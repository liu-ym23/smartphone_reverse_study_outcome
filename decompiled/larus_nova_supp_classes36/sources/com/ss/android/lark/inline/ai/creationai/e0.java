package com.ss.android.lark.inline.ai.creationai;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.color.UDColorUtils;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e0 extends Drawable {
    public final Context a;
    public final Paint b;
    public float c;
    public float d;

    public static final class a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    public e0(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r3;
        Paint r0 = new Paint();
        r0.setAntiAlias(true);
        com.ss.android.lark.storage.a r1 = com.ss.android.lark.inline.ai.logic.b.a;
        r0.setColor(ContextCompat.getColor(r3, 2131100557));
        this.b = r0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r16) {
        Intrinsics.checkNotNullParameter(r16, "canvas");
        float r10 = Math.min(getBounds().width(), getBounds().height());
        int r11 = r16.saveLayer(0.0f, 0.0f, getBounds().width(), getBounds().height(), this.b);
        if (this.c <= 0.0f) goto L5;
        float r2 = getBounds().left;
        float r3 = getBounds().top;
        float r4 = getBounds().right;
        float r5 = getBounds().bottom;
        float r7 = this.c;
        r16.drawRoundRect(r2, r3, r4, r5, r7, r7, this.b);
    L6:
        Paint r1 = this.b;
        float r6 = Math.min(getBounds().width(), getBounds().height());
        float r8 = (getBounds().left + r6) / 2.0f;
        float r9 = (getBounds().top + r6) / 2.0f;
        Matrix r12 = new Matrix();
        r12.preRotate(((System.currentTimeMillis() % ((long) 3000)) / 3000.0f) * 360, r8, r9);
        SweepGradient r13 = new SweepGradient(r8, r9, ArraysKt.toIntArray(new Integer[]{Integer.valueOf(UDColorUtils.getColor(this.a, 2131100156)), Integer.valueOf(UDColorUtils.getColor(this.a, 2131100157)), Integer.valueOf(UDColorUtils.getColor(this.a, 2131100157)), Integer.valueOf(UDColorUtils.getColor(this.a, 2131100156))}), null);
        r13.setLocalMatrix(r12);
        r1.setShader(r13);
        this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        if (getBounds().width() <= getBounds().height()) goto L9;
        r16.scale(getBounds().width() / getBounds().height(), 1.0f);
    L10:
        r16.drawRect(getBounds().left, getBounds().top, getBounds().left + r10, getBounds().top + r10, this.b);
        this.b.setShader(null);
        this.b.setXfermode(null);
        r16.restoreToCount(r11);
        if (this.c <= 0.0f) goto L13;
        float r14 = this.d + getBounds().left;
        float r15 = this.d + getBounds().top;
        float r17 = getBounds().right - this.d;
        float r18 = getBounds().bottom;
        float r19 = this.d;
        float r20 = r18 - r19;
        float r21 = this.c;
        r16.drawRoundRect(r14, r15, r17, r20, r21 - r19, r21 - r19, this.b);
        return;
    L13:
        r16.drawRect(this.d + getBounds().left, this.d + getBounds().top, getBounds().right - this.d, getBounds().bottom - this.d, this.b);
        return;
    L9:
        r16.scale(1.0f, getBounds().height() / getBounds().width());
        goto L10
    L5:
        r16.drawRect(getBounds().left, getBounds().top, getBounds().right, getBounds().bottom, this.b);
        goto L6
    }
}
