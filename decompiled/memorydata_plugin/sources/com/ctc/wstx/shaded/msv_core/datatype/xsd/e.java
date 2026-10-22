package com.ctc.wstx.shaded.msv_core.datatype.xsd;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static int a(String r5) {
        int r0 = r5.length();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L11;
        char r3 = r5.charAt(r1);
        if (55296 <= r3) goto L7;
    L9:
        r2 = r2 + 1;
    L10:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r3 >= 56320) goto L9;
    L11:
        return r2;
    }
}
