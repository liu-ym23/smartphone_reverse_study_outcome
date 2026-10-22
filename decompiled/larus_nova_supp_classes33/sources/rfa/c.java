package rfa;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public final long a;
    public final long b;

    public c() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "SourceAppInfo(versionCode=" + this.a + ", lastUpdateTime=" + this.b + ')';
    }

    public /* synthetic */ c(int r3) {
        this(-1, -1);
    }

    public c(long r1, long r3) {
        this.a = r1;
        this.b = r3;
    }
}
