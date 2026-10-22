package q8;

import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final long f12486a;

    public a(float r10, float r11) {
        long r12 = Float.floatToRawIntBits(r10);
        this((((long) Float.floatToRawIntBits(r11)) & 4294967295L) | (r12 << 32));
    }

    public a(long r10) {
        this.f12486a = r10;
    }

    public String toString() {
        return '(' + Float.intBitsToFloat((int) (this.f12486a >> 32)) + ", " + Float.intBitsToFloat((int) (this.f12486a & 4294967295L)) + ')';
    }
}
