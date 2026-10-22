package com.bytedance.ai.applet.render.core.lynx;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import b3.p;
import com.bytedance.ai.applet.render.core.RenderType;
import com.bytedance.crash.Npth;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxLoadMode;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.l0;
import com.lynx.tasm.o0;
import com.lynx.tasm.x;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import ym.o;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends LynxView implements g1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q7.a f1769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.sdk.xbridge.cn.platform.lynx.a f1771c;
    public final l2.a d;
    public final a1.c e;
    public final g1.d f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j f1772h;

    public i(Context r5, l0 r10, q7.a r11, String r12, com.bytedance.sdk.xbridge.cn.platform.lynx.a r13, l2.a r14) {
        super(r5, r10);
        this.f1769a = r11;
        this.f1770b = r12;
        this.f1771c = r13;
        this.d = r14;
        this.e = new a1.c("LynxRenderView");
        this.f = new g1.d();
        addLynxViewClient(new h(this, 0));
        d r15 = new d(this, r14);
        getBridge().c(this);
        getBridge().d(r15);
    }

    private final void setNpthLastUrl(String r5) {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L4
        LinkedHashMap r11 = new LinkedHashMap();     // Catch: Throwable -> L4
        r11.put("last_lynx_url", CollectionsKt.first(StringsKt.K(r5, new String[]{"?"}, 0, 6)));     // Catch: Throwable -> L4
        r11.put(LynxEventReporter.PROP_NAME_LYNX_SDK_VERSION, LynxEnv.inst().getLynxVersion());     // Catch: Throwable -> L4
        Npth.addTags(r11);     // Catch: Throwable -> L4
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }

    @Override // g1.b
    public final View a() {
        return this;
    }

    @Override // g1.b
    public final void b() {
        getComposition().f = null;
    }

    @Override // g1.b
    public final void c() {
        getComposition().e = null;
        j r5 = this.f1772h;
        if (r5 == null) goto L6;
        removeLynxViewClient(r5);
        this.f1772h = null;
        return;
    }

    @Override // g1.b
    public final View d() {
        return this;
    }

    @Override // com.lynx.tasm.LynxView, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        g1.a r10 = getComposition().f;
        if (r10 == null) goto L8;
        com.bytedance.ai.widget.contianer.e r11 = (com.bytedance.ai.widget.contianer.e) r10;
        Intrinsics.checkNotNullParameter(r5, "ev");
        if (r5.getAction() != 1) goto L8;
        AtomicBoolean r12 = z2.d.f23373a;
        z2.d.e("widget_click", new o(r11.f3045a, 2));
    L8:
        return super.dispatchTouchEvent(r5);
    }

    @Override // g1.b
    public final boolean e() {
        return this.g;
    }

    @Override // g1.b
    public m1.i getBridge() {
        return getComposition().f17015a;
    }

    @Override // g1.b
    public g1.d getComposition() {
        return this.f;
    }

    public final com.bytedance.sdk.xbridge.cn.platform.lynx.a getLynxBDXBridge() {
        return this.f1771c;
    }

    public final l2.a getLynxBridgeMessages() {
        return this.d;
    }

    @Override // g1.b
    public RenderType getRenderType() {
        return RenderType.d;
    }

    public final String getViewUuid() {
        return this.f1770b;
    }

    @Override // g1.b
    public void setGlobalProperties(Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "props");
        g1.d r10 = getComposition();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r10.f17016b = r5;
    }

    @Override // g1.b
    public void setOnTouchEventListener(g1.a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        getComposition().f = r5;
    }

    @Override // g1.b
    public void setReused(boolean r5) {
        this.g = r5;
    }

    @Override // g1.b
    public void setViewClient(g1.c r5) {
        Intrinsics.checkNotNullParameter(r5, "client");
        Intrinsics.checkNotNullParameter(r5, "client");
        getComposition().e = r5;
        o0 r10 = this.f1772h;
        if (r10 == null) goto L5;
        removeLynxViewClient(r10);
    L5:
        j r11 = new j(this, r5, this.f1769a);
        this.f1772h = r11;
        addLynxViewClient(r11);
    }

    @Override // g1.b
    public void setViewContext(Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        g1.d r10 = getComposition();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r10.f17017c = r5;
    }

    @Override // g1.b
    public void setViewData(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        g1.d r10 = getComposition();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r10.d = r5;
    }

    @Override // g1.b
    public final Object a(String r13, JSONObject r14, ContinuationImpl r15) {
        if ((r15 instanceof LynxRenderView$loadUrl$1) == false) goto L7;
        LynxRenderView$loadUrl$1 r5 = (LynxRenderView$loadUrl$1) r15;
        int r10 = r5.f;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.f = r10 - Integer.MIN_VALUE;
    L8:
        Object r16 = r5.d;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r5.f;
        if (r12 == 0) goto L15;
        if (r12 != 1) goto L14;
        r14 = r5.f1758c;
        r13 = r5.f1757b;
        i this = r5.f1756a;
        ResultKt.throwOnFailure(r16);
    L12:
        String r17 = r13;
        TemplateBundle r18 = (TemplateBundle) r16;
        if (r18 != null) goto L31;
        a1.c r19 = this.e;
        AtomicInteger r110 = a1.c.f44c;
        r19.b("load resource failed, bundle is NULL", null);
        g1.c r111 = this.getComposition().e;
        if (r111 == null) goto L30;
        ((com.bytedance.ai.widget.contianer.d) r111).b(this, true, 103, "load resource failed, bundle is NULL");
    L30:
        return Unit.INSTANCE;
    L31:
        g1.c r112 = this.getComposition().e;
        if (r112 == null) goto L34;
        ((com.bytedance.ai.widget.contianer.d) r112).a(this, r17);
    L34:
        this.setNpthLastUrl(r17);
        this.updateGlobalProps(this.getComposition().f17016b);
        this.loadTemplate(new x(r17, null, r18, this.b(r14), null, LynxLoadMode.f10003a, 4));
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r16);
        g1.c r113 = getComposition().e;
        if (r113 == null) goto L21;
        com.bytedance.ai.widget.contianer.d r114 = (com.bytedance.ai.widget.contianer.d) r113;
        Intrinsics.checkNotNullParameter(this, "view");
        Intrinsics.checkNotNullParameter(r13, "url");
        String r20 = androidx.room.jarjarred.org.antlr.runtime.a.v(new StringBuilder("onWillReadResource "), r13, "AppletWidgetContainer", "tag");
        t0.d r21 = com.bytedance.ai.utils.c.f2846a;
        if (r21 == null) goto L20;
        r21.i("AppletWidgetContainer", r20);
    L20:
        p r22 = b3.h.f841a;
        b3.h.d(r114.f3044a.v());
    L21:
        r5.f1756a = this;
        r5.f1757b = r13;
        r5.f1758c = r14;
        r5.f = 1;
        r16 = this.f1769a.b(r13, r5);
        if (r16 != r11) goto L12;
        return r11;
    L7:
        r5 = new LynxRenderView$loadUrl$1(this, r15);
        goto L8
    }

    public final TemplateData b(JSONObject r5) {
        TemplateData r10 = new TemplateData();
        if (getComposition().f17017c.isEmpty() == true) goto L6;
        r10.i("viewContext", getComposition().f17017c);
    L6:
        if (getComposition().d.length() <= 0) goto L9;
        r10.i("viewData", getComposition().d);
        r10.i("widgetData", getComposition().d);
    L9:
        if (r5.length() <= 0) goto L11;
        r10.h(TemplateData.b(r5.toString()));
    L11:
        return r10;
    }

    @Override // g1.b
    public final void a(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        updateData(b(r5));
    }
}
