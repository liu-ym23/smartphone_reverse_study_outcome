package g1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f7560a;

    public e(d r8) {
        this.f7560a = r8;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r8) {
        d r10 = this.f7560a;
        ArrayList r11 = new ArrayList(r10.f7552o);
        int r12 = r11.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ((c) r11.get(r13)).a(r10);
        r13 = r13 + 1;
        goto L3
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r8) {
        d r10 = this.f7560a;
        ArrayList r11 = new ArrayList(r10.f7552o);
        int r12 = r11.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ((c) r11.get(r13)).b(r10);
        r13 = r13 + 1;
        goto L3
    }
}
