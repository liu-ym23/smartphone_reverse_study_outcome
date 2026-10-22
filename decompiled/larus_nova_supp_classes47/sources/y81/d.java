package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends AnimatorListenerAdapter {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ViewGroup r3 = this.a.q;
        if (r3 == null) goto L5;
        r3.setVisibility(8);
    L5:
        this.a.q();
        this.a.i(0);
        RelativeLayout r4 = this.a.u;
        if (r4 == null) goto L11;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L12;
        r5.width = -2;
        return;
    L12:
        return;
    }
}
