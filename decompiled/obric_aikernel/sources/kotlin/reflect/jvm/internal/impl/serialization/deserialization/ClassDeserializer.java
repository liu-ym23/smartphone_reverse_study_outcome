package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public final class ClassDeserializer {
    private static final Set<ClassId> BLACK_LIST = null;
    public static final Companion Companion = null;
    private final Function1<ClassKey, ClassDescriptor> classes;
    private final DeserializationComponents components;

    private static final class ClassKey {
        private final ClassData classData;
        private final ClassId classId;

        public ClassKey(ClassId r10, ClassData r11) {
            Intrinsics.checkNotNullParameter(r10, "classId");
            this.classId = r10;
            this.classData = r11;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof ClassKey) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(this.classId, ((ClassKey) r10).classId) == false) goto L7;
            return true;
        }

        public final ClassData getClassData() {
            return this.classData;
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public int hashCode() {
            return this.classId.hashCode();
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final Set<ClassId> getBLACK_LIST() {
            return ClassDeserializer.access$getBLACK_LIST$cp();
        }
    }

    static {
        Companion = new Companion(null);
        BLACK_LIST = SetsKt.setOf(ClassId.topLevel(StandardNames.FqNames.cloneable.toSafe()));
    }

    public ClassDeserializer(DeserializationComponents r10) {
        Intrinsics.checkNotNullParameter(r10, "components");
        this.components = r10;
        this.classes = r10.getStorageManager().createMemoizedFunctionWithNullableValues(new ClassDeserializer$classes$1(this));
    }

    public static final /* synthetic */ ClassDescriptor access$createClass(ClassDeserializer r10, ClassKey r11) {
        return r10.createClass(r11);
    }

    public static final /* synthetic */ Set access$getBLACK_LIST$cp() {
        return BLACK_LIST;
    }

    private final ClassDescriptor createClass(ClassKey r13) {
        ClassId r10 = r13.getClassId();
        Iterator<ClassDescriptorFactory> r11 = this.components.getFictitiousClassDescriptorFactories().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        ClassDescriptor r12 = r11.next().createClass(r10);
        if (r12 == null) goto L4;
        return r12;
    L9:
        if (BLACK_LIST.contains(r10) == false) goto L11;
        return null;
    L11:
        ClassData r14 = r13.getClassData();
        if (r14 != null) goto L16;
        r14 = this.components.getClassDataFinder().findClassData(r10);
        if (r14 != null) goto L16;
        return null;
    L16:
        NameResolver r15 = r14.component1();
        ProtoBuf.Class r16 = r14.component2();
        BinaryVersion r17 = r14.component3();
        SourceElement r18 = r14.component4();
        ClassId r19 = r10.getOuterClassId();
        if (r19 == null) goto L28;
        ClassDescriptor r110 = deserializeClass$default(this, r19, null, 2, null);
        if ((r110 instanceof DeserializedClassDescriptor) == false) goto L21;
        DeserializedClassDescriptor r111 = (DeserializedClassDescriptor) r110;
    L22:
        if (r111 != null) goto L24;
        return null;
    L24:
        Name r20 = r10.getShortClassName();
        Intrinsics.checkNotNullExpressionValue(r20, "classId.shortClassName");
        if (r111.hasNestedClass$deserialization(r20) == true) goto L27;
        return null;
    L27:
        DeserializationContext r112 = r111.getC();
    L46:
        return new DeserializedClassDescriptor(r112, r16, r15, r17, r18);
    L21:
        r111 = null;
        goto L22
    L28:
        PackageFragmentProvider r21 = this.components.getPackageFragmentProvider();
        FqName r22 = r10.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r22, "classId.packageFqName");
        Iterator<T> r23 = PackageFragmentProviderKt.packageFragments(r21, r22).iterator();
    L30:
        if (r23.hasNext() == false) goto L40;
        Object r24 = r23.next();
        PackageFragmentDescriptor r25 = (PackageFragmentDescriptor) r24;
        if ((r25 instanceof DeserializedPackageFragment) == false) goto L37;
        Name r26 = r10.getShortClassName();
        Intrinsics.checkNotNullExpressionValue(r26, "classId.shortClassName");
        if (((DeserializedPackageFragment) r25).hasTopLevelClass(r26) == true) goto L37;
        boolean r27 = false;
    L38:
        if (r27 == false) goto L30;
    L41:
        PackageFragmentDescriptor r28 = (PackageFragmentDescriptor) r24;
        if (r28 != null) goto L44;
        return null;
    L44:
        DeserializationComponents r29 = this.components;
        ProtoBuf.TypeTable r113 = r16.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(r113, "classProto.typeTable");
        TypeTable r30 = new TypeTable(r113);
        VersionRequirementTable.Companion r114 = VersionRequirementTable.Companion;
        ProtoBuf.VersionRequirementTable r31 = r16.getVersionRequirementTable();
        Intrinsics.checkNotNullExpressionValue(r31, "classProto.versionRequirementTable");
        r112 = r29.createContext(r28, r15, r30, r114.create(r31), r17, null);
    L37:
        r27 = true;
        goto L38
    L40:
        r24 = null;
        goto L41
    }

    public static /* synthetic */ ClassDescriptor deserializeClass$default(ClassDeserializer r10, ClassId r11, ClassData r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = null;
    L6:
        return r10.deserializeClass(r11, r12);
    }

    public final ClassDescriptor deserializeClass(ClassId r10, ClassData r11) {
        Intrinsics.checkNotNullParameter(r10, "classId");
        return this.classes.invoke(new ClassKey(r10, r11));
    }
}
