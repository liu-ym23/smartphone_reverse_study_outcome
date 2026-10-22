package com.alibaba.excel.support.asm;

/* JADX INFO: loaded from: classes.dex */
public class ac {
    static void a(int r2, d r3) {
        int r0 = r2 >>> 24;
        if (r0 != 0) goto L5;
    L13:
        r3.b(r2 >>> 16);
        return;
    L5:
        if (r0 == 1) goto L13;
        switch(r0) {
            case 16: goto L12;
            case 17: goto L12;
            case 18: goto L12;
            case 19: goto L11;
            case 20: goto L11;
            case 21: goto L11;
            case 22: goto L13;
            case 23: goto L12;
            default: goto L7;
        };
    L7:
        switch(r0) {
            case 66: goto L12;
            case 67: goto L12;
            case 68: goto L12;
            case 69: goto L12;
            case 70: goto L12;
            case 71: goto L10;
            case 72: goto L10;
            case 73: goto L10;
            case 74: goto L10;
            case 75: goto L10;
            default: goto L9;
        };
    L10:
        r3.c(r2);
        return;
    L9:
        throw new IllegalArgumentException();
    L11:
        r3.a(r0);
        return;
    L12:
        r3.b(r0, (r2 & 16776960) >> 8);
    }
}
