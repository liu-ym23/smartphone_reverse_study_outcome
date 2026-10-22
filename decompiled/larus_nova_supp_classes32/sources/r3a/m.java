package r3a;

import com.larus.im.internal.delegate.w;
import com.larus.im.service.audio.AudioSessionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m {
    public final int a;
    public final int b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final float g;
    public final boolean h;
    public final boolean i;
    public final AudioSessionType j;

    public m() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Float.compare(this.g, r6.g) == 0) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.e == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.f == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (((r5 + r6) * 31) + Float.floatToIntBits(this.g)) * 31;
        if (this.h == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        if (this.i == true) goto L23;
        r2 = 1237;
    L23:
        return ((r9 + r2) * 31) + this.j.hashCode();
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "RealtimeCameraConfig(previewWidth=" + this.a + ", previewHeight=" + this.b + ", fps=" + this.c + ", isFrontCamera=" + this.d + ", enableAntiShake=" + this.e + ", enableVideoAntiShake=" + this.f + ", defaultZoomRatio=" + this.g + ", enableFallback=" + this.h + ", enablePreviewingFallback=" + this.i + ", sessionType=" + this.j + ')';
    }

    public m(int r12) {
        this(w.n().a, w.n().b, w.n().c, false, false, false, 1.0f, true, true, AudioSessionType.RTC);
    }

    public m(int r2, int r3, int r4, boolean r5, boolean r6, boolean r7, float r8, boolean r9, boolean r10, AudioSessionType r11) {
        Intrinsics.checkNotNullParameter(r11, "sessionType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }
}
