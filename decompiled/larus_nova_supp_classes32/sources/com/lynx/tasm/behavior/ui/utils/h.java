package com.lynx.tasm.behavior.ui.utils;

import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h {
    /* JADX WARN: Type inference failed for: r6v1, types: [android.view.View] */
    public static PointF b(LynxBaseUI r5, PointF r6) {
        if (r5 != null) goto L6;
        LLog.e("LynxUIHelper", "convertPointFromUIToRootUI failed since descendant ui is null");
        return r6;
    L6:
        LynxContext r1 = r5.getLynxContext();
        if (r1 != null) goto L10;
        LLog.e("LynxUIHelper", "convertPointFromUIToRootUI failed since context is null");
        return r6;
    L10:
        UIBody r2 = r1.getUIBody();
        if (r2 != null) goto L14;
        LLog.e("LynxUIHelper", "convertPointFromUIToRootUI failed since root ui is null");
        return r6;
    L14:
        if (r5 != r2) goto L16;
        return r6;
    L16:
        PointF r3 = new PointF(r6.x, r6.y);
        if (r5.isFlatten() == false) goto L23;
        r3.x += r5.getLeft();
        r3.y += r5.getTop();
        if (r5.getDrawParent() != null) goto L22;
        LLog.e("LynxUIHelper", "mDrawParent of flattenUI is null, which causes the value convertPointFromUIToRootUI returns is not the correct coordinates relative to the root ui!");
        return r6;
    L22:
        View r7 = ((LynxUI) r5.getDrawParent()).getView();
        r3.x -= r7.getScrollX();
        r3.y -= r7.getScrollY();
    L25:
        return o.c(r7, r2.getView(), r3);
    L23:
        r7 = ((LynxUI) r5).getView();
        goto L25
    }

    public static PointF c(LynxBaseUI r4, PointF r5) {
        if (r4 != null) goto L6;
        LLog.e("LynxUIHelper", "convertPointFromUIToScreen failed since ui is null");
        return r5;
    L6:
        PointF r1 = new PointF(r5.x, r5.y);
        if (r4.isFlatten() == false) goto L13;
        r1.x += r4.getLeft();
        r1.y += r4.getTop();
        if (r4.getDrawParent() != null) goto L12;
        LLog.e("LynxUIHelper", "mDrawParent of flattenUI is null, which causes the value convertPointFromUIToScreen returns is not the correct coordinates relative to the screen!");
        return r5;
    L12:
        View r6 = ((LynxUI) r4.getDrawParent()).getView();
        r1.x -= r6.getScrollX();
        r1.y -= r6.getScrollY();
    L15:
        return o.b(r6, r6.getRootView(), r1);
    L13:
        r6 = ((LynxUI) r4).getView();
        goto L15
    }

    public static RectF e(LynxBaseUI r2, RectF r3) {
        LynxContext r0 = r2.getLynxContext();
        if (r0 != null) goto L6;
        LLog.e("LynxUIHelper", "convertRectFromUIToRootUI failed since context is null");
        return r3;
    L6:
        UIBody r1 = r0.getUIBody();
        if (r1 != null) goto L11;
        LLog.e("LynxUIHelper", "convertRectFromUIToRootUI failed since rootUI is null");
        return r3;
    L11:
        return d(r2, r1, r3);
    }

    public static RectF f(LynxBaseUI r6, RectF r7) {
        if (r6 != null) goto L6;
        LLog.e("LynxUIHelper", "convertRectFromUIToScreen failed since ancestor or descendant is null");
        return r7;
    L6:
        RectF r1 = new RectF(r7.left, r7.top, r7.right, r7.bottom);
        if (r6.isFlatten() == false) goto L13;
        r1.left += r6.getLeft();
        r1.top += r6.getTop();
        if (r6.getDrawParent() != null) goto L12;
        LLog.e("LynxUIHelper", "mDrawParent of flattenUI is null, which causes the value convertRectFromUIToScreen returns is not the correct coordinates relative to the screen!");
        return r7;
    L12:
        View r8 = ((LynxUI) r6.getDrawParent()).getView();
        r1.left -= r8.getScrollX();
        r1.top -= r8.getScrollY();
        r1.right = r1.left + r7.width();
        r1.bottom = r1.top + r7.height();
    L15:
        return o.e(r8, r8.getRootView(), r1);
    L13:
        r8 = ((LynxUI) r6).getView();
        goto L15
    }

    public static RectF g(LynxBaseUI r4, ReadableMap r5) {
        if (r5 == null) goto L41;
        if (r5.getBoolean("androidEnableTransformProps", false) == false) goto L41;
        LynxBaseUI r2 = null;
        if (r5.hasKey("relativeTo") == true) goto L8;
    L11:
        String r6 = null;
    L13:
        if (r4 == null) goto L30;
        if (r6 == null) goto L30;
        com.lynx.tasm.behavior.ui.k r1 = r4.getParent();
    L17:
        LynxBaseUI r3 = (LynxBaseUI) r1;
        if ((r3 instanceof LynxBaseUI) == false) goto L24;
        if (r6.equals(r3.getIdSelector()) == true) goto L21;
        r1 = r3.getParent();
        goto L17
    L21:
        r2 = r3;
    L32:
        if ("screen".equals(r6) == true) goto L34;
        if (r2 == null) goto L39;
        return d(r4, r2, new RectF(0.0f, 0.0f, r4.getWidth(), r4.getHeight()));
    L39:
        return e(r4, new RectF(0.0f, 0.0f, r4.getWidth(), r4.getHeight()));
    L34:
        return f(r4, new RectF(0.0f, 0.0f, r4.getWidth(), r4.getHeight()));
    L24:
        if (r4.getLynxContext() != null) goto L27;
        LLog.e("LynxUIHelper", "getRelativeUI failed since context is null");
        goto L32
    L27:
        if (r4.getLynxContext().getLynxUIOwner() != null) goto L29;
        LLog.e("LynxUIHelper", "getRelativeUI failed since uiowner is null");
        goto L32
    L29:
        r2 = r4.getLynxContext().getLynxUIOwner().findLynxUIByIdSelector(r6);
    L30:
        LLog.e("LynxUIHelper", "getRelativeUI failed since ui or relativeID is null");
        goto L32
    L8:
        if (r5.getString("relativeTo") == null) goto L11;
        r6 = r5.getString("relativeTo");
    L41:
        return new RectF(r4.getBoundingClientRect());
    }

    public static int h(LynxContext r2, float r3) {
        if (r2 == null) goto L11;
        if (r2.getResources() == null) goto L11;
        Resources r0 = r2.getResources();
        if (WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()) == null) goto L11;
        Resources r4 = r2.getResources();
        return (int) (((double) (r3 / WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density)) + 0.5d);
    L11:
        return (int) r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    public static PointF a(UIBody r6, LynxBaseUI r7, PointF r8) {
        if (r6 != null) goto L6;
        LLog.e("LynxUIHelper", "convertPointFromUIToAnotherUI failed since ui is null");
        return r8;
    L6:
        if (r7 != null) goto L9;
        LLog.e("LynxUIHelper", "convertPointFromUIToAnotherUI failed since another ui is null");
        return r8;
    L9:
        if (r6 != r7) goto L11;
        return r8;
    L11:
        PointF r1 = new PointF(r8.x, r8.y);
        if (r6.isFlatten() == false) goto L18;
        r1.x += r6.getLeft();
        r1.y += r6.getTop();
        if (r6.getDrawParent() != null) goto L17;
        LLog.e("LynxUIHelper", "mDrawParent of flattenUI is null, which causes the value convertPointFromUIToAnotherUI returns is not the correct coordinates relative to the another ui!");
        return r8;
    L17:
        View r9 = ((LynxUI) r6.getDrawParent()).getView();
        r1.x -= r9.getScrollX();
        r1.y -= r9.getScrollY();
        ?? r10 = r9;
    L19:
        float r4 = 0.0f;
        if (r7.isFlatten() == false) goto L26;
        float r2 = r7.getLeft() + 0.0f;
        float r5 = r7.getTop() + 0.0f;
        if (r7.getDrawParent() != null) goto L25;
        LLog.e("LynxUIHelper", "mDrawParent of flattenUI is null, which causes the value convertPointFromUIToAnotherUI returns is not the correct coordinates relative to the another ui!");
        return r8;
    L25:
        View r11 = ((LynxUI) r7.getDrawParent()).getView();
        r4 = r2 - r11.getScrollX();
        float r12 = r5 - r11.getScrollY();
    L27:
        PointF r13 = o.c(r10, r11, r1);
        r13.offset(-r4, -r12);
        return r13;
    L26:
        r11 = ((LynxUI) r7).getView();
        r12 = 0.0f;
        goto L27
    L18:
        r10 = r6.getView();
        goto L19
    }

    public static RectF d(LynxBaseUI r6, LynxBaseUI r7, RectF r8) {
        if (r6 != null) goto L6;
        LLog.e("LynxUIHelper", "convertRectFromUIToRootUI failed since descendant is null");
        return r8;
    L6:
        if (r6 != r7) goto L8;
        return r8;
    L8:
        RectF r1 = new RectF(r8.left, r8.top, r8.right, r8.bottom);
        if (r6.isFlatten() == false) goto L15;
        r1.left += r6.getLeft();
        r1.top += r6.getTop();
        if (r6.getDrawParent() != null) goto L14;
        LLog.e("LynxUIHelper", "mDrawParent of flattenUI is null, which causes the value convertRectFromUIToAnotherUI returns is not the correct coordinates relative to the another ui!");
        return r8;
    L14:
        View r9 = ((LynxUI) r6.getDrawParent()).getView();
        r1.left -= r9.getScrollX();
        r1.top -= r9.getScrollY();
        r1.right = r1.left + r8.width();
        r1.bottom = r1.top + r8.height();
    L16:
        float r4 = 0.0f;
        if (r7.isFlatten() == false) goto L23;
        float r2 = r7.getLeft() + 0.0f;
        float r5 = r7.getTop() + 0.0f;
        if (r7.getDrawParent() != null) goto L22;
        LLog.e("LynxUIHelper", "mDrawParent of flattenUI is null, which causes the value convertRectFromUIToAnotherUI returns is not the correct coordinates relative to the another ui!");
        return r8;
    L22:
        View r10 = ((LynxUI) r7.getDrawParent()).getView();
        r4 = r2 - r10.getScrollX();
        float r11 = r5 - r10.getScrollY();
    L24:
        if (r9 == null) goto L36;
        if (r10 == null) goto L36;
        if (r9 != r10) goto L30;
    L37:
        r1.offset(-r4, -r11);
        return r1;
    L30:
        if (o.f(r9, r10) == false) goto L33;
        r1 = o.d(r9, r10, r1);
        goto L37
    L33:
        if (o.f(r10, r9) == false) goto L35;
        r1 = o.e(r9, r10, r1);
        goto L37
    L35:
        r1 = o.d(r10.getRootView(), r10, o.e(r9, r9.getRootView(), r1));
    L36:
        LLog.e("ViewHelper", "convertRectFromViewToAnother failed since view or another is null");
        goto L37
    L23:
        r10 = ((LynxUI) r7).getView();
        r11 = 0.0f;
        goto L24
    L15:
        r9 = ((LynxUI) r6).getView();
        goto L16
    }
}
