package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class a extends d {
    private final TextWatcher e;
    private final View.OnFocusChangeListener f;
    private final TextInputLayout.a g;
    private final TextInputLayout.b h;
    private AnimatorSet i;
    private ValueAnimator j;

    a(TextInputLayout r1, int r2) {
        super(r1, r2);
        this.e = new AnonymousClass1(this);
        this.f = new AnonymousClass2(this);
        this.g = new AnonymousClass3(this);
        this.h = new AnonymousClass4(this);
    }

    private ValueAnimator a(float... r3) {
        ValueAnimator r4 = ValueAnimator.ofFloat(r3);
        r4.setInterpolator(com.google.android.material.a.a.f3741a);
        r4.setDuration(100);
        r4.addUpdateListener(new AnonymousClass8(this));
        return r4;
    }

    static /* synthetic */ void a(a r0, boolean r1) {
        r0.b(r1);
    }

    static /* synthetic */ boolean a(a r0) {
        return r0.e();
    }

    static /* synthetic */ View.OnFocusChangeListener b(a r0) {
        return r0.f;
    }

    private void b(boolean r3) {
        if (this.f4166a.f() != r3) goto L5;
        boolean r0 = true;
    L6:
        if (r3 == true) goto L8;
    L12:
        if (r3 == true) goto L19;
        this.i.cancel();
        this.j.start();
        if (r0 == false) goto L20;
        this.j.end();
        return;
    L20:
        return;
    L19:
        return;
    L8:
        if (this.i.isRunning() == true) goto L12;
        this.j.cancel();
        this.i.start();
        if (r0 == false) goto L17;
        this.i.end();
        return;
    L17:
        return;
    L5:
        r0 = false;
        goto L6
    }

    static /* synthetic */ TextWatcher c(a r0) {
        return r0.e;
    }

    private void c() {
        ValueAnimator r0 = d();
        ValueAnimator r2 = a(new float[]{0.0f, 1.0f});
        AnimatorSet r3 = new AnimatorSet();
        this.i = r3;
        r3.playTogether(new Animator[]{r0, r2});
        this.i.addListener(new AnonymousClass6(this));
        ValueAnimator r1 = a(new float[]{1.0f, 0.0f});
        this.j = r1;
        r1.addListener(new AnonymousClass7(this));
    }

    private ValueAnimator d() {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        r0.setInterpolator(com.google.android.material.a.a.d);
        r0.setDuration(150);
        r0.addUpdateListener(new AnonymousClass9(this));
        return r0;
    }

    private boolean e() {
        EditText r0 = this.f4166a.getEditText();
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.hasFocus() == true) goto L9;
        if (this.c.hasFocus() == false) goto L11;
    L9:
        if (r0.getText().length() <= 0) goto L11;
        return true;
    }

    @Override // com.google.android.material.textfield.d
    void a() {
        TextInputLayout r0 = this.f4166a;
        if (this.d != 0) goto L5;
        int r1 = ZeusTransformUtils.mapRes(R.drawable.mtrl_ic_cancel, "drawable", "mtrl_ic_cancel");
    L6:
        r0.setEndIconDrawable(r1);
        this.f4166a.setEndIconContentDescription(ZeusTransformUtils.getResources(this.f4166a, "com.obric.memorydata.plugin").getText(ZeusTransformUtils.mapRes(R.string.clear_text_end_icon_content_description, TypedValues.Custom.S_STRING, "clear_text_end_icon_content_description")));
        this.f4166a.setEndIconCheckable(false);
        this.f4166a.setEndIconOnClickListener(new AnonymousClass5(this));
        this.f4166a.a(this.g);
        this.f4166a.a(this.h);
        c();
        return;
    L5:
        r1 = this.d;
        goto L6
    }

    @Override // com.google.android.material.textfield.d
    void a(boolean r2) {
        if (this.f4166a.getSuffixText() != null) goto L5;
        return;
    L5:
        b(r2);
    }
}
