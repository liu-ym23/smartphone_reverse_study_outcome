package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.v0;
import androidx.appcompat.widget.y;
import com.google.android.material.internal.CheckableImageButton;
import com.obric.cae.R;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
public final class v extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f5123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f5124b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f5125m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CheckableImageButton f5126n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ColorStateList f5127o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public PorterDuff.Mode f5128p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f5129q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView.ScaleType f5130r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View.OnLongClickListener f5131s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f5132t;

    public v(TextInputLayout r10, v0 r11) {
        super(r10.getContext());
        this.f5123a = r10;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton r8 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, this, false);
        this.f5126n = r8;
        CharSequence r12 = null;
        y r13 = new y(getContext(), null);
        this.f5124b = r13;
        if (x9.c.d(getContext()) == false) goto L5;
        j0.f.g((ViewGroup.MarginLayoutParams) r8.getLayoutParams(), 0);
    L5:
        View.OnLongClickListener r14 = this.f5131s;
        r8.setOnClickListener(null);
        o.d(r8, r14);
        this.f5131s = null;
        r8.setOnLongClickListener(null);
        o.d(r8, null);
        if (r11.l(69) == false) goto L9;
        this.f5127o = x9.c.b(getContext(), r11, 69);
    L9:
        if (r11.l(70) == false) goto L12;
        this.f5128p = com.google.android.material.internal.q.b(r11.h(70, -1), null);
    L12:
        if (r11.l(66) == false) goto L19;
        b(r11.e(66));
        if (r11.l(65) == false) goto L18;
        CharSequence r15 = r11.k(65);
        if (r8.getContentDescription() == r15) goto L18;
        r8.setContentDescription(r15);
    L18:
        r8.setCheckable(r11.a(64, true));
    L19:
        int r16 = r11.d(67, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (r16 < 0) goto L37;
        if (r16 == this.f5129q) goto L25;
        this.f5129q = r16;
        r8.setMinimumWidth(r16);
        r8.setMinimumHeight(r16);
    L25:
        if (r11.l(68) == false) goto L27;
        ImageView.ScaleType r17 = o.b(r11.h(68, -1));
        this.f5130r = r17;
        r8.setScaleType(r17);
    L27:
        r13.setVisibility(8);
        r13.setId(R.id.textinput_prefix_text);
        r13.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        WeakHashMap<View, h0> r18 = w.f8437a;
        w.g.f(r13, 1);
        r13.setTextAppearance(r11.i(60, 0));
        if (r11.l(61) == false) goto L30;
        r13.setTextColor(r11.b(61));
    L30:
        CharSequence r19 = r11.k(59);
        if (TextUtils.isEmpty(r19) == true) goto L34;
        r12 = r19;
    L34:
        this.f5125m = r12;
        r13.setText(r19);
        e();
        addView(r8);
        addView(r13);
        return;
    L37:
        throw new IllegalArgumentException("startIconSize cannot be less than 0");
    }

    public final int a() {
        CheckableImageButton r8 = this.f5126n;
        int r10 = 0;
        if (r8.getVisibility() != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        r10 = j0.f.b((ViewGroup.MarginLayoutParams) r8.getLayoutParams()) + r8.getMeasuredWidth();
    L8:
        WeakHashMap<View, h0> r12 = w.f8437a;
        return (w.e.f(this.f5124b) + w.e.f(this)) + r10;
    L5:
        r11 = false;
        goto L6
    }

    public final void b(Drawable r8) {
        CheckableImageButton r10 = this.f5126n;
        r10.setImageDrawable(r8);
        if (r8 == null) goto L5;
        ColorStateList r11 = this.f5127o;
        PorterDuff.Mode r12 = this.f5128p;
        TextInputLayout r13 = this.f5123a;
        o.a(r13, r10, r11, r12);
        c(true);
        o.c(r13, r10, this.f5127o);
        return;
    L5:
        c(false);
        View.OnLongClickListener r14 = this.f5131s;
        r10.setOnClickListener(null);
        o.d(r10, r14);
        this.f5131s = null;
        r10.setOnLongClickListener(null);
        o.d(r10, null);
        if (r10.getContentDescription() == null) goto L10;
        r10.setContentDescription(null);
        return;
    }

    public final void c(boolean r8) {
        CheckableImageButton r10 = this.f5126n;
        int r11 = 0;
        if (r10.getVisibility() != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == r8) goto L12;
        if (r8 == true) goto L10;
        r11 = 8;
    L10:
        r10.setVisibility(r11);
        d();
        e();
        return;
    L12:
        return;
    L5:
        r12 = false;
        goto L6
    }

    public final void d() {
        EditText r8 = this.f5123a.f4984n;
        if (r8 != null) goto L5;
        return;
    L5:
        int r10 = 0;
        if (this.f5126n.getVisibility() != 0) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == true) goto L12;
        WeakHashMap<View, h0> r12 = w.f8437a;
        r10 = w.e.f(r8);
    L12:
        int r13 = r8.getCompoundPaddingTop();
        int r14 = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int r15 = r8.getCompoundPaddingBottom();
        WeakHashMap<View, h0> r16 = w.f8437a;
        w.e.k(this.f5124b, r10, r13, r14, r15);
        return;
    L8:
        r11 = false;
        goto L9
    }

    public final void e() {
        int r8 = 8;
        if (this.f5125m != null) goto L5;
    L7:
        int r10 = 8;
    L9:
        if (this.f5126n.getVisibility() == 0) goto L13;
        if (r10 == 0) goto L13;
        boolean r11 = false;
    L14:
        if (r11 == false) goto L16;
        r8 = 0;
    L16:
        setVisibility(r8);
        this.f5124b.setVisibility(r10);
        this.f5123a.r();
        return;
    L13:
        r11 = true;
        goto L14
    L5:
        if (this.f5132t == true) goto L7;
        r10 = 0;
        goto L9
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
        d();
    }
}
