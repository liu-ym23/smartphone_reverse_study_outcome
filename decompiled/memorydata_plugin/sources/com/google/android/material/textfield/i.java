package com.google.android.material.textfield;

import android.content.Context;
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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.r;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class i extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextInputLayout f4179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f4180b;
    private CharSequence c;
    private final CheckableImageButton d;
    private ColorStateList e;
    private PorterDuff.Mode f;
    private View.OnLongClickListener g;
    private boolean h;

    i(TextInputLayout r6, TintTypedArray r7) {
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.f4179a = r6;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        CheckableImageButton r8 = (CheckableImageButton) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.design_text_input_start_icon, "layout", "design_text_input_start_icon"), this, false, "com.obric.memorydata.plugin"), CheckableImageButton.class, "com.obric.memorydata.plugin");
        this.d = r8;
        AppCompatTextView r0 = new AppCompatTextView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.f4180b = r0;
        a(r7);
        b(r7);
        addView(r8);
        addView(r0);
    }

    private void a(TintTypedArray r7) {
        if (com.google.android.material.resources.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L5;
        MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(this.d.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), 0);
    L5:
        a(null);
        a(null);
        if (r7.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_startIconTint, "styleable", "TextInputLayout_startIconTint")) == false) goto L9;
        this.e = com.google.android.material.resources.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r7, ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_startIconTint, "styleable", "TextInputLayout_startIconTint"));
    L9:
        if (r7.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_startIconTintMode, "styleable", "TextInputLayout_startIconTintMode")) == false) goto L12;
        this.f = r.a(r7.getInt(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_startIconTintMode, "styleable", "TextInputLayout_startIconTintMode"), -1), null);
    L12:
        if (r7.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_startIconDrawable, "styleable", "TextInputLayout_startIconDrawable")) == false) goto L18;
        a(r7.getDrawable(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_startIconDrawable, "styleable", "TextInputLayout_startIconDrawable")));
        if (r7.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_startIconContentDescription, "styleable", "TextInputLayout_startIconContentDescription")) == false) goto L16;
        b(r7.getText(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_startIconContentDescription, "styleable", "TextInputLayout_startIconContentDescription")));
    L16:
        b(r7.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_startIconCheckable, "styleable", "TextInputLayout_startIconCheckable"), true));
        return;
    }

    private void b(TintTypedArray r5) {
        this.f4180b.setVisibility(8);
        this.f4180b.setId(ZeusTransformUtils.mapRes(R.id.textinput_prefix_text, OaidModel.KEY_ID, "textinput_prefix_text"));
        this.f4180b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(this.f4180b, 1);
        a(r5.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_prefixTextAppearance, "styleable", "TextInputLayout_prefixTextAppearance"), 0));
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_prefixTextColor, "styleable", "TextInputLayout_prefixTextColor")) == false) goto L5;
        a(r5.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_prefixTextColor, "styleable", "TextInputLayout_prefixTextColor")));
    L5:
        a(r5.getText(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_prefixText, "styleable", "TextInputLayout_prefixText")));
    }

    private void i() {
        int r1 = 8;
        if (this.c != null) goto L5;
    L7:
        int r0 = 8;
    L9:
        if (this.d.getVisibility() == 0) goto L13;
        if (r0 == 0) goto L13;
        boolean r3 = false;
    L14:
        if (r3 == false) goto L16;
        r1 = 0;
    L16:
        setVisibility(r1);
        this.f4180b.setVisibility(r0);
        this.f4179a.h();
        return;
    L13:
        r3 = true;
        goto L14
    L5:
        if (this.h == true) goto L7;
        r0 = 0;
        goto L9
    }

    TextView a() {
        return this.f4180b;
    }

    void a(int r1) {
        TextViewCompat.setTextAppearance(this.f4180b, r1);
    }

    void a(ColorStateList r1) {
        this.f4180b.setTextColor(r1);
    }

    void a(PorterDuff.Mode r3) {
        if (this.f == r3) goto L6;
        this.f = r3;
        e.a(this.f4179a, this.d, this.e, r3);
        return;
    }

    void a(Drawable r4) {
        this.d.setImageDrawable(r4);
        if (r4 == null) goto L5;
        e.a(this.f4179a, this.d, this.e, this.f);
        a(true);
        f();
        return;
    L5:
        a(false);
        a(null);
        a(null);
        b(null);
    }

    void a(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        e.a(this.d, r4, this.g);
    }

    void a(View.OnLongClickListener r3) {
        View.OnLongClickListener r4 = (View.OnLongClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnLongClickListener.class, "com.obric.memorydata.plugin");
        this.g = r4;
        e.a(this.d, r4);
    }

    void a(AccessibilityNodeInfoCompat r2) {
        if (this.f4180b.getVisibility() != 0) goto L5;
        r2.setLabelFor(this.f4180b);
        View r1 = this.f4180b;
    L6:
        r2.setTraversalAfter(r1);
        return;
    L5:
        r1 = this.d;
        goto L6
    }

    void a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r4) == false) goto L5;
        CharSequence r0 = null;
    L6:
        this.c = r0;
        this.f4180b.setText(r4);
        i();
        return;
    L5:
        r0 = r4;
        goto L6
    }

    void a(boolean r2) {
        if (e() == r2) goto L10;
        CheckableImageButton r0 = this.d;
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        h();
        i();
        return;
    L7:
        r3 = 8;
        goto L8
    }

    CharSequence b() {
        return this.c;
    }

    void b(ColorStateList r3) {
        if (this.e == r3) goto L6;
        this.e = r3;
        e.a(this.f4179a, this.d, r3, this.f);
        return;
    }

    void b(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (g() == r4) goto L6;
        this.d.setContentDescription(r4);
        return;
    }

    void b(boolean r1) {
        this.d.setCheckable(r1);
    }

    ColorStateList c() {
        return this.f4180b.getTextColors();
    }

    void c(boolean r1) {
        this.h = r1;
        i();
    }

    Drawable d() {
        return this.d.getDrawable();
    }

    boolean e() {
        if (this.d.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    void f() {
        e.a(this.f4179a, this.d, this.e);
    }

    CharSequence g() {
        return this.d.getContentDescription();
    }

    void h() {
        EditText r0 = this.f4179a.f4134a;
        if (r0 != null) goto L6;
        return;
    L6:
        if (e() == false) goto L8;
        int r1 = 0;
    L9:
        ViewCompat.setPaddingRelative(this.f4180b, r1, r0.getCompoundPaddingTop(), ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.material_input_text_to_prefix_suffix_padding, "dimen", "material_input_text_to_prefix_suffix_padding")), r0.getCompoundPaddingBottom());
        return;
    L8:
        r1 = ViewCompat.getPaddingStart(r0);
        goto L9
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        h();
    }
}
