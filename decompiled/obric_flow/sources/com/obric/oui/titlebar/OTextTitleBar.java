package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$styleable;
import com.obric.oui.constraintlayout.motion.widget.e0;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class OTextTitleBar extends OTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f14816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f14817c;
    public final ImageView d;
    public boolean e;
    public boolean f;
    public final View g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f14818h;

    public OTextTitleBar(@NonNull Context r5) {
        this(r5, null);
    }

    public ImageView getBackBtn() {
        return this.d;
    }

    public int getEndButtonType() {
        return this.f14818h;
    }

    public TextView getEndText() {
        return this.f14817c;
    }

    public TextView getStartText() {
        return this.f14816b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextView r5 = this.f14816b;
        if (r5 == null) goto L5;
        com.lynx.tasm.utils.d.o(r5, com.lynx.tasm.utils.a.u(44), com.lynx.tasm.utils.a.u(44), false);
    L5:
        TextView r10 = this.f14817c;
        if (r10 == null) goto L9;
        com.lynx.tasm.utils.d.o(r10, com.lynx.tasm.utils.a.u(44), com.lynx.tasm.utils.a.u(44), false);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int r5 = com.lynx.tasm.utils.a.x(getContext());
        int r10 = ((r5 / 2) - Math.max(this.f14816b.getMeasuredWidth(), this.f14817c.getMeasuredWidth())) * 2;
        this.f14819a.setMaxWidth(Math.max(r10, com.lynx.tasm.utils.a.u(112)));
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(@ColorInt int r5) {
        this.g.setBackgroundColor(r5);
    }

    public void setEndText(CharSequence r5) {
        this.f14817c.setText(r5);
    }

    public void setEndTextColor(@ColorInt int r5) {
        this.f14817c.setTextColor(r5);
    }

    public void setEndTextSize(float r5) {
        this.f14817c.setTextSize(r5);
    }

    public void setLineBackground(@ColorInt int r5) {
        this.g.setBackgroundColor(r5);
    }

    public void setOnTitleBarClickListener(ms.a r5) {
    }

    public void setStartText(CharSequence r5) {
        this.f14816b.setText(r5);
    }

    public void setStartTextColor(@ColorInt int r5) {
        this.f14816b.setTextColor(r5);
    }

    public void setStartTextSize(float r5) {
        this.f14816b.setTextSize(r5);
    }

    public void setUseBackIcon(boolean r5) {
        if (this.e == r5) goto L14;
        this.e = r5;
        ImageView r10 = this.d;
        int r11 = 8;
        if (r5 == false) goto L7;
        int r12 = 0;
    L8:
        r10.setVisibility(r12);
        this.d.setImageResource(R$drawable.o_ic_titlebar_back);
        TextView r13 = this.f14816b;
        if (this.e == true) goto L12;
        r11 = 0;
    L12:
        r13.setVisibility(r11);
        this.d.setContentDescription(getContext().getString(R$string.oui_iv_back_desc));
        return;
    L7:
        r12 = 8;
        goto L8
    }

    public void setUseCloseIcon(boolean r5) {
        if (this.f == r5) goto L14;
        this.f = r5;
        ImageView r10 = this.d;
        int r11 = 8;
        if (r5 == false) goto L7;
        int r12 = 0;
    L8:
        r10.setVisibility(r12);
        this.d.setImageResource(R$drawable.o_ic_titlebar_close);
        TextView r13 = this.f14816b;
        if (this.f == true) goto L12;
        r11 = 0;
    L12:
        r13.setVisibility(r11);
        this.d.setContentDescription(getContext().getString(R$string.oui_iv_close_desc));
        return;
    L7:
        r12 = 8;
        goto L8
    }

    public OTextTitleBar(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public void setEndText(@StringRes int r5) {
        this.f14817c.setText(r5);
    }

    public void setStartText(@StringRes int r5) {
        this.f14816b.setText(r5);
    }

    public OTextTitleBar(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f14818h = 0;
        View.inflate(r10, R$layout.o_view_text_title_bar, this);
        this.f14816b = (TextView) findViewById(R$id.text_left);
        this.f14819a = (TextView) findViewById(R$id.title);
        this.f14817c = (TextView) findViewById(R$id.text_right);
        this.d = (ImageView) findViewById(R$id.back_btn);
        this.g = findViewById(R$id.line);
        this.d.setOnClickListener(this);
        this.f14816b.setOnClickListener(this);
        this.f14817c.setOnClickListener(this);
        e0 r5 = new e0(3);
        this.d.setOnTouchListener(r5);
        this.f14816b.setOnTouchListener(r5);
        this.f14817c.setOnTouchListener(r5);
        if (r11 == null) goto L19;
        TypedArray r13 = r10.obtainStyledAttributes(r11, R$styleable.OTextTitleBar);
        String r14 = r13.getString(R$styleable.OTextTitleBar_oui_centerText);
        float r15 = r13.getDimension(R$styleable.OTextTitleBar_oui_centerTextSize, com.lynx.tasm.utils.a.u(17));
        int r16 = r13.getColor(R$styleable.OTextTitleBar_oui_centerTextColor, ContextCompat.getColor(r10, R$color.TextPrimary));
        this.f14819a.setText(r14);
        this.f14819a.setTextSize(0, r15);
        this.f14819a.setTextColor(r16);
        this.e = r13.getBoolean(R$styleable.OTextTitleBar_oui_useBackIcon, false);
        boolean r17 = r13.getBoolean(R$styleable.OTextTitleBar_oui_useCloseIcon, false);
        this.f = r17;
        if (this.e == false) goto L7;
        this.d.setVisibility(0);
        this.f14816b.setVisibility(8);
        this.d.setContentDescription(r10.getString(R$string.oui_iv_back_desc));
    L10:
        int r18 = r13.getInt(R$styleable.OTextTitleBar_oui_rightButtonType, 1);
        this.f14818h = r18;
        if (r18 != 1) goto L13;
        this.f14817c.setTextColor(ContextCompat.getColor(r10, R$color.Primary));
    L14:
        String r19 = r13.getString(R$styleable.OTextTitleBar_oui_rightButtonText);
        float r20 = r13.getDimension(R$styleable.OTextTitleBar_oui_rightTextSize, com.lynx.tasm.utils.a.u(15));
        int r21 = r13.getColor(R$styleable.OTextTitleBar_oui_rightTextColor, ContextCompat.getColor(r10, R$color.TextPrimary));
        int r22 = r13.getInt(R$styleable.OTextTitleBar_oui_rightTextVisible, 0);
        this.f14817c.setText(r19);
        this.f14817c.setTextSize(0, r20);
        if (r13.hasValue(R$styleable.OTextTitleBar_oui_rightTextColor) == false) goto L17;
        this.f14817c.setTextColor(r21);
    L17:
        this.f14817c.setVisibility(r22);
        this.g.setVisibility(r13.getInt(R$styleable.OTextTitleBar_oui_dividerVisible, 0));
        this.g.setBackgroundColor(r13.getColor(R$styleable.OTextTitleBar_oui_dividerColor, ContextCompat.getColor(r10, R$color.LinePrimary)));
        r13.recycle();
        return;
    L13:
        this.f14817c.setTextColor(ContextCompat.getColor(r10, R$color.TextPrimary));
        goto L14
    L7:
        if (r17 == false) goto L9;
        this.d.setVisibility(0);
        this.d.setImageResource(R$drawable.o_ic_titlebar_close);
        this.f14816b.setVisibility(8);
        this.d.setContentDescription(r10.getString(R$string.oui_iv_close_desc));
        goto L10
    L9:
        String r23 = r13.getString(R$styleable.OTextTitleBar_oui_leftButtonText);
        float r24 = r13.getDimension(R$styleable.OTextTitleBar_oui_leftTextSize, com.lynx.tasm.utils.a.u(15));
        int r25 = r13.getColor(R$styleable.OTextTitleBar_oui_leftTextColor, ContextCompat.getColor(r10, R$color.TextPrimary));
        this.d.setVisibility(8);
        this.f14816b.setVisibility(0);
        this.f14816b.setText(r23);
        this.f14816b.setTextSize(0, r24);
        this.f14816b.setTextColor(r25);
        goto L10
    }
}
