package q19;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.larus.common_ui.refresh.SuperSwipeRefreshLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ SuperSwipeRefreshLayout a;

    public c(SuperSwipeRefreshLayout r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r1) {
        super.onAnimationEnd(r1);
        this.a.c();
    }
}
