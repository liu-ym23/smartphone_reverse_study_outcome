package com.bytedance.android.livesdk.feedback.utils;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final ThreadLocal<Matrix> a = null;
    public static final ThreadLocal<RectF> b = null;

    static {
        a = new ThreadLocal();
        b = new ThreadLocal();
    }

    public static void a(ViewGroup r3, View r4, Rect r5) {
        r5.set(0, 0, r4.getWidth(), r4.getHeight());
        ThreadLocal<Matrix> r0 = a;
        Matrix r1 = r0.get();
        if (r1 != null) goto L5;
        r1 = new Matrix();
        r0.set(r1);
    L6:
        b(r3, r4, r1);
        ThreadLocal<RectF> r6 = b;
        RectF r7 = r6.get();
        if (r7 != null) goto L9;
        r7 = new RectF();
        r6.set(r7);
    L9:
        r7.set(r5);
        r1.mapRect(r7);
        r5.set((int) (r7.left + 0.5f), (int) (r7.top + 0.5f), (int) (r7.right + 0.5f), (int) (r7.bottom + 0.5f));
        return;
    L5:
        r1.reset();
        goto L6
    }

    public static void b(ViewParent r2, View r3, Matrix r4) {
        Object r0 = r3.getParent();
        if ((r0 instanceof View) == false) goto L6;
        if (r0 == r2) goto L6;
        View r1 = (View) r0;
        b(r2, r1, r4);
        r4.preTranslate(-r1.getScrollX(), -r1.getScrollY());
    L6:
        r4.preTranslate(r3.getLeft(), r3.getTop());
        if (r3.getMatrix().isIdentity() == true) goto L10;
        r4.preConcat(r3.getMatrix());
        return;
    }
}
