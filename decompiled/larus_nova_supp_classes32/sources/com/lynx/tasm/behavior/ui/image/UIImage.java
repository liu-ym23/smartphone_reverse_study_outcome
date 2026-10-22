package com.lynx.tasm.behavior.ui.image;

import android.graphics.Canvas;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.ILynxUIMeaningfulContent$MeaningfulContentStatus;
import com.lynx.tasm.behavior.ui.e;
import com.lynx.tasm.behavior.ui.j;
import com.lynx.tasm.behavior.ui.m;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.view.UIView;
import com.lynx.tasm.behavior.ui.view.a;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.event.EventsListener;
import d7a.f;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIImage extends UIView {
    public f a;

    @Override // com.lynx.tasm.behavior.ui.view.UIView, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getInitialOverflowType() {
        return 0;
    }

    public final void M() {
        if (this.a == null) goto L5;
        return;
    L5:
        f r0 = new f(getLynxContext());
        this.a = r0;
        r0.T = this;
        r0.t(this.mEvents);
        this.a.A(this.mProps);
        this.a.l(getWidth(), getHeight(), getPaddingLeft(), getPaddingRight(), getPaddingTop(), getPaddingBottom());
        this.a.m();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final ILynxUIMeaningfulContent$MeaningfulContentStatus getMeaningfulContentStatus() {
        f r0 = this.a;
        if (r0 == null) goto L9;
        if (r0.e().booleanValue() == false) goto L9;
        return ILynxUIMeaningfulContent$MeaningfulContentStatus.PRESENTED;
    L9:
        return ILynxUIMeaningfulContent$MeaningfulContentStatus.PENDING;
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIView, com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        f r0 = this.a;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final long getMemoryUsageBytes() {
        long r0 = super.getMemoryUsageBytes();
        f r2 = this.a;
        if (r2 != null) goto L6;
        return r0;
    L6:
        if (r2.j != null) goto L8;
        long r3 = 0;
    L10:
        return r3 + r0;
    L8:
        r3 = r2.Q;
        goto L10
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Map<String, String> getMemoryUsageDetail() {
        long r0 = getMemoryUsageBytes();
        f r2 = this.a;
        if (r2 == null) goto L5;
        String r3 = r2.d;
    L7:
        if (r0 == 0) goto L16;
        if (r3 != null) goto L10;
        return null;
    L10:
        if (r3.isEmpty() == false) goto L12;
        return null;
    L12:
        if (r3.startsWith("data:image") == true) goto L19;
        HashMap r4 = new HashMap();
        r4.put(r3, String.valueOf(r0));
        return r4;
    L19:
        return null;
    L16:
        return null;
    L5:
        r3 = null;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        M();
        super.onLayoutUpdated();
        this.a.l(getWidth(), getHeight(), getPaddingLeft(), getPaddingRight(), getPaddingTop(), getPaddingBottom());
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        M();
        super.onNodeReady();
        BackgroundDrawable r0 = (BackgroundDrawable) this.mLynxBackground.b;
        if (r0 == null) goto L11;
        this.a.s(r0.b());
        if (this.mLynxBackground.m() == null) goto L11;
        boolean r1 = this.mLynxBackground.m().d(getWidth(), getHeight());
        f r2 = this.a;
        float[] r3 = this.mLynxBackground.m().a();
        if (r2.M == null) goto L9;
        if (r1 == true) goto L9;
    L10:
        r2.M = r3;
    L9:
        r2.a |= 4096;
    L11:
        this.a.m();
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIView, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        M();
        super.onPropsUpdated();
        this.a.getClass();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onAttach() {
        super.onAttach();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onDetach() {
        super.onDetach();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.IDrawChildHook
    public final void beforeDraw(Canvas r2) {
        M();
        super.beforeDraw(r2);
        this.a.i(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.a
    public final void beforeProcessViewInfo(m r3) {
        M();
        f r0 = this.a;
        if (r0 == null) goto L5;
        this.mViewInfo.q = r0;
    L5:
        super.beforeProcessViewInfo(r3);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void detachWithViewInfo(m r5) {
        f r0 = this.a;
        if (r0 == null) goto L9;
        r0.T = null;
        m r2 = this.mViewInfo;
        if (r2 != null) goto L8;
        r2 = r5;
    L8:
        r0.U = r2;
        getLynxContext().getUIBodyView().registerImageAccordingToNodeIndex(this.mNodeIndex, this.a);
        this.a = null;
    L9:
        super.detachWithViewInfo(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r2) {
        M();
        super.setEvents(r2);
        this.a.t(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setImageRendering(int r3) {
        M();
        super.setImageRendering(r3);
        f r0 = this.a;
        if (r3 != 2) goto L5;
        boolean r4 = true;
    L6:
        r0.v1 = r4;
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updatePropertiesInterval(x0 r2) {
        M();
        super.updatePropertiesInterval(r2);
        this.a.A(r2.a);
    }

    public UIImage(LynxContext r2, Object r3) {
        super(r2, r3);
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L12;
        if (r0.isFallbackProcess() == false) goto L12;
        if (this.mContext.getUIBodyView() == null) goto L12;
        if ((r3 instanceof j) == false) goto L12;
        setNodeIndex(((j) r3).b);
        this.a = r2.getUIBodyView().obtainImageAccordingToNodeIndex(this.mNodeIndex);
    L12:
        if (this.a != null) goto L14;
        this.a = new f(getLynxContext());
    L14:
        this.a.T = this;
        ((a) this.mView).setWillNotDraw(false);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final e convertToMeaningfulPaintingArea(int r5, int r6) {
        if (getMeaningfulContentStatus() != ILynxUIMeaningfulContent$MeaningfulContentStatus.IRRELEVANT) goto L6;
        return null;
    L6:
        f r0 = this.a;
        if (r0 == null) goto L12;
        f.e r1 = r0.V1;
        if (r1 == null) goto L12;
        r1.b();
    L12:
        int r7 = r5 + getOriginLeft();
        int r8 = r6 + getOriginTop();
        int r2 = getWidth();
        int r3 = getHeight();
        f r4 = this.a;
        if (r4 == null) goto L15;
        r4.e().booleanValue();
    L15:
        e r9 = new e(r7, r8, r2, r3);
        T r10 = this.mView;
        if (r10 == 0) goto L18;
        ((a) r10).getAlpha();
    L19:
        T r11 = this.mView;
        if (r11 == 0) goto L22;
        ((a) r11).getScaleX();
    L23:
        T r12 = this.mView;
        if (r12 == 0) goto L26;
        ((a) r12).getScaleY();
    L27:
        T r13 = this.mView;
        if (r13 == 0) goto L30;
        ((a) r13).getVisibility();
    L31:
        r9.e = getMeaningfulContentStatus();
        r9.f = getFirstMeaningfulContentPresentedTimestampMicros();
        return r9;
    L30:
        getVisibility();
        goto L31
    L26:
        getScaleY();
        goto L27
    L22:
        getScaleX();
        goto L23
    L18:
        getAlpha();
        goto L19
    }

    @LynxUIMethod
    public void pauseAnimation(ReadableMap r1, Callback r2) {
        M();
        this.a.n(r2);
    }

    @LynxUIMethod
    public void resumeAnimation(ReadableMap r1, Callback r2) {
        M();
        this.a.r(r2);
    }

    @LynxUIMethod
    public void startAnimate(ReadableMap r1, Callback r2) {
        M();
        this.a.w(r2);
    }

    @LynxUIMethod
    public void stopAnimation(ReadableMap r1, Callback r2) {
        M();
        this.a.x(r2);
    }
}
