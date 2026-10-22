package com.bytedance.common.utility.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class DrawableCenterTextView extends TextView {
    public DrawableCenterTextView(Context r5) {
        super(r5);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r5) {
        Drawable[] r10 = getCompoundDrawables();
        if (r10 != null) goto L5;
    L17:
        super.onDraw(r5);
        return;
    L5:
        if (r10.length != 4) goto L17;
        Drawable r11 = r10[0];
        Drawable r12 = r10[2];
        if (r11 != null) goto L9;
        if (r12 == null) goto L17;
    L9:
        float r13 = getPaint().measureText(getText().toString());
        int r14 = getCompoundDrawablePadding();
        if (r11 == null) goto L12;
        int r15 = r11.getIntrinsicWidth();
    L13:
        float r16 = (r13 + r15) + r14;
        if (r11 == null) goto L16;
        setGravity(19);
        r5.translate((getWidth() - r16) / 2.0f, 0.0f);
        goto L17
    L16:
        setGravity(21);
        r5.translate((r16 - getWidth()) / 2.0f, 0.0f);
        goto L17
    L12:
        r15 = r12.getIntrinsicWidth();
        goto L13
    }

    public DrawableCenterTextView(Context r5, AttributeSet r10) {
        super(r5, r10);
    }

    public DrawableCenterTextView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
    }
}
