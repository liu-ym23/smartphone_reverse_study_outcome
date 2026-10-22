package com.bytedance.ai.applet.render.core.lynx;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ai.applet.render.core.RenderType;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.crash.Npth;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxLoadMode;
import com.lynx.tasm.LynxLoadOption;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.s0;
import d3.w;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class LynxRenderView extends LynxView implements w2.a {
    public final o a;
    public final String b;
    public final com.ivy.ivykit.api.bridge.g c;
    public final com.ivy.ivykit.api.plugin.b d;
    public final s4.c<ReadableMap> e;
    public final com.bytedance.ai.applet.base.log.d f;
    public final w2.c g;
    public boolean h;
    public n i;

    public static final class a extends w2.a.AbstractC0209a<a, LynxRenderView> {
        public final LynxViewBuilder d;
        public final String e;
        public o f;
        public Function2<? super String, ? super ContainerType, Boolean> g;

        public a(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            this(r10, new LynxViewBuilder());
        }

        public a(Context r10, LynxViewBuilder r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "lynxViewBuilder");
            super(r10);
            this.d = r11;
            this.e = UUID.randomUUID().toString();
        }
    }

    public static final class b {
    }

    static {
    }

    public LynxRenderView() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w2.a
    public final View asView() {
        return this;
    }

    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w2.a
    public final View realView() {
        return this;
    }

    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, r1);
    }

    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    @Override // w2.a
    public final void destroy() {
        com.ivy.ivykit.api.plugin.b r0 = this.d;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        com.ivy.ivykit.api.bridge.g r1 = this.c;
        if (r1 == null) goto L8;
        r1.release();
    L8:
        super.destroy();
    }

    private final TemplateData getGlobalPropsTemplateData() {
        return TemplateData.fromMap(getLynxGlobalProps());
    }

    private final Map<String, Object> getLynxGlobalProps() {
        Map<String, Object> r0 = MapsKt.toMutableMap(getComposition().b);
        r0.put("__RENDER_DATA__", getComposition().d.toString());
        r0.put("__VIEW_CONTEXT__", getComposition().c);
        return r0;
    }

    @Override // w2.a
    public final void a() {
        getComposition().f = null;
    }

    @Override // w2.a
    public final void c() {
        getComposition().e = null;
        n r0 = this.i;
        if (r0 == null) goto L6;
        removeLynxViewClient(r0);
        this.i = null;
        return;
    }

    @Override // w2.a
    public w getBridge() {
        return getComposition().a;
    }

    @Override // w2.a
    public final boolean d() {
        return this.h;
    }

    @Override // w2.a
    public w2.c getComposition() {
        return this.g;
    }

    public final com.ivy.ivykit.api.bridge.g getIvyLynxBridge() {
        return this.c;
    }

    public final s4.c<ReadableMap> getLynxBridgeMessages() {
        return this.e;
    }

    @Override // w2.a
    public RenderType getRenderType() {
        return RenderType.LYNX;
    }

    public final String getViewUuid() {
        return this.b;
    }

    private final void setNpthLastUrl(String r10) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L4
        r1.put("last_lynx_url", CollectionsKt.first(StringsKt.split$default(r10, new String[]{"?"}, false, 0, 6, null)));     // Catch: Throwable -> L4
        r1.put("lynx_sdk_version", LynxEnv.inst().getLynxVersion());     // Catch: Throwable -> L4
        Npth.addTags(r1);     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        w2.a.c r0 = getComposition().f;
        if (r0 == null) goto L6;
        r0.onTouchEvent(r10);
    L6:
        return super.dispatchTouchEvent(r10);
    }

    @Override // w2.a
    public final void e(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "props");
        w2.a.b.b(this, r10);
        updateGlobalProps(TemplateData.fromMap(r10));
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        sendGlobalEvent("globalPropsUpdated", new JavaOnlyArray());     // Catch: Throwable -> L5
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L13;
        com.bytedance.ai.applet.base.log.b r0 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("LynxRenderView", "sendGlobalEvent globalPropsUpdated error: " + r13.getMessage(), null);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final TemplateData h(JSONObject r10) {
        TemplateData r0 = TemplateData.empty();
        if ((!getComposition().c.isEmpty()) == false) goto L6;
        r0.put("viewContext", getComposition().c);
    L6:
        if (getComposition().d.length() <= 0) goto L9;
        r0.put("viewData", getComposition().d);
        r0.put("widgetData", getComposition().d);
    L9:
        if (r10.length() <= 0) goto L11;
        r0.updateWithTemplateData(TemplateData.fromString(r10.toString()));
    L11:
        return r0;
    }

    @Override // w2.a
    public void setGlobalProperties(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "props");
        w2.c r0 = getComposition();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r0.b = r10;
    }

    @Override // w2.a
    public void setOnTouchEventListener(w2.a.c r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        getComposition().f = r10;
    }

    @Override // w2.a
    public void setReused(boolean r1) {
        this.h = r1;
    }

    @Override // w2.a
    public void setViewClient(w2.b r10) {
        Intrinsics.checkNotNullParameter(r10, "client");
        Intrinsics.checkNotNullParameter(r10, "client");
        getComposition().e = r10;
        n r0 = this.i;
        if (r0 == null) goto L5;
        removeLynxViewClient(r0);
    L5:
        n r1 = new n(this, r10, this.a);
        this.i = r1;
        addLynxViewClient(r1);
    }

    @Override // w2.a
    public void setViewContext(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        w2.c r0 = getComposition();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r0.c = r10;
    }

    @Override // w2.a
    public void setViewData(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        w2.c r0 = getComposition();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r0.d = r10;
    }

    @Override // w2.a
    public final void b(JSONObject r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        if (r11 == false) goto L5;
        reloadTemplate(h(r10), getGlobalPropsTemplateData());
        return;
    L5:
        updateData(h(r10));
    }

    @Override // w2.a
    public final Object f(String r10, JSONObject r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof LynxRenderView$loadUrl$1) == false) goto L7;
        LynxRenderView$loadUrl$1 r0 = (LynxRenderView$loadUrl$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        r11 = (JSONObject) r0.L$1;
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L20:
        TemplateBundle r16 = (TemplateBundle) r13;
        String r17 = null;
        if (r16 != null) goto L27;
        com.bytedance.ai.applet.base.log.d r18 = this.f;
        AtomicInteger r19 = com.bytedance.ai.applet.base.log.d.d;
        r18.a("load resource failed, bundle is NULL", null);
        w2.b r20 = getComposition().e;
        if (r20 == null) goto L26;
        r20.f(this, true, 103, "load resource failed, bundle is NULL");
    L26:
        return Unit.INSTANCE;
    L27:
        w2.b r21 = getComposition().e;
        if (r21 == null) goto L30;
        r21.a(this, r10);
    L30:
        setNpthLastUrl(r10);
        updateGlobalProps(getLynxGlobalProps());
        Object r22 = getComposition().c.get("appletId");
        if ((r22 instanceof String) == false) goto L33;
        String r23 = (String) r22;
    L34:
        Object r24 = getComposition().c.get("pageName");
        if ((r24 instanceof String) == false) goto L37;
        r17 = (String) r24;
    L37:
        int r25 = p.a;
        p.a.a(this, r10, r23, r17);
        s0.a r26 = new s0.a();
        r26.a = r10;
        r26.c = r16;
        r26.d = h(r11);
        r26.f = LynxLoadMode.NORMAL;
        r26.a(LynxLoadOption.RECYCLE_TEMPLATE_BUNDLE);
        loadTemplate(r26.b());
        return Unit.INSTANCE;
    L33:
        r23 = null;
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        w2.b r27 = getComposition().e;
        if (r27 == null) goto L17;
        r27.g(this, r10);
    L17:
        o r28 = this.a;
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.label = 1;
        r13 = r28.a(r10, r0);
        if (r13 != r14) goto L20;
        return r14;
    L7:
        r0 = new LynxRenderView$loadUrl$1(this, r12);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LynxRenderView(Context r1, LynxViewBuilder r10, o r11, String r12, com.ivy.ivykit.api.bridge.g r13, com.ivy.ivykit.api.plugin.b r14, s4.c r15) {
        super(r1, r10);
        this.a = r11;
        this.b = r12;
        this.c = r13;
        this.d = r14;
        this.e = r15;
        this.f = new com.bytedance.ai.applet.base.log.d("LynxRenderView", null);
        this.g = new w2.c();
        addLynxViewClient(new m(this));
        LynxAIBridgePort r16 = new LynxAIBridgePort(this, r15);
        getBridge().j(this);
        getBridge().k(r16);
    }
}
