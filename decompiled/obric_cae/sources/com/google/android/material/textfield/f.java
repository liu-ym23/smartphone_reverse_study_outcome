package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import com.obric.cae.R;
import com.obric.cae.userAware.datacollection.AwareStateListener;

/* JADX INFO: loaded from: classes.dex */
public final class f extends n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f5024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TimeInterpolator f5025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public EditText f5026i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.google.android.material.search.a f5027j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f5028k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AnimatorSet f5029l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ValueAnimator f5030m;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.material.textfield.c] */
    public f(m r8) {
        super(r8);
        this.f5027j = new com.google.android.material.search.a(this, 1);
        this.f5028k = new c(this);
        this.f5022e = v9.d.c(r8.getContext(), R.attr.motionDurationShort3, 100);
        this.f5023f = v9.d.c(r8.getContext(), R.attr.motionDurationShort3, AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD);
        this.f5024g = v9.d.d(r8.getContext(), R.attr.motionEasingLinearInterpolator, h9.a.f7943a);
        this.f5025h = v9.d.d(r8.getContext(), R.attr.motionEasingEmphasizedInterpolator, h9.a.f7946d);
    }

    @Override // com.google.android.material.textfield.n
    public final void a() {
        if (this.f5073b.f5064z == null) goto L5;
        return;
    L5:
        t(u());
    }

    @Override // com.google.android.material.textfield.n
    public final int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // com.google.android.material.textfield.n
    public final int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // com.google.android.material.textfield.n
    public final View.OnFocusChangeListener e() {
        return this.f5028k;
    }

    @Override // com.google.android.material.textfield.n
    public final View.OnClickListener f() {
        return this.f5027j;
    }

    @Override // com.google.android.material.textfield.n
    public final View.OnFocusChangeListener g() {
        return this.f5028k;
    }

    @Override // com.google.android.material.textfield.n
    public final void m(EditText r8) {
        this.f5026i = r8;
        this.f5072a.setEndIconVisible(u());
    }

    @Override // com.google.android.material.textfield.n
    public final void p(boolean r8) {
        if (this.f5073b.f5064z != null) goto L5;
        return;
    L5:
        t(r8);
    }

    @Override // com.google.android.material.textfield.n
    public final void r() {
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        r8.setInterpolator(this.f5025h);
        r8.setDuration(this.f5023f);
        r8.addUpdateListener(new a(this));
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        TimeInterpolator r11 = this.f5024g;
        r10.setInterpolator(r11);
        int r12 = this.f5022e;
        r10.setDuration(r12);
        r10.addUpdateListener(new b(this, 0));
        AnimatorSet r13 = new AnimatorSet();
        this.f5029l = r13;
        r13.playTogether(new Animator[]{r8, r10});
        this.f5029l.addListener(new d(this));
        ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r14.setInterpolator(r11);
        r14.setDuration(r12);
        r14.addUpdateListener(new b(this, 0));
        this.f5030m = r14;
        r14.addListener(new e(this));
    }

    @Override // com.google.android.material.textfield.n
    public final void s() {
        EditText r8 = this.f5026i;
        if (r8 == null) goto L6;
        r8.post(new androidx.activity.k(this, 10));
        return;
    }

    public final void t(boolean r8) {
        if (this.f5073b.d() != r8) goto L5;
        boolean r10 = true;
    L6:
        if (r8 == true) goto L8;
    L12:
        if (r8 == true) goto L19;
        this.f5029l.cancel();
        this.f5030m.start();
        if (r10 == false) goto L20;
        this.f5030m.end();
        return;
    L20:
        return;
    L19:
        return;
    L8:
        if (this.f5029l.isRunning() == true) goto L12;
        this.f5030m.cancel();
        this.f5029l.start();
        if (r10 == false) goto L17;
        this.f5029l.end();
        return;
    L17:
        return;
    L5:
        r10 = false;
        goto L6
    }

    public final boolean u() {
        EditText r8 = this.f5026i;
        if (r8 != null) goto L5;
    L11:
        return false;
    L5:
        if (r8.hasFocus() == true) goto L9;
        if (this.f5075d.hasFocus() == false) goto L11;
    L9:
        if (this.f5026i.getText().length() <= 0) goto L11;
        return true;
    }
}
