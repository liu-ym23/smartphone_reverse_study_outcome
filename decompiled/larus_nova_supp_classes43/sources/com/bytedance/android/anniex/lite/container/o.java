package com.bytedance.android.anniex.lite.container;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import android.view.View;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o implements na.a {
    public final qa.a a;
    public final ia.c b;
    public AnnieXWebKit c;
    public AnnieXWebModel d;
    public com.bytedance.android.anniex.lite.flow.web.b e;
    public WeakReference<com.bytedance.android.anniex.base.lifecycle.a> f;

    @Override // na.a
    public final void a() {
    }

    @Override // na.a
    public final boolean canGoBack() {
        AnnieXWebKit r0 = this.c;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.A == SccConfig.SccLevel.SAFE) goto L8;
        return false;
    L8:
        if (r0.w <= 0) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // na.a
    public final View d() {
        AnnieXWebKit r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    @Override // na.a
    public final void enterBackground() {
        AnnieXWebKit r0 = this.c;
        if (r0 == null) goto L6;
        r0.j();
        return;
    }

    @Override // na.a
    public final void enterForeground() {
        AnnieXWebKit r0 = this.c;
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    @Override // na.a
    public final void goBack() {
        AnnieXWebKit r0 = this.c;
        if (r0 == null) goto L8;
        SSWebView r1 = r0.e;
        if (r1 == null) goto L9;
        r1.goBack();
        return;
    L9:
        return;
    }

    @Override // na.a
    public final void release() {
        AnnieXWebKit r0 = this.c;
        if (r0 == null) goto L5;
        r0.f();
    L5:
        com.bytedance.android.anniex.lite.flow.web.b r1 = this.e;
        if (r1 == null) goto L8;
        r1.onRelease();
    L8:
        WeakReference<com.bytedance.android.anniex.base.lifecycle.a> r10 = this.f;
        if (r10 == null) goto L21;
        com.bytedance.android.anniex.base.lifecycle.a r11 = r10.get();
        if (r11 == null) goto L22;
        AnnieXWebModel r12 = this.d;
        if (r12 == null) goto L18;
        Uri r13 = r12.c;
        if (r13 == null) goto L18;
        String r14 = r13.toString();
        if (r14 == null) goto L18;
    L19:
        r11.f(r14, this.b);
        return;
    L18:
        r14 = "";
        goto L19
    L22:
        return;
    }

    @Override // na.a
    public final boolean reload() {
        AnnieXWebKit r0 = this.c;
        if (r0 != null) goto L5;
    L17:
        return false;
    L5:
        if (r0.u == null) goto L7;
        boolean r10 = true;
    L9:
        if (r10 == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L17;
        Uri r1 = r0.u;
        if (r1 == null) goto L16;
        m16.b r11 = r0.D;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.ies.bullet.core.model.context.ContextProviderFactory");
        r0.h(r1, true, null, r11);
    L16:
        return true;
    L7:
        r10 = false;
        goto L9
    }

    @Override // na.a
    public final void c(Activity r10) {
        AnnieXWebKit r0 = this.c;
        if (r0 == null) goto L6;
        r0.c(r10);
        return;
    }

    @Override // na.a
    public final void e(Activity r10) {
        AnnieXWebKit r0 = this.c;
        if (r0 == null) goto L6;
        r0.o(r10);
        return;
    }

    @Override // na.a
    public final void sendEvent(com.bytedance.ies.bullet.core.kit.bridge.h r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        AnnieXWebKit r0 = this.c;
        if (r0 == null) goto L6;
        r0.p(r10.getName(), r10.getParams());
        return;
    }

    @Override // na.a
    public final void updateData(String r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
    }

    @Override // na.a
    public final void updateGlobalProps(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "globalProps");
        AnnieXWebKit r0 = this.c;
        if (r0 == null) goto L6;
        r0.q(r10);
        return;
    }

    @Override // na.a
    public final void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
    }

    public o(qa.a r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, "annieXContext");
        Intrinsics.checkNotNullParameter(r11, "iContainer");
        this.a = r10;
        this.b = r11;
    }

    @Override // na.a
    public final void b(String r10, Map r11, m16.b r12, AnnieXLiteContainer.b r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        this.e = com.bytedance.android.anniex.lite.flow.web.a.a(this.a.b);
        Context r14 = this.a.getContext();
        p r1 = null;
        if (r14 == null) goto L29;
        String r15 = this.a.c;
        com.bytedance.android.anniex.lite.flow.web.b r16 = this.e;
        if (r16 == null) goto L26;
        AnnieXWebKit r17 = r16.d();
        if (r17 == null) goto L26;
        String r18 = r17.g();
        if (r18 == null) goto L12;
        com.bytedance.ies.bullet.service.monitor.a.a(r18, "is_from_engine", "true");
    L12:
        if (com.bytedance.ies.bullet.service.base.h.Q() == false) goto L16;
        AnnieXWebModel r19 = r17.c;
        if (r19 == null) goto L16;
        r19.l.b(r14);
    L16:
        Map r20 = x26.a.a;
        w26.g r21 = (w26.g) x26.a.a(w26.g.class);
        if (r21 == null) goto L23;
        w26.e r22 = (w26.e) r21.n0(w26.e.class);
        if (r22 == null) goto L23;
        Boolean r23 = r22.M1();
        if (r23 == null) goto L23;
        boolean r24 = r23.booleanValue();
    L24:
        if (r24 == false) goto L30;
        r17.G = new WeakReference(r14);
    L30:
        this.c = r17;
        if (r17 == null) goto L33;
        Scenes r110 = this.a.a;
        Intrinsics.checkNotNullParameter(r110, "scene");
        r17.i = r110;
    L33:
        Uri r111 = UriProtector.parse(this.a.e);
        qa.a r25 = this.a;
        String r26 = r25.c;
        String r27 = r25.b;
        com.bytedance.android.anniex.lite.flow.web.b r28 = this.e;
        if (r28 == null) goto L37;
        AnnieXWebModel r29 = r28.b(r26, r111, r27);
        if (r29 == null) goto L37;
    L38:
        this.d = r29;
        Map<String, i36.d> r112 = MonitorManager.a;
        qa.a r113 = this.a;
        MonitorManager.h(r113.b, r113.a.getTag());
        if (this.d != null) goto L42;
        if (r13 == null) goto L128;
        Intrinsics.checkNotNullParameter("create AnnieX model error", "errorMessage");
    L128:
        this.f = new WeakReference(r13);
        AnnieXWebKit r114 = this.c;
        if (r114 == null) goto L141;
        m16.b r115 = r114.D;
        if (r115 == null) goto L142;
        this.b.onEngineReady(r115);
        return;
    L142:
        return;
    L141:
        return;
    L42:
        AnnieXWebModel r116 = this.d;
        if (r116 == null) goto L121;
        Map<String, Object> r30 = r116.g;
        if (r11 == null) goto L52;
        Iterator r31 = r11.entrySet().iterator();
    L48:
        if (r31.hasNext() == false) goto L52;
        Map.Entry r32 = (Map.Entry) r31.next();
        if (r30 == null) goto L48;
        r30.put((String) r32.getKey(), r32.getValue());
    L52:
        Context r33 = this.a.getContext();
        if (r33 == null) goto L121;
        AnnieXWebKit r34 = this.c;
        if (r34 == null) goto L121;
        if (r34.m == false) goto L108;
        SSWebView r35 = r34.e;
        if (r35 == null) goto L67;
        Context r36 = r35.getContext();
        if (r36 == null) goto L67;
        if ((r36 instanceof MutableContextWrapper) == false) goto L65;
        HybridLogger r37 = HybridLogger.a;
        HybridLogger.m("AnnieXWebEngineProxy", "loadSchema: webView context is MutableContextWrapper  anniexContext: " + r33, null, null, 12);
        ((MutableContextWrapper) r36).setBaseContext(r33);
        goto L67
    L65:
        HybridLogger r38 = HybridLogger.a;
        HybridLogger.i("AnnieXWebEngineProxy", "loadSchema: webView context is not MutableContextWrapper  " + r36, null, 12);
    L67:
        if (com.bytedance.ies.bullet.service.base.h.P() == false) goto L70;
        if (r12 == null) goto L70;
        r34.D.b(r12);
    L70:
        Map r117 = x26.a.a;
        w26.g r118 = (w26.g) x26.a.a(w26.g.class);
        if (r118 == null) goto L77;
        w26.e r119 = (w26.e) r118.n0(w26.e.class);
        if (r119 == null) goto L77;
        Boolean r120 = r119.c1();
        if (r120 == null) goto L77;
        boolean r121 = r120.booleanValue();
    L78:
        if (r121 == false) goto L82;
        ConcurrentHashMap<String, Object> r122 = com.bytedance.android.anniex.ability.f.a;
        String r123 = r116.a;
        KitType r39 = KitType.WEB;
        String r40 = this.a.b;
        com.bytedance.android.anniex.ability.f.p(r123, r39, r33);
        AnnieXWebKit r124 = this.c;
        if (r124 == null) goto L82;
        r124.q(r116.g);
    L82:
        if (r13 == null) goto L89;
        AnnieXWebModel r125 = this.d;
        if (r125 == null) goto L87;
        String r126 = r125.b;
        if (r126 == null) goto L87;
    L88:
        r13.e(r126, this.b);
    L87:
        r126 = "";
    L89:
        if (r13 == null) goto L103;
        ib.f r127 = r34.I;
        if ((r127 instanceof n) == false) goto L93;
        n r128 = (n) r127;
    L94:
        if (r128 == null) goto L103;
        ia.c r129 = this.b;
        Intrinsics.checkNotNullParameter(r129, "iContainer");
        Intrinsics.checkNotNullParameter(r13, "lifecycle");
        r128.a = r13;
        r128.b = r129;
        monitor-enter(r128);
        r128.d = true;     // Catch: Throwable -> L100
        throw null;     // Catch: Throwable -> L100
    L100:
        th = move-exception;
        throw th;
    L93:
        r128 = null;
    L103:
        new Handler(Looper.getMainLooper()).post(new com.bytedance.android.anniex.web.a(r34));
        if (r11 == null) goto L121;
        AnnieXWebKit r130 = this.c;
        if (r130 == null) goto L121;
        r130.p("annie.updateRenderData", r11);
    L77:
        r121 = true;
        goto L78
    L108:
        if (r13 == null) goto L115;
        AnnieXWebModel r131 = this.d;
        if (r131 == null) goto L113;
        String r132 = r131.b;
        if (r132 == null) goto L113;
    L114:
        r13.e(r132, this.b);
    L113:
        r132 = "";
    L115:
        if (r13 == null) goto L117;
        r1 = new p(this.a, r13, this.b);
    L117:
        if (r12 != null) goto L119;
        r12 = new m16.b();
    L119:
        r34.i(r33, r1, r116, r12);
    L121:
        if (this.c != null) goto L125;
        if (r13 == null) goto L125;
        Intrinsics.checkNotNullParameter("create AnnieXWebkit error", "errorMessage");
    L125:
        if (this.a.getContext() != null) goto L128;
        if (r13 == null) goto L128;
        Intrinsics.checkNotNullParameter("load uri error context = null", "errorMessage");
    L37:
        r29 = com.bytedance.android.anniex.lite.c.b(r26, r111, r27);
    L23:
        r24 = true;
    L26:
        LruCache<String, AnnieXWebModel> r41 = com.bytedance.android.anniex.lite.c.a;
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "bid");
        r17 = ib.c.a(r14, r15);
        com.bytedance.android.anniex.lite.flow.web.b r133 = this.e;
        if (r133 == null) goto L30;
        r133.a();
        goto L30
    L29:
        r17 = null;
        goto L30
    }
}
