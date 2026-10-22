package com.larus.bmhome.chat.immerse;

import android.view.animation.Animation;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.databinding.LarusPageChatImmersiveBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t implements Animation.AnimationListener {
    public final /* synthetic */ ChatImmersFragment a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
    }

    public t(ChatImmersFragment r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r2) {
        LarusPageChatImmersiveBinding r3 = this.a.j;
        if (r3 == null) goto L8;
        ConstraintLayout r4 = r3.f;
        if (r4 == null) goto L9;
        r4.setVisibility(8);
        return;
    L9:
        return;
    }
}
