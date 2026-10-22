package com.google.android.material.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<Matrix> f3970a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<RectF> f3971b = null;

    static {
        f3970a = new ThreadLocal();
        f3971b = new ThreadLocal();
    }

    public static void a(ViewGroup r4, View r5, Rect r6) {
        ThreadLocal<Matrix> r0 = f3970a;
        Matrix r1 = (Matrix) ZeusTransformUtils.preCheckCast(r0.get(), Matrix.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        r1 = new Matrix();
        r0.set(r1);
    L6:
        a(r4, r5, r1);
        ThreadLocal<RectF> r7 = f3971b;
        RectF r8 = (RectF) ZeusTransformUtils.preCheckCast(r7.get(), RectF.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L9;
        r8 = new RectF();
        r7.set(r8);
    L9:
        r8.set(r6);
        r1.mapRect(r8);
        r6.set((int) (r8.left + 0.5f), (int) (r8.top + 0.5f), (int) (r8.right + 0.5f), (int) (r8.bottom + 0.5f));
        return;
    L5:
        r1.reset();
        goto L6
    }

    private static void a(ViewParent r3, View r4, Matrix r5) {
        ViewParent r6 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r3, ViewParent.class, "com.obric.memorydata.plugin");
        ViewParent r0 = r4.getParent();
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L6;
        if (r0 == r6) goto L6;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
        a(r6, r1, r5);
        r5.preTranslate(-r1.getScrollX(), -r1.getScrollY());
    L6:
        r5.preTranslate(r4.getLeft(), r4.getTop());
        if (r4.getMatrix().isIdentity() == true) goto L10;
        r5.preConcat(r4.getMatrix());
        return;
    }

    public static void b(ViewGroup r3, View r4, Rect r5) {
        r5.set(0, 0, r4.getWidth(), r4.getHeight());
        a(r3, r4, r5);
    }
}
