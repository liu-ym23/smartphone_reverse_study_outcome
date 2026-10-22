package ta2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.animator.OptScrollItemAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;
    public final /* synthetic */ RecyclerView.ViewHolder b;
    public final /* synthetic */ int c;
    public final /* synthetic */ ViewPropertyAnimator d;
    public final /* synthetic */ OptScrollItemAnimator e;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        if (this.e.i != 2) goto L6;
        this.a.setLayerType(0, null);
    L6:
        if (this.c == 0) goto L9;
        this.a.setTranslationY(0.0f);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        if (this.e.i != 2) goto L5;
        this.a.setLayerType(0, null);
    L5:
        this.d.setListener(null);
        this.e.dispatchMoveFinished(this.b);
        this.e.g.remove(this.b);
        OptScrollItemAnimator r4 = this.e;
        if (r4.isRunning() == true) goto L9;
        r4.dispatchAnimationsFinished();
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        if (this.e.i != 2) goto L5;
        this.a.setLayerType(2, null);
    L5:
        this.e.dispatchMoveStarting(this.b);
    }

    public b(OptScrollItemAnimator r1, View r2, RecyclerView.ViewHolder r3, int r4, ViewPropertyAnimator r5) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
