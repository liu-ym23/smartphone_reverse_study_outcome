package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
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

/* JADX INFO: loaded from: classes3.dex */
final class ReflectClassStructure {
    public static final ReflectClassStructure INSTANCE = null;

    static {
        INSTANCE = new ReflectClassStructure();
    }

    private ReflectClassStructure() {
    }

    private final ClassLiteralValue classLiteralValue(Class<?> r5) {
        int r10 = 0;
    L4:
        if (r5.isArray() == false) goto L7;
        r10 = r10 + 1;
        r5 = r5.getComponentType();
        goto L4
    L7:
        if (r5.isPrimitive() == true) goto L9;
        ClassId r11 = ReflectClassUtilKt.getClassId(r5);
        ClassId r12 = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(r11.asSingleFqName());
        if (r12 == null) goto L23;
        r11 = r12;
    L23:
        return new ClassLiteralValue(r11, r10);
    L9:
        if (Intrinsics.areEqual(r5, Void.TYPE) == true) goto L11;
        PrimitiveType r13 = JvmPrimitiveType.get(r5.getName()).getPrimitiveType();
        if (r10 <= 0) goto L17;
        return new ClassLiteralValue(ClassId.topLevel(r13.getArrayTypeFqName()), r10 - 1);
    L17:
        return new ClassLiteralValue(ClassId.topLevel(r13.getTypeFqName()), r10);
    L11:
        return new ClassLiteralValue(ClassId.topLevel(StandardNames.FqNames.unit.toSafe()), r10);
    }

