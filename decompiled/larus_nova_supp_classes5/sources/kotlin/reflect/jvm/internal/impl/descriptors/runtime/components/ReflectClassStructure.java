package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
final class ReflectClassStructure {
    public static final ReflectClassStructure INSTANCE = null;

    static {
        INSTANCE = new ReflectClassStructure();
    }

    private ReflectClassStructure() {
    }

    private final ClassLiteralValue classLiteralValue(Class<?> r4) {
        int r0 = 0;
    L4:
        if (r4.isArray() == false) goto L7;
        r0 = r0 + 1;
        r4 = r4.getComponentType();
        goto L4
    L7:
        if (r4.isPrimitive() == true) goto L9;
        ClassId r5 = ReflectClassUtilKt.getClassId(r4);
        ClassId r1 = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(r5.asSingleFqName());
        if (r1 == null) goto L23;
        r5 = r1;
    L23:
        return new ClassLiteralValue(r5, r0);
    L9:
        if (Intrinsics.areEqual(r4, Void.TYPE) == true) goto L11;
        PrimitiveType r6 = JvmPrimitiveType.get(r4.getName()).getPrimitiveType();
        if (r0 <= 0) goto L17;
        return new ClassLiteralValue(ClassId.Companion.topLevel(r6.getArrayTypeFqName()), r0 - 1);
    L17:
        return new ClassLiteralValue(ClassId.Companion.topLevel(r6.getTypeFqName()), r0);
    L11:
        return new ClassLiteralValue(ClassId.Companion.topLevel(StandardNames.FqNames.unit.toSafe()), r0);
    }

