package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.constraintlayout.motion.widget.e0;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class OButtonTitleBar extends OTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f14766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f14767c;
    public final Drawable d;
    public final View e;
    public final int f;

    public OButtonTitleBar(@NonNull Context r5) {
        this(r5, null);
    }

    public TextView getEndBtn() {
        return this.f14767c;
    }

    public int getEndButtonType() {
        return this.f;
    }

    public ImageView getStartBtn() {
        return this.f14766b;
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

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(@ColorInt int r5) {
        this.e.setBackgroundColor(r5);
    }

    public void setOnTitleBarClickListener(ms.a r5) {
    }

    public OButtonTitleBar(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public OButtonTitleBar(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        int r13 = 0;
        this.f = 0;
        View.inflate(r10, R$layout.o_view_button_title_bar, this);
        this.f14766b = (ImageView) findViewById(R$id.back_btn);
        this.f14819a = (TextView) findViewById(R$id.title);
        this.f14767c = (TextView) findViewById(R$id.right_btn);
        this.e = findViewById(R$id.line);
        this.f14766b.setOnClickListener(this);
        this.f14767c.setOnClickListener(this);
        e0 r5 = new e0(3);
        this.f14766b.setOnTouchListener(r5);
        this.f14767c.setOnTouchListener(r5);
        if (r11 == null) goto L20;
        TypedArray r14 = r10.obtainStyledAttributes(r11, R$styleable.OButtonTitleBar);
        String r15 = r14.getString(R$styleable.OButtonTitleBar_oui_centerText);
        float r16 = r14.getDimension(R$styleable.OButtonTitleBar_oui_centerTextSize, com.lynx.tasm.utils.a.u(17));
        int r17 = r14.getColor(R$styleable.OButtonTitleBar_oui_centerTextColor, ContextCompat.getColor(r10, R$color.TextPrimary));
        this.f14819a.setText(r15);
        this.f14819a.setTextSize(0, r16);
        this.f14819a.setTextColor(r17);
        String r18 = r14.getString(R$styleable.OButtonTitleBar_oui_rightButtonText);
        int r19 = r14.getInt(R$styleable.OButtonTitleBar_oui_rightButtonType, 1);
        float r20 = r14.getDimension(R$styleable.OButtonTitleBar_oui_rightButtonTextSize, 17.0f * Resources.getSystem().getDisplayMetrics().density);
        int r21 = r14.getColor(R$styleable.OButtonTitleBar_oui_rightButtonTextColor, 0);
        this.d = r14.getDrawable(R$styleable.OButtonTitleBar_oui_rightButtonTextBackground);
        int r22 = r14.getInt(R$styleable.OButtonTitleBar_oui_rightButtonVisible, 0);
        this.f14767c.setText(r18);
        this.f = r19;
        if (r19 != 1) goto L7;
        this.f14767c.setTypeface(Typeface.defaultFromStyle(1));
        this.f14767c.setTextColor(ContextCompat.getColor(r10, R$color.Primary));
    L8:
        this.f14767c.setTextSize(0, r20);
        if (r21 == 0) goto L11;
        this.f14767c.setTextColor(r21);
    L11:
        Drawable r23 = this.d;
        if (r23 == null) goto L14;
        this.f14767c.setBackground(r23);
    L14:
        this.f14767c.setVisibility(r22);
        boolean r24 = r14.getBoolean(R$styleable.OButtonTitleBar_oui_dividerVisible, false);
        View r25 = this.e;
        if (r24 == true) goto L18;
        r13 = 4;
    L18:
        r25.setVisibility(r13);
        this.e.setBackgroundColor(r14.getColor(R$styleable.OButtonTitleBar_oui_dividerColor, ContextCompat.getColor(r10, R$color.LinePrimary)));
        r14.recycle();
        return;
    L7:
        this.f14767c.setTypeface(Typeface.defaultFromStyle(0));
        this.f14767c.setTextColor(ContextCompat.getColor(r10, R$color.TextPrimary));
        goto L8
    }
}
