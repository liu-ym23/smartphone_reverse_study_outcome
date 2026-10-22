package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class FansTrayView extends LinearLayout implements View.OnClickListener {
    public static float d;
    public LinearLayout a;
    public TextView b;
    public ViewGroup c;

    public FansTrayView(Context r2) {
        this(r2, null);
    }

    private void setTextContent(k32.a r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.b.setText(getContext().getString(2131916476, new Object[]{r4.b}));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        r1.getId();
    }

    public FansTrayView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public FansTrayView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        LinearLayout.inflate(getContext(), 2131565959, this);
        this.a = (LinearLayout) findViewById(2131389374);
        this.b = (TextView) findViewById(2131391677);
        this.c = (ViewGroup) findViewById(2131374505);
        TextView r4 = (TextView) findViewById(2131391563);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        if (d <= 0.0f) goto L5;
    L8:
        setGravity(16);
        return;
    L5:
        if (getContext() == null) goto L10;
        Resources r5 = getContext().getResources();
        d = WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density / 3.0f;
        goto L8
    }
}
