package ib;

import com.qualcomm.qti.qesdk.QesdkUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8302a;

    public a(float r8, float r10) {
        long r11 = Float.floatToRawIntBits(r8);
        this.f8302a = (((long) Float.floatToRawIntBits(r10)) & QesdkUtils.LIMITS.UINT_32_UPPER) | (r11 << 32);
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("(");
        long r10 = this.f8302a;
        r8.append(Float.intBitsToFloat((int) (r10 >> 32)));
        r8.append(", ");
        r8.append(Float.intBitsToFloat((int) (r10 & QesdkUtils.LIMITS.UINT_32_UPPER)));
        r8.append(')');
        return r8.toString();
    }
}
