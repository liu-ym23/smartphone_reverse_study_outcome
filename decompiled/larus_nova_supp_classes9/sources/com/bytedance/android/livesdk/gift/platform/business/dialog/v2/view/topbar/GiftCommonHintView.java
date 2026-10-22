package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class GiftCommonHintView extends FrameLayout {
    public TextView a;
    public TextView b;

    public GiftCommonHintView(Context r2) {
        this(r2, null);
    }

    public void setSubTitle(String r2) {
        this.b.setText(r2);
    }

    public void setTitle(String r2) {
        this.a.setText(r2);
    }

    public GiftCommonHintView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public GiftCommonHintView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        LayoutInflater.from(getContext()).inflate(2131566158, this);
        this.a = (TextView) findViewById(2131372615);
        this.b = (TextView) findViewById(2131387553);
    }
}
