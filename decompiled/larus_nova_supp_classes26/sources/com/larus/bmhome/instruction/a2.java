package com.larus.bmhome.instruction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a2 {
    public static boolean g;
    public final boolean a;
    public boolean b;
    public long c;
    public long d;
    public long e;
    public long f;

    public static final class a {
    }

    static {
        g = true;
    }

    public a2() {
        this.a = g;
        g = false;
    }

    public static Long a(long r3, long r5) {
        if (r3 > 0) goto L5;
    L7:
        return null;
    L5:
        if (r5 <= 0) goto L7;
        return Long.valueOf(r5 - r3);
    }
}
