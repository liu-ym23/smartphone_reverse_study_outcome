package com.bytedance.ies.bullet.lynx;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.bytedance.ai.applet.render.core.lynx.j;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewMonitorModule;
import com.bytedance.crash.Npth;
import com.bytedance.forest.chain.fetchers.GeckoFetcher;
import com.bytedance.forest.model.Scene;
import com.bytedance.ies.bullet.core.l;
import com.bytedance.ies.bullet.core.n;
import com.bytedance.ies.bullet.core.o;
import com.bytedance.ies.bullet.lynx.bridge.LynxBridgeModule;
import com.bytedance.ies.bullet.lynx.impl.DefaultLynxViewClient;
import com.bytedance.ies.bullet.lynx.resource.k;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.i;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.sdk.xbridge.cn.platform.lynx.XBridgeLynxModule;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.google.gson.Gson;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.canvas.KryptonVideoPlayerService;
import com.lynx.canvas.LynxKryptonUtils;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ui.krypton.CanvasRuntimeMediator;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.l0;
import com.lynx.tasm.navigator.NavigationModule;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.service.ILynxTrailServiceExtension;
import com.lynx.tasm.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ko.r;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements vc.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ies.bullet.ui.common.loader.c f5636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f5637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5638c;
    public final h5.b d;
    public com.bytedance.ies.bullet.lynx.impl.e e;
    public com.bytedance.ies.bullet.lynx.impl.c f;
    public LynxView g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f5639h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f5640i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5641j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a0 f5642k;

    public h(d r5, com.bytedance.ies.bullet.ui.common.loader.c r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r5, "kitService");
        this.f5636a = r10;
        this.f5637b = r5;
        this.d = new h5.b();
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkNotNullParameter(r10, "context");
        com.bytedance.ies.bullet.lynx.impl.e r11 = new com.bytedance.ies.bullet.lynx.impl.e(r5, r10);
        Intrinsics.checkNotNullParameter(this, "kitView");
        r11.f5656b = this;
        this.e = r11;
        this.f = r11.f5658h;
        this.f5639h = "";
        this.f5641j = true;
    }

    public static void k(String r5) {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L9
        HashMap r11 = new HashMap();     // Catch: Throwable -> L9
        if (r5 == null) goto L11;
        List r12 = StringsKt.K(r5, new String[]{"?"}, 0, 6);     // Catch: Throwable -> L9
        if (r12 == null) goto L11;
        String r13 = (String) r12.get(0);     // Catch: Throwable -> L9
        if (r13 == null) goto L11;
    L12:
        r11.put("last_lynx_url", r13);     // Catch: Throwable -> L9
        r11.put(LynxEventReporter.PROP_NAME_LYNX_SDK_VERSION, LynxEnv.inst().getLynxVersion());     // Catch: Throwable -> L9
        Npth.addTags(r11);     // Catch: Throwable -> L9
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L11:
        r13 = "";
    L9:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final void a(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r10, "eventName");
        if (com.bytedance.ies.bullet.core.h.g.f5315a == true) goto L30;
        boolean r5 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, this.f5639h, "send even", "XLynxKit");
    L9:
        com.bytedance.ies.bullet.lynx.impl.c r12 = this.f;
        if (r12 == null) goto L12;
        Intrinsics.checkNotNull(r12);
        r12.a(r11, r10, this.g);
        return;
    L12:
        if (r11 != null) goto L16;
        LynxView r13 = this.g;
        if (r13 == null) goto L33;
        r13.sendGlobalEvent(r10, new JavaOnlyArray(new ArrayList()));
        return;
    L33:
        return;
    L16:
        boolean r14 = r11 instanceof List;
        if (r14 == false) goto L26;
        LynxView r15 = this.g;
        if (r15 == null) goto L35;
        if (r14 == false) goto L22;
        List r16 = (List) r11;
    L23:
        if (r16 != null) goto L25;
        r16 = new ArrayList();
    L25:
        r15.sendGlobalEvent(r10, new JavaOnlyArray(r16));
        return;
    L22:
        r16 = null;
        goto L23
    L35:
        return;
    L26:
        LynxView r17 = this.g;
        if (r17 == null) goto L37;
        r17.sendGlobalEvent(r10, new JavaOnlyArray(Arrays.asList(new Object[]{r11})));
        return;
    L37:
        return;
    L30:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L6
        boolean r19 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L6
        com.bytedance.ies.bullet.service.base.b.b(8, this.f5639h, "send event: " + r10 + " with params: " + new Gson().toJson(r11), "XLynxKit");     // Catch: Throwable -> L6
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final SccConfig.SccLevel b() {
        return SccConfig.SccLevel.f5894a;
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final void c() {
        LynxView r5 = this.g;
        if (r5 == null) goto L5;
        r5.sendGlobalEvent("viewDisappeared", new JavaOnlyArray());
        r5.onEnterBackground();
    L5:
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, this.f5639h, "kitView status:on hide", "XLynxKit");
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final void d() {
        LynxView r5 = this.g;
        if (r5 == null) goto L5;
        JSONObject r10 = new JSONObject();
        r10.put("isViewFirstAppeared", this.f5641j);
        Unit r11 = Unit.INSTANCE;
        a("viewAppeared", r10);
        r5.onEnterForeground();
        this.f5641j = false;
    L5:
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, this.f5639h, "kitView status:on show", "XLynxKit");
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final void destroy() {
        com.bytedance.ies.bullet.lynx.impl.e r5 = this.e;
        r5.getClass();
        Intrinsics.checkNotNullParameter(this, "kitViewService");
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        StringBuilder r11 = new StringBuilder("lynxview was destroy, currentUri: ");
        com.bytedance.ies.bullet.core.e r12 = r5.f;
        if (r12 == null) goto L5;
        Uri r13 = r12.f5297k;
    L6:
        r11.append(r13);
        com.bytedance.ies.bullet.service.base.b.a(2, r11.toString(), "XLynxKit");
        com.bytedance.ies.bullet.core.e r14 = r5.f;
        if (r14 == null) goto L15;
        n r15 = r14.f5299m;
        if (r15 == null) goto L15;
        Uri r16 = r14.f5297k;
        if (r16 != null) goto L13;
        r16 = Uri.EMPTY;
    L13:
        r15.s(r16, this);
    L15:
        if (r5.f5662l.getValue() != null) goto L35;
        if (this.f5640i == null) goto L20;
        Intrinsics.areEqual(null, Boolean.TRUE);
    L20:
        if (xq.b.h() == true) goto L26;
        c r17 = this.f5640i;
        if (r17 == null) goto L26;
        String r18 = r17.f5620c;
        if (r18 == null) goto L26;
        com.bytedance.ies.bullet.lynx.init.d.d(r18);
    L26:
        zm.c r19 = com.bytedance.ies.bullet.forest.f.f5397a;
        com.bytedance.ies.bullet.forest.f.l(l());
        LynxView r20 = this.g;
        if (r20 == null) goto L29;
        r20.setAsyncImageInterceptor(null);
    L29:
        LynxView r21 = this.g;
        if (r21 == null) goto L32;
        r21.destroy();
    L32:
        com.bytedance.ies.bullet.service.base.b.b(8, this.f5639h, "kitView status:destroy", "XLynxKit");
        return;
    L35:
        throw new ClassCastException();
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final void e() {
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final String f() {
        return "Lynx View(" + LynxEnv.inst().getLynxVersion() + ')';
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final boolean g() {
        this.e.getClass();     // Catch: Exception -> L4
    L6:
        zn.a.f23550b.a();
        return false;
    L4:
        e = move-exception;
        com.bytedance.ies.bullet.service.base.b.g("onBackPressed", "XLynxKit", e);
        goto L6
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final KitType h() {
        return KitType.d;
    }

    public final wc.g i(String r10) {
        q7.a r5 = this.e.f5663m;
        Uri.parse(r10);
        if (r5 == null) goto L20;
        wc.g r11 = new wc.g("");
        com.bytedance.ies.bullet.lynx.impl.e r12 = (com.bytedance.ies.bullet.lynx.impl.e) r5.f21488b;
        com.bytedance.ies.bullet.core.e r13 = r12.f;
        if (r13 == null) goto L9;
        l r14 = r13.f5309x;
        if (r14 == null) goto L9;
        wc.a r15 = r14.f5346a;
    L10:
        wc.a r16 = cl.a.i(r15);
        if (r16 != null) goto L13;
        r16 = new wc.a(false);
    L13:
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r11.f22837b = r16;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r11.f = "";
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r11.g = "";
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r11.f22839h = "";
        r11.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r12.f5657c.getAllDependency());
        r11.d = 0;
        com.bytedance.ies.bullet.core.e r17 = r12.f;
        if (r17 == null) goto L17;
        String r18 = r17.f;
        if (r18 == null) goto L17;
    L18:
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r11.f22855y = r18;
        Intrinsics.checkNotNullParameter("template", "<set-?>");
        r11.f22840i = "template";
        return r11;
    L17:
        r18 = "default_bid";
    L9:
        r15 = null;
        goto L10
    L20:
        wc.g r19 = new wc.g("");
        d r20 = this.f5637b;
        String r21 = r20.f22117a;
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        r19.f22838c = r21;
        Intrinsics.checkNotNullParameter("template", "<set-?>");
        r19.f22840i = "template";
        r19.f22846o = com.bytedance.ies.bullet.base.utils.b.e(this.f5636a.getAllDependency());
        Uri r22 = Uri.parse(r10);     // Catch: Throwable -> L24
        String r23 = io.reactivex.exceptions.a.b(r22, r20.f22117a);     // Catch: Throwable -> L24
        if (r23 == null) goto L26;
        Intrinsics.checkNotNullParameter(r23, "<set-?>");     // Catch: Throwable -> L24
        r19.f22839h = r23;     // Catch: Throwable -> L24
    L26:
        String r24 = r22.getQueryParameter(LynxMonitorService.KEY_CHANNEL);     // Catch: Throwable -> L24
        if (r24 == null) goto L29;
        Intrinsics.checkNotNullParameter(r24, "<set-?>");     // Catch: Throwable -> L24
        r19.f = r24;     // Catch: Throwable -> L24
    L29:
        String r25 = r22.getQueryParameter("bundle");     // Catch: Throwable -> L24
        if (r25 == null) goto L32;
        Intrinsics.checkNotNullParameter(r25, "<set-?>");     // Catch: Throwable -> L24
        r19.g = r25;     // Catch: Throwable -> L24
    L32:
        r19.d = 1;     // Catch: Throwable -> L24
        String r26 = r22.getQueryParameter("dynamic");     // Catch: Throwable -> L24
        if (r26 == null) goto L37;
        r19.d = Integer.valueOf(Integer.parseInt(r26));     // Catch: Throwable -> L24
        return r19;
    L37:
        return r19;
    L24:
        th = move-exception;
        com.bytedance.ies.bullet.service.base.b.g("lynxkit.load parse url error", "XLynxKit", th);
        goto L37
    }

    public final void j(String r5, TemplateBundle r10) {
        c r11 = this.f5640i;
        if (r11 == null) goto L13;
        if (r11.f == true) goto L13;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L10;
        h.f.b(new f(this, r5, r10, 0), h.f.g);
        return;
    L10:
        f(r5, r10);
        return;
    L13:
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L16;
        f(r5, r10);
        return;
    L16:
        h.f.b(new f(this, r5, r10, 1), h.f.f17263i);
    }

    public final String l() {
        String r5 = this.f5639h;
        if (xq.b.q() == true) goto L5;
    L12:
        return r5;
    L5:
        if (Intrinsics.areEqual(this.f5637b.f22117a, "webcast") == false) goto L12;
        ub.a r10 = (ub.a) cd.a.a(r5).a(ub.a.class);
        if (r10 == null) goto L12;
        String r11 = r10.f22319a;
        if (r11 == null) goto L12;
        return r11;
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final void b(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "globalprops");
        Map r10 = this.e.b();
        r10.put("bullet_update_type", 1);
        r10.putAll(r5);
        LynxView r11 = this.g;
        if (r11 == null) goto L5;
        TemplateData r12 = TemplateData.c(r10);
        r12.i("bullet_update_type", 1);
        r11.updateGlobalProps(r12);
    L5:
        boolean r13 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, this.f5639h, "update updateGlobalProps", "XLynxKit");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(String r25, n r26, String r27) {
        String r5 = "url";
        Intrinsics.checkNotNullParameter(r25, "url");
        Intrinsics.checkNotNullParameter(r26, "lifeCycle");
        Intrinsics.checkNotNullParameter(r27, "sessionId");
        cd.a.a(r27);
        com.bytedance.ies.bullet.lynx.impl.e r10 = this.e;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r27, "sessionId");
        String r11 = "XLynxKit";
        if (com.bytedance.ies.bullet.lynx.impl.e.f5654o == false) goto L5;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XLynxKit", "cold start this time", null, 12);
        r10.f5661k = true;
        com.bytedance.ies.bullet.lynx.impl.e.f5654o = false;
    L5:
        Lazy r12 = com.bytedance.ies.bullet.core.f.f5312b;
        com.bytedance.ies.bullet.core.e r13 = td.b.b().a(r27);
        r10.f = r13;
        if (r13 != null) goto L8;
        String r17 = "url";
        r11 = "XLynxKit";
    L104:
        final Uri r14 = Uri.parse(r25);
        final rd.e r15 = this.e.a(r25, r27);
        final com.bytedance.ies.bullet.ui.common.loader.a r16 = (com.bytedance.ies.bullet.ui.common.loader.a) r26;
        h(new LynxKitView$loadUri$1(r16, r14, this, r15));
        this.e.getClass();
        boolean r18 = com.bytedance.ies.bullet.core.h.g.f5315a;
        com.bytedance.ies.bullet.core.e r19 = this.e.f;
        if (r19 == null) goto L109;
        com.bytedance.ies.bullet.service.monitor.b r20 = r19.f5293c;
        if (r20 == null) goto L109;
        r20.w();
    L109:
        c r21 = this.e.e();
        c(r21);
        LynxView r22 = this.g;
        if (r22 != null) goto L112;
        h(new LynxKitView$loadUriInner$1(r16, r14));
    L284:
        Unit r23 = Unit.INSTANCE;
        return;
    L112:
        Intrinsics.checkNotNull(r22);
        com.bytedance.ies.bullet.core.e r24 = this.e.f;
        if (r24 == null) goto L116;
        String r28 = r24.f;
        if (r28 == null) goto L116;
    L117:
        tc.c r29 = tc.c.f22119c;
        rc.c r30 = (i) tc.c.f22119c.a(i.class, r28);
        if (r30 != null) goto L120;
        Lazy r31 = com.bytedance.ies.bullet.service.monitor.i.d;
        r30 = m.b();
    L120:
        com.obric.oui.constraintlayout.core.widgets.analyzer.f r32 = new com.obric.oui.constraintlayout.core.widgets.analyzer.f((String) ((com.bytedance.ies.bullet.service.monitor.i) r30).f6054b.f9377c);
        r32.d = null;
        com.bytedance.ies.bullet.lynx.impl.e r110 = this.e;
        if (r110 != null) goto L124;
        r110 = null;
    L124:
        if (r110 == null) goto L126;
        com.bytedance.ies.bullet.core.e r111 = r110.f;
    L127:
        r32.e = new mn.i(new WeakReference(r111));
        r32.f12567a = true;
        Intrinsics.checkNotNullParameter("bullet", "<set-?>");
        r32.g = "bullet";
        r32.f12570h = l();
        Lazy r33 = com.bytedance.ies.bullet.core.f.f5312b;
        com.bytedance.ies.bullet.core.e r34 = td.b.b().a(this.f5639h);
        if (r34 != null) goto L130;
    L132:
        qo.a.h(r22, r32);
        String r35 = this.f5639h;
        LynxView r36 = this.g;
        Intrinsics.checkNotNull(r36);
        Intrinsics.checkNotNullParameter(r35, "sessionId");
        Intrinsics.checkNotNullParameter(r36, "lynxView");
        LynxView r37 = this.g;
        if (r37 == null) goto L135;
        r37.addLynxViewClient(new j(r16, r14, this));
    L135:
        h(new LynxKitView$loadUriInner$3(r16, r14, this));
        com.bytedance.ies.bullet.lynx.impl.e r38 = this.e;
        LynxView r39 = this.g;
        Intrinsics.checkNotNull(r39);
        r38.getClass();
        Intrinsics.checkNotNullParameter(r39, "view");
        if (r38.d == false) goto L228;
        if (r39 == null) goto L228;
        com.bytedance.ies.bullet.core.e r40 = r38.f;
        if (r40 == null) goto L143;
        com.bytedance.ies.bullet.service.monitor.b r41 = r40.f5293c;
        if (r41 == null) goto L143;
        r41.u();
    L143:
        LinkedHashMap r42 = cd.a.f1171a;
        com.bytedance.ies.bullet.core.e r43 = r38.f;
        if (r43 == null) goto L146;
        String r44 = r43.getSessionId();
    L147:
        rb.b r45 = cd.a.a(r44);
        pb.a r46 = (pb.a) tc.c.f22119c.a(pb.a.class, "default_bid");
        if (r46 == null) goto L158;
        boolean r112 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(6, "DefaultLynxDelegate.onLynxViewCreated, createMethodFinder from ".concat(r46.getClass().getName()), null);
        Iterator r113 = r46.c(r45).iterator();
    L151:
        if (r113.hasNext() == false) goto L156;
        com.bytedance.sdk.xbridge.cn.protocol.h r114 = (com.bytedance.sdk.xbridge.cn.protocol.h) r113.next();
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r115 = r38.e;
        if (r115 == null) goto L151;
        r115.g(r114);
        goto L151
    L156:
        if ((r46 instanceof com.ivy.ivykit.plugin.impl.jsb.c) == false) goto L158;
        com.ivy.ivykit.plugin.impl.jsb.c r47 = (com.ivy.ivykit.plugin.impl.jsb.c) r46;
        Intrinsics.checkNotNullParameter(r45, "providerFactory");
    L158:
        tc.c r48 = tc.c.f22119c;
        tc.c r49 = tc.c.f22119c;
        com.bytedance.ies.bullet.core.e r116 = r38.f;
        if (r116 == null) goto L162;
        String r117 = r116.f;
        if (r117 == null) goto L162;
    L163:
        pb.a r50 = (pb.a) r49.a(pb.a.class, r117);
        if ((r50 instanceof com.ivy.ivykit.plugin.impl.jsb.c) == false) goto L166;
        com.ivy.ivykit.plugin.impl.jsb.c r51 = (com.ivy.ivykit.plugin.impl.jsb.c) r50;
    L167:
        if (r51 == null) goto L169;
        Intrinsics.checkNotNullParameter(r45, "providerFactory");
    L169:
        tc.c r52 = tc.c.f22119c;
        com.bytedance.ies.bullet.core.e r118 = r38.f;
        if (r118 == null) goto L173;
        String r119 = r118.f;
        if (r119 == null) goto L173;
    L174:
        pb.a r53 = (pb.a) r52.a(pb.a.class, r119);
        if ((r53 instanceof com.ivy.ivykit.plugin.impl.jsb.c) == false) goto L177;
        com.ivy.ivykit.plugin.impl.jsb.c r54 = (com.ivy.ivykit.plugin.impl.jsb.c) r53;
    L178:
        if (r54 == null) goto L185;
        Iterator r55 = r54.d(r45).iterator();
    L181:
        if (r55.hasNext() == false) goto L185;
        IDLXBridgeMethod r120 = (IDLXBridgeMethod) r55.next();
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r121 = r38.e;
        if (r121 == null) goto L181;
        r121.h(r120);
    L185:
        Intrinsics.checkNotNullParameter(LynxView.class, "clazz");
        r45.b(LynxView.class, new rb.a(r39));
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r56 = r38.e;
        if (r56 == null) goto L188;
        r56.s(r39);
    L188:
        com.bytedance.ies.bullet.core.e r57 = r38.f;
        if (r57 == null) goto L193;
        rd.b r58 = r57.e;
        if (r58 == null) goto L193;
        Uri r59 = ((com.bytedance.ies.bullet.service.sdk.b) r58).f6135c;
    L194:
        if (r59 == null) goto L196;
        String r60 = r59.getQueryParameter("enable_annie_jsb_for_common");
    L198:
        if (Intrinsics.areEqual(r60, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L204;
        tc.c r61 = tc.c.f22119c;
        pb.a r62 = (pb.a) tc.c.f22119c.a(pb.a.class, "default_bid");
        if (r62 == null) goto L204;
        if ((r62 instanceof com.ivy.ivykit.plugin.impl.jsb.c) == false) goto L204;
        defpackage.c r122 = new defpackage.c();
        com.bytedance.ies.bullet.core.e r63 = r38.f;
        Intrinsics.checkNotNull(r63);
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r64 = r38.e;
        Intrinsics.checkNotNull(r64);
        r122.d(r63, r39, r64, r45, r38.f5658h);
    L204:
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r65 = r38.e;
        if (r65 == null) goto L207;
        r65.i(rb.b.class, r45);
    L207:
        com.bytedance.ies.bullet.core.e r66 = r38.f;
        if (r66 == null) goto L212;
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r67 = r38.e;
        if (r67 == null) goto L212;
        r67.i(com.bytedance.ies.bullet.core.e.class, r66);
    L212:
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r68 = r38.e;
        if (r68 == null) goto L215;
        r68.i(kj.b.class, r38.f5659i);
    L215:
        com.bytedance.ies.bullet.core.e r69 = r38.f;
        if (r69 == null) goto L220;
        r69.f5302p = new com.bytedance.ies.bullet.lynx.impl.d(r38);
    L220:
        if (r38.f5662l.getValue() != null) goto L227;
        com.bytedance.ies.bullet.core.e r70 = r38.f;
        if (r70 == null) goto L228;
        com.bytedance.ies.bullet.service.monitor.b r71 = r70.f5293c;
        if (r71 == null) goto L228;
        r71.v();
        goto L228
    L227:
        throw new ClassCastException();
    L196:
        r60 = null;
    L193:
        r59 = null;
        goto L194
    L177:
        r54 = null;
    L173:
        r119 = "default_bid";
        goto L174
    L166:
        r51 = null;
    L162:
        r117 = "default_bid";
        goto L163
    L146:
        r44 = null;
    L228:
        com.bytedance.ies.bullet.core.e r72 = this.e.f;
        TemplateBundle r73 = r21.f5623j;
        if (r73 == null) goto L231;
    L233:
        String r123 = null;
        wc.g r74 = null;
    L234:
        if (r73 != null) goto L236;
    L245:
        boolean r75 = r21.f5624k;
        q7.a r76 = this.e.f5663m;
        if (r76 == null) goto L252;
        com.bytedance.ies.bullet.core.e r77 = ((com.bytedance.ies.bullet.lynx.impl.e) r76.f21488b).f;
        if (r77 == null) goto L252;
        com.bytedance.ies.bullet.service.monitor.b r78 = r77.f5293c;
        if (r78 == null) goto L252;
        r78.B();
    L252:
        final Uri r124 = Uri.parse(r25);
        if (r76 == null) goto L266;
        String r79 = r17;
        Intrinsics.checkNotNullParameter(r25, r79);
        Intrinsics.checkNotNullParameter(r25, r79);
        LinkedHashMap r80 = cd.a.f1171a;
        com.bytedance.ies.bullet.core.e r81 = ((com.bytedance.ies.bullet.lynx.impl.e) r76.f21488b).f;
        if (r81 == null) goto L257;
        String r82 = r81.getSessionId();
    L258:
        rb.b r83 = cd.a.a(r82);
        Intrinsics.checkNotNullParameter(o.class, "clazz");
        rb.a r84 = (rb.a) r83.f21717a.get(o.class);
        rb.a r85 = r84;
        if (r84 != null) goto L262;
        r85 = r123;
    L262:
        if (r85 == 0) goto L266;
        if (((o) r85.a()) == null) goto L266;
        Intrinsics.checkNotNullParameter(r25, r79);
        Intrinsics.checkNotNullParameter(r25, r79);
        goto L266
    L257:
        r82 = r123;
    L266:
        if (r74 != null) goto L268;
        wc.g r125 = i(r25);
    L269:
        final LynxKitView$loadResource$onSuccess$1 r126 = new LynxKitView$loadResource$onSuccess$1(this, r75, r25, r125, r16);
        final LynxKitView$loadResource$onFailed$1 r86 = new LynxKitView$loadResource$onFailed$1(r16, r25, this, r75);
        ((rc.a) this.f5636a.f6210a).b(wc.a.class, r125.f22837b);
        boolean r87 = com.bytedance.ies.bullet.service.base.b.f5956a;
        String r88 = this.f5639h;
        StringBuilder r89 = new StringBuilder();
        if (r75 == false) goto L272;
        String r90 = GeckoFetcher.GECKO_SDK_INVOKE_ASYNC_TAG;
    L273:
        com.bytedance.ies.bullet.service.base.b.b(8, r88, f4.b.b(r89, r90, " load template url: ", r25), r11);
        if (r75 == false) goto L283;
        c r91 = this.f5640i;
        zm.c r92 = com.bytedance.ies.bullet.forest.f.f5397a;
        if (r91 == null) goto L278;
        String r93 = "ttnet";
    L279:
        Scene r94 = Scene.f4345a;
        String r95 = l();
        if (r125.f22838c.length() != 0) goto L282;
        String r96 = this.f5637b.f22117a;
        Intrinsics.checkNotNullParameter(r96, "<set-?>");
        r125.f22838c = r96;
    L282:
        Unit r97 = Unit.INSTANCE;
        com.bytedance.ies.bullet.forest.f.e(r25, r93, r94, r95, r125, null, new LynxKitView$loadResource$4(this, r126, r124, r86), 193);
        goto L284
    L278:
        r93 = r123;
        goto L279
    L283:
        ConcurrentHashMap r98 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
        com.bytedance.ies.bullet.kit.resourceloader.g.a(this.f5637b.f22117a).a(r25, r125, new LynxKitView$loadResource$5(this, r126), new LynxKitView$loadResource$6(r86));
        goto L284
    L272:
        r90 = "RL";
        goto L273
    L268:
        r125 = r74;
        goto L269
    L236:
        if (this.g == null) goto L245;
        Lazy r99 = com.bytedance.ies.bullet.core.f.f5312b;
        com.bytedance.ies.bullet.core.e r100 = td.b.b().a(this.f5639h);
        if (r100 == null) goto L240;
        l r127 = r100.f5309x;
    L241:
        if (r127 == 0) goto L244;
        Intrinsics.checkNotNullParameter("templateBundle", "<set-?>");
        r127.f5347b = "templateBundle";
    L244:
        j(r25, r73);
        goto L284
    L240:
        r127 = r123;
        goto L241
    L231:
        if (com.bytedance.ies.bullet.preloadv2.c.f5880a == false) goto L233;
        r74 = i(r25);
        String r101 = com.bytedance.apm.util.a.c(r25, r74);
        r123 = null;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XPreload", "get template from TemplateMemoryCache", null, 12);
        oc.e.d.b(r101);
        goto L234
    L130:
        if (r34.B != true) goto L132;
        r32.f12568b = false;
        goto L132
    L126:
        r111 = null;
    L116:
        r28 = "default_bid";
        goto L117
    L8:
        ArrayList r102 = new ArrayList();
        com.bytedance.ies.bullet.core.e r128 = r10.f;
        if (r128 == null) goto L13;
        ArrayList r129 = r128.f5300n;
        if (r129 == null) goto L13;
        r102.addAll(r129);
    L13:
        com.bytedance.ies.bullet.core.e r130 = r10.f;
        if (r130 == null) goto L18;
        n r131 = r130.f5299m;
        if (r131 == null) goto L18;
        r102.add(r131);
    L18:
        com.bytedance.ies.bullet.core.e r103 = r10.f;
        if (r103 == null) goto L59;
        com.bytedance.ies.bullet.core.j r132 = r103.f5306u;
        com.bytedance.ies.bullet.lynx.impl.f r104 = new com.bytedance.ies.bullet.lynx.impl.f();
        Iterable r105 = (List) r103.f5305t.f288c;
        if (r105 != null) goto L23;
        r105 = new ArrayList();
    L23:
        Intrinsics.checkNotNullParameter(r103, "bulletContext");
        Intrinsics.checkNotNullParameter(r105, "packageNames");
        Intrinsics.checkNotNullParameter(r103, "bulletContext");
        Intrinsics.checkNotNullParameter(r105, "packageNames");
        r104.d = r103;
        rb.b r133 = cd.a.a(r103.getSessionId());
        Iterator r106 = r105.iterator();
    L24:
        r17 = r5;
        if (r106.hasNext() == false) goto L32;
        String r134 = (String) r106.next();
        tc.c r135 = tc.c.f22119c;
        Iterator r136 = r106;
        com.ivy.ivykit.plugin.impl.utils.b r107 = (com.ivy.ivykit.plugin.impl.utils.b) tc.c.f22119c.a(com.ivy.ivykit.plugin.impl.utils.b.class, r134);
        if (r107 == null) goto L31;
        if (Intrinsics.areEqual("CardView", r104.a()) == true) goto L31;
        r104.f.add(r107);
    L31:
        r5 = r17;
        r106 = r136;
        goto L24
    L32:
        tc.c r108 = tc.c.f22119c;
        r104.e = (com.ivy.ivykit.plugin.impl.utils.b) tc.c.f22119c.a(com.ivy.ivykit.plugin.impl.utils.b.class, r104.a());
        if (Intrinsics.areEqual("default_bid", r104.a()) == false) goto L35;
    L37:
        Iterator r109 = r104.f.iterator();
    L39:
        if (r109.hasNext() == false) goto L42;
        ((com.ivy.ivykit.plugin.impl.utils.b) r109.next()).getClass();
        Intrinsics.checkNotNullParameter(r133, "providerFactory");
        r104.g.addAll(com.ivy.ivykit.plugin.impl.utils.b.d(r133));
        Intrinsics.checkNotNullParameter(r133, "providerFactory");
        Intrinsics.checkNotNullParameter(r133, "providerFactory");
        Intrinsics.checkNotNullParameter(r133, "providerFactory");
        goto L39
    L42:
        if (r104.e == null) goto L44;
        Intrinsics.checkNotNullParameter(r133, "providerFactory");
        r104.g.addAll(com.ivy.ivykit.plugin.impl.utils.b.d(r133));
        Intrinsics.checkNotNullParameter(r133, "providerFactory");
        Intrinsics.checkNotNullParameter(r133, "providerFactory");
        Intrinsics.checkNotNullParameter(r133, "providerFactory");
    L44:
        Iterator r137 = r104.f5271b.iterator();
    L46:
        if (r137.hasNext() == false) goto L50;
        vc.c r138 = ((n) r137.next()).getLynxClient();
        if (r138 == null) goto L46;
        r104.f5665h.add(r138);
        goto L46
    L50:
        n r139 = r103.f5299m;
        if (r139 == null) goto L55;
        vc.c r140 = r139.getLynxClient();
        if (r140 == null) goto L55;
        r104.f5665h.add(r140);
    L55:
        vc.c r141 = (vc.c) r133.a(vc.c.class);
        if (r141 == null) goto L58;
        r104.f5665h.add(r141);
    L58:
        td.c.c(r104, KitType.d);
        r103.f5300n.clear();
        ArrayList r142 = r104.f5271b;
        Intrinsics.checkNotNullParameter(r142, "<set-?>");
        r103.f5300n = r142;
        r132.f5320b = r104;
    L60:
        com.bytedance.ies.bullet.core.e r143 = r10.f;
        if (r143 == null) goto L77;
        n r144 = r143.f5299m;
        if (r144 == null) goto L77;
        vc.c r145 = r144.getLynxClient();
        if (r145 == null) goto L77;
        com.bytedance.ies.bullet.lynx.impl.f r146 = r10.d();
        if (r146 == null) goto L77;
        ArrayList r147 = r146.f5665h;
        if (r147 == null) goto L77;
        if (r147.contains(r145) == true) goto L77;
        com.bytedance.ies.bullet.lynx.impl.f r148 = r10.d();
        if (r148 == null) goto L77;
        ArrayList r149 = r148.f5665h;
        if (r149 == null) goto L77;
        r149.add(r145);
    L77:
        com.bytedance.ies.bullet.core.e r150 = r10.f;
        if (r150 == null) goto L104;
        ArrayList r151 = r150.f5300n;
        if (r151 == null) goto L104;
        Iterator r152 = r151.iterator();
    L83:
        if (r152.hasNext() == false) goto L104;
        n r153 = (n) r152.next();
        Result.Companion r154 = Result.Companion;     // Catch: Throwable -> L90
        com.bytedance.ies.bullet.core.e r155 = r10.f;     // Catch: Throwable -> L90
        if (r155 == null) goto L92;
        Uri r156 = r155.f5297k;     // Catch: Throwable -> L90
        if (r156 == null) goto L92;
    L93:
        com.bytedance.ies.bullet.core.e r157 = r10.f;     // Catch: Throwable -> L90
        if (r157 == null) goto L96;
        n r158 = r157.f5299m;     // Catch: Throwable -> L90
    L98:
        if ((r158 instanceof com.bytedance.ies.bullet.core.container.e) == false) goto L100;
        com.bytedance.ies.bullet.core.container.e r159 = (com.bytedance.ies.bullet.core.container.e) r158;     // Catch: Throwable -> L90
    L101:
        r153.u(r156, r159);     // Catch: Throwable -> L90
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L90
        goto L83
    L100:
        r159 = null;
        goto L101
    L96:
        r158 = null;
    L92:
        r156 = Uri.parse("");     // Catch: Throwable -> L90
    L90:
        th = move-exception;
        Result.Companion r160 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L83
    L35:
        if (((com.ivy.ivykit.plugin.impl.utils.b) tc.c.f22119c.a(com.ivy.ivykit.plugin.impl.utils.b.class, "default_bid")) == null) goto L37;
        r104.g.addAll(com.ivy.ivykit.plugin.impl.utils.b.d(r133));
        Intrinsics.checkNotNullParameter(r133, "providerFactory");
        goto L37
    L59:
        r17 = "url";
        goto L60
    }

    public final void f(String r10, TemplateBundle r11) {
        ConcurrentHashMap r5 = yc.a.f23246a;     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");     // Catch: Throwable -> L10
        xc.e r12 = (xc.e) yc.a.a(xc.e.class, "default_bid");     // Catch: Throwable -> L10
        if (r12 == null) goto L12;
        xc.d r13 = (xc.d) r12.a(xc.d.class);     // Catch: Throwable -> L10
        if (r13 == null) goto L12;
        Boolean r14 = r13.j();     // Catch: Throwable -> L10
        if (r14 == null) goto L12;
        boolean r15 = r14.booleanValue();     // Catch: Throwable -> L10
    L13:
        if (r15 == false) goto L16;
        String r16 = io.reactivex.exceptions.a.b(Uri.parse(r10), this.f5637b.f22117a);     // Catch: Throwable -> L10
        if (r16 == null) goto L16;
    L17:
        k(r10);     // Catch: Throwable -> L10
        c r17 = this.f5640i;     // Catch: Throwable -> L10
        TemplateData r18 = null;
        if (r17 == null) goto L20;
        r18 = r17.e;     // Catch: Throwable -> L10
    L20:
        q7.a r19 = this.e.f5663m;     // Catch: Throwable -> L10
        if (r19 == null) goto L27;
        com.bytedance.ies.bullet.core.e r20 = ((com.bytedance.ies.bullet.lynx.impl.e) r19.f21488b).f;     // Catch: Throwable -> L10
        if (r20 == null) goto L27;
        com.bytedance.ies.bullet.service.monitor.b r21 = r20.f5293c;     // Catch: Throwable -> L10
        if (r21 == null) goto L27;
        r21.z();     // Catch: Throwable -> L10
    L27:
        Map<String, Object> r22 = this.e.b();     // Catch: Throwable -> L10
        LynxView r23 = this.g;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r23);     // Catch: Throwable -> L10
        r23.updateGlobalProps(r22);     // Catch: Throwable -> L10
        LynxView r24 = this.g;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r24);     // Catch: Throwable -> L10
        r24.renderTemplateBundle(r11, r18, r16);     // Catch: Throwable -> L10
        q7.a r25 = this.e.f5663m;     // Catch: Throwable -> L10
        if (r25 == null) goto L34;
        com.bytedance.ies.bullet.core.e r26 = ((com.bytedance.ies.bullet.lynx.impl.e) r25.f21488b).f;     // Catch: Throwable -> L10
        if (r26 == null) goto L34;
        com.bytedance.ies.bullet.service.monitor.b r27 = r26.f5293c;     // Catch: Throwable -> L10
        if (r27 == null) goto L34;
        r27.A();     // Catch: Throwable -> L10
    L34:
        boolean r28 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L10
        com.bytedance.ies.bullet.service.base.b.b(8, this.f5639h, "load with templateBundle", "XLynxKit");     // Catch: Throwable -> L10
        return;
    L16:
        r16 = r10;
    L12:
        r15 = true;
    L10:
        th = move-exception;
        com.bytedance.ies.bullet.service.base.b.g("load with templateBundle", "XLynxKit", th);
    }

    public final void h(Function0 r5) {
        com.bytedance.ies.bullet.core.e r10 = this.e.f;
        if (r10 == null) goto L16;
        rd.e r11 = r10.g;
        if (r11 == null) goto L9;
        Boolean r12 = (Boolean) new vd.a(r11.f21723a, "force_lifecycle_on_ui", Boolean.FALSE).f22372b;
        if (r12 == null) goto L9;
        boolean r13 = r12.booleanValue();
    L11:
        if (r13 != true) goto L16;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == true) goto L16;
        h.f.b(new g(0, r5), h.f.f17263i);
        return;
    L9:
        r13 = false;
    L16:
        r5.invoke();
    }

    public final void g(String r5, byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "templateArray");
        Map<String, Object> r11 = this.e.b();
        LynxView r12 = this.g;
        if (r12 == null) goto L5;
        r12.updateGlobalProps(r11);
    L5:
        c r13 = this.f5640i;
        TemplateData r14 = null;
        if (r13 == null) goto L8;
        r14 = r13.e;
    L8:
        q7.a r15 = this.e.f5663m;
        if (r15 == null) goto L15;
        com.bytedance.ies.bullet.core.e r16 = ((com.bytedance.ies.bullet.lynx.impl.e) r15.f21488b).f;
        if (r16 == null) goto L15;
        com.bytedance.ies.bullet.service.monitor.b r17 = r16.f5293c;
        if (r17 == null) goto L15;
        r17.z();
    L15:
        LynxView r18 = this.g;
        if (r18 == null) goto L18;
        r18.renderTemplateWithBaseUrl(r10, r14, r5);
    L18:
        q7.a r19 = this.e.f5663m;
        if (r19 == null) goto L25;
        com.bytedance.ies.bullet.core.e r20 = ((com.bytedance.ies.bullet.lynx.impl.e) r19.f21488b).f;
        if (r20 == null) goto L25;
        com.bytedance.ies.bullet.service.monitor.b r21 = r20.f5293c;
        if (r21 == null) goto L25;
        r21.A();
    L25:
        boolean r22 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, this.f5639h, "load with template array", "XLynxKit");
    }

    public final void c(c r18) {
        this.f5640i = r18;
        String r5 = r18.g;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        this.f5639h = r5;
        if (this.g == null) goto L8;
        return;
    L8:
        Context r10 = ((rc.a) this.f5636a.f6210a).f21718a;
        Intrinsics.checkNotNull(r10);
        l0 r11 = new l0();
        c r12 = this.f5640i;
        if (r12 == null) goto L14;
        u r13 = r12.f5619b;
        if (r13 == null) goto L14;
        r11.f10900c.f10894c = r13;
    L14:
        if (r12 != null) goto L16;
    L27:
        r11.a(NavigationModule.class, null, NavigationModule.NAME);
        r11.a(LynxViewMonitorModule.class, this.d, "hybridMonitor");
        com.bytedance.ies.bullet.lynx.impl.e r14 = this.e;
        r14.getClass();
        LinkedHashMap r15 = new LinkedHashMap();
        if (r14.d == true) goto L30;
        r15.put("bridge", new lc.b(r14.f));
    L30:
        Iterator r16 = r15.entrySet().iterator();
    L32:
        if (r16.hasNext() == false) goto L34;
        Map.Entry r17 = (Map.Entry) r16.next();
        String r19 = (String) r17.getKey();
        ((lc.b) r17.getValue()).getClass();
        r11.a(LynxBridgeModule.class, ((lc.b) r17.getValue()).f19598a, r19);
        goto L32
    L34:
        com.bytedance.ies.bullet.lynx.impl.e r20 = this.e;
        r20.getClass();
        ArrayList r21 = new ArrayList();
        ArrayList r110 = new ArrayList();
        com.bytedance.ies.bullet.lynx.impl.f r22 = r20.d();
        if (r22 == null) goto L45;
        ArrayList r23 = r22.g;
        if (r23 == null) goto L45;
        Iterator r24 = r23.iterator();
    L40:
        if (r24.hasNext() == false) goto L45;
        Object r111 = r24.next();
        if ((r111 instanceof com.lynx.tasm.behavior.a) == true) goto L43;
        r110.add(String.valueOf(r111));
        goto L40
    L43:
        r21.add(r111);
    L45:
        r11.c(r21);
        if (r12 == null) goto L49;
        ln.b r25 = r12.d;
        if (r25 == null) goto L49;
    L50:
        r11.f10915w = r25;
        if (r12 == null) goto L53;
        r11.g = false;
    L53:
        if (r12 == null) goto L55;
        r11.f10901h = false;
    L55:
        r11.b("EXTERNAL_JS_SOURCE", new k(this.f5636a, this.f5637b));
        r11.b("FONT", new com.bytedance.ies.bullet.lynx.resource.l(this.f5636a, this.f5637b));
        r11.f10900c.f = new com.bytedance.ies.bullet.lynx.resource.c(this.f5636a, this.f5637b);
        r11.f10900c.g = new com.bytedance.ies.bullet.lynx.resource.d(this.f5636a);
        r11.f10900c.f10895h = new com.bytedance.ies.bullet.lynx.resource.j(this.f5636a);
        com.bytedance.ies.bullet.base.utils.logger.a.g("LynxKitView", "enableLynxGenericFetcher: null", null, 12);
        com.bytedance.ies.bullet.lynx.impl.e r26 = this.e;
        r26.getClass();
        Intrinsics.checkNotNullParameter(r11, "viewBuilder");
        String r112 = "XLynxKit";
        if (r26.d == false) goto L147;
        com.bytedance.ies.bullet.core.e r27 = r26.f;
        if (r27 == null) goto L61;
        String r28 = r27.getSessionId();
        if (r28 == null) goto L61;
    L62:
        StringBuilder r29 = com.lynx.tasm.utils.e.b("sessionId = ", r28, ", context = ");
        com.bytedance.ies.bullet.core.e r30 = r26.f;
        if (r30 == null) goto L66;
        Object r31 = r30.f5294h;
        if (r31 == null) goto L66;
    L67:
        r29.append(r31);
        com.bytedance.ies.bullet.base.utils.logger.a.g("XLynxKit", r29.toString(), null, 12);
        com.bytedance.ies.bullet.core.e r32 = r26.f;
        if (r32 == null) goto L76;
        Context r113 = r32.f5294h;
        if (r113 == null) goto L76;
        if (Intrinsics.areEqual(r32.f, "webcast") == false) goto L74;
        String r33 = "webcast";
    L75:
        Intrinsics.checkNotNullParameter(r113, "context");
        Intrinsics.checkNotNullParameter(r28, "containerID");
        Intrinsics.checkNotNullParameter(r33, "namespace");
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r114 = new com.bytedance.sdk.xbridge.cn.platform.lynx.a(r113, r28);
        r114.f7360k = r33;
    L77:
        r26.e = r114;
        com.bytedance.ies.bullet.core.e r34 = r26.f;
        if (r34 == null) goto L80;
        String r35 = r34.f;
    L82:
        if (Intrinsics.areEqual(r35, "webcast") == false) goto L86;
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r36 = r26.e;
        if (r36 == null) goto L86;
        Intrinsics.checkNotNullParameter("host", "namespace");
        r36.f7364o.add("host");
    L86:
        tc.c r37 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r38 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r38 == null) goto L93;
        com.bytedance.ies.bullet.service.base.d r39 = (com.bytedance.ies.bullet.service.base.d) r38.f6163b.getValue();
        if (r39 == null) goto L93;
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r40 = r26.e;
        if (r40 == null) goto L93;
        ArrayList r41 = r39.f5966h;
        r40.f7366q = Boolean.FALSE;
        r40.f7365p = r41;
    L93:
        com.bytedance.ies.bullet.core.e r42 = r26.f;
        if (r42 == null) goto L96;
        String r43 = r42.f;
    L98:
        if (Intrinsics.areEqual(r43, "webcast") == false) goto L102;
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r44 = r26.e;
        if (r44 == null) goto L102;
        ArrayList r45 = new ArrayList();
        com.bytedance.sdk.xbridge.cn.optimize.c r46 = new com.bytedance.sdk.xbridge.cn.optimize.c(null, null, 31);
        r46.f7356a = SetsKt.hashSetOf(new String[]{"bdx_thread_opt_all_schema"});
        HashSet r47 = new HashSet();
        r47.add("sendLogV3");
        r47.add("setStorage");
        r46.f7357b = r47;
        r45.add(r46);
        Unit r48 = Unit.INSTANCE;
        r44.f7366q = Boolean.TRUE;
        r44.f7365p = r45;
    L102:
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r49 = r26.e;
        if (r49 == null) goto L105;
        Intrinsics.checkNotNullParameter(r11, "lynxViewBuilder");
        r11.a(XBridgeLynxModule.class, r49, "bridge");
    L105:
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r50 = r26.e;
        if (r50 == null) goto L132;
        LinkedHashMap r51 = new LinkedHashMap();
        Lazy r52 = com.bytedance.sdk.xbridge.cn.optimize.b.f7355a;
        ConcurrentHashMap r53 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r54 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r54 == null) goto L114;
        xc.d r55 = (xc.d) r54.a(xc.d.class);
        if (r55 == null) goto L114;
        Boolean r56 = r55.v();
        if (r56 == null) goto L114;
        boolean r57 = r56.booleanValue();
    L115:
        r51.put("latch_skip_bpea", Boolean.valueOf(r57));
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r58 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r58 == null) goto L122;
        xc.d r59 = (xc.d) r58.a(xc.d.class);
        if (r59 == null) goto L122;
        Boolean r60 = r59.t();
        if (r60 == null) goto L122;
        boolean r61 = r60.booleanValue();
    L123:
        r51.put("latch_skip_auth", Boolean.valueOf(r61));
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r62 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r62 == null) goto L130;
        xc.d r63 = (xc.d) r62.a(xc.d.class);
        if (r63 == null) goto L130;
        Boolean r64 = r63.D();
        if (r64 == null) goto L130;
        boolean r65 = r64.booleanValue();
    L131:
        r51.put("mix_jsb_opt_switch", Boolean.valueOf(r65));
        r51.put("can_run_in_background_fix", Boolean.valueOf(xq.b.g()));
        r51.put("xbridge_model_proxy_enhancement", Boolean.valueOf(xq.b.s()));
        Intrinsics.checkNotNullParameter(r51, "settings");
        r50.e.putAll(r51);
    L130:
        r65 = true;
    L122:
        r61 = true;
    L114:
        r57 = true;
    L132:
        ki.a r66 = ki.a.f18646a;
        ConcurrentHashMap r67 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r68 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r68 == null) goto L139;
        xc.d r69 = (xc.d) r68.a(xc.d.class);
        if (r69 == null) goto L139;
        Boolean r70 = r69.G0();
        if (r70 == null) goto L139;
        boolean r71 = r70.booleanValue();
    L140:
        ki.a.e = r71;
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r72 = r26.e;
        if (r72 == null) goto L148;
        com.bytedance.ies.bullet.core.e r73 = r26.f;
        if (r73 == null) goto L145;
        boolean r74 = sk.a.d(r73);
    L146:
        r72.f7363n = r74;
        ((com.bytedance.sdk.xbridge.cn.platform.lynx.k) r72.f7362m.getValue()).f7380a.f23298a = r74;
        goto L148
    L145:
        r74 = false;
    L148:
        Boolean r75 = Boolean.TRUE;
        if (Intrinsics.areEqual(null, r75) == false) goto L175;
        com.bytedance.ies.bullet.core.e r76 = r26.f;
        if (r76 == null) goto L153;
        String r77 = r76.f;
    L154:
        ConcurrentHashMap r78 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r79 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r79 == null) goto L159;
        xc.g r80 = (xc.g) r79.a(xc.g.class);
        if (r80 == null) goto L159;
        boolean r81 = r80.a();
    L160:
        if (r81 == true) goto L162;
    L164:
        boolean r82 = false;
    L165:
        if (r82 == false) goto L167;
        boolean r83 = com.bytedance.ies.bullet.service.base.b.f5956a;
        LogLevel r84 = LogLevel.f5954b;
        Intrinsics.checkNotNullParameter("BulletOptimize CodeCache disable by settings", "msg");
        Intrinsics.checkNotNullParameter(r84, "logLevel");
        Intrinsics.checkNotNullParameter("", "subModule");
        com.bytedance.ies.bullet.service.base.b.d("BulletOptimize CodeCache disable by settings", r84, "");
        Object r85 = null;
        boolean r86 = true;
    L177:
        if (Intrinsics.areEqual(r85, r75) == false) goto L180;
        r11.f10902i = r86;
        r11.f10903j = r86;
    L180:
        if (Intrinsics.areEqual(r85, r75) == true) goto L227;
        TraceEvent.c("CreateLynxView");
        ILynxTrailService r87 = (ILynxTrailService) r.g().e(ILynxTrailService.class);
        if ((r87 instanceof ILynxTrailServiceExtension) == false) goto L184;
        ((ILynxTrailServiceExtension) r87).parseLynxViewBuilder(r11);
    L184:
        LynxView r88 = new LynxView(r10, r11);
        if (TraceEvent.f10115c == false) goto L190;
        HashMap r89 = new HashMap();
        if (r88.getLynxContext() == null) goto L189;
        r89.put("instance_id", String.valueOf(r88.getLynxContext().A));
    L189:
        TraceEvent.e(r89);
    L190:
        com.bytedance.ies.bullet.core.e r90 = this.e.f;
        c r91 = this.f5640i;
        if (r91 == null) goto L193;
        ArrayList r92 = r91.f5625l;
    L194:
        Intrinsics.checkNotNull(r92);
        r88.addLynxViewClient(new DefaultLynxViewClient(r92, this.f5636a));
        Lazy r93 = com.bytedance.ies.bullet.core.f.f5312b;
        com.bytedance.ies.bullet.core.e r94 = td.b.b().a(this.f5639h);
        if (r94 == null) goto L201;
        com.bytedance.ies.bullet.core.j r95 = r94.f5306u;
        if (r95 == null) goto L201;
        v3.b r96 = (v3.b) r95.d;
        if (r96 == null) goto L201;
        r88.addLynxViewClient(r96);
    L201:
        r88.setAsyncImageInterceptor(new android.support.v4.media.c(new DefaultLynxViewClient(new ArrayList(), this.f5636a)));
        this.d.f17282a = r88;
        if (com.bytedance.ies.bullet.core.h.g.f5315a == false) goto L213;
        com.bytedance.ies.bullet.core.h.a(r88);
        Result.Companion r97 = Result.Companion;     // Catch: Throwable -> L210
        boolean r98 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L210
        String r99 = r112;
        com.bytedance.ies.bullet.service.base.b.b(8, this.f5639h, "lynxview create lynxKitInitParams: " + new Gson().toJson(r18), r99);     // Catch: Throwable -> L208
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L208
    L232:
        Class.forName("com.ss.ttvideoengine.TTVideoEngine");     // Catch: Throwable -> L219
        LynxKryptonHelper r100 = LynxKryptonUtils.getLynxKryptonHelper(r88);     // Catch: Throwable -> L219
        if (r100 == null) goto L221;
        kc.b r101 = new kc.b(r10);     // Catch: Throwable -> L219
        r100.f10496b.put(KryptonVideoPlayerService.class, r101);     // Catch: Throwable -> L219
        CanvasRuntimeMediator r102 = r100.f10495a;     // Catch: Throwable -> L219
        if (r102 == null) goto L221;
        r102.f10493a.put(KryptonVideoPlayerService.class, r101);     // Catch: Throwable -> L219
    L221:
        boolean r103 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L219
        com.bytedance.ies.bullet.service.base.b.d("register LynxCanvasTTPlayer success", LogLevel.f5954b, r99);     // Catch: Throwable -> L219
    L224:
        tc.c r104 = tc.c.f22119c;
        d r105 = (d) fj.a.a(tc.c.f22119c, d.class, d.class);
        this.g = r88;
        return;
    L219:
        th = move-exception;
        com.bytedance.ies.bullet.service.base.b.g("take it easy. just check ttvideoengine sdk is not exist", r99, th);
    L208:
        th = th;
    L212:
        Result.Companion r106 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    L210:
        th = th;
        r99 = r112;
        goto L212
    L213:
        r99 = r112;
        boolean r107 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, this.f5639h, "lynxview create " + r18, r99);
        goto L232
    L193:
        r92 = null;
        goto L194
    L227:
        throw null;
    L167:
        com.bytedance.ies.bullet.core.e r108 = r26.f;
        if (r108 == null) goto L175;
        ad.a r109 = r108.f5303q;
        if (r109 == null) goto L175;
        String r115 = r109.a();
        if (r115 == null) goto L175;
        com.bytedance.ies.bullet.base.utils.b.g("code cache: ".concat(r115));
        com.lynx.tasm.k r116 = r11.f10900c;
        r86 = true;
        r116.f10892a = true;
        r116.f10893b = r115;
    L174:
        r85 = null;
        goto L177
    L162:
        if (Intrinsics.areEqual("BDUG_BID", r77) == false) goto L164;
        r82 = true;
    L159:
        r81 = false;
        goto L160
    L153:
        r77 = null;
    L175:
        r86 = true;
    L139:
        r71 = true;
        goto L140
    L96:
        r43 = null;
        goto L98
    L80:
        r35 = null;
        goto L82
    L74:
        r33 = "";
    L76:
        r114 = null;
    L66:
        r31 = "null";
    L61:
        r28 = "";
        goto L62
    L147:
        r112 = "XLynxKit";
    L49:
        r25 = new com.bytedance.ies.bullet.lynx.resource.a(this.f5636a);
        goto L50
    L16:
        if (Intrinsics.areEqual(this.f5637b.f22117a, "webcast") == false) goto L22;
        int r117 = r12.f5622i;
        if (r117 <= 0) goto L27;
        int r118 = r12.f5621h;
        if (r118 <= 0) goto L27;
        r11.f10911r = (int) (r117 * 1.0f);
        r11.s = (int) (r118 * 1.0f);
        goto L27
    L22:
        int r119 = r12.f5622i;
        if (r119 <= 0) goto L27;
        int r120 = r12.f5621h;
        if (r120 <= 0) goto L27;
        r11.f10911r = (int) (r119 * 1.0f);
        r11.s = (int) (r120 * 1.0f);
        goto L27
    }

    public static final void d(h r10, String r11, a0 r12, wc.g r13, com.bytedance.ies.bullet.ui.common.loader.a r14) {
        int r5 = 3;
        r10.getClass();
        if (r13.f22839h.length() <= 0) goto L5;
        String r15 = r13.f22839h;
    L8:
        q7.a r16 = r10.e.f5663m;
        if (r16 == null) goto L16;
        com.bytedance.ies.bullet.core.e r17 = ((com.bytedance.ies.bullet.lynx.impl.e) r16.f21488b).f;
        if (r17 == null) goto L16;
        com.bytedance.ies.bullet.service.monitor.b r18 = r17.f5293c;
        if (r18 == null) goto L16;
        r18.x();
    L16:
        if ((r12 instanceof com.bytedance.ies.bullet.forest.m) == false) goto L18;
        com.bytedance.ies.bullet.forest.m r19 = (com.bytedance.ies.bullet.forest.m) r12;
    L19:
        if (r19 == null) goto L21;
        Object r20 = r19.d();
    L23:
        if ((r20 instanceof TemplateBundle) == false) goto L25;
        TemplateBundle r21 = (TemplateBundle) r20;
    L26:
        if (r21 == null) goto L102;
        byte[] r22 = null;
    L39:
        if (r22 != null) goto L42;
        if (r21 != null) goto L42;
        r14.r(Uri.parse(r11), new Throwable("neither byte array nor templateBundle are provided"));
        return;
    L42:
        boolean r23 = true;
        if (r12.d == ResourceFrom.f5927c) goto L45;
    L51:
        int r24 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("LynxKitView", com.lynx.tasm.utils.g.d("===match resInfo.filePath: $", r15, "==="), null, 12);
        String r110 = r12.f5933b;
        if (r110 != null) goto L54;
    L53:
        r110 = r15;
    L54:
        k(r11);
        if (r22 == null) goto L69;
        q7.a r25 = r10.e.f5663m;
        if (r25 == null) goto L69;
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r22, "lynxFile");
        Intrinsics.checkNotNullParameter(r14, "listener");
        com.bytedance.ies.bullet.lynx.impl.e r111 = (com.bytedance.ies.bullet.lynx.impl.e) r25.f21488b;
        com.bytedance.ies.bullet.core.e r112 = r111.f;
        if (r112 == null) goto L64;
        com.bytedance.ies.bullet.service.monitor.b r113 = r112.f5293c;
        if (r113 == null) goto L64;
        r113.y();
    L64:
        if (r111.f5662l.getValue() == null) goto L69;
        throw new ClassCastException();
    L69:
        if (r21 == null) goto L85;
        com.bytedance.ies.bullet.core.e r26 = r10.e.f;
        if (r26 == null) goto L75;
        com.bytedance.ies.bullet.service.monitor.b r27 = r26.f5293c;
        if (r27 == null) goto L75;
        r27.y();
    L75:
        ConcurrentHashMap r28 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r114 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r114 == null) goto L82;
        xc.d r115 = (xc.d) r114.a(xc.d.class);
        if (r115 == null) goto L82;
        Boolean r116 = r115.G();
        if (r116 == null) goto L82;
        r23 = r116.booleanValue();
    L82:
        if (r23 == false) goto L84;
        r10.j(r15, r21);
        return;
    L84:
        r10.j(r110, r21);
        return;
    L85:
        ConcurrentHashMap r29 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r117 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r117 == null) goto L92;
        xc.d r118 = (xc.d) r117.a(xc.d.class);
        if (r118 == null) goto L92;
        Boolean r119 = r118.G();
        if (r119 == null) goto L92;
        r23 = r119.booleanValue();
    L92:
        if (r23 == false) goto L97;
        Intrinsics.checkNotNull(r22);
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L96;
        r10.g(r15, r22);
        return;
    L96:
        h.f.b(new com.airbnb.lottie.k(r10, r22, r15, r5), h.f.f17263i);
        return;
    L97:
        Intrinsics.checkNotNull(r22);
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L100;
        r10.g(r110, r22);
        return;
    L100:
        h.f.b(new com.airbnb.lottie.k(r10, r22, r110, r5), h.f.f17263i);
        return;
    L45:
        if (((rc.a) r10.f5636a.f6210a).f21719b == true) goto L50;
        c r30 = r10.f5640i;
        if (r30 == null) goto L51;
        if (r30.f5618a != true) goto L51;
    L50:
        int r120 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("LynxKitView", com.lynx.tasm.utils.g.d("===match sUrl:", r15, "==="), null, 12);
        goto L53
    L102:
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L30
        Object r32 = Result.m124constructorimpl(r12.b());     // Catch: Throwable -> L30
    L32:
        Throwable r33 = Result.m127exceptionOrNullimpl(r32);
        if (r33 == null) goto L36;
        r14.r(Uri.parse(r11), r33);
    L36:
        if (Result.m130isFailureimpl(r32) == false) goto L38;
        r32 = null;
    L38:
        r22 = (byte[]) r32;
    L30:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r32 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L32
    L25:
        r21 = null;
        goto L26
    L21:
        r20 = null;
        goto L23
    L18:
        r19 = null;
        goto L19
    L5:
        r15 = io.reactivex.exceptions.a.b(Uri.parse(r11), r10.f5637b.f22117a);
        if (r15 != null) goto L8;
        r15 = r11;
        goto L8
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final boolean a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schemaUrl");
        String r10 = this.f5638c;
        if (r10 == null) goto L6;
        this.e.a(r5, r10);
        c(this.e.e());
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final View a() {
        return this.g;
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final void a(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        LynxView r10 = this.g;
        if (r10 == null) goto L5;
        TemplateData r11 = TemplateData.c(r5);
        r11.i("bullet_update_type", 1);
        r10.updateData(r11);
    L5:
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, this.f5639h, "update data", "XLynxKit");
    }
}
