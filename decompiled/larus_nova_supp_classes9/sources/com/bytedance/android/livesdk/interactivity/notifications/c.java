package com.bytedance.android.livesdk.interactivity.notifications;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ViewGroup.MarginLayoutParams a;
    public final /* synthetic */ LiveRoomNotifyWidget.c b;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Object r3 = r2.getAnimatedValue();
        if ((r3 instanceof Integer) == true) goto L5;
        return;
    L5:
        if (((Widget) this.b.n).containerView == null) goto L9;
        ViewGroup.MarginLayoutParams r0 = this.a;
        r0.topMargin = ((Integer) r3).intValue();
        ((Widget) this.b.n).containerView.setLayoutParams(this.a);
        return;
    }

    public c(LiveRoomNotifyWidget.c r1, ViewGroup.MarginLayoutParams r2) {
        this.b = r1;
        this.a = r2;
    }
}
