package k8;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f10142a = Float.MAX_VALUE;

    static {
    }

    public static final d a(float r10, float r11) {
        long r12 = Float.floatToRawIntBits(r10);
        return new d((((long) Float.floatToRawIntBits(r11)) & 4294967295L) | (r12 << 32));
    }

    public static final float b() {
        return f10142a;
    }
}
