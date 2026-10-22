package com.bytedance.ies.bullet.web.pia;

import android.app.Application;
import android.content.res.AssetManager;
import android.webkit.WebResourceResponse;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.w;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.bytedance.pia.core.api.resource.LoadFrom;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements dh.d, com.bytedance.ies.bullet.forest.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f6248b;

    public q(String r5, k r10) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        this.f6247a = r5;
        this.f6248b = r10;
    }

    @Override // dh.d
    public final fh.c a(dh.e r25, final fh.a r26, final fh.a r27) {
        Intrinsics.checkNotNullParameter(LoadFrom.f6957c, "loadFrom");
        Intrinsics.checkNotNullParameter(r25, "request");
        Intrinsics.checkNotNullParameter(r26, "resolve");
        Intrinsics.checkNotNullParameter(r27, "reject");
        String r10 = null;
        k r11 = this.f6248b;
        if (r11 == null) goto L5;
        rd.e r12 = r11.f6238b;
    L6:
        if (r12 == null) goto L8;
        boolean r5 = u8.a.o(r12);
    L9:
        String r13 = this.f6247a;
        if (Intrinsics.areEqual(r13, "webcast") == false) goto L15;
        if (r5 == true) goto L15;
        r27.accept(new Throwable("anniex pia config error, bid webcast MUST use Forest to load"));
        return n.f6242c;
    L15:
        if (r5 == false) goto L31;
        String r16 = r25.getUrl().toString();
        Scene r18 = (Scene) com.bytedance.ies.bullet.forest.o.c(this, r16, false, null, r12, 14).getSecond();
        wc.g r14 = new wc.g("");
        wc.a r15 = new wc.a(false);
        List r17 = CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.f5993a, LoaderType.f5994b});
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r15.f22822b = r17;
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r14.f22837b = r15;
        if (r11 == null) goto L19;
        String r19 = r11.f6239c;
    L20:
        r14.f22849r = r19;
        r14.s = new l(r25);
        r14.f22846o = com.bytedance.ies.bullet.base.utils.b.e(null);
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r14.f22838c = r13;
        Intrinsics.checkNotNullParameter("web", "<set-?>");
        r14.f22840i = "web";
        zm.c r20 = com.bytedance.ies.bullet.forest.f.f5397a;
        if (r12 == null) goto L26;
        String r21 = u8.a.h(r12, "forest_download_engine");
        if (r21 != null) goto L25;
        r21 = "ttnet";
    L25:
        String r110 = r21;
        if (r11 == null) goto L29;
        r10 = r11.f6237a;
    L29:
        com.bytedance.ies.bullet.forest.f.e(r16, r110, r18, r10, r14, new PiaResourceLoader$loadAsync$3(), new PiaResourceLoader$loadAsync$4(r26, r27), 65);
        return n.d;
    L26:
        r21 = u8.a.b(r25.getUrl());
        goto L25
    L19:
        r19 = null;
        goto L20
    L31:
        com.bytedance.ies.bullet.kit.resourceloader.h r22 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r13);
        String r23 = r25.getUrl().toString();
        wc.g r24 = new wc.g("");
        wc.a r28 = new wc.a(true);
        List r29 = CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.f5993a, LoaderType.f5994b});
        Intrinsics.checkNotNullParameter(r29, "<set-?>");
        r28.f22822b = r29;
        Intrinsics.checkNotNullParameter(r28, "<set-?>");
        r24.f22837b = r28;
        Intrinsics.checkNotNullParameter("web", "<set-?>");
        r24.f22840i = "web";
        Unit r30 = Unit.INSTANCE;
        return new o(this, r22.a(r23, r24, new PiaResourceLoader$loadAsync$loadTask$2(r26), new PiaResourceLoader$loadAsync$loadTask$3(r27)));
    L8:
        r5 = u8.a.m(r25.getUrl());
        goto L9
    L5:
        r12 = null;
        goto L6
    }

    @Override // dh.d
    public final dh.f b(final LoadFrom r24, dh.e r25) {
        Intrinsics.checkNotNullParameter(r24, "loadFrom");
        Intrinsics.checkNotNullParameter(r25, "request");
        k r10 = this.f6248b;
        if (r10 == null) goto L5;
        rd.e r11 = r10.f6238b;
    L6:
        if (r11 == null) goto L8;
        boolean r5 = u8.a.o(r11);
    L9:
        String r12 = this.f6247a;
        if (Intrinsics.areEqual(r12, "webcast") == false) goto L14;
        if (r5 == true) goto L14;
        return null;
    L14:
        if (r5 == false) goto L41;
        String r16 = r25.getUrl().toString();
        Scene r18 = (Scene) com.bytedance.ies.bullet.forest.o.c(this, r16, r25.isForMainFrame(), null, r11, 12).getSecond();
        wc.g r13 = new wc.g("");
        wc.a r14 = new wc.a(false);
        List r15 = CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.f5993a, LoaderType.f5994b});
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r14.f22822b = r15;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.f22837b = r14;
        if (r10 == null) goto L18;
        String r17 = r10.f6239c;
    L19:
        r13.f22849r = r17;
        r13.s = new l(r25);
        r13.f22846o = com.bytedance.ies.bullet.base.utils.b.e(null);
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r13.f22838c = r12;
        Intrinsics.checkNotNullParameter("web", "<set-?>");
        r13.f22840i = "web";
        zm.c r19 = com.bytedance.ies.bullet.forest.f.f5397a;
        if (r11 == null) goto L25;
        String r20 = u8.a.h(r11, "forest_download_engine");
        if (r20 != null) goto L24;
        r20 = "ttnet";
    L24:
        String r110 = r20;
        if (r10 == null) goto L28;
        String r111 = r10.f6237a;
    L29:
        w r21 = com.bytedance.ies.bullet.forest.f.b(r16, r110, r18, r111, r13, new PiaResourceLoader$load$response$2(r24), 1);
        if (r21 == null) goto L37;
        int r22 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("forest-web", "forest resp: " + r21, null, 12);
        com.bytedance.forest.pollyfill.d r23 = r21.e;
        if (r23 == null) goto L34;
        String r26 = (String) r23.f4528c.put("x-ttwebview-response-update-time", String.valueOf(r21.f4449z));
    L34:
        WebResourceResponse r27 = r21.m();
        if (r27 == null) goto L37;
    L38:
        LinkedHashMap r28 = i.f6234a;
        Intrinsics.checkNotNullParameter(r27, "<this>");
        Intrinsics.checkNotNullParameter(r24, "loadFrom");
    L39:
        return null;
    L37:
        r27 = new WebResourceResponse("", "", null);
        goto L38
    L28:
        r111 = null;
        goto L29
    L25:
        r20 = u8.a.b(r25.getUrl());
        goto L24
    L18:
        r17 = null;
        goto L19
    L41:
        if (LoadFrom.f6956b == r24) goto L39;
        com.bytedance.ies.bullet.kit.resourceloader.h r29 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r12);
        String r30 = r25.getUrl().toString();
        wc.g r31 = new wc.g("");
        wc.a r32 = new wc.a(true);
        List r33 = CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.f5993a, LoaderType.f5994b});
        Intrinsics.checkNotNullParameter(r33, "<set-?>");
        r32.f22822b = r33;
        Intrinsics.checkNotNullParameter(r32, "<set-?>");
        r31.f22837b = r32;
        Intrinsics.checkNotNullParameter("web", "<set-?>");
        r31.f22840i = "web";
        Unit r34 = Unit.INSTANCE;
        a0 r35 = r29.c(r30, r31);
        if (r35 == null) goto L39;
        String r36 = r35.f5933b;
        if (r36 != null) goto L47;
    L48:
        r35 = null;
    L49:
        if (r35 == null) goto L39;
        WebResourceResponse r37 = r35.f5948v;
        if (r37 != null) goto L67;
        ResourceType r38 = r35.f5934c;
        if (r38 != null) goto L55;
        int r39 = -1;
    L56:
        String r40 = r35.f5933b;
        if (r39 != 1) goto L59;
        WebResourceResponse r41 = com.bytedance.ies.bullet.kit.resourceloader.i.h(r40);
    L68:
        if (r41 == null) goto L71;
        LinkedHashMap r42 = i.f6234a;
        Intrinsics.checkNotNullParameter(r41, "<this>");
        Intrinsics.checkNotNullParameter(r24, "loadFrom");
        return new h(r41, r24);
    L71:
        return null;
    L59:
        if (r39 == 2) goto L61;
        r41 = null;
        goto L68
    L61:
        char[] r43 = com.bytedance.ies.bullet.kit.resourceloader.i.f5457a;
        Application r44 = com.bytedance.ies.bullet.core.h.g.f5316b;
        if (r44 == null) goto L64;
        AssetManager r45 = r44.getAssets();
    L65:
        r41 = com.bytedance.ies.bullet.kit.resourceloader.i.a(r45, r40);
        goto L68
    L64:
        r45 = null;
        goto L65
    L55:
        r39 = m.f6241a[r38.ordinal()];
        goto L56
    L67:
        r41 = r37;
        goto L68
    L47:
        if (r36.length() != 0) goto L49;
    L8:
        r5 = u8.a.m(r25.getUrl());
        goto L9
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String forestDownloadEngine(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.c(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.p
    public final Pair h(String r5, boolean r10, com.bytedance.ies.bullet.core.e r11, rd.e r12) {
        return com.bytedance.ies.bullet.forest.o.b(this, r5, r10, r11, r12);
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

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean hasGeckoModelInfo(rd.e r5) {
        return u8.a.j(r5);
    }
}
