package tia;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public final int a;
    public final long b;
    public final long c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r9 = (d) r8;
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
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "CaptureReadResult(readSize=" + this.a + ", nextCursorMs=" + this.b + ", missingMs=" + this.c + ')';
    }

    public d(int r1, long r2, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
