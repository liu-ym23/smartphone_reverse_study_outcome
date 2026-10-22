package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.constraintlayout.motion.widget.e0;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class ONormalTitleBar extends OTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f14814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f14815c;
    public final View d;
    public final TextView e;

    public ONormalTitleBar(Context r5) {
        this(r5, null);
    }

    public ImageView getEndBtn() {
        return this.f14815c;
    }

    public ImageView getStartBtn() {
        return this.f14814b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getStartBtn() == null) goto L6;
        com.lynx.tasm.utils.d.o(getStartBtn(), com.lynx.tasm.utils.a.u(44), com.lynx.tasm.utils.a.u(44), false);
    L6:
        if (getEndBtn() == null) goto L9;
        com.lynx.tasm.utils.d.o(getEndBtn(), com.lynx.tasm.utils.a.u(44), com.lynx.tasm.utils.a.u(44), false);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
    }

    public void setCenterText(CharSequence r5) {
        this.f14819a.setText(r5);
    }

    public void setDividerHeight(int r5) {
        ViewGroup.LayoutParams r10 = this.d.getLayoutParams();
        r10.height = r5;
        this.d.setLayoutParams(r10);
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(@ColorInt int r5) {
        this.d.setBackgroundColor(r5);
    }

    public void setEndBtnIcon(@DrawableRes int r5) {
        this.f14815c.setImageResource(r5);
    }

    public void setOnTitleBarClickListener(ms.a r5) {
    }

    public void setStartBtnIcon(@DrawableRes int r5) {
        this.f14814b.setImageResource(r5);
    }

    public void setStartText(String r5) {
        this.f14814b.setVisibility(8);
        this.e.setVisibility(0);
        this.e.setText(r5);
    }

    public void setStartTextSize(float r5) {
        this.e.setTextSize(0, r5);
    }

    public ONormalTitleBar(Context r5, AttributeSet r10) {
        this(r5, r10, 0);
    }

    public ONormalTitleBar(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        View.inflate(r5, R$layout.o_view_normal_title_bar, this);
        this.f14814b = (ImageView) findViewById(R$id.back_btn);
        this.f14819a = (TextView) findViewById(R$id.title);
        this.f14815c = (ImageView) findViewById(R$id.right_btn);
        this.d = findViewById(R$id.line);
        this.e = (TextView) findViewById(R$id.text_left);
        this.f14814b.setOnClickListener(this);
        this.f14815c.setOnClickListener(this);
        this.e.setOnClickListener(this);
        e0 r12 = new e0(3);
        this.f14814b.setOnTouchListener(r12);
        this.f14815c.setOnTouchListener(r12);
        this.e.setOnTouchListener(r12);
        if (r10 == null) goto L16;
        TypedArray r13 = r5.obtainStyledAttributes(r10, R$styleable.ONormalTitleBar);
        String r14 = r13.getString(R$styleable.ONormalTitleBar_oui_centerText);
        float r15 = r13.getDimension(R$styleable.ONormalTitleBar_oui_centerTextSize, com.lynx.tasm.utils.a.u(17));
        int r16 = r13.getColor(R$styleable.ONormalTitleBar_oui_centerTextColor, ContextCompat.getColor(r5, R$color.TextPrimary));
        this.f14819a.setText(r14);
        int r17 = 0;
        this.f14819a.setTextSize(0, r15);
        this.f14819a.setTextColor(r16);
        Drawable r18 = r13.getDrawable(R$styleable.ONormalTitleBar_oui_rightDrawable);
        if (r13.hasValue(R$styleable.ONormalTitleBar_oui_rightDrawableTint) == false) goto L8;
        if (r18 == null) goto L8;
        int r19 = r13.getColor(R$styleable.ONormalTitleBar_oui_rightDrawableTint, 0);
        r18 = r18.mutate();
        DrawableCompat.setTint(r18, r19);
    L8:
        if (r18 == null) goto L10;
        this.f14815c.setImageDrawable(r18);
    L10:
        boolean r20 = r13.getBoolean(R$styleable.ONormalTitleBar_oui_dividerVisible, true);
        View r21 = this.d;
        if (r20 == true) goto L14;
        r17 = 8;
    L14:
        r21.setVisibility(r17);
        this.d.setBackgroundColor(r13.getColor(R$styleable.ONormalTitleBar_oui_dividerColor, ContextCompat.getColor(r5, R$color.LinePrimary)));
        r13.recycle();
        return;
    }
}
