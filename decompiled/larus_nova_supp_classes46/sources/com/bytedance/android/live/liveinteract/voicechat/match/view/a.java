package com.bytedance.android.live.liveinteract.voicechat.match.view;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ChatMatchDialog a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;

    public a(ChatMatchDialog r1, int r2, int r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        Object r6 = r5.getAnimatedValue();
        if (r6 == null) goto L20;
        float r7 = ((Float) r6).floatValue();
        ConstraintLayout r0 = this.a.S90(2131365553);
        if (r0 == null) goto L7;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        int r2 = this.b;
        int r3 = this.c;
        r1.height = (int) (((r2 - r3) * r7) + r3);
        r0.setLayoutParams(r1);
    L7:
        ConstraintLayout r4 = this.a.z;
        if (r4 == null) goto L11;
        r4.setAlpha(1 - r7);
    L11:
        if (this.d == true) goto L15;
        LinearLayout r8 = this.a.u;
        if (r8 == null) goto L15;
        r8.setAlpha(1 - r7);
    L15:
        FrameLayout r9 = (FrameLayout) this.a.S90(2131364335);
        if (r9 == null) goto L21;
        r9.setAlpha(r7);
        return;
    L21:
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
