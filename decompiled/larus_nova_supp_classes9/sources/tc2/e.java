package tc2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements nf6.a {
    public final long a;
    public final long b;
    public final long c;

    public e() {
        this(0, 0, 0, 7);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof e) == false) goto L12;
        e r7 = (e) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.c;
        return r2 + ((int) (r4 ^ (r4 >>> 32)));
    }

    public final String toString() {
        return "DanmakuStat(messageDecodeTime=" + this.a + ", dataReceiveTime=" + this.b + ", danmakuReceiveTime=" + this.c + ")";
    }

    public e(long r1, long r3, long r5) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
    }

    public /* synthetic */ e(long r8, long r10, long r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        long r3 = 0;
    L7:
        if ((r14 & 2) == 0) goto L9;
        long r5 = 0;
    L11:
        if ((r14 & 4) == 0) goto L13;
        long r15 = 0;
    L14:
        this(r3, r5, r15);
        return;
    L13:
        r15 = r13;
        goto L14
    L9:
        r5 = r10;
        goto L11
    L5:
        r3 = r8;
        goto L7
    }
}
