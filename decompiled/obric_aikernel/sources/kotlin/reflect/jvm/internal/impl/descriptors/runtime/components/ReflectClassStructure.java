package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.bytedance.crash.event.EnsureReportData;
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
import kotlin.reflect.jvm.internal.impl.name.FqName;
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

    private final ClassLiteralValue classLiteralValue(Class<?> r10) {
        int r11 = 0;
    L4:
        if (r10.isArray() == false) goto L7;
        r11 = r11 + 1;
        r10 = r10.getComponentType();
        Intrinsics.checkNotNullExpressionValue(r10, "currentClass.componentType");
        goto L4
    L7:
        if (r10.isPrimitive() == true) goto L9;
        ClassId r12 = ReflectClassUtilKt.getClassId(r10);
        JavaToKotlinClassMap r13 = JavaToKotlinClassMap.INSTANCE;
        FqName r14 = r12.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(r14, "javaClassId.asSingleFqName()");
        ClassId r15 = r13.mapJavaToKotlin(r14);
        if (r15 == null) goto L23;
        r12 = r15;
    L23:
        return new ClassLiteralValue(r12, r11);
    L9:
        if (Intrinsics.areEqual(r10, Void.TYPE) == false) goto L12;
        ClassId r16 = ClassId.topLevel(StandardNames.FqNames.unit.toSafe());
        Intrinsics.checkNotNullExpressionValue(r16, "topLevel(StandardNames.FqNames.unit.toSafe())");
        return new ClassLiteralValue(r16, r11);
    L12:
        PrimitiveType r17 = JvmPrimitiveType.get(r10.getName()).getPrimitiveType();
        Intrinsics.checkNotNullExpressionValue(r17, "get(currentClass.name).primitiveType");
        if (r11 <= 0) goto L16;
        ClassId r18 = ClassId.topLevel(r17.getArrayTypeFqName());
        Intrinsics.checkNotNullExpressionValue(r18, "topLevel(primitiveType.arrayTypeFqName)");
        return new ClassLiteralValue(r18, r11 - 1);
    L16:
        ClassId r19 = ClassId.topLevel(r17.getTypeFqName());
        Intrinsics.checkNotNullExpressionValue(r19, "topLevel(primitiveType.typeFqName)");
        return new ClassLiteralValue(r19, r11);
    }

    private final void loadConstructorAnnotations(Class<?> r20, KotlinJvmBinaryClass.MemberVisitor r21) {
        Constructor<?>[] r10 = r20.getDeclaredConstructors();
        Intrinsics.checkNotNullExpressionValue(r10, "klass.declaredConstructors");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L28;
        Constructor<?> r13 = r10[r12];
        Name r14 = SpecialNames.INIT;
        SignatureSerializer r15 = SignatureSerializer.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r13, "constructor");
        KotlinJvmBinaryClass.MethodAnnotationVisitor r16 = r21.visitMethod(r14, r15.constructorDesc(r13));
        if (r16 != null) goto L7;
        Constructor<?>[] r17 = r10;
        int r18 = r11;
    L27:
        r12 = r12 + 1;
        r10 = r17;
        r11 = r18;
        goto L3
    L7:
        Annotation[] r19 = r13.getDeclaredAnnotations();
        Intrinsics.checkNotNullExpressionValue(r19, "constructor.declaredAnnotations");
        int r22 = r19.length;
        int r23 = 0;
    L9:
        if (r23 >= r22) goto L11;
        Annotation r110 = r19[r23];
        Intrinsics.checkNotNullExpressionValue(r110, "annotation");
        processAnnotation(r16, r110);
        r23 = r23 + 1;
        goto L9
    L11:
        Annotation[][] r24 = r13.getParameterAnnotations();
        Intrinsics.checkNotNullExpressionValue(r24, "parameterAnnotations");
        if (r24.length != 0) goto L14;
        boolean r25 = true;
    L16:
        if ((!r25) == false) goto L26;
        int r26 = r13.getParameterTypes().length - r24.length;
        int r27 = r24.length;
        int r28 = 0;
    L18:
        if (r28 >= r27) goto L26;
        Annotation[] r111 = r24[r28];
        Intrinsics.checkNotNullExpressionValue(r111, "annotations");
        int r112 = r111.length;
        int r113 = 0;
    L20:
        if (r113 >= r112) goto L25;
        Annotation r114 = r111[r113];
        Class<?> r29 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r114));
        Constructor<?>[] r115 = r10;
        int r116 = r11;
        ClassId r30 = ReflectClassUtilKt.getClassId(r29);
        int r117 = r26;
        Intrinsics.checkNotNullExpressionValue(r114, "annotation");
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r31 = r16.visitParameterAnnotation(r28 + r26, r30, new ReflectAnnotationSource(r114));
        if (r31 == null) goto L24;
        INSTANCE.processAnnotationArguments(r31, r114, r29);
    L24:
        r113 = r113 + 1;
        r10 = r115;
        r11 = r116;
        r26 = r117;
        goto L20
    L25:
        r28 = r28 + 1;
    L26:
        r17 = r10;
        r18 = r11;
        r16.visitEnd();
        goto L27
    L14:
        r25 = false;
        goto L16
    }

    private final void loadFieldAnnotations(Class<?> r10, KotlinJvmBinaryClass.MemberVisitor r11) {
        Field[] r12 = r10.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(r12, "klass.declaredFields");
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L12;
        Field r15 = r12[r14];
        Name r16 = Name.identifier(r15.getName());
        Intrinsics.checkNotNullExpressionValue(r16, "identifier(field.name)");
        SignatureSerializer r17 = SignatureSerializer.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r15, "field");
        KotlinJvmBinaryClass.AnnotationVisitor r18 = r11.visitField(r16, r17.fieldDesc(r15), null);
        if (r18 == null) goto L11;
        Annotation[] r19 = r15.getDeclaredAnnotations();
        Intrinsics.checkNotNullExpressionValue(r19, "field.declaredAnnotations");
        int r20 = r19.length;
        int r21 = 0;
    L8:
        if (r21 >= r20) goto L10;
        Annotation r22 = r19[r21];
        Intrinsics.checkNotNullExpressionValue(r22, "annotation");
        processAnnotation(r18, r22);
        r21 = r21 + 1;
        goto L8
    L10:
        r18.visitEnd();
    L11:
        r14 = r14 + 1;
        goto L3
    }

    private final void loadMethodAnnotations(Class<?> r18, KotlinJvmBinaryClass.MemberVisitor r19) {
        Method[] r10 = r18.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(r10, "klass.declaredMethods");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L22;
        Method r13 = r10[r12];
        Name r14 = Name.identifier(r13.getName());
        Intrinsics.checkNotNullExpressionValue(r14, "identifier(method.name)");
        SignatureSerializer r15 = SignatureSerializer.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r13, EnsureReportData.METHOD);
        KotlinJvmBinaryClass.MethodAnnotationVisitor r16 = r19.visitMethod(r14, r15.methodDesc(r13));
        if (r16 != null) goto L7;
        Method[] r17 = r10;
    L21:
        r12 = r12 + 1;
        r10 = r17;
        goto L3
    L7:
        Annotation[] r20 = r13.getDeclaredAnnotations();
        Intrinsics.checkNotNullExpressionValue(r20, "method.declaredAnnotations");
        int r21 = r20.length;
        int r22 = 0;
    L9:
        if (r22 >= r21) goto L11;
        Annotation r110 = r20[r22];
        Intrinsics.checkNotNullExpressionValue(r110, "annotation");
        processAnnotation(r16, r110);
        r22 = r22 + 1;
        goto L9
    L11:
        Annotation[][] r23 = r13.getParameterAnnotations();
        Intrinsics.checkNotNullExpressionValue(r23, "method.parameterAnnotations");
        int r24 = r23.length;
        int r25 = 0;
    L12:
        if (r25 >= r24) goto L20;
        Annotation[] r26 = r23[r25];
        Intrinsics.checkNotNullExpressionValue(r26, "annotations");
        int r111 = r26.length;
        int r112 = 0;
    L14:
        if (r112 >= r111) goto L19;
        Annotation r113 = r26[r112];
        Class<?> r114 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r113));
        ClassId r27 = ReflectClassUtilKt.getClassId(r114);
        Method[] r115 = r10;
        Intrinsics.checkNotNullExpressionValue(r113, "annotation");
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r28 = r16.visitParameterAnnotation(r25, r27, new ReflectAnnotationSource(r113));
        if (r28 == null) goto L18;
        INSTANCE.processAnnotationArguments(r28, r113, r114);
    L18:
        r112 = r112 + 1;
        r10 = r115;
        goto L14
    L19:
        r25 = r25 + 1;
        goto L12
    L20:
        r17 = r10;
        r16.visitEnd();
        goto L21
    }

    private final void processAnnotation(KotlinJvmBinaryClass.AnnotationVisitor r10, Annotation r11) {
        Class<?> r12 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r11));
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r13 = r10.visitAnnotation(ReflectClassUtilKt.getClassId(r12), new ReflectAnnotationSource(r11));
        if (r13 == null) goto L6;
        INSTANCE.processAnnotationArguments(r13, r11, r12);
        return;
    }

    private final void processAnnotationArgumentValue(KotlinJvmBinaryClass.AnnotationArgumentVisitor r10, Name r11, Object r12) {
        Class<?> r13 = r12.getClass();
        if (Intrinsics.areEqual(r13, Class.class) == false) goto L6;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.lang.Class<*>");
        r10.visitClassLiteral(r11, classLiteralValue((Class) r12));
        return;
    L6:
        if (ReflectKotlinClassKt.access$getTYPES_ELIGIBLE_FOR_SIMPLE_VISIT$p().contains(r13) == false) goto L9;
        r10.visit(r11, r12);
        return;
    L9:
        if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(r13) == false) goto L16;
        if (r13.isEnum() == true) goto L14;
        r13 = r13.getEnclosingClass();
    L14:
        Intrinsics.checkNotNullExpressionValue(r13, "if (clazz.isEnum) clazz else clazz.enclosingClass");
        ClassId r14 = ReflectClassUtilKt.getClassId(r13);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Enum<*>");
        Name r15 = Name.identifier(((Enum) r12).name());
        Intrinsics.checkNotNullExpressionValue(r15, "identifier((value as Enum<*>).name)");
        r10.visitEnum(r11, r14, r15);
        return;
    L16:
        if (Annotation.class.isAssignableFrom(r13) == false) goto L22;
        Class<?>[] r16 = r13.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(r16, "clazz.interfaces");
        Class<?> r17 = (Class) ArraysKt.single(r16);
        Intrinsics.checkNotNullExpressionValue(r17, "annotationClass");
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r18 = r10.visitAnnotation(r11, ReflectClassUtilKt.getClassId(r17));
        if (r18 != null) goto L20;
        return;
    L20:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Annotation");
        processAnnotationArguments(r18, (Annotation) r12, r17);
        return;
    L22:
        if (r13.isArray() == false) goto L51;
        KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor r19 = r10.visitArray(r11);
        if (r19 != null) goto L26;
        return;
    L26:
        Class<?> r20 = r13.getComponentType();
        int r21 = 0;
        if (r20.isEnum() == false) goto L32;
        Intrinsics.checkNotNullExpressionValue(r20, "componentType");
        ClassId r22 = ReflectClassUtilKt.getClassId(r20);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r110 = (Object[]) r12;
        int r23 = r110.length;
    L29:
        if (r21 >= r23) goto L48;
        Object r24 = r110[r21];
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type kotlin.Enum<*>");
        Name r25 = Name.identifier(((Enum) r24).name());
        Intrinsics.checkNotNullExpressionValue(r25, "identifier((element as Enum<*>).name)");
        r19.visitEnum(r22, r25);
        r21 = r21 + 1;
    L48:
        r19.visitEnd();
        return;
    L32:
        if (Intrinsics.areEqual(r20, Class.class) == false) goto L36;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r111 = (Object[]) r12;
        int r26 = r111.length;
    L34:
        if (r21 >= r26) goto L48;
        Object r27 = r111[r21];
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type java.lang.Class<*>");
        r19.visitClassLiteral(classLiteralValue((Class) r27));
        r21 = r21 + 1;
        goto L34
    L36:
        boolean r28 = Annotation.class.isAssignableFrom(r20);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r112 = (Object[]) r12;
        if (r28 == false) goto L45;
        int r29 = r112.length;
    L39:
        if (r21 >= r29) goto L48;
        Object r30 = r112[r21];
        Intrinsics.checkNotNullExpressionValue(r20, "componentType");
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r31 = r19.visitAnnotation(ReflectClassUtilKt.getClassId(r20));
        if (r31 == null) goto L44;
        Intrinsics.checkNotNull(r30, "null cannot be cast to non-null type kotlin.Annotation");
        processAnnotationArguments(r31, (Annotation) r30, r20);
    L44:
        r21 = r21 + 1;
        goto L39
    L45:
        int r32 = r112.length;
    L46:
        if (r21 >= r32) goto L48;
        r19.visit(r112[r21]);
        r21 = r21 + 1;
        goto L46
    L51:
        throw new UnsupportedOperationException("Unsupported annotation argument value (" + r13 + "): " + r12);
    }

    private final void processAnnotationArguments(KotlinJvmBinaryClass.AnnotationArgumentVisitor r10, Annotation r11, Class<?> r12) {
        Method[] r13 = r12.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(r13, "annotationType.declaredMethods");
        int r14 = r13.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L8;
        Method r16 = r13[r15];
        Object r17 = r16.invoke(r11, new Object[0]);     // Catch: IllegalAccessException -> L10
        Intrinsics.checkNotNull(r17);     // Catch: IllegalAccessException -> L10
        Name r18 = Name.identifier(r16.getName());
        Intrinsics.checkNotNullExpressionValue(r18, "identifier(method.name)");
        processAnnotationArgumentValue(r10, r18, r17);
    L7:
        r15 = r15 + 1;
        goto L3
    L8:
        r10.visitEnd();
    }

    public final void loadClassAnnotations(Class<?> r10, KotlinJvmBinaryClass.AnnotationVisitor r11) {
        Intrinsics.checkNotNullParameter(r10, "klass");
        Intrinsics.checkNotNullParameter(r11, "visitor");
        Annotation[] r12 = r10.getDeclaredAnnotations();
        Intrinsics.checkNotNullExpressionValue(r12, "klass.declaredAnnotations");
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        Annotation r15 = r12[r14];
        Intrinsics.checkNotNullExpressionValue(r15, "annotation");
        processAnnotation(r11, r15);
        r14 = r14 + 1;
        goto L3
    L5:
        r11.visitEnd();
    }

    public final void visitMembers(Class<?> r10, KotlinJvmBinaryClass.MemberVisitor r11) {
        Intrinsics.checkNotNullParameter(r10, "klass");
        Intrinsics.checkNotNullParameter(r11, "memberVisitor");
        loadMethodAnnotations(r10, r11);
        loadConstructorAnnotations(r10, r11);
        loadFieldAnnotations(r10, r11);
    }
}
