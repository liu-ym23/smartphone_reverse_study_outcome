package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.RectF;
import com.lynx.tasm.behavior.LynxContext;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i extends d<a7a.l> {
    public int h;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.utils.d
    public final a7a.k a() {
        return new a7a.l(this.f, this, this.g);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r12) {
        if ((!((ArrayList) ((a7a.l) this.e).a).isEmpty()) == true) goto L5;
        return;
    L5:
        if (getBounds().isEmpty() == true) goto L13;
        RectF r7 = new RectF(getBounds());
        RectF r5 = new RectF(this.c);
        RectF r6 = new RectF(this.d);
        a7a.l r2 = (a7a.l) this.e;
        if (this.a == null) goto L9;
        boolean r10 = true;
    L10:
        r2.a(r12, r7, r5, r6, r7, null, null, r10);
        return;
    L9:
        r10 = false;
        goto L10
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        if (r2 == this.h) goto L6;
        this.h = r2;
        invalidateSelf();
        return;
    }

    public i(LynxContext r1, float r2) {
        super(r1, r2);
        this.h = 255;
    }
}
