package com.bytedance.android.anniex.detect;

import com.lynx.tasm.behavior.v0;
import kn.e;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f3209c;
    public final float d;
    public final long e;
    public final long f;
    public final long g;

    public b(long r5, long r10, float r11, float r12, long r13, long r14, long r15) {
        this.f3207a = r5;
        this.f3208b = r10;
        this.f3209c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        r11.getClass();
        if (this.f3207a == r11.f3207a) goto L12;
        return false;
    L12:
        if (this.f3208b == r11.f3208b) goto L15;
        return false;
    L15:
        if (Float.compare(this.f3209c, r11.f3209c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r11.d) == 0) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (this.f == r11.f) goto L27;
        return false;
    L27:
        if (this.g == r11.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r5 = v0.a(v0.a(e.a(e.a(Boolean.hashCode(false) * 31, 31, false), 31, false), this.f3207a), this.f3208b);
        int r10 = androidx.constraintlayout.motion.widget.a.b(this.f3209c, r5, 31);
        int r11 = v0.a(v0.a(androidx.constraintlayout.motion.widget.a.b(this.d, r10, 31), this.e), this.f);
        return Long.hashCode(this.g) + r11;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("BlankDetectorConfig(isCheckEnable=false, isPureBlankCheckEnable=false, isPartialBlankCheckEnable=false, checkTimeoutMs=");
        r5.append(this.f3207a);
        r5.append(", snapShotTimeoutMs=");
        r5.append(this.f3208b);
        r5.append(", snapShotMaxQuality=");
        r5.append(this.f3209c);
        r5.append(", pureColorCheckThreshold=");
        r5.append(this.d);
        r5.append(", pureColorCheckTimeoutMs=");
        r5.append(this.e);
        r5.append(", partialBlankCheckTimeoutMs=");
        r5.append(this.f);
        r5.append(", detectFrequencyInternal=");
        return androidx.room.jarjarred.org.antlr.runtime.a.t(r5, this.g, ')');
    }
}
