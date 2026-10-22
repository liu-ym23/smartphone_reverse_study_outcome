package com.bytedance.ai.model.widgets;

import android.app.Activity;
import android.os.Looper;
import android.view.View;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageStatus;
import com.bytedance.ai.model.u;
import com.google.gson.JsonObject;
import com.ivy.ivykit.api.plugin.IIvyWebService;
import com.lynx.tasm.ui.image.f0;
import com.obric.launcher.widget.R$id;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ai/model/widgets/WebViewFloatingPageV2;", "Landroidx/lifecycle/LifecycleOwner;", "Lw0/l;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWebViewFloatingPageV2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewFloatingPageV2.kt\ncom/bytedance/ai/model/widgets/WebViewFloatingPageV2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,504:1\n1#2:505\n*E\n"})
public final class WebViewFloatingPageV2 extends a implements LifecycleOwner, w0.l {
    public WebView e;
    public m1.i f;
    public u g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashMap f2322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final rl.a f2323i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ql.b f2324j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2325k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2326l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LifecycleRegistry f2327m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final t0.f f2328n;

    public WebViewFloatingPageV2(AppletRuntime r11, PageInfo r12) {
        Intrinsics.checkNotNullParameter(r11, "appletRuntime");
        Intrinsics.checkNotNullParameter(r12, "pageInfo");
        Intrinsics.checkNotNullParameter(r11, "appletRuntime");
        Intrinsics.checkNotNullParameter(r12, "pageInfo");
        super(r11, r12);
        this.f2322h = new LinkedHashMap();
        LazyKt.lazy(new a3.f(10));
        this.f2327m = new LifecycleRegistry(this);
        final int r5 = 0;
        final int r10 = 1;
        t0.f r13 = new t0.f(new r(this, r5), new r(this, r10));
        this.f2328n = r13;
        t0.b r14 = com.bytedance.ai.model.p.f2294c;
        if (r14 == null) goto L5;
        r14.addAppBackGroundListener(r13);
    L5:
        r12.setPageId(this.f2331c);
        u0.a r15 = s0.a.f21800c;
        if (r15 == null) goto L11;
        String r16 = r15.f22202m;
        if (r16 == null) goto L12;
        this.f2323i = IIvyWebService.Companion.createIvyWebClient(r16, "schema", new ym.d(this), new s(this, 0), null, null, new t(r12, this), null, null);
        return;
    L12:
        return;
    }

    public static void j(LifecycleRegistry r5, Lifecycle.Event r10) {
        e r11 = new e(r10, r5, 2);
        if (r10 != Lifecycle.Event.ON_DESTROY) goto L5;
    L16:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L10
        r5.handleLifecycleEvent(r10);     // Catch: Throwable -> L10
        Object r13 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L13:
        if (Result.m127exceptionOrNullimpl(r13) == null) goto L18;
        r11.invoke();
        return;
    L18:
        return;
    L10:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L13
    L5:
        if (r5.getCurrentState() != Lifecycle.State.DESTROYED) goto L16;
        r11.invoke();
    }

    @Override // w0.i
    public final View a() {
        ql.b r5 = this.f2324j;
        if (r5 != null) goto L5;
        return null;
    L5:
        return ((com.ivy.ivykit.plugin.impl.web.h) r5).f9542a;
    }

    @Override // com.bytedance.ai.model.widgets.a, w0.j
    public final View b(PageInfo r10, com.bytedance.ai.model.k r11, com.bytedance.ai.model.k r12) {
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        super.b(r10, null, null);
        d r13 = new d(2, this, r12);
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        if (r10.getPageName() != null) goto L5;
    L19:
        r13.invoke("pageInfo is null, context=null, pageName=" + r10.getPageName() + ", pageUrl=" + r10.getPageUrl());
    L20:
        return null;
    L5:
        if (r10.getPageUrl() == null) goto L19;
        t0.b r14 = com.bytedance.ai.model.p.f2294c;
        if (r14 == null) goto L10;
        Activity r15 = r14.currentActivity();
    L12:
        if ((r15 instanceof FragmentActivity) == false) goto L14;
        FragmentActivity r16 = (FragmentActivity) r15;
    L15:
        if (r16 != null) goto L17;
        FragmentActivity r5 = null;
    L18:
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f2330b = r10;
        c1.b.b(new m(r5, this, r10, r11, r13, 1));
        goto L20
    L17:
        r5 = r16;
        goto L18
    L14:
        r16 = null;
        goto L15
    L10:
        r15 = null;
        goto L12
    }

