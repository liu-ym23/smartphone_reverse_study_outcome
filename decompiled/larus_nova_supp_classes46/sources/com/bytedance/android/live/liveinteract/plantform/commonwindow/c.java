package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ PointF a;
    public final /* synthetic */ PointF b;
    public final /* synthetic */ CommonDynamicIslandLayoutManager c;
    public final /* synthetic */ View d;

    public c(PointF r1, PointF r2, CommonDynamicIslandLayoutManager r3, View r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        int r0 = this.d.getWidth();
        int r1 = this.d.getHeight();
        Object r7 = r6.getAnimatedValue();
        if (r7 == null) goto L7;
        float r8 = ((Float) r7).floatValue();
        PointF r3 = this.a;
        PointF r2 = new PointF(r3.x - (r0 / 2), r3.y - (r1 / 2));
        PointF r4 = this.b;
        float r5 = r4.x;
        float r9 = r5 + ((r2.x - r5) * r8);
        float r10 = r4.y;
        float r11 = r10 + ((r2.y - r10) * r8);
        ALogger.i(this.c.a, "addUpdateListener startPointLeft=" + this.b + " endPoint=" + r2 + " x=" + r9 + ", y=" + r11);
        this.d.setX(r9);
        this.d.setY(r11);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