    private final void loadConstructorAnnotations(Class<?> r19, KotlinJvmBinaryClass.MemberVisitor r20) {
        Constructor<?>[] r5 = r19.getDeclaredConstructors();
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L26;
        Constructor<?> r12 = r5[r11];
        KotlinJvmBinaryClass.MethodAnnotationVisitor r13 = r20.visitMethod(SpecialNames.INIT, SignatureSerializer.INSTANCE.constructorDesc(r12));
        if (r13 != null) goto L7;
        Constructor<?>[] r16 = r5;
        int r17 = r10;
    L25:
        r11 = r11 + 1;
        r5 = r16;
        r10 = r17;
        goto L3
    L7:
        Annotation[] r14 = r12.getDeclaredAnnotations();
        int r15 = r14.length;
        int r18 = 0;
    L8:
        if (r18 >= r15) goto L10;
        processAnnotation(r13, r14[r18]);
        r18 = r18 + 1;
        goto L8
    L10:
        Annotation[][] r21 = r12.getParameterAnnotations();
        if (r21.length != 0) goto L13;
        boolean r22 = true;
    L14:
        if (r22 == true) goto L24;
        int r23 = r12.getParameterTypes().length - r21.length;
        int r24 = r21.length;
        int r25 = 0;
    L16:
        if (r25 >= r24) goto L24;
        Annotation[] r110 = r21[r25];
        int r111 = r110.length;
        int r112 = 0;
    L18:
        if (r112 >= r111) goto L23;
        Annotation r113 = r110[r112];
        Class<?> r114 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r113));
        Constructor<?>[] r115 = r5;
        int r116 = r10;
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r26 = r13.visitParameterAnnotation(r25 + r23, ReflectClassUtilKt.getClassId(r114), new ReflectAnnotationSource(r113));
        if (r26 == null) goto L22;
        INSTANCE.processAnnotationArguments(r26, r113, r114);
    L22:
        r112 = r112 + 1;
        r5 = r115;
        r10 = r116;
        goto L18
    L23:
        r25 = r25 + 1;
    L24:
        r16 = r5;
        r17 = r10;
        r13.visitEnd();
        goto L25
    L13:
        r22 = false;
        goto L14
    }

    private final void loadFieldAnnotations(Class<?> r10, KotlinJvmBinaryClass.MemberVisitor r11) {
        Field[] r12 = r10.getDeclaredFields();
        int r5 = r12.length;
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L12;
        Field r14 = r12[r13];
        KotlinJvmBinaryClass.AnnotationVisitor r15 = r11.visitField(Name.identifier(r14.getName()), SignatureSerializer.INSTANCE.fieldDesc(r14), null);
        if (r15 == null) goto L11;
        Annotation[] r16 = r14.getDeclaredAnnotations();
        int r17 = r16.length;
        int r18 = 0;
    L8:
        if (r18 >= r17) goto L10;
        processAnnotation(r15, r16[r18]);
        r18 = r18 + 1;
        goto L8
    L10:
        r15.visitEnd();
    L11:
        r13 = r13 + 1;
        goto L3
    }

    private final void loadMethodAnnotations(Class<?> r17, KotlinJvmBinaryClass.MemberVisitor r18) {
        Method[] r5 = r17.getDeclaredMethods();
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L21;
        Method r12 = r5[r11];
        KotlinJvmBinaryClass.MethodAnnotationVisitor r13 = r18.visitMethod(Name.identifier(r12.getName()), SignatureSerializer.INSTANCE.methodDesc(r12));
        if (r13 == null) goto L20;
        Annotation[] r14 = r12.getDeclaredAnnotations();
        int r15 = r14.length;
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L10;
        processAnnotation(r13, r14[r16]);
        r16 = r16 + 1;
        goto L8
    L10:
        Annotation[][] r19 = r12.getParameterAnnotations();
        int r20 = r19.length;
        int r21 = 0;
    L11:
        if (r21 >= r20) goto L19;
        Annotation[] r22 = r19[r21];
        int r110 = r22.length;
        int r111 = 0;
    L13:
        if (r111 >= r110) goto L18;
        Annotation r112 = r22[r111];
        Class<?> r113 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r112));
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r23 = r13.visitParameterAnnotation(r21, ReflectClassUtilKt.getClassId(r113), new ReflectAnnotationSource(r112));
        if (r23 == null) goto L17;
        INSTANCE.processAnnotationArguments(r23, r112, r113);
    L17:
        r111 = r111 + 1;
        goto L13
    L18:
        r21 = r21 + 1;
        goto L11
    L19:
        r13.visitEnd();
    L20:
        r11 = r11 + 1;
        goto L3
    }

    private final void processAnnotation(KotlinJvmBinaryClass.AnnotationVisitor r5, Annotation r10) {
        Class<?> r11 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r10));
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r12 = r5.visitAnnotation(ReflectClassUtilKt.getClassId(r11), new ReflectAnnotationSource(r10));
        if (r12 == null) goto L6;
        INSTANCE.processAnnotationArguments(r12, r10, r11);
        return;
    }

    private final void processAnnotationArgumentValue(KotlinJvmBinaryClass.AnnotationArgumentVisitor r10, Name r11, Object r12) {
        Class<?> r5 = r12.getClass();
        if (Intrinsics.areEqual(r5, Class.class) == false) goto L6;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.lang.Class<*>");
        r10.visitClassLiteral(r11, classLiteralValue((Class) r12));
        return;
    L6:
        if (ReflectKotlinClassKt.access$getTYPES_ELIGIBLE_FOR_SIMPLE_VISIT$p().contains(r5) == false) goto L9;
        r10.visit(r11, r12);
        return;
    L9:
        if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(r5) == false) goto L16;
        if (r5.isEnum() == true) goto L14;
        r5 = r5.getEnclosingClass();
    L14:
        ClassId r13 = ReflectClassUtilKt.getClassId(r5);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Enum<*>");
        r10.visitEnum(r11, r13, Name.identifier(((Enum) r12).name()));
        return;
    L16:
        if (Annotation.class.isAssignableFrom(r5) == false) goto L22;
        Class<?> r14 = (Class) ArraysKt.single(r5.getInterfaces());
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r15 = r10.visitAnnotation(r11, ReflectClassUtilKt.getClassId(r14));
        if (r15 != null) goto L20;
        return;
    L20:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Annotation");
        processAnnotationArguments(r15, (Annotation) r12, r14);
        return;
    L22:
        if (r5.isArray() == false) goto L51;
        KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor r16 = r10.visitArray(r11);
        if (r16 != null) goto L26;
        return;
    L26:
        Class<?> r17 = r5.getComponentType();
        int r18 = 0;
        if (r17.isEnum() == false) goto L32;
        ClassId r19 = ReflectClassUtilKt.getClassId(r17);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r110 = (Object[]) r12;
        int r111 = r110.length;
    L29:
        if (r18 >= r111) goto L48;
        Object r20 = r110[r18];
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.Enum<*>");
        r16.visitEnum(r19, Name.identifier(((Enum) r20).name()));
        r18 = r18 + 1;
    L48:
        r16.visitEnd();
        return;
    L32:
        if (Intrinsics.areEqual(r17, Class.class) == false) goto L37;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r112 = (Object[]) r12;
        int r113 = r112.length;
    L34:
        if (r18 >= r113) goto L48;
        Object r21 = r112[r18];
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type java.lang.Class<*>");
        r16.visitClassLiteral(classLiteralValue((Class) r21));
        r18 = r18 + 1;
        goto L34
    L37:
        if (Annotation.class.isAssignableFrom(r17) == false) goto L45;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r114 = (Object[]) r12;
        int r22 = r114.length;
    L39:
        if (r18 >= r22) goto L48;
        Object r23 = r114[r18];
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r24 = r16.visitAnnotation(ReflectClassUtilKt.getClassId(r17));
        if (r24 == null) goto L44;
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type kotlin.Annotation");
        processAnnotationArguments(r24, (Annotation) r23, r17);
    L44:
        r18 = r18 + 1;
        goto L39
    L45:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r115 = (Object[]) r12;
        int r25 = r115.length;
    L46:
        if (r18 >= r25) goto L48;
        r16.visit(r115[r18]);
        r18 = r18 + 1;
        goto L46
    L51:
        throw new UnsupportedOperationException("Unsupported annotation argument value (" + r5 + "): " + r12);
    }

    private final void processAnnotationArguments(KotlinJvmBinaryClass.AnnotationArgumentVisitor r5, Annotation r10, Class<?> r11) {
        Method[] r12 = r11.getDeclaredMethods();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        Method r15 = r12[r14];
        Object r16 = r15.invoke(r10, null);     // Catch: IllegalAccessException -> L10
        Intrinsics.checkNotNull(r16);     // Catch: IllegalAccessException -> L10
        processAnnotationArgumentValue(r5, Name.identifier(r15.getName()), r16);
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        r5.visitEnd();
    }

    public final void loadClassAnnotations(Class<?> r5, KotlinJvmBinaryClass.AnnotationVisitor r10) {
        Intrinsics.checkNotNullParameter(r5, "klass");
        Intrinsics.checkNotNullParameter(r10, "visitor");
        Annotation[] r11 = r5.getDeclaredAnnotations();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        processAnnotation(r10, r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        r10.visitEnd();
    }

    public final void visitMembers(Class<?> r5, KotlinJvmBinaryClass.MemberVisitor r10) {
        Intrinsics.checkNotNullParameter(r5, "klass");
        Intrinsics.checkNotNullParameter(r10, "memberVisitor");
        loadMethodAnnotations(r5, r10);
        loadConstructorAnnotations(r5, r10);
        loadFieldAnnotations(r5, r10);
    }
}