    @Override // com.bytedance.ai.model.widgets.a, w0.f
    public final void c(double r10, double r11) {
        c1.b.b(new j(this, r10, r11, 1));
    }

    @Override // w0.i
    public final View d() {
        return this.e;
    }

    @Override // com.bytedance.ai.model.widgets.a
    public final void e(String r5) {
        super.e(r5);
        Intrinsics.checkNotNullParameter(PageStatus.f2287b, "<set-?>");
        c1.b.b(new q(this, 7));
    }

    @Override // w0.l
    public final void f() {
        k();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f2327m;
    }

    @Override // com.bytedance.ai.model.widgets.a
    public final String h() {
        return "webview";
    }

    @Override // w0.d
    public final m1.k i() {
        return this.f;
    }

    public final void k() {
        Intrinsics.checkNotNullParameter("WebViewFloatingPageV2", "tag");
        t0.d r5 = com.bytedance.ai.utils.c.f2846a;
        if (r5 == null) goto L5;
        r5.d("WebViewFloatingPageV2", "floating onDestroy");
    L5:
        t0.b r10 = com.bytedance.ai.model.p.f2294c;
        if (r10 == null) goto L8;
        r10.removeAppBackGroundListener(this.f2328n);
    L8:
        AppletRuntime r11 = this.f2329a;
        r11.f2197h.h();
        r11.h();
        String r12 = this.f2331c;
        Intrinsics.checkNotNullParameter(r12, "id");
        LinkedHashMap r13 = com.bytedance.ai.model.p.f2293b;
        a r14 = (a) r13.get(r12);
        r13.remove(r12);
        Iterator r15 = com.bytedance.ai.model.p.d.iterator();
    L10:
        if (r15.hasNext() == false) goto L19;
        if (r15.next() != null) goto L18;
        if (r14 == null) goto L10;
        throw null;
    L18:
        throw new ClassCastException();
    L19:
        c1.b.b(new q(this, 4));
        q r16 = new q(this, 5);
        Intrinsics.checkNotNullParameter(r16, "runnable");
        c1.b.c().postDelayed(r16, 2000);
    }

    @Override // w0.l
    public final void n() {
        c1.b.b(new q(this, 0));
        m1.i r5 = this.f;
        if (r5 == null) goto L6;
        JsonObject r10 = new JsonObject();
        r10.addProperty("viewId", this.f2330b.getPageId());
        Unit r11 = Unit.INSTANCE;
        r5.e("applet.floatingMaskClicked", r10);
        return;
    }

