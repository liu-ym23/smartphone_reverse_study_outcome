package com.obric.oui.calendar;

import android.R;
import android.animation.Animator;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import com.obric.assistant.interaction.impl.performance.WindowAnimationBoostCoordinator;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class z {
    public final TextView a;
    public mla.g b;
    public final int c;
    public final int d;
    public final int e;
    public final Interpolator f;
    public int g;
    public long h;
    public CalendarDay i;

    public class a extends com.obric.oui.calendar.a {
        public final /* synthetic */ CharSequence a;
        public final /* synthetic */ int b;
        public final /* synthetic */ z c;

        @Override // com.obric.oui.calendar.a, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r3) {
            z r4 = this.c;
            r4.b(r4.a, 0);
            this.c.a.setAlpha(1.0f);
        }

        @Override // com.obric.oui.calendar.a, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            this.c.a.setText(this.a);
            z r5 = this.c;
            r5.b(r5.a, this.b);
            ViewPropertyAnimator r6 = this.c.a.animate();
            if (this.c.g != 1) goto L5;
            r6.translationX(0.0f);
        L6:
            r6.alpha(1.0f).setDuration(this.c.d).setInterpolator(this.c.f).setListener(new com.obric.oui.calendar.a()).start();
            return;
        L5:
            r6.translationY(0.0f);
            goto L6
        }

        public a(z r1, CharSequence r2, int r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public z(TextView r3) {
        this.b = mla.g.a;
        this.f = new DecelerateInterpolator(2.0f);
        this.g = 0;
        this.h = 0;
        this.i = null;
        this.a = r3;
        Resources r4 = r3.getResources();
        this.c = WindowAnimationBoostCoordinator.DEFAULT_WINDOW_ANIMATION_DURATION_MS;
        this.d = r4.getInteger(R.integer.config_shortAnimTime) / 2;
        this.e = (int) TypedValue.applyDimension(1, 20.0f, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()));
    }

    public final void b(TextView r3, int r4) {
        if (this.g != 1) goto L5;
        r3.setTranslationX(r4);
        return;
    L5:
        r3.setTranslationY(r4);
    }

    public final void a(long r3, CalendarDay r5, boolean r6) {
        this.a.animate().cancel();
        b(this.a, 0);
        this.a.setAlpha(1.0f);
        this.h = r3;
        CharSequence r4 = this.b.a(r5);
        if (r6 == true) goto L5;
        this.a.setText(r4);
    L14:
        this.i = r5;
        return;
    L5:
        int r7 = this.e;
        if (this.i.a.isBefore(r5.a) == false) goto L8;
        int r8 = 1;
    L9:
        int r9 = r7 * r8;
        ViewPropertyAnimator r10 = this.a.animate();
        if (this.g != 1) goto L12;
        r10.translationX(r9 * (-1));
    L13:
        r10.alpha(0.0f).setDuration(this.d).setInterpolator(this.f).setListener(new a(this, r4, r9)).start();
        goto L14
    L12:
        r10.translationY(r9 * (-1));
        goto L13
    L8:
        r8 = -1;
        goto L9
    }
}
