package com.bytedance.ai.model.widgets;

import android.app.Application;
import android.os.Trace;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.jsb.lynx.LynxAppletModelClass;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.RenderType;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.google.gson.JsonObject;
import com.lynx.tasm.TemplateBundle;
import com.obric.launcher.widget.R$id;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ai/model/widgets/LynxViewFloatingPage;", "Lcom/bytedance/ai/model/widgets/a;", "Landroidx/lifecycle/LifecycleOwner;", "Lw0/l;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLynxViewFloatingPage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LynxViewFloatingPage.kt\ncom/bytedance/ai/model/widgets/LynxViewFloatingPage\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,540:1\n1863#2,2:541\n*S KotlinDebug\n*F\n+ 1 LynxViewFloatingPage.kt\ncom/bytedance/ai/model/widgets/LynxViewFloatingPage\n*L\n254#1:541,2\n*E\n"})
public final class LynxViewFloatingPage extends a implements LifecycleOwner, w0.l {
    public com.bytedance.ai.lynx.g e;
    public final com.bytedance.ai.applet.render.core.lynx.h f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LifecycleRegistry f2302h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l2.a f2303i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f2304j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public m1.i f2305k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2306l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2307m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final t0.f f2308n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final t9.a f2309o;

    public LynxViewFloatingPage(AppletRuntime r5, PageInfo r10) {
        Intrinsics.checkNotNullParameter(r5, "appletRuntime");
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        super(r5, r10);
        this.f2302h = new LifecycleRegistry(this);
        this.f2303i = new l2.a();
        this.f2304j = new LinkedHashMap();
        final int r11 = 0;
        final int r12 = 1;
        t0.f r13 = new t0.f(new f(this, r11), new f(this, r12));
        this.f2308n = r13;
        t0.b r14 = com.bytedance.ai.model.p.f2294c;
        if (r14 == null) goto L5;
        r14.addAppBackGroundListener(r13);
    L5:
        r10.setPageId(this.f2331c);
        this.f = new com.bytedance.ai.applet.render.core.lynx.h(r10, 1);
        this.f2309o = new t9.a();
    }

    @Override // w0.i
    public final View a() {
        return this.e;
    }

