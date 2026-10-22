package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectKotlinClass implements KotlinJvmBinaryClass {
    public static final Factory Factory = null;
    private final KotlinClassHeader classHeader;
    private final Class<?> klass;

    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker r5) {
            this();
        }

        public final ReflectKotlinClass create(Class<?> r5) {
            Intrinsics.checkNotNullParameter(r5, "klass");
            ReadKotlinClassHeaderAnnotationVisitor r10 = new ReadKotlinClassHeaderAnnotationVisitor();
            ReflectClassStructure.INSTANCE.loadClassAnnotations(r5, r10);
            KotlinClassHeader r11 = r10.createHeaderWithDefaultMetadataVersion();
            DefaultConstructorMarker r12 = null;
            if (r11 != null) goto L6;
            return null;
        L6:
            return new ReflectKotlinClass(r5, r11, r12);
        }

        private Factory() {
        }
    }

    static {
        Factory = new Factory(null);
    }

    public /* synthetic */ ReflectKotlinClass(Class r5, KotlinClassHeader r10, DefaultConstructorMarker r11) {
        this(r5, r10);
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof ReflectKotlinClass) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.klass, ((ReflectKotlinClass) r5).klass) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public KotlinClassHeader getClassHeader() {
        return this.classHeader;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public ClassId getClassId() {
        return ReflectClassUtilKt.getClassId(this.klass);
    }

    public final Class<?> getKlass() {
        return this.klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public String getLocation() {
        return StringsKt.E(this.klass.getName(), '.', '/') + ".class";
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void loadClassAnnotations(KotlinJvmBinaryClass.AnnotationVisitor r5, byte[] r10) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        ReflectClassStructure.INSTANCE.loadClassAnnotations(this.klass, r5);
    }

    public String toString() {
        return ReflectKotlinClass.class.getName() + ": " + this.klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void visitMembers(KotlinJvmBinaryClass.MemberVisitor r5, byte[] r10) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        ReflectClassStructure.INSTANCE.visitMembers(this.klass, r5);
    }

    private ReflectKotlinClass(Class<?> r5, KotlinClassHeader r10) {
        this.klass = r5;
        this.classHeader = r10;
    }
}