    private final void loadConstructorAnnotations(Class<?> r12, KotlinJvmBinaryClass.MemberVisitor r13) {
        Iterator r14 = ArrayIteratorKt.iterator(r12.getDeclaredConstructors());
    L4:
        if (r14.hasNext() == false) goto L28;
        Constructor r0 = (Constructor) r14.next();
        Name r1 = SpecialNames.INIT;
        SignatureSerializer r2 = SignatureSerializer.INSTANCE;
        Intrinsics.checkNotNull(r0);
        KotlinJvmBinaryClass.MethodAnnotationVisitor r3 = r13.visitMethod(r1, r2.constructorDesc(r0));
        if (r3 == null) goto L4;
        Iterator r4 = ArrayIteratorKt.iterator(r0.getDeclaredAnnotations());
    L10:
        if (r4.hasNext() == false) goto L12;
        Annotation r5 = (Annotation) r4.next();
        Intrinsics.checkNotNull(r5);
        processAnnotation(r3, r5);
        goto L10
    L12:
        Annotation[][] r6 = r0.getParameterAnnotations();
        Intrinsics.checkNotNull(r6);
        int r7 = 0;
        if (r6.length != 0) goto L15;
        boolean r8 = true;
    L17:
        if ((!r8) == false) goto L27;
        int r9 = r0.getParameterTypes().length - r6.length;
        int r10 = r6.length;
    L19:
        if (r7 >= r10) goto L27;
        Iterator r11 = ArrayIteratorKt.iterator(r6[r7]);
    L22:
        if (r11.hasNext() == false) goto L26;
        Annotation r15 = (Annotation) r11.next();
        Class<?> r16 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r15));
        ClassId r17 = ReflectClassUtilKt.getClassId(r16);
        Intrinsics.checkNotNull(r15);
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r18 = r3.visitParameterAnnotation(r7 + r9, r17, new ReflectAnnotationSource(r15));
        if (r18 == null) goto L22;
        INSTANCE.processAnnotationArguments(r18, r15, r16);
        goto L22
    L26:
        r7 = r7 + 1;
    L27:
        r3.visitEnd();
        goto L4
    L15:
        r8 = false;
        goto L17
    }

    private final void loadFieldAnnotations(Class<?> r5, KotlinJvmBinaryClass.MemberVisitor r6) {
        Iterator r7 = ArrayIteratorKt.iterator(r5.getDeclaredFields());
    L4:
        if (r7.hasNext() == false) goto L13;
        Field r0 = (Field) r7.next();
        Name r1 = Name.identifier(r0.getName());
        SignatureSerializer r2 = SignatureSerializer.INSTANCE;
        Intrinsics.checkNotNull(r0);
        KotlinJvmBinaryClass.AnnotationVisitor r3 = r6.visitField(r1, r2.fieldDesc(r0), null);
        if (r3 == null) goto L4;
        Iterator r4 = ArrayIteratorKt.iterator(r0.getDeclaredAnnotations());
    L10:
        if (r4.hasNext() == false) goto L12;
        Annotation r8 = (Annotation) r4.next();
        Intrinsics.checkNotNull(r8);
        processAnnotation(r3, r8);
        goto L10
    L12:
        r3.visitEnd();
        goto L4
    }

    private final void loadMethodAnnotations(Class<?> r10, KotlinJvmBinaryClass.MemberVisitor r11) {
        Iterator r12 = ArrayIteratorKt.iterator(r10.getDeclaredMethods());
    L4:
        if (r12.hasNext() == false) goto L22;
        Method r0 = (Method) r12.next();
        Name r1 = Name.identifier(r0.getName());
        SignatureSerializer r2 = SignatureSerializer.INSTANCE;
        Intrinsics.checkNotNull(r0);
        KotlinJvmBinaryClass.MethodAnnotationVisitor r3 = r11.visitMethod(r1, r2.methodDesc(r0));
        if (r3 == null) goto L4;
        Iterator r4 = ArrayIteratorKt.iterator(r0.getDeclaredAnnotations());
    L10:
        if (r4.hasNext() == false) goto L12;
        Annotation r5 = (Annotation) r4.next();
        Intrinsics.checkNotNull(r5);
        processAnnotation(r3, r5);
        goto L10
    L12:
        Annotation[][] r6 = r0.getParameterAnnotations();
        int r7 = r6.length;
        int r8 = 0;
    L13:
        if (r8 >= r7) goto L21;
        Iterator r9 = ArrayIteratorKt.iterator(r6[r8]);
    L16:
        if (r9.hasNext() == false) goto L20;
        Annotation r13 = (Annotation) r9.next();
        Class<?> r14 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r13));
        ClassId r15 = ReflectClassUtilKt.getClassId(r14);
        Intrinsics.checkNotNull(r13);
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r16 = r3.visitParameterAnnotation(r8, r15, new ReflectAnnotationSource(r13));
        if (r16 == null) goto L16;
        INSTANCE.processAnnotationArguments(r16, r13, r14);
        goto L16
    L20:
        r8 = r8 + 1;
        goto L13
    L21:
        r3.visitEnd();
        goto L4
    }

    private final void processAnnotation(KotlinJvmBinaryClass.AnnotationVisitor r4, Annotation r5) {
        Class<?> r0 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r5));
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r6 = r4.visitAnnotation(ReflectClassUtilKt.getClassId(r0), new ReflectAnnotationSource(r5));
        if (r6 == null) goto L6;
        INSTANCE.processAnnotationArguments(r6, r5, r0);
        return;
    }

    public final void loadClassAnnotations(Class<?> r2, KotlinJvmBinaryClass.AnnotationVisitor r3) {
        Intrinsics.checkNotNullParameter(r2, "klass");
        Intrinsics.checkNotNullParameter(r3, "visitor");
        Iterator r4 = ArrayIteratorKt.iterator(r2.getDeclaredAnnotations());
    L4:
        if (r4.hasNext() == false) goto L6;
        Annotation r0 = (Annotation) r4.next();
        Intrinsics.checkNotNull(r0);
        processAnnotation(r3, r0);
        goto L4
    L6:
        r3.visitEnd();
    }

    public final void visitMembers(Class<?> r2, KotlinJvmBinaryClass.MemberVisitor r3) {
        Intrinsics.checkNotNullParameter(r2, "klass");
        Intrinsics.checkNotNullParameter(r3, "memberVisitor");
        loadMethodAnnotations(r2, r3);
        loadConstructorAnnotations(r2, r3);
        loadFieldAnnotations(r2, r3);
    }

    private final void processAnnotationArgumentValue(KotlinJvmBinaryClass.AnnotationArgumentVisitor r7, Name r8, Object r9) {
        Class<?> r0 = r9.getClass();
        if (Intrinsics.areEqual(r0, Class.class) == false) goto L6;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type java.lang.Class<*>");
        r7.visitClassLiteral(r8, classLiteralValue((Class) r9));
        return;
    L6:
        if (ReflectKotlinClassKt.access$getTYPES_ELIGIBLE_FOR_SIMPLE_VISIT$p().contains(r0) == false) goto L9;
        r7.visit(r8, r9);
        return;
    L9:
        if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(r0) == false) goto L16;
        if (r0.isEnum() == true) goto L14;
        r0 = r0.getEnclosingClass();
    L14:
        Intrinsics.checkNotNull(r0);
        ClassId r1 = ReflectClassUtilKt.getClassId(r0);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Enum<*>");
        r7.visitEnum(r8, r1, Name.identifier(((Enum) r9).name()));
        return;
    L16:
        if (Annotation.class.isAssignableFrom(r0) == false) goto L22;
        Class<?> r2 = (Class) ArraysKt.single(r0.getInterfaces());
        Intrinsics.checkNotNull(r2);
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r10 = r7.visitAnnotation(r8, ReflectClassUtilKt.getClassId(r2));
        if (r10 != null) goto L20;
        return;
    L20:
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Annotation");
        processAnnotationArguments(r10, (Annotation) r9, r2);
        return;
    L22:
        if (r0.isArray() == false) goto L51;
        KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor r11 = r7.visitArray(r8);
        if (r11 != null) goto L26;
        return;
    L26:
        Class<?> r12 = r0.getComponentType();
        int r3 = 0;
        if (r12.isEnum() == false) goto L32;
        Intrinsics.checkNotNull(r12);
        ClassId r13 = ReflectClassUtilKt.getClassId(r12);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r14 = (Object[]) r9;
        int r4 = r14.length;
    L29:
        if (r3 >= r4) goto L48;
        Object r5 = r14[r3];
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Enum<*>");
        r11.visitEnum(r13, Name.identifier(((Enum) r5).name()));
        r3 = r3 + 1;
    L48:
        r11.visitEnd();
        return;
    L32:
        if (Intrinsics.areEqual(r12, Class.class) == false) goto L37;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r15 = (Object[]) r9;
        int r16 = r15.length;
    L34:
        if (r3 >= r16) goto L48;
        Object r6 = r15[r3];
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type java.lang.Class<*>");
        r11.visitClassLiteral(classLiteralValue((Class) r6));
        r3 = r3 + 1;
        goto L34
    L37:
        if (Annotation.class.isAssignableFrom(r12) == false) goto L45;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r17 = (Object[]) r9;
        int r18 = r17.length;
    L39:
        if (r3 >= r18) goto L48;
        Object r19 = r17[r3];
        Intrinsics.checkNotNull(r12);
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r20 = r11.visitAnnotation(ReflectClassUtilKt.getClassId(r12));
        if (r20 == null) goto L44;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.Annotation");
        processAnnotationArguments(r20, (Annotation) r19, r12);
    L44:
        r3 = r3 + 1;
        goto L39
    L45:
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r21 = (Object[]) r9;
        int r22 = r21.length;
    L46:
        if (r3 >= r22) goto L48;
        r11.visit(r21[r3]);
        r3 = r3 + 1;
        goto L46
    L51:
        throw new UnsupportedOperationException("Unsupported annotation argument value (" + r0 + "): " + r9);
    }

    private final void processAnnotationArguments(KotlinJvmBinaryClass.AnnotationArgumentVisitor r3, Annotation r4, Class<?> r5) {
        Iterator r6 = ArrayIteratorKt.iterator(r5.getDeclaredMethods());
    L4:
        if (r6.hasNext() == false) goto L9;
        Method r0 = (Method) r6.next();
        Object r1 = r0.invoke(r4, new Object[0]);     // Catch: IllegalAccessException -> L8
        Intrinsics.checkNotNull(r1);     // Catch: IllegalAccessException -> L8
        processAnnotationArgumentValue(r3, Name.identifier(r0.getName()), r1);
        goto L4
    L9:
        r3.visitEnd();
    }
}
