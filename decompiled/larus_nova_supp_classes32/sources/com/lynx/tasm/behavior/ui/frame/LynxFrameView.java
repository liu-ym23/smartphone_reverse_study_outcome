package com.lynx.tasm.behavior.ui.frame;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import c7a.b;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.s0;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import x6a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxFrameView extends UIBody.UIBodyView {
    public static final /* synthetic */ int x = 0;
    public LynxTemplateRender a;
    public String b;
    public WeakReference<LynxView> c;
    public a d;
    public int e;
    public LynxContext f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public boolean k;
    public TemplateData l;
    public TemplateData m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public UIBody.UIBodyView.a s;
    public int t;
    public int u;
    public Boolean v;
    public final c7a.a w;

    public interface a {
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return d.h(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        d.k(this, r1);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        d.l(this, r1);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public LynxViewBuilder getLynxViewBuilder() {
        LynxTemplateRender r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLynxViewBuilder();
    }

    @Override // android.view.View
    public LynxView getRootView() {
        WeakReference<LynxView> r0 = this.c;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get();
    }

    public String getUrl() {
        String r0 = this.b;
        if (r0 != null) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return r0;
    }

    @Override // android.view.View
    public /* bridge */ /* synthetic */ View getRootView() {
        return getRootView();
    }

    public LynxFrameView(Context r4) {
        super(r4);
        this.c = null;
        this.g = false;
        this.h = true;
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.l = null;
        this.m = null;
        this.n = false;
        this.o = false;
        this.p = 1073741824;
        this.q = 1073741824;
        this.r = 0;
        this.t = -1;
        this.u = -1;
        this.v = null;
        this.w = new c7a.a(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        super.dispatchDraw(r2);
        LynxTemplateRender r0 = this.a;
        if (r0 == null) goto L6;
        r0.onRootViewDraw(r2);
        return;
    }

    public final boolean g(TemplateBundle r10) {
        int r5 = 0;
        if (this.a != null) goto L5;
    L7:
        UIBody.UIBodyView r0 = this.f.getUIBodyView();
        if (r0 != null) goto L10;
        LLog.e("LynxFrameView", "ensureRenderCreated failed, bodyView is null");
    L26:
        boolean r1 = false;
    L31:
        if (r1 == true) goto L34;
        LLog.e("LynxFrameView", "create render failed");
        return false;
    L34:
        int r2 = this.i;
        int r3 = this.j;
        if (r2 == (-1)) goto L38;
        if (r3 == (-1)) goto L38;
        boolean r4 = true;
    L39:
        if (r4 == false) goto L41;
        this.a.updateViewport(View.MeasureSpec.makeMeasureSpec(r2, this.p), View.MeasureSpec.makeMeasureSpec(this.j, this.q));
    L53:
        s0.a r6 = new s0.a();
        r6.a = this.b;
        r6.c = r10;
        TemplateData r11 = this.l;
        TemplateData r7 = this.m;
        this.l = null;
        this.m = null;
        r6.d = r11;
        r6.e = r7;
        this.a.loadTemplate(r6.b());
        this.g = true;
        return true;
    L41:
        int r8 = this.t;
        if (r8 == (-1)) goto L44;
    L45:
        LynxTemplateRender r9 = this.a;
        if (r8 != (-1)) goto L48;
        r8 = 0;
    L48:
        int r12 = View.MeasureSpec.makeMeasureSpec(r8, this.p);
        int r13 = this.u;
        if (r13 == (-1)) goto L52;
        r5 = r13;
    L52:
        r9.updateViewport(r12, View.MeasureSpec.makeMeasureSpec(r5, this.q));
        goto L53
    L44:
        if (this.u == (-1)) goto L53;
    L38:
        r4 = false;
        goto L39
    L10:
        LynxViewBuilder r14 = r0.getLynxViewBuilder();
        r14.setEnablePreUpdateData(true);
        r14.setEmbeddedMode(this.r);
        Boolean r15 = this.v;
        if (r15 == null) goto L13;
        r14.setEnableMultiAsyncThread(r15.booleanValue());
    L13:
        int r16 = this.t;
        if (r16 == (-1)) goto L16;
    L17:
        if (r16 != (-1)) goto L19;
        r16 = 0;
    L19:
        int r17 = View.MeasureSpec.makeMeasureSpec(r16, this.p);
        int r18 = this.u;
        if (r18 != (-1)) goto L22;
        r18 = 0;
    L22:
        r14.setPresetMeasuredSpec(r17, View.MeasureSpec.makeMeasureSpec(r18, this.q));
    L23:
        this.mLynxUIRender = r14.createLynxUIRenderer();
        LynxTemplateRender r19 = new LynxTemplateRender(this.f, this, r14);
        this.a = r19;
        if (this.mLynxUIRender != null) goto L27;
        LLog.e("LynxFrameView", "ensureRenderCreated failed, render or ui renderer creation returned null");
        goto L26
    L27:
        r19.addLynxViewClientV2(this.w);
        UIBody.UIBodyView.a r20 = this.s;
        if (r20 == null) goto L30;
        this.a.setAttachLynxPageUICallback(r20);
        this.s = null;
    L30:
        r1 = true;
        goto L31
    L16:
        if (this.u == (-1)) goto L23;
    L5:
        if (this.mLynxUIRender == null) goto L7;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public final void runOnTasmThread(Runnable r2) {
        LynxTemplateRender r0 = this.a;
        if (r0 == null) goto L6;
        r0.runOnTasmThread(r2);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public void setAttachLynxPageUICallback(UIBody.UIBodyView.a r2) {
        LynxTemplateRender r0 = this.a;
        if (r0 == null) goto L5;
        r0.setAttachLynxPageUICallback(r2);
        return;
    L5:
        this.s = r2;
    }

    public void setAutoHeight(boolean r4) {
        if (this.o != r4) goto L5;
        return;
    L5:
        this.o = r4;
        boolean r0 = false;
        if (r4 == false) goto L8;
        int r5 = 0;
    L9:
        this.q = r5;
        if (this.g == false) goto L18;
        int r6 = this.i;
        int r1 = this.j;
        if (r6 == (-1)) goto L15;
        if (r1 == (-1)) goto L15;
        r0 = true;
    L15:
        if (r0 == false) goto L19;
        this.a.updateViewport(View.MeasureSpec.makeMeasureSpec(r6, this.p), View.MeasureSpec.makeMeasureSpec(this.j, this.q));
        return;
    L19:
        return;
    L18:
        return;
    L8:
        r5 = 1073741824;
        goto L9
    }

    public void setAutoWidth(boolean r5) {
        if (this.n != r5) goto L5;
        return;
    L5:
        this.n = r5;
        boolean r0 = false;
        if (r5 == false) goto L8;
        int r6 = 0;
    L9:
        this.p = r6;
        if (this.g == false) goto L18;
        int r1 = this.i;
        int r2 = this.j;
        if (r1 == (-1)) goto L15;
        if (r2 == (-1)) goto L15;
        r0 = true;
    L15:
        if (r0 == false) goto L19;
        this.a.updateViewport(View.MeasureSpec.makeMeasureSpec(r1, r6), View.MeasureSpec.makeMeasureSpec(this.j, this.q));
        return;
    L19:
        return;
    L18:
        return;
    L8:
        r6 = 1073741824;
        goto L9
    }

    public void setEmbeddedMode(int r2) {
        if (this.r == 0) goto L6;
        LLog.e("LynxFrameView", "setEmbeddedMode failed, embeddedMode is already set");
        return;
    L6:
        this.r = r2;
    }

    public void setEnableMultiAsyncThread(Boolean r1) {
        this.v = r1;
    }

    public void setFrameEventCallback(a r1) {
        this.d = r1;
    }

    public void setGlobalProps(long r7) {
        TraceEvent.instant(0, "LynxFrameView.setGlobalProps");
        TemplateData r0 = this.m;
        if (r0 == null) goto L9;
        if (r0.getNativePtr() == r7) goto L13;
        r0.recycle();
    L13:
        this.m = r0;
        return;
    L9:
        if (r7 != 0) goto L11;
        TemplateData r8 = null;
    L12:
        r0 = r8;
        goto L13
    L11:
        r8 = TemplateData.fromNativeDataPtr(r7);
        goto L12
    }

    public void setInitData(long r7) {
        TraceEvent.instant(0, "LynxFrameView.setInitData");
        TemplateData r0 = this.l;
        if (r0 == null) goto L9;
        if (r0.getNativePtr() == r7) goto L13;
        r0.recycle();
    L13:
        this.l = r0;
        return;
    L9:
        if (r7 != 0) goto L11;
        TemplateData r8 = null;
    L12:
        r0 = r8;
        goto L13
    L11:
        r8 = TemplateData.fromNativeDataPtr(r7);
        goto L12
    }

    public void setPresetHeight(int r1) {
        if (r1 >= 0) goto L4;
        return;
    L4:
        this.u = r1;
    }

    public void setPresetWidth(int r1) {
        if (r1 >= 0) goto L4;
        return;
    L4:
        this.t = r1;
    }

    public void setSign(int r1) {
        this.e = r1;
    }

    public void setUrl(String r1) {
        this.b = r1;
    }

    public void setGlobalProps(TemplateData r4) {
        TraceEvent.instant(0, "LynxFrameView.setGlobalProps");
        this.m = r4;
    }

    public void setInitData(TemplateData r4) {
        TraceEvent.instant(0, "LynxFrameView.setInitData");
        this.l = r4;
    }

    public LynxFrameView(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.c = null;
        this.g = false;
        this.h = true;
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.l = null;
        this.m = null;
        this.n = false;
        this.o = false;
        this.p = 1073741824;
        this.q = 1073741824;
        this.r = 0;
        this.t = -1;
        this.u = -1;
        this.v = null;
        this.w = new c7a.a(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        if (TraceEvent.isTracingStarted() == false) goto L6;
        HashMap r0 = new HashMap();
        r0.put("widthMeasureSpec", View.MeasureSpec.toString(r10));
        r0.put("heightMeasureSpec", View.MeasureSpec.toString(r11));
        TraceEvent.instant(0, "LynxFrameView.onMeasure", r0);
    L6:
        if (this.g == true) goto L8;
    L31:
        super.onMeasure(r10, r11);
        return;
    L8:
        if (this.a == null) goto L31;
        int r1 = this.i;
        int r5 = this.j;
        boolean r7 = true;
        if (this.h == true) goto L20;
        if (this.p == 1073741824) goto L16;
        r1 = getIntrinsicWidth();
    L16:
        if (this.q == 1073741824) goto L18;
        r5 = getIntrinsicHeight();
    L18:
        this.h = true;
    L20:
        if (r1 == (-1)) goto L23;
        if (r5 == (-1)) goto L23;
    L24:
        if (r7 == true) goto L26;
        super.onMeasure(r10, r11);
        return;
    L26:
        if (TraceEvent.isTracingStarted() == false) goto L28;
        HashMap r12 = new HashMap();
        int r13 = View.MeasureSpec.makeMeasureSpec(r1, this.p);
        int r6 = View.MeasureSpec.makeMeasureSpec(r5, this.q);
        r12.put("widthMeasureSpec", View.MeasureSpec.toString(r13));
        r12.put("heightMeasureSpec", View.MeasureSpec.toString(r6));
        TraceEvent.instant(0, "LynxFrameView.onMeasureTarget", r12);
    L28:
        this.a.onMeasure(View.MeasureSpec.makeMeasureSpec(r1, this.p), View.MeasureSpec.makeMeasureSpec(r5, this.q));
        return;
    L23:
        r7 = false;
        goto L24
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public final void sendGlobalEvent(String r2, JavaOnlyArray r3) {
        LynxTemplateRender r0 = this.a;
        if (r0 == null) goto L6;
        r0.sendGlobalEvent(r2, r3);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public final void setIntrinsicContentSize(final int r8, final int r9) {
        if (r8 == getIntrinsicWidth()) goto L5;
    L7:
        LLog.i("LynxFrameView", "LynxFrameView::setIntrinsicContentSize width:" + r8 + " height:" + r9);
        if (TraceEvent.isTracingStarted() == false) goto L10;
        HashMap r0 = new HashMap();
        r0.put("width", String.valueOf(r8));
        r0.put("height", String.valueOf(r9));
        TraceEvent.instant(0, "LynxFrameView.setIntrinsicContentSize", r0);
    L10:
        this.f.findShadowNodeAndRunTask(this.e, new b(r8, r9));
        this.h = false;
        super.setIntrinsicContentSize(r8, r9);
        a r1 = this.d;
        if (r1 == null) goto L26;
        UIFrame r2 = ((UIFrame.a) r1).a.get();
        if (r2 == null) goto L27;
        DisplayMetrics r3 = r2.getLynxContext().getScreenMetrics();
        if (r3 != null) goto L17;
        float r4 = 0.0f;
    L18:
        double r5 = r8;
        if (r4 <= 0.0f) goto L21;
        r5 = r5 / ((double) r4);
    L21:
        r2.e = r5;
        double r10 = r9;
        if (r4 <= 0.0f) goto L24;
        r10 = r10 / ((double) r4);
    L24:
        r2.f = r10;
        r2.d = true;
        r2.sendLayoutChangeEvent();
        return;
    L17:
        r4 = r3.density;
        goto L18
    L27:
        return;
    L26:
        return;
    L5:
        if (r9 != getIntrinsicHeight()) goto L7;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        LynxTemplateRender r0 = this.a;
        if (r0 == null) goto L6;
        r0.onLayout(r7, r8, r9, r10, r11);
        return;
    }
}
