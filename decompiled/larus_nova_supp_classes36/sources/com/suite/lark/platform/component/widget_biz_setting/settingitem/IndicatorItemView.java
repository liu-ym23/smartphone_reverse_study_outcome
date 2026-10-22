package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.utils.UIHelper;
import xbc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class IndicatorItemView extends BaseItemView {
    public TextView l;
    public ImageView m;
    public TextView n;
    public ImageView o;
    public String p;
    public Drawable q;
    public String r;
    public Drawable s;

    public IndicatorItemView(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.BaseItemView
    public void setupContainer(FrameLayout r23) {
        ConstraintLayout r1 = new ConstraintLayout(getContext());
        TextView r2 = new TextView(getContext());
        this.l = r2;
        r2.setId(2131385993);
        this.l.setTextSize(16);
        this.l.setTextColor(getContext().getResources().getColorStateList(2131106622));
        this.l.setMaxLines(2);
        TextView r3 = this.l;
        String r6 = this.p;
        r3.setText(r6);
        int r7 = 8;
        if (TextUtils.isEmpty(r6) == false) goto L5;
        int r8 = 8;
    L6:
        r3.setVisibility(r8);
        ConstraintLayout.LayoutParams r4 = b.b(0.0f, -2.0f, 16, 0, 16, 0);
        r4.topToTop = 0;
        r4.bottomToBottom = 0;
        r4.startToStart = 0;
        r4.endToStart = 2131385996;
        r4.horizontalWeight = 1.0f;
        r4.horizontalChainStyle = 2;
        r1.addView(this.l, r4);
        ImageView r5 = new ImageView(getContext());
        this.o = r5;
        r5.setId(2131385996);
        ConstraintLayout.LayoutParams r9 = b.b(-2.0f, -2.0f, 0, 0, 5, 0);
        r9.topToTop = 0;
        r9.bottomToBottom = 0;
        r9.startToEnd = 2131385993;
        r9.endToStart = 2131385999;
        ImageView r10 = this.o;
        Drawable r11 = this.s;
        if (r11 != null) goto L9;
        int r12 = 8;
    L10:
        r10.setVisibility(r12);
        if (r11 == null) goto L13;
        r10.setImageDrawable(r11);
    L13:
        r1.addView(this.o, r9);
        ImageView r13 = this.o;
        Drawable r14 = this.s;
        if (r14 != null) goto L16;
        int r15 = 8;
    L17:
        r13.setVisibility(r15);
        if (r14 == null) goto L20;
        r13.setImageDrawable(r14);
    L20:
        TextView r16 = new TextView(getContext());
        this.n = r16;
        r16.setId(2131385999);
        this.n.setTextSize(14);
        this.n.setTextColor(getContext().getResources().getColorStateList(2131106622));
        ConstraintLayout.LayoutParams r17 = b.b(-2.0f, -2.0f, 0, 0, 5, 0);
        r17.topToTop = 0;
        r17.bottomToBottom = 0;
        r17.startToEnd = 2131385996;
        r17.endToStart = 2131385997;
        r1.addView(this.n, r17);
        TextView r18 = this.n;
        String r19 = this.r;
        r18.setText(r19);
        if (TextUtils.isEmpty(r19) == false) goto L23;
        int r20 = 8;
    L24:
        r18.setVisibility(r20);
        ImageView r21 = new ImageView(getContext());
        this.m = r21;
        r21.setId(2131385997);
        this.m.setImageTintList(getContext().getResources().getColorStateList(2131102420));
        ConstraintLayout.LayoutParams r22 = b.b(16.0f, 16.0f, 0, 0, 16, 0);
        r22.topToTop = 0;
        r22.bottomToBottom = 0;
        r22.startToEnd = 2131385999;
        r22.endToEnd = 0;
        r1.addView(this.m, r22);
        ImageView r24 = this.m;
        Drawable r25 = this.q;
        if (r25 == null) goto L28;
        r7 = 0;
    L28:
        r24.setVisibility(r7);
        if (r25 == null) goto L31;
        r24.setImageDrawable(r25);
    L31:
        setupBackground(r1);
        r1.setClickable(true);
        r1.setOnClickListener(null);
        r23.addView(r1, new ConstraintLayout.LayoutParams(-1, UIHelper.dp2px(54)));
        return;
    L23:
        r20 = 0;
        goto L24
    L16:
        r15 = 0;
        goto L17
    L9:
        r12 = 0;
        goto L10
    L5:
        r8 = 0;
        goto L6
    }

    public IndicatorItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.BaseItemView
    public final void R5(Context r2, AttributeSet r3) {
        super.R5(r2, r3);
        if (r3 == null) goto L6;
        TypedArray r4 = r2.obtainStyledAttributes(r3, new int[]{2130969052, 2130969111, 2130969124, 2130969616, 2130969775, 2130969778, 2130969971, 2130969972, 2130969973, 2130970348, 2130972677, 2130975002});
        this.p = r4.getString(9);
        this.q = r4.getDrawable(6);
        this.s = r4.getDrawable(7);
        this.r = r4.getString(8);
        r4.recycle();
        return;
    }

    public IndicatorItemView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        R5(r1, r2);
        S5(r1);
    }
}
