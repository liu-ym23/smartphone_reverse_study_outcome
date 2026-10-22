package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final TextInputLayout f3978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinearLayout f3979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FrameLayout f3981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Animator f3982f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f3983g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3984h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3985i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private CharSequence f3986j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3987k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private TextView f3988l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private CharSequence f3989m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f3990n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private ColorStateList f3991o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f3992p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f3993q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private TextView f3994r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f3995s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private ColorStateList f3996t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Typeface f3997u;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3998c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ TextView f3999g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f4000h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ TextView f4001i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ e f4002j;

        a(e r10, int r11, TextView r12, int r13, TextView r14) {
            this.f4002j = r10;
            this.f3998c = r11;
            this.f3999g = r12;
            this.f4000h = r13;
            this.f4001i = r14;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            e.a(this.f4002j, this.f3998c);
            e.b(this.f4002j, null);
            TextView r11 = this.f3999g;
            if (r11 == null) goto L9;
            r11.setVisibility(4);
            if (this.f4000h != 1) goto L9;
            if (e.c(this.f4002j) == null) goto L9;
            e.c(this.f4002j).setText(null);
        L9:
            TextView r12 = this.f4001i;
            if (r12 == null) goto L13;
            r12.setTranslationY(0.0f);
            this.f4001i.setAlpha(1.0f);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            TextView r11 = this.f4001i;
            if (r11 == null) goto L6;
            r11.setVisibility(0);
            return;
        }
    }

    class b extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f4003a;

        b(e r10) {
            this.f4003a = r10;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfo r11) {
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            EditText r12 = e.d(this.f4003a).getEditText();
            if (r12 == null) goto L6;
            r11.setLabeledBy(r12);
            return;
        }
    }

    public e(@NonNull TextInputLayout r10) {
        Context r11 = r10.getContext();
        this.f3977a = r11;
        this.f3978b = r10;
        this.f3983g = r11.getResources().getDimensionPixelSize(q5.d.design_textinput_caption_translate_y);
    }

    private void C(int r10, int r11) {
        if (r10 != r11) goto L4;
        return;
    L4:
        if (r11 == 0) goto L8;
        TextView r12 = m(r11);
        if (r12 == null) goto L8;
        r12.setVisibility(0);
        r12.setAlpha(1.0f);
    L8:
        if (r10 == 0) goto L14;
        TextView r13 = m(r10);
        if (r13 == null) goto L14;
        r13.setVisibility(4);
        if (r10 != 1) goto L14;
        r13.setText(null);
    L14:
        this.f3984h = r11;
    }

    private void K(@Nullable TextView r10, Typeface r11) {
        if (r10 == null) goto L5;
        r10.setTypeface(r11);
        return;
    }

    private void M(@NonNull ViewGroup r10, int r11) {
        if (r11 != 0) goto L5;
        r10.setVisibility(8);
        return;
    }

    private boolean N(@Nullable TextView r10, @NonNull CharSequence r11) {
        if (ViewCompat.isLaidOut(this.f3978b) == true) goto L5;
    L12:
        return false;
    L5:
        if (this.f3978b.isEnabled() == false) goto L12;
        if (this.f3985i != this.f3984h) goto L11;
        if (r10 == null) goto L11;
        if (TextUtils.equals(r10.getText(), r11) == true) goto L12;
    L11:
        return true;
    }

    private void Q(int r14, int r15, boolean r16) {
        if (r14 != r15) goto L5;
        return;
    L5:
        if (r16 == false) goto L7;
        AnimatorSet r11 = new AnimatorSet();
        this.f3982f = r11;
        ArrayList r12 = new ArrayList();
        i(r12, this.f3993q, this.f3994r, 2, r14, r15);
        i(r12, this.f3987k, this.f3988l, 1, r14, r15);
        r5.b.a(r11, r12);
        r11.addListener(new a(this, r15, m(r14), r14, m(r15)));
        r11.start();
    L8:
        this.f3978b.r0();
        this.f3978b.w0(r16);
        this.f3978b.E0();
        return;
    L7:
        C(r14, r15);
        goto L8
    }

    static /* synthetic */ int a(e r10, int r11) {
        r10.f3984h = r11;
        return r11;
    }

    static /* synthetic */ Animator b(e r10, Animator r11) {
        r10.f3982f = r11;
        return r11;
    }

    static /* synthetic */ TextView c(e r10) {
        return r10.f3988l;
    }

    static /* synthetic */ TextInputLayout d(e r10) {
        return r10.f3978b;
    }

    private boolean g() {
        if (this.f3979c != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f3978b.getEditText() == null) goto L7;
        return true;
    }

    private void i(@NonNull List<Animator> r10, boolean r11, @Nullable TextView r12, int r13, int r14, int r15) {
        if (r12 == null) goto L14;
        if (r11 == false) goto L17;
        if (r13 == r15) goto L7;
        if (r13 == r14) goto L7;
        return;
    L7:
        if (r15 != r13) goto L9;
        boolean r16 = true;
    L10:
        r10.add(j(r12, r16));
        if (r15 != r13) goto L16;
        r10.add(k(r12));
        return;
    L16:
        return;
    L9:
        r16 = false;
        goto L10
    L17:
        return;
    }

    private ObjectAnimator j(TextView r10, boolean r11) {
        if (r11 == false) goto L4;
        float r12 = 1.0f;
    L5:
        ObjectAnimator r13 = ObjectAnimator.ofFloat(r10, View.ALPHA, new float[]{r12});
        r13.setDuration(167);
        r13.setInterpolator(r5.a.f12673a);
        return r13;
    L4:
        r12 = 0.0f;
        goto L5
    }

    private ObjectAnimator k(TextView r10) {
        ObjectAnimator r11 = ObjectAnimator.ofFloat(r10, View.TRANSLATION_Y, new float[]{-this.f3983g, 0.0f});
        r11.setDuration(217);
        r11.setInterpolator(r5.a.f12676d);
        return r11;
    }

    @Nullable
    private TextView m(int r10) {
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L9;
        return null;
    L9:
        return this.f3994r;
    L11:
        return this.f3988l;
    }

    private int u(boolean r10, @DimenRes int r11, int r12) {
        if (r10 == true) goto L4;
        return r12;
    L4:
        return this.f3977a.getResources().getDimensionPixelSize(r11);
    }

    private boolean x(int r10) {
        if (r10 == 1) goto L5;
    L9:
        return false;
    L5:
        if (this.f3988l == null) goto L9;
        if (TextUtils.isEmpty(this.f3986j) == true) goto L9;
        return true;
    }

    boolean A() {
        return this.f3993q;
    }

    void B(TextView r10, int r11) {
        if (this.f3979c != null) goto L6;
        return;
    L6:
        if (y(r11) == false) goto L10;
        FrameLayout r12 = this.f3981e;
        if (r12 == null) goto L10;
        r12.removeView(r10);
    L11:
        int r13 = this.f3980d - 1;
        this.f3980d = r13;
        M(this.f3979c, r13);
        return;
    L10:
        this.f3979c.removeView(r10);
        goto L11
    }

    void D(@Nullable CharSequence r10) {
        this.f3989m = r10;
        TextView r11 = this.f3988l;
        if (r11 == null) goto L6;
        r11.setContentDescription(r10);
        return;
    }

    void E(boolean r10) {
        if (this.f3987k != r10) goto L5;
        return;
    L5:
        h();
        if (r10 == false) goto L14;
        AppCompatTextView r11 = new AppCompatTextView(this.f3977a);
        this.f3988l = r11;
        r11.setId(q5.f.textinput_error);
        if (Build.VERSION.SDK_INT < 17) goto L10;
        this.f3988l.setTextAlignment(5);
    L10:
        Typeface r12 = this.f3997u;
        if (r12 == null) goto L13;
        this.f3988l.setTypeface(r12);
    L13:
        F(this.f3990n);
        G(this.f3991o);
        D(this.f3989m);
        this.f3988l.setVisibility(4);
        ViewCompat.setAccessibilityLiveRegion(this.f3988l, 1);
        e(this.f3988l, 0);
    L15:
        this.f3987k = r10;
        return;
    L14:
        v();
        B(this.f3988l, 0);
        this.f3988l = null;
        this.f3978b.r0();
        this.f3978b.E0();
        goto L15
    }

    void F(@StyleRes int r10) {
        this.f3990n = r10;
        TextView r11 = this.f3988l;
        if (r11 == null) goto L6;
        this.f3978b.d0(r11, r10);
        return;
    }

    void G(@Nullable ColorStateList r10) {
        this.f3991o = r10;
        TextView r11 = this.f3988l;
        if (r11 == null) goto L7;
        if (r10 == null) goto L8;
        r11.setTextColor(r10);
        return;
    L8:
        return;
    }

    void H(@StyleRes int r10) {
        this.f3995s = r10;
        TextView r11 = this.f3994r;
        if (r11 == null) goto L6;
        TextViewCompat.setTextAppearance(r11, r10);
        return;
    }

    void I(boolean r10) {
        if (this.f3993q != r10) goto L5;
        return;
    L5:
        h();
        if (r10 == false) goto L16;
        AppCompatTextView r11 = new AppCompatTextView(this.f3977a);
        this.f3994r = r11;
        r11.setId(q5.f.textinput_helper_text);
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 17) goto L10;
        this.f3994r.setTextAlignment(5);
    L10:
        Typeface r13 = this.f3997u;
        if (r13 == null) goto L13;
        this.f3994r.setTypeface(r13);
    L13:
        this.f3994r.setVisibility(4);
        ViewCompat.setAccessibilityLiveRegion(this.f3994r, 1);
        H(this.f3995s);
        J(this.f3996t);
        e(this.f3994r, 1);
        if (r12 < 17) goto L17;
        this.f3994r.setAccessibilityDelegate(new b(this));
    L17:
        this.f3993q = r10;
        return;
    L16:
        w();
        B(this.f3994r, 1);
        this.f3994r = null;
        this.f3978b.r0();
        this.f3978b.E0();
        goto L17
    }

    void J(@Nullable ColorStateList r10) {
        this.f3996t = r10;
        TextView r11 = this.f3994r;
        if (r11 == null) goto L7;
        if (r10 == null) goto L8;
        r11.setTextColor(r10);
        return;
    L8:
        return;
    }

    void L(Typeface r10) {
        if (r10 == this.f3997u) goto L6;
        this.f3997u = r10;
        K(this.f3988l, r10);
        K(this.f3994r, r10);
        return;
    }

    void O(CharSequence r10) {
        h();
        this.f3986j = r10;
        this.f3988l.setText(r10);
        int r11 = this.f3984h;
        if (r11 == 1) goto L5;
        this.f3985i = 1;
    L5:
        Q(r11, this.f3985i, N(this.f3988l, r10));
    }

    void P(CharSequence r10) {
        h();
        this.f3992p = r10;
        this.f3994r.setText(r10);
        int r11 = this.f3984h;
        if (r11 == 2) goto L5;
        this.f3985i = 2;
    L5:
        Q(r11, this.f3985i, N(this.f3994r, r10));
    }

    void e(TextView r10, int r11) {
        if (this.f3979c != null) goto L10;
        if (this.f3981e != null) goto L10;
        LinearLayout r12 = new LinearLayout(this.f3977a);
        this.f3979c = r12;
        r12.setOrientation(0);
        this.f3978b.addView(this.f3979c, -1, -2);
        this.f3981e = new FrameLayout(this.f3977a);
        this.f3979c.addView(this.f3981e, new LinearLayout.LayoutParams(0, -2, 1.0f));
        if (this.f3978b.getEditText() == null) goto L10;
        f();
    L10:
        if (y(r11) == false) goto L12;
        this.f3981e.setVisibility(0);
        this.f3981e.addView(r10);
    L13:
        this.f3979c.setVisibility(0);
        this.f3980d++;
        return;
    L12:
        this.f3979c.addView(r10, new LinearLayout.LayoutParams(-2, -2));
        goto L13
    }

    void f() {
        if (g() == false) goto L6;
        EditText r10 = this.f3978b.getEditText();
        boolean r11 = com.google.android.material.resources.c.i(this.f3977a);
        LinearLayout r12 = this.f3979c;
        int r13 = q5.d.material_helper_text_font_1_3_padding_horizontal;
        ViewCompat.setPaddingRelative(r12, u(r11, r13, ViewCompat.getPaddingStart(r10)), u(r11, q5.d.material_helper_text_font_1_3_padding_top, this.f3977a.getResources().getDimensionPixelSize(q5.d.material_helper_text_default_padding_top)), u(r11, r13, ViewCompat.getPaddingEnd(r10)), 0);
        return;
    }

    void h() {
        Animator r10 = this.f3982f;
        if (r10 == null) goto L6;
        r10.cancel();
        return;
    }

    boolean l() {
        return x(this.f3985i);
    }

    @Nullable
    CharSequence n() {
        return this.f3989m;
    }

    @Nullable
    CharSequence o() {
        return this.f3986j;
    }

    @ColorInt
    int p() {
        TextView r10 = this.f3988l;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getCurrentTextColor();
    }

    @Nullable
    ColorStateList q() {
        TextView r10 = this.f3988l;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getTextColors();
    }

    CharSequence r() {
        return this.f3992p;
    }

    @Nullable
    View s() {
        return this.f3994r;
    }

    @ColorInt
    int t() {
        TextView r10 = this.f3994r;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getCurrentTextColor();
    }

    void v() {
        this.f3986j = null;
        h();
        if (this.f3984h == 1) goto L5;
    L11:
        Q(this.f3984h, this.f3985i, N(this.f3988l, ""));
        return;
    L5:
        if (this.f3993q == true) goto L7;
    L9:
        int r10 = 0;
    L10:
        this.f3985i = r10;
        goto L11
    L7:
        if (TextUtils.isEmpty(this.f3992p) == true) goto L9;
        r10 = 2;
        goto L10
    }

    void w() {
        h();
        int r10 = this.f3984h;
        if (r10 != 2) goto L5;
        this.f3985i = 0;
    L5:
        Q(r10, this.f3985i, N(this.f3994r, ""));
    }

    boolean y(int r10) {
        if (r10 == 0) goto L8;
        if (r10 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    boolean z() {
        return this.f3987k;
    }
}
