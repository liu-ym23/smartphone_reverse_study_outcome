package com.google.common.base;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class n {
    public static int a(int r1, int r2) {
        return a(r1, r2, "index");
    }

    public static int a(int r1, int r2, String r3) {
        if (r1 < 0) goto L6;
        if (r1 >= r2) goto L6;
        return r1;
    L6:
        throw new IndexOutOfBoundsException(c(r1, r2, r3));
    }

    public static <T> T a(T r0) {
        Objects.requireNonNull(r0);
        return r0;
    }

    public static <T> T a(T r0, Object r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new NullPointerException(String.valueOf(r1));
    }

    public static <T> T a(T r2, String r3, Object r4) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(q.a(r3, new Object[]{r4}));
    }

    public static void a(int r1, int r2, int r3) {
        if (r1 < 0) goto L7;
        if (r2 < r1) goto L7;
        if (r2 > r3) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException(b(r1, r2, r3));
    }

    public static void a(boolean r0) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static void a(boolean r0, Object r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r1));
    }

    public static void a(boolean r2, String r3, char r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(q.a(r3, new Object[]{Character.valueOf(r4)}));
    }

    public static void a(boolean r2, String r3, int r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(q.a(r3, new Object[]{Integer.valueOf(r4)}));
    }

    public static void a(boolean r2, String r3, int r4, int r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(q.a(r3, new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)}));
    }

    public static void a(boolean r2, String r3, long r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(q.a(r3, new Object[]{Long.valueOf(r4)}));
    }

    public static void a(boolean r2, String r3, long r4, long r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(q.a(r3, new Object[]{Long.valueOf(r4), Long.valueOf(r6)}));
    }

    public static void a(boolean r2, String r3, long r4, Object r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(q.a(r3, new Object[]{Long.valueOf(r4), r6}));
    }

    public static void a(boolean r2, String r3, Object r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(q.a(r3, new Object[]{r4}));
    }

    public static void a(boolean r2, String r3, Object r4, Object r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(q.a(r3, new Object[]{r4, r5}));
    }

    public static void a(boolean r2, String r3, Object r4, Object r5, Object r6, Object r7) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(q.a(r3, new Object[]{r4, r5, r6, r7}));
    }

    public static int b(int r1, int r2) {
        return b(r1, r2, "index");
    }

    public static int b(int r1, int r2, String r3) {
        if (r1 < 0) goto L6;
        if (r1 > r2) goto L6;
        return r1;
    L6:
        throw new IndexOutOfBoundsException(d(r1, r2, r3));
    }

    private static String b(int r1, int r2, int r3) {
        if (r1 < 0) goto L13;
        if (r1 > r3) goto L13;
        if (r2 < 0) goto L11;
        if (r2 > r3) goto L11;
        return q.a("end index (%s) must not be less than start index (%s)", new Object[]{Integer.valueOf(r2), Integer.valueOf(r1)});
    L11:
        return d(r2, r3, "end index");
    L13:
        return d(r1, r3, "start index");
    }

    public static void b(boolean r0) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException();
    }

    public static void b(boolean r0, Object r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.valueOf(r1));
    }

    public static void b(boolean r2, String r3, int r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(q.a(r3, new Object[]{Integer.valueOf(r4)}));
    }

    public static void b(boolean r2, String r3, long r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(q.a(r3, new Object[]{Long.valueOf(r4)}));
    }

    public static void b(boolean r2, String r3, Object r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(q.a(r3, new Object[]{r4}));
    }

    public static void b(boolean r2, String r3, Object r4, Object r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(q.a(r3, new Object[]{r4, r5}));
    }

    private static String c(int r4, int r5, String r6) {
        if (r4 < 0) goto L5;
        if (r5 < 0) goto L10;
        return q.a("%s (%s) must be less than size (%s)", new Object[]{r6, Integer.valueOf(r4), Integer.valueOf(r5)});
    L10:
        throw new IllegalArgumentException("negative size: " + r5);
    L5:
        return q.a("%s (%s) must not be negative", new Object[]{r6, Integer.valueOf(r4)});
    }

    private static String d(int r4, int r5, String r6) {
        if (r4 < 0) goto L5;
        if (r5 < 0) goto L10;
        return q.a("%s (%s) must not be greater than size (%s)", new Object[]{r6, Integer.valueOf(r4), Integer.valueOf(r5)});
    L10:
        throw new IllegalArgumentException("negative size: " + r5);
    L5:
        return q.a("%s (%s) must not be negative", new Object[]{r6, Integer.valueOf(r4)});
    }
}
