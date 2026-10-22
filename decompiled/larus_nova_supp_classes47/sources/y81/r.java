package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r extends AnimatorListenerAdapter {
    public final /* synthetic */ l a;

    public r(l r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ViewGroup r3 = this.a.l;
        if (r3 == null) goto L5;
        r3.setVisibility(8);
    L5:
        this.a.q();
        this.a.i(0);
        RelativeLayout r4 = this.a.t;
        if (r4 == null) goto L11;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L12;
        r5.width = -2;
        return;
    L12:
        return;
    }
}
