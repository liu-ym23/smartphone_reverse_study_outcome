package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.utils.UIHelper;
import xbc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class TextSettingItemView extends ConstraintLayout {
    public TextView a;
    public ImageView b;
    public TextView c;
    public ImageView d;
    public String e;
    public Drawable f;
    public String g;
    public Drawable h;

    public TextSettingItemView(Context r2) {
        this(r2, null);
    }

    public void setRightText(String r2) {
        R5(this.c, r2);
    }

    public void setTitle(String r2) {
        R5(this.a, r2);
    }

    public TextSettingItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void R5(TextView r1, String r2) {
        r1.setText(r2);
        if (TextUtils.isEmpty(r2) == false) goto L5;
        int r3 = 8;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextSettingItemView(Context r21, AttributeSet r22, int r23) {
        super(r21, r22, r23);
        int r2 = 8;
        if (r22 == null) goto L5;
        TypedArray r1 = r21.obtainStyledAttributes(r22, new int[]{2130969052, 2130969111, 2130969124, 2130969616, 2130969775, 2130969778, 2130969971, 2130969972, 2130969973, 2130970348, 2130972677, 2130975002});
        this.e = r1.getString(9);
        this.f = r1.getDrawable(6);
        this.h = r1.getDrawable(7);
        this.g = r1.getString(8);
        r1.recycle();
    L5:
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setMinHeight(UIHelper.dp2px(54.0f));
        TextView r3 = new TextView(getContext());
        this.a = r3;
        r3.setId(2131385993);
        this.a.setTextSize(16);
        this.a.setTextColor(UDColorUtils.getColor(getContext(), 2131106622));
        this.a.setMaxLines(2);
        this.a.setEllipsize(TextUtils.TruncateAt.END);
        ConstraintLayout.LayoutParams r5 = b.b(0.0f, -2.0f, 16, 0, 16, 0);
        r5.topToTop = 0;
        r5.bottomToBottom = 0;
        r5.startToStart = 0;
        r5.endToStart = 2131385996;
        r5.horizontalWeight = 1.0f;
        r5.horizontalChainStyle = 2;
        addView(this.a, r5);
        ImageView r4 = new ImageView(getContext());
        this.d = r4;
        r4.setId(2131385996);
        ConstraintLayout.LayoutParams r11 = b.b(-2.0f, -2.0f, 0, 0, 5, 0);
        r11.topToTop = 0;
        r11.bottomToBottom = 0;
        r11.startToEnd = 2131385993;
        r11.endToStart = 2131385999;
        addView(this.d, r11);
        TextView r12 = new TextView(getContext());
        this.c = r12;
        r12.setMaxWidth(UIHelper.dp2px(120.0f));
        this.c.setId(2131385999);
        this.c.setTextSize(14);
        this.c.setTextColor(getContext().getResources().getColorStateList(2131106620));
        this.c.setLines(1);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        ConstraintLayout.LayoutParams r6 = b.b(-2.0f, -2.0f, 0, 0, 5, 0);
        r6.topToTop = 0;
        r6.bottomToBottom = 0;
        r6.startToEnd = 2131385996;
        r6.endToStart = 2131385997;
        addView(this.c, r6);
        ImageView r7 = new ImageView(getContext());
        this.b = r7;
        r7.setId(2131385997);
        this.b.setImageTintList(getContext().getResources().getColorStateList(2131102420));
        ConstraintLayout.LayoutParams r8 = b.b(16.0f, 16.0f, 0, 0, 16, 0);
        r8.topToTop = 0;
        r8.bottomToBottom = 0;
        r8.startToEnd = 2131385999;
        r8.endToEnd = 0;
        addView(this.b, r8);
        R5(this.a, this.e);
        ImageView r9 = this.d;
        Drawable r10 = this.h;
        if (r10 != null) goto L8;
        int r13 = 8;
    L9:
        r9.setVisibility(r13);
        if (r10 == null) goto L12;
        r9.setImageDrawable(r10);
    L12:
        ImageView r14 = this.d;
        Drawable r15 = this.h;
        if (r15 != null) goto L15;
        int r16 = 8;
    L16:
        r14.setVisibility(r16);
        if (r15 == null) goto L19;
        r14.setImageDrawable(r15);
    L19:
        R5(this.c, this.g);
        ImageView r17 = this.b;
        Drawable r18 = this.f;
        if (r18 == null) goto L23;
        r2 = 0;
    L23:
        r17.setVisibility(r2);
        if (r18 == null) goto L26;
        r17.setImageDrawable(r18);
    L26:
        setOnClickListener(null);
        return;
    L15:
        r16 = 0;
        goto L16
    L8:
        r13 = 0;
        goto L9
    }
}
