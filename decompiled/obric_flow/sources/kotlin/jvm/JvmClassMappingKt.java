package kotlin.jvm;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u001f\u0010\u001f\u001a\u00020 \"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0014*\u0006\u0012\u0002\b\u00030!¢\u0006\u0002\u0010\"\"'\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\";\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t*\b\u0012\u0004\u0012\u0002H\b0\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"-\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018G¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"&\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0015\";\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018Ç\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"+\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012\"-\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0012\"+\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"annotationClass", "Lkotlin/reflect/KClass;", ExifInterface.GPS_DIRECTION_TRUE, "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "declaringJavaClass", "Ljava/lang/Class;", ExifInterface.LONGITUDE_EAST, "", "getDeclaringJavaClass$annotations", "(Ljava/lang/Enum;)V", "getDeclaringJavaClass", "(Ljava/lang/Enum;)Ljava/lang/Class;", "java", "getJavaClass$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "getRuntimeClassOfKClassInstance$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "JvmClassMappingKt")
public final class JvmClassMappingKt {
    public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(T r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        KClass<? extends T> r10 = getKotlinClass(r5.annotationType());
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return r10;
    }

    private static final <E extends Enum<E>> Class<E> getDeclaringJavaClass(Enum<E> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.getDeclaringClass();
    }

    @SinceKotlin(version = "1.7")
    @InlineOnly
    public static /* synthetic */ void getDeclaringJavaClass$annotations(Enum r5) {
    }

    @JvmName(name = "getJavaClass")
    public static final <T> Class<T> getJavaClass(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Class<T> r10 = (Class<T>) ((ClassBasedDeclarationContainer) r5).getJClass();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return r10;
    }

    public static /* synthetic */ void getJavaClass$annotations(KClass r5) {
    }

    public static final <T> Class<T> getJavaObjectType(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Class<T> r10 = (Class<T>) ((ClassBasedDeclarationContainer) r5).getJClass();
        if (r10.isPrimitive() == true) goto L6;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return r10;
    L6:
        String r11 = r10.getName();
        switch(r11.hashCode()) {
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
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return r10;
    L10:
        if (r11.equals("short") == false) goto L45;
        r10 = (Class<T>) Short.class;
        goto L45
    L14:
        if (r11.equals("float") == false) goto L45;
        r10 = (Class<T>) Float.class;
        goto L45
    L18:
        if (r11.equals("boolean") == false) goto L45;
        r10 = (Class<T>) Boolean.class;
        goto L45
    L22:
        if (r11.equals("void") == false) goto L45;
        r10 = (Class<T>) Void.class;
        goto L45
    L26:
        if (r11.equals("long") == false) goto L45;
        r10 = (Class<T>) Long.class;
        goto L45
    L30:
        if (r11.equals("char") == false) goto L45;
        r10 = (Class<T>) Character.class;
        goto L45
    L34:
        if (r11.equals("byte") == false) goto L45;
        r10 = (Class<T>) Byte.class;
        goto L45
    L38:
        if (r11.equals("int") == false) goto L45;
        r10 = (Class<T>) Integer.class;
        goto L45
    L42:
        if (r11.equals("double") == false) goto L45;
        r10 = (Class<T>) Double.class;
        goto L45
    }

    public static final <T> Class<T> getJavaPrimitiveType(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Class<T> r10 = (Class<T>) ((ClassBasedDeclarationContainer) r5).getJClass();
        if (r10.isPrimitive() == false) goto L6;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
        return r10;
    L6:
        String r11 = r10.getName();
        switch(r11.hashCode()) {
            case -2056817302: goto L42;
            case -527879800: goto L38;
            case -515992664: goto L34;
            case 155276373: goto L30;
            case 344809556: goto L26;
            case 398507100: goto L22;
            case 398795216: goto L18;
            case 399092968: goto L14;
            case 761287205: goto L10;
            default: goto L43;
        };
    L43:
        return null;
    L10:
        if (r11.equals("java.lang.Double") == false) goto L43;
        return Double.TYPE;
    L14:
        if (r11.equals("java.lang.Void") == false) goto L43;
        return Void.TYPE;
    L18:
        if (r11.equals("java.lang.Long") == false) goto L43;
        return Long.TYPE;
    L22:
        if (r11.equals("java.lang.Byte") == false) goto L43;
        return Byte.TYPE;
    L26:
        if (r11.equals("java.lang.Boolean") == false) goto L43;
        return Boolean.TYPE;
    L30:
        if (r11.equals("java.lang.Character") == false) goto L43;
        return Character.TYPE;
    L34:
        if (r11.equals("java.lang.Short") == false) goto L43;
        return Short.TYPE;
    L38:
        if (r11.equals("java.lang.Float") == false) goto L43;
        return Float.TYPE;
    L42:
        if (r11.equals("java.lang.Integer") == false) goto L43;
        return Integer.TYPE;
    }

    @JvmName(name = "getKotlinClass")
    public static final <T> KClass<T> getKotlinClass(Class<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Reflection.getOrCreateKotlinClass(r5);
    }

    @JvmName(name = "getRuntimeClassOfKClassInstance")
    public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Class<KClass<T>> r10 = (Class<KClass<T>>) r5.getClass();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
        return r10;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @ReplaceWith(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void getRuntimeClassOfKClassInstance$annotations(KClass r5) {
    }

    public static final /* synthetic */ boolean isArrayOf(Object[] r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return Object.class.isAssignableFrom(r5.getClass().getComponentType());
    }

    public static final <T> Class<T> getJavaClass(T r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Class<T> r10 = (Class<T>) r5.getClass();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
        return r10;
    }
}
