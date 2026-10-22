package kotlin.jvm;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
@JvmName(name = "JvmClassMappingKt")
public final class JvmClassMappingKt {
    public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(T r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Class<? extends Annotation> r11 = r10.annotationType();
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.annota…otation).annotationType()");
        KClass<? extends T> r12 = getKotlinClass(r11);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return r12;
    }

    private static final <E extends Enum<E>> Class<E> getDeclaringJavaClass(Enum<E> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Class<E> r11 = r10.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.Enum<E>).declaringClass");
        return r11;
    }

    @SinceKotlin(version = "1.7")
    @InlineOnly
    public static /* synthetic */ void getDeclaringJavaClass$annotations(Enum r10) {
    }

    public static final <T> Class<T> getJavaClass(T r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Class<T> r11 = (Class<T>) r10.getClass();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
        return r11;
    }

    @JvmName(name = "getJavaClass")
    public static final <T> Class<T> getJavaClass(KClass<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Class<T> r11 = (Class<T>) ((ClassBasedDeclarationContainer) r10).getJClass();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return r11;
    }

    public static /* synthetic */ void getJavaClass$annotations(KClass r10) {
    }

    public static final <T> Class<T> getJavaObjectType(KClass<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Class<T> r11 = (Class<T>) ((ClassBasedDeclarationContainer) r10).getJClass();
        if (r11.isPrimitive() == true) goto L6;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return r11;
    L6:
        String r12 = r11.getName();
        switch(r12.hashCode()) {
            case -1325958191: goto L42;
            case 104431: goto L38;
            case 3039496: goto L34;
            case 3052374: goto L30;
            case 3327612: goto L26;
            case 3625364: goto L22;
            case 64711720: goto L18;
            case 97526364: goto L14;
            case 109413500: goto L10;
            default: goto L45;
        };
    L45:
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return r11;
    L10:
        if (r12.equals("short") == false) goto L45;
        r11 = (Class<T>) Short.class;
        goto L45
    L14:
        if (r12.equals(TypedValues.Custom.S_FLOAT) == false) goto L45;
        r11 = (Class<T>) Float.class;
        goto L45
    L18:
        if (r12.equals(TypedValues.Custom.S_BOOLEAN) == false) goto L45;
        r11 = (Class<T>) Boolean.class;
        goto L45
    L22:
        if (r12.equals("void") == false) goto L45;
        r11 = (Class<T>) Void.class;
        goto L45
    L26:
        if (r12.equals("long") == false) goto L45;
        r11 = (Class<T>) Long.class;
        goto L45
    L30:
        if (r12.equals("char") == false) goto L45;
        r11 = (Class<T>) Character.class;
        goto L45
    L34:
        if (r12.equals("byte") == false) goto L45;
        r11 = (Class<T>) Byte.class;
        goto L45
    L38:
        if (r12.equals("int") == false) goto L45;
        r11 = (Class<T>) Integer.class;
        goto L45
    L42:
        if (r12.equals("double") == false) goto L45;
        r11 = (Class<T>) Double.class;
        goto L45
    }

    public static final <T> Class<T> getJavaPrimitiveType(KClass<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Class<T> r11 = (Class<T>) ((ClassBasedDeclarationContainer) r10).getJClass();
        if (r11.isPrimitive() == false) goto L6;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
        return r11;
    L6:
        String r12 = r11.getName();
        switch(r12.hashCode()) {
            case -2056817302: goto L42;
            case -527879800: goto L38;
            case -515992664: goto L34;
            case 155276373: goto L30;
            case 344809556: goto L26;
            case 398507100: goto L22;
            case 398795216: goto L18;
            case 399092968: goto L14;
            case 761287205: goto L10;
            default: goto L45;
        };
    L45:
        return null;
    L10:
        if (r12.equals("java.lang.Double") == false) goto L45;
        return Double.TYPE;
    L14:
        if (r12.equals("java.lang.Void") == false) goto L45;
        return Void.TYPE;
    L18:
        if (r12.equals("java.lang.Long") == false) goto L45;
        return Long.TYPE;
    L22:
        if (r12.equals("java.lang.Byte") == false) goto L45;
        return Byte.TYPE;
    L26:
        if (r12.equals("java.lang.Boolean") == false) goto L45;
        return Boolean.TYPE;
    L30:
        if (r12.equals("java.lang.Character") == false) goto L45;
        return Character.TYPE;
    L34:
        if (r12.equals("java.lang.Short") == false) goto L45;
        return Short.TYPE;
    L38:
        if (r12.equals("java.lang.Float") == false) goto L45;
        return Float.TYPE;
    L42:
        if (r12.equals("java.lang.Integer") == false) goto L45;
        return Integer.TYPE;
    }

    @JvmName(name = "getKotlinClass")
    public static final <T> KClass<T> getKotlinClass(Class<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Reflection.getOrCreateKotlinClass(r10);
    }

    @JvmName(name = "getRuntimeClassOfKClassInstance")
    public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(KClass<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Class<KClass<T>> r11 = (Class<KClass<T>>) r10.getClass();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
        return r11;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @ReplaceWith(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void getRuntimeClassOfKClassInstance$annotations(KClass r10) {
    }

    public static final /* synthetic */ boolean isArrayOf(Object[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return Object.class.isAssignableFrom(r10.getClass().getComponentType());
    }
}
