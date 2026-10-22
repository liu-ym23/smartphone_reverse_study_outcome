package com.bytedance.ai.model.widgets;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageStatus;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ai/model/widgets/RelaxViewFloatingPageV2;", "Landroidx/lifecycle/LifecycleOwner;", "Lw0/l;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRelaxViewFloatingPageV2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RelaxViewFloatingPageV2.kt\ncom/bytedance/ai/model/widgets/RelaxViewFloatingPageV2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,378:1\n1#2:379\n216#3,2:380\n*S KotlinDebug\n*F\n+ 1 RelaxViewFloatingPageV2.kt\ncom/bytedance/ai/model/widgets/RelaxViewFloatingPageV2\n*L\n165#1:380,2\n*E\n"})
public final class RelaxViewFloatingPageV2 extends a implements LifecycleOwner, w0.l {
    public m1.i e;
    public final LinkedHashMap f;
    public c3.c g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2318h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2319i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LifecycleRegistry f2320j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final t0.f f2321k;

    public RelaxViewFloatingPageV2(AppletRuntime r5, PageInfo r10) {
        Intrinsics.checkNotNullParameter(r5, "appletRuntime");
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        Intrinsics.checkNotNullParameter(r5, "appletRuntime");
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        super(r5, r10);
        this.f = new LinkedHashMap();
        LazyKt.lazy(new a3.f(9));
        this.f2320j = new LifecycleRegistry(this);
        final int r11 = 0;
        final int r12 = 1;
        t0.f r13 = new t0.f(new n(this, r11), new n(this, r12));
        this.f2321k = r13;
        t0.b r14 = com.bytedance.ai.model.p.f2294c;
        if (r14 == null) goto L5;
        r14.addAppBackGroundListener(r13);
    L5:
        r10.setPageId(this.f2331c);
    }

    public static void j(LifecycleRegistry r5, Lifecycle.Event r10) {
        e r11 = new e(r10, r5, 1);
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

    @Override // w0.k
    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
    }

    @Override // com.bytedance.ai.model.widgets.a, w0.j
    public final View b(PageInfo r10, com.bytedance.ai.model.k r11, com.bytedance.ai.model.k r12) {
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        super.b(r10, null, null);
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        if (r10.getPageName() != null) goto L5;
    L22:
        r12.invoke("pageInfo is null, context=null, pageName=" + r10.getPageName() + ", pageUrl=" + r10.getPageUrl());
    L23:
        return null;
    L5:
        if (r10.getPageUrl() == null) goto L22;
        t0.b r5 = com.bytedance.ai.model.p.f2294c;
        if (r5 == null) goto L10;
        Activity r13 = r5.currentActivity();
    L12:
        if ((r13 instanceof FragmentActivity) == false) goto L14;
        FragmentActivity r14 = (FragmentActivity) r13;
    L15:
        if (r14 != null) goto L17;
        FragmentActivity r15 = null;
    L18:
        t0.b r16 = com.bytedance.ai.model.p.f2294c;
        if (r16 == null) goto L21;
        r16.findMainActivity();
    L21:
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f2330b = r10;
        c1.b.b(new m(r15, this, r10, r11, r12, 0));
        goto L23
    L17:
        r15 = r14;
        goto L18
    L14:
        r14 = null;
        goto L15
    L10:
        r13 = null;
        goto L12
    }

