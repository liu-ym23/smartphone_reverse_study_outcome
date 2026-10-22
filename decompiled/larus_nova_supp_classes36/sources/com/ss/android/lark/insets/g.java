package com.ss.android.lark.insets;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.Insets;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g extends Drawable {
    public final Paint a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public final Rect n;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public g() {
        this.a = new Paint();
        this.j = true;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = new Rect();
    }

    public final void a(Insets r3) {
        int r0 = 0;
        if (r3 == null) goto L5;
        int r1 = r3.top;
    L6:
        this.b = r1;
        if (r3 == null) goto L9;
        int r2 = r3.bottom;
    L10:
        this.c = r2;
        if (r3 == null) goto L13;
        int r4 = r3.left;
    L14:
        this.d = r4;
        if (r3 == null) goto L17;
        r0 = r3.right;
    L17:
        this.e = r0;
        return;
    L13:
        r4 = 0;
        goto L14
    L9:
        r2 = 0;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        Rect r0 = getBounds();
        if (this.b <= 0) goto L10;
        if (this.f == 0) goto L10;
        if (this.j == false) goto L10;
        this.n.setEmpty();
        this.n.set(0, 0, r0.width(), this.b);
        this.a.setColor(this.f);
        r7.drawRect(this.n, this.a);
    L10:
        if (this.c <= 0) goto L22;
        if (this.g == 0) goto L22;
        if (this.k == false) goto L22;
        this.n.setEmpty();
        this.n.set(0, 0, r0.width(), this.c);
        this.a.setColor(this.g);
        float r1 = r0.height() - this.c;
        int r4 = r7.save();
        r7.translate(0.0f, r1);
        r7.drawRect(this.n, this.a);     // Catch: Throwable -> L18
        r7.restoreToCount(r4);
    L18:
        th = move-exception;
        r7.restoreToCount(r4);
        throw th;
    L22:
        if (this.d <= 0) goto L29;
        if (this.h == 0) goto L29;
        if (this.l == false) goto L29;
        this.n.setEmpty();
        this.n.set(0, 0, this.d, r0.height());
        this.a.setColor(this.h);
        r7.drawRect(this.n, this.a);
    L29:
        if (this.e > 0) goto L31;
        return;
    L31:
        if (this.i != 0) goto L33;
        return;
    L33:
        if (this.m == false) goto L46;
        this.n.setEmpty();
        this.n.set(0, 0, this.e, r0.height());
        this.a.setColor(this.i);
        float r2 = r0.width() - this.e;
        int r3 = r7.save();
        r7.translate(r2, 0.0f);
        r7.drawRect(this.n, this.a);     // Catch: Throwable -> L37
        r7.restoreToCount(r3);
        return;
    L37:
        th = move-exception;
        r7.restoreToCount(r3);
        throw th;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.a.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.a.setColorFilter(r2);
    }
}
