package com.ss.android.lark.custom.repeat.widget.childview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ControlChildViewClickableLayout extends LinearLayout {
    public boolean a;

    public ControlChildViewClickableLayout(Context r1) {
        super(r1);
        this.a = true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return !this.a;
    }

    public void setChildViewClickable(boolean r1) {
        this.a = r1;
    }

    public ControlChildViewClickableLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = true;
    }
}
