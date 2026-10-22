package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class ECExplainingView extends LinearLayout {
    public ECLiveExplainWaveView a;
    public TextView b;

    public ECExplainingView(Context r1) {
        super(r1);
        a(r1);
    }

    public final void a(Context r10) {
        setGravity(17);
        this.a = new ECLiveExplainWaveView(r10);
        int r1 = ECLiveImageUtils.d(r10, 12.0f);
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(r1, r1);
        r11.rightMargin = ECLiveImageUtils.d(r10, 2.0f);
        this.a.setLayoutParams(r11);
        this.a.setWaveLineColor(r10.getResources().getColor(2131101703));
        addView(this.a);
        TextView r12 = new TextView(r10);
        this.b = r12;
        r12.setText(2131896484);
        this.b.setTextColor(r10.getResources().getColor(2131101703));
        this.b.setTextSize(1, 12.0f);
        addView(this.b);
    }

    public ECExplainingView(Context r1, AttributeSet r10) {
        super(r1, r10);
        a(r1);
    }

    public ECExplainingView(Context r1, AttributeSet r10, int r11) {
        super(r1, r10, r11);
        a(r1);
    }
}
