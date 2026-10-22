package com.bytedance.ies.bullet.lynx.resource.forest;

import android.graphics.Typeface;
import android.text.TextUtils;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Scene;
import com.google.common.reflect.w;
import com.lynx.tasm.resourceprovider.LynxResourceRequest$LynxResourceType;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import ko.r;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends wn.h implements com.bytedance.ies.bullet.forest.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5758b;

    public d(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "downloadEngine");
        this.f5757a = r5;
        this.f5758b = r10;
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String forestDownloadEngine(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.c(r5);
    }

    @Override // wn.h
    public final void g(r r17, com.bytedance.lynx.media.b r18) {
        if (TextUtils.isEmpty((String) r17.f18728b) == false) goto L6;
        w r5 = w.b(new Throwable("request.url is null"));
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.String>");
        r18.f(r5);
        return;
    L6:
        String r10 = (String) r17.f18728b;
        if (r10 != null) goto L9;
        r10 = "";
    L9:
        LynxResourceRequest$LynxResourceType r11 = (LynxResourceRequest$LynxResourceType) r17.f18729c;
        LynxResourceRequest$LynxResourceType r14 = LynxResourceRequest$LynxResourceType.f10943b;
        if (r11 != r14) goto L15;
        ConcurrentHashMap r12 = mc.a.f20057a;
        Intrinsics.checkNotNullParameter(r10, "url");
        if (mc.a.f20057a.containsKey(r10) == false) goto L15;
        r18.f(w.a(r10));
        return;
    L15:
        zm.c r13 = com.bytedance.ies.bullet.forest.f.f5397a;
        String r15 = r10;
        com.bytedance.forest.model.w r16 = com.bytedance.ies.bullet.forest.f.b(r15, "downloader", u8.a.l(r11), this.f5758b, null, ForestLynxGenericResourceProvider$fetchResourcePath$1.f5739a, 33);
        if (r16 != null) goto L18;
        return;
    L18:
        if (r16.f4442r == true) goto L21;
        int r19 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("ForestLynxGenericResourceProvider", "Forest load " + r11.name() + " failed", null, 12);
        w r20 = w.b(new Throwable("Forest load " + r11.name() + " failed"));
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.String>");
        r18.f(r20);
        return;
    L21:
        String r21 = r16.f4443t;
        if (r21 != null) goto L24;
    L41:
        com.bytedance.ies.bullet.base.utils.logger.a.d("ForestLynxGenericResourceProvider", "Forest's filePath is empty", null, 12);
        w r22 = w.b(new Throwable("Forest's filePath is empty"));
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.String>");
        r18.f(r22);
        return;
    L24:
        if (r21.length() == 0) goto L41;
        if (r11 == r14) goto L43;
    L32:
        String r23 = r16.f4443t;     // Catch: Exception -> L30
        if (r16.f4444u != ResourceFrom.f4339b) goto L35;
        String r24 = "asset://" + r23;     // Catch: Exception -> L30
    L36:
        r18.f(w.a(r24));     // Catch: Exception -> L30
        Unit r25 = Unit.INSTANCE;     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        String r26 = e.getMessage();
        if (r26 == null) goto L46;
        com.bytedance.ies.bullet.base.utils.logger.a.d("ForestLynxGenericResourceProvider", r26, null, 12);
        Unit r27 = Unit.INSTANCE;
        return;
    L46:
        return;
    L35:
        r24 = "file://" + r23;     // Catch: Exception -> L30
        goto L36
    L43:
        String r28 = r16.f4443t;     // Catch: Exception -> L30
        Intrinsics.checkNotNull(r28);     // Catch: Exception -> L30
        Typeface r29 = Typeface.createFromFile(new File(r28));     // Catch: Exception -> L30
        if (r29 == null) goto L32;
        ConcurrentHashMap r30 = mc.a.f20057a;     // Catch: Exception -> L30
        Intrinsics.checkNotNullParameter(r10, "url");     // Catch: Exception -> L30
        Intrinsics.checkNotNullParameter(r29, "cache");     // Catch: Exception -> L30
        mc.a.f20057a.put(r10, r29);     // Catch: Exception -> L30
        int r31 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;     // Catch: Exception -> L30
        com.bytedance.ies.bullet.base.utils.logger.a.d("ForestLynxGenericResourceProvider", "Forest cache font for ".concat(r10), null, 12);     // Catch: Exception -> L30
        goto L32
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean hasGeckoModelInfo(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.n(r5);
    }

    @Override // wn.h
    public final void i(r r10, final go.a r11) {
        String r5 = (String) r10.f18728b;
        if (TextUtils.isEmpty(r5) == true) goto L5;
    L4:
        String r12 = r5;
        if (r12 == null) goto L9;
        zm.c r13 = com.bytedance.ies.bullet.forest.f.f5397a;
        final LynxResourceRequest$LynxResourceType r14 = (LynxResourceRequest$LynxResourceType) r10.f18729c;
        Scene r15 = u8.a.l(r14);
        Function1<com.bytedance.forest.model.w, Unit> r16 = new ForestLynxGenericResourceProvider$fetchResource$2$1(r11, this, r14);
        String r17 = this.f5758b;
        com.bytedance.ies.bullet.forest.f.e(r12, this.f5757a, r15, r17, null, null, r16, 225);
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L4
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
