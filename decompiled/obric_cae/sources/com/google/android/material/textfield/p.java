package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.y;
import com.obric.cae.R;
import j0.h0;
import j0.w;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class p {
    public ColorStateList A;
    public Typeface B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f5079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f5080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f5081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f5082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextInputLayout f5083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f5084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f5086k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Animator f5087l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f5088m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5089n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f5090o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f5091p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f5092q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public y f5093r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f5094s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f5095t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f5096u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ColorStateList f5097v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f5098w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f5099x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public y f5100y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f5101z;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f5103b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f5104m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ TextView f5105n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ p f5106o;

        public a(p r8, int r10, TextView r11, int r12, TextView r13) {
            this.f5106o = r8;
            this.f5102a = r10;
            this.f5103b = r11;
            this.f5104m = r12;
            this.f5105n = r13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r8) {
            int r10 = this.f5102a;
            p r11 = this.f5106o;
            r11.f5089n = r10;
            r11.f5087l = null;
            TextView r12 = this.f5103b;
            if (r12 == null) goto L9;
            r12.setVisibility(4);
            if (this.f5104m != 1) goto L9;
            y r13 = r11.f5093r;
            if (r13 == null) goto L9;
            r13.setText(null);
        L9:
            TextView r14 = this.f5105n;
            if (r14 == null) goto L13;
            r14.setTranslationY(0.0f);
            r14.setAlpha(1.0f);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r8) {
            TextView r10 = this.f5105n;
            if (r10 == null) goto L6;
            r10.setVisibility(0);
            r10.setAlpha(0.0f);
            return;
        }
    }

    public p(TextInputLayout r8) {
        Context r10 = r8.getContext();
        this.f5082g = r10;
        this.f5083h = r8;
        this.f5088m = r10.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        this.f5076a = v9.d.c(r10, R.attr.motionDurationShort4, 217);
        this.f5077b = v9.d.c(r10, R.attr.motionDurationMedium4, 167);
        this.f5078c = v9.d.c(r10, R.attr.motionDurationShort4, 167);
        this.f5079d = v9.d.d(r10, R.attr.motionEasingEmphasizedDecelerateInterpolator, h9.a.f7946d);
        LinearInterpolator r11 = h9.a.f7943a;
        this.f5080e = v9.d.d(r10, R.attr.motionEasingEmphasizedDecelerateInterpolator, r11);
        this.f5081f = v9.d.d(r10, R.attr.motionEasingLinearInterpolator, r11);
    }

    public final void a(TextView r8, int r10) {
        if (this.f5084i != null) goto L10;
        if (this.f5086k != null) goto L10;
        Context r11 = this.f5082g;
        LinearLayout r12 = new LinearLayout(r11);
        this.f5084i = r12;
        r12.setOrientation(0);
        LinearLayout r13 = this.f5084i;
        TextInputLayout r14 = this.f5083h;
        r14.addView(r13, -1, -2);
        this.f5086k = new FrameLayout(r11);
        this.f5084i.addView(this.f5086k, new LinearLayout.LayoutParams(0, -2, 1.0f));
        if (r14.getEditText() == null) goto L10;
        b();
    L10:
        if (r10 == 0) goto L14;
        if (r10 == 1) goto L14;
        boolean r15 = false;
    L15:
        if (r15 == false) goto L17;
        this.f5086k.setVisibility(0);
        this.f5086k.addView(r8);
    L18:
        this.f5084i.setVisibility(0);
        this.f5085j++;
        return;
    L17:
        this.f5084i.addView(r8, new LinearLayout.LayoutParams(-2, -2));
    L14:
        r15 = true;
        goto L15
    }

    public final void b() {
        LinearLayout r8 = this.f5084i;
        TextInputLayout r10 = this.f5083h;
        if (r8 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L20;
        EditText r12 = r10.getEditText();
        Context r13 = this.f5082g;
        boolean r14 = x9.c.d(r13);
        LinearLayout r15 = this.f5084i;
        WeakHashMap<View, h0> r16 = w.f8437a;
        int r17 = w.e.f(r12);
        if (r14 == false) goto L12;
        r17 = r13.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
    L12:
        int r18 = r13.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
        if (r14 == false) goto L15;
        r18 = r13.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_top);
    L15:
        int r19 = w.e.e(r12);
        if (r14 == false) goto L18;
        r19 = r13.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
    L18:
        w.e.k(r15, r17, r18, r19, 0);
        return;
    L20:
        return;
    L5:
        if (r10.getEditText() == null) goto L7;
        r11 = true;
        goto L8
    }

    public final void c() {
        Animator r8 = this.f5087l;
        if (r8 == null) goto L6;
        r8.cancel();
        return;
    }

    public final void d(ArrayList r8, boolean r10, TextView r11, int r12, int r13, int r14) {
        if (r11 == null) goto L39;
        if (r10 == true) goto L6;
        return;
    L6:
        if (r12 == r14) goto L10;
        if (r12 == r13) goto L10;
        boolean r15 = false;
    L11:
        if (r15 == false) goto L40;
        if (r14 != r12) goto L14;
        boolean r16 = true;
    L16:
        if (r16 == false) goto L18;
        float r17 = 1.0f;
    L19:
        ObjectAnimator r18 = ObjectAnimator.ofFloat(r11, View.ALPHA, new float[]{r17});
        int r19 = this.f5078c;
        if (r16 == false) goto L22;
        int r20 = this.f5077b;
    L23:
        r18.setDuration(r20);
        if (r16 == false) goto L26;
        TimeInterpolator r21 = this.f5080e;
    L27:
        r18.setInterpolator(r21);
        if (r12 != r14) goto L31;
        if (r13 == 0) goto L31;
        boolean r22 = true;
    L32:
        if (r22 == false) goto L34;
        r18.setStartDelay(r19);
    L34:
        r8.add(r18);
        if (r14 != r12) goto L41;
        if (r13 == 0) goto L42;
        ObjectAnimator r23 = ObjectAnimator.ofFloat(r11, View.TRANSLATION_Y, new float[]{-this.f5088m, 0.0f});
        r23.setDuration(this.f5076a);
        r23.setInterpolator(this.f5079d);
        r23.setStartDelay(r19);
        r8.add(r23);
        return;
    L42:
        return;
    L41:
        return;
    L31:
        r22 = false;
        goto L32
    L26:
        r21 = this.f5081f;
        goto L27
    L22:
        r20 = r19;
        goto L23
    L18:
        r17 = 0.0f;
        goto L19
    L14:
        r16 = false;
        goto L16
    L40:
        return;
    L10:
        r15 = true;
        goto L11
    }

    public final TextView e(int r8) {
        if (r8 == 1) goto L11;
        if (r8 == 2) goto L9;
        return null;
    L9:
        return this.f5100y;
    L11:
        return this.f5093r;
    }

    public final void f() {
        this.f5091p = null;
        c();
        if (this.f5089n == 1) goto L5;
    L11:
        i(this.f5089n, this.f5090o, h(this.f5093r, ""));
        return;
    L5:
        if (this.f5099x == true) goto L7;
    L9:
        int r8 = 0;
    L10:
        this.f5090o = r8;
        goto L11
    L7:
        if (TextUtils.isEmpty(this.f5098w) == true) goto L9;
        r8 = 2;
        goto L10
    }

    public final void g(TextView r8, int r10) {
        LinearLayout r11 = this.f5084i;
        if (r11 != null) goto L5;
        return;
    L5:
        boolean r12 = true;
        if (r10 == 0) goto L10;
        if (r10 == 1) goto L10;
        r12 = false;
    L10:
        if (r12 == false) goto L14;
        FrameLayout r13 = this.f5086k;
        if (r13 == null) goto L14;
        r13.removeView(r8);
    L15:
        int r14 = this.f5085j - 1;
        this.f5085j = r14;
        LinearLayout r15 = this.f5084i;
        if (r14 != 0) goto L19;
        r15.setVisibility(8);
        return;
    L19:
        return;
    L14:
        r11.removeView(r8);
        goto L15
    }

    public final boolean h(TextView r8, CharSequence r10) {
        WeakHashMap<View, h0> r11 = w.f8437a;
        TextInputLayout r12 = this.f5083h;
        if (w.g.c(r12) == true) goto L5;
    L12:
        return false;
    L5:
        if (r12.isEnabled() == false) goto L12;
        if (this.f5090o != this.f5089n) goto L11;
        if (r8 == null) goto L11;
        if (TextUtils.equals(r8.getText(), r10) == true) goto L12;
    L11:
        return true;
    }

    public final void i(int r15, int r16, boolean r17) {
        if (r15 != r16) goto L6;
        return;
    L6:
        if (r17 == false) goto L8;
        AnimatorSet r12 = new AnimatorSet();
        this.f5087l = r12;
        ArrayList r13 = new ArrayList();
        d(r13, this.f5099x, this.f5100y, 2, r15, r16);
        d(r13, this.f5092q, this.f5093r, 1, r15, r16);
        t2.b.R(r12, r13);
        r12.addListener(new a(this, r16, e(r15), r15, e(r16)));
        r12.start();
    L21:
        TextInputLayout r8 = this.f5083h;
        r8.s();
        r8.v(r17, false);
        r8.y();
        return;
    L8:
        if (r15 == r16) goto L21;
        if (r16 == 0) goto L14;
        TextView r10 = e(r16);
        if (r10 == null) goto L14;
        r10.setVisibility(0);
        r10.setAlpha(1.0f);
    L14:
        if (r15 == 0) goto L20;
        TextView r11 = e(r15);
        if (r11 == null) goto L20;
        r11.setVisibility(4);
        if (r15 != 1) goto L20;
        r11.setText(null);
    L20:
        this.f5089n = r16;
        goto L21
    }
}
