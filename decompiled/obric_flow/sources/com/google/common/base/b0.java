package com.google.common.base;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b0 {
    public static String A(String r10, Object... r11) {
        String r12 = String.valueOf(r10);
        int r5 = 0;
        int r13 = 0;
    L4:
        if (r13 >= r11.length) goto L17;
        Object r14 = r11[r13];
        if (r14 != null) goto L33;
        String r15 = "null";
    L16:
        r11[r13] = r15;
        r13 = r13 + 1;
        goto L4
    L33:
        r15 = r14.toString();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        String r16 = r14.getClass().getName();
        String r17 = Integer.toHexString(System.identityHashCode(r14));
        StringBuilder r18 = new StringBuilder(androidx.room.jarjarred.org.antlr.runtime.a.g(r16.length() + 1, r17));
        r18.append(r16);
        r18.append('@');
        r18.append(r17);
        String r19 = r18.toString();
        Logger r20 = Logger.getLogger("com.google.common.base.Strings");
        Level r21 = Level.WARNING;
        String r22 = String.valueOf(r19);
        if (r22.length() == 0) goto L14;
        String r23 = "Exception during lenientFormat for ".concat(r22);
    L15:
        r20.log(r21, r23, e);
        String r24 = e.getClass().getName();
        StringBuilder r25 = new StringBuilder(r24.length() + androidx.room.jarjarred.org.antlr.runtime.a.g(9, r19));
        r25.append("<");
        r25.append(r19);
        r25.append(" threw ");
        r25.append(r24);
        r25.append(">");
        r15 = r25.toString();
        goto L16
    L14:
        r23 = new String("Exception during lenientFormat for ");
        goto L15
    L17:
        StringBuilder r26 = new StringBuilder((r11.length * 16) + r12.length());
        int r27 = 0;
    L19:
        if (r5 >= r11.length) goto L24;
        int r28 = r12.indexOf("%s", r27);
        if (r28 == (-1)) goto L24;
        r26.append(r12, r27, r28);
        r26.append(r11[r5]);
        r27 = r28 + 2;
        r5 = r5 + 1;
    L24:
        r26.append(r12, r27, r12.length());
        if (r5 >= r11.length) goto L32;
        r26.append(" [");
        int r110 = r5 + 1;
        r26.append(r11[r5]);
    L28:
        if (r110 >= r11.length) goto L30;
        r26.append(", ");
        r26.append(r11[r110]);
        r110 = r110 + 1;
        goto L28
    L30:
        r26.append(']');
    L32:
        return r26.toString();
    }

    public static z B(z r5) {
        return new Predicates$NotPredicate(r5);
    }

    public static e0 C(com.google.common.cache.d r5) {
        return new Suppliers$SupplierOfInstance(r5);
    }

    public static String D(String r5) {
        int r10 = r5.length();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L18;
        char r12 = r5.charAt(r11);
        if (r12 < 'A') goto L17;
        if (r12 > 'Z') goto L17;
        char[] r13 = r5.toCharArray();
    L9:
        if (r11 >= r10) goto L16;
        char r14 = r13[r11];
        if (r14 < 'A') goto L14;
        if (r14 > 'Z') goto L14;
        r13[r11] = (char) (r14 ^ ' ');
    L14:
        r11 = r11 + 1;
        goto L9
    L16:
        return String.valueOf(r13);
    L17:
        r11 = r11 + 1;
        goto L3
    L18:
        return r5;
    }

    public static w E(Object r5) {
        return new w(r5.getClass().getSimpleName());
    }

    public static String F(String r5) {
        int r10 = r5.length();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L18;
        char r12 = r5.charAt(r11);
        if (r12 < 'a') goto L17;
        if (r12 > 'z') goto L17;
        char[] r13 = r5.toCharArray();
    L9:
        if (r11 >= r10) goto L16;
        char r14 = r13[r11];
        if (r14 < 'a') goto L14;
        if (r14 > 'z') goto L14;
        r13[r11] = (char) (r14 ^ ' ');
    L14:
        r11 = r11 + 1;
        goto L9
    L16:
        return String.valueOf(r13);
    L17:
        r11 = r11 + 1;
        goto L3
    L18:
        return r5;
    }

    public static void G(boolean r5) {
        if (r5 == false) goto L5;
        return;
    L5:
        throw new VerifyException();
    }

    public static String a(String r5, Iterable r10) {
        StringBuilder r11 = new StringBuilder("Predicates.");
        r11.append(r5);
        r11.append('(');
        Iterator r12 = r10.iterator();
        boolean r13 = true;
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r14 = r12.next();
        if (r13 == true) goto L8;
        r11.append(',');
    L8:
        r11.append(r14);
        r13 = false;
        goto L4
    L9:
        r11.append(')');
        return r11.toString();
    }

    public static z b() {
        return Predicates$ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    public static String c(int r5, int r10, String r11) {
        if (r5 < 0) goto L4;
        if (r10 < 0) goto L9;
        return A("%s (%s) must not be greater than size (%s)", new Object[]{r11, Integer.valueOf(r5), Integer.valueOf(r10)});
    L9:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.i(26, "negative size: ", r10));
    L4:
        return A("%s (%s) must not be negative", new Object[]{r11, Integer.valueOf(r5)});
    }

    public static void d(int r5, String r10, boolean r11) {
        if (r11 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(A(r10, new Object[]{Integer.valueOf(r5)}));
    }

    public static void e(String r5, int r10, int r11, boolean r12) {
        if (r12 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(A(r5, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11)}));
    }

    public static void f(String r5, long r10, boolean r11) {
        if (r11 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(A(r5, new Object[]{Long.valueOf(r10)}));
    }

    public static void g(String r5, boolean r10) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r5);
    }

    public static void h(String r5, boolean r10, Object r11) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(A(r5, new Object[]{r11}));
    }

    public static void i(boolean r5) {
        if (r5 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static void j(boolean r5, String r10, long r11, TimeUnit r12) {
        if (r5 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(A(r10, new Object[]{Long.valueOf(r11), r12}));
    }

    public static void k(boolean r5, String r10, Object r11, Object r12) {
        if (r5 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(A(r10, new Object[]{r11, r12}));
    }

    public static void l(int r5, int r10) {
        if (r5 < 0) goto L7;
        if (r5 >= r10) goto L7;
        return;
    L7:
        if (r5 < 0) goto L12;
        if (r10 < 0) goto L11;
        String r11 = A("%s (%s) must be less than size (%s)", new Object[]{"index", Integer.valueOf(r5), Integer.valueOf(r10)});
    L14:
        throw new IndexOutOfBoundsException(r11);
    L11:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.i(26, "negative size: ", r10));
    L12:
        r11 = A("%s (%s) must not be negative", new Object[]{"index", Integer.valueOf(r5)});
        goto L14
    }

    public static void m(Object r5) {
        r5.getClass();
    }

    public static void n(Object r5, String r10) {
        if (r5 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(r10);
    }

    public static void o(int r5, int r10) {
        if (r5 < 0) goto L6;
        if (r5 > r10) goto L6;
        return;
    L6:
        throw new IndexOutOfBoundsException(c(r5, r10, "index"));
    }

    public static void p(int r5, int r10, int r11) {
        if (r5 < 0) goto L8;
        if (r10 < r5) goto L8;
        if (r10 > r11) goto L8;
        return;
    L8:
        if (r5 < 0) goto L15;
        if (r5 > r11) goto L15;
        if (r10 < 0) goto L14;
        if (r10 > r11) goto L14;
        String r12 = A("end index (%s) must not be less than start index (%s)", new Object[]{Integer.valueOf(r10), Integer.valueOf(r5)});
    L17:
        throw new IndexOutOfBoundsException(r12);
    L14:
        r12 = c(r10, r11, "end index");
    L15:
        r12 = c(r5, r11, "start index");
        goto L17
    }

    public static void q(int r5, String r10, boolean r11) {
        if (r11 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(A(r10, new Object[]{Integer.valueOf(r5)}));
    }

    public static void r(String r5, long r10, boolean r11) {
        if (r11 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(A(r5, new Object[]{Long.valueOf(r10)}));
    }

    public static void s(String r5, boolean r10, Object r11) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(A(r5, new Object[]{r11}));
    }

    public static void t(boolean r5) {
        if (r5 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException();
    }

    public static void u(boolean r5, String r10) {
        if (r5 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(r10);
    }

    public static z v(z r5, q r10) {
        return new Predicates$CompositionPredicate(r5, r10, null);
    }

    public static boolean w(Object r5, Object r10) {
        if (r5 == r10) goto L8;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.equals(r10) == false) goto L7;
    L8:
        return true;
    }

    public static z x(Object r5) {
        if (r5 != null) goto L5;
        return Predicates$ObjectPredicate.IS_NULL.withNarrowedType();
    L5:
        return new Predicates$IsEqualToPredicate(r5, null).withNarrowedType();
    }

    public static Object y(Object r5, Object r10) {
        if (r5 == null) goto L4;
        return r5;
    L4:
        if (r10 == null) goto L7;
        return r10;
    L7:
        throw new NullPointerException("Both parameters are null");
    }

    public static z z(Collection r5) {
        return new Predicates$InPredicate(r5, null);
    }
}
