package nuc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import juc.d;
import juc.g;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.serialization.Polymorphic;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.NamedCompanion;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class z1 {
    public static final <T> boolean c(KClass<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return JvmClassMappingKt.getJavaClass(r1).isInterface();
    }

    public static final <T> d<T> a(KClass<T> r13, d<Object>... r14) {
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter(r14, "args");
        Class r15 = JvmClassMappingKt.getJavaClass(r13);
        d[] r16 = (d[]) Arrays.copyOf(r14, r14.length);
        Intrinsics.checkNotNullParameter(r15, "<this>");
        Intrinsics.checkNotNullParameter(r16, "args");
        boolean r1 = true;
        if (r15.isEnum() == true) goto L5;
    L12:
        d[] r0 = (d[]) Arrays.copyOf(r16, r16.length);
        Field r3 = r15.getDeclaredField("Companion");     // Catch: Throwable -> L15
        r3.setAccessible(true);     // Catch: Throwable -> L15
        Object r4 = r3.get(null);     // Catch: Throwable -> L15
    L16:
        if (r4 != null) goto L18;
        d<T> r2 = null;
    L19:
        if (r2 != null) goto L161;
        String r5 = r15.getCanonicalName();
        if (r5 != null) goto L24;
    L32:
        boolean r6 = false;
    L34:
        if (r6 == false) goto L80;
        Field[] r7 = r15.getDeclaredFields();
        int r8 = r7.length;
        Field r9 = null;
        int r10 = 0;
        boolean r11 = false;
    L37:
        if (r10 >= r8) goto L51;
        Field r12 = r7[r10];
        if (Intrinsics.areEqual(r12.getName(), "INSTANCE") == true) goto L41;
    L45:
        boolean r17 = false;
    L46:
        if (r17 == false) goto L50;
        if (r11 == true) goto L52;
        r9 = r12;
        r11 = true;
    L52:
        r9 = null;
    L53:
        if (r9 == null) goto L80;
        Object r18 = r9.get(null);
        Method[] r19 = r15.getMethods();
        int r20 = r19.length;
        Method r21 = null;
        int r22 = 0;
        boolean r23 = false;
    L56:
        if (r22 >= r20) goto L73;
        Method r110 = r19[r22];
        if (Intrinsics.areEqual(r110.getName(), "serializer") == true) goto L60;
    L67:
        boolean r111 = false;
    L68:
        if (r111 == false) goto L72;
        if (r23 == true) goto L74;
        r21 = r110;
        r23 = true;
    L74:
        r21 = null;
    L75:
        if (r21 == null) goto L80;
        Object r24 = r21.invoke(r18, new Object[0]);
        if ((r24 instanceof d) == false) goto L80;
        d<T> r25 = (d) r24;
    L81:
        if (r25 != null) goto L162;
        d[] r112 = (d[]) Arrays.copyOf(r16, r16.length);
        Class<?>[] r26 = r15.getDeclaredClasses();
        int r27 = r26.length;
        int r28 = 0;
    L84:
        if (r28 >= r27) goto L92;
        Class<?> r29 = r26[r28];
        if (r29.getAnnotation(NamedCompanion.class) == null) goto L88;
        boolean r30 = true;
    L89:
        if (r30 == true) goto L93;
        r28 = r28 + 1;
    L93:
        if (r29 != null) goto L141;
    L94:
        Object r31 = null;
    L99:
        if (r31 == null) goto L143;
        d<T> r113 = b(r31, (d[]) Arrays.copyOf(r112, r112.length));
        if (r113 == null) goto L143;
    L121:
        d<T> r32 = r113;
    L124:
        if (r32 == null) goto L127;
        return r32;
    L127:
        if (r15.getAnnotation(Polymorphic.class) != null) goto L135;
        Serializable r114 = r15.getAnnotation(Serializable.class);
        if (r114 != null) goto L132;
    L134:
        r1 = false;
        goto L135
    L132:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r114.with()), Reflection.getOrCreateKotlinClass(g.class)) == false) goto L134;
    L135:
        if (r1 == false) goto L138;
        return new g(JvmClassMappingKt.getKotlinClass(r15));
    L138:
        return null;
    L143:
        Class<?>[] r115 = r15.getDeclaredClasses();     // Catch: NoSuchFieldException -> L122
        int r33 = r115.length;     // Catch: NoSuchFieldException -> L122
        Class<?> r34 = null;
        int r35 = 0;
        boolean r36 = false;
    L104:
        if (r35 >= r33) goto L111;
        Class<?> r37 = r115[r35];     // Catch: NoSuchFieldException -> L122
        if (Intrinsics.areEqual(r37.getSimpleName(), "$serializer") == false) goto L110;
        if (r36 == true) goto L112;
        r34 = r37;
        r36 = true;
    L112:
        r34 = null;
    L113:
        if (r34 == null) goto L117;
        Field r116 = r34.getField("INSTANCE");     // Catch: NoSuchFieldException -> L122
        if (r116 == null) goto L117;
        Object r117 = r116.get(null);     // Catch: NoSuchFieldException -> L122
    L119:
        if ((r117 instanceof d) == false) goto L123;
        r113 = (d) r117;     // Catch: NoSuchFieldException -> L122
    L117:
        r117 = null;
    L110:
        r35 = r35 + 1;     // Catch: NoSuchFieldException -> L122
        goto L104
    L111:
        if (r36 == true) goto L113;
    L123:
        r32 = null;
        goto L124
    L141:
        Field r38 = r15.getDeclaredField(r29.getSimpleName());     // Catch: Throwable -> L98
        r38.setAccessible(true);     // Catch: Throwable -> L98
        r31 = r38.get(null);     // Catch: Throwable -> L98
    L88:
        r30 = false;
        goto L89
    L92:
        r29 = null;
        goto L93
    L162:
        return r25;
    L72:
        r22 = r22 + 1;
        goto L56
    L60:
        if (r110.getParameterTypes().length != 0) goto L62;
        boolean r118 = true;
    L63:
        if (r118 == false) goto L67;
        if (Intrinsics.areEqual(r110.getReturnType(), d.class) == false) goto L67;
        r111 = true;
        goto L68
    L62:
        r118 = false;
        goto L63
    L73:
        if (r23 == true) goto L75;
    L50:
        r10 = r10 + 1;
        goto L37
    L41:
        if (Intrinsics.areEqual(r12.getType(), r15) == false) goto L45;
        if (Modifier.isStatic(r12.getModifiers()) == false) goto L45;
        r17 = true;
        goto L46
    L51:
        if (r11 == true) goto L53;
    L80:
        r25 = null;
        goto L81
    L24:
        if (StringsKt.startsWith$default(r5, "java.", false, 2, null) == false) goto L26;
    L29:
        boolean r39 = true;
    L30:
        if (r39 == true) goto L32;
        r6 = true;
        goto L34
    L26:
        if (StringsKt.startsWith$default(r5, "kotlin.", false, 2, null) == true) goto L29;
        r39 = false;
        goto L30
    L161:
        return r2;
    L18:
        r2 = b(r4, (d[]) Arrays.copyOf(r0, r0.length));
    L15:
        r4 = null;
        goto L16
    L5:
        if (r15.getAnnotation(Serializable.class) == null) goto L7;
    L9:
        boolean r40 = false;
    L10:
        if (r40 == false) goto L12;
        Object[] r119 = r15.getEnumConstants();
        String r120 = r15.getCanonicalName();
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return new h0(r120, (Enum[]) r119);
    L7:
        if (r15.getAnnotation(Polymorphic.class) != null) goto L9;
        r40 = true;
        goto L10
    }

    public static final <T> d<T> b(Object r4, d<Object>... r5) {
        int r1 = 0;
        if (r5.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        Class[] r2 = new Class[0];     // Catch: InvocationTargetException -> L16 NoSuchMethodException -> L27
    L12:
        Object r6 = r4.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(r2, r2.length)).invoke(r4, Arrays.copyOf(r5, r5.length));     // Catch: InvocationTargetException -> L16 NoSuchMethodException -> L27
        if ((r6 instanceof d) == false) goto L25;
        goto L25
    L31:
        return (d) r6;
    L8:
        int r3 = r5.length;     // Catch: InvocationTargetException -> L16 NoSuchMethodException -> L27
        Class[] r7 = new Class[r3];     // Catch: InvocationTargetException -> L16 NoSuchMethodException -> L27
    L9:
        if (r1 >= r3) goto L11;
        r7[r1] = d.class;     // Catch: InvocationTargetException -> L16 NoSuchMethodException -> L27
        r1 = r1 + 1;     // Catch: InvocationTargetException -> L16 NoSuchMethodException -> L27
        goto L9
    L11:
        r2 = r7;
        goto L12
    L5:
        r0 = false;
    L16:
        e = move-exception;
        Throwable r8 = e.getCause();
        if (r8 == null) goto L24;
        String r9 = r8.getMessage();
        if (r9 != null) goto L23;
        r9 = e.getMessage();
    L23:
        throw new InvocationTargetException(r8, r9);
    L24:
        throw e;
    L25:
        return null;
    }
}
