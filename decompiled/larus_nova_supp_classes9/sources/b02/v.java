package b02;

import android.animation.Animator;
import android.view.View;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.RoundWaveAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v extends o12.b {
    public final /* synthetic */ RoundWaveAnimationView a;
    public final /* synthetic */ View b;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.removeView(this.b);
    }

    public v(RoundWaveAnimationView r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
