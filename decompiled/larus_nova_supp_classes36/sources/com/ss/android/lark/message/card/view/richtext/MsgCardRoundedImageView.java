package com.ss.android.lark.message.card.view.richtext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class MsgCardRoundedImageView extends LKUIRoundedImageView2 {
    public float a;
    public a b;

    public interface a {
    }

    public MsgCardRoundedImageView(Context r1) {
        super(r1);
        this.a = 0.0f;
        new Rect();
    }

    public final void onDraw(Canvas r1) {
        super.onDraw(r1);
    }

    public void setOnSizeChangedListener(a r1) {
        this.b = r1;
    }

    public void setRadiusPercent(float r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r7, int r8, int r9, int r10) {
        super/*android.widget.ImageView*/.onSizeChanged(r7, r8, r9, r10);
        a r11 = this.b;
        if (r11 == null) goto L6;
        p0 r12 = (p0) r11;
        r12.f.v(r12.a, r12.b, r12.c, r12.d, r12.e);
        r12.b.setOnSizeChangedListener(null);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super/*android.widget.ImageView*/.onLayout(r1, r2, r3, r4, r5);
        float r6 = this.a;
        if (r6 == 0.0f) goto L12;
        float r7 = Math.min(Math.max(0.0f, r6), 0.5f);
        if (getWidth() != getHeight()) goto L7;
        float r8 = r7 * getWidth();
    L9:
        if (r8 == 0.0f) goto L13;
        setRadius(r8);
        return;
    L13:
        return;
    L7:
        r8 = 0.0f;
        goto L9
    }
}
