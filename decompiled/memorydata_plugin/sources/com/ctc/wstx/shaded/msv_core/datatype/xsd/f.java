package com.ctc.wstx.shaded.msv_core.datatype.xsd;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static boolean a(String r4) {
        if (r4 != null) goto L5;
    L22:
        return false;
    L5:
        if (r4.length() == 0) goto L22;
        char r1 = r4.charAt(0);
        if (com.ctc.wstx.shaded.msv.a.a.c(r1) == false) goto L10;
    L14:
        int r2 = 1;
    L16:
        if (r2 >= r4.length()) goto L21;
        if (com.ctc.wstx.shaded.msv.a.a.a(r4.charAt(r2)) == false) goto L19;
        r2 = r2 + 1;
        goto L16
    L19:
        return false;
    L21:
        return true;
    L10:
        if (r1 == '_') goto L14;
        if (r1 == ':') goto L14;
        return false;
    }

    public static boolean b(String r4) {
        if (r4 != null) goto L5;
    L20:
        return false;
    L5:
        if (r4.length() == 0) goto L20;
        char r1 = r4.charAt(0);
        if (com.ctc.wstx.shaded.msv.a.a.c(r1) == false) goto L10;
    L12:
        int r2 = 1;
    L14:
        if (r2 >= r4.length()) goto L19;
        if (com.ctc.wstx.shaded.msv.a.a.b(r4.charAt(r2)) == false) goto L17;
        r2 = r2 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    L10:
        if (r1 == '_') goto L12;
        return false;
    }

    public static boolean c(String r4) {
        if (r4 != null) goto L5;
    L15:
        return false;
    L5:
        if (r4.length() == 0) goto L15;
        int r1 = r4.length();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L13;
        if (com.ctc.wstx.shaded.msv.a.a.a(r4.charAt(r2)) == false) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    }

    public static boolean d(String r1) {
        if (a(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.indexOf(58) >= 0) goto L7;
        return true;
    }
}
