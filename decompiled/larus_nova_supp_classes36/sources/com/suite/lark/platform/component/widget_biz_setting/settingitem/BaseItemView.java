package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.UIHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import xbc.b;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class BaseItemView extends ConstraintLayout {
    public TextView a;
    public TextView b;
    public FrameLayout c;
    public SettingDividerView d;
    public SettingDividerView e;
    public String f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public View k;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ItemType {
        public static final int BUTTON = 4;
        public static final int CUSTOM = 0;
        public static final int DIVIDER = 3;
        public static final int INDICATOR = 1;
        public static final int SWITCHER = 2;
    }

    public abstract void setupContainer(FrameLayout r1);

    public BaseItemView(Context r2) {
        this(r2, null);
    }

    private void setBottomDesc(String r2) {
        this.g = r2;
        this.b.setText(r2);
        if (TextUtils.isEmpty(r2) == false) goto L5;
        this.b.setVisibility(8);
        return;
    L5:
        this.b.setVisibility(0);
    }

    private void setUpperDesc(String r6) {
        this.f = r6;
        this.a.setText(r6);
        ConstraintLayout.LayoutParams r0 = this.d.getLayoutParams();
        ConstraintLayout.LayoutParams r1 = this.c.getLayoutParams();
        if (TextUtils.isEmpty(r6) == false) goto L12;
        this.a.setVisibility(8);
        SettingDividerView r7 = this.d;
        if (this.j <= 0) goto L7;
        float r4 = 0.0f;
    L8:
        r7.setLeftBlankWidth(r4);
        if (this.d.getVisibility() == 8) goto L11;
        r0.setMargins(0, UIHelper.dp2px(this.j), 0, 0);
        return;
    L11:
        r1.setMargins(0, UIHelper.dp2px(this.j), 0, 0);
        return;
    L7:
        r4 = UIHelper.dp2px(16.0f);
        goto L8
    L12:
        this.a.setVisibility(0);
        if (this.d.getVisibility() == 8) goto L15;
        r0.setMargins(0, UIHelper.dp2px(this.j), 0, 0);
        return;
    L15:
        r1.setMargins(0, UIHelper.dp2px(this.j), 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(Context r25) {
        int r2 = d.b(r25, 16.0f);
        setPadding(r2, 0, r2, 0);
        TextView r3 = new TextView(r25);
        this.a = r3;
        r3.setId(2131386002);
        this.a.setMaxLines(1);
        float r6 = 14;
        this.a.setTextSize(r6);
        this.a.setTextColor(UIUtils.getColor(getContext(), 2131106620));
        ConstraintLayout.LayoutParams r4 = b.b(-1.0f, -2.0f, 16, this.j, 16, 2);
        r4.topToTop = 0;
        r4.startToStart = 0;
        r4.endToEnd = 0;
        r4.bottomToTop = 2131386003;
        r4.verticalChainStyle = 2;
        addView(this.a, r4);
        SettingDividerView r5 = new SettingDividerView(r25);
        this.d = r5;
        r5.setId(2131386003);
        SettingDividerView r7 = this.d;
        int r10 = 8;
        if (this.h == false) goto L5;
        int r9 = 0;
    L6:
        r7.setVisibility(r9);
        ConstraintLayout.LayoutParams r11 = b.b(0.0f, 0.5f, 0, 0, 0, 0);
        r11.topToBottom = 2131386002;
        r11.bottomToTop = 2131385987;
        r11.startToStart = 0;
        r11.endToEnd = 0;
        addView(this.d, r11);
        FrameLayout r12 = new FrameLayout(r25);
        this.c = r12;
        r12.setId(2131385987);
        ConstraintLayout.LayoutParams r8 = b.b(-1.0f, -2.0f, 0, 0, 0, 0);
        r8.topToBottom = 2131386003;
        r8.startToStart = 0;
        r8.endToEnd = 0;
        r8.bottomToTop = 2131385984;
        addView(this.c, r8);
        setupContainer(this.c);
        TextView r13 = new TextView(r25);
        this.b = r13;
        r13.setId(2131385983);
        this.b.setTextSize(r6);
        this.b.setTextColor(UIUtils.getColor(getContext(), 2131106620));
        ConstraintLayout.LayoutParams r14 = b.b(-1.0f, -2.0f, 16, 2, 16, 0);
        r14.bottomToBottom = 0;
        r14.startToStart = 0;
        r14.topToBottom = 2131385984;
        r14.endToEnd = 0;
        addView(this.b, r14);
        SettingDividerView r15 = new SettingDividerView(r25);
        this.e = r15;
        r15.setId(2131385984);
        SettingDividerView r1 = this.e;
        if (this.i == false) goto L9;
        r10 = 0;
    L9:
        r1.setVisibility(r10);
        ConstraintLayout.LayoutParams r16 = b.b(0.0f, 0.5f, 0, 0, 0, 0);
        r16.topToBottom = 2131385987;
        r16.bottomToTop = 2131385983;
        r16.startToStart = 0;
        r16.endToEnd = 0;
        addView(this.e, r16);
        setUpperDesc(this.f);
        setBottomDesc(this.g);
        setClickable(true);
        return;
    L5:
        r9 = 8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setupBackground(View r4) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setColor(UIUtils.getColorStateList(getContext(), 2131100552));
        r4.setBackground(r0);
        this.k = r4;
    }

    public BaseItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public void R5(Context r2, AttributeSet r3) {
        if (r3 == null) goto L5;
        TypedArray r4 = r2.obtainStyledAttributes(r3, new int[]{2130969052, 2130969111, 2130969124, 2130969616, 2130969775, 2130969778, 2130969971, 2130969972, 2130969973, 2130970348, 2130972677, 2130975002});
        this.f = r4.getString(11);
        this.g = r4.getString(0);
        r4.getInteger(3, 0);
        this.h = r4.getBoolean(5, false);
        this.j = r4.getDimensionPixelSize(10, 0);
        this.i = r4.getBoolean(4, false);
        r4.recycle();
        return;
    }

    public BaseItemView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        R5(r1, r2);
    }
}
