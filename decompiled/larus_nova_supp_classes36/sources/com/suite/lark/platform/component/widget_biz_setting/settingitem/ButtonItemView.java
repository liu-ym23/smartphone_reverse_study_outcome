package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ButtonItemView extends BaseItemView {
    public TextView l;
    public String m;
    public int n;

    public ButtonItemView(Context r2) {
        this(r2, null);
    }

    public void setEnable(boolean r2) {
        this.l.setEnabled(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.BaseItemView
    public void setupContainer(FrameLayout r5) {
        TextView r0 = new TextView(getContext());
        this.l = r0;
        r0.setId(2131385985);
        this.l.setTextSize(16);
        this.l.setTextColor(this.n);
        this.l.setMaxLines(1);
        this.l.setText(this.m);
        this.l.setGravity(17);
        setupBackground(this.l);
        this.l.setOnClickListener(null);
        r5.addView(this.l, new FrameLayout.LayoutParams(-1, UIHelper.dp2px(54)));
    }

    public ButtonItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.BaseItemView
    public final void R5(Context r2, AttributeSet r3) {
        super.R5(r2, r3);
        if (r3 == null) goto L6;
        TypedArray r4 = r2.obtainStyledAttributes(r3, new int[]{2130969052, 2130969111, 2130969124, 2130969616, 2130969775, 2130969778, 2130969971, 2130969972, 2130969973, 2130970348, 2130972677, 2130975002});
        this.m = r4.getString(2);
        this.n = r4.getColor(1, getResources().getColor(2131106622));
        r4.recycle();
        return;
    }

    public ButtonItemView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        R5(r1, r2);
        S5(r1);
    }
}
