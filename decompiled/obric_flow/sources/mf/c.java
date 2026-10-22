package mf;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.lynx.map.ng.LynxMapMarker;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.utils.p;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends com.lynx.tasm.behavior.ui.view.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LynxMapMarker f20067a;

    public c(Context r5) {
        super(r5);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [android.view.View] */
    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        if (r10.getActionMasked() != 0) goto L40;
        this.f20067a.recognizeGesturere();
        MotionEvent r5 = MotionEvent.obtain(r10);
        float r11 = r10.getX() + this.f20067a.getMarkerLeft();
        float r12 = r10.getY() + this.f20067a.getMarkerTop();
        LynxBaseUI r13 = this.f20067a.getMapUI();
        if (r13 == null) goto L38;
        PointF r14 = new PointF(r11, r12);
        LynxContext r15 = r13.getLynxContext();
        if (r15 != null) goto L10;
        LynxLog.b(4, "LynxUIHelper", "convertPointFromUIToRootUI failed since context is null");
    L37:
        r5.setLocation(r14.x, r14.y);
        goto L38
    L10:
        UIBody r16 = r15.f10145m;
        if (r16 != null) goto L13;
        LynxLog.b(4, "LynxUIHelper", "convertPointFromUIToRootUI failed since root ui is null");
        goto L37
    L13:
        if (r13 == r16) goto L37;
        PointF r17 = new PointF(r14.x, r14.y);
        if (r13.isFlatten() == false) goto L21;
        r17.x += r13.getLeft();
        r17.y += r13.getTop();
        if (r13.getDrawParent() != null) goto L20;
        LynxLog.b(4, "LynxUIHelper", "mDrawParent of flattenUI is null, which causes the value convertPointFromUIToRootUI returns is not the correct coordinates relative to the root ui!");
        goto L37
    L20:
        View r18 = ((LynxUI) r13.getDrawParent()).getView();
        r17.x -= r18.getScrollX();
        r17.y -= r18.getScrollY();
    L22:
        ?? r19 = r16.getView();
        if (r18 == null) goto L35;
        if (r19 == 0) goto L35;
        if (r18 != r19) goto L29;
    L36:
        r14 = r17;
        goto L37
    L29:
        if (p.k(r18, r19) == false) goto L32;
        r14 = p.a(r18, r19, r17);
        goto L37
    L32:
        if (p.k(r19, r18) == false) goto L34;
        r14 = p.m(r18, r19, r17);
        goto L37
    L34:
        r14 = p.a(r19.getRootView(), r19, p.m(r18, r18.getRootView(), r17));
    L35:
        LynxLog.b(4, "ViewHelper", "convertPointFromAncestorToDescendant failed since view or another is null");
        goto L36
    L21:
        r18 = ((LynxUI) r13).getView();
    L38:
        r5.setAction(1);
        this.f20067a.onTouchUp(r5);
    L40:
        return super.dispatchTouchEvent(r10);
    }

    @Override // com.lynx.tasm.behavior.ui.view.b, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        ViewParent r14 = getParent();
        if ((r14 instanceof ViewGroup) == false) goto L5;
        ((ViewGroup) r14).setClipChildren(false);
    L5:
        this.f20067a.setMarkerLayoutParams(r10, r11, r12, r13);
        this.mDrawChildHook.performLayoutChildrenUI();
    }

    @Override // com.lynx.tasm.behavior.ui.view.b, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        setMeasuredDimension(this.f20067a.getMarkerWidth(), this.f20067a.getMarkerHeight());
        this.mDrawChildHook.performMeasureChildrenUI();
    }
}
