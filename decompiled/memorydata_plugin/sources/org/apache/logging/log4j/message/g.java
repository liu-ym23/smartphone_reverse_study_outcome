package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.util.r;

/* JADX INFO: loaded from: classes6.dex */
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f17891a = null;

    static {
        f17891a = ThreadLocal.withInitial($$Lambda$g$Pc67SZ8k6Z8zkstMc45Saepxeg.INSTANCE);
    }

    static int a(String r7) {
        if (r7 != null) goto L5;
        return 0;
    L5:
        int r1 = r7.length();
        int r2 = 0;
        int r3 = 0;
        boolean r4 = false;
    L7:
        if (r2 >= (r1 - 1)) goto L19;
        char r5 = r7.charAt(r2);
        if (r5 != '\\') goto L12;
        r4 = !r4;
    L18:
        r2 = r2 + 1;
        goto L7
    L12:
        if (r5 != '{') goto L17;
        if (r4 == true) goto L17;
        int r6 = r2 + 1;
        if (r7.charAt(r6) != '}') goto L17;
        r3 = r3 + 1;
        r2 = r6;
    L17:
        r4 = false;
        goto L18
    L19:
        return r3;
    }

    static int a(String r7, int[] r8) {
        if (r7 != null) goto L5;
        return 0;
    L5:
        int r1 = r7.length();
        int r2 = 0;
        int r3 = 0;
        boolean r4 = false;
    L7:
        if (r2 >= (r1 - 1)) goto L19;
        char r5 = r7.charAt(r2);
        if (r5 != '\\') goto L12;
        r4 = !r4;
        r8[0] = -1;
        r3 = r3 + 1;
    L18:
        r2 = r2 + 1;
        goto L7
    L12:
        if (r5 != '{') goto L17;
        if (r4 == true) goto L17;
        int r6 = r2 + 1;
        if (r7.charAt(r6) != '}') goto L17;
        r8[r3] = r2;
        r3 = r3 + 1;
        r2 = r6;
    L17:
        r4 = false;
        goto L18
    L19:
        return r3;
    }

    static String a(Object r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L10;
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    L10:
        if (ZeusTransformUtils.instanceOf(r2, Integer.class) == false) goto L14;
        return Integer.toString(((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue());
    L14:
        if (ZeusTransformUtils.instanceOf(r2, Long.class) == false) goto L18;
        return Long.toString(((Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.memorydata.plugin")).longValue());
    L18:
        if (ZeusTransformUtils.instanceOf(r2, Double.class) == false) goto L22;
        return Double.toString(((Double) ZeusTransformUtils.preCheckCast(r2, Double.class, "com.obric.memorydata.plugin")).doubleValue());
    L22:
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == false) goto L26;
        return Boolean.toString(((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
    L26:
        if (ZeusTransformUtils.instanceOf(r2, Character.class) == false) goto L30;
        return Character.toString(((Character) ZeusTransformUtils.preCheckCast(r2, Character.class, "com.obric.memorydata.plugin")).charValue());
    L30:
        if (ZeusTransformUtils.instanceOf(r2, Short.class) == false) goto L34;
        return Short.toString(((Short) ZeusTransformUtils.preCheckCast(r2, Short.class, "com.obric.memorydata.plugin")).shortValue());
    L34:
        if (ZeusTransformUtils.instanceOf(r2, Float.class) == false) goto L38;
        return Float.toString(((Float) ZeusTransformUtils.preCheckCast(r2, Float.class, "com.obric.memorydata.plugin")).floatValue());
    L38:
        if (ZeusTransformUtils.instanceOf(r2, Byte.class) == true) goto L40;
        StringBuilder r0 = new StringBuilder();
        a(r2, r0);
        return r0.toString();
    L40:
        return Byte.toString(((Byte) ZeusTransformUtils.preCheckCast(r2, Byte.class, "com.obric.memorydata.plugin")).byteValue());
    }

    static String a(String r2, Object[] r3) {
        StringBuilder r0 = new StringBuilder();
        if (r3 != null) goto L5;
        int r1 = 0;
    L6:
        a(r0, r2, r3, r1);
        return r0.toString();
    L5:
        r1 = r3.length;
        goto L6
    }

    private static Set<Object> a() {
        return Collections.newSetFromMap(new IdentityHashMap());
    }

    private static Set<Object> a(Set<Object> r2) {
        Set<Object> r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L5;
        return r3;
    L5:
        return a();
    }

    private static void a(int r0, StringBuilder r1) {
        b(r0 >> 1, r1);
    }

    static void a(Object r1, StringBuilder r2) {
        a(r1, r2, null);
    }

    private static void a(Object r1, StringBuilder r2, Throwable r3) {
        r2.append(ParameterizedMessage.ERROR_PREFIX);
        r2.append(b(r1));
        r2.append(ParameterizedMessage.ERROR_SEPARATOR);
        String r4 = r3.getMessage();
        String r5 = r3.getClass().getName();
        r2.append(r5);
        if (r5.equals(r4) == true) goto L5;
        r2.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        r2.append(r4);
    L5:
        r2.append(ParameterizedMessage.ERROR_SUFFIX);
    }

    private static void a(Object r2, StringBuilder r3, Set<Object> r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if (b(r2, r3) == false) goto L6;
        return;
    L6:
        if (c(r2) == false) goto L8;
        b(r2, r3, r5);
        return;
    L8:
        d(r2, r3);
    }

    private static void a(Object r10, StringBuilder r11, Set<Object> r12, Class<?> r13) {
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        if (r13 != byte[].class) goto L6;
        String r15 = Arrays.toString((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r10, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"));
    L5:
        r11.append(r15);
        return;
    L6:
        if (r13 != short[].class) goto L8;
        r15 = Arrays.toString((short[]) ZeusTransformUtils.preCheckCast((short[]) ZeusTransformUtils.preCheckCast(r10, short[].class, "com.obric.memorydata.plugin"), short[].class, "com.obric.memorydata.plugin"));
        goto L5
    L8:
        if (r13 != int[].class) goto L10;
        r15 = Arrays.toString((int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r10, int[].class, "com.obric.memorydata.plugin"), int[].class, "com.obric.memorydata.plugin"));
        goto L5
    L10:
        if (r13 != long[].class) goto L12;
        r15 = Arrays.toString((long[]) ZeusTransformUtils.preCheckCast((long[]) ZeusTransformUtils.preCheckCast(r10, long[].class, "com.obric.memorydata.plugin"), long[].class, "com.obric.memorydata.plugin"));
        goto L5
    L12:
        if (r13 != float[].class) goto L14;
        r15 = Arrays.toString((float[]) ZeusTransformUtils.preCheckCast((float[]) ZeusTransformUtils.preCheckCast(r10, float[].class, "com.obric.memorydata.plugin"), float[].class, "com.obric.memorydata.plugin"));
        goto L5
    L14:
        if (r13 != double[].class) goto L16;
        r15 = Arrays.toString((double[]) ZeusTransformUtils.preCheckCast((double[]) ZeusTransformUtils.preCheckCast(r10, double[].class, "com.obric.memorydata.plugin"), double[].class, "com.obric.memorydata.plugin"));
        goto L5
    L16:
        if (r13 != boolean[].class) goto L18;
        r15 = Arrays.toString((boolean[]) ZeusTransformUtils.preCheckCast((boolean[]) ZeusTransformUtils.preCheckCast(r10, boolean[].class, "com.obric.memorydata.plugin"), boolean[].class, "com.obric.memorydata.plugin"));
        goto L5
    L18:
        if (r13 != char[].class) goto L20;
        r15 = Arrays.toString((char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(r10, char[].class, "com.obric.memorydata.plugin"), char[].class, "com.obric.memorydata.plugin"));
        goto L5
    L20:
        Set<Object> r16 = a(r14);
        boolean r0 = true;
        if ((!r16.add(r10)) == false) goto L23;
        r11.append(ParameterizedMessage.RECURSION_PREFIX).append(b(r10)).append(ParameterizedMessage.RECURSION_SUFFIX);
        return;
    L23:
        Object[] r17 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r10, Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin");
        r11.append('[');
        int r18 = r17.length;
        int r2 = 0;
    L24:
        if (r2 >= r18) goto L30;
        Object r3 = r17[r2];
        if (r0 == false) goto L28;
        r0 = false;
    L29:
        a(r3, r11, b(r16));
        r2 = r2 + 1;
        goto L24
    L28:
        r11.append(", ");
        goto L29
    L30:
        r11.append(']');
    }

    private static void a(String r0, int r1, StringBuilder r2, int r3, int r4) {
        if (r4 != (r1 - 1)) goto L6;
        a(r2, r3, r0.charAt(r4));
        return;
    }

    private static void a(StringBuilder r1) {
        r1.append('{');
        r1.append('}');
    }

    private static void a(StringBuilder r1, int r2, char r3) {
        if (r3 != '\\') goto L5;
        b(r2 + 1, r1);
        return;
    L5:
        b(r1, r2, r3);
    }

    static void a(StringBuilder r7, String r8, Object[] r9, int r10) {
        if (r8 == null) goto L23;
        if (r9 == null) goto L23;
        if (r10 == 0) goto L23;
        int r0 = r8.length();
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r2 >= (r0 - 1)) goto L21;
        char r5 = r8.charAt(r2);
        if (r5 != '\\') goto L13;
        r3 = r3 + 1;
    L20:
        r2 = r2 + 1;
        goto L8
    L13:
        if (a(r5, r8, r2) == false) goto L18;
        r2 = r2 + 1;
        a(r3, r7);
        if (a(r3) == false) goto L17;
        a(r7);
    L19:
        r3 = 0;
        goto L20
    L17:
        a(r9, r10, r4, r7);
        r4 = r4 + 1;
        goto L19
    L18:
        b(r7, r3, r5);
        goto L19
    L21:
        a(r8, r0, r7, r3, r2);
        return;
    L23:
        r7.append(r8);
    }

    static void a(StringBuilder r3, String r4, Object[] r5, int r6, int[] r7) {
        if (r4 == null) goto L11;
        if (r5 == null) goto L11;
        if (r6 == 0) goto L11;
        int r0 = 0;
        int r1 = 0;
    L7:
        if (r0 >= r6) goto L9;
        r3.append(r4, r1, r7[r0]);
        r1 = r7[r0] + 2;
        a(r5[r0], r3);
        r0 = r0 + 1;
        goto L7
    L9:
        r3.append(r4, r1, r4.length());
        return;
    L11:
        r3.append(r4);
    }

    private static void a(Object[] r0, int r1, int r2, StringBuilder r3) {
        if (r2 >= r1) goto L4;
        a(r0[r2], r3);
        return;
    L4:
        a(r3);
    }

    private static boolean a(char r2, String r3, int r4) {
        if (r2 == '{') goto L5;
    L7:
        return false;
    L5:
        if (r3.charAt(r4 + 1) != '}') goto L7;
        return true;
    }

    private static boolean a(int r1) {
        if ((r1 & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    static String b(Object r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return r2.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(r2));
    }

    private static /* synthetic */ SimpleDateFormat b() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    }

    private static Set<Object> b(Set<Object> r2) {
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Set<Object> r0 = a();
        r0.addAll(r3);
        return r0;
    }

    private static void b(int r1, StringBuilder r2) {
    L2:
        if (r1 <= 0) goto L4;
        r2.append('\\');
        r1 = r1 - 1;
        goto L2
    }

    private static void b(Object r2, StringBuilder r3, Set<Object> r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Class<?> r0 = r2.getClass();
        if (r0.isArray() == false) goto L6;
        a(r2, r3, r5, r0);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, Map.class) == false) goto L9;
        c(r2, r3, r5);
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r2, Collection.class) == false) goto L13;
        d(r2, r3, r5);
        return;
    L13:
        throw new IllegalArgumentException("was expecting a container, found " + r0);
    }

    private static void b(StringBuilder r0, int r1, char r2) {
        b(r1, r0);
        r0.append(r2);
    }

    private static boolean b(Object r1, StringBuilder r2) {
        if (r.c(r2, r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (c(r1, r2) == true) goto L8;
        return false;
    }

    private static void c(Object r5, StringBuilder r6, Set<Object> r7) {
        Set<Object> r8 = a((Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin"));
        boolean r2 = true;
        if ((!r8.add(r5)) == false) goto L5;
        r6.append(ParameterizedMessage.RECURSION_PREFIX).append(b(r5)).append(ParameterizedMessage.RECURSION_SUFFIX);
        return;
    L5:
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin");
        r6.append('{');
        Iterator r10 = r9.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L13;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r2 == false) goto L11;
        r2 = false;
    L12:
        Object r3 = r0.getKey();
        Object r1 = r0.getValue();
        a(r3, r6, b(r8));
        r6.append('=');
        a(r1, r6, b(r8));
        goto L7
    L11:
        r6.append(", ");
        goto L12
    L13:
        r6.append('}');
    }

    private static boolean c(Object r1) {
        if (r1.getClass().isArray() == false) goto L5;
    L10:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, Map.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L10;
        return false;
    }

    private static boolean c(Object r3, StringBuilder r4) {
        if (ZeusTransformUtils.instanceOf(r3, Date.class) == true) goto L6;
        return false;
    L6:
        Date r5 = (Date) ZeusTransformUtils.preCheckCast(r3, Date.class, "com.obric.memorydata.plugin");
        r4.append(((SimpleDateFormat) ZeusTransformUtils.preCheckCast(f17891a.get(), SimpleDateFormat.class, "com.obric.memorydata.plugin")).format(r5));
        return true;
    }

    private static void d(Object r1, StringBuilder r2) {
        r2.append(r1.toString());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a(r1, r2, th);
    }

    private static void d(Object r3, StringBuilder r4, Set<Object> r5) {
        Set<Object> r6 = a((Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin"));
        boolean r2 = true;
        if ((!r6.add(r3)) == false) goto L5;
        r4.append(ParameterizedMessage.RECURSION_PREFIX).append(b(r3)).append(ParameterizedMessage.RECURSION_SUFFIX);
        return;
    L5:
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin");
        r4.append('[');
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L13;
        Object r0 = r8.next();
        if (r2 == false) goto L11;
        r2 = false;
    L12:
        a(r0, r4, b(r6));
        goto L7
    L11:
        r4.append(", ");
        goto L12
    L13:
        r4.append(']');
    }

    /* JADX INFO: renamed from: lambda$Pc67S-Z8k6Z8zkstMc45Saepxeg, reason: not valid java name */
    public static /* synthetic */ SimpleDateFormat m3152lambda$Pc67SZ8k6Z8zkstMc45Saepxeg() {
        return b();
    }
}
