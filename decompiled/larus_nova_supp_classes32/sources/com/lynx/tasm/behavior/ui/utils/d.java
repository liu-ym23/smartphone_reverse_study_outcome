package com.lynx.tasm.behavior.ui.utils;

import a7a.k;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.lynx.tasm.behavior.LynxContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class d<T extends a7a.k> extends Drawable {
    public final k a;
    public final float[] b;
    public final Rect c;
    public final Rect d;
    public final T e;
    public final LynxContext f;
    public final float g;

    public abstract T a();

    public final RectF b() {
        float r0 = this.a.a(1);
        float r2 = this.a.a(3);
        float r3 = this.a.a(0);
        float r4 = this.a.a(2);
        Rect r5 = getBounds();
        float r6 = r3 + r4;
        if (r6 > r5.width()) goto L5;
    L7:
        float r7 = r0 + r2;
        if (r7 <= r5.height()) goto L13;
        if (r5.height() < 1) goto L13;
        float r1 = r5.height() / r7;
        r0 = r0 * r1;
        r2 = r2 * r1;
    L13:
        return new RectF(r3, r0, r4, r2);
    L5:
        if (r5.width() < 1) goto L7;
        float r8 = r5.width() / r6;
        r3 = r3 * r8;
        r4 = r4 * r8;
        goto L7
    }

    public final void e() {
        Rect r0 = getBounds();
        this.c.set(r0.left, r0.top, r0.right, r0.bottom);
        RectF r1 = b();
        Rect r2 = this.c;
        int r3 = (int) (r2.left + r1.left);
        r2.left = r3;
        int r4 = (int) (r2.top + r1.top);
        r2.top = r4;
        int r5 = (int) (r2.right - r1.right);
        r2.right = r5;
        int r6 = (int) (r2.bottom - r1.bottom);
        r2.bottom = r6;
        this.d.set(r3, r4, r5, r6);
        Rect r7 = this.d;
        float r8 = r7.top;
        float[] r9 = this.b;
        r7.top = (int) (r8 + r9[0]);
        r7.right = (int) (r7.right - r9[1]);
        r7.bottom = (int) (r7.bottom - r9[2]);
        r7.left = (int) (r7.left + r9[3]);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r5) {
        super.onBoundsChange(r5);
        Iterator r0 = ((ArrayList) this.e.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a7a.d) r0.next()).g(r5.width(), r5.height());
        goto L4
    L6:
        e();
    }

    public d(LynxContext r2, float r3) {
        this.c = new Rect();
        this.d = new Rect();
        this.e = null;
        this.f = r2;
        this.g = r3;
        this.e = (T) a();
        float[] r4 = new float[4];
        this.b = r4;
        Arrays.fill(r4, 0.0f);
        if (r2.getCssAlignWithLegacyW3c() == false) goto L5;
        this.a = new k(3.0f);
        return;
    L5:
        this.a = new k();
    }

    public boolean c(int r2, float r3) {
        return this.a.b(r2, r3);
    }

    public boolean d(float r4, float r5, float r6, float r7) {
        boolean r1 = false;
        if (com.lynx.tasm.utils.b.a(this.b[0], r4) == true) goto L6;
        this.b[0] = r4;
        r1 = true;
    L6:
        if (com.lynx.tasm.utils.b.a(this.b[1], r5) == true) goto L9;
        this.b[1] = r5;
        r1 = true;
    L9:
        if (com.lynx.tasm.utils.b.a(this.b[2], r6) == true) goto L12;
        this.b[2] = r6;
        r1 = true;
    L12:
        if (com.lynx.tasm.utils.b.a(this.b[3], r7) == true) goto L15;
        this.b[3] = r7;
        return true;
    L15:
        return r1;
    }
}
