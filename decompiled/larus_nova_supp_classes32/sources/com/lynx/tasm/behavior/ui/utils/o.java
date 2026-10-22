package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.base.LLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o {
    public o() {
    }

    public static boolean f(View r2, View r3) {
        if (r2 == null) goto L18;
        if (r3 == null) goto L18;
        if ((r2 instanceof ViewGroup) == true) goto L10;
        return false;
    L10:
        if (r3.getParent() == null) goto L18;
        if (r3.getParent() == r2) goto L13;
        if ((r3.getParent() instanceof View) == false) goto L18;
        r3 = (View) r3.getParent();
        goto L10
    L13:
        return true;
    L18:
        return false;
    }

    public static PointF a(View r8, View r9, PointF r10) {
        if (r8 == null) goto L22;
        if (r9 == null) goto L22;
        if (r8 != r9) goto L7;
        return r10;
    L7:
        float[] r1 = {r10.x, r10.y};
        ArrayList r11 = new ArrayList();
    L8:
        if (r9 == null) goto L11;
        if (r9 == r8) goto L11;
        r11.add(r9);
        r9 = (View) r9.getParent();
    L11:
        Matrix r12 = new Matrix();
        int r4 = r11.size() - 1;
    L12:
        if (r4 < 0) goto L21;
        View r5 = (View) ListProtector.get(r11, r4);
        r1[0] = r1[0] + r8.getScrollX();
        r1[1] = r1[1] + r8.getScrollY();
        r1[0] = r1[0] - r5.getLeft();
        r1[1] = r1[1] - r5.getTop();
        if (r5.getMatrix().isIdentity() == true) goto L19;
        r12.reset();
        if (r5.getMatrix().invert(r12) == false) goto L18;
        float[] r13 = {r1[0], r1[1]};
        r12.mapPoints(r13);
        r1[0] = r13[0];
        r1[1] = r13[1];
        goto L19
    L18:
        r1[0] = Float.MAX_VALUE;
        r1[1] = Float.MAX_VALUE;
    L19:
        r4 = r4 - 1;
        r8 = r5;
        goto L12
    L21:
        return new PointF(r1[0], r1[1]);
    L22:
        LLog.e("ViewHelper", "convertPointFromAncestorToDescendant failed since ancestor or descendant is null");
        return r10;
    }

    public static PointF b(View r6, View r7, PointF r8) {
        if (r7 == null) goto L21;
        if (r6 == null) goto L21;
        if (r7 != r6) goto L8;
        return r8;
    L8:
        float[] r1 = {r8.x, r8.y};
        if (r6.getMatrix().isIdentity() == true) goto L11;
        r6.getMatrix().mapPoints(r1);
    L11:
        if (r6 == r7) goto L20;
        View r9 = (View) r6.getParent();
        if (r9 == null) goto L14;
        r1[0] = r1[0] + r6.getLeft();
        r1[1] = r1[1] + r6.getTop();
        r1[0] = r1[0] - r9.getScrollX();
        r1[1] = r1[1] - r9.getScrollY();
        if (r9.getMatrix().isIdentity() == true) goto L18;
        r9.getMatrix().mapPoints(r1);
    L18:
        r6 = r9;
        goto L11
    L14:
        LLog.e("ViewHelper", "convertPointFromDescendantToAncestor failed, parent is null.");
    L20:
        return new PointF(r1[0], r1[1]);
    L21:
        LLog.e("ViewHelper", "convertPointFromAncestorToDescendant failed since view or another is null");
        return r8;
    }

    public static PointF c(View r1, View r2, PointF r3) {
        if (r1 == null) goto L17;
        if (r2 == null) goto L17;
        if (r1 != r2) goto L8;
        return r3;
    L8:
        if (f(r1, r2) == false) goto L12;
        return a(r1, r2, r3);
    L12:
        if (f(r2, r1) == true) goto L14;
        PointF r4 = b(r1, r1.getRootView(), r3);
        return a(r2.getRootView(), r2, r4);
    L14:
        return b(r1, r2, r3);
    L17:
        LLog.e("ViewHelper", "convertPointFromAncestorToDescendant failed since view or another is null");
        return r3;
    }

    public static RectF d(View r5, View r6, RectF r7) {
        if (r5 == null) goto L7;
        if (r5 != r6) goto L5;
        return r7;
    L5:
        PointF r0 = new PointF(r7.left, r7.top);
        PointF r1 = new PointF(r7.right, r7.top);
        PointF r2 = new PointF(r7.left, r7.bottom);
        PointF r3 = new PointF(r7.right, r7.bottom);
        PointF r8 = a(r5, r6, r0);
        PointF r4 = a(r5, r6, r1);
        PointF r9 = a(r5, r6, r2);
        PointF r10 = a(r5, r6, r3);
        RectF r11 = new RectF();
        r11.left = Math.min(Math.min(r8.x, r4.x), Math.min(r9.x, r10.x));
        r11.top = Math.min(Math.min(r8.y, r4.y), Math.min(r9.y, r10.y));
        r11.right = Math.max(Math.max(r8.x, r4.x), Math.max(r9.x, r10.x));
        r11.bottom = Math.max(Math.max(r8.y, r4.y), Math.max(r9.y, r10.y));
        return r11;
    L7:
        LLog.e("ViewHelper", "convertPointFromAncestorToDescendant failed since ancestor or descendant is null");
        return r7;
    }

    public static RectF e(View r5, View r6, RectF r7) {
        if (r6 == null) goto L7;
        if (r6 != r5) goto L5;
        return r7;
    L5:
        PointF r0 = new PointF(r7.left, r7.top);
        PointF r1 = new PointF(r7.right, r7.top);
        PointF r2 = new PointF(r7.left, r7.bottom);
        PointF r3 = new PointF(r7.right, r7.bottom);
        PointF r8 = b(r5, r6, r0);
        PointF r4 = b(r5, r6, r1);
        PointF r9 = b(r5, r6, r2);
        PointF r10 = b(r5, r6, r3);
        RectF r11 = new RectF();
        r11.left = Math.min(Math.min(r8.x, r4.x), Math.min(r9.x, r10.x));
        r11.top = Math.min(Math.min(r8.y, r4.y), Math.min(r9.y, r10.y));
        r11.right = Math.max(Math.max(r8.x, r4.x), Math.max(r9.x, r10.x));
        r11.bottom = Math.max(Math.max(r8.y, r4.y), Math.max(r9.y, r10.y));
        return r11;
    L7:
        LLog.e("ViewHelper", "convertPointFromAncestorToDescendant failed since ancestor or descendant is null");
        return r7;
    }
}
