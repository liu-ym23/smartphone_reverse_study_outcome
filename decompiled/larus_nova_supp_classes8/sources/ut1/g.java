package ut1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.livesdk.drawer.LiveDrawerDialog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g extends AnimatorListenerAdapter {
    public final /* synthetic */ LiveDrawerDialog a;

    public g(LiveDrawerDialog r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        this.a.K.setVisibility(8);
        this.a.L.setVisibility(8);
    }
}
