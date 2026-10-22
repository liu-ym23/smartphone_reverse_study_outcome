package com.ss.android.lark.reaction.widget.detailwindow.userstatus;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import v2c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ReactionUserStatusLinearLayout extends LinearLayout {
    public ImageView a;
    public TextView b;

    public int getMaxLines() {
        return this.b.getMaxLines();
    }

    public final void a() {
        getContext();
        LinearLayout.inflate(getContext(), 2131564264, this);
        this.a = (ImageView) findViewById(2131376297);
        this.b = (TextView) findViewById(2131390479);
        setTextSize(12);
    }

    public ReactionUserStatusLinearLayout(Context r1) {
        super(r1);
        a();
    }

    public void setIconVisibility(int r2) {
        this.a.setVisibility(r2);
    }

    public void setMaxLines(int r2) {
        this.b.setMaxLines(r2);
    }

    public void setTextColor(int r2) {
        this.b.setTextColor(r2);
    }

    public void setTextMaxWidth(int r2) {
        this.b.setMaxWidth(r2);
    }

    public void setTextSize(int r3) {
        this.b.setTextSize(r3);
        this.b.setMinHeight(a.a(getContext(), r3 + 2));
    }

    public void setWidth(int r2) {
        this.b.setWidth(r2);
    }

    public ReactionUserStatusLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    public ReactionUserStatusLinearLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }
}
