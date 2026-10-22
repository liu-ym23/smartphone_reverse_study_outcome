package com.lynx.tasm.behavior.ui.frame;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import c7a.c;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.o1;
import com.lynx.tasm.utils.n;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@LynxBehavior(isCreateAsync = false, tagName = {"frame"})
@LynxGeneratorName(packageName = "com.lynx.tasm.behavior.ui.frame")
public final class UIFrame extends LynxUI<LynxFrameView> {
    public TemplateBundle a;
    public boolean b;
    public boolean c;
    public boolean d;
    public double e;
    public double f;

    public static final class a implements LynxFrameView.a {
        public final WeakReference<UIFrame> a;

        public a(UIFrame r2) {
            this.a = new WeakReference(r2);
        }
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Map<String, Object> buildLayoutChangeEventDetail() {
        Map<String, Object> r0 = super.buildLayoutChangeEventDetail();
        LynxFrameView r1 = getView();
        if (r1 != null) goto L5;
        String r2 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        r0.put("frameUrl", r2);
        if (this.d == false) goto L9;
        r0.put("intrinsicWidth", Double.valueOf(this.e));
        r0.put("intrinsicHeight", Double.valueOf(this.f));
    L9:
        return r0;
    L5:
        r2 = r1.getUrl();
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        LynxFrameView r0 = getView();
        if (r0 == null) goto L18;
        r0.setFrameEventCallback(null);
        if (r0.k == true) goto L19;
        r0.k = true;
        LLog.i("LynxFrameView", "lynxframeview destroy " + r0.toString());
        TraceEvent.beginSection("LynxFrameView.destroy");
        LynxTemplateRender r3 = r0.a;
        if (r3 == null) goto L10;
        r3.removeLynxViewClientV2(r0.w);
        r0.a.onDetachedFromWindow();
        r0.a.destroy();
        r0.a = null;
    L10:
        TemplateData r4 = r0.l;
        if (r4 == null) goto L13;
        r4.recycle();
        r0.l = null;
    L13:
        TemplateData r5 = r0.m;
        if (r5 == null) goto L16;
        r5.recycle();
        r0.m = null;
    L16:
        TraceEvent.endSection("LynxFrameView.destroy");
        return;
    L19:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.c == true) goto L5;
    L9:
        this.b = true;
        LynxFrameView r0 = getView();
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.g == true) goto L14;
    L22:
        LLog.e("LynxFrameView", "onPropsUpdated failed, bundle not loaded or render is null");
        return;
    L14:
        if (r0.a == null) goto L22;
        TemplateData r2 = r0.l;
        if (r2 == null) goto L19;
    L21:
        TemplateData r3 = r0.m;
        r0.l = null;
        r0.m = null;
        o1 r1 = new o1(r2, r3);
        r0.a.updateMetaData(r1);
        return;
    L19:
        if (r0.m != null) goto L21;
        return;
    L5:
        if (this.a == null) goto L9;
        if (O(this.a) == false) goto L9;
        this.a = null;
        this.c = false;
        goto L9
    }

    public static TemplateData N(f6a.a r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.isNull() == false) goto L8;
        return null;
    L8:
        if (r3.getType() == ReadableType.Map) goto L10;
        return null;
    L10:
        ReadableMap r4 = r3.asMap();
        if (r4 != null) goto L14;
        return null;
    L14:
        return TemplateData.fromMap(r4.asHashMap());
    }

    public final int M(String r10) {
        if (r10 != null) goto L5;
        return -1;
    L5:
        UIBody r0 = getLynxContext().getUIBody();
        if (r0 == null) goto L8;
        float r1 = r0.getFontSize();
        float r2 = r0.getWidth();
        float r6 = r0.getHeight();
        float r3 = r1;
        float r5 = r2;
    L10:
        return (int) n.b(r10, r3, getFontSize(), r5, r6, 1.0E21f, getLynxContext().getScreenMetrics());
    L8:
        r3 = 0.0f;
        r5 = 0.0f;
        r6 = 0.0f;
        goto L10
    }

    public final boolean O(TemplateBundle r4) {
        LynxFrameView r0 = getView();
        if (r0 != null) goto L6;
        return false;
    L6:
        LynxFrameView r1 = getView();
        if (r1 == null) goto L11;
        r1.setAttachLynxPageUICallback(new c(this));
    L11:
        return r0.g(r4);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r3) {
        LynxContext r4 = this.mContext;
        r4.getLynxFrameViewProvider();
        LynxFrameView r0 = new LynxFrameView(this.mContext);
        r0.f = r4;
        UIBody.UIBodyView r5 = r4.getUIBodyView();
        if (r5 != null) goto L5;
    L10:
        r0.setFrameEventCallback(new a(this));
        return r0;
    L5:
        if ((r5 instanceof LynxView) == false) goto L8;
        r0.c = new WeakReference((LynxView) r5);
        goto L10
    L8:
        if ((r5 instanceof LynxFrameView) == false) goto L10;
        r0.c = new WeakReference(((LynxFrameView) r5).getRootView());
        goto L10
    }

    @LynxProp(defaultBoolean = false, name = "auto-height")
    public void setAutoHeight(boolean r2) {
        LynxFrameView r0 = getView();
        if (r0 == null) goto L6;
        r0.setAutoHeight(r2);
        return;
    }

    @LynxProp(defaultBoolean = false, name = "auto-width")
    public void setAutoWidth(boolean r2) {
        LynxFrameView r0 = getView();
        if (r0 == null) goto L6;
        r0.setAutoWidth(r2);
        return;
    }

    @LynxProp(name = LynxResourceModule.DATA_KEY)
    public void setData(f6a.a r4) {
        LynxFrameView r0 = getView();
        if (r0 == null) goto L9;
        if (r4 != null) goto L6;
    L8:
        r0.setInitData(N(r4));
        goto L9
    L6:
        if (r4.getType() != ReadableType.Long) goto L8;
        r0.setInitData(r4.asLong());
    L9:
        this.mProps.remove(LynxResourceModule.DATA_KEY);
    }

    @LynxProp(name = "embedded-mode")
    public void setEmbeddedMode(int r2) {
        LynxFrameView r0 = getView();
        if (r0 == null) goto L6;
        r0.setEmbeddedMode(r2);
        return;
    }

    @LynxProp(name = "enable-multi-async-thread")
    public void setEnableMultiAsyncThread(Boolean r2) {
        LynxFrameView r0 = getView();
        if (r0 == null) goto L6;
        r0.setEnableMultiAsyncThread(r2);
        return;
    }

    @LynxProp(name = "global-props")
    public void setGlobalProps(f6a.a r4) {
        LynxFrameView r0 = getView();
        if (r0 == null) goto L9;
        if (r4 != null) goto L6;
    L8:
        r0.setGlobalProps(N(r4));
        goto L9
    L6:
        if (r4.getType() != ReadableType.Long) goto L8;
        r0.setGlobalProps(r4.asLong());
    L9:
        this.mProps.remove("global-props");
    }

    @LynxProp(name = "preset-height")
    public void setPresetHeight(String r2) {
        LynxFrameView r0 = getView();
        if (r0 == null) goto L6;
        r0.setPresetHeight(M(r2));
        return;
    }

    @LynxProp(name = "preset-width")
    public void setPresetWidth(String r2) {
        LynxFrameView r0 = getView();
        if (r0 == null) goto L6;
        r0.setPresetWidth(M(r2));
        return;
    }

    @LynxProp(name = LynxError.LYNX_ERROR_KEY_RESOURCE_URL)
    public void setSrc(String r3) {
        this.c = true;
        this.b = false;
        this.d = false;
        this.e = 0.0d;
        this.f = 0.0d;
        LynxFrameView r0 = getView();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setUrl(r3);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateExtraData(Object r2) {
        if ((r2 instanceof TemplateBundle) == false) goto L13;
        TemplateBundle r3 = (TemplateBundle) r2;
        if (this.c == true) goto L7;
    L11:
        this.a = r3;
        return;
    L7:
        if (this.b == false) goto L11;
        if (O(r3) == false) goto L11;
        this.a = null;
        this.c = false;
        this.b = false;
        return;
    }

    public UIFrame(LynxContext r1, Object r2) {
        super(r1, r2);
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = 0.0d;
        this.f = 0.0d;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setSign(int r1, String r2) {
        super.setSign(r1, r2);
        LynxFrameView r3 = getView();
        if (r3 == null) goto L6;
        r3.setSign(r1);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateLayout(int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23, Rect r24) {
        super.updateLayout(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        LynxFrameView r0 = getView();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = Math.max(0, r10 - (((r12 + r14) + r20) + r22));
        int r2 = Math.max(0, r11 - (((r13 + r15) + r21) + r23));
        if (TraceEvent.isTracingStarted() == false) goto L8;
        HashMap r3 = new HashMap();
        int r4 = View.MeasureSpec.makeMeasureSpec(r1, r0.p);
        int r5 = View.MeasureSpec.makeMeasureSpec(r2, r0.q);
        r3.put("widthMeasureSpec", View.MeasureSpec.toString(r4));
        r3.put("heightMeasureSpec", View.MeasureSpec.toString(r5));
        TraceEvent.instant(0, "LynxFrameView.updateLayout", r3);
    L8:
        r0.i = r1;
        r0.j = r2;
    }
}
