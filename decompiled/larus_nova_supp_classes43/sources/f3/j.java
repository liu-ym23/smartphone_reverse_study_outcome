package f3;

import com.bytedance.ai.bridge.core.annotation.DefaultType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public final DefaultType a;
    public final double b;
    public final String c;
    public final int d;
    public final boolean e;
    public final long f;

    public j() {
        this(0);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof j) == true) goto L8;
        return false;
    L8:
        j r11 = (j) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (Double.compare(this.b, r11.b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (this.f == r11.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = Double.doubleToLongBits(this.b);
        int r10 = (((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d) * 31;
        if (this.e == false) goto L5;
        int r11 = 1231;
    L6:
        int r12 = (r10 + r11) * 31;
        long r13 = this.f;
        return r12 + ((int) (r13 ^ (r13 >>> 32)));
    L5:
        r11 = 1237;
        goto L6
    }

    public final String toString() {
        return "DefaultValue(type=" + this.a + ", doubleValue=" + this.b + ", stringValue=" + this.c + ", intValue=" + this.d + ", boolValue=" + this.e + ", longValue=" + this.f + ')';
    }

    public final DefaultType getType() {
        return this.a;
    }

    public /* synthetic */ j(int r10) {
        this(DefaultType.NONE, 0.0d, "", 0, false, 0);
    }

    public j(DefaultType r10, double r11, String r12, int r13, boolean r14, long r15) {
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r12, "stringValue");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
    }
}
