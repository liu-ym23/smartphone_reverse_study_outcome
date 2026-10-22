package b02;

import android.animation.Animator;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.LiveGiftComboViewNew;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r extends o12.b {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ LiveGiftComboViewNew b;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        LiveGiftComboViewNew r3 = this.b;
        r3.e = 2;
        r3.g(this.a);
    }

    public r(LiveGiftComboViewNew r1, com.bytedance.android.livesdk.gift.vs.panel.viewholder.b r2) {
        this.b = r1;
        this.a = r2;
    }
}
