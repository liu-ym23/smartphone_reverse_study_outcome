package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ j a;

    public k(j r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        Object r6 = r5.getAnimatedValue();
        if (r6 == null) goto L13;
        float r7 = ((Float) r6).floatValue();
        j r0 = this.a;
        j.b(r0, r0.a(2131381750), r7);
        if (r7 < 0.5f) goto L7;
        j r3 = this.a;
        j.b(r3, r3.a(2131381751), r7 - 0.5f);
    L8:
        View r8 = this.a.a(2131381750);
        if (r8 == null) goto L14;
        r8.requestLayout();
        return;
    L14:
        return;
    L7:
        j r4 = this.a;
        j.b(r4, r4.a(2131381751), r7 + 0.5f);
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
