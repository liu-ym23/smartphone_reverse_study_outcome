package qz1;

import android.animation.Animator;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.LiveGiftGroupComboViewNew;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends o12.b {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ LiveGiftGroupComboViewNew b;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        LiveGiftGroupComboViewNew r4 = this.b;
        Runnable r0 = this.a;
        int r1 = LiveGiftGroupComboViewNew.g;
        r4.c(r0);
    }

    public f(LiveGiftGroupComboViewNew r1, Runnable r2) {
        this.b = r1;
        this.a = r2;
    }
}
