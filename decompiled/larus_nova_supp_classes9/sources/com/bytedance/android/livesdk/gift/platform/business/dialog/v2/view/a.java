package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends BaseAnimationListener {
    public final /* synthetic */ LiveSendGiftAnimationView.b a;

    public a(LiveSendGiftAnimationView.b r1) {
        this.a = r1;
    }

    public final void onAnimationStart(AnimatedDrawable2 r2) {
        LiveSendGiftAnimationView.e(this.a.a, false);
    }

    public final void onAnimationStop(AnimatedDrawable2 r2) {
        LiveSendGiftAnimationView.e(this.a.a, true);
    }
}
