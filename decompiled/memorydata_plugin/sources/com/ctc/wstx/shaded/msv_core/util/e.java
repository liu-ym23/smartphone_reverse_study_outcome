package com.ctc.wstx.shaded.msv_core.util;

import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f3644a = "UTF-8";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3645b = "<>\"{}|\\^`";

    static {
    }

    public static String a(String r2, String r3) {
        if (a(r3) == true) goto L9;
        if (r2 == null) goto L9;
        if (a(r2) == false) goto L9;
        return new URL(new URL(r2), r3).toString();
    L9:
        return r3;
    }

    public static boolean a(String r4) {
        int r0 = r4.indexOf(58);
        if (r0 >= 0) goto L5;
        return false;
    L5:
        r0 = r0 - 1;
        if (r0 < 0) goto L15;
        char r2 = r4.charAt(r0);
        if (r2 == '#') goto L14;
        if (r2 == '/') goto L14;
        if (r2 != '?') goto L5;
    L14:
        return false;
    L15:
        return true;
    }
}
