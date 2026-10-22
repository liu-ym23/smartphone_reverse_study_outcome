package ix8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public final long a;
    public final int b;
    public final int c;

    public g() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof g) == true) goto L8;
        return false;
    L8:
        g r9 = (g) r8;
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
        return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        return "VLMIntentPreProcessInfo(durationMs=" + this.a + ", originImageSize=" + this.b + ", compressedImageSize=" + this.c + ')';
    }

    public /* synthetic */ g(int r3) {
        this(0, 0, 0);
    }

    public g(long r1, int r3, int r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }
}
