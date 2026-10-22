package com.ss.android.lark.guide.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ArrowView extends View {
    public int a;
    public int b;
    public final Drawable c;

    public ArrowView(Context r2) {
        super(r2);
        this.a = getContext().getResources().getColor(2131105549);
        this.b = 48;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), 2131235926);
        this.c = r3;
        r3.setTint(this.a);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r7) {
        super.onDraw(r7);
        int r0 = getWidth();
        int r1 = getHeight();
        r7.save();
        int r2 = this.b;
        if (r2 != 3) goto L5;
    L18:
        r7.translate(0.0f, r1);
        r7.rotate(-90.0f, 0.0f, 0.0f);
        this.c.setBounds(0, 0, r1, r0);
    L19:
        this.c.draw(r7);
        r7.restore();
        return;
    L5:
        if (r2 != 5) goto L7;
    L17:
        r7.translate(r0, 0.0f);
        r7.rotate(90.0f, 0.0f, 0.0f);
        this.c.setBounds(0, 0, r1, r0);
        goto L19
    L7:
        if (r2 != 48) goto L9;
        this.c.setBounds(0, 0, r0, r1);
        goto L19
    L9:
        if (r2 != 80) goto L11;
        this.c.setBounds(0, 0, r0, r1);
        r7.rotate(180.0f, (r0 * 1.0f) / 2.0f, (r1 * 1.0f) / 2.0f);
        goto L19
    L11:
        if (r2 == 8388611) goto L18;
        if (r2 == 8388613) goto L17;
        goto L17
    }

    public void setAnchorGravity(int r1) {
        this.b = r1;
    }

    public void setFillColor(int r2) {
        this.a = r2;
        this.c.setTint(r2);
    }

    public ArrowView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = getContext().getResources().getColor(2131105549);
        this.b = 48;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), 2131235926);
        this.c = r3;
        r3.setTint(this.a);
    }

    public ArrowView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = getContext().getResources().getColor(2131105549);
        this.b = 48;
        Drawable r4 = AppCompatResources.getDrawable(getContext(), 2131235926);
        this.c = r4;
        r4.setTint(this.a);
    }
}
