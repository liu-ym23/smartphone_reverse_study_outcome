package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements Interpolator {
    public final PointF a;
    public final PointF b;
    public final PointF c;
    public final PointF d;
    public final PointF e;

    public static final class a {
    }

    static {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r12) {
        float r2 = r12;
        int r1 = 1;
    L4:
        if (r1 > 13) goto L9;
        PointF r3 = this.e;
        float r5 = 3;
        PointF r6 = this.a;
        float r7 = r6.x * r5;
        r3.x = r7;
        PointF r8 = this.d;
        float r9 = ((this.b.x - r6.x) * r5) - r7;
        r8.x = r9;
        PointF r10 = this.c;
        float r11 = (1 - r3.x) - r9;
        r10.x = r11;
        float r4 = ((r3.x + ((r8.x + (r11 * r2)) * r2)) * r2) - r12;
        if (Math.abs(r4) < 0.001d) goto L9;
        r2 = r2 - (r4 / (this.e.x + (((2 * this.d.x) + ((r5 * this.c.x) * r2)) * r2)));
        r1 = r1 + 1;
    L9:
        PointF r13 = this.e;
        float r14 = 3;
        PointF r15 = this.a;
        float r16 = r15.y * r14;
        r13.y = r16;
        PointF r17 = this.d;
        float r18 = (r14 * (this.b.y - r15.y)) - r16;
        r17.y = r18;
        PointF r19 = this.c;
        float r0 = (1 - r13.y) - r18;
        r19.y = r0;
        return r2 * (r13.y + ((r17.y + (r0 * r2)) * r2));
    }

    public f(float r4, float r5, float r6, float r7) {
        PointF r0 = new PointF(r4, r5);
        PointF r8 = new PointF(r6, r7);
        Intrinsics.checkNotNullParameter(r0, "start");
        Intrinsics.checkNotNullParameter(r8, "end");
        this.c = new PointF();
        this.d = new PointF();
        this.e = new PointF();
        float r9 = r0.x;
        boolean r10 = false;
        float r11 = 0;
        if (r9 >= r11) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == false) goto L20;
        float r13 = r8.x;
        if (r13 >= r11) goto L12;
    L14:
        if (r10 == false) goto L18;
        this.a = r0;
        this.b = r8;
        return;
    L18:
        throw new IllegalArgumentException("endX value must be in the range [0, 1]".toString());
    L12:
        if (r13 > 1) goto L14;
        r10 = true;
        goto L14
    L20:
        throw new IllegalArgumentException("startX value must be in the range [0, 1]".toString());
    L5:
        if (r9 > 1) goto L7;
        r12 = true;
        goto L8
    }
}
