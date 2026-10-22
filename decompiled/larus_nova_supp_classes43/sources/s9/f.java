package s9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public long a;
    public long b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L8;
        return false;
    L8:
        f r11 = (f) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r10 = this.b;
        return r1 + ((int) (r10 ^ (r10 >>> 32)));
    }

    public final String toString() {
        return "Recorder(startTime=" + this.a + ", endTime=" + this.b + ')';
    }

    public f() {
        this.a = 0;
        this.b = 0;
    }
}
