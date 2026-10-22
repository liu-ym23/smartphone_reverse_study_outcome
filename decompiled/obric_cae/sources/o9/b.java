package o9;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewAnimationUtils;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    /* JADX WARN: Multi-variable type inference failed */
    public static AnimatorSet a(d r8, float r10, float r11, float r12) {
        ObjectAnimator r13 = ObjectAnimator.ofObject(r8, d.b.f9764a, d.a.f9762b, new d.C0130d[]{new d.C0130d(r10, r11, r12)});
        d.C0130d r14 = r8.getRevealInfo();
        if (r14 == null) goto L7;
        View r15 = (View) r8;
        int r16 = (int) r10;
        int r17 = (int) r11;
        Animator r18 = ViewAnimationUtils.createCircularReveal(r15, r16, r17, r14.f9768c, r12);
        AnimatorSet r19 = new AnimatorSet();
        r19.playTogether(new Animator[]{r13, r18});
        return r19;
    L7:
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }
}
