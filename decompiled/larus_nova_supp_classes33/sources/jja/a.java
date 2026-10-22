package jja;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final long a;

    public final String toString() {
        return "(" + Float.intBitsToFloat((int) (this.a >> 32)) + ", " + Float.intBitsToFloat((int) (this.a & 4294967295L)) + ')';
    }

    public a(float r5, float r6) {
        long r0 = Float.floatToRawIntBits(r5);
        this.a = (((long) Float.floatToRawIntBits(r6)) & 4294967295L) | (r0 << 32);
    }
}
