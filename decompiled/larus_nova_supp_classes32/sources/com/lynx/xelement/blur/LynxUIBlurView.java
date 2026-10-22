package com.lynx.xelement.blur;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RenderNode;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.view.UIView;
import com.lynx.tasm.utils.n;
import n8a.a;
import n8a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@LynxBehavior(isCreateAsync = false, tagName = {"blur-view"})
@LynxGeneratorName(packageName = "com.lynx.xelement.blur")
public class LynxUIBlurView<T extends a> extends UIView {
    public final int[] a;
    public final int[] b;
    public final int[] c;
    public View d;
    public boolean e;
    public String f;

    public final View N() {
        if (this.mView == 0) goto L16;
        String r0 = this.f;
        if (r0 == null) goto L16;
        if (r0.isEmpty() == true) goto L16;
        if (this.mContext.getLynxView() == null) goto L16;
        View r1 = this.mContext.getLynxView().findViewByIdSelector(this.f);
        if (r1 != null) goto L14;
        return null;
    L14:
        P(this, this.a);
        r1.getLocationOnScreen(this.c);
        ((a) this.mView).setBlurViewLocation(this.a);
        ((a) this.mView).setRootLocation(this.c);
        int[] r2 = this.a;
        int r3 = r2[0];
        int r4 = r2[1];
        int r5 = getWidth() + r3;
        int r6 = getHeight() + r4;
        int[] r7 = this.c;
        int r8 = r7[0];
        int r9 = r7[1];
        int r10 = r1.getWidth() + r8;
        int r11 = r1.getHeight() + r9;
        int r12 = Math.max(r3, r8);
        int r13 = Math.max(r4, r9);
        int r14 = Math.min(r5, r10);
        int r15 = Math.min(r6, r11);
        a r16 = (a) this.mView;
        int r17 = r15 - r4;
        Rect r18 = r16.m;
        r18.set(r12 - r3, r13 - r4, r14 - r3, r17);
        r16.n = true;
        return r1;
    L16:
        return null;
    }

    public final LynxBaseUI O() {
        LynxBaseUI r0 = getParentBaseUI();
        P(this, this.a);
        ((a) this.mView).setBlurViewLocation(this.a);
        a r1 = (a) this.mView;
        r1.m.setEmpty();
        r1.n = false;
    L4:
        if ((r0 instanceof UIBody) == true) goto L23;
        if (r0 == null) goto L23;
        if (r0.getOverflow() == 0) goto L9;
        int[] r2 = this.a;
        int r3 = r2[0];
        boolean r4 = true;
        int r5 = r2[1];
        int r6 = getWidth() + r3;
        int r7 = getHeight() + r5;
        P(r0, this.b);
        int[] r8 = this.b;
        int r9 = r8[0];
        int r10 = r8[1];
        if (r0.isFlatten() == false) goto L13;
        r9 = r9 + r0.getLeft();
        r10 = r10 + r0.getTop();
    L13:
        int r11 = r0.getWidth() + r9;
        int r12 = r0.getHeight() + r10;
        ((a) this.mView).setRootLocation(this.b);
        if (r3 < r9) goto L19;
        if (r5 < r10) goto L19;
        if (r6 > r11) goto L19;
        if (r7 > r12) goto L19;
    L20:
        if (r4 == true) goto L23;
        r0 = r0.getParentBaseUI();
    L19:
        r4 = false;
        goto L20
    L9:
        P(r0, this.b);
        ((a) this.mView).setRootLocation(this.b);
    L23:
        return r0;
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIView, com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        T r0 = this.mView;
        if (r0 == 0) goto L22;
        a r1 = (a) r0;
        r1.u = true;
        TraceEvent.beginSection("BlurView.destroy");
        r1.getViewTreeObserver().removeOnPreDrawListener(r1);
        r1.o = false;
        r1.q = false;
        RenderNode r2 = r1.a;
        if (r2 == null) goto L7;
        r2.discardDisplayList();
        r1.a = null;
    L7:
        Object r3 = r1.r;
        monitor-enter(r3);
        RenderScript r4 = r1.s;     // Catch: Throwable -> L19
        ScriptIntrinsicBlur r5 = r1.t;     // Catch: Throwable -> L19
        r1.s = null;     // Catch: Throwable -> L19
        r1.t = null;     // Catch: Throwable -> L19
        monitor-exit(r3);     // Catch: Throwable -> L19
        if (r4 == null) goto L13;
        r4.destroy();
    L13:
        if (r5 == null) goto L15;
        r5.destroy();
    L15:
        Allocation r6 = r1.v;
        if (r6 == null) goto L18;
        r6.destroy();
        r1.v = null;
    L18:
        r1.l = null;
        r1.m.setEmpty();
        r1.n = false;
        r1.f = null;
        r1.k = null;
        r1.g = null;
        r1.d = false;
        TraceEvent.endSection("BlurView.destroy");
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        if (this.e == false) goto L6;
        ((a) this.mView).f(getWidth(), getHeight());
        return;
    }

