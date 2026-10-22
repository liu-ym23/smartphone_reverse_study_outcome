package f1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import j0.h0;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d extends v {

    public static class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f7251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7252b;

        public a(View r8) {
            this.f7252b = false;
            this.f7251a = r8;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r8) {
            o.a r10 = o.f7298a;
            View r11 = this.f7251a;
            r11.setTransitionAlpha(1.0f);
            if (this.f7252b == false) goto L6;
            r11.setLayerType(0, null);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r8) {
            WeakHashMap<View, h0> r10 = j0.w.f8437a;
            View r11 = this.f7251a;
            if (j0.w.d.h(r11) == true) goto L5;
            return;
        L5:
            if (r11.getLayerType() != 0) goto L9;
            this.f7252b = true;
            r11.setLayerType(2, null);
            return;
        }
    }

    public d(int r8) {
        if ((r8 & (-4)) != 0) goto L7;
        this.H = r8;
        return;
    L7:
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public final ObjectAnimator J(View r8, float r10, float r11) {
        if (r10 != r11) goto L6;
        return null;
    L6:
        o.a r12 = o.f7298a;
        r8.setTransitionAlpha(r10);
        ObjectAnimator r13 = ObjectAnimator.ofFloat(r8, o.f7298a, new float[]{r11});
        r13.addListener(new a(r8));
        a(new c(r8));
        return r13;
    }

    @Override // f1.h
    public final void g(n r8) {
        H(r8);
        HashMap r10 = r8.f7295a;
        o.a r11 = o.f7298a;
        r10.put("android:fade:transitionAlpha", Float.valueOf(r8.f7296b.getTransitionAlpha()));
    }
}
