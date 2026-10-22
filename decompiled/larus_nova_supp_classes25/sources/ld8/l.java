package ld8;

import android.animation.Animator;
import com.larus.bmhome.chat.component.bottom.floating.BottomFloatingButtonComponent;
import com.larus.bmhome.databinding.LarusPageChatBottomFloatingButtonBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l implements Animator.AnimatorListener {
    public final /* synthetic */ LarusPageChatBottomFloatingButtonBinding a;
    public final /* synthetic */ BottomFloatingButtonComponent b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.b.v = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.a.setVisibility(0);
        this.a.e.setVisibility(0);
        this.a.b.b();
    }

    public l(LarusPageChatBottomFloatingButtonBinding r1, BottomFloatingButtonComponent r2) {
        this.a = r1;
        this.b = r2;
    }
}
