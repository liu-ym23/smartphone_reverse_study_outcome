package com.obric.assistant.zeus.plugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ZeusSubProcessMainProcessWakeupManager$a {
    public final long a;
    public final long b;
    public final long c;
    public final long d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ZeusSubProcessMainProcessWakeupManager$a) == true) goto L8;
        return false;
    L8:
        ZeusSubProcessMainProcessWakeupManager$a r9 = (ZeusSubProcessMainProcessWakeupManager$a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.c;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.d;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    }

    public final String toString() {
        return "WakeupIntervals(mainSuccessRequestExpireIntervalMillis=" + this.a + ", wakeMainIntervalMillis=" + this.b + ", minCheckDelayMillis=" + this.c + ", maxCheckDelayMillis=" + this.d + ')';
    }

    public ZeusSubProcessMainProcessWakeupManager$a(long r1, long r3, long r5, long r7) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
        this.d = r7;
    }
}
