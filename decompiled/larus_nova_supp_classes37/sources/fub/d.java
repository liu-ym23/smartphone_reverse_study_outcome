package fub;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final long a;
    public final long b;
    public final int c;

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
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        return ((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c;
    }

    public final String toString() {
        return "RecordingUploadProgress(bytesUploaded=" + this.a + ", bytesTotal=" + this.b + ", progressPercent=" + this.c + ')';
    }

    public d(long r1, long r3, int r5) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
    }
}
