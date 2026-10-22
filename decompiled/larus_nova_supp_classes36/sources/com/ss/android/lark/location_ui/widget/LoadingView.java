package com.ss.android.lark.location_ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class LoadingView extends LinearLayout {
    public ProgressBar a;
    public TextView b;

    public final void a() {
        String r0 = getResources().getString(2131890383);
        this.a.setVisibility(8);
        this.b.setText(r0);
    }

    public final void b() {
        String r0 = getResources().getString(2131891898);
        setVisibility(0);
        this.a.setVisibility(0);
        this.b.setText(r0);
    }

    public LoadingView(Context r2) {
        this(r2, null);
    }

    public LoadingView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public LoadingView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4, 0);
        LayoutInflater.from(getContext()).inflate(2131563584, this);
        this.a = (ProgressBar) findViewById(2131379151);
        this.b = (TextView) findViewById(2131379157);
    }
}
