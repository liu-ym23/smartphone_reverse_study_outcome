package s12;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.bytedance.android.livesdk.gift.platform.format.panel.view.FormatGiftListWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends AnimatorListenerAdapter {
    public final /* synthetic */ FormatGiftListWidget a;

    public f(FormatGiftListWidget r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ImageView r3 = this.a.f;
        if (r3 == null) goto L6;
        r3.setVisibility(0);
        return;
    }
}
