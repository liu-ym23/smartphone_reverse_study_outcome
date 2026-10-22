package com.alibaba.excel.i;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static int a(long r2) {
        if (r2 <= 2147483647L) goto L7;
        return Integer.MAX_VALUE;
    L7:
        if (r2 >= (-2147483648L)) goto L11;
        return Integer.MIN_VALUE;
    L11:
        return (int) r2;
    }
}
