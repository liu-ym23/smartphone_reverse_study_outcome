package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextInputLayout f4169b;
    private LinearLayout c;
    private int d;
    private FrameLayout e;
    private Animator f;
    private final float g;
    private int h;
    private int i;
    private CharSequence j;
    private boolean k;
    private TextView l;
    private CharSequence m;
    private int n;
    private ColorStateList o;
    private CharSequence p;
    private boolean q;
    private TextView r;
    private int s;
    private ColorStateList t;
    private Typeface u;

    public f(TextInputLayout r4) {
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f4168a = r0;
        this.f4169b = r4;
        this.g = ZeusTransformUtils.getResources(r0, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_textinput_caption_translate_y, "dimen", "design_textinput_caption_translate_y"));
    }

    static /* synthetic */ int a(f r0, int r1) {
        r0.h = r1;
        return r1;
    }

    private int a(boolean r1, int r2, int r3) {
        if (r1 == true) goto L4;
        return r3;
    L4:
        return ZeusTransformUtils.getResources(this.f4168a, "com.obric.memorydata.plugin").getDimensionPixelSize(r2);
    }

    static /* synthetic */ Animator a(f r0, Animator r1) {
        r0.f = r1;
        return r1;
    }

    private ObjectAnimator a(TextView r4) {
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r4, View.TRANSLATION_Y, new float[]{-this.g, 0.0f});
        r3.setDuration(217);
        r3.setInterpolator(com.google.android.material.a.a.d);
        return r3;
    }

    private ObjectAnimator a(TextView r3, boolean r4) {
        if (r4 == false) goto L4;
        float r2 = 1.0f;
    L5:
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r3, View.ALPHA, new float[]{r2});
        r5.setDuration(167);
        r5.setInterpolator(com.google.android.material.a.a.f3741a);
        return r5;
    L4:
        r2 = 0.0f;
        goto L5
    }

    static /* synthetic */ TextView a(f r0) {
        return r0.l;
    }

    private void a(int r3, int r4) {
        if (r3 != r4) goto L4;
        return;
    L4:
        if (r4 == 0) goto L8;
        TextView r0 = d(r4);
        if (r0 == null) goto L8;
        r0.setVisibility(0);
        r0.setAlpha(1.0f);
    L8:
        if (r3 == 0) goto L14;
        TextView r1 = d(r3);
        if (r1 == null) goto L14;
        r1.setVisibility(4);
        if (r3 != 1) goto L14;
        r1.setText(null);
    L14:
        this.h = r4;
    }

    private void a(final int r14, final int r15, boolean r16) {
        if (r14 != r15) goto L5;
        return;
    L5:
        if (r16 == false) goto L7;
        AnimatorSet r11 = new AnimatorSet();
        this.f = r11;
        ArrayList r12 = new ArrayList();
        a(r12, this.q, this.r, 2, r14, r15);
        a(r12, this.k, this.l, 1, r14, r15);
        com.google.android.material.a.b.a(r11, r12);
        final TextView r3 = d(r14);
        final TextView r5 = d(r15);
        r11.addListener(new AnonymousClass1(this, r15, r3, r14, r5));
        r11.start();
    L8:
        this.f4169b.c();
        this.f4169b.a(r16);
        this.f4169b.i();
        return;
    L7:
        a(r14, r15);
        goto L8
    }

    private void a(ViewGroup r1, int r2) {
        if (r2 != 0) goto L5;
        r1.setVisibility(8);
        return;
    }

    private void a(TextView r1, Typeface r2) {
        if (r1 == null) goto L5;
        r1.setTypeface(r2);
        return;
    }

    private void a(List<Animator> r3, boolean r4, TextView r5, int r6, int r7, int r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L15;
        if (r4 == false) goto L18;
        if (r6 == r8) goto L8;
        if (r6 == r7) goto L8;
        return;
    L8:
        if (r8 != r6) goto L10;
        boolean r10 = true;
    L11:
        r9.add(a(r5, r10));
        if (r8 != r6) goto L17;
        r9.add(a(r5));
        return;
    L17:
        return;
    L10:
        r10 = false;
        goto L11
    L18:
        return;
    }

    private boolean a(TextView r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (ViewCompat.isLaidOut(this.f4169b) == true) goto L5;
    L12:
        return false;
    L5:
        if (this.f4169b.isEnabled() == false) goto L12;
        if (this.i != this.h) goto L11;
        if (r3 == null) goto L11;
        if (TextUtils.equals(r3.getText(), r5) == true) goto L12;
    L11:
        return true;
    }

    static /* synthetic */ TextInputLayout b(f r0) {
        return r0.f4169b;
    }

    private TextView d(int r2) {
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L9;
        return null;
    L9:
        return this.r;
    L11:
        return this.l;
    }

    private boolean e(int r2) {
        if (r2 == 1) goto L5;
    L9:
        return false;
    L5:
        if (this.l == null) goto L9;
        if (TextUtils.isEmpty(this.j) == true) goto L9;
        return true;
    }

    private boolean o() {
        if (this.c != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f4169b.getEditText() == null) goto L7;
        return true;
    }

    void a() {
        c();
        int r0 = this.h;
        if (r0 != 2) goto L5;
        this.i = 0;
    L5:
        a(r0, this.i, a(this.r, ""));
    }

    void a(ColorStateList r1) {
        this.o = r1;
        TextView r0 = this.l;
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        r0.setTextColor(r1);
        return;
    L8:
        return;
    }

    void a(Typeface r2) {
        if (r2 == this.u) goto L6;
        this.u = r2;
        a(this.l, r2);
        a(this.r, r2);
        return;
    }

    void a(TextView r6, int r7) {
        if (this.c != null) goto L10;
        if (this.e != null) goto L10;
        LinearLayout r0 = new LinearLayout(this.f4168a);
        this.c = r0;
        r0.setOrientation(0);
        this.f4169b.addView(this.c, -1, -2);
        this.e = new FrameLayout(this.f4168a);
        this.c.addView(this.e, new LinearLayout.LayoutParams(0, -2, 1.0f));
        if (this.f4169b.getEditText() == null) goto L10;
        d();
    L10:
        if (a(r7) == false) goto L12;
        this.e.setVisibility(0);
        this.e.addView(r6);
    L13:
        this.c.setVisibility(0);
        this.d++;
        return;
    L12:
        this.c.addView(r6, new LinearLayout.LayoutParams(-2, -2));
        goto L13
    }

    void a(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        c();
        this.p = r5;
        this.r.setText(r5);
        int r0 = this.h;
        if (r0 == 2) goto L5;
        this.i = 2;
    L5:
        a(r0, this.i, a(this.r, r5));
    }

    void a(boolean r6) {
        if (this.k != r6) goto L5;
        return;
    L5:
        c();
        if (r6 == false) goto L14;
        AppCompatTextView r1 = new AppCompatTextView(this.f4168a);
        this.l = r1;
        r1.setId(ZeusTransformUtils.mapRes(R.id.textinput_error, OaidModel.KEY_ID, "textinput_error"));
        if (Build.VERSION.SDK_INT < 17) goto L10;
        this.l.setTextAlignment(5);
    L10:
        Typeface r2 = this.u;
        if (r2 == null) goto L13;
        this.l.setTypeface(r2);
    L13:
        b(this.n);
        a(this.o);
        c(this.m);
        this.l.setVisibility(4);
        ViewCompat.setAccessibilityLiveRegion(this.l, 1);
        a(this.l, 0);
    L15:
        this.k = r6;
        return;
    L14:
        b();
        b(this.l, 0);
        this.l = null;
        this.f4169b.c();
        this.f4169b.i();
        goto L15
    }

    boolean a(int r1) {
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    void b() {
        this.j = null;
        c();
        if (this.h == 1) goto L5;
    L11:
        a(this.h, this.i, a(this.l, ""));
        return;
    L5:
        if (this.q == true) goto L7;
    L9:
        int r0 = 0;
    L10:
        this.i = r0;
        goto L11
    L7:
        if (TextUtils.isEmpty(this.p) == true) goto L9;
        r0 = 2;
        goto L10
    }

    void b(int r2) {
        this.n = r2;
        TextView r0 = this.l;
        if (r0 == null) goto L6;
        this.f4169b.a(r0, r2);
        return;
    }

    void b(ColorStateList r1) {
        this.t = r1;
        TextView r0 = this.r;
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        r0.setTextColor(r1);
        return;
    L8:
        return;
    }

    void b(TextView r2, int r3) {
        if (this.c != null) goto L6;
        return;
    L6:
        if (a(r3) == false) goto L10;
        FrameLayout r4 = this.e;
        if (r4 == null) goto L10;
        r4.removeView(r2);
    L11:
        int r5 = this.d - 1;
        this.d = r5;
        a(this.c, r5);
        return;
    L10:
        this.c.removeView(r2);
        goto L11
    }

    void b(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        c();
        this.j = r5;
        this.l.setText(r5);
        int r0 = this.h;
        if (r0 == 1) goto L5;
        this.i = 1;
    L5:
        a(r0, this.i, a(this.l, r5));
    }

    void b(boolean r6) {
        if (this.q != r6) goto L5;
        return;
    L5:
        c();
        if (r6 == false) goto L16;
        AppCompatTextView r1 = new AppCompatTextView(this.f4168a);
        this.r = r1;
        r1.setId(ZeusTransformUtils.mapRes(R.id.textinput_helper_text, OaidModel.KEY_ID, "textinput_helper_text"));
        if (Build.VERSION.SDK_INT < 17) goto L10;
        this.r.setTextAlignment(5);
    L10:
        Typeface r2 = this.u;
        if (r2 == null) goto L13;
        this.r.setTypeface(r2);
    L13:
        this.r.setVisibility(4);
        ViewCompat.setAccessibilityLiveRegion(this.r, 1);
        c(this.s);
        b(this.t);
        a(this.r, 1);
        if (Build.VERSION.SDK_INT < 17) goto L17;
        this.r.setAccessibilityDelegate(new AnonymousClass2(this));
    L17:
        this.q = r6;
        return;
    L16:
        a();
        b(this.r, 1);
        this.r = null;
        this.f4169b.c();
        this.f4169b.i();
        goto L17
    }

    void c() {
        Animator r0 = this.f;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    void c(int r1) {
        this.s = r1;
        TextView r0 = this.r;
        if (r0 == null) goto L6;
        TextViewCompat.setTextAppearance(r0, r1);
        return;
    }

    void c(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.m = r4;
        TextView r2 = this.l;
        if (r2 == null) goto L6;
        r2.setContentDescription(r4);
        return;
    }

    void d() {
        if (o() == false) goto L6;
        EditText r0 = this.f4169b.getEditText();
        boolean r1 = com.google.android.material.resources.c.a(this.f4168a);
        ViewCompat.setPaddingRelative(this.c, a(r1, ZeusTransformUtils.mapRes(R.dimen.material_helper_text_font_1_3_padding_horizontal, "dimen", "material_helper_text_font_1_3_padding_horizontal"), ViewCompat.getPaddingStart(r0)), a(r1, ZeusTransformUtils.mapRes(R.dimen.material_helper_text_font_1_3_padding_top, "dimen", "material_helper_text_font_1_3_padding_top"), ZeusTransformUtils.getResources(this.f4168a, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.material_helper_text_default_padding_top, "dimen", "material_helper_text_default_padding_top"))), a(r1, ZeusTransformUtils.mapRes(R.dimen.material_helper_text_font_1_3_padding_horizontal, "dimen", "material_helper_text_font_1_3_padding_horizontal"), ViewCompat.getPaddingEnd(r0)), 0);
        return;
    }

    boolean e() {
        return this.k;
    }

    boolean f() {
        return this.q;
    }

    View g() {
        return this.r;
    }

    boolean h() {
        return e(this.i);
    }

    CharSequence i() {
        return this.j;
    }

    CharSequence j() {
        return this.p;
    }

    int k() {
        TextView r0 = this.l;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getCurrentTextColor();
    }

    ColorStateList l() {
        TextView r0 = this.l;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTextColors();
    }

    CharSequence m() {
        return this.m;
    }

    int n() {
        TextView r0 = this.r;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getCurrentTextColor();
    }
}
