package com.bytedance.ies.bullet.lynx.init;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.w;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.fontface.FontFace$TYPE;
import com.lynx.tasm.p0;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l9.o;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends yn.b implements com.bytedance.ies.bullet.forest.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f5677a;

    public f(boolean r5) {
        this.f5677a = r5;
    }

    @Override // yn.b
    public final Typeface a(LynxContext r17, FontFace$TYPE r18, String r19) {
        if (r19 != null) goto L5;
        return null;
    L5:
        if (r19.length() != 0) goto L8;
        return null;
    L8:
        if (this.f5677a == false) goto L13;
        ConcurrentHashMap r5 = mc.a.f20057a;
        Intrinsics.checkNotNullParameter(r19, "url");
        ConcurrentHashMap r10 = mc.a.f20057a;
        if (r10.containsKey(r19) == false) goto L13;
        Intrinsics.checkNotNullParameter(r19, "url");
        return (Typeface) r10.get(r19);
    L13:
        rc.f r11 = h.d;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("token");
        r11 = null;
    L17:
        if (u8.a.t(this, r11) == false) goto L43;
        if (StringsKt.P(r19, "base64:") == true) goto L43;
        zm.c r12 = com.bytedance.ies.bullet.forest.f.f5397a;
        rc.f r13 = h.d;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("token");
        r13 = null;
    L23:
        w r14 = com.bytedance.ies.bullet.forest.f.b(r19, "downloader", Scene.d, u8.a.p(this, r13), null, LynxKit$setFontLoader$1$onLoadFontFace$1.f5667a, 33);
        if (r14 != null) goto L26;
    L74:
        ConcurrentHashMap r15 = mc.a.f20057a;
        Intrinsics.checkNotNullParameter(r19, "url");
        Typeface r16 = (Typeface) mc.a.f20057a.get(r19);
        if (r16 != null) goto L99;
        if (TextUtils.isEmpty(r19) == false) goto L79;
    L93:
        r16 = null;
    L94:
        if (r16 != null) goto L96;
        return null;
    L96:
        if (this.f5677a == false) goto L99;
        ConcurrentHashMap r20 = mc.a.f20057a;
        Intrinsics.checkNotNullParameter(r19, "url");
        Intrinsics.checkNotNullParameter(r16, "cache");
        mc.a.f20057a.put(r19, r16);
        goto L99
    L79:
        if (r18 == FontFace$TYPE.f10851b) goto L93;
        Intrinsics.checkNotNull(r19);
        int r21 = StringsKt.r("base64,", 0, 6, r19);
        if (StringsKt.P(r19, "data:") == false) goto L93;
        if (r21 == (-1)) goto L93;
        r16 = o.b(r17, Base64.decode(r19.substring(r21 + 7), 0));     // Catch: Exception -> L89
    L89:
        e = move-exception;
        String r22 = e.getMessage();
        p0 r23 = r17.f10150r;
        if (r23 == null) goto L93;
        r23.onReceivedError(new LynxError(r22, 39800));
    L99:
        return r16;
    L26:
        if (r14.f4442r == true) goto L28;
        boolean r24 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("Forest load fontFace failed", LogLevel.d, "XLynxKit");
        goto L74
    L28:
        String r25 = r14.f4443t;
        if (r25 != null) goto L31;
    L41:
        boolean r26 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("Forest's filePath is empty", LogLevel.d, "XLynxKit");
        goto L74
    L31:
        if (r25.length() == 0) goto L41;
        String r27 = r14.f4443t;     // Catch: Exception -> L37
        Intrinsics.checkNotNull(r27);     // Catch: Exception -> L37
        Typeface r28 = Typeface.createFromFile(new File(r27));     // Catch: Exception -> L37
        if (r28 == null) goto L74;
        ConcurrentHashMap r29 = mc.a.f20057a;     // Catch: Exception -> L37
        Intrinsics.checkNotNullParameter(r19, "url");     // Catch: Exception -> L37
        Intrinsics.checkNotNullParameter(r28, "cache");     // Catch: Exception -> L37
        mc.a.f20057a.put(r19, r28);     // Catch: Exception -> L37
        boolean r30 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Exception -> L37
        com.bytedance.ies.bullet.service.base.b.d("Forest cache font for ".concat(r19), LogLevel.d, "XLynxKit");     // Catch: Exception -> L37
    L37:
        e = move-exception;
        String r31 = e.getMessage();
        if (r31 == null) goto L74;
        boolean r32 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d(r31, LogLevel.d, "XLynxKit");
    L43:
        if (ym.h.d() == null) goto L48;
        rc.f r33 = h.d;
        if (r33 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("token");
        r33 = null;
    L47:
        com.bytedance.ies.bullet.preloadv2.e.d(r33.getBid(), r19);
    L48:
        ConcurrentHashMap r34 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.preload.b.class, "cls");
        com.bytedance.ies.bullet.service.preload.b r35 = (com.bytedance.ies.bullet.service.preload.b) yc.a.a(com.bytedance.ies.bullet.service.preload.b.class, "default_bid");
        if (r35 == null) goto L51;
        r35.a(r19);
    L51:
        ConcurrentHashMap r36 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
        rc.f r37 = h.d;
        if (r37 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("token");
        r37 = null;
    L54:
        com.bytedance.ies.bullet.kit.resourceloader.h r38 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r37.getBid());
        wc.g r39 = new wc.g("");
        rc.f r40 = h.d;
        if (r40 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("token");
        r40 = null;
    L57:
        r39.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r40.getAllDependency());
        Intrinsics.checkNotNullParameter("sub_resource", "<set-?>");
        r39.f22840i = "sub_resource";
        Unit r41 = Unit.INSTANCE;
        a0 r42 = r38.c(r19, r39);
        if (r42 != null) goto L60;
        boolean r43 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("Load fontFace failed", LogLevel.d, "XLynxKit");
        goto L74
    L60:
        String r44 = r42.f5933b;
        if (r44 != null) goto L63;
    L73:
        boolean r45 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("ResourceInfo's filePath is empty", LogLevel.d, "XLynxKit");
        goto L74
    L63:
        if (r44.length() == 0) goto L73;
        String r46 = r42.f5933b;     // Catch: Exception -> L69
        Intrinsics.checkNotNull(r46);     // Catch: Exception -> L69
        Typeface r47 = Typeface.createFromFile(new File(r46));     // Catch: Exception -> L69
        if (r47 == null) goto L74;
        ConcurrentHashMap r48 = mc.a.f20057a;     // Catch: Exception -> L69
        Intrinsics.checkNotNullParameter(r19, "url");     // Catch: Exception -> L69
        Intrinsics.checkNotNullParameter(r47, "cache");     // Catch: Exception -> L69
        mc.a.f20057a.put(r19, r47);     // Catch: Exception -> L69
        boolean r49 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Exception -> L69
        com.bytedance.ies.bullet.service.base.b.d("cache font for ".concat(r19), LogLevel.d, "XLynxKit");     // Catch: Exception -> L69
    L69:
        e = move-exception;
        String r50 = e.getMessage();
        if (r50 == null) goto L74;
        boolean r51 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d(r50, LogLevel.d, "XLynxKit");
        goto L74
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
