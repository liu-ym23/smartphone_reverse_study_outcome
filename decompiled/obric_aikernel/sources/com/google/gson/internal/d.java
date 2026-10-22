package com.google.gson.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f4259a = 0;

    static {
        f4259a = a();
    }

    private static int a() {
        return c(System.getProperty("java.version"));
    }

    private static int b(String r10) {
        StringBuilder r11 = new StringBuilder();     // Catch: NumberFormatException -> L10
        int r12 = 0;
    L4:
        if (r12 >= r10.length()) goto L8;
        char r13 = r10.charAt(r12);     // Catch: NumberFormatException -> L10
        if (Character.isDigit(r13) == false) goto L8;
        r11.append(r13);     // Catch: NumberFormatException -> L10
        r12 = r12 + 1;     // Catch: NumberFormatException -> L10
    L8:
        return Integer.parseInt(r11.toString());
    L10:
        return -1;
    }

    static int c(String r10) {
        int r11 = e(r10);
        if (r11 != (-1)) goto L5;
        r11 = b(r10);
    L5:
        if (r11 != (-1)) goto L8;
        return 6;
    L8:
        return r11;
    }

    public static boolean d() {
        if (f4259a < 9) goto L5;
        return true;
    L5:
        return false;
    }

    private static int e(String r10) {
        String[] r11 = r10.split("[._]");     // Catch: NumberFormatException -> L9
        int r12 = Integer.parseInt(r11[0]);     // Catch: NumberFormatException -> L9
        if (r12 == 1) goto L5;
    L8:
        return r12;
    L5:
        if (r11.length <= 1) goto L8;
        return Integer.parseInt(r11[1]);
    L9:
        return -1;
    }
}
