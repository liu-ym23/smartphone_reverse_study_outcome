package com.bytedance.ai.model.widgets;

import android.content.Context;
import android.database.MatrixCursor;
import android.net.Uri;
import android.util.SparseArray;
import android.view.View;
import androidx.core.util.Consumer;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ai.applet.render.core.relax.RelaxBridgeModule;
import com.bytedance.ai.applet.render.core.relax.RelaxViewAIBridgePort$RTSInterface;
import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.resource.e0;
import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.pia.core.api.bridge.PiaMethod$InvalidParamsError;
import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;
import com.bytedance.pia.core.api.bridge.PiaMethod$SettingDisableError;
import com.bytedance.pia.core.api.bridge.PiaMethod$UnregisteredError;
import com.bytedance.pia.core.bridge.methods.n0;
import com.bytedance.pia.core.setting.Settings;
import com.google.gson.JsonObject;
import com.ivy.ivykit.api.plugin.IIvyWebService;
import com.obric.android.agilelogger.ALog;
import com.obric.olog.salvage.LogCompressionProvider;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.relax.RelaxView;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2357c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ m(Object r5, Object r10, Object r11, Object r12, Object r13, int r14) {
        this.f2355a = r14;
        this.f2356b = r5;
        this.e = r10;
        this.f2357c = r11;
        this.d = r12;
        this.f = r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        int r10 = 0;
        Object r11 = this.f2356b;
        Object r12 = this.f2357c;
        Object r13 = this.e;
        Object r14 = this.f;
        Object r15 = this.d;
        boolean r16 = true;
        switch(this.f2355a) {
            case 0: goto L126;
            case 1: goto L109;
            case 2: goto L95;
            case 3: goto L40;
            case 4: goto L32;
            case 5: goto L6;
            default: goto L4;
        };
    L4:
        y2.d r17 = (y2.d) r11;
        y2.d.g(r17, (com.bytedance.ai.utils.h) r13, (String) r12, (a3.f) r15, (a2.c) r14);
        return;
    L6:
        String[] r18 = (String[]) r13;
        Uri r19 = (Uri) r12;
        MatrixCursor r110 = (MatrixCursor) r15;
        CountDownLatch r111 = (CountDownLatch) r14;
        int r5 = LogCompressionProvider.f11911c;
        LogCompressionProvider r20 = (LogCompressionProvider) r11;
        r20.getClass();
        Context r21 = r20.getContext();     // Catch: Throwable -> L17 Exception -> L19
        if (r21 != null) goto L174;
    L9:
        r111.countDown();
        return;
    L174:
        so.i r22 = ALog.sConfig;     // Catch: ClassNotFoundException -> L12 Throwable -> L17 Exception -> L19
        Object[] r23 = true;
    L14:
        if (r23 == false) goto L181;
        ALog.syncFlush();     // Catch: Throwable -> L17 Exception -> L19
        Thread.sleep(1000);     // Catch: Throwable -> L17 Exception -> L19
    L181:
        xs.b r24 = com.ss.android.agilelogger.ALog.sConfig;     // Catch: Throwable -> L17 Exception -> L19 ClassNotFoundException -> L173
        r10 = 1;
    L23:
        if (r10 == 0) goto L25;
        com.ss.android.agilelogger.ALog.syncFlush();     // Catch: Throwable -> L17 Exception -> L19
        Thread.sleep(1000);     // Catch: Throwable -> L17 Exception -> L19
    L25:
        rq.a.b(r21, r18);     // Catch: Throwable -> L17 Exception -> L19
        r110.addRow(new Object[]{Uri.withAppendedPath(r19, "zip_file").toString()});     // Catch: Throwable -> L17 Exception -> L19
    L12:
        r23 = false;
    L17:
        th = move-exception;
        r111.countDown();
        throw th;
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
        goto L9
    L32:
        final Consumer r25 = (Consumer) r11;
        final Consumer r26 = (Consumer) r13;
        m1.i r27 = (m1.i) r12;
        String r112 = (String) r15;
        if (r25 != null) goto L35;
        if (r26 != null) goto L35;
    L38:
        r27.e.c(new j2.a(ProtocolMessage.a((ProtocolMessage) r14, Integer.valueOf(r10)), new m1.g(1 == true ? 1 : 0, r112, r27)));
        return;
    L35:
        Consumer r28 = new m1.d(r25, r26);
        SparseArray r29 = r27.f;
        int r30 = r27.f19972a - 1;
        r27.f19972a = r30;
        r29.append(r30, r28);
        r10 = r27.f19972a;
        if (r112 == null) goto L38;
        n1.a r31 = r27.g;
        r31.getClass();
        Intrinsics.checkNotNullParameter(r112, "traceId");
        r31.d.append(r10, r112);
        goto L38
    L40:
        String r32 = (String) r13;
        fh.a r33 = (fh.a) r12;
        fh.a r113 = (fh.a) r14;
        gh.c r34 = (gh.c) r11;
        r34.getClass();
        com.bytedance.pia.core.utils.j.A("[PiaBridge-Call] bridgeName:" + r32);     // Catch: Throwable -> L50
        if (r32 != null) goto L44;
    L52:
        gh.a r35 = r34.f17100c;     // Catch: Throwable -> L50
        PiaMethod$Scope r36 = r34.f17098a;     // Catch: Throwable -> L50
        if (r32 != null) goto L55;
        r35.getClass();     // Catch: Throwable -> L50
    L64:
        ah.b r37 = null;
    L65:
        if (r37 == null) goto L71;
        nh.d r38 = r34.f17099b;     // Catch: Throwable -> L50
        if (r38 != null) goto L69;
        Object r39 = "";
    L70:
        ah.a r40 = (ah.a) r37.f171c.a(r39);     // Catch: Throwable -> L50
    L72:
        if (r40 != null) goto L74;
        r34.a(-2, r32, null, null);     // Catch: Throwable -> L50
        gh.c.b(r33, new PiaMethod$UnregisteredError());     // Catch: Throwable -> L50
        return;
    L74:
        Class r41 = com.bytedance.pia.core.utils.j.j(r40, ah.a.class, 0);     // Catch: Throwable -> L50
        Class r114 = com.bytedance.pia.core.utils.j.j(r40, ah.a.class, 1);     // Catch: Throwable -> L50
        JsonObject r42 = (JsonObject) r15;
        if (r41 == null) goto L82;
        if (r42 == null) goto L82;
        Object r43 = com.bytedance.pia.core.utils.i.a().fromJson(r42, r41);     // Catch: Throwable -> L80
    L87:
        if (r43 == null) goto L89;
    L91:
        long r44 = System.currentTimeMillis();     // Catch: Throwable -> L50
        r40.a(r34, r43, new gh.b(r34, r113, r114, r32, r33, r42, r44), new n0(r34, r32, r42, r44, r33));     // Catch: Throwable -> L50
        return;
    L89:
        if (Void.class == r41) goto L91;
        r34.a(-3, r32, "unsupported params type.", null);     // Catch: Throwable -> L50
        gh.c.b(r33, new PiaMethod$InvalidParamsError());     // Catch: Throwable -> L50
        return;
    L80:
        th = move-exception;
        r34.a(-3, r32, "parse params failed.", th);     // Catch: Throwable -> L50
        gh.c.b(r33, new PiaMethod$InvalidParamsError());     // Catch: Throwable -> L50
        return;
    L82:
        if (r41 != null) goto L84;
    L86:
        r43 = null;
        goto L87
    L84:
        if (r41.isInstance(r42) == false) goto L86;
        r43 = r42;
        goto L87
    L69:
        r39 = r38.f20243n;     // Catch: Throwable -> L50
        goto L70
    L71:
        r40 = null;
        goto L72
    L55:
        r37 = (ah.b) r35.f17094a.get(r32);     // Catch: Throwable -> L50
        if (r37 != null) goto L58;
        r37 = (ah.b) gh.a.f17093b.get(r32);     // Catch: Throwable -> L50
    L58:
        if (r37 == null) goto L64;
        PiaMethod$Scope r45 = PiaMethod$Scope.f6954c;     // Catch: Throwable -> L50
        PiaMethod$Scope r46 = r37.f170b;     // Catch: Throwable -> L50
        if (r45 == r46) goto L65;
        if (r46 != r36) goto L64;
    L44:
        if (r32.startsWith("pia.internal.") == false) goto L52;
        String r47 = r32.substring(13);     // Catch: Throwable -> L50
        String r48 = r47.substring(0, r47.indexOf(46));     // Catch: Throwable -> L50
        Lazy r49 = Settings.B;     // Catch: Throwable -> L50
        Map r50 = (Map) com.lynx.tasm.p.a().f7070w.getValue();     // Catch: Throwable -> L50
        if (r50.containsKey(r48) == false) goto L52;
        if (Boolean.FALSE.equals(r50.get(r48)) == false) goto L52;
        r34.a(-6, r32, null, null);     // Catch: Throwable -> L50
        gh.c.b(r33, new PiaMethod$SettingDisableError());     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        r34.a(0, r32, null, th);
        gh.c.b(r33, new PiaMethod$Error(th.toString()));
        return;
    L95:
        View r51 = (View) r11;
        Intrinsics.checkNotNullParameter(r51, "$topFadingEdge");
        com.obric.flow.cardlistpage.ui.view.i r52 = (com.obric.flow.cardlistpage.ui.view.i) r13;
        Intrinsics.checkNotNullParameter(r52, "this$0");
        View r53 = (View) r12;
        Intrinsics.checkNotNullParameter(r53, "$bottomFadingEdge");
        Ref.BooleanRef r115 = (Ref.BooleanRef) r15;
        Intrinsics.checkNotNullParameter(r115, "$topShowing");
        Ref.BooleanRef r116 = (Ref.BooleanRef) r14;
        Intrinsics.checkNotNullParameter(r116, "$bottomShowing");
        RecyclerView r54 = r52.f11854b;
        if (r54 != null) goto L98;
    L100:
        boolean r55 = false;
    L101:
        com.obric.flow.cardlistpage.ui.view.i.a(r115, r116, r51, r55, true);
        RecyclerView r56 = r52.f11854b;
        if (r56 != null) goto L104;
    L106:
        r16 = false;
    L107:
        com.obric.flow.cardlistpage.ui.view.i.a(r115, r116, r53, r16, false);
        return;
    L104:
        if (r56.canScrollVertically(1) != true) goto L106;
    L98:
        if (r54.canScrollVertically(-1) != true) goto L100;
        r55 = true;
        goto L101
    L109:
        d r117 = (d) r14;
        FragmentActivity r57 = (FragmentActivity) r11;
        if (r57 == null) goto L124;
        WebViewFloatingPageV2 r58 = (WebViewFloatingPageV2) r13;
        rl.a r59 = r58.f2323i;
        if (r59 == null) goto L114;
        r58.f2324j = IIvyWebService.Companion.createIvyWebView("schema", r59, s0.c.a());
    L114:
        PageInfo r60 = (PageInfo) r12;
        String r61 = r60.getPageUrl();
        if (r61 == null) goto L119;
        ql.b r62 = r58.f2324j;
        if (r62 == null) goto L119;
        r62.a(r61);
    L119:
        WebViewFloatingPageV2.j(r58.f2327m, Lifecycle.Event.ON_CREATE);
        Lazy r63 = v0.d.f22502n;
        if (cl.a.h().n(r58, r58.f2330b, r57) == 0) goto L122;
        ((com.bytedance.ai.model.k) r15).invoke(1);
        r58.c();
    L123:
        z2.d.e("create_floating_page", new ym.j(r60));
        return;
    L122:
        r117.invoke("show Floating fail");
        goto L123
    L124:
        r117.invoke("currentActivity is null");
        return;
    L126:
        com.bytedance.ai.model.k r118 = (com.bytedance.ai.model.k) r14;
        FragmentActivity r64 = (FragmentActivity) r11;
        if (r64 == null) goto L171;
        c3.c r65 = new c3.c(r64);
        RelaxViewFloatingPageV2 r66 = (RelaxViewFloatingPageV2) r13;
        r66.g = r65;
        View r67 = (View) r65.f1114a;
        Intrinsics.checkNotNull(r67, "null cannot be cast to non-null type com.relax.RelaxView");
        RelaxView r68 = (RelaxView) r67;
        Intrinsics.checkNotNullParameter(r68, "relaxView");
        RelaxViewAIBridgePort$RTSInterface.initialize(r68);
        RelaxBridgeModule r69 = RelaxViewAIBridgePort$RTSInterface.INSTANCE.getRelaxViewToRelaxBridgeModule().get(r68);
        if (r69 != null) goto L131;
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter("[RelaxViewAIBridgePort] must call JSInterface::initialize before create RelaxViewAIBridgePort", "msg");
        a1.a.f43a.e("ai_bridge", "[RelaxViewAIBridgePort] must call JSInterface::initialize before create RelaxViewAIBridgePort", null);
    L133:
        com.bytedance.ai.applet.render.core.relax.h r70 = null;
    L135:
        if (r70 == null) goto L160;
        m1.i r71 = new m1.i();
        r66.e = r71;
        n1.a r72 = r71.g;
        if (r72 == null) goto L139;
        p r119 = new p(r66);
        Intrinsics.checkNotNullParameter(m1.j.class, "clazz");
        r72.c(m1.j.class, r119, RefType.f1803a);
    L139:
        m1.i r73 = r66.e;
        if (r73 == null) goto L144;
        n1.a r74 = r73.g;
        if (r74 == null) goto L144;
        r74.c(w0.f.class, r66, RefType.f1804b);
    L144:
        m1.i r75 = r66.e;
        if (r75 == null) goto L149;
        n1.a r76 = r75.g;
        if (r76 == null) goto L149;
        r76.c(AppletRuntime.class, r66.f2329a, RefType.f1804b);
    L149:
        m1.i r77 = r66.e;
        if (r77 == null) goto L154;
        n1.a r78 = r77.g;
        if (r78 == null) goto L154;
        com.bytedance.ai.model.s r120 = new com.bytedance.ai.model.s(r66, 4);
        Intrinsics.checkNotNullParameter(com.bytedance.ai.model.s.class, "clazz");
        r78.c(com.bytedance.ai.model.s.class, r120, RefType.f1803a);
    L154:
        m1.i r79 = r66.e;
        if (r79 == null) goto L157;
        o1.b r80 = new o1.b(1);
        Intrinsics.checkNotNullParameter(r80, "methodSeeker");
        r79.f19974c.add(r80);
    L157:
        m1.i r81 = r66.e;
        if (r81 == null) goto L160;
        r81.d(r70);
    L160:
        c3.c r82 = r66.g;
        if (r82 == null) goto L163;
        l r83 = new l(r66, r10);
        Intrinsics.checkNotNullParameter(r83, "interceptor");
        r82.b(new f9.a(r83));
    L163:
        Intrinsics.checkNotNullParameter(r64, "context");
        RelaxViewFloatingPageV2.j(r66.f2320j, Lifecycle.Event.ON_CREATE);
        Lazy r84 = v0.d.f22502n;
        if (cl.a.h().n(r66, r66.f2330b, r64) == 0) goto L166;
        ((com.bytedance.ai.model.k) r15).invoke(1);
        r66.c();
    L167:
        PageInfo r85 = (PageInfo) r12;
        String r86 = r85.getPageUrl();
        if (r86 == null) goto L170;
        e0.k(null, r86, new d(1 == true ? 1 : 0, r66, r85), new com.bytedance.ai.model.m(1), false);
    L170:
        z2.d.e("create_floating_page", new bd.d(r85));
        return;
    L166:
        r118.invoke("show Floating fail");
        goto L167
    L131:
        l2.a r87 = r69.getNext();
        if (r87 == null) goto L133;
        r70 = new com.bytedance.ai.applet.render.core.relax.h(new WeakReference(r68), r87);
        goto L135
    L171:
        r118.invoke("currentActivity is null");
    }
}
