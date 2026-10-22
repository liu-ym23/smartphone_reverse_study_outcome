package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aO\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\"\u0010\u0006\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0007\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0002¢\u0006\u0002\u0010\b\u001a\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0000\u001a\u0012\u0010\r\u001a\u0004\u0018\u00010\u0003*\u0006\u0012\u0002\b\u00030\u0005H\u0002\u001a$\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0000\u001aM\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00052\"\u0010\u0006\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0007\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0000¢\u0006\u0002\u0010\b\u001aM\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\f2\"\u0010\u0006\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0007\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0000¢\u0006\u0002\u0010\u0010\u001a\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a$\u0010\u0012\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a&\u0010\u0013\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0080\b¢\u0006\u0002\u0010\u0016\u001a\u0015\u0010\u0013\u001a\u00020\n*\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0080\b\u001a$\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a\u0018\u0010\u0019\u001a\u00020\n*\u00020\u00032\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\fH\u0000\u001a\u001c\u0010\u001b\u001a\u00020\n\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a\u001c\u0010\u001c\u001a\u00020\n\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a\u0010\u0010\u001d\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\fH\u0000\u001a\u0010\u0010\u001f\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\u0005H\u0000\u001aK\u0010 \u001a\b\u0012\u0004\u0012\u0002H!0\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010!*\u0004\u0018\u0001H\u0002*\u0012\u0012\u0004\u0012\u0002H!0\"j\b\u0012\u0004\u0012\u0002H!`#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020\fH\u0000¢\u0006\u0002\u0010%¨\u0006&"}, d2 = {"invokeSerializerOnCompanion", "Lkotlinx/serialization/KSerializer;", ExifInterface.GPS_DIRECTION_TRUE, "", "jClass", "Ljava/lang/Class;", "args", "", "(Ljava/lang/Class;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "isReferenceArray", "", "rootClass", "Lkotlin/reflect/KClass;", "companionOrNull", "compiledSerializerImpl", "constructSerializerForGivenTypeArgs", "(Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "createEnumSerializer", "findObjectSerializer", "getChecked", "index", "", "([Ljava/lang/Object;I)Ljava/lang/Object;", "", "interfaceSerializer", "isInstanceOf", "kclass", "isNotAnnotated", "isPolymorphicSerializer", "platformSpecificSerializerNotRegistered", "", "serializerNotRegistered", "toNativeArrayImpl", ExifInterface.LONGITUDE_EAST, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "eClass", "(Ljava/util/ArrayList;Lkotlin/reflect/KClass;)[Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class bl {
    public static final <T> kotlinx.serialization.c<T> a(Class<T> r9, kotlinx.serialization.c<Object>... r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "args");
        if (r9.isEnum() == false) goto L9;
        if (a(r9) == false) goto L9;
        return e(r9);
    L9:
        if (r9.isInterface() == false) goto L13;
        kotlinx.serialization.c<T> r0 = c(r9);
        if (r0 == null) goto L13;
        return r0;
    L13:
        kotlinx.serialization.c<T> r11 = b(r9, (kotlinx.serialization.c[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r10, r10.length), kotlinx.serialization.c[].class, "com.obric.memorydata.plugin"));
        if (r11 == null) goto L16;
        return r11;
    L16:
        kotlinx.serialization.c<T> r12 = f(r9);
        if (r12 == null) goto L19;
        return r12;
    L19:
        kotlinx.serialization.e r13 = null;
        Class<?>[] r1 = r9.getDeclaredClasses();     // Catch: NoSuchFieldException -> L41
        Intrinsics.checkNotNullExpressionValue(r1, "declaredClasses");     // Catch: NoSuchFieldException -> L41
        Object[] r2 = (Object[]) ZeusTransformUtils.preCheckCast(r1, Object[].class, "com.obric.memorydata.plugin");     // Catch: NoSuchFieldException -> L41
        int r3 = r2.length;     // Catch: NoSuchFieldException -> L41
        int r4 = 0;
        Object r5 = null;
        boolean r6 = false;
    L21:
        if (r4 >= r3) goto L28;
        Object r7 = r2[r4];     // Catch: NoSuchFieldException -> L41
        if (Intrinsics.areEqual(((Class) ZeusTransformUtils.preCheckCast(r7, Class.class, "com.obric.memorydata.plugin")).getSimpleName(), "$serializer") == false) goto L27;
        if (r6 == true) goto L29;
        r6 = true;
        r5 = r7;
    L29:
        r5 = null;
    L30:
        Class r8 = (Class) ZeusTransformUtils.preCheckCast(r5, Class.class, "com.obric.memorydata.plugin");     // Catch: NoSuchFieldException -> L41
        if (r8 == null) goto L35;
        Field r14 = r8.getField("INSTANCE");     // Catch: NoSuchFieldException -> L41
        if (r14 == null) goto L35;
        Object r15 = r14.get(null);     // Catch: NoSuchFieldException -> L41
    L37:
        if (ZeusTransformUtils.instanceOf(r15, kotlinx.serialization.c.class) == false) goto L40;
        kotlinx.serialization.c<T> r16 = (kotlinx.serialization.c) ZeusTransformUtils.preCheckCast(r15, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");     // Catch: NoSuchFieldException -> L41
    L42:
        if (r16 == null) goto L45;
        return r16;
    L45:
        if (b(r9) == false) goto L48;
        r13 = new kotlinx.serialization.e(JvmClassMappingKt.getKotlinClass(r9));
    L48:
        return (kotlinx.serialization.c) ZeusTransformUtils.preCheckCast(r13, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
    L40:
        r16 = null;
    L35:
        r15 = null;
    L27:
        r4 = r4 + 1;     // Catch: NoSuchFieldException -> L41
        goto L21
    L28:
        if (r6 == true) goto L30;
    L41:
        r16 = (kotlinx.serialization.c) ZeusTransformUtils.preCheckCast(null, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
        goto L42
    }

    public static final <T> kotlinx.serialization.c<T> a(KClass<T> r2) {
        KClass r3 = (KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return a(r3, new kotlinx.serialization.c[0]);
    }

    public static final <T> kotlinx.serialization.c<T> a(KClass<T> r2, kotlinx.serialization.c<Object>... r3) {
        KClass r4 = (KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "args");
        return a(JvmClassMappingKt.getJavaClass(r4), (kotlinx.serialization.c[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), kotlinx.serialization.c[].class, "com.obric.memorydata.plugin"));
    }

    private static final <T> boolean a(Class<T> r1) {
        if (r1.getAnnotation(kotlinx.serialization.h.class) == null) goto L5;
    L7:
        return false;
    L5:
        if (r1.getAnnotation(kotlinx.serialization.d.class) != null) goto L7;
        return true;
    }

    public static final <T, E extends T> E[] a(ArrayList<E> r2, KClass<T> r3) {
        KClass r4 = (KClass) ZeusTransformUtils.wrapperContextForParams(r3, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "eClass");
        Object r5 = Array.newInstance(JvmClassMappingKt.getJavaClass(r4), r2.size());
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        E[] r6 = (E[]) r2.toArray((Object[]) ZeusTransformUtils.preCheckCast(r5, Object[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r6, "toArray(java.lang.reflec….java, size) as Array<E>)");
        return r6;
    }

    public static final Void b(KClass<?> r2) {
        KClass r3 = (KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        bm.a(r3);
        throw new KotlinNothingValueException();
    }

    private static final <T> kotlinx.serialization.c<T> b(Class<?> r6, kotlinx.serialization.c<Object>... r7) {
        Object r8 = d(r6);
        if (r8 != null) goto L30;
        return null;
    L30:
        int r3 = 0;
        if (r7.length != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        Class[] r4 = (Class[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(new Class[0], Object[].class, "com.obric.memorydata.plugin"), Class[].class, "com.obric.memorydata.plugin");     // Catch: InvocationTargetException -> L19 NoSuchMethodException -> L28
    L15:
        Object r9 = r8.getClass().getDeclaredMethod("serializer", (Class[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), Class[].class, "com.obric.memorydata.plugin")).invoke(r8, Arrays.copyOf(r7, r7.length));     // Catch: InvocationTargetException -> L19 NoSuchMethodException -> L28
        if (ZeusTransformUtils.instanceOf(r9, kotlinx.serialization.c.class) == false) goto L33;
        goto L29
    L34:
        return (kotlinx.serialization.c) ZeusTransformUtils.preCheckCast(r9, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
    L33:
        return null;
    L11:
        int r5 = r7.length;     // Catch: InvocationTargetException -> L19 NoSuchMethodException -> L28
        Class[] r10 = new Class[r5];     // Catch: InvocationTargetException -> L19 NoSuchMethodException -> L28
    L12:
        if (r3 >= r5) goto L14;
        r10[r3] = kotlinx.serialization.c.class;     // Catch: InvocationTargetException -> L19 NoSuchMethodException -> L28
        r3 = r3 + 1;     // Catch: InvocationTargetException -> L19 NoSuchMethodException -> L28
        goto L12
    L14:
        r4 = r10;
        goto L15
    L8:
        r2 = false;
    L19:
        e = move-exception;
        Throwable r11 = e.getCause();
        if (r11 == null) goto L27;
        String r1 = r11.getMessage();
        if (r1 != null) goto L26;
        r1 = e.getMessage();
    L26:
        throw new InvocationTargetException(r11, r1);
    L27:
        throw e;
    L29:
        return (kotlinx.serialization.c) ZeusTransformUtils.preCheckCast(null, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
    }

    private static final <T> boolean b(Class<T> r3) {
        if (r3.getAnnotation(kotlinx.serialization.d.class) == null) goto L5;
        return true;
    L5:
        kotlinx.serialization.h r4 = (kotlinx.serialization.h) ZeusTransformUtils.preCheckCast(r3.getAnnotation(kotlinx.serialization.h.class), kotlinx.serialization.h.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r4.a()), Reflection.getOrCreateKotlinClass(kotlinx.serialization.e.class)) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static final <T> kotlinx.serialization.c<T> c(Class<T> r3) {
        kotlinx.serialization.h r0 = (kotlinx.serialization.h) ZeusTransformUtils.preCheckCast(r3.getAnnotation(kotlinx.serialization.h.class), kotlinx.serialization.h.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L10;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r0.a()), Reflection.getOrCreateKotlinClass(kotlinx.serialization.e.class)) == true) goto L10;
        return null;
    L10:
        return (kotlinx.serialization.c) ZeusTransformUtils.preCheckCast(new kotlinx.serialization.e(JvmClassMappingKt.getKotlinClass(r3)), kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
    }

    public static final boolean c(KClass<Object> r2) {
        KClass r3 = (KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "rootClass");
        return JvmClassMappingKt.getJavaClass(r3).isArray();
    }

    private static final Object d(Class<?> r2) {
        Field r3 = r2.getDeclaredField("Companion");     // Catch: Throwable -> L5
        r3.setAccessible(true);     // Catch: Throwable -> L5
        return r3.get(null);
    L8:
        return null;
    }

    private static final <T> kotlinx.serialization.c<T> e(Class<T> r4) {
        T[] r0 = r4.getEnumConstants();
        String r5 = r4.getCanonicalName();
        Intrinsics.checkNotNullExpressionValue(r5, "canonicalName");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return (kotlinx.serialization.c) ZeusTransformUtils.preCheckCast(new ad(r5, (Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin")), kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
    }

    private static final <T> kotlinx.serialization.c<T> f(Class<T> r13) {
        Field[] r0 = r13.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(r0, "declaredFields");
        Object[] r1 = (Object[]) ZeusTransformUtils.preCheckCast(r0, Object[].class, "com.obric.memorydata.plugin");
        int r2 = r1.length;
        int r5 = 0;
        boolean r6 = false;
        Object r7 = null;
    L4:
        if (r5 >= r2) goto L18;
        Object r9 = r1[r5];
        Field r10 = (Field) ZeusTransformUtils.preCheckCast(r9, Field.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r10.getName(), "INSTANCE") == true) goto L8;
    L12:
        boolean r11 = false;
    L13:
        if (r11 == false) goto L17;
        if (r6 == true) goto L19;
        r6 = true;
        r7 = r9;
    L19:
        r7 = null;
    L20:
        Field r3 = (Field) ZeusTransformUtils.preCheckCast(r7, Field.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L23;
        return null;
    L23:
        Object r4 = r3.get(null);
        Method[] r14 = r13.getMethods();
        Intrinsics.checkNotNullExpressionValue(r14, "methods");
        Object[] r15 = (Object[]) ZeusTransformUtils.preCheckCast(r14, Object[].class, "com.obric.memorydata.plugin");
        int r8 = r15.length;
        int r12 = 0;
        boolean r16 = false;
        Object r17 = null;
    L24:
        if (r12 >= r8) goto L41;
        Object r18 = r15[r12];
        Method r19 = (Method) ZeusTransformUtils.preCheckCast(r18, Method.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r19.getName(), "serializer") == false) goto L35;
        Class<?>[] r110 = r19.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(r110, "it.parameterTypes");
        if (((Object[]) ZeusTransformUtils.preCheckCast(r110, Object[].class, "com.obric.memorydata.plugin")).length != 0) goto L30;
        boolean r111 = true;
    L31:
        if (r111 == false) goto L35;
        if (Intrinsics.areEqual(r19.getReturnType(), kotlinx.serialization.c.class) == false) goto L35;
        boolean r112 = true;
    L36:
        if (r112 == false) goto L40;
        if (r16 == true) goto L42;
        r16 = true;
        r17 = r18;
    L42:
        r17 = null;
    L43:
        Method r113 = (Method) ZeusTransformUtils.preCheckCast(r17, Method.class, "com.obric.memorydata.plugin");
        if (r113 != null) goto L46;
        return null;
    L46:
        Object r114 = r113.invoke(r4, new Object[0]);
        if (ZeusTransformUtils.instanceOf(r114, kotlinx.serialization.c.class) == true) goto L49;
        return null;
    L49:
        return (kotlinx.serialization.c) ZeusTransformUtils.preCheckCast(r114, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
    L40:
        r12 = r12 + 1;
        goto L24
    L30:
        r111 = false;
    L35:
        r112 = false;
        goto L36
    L41:
        if (r16 == true) goto L43;
    L17:
        r5 = r5 + 1;
        goto L4
    L8:
        if (Intrinsics.areEqual(r10.getType(), r13) == false) goto L12;
        if (Modifier.isStatic(r10.getModifiers()) == false) goto L12;
        r11 = true;
        goto L13
    L18:
        if (r6 == true) goto L20;
        goto L19
    }
}
