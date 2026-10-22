package com.obric.aiagent.ipc.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class c$b {
    public long a;
    public int b;
    public boolean c;

    public c$b() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c$b) == true) goto L8;
        return false;
    L8:
        c$b r9 = (c$b) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
        if (this.c == false) goto L5;
        int r2 = 1231;
    L7:
        return r1 + r2;
    L5:
        r2 = 1237;
        goto L7
    }

    public final String toString() {
        return "MethodState(windowIndex=" + this.a + ", windowCount=" + this.b + ", frequentReported=" + this.c + ')';
    }

    public c$b(int r3) {
        this.a = Long.MIN_VALUE;
        this.b = 0;
        this.c = false;
    }
}
