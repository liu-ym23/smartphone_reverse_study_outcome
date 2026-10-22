package com.bytedance.android.live.livepkaudience.dialog;

import android.view.animation.Animation;
import com.bytedance.android.live.core.widget.HSImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements Animation.AnimationListener {
    public final /* synthetic */ PkAudienceGuestInviteDialog a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
    }

    public j(PkAudienceGuestInviteDialog r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r3) {
        PkAudienceGuestInviteDialog r4 = this.a;
        Animation r0 = r4.g;
        if (r0 == null) goto L8;
        HSImageView r5 = r4.S90(2131374209);
        if (r5 == null) goto L9;
        r5.startAnimation(r0);
        return;
    L9:
        return;
    }
}
