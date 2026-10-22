package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import q5.j;

/* JADX INFO: loaded from: classes.dex */
class a extends com.google.android.material.textfield.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextWatcher f3956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View.OnFocusChangeListener f3957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextInputLayout.e f3958g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TextInputLayout.f f3959h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AnimatorSet f3960i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ValueAnimator f3961j;

    /* JADX INFO: renamed from: com.google.android.material.textfield.a$a, reason: collision with other inner class name */
    class C0087a implements TextWatcher {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f3962c;

        C0087a(a r10) {
            this.f3962c = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable r10) {
            if (this.f3962c.f3973a.getSuffixText() == null) goto L5;
            return;
        L5:
            a r11 = this.f3962c;
            a.f(r11, a.e(r11));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }
    }

    class b implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f3963c;

        b(a r10) {
            this.f3963c = r10;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View r10, boolean r11) {
            a r12 = this.f3963c;
            a.f(r12, a.e(r12));
        }
    }

    class c implements TextInputLayout.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f3964a;

        c(a r10) {
            this.f3964a = r10;
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e
        public void a(@NonNull TextInputLayout r10) {
            EditText r11 = r10.getEditText();
            r10.setEndIconVisible(a.e(this.f3964a));
            r11.setOnFocusChangeListener(a.g(this.f3964a));
            a r12 = this.f3964a;
            r12.f3975c.setOnFocusChangeListener(a.g(r12));
            r11.removeTextChangedListener(a.h(this.f3964a));
            r11.addTextChangedListener(a.h(this.f3964a));
        }
    }

    class d implements TextInputLayout.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f3965a;

        /* JADX INFO: renamed from: com.google.android.material.textfield.a$d$a, reason: collision with other inner class name */
        class RunnableC0088a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ EditText f3966c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ d f3967g;

            RunnableC0088a(d r10, EditText r11) {
                this.f3967g = r10;
                this.f3966c = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f3966c.removeTextChangedListener(a.h(this.f3967g.f3965a));
                a.f(this.f3967g.f3965a, true);
            }
        }

        d(a r10) {
            this.f3965a = r10;
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(@NonNull TextInputLayout r10, int r11) {
            EditText r12 = r10.getEditText();
            if (r12 != null) goto L5;
            return;
        L5:
            if (r11 != 2) goto L14;
            r12.post(new RunnableC0088a(this, r12));
            if (r12.getOnFocusChangeListener() != a.g(this.f3965a)) goto L10;
            r12.setOnFocusChangeListener(null);
        L10:
            if (this.f3965a.f3975c.getOnFocusChangeListener() != a.g(this.f3965a)) goto L15;
            this.f3965a.f3975c.setOnFocusChangeListener(null);
            return;
        L15:
            return;
        }
    }

    class e implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f3968c;

        e(a r10) {
            this.f3968c = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            Editable r11 = this.f3968c.f3973a.getEditText().getText();
            if (r11 == null) goto L5;
            r11.clear();
        L5:
            this.f3968c.f3973a.U();
        }
    }

    class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f3969c;

        f(a r10) {
            this.f3969c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f3969c.f3973a.setEndIconVisible(true);
        }
    }

    class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f3970c;

        g(a r10) {
            this.f3970c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f3970c.f3973a.setEndIconVisible(false);
        }
    }

    class h implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f3971c;

        h(a r10) {
            this.f3971c = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r10) {
            float r11 = ((Float) r10.getAnimatedValue()).floatValue();
            this.f3971c.f3975c.setAlpha(r11);
        }
    }

    class i implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f3972c;

        i(a r10) {
            this.f3972c = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r10) {
            float r11 = ((Float) r10.getAnimatedValue()).floatValue();
            this.f3972c.f3975c.setScaleX(r11);
            this.f3972c.f3975c.setScaleY(r11);
        }
    }

    a(@NonNull TextInputLayout r10, @DrawableRes int r11) {
        super(r10, r11);
        this.f3956e = new C0087a(this);
        this.f3957f = new b(this);
        this.f3958g = new c(this);
        this.f3959h = new d(this);
    }

    static /* synthetic */ boolean e(a r10) {
        return r10.m();
    }

    static /* synthetic */ void f(a r10, boolean r11) {
        r10.i(r11);
    }

    static /* synthetic */ View.OnFocusChangeListener g(a r10) {
        return r10.f3957f;
    }

    static /* synthetic */ TextWatcher h(a r10) {
        return r10.f3956e;
    }

    private void i(boolean r10) {
        if (this.f3973a.K() != r10) goto L5;
        boolean r11 = true;
    L6:
        if (r10 == true) goto L8;
    L12:
        if (r10 == true) goto L19;
        this.f3960i.cancel();
        this.f3961j.start();
        if (r11 == false) goto L20;
        this.f3961j.end();
        return;
    L20:
        return;
    L19:
        return;
    L8:
        if (this.f3960i.isRunning() == true) goto L12;
        this.f3961j.cancel();
        this.f3960i.start();
        if (r11 == false) goto L17;
        this.f3960i.end();
        return;
    L17:
        return;
    L5:
        r11 = false;
        goto L6
    }

    private ValueAnimator j(float... r10) {
        ValueAnimator r11 = ValueAnimator.ofFloat(r10);
        r11.setInterpolator(r5.a.f12673a);
        r11.setDuration(100);
        r11.addUpdateListener(new h(this));
        return r11;
    }

    private ValueAnimator k() {
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        r10.setInterpolator(r5.a.f12676d);
        r10.setDuration(150);
        r10.addUpdateListener(new i(this));
        return r10;
    }

    private void l() {
        ValueAnimator r10 = k();
        ValueAnimator r11 = j(new float[]{0.0f, 1.0f});
        AnimatorSet r12 = new AnimatorSet();
        this.f3960i = r12;
        r12.playTogether(new Animator[]{r10, r11});
        this.f3960i.addListener(new f(this));
        ValueAnimator r13 = j(new float[]{1.0f, 0.0f});
        this.f3961j = r13;
        r13.addListener(new g(this));
    }

    private boolean m() {
        EditText r10 = this.f3973a.getEditText();
        if (r10 != null) goto L5;
    L11:
        return false;
    L5:
        if (r10.hasFocus() == true) goto L9;
        if (this.f3975c.hasFocus() == false) goto L11;
    L9:
        if (r10.getText().length() <= 0) goto L11;
        return true;
    }

    @Override // com.google.android.material.textfield.c
    void a() {
        TextInputLayout r10 = this.f3973a;
        int r11 = this.f3976d;
        if (r11 != 0) goto L5;
        r11 = q5.e.mtrl_ic_cancel;
    L5:
        r10.setEndIconDrawable(r11);
        TextInputLayout r12 = this.f3973a;
        r12.setEndIconContentDescription(r12.getResources().getText(j.clear_text_end_icon_content_description));
        this.f3973a.setEndIconCheckable(false);
        this.f3973a.setEndIconOnClickListener(new e(this));
        this.f3973a.g(this.f3958g);
        this.f3973a.h(this.f3959h);
        l();
    }

    @Override // com.google.android.material.textfield.c
    void c(boolean r10) {
        if (this.f3973a.getSuffixText() != null) goto L5;
        return;
    L5:
        i(r10);
    }
}
