package x6a;

import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.renderscript.Matrix4f;
import android.view.View;
import android.view.ViewGroup;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.utils.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class d {
    public static int e(e r0) {
        View r1 = r0.getView();
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.getHeight();
    }

    public static int f(e r0) {
        View r1 = r0.getView();
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.getScrollX();
    }

    public static int g(e r0) {
        View r1 = r0.getView();
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.getScrollY();
    }

    public static int h(e r0) {
        View r1 = r0.getView();
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.getWidth();
    }

    public static void i(e r0) {
        View r1 = r0.getView();
        if (r1 == null) goto L6;
        r1.invalidate();
        return;
    }

    public static void j(e r0) {
        View r1 = r0.getView();
        if (r1 == null) goto L6;
        r1.requestLayout();
        return;
    }

    public static void b(e r0, float r1) {
        View r2 = r0.getView();
        if (r2 == null) goto L6;
        r2.setAlpha(r1);
        return;
    }

    public static void c(e r2, float[] r3) {
        View r4 = r2.getView();
        if (r4 != null) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        r4.setAnimationMatrix(i.d(r3));
        return;
    L9:
        m r0 = new m();
        Matrix4f r1 = new Matrix4f(r3);
        com.lynx.tasm.utils.h.a r5 = new com.lynx.tasm.utils.h.a();
        r5.a();
        com.lynx.tasm.utils.h.a(m.b(r1.getArray()), r5);
        r0.l(r5);
        r4.setTranslationX(r0.h());
        r4.setTranslationY(r0.i());
        r4.setTranslationZ(r0.j());
        r4.setRotation(r0.c());
        r4.setRotationX(r0.d());
        r4.setRotationY(r0.e());
        r4.setScaleX(r0.f());
        r4.setScaleY(r0.g());
    }

    public static PointF d(e r7, PointF r8) {
        View r9 = r7.getView();
        if (r9 != null) goto L5;
        return r8;
    L5:
        int[] r1 = new int[2];
        r9.getRootView().getLocationOnScreen(r1);
        float[] r0 = {r8.x, r8.y};
        if (r9.getMatrix().isIdentity() == true) goto L8;
        r9.getMatrix().mapPoints(r0);
    L8:
        View r10 = r9.getRootView();
    L9:
        if (r9 == r10) goto L17;
        View r4 = (View) r9.getParent();
        if (r4 == null) goto L12;
        r0[0] = r0[0] + r9.getLeft();
        r0[1] = r0[1] + r9.getTop();
        r0[0] = r0[0] - r4.getScrollX();
        r0[1] = r0[1] - r4.getScrollY();
        if (r4.getMatrix().isIdentity() == true) goto L16;
        r4.getMatrix().mapPoints(r0);
    L16:
        r9 = r4;
        goto L9
    L12:
        LLog.e("LynxUIHelper", "transformFromViewToRootView failed, parent is null.");
    L17:
        r0[0] = r0[0] + r1[0];
        r0[1] = r0[1] + r1[1];
        return new PointF(r0[0], r0[1]);
    }

    public static void k(e r1, boolean r2) {
        View r3 = r1.getView();
        if ((r3 instanceof ViewGroup) == false) goto L6;
        ((ViewGroup) r3).setClipChildren(r2);
        return;
    }

    public static void l(e r0, boolean r1) {
        View r2 = r0.getView();
        if (r2 == null) goto L6;
        r2.setWillNotDraw(r1);
        return;
    }

    public static void a(e r0, boolean r1, Rect r2) {
        View r3 = r0.getView();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r1 == true) goto L8;
        r2 = null;
    L8:
        r3.setClipBounds(r2);
    }
}
