package com.bytedance.common.utility.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class DrawableCenterTextView extends TextView {
    public DrawableCenterTextView(Context r10) {
        super(r10);
    }

    public DrawableCenterTextView(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    public DrawableCenterTextView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas r10) {
        Drawable[] r11 = getCompoundDrawables();
        if (r11 != null) goto L5;
    L17:
        super.onDraw(r10);
        return;
    L5:
        if (r11.length != 4) goto L17;
        Drawable r12 = r11[0];
        Drawable r13 = r11[2];
        if (r12 != null) goto L9;
        if (r13 == null) goto L17;
    L9:
        float r14 = getPaint().measureText(getText().toString());
        int r15 = getCompoundDrawablePadding();
        if (r12 == null) goto L12;
        int r16 = r12.getIntrinsicWidth();
    L13:
        float r17 = (r14 + r16) + r15;
        if (r12 == null) goto L16;
        setGravity(19);
        r10.translate((getWidth() - r17) / 2.0f, 0.0f);
        goto L17
    L16:
        setGravity(21);
        r10.translate((r17 - getWidth()) / 2.0f, 0.0f);
        goto L17
    L12:
        r16 = r13.getIntrinsicWidth();
        goto L13
    }
}
