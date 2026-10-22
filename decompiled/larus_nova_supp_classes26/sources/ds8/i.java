package ds8;

import android.animation.Animator;
import com.larus.bmhome.top.ChatTopFloatingButtonComponent;
import com.larus.chat.core.impl.databinding.LarusPageChatTopFloatingButtonBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i implements Animator.AnimatorListener {
    public final /* synthetic */ LarusPageChatTopFloatingButtonBinding a;
    public final /* synthetic */ ChatTopFloatingButtonComponent b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.a.setVisibility(8);
        this.a.b.setVisibility(8);
        ChatTopFloatingButtonComponent r3 = this.b;
        int r0 = ChatTopFloatingButtonComponent.z;
        r3.getClass();
        this.a.a.setClipToOutline(false);
    }

    public i(LarusPageChatTopFloatingButtonBinding r1, ChatTopFloatingButtonComponent r2) {
        this.a = r1;
        this.b = r2;
    }
}
