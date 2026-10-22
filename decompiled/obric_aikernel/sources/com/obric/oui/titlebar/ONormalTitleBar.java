package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.obric.oui.common.util.k;
import u8.c;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class ONormalTitleBar extends OTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f7705g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f7706h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ba.a f7707i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f7708j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f7709k;

    public ONormalTitleBar(Context r10) {
        this(r10, null);
    }

    public ONormalTitleBar(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ONormalTitleBar(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        a(r10);
        if (r11 == null) goto L6;
        b(r10, r11);
        return;
    }

    private void a(Context r10) {
        FrameLayout.inflate(r10, h.o_view_normal_title_bar, this);
        this.f7705g = (ImageView) findViewById(f.back_btn);
        this.f7718c = (TextView) findViewById(f.title);
        this.f7706h = (ImageView) findViewById(f.right_btn);
        this.f7708j = findViewById(f.line);
        this.f7709k = (TextView) findViewById(f.text_left);
        this.f7705g.setOnClickListener(this);
        this.f7706h.setOnClickListener(this);
        this.f7709k.setOnClickListener(this);
        p9.a r11 = new p9.a(0.5f, 1.0f);
        this.f7705g.setOnTouchListener(r11);
        this.f7706h.setOnTouchListener(r11);
        this.f7709k.setOnTouchListener(r11);
    }

    private void b(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, l.ONormalTitleBar);
        String r13 = r12.getString(l.ONormalTitleBar_oui_centerText);
        float r14 = r12.getDimension(l.ONormalTitleBar_oui_centerTextSize, com.obric.oui.common.util.f.b(17));
        int r15 = r12.getColor(l.ONormalTitleBar_oui_centerTextColor, ContextCompat.getColor(r10, c.TextPrimary));
        this.f7718c.setText(r13);
        int r16 = 0;
        this.f7718c.setTextSize(0, r14);
        this.f7718c.setTextColor(r15);
        Drawable r17 = r12.getDrawable(l.ONormalTitleBar_oui_rightDrawable);
        int r18 = l.ONormalTitleBar_oui_rightDrawableTint;
        if (r12.hasValue(r18) == false) goto L6;
        if (r17 == null) goto L6;
        int r19 = r12.getColor(r18, 0);
        r17 = r17.mutate();
        DrawableCompat.setTint(r17, r19);
    L6:
        if (r17 == null) goto L8;
        this.f7706h.setImageDrawable(r17);
    L8:
        boolean r20 = r12.getBoolean(l.ONormalTitleBar_oui_dividerVisible, true);
        View r21 = this.f7708j;
        if (r20 == true) goto L12;
        r16 = 8;
    L12:
        r21.setVisibility(r16);
        this.f7708j.setBackgroundColor(r12.getColor(l.ONormalTitleBar_oui_dividerColor, ContextCompat.getColor(r10, c.LinePrimary)));
        r12.recycle();
    }

    public ImageView getEndBtn() {
        return this.f7706h;
    }

    public ImageView getStartBtn() {
        return this.f7705g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getStartBtn() == null) goto L6;
        k.b(getStartBtn(), com.obric.oui.common.util.f.b(44), com.obric.oui.common.util.f.b(44), false);
    L6:
        if (getEndBtn() == null) goto L9;
        k.b(getEndBtn(), com.obric.oui.common.util.f.b(44), com.obric.oui.common.util.f.b(44), false);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (this.f7707i != null) goto L5;
        return;
    L5:
        if (r10.getId() != f.back_btn) goto L7;
    L12:
        this.f7707i.b(r10);
        return;
    L7:
        if (r10.getId() == f.text_left) goto L12;
        if (r10.getId() != f.right_btn) goto L15;
        this.f7707i.a(r10);
        return;
    }

    public void setCenterText(CharSequence r10) {
        this.f7718c.setText(r10);
    }

    public void setDividerHeight(int r10) {
        ViewGroup.LayoutParams r11 = this.f7708j.getLayoutParams();
        r11.height = r10;
        this.f7708j.setLayoutParams(r11);
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(@ColorInt int r10) {
        this.f7708j.setBackgroundColor(r10);
    }

    public void setEndBtnIcon(@DrawableRes int r10) {
        this.f7706h.setImageResource(r10);
    }

    public void setOnTitleBarClickListener(ba.a r10) {
        this.f7707i = r10;
    }

    public void setStartBtnIcon(@DrawableRes int r10) {
        this.f7705g.setImageResource(r10);
    }

    public void setStartText(String r10) {
        this.f7705g.setVisibility(8);
        this.f7709k.setVisibility(0);
        this.f7709k.setText(r10);
    }

    public void setStartTextSize(float r10) {
        this.f7709k.setTextSize(0, r10);
    }
}
