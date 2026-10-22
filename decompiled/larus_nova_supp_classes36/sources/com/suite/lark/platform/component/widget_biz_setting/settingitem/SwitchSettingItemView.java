package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import xbc.b;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class SwitchSettingItemView extends ConstraintLayout {
    public TextView a;
    public UDSwitch b;
    public String c;
    public boolean d;

    public UDSwitch getSwitchView() {
        return this.b;
    }

    public SwitchSettingItemView(Context r2) {
        this(r2, null);
    }

    public void setTitle(String r2) {
        this.a.setText(r2);
    }

    public SwitchSettingItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SwitchSettingItemView(Context r11, AttributeSet r12, int r13) {
        super(r11, r12, r13);
        this.d = false;
        if (r12 == null) goto L5;
        TypedArray r14 = r11.obtainStyledAttributes(r12, new int[]{2130974022, 2130974023});
        this.c = r14.getString(1);
        this.d = r14.getBoolean(0, this.d);
        r14.recycle();
    L5:
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        int r0 = d.b(r11, 16.0f);
        setPadding(0, r0, 0, r0);
        TextView r1 = new TextView(r11);
        this.a = r1;
        r1.setTextSize(16.0f);
        this.a.setTextColor(getContext().getResources().getColorStateList(2131106622));
        this.a.setMaxLines(3);
        this.a.setEllipsize(TextUtils.TruncateAt.END);
        ConstraintLayout.LayoutParams r15 = b.b(0.0f, -2.0f, 16, 0, 16, 0);
        r15.topToTop = 0;
        r15.bottomToBottom = 0;
        r15.startToStart = 0;
        r15.endToStart = 2131385998;
        addView(this.a, r15);
        UDSwitch r16 = new UDSwitch(r11);
        this.b = r16;
        r16.setId(2131385998);
        this.b.setGravity(17);
        ConstraintLayout.LayoutParams r17 = b.b(-2.0f, -1.0f, 0, 0, 16, 0);
        r17.topToTop = 0;
        r17.bottomToBottom = 0;
        r17.endToEnd = 0;
        addView(this.b, r17);
        setTitle(this.c);
        this.b.setChecked(this.d);
        this.b.setOnCheckedChangeListener(null);
    }
}
