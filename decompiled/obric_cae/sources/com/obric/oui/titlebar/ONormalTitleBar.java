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
import com.obric.cae.R;
import uc.b;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class ONormalTitleBar extends b implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f6628b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f6629m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f6630n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f6631o;

    public ONormalTitleBar(Context r8, AttributeSet r10) {
        int r11 = 0;
        super(r8, r10, 0);
        FrameLayout.inflate(r8, R.layout.o_view_normal_title_bar, this);
        this.f6628b = (ImageView) findViewById(R.id.back_btn);
        this.f12586a = (TextView) findViewById(R.id.title);
        this.f6629m = (ImageView) findViewById(R.id.right_btn);
        this.f6630n = findViewById(R.id.line);
        this.f6631o = (TextView) findViewById(R.id.text_left);
        this.f6628b.setOnClickListener(this);
        this.f6629m.setOnClickListener(this);
        this.f6631o.setOnClickListener(this);
        cc.a r12 = new cc.a();
        this.f6628b.setOnTouchListener(r12);
        this.f6629m.setOnTouchListener(r12);
        this.f6631o.setOnTouchListener(r12);
        if (r10 == null) goto L16;
        TypedArray r13 = r8.obtainStyledAttributes(r10, nb.a.f9500n);
        String r14 = r13.getString(0);
        float r15 = r13.getDimension(2, l6.a.G(17));
        Object r16 = androidx.core.content.a.f1674a;
        int r17 = r13.getColor(1, androidx.core.content.a.c.a(r8, R.color.TextPrimary));
        this.f12586a.setText(r14);
        this.f12586a.setTextSize(0, r15);
        this.f12586a.setTextColor(r17);
        Drawable r18 = r13.getDrawable(5);
        if (r13.hasValue(6) == false) goto L8;
        if (r18 == null) goto L8;
        int r19 = r13.getColor(6, 0);
        r18 = r18.mutate();
        b0.a.b.g(r18, r19);
    L8:
        if (r18 == null) goto L10;
        this.f6629m.setImageDrawable(r18);
    L10:
        boolean r20 = r13.getBoolean(4, true);
        View r21 = this.f6630n;
        if (r20 == true) goto L14;
        r11 = 8;
    L14:
        r21.setVisibility(r11);
        this.f6630n.setBackgroundColor(r13.getColor(3, androidx.core.content.a.c.a(r8, R.color.LinePrimary)));
        r13.recycle();
        return;
    }

    public ImageView getEndBtn() {
        return this.f6629m;
    }

    public ImageView getStartBtn() {
        return this.f6628b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getStartBtn() == null) goto L6;
        bc.a.a(getStartBtn(), l6.a.G(44), l6.a.G(44), false);
    L6:
        if (getEndBtn() == null) goto L9;
        bc.a.a(getEndBtn(), l6.a.G(44), l6.a.G(44), false);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
    }

    public void setCenterText(CharSequence r8) {
        this.f12586a.setText(r8);
    }

    public void setDividerHeight(int r8) {
        ViewGroup.LayoutParams r10 = this.f6630n.getLayoutParams();
        r10.height = r8;
        this.f6630n.setLayoutParams(r10);
    }

    @Override // uc.b
    public void setDividerLineBackground(int r8) {
        this.f6630n.setBackgroundColor(r8);
    }

    public void setEndBtnIcon(int r8) {
        this.f6629m.setImageResource(r8);
    }

    public void setOnTitleBarClickListener(wc.a r8) {
    }

    public void setStartBtnIcon(int r8) {
        this.f6628b.setImageResource(r8);
    }

    public void setStartText(String r8) {
        this.f6628b.setVisibility(8);
        this.f6631o.setVisibility(0);
        this.f6631o.setText(r8);
    }

    public void setStartTextSize(float r8) {
        this.f6631o.setTextSize(0, r8);
    }
}
