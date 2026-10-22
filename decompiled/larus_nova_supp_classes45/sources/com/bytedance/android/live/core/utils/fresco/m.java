package com.bytedance.android.live.core.utils.fresco;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.frame.FrameScheduler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m implements FrameScheduler {
    public final a a;
    public long b;

    public static class a implements AnimationInformation {
        public final AnimationInformation a;

        public final int getLoopCount() {
            return 1;
        }

        public final int getFrameCount() {
            return this.a.getFrameCount();
        }

        public a(AnimationBackend r1) {
            this.a = r1;
        }

        public final int getFrameDurationMs(int r2) {
            return this.a.getFrameDurationMs(r2);
        }
    }

    public final FrameScheduler forNewFrameScheduler(FrameScheduler r1) {
        return null;
    }

    public final void setStartTime(long r1) {
    }

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
        this.a.getClass();
        return false;
    }

    public m(AnimationBackend r3) {
        this.b = -1;
        this.a = new a(r3);
    }

    public final long getTargetRenderTimeForNextFrameMs(long r12) {
        long r0 = getLoopDurationMs();
        long r4 = 0;
        if (r0 != 0) goto L5;
        return -1;
    L5:
        isInfiniteAnimation();
        long r6 = r12 / getLoopDurationMs();
        this.a.getClass();
        if (r6 < 1) goto L8;
        return -1;
    L8:
        long r1 = r12 % r0;
        int r2 = this.a.getFrameCount();
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L14;
        if (r4 > r1) goto L14;
        r4 = r4 + ((long) this.a.getFrameDurationMs(r3));
        r3 = r3 + 1;
    L14:
        return r12 + (r4 - r1);
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

    public final int getFrameNumberToRender(long r7, long r9) {
        isInfiniteAnimation();
        long r11 = r7 / getLoopDurationMs();
        this.a.getClass();
        if (r11 < 1) goto L5;
        return -1;
    L5:
        long r8 = r7 % getLoopDurationMs();
        int r12 = 0;
        long r1 = 0;
    L6:
        r1 = r1 + ((long) this.a.getFrameDurationMs(r12));
        r12 = r12 + 1;
        if (r8 >= r1) goto L6;
        return r12 - 1;
    }
}