    @Override // com.bytedance.ai.model.widgets.a, w0.j
    public final View b(PageInfo r21, com.bytedance.ai.model.k r22, com.bytedance.ai.model.k r23) {
        Intrinsics.checkNotNullParameter(r21, "pageInfo");
        super.b(r21, null, null);
        int r10 = 0;
        d r5 = new d(r10, this, r23);
        if (r21.getPageName() != null) goto L5;
    L56:
        r5.invoke("pageInfo is null, context=null, pageName=" + r21.getPageName() + ", pageUrl=" + r21.getPageUrl());
    L57:
        return null;
    L5:
        if (r21.getPageUrl() == null) goto L56;
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        this.f2330b = r21;
        ReadableMap r11 = r21.getPageSettings();
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L13
        if (r11 == null) goto L15;
        String r13 = r11.getString("width");     // Catch: Throwable -> L13
        if (r13 == null) goto L15;
        double r14 = Double.parseDouble(r13);     // Catch: Throwable -> L13
        AtomicBoolean r15 = s0.a.f21798a;     // Catch: Throwable -> L13
        int r16 = com.bytedance.ai.utils.c.d(Double.valueOf(r14));     // Catch: Throwable -> L13
    L16:
        this.f2306l = r16;     // Catch: Throwable -> L13
        if (r11 == null) goto L21;
        String r17 = r11.getString("height");     // Catch: Throwable -> L13
        if (r17 == null) goto L21;
        double r18 = Double.parseDouble(r17);     // Catch: Throwable -> L13
        AtomicBoolean r19 = s0.a.f21798a;     // Catch: Throwable -> L13
        int r20 = com.bytedance.ai.utils.c.d(Double.valueOf(r18));     // Catch: Throwable -> L13
    L22:
        this.f2307m = r20;     // Catch: Throwable -> L13
        Object r24 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L25:
        Throwable r25 = Result.m127exceptionOrNullimpl(r24);
        if (r25 == null) goto L28;
        r5.invoke("get page width/height exception: " + ExceptionsKt.stackTraceToString(r25));
        goto L57
    L28:
        Trace.beginSection("createLynxFloatingView");
        ArrayList r26 = new ArrayList();
        com.lynx.jsbridge.r r27 = new com.lynx.jsbridge.r();
        r27.f9939a = "AppletBridgeModule";
        r27.f9940b = LynxAppletModelClass.class;
        l2.a r28 = this.f2303i;
        r27.f9941c = new ArrayList(CollectionsKt.mutableListOf(new l2.a[]{r28}));
        r26.add(r27);
        Application r29 = s0.c.a();
        Application r30 = s0.c.a();
        u0.a r110 = s0.a.f21800c;
        if (r110 == null) goto L32;
        String r111 = r110.f22202m;
        if (r111 == null) goto L32;
    L33:
        AppletRuntime r112 = this.f2329a;
        com.bytedance.ai.lynx.g r31 = com.bytedance.ai.lynx.i.a(r30, r111, r112.f2197h.f2276x, this.f2330b.getPackageName(), new com.bytedance.ai.bridge.method.net.e(r26, r29));
        r31.setTag(R$id.applet_ai_container_tag, new WeakReference(this));
        this.e = r31;
        r31.addLynxViewClient(this.f);
        com.bytedance.ai.lynx.g r32 = this.e;
        if (r32 == null) goto L36;
        r32.addOnLayoutChangeListener(new g());
    L36:
        com.bytedance.ai.lynx.g r33 = this.e;
        if (r33 == null) goto L39;
        r33.setClickable(true);
        r33.setFocusable(true);
        r33.setFocusableInTouchMode(true);
        r33.setOnFocusChangeListener(new h(this, r10));
    L39:
        Trace.endSection();
        com.bytedance.ai.lynx.g r34 = this.e;
        if (r34 == null) goto L49;
        com.bytedance.ai.applet.render.core.lynx.d r35 = new com.bytedance.ai.applet.render.core.lynx.d(r34, r28);
        com.bytedance.ai.lynx.g r36 = this.e;
        if (r36 == null) goto L45;
        r36.addLynxViewClient(new com.bytedance.ai.applet.render.core.lynx.h(this, 2));
    L45:
        m1.i r37 = new m1.i();
        com.bytedance.ai.lynx.g r38 = this.e;
        if (r38 == null) goto L48;
        r37.c(r38);
    L48:
        i r39 = new i(this);
        n1.a r40 = r37.g;
        r40.getClass();
        Intrinsics.checkNotNullParameter(m1.j.class, "clazz");
        RefType r113 = RefType.f1803a;
        r40.c(m1.j.class, r39, r113);
        RefType r41 = RefType.f1804b;
        r40.c(w0.f.class, this, r41);
        r40.c(AppletRuntime.class, r112, r41);
        com.bytedance.ai.model.s r42 = new com.bytedance.ai.model.s(this, 3);
        Intrinsics.checkNotNullParameter(com.bytedance.ai.model.s.class, "clazz");
        r40.c(com.bytedance.ai.model.s.class, r42, r113);
        r37.d(r35);
        this.f2305k = r37;
    L49:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new LynxViewFloatingPage$createRealPage$3(this, null), 2, null);
        z2.d.e("create_floating_page", new we.a(r21));
        j(this.f2302h, Lifecycle.Event.ON_CREATE);
        Lazy r43 = v0.e.f;
        com.bytedance.android.anniex.base.service.f.g().getClass();
        Intrinsics.checkNotNullParameter(this, "page");
        Intrinsics.checkNotNullParameter(r21, "pageInfo");
        RenderType[] r44 = RenderType.f2230a;
        if (Intrinsics.areEqual("lynx", "lynx") == true) goto L53;
        Lazy r45 = v0.d.f22502n;
        r10 = cl.a.h().n(this, r21, null);
    L53:
        if (r10 <= 0) goto L55;
        r22.invoke(Integer.valueOf(r10));
        goto L57
    L55:
        r5.invoke("fail to show floating page");
    L32:
        r111 = "";
    L21:
        r20 = this.f2307m;     // Catch: Throwable -> L13
    L15:
        r16 = this.f2306l;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r24 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L25
    }

    @Override // com.bytedance.ai.model.widgets.a, w0.f
    public final void c(double r5, double r10) {
        AtomicBoolean r11 = s0.a.f21798a;
        this.f2306l = com.bytedance.ai.utils.c.d(Double.valueOf(r5));
        this.f2307m = com.bytedance.ai.utils.c.d(Double.valueOf(r10));
        Lazy r12 = v0.e.f;
        v0.e r13 = com.bytedance.android.anniex.base.service.f.g();
        int r14 = this.f2306l;
        r13.getClass();
        Intrinsics.checkNotNullParameter(this, "page");
        RenderType[] r15 = RenderType.f2230a;
        if (Intrinsics.areEqual("lynx", "lynx") == true) goto L10;
        Lazy r16 = v0.d.f22502n;
        v0.d r17 = cl.a.h();
        r17.getClass();
        Intrinsics.checkNotNullParameter(this, "page");
        v0.a r18 = r17.f;
        if (r18 == null) goto L9;
        r18.setRealWidth(r14);
        return;
    L9:
        return;
    }

    @Override // w0.i
    public final View d() {
        return this.e;
    }

    @Override // w0.l
    public final void e() {
        if (this.g == true) goto L8;
        String r5 = ug.a.c(new StringBuilder("floatingViewShow: widget "), this.f2331c, " is hide", "LynxViewFloatingPage");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L13;
        r10.d("LynxViewFloatingPage", r5);
        return;
    L13:
        return;
    L8:
        this.g = false;
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L11;
        r11.d("LynxViewFloatingPage", "floatingViewHide: ");
    L11:
        k("onHide");
        j(this.f2302h, Lifecycle.Event.ON_PAUSE);
    }

    @Override // w0.l
    public final void f() {
        l();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f2302h;
    }

    @Override // com.bytedance.ai.model.widgets.a
    public final String h() {
        RenderType[] r5 = RenderType.f2230a;
        return "lynx";
    }

    @Override // w0.d
    public final m1.k i() {
        return this.f2305k;
    }

    public final void j(LifecycleRegistry r10, Lifecycle.Event r11) {
        e r5 = new e(r11, r10, 0);
        if (r11 != Lifecycle.Event.ON_DESTROY) goto L5;
    L8:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new LynxViewFloatingPage$changeTo$1(r10, r11, r5, null), 3, null);
        return;
    L5:
        if (r10.getCurrentState() != Lifecycle.State.DESTROYED) goto L8;
        r5.invoke();
    }

    public final void k(String r5) {
        String r10 = "dispatchLifecycleEventToWeb " + this + " lifecycle ==> " + r5;
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L5;
        r11.d("LynxViewFloatingPage", r10);
    L5:
        m1.i r12 = this.f2305k;
        if (r12 == null) goto L9;
        JsonObject r13 = new JsonObject();
        this.f2330b.setPageId(this.f2331c);
        r13.addProperty("eventName", this.f2330b.toViewContext());
        Unit r14 = Unit.INSTANCE;
        r12.e(r5, r13);
        return;
    }

    public final void l() {
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r5 = com.bytedance.ai.utils.c.f2846a;
        if (r5 == null) goto L5;
        r5.d("LynxViewFloatingPage", "floating onDestroy");
    L5:
        t0.b r10 = com.bytedance.ai.model.p.f2294c;
        if (r10 == null) goto L8;
        r10.removeAppBackGroundListener(this.f2308n);
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
        k("onDestroy");
        androidx.fragment.app.d r16 = new androidx.fragment.app.d(this, 11);
        SoftReference r17 = c1.b.f1102a;
        Intrinsics.checkNotNullParameter(r16, "runnable");
        c1.b.c().postDelayed(r16, 2000);
    }

    @Override // w0.l
    public final void n() {
        m1.i r5 = this.f2305k;
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
        m1.i r11 = this.f2305k;
        if (r11 == null) goto L6;
        r11.e(r5, r10);
        return;
    }

    public static final Object i(LynxViewFloatingPage r10, ContinuationImpl r11) {
        r10.getClass();
        if ((r11 instanceof LynxViewFloatingPage$loadTemplateBundleFromPackage$1) == false) goto L7;
        LynxViewFloatingPage$loadTemplateBundleFromPackage$1 r5 = (LynxViewFloatingPage$loadTemplateBundleFromPackage$1) r11;
        int r12 = r5.e;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.e = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.f2317c;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.e;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        String r16 = r5.f2316b;
        String r17 = r5.f2315a;
        ResultKt.throwOnFailure(r13);
    L26:
        String r18 = r16;
        TemplateBundle r19 = (TemplateBundle) r13;
        String r110 = r17;
    L28:
        Trace.endSection();
        String r111 = "loadTemplateBundleFromPackage: end loading, packageName = " + r110 + ", widgetId = " + r18;
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L31;
        r20.i("LynxViewFloatingPage", r111);
    L31:
        return r19;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r110 = r10.getAppletId();
        r18 = r10.f2330b.getPageName();
        String r21 = com.lynx.tasm.utils.b.j("loadTemplateBundleFromPackage: start loading, packageName = ", r110, ", widgetId = ", r18);
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r22 = com.bytedance.ai.utils.c.f2846a;
        if (r22 == null) goto L17;
        r22.i("LynxViewFloatingPage", r21);
    L17:
        Trace.beginSection("loadTemplateBundle_" + r10.f2330b.getPageName());
        String r23 = r10.f2330b.getPageUrl();
        if (r23 == null) goto L27;
        String r24 = r10.f2329a.f2197h.f2276x;
        if (r24 != null) goto L22;
        r24 = "";
    L22:
        r5.f2315a = r110;
        r5.f2316b = r18;
        r5.e = 1;
        Object r25 = com.bytedance.ai.lynx.i.b(r24, r23, r5);
        if (r25 != r14) goto L25;
        return r14;
    L25:
        r17 = r110;
        r13 = r25;
        r16 = r18;
        goto L26
    L27:
        r19 = null;
    L7:
        r5 = new LynxViewFloatingPage$loadTemplateBundleFromPackage$1(r10, r11);
        goto L8
    }

    @Override // w0.k
    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        String r10 = "onMessageToJS: " + r5;
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L6;
        r11.i("LynxViewFloatingPage", r10);
        return;
    }

    @Override // m2.a
    public final m3.a d(String r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "groupId");
        if (r10 == true) goto L5;
        LinkedHashMap r11 = this.f2304j;
        m3.a r12 = (m3.a) r11.get(r5);
        if (r12 != null) goto L10;
        o r13 = new o(r5, 2);
        r11.put(r5, r13);
        return r13;
    L10:
        return r12;
    L5:
        return av.i.d(this, r5);
    }

    @Override // w0.l
    public final void c() {
        if (this.g == false) goto L8;
        String r5 = ug.a.c(new StringBuilder("floatingViewShow: widget "), this.f2331c, " is showing", "LynxViewFloatingPage");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L10;
        r10.d("LynxViewFloatingPage", r5);
        return;
    L10:
        return;
    L8:
        this.g = true;
        k("onShow");
        j(this.f2302h, Lifecycle.Event.ON_RESUME);
    }
}
