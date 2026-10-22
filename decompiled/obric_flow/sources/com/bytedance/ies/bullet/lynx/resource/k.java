package com.bytedance.ies.bullet.lynx.resource;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.salamander.anniex.b0;
import com.lynx.tasm.behavior.ui.utils.n;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends fo.h implements com.bytedance.ies.bullet.forest.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tc.a f5776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f5777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5778c;
    public final com.bytedance.ies.bullet.lynx.resource.forest.c d;

    public k(com.bytedance.ies.bullet.ui.common.loader.c r5, tc.a r10) {
        Intrinsics.checkNotNullParameter(r5, "token");
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_SERVICE);
        this.f5776a = r10;
        this.f5777b = new WeakReference(r5);
        this.f5778c = u8.a.t(this, r5);
        this.d = new com.bytedance.ies.bullet.lynx.resource.forest.c(u8.a.e(this, r5), u8.a.p(this, r5));
    }

    @Override // fo.h
    public final void a(n r10, final fo.g r11) {
        Intrinsics.checkNotNullParameter(r10, "request");
        Intrinsics.checkNotNullParameter(r11, "callback");
        if (this.f5778c == false) goto L6;
        this.d.a(r10, r11);
        return;
    L6:
        String r12 = (String) r10.f10761a;
        Map r5 = null;
        if (TextUtils.isEmpty(r12) == false) goto L10;
        r12 = null;
    L10:
        if (r12 == null) goto L37;
        ConcurrentHashMap r13 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
        com.bytedance.ies.bullet.kit.resourceloader.h r14 = com.bytedance.ies.bullet.kit.resourceloader.g.a(this.f5776a.f22117a);
        wc.g r15 = new wc.g("");
        Intrinsics.checkNotNullParameter("external_js", "<set-?>");
        r15.f22840i = "external_js";
        WeakReference r16 = this.f5777b;
        if (r16 == null) goto L16;
        rc.f r17 = (rc.f) r16.get();
        if (r17 == null) goto L16;
        r5 = r17.getAllDependency();
    L16:
        r15.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r5);
        Uri r18 = Uri.parse(r12);     // Catch: Throwable -> L20
        String r19 = io.reactivex.exceptions.a.b(r18, "default_bid");     // Catch: Throwable -> L20
        if (r19 == null) goto L22;
        Intrinsics.checkNotNullParameter(r19, "<set-?>");     // Catch: Throwable -> L20
        r15.f22839h = r19;     // Catch: Throwable -> L20
    L22:
        String r20 = r18.getQueryParameter(LynxMonitorService.KEY_CHANNEL);     // Catch: Throwable -> L20
        if (r20 == null) goto L25;
        Intrinsics.checkNotNullParameter(r20, "<set-?>");     // Catch: Throwable -> L20
        r15.f = r20;     // Catch: Throwable -> L20
    L25:
        String r21 = r18.getQueryParameter("bundle");     // Catch: Throwable -> L20
        if (r21 == null) goto L28;
        Intrinsics.checkNotNullParameter(r21, "<set-?>");     // Catch: Throwable -> L20
        r15.g = r21;     // Catch: Throwable -> L20
    L28:
        String r22 = r18.getQueryParameter("dynamic");     // Catch: Throwable -> L20
        if (r22 == null) goto L33;
        r15.d = Integer.valueOf(Integer.parseInt(r22));     // Catch: Throwable -> L20
    L33:
        Unit r23 = Unit.INSTANCE;
        r14.a(r12, r15, new ExternalJSProvider$request$2$2(r11), new ExternalJSProvider$request$2$3(r11));
        return;
    L20:
        th = move-exception;
        com.bytedance.ies.bullet.service.base.b.g("ExternalJSProvider parse url error", "XLynxKit", th);
        b0 r24 = new b0(th);
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type com.lynx.tasm.provider.LynxResourceResponse<kotlin.ByteArray>");
        r11.a(r24);
        goto L33
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