    @Override // w0.k
    public final void onMessageToAIBridge(String r5, JsonObject r10) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        m1.i r11 = this.f;
        if (r11 == null) goto L6;
        r11.e(r5, r10);
        return;
    }

    @Override // w0.l
    public final void c() {
        boolean r5 = this.f2326l;
        String r10 = this.f2331c;
        if (r5 == false) goto L9;
        String r11 = ug.a.c(new StringBuilder("floatingViewShow: widget "), r10, " is showing", "WebViewFloatingPageV2");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L19;
        r12.d("WebViewFloatingPageV2", r11);
        return;
    L19:
        return;
    L9:
        if (this.f2325k == true) goto L14;
        String r13 = ug.a.c(new StringBuilder("floatingViewShow: widget "), r10, " evaluate is NOT completed", "WebViewFloatingPageV2");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L20;
        r14.d("WebViewFloatingPageV2", r13);
        return;
    L20:
        return;
    L14:
        this.f2326l = true;
        Intrinsics.checkNotNullParameter("WebViewFloatingPageV2", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L17;
        r15.d("WebViewFloatingPageV2", "floatingViewShow: ");
    L17:
        c1.b.b(new q(this, 1));
        j(this.f2327m, Lifecycle.Event.ON_RESUME);
    }

    @Override // m2.a
    public final m3.a d(String r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "groupId");
        if (r10 == true) goto L5;
        Intrinsics.checkNotNullParameter(r5, "groupId");
        if (r10 == false) goto L10;
        return null;
    L10:
        LinkedHashMap r11 = this.f2322h;
        m3.a r12 = (m3.a) r11.get(r5);
        if (r12 != null) goto L14;
        o r13 = new o(r5, 1);
        r11.put(r5, r13);
        return r13;
    L14:
        return r12;
    L5:
        return av.i.d(this, r5);
    }

    public final void i(WebView r10) {
        if (r10 == null) goto L28;
        r10.setTag(R$id.applet_ai_container_tag, new WeakReference(this));
        r10.getSettings().setJavaScriptEnabled(true);
        r10.getSettings().setDisplayZoomControls(false);
        r10.getSettings().setBuiltInZoomControls(false);
        u r5 = new u(this);
        this.g = r5;
        Intrinsics.checkNotNull(r5);
        r10.addJavascriptInterface(r5, "AppletJSBridge");
        j1.g r11 = f0.b(r10);
        if (r11 == null) goto L29;
        m1.i r12 = new m1.i();
        this.f = r12;
        r12.c(r10);
        m1.i r13 = this.f;
        if (r13 == null) goto L10;
        n1.a r14 = r13.g;
        if (r14 == null) goto L10;
        i r15 = new i(this, r10);
        Intrinsics.checkNotNullParameter(m1.j.class, "clazz");
        r14.c(m1.j.class, r15, RefType.f1803a);
    L10:
        m1.i r16 = this.f;
        if (r16 == null) goto L15;
        n1.a r17 = r16.g;
        if (r17 == null) goto L15;
        r17.c(w0.f.class, this, RefType.f1804b);
    L15:
        m1.i r18 = this.f;
        if (r18 == null) goto L20;
        n1.a r19 = r18.g;
        if (r19 == null) goto L20;
        r19.c(AppletRuntime.class, this.f2329a, RefType.f1804b);
    L20:
        m1.i r20 = this.f;
        if (r20 == null) goto L25;
        n1.a r21 = r20.g;
        if (r21 == null) goto L25;
        com.bytedance.ai.model.s r22 = new com.bytedance.ai.model.s(this, 5);
        Intrinsics.checkNotNullParameter(com.bytedance.ai.model.s.class, "clazz");
        r21.c(com.bytedance.ai.model.s.class, r22, RefType.f1803a);
    L25:
        m1.i r23 = this.f;
        if (r23 == null) goto L29;
        r23.d(r11);
    L29:
        this.e = r10;
        return;
    L28:
        r10 = null;
        goto L29
    }

    @Override // w0.k
    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        u r10 = this.g;
        if (r10 == null) goto L9;
        Intrinsics.checkNotNullParameter(r5, "message");
        com.bytedance.ai.model.f r11 = new com.bytedance.ai.model.f(r10, r5);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L7;
        r11.run();
        return;
    L7:
        c1.b.b(r11);
        return;
    }

    @Override // w0.l
    public final void e() {
        if (this.f2326l == true) goto L8;
        String r5 = ug.a.c(new StringBuilder("floatingViewShow: widget "), this.f2331c, " is hide", "WebViewFloatingPageV2");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L13;
        r10.d("WebViewFloatingPageV2", r5);
        return;
    L13:
        return;
    L8:
        this.f2326l = false;
        Intrinsics.checkNotNullParameter("WebViewFloatingPageV2", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L11;
        r11.d("WebViewFloatingPageV2", "floatingViewHide: ");
    L11:
        c1.b.b(new q(this, 6));
        j(this.f2327m, Lifecycle.Event.ON_PAUSE);
    }
}
