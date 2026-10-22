package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ReflectKotlinClass implements KotlinJvmBinaryClass {
    public static final Factory Factory = null;
    private final KotlinClassHeader classHeader;
    private final Class<?> klass;

    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker r1) {
            this();
        }

        public final ReflectKotlinClass create(Class<?> r4) {
            Intrinsics.checkNotNullParameter(r4, "klass");
            ReadKotlinClassHeaderAnnotationVisitor r0 = new ReadKotlinClassHeaderAnnotationVisitor();
            ReflectClassStructure.INSTANCE.loadClassAnnotations(r4, r0);
            KotlinClassHeader r1 = r0.createHeaderWithDefaultMetadataVersion();
            DefaultConstructorMarker r2 = null;
            if (r1 != null) goto L6;
            return null;
        L6:
            return new ReflectKotlinClass(r4, r1, r2);
        }
    }

    static {
        Factory = new Factory(null);
    }

    public /* synthetic */ ReflectKotlinClass(Class r1, KotlinClassHeader r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public ClassId getClassId() {
        return ReflectClassUtilKt.getClassId(this.klass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public String getLocation() {
        return StringsKt.replace$default(this.klass.getName(), '.', '/', false, 4, null) + ".class";
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    public String toString() {
        return ReflectKotlinClass.class.getName() + ": " + this.klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public KotlinClassHeader getClassHeader() {
        return this.classHeader;
    }

    public final Class<?> getKlass() {
        return this.klass;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof ReflectKotlinClass) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.klass, ((ReflectKotlinClass) r2).klass) == false) goto L7;
        return true;
    }

    private ReflectKotlinClass(Class<?> r1, KotlinClassHeader r2) {
        this.klass = r1;
        this.classHeader = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void loadClassAnnotations(KotlinJvmBinaryClass.AnnotationVisitor r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "visitor");
        ReflectClassStructure.INSTANCE.loadClassAnnotations(this.klass, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void visitMembers(KotlinJvmBinaryClass.MemberVisitor r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "visitor");
        ReflectClassStructure.INSTANCE.visitMembers(this.klass, r2);
    }
}
