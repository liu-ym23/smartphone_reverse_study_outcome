package com.obric.oui.calendar;

import android.R;
import android.animation.Animator;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f6355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private m9.g f6356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f6358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f6359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Interpolator f6360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f6361g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f6362h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CalendarDay f6363i;

    class a extends com.obric.oui.calendar.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ CharSequence f6364c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f6365g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ n f6366h;

        a(n r10, CharSequence r11, int r12) {
            this.f6366h = r10;
            this.f6364c = r11;
            this.f6365g = r12;
        }

        @Override // com.obric.oui.calendar.a, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            n r11 = this.f6366h;
            n.b(r11, n.a(r11), 0);
            n.a(this.f6366h).setAlpha(1.0f);
        }

        @Override // com.obric.oui.calendar.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            n.a(this.f6366h).setText(this.f6364c);
            n r11 = this.f6366h;
            n.b(r11, n.a(r11), this.f6365g);
            ViewPropertyAnimator r12 = n.a(this.f6366h).animate();
            if (n.c(this.f6366h) != 1) goto L5;
            r12.translationX(0.0f);
        L6:
            r12.alpha(1.0f).setDuration(n.e(this.f6366h)).setInterpolator(n.d(this.f6366h)).setListener(new com.obric.oui.calendar.a()).start();
            return;
        L5:
            r12.translationY(0.0f);
            goto L6
        }
    }

    public n(TextView r10) {
        this.f6356b = m9.g.f11061a;
        this.f6360f = new DecelerateInterpolator(2.0f);
        this.f6361g = 0;
        this.f6362h = 0;
        this.f6363i = null;
        this.f6355a = r10;
        Resources r11 = r10.getResources();
        this.f6357c = 400;
        this.f6358d = r11.getInteger(R.integer.config_shortAnimTime) / 2;
        this.f6359e = (int) TypedValue.applyDimension(1, 20.0f, r11.getDisplayMetrics());
    }

    static /* synthetic */ TextView a(n r10) {
        return r10.f6355a;
    }

    static /* synthetic */ void b(n r10, TextView r11, int r12) {
        r10.h(r11, r12);
    }

    static /* synthetic */ int c(n r10) {
        return r10.f6361g;
    }

    static /* synthetic */ Interpolator d(n r10) {
        return r10.f6360f;
    }

    static /* synthetic */ int e(n r10) {
        return r10.f6358d;
    }

    private void g(long r10, CalendarDay r11, boolean r12) {
        this.f6355a.animate().cancel();
        h(this.f6355a, 0);
        this.f6355a.setAlpha(1.0f);
        this.f6362h = r10;
        CharSequence r13 = this.f6356b.a(r11);
        if (r12 == true) goto L5;
        this.f6355a.setText(r13);
    L14:
        this.f6363i = r11;
        return;
    L5:
        int r14 = this.f6359e;
        if (this.f6363i.isBefore(r11) == false) goto L8;
        int r15 = 1;
    L9:
        int r16 = r14 * r15;
        ViewPropertyAnimator r17 = this.f6355a.animate();
        if (this.f6361g != 1) goto L12;
        r17.translationX(r16 * (-1));
    L13:
        r17.alpha(0.0f).setDuration(this.f6358d).setInterpolator(this.f6360f).setListener(new a(this, r13, r16)).start();
        goto L14
    L12:
        r17.translationY(r16 * (-1));
        goto L13
    L8:
        r15 = -1;
        goto L9
    }

    private void h(TextView r10, int r11) {
        if (this.f6361g != 1) goto L5;
        r10.setTranslationX(r11);
        return;
    L5:
        r10.setTranslationY(r11);
    }

    public void f(CalendarDay r10) {
        long r11 = System.currentTimeMillis();
        if (r10 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.f6355a.getText()) == false) goto L8;
    L9:
        g(r11, r10, false);
    L11:
        if (r10.equals(this.f6363i) == false) goto L13;
        return;
    L13:
        if (r10.getMonth() == this.f6363i.getMonth()) goto L15;
    L17:
        g(r11, r10, true);
        return;
    L15:
        if (r10.getYear() != this.f6363i.getYear()) goto L17;
        return;
    L8:
        if ((r11 - this.f6362h) >= this.f6357c) goto L11;
        goto L9
    }

    public int i() {
        return this.f6361g;
    }

    public void j(int r10) {
        this.f6361g = r10;
    }

    public void k(CalendarDay r10) {
        this.f6363i = r10;
    }

    public void l(@Nullable m9.g r10) {
        if (r10 != null) goto L4;
        r10 = m9.g.f11061a;
    L4:
        this.f6356b = r10;
    }
}
