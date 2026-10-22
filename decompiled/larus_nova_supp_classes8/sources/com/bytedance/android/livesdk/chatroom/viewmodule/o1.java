package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.ValueAnimator;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ s1 a;

    public o1(s1 r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        int r4 = ((Integer) this.a.q.getAnimatedValue()).intValue();
        UIUtils.updateLayout(this.a.d, Math.max(r4, 1), -3);
    }
}
