package com.bytedance.ai.applet.render.core.relax;

import android.content.Context;
import android.view.View;
import b3.p;
import com.bytedance.ai.applet.render.core.RenderType;
import com.bytedance.ai.applet.render.core.relax.monitor.RelaxViewMonitorModule;
import com.relax.RelaxView;
import com.relax.RuntimeType;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import mn.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends RelaxView implements g1.b {
    public static boolean e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelaxRenderView$RenderMode f1792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f1793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a1.c f1794c;
    public final g1.d d;

    public f(Context r10, RelaxRenderView$RenderMode r11, i r12) {
        super(r10, e.a(r10, r11), RuntimeType.RuntimeTypeVM, true, true, null);
        this.f1792a = r11;
        this.f1793b = r12;
        this.f1794c = new a1.c("RelaxRenderView");
        this.d = new g1.d();
        f();
        setOnDispatchTouchEventListener(new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g1.b
    public final View a() {
        return (View) this;
    }

    @Override // g1.b
    public final void b() {
        this.d.f = null;
    }

    @Override // g1.b
    public final void c() {
        this.d.e = null;
        setRelaxViewClient(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g1.b
    public final View d() {
        return (View) this;
    }

    @Override // g1.b
    public final void destroy() {
        super.destroy();
        this.d.f17015a.g();
    }

    @Override // g1.b
    public final boolean e() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        Intrinsics.checkNotNullParameter(this, "relaxView");
        RelaxViewAIBridgePort$RTSInterface.initialize(this);
        RelaxBridgeModule r5 = RelaxViewAIBridgePort$RTSInterface.INSTANCE.getRelaxViewToRelaxBridgeModule().get(this);
        if (r5 != null) goto L5;
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter("[RelaxViewAIBridgePort] must call JSInterface::initialize before create RelaxViewAIBridgePort", "msg");
        a1.a.f43a.e("ai_bridge", "[RelaxViewAIBridgePort] must call JSInterface::initialize before create RelaxViewAIBridgePort", null);
    L7:
        h r10 = null;
    L9:
        g1.d r11 = this.d;
        r11.f17015a.c((View) this);
        if (r10 == null) goto L12;
        r11.f17015a.d(r10);
    L13:
        registerBridgeModule("hybridMonitor", new RelaxViewMonitorModule(this));
        return;
    L12:
        Intrinsics.checkNotNullParameter("RelaxRenderView", "tag");
        Intrinsics.checkNotNullParameter("port is NULL", "msg");
        a1.a.f43a.e("RelaxRenderView", "port is NULL", null);
        goto L13
    L5:
        l2.a r12 = r5.getNext();
        if (r12 == null) goto L7;
        r10 = new h(new WeakReference(this), r12);
        goto L9
    }

    @Override // g1.b
    public final m1.i getBridge() {
        return this.d.f17015a;
    }

    @Override // g1.b
    public final g1.d getComposition() {
        throw null;
    }

    @Override // g1.b
    public final RenderType getRenderType() {
        return RenderType.e;
    }

    @Override // g1.b
    public final void setGlobalProperties(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "props");
        g1.d r10 = this.d;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r10.f17016b = r5;
    }

    @Override // g1.b
    public final void setOnTouchEventListener(g1.a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        this.d.f = r5;
    }

    @Override // g1.b
    public final void setReused(boolean r5) {
    }

    @Override // g1.b
    public final void setViewClient(g1.c r5) {
        Intrinsics.checkNotNullParameter(r5, "client");
        Intrinsics.checkNotNullParameter(r5, "client");
        this.d.e = r5;
        setRelaxViewClient(new g(this, r5));
    }

    @Override // g1.b
    public final void setViewContext(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        g1.d r10 = this.d;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r10.f17017c = r5;
    }

    @Override // g1.b
    public final void setViewData(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        g1.d r10 = this.d;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r10.d = r5;
    }

    @Override // g1.b
    public final Object a(String r10, JSONObject r11, ContinuationImpl r12) {
        if ((r12 instanceof RelaxRenderView$loadUrl$1) == false) goto L7;
        RelaxRenderView$loadUrl$1 r13 = (RelaxRenderView$loadUrl$1) r12;
        int r5 = r13.e;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r13.e = r5 - Integer.MIN_VALUE;
    L8:
        Object r14 = r13.f1788c;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r13.e;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = r13.f1787b;
        f this = r13.f1786a;
        ResultKt.throwOnFailure(r14);
    L23:
        byte[] r17 = (byte[]) r14;
        if (r17 != null) goto L30;
        a1.c r18 = this.f1794c;
        AtomicInteger r19 = a1.c.f44c;
        r18.b("load resource failed, byteArray is NULL", null);
        g1.c r20 = this.d.e;
        if (r20 == null) goto L29;
        ((com.bytedance.ai.widget.contianer.d) r20).b(this, true, 103, "load resource failed, byteArray is NULL");
    L29:
        return Unit.INSTANCE;
    L30:
        g1.c r21 = this.d.e;
        if (r21 == null) goto L33;
        ((com.bytedance.ai.widget.contianer.d) r21).a(this, r10);
    L33:
        g1.d r22 = this.d;
        this.setGlobalProps(MapsKt.mapOf(new Pair[]{TuplesKt.to("viewContext", z0.c.c(r22.f17017c)), TuplesKt.to("viewData", r22.d.toString()), TuplesKt.to("containerInfos", z0.c.c(r22.f17016b))}));
        this.loadFile(r17, r10);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        g1.c r23 = this.d.e;
        if (r23 == null) goto L20;
        com.bytedance.ai.widget.contianer.d r24 = (com.bytedance.ai.widget.contianer.d) r23;
        Intrinsics.checkNotNullParameter(this, "view");
        Intrinsics.checkNotNullParameter(r10, "url");
        String r25 = androidx.room.jarjarred.org.antlr.runtime.a.v(new StringBuilder("onWillReadResource "), r10, "AppletWidgetContainer", "tag");
        t0.d r26 = com.bytedance.ai.utils.c.f2846a;
        if (r26 == null) goto L19;
        r26.i("AppletWidgetContainer", r25);
    L19:
        p r27 = b3.h.f841a;
        b3.h.d(r24.f3044a.v());
    L20:
        r13.f1786a = this;
        r13.f1787b = r10;
        r13.e = 1;
        r14 = this.f1793b.b(r10, r13);
        if (r14 != r15) goto L23;
        return r15;
    L7:
        r13 = new RelaxRenderView$loadUrl$1(this, r12);
        goto L8
    }

    @Override // g1.b
    public final void a(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        AtomicInteger r10 = a1.c.f44c;
        this.f1794c.b("reload is not supported", null);
    }
}
