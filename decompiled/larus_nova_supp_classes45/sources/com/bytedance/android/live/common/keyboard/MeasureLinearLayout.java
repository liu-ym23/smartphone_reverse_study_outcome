package com.bytedance.android.live.common.keyboard;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import i40.b;
import i40.d;
import i40.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class MeasureLinearLayout extends LinearLayout {
    public b a;
    public int b;
    public int c;
    public boolean d;

    public b getKeyBoardObservable() {
        return this.a;
    }

    public MeasureLinearLayout(Context r2) {
        this(r2, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r3) {
        super.onDraw(r3);
        b r4 = this.a;
        Context r0 = getContext();
        d r1 = r4.a.a(r0, this);
        if (r1 == null) goto L7;
        r4.c(r1.a, r1.b);
        return;
    }

    public void setKeyBoardObservable(b r1) {
        this.a = r1;
    }

    public MeasureLinearLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        int r0 = this.c;
        int r1 = this.b;
        if (r0 != r1) goto L5;
        this.d = this.a.a(getContext(), r4);
    L6:
        super.onMeasure(r3, r4);
        return;
    L5:
        this.c = r1;
        goto L6
    }

    public MeasureLinearLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.d = true;
        this.a = new b(this);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r9, int r11, int r12, int r13) {
        if (this.d == true) goto L6;
        h.c("【skip layout】", true);
        return;
    L6:
        super.onLayout(r8, r9, r11, r12, r13);
        b r14 = this.a;
        Context r1 = getContext();
        r14.a.c(r1, this, r9, r11, r12, r13);
    }
}
