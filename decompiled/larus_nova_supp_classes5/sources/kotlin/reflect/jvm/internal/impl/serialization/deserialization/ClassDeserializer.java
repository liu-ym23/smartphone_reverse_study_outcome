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
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ClassDeserializer {
    private static final Set<ClassId> BLACK_LIST = null;
    public static final Companion Companion = null;
    private final Function1<ClassKey, ClassDescriptor> classes;
    private final DeserializationComponents components;

    public static final class ClassKey {
        private final ClassData classData;
        private final ClassId classId;

        public int hashCode() {
            return this.classId.hashCode();
        }

        public final ClassData getClassData() {
            return this.classData;
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof ClassKey) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(this.classId, ((ClassKey) r2).classId) == false) goto L7;
            return true;
        }

        public ClassKey(ClassId r2, ClassData r3) {
            Intrinsics.checkNotNullParameter(r2, "classId");
            this.classId = r2;
            this.classData = r3;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Set<ClassId> getBLACK_LIST() {
            return ClassDeserializer.access$getBLACK_LIST$cp();
        }
    }

    public static /* synthetic */ ClassDescriptor accessor$ClassDeserializer$lambda0(ClassDeserializer r0, ClassKey r1) {
        return classes$lambda$0(r0, r1);
    }

    static {
        Companion = new Companion(null);
        BLACK_LIST = SetsKt.setOf(ClassId.Companion.topLevel(StandardNames.FqNames.cloneable.toSafe()));
    }

    public static final /* synthetic */ Set access$getBLACK_LIST$cp() {
        return BLACK_LIST;
    }

    public ClassDeserializer(DeserializationComponents r2) {
        Intrinsics.checkNotNullParameter(r2, "components");
        this.components = r2;
        this.classes = r2.getStorageManager().createMemoizedFunctionWithNullableValues(new ClassDeserializer$$Lambda$0(this));
    }

    private final ClassDescriptor createClass(ClassKey r13) {
        ClassId r0 = r13.getClassId();
        Iterator<ClassDescriptorFactory> r1 = this.components.getFictitiousClassDescriptorFactories().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        ClassDescriptor r2 = r1.next().createClass(r0);
        if (r2 == null) goto L4;
        return r2;
    L9:
        if (BLACK_LIST.contains(r0) == false) goto L11;
        return null;
    L11:
        ClassData r14 = r13.getClassData();
        if (r14 != null) goto L16;
        r14 = this.components.getClassDataFinder().findClassData(r0);
        if (r14 != null) goto L16;
        return null;
    L16:
        NameResolver r3 = r14.component1();
        ProtoBuf$Class r10 = r14.component2();
        BinaryVersion r11 = r14.component3();
        SourceElement r15 = r14.component4();
        ClassId r4 = r0.getOuterClassId();
        if (r4 == null) goto L28;
        ClassDescriptor r5 = deserializeClass$default(this, r4, null, 2, null);
        if ((r5 instanceof DeserializedClassDescriptor) == false) goto L21;
        DeserializedClassDescriptor r6 = (DeserializedClassDescriptor) r5;
    L22:
        if (r6 != null) goto L25;
        return null;
    L25:
        if (r6.hasNestedClass$deserialization(r0.getShortClassName()) == true) goto L27;
        return null;
    L27:
        DeserializationContext r7 = r6.getC();
    L46:
        return new DeserializedClassDescriptor(r7, r10, r3, r11, r15);
    L21:
        r6 = null;
        goto L22
    L28:
        Iterator<T> r8 = PackageFragmentProviderKt.packageFragments(this.components.getPackageFragmentProvider(), r0.getPackageFqName()).iterator();
    L30:
        if (r8.hasNext() == false) goto L40;
        Object r9 = r8.next();
        PackageFragmentDescriptor r12 = (PackageFragmentDescriptor) r9;
        if ((r12 instanceof DeserializedPackageFragment) == true) goto L34;
    L37:
        boolean r16 = true;
    L38:
        if (r16 == false) goto L30;
    L41:
        PackageFragmentDescriptor r17 = (PackageFragmentDescriptor) r9;
        if (r17 != null) goto L44;
        return null;
    L44:
        r7 = this.components.createContext(r17, r3, new TypeTable(r10.getTypeTable()), VersionRequirementTable.Companion.create(r10.getVersionRequirementTable()), r11, null);
        goto L46
    L34:
        if (((DeserializedPackageFragment) r12).hasTopLevelClass(r0.getShortClassName()) == true) goto L37;
        r16 = false;
        goto L38
    L40:
        r9 = null;
        goto L41
    }

    private static final ClassDescriptor classes$lambda$0(ClassDeserializer r1, ClassKey r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "key");
        return r1.createClass(r2);
    }

    public final ClassDescriptor deserializeClass(ClassId r3, ClassData r4) {
        Intrinsics.checkNotNullParameter(r3, "classId");
        return (ClassDescriptor) this.classes.invoke(new ClassKey(r3, r4));
    }

    public static /* synthetic */ ClassDescriptor deserializeClass$default(ClassDeserializer r0, ClassId r1, ClassData r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.deserializeClass(r1, r2);
    }
}
