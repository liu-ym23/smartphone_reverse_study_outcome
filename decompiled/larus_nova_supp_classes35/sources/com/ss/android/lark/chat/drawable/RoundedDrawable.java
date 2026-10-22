package com.ss.android.lark.chat.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class RoundedDrawable extends Drawable {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public List<Path> j;
    public Paint k;
    public LinearGradient l;
    public Paint m;
    public final boolean n;
    public final Lazy o;

    public static final class a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r14) {
        Intrinsics.checkNotNullParameter(r14, "canvas");
        int r0 = r14.save();
        r14.clipRect(getBounds().left, getBounds().top, getBounds().right, getBounds().bottom);
        Paint r1 = this.m;
        if (r1 != null) goto L8;
        r1 = new Paint();
        LinearGradient r3 = this.l;
        if (r3 != null) goto L7;
        r3 = new LinearGradient(0.0f, 0.0f, getBounds().width(), 0.0f, this.g, this.h, Shader.TileMode.MIRROR);
        this.l = r3;
    L7:
        r1.setShader(r3);
        r1.setAntiAlias(true);
        this.m = r1;
    L8:
        r14.drawPaint(r1);
        if (this.f <= 0) goto L36;
        Paint r2 = this.k;
        if (r2 != null) goto L17;
        r2 = new Paint();
        r2.setStyle(Paint.Style.STROKE);
        r2.setAntiAlias(true);
        r2.setStrokeWidth(this.f);
        if (this.n == false) goto L16;
        r2.setStrokeWidth(r2.getStrokeWidth() * 2);
    L16:
        this.k = r2;
    L17:
        r2.setColor(this.e);
        List<Path> r4 = this.j;
        List r5 = r4;
        if (r4 != null) goto L32;
        ArrayList r6 = new ArrayList();
        this.j = r6;
        int r7 = this.i;
        if (r7 != 1) goto L23;
        r6.addAll(b(getBounds().width(), this.c, getBounds().width(), getBounds().height() - this.d));
        Path r8 = new Path();
        r8.moveTo(getBounds().width(), getBounds().height() - this.d);
        float r9 = getBounds().width() - this.d;
        float r10 = getBounds().height();
        float r11 = this.d;
        a(r8, r9, r10 - r11, r11, 0);
        r8.lineTo(this.b, getBounds().height());
        float r12 = this.b;
        float r13 = getBounds().height();
        float r15 = this.b;
        a(r8, r12, r13 - r15, r15, 1);
        r6.add(r8);
        r6.addAll(b(0.0f, getBounds().height() - this.b, 0.0f, this.a));
        r5 = r6;
        goto L32
    L23:
        if (r7 == 2) goto L30;
        if (r7 != 3) goto L26;
        Path r16 = new Path();
        r16.moveTo(this.a, 0.0f);
        r16.lineTo(getBounds().width() - this.c, 0.0f);
        float r17 = getBounds().width();
        float r18 = this.c;
        a(r16, r17 - r18, r18, r18, -1);
        r6.add(r16);
        r6.addAll(b(getBounds().width(), this.c, getBounds().width(), getBounds().height() - this.d));
        Path r19 = new Path();
        r19.moveTo(getBounds().width(), getBounds().height() - this.d);
        float r20 = getBounds().width() - this.d;
        float r21 = getBounds().height();
        float r22 = this.d;
        a(r19, r20, r21 - r22, r22, 0);
        r19.lineTo(this.b, getBounds().height());
        r6.add(r19);
        r5 = r6;
        goto L32
    L26:
        if (r7 == 4) goto L28;
        r6.addAll(b(getBounds().width(), this.c, getBounds().width(), getBounds().height() - this.d));
        Path r23 = new Path();
        r23.moveTo(getBounds().width(), getBounds().height() - this.d);
        float r24 = getBounds().width() - this.d;
        float r110 = getBounds().height();
        float r111 = this.d;
        a(r23, r24, r110 - r111, r111, 0);
        r23.lineTo(this.b, getBounds().height());
        float r25 = this.b;
        float r26 = getBounds().height();
        float r112 = this.b;
        a(r23, r25, r26 - r112, r112, 1);
        r6.add(r23);
        r6.addAll(b(0.0f, getBounds().height() - this.b, 0.0f, this.a));
        Path r27 = new Path();
        r27.moveTo(0.0f, this.a);
        float r28 = this.a;
        a(r27, r28, r28, r28, 2);
        r27.lineTo(getBounds().width() - this.c, 0.0f);
        float r29 = getBounds().width();
        float r30 = this.c;
        a(r27, r29 - r30, r30, this.d, 3);
        r6.add(r27);
        r5 = r6;
        goto L32
    L28:
        Path r31 = new Path();
        r31.moveTo(getBounds().width() - this.d, getBounds().height());
        r31.lineTo(this.b, getBounds().height());
        float r32 = this.b;
        float r33 = getBounds().height();
        float r34 = this.b;
        a(r31, r32, r33 - r34, r34, 1);
        r6.add(r31);
        r6.addAll(b(0.0f, getBounds().height() - this.b, 0.0f, this.a));
        Path r35 = new Path();
        r35.moveTo(0.0f, this.a);
        float r36 = this.a;
        a(r35, r36, r36, r36, 2);
        r35.lineTo(getBounds().width() - this.c, 0.0f);
        r6.add(r35);
        r5 = r6;
        goto L32
    L30:
        r6.addAll(b(0.0f, getBounds().height() - this.b, 0.0f, this.a));
        Path r37 = new Path();
        r37.moveTo(0.0f, this.a);
        float r38 = this.a;
        a(r37, r38, r38, r38, 2);
        r37.lineTo(getBounds().width() - this.c, 0.0f);
        float r39 = getBounds().width();
        float r40 = this.c;
        a(r37, r39 - r40, r40, r40, 3);
        r6.add(r37);
        r6.addAll(b(getBounds().width(), this.c, getBounds().width(), getBounds().height() - this.d));
        r5 = r6;
    L32:
        Iterator r41 = r5.iterator();
    L34:
        if (r41.hasNext() == false) goto L36;
        r14.drawPath((Path) r41.next(), r2);
    L36:
        r14.restoreToCount(r0);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "bounds");
        if (Intrinsics.areEqual(r2, getBounds()) == true) goto L5;
        this.j = null;
        this.m = null;
        this.l = null;
    L5:
        super.setBounds(r2);
    }

    public static List b(float r10, float r11, float r12, float r13) {
        ArrayList r0 = new ArrayList();
        float r1 = r12 - r10;
        float r2 = r13 - r11;
        int r3 = (int) (Math.max(Math.abs(r1), Math.abs(r2)) / 100);
        if (r3 != 0) goto L7;
        Path r4 = new Path();
        r4.moveTo(r10, r11);
        r4.lineTo(r12, r13);
        r0.add(r4);
        return r0;
    L7:
        if (1 > r3) goto L12;
        int r5 = 1;
    L9:
        Path r6 = new Path();
        r6.moveTo(r10, r11);
        float r7 = 1;
        float r9 = r3;
        r10 = r10 + ((r1 * r7) / r9);
        r11 = r11 + ((r7 * r2) / r9);
        r6.lineTo(r10, r11);
        r0.add(r6);
        if (r5 == r3) goto L12;
        r5 = r5 + 1;
    L12:
        Path r8 = new Path();
        r8.moveTo(r10, r11);
        r8.lineTo(r12, r13);
        r0.add(r8);
        return r0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int r2, int r3, int r4, int r5) {
        if (r2 == getBounds().left) goto L5;
    L10:
        this.j = null;
        this.m = null;
        this.l = null;
    L11:
        super.setBounds(r2, r3, r4, r5);
        return;
    L5:
        if (r4 != getBounds().right) goto L10;
        if (r3 != getBounds().top) goto L10;
        if (r5 == getBounds().bottom) goto L11;
        goto L10
    }

    public static void a(Path r8, float r9, float r10, float r11, int r12) {
        r8.arcTo(r9 - r11, r10 - r11, r9 + r11, r10 + r11, r12 * 90.0f, 90.0f, false);
    }

    public RoundedDrawable(float r1, float r2, float r3, float r4, int r5, int r6, int r7, int r8, int r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.n = true;
        new Path();
        this.o = LazyKt.lazy(RoundedDrawable$mClearPaint$2.INSTANCE);
    }
}
