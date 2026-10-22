package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class DividerItemView extends BaseItemView {
    @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.BaseItemView
    public void setupContainer(FrameLayout r1) {
    }

    public DividerItemView(Context r2) {
        this(r2, null);
    }

    public DividerItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public DividerItemView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        S5(r1);
    }
}
