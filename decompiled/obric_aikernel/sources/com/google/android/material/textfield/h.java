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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
class h extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextInputLayout f4013c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextView f4014g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private CharSequence f4015h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final CheckableImageButton f4016i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ColorStateList f4017j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f4018k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View.OnLongClickListener f4019l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f4020m;

    h(TextInputLayout r10, TintTypedArray r11) {
        super(r10.getContext());
        this.f4013c = r10;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        CheckableImageButton r12 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(q5.h.design_text_input_start_icon, this, false);
        this.f4016i = r12;
        AppCompatTextView r13 = new AppCompatTextView(getContext());
        this.f4014g = r13;
        g(r11);
        f(r11);
        addView(r12);
        addView(r13);
    }

    private void f(TintTypedArray r10) {
        this.f4014g.setVisibility(8);
        this.f4014g.setId(q5.f.textinput_prefix_text);
        this.f4014g.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(this.f4014g, 1);
        l(r10.getResourceId(l.TextInputLayout_prefixTextAppearance, 0));
        int r11 = l.TextInputLayout_prefixTextColor;
        if (r10.hasValue(r11) == false) goto L5;
        m(r10.getColorStateList(r11));
    L5:
        k(r10.getText(l.TextInputLayout_prefixText));
    }

    private void g(TintTypedArray r10) {
        if (com.google.android.material.resources.c.i(getContext()) == false) goto L5;
        MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) this.f4016i.getLayoutParams(), 0);
    L5:
        q(null);
        r(null);
        int r11 = l.TextInputLayout_startIconTint;
        if (r10.hasValue(r11) == false) goto L8;
        this.f4017j = com.google.android.material.resources.c.b(getContext(), r10, r11);
    L8:
        int r12 = l.TextInputLayout_startIconTintMode;
        if (r10.hasValue(r12) == false) goto L11;
        this.f4018k = ViewUtils.j(r10.getInt(r12, -1), null);
    L11:
        int r13 = l.TextInputLayout_startIconDrawable;
        if (r10.hasValue(r13) == false) goto L18;
        p(r10.getDrawable(r13));
        int r14 = l.TextInputLayout_startIconContentDescription;
        if (r10.hasValue(r14) == false) goto L16;
        o(r10.getText(r14));
    L16:
        n(r10.getBoolean(l.TextInputLayout_startIconCheckable, true));
        return;
    }

    private void x() {
        int r10 = 8;
        if (this.f4015h != null) goto L5;
    L7:
        int r11 = 8;
    L9:
        if (this.f4016i.getVisibility() == 0) goto L13;
        if (r11 == 0) goto L13;
        boolean r12 = false;
    L14:
        if (r12 == false) goto L16;
        r10 = 0;
    L16:
        setVisibility(r10);
        this.f4014g.setVisibility(r11);
        this.f4013c.q0();
        return;
    L13:
        r12 = true;
        goto L14
    L5:
        if (this.f4020m == true) goto L7;
        r11 = 0;
        goto L9
    }

    @Nullable
    CharSequence a() {
        return this.f4015h;
    }

    @Nullable
    ColorStateList b() {
        return this.f4014g.getTextColors();
    }

    @NonNull
    TextView c() {
        return this.f4014g;
    }

    @Nullable
    CharSequence d() {
        return this.f4016i.getContentDescription();
    }

    @Nullable
    Drawable e() {
        return this.f4016i.getDrawable();
    }

    boolean h() {
        if (this.f4016i.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    void i(boolean r10) {
        this.f4020m = r10;
        x();
    }

    void j() {
        d.c(this.f4013c, this.f4016i, this.f4017j);
    }

    void k(@Nullable CharSequence r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        CharSequence r11 = null;
    L6:
        this.f4015h = r11;
        this.f4014g.setText(r10);
        x();
        return;
    L5:
        r11 = r10;
        goto L6
    }

    void l(@StyleRes int r10) {
        TextViewCompat.setTextAppearance(this.f4014g, r10);
    }

    void m(@NonNull ColorStateList r10) {
        this.f4014g.setTextColor(r10);
    }

    void n(boolean r10) {
        this.f4016i.setCheckable(r10);
    }

    void o(@Nullable CharSequence r10) {
        if (d() == r10) goto L6;
        this.f4016i.setContentDescription(r10);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        w();
    }

    void p(@Nullable Drawable r10) {
        this.f4016i.setImageDrawable(r10);
        if (r10 == null) goto L5;
        d.a(this.f4013c, this.f4016i, this.f4017j, this.f4018k);
        u(true);
        j();
        return;
    L5:
        u(false);
        q(null);
        r(null);
        o(null);
    }

    void q(@Nullable View.OnClickListener r10) {
        d.e(this.f4016i, r10, this.f4019l);
    }

    void r(@Nullable View.OnLongClickListener r10) {
        this.f4019l = r10;
        d.f(this.f4016i, r10);
    }

    void s(@Nullable ColorStateList r10) {
        if (this.f4017j == r10) goto L6;
        this.f4017j = r10;
        d.a(this.f4013c, this.f4016i, r10, this.f4018k);
        return;
    }

    void t(@Nullable PorterDuff.Mode r10) {
        if (this.f4018k == r10) goto L6;
        this.f4018k = r10;
        d.a(this.f4013c, this.f4016i, this.f4017j, r10);
        return;
    }

    void u(boolean r10) {
        if (h() == r10) goto L10;
        CheckableImageButton r11 = this.f4016i;
        if (r10 == false) goto L7;
        int r12 = 0;
    L8:
        r11.setVisibility(r12);
        w();
        x();
        return;
    L7:
        r12 = 8;
        goto L8
    }

    void v(@NonNull AccessibilityNodeInfoCompat r10) {
        if (this.f4014g.getVisibility() != 0) goto L5;
        r10.setLabelFor(this.f4014g);
        View r11 = this.f4014g;
    L6:
        r10.setTraversalAfter(r11);
        return;
    L5:
        r11 = this.f4016i;
        goto L6
    }

    void w() {
        EditText r10 = this.f4013c.f3918j;
        if (r10 != null) goto L6;
        return;
    L6:
        if (h() == false) goto L8;
        int r11 = 0;
    L9:
        ViewCompat.setPaddingRelative(this.f4014g, r11, r10.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(q5.d.material_input_text_to_prefix_suffix_padding), r10.getCompoundPaddingBottom());
        return;
    L8:
        r11 = ViewCompat.getPaddingStart(r10);
        goto L9
    }
}
