package kotlin.jvm;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u001f\u0010\u001f\u001a\u00020 \"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0014*\u0006\u0012\u0002\b\u00030!¢\u0006\u0002\u0010\"\"'\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\";\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t*\b\u0012\u0004\u0012\u0002H\b0\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"-\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018G¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"&\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0015\";\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018Ç\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"+\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012\"-\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0012\"+\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"annotationClass", "Lkotlin/reflect/KClass;", ExifInterface.GPS_DIRECTION_TRUE, "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "declaringJavaClass", "Ljava/lang/Class;", ExifInterface.LONGITUDE_EAST, "", "getDeclaringJavaClass$annotations", "(Ljava/lang/Enum;)V", "getDeclaringJavaClass", "(Ljava/lang/Enum;)Ljava/lang/Class;", "java", "getJavaClass$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "getRuntimeClassOfKClassInstance$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class JvmClassMappingKt {
    public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(T r2) {
        Annotation r3 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r2, Annotation.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Class<? extends Annotation> r4 = r3.annotationType();
        Intrinsics.checkNotNullExpressionValue(r4, "annotationType(...)");
        KClass<? extends T> r5 = getKotlinClass(r4);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return r5;
    }

    private static final <E extends Enum<E>> Class<E> getDeclaringJavaClass(Enum<E> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Class<E> r2 = r1.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(r2, "getDeclaringClass(...)");
        return r2;
    }

    public static /* synthetic */ void getDeclaringJavaClass$annotations(Enum r0) {
    }

    public static final <T> Class<T> getJavaClass(T r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Class<T> r2 = (Class<T>) r1.getClass();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
        return r2;
    }

    public static final <T> Class<T> getJavaClass(KClass<T> r2) {
        KClass r3 = (KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Class<T> r4 = (Class<T>) ((ClassBasedDeclarationContainer) ZeusTransformUtils.preCheckCast(r3, ClassBasedDeclarationContainer.class, "com.obric.memorydata.plugin")).getJClass();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return r4;
    }

    public static /* synthetic */ void getJavaClass$annotations(KClass r2) {
        KClass r3 = (KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin");
    }

    public static final <T> Class<T> getJavaObjectType(KClass<T> r3) {
        KClass r4 = (KClass) ZeusTransformUtils.wrapperContextForParams(r3, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Class<T> r5 = (Class<T>) ((ClassBasedDeclarationContainer) ZeusTransformUtils.preCheckCast(r4, ClassBasedDeclarationContainer.class, "com.obric.memorydata.plugin")).getJClass();
        if (r5.isPrimitive() == true) goto L6;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return r5;
    L6:
        String r0 = r5.getName();
        if (r0 != null) goto L9;
    L47:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return r5;
    L9:
        switch(r0.hashCode()) {
            case -1325958191: goto L44;
            case 104431: goto L40;
            case 3039496: goto L36;
            case 3052374: goto L32;
            case 3327612: goto L28;
            case 3625364: goto L24;
            case 64711720: goto L20;
            case 97526364: goto L16;
            case 109413500: goto L12;
            default: goto L47;
        };
    L12:
        if (r0.equals("short") == false) goto L47;
        r5 = (Class<T>) Short.class;
        goto L47
    L16:
        if (r0.equals(TypedValues.Custom.S_FLOAT) == false) goto L47;
        r5 = (Class<T>) Float.class;
        goto L47
    L20:
        if (r0.equals(TypedValues.Custom.S_BOOLEAN) == false) goto L47;
        r5 = (Class<T>) Boolean.class;
        goto L47
    L24:
        if (r0.equals("void") == false) goto L47;
        r5 = (Class<T>) Void.class;
        goto L47
    L28:
        if (r0.equals("long") == false) goto L47;
        r5 = (Class<T>) Long.class;
        goto L47
    L32:
        if (r0.equals("char") == false) goto L47;
        r5 = (Class<T>) Character.class;
        goto L47
    L36:
        if (r0.equals("byte") == false) goto L47;
        r5 = (Class<T>) Byte.class;
        goto L47
    L40:
        if (r0.equals("int") == false) goto L47;
        r5 = (Class<T>) Integer.class;
        goto L47
    L44:
        if (r0.equals("double") == false) goto L47;
        r5 = (Class<T>) Double.class;
        goto L47
    }

    public static final <T> Class<T> getJavaPrimitiveType(KClass<T> r2) {
        KClass r3 = (KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Class<T> r4 = (Class<T>) ((ClassBasedDeclarationContainer) ZeusTransformUtils.preCheckCast(r3, ClassBasedDeclarationContainer.class, "com.obric.memorydata.plugin")).getJClass();
        if (r4.isPrimitive() == false) goto L6;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
        return r4;
    L6:
        String r5 = r4.getName();
        if (r5 != null) goto L9;
    L47:
        return null;
    L9:
        switch(r5.hashCode()) {
            case -2056817302: goto L44;
            case -527879800: goto L40;
            case -515992664: goto L36;
            case 155276373: goto L32;
            case 344809556: goto L28;
            case 398507100: goto L24;
            case 398795216: goto L20;
            case 399092968: goto L16;
            case 761287205: goto L12;
            default: goto L47;
        };
    L12:
        if (r5.equals("java.lang.Double") == false) goto L47;
        return Double.TYPE;
    L16:
        if (r5.equals("java.lang.Void") == false) goto L47;
        return Void.TYPE;
    L20:
        if (r5.equals("java.lang.Long") == false) goto L47;
        return Long.TYPE;
    L24:
        if (r5.equals("java.lang.Byte") == false) goto L47;
        return Byte.TYPE;
    L28:
        if (r5.equals("java.lang.Boolean") == false) goto L47;
        return Boolean.TYPE;
    L32:
        if (r5.equals("java.lang.Character") == false) goto L47;
        return Character.TYPE;
    L36:
        if (r5.equals("java.lang.Short") == false) goto L47;
        return Short.TYPE;
    L40:
        if (r5.equals("java.lang.Float") == false) goto L47;
        return Float.TYPE;
    L44:
        if (r5.equals("java.lang.Integer") == false) goto L47;
        return Integer.TYPE;
    }

    public static final <T> KClass<T> getKotlinClass(Class<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Reflection.getOrCreateKotlinClass(r1);
    }

    public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(KClass<T> r2) {
        KClass r3 = (KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Class<KClass<T>> r4 = (Class<KClass<T>>) ZeusTransformUtils.preCheckCast(r3, Object.class, "com.obric.memorydata.plugin").getClass();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
        return r4;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @ReplaceWith(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void getRuntimeClassOfKClassInstance$annotations(KClass r2) {
        KClass r3 = (KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ boolean isArrayOf(Object[] r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return ((Class) ZeusTransformUtils.preCheckCast(Object.class, Class.class, "com.obric.memorydata.plugin")).isAssignableFrom(((Class) ZeusTransformUtils.preCheckCast(r3.getClass(), Class.class, "com.obric.memorydata.plugin")).getComponentType());
    }
}
