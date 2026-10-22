package ld8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m extends AnimatorListenerAdapter {
    public final /* synthetic */ LinearLayout a;

    public m(LinearLayout r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ViewGroup.LayoutParams r3 = this.a.getLayoutParams();
        r3.width = -2;
        this.a.setLayoutParams(r3);
    }
}
