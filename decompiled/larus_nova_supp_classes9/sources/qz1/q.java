package qz1;

import android.animation.Animator;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.LiveSendGiftAnimationView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q extends com.bytedance.android.live.revenue.common.f {
    public final /* synthetic */ LiveSendGiftAnimationView a;

    public q(LiveSendGiftAnimationView r1) {
        this.a = r1;
    }

    public final void onAnimationEnd(Animator r2) {
        this.a.h.setVisibility(8);
    }

    public final void onAnimationStart(Animator r1, boolean r2) {
        this.a.h.setVisibility(0);
    }
}
