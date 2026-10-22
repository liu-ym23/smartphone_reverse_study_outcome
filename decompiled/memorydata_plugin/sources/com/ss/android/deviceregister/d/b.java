package com.ss.android.deviceregister.d;

/* JADX INFO: loaded from: classes6.dex */
public class b {
    public static boolean a(String r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        int r1 = r5.length();
        if (r1 >= 13) goto L8;
    L30:
        return false;
    L8:
        if (r1 > 160) goto L30;
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L28;
        char r3 = r5.charAt(r2);
        if (r3 < '0') goto L17;
        if (r3 > '9') goto L17;
    L27:
        r2 = r2 + 1;
    L17:
        if (r3 < 'a') goto L21;
        if (r3 <= 'f') goto L27;
    L21:
        if (r3 < 'A') goto L25;
        if (r3 <= 'F') goto L27;
    L25:
        if (r3 == '-') goto L27;
        return false;
    L28:
        return true;
    }
}
