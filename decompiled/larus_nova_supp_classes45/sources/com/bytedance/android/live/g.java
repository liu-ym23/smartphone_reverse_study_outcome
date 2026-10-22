package com.bytedance.android.live;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.FrameScheduler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements FrameScheduler {
    public final AnimationBackend a;
    public long b;
    public int c;
    public int d;
    public long e;
    public long f;
    public long g;
    public final int h;

    public final long getLoopDurationMs() {
        long r0 = this.b;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        this.b = 0;
        int r1 = this.a.getFrameCount();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L9;
        this.b += (long) this.a.getFrameDurationMs(r2);
        r2 = r2 + 1;
        goto L6
    L9:
        return this.b;
    }

    public final boolean isInfiniteAnimation() {
        if (this.a.getLoopCount() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final FrameScheduler forNewFrameScheduler(FrameScheduler r5) {
        if ((r5 instanceof g) == false) goto L6;
        g r6 = (g) r5;
        g r1 = new g(r6.a, r6.h);
        r1.d = this.d;
        r1.f = this.f;
        r1.c = this.c;
        r1.e = this.e;
        return r1;
    L6:
        return null;
    }

    public final long getTargetRenderTimeForNextFrameMs(long r8) {
        if (getLoopDurationMs() != 0) goto L6;
        return -1;
    L6:
        if (isInfiniteAnimation() == false) goto L8;
    L10:
        long r0 = this.a.getFrameDurationMs(this.d);
        long r2 = this.e + r0;
        if (r2 >= r8) goto L14;
        r2 = r8 + r0;
    L14:
        long r9 = this.g;
        return ((((r2 + r9) / 34) + 1) * 34) - r9;
    L8:
        if (this.c < this.a.getLoopCount()) goto L10;
        return -1;
    }

    public final long getTargetRenderTimeMs(int r6) {
        long r0 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L5;
        r0 = r0 + ((long) this.a.getFrameDurationMs(r6));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public final void setStartTime(long r1) {
        this.g = r1;
    }

    public g(AnimationBackend r4, int r5) {
        this.b = -1;
        this.c = 0;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.a = r4;
        this.h = r5;
    }

    public final int getFrameNumberToRender(long r11, long r13) {
        long r0 = getLoopDurationMs();
        long r3 = 0;
        if (r0 != 0) goto L6;
        return -1;
    L6:
        if (isInfiniteAnimation() == false) goto L8;
    L10:
        long r1 = r11 % r0;
        int r5 = 0;
        int r6 = 0;
    L11:
        r3 = r3 + ((long) this.a.getFrameDurationMs(r6));
        r6 = r6 + 1;
        if (r1 >= r3) goto L11;
        int r7 = r6 - 1;
        int r2 = this.d;
        if (r2 != (-1)) goto L16;
    L38:
        this.e = r11;
        this.f = r11;
        this.d = r7;
        this.c = 0;
        return r7;
    L16:
        if (r13 != this.f) goto L38;
        this.f = r11;
        if ((this.e + this.a.getFrameDurationMs(r2)) > r11) goto L21;
        this.e = r11;
        int r12 = this.d + 1;
        if (r12 < this.a.getFrameCount()) goto L31;
        int r14 = this.h;
        if (r14 != 0) goto L27;
    L30:
        this.c++;
    L33:
        if (this.a.hasCacheFrame(r5) == false) goto L37;
        this.d = r5;
        return r5;
    L37:
        return this.d;
    L27:
        if (r14 == 3) goto L30;
        r5 = r12 - 1;
        goto L33
    L31:
        r5 = r12;
        goto L33
    L21:
        return this.d;
    L8:
        if ((r11 / r0) < this.a.getLoopCount()) goto L10;
        return -1;
    }
}
