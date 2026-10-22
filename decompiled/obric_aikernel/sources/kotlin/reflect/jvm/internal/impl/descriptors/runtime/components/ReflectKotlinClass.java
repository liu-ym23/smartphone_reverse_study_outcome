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
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker r10) {
            this();
        }

        public final ReflectKotlinClass create(Class<?> r10) {
            Intrinsics.checkNotNullParameter(r10, "klass");
            ReadKotlinClassHeaderAnnotationVisitor r11 = new ReadKotlinClassHeaderAnnotationVisitor();
            ReflectClassStructure.INSTANCE.loadClassAnnotations(r10, r11);
            KotlinClassHeader r12 = r11.createHeader();
            DefaultConstructorMarker r13 = null;
            if (r12 != null) goto L6;
            return null;
        L6:
            return new ReflectKotlinClass(r10, r12, r13);
        }
    }

    static {
        Factory = new Factory(null);
    }

    private ReflectKotlinClass(Class<?> r10, KotlinClassHeader r11) {
        this.klass = r10;
        this.classHeader = r11;
    }

    public /* synthetic */ ReflectKotlinClass(Class r10, KotlinClassHeader r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof ReflectKotlinClass) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.klass, ((ReflectKotlinClass) r10).klass) == false) goto L7;
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
        StringBuilder r10 = new StringBuilder();
        String r11 = this.klass.getName();
        Intrinsics.checkNotNullExpressionValue(r11, "klass.name");
        r10.append(StringsKt.replace$default(r11, '.', '/', false, 4, null));
        r10.append(".class");
        return r10.toString();
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void loadClassAnnotations(KotlinJvmBinaryClass.AnnotationVisitor r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "visitor");
        ReflectClassStructure.INSTANCE.loadClassAnnotations(this.klass, r10);
    }

    public String toString() {
        return ReflectKotlinClass.class.getName() + ": " + this.klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void visitMembers(KotlinJvmBinaryClass.MemberVisitor r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "visitor");
        ReflectClassStructure.INSTANCE.visitMembers(this.klass, r10);
    }
}
