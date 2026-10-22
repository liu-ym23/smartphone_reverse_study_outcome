package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.obric.oui.common.util.k;
import u8.c;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class OButtonTitleBar extends OTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f7641g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f7642h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ba.a f7643i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Drawable f7644j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f7645k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @ColorInt
    private int f7646l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f7647m;

    public OButtonTitleBar(@NonNull Context r10) {
        this(r10, null);
    }

    public OButtonTitleBar(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public OButtonTitleBar(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f7647m = 0;
        a(r10);
        if (r11 == null) goto L6;
        b(r10, r11);
        return;
    }

    private void a(Context r10) {
        FrameLayout.inflate(r10, h.o_view_button_title_bar, this);
        this.f7641g = (ImageView) findViewById(f.back_btn);
        this.f7718c = (TextView) findViewById(f.title);
        this.f7642h = (TextView) findViewById(f.right_btn);
        this.f7645k = findViewById(f.line);
        this.f7641g.setOnClickListener(this);
        this.f7642h.setOnClickListener(this);
        p9.a r11 = new p9.a(0.5f, 1.0f);
        this.f7641g.setOnTouchListener(r11);
        this.f7642h.setOnTouchListener(r11);
    }

    private void b(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, l.OButtonTitleBar);
        String r13 = r12.getString(l.OButtonTitleBar_oui_centerText);
        float r14 = r12.getDimension(l.OButtonTitleBar_oui_centerTextSize, com.obric.oui.common.util.f.b(17));
        int r15 = l.OButtonTitleBar_oui_centerTextColor;
        int r16 = c.TextPrimary;
        int r17 = r12.getColor(r15, ContextCompat.getColor(r10, r16));
        this.f7718c.setText(r13);
        int r18 = 0;
        this.f7718c.setTextSize(0, r14);
        this.f7718c.setTextColor(r17);
        String r19 = r12.getString(l.OButtonTitleBar_oui_rightButtonText);
        int r20 = r12.getInt(l.OButtonTitleBar_oui_rightButtonType, 1);
        float r21 = r12.getDimension(l.OButtonTitleBar_oui_rightButtonTextSize, com.obric.oui.common.util.f.a(17.0f));
        int r22 = r12.getColor(l.OButtonTitleBar_oui_rightButtonTextColor, 0);
        this.f7644j = r12.getDrawable(l.OButtonTitleBar_oui_rightButtonTextBackground);
        int r23 = r12.getInt(l.OButtonTitleBar_oui_rightButtonVisible, 0);
        this.f7642h.setText(r19);
        this.f7647m = r20;
        TextView r24 = this.f7642h;
        if (r20 != 1) goto L5;
        r24.setTypeface(Typeface.defaultFromStyle(1));
        TextView r25 = this.f7642h;
        int r26 = ContextCompat.getColor(r10, c.Primary);
    L6:
        r25.setTextColor(r26);
        this.f7642h.setTextSize(0, r21);
        if (r22 == 0) goto L9;
        this.f7642h.setTextColor(r22);
    L9:
        Drawable r27 = this.f7644j;
        if (r27 == null) goto L12;
        this.f7642h.setBackground(r27);
    L12:
        this.f7642h.setVisibility(r23);
        boolean r28 = r12.getBoolean(l.OButtonTitleBar_oui_dividerVisible, false);
        View r29 = this.f7645k;
        if (r28 == true) goto L16;
        r18 = 4;
    L16:
        r29.setVisibility(r18);
        int r110 = r12.getColor(l.OButtonTitleBar_oui_dividerColor, ContextCompat.getColor(r10, c.LinePrimary));
        this.f7646l = r110;
        this.f7645k.setBackgroundColor(r110);
        r12.recycle();
        return;
    L5:
        r24.setTypeface(Typeface.defaultFromStyle(0));
        r25 = this.f7642h;
        r26 = ContextCompat.getColor(r10, r16);
        goto L6
    }

    public TextView getEndBtn() {
        return this.f7642h;
    }

    public int getEndButtonType() {
        return this.f7647m;
    }

    public ImageView getStartBtn() {
        return this.f7641g;
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
        if (this.f7643i != null) goto L5;
        return;
    L5:
        if (r10.getId() != f.back_btn) goto L8;
        this.f7643i.b(r10);
        return;
    L8:
        if (r10.getId() != f.right_btn) goto L13;
        this.f7643i.a(r10);
        return;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(@ColorInt int r10) {
        this.f7645k.setBackgroundColor(r10);
    }

    public void setOnTitleBarClickListener(ba.a r10) {
        this.f7643i = r10;
    }
}
