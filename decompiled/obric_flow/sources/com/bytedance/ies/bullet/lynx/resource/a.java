package com.bytedance.ies.bullet.lynx.resource;

import android.net.Uri;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ln.b, com.bytedance.ies.bullet.forest.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f5716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ies.bullet.lynx.resource.forest.b f5718c;

    public a(com.bytedance.ies.bullet.ui.common.loader.c r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f5717b = u8.a.t(this, r5);
        this.f5718c = new com.bytedance.ies.bullet.lynx.resource.forest.b(u8.a.e(this, r5), u8.a.p(this, r5));
        this.f5716a = new WeakReference(r5);
    }

    @Override // ln.b
    public final void a(String r10, final zm.c r11) {
        String r5 = null;
        if (r10 != null) goto L6;
        r11.m(null, new Throwable("url is null"));
        return;
    L6:
        String r12 = "DefaultDynamicComponentFetcher start to load ".concat(r10);
        Intrinsics.checkNotNullParameter(r12, "msg");
        dc.b.f16633a.c("[ResourceLoader] " + r12);
        if (this.f5717b == false) goto L10;
        this.f5718c.a(r10, r11);
        return;
    L10:
        Uri r13 = Uri.parse(r10);
        final String r14 = r13.getQueryParameter("dynamic_component_rl_callback_type");
        if (r14 != null) goto L13;
        r14 = "async";
    L13:
        wc.g r15 = new wc.g("");
        WeakReference r16 = this.f5716a;
        if (r16 == null) goto L16;
        rc.f r17 = (rc.f) r16.get();
    L17:
        if (r17 == null) goto L19;
        Map r18 = r17.getAllDependency();
    L20:
        r15.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r18);
        Intrinsics.checkNotNullParameter("component", "<set-?>");
        r15.f22840i = "component";
        String r19 = io.reactivex.exceptions.a.b(r13, "default_bid");     // Catch: Throwable -> L24
        if (r19 == null) goto L26;
        Intrinsics.checkNotNullParameter(r19, "<set-?>");     // Catch: Throwable -> L24
        r15.f22839h = r19;     // Catch: Throwable -> L24
    L26:
        String r20 = r13.getQueryParameter(LynxMonitorService.KEY_CHANNEL);     // Catch: Throwable -> L24
        if (r20 == null) goto L29;
        Intrinsics.checkNotNullParameter(r20, "<set-?>");     // Catch: Throwable -> L24
        r15.f = r20;     // Catch: Throwable -> L24
    L29:
        String r21 = r13.getQueryParameter("bundle");     // Catch: Throwable -> L24
        if (r21 == null) goto L32;
        Intrinsics.checkNotNullParameter(r21, "<set-?>");     // Catch: Throwable -> L24
        r15.g = r21;     // Catch: Throwable -> L24
    L32:
        r15.d = 1;     // Catch: Throwable -> L24
        String r22 = r13.getQueryParameter("dynamic");     // Catch: Throwable -> L24
        if (r22 == null) goto L37;
        r15.d = Integer.valueOf(Integer.parseInt(r22));     // Catch: Throwable -> L24
    L37:
        ConcurrentHashMap r23 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
        if (r16 == null) goto L40;
        rc.f r24 = (rc.f) r16.get();
    L41:
        if (r24 == null) goto L43;
        r5 = r24.getBid();
    L43:
        com.bytedance.ies.bullet.kit.resourceloader.g.a(r5).a(r10, r15, new DefaultDynamicComponentFetcher$loadDynamicComponent$1(r14, r11), new DefaultDynamicComponentFetcher$loadDynamicComponent$2(r11));
        return;
    L40:
        r24 = null;
    L24:
        th = move-exception;
        com.bytedance.ies.bullet.service.base.b.g("DefaultDynamicComponentFetcher parse url error", "XLynxKit", th);
        goto L37
    L19:
        r18 = null;
        goto L20
    L16:
        r17 = null;
        goto L17
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String forestDownloadEngine(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.c(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean hasGeckoModelInfo(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.n(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String sessionID(com.bytedance.ies.bullet.core.e r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        return r5.getSessionId();
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean useForest(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.q(r5);
    }
}