    @Override // w0.l
    public final void c() {
        boolean r5 = this.f2319i;
        String r10 = this.f2331c;
        if (r5 == false) goto L9;
        String r11 = ug.a.c(new StringBuilder("floatingViewShow: widget "), r10, " is showing", "RelaxViewFloatingPageV2");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L19;
        r12.d("RelaxViewFloatingPageV2", r11);
        return;
    L19:
        return;
    L9:
        if (this.f2318h == true) goto L14;
        String r13 = ug.a.c(new StringBuilder("floatingViewShow: widget "), r10, " evaluate is NOT completed", "RelaxViewFloatingPageV2");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L20;
        r14.d("RelaxViewFloatingPageV2", r13);
        return;
    L20:
        return;
    L14:
        this.f2319i = true;
        Intrinsics.checkNotNullParameter("RelaxViewFloatingPageV2", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L17;
        r15.d("RelaxViewFloatingPageV2", "floatingViewShow: ");
    L17:
        c1.b.b(new k(this, 2));
        j(this.f2320j, Lifecycle.Event.ON_RESUME);
    }

    @Override // w0.i
    public final View d() {
        return null;
    }

    @Override // w0.l
    public final void e() {
        if (this.f2319i == true) goto L8;
        String r5 = ug.a.c(new StringBuilder("floatingViewShow: widget "), this.f2331c, " is hide", "RelaxViewFloatingPageV2");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L13;
        r10.d("RelaxViewFloatingPageV2", r5);
        return;
    L13:
        return;
    L8:
        this.f2319i = false;
        Intrinsics.checkNotNullParameter("RelaxViewFloatingPageV2", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L11;
        r11.d("RelaxViewFloatingPageV2", "floatingViewHide: ");
    L11:
        c1.b.b(new k(this, 5));
        j(this.f2320j, Lifecycle.Event.ON_PAUSE);
    }

    @Override // w0.l
    public final void f() {
        Intrinsics.checkNotNullParameter("RelaxViewFloatingPageV2", "tag");
        t0.d r5 = com.bytedance.ai.utils.c.f2846a;
        if (r5 == null) goto L5;
        r5.d("RelaxViewFloatingPageV2", "floating onDestroy");
    L5:
        t0.b r10 = com.bytedance.ai.model.p.f2294c;
        if (r10 == null) goto L8;
        r10.removeAppBackGroundListener(this.f2321k);
    L8:
        AppletRuntime r11 = this.f2329a;
        r11.f2197h.h();
        r11.h();
        c1.b.b(new k(this, 3));
        k r12 = new k(this, 4);
        Intrinsics.checkNotNullParameter(r12, "runnable");
        c1.b.c().postDelayed(r12, 2000);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f2320j;
    }

    @Override // com.bytedance.ai.model.widgets.a
    public final String h() {
        return "relax";
    }

    @Override // w0.d
    public final m1.k i() {
        return this.e;
    }

    @Override // w0.l
    public final void n() {
        c1.b.b(new k(this, 1));
        m1.i r5 = this.e;
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
        m1.i r11 = this.e;
        if (r11 == null) goto L6;
        r11.e(r5, r10);
        return;
    }

    public static final Unit i(RelaxViewFloatingPageV2 r10, PageInfo r11, com.ivy.ivykit.api.plugin.b r12) {
        Intrinsics.checkNotNullParameter(r12, ST.IMPLICIT_ARG_NAME);
        r11.getPageUrl();
        r10.getClass();
        Intrinsics.checkNotNullParameter("AIContainerViewBase", "tag");
        t0.d r5 = com.bytedance.ai.utils.c.f2846a;
        if (r5 == null) goto L5;
        r5.i("AIContainerViewBase", "onViewStart");
    L5:
        PageStatus r13 = PageStatus.f2286a;
        z2.d.e("applet_view_start", new w8.f(r10));
        Intrinsics.checkNotNullParameter(PageStatus.f2286a, "<set-?>");
        com.bytedance.ai.lynx.k r14 = com.bytedance.ai.lynx.k.f2188a;
        u0.a r15 = s0.a.f21800c;
        if (r15 == null) goto L9;
        String r16 = r15.f22202m;
        if (r16 == null) goto L9;
    L10:
        Map r17 = com.bytedance.ai.lynx.k.b(r16);
        Map r18 = com.bytedance.ai.lynx.k.a(null);
        if (r18 == null) goto L16;
        Iterator r19 = r18.entrySet().iterator();
    L14:
        if (r19.hasNext() == false) goto L16;
        Map.Entry r20 = (Map.Entry) r19.next();
        r17.put(r20.getKey(), r20.getValue());
    L16:
        r17.put("__AI_SDK_VERSION__", "0.90.0-rc.37-miniapp");
        AtomicBoolean r21 = s0.a.f21798a;
        r17.put("__TEXT_ZOOM_RATIO__", Float.valueOf(1.0f));
        r10.f2330b.setPageId(r10.f2331c);
        Pair r22 = TuplesKt.to("viewContext", r10.f2330b.toViewContext());
        String r23 = r11.getPageData();
        if (r23 != null) goto L19;
        r23 = "";
    L19:
        Pair r24 = TuplesKt.to("viewData", r23);
        Intrinsics.checkNotNullParameter(r17, "value");
        Map r25 = MapsKt.mutableMapOf(new Pair[]{r22, r24, TuplesKt.to("containerInfos", z0.a.a().toJson(r17))});
        c3.c r26 = r10.g;
        if (r26 == null) goto L22;
        r26.d(r25);
    L22:
        com.ivy.ivykit.api.plugin.a r27 = r12.e;
        if (r27 == null) goto L30;
        c3.c r28 = r10.g;
        if (r28 == null) goto L30;
        String r29 = r11.getPageUrl();
        if (r29 != null) goto L29;
        r29 = "";
    L29:
        r28.c(r29, r27.f9478a);
    L30:
        c3.c r30 = r10.g;
        if (r30 == null) goto L33;
        r30.a();
    L33:
        super.e("");
        Intrinsics.checkNotNullParameter(PageStatus.f2287b, "<set-?>");
        c1.b.b(new k(r10, 7));
        return Unit.INSTANCE;
    L9:
        r16 = "";
        goto L10
    }

    @Override // w0.i
    public final View a() {
        c3.c r5 = this.g;
        if (r5 != null) goto L5;
        return null;
    L5:
        return (View) r5.f1114a;
    }

    @Override // m2.a
    public final m3.a d(String r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "groupId");
        if (r10 == true) goto L5;
        Intrinsics.checkNotNullParameter(r5, "groupId");
        if (r10 == false) goto L10;
        return null;
    L10:
        LinkedHashMap r11 = this.f;
        m3.a r12 = (m3.a) r11.get(r5);
        if (r12 != null) goto L14;
        o r13 = new o(r5, 0);
        r11.put(r5, r13);
        return r13;
    L14:
        return r12;
    L5:
        return av.i.d(this, r5);
    }

    @Override // com.bytedance.ai.model.widgets.a, w0.f
    public final void c(double r10, double r11) {
        c1.b.b(new j(this, r10, r11, 0));
    }
}
