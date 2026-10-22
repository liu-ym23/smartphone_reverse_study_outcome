package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c0 extends Drawable {
    public final /* synthetic */ b0 a;

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    public c0(b0 r1) {
        this.a = r1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        b0 r0 = this.a;
        b0.a r1 = r0.e;
        if (r1 != null) goto L5;
        return;
    L5:
        r0.d.set(r0.a.getPaint());
        b0 r2 = this.a;
        Paint r3 = r2.d;
        ColorStateList r4 = r2.f;
        if (r4 == null) goto L12;
        int[] r5 = r2.a.getDrawableState();
        ColorStateList r6 = this.a.f;
        if (r6 == null) goto L10;
        int r7 = r6.getDefaultColor();
    L11:
        int r8 = r4.getColorForState(r5, r7);
    L13:
        r3.setColor(r8);
        if (r1.d == false) goto L16;
        float r10 = r1.b;
        b0 r11 = this.a;
        float r12 = r10 - r11.d.measureText(r11.c);
    L17:
        int r13 = r9.save();
        r9.translate(this.a.a.getScrollX(), this.a.a.getScrollY());
        r9.clipRect(this.a.a.getTotalPaddingLeft(), this.a.a.getExtendedPaddingTop(), this.a.a.getWidth() - this.a.a.getTotalPaddingRight(), this.a.a.getHeight() - this.a.a.getExtendedPaddingBottom());
        b0 r14 = this.a;
        r9.drawText(r14.c, r12, r1.c, r14.d);
        r9.restoreToCount(r13);
        return;
    L16:
        r12 = r1.b;
        goto L17
    L10:
        r7 = -7829368;
        goto L11
    L12:
        r8 = r2.a.getCurrentHintTextColor();
        goto L13
    }
}
