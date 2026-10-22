package com.tom_roush.pdfbox.pdmodel.font;

import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
final class ag {
    static String a(int r2) {
        String r3 = Integer.toString(r2, 16).toUpperCase(Locale.US);
        int r0 = r3.length();
        if (r0 != 1) goto L5;
        StringBuilder r1 = new StringBuilder();
        String r4 = "uni000";
    L10:
        return r1.append(r4).append(r3).toString();
    L5:
        if (r0 != 2) goto L7;
        r1 = new StringBuilder();
        r4 = "uni00";
        goto L10
    L7:
        if (r0 == 3) goto L11;
        r1 = new StringBuilder();
        r4 = "uni";
        goto L10
    L11:
        r1 = new StringBuilder();
        r4 = "uni0";
        goto L10
    }
}
