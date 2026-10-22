package com.lynx.markdown;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {
    public static long a(int r4, int r5) {
        long r0 = (0 | ((long) r4)) << 32;
        return ((long) r5) | r0;
    }

    public static long b(int r5, int r6, int r7) {
        long r0 = (((long) r5) & 2097151) << 42;
        return (((((long) r6) & 2097151) << 21) | r0) | (((long) r7) & 2097151);
    }
}
