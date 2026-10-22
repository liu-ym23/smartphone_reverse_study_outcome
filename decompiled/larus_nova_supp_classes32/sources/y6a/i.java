package y6a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {
    public i() {
    }

    public static long a(float r2, float r3) {
        int r4 = Float.floatToRawIntBits(r2);
        long r0 = ((long) r4) << 32;
        return ((long) Float.floatToRawIntBits(r3)) | r0;
    }

    public static long b(int r0, int r1) {
        return a(r0, r1);
    }
}
