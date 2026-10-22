package com.bytedance.ies.bullet.lynx.resource;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.w;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.salamander.anniex.b0;
import com.lynx.tasm.behavior.ui.utils.n;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends fo.h implements com.bytedance.ies.bullet.forest.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f5779a;

    public l(com.bytedance.ies.bullet.ui.common.loader.c r5, tc.a r10) {
        Intrinsics.checkNotNullParameter(r5, "token");
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_SERVICE);
        this.f5779a = new WeakReference(r5);
    }

    @Override // fo.h
    public final void a(n r22, fo.g r23) {
        Intrinsics.checkNotNullParameter(r22, "request");
        Intrinsics.checkNotNullParameter(r23, "callback");
        if (TextUtils.isEmpty((String) r22.f10761a) == false) goto L6;
        b0 r5 = new b0(new Throwable("request.url is null"));
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.lynx.tasm.provider.LynxResourceResponse<kotlin.String>");
        r23.a(r5);
        return;
    L6:
        WeakReference r10 = this.f5779a;
        if (r10 == null) goto L15;
        rc.f r11 = (rc.f) r10.get();
        if (r11 == null) goto L15;
        com.bytedance.ies.bullet.settings.b r12 = (com.bytedance.ies.bullet.settings.b) r11.a(com.bytedance.ies.bullet.settings.b.class);
        if (r12 == null) goto L15;
        com.bytedance.ies.bullet.service.base.d r13 = (com.bytedance.ies.bullet.service.base.d) r12.f6163b.getValue();
        if (r13 == null) goto L15;
        boolean r14 = r13.f5964b;
    L17:
        if (r14 == false) goto L22;
        ConcurrentHashMap r15 = mc.a.f20057a;
        String r16 = (String) r22.f10761a;
        Intrinsics.checkNotNullParameter(r16, "url");
        if (mc.a.f20057a.containsKey(r16) == false) goto L22;
        b0 r17 = new b0((String) r22.f10761a);
        r17.f7246b = 0;
        r23.a(r17);
        return;
    L22:
        WeakReference r18 = this.f5779a;
        if (r18 == null) goto L25;
        rc.f r19 = (rc.f) r18.get();
    L27:
        if (u8.a.t(this, r19) == true) goto L29;
    L83:
        WeakReference r20 = this.f5779a;
        if (r20 == null) goto L95;
        rc.f r21 = (rc.f) r20.get();
        if (r21 == null) goto L95;
        String r24 = r21.getBid();
        if (r24 == null) goto L95;
        if (ym.h.d() == null) goto L92;
        com.bytedance.ies.bullet.preloadv2.e.d(r24, (String) r22.f10761a);
    L92:
        ConcurrentHashMap r25 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.preload.b.class, "cls");
        com.bytedance.ies.bullet.service.preload.b r26 = (com.bytedance.ies.bullet.service.preload.b) yc.a.a(com.bytedance.ies.bullet.service.preload.b.class, "default_bid");
        if (r26 == null) goto L95;
        r26.a((String) r22.f10761a);
    L95:
        ConcurrentHashMap r27 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
        WeakReference r28 = this.f5779a;
        if (r28 == null) goto L100;
        rc.f r29 = (rc.f) r28.get();
        if (r29 == null) goto L100;
        String r30 = r29.getBid();
    L101:
        com.bytedance.ies.bullet.kit.resourceloader.h r31 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r30);
        String r32 = (String) r22.f10761a;
        wc.g r110 = new wc.g("");
        WeakReference r33 = this.f5779a;
        if (r33 == null) goto L106;
        rc.f r34 = (rc.f) r33.get();
        if (r34 == null) goto L106;
        Map r35 = r34.getAllDependency();
    L107:
        r110.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r35);
        Intrinsics.checkNotNullParameter("sub_resource", "<set-?>");
        r110.f22840i = "sub_resource";
        Unit r36 = Unit.INSTANCE;
        a0 r37 = r31.c(r32, r110);
        if (r37 != null) goto L111;
        com.bytedance.ies.bullet.base.utils.logger.a.d("FontResourceProvider", "Load fontFace failed", null, 12);
        b0 r38 = new b0(new Throwable("Load fontFace failed"));
        Intrinsics.checkNotNull(r38, "null cannot be cast to non-null type com.lynx.tasm.provider.LynxResourceResponse<kotlin.String>");
        r23.a(r38);
        return;
    L111:
        String r39 = r37.f5933b;
        if (r39 != null) goto L114;
    L130:
        com.bytedance.ies.bullet.base.utils.logger.a.d("FontResourceProvider", "ResourceInfo's filePath is empty", null, 12);
        b0 r40 = new b0(new Throwable("ResourceInfo's filePath is empty"));
        Intrinsics.checkNotNull(r40, "null cannot be cast to non-null type com.lynx.tasm.provider.LynxResourceResponse<kotlin.String>");
        r23.a(r40);
        return;
    L114:
        if (r39.length() == 0) goto L130;
        String r41 = r37.f5933b;
        if (r37.d != ResourceFrom.f5926b) goto L119;
        String r42 = td.d.b("asset://", r41);
    L120:
        b0 r43 = new b0(r42);
        r43.f7246b = 0;
        r23.a(r43);
        String r44 = r37.f5933b;     // Catch: Exception -> L125
        Intrinsics.checkNotNull(r44);     // Catch: Exception -> L125
        Typeface r45 = Typeface.createFromFile(new File(r44));     // Catch: Exception -> L125
        if (r45 == null) goto L140;
        ConcurrentHashMap r46 = mc.a.f20057a;     // Catch: Exception -> L125
        String r47 = (String) r22.f10761a;     // Catch: Exception -> L125
        Intrinsics.checkNotNullParameter(r47, "url");     // Catch: Exception -> L125
        Intrinsics.checkNotNullParameter(r45, "cache");     // Catch: Exception -> L125
        mc.a.f20057a.put(r47, r45);     // Catch: Exception -> L125
        int r48 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;     // Catch: Exception -> L125
        com.bytedance.ies.bullet.base.utils.logger.a.d("FontResourceProvider", "cache font for " + r22 + ".url", null, 12);     // Catch: Exception -> L125
        return;
    L140:
        return;
    L125:
        e = move-exception;
        String r49 = e.getMessage();
        if (r49 == null) goto L141;
        com.bytedance.ies.bullet.base.utils.logger.a.d("FontResourceProvider", r49, null, 12);
        Unit r50 = Unit.INSTANCE;
        return;
    L141:
        return;
    L119:
        r42 = td.d.b("file://", r41);
    L106:
        r35 = null;
    L100:
        r30 = null;
        goto L101
    L29:
        if (StringsKt.P((String) r22.f10761a, "base64:") == true) goto L83;
        zm.c r51 = com.bytedance.ies.bullet.forest.f.f5397a;
        String r111 = (String) r22.f10761a;
        WeakReference r52 = this.f5779a;
        if (r52 == null) goto L33;
        rc.f r53 = (rc.f) r52.get();
    L34:
        w r54 = com.bytedance.ies.bullet.forest.f.b(r111, "downloader", Scene.d, u8.a.p(this, r53), null, FontResourceProvider$request$1.f5715a, 33);
        if (r54 != null) goto L37;
        return;
    L37:
        if (r54.f4442r == true) goto L40;
        com.bytedance.ies.bullet.base.utils.logger.a.d("FontResourceProvider", "Forest load fontFace failed", null, 12);
        b0 r55 = new b0(new Throwable("Forest load fontFace failed"));
        Intrinsics.checkNotNull(r55, "null cannot be cast to non-null type com.lynx.tasm.provider.LynxResourceResponse<kotlin.String>");
        r23.a(r55);
        return;
    L40:
        String r56 = r54.f4443t;
        if (r56 != null) goto L43;
    L81:
        com.bytedance.ies.bullet.base.utils.logger.a.d("FontResourceProvider", "Forest's filePath is empty", null, 12);
        b0 r57 = new b0(new Throwable("Forest's filePath is empty"));
        Intrinsics.checkNotNull(r57, "null cannot be cast to non-null type com.lynx.tasm.provider.LynxResourceResponse<kotlin.String>");
        r23.a(r57);
        return;
    L43:
        if (r56.length() == 0) goto L81;
        com.bytedance.forest.model.ResourceFrom r58 = r54.f4444u;
        if (r58 != com.bytedance.forest.model.ResourceFrom.d) goto L49;
        r58 = null;
    L49:
        if (r58 != null) goto L51;
        r58 = r54.f4445v;
    L51:
        boolean r59 = com.bytedance.ies.bullet.preloadv2.redirect.a.f5885a;
        String r60 = r54.f4443t;
        Intrinsics.checkNotNull(r60);
        String r61 = com.bytedance.ies.bullet.preloadv2.redirect.a.b(r60, r58);
        b0 r62 = new b0(r61);
        r62.f7246b = 0;
        r23.a(r62);
        Uri r63 = Uri.parse(r61);     // Catch: Exception -> L67
        if (r58 == com.bytedance.forest.model.ResourceFrom.f4339b) goto L55;
    L71:
        String r64 = r63.getPath();     // Catch: Exception -> L67
        if (r64 == null) goto L74;
        Typeface r65 = Typeface.createFromFile(new File(r64));     // Catch: Exception -> L67
    L75:
        if (r65 == null) goto L137;
        ConcurrentHashMap r66 = mc.a.f20057a;     // Catch: Exception -> L67
        String r67 = (String) r22.f10761a;     // Catch: Exception -> L67
        Intrinsics.checkNotNullParameter(r67, "url");     // Catch: Exception -> L67
        Intrinsics.checkNotNullParameter(r65, "cache");     // Catch: Exception -> L67
        mc.a.f20057a.put(r67, r65);     // Catch: Exception -> L67
        int r68 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;     // Catch: Exception -> L67
        com.bytedance.ies.bullet.base.utils.logger.a.d("FontResourceProvider", "Forest cache font for " + r22 + ".url", null, 12);     // Catch: Exception -> L67
        return;
    L137:
        return;
    L74:
        r65 = null;
        goto L75
    L55:
        if (Intrinsics.areEqual(r63.getScheme(), "file") == true) goto L71;
        WeakReference r69 = this.f5779a;     // Catch: Exception -> L67
        if (r69 == null) goto L74;
        rc.f r70 = (rc.f) r69.get();     // Catch: Exception -> L67
        if (r70 == null) goto L74;
        rc.e r71 = r70.getServiceContext();     // Catch: Exception -> L67
        if (r71 == null) goto L74;
        Context r72 = ((rc.a) r71).f21718a;     // Catch: Exception -> L67
        if (r72 == null) goto L74;
        AssetManager r73 = r72.getAssets();     // Catch: Exception -> L67
        String r74 = r63.getPath();     // Catch: Exception -> L67
        if (r74 == null) goto L69;
        String r75 = StringsKt.A(r74, "/");     // Catch: Exception -> L67
    L70:
        r65 = Typeface.createFromAsset(r73, r75);     // Catch: Exception -> L67
        goto L75
    L69:
        r75 = null;
    L67:
        e = move-exception;
        String r76 = e.getMessage();
        if (r76 == null) goto L138;
        com.bytedance.ies.bullet.base.utils.logger.a.d("FontResourceProvider", r76, null, 12);
        Unit r77 = Unit.INSTANCE;
        return;
    L138:
        return;
    L33:
        r53 = null;
        goto L34
    L25:
        r19 = null;
    L15:
        r14 = true;
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
