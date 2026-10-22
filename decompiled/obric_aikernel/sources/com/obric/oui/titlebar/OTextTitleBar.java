package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.obric.oui.common.util.k;
import u8.c;
import u8.e;
import u8.f;
import u8.h;
import u8.j;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class OTextTitleBar extends OTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f7710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f7711h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ba.a f7712i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageView f7713j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f7714k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f7715l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f7716m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f7717n;

    public OTextTitleBar(@NonNull Context r10) {
        this(r10, null);
    }

    public OTextTitleBar(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public OTextTitleBar(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f7717n = 0;
        a(r10);
        if (r11 == null) goto L6;
        b(r10, r11);
        return;
    }

    private void a(Context r10) {
        FrameLayout.inflate(r10, h.o_view_text_title_bar, this);
        this.f7710g = (TextView) findViewById(f.text_left);
        this.f7718c = (TextView) findViewById(f.title);
        this.f7711h = (TextView) findViewById(f.text_right);
        this.f7713j = (ImageView) findViewById(f.back_btn);
        this.f7716m = findViewById(f.line);
        this.f7713j.setOnClickListener(this);
        this.f7710g.setOnClickListener(this);
        this.f7711h.setOnClickListener(this);
        p9.a r11 = new p9.a(0.5f, 1.0f);
        this.f7713j.setOnTouchListener(r11);
        this.f7710g.setOnTouchListener(r11);
        this.f7711h.setOnTouchListener(r11);
    }

    private void b(Context r10, @NonNull AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, l.OTextTitleBar);
        String r13 = r12.getString(l.OTextTitleBar_oui_centerText);
        float r14 = r12.getDimension(l.OTextTitleBar_oui_centerTextSize, com.obric.oui.common.util.f.b(17));
        int r15 = l.OTextTitleBar_oui_centerTextColor;
        int r16 = c.TextPrimary;
        int r17 = r12.getColor(r15, ContextCompat.getColor(r10, r16));
        this.f7718c.setText(r13);
        this.f7718c.setTextSize(0, r14);
        this.f7718c.setTextColor(r17);
        this.f7714k = r12.getBoolean(l.OTextTitleBar_oui_useBackIcon, false);
        boolean r18 = r12.getBoolean(l.OTextTitleBar_oui_useCloseIcon, false);
        this.f7715l = r18;
        if (this.f7714k == false) goto L6;
        this.f7713j.setVisibility(0);
        this.f7710g.setVisibility(8);
        ImageView r19 = this.f7713j;
        int r20 = j.oui_iv_back_desc;
    L5:
        r19.setContentDescription(r10.getString(r20));
    L9:
        int r21 = r12.getInt(l.OTextTitleBar_oui_rightButtonType, 1);
        this.f7717n = r21;
        if (r21 != 1) goto L12;
        TextView r22 = this.f7711h;
        int r23 = ContextCompat.getColor(r10, c.Primary);
    L13:
        r22.setTextColor(r23);
        String r24 = r12.getString(l.OTextTitleBar_oui_rightButtonText);
        float r25 = r12.getDimension(l.OTextTitleBar_oui_rightTextSize, com.obric.oui.common.util.f.b(15));
        int r26 = l.OTextTitleBar_oui_rightTextColor;
        int r27 = r12.getColor(r26, ContextCompat.getColor(r10, r16));
        int r28 = r12.getInt(l.OTextTitleBar_oui_rightTextVisible, 0);
        this.f7711h.setText(r24);
        this.f7711h.setTextSize(0, r25);
        if (r12.hasValue(r26) == false) goto L16;
        this.f7711h.setTextColor(r27);
    L16:
        this.f7711h.setVisibility(r28);
        this.f7716m.setVisibility(r12.getInt(l.OTextTitleBar_oui_dividerVisible, 0));
        this.f7716m.setBackgroundColor(r12.getColor(l.OTextTitleBar_oui_dividerColor, ContextCompat.getColor(r10, c.LinePrimary)));
        r12.recycle();
        return;
    L12:
        r22 = this.f7711h;
        r23 = ContextCompat.getColor(r10, r16);
        goto L13
    L6:
        if (r18 == false) goto L8;
        this.f7713j.setVisibility(0);
        this.f7713j.setImageResource(e.o_ic_titlebar_close);
        this.f7710g.setVisibility(8);
        r19 = this.f7713j;
        r20 = j.oui_iv_close_desc;
        goto L5
    L8:
        String r29 = r12.getString(l.OTextTitleBar_oui_leftButtonText);
        float r30 = r12.getDimension(l.OTextTitleBar_oui_leftTextSize, com.obric.oui.common.util.f.b(15));
        int r31 = r12.getColor(l.OTextTitleBar_oui_leftTextColor, ContextCompat.getColor(r10, r16));
        this.f7713j.setVisibility(8);
        this.f7710g.setVisibility(0);
        this.f7710g.setText(r29);
        this.f7710g.setTextSize(0, r30);
        this.f7710g.setTextColor(r31);
        goto L9
    }

    public ImageView getBackBtn() {
        return this.f7713j;
    }

    public int getEndButtonType() {
        return this.f7717n;
    }

    public TextView getEndText() {
        return this.f7711h;
    }

    public TextView getStartText() {
        return this.f7710g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextView r10 = this.f7710g;
        if (r10 == null) goto L5;
        k.b(r10, com.obric.oui.common.util.f.b(44), com.obric.oui.common.util.f.b(44), false);
    L5:
        TextView r11 = this.f7711h;
        if (r11 == null) goto L9;
        k.b(r11, com.obric.oui.common.util.f.b(44), com.obric.oui.common.util.f.b(44), false);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (this.f7712i != null) goto L5;
        return;
    L5:
        if (r10.getId() != f.back_btn) goto L7;
    L12:
        this.f7712i.b(r10);
        return;
    L7:
        if (r10.getId() == f.text_left) goto L12;
        if (r10.getId() != f.text_right) goto L15;
        this.f7712i.a(r10);
        return;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int r10 = com.obric.oui.common.util.f.e(getContext());
        int r11 = ((r10 / 2) - Math.max(this.f7710g.getMeasuredWidth(), this.f7711h.getMeasuredWidth())) * 2;
        this.f7718c.setMaxWidth(Math.max(r11, com.obric.oui.common.util.f.b(112)));
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(@ColorInt int r10) {
        this.f7716m.setBackgroundColor(r10);
    }

    public void setEndText(@StringRes int r10) {
        this.f7711h.setText(r10);
    }

    public void setEndText(CharSequence r10) {
        this.f7711h.setText(r10);
    }

    public void setEndTextColor(@ColorInt int r10) {
        this.f7711h.setTextColor(r10);
    }

    public void setEndTextSize(float r10) {
        this.f7711h.setTextSize(r10);
    }

    public void setLineBackground(@ColorInt int r10) {
        this.f7716m.setBackgroundColor(r10);
    }

    public void setOnTitleBarClickListener(ba.a r10) {
        this.f7712i = r10;
    }

    public void setStartText(@StringRes int r10) {
        this.f7710g.setText(r10);
    }

    public void setStartText(CharSequence r10) {
        this.f7710g.setText(r10);
    }

    public void setStartTextColor(@ColorInt int r10) {
        this.f7710g.setTextColor(r10);
    }

    public void setStartTextSize(float r10) {
        this.f7710g.setTextSize(r10);
    }

    public void setUseBackIcon(boolean r10) {
        if (this.f7714k == r10) goto L13;
        this.f7714k = r10;
        ImageView r11 = this.f7713j;
        int r12 = 0;
        if (r10 == false) goto L7;
        int r13 = 0;
    L8:
        r11.setVisibility(r13);
        this.f7713j.setImageResource(e.o_ic_titlebar_back);
        TextView r14 = this.f7710g;
        if (this.f7714k == false) goto L11;
        r12 = 8;
    L11:
        r14.setVisibility(r12);
        this.f7713j.setContentDescription(getContext().getString(j.oui_iv_back_desc));
        return;
    L7:
        r13 = 8;
        goto L8
    }

    public void setUseCloseIcon(boolean r10) {
        if (this.f7715l == r10) goto L13;
        this.f7715l = r10;
        ImageView r11 = this.f7713j;
        int r12 = 0;
        if (r10 == false) goto L7;
        int r13 = 0;
    L8:
        r11.setVisibility(r13);
        this.f7713j.setImageResource(e.o_ic_titlebar_close);
        TextView r14 = this.f7710g;
        if (this.f7715l == false) goto L11;
        r12 = 8;
    L11:
        r14.setVisibility(r12);
        this.f7713j.setContentDescription(getContext().getString(j.oui_iv_close_desc));
        return;
    L7:
        r13 = 8;
        goto L8
    }
}
