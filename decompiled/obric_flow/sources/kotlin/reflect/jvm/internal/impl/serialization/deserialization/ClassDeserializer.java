package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nClassDeserializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/ClassDeserializer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,91:1\n1#2:92\n288#3,2:93\n*S KotlinDebug\n*F\n+ 1 ClassDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/ClassDeserializer\n*L\n57#1:93,2\n*E\n"})
public final class ClassDeserializer {
    private static final Set<ClassId> BLACK_LIST = null;
    public static final Companion Companion = null;
    private final Function1<ClassKey, ClassDescriptor> classes;
    private final DeserializationComponents components;

    public static final class ClassKey {
        private final ClassData classData;
        private final ClassId classId;

        public ClassKey(ClassId r5, ClassData r10) {
            Intrinsics.checkNotNullParameter(r5, "classId");
            this.classId = r5;
            this.classData = r10;
        }

        public boolean equals(Object r5) {
            if ((r5 instanceof ClassKey) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(this.classId, ((ClassKey) r5).classId) == false) goto L7;
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
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final Set<ClassId> getBLACK_LIST() {
            return ClassDeserializer.access$getBLACK_LIST$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        BLACK_LIST = SetsKt.setOf(ClassId.topLevel(StandardNames.FqNames.cloneable.toSafe()));
    }

    public ClassDeserializer(DeserializationComponents r5) {
        Intrinsics.checkNotNullParameter(r5, "components");
        this.components = r5;
        this.classes = r5.getStorageManager().createMemoizedFunctionWithNullableValues(new ClassDeserializer$classes$1(this));
    }

    public static final /* synthetic */ ClassDescriptor access$createClass(ClassDeserializer r5, ClassKey r10) {
        return r5.createClass(r10);
    }

    public static final /* synthetic */ Set access$getBLACK_LIST$cp() {
        return BLACK_LIST;
    }

    private final ClassDescriptor createClass(ClassKey r13) {
        ClassId r5 = r13.getClassId();
        Iterator<ClassDescriptorFactory> r10 = this.components.getFictitiousClassDescriptorFactories().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        ClassDescriptor r11 = r10.next().createClass(r5);
        if (r11 == null) goto L4;
        return r11;
    L9:
        if (BLACK_LIST.contains(r5) == false) goto L11;
        return null;
    L11:
        ClassData r14 = r13.getClassData();
        if (r14 != null) goto L16;
        r14 = this.components.getClassDataFinder().findClassData(r5);
        if (r14 != null) goto L16;
        return null;
    L16:
        NameResolver r12 = r14.component1();
        ProtoBuf.Class r15 = r14.component2();
        BinaryVersion r16 = r14.component3();
        SourceElement r17 = r14.component4();
        ClassId r18 = r5.getOuterClassId();
        if (r18 == null) goto L29;
        ClassDescriptor r19 = deserializeClass$default(this, r18, null, 2, null);
        if ((r19 instanceof DeserializedClassDescriptor) == false) goto L21;
        DeserializedClassDescriptor r110 = (DeserializedClassDescriptor) r19;
    L22:
        if (r110 != null) goto L25;
        return null;
    L25:
        if (r110.hasNestedClass$deserialization(r5.getShortClassName()) == true) goto L27;
        return null;
    L27:
        DeserializationContext r111 = r110.getC();
    L43:
        return new DeserializedClassDescriptor(r111, r15, r12, r16, r17);
    L21:
        r110 = null;
        goto L22
    L29:
        Iterator<T> r20 = PackageFragmentProviderKt.packageFragments(this.components.getPackageFragmentProvider(), r5.getPackageFqName()).iterator();
    L31:
        if (r20.hasNext() == false) goto L37;
        Object r21 = r20.next();
        PackageFragmentDescriptor r22 = (PackageFragmentDescriptor) r21;
        if ((r22 instanceof DeserializedPackageFragment) == false) goto L38;
        if (((DeserializedPackageFragment) r22).hasTopLevelClass(r5.getShortClassName()) == false) goto L31;
    L38:
        PackageFragmentDescriptor r23 = (PackageFragmentDescriptor) r21;
        if (r23 != null) goto L41;
        return null;
    L41:
        r111 = this.components.createContext(r23, r12, new TypeTable(r15.getTypeTable()), VersionRequirementTable.Companion.create(r15.getVersionRequirementTable()), r16, null);
        goto L43
    L37:
        r21 = null;
        goto L38
    }

    public static /* synthetic */ ClassDescriptor deserializeClass$default(ClassDeserializer r5, ClassId r10, ClassData r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = null;
    L6:
        return r5.deserializeClass(r10, r11);
    }

    public final ClassDescriptor deserializeClass(ClassId r5, ClassData r10) {
        Intrinsics.checkNotNullParameter(r5, "classId");
        return this.classes.invoke(new ClassKey(r5, r10));
    }
}
