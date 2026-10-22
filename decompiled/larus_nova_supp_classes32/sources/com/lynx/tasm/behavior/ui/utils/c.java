package com.lynx.tasm.behavior.ui.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public c() {
    }

    public static int a(int r2, int r3) {
        if (r3 != 255) goto L6;
        return r2;
    L6:
        if (r3 == 0) goto L8;
        int r4 = r3 + (r3 >> 7);
        int r5 = (((r2 >>> 24) * r4) >> 8) << 24;
        return (r2 & 16777215) | r5;
    L8:
        return r2 & 16777215;
    }
}
