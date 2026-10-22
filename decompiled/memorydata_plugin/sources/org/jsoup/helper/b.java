package org.jsoup.helper;

/* JADX INFO: loaded from: classes7.dex */
public final class b {
    private b() {
    }

    public static void a(Object r1) {
        if (r1 == null) goto L5;
        return;
    L5:
        throw new ValidationException("Object must not be null");
    }

    public static void a(Object r2, String r3) {
        if (r2 == null) goto L5;
        return;
    L5:
        throw new ValidationException(String.format("The parameter '%s' must not be null.", new Object[]{r3}));
    }

    public static void a(String r1) {
        if (r1 == null) goto L7;
        if (r1.length() == 0) goto L7;
        return;
    L7:
        throw new ValidationException("String must not be empty");
    }

    public static void a(String r2, String r3) {
        if (r2 == null) goto L7;
        if (r2.length() == 0) goto L7;
        return;
    L7:
        throw new ValidationException(String.format("The '%s' parameter must not be empty.", new Object[]{r3}));
    }

    public static void a(boolean r1) {
        if (r1 == false) goto L5;
        return;
    L5:
        throw new ValidationException("Must be true");
    }

    public static void a(boolean r0, String r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new ValidationException(r1);
    }

    public static void a(Object[] r1) {
        a(r1, "Array must not contain any null objects");
    }

    public static void a(Object[] r3, String r4) {
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (r3[r1] == null) goto L8;
        r1 = r1 + 1;
        goto L3
    L8:
        throw new ValidationException(r4);
    }

    public static Object b(Object r1) {
        if (r1 == null) goto L5;
        return r1;
    L5:
        throw new ValidationException("Object must not be null");
    }

    public static void b(Object r0, String r1) {
        if (r0 == null) goto L5;
        return;
    L5:
        throw new ValidationException(r1);
    }

    public static void b(String r1) {
        throw new ValidationException(r1);
    }

    public static void b(String r0, String r1) {
        if (r0 == null) goto L7;
        if (r0.length() == 0) goto L7;
        return;
    L7:
        throw new ValidationException(r1);
    }

    public static void b(boolean r1) {
        if (r1 == true) goto L5;
        return;
    L5:
        throw new ValidationException("Must be false");
    }
}
