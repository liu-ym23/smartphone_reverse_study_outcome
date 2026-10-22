package com.ivy.ivykit.plugin.impl.applet;

import ai.j0;
import android.app.Application;
import android.content.res.AssetManager;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.core.app.NotificationCompat;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.w;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.ies.bullet.core.l;
import com.bytedance.ies.bullet.forest.o;
import com.bytedance.ies.bullet.kit.web.impl.i;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ol.f;
import wc.g;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends i {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List f9510q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f9511r;
    public final String s;

    public d(com.bytedance.ies.bullet.service.webkit.c r5, List r10) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_SERVICE);
        super(r5);
        this.f9510q = r10;
        this.f9511r = r5.f22117a;
        this.s = "AIPackageWebView";
    }

    public static WebResourceResponse i(InputStream r10, String r11) {
        if (r10 == null) goto L16;
        HashMap r5 = new HashMap();     // Catch: Exception -> L8
        r5.put("Access-Control-Allow-Origin", XPath.WILDCARD);     // Catch: Exception -> L8
        if (Intrinsics.areEqual("font/ttf", r11) == true) goto L7;
        WebResourceResponse r12 = new WebResourceResponse(r11, "", r10);     // Catch: Exception -> L8
        r12.setResponseHeaders(r5);     // Catch: Exception -> L8
        return r12;
    L7:
        return new WebResourceResponse(r11, "", 200, "OK", r5, r10);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L16:
        return null;
    }

    @Override // com.bytedance.ies.bullet.kit.web.impl.i
    public final WebResourceResponse a(WebResourceRequest r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        return j(r5.getUrl().toString());
    }

    @Override // com.bytedance.ies.bullet.kit.web.impl.i
    public final WebResourceResponse b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        return j(r5);
    }

    public final WebResourceResponse j(String r19) {
        ConcurrentHashMap r5 = tl.b.f22138a;
        String r10 = j0.C("AIWebKitDelegate loadResource: ", r19);
        String r14 = this.s;
        tl.b.c(r14, r10);
        List r11 = this.f9510q;
        if (r11 != null) goto L5;
    L17:
        d().f5293c.B();
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L23
        Uri r13 = Uri.parse(r19);     // Catch: Throwable -> L23
        String r15 = r13.getHost();     // Catch: Throwable -> L23
        if (r15 != null) goto L21;
    L25:
        if (r15 != null) goto L27;
    L29:
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L32:
        Boolean r16 = Boolean.FALSE;
        Pair r17 = new Pair(r16, r16);
    L33:
        boolean r18 = ((Boolean) r17.getFirst()).booleanValue();
        boolean r20 = ((Boolean) r17.getSecond()).booleanValue();
        String r110 = this.f9511r;
        if (r18 == true) goto L36;
    L93:
        Pair r21 = o.c(this, r19, false, d(), null, 22);
        boolean r22 = ((Boolean) r21.component1()).booleanValue();
        Scene r23 = (Scene) r21.component2();
        if (r22 == true) goto L97;
        ConcurrentHashMap r24 = tl.b.f22138a;
        tl.b.c(r14, r19.concat(" can NOT be intercepted by forest. skip it"));
        Class r25 = f.class;
        WebResourceResponse r26 = null;
        WebResourceResponse r111 = null;
    L144:
        if (r111 != null) goto L146;
        r111 = super.b(r19);
    L146:
        if (r111 == null) goto L159;
        f r27 = (f) f().a(r25);
        if (r27 == null) goto L150;
        WebResourceResponse r28 = r27.a(r19, r111);
    L151:
        if (r28 != null) goto L154;
        return r111;
    L154:
        return r28;
    L150:
        r28 = r26;
        goto L151
    L159:
        return r111;
    L97:
        if (u8.a.q(d()) == false) goto L100;
        if (r22 == false) goto L100;
        boolean r29 = true;
    L101:
        d().f5293c.B();
        g r30 = new g("");
        wc.a r31 = cl.a.i(d().f5309x.f5346a);
        if (r31 != null) goto L104;
        r31 = new wc.a(false);
    L104:
        List r32 = CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.f5993a, LoaderType.f5994b, LoaderType.f5995c});
        Intrinsics.checkNotNullParameter(r32, "<set-?>");
        r31.f22822b = r32;
        Intrinsics.checkNotNullParameter(r31, "<set-?>");
        r30.f22837b = r31;
        rc.e r33 = d().f5304r;
        if (r33 == null) goto L107;
        ConcurrentHashMap r34 = ((rc.a) r33).a();
    L108:
        r30.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r34);
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r30.f22838c = r110;
        Intrinsics.checkNotNullParameter("web", "<set-?>");
        r30.f22840i = "web";
        if (r29 == false) goto L115;
        zm.c r35 = com.bytedance.ies.bullet.forest.f.f5397a;
        r25 = f.class;
        r26 = null;
        w r36 = com.bytedance.ies.bullet.forest.f.b(r19, u8.a.c(d()), r23, d().getSessionId(), r30, null, 65);
        if (r36 == null) goto L113;
        l r37 = d().f5309x;
        String r38 = r36.c(r36.f4444u);
        r37.getClass();
        Intrinsics.checkNotNullParameter(r38, "<set-?>");
        r37.f5347b = r38;
        ConcurrentHashMap r39 = tl.b.f22138a;
        tl.b.c(r14, "forest resp: " + r36);
        r111 = r36.m();
    L114:
        d().f5293c.C();
        goto L144
    L113:
        r111 = null;
        goto L114
    L115:
        r25 = f.class;
        r26 = null;
        a0 r40 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r110).c(r19, r30);
        if (r40 == null) goto L143;
        String r41 = r40.f5933b;
        if (r41 != null) goto L120;
    L121:
        r40 = null;
    L122:
        if (r40 == null) goto L143;
        d().f5293c.C();
        WebResourceResponse r42 = r40.f5948v;
        if (r42 != null) goto L140;
        ResourceType r43 = r40.f5934c;
        if (r43 != null) goto L128;
        int r44 = -1;
    L129:
        String r45 = r40.f5933b;
        if (r44 != 1) goto L132;
        r111 = com.bytedance.ies.bullet.kit.resourceloader.i.h(r45);
    L141:
        if (r111 == null) goto L144;
        l r46 = d().f5309x;
        String r47 = r40.a();
        r46.getClass();
        Intrinsics.checkNotNullParameter(r47, "<set-?>");
        r46.f5347b = r47;
        goto L144
    L132:
        if (r44 == 2) goto L134;
        r111 = null;
        goto L141
    L134:
        char[] r48 = com.bytedance.ies.bullet.kit.resourceloader.i.f5457a;
        Application r49 = h.g.f5316b;
        if (r49 == null) goto L137;
        AssetManager r112 = r49.getAssets();
    L138:
        r111 = com.bytedance.ies.bullet.kit.resourceloader.i.a(r112, r45);
        goto L141
    L137:
        r112 = null;
        goto L138
    L128:
        r44 = c.f9509a[r43.ordinal()];
        goto L129
    L140:
        r111 = r42;
        goto L141
    L120:
        if (r41.length() != 0) goto L122;
    L143:
        r111 = null;
        goto L144
    L107:
        r34 = null;
    L100:
        r29 = false;
        goto L101
    L36:
        if (StringsKt.g(r19.toLowerCase(), "/favicon.ico") == true) goto L38;
        com.bytedance.ies.bullet.kit.resourceloader.h r50 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r110);
        g r51 = new g("");
        wc.a r52 = new wc.a(true);
        r52.f22823c = CollectionsKt.mutableListOf(new Class[]{a.class});
        if (r20 == false) goto L42;
        r52.f22822b.add(LoaderType.f5995c);
    L42:
        Intrinsics.checkNotNullParameter(r52, "<set-?>");
        r51.f22837b = r52;
        rc.e r53 = d().f5304r;
        if (r53 == null) goto L45;
        ConcurrentHashMap r54 = ((rc.a) r53).a();
    L46:
        r51.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r54);
        Intrinsics.checkNotNullParameter("web", "<set-?>");
        r51.f22840i = "web";
        Unit r55 = Unit.INSTANCE;
        a0 r56 = r50.c(r19, r51);
        if (r56 == null) goto L93;
        String r57 = r56.f5933b;
        if (r57 != null) goto L51;
    L52:
        r56 = null;
    L53:
        if (r56 == null) goto L93;
        d().f5293c.C();
        WebResourceResponse r58 = r56.f5948v;
        if (r58 != null) goto L90;
        ResourceType r59 = r56.f5934c;
        if (r59 != null) goto L59;
        int r60 = -1;
    L60:
        String r61 = r56.f5933b;
        if (r60 == 1) goto L69;
        if (r60 == 2) goto L64;
        r58 = null;
        goto L90
    L64:
        char[] r62 = com.bytedance.ies.bullet.kit.resourceloader.i.f5457a;
        Application r63 = h.g.f5316b;
        if (r63 == null) goto L67;
        AssetManager r64 = r63.getAssets();
    L68:
        r58 = com.bytedance.ies.bullet.kit.resourceloader.i.a(r64, r61);
        goto L90
    L67:
        r64 = null;
        goto L68
    L69:
        InputStream r65 = r56.f5935h;
        if (r65 == null) goto L85;
        f r66 = (f) f().a(f.class);
        if (r66 == null) goto L81;
        char[] r113 = com.bytedance.ies.bullet.kit.resourceloader.i.f5457a;
        if (r61 != null) goto L76;
        String r114 = "";
    L77:
        WebResourceResponse r67 = r66.a(r19, i(r65, com.bytedance.ies.bullet.kit.resourceloader.i.f(r114)));
        if (r67 == null) goto L81;
        r58 = r67;
        goto L90
    L76:
        r114 = r61;
    L81:
        char[] r68 = com.bytedance.ies.bullet.kit.resourceloader.i.f5457a;
        if (r61 != null) goto L84;
        r61 = "";
    L84:
        r58 = i(r65, com.bytedance.ies.bullet.kit.resourceloader.i.f(r61));
        goto L90
    L85:
        f r69 = (f) f().a(f.class);
        if (r69 == null) goto L89;
        r58 = r69.a(r19, com.bytedance.ies.bullet.kit.resourceloader.i.h(r61));
        if (r58 != null) goto L90;
    L89:
        r58 = com.bytedance.ies.bullet.kit.resourceloader.i.h(r61);
        goto L90
    L59:
        r60 = c.f9509a[r59.ordinal()];
    L90:
        if (r58 == null) goto L93;
        l r70 = d().f5309x;
        String r71 = r56.a();
        r70.getClass();
        Intrinsics.checkNotNullParameter(r71, "<set-?>");
        r70.f5347b = r71;
        return r58;
    L51:
        if (r57.length() != 0) goto L53;
    L45:
        r54 = null;
        goto L46
    L38:
        return new WebResourceResponse("image/png", null, null);
    L27:
        if (r13.getBooleanQueryParameter("dev_mode", false) == false) goto L29;
        Boolean r72 = Boolean.TRUE;     // Catch: Throwable -> L23
        r17 = new Pair(r72, r72);     // Catch: Throwable -> L23
        goto L33
    L21:
        if (Intrinsics.areEqual(r15, IIvyAIPackageResourceService.HOST) == false) goto L25;
        r17 = new Pair(Boolean.TRUE, Boolean.FALSE);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r73 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L32
    L5:
        if (r11.isEmpty() == true) goto L17;
        Iterator r74 = r11.iterator();
    L9:
        if (r74.hasNext() == false) goto L13;
        Object r75 = r74.next();
        if (Intrinsics.areEqual((String) r75, r19) == false) goto L9;
    L14:
        if (r75 == null) goto L17;
        ConcurrentHashMap r76 = tl.b.f22138a;
        tl.b.c(r14, r19 + " is in the white list. skip it");
        return null;
    L13:
        r75 = null;
        goto L14
    }
}