    public T M(Context r2) {
        return (T) new a(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIView, com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r1) {
        a r2 = M(r1);
        r2.setLynxBaseUI(this);
        return r2;
    }

    @LynxUIMethod
    public void enableAutoBlur(ReadableMap r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.hasKey("enable") == false) goto L7;
        boolean r4 = r3.getBoolean("enable");
    L8:
        T r0 = this.mView;
        if (r0 == 0) goto L12;
        ((a) r0).setEnableBlurAutoUpdate(r4);
        return;
    L12:
        return;
    L7:
        r4 = false;
        goto L8
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onBorderRadiusUpdated(int r2) {
        super.onBorderRadiusUpdated(r2);
        T r3 = this.mView;
        if (r3 == 0) goto L6;
        ((a) r3).setHasRadiusIfRadiusChanged(getHasRadius());
        return;
    }

    @LynxProp(defaultInt = 0, name = "blur-radius")
    public void setBlurRadius(String r8) {
        if (this.mView == 0) goto L6;
        UIBody r0 = this.mContext.getUIBody();
        ((a) this.mView).setBlurRadius(Math.round(n.c(r8, r0.getFontSize(), this.mFontSize, r0.getWidth(), r0.getHeight(), this.mContext.getScreenMetrics())));
        return;
    }

    @LynxProp(name = "android-capture-target")
    public void setCaptureTarget(String r2) {
        this.f = r2;
        T r3 = this.mView;
        if (r3 == 0) goto L9;
        a r4 = (a) r3;
        if (r4.c == false) goto L10;
        r4.post(new c(r4));
        return;
    L10:
        return;
    }

    @LynxProp(defaultBoolean = true, name = "enable-auto-blur")
    public void setEnableAutoBlur(boolean r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((a) r0).setEnableBlurAutoUpdate(r2);
        return;
    }

    @LynxProp(name = "experimental-update-blur-radius")
    public void setExperimentalUpdateBlurRadius(boolean r2) {
        this.e = r2;
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((a) r0).setExperimentalUpdateBlurRadius(r2);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIView, com.lynx.tasm.behavior.ui.LynxUI
    public final com.lynx.tasm.behavior.ui.view.a createView(Context r1) {
        a r2 = M(r1);
        r2.setLynxBaseUI(this);
        return r2;
    }

    public LynxUIBlurView(LynxContext r1, Object r2) {
        super(r1, r2);
        this.a = new int[2];
        this.b = new int[2];
        this.c = new int[2];
        this.e = true;
    }

    public final void P(LynxBaseUI r2, int[] r3) {
        if (r2.isFlatten() == false) goto L9;
        View r4 = ((LynxUI) r2.getDrawParent()).getView();
        if (r4 != null) goto L7;
        return;
    L7:
        if (this.d == r4) goto L14;
        this.d = r4;
        r4.getLocationOnScreen(r3);
        return;
    L14:
        return;
    L9:
        View r5 = ((LynxUI) r2).getView();
        if (r5 == null) goto L16;
        r5.getLocationOnScreen(r3);
        return;
    }
}
