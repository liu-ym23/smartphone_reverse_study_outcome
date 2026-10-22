package kotlinx.serialization.internal;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlinx.serialization.descriptors.g[] f19378a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlinx.serialization.c[] f19379b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f19380c = null;

    static {
        f19378a = new kotlinx.serialization.descriptors.g[0];
        f19379b = new kotlinx.serialization.c[0];
        f19380c = new Object();
    }

    public static final e0 a(String r5, kotlinx.serialization.c r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "primitiveSerializer");
        return new e0(r5, new f0(r10));
    }

    public static final Set b(kotlinx.serialization.descriptors.g r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof l) == true) goto L5;
        HashSet r10 = new HashSet(r5.d());
        int r11 = r5.d();
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L9;
        r10.add(r5.e(r12));
        r12 = r12 + 1;
        goto L7
    L9:
        return r10;
    L5:
        return ((l) r5).a();
    }

    public static final kotlinx.serialization.descriptors.g[] c(List r5) {
        if (r5 != null) goto L4;
    L5:
        r5 = null;
    L6:
        if (r5 == null) goto L10;
        kotlinx.serialization.descriptors.g[] r10 = (kotlinx.serialization.descriptors.g[]) r5.toArray(new kotlinx.serialization.descriptors.g[0]);
        if (r10 == null) goto L10;
        return r10;
    L10:
        return f19378a;
    L4:
        if (r5.isEmpty() == false) goto L6;
        goto L5
    }

    public static final kotlinx.serialization.c d(KClass r16, kotlinx.serialization.c... r17) {
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Intrinsics.checkNotNullParameter(r17, "args");
        Class r5 = JvmClassMappingKt.getJavaClass(r16);
        kotlinx.serialization.c[] r10 = (kotlinx.serialization.c[]) Arrays.copyOf(r17, r17.length);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "args");
        if (r5.isEnum() == false) goto L10;
        if (r5.getAnnotation(kotlinx.serialization.g.class) != null) goto L10;
        if (r5.getAnnotation(kotlinx.serialization.d.class) != null) goto L10;
        Object[] r11 = r5.getEnumConstants();
        String r12 = r5.getCanonicalName();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return new y(r12, (Enum[]) r11);
    L10:
        if (r5.isInterface() == false) goto L20;
        kotlinx.serialization.g r13 = (kotlinx.serialization.g) r5.getAnnotation(kotlinx.serialization.g.class);
        if (r13 != null) goto L14;
    L17:
        kotlinx.serialization.e r14 = new kotlinx.serialization.e(JvmClassMappingKt.getKotlinClass(r5));
    L18:
        if (r14 == null) goto L20;
        return r14;
    L14:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r13.with()), Reflection.getOrCreateKotlinClass(kotlinx.serialization.e.class)) == true) goto L17;
        r14 = null;
    L20:
        kotlinx.serialization.c[] r15 = (kotlinx.serialization.c[]) Arrays.copyOf(r10, r10.length);
        Field r18 = r5.getDeclaredField("Companion");     // Catch: Throwable -> L23
        r18.setAccessible(true);     // Catch: Throwable -> L23
        Object r19 = r18.get(null);     // Catch: Throwable -> L23
    L24:
        if (r19 != null) goto L26;
        kotlinx.serialization.c r20 = null;
    L27:
        if (r20 != null) goto L150;
        Field[] r21 = r5.getDeclaredFields();
        int r22 = r21.length;
        Field r110 = null;
        int r111 = 0;
        boolean r112 = false;
    L31:
        if (r111 >= r22) goto L42;
        Field r113 = r21[r111];
        if (Intrinsics.areEqual(r113.getName(), "INSTANCE") == false) goto L41;
        if (Intrinsics.areEqual(r113.getType(), r5) == false) goto L41;
        if (Modifier.isStatic(r113.getModifiers()) == false) goto L41;
        if (r112 == true) goto L39;
        r112 = true;
        r110 = r113;
    L39:
        r110 = null;
    L44:
        if (r110 != null) goto L46;
    L45:
        kotlinx.serialization.c r23 = null;
    L65:
        if (r23 != null) goto L151;
        kotlinx.serialization.c[] r24 = (kotlinx.serialization.c[]) Arrays.copyOf(r10, r10.length);
        Class<?>[] r25 = r5.getDeclaredClasses();
        int r26 = r25.length;
        int r27 = 0;
    L68:
        if (r27 >= r26) goto L73;
        Class<?> r28 = r25[r27];
        if (r28.getAnnotation(s0.class) != null) goto L74;
        r27 = r27 + 1;
    L74:
        if (r28 != null) goto L123;
        Object r29 = null;
        boolean r30 = true;
    L83:
        if (r29 == null) goto L127;
        kotlinx.serialization.c r31 = f(r29, (kotlinx.serialization.c[]) Arrays.copyOf(r24, r24.length));
        if (r31 == null) goto L127;
    L86:
        kotlinx.serialization.c r32 = r31;
        if (r32 == null) goto L110;
        return r32;
    L110:
        if (r5.getAnnotation(kotlinx.serialization.d.class) != null) goto L148;
        kotlinx.serialization.g r33 = (kotlinx.serialization.g) r5.getAnnotation(kotlinx.serialization.g.class);
        if (r33 == null) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r33.with()), Reflection.getOrCreateKotlinClass(kotlinx.serialization.e.class)) == true) goto L148;
    L118:
        return null;
    L148:
        return new kotlinx.serialization.e(JvmClassMappingKt.getKotlinClass(r5));
    L127:
        Class<?>[] r34 = r5.getDeclaredClasses();     // Catch: NoSuchFieldException -> L119
        int r35 = r34.length;     // Catch: NoSuchFieldException -> L119
        Class<?> r114 = null;
        boolean r36 = false;
        int r37 = 0;
    L88:
        if (r37 >= r35) goto L95;
        Class<?> r115 = r34[r37];     // Catch: NoSuchFieldException -> L119
        if (Intrinsics.areEqual(r115.getSimpleName(), "$serializer") == false) goto L94;
        if (r36 == true) goto L92;
        r36 = r30;
        r114 = r115;
    L92:
        r114 = null;
    L97:
        if (r114 == null) goto L101;
        Field r38 = r114.getField("INSTANCE");     // Catch: NoSuchFieldException -> L119
        if (r38 == null) goto L101;
        Object r39 = r38.get(null);     // Catch: NoSuchFieldException -> L119
    L103:
        if ((r39 instanceof kotlinx.serialization.c) == false) goto L106;
        r31 = (kotlinx.serialization.c) r39;     // Catch: NoSuchFieldException -> L119
    L101:
        r39 = null;
    L94:
        r37 = r37 + 1;     // Catch: NoSuchFieldException -> L119
        goto L88
    L95:
        if (r36 == true) goto L97;
    L106:
        r31 = null;
        goto L86
    L123:
        Field r40 = r5.getDeclaredField(r28.getSimpleName());     // Catch: Throwable -> L81
        r30 = true;
        r40.setAccessible(true);     // Catch: Throwable -> L120
        r29 = r40.get(null);     // Catch: Throwable -> L120
    L82:
        r29 = null;
    L81:
        r30 = true;
        goto L82
    L73:
        r28 = null;
        goto L74
    L151:
        return r23;
    L46:
        Object r41 = r110.get(null);
        Method[] r42 = r5.getMethods();
        int r116 = r42.length;
        Method r117 = null;
        int r118 = 0;
        boolean r119 = false;
    L47:
        if (r118 >= r116) goto L58;
        Method r120 = r42[r118];
        if (Intrinsics.areEqual(r120.getName(), "serializer") == false) goto L57;
        if (r120.getParameterTypes().length != 0) goto L57;
        if (Intrinsics.areEqual(r120.getReturnType(), kotlinx.serialization.c.class) == false) goto L57;
        if (r119 == true) goto L55;
        r117 = r120;
        r119 = true;
    L55:
        r117 = null;
    L60:
        if (r117 == null) goto L45;
        Object r43 = r117.invoke(r41, null);
        if ((r43 instanceof kotlinx.serialization.c) == false) goto L45;
        r23 = (kotlinx.serialization.c) r43;
    L57:
        r118 = r118 + 1;
        goto L47
    L58:
        if (r119 == true) goto L60;
    L41:
        r111 = r111 + 1;
        goto L31
    L42:
        if (r112 == true) goto L44;
    L150:
        return r20;
    L26:
        r20 = f(r19, (kotlinx.serialization.c[]) Arrays.copyOf(r15, r15.length));
    L23:
        r19 = null;
        goto L24
    }

    public static final int e(kotlinx.serialization.descriptors.g r10, kotlinx.serialization.descriptors.g[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeParams");
        int r5 = (r10.h().hashCode() * 31) + Arrays.hashCode(r11);
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r12 = r10.d();
        int r13 = 1;
    L3:
        int r14 = 0;
        if (r12 <= 0) goto L6;
        boolean r15 = true;
    L7:
        if (r15 == false) goto L12;
        int r16 = r12 - 1;
        int r17 = r13 * 31;
        String r18 = r10.g(r10.d() - r12).h();
        if (r18 == null) goto L11;
        r14 = r18.hashCode();
    L11:
        r13 = r17 + r14;
        r12 = r16;
        goto L3
    L12:
        int r19 = r10.d();
        int r20 = 1;
    L13:
        if (r19 <= 0) goto L15;
        boolean r21 = true;
    L16:
        if (r21 == false) goto L23;
        int r22 = r19 - 1;
        int r23 = r20 * 31;
        kotlinx.serialization.descriptors.k r24 = r10.g(r10.d() - r19).getKind();
        if (r24 == null) goto L20;
        int r25 = r24.hashCode();
    L21:
        r20 = r23 + r25;
        r19 = r22;
        goto L13
    L20:
        r25 = 0;
        goto L21
    L23:
        return (((r5 * 31) + r13) * 31) + r20;
    L15:
        r21 = false;
        goto L16
    L6:
        r15 = false;
        goto L7
    }

    public static final kotlinx.serialization.c f(Object r5, kotlinx.serialization.c... r10) {
        int r11 = 0;
        if (r10.length != 0) goto L8;
        Class[] r12 = new Class[0];     // Catch: InvocationTargetException -> L6 NoSuchMethodException -> L25
    L12:
        Object r13 = r5.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(r12, r12.length)).invoke(r5, Arrays.copyOf(r10, r10.length));     // Catch: InvocationTargetException -> L6 NoSuchMethodException -> L25
        if ((r13 instanceof kotlinx.serialization.c) == false) goto L24;
        goto L30
    L29:
        return (kotlinx.serialization.c) r13;
    L24:
        return null;
    L8:
        int r14 = r10.length;     // Catch: InvocationTargetException -> L6 NoSuchMethodException -> L25
        Class[] r15 = new Class[r14];     // Catch: InvocationTargetException -> L6 NoSuchMethodException -> L25
    L9:
        if (r11 >= r14) goto L11;
        r15[r11] = kotlinx.serialization.c.class;     // Catch: InvocationTargetException -> L6 NoSuchMethodException -> L25
        r11 = r11 + 1;     // Catch: InvocationTargetException -> L6 NoSuchMethodException -> L25
        goto L9
    L11:
        r12 = r15;
    L6:
        e = move-exception;
        Throwable r16 = e.getCause();
        if (r16 == null) goto L23;
        String r17 = r16.getMessage();
        if (r17 != null) goto L22;
        r17 = e.getMessage();
    L22:
        throw new InvocationTargetException(r16, r17);
    L23:
        throw e;
    L30:
        return null;
    }

    public static final KClass g(KType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        KClassifier r10 = r5.getClassifier();
        if ((r10 instanceof KClass) == false) goto L7;
        return (KClass) r10;
    L7:
        if ((r10 instanceof KTypeParameter) == false) goto L11;
        throw new IllegalStateException(("Captured type parameter " + r10 + " from generic non-reified function. Such functionality cannot be supported as " + r10 + " is erased, either specify serializer explicitly or make calling function inline with reified " + r10).toString());
    L11:
        throw new IllegalStateException(("Only KClass supported as classifier, got " + r10).toString());
    }
}
