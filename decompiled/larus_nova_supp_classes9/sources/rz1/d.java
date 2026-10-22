package rz1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements GiftIconMaskView.b {
    public final /* synthetic */ b a;

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView.b
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public d(b r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView.b
    public final void onAnimationEnd(Animator r6) {
        Intrinsics.checkNotNullParameter(r6, "animation");
        b r7 = this.a;
        if (r7.b != null) goto L5;
        r7.b = new AnimatorSet();
    L5:
        AnimatorSet r0 = r7.b;
        if (r0 == null) goto L9;
        r0.cancel();
        r0.removeAllListeners();
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r7.c, "scaleX", new float[]{1.12f, 1.0f});
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r7.c, "scaleY", new float[]{1.12f, 1.0f});
        r0.play(r1).with(r2);
        r0.setDuration(200);
        r0.addListener(new c(r7));
        r0.start();
        return;
    }
}
