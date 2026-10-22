package com.bytedance.ies.bullet.lynx.resource;

import android.graphics.Typeface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.common.reflect.w;
import com.lynx.tasm.resourceprovider.LynxResourceRequest$LynxResourceType;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ko.r;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends wn.h implements com.bytedance.ies.bullet.forest.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tc.a f5722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f5723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5724c;
    public final com.bytedance.ies.bullet.lynx.resource.forest.d d;

    public c(com.bytedance.ies.bullet.ui.common.loader.c r5, tc.a r10) {
        Intrinsics.checkNotNullParameter(r5, "token");
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_SERVICE);
        this.f5722a = r10;
        this.f5723b = new WeakReference(r5);
        this.f5724c = u8.a.t(this, r5);
        this.d = new com.bytedance.ies.bullet.lynx.resource.forest.d(u8.a.e(this, r5), u8.a.p(this, r5));
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String forestDownloadEngine(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.c(r5);
    }

    @Override // wn.h
    public final void g(r r13, com.bytedance.lynx.media.b r14) {
        String r5 = (String) r13.f18728b;
        if (TextUtils.isEmpty(r5) == false) goto L7;
        w r12 = w.b(new Throwable("request.url is null"));
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.String>");
        r14.f(r12);
        return;
    L7:
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        LynxResourceRequest$LynxResourceType r10 = LynxResourceRequest$LynxResourceType.f10943b;
        WeakReference r11 = this.f5723b;
        LynxResourceRequest$LynxResourceType r15 = (LynxResourceRequest$LynxResourceType) r13.f18729c;
        if (r15 != r10) goto L26;
        if (r11 == null) goto L19;
        rc.f r16 = (rc.f) r11.get();
        if (r16 == null) goto L19;
        com.bytedance.ies.bullet.settings.b r17 = (com.bytedance.ies.bullet.settings.b) r16.a(com.bytedance.ies.bullet.settings.b.class);
        if (r17 == null) goto L19;
        com.bytedance.ies.bullet.service.base.d r18 = (com.bytedance.ies.bullet.service.base.d) r17.f6163b.getValue();
        if (r18 == null) goto L19;
        boolean r19 = r18.f5964b;
    L20:
        if (r19 == false) goto L26;
        ConcurrentHashMap r110 = mc.a.f20057a;
        Intrinsics.checkNotNullParameter(r5, "url");
        if (mc.a.f20057a.containsKey(r5) == false) goto L26;
        r14.f(w.a(r5));
        return;
    L19:
        r19 = true;
    L26:
        if (this.f5724c == false) goto L32;
        if (StringsKt.P(r5, "base64:") == true) goto L32;
        this.d.g(r13, r14);
        return;
    L32:
        if (r11 == null) goto L47;
        rc.f r111 = (rc.f) r11.get();
        if (r111 == null) goto L47;
        String r112 = r111.getBid();
        if (r112 == null) goto L47;
        if (r15 == r10) goto L40;
        r112 = null;
    L40:
        if (r112 == null) goto L47;
        if (ym.h.d() == null) goto L44;
        com.bytedance.ies.bullet.preloadv2.e.d(r112, r5);
    L44:
        ConcurrentHashMap r113 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.preload.b.class, "cls");
        com.bytedance.ies.bullet.service.preload.b r114 = (com.bytedance.ies.bullet.service.preload.b) yc.a.a(com.bytedance.ies.bullet.service.preload.b.class, "default_bid");
        if (r114 == null) goto L47;
        r114.a(r5);
    L47:
        ConcurrentHashMap r115 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
        if (r11 == null) goto L52;
        rc.f r116 = (rc.f) r11.get();
        if (r116 == null) goto L52;
        String r117 = r116.getBid();
    L53:
        com.bytedance.ies.bullet.kit.resourceloader.h r118 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r117);
        wc.g r119 = new wc.g("");
        if (r11 == null) goto L58;
        rc.f r20 = (rc.f) r11.get();
        if (r20 == null) goto L58;
        Map r21 = r20.getAllDependency();
    L59:
        r119.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r21);
        String r22 = u8.a.f(r15);
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r119.f22840i = r22;
        Unit r23 = Unit.INSTANCE;
        a0 r120 = r118.c(r5, r119);
        if (r120 != null) goto L63;
        int r121 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("DefaultLynxGenericResourceProvider", "Load " + r15.name() + " failed", null, 12);
        w r122 = w.b(new Throwable("Load " + r15.name() + " failed"));
        Intrinsics.checkNotNull(r122, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.String>");
        r14.f(r122);
        return;
    L63:
        String r123 = r120.f5933b;
        if (r123 != null) goto L66;
    L84:
        com.bytedance.ies.bullet.base.utils.logger.a.d("DefaultLynxGenericResourceProvider", "ResourceInfo's filePath is empty", null, 12);
        w r124 = w.b(new Throwable("ResourceInfo's filePath is empty"));
        Intrinsics.checkNotNull(r124, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.String>");
        r14.f(r124);
        return;
    L66:
        if (r123.length() == 0) goto L84;
        if (r15 != r10) goto L75;
        Intrinsics.checkNotNull(r123);     // Catch: Exception -> L72
        Typeface r24 = Typeface.createFromFile(new File(r123));     // Catch: Exception -> L72
        if (r24 == null) goto L75;
        ConcurrentHashMap r25 = mc.a.f20057a;     // Catch: Exception -> L72
        Intrinsics.checkNotNullParameter(r5, "url");     // Catch: Exception -> L72
        Intrinsics.checkNotNullParameter(r24, "cache");     // Catch: Exception -> L72
        mc.a.f20057a.put(r5, r24);     // Catch: Exception -> L72
        int r26 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;     // Catch: Exception -> L72
        com.bytedance.ies.bullet.base.utils.logger.a.d("DefaultLynxGenericResourceProvider", "cache font for ".concat(r5), null, 12);     // Catch: Exception -> L72
    L72:
        e = move-exception;
        String r125 = e.getMessage();
        if (r125 == null) goto L88;
        com.bytedance.ies.bullet.base.utils.logger.a.d("DefaultLynxGenericResourceProvider", r125, null, 12);
        Unit r126 = Unit.INSTANCE;
        return;
    L88:
        return;
    L75:
        if (r120.d != ResourceFrom.f5926b) goto L77;
        String r127 = "asset://".concat(r123);     // Catch: Exception -> L72
    L78:
        r14.f(w.a(r127));     // Catch: Exception -> L72
        return;
    L77:
        r127 = "file://".concat(r123);     // Catch: Exception -> L72
    L58:
        r21 = null;
    L52:
        r117 = null;
        goto L53
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean hasGeckoModelInfo(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.n(r5);
    }

    @Override // wn.h
    public final void i(r r10, final go.a r11) {
        if (this.f5724c == false) goto L6;
        this.d.i(r10, r11);
        return;
    L6:
        String r5 = (String) r10.f18728b;
        if (TextUtils.isEmpty(r5) == false) goto L10;
        r5 = null;
    L10:
        if (r5 == null) goto L38;
        ConcurrentHashMap r12 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
        com.bytedance.ies.bullet.kit.resourceloader.h r13 = com.bytedance.ies.bullet.kit.resourceloader.g.a(this.f5722a.f22117a);
        wc.g r14 = new wc.g("");
        final LynxResourceRequest$LynxResourceType r15 = (LynxResourceRequest$LynxResourceType) r10.f18729c;
        String r16 = u8.a.f(r15);
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r14.f22840i = r16;
        WeakReference r17 = this.f5723b;
        if (r17 == null) goto L16;
        rc.f r18 = (rc.f) r17.get();
        if (r18 == null) goto L16;
        Map r19 = r18.getAllDependency();
    L17:
        r14.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r19);
        Uri r20 = Uri.parse(r5);     // Catch: Throwable -> L21
        String r21 = io.reactivex.exceptions.a.b(r20, "default_bid");     // Catch: Throwable -> L21
        if (r21 == null) goto L23;
        Intrinsics.checkNotNullParameter(r21, "<set-?>");     // Catch: Throwable -> L21
        r14.f22839h = r21;     // Catch: Throwable -> L21
    L23:
        String r22 = r20.getQueryParameter(LynxMonitorService.KEY_CHANNEL);     // Catch: Throwable -> L21
        if (r22 == null) goto L26;
        Intrinsics.checkNotNullParameter(r22, "<set-?>");     // Catch: Throwable -> L21
        r14.f = r22;     // Catch: Throwable -> L21
    L26:
        String r23 = r20.getQueryParameter("bundle");     // Catch: Throwable -> L21
        if (r23 == null) goto L29;
        Intrinsics.checkNotNullParameter(r23, "<set-?>");     // Catch: Throwable -> L21
        r14.g = r23;     // Catch: Throwable -> L21
    L29:
        String r24 = r20.getQueryParameter("dynamic");     // Catch: Throwable -> L21
        if (r24 == null) goto L34;
        r14.d = Integer.valueOf(Integer.parseInt(r24));     // Catch: Throwable -> L21
    L34:
        Unit r25 = Unit.INSTANCE;
        r13.a(r5, r14, new DefaultLynxGenericResourceProvider$fetchResource$2$2(r11, this, r15), new DefaultLynxGenericResourceProvider$fetchResource$2$3(r11, this, r15));
        return;
    L21:
        th = move-exception;
        int r26 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("DefaultLynxGenericResourceProvider", "DefaultLynxGenericResourceProvider parse url error, e: " + th.getMessage(), null, 12);
        w r27 = w.b(th);
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.ByteArray>");
        r11.f(r27);
    L16:
        r19 = null;
        goto L17
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
