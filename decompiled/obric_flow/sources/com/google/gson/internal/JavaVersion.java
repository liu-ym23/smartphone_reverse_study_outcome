package com.google.gson.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class JavaVersion {
    private static final int majorJavaVersion = 0;

    static {
        majorJavaVersion = determineMajorJavaVersion();
    }

    private JavaVersion() {
    }

    private static int determineMajorJavaVersion() {
        return parseMajorJavaVersion(System.getProperty("java.version"));
    }

    private static int extractBeginningInt(String r5) {
        StringBuilder r10 = new StringBuilder();     // Catch: NumberFormatException -> L10
        int r11 = 0;
    L4:
        if (r11 >= r5.length()) goto L8;
        char r12 = r5.charAt(r11);     // Catch: NumberFormatException -> L10
        if (Character.isDigit(r12) == false) goto L8;
        r10.append(r12);     // Catch: NumberFormatException -> L10
        r11 = r11 + 1;     // Catch: NumberFormatException -> L10
    L8:
        return Integer.parseInt(r10.toString());
    L10:
        return -1;
    }

    public static int getMajorJavaVersion() {
        return majorJavaVersion;
    }

    public static boolean isJava9OrLater() {
        if (majorJavaVersion < 9) goto L5;
        return true;
    L5:
        return false;
    }

    private static int parseDotted(String r5) {
        String[] r10 = r5.split("[._]", 3);     // Catch: NumberFormatException -> L9
        int r11 = Integer.parseInt(r10[0]);     // Catch: NumberFormatException -> L9
        if (r11 == 1) goto L5;
    L8:
        return r11;
    L5:
        if (r10.length <= 1) goto L8;
        return Integer.parseInt(r10[1]);
    L9:
        return -1;
    }

    public static int parseMajorJavaVersion(String r5) {
        int r10 = parseDotted(r5);
        if (r10 != (-1)) goto L5;
        r10 = extractBeginningInt(r5);
    L5:
        if (r10 != (-1)) goto L8;
        return 6;
    L8:
        return r10;
    }
}
