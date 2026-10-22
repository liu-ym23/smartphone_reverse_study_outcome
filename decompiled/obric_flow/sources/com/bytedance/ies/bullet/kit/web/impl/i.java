package com.bytedance.ies.bullet.kit.web.impl;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.w;
import com.bytedance.ies.bullet.core.l;
import com.bytedance.ies.bullet.forest.o;
import com.bytedance.ies.bullet.forest.p;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.kit.web.m;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.web.WebChromeClientDispatcher;
import com.bytedance.ies.bullet.web.pia.j;
import com.bytedance.ies.bullet.web.pia.s;
import com.bytedance.ies.web.jsbridge2.t;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthPriority;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jg.k;
import ko.r;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import li.n;

/* JADX INFO: loaded from: classes2.dex */
public class i implements p {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile boolean f5521p = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ies.bullet.service.webkit.c f5522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ies.bullet.core.e f5524c;
    public rb.b d;
    public final com.bytedance.ies.bullet.service.webkit.d e;
    public final ArrayList f;
    public j g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.ies.bullet.kit.web.jsbridge.d f5525h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5526i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.sdk.xbridge.cn.platform.web.b f5527j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f5528k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinkedHashMap f5529l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f5530m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final k f5531n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.ies.bullet.service.base.c f5532o;

    public i(com.bytedance.ies.bullet.service.webkit.c r5) {
        Intrinsics.checkNotNullParameter(r5, "kitService");
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_SERVICE);
        this.f5522a = r5;
        com.bytedance.ies.bullet.service.base.c r10 = new com.bytedance.ies.bullet.service.base.c(2);
        Intrinsics.checkNotNullParameter(r10, "config");
        this.e = new com.bytedance.ies.bullet.service.webkit.d(r5, r10);
        this.f = new ArrayList();
        this.f5531n = new k(this, 4);
        this.f5532o = new com.bytedance.ies.bullet.service.base.c(6);
    }

    public WebResourceResponse a(WebResourceRequest r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        Uri r5 = r10.getUrl();
        if (r5 == null) goto L16;
        boolean r11 = true;
        if (r5.isHierarchical() != true) goto L16;
        Pair r12 = o.a(this, r10, d());
        boolean r13 = ((Boolean) r12.component1()).booleanValue();
        Scene r14 = (Scene) r12.component2();
        if (u8.a.q(d()) == false) goto L10;
        if (r13 == false) goto L10;
    L11:
        WebResourceResponse r15 = c(r10.getUrl().toString(), r14, r11, r10);
        if (r15 != null) goto L15;
        Intrinsics.checkNotNullParameter(r10, "request");
        return null;
    L15:
        return r15;
    L10:
        r11 = false;
    L16:
        Intrinsics.checkNotNullParameter(r10, "request");
        return null;
    }

    public WebResourceResponse b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "url");
        if (Uri.parse(r10).isHierarchical() == true) goto L6;
        Intrinsics.checkNotNullParameter(r10, "url");
        return null;
    L6:
        Pair r5 = o.c(this, r10, false, d(), null, 22);
        ((Boolean) r5.component1()).getClass();
        Scene r11 = (Scene) r5.component2();
        u8.a.q(d());
        WebResourceResponse r12 = c(r10, r11, false, null);
        if (r12 != null) goto L10;
        Intrinsics.checkNotNullParameter(r10, "url");
        return null;
    L10:
        return r12;
    }

    public final WebResourceResponse c(String r23, Scene r24, boolean r25, WebResourceRequest r26) {
        WebResourceResponse r10 = null;
        r10 = null;
        AssetManager r11 = null;
        if (Intrinsics.areEqual(d().f, "webcast") == false) goto L7;
        if (r25 == true) goto L7;
        Intrinsics.checkNotNullParameter(r23, "url");
        return null;
    L7:
        Scene r12 = Scene.f4351k;
        if (r24 != r12) goto L10;
        d().f5293c.B();
    L10:
        wc.g r5 = new wc.g("");
        r5.s = r26;
        r5.f22849r = this.f5530m;
        wc.a r13 = cl.a.i(d().f5309x.f5346a);
        boolean r14 = false;
        if (r13 != null) goto L13;
        r13 = new wc.a(false);
    L13:
        List r15 = CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.f5993a, LoaderType.f5994b});
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r13.f22822b = r15;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r5.f22837b = r13;
        rc.e r16 = d().f5304r;
        if (r16 == null) goto L16;
        ConcurrentHashMap r17 = ((rc.a) r16).a();
    L17:
        r5.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r17);
        com.bytedance.ies.bullet.service.webkit.c r18 = this.f5522a;
        String r19 = r18.f22117a;
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r5.f22838c = r19;
        Intrinsics.checkNotNullParameter("web", "<set-?>");
        r5.f22840i = "web";
        ConcurrentHashMap r20 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r21 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r21 == null) goto L22;
        xc.f r22 = (xc.f) r21.a(xc.f.class);
        if (r22 == null) goto L22;
        boolean r27 = r22.g();
    L23:
        if (r27 == false) goto L27;
        WebView r28 = (WebView) f().a(WebView.class);
        if (r28 == null) goto L27;
        r5.f22853w = String.valueOf(r28.hashCode());
        r5.f22854x = this.f5528k;
    L27:
        if (r25 == false) goto L43;
        zm.c r29 = com.bytedance.ies.bullet.forest.f.f5397a;
        String r30 = u8.a.c(d());
        if (xq.b.q() == true) goto L31;
    L39:
        String r31 = d().getSessionId();
    L40:
        w r32 = com.bytedance.ies.bullet.forest.f.b(r23, r30, r24, r31, r5, null, 65);
        if (r32 == null) goto L102;
        int r33 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.c("forest-web", "forest resp: " + r32);
        String r34 = r32.c(r32.f4444u);
        r10 = r32.m();
        String r35 = r34;
    L104:
        if (r24 != r12) goto L109;
        if (r10 == null) goto L109;
        if (r35 == null) goto L108;
        l r36 = d().f5309x;
        r36.getClass();
        Intrinsics.checkNotNullParameter(r35, "<set-?>");
        r36.f5347b = r35;
    L108:
        d().f5293c.C();
    L109:
        return r10;
    L102:
        r35 = null;
        goto L104
    L31:
        if (Intrinsics.areEqual(d().f, "webcast") == false) goto L39;
        ub.a r37 = (ub.a) f().a(ub.a.class);
        if (r37 == null) goto L38;
        r31 = r37.f22319a;
        if (r31 != null) goto L40;
    L38:
        r31 = d().getSessionId();
        goto L40
    L43:
        com.bytedance.ies.bullet.kit.web.download.b r38 = (com.bytedance.ies.bullet.kit.web.download.b) com.bytedance.ies.bullet.kit.web.download.b.d.getValue();
        r38.getClass();
        Intrinsics.checkNotNullParameter(r23, "url");
        File r39 = r38.f5498b;
        if (r39 == null) goto L72;
        String r110 = com.bytedance.ies.bullet.kit.web.download.b.a(r23);
        if (r110 == null) goto L72;
        DownloadInfo r40 = Downloader.b(r38.f5497a).a(r23, r39.getPath());
        File r111 = new File(r39, r110);
        if (r111.exists() == false) goto L72;
        if (r111.isDirectory() == true) goto L72;
        if (r40 != null) goto L53;
    L57:
        boolean r41 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "WebResourceDownloader: get cache of url=" + r23 + " from destination=" + r111, "XPreload");
        char[] r42 = com.bytedance.ies.bullet.kit.resourceloader.i.f5457a;
        String r43 = com.bytedance.ies.bullet.kit.resourceloader.i.f(r111.getPath());
        if (TextUtils.isEmpty(r43) == false) goto L63;
        if (r40 == null) goto L63;
        String r44 = r40.f15839u;
        if (r44 == null) goto L63;
        String r112 = r44;
    L64:
        FileInputStream r45 = new FileInputStream(r111);
        HashMap r46 = new HashMap();     // Catch: Exception -> L71
        r46.put("Access-Control-Allow-Origin", XPath.WILDCARD);     // Catch: Exception -> L71
        if (Intrinsics.areEqual("font/ttf", r112) == false) goto L69;
        WebResourceResponse r113 = new WebResourceResponse(r112, "", 200, "OK", r46, r45);     // Catch: Exception -> L71
    L110:
    L73:
        if (r113 != null) goto L103;
        ConcurrentHashMap r47 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
        a0 r48 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r18.f22117a).c(r23, r5);
        if (r48 == null) goto L102;
        String r49 = r48.f5933b;
        if (r49 != null) goto L79;
    L80:
        r14 = true;
    L81:
        if (r14 == false) goto L84;
        r48 = null;
    L84:
        if (r48 == null) goto L102;
        WebResourceResponse r50 = r48.f5948v;
        if (r50 != null) goto L100;
        ResourceType r51 = r48.f5934c;
        if (r51 != null) goto L90;
        int r52 = -1;
    L91:
        String r53 = r48.f5933b;
        if (r52 == 1) goto L99;
        if (r52 != 2) goto L101;
        char[] r54 = com.bytedance.ies.bullet.kit.resourceloader.i.f5457a;
        Application r55 = com.bytedance.ies.bullet.core.h.g.f5316b;
        if (r55 == null) goto L98;
        r11 = r55.getAssets();
    L98:
        r10 = com.bytedance.ies.bullet.kit.resourceloader.i.a(r11, r53);
    L101:
        r35 = r48.a();
        goto L104
    L99:
        r10 = com.bytedance.ies.bullet.kit.resourceloader.i.h(r53);
        goto L101
    L90:
        r52 = a.f5505a[r51.ordinal()];
        goto L91
    L100:
        r10 = r50;
        goto L101
    L79:
        if (r49.length() != 0) goto L81;
    L103:
        r35 = null;
        r10 = r113;
        goto L104
    L69:
        r113 = new WebResourceResponse(r112, "", r45);     // Catch: Exception -> L71
        r113.setResponseHeaders(r46);     // Catch: Exception -> L71
    L71:
        com.bytedance.ies.bullet.service.base.b.a(2, "WebResourceDownloader: translate input to response failed", "XPreload");
    L63:
        r112 = r43;
        goto L64
    L53:
        if (r40.g() <= 0) goto L57;
        if (System.currentTimeMillis() <= r40.g()) goto L57;
    L72:
        r113 = null;
    L22:
        r27 = false;
        goto L23
    L16:
        r17 = null;
        goto L17
    }

    public final com.bytedance.ies.bullet.core.e d() {
        com.bytedance.ies.bullet.core.e r5 = this.f5524c;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("bulletContext");
        return null;
    }

    public final void e(View r25, m r26) {
        int r5 = 6;
        Intrinsics.checkNotNullParameter(r25, "view");
        Intrinsics.checkNotNullParameter(r26, "kitView");
        if ((r25 instanceof SSWebView) == true) goto L5;
        return;
    L5:
        WebView r10 = (WebView) r25;
        String r12 = "<set-?>";
        String r13 = "default_bid";
        if (((com.bytedance.ies.bullet.kit.web.j) d().f5307v.f1119c) == null) goto L47;
        com.bytedance.ies.bullet.kit.web.j r11 = (com.bytedance.ies.bullet.kit.web.j) d().f5307v.f1119c;
        if (r11 != null) goto L11;
        r11 = null;
    L11:
        if (r11 == null) goto L47;
        if (r11.e == null) goto L15;
        com.ivy.ivykit.plugin.impl.web.i.d(r10.getSettings(), r10, f());
    L15:
        Iterator r14 = CollectionsKt.reversed(r11.f).iterator();
    L17:
        if (r14.hasNext() == false) goto L19;
        com.ivy.ivykit.plugin.impl.web.i r15 = (com.ivy.ivykit.plugin.impl.web.i) r14.next();
        WebSettings r16 = r10.getSettings();
        rb.b r17 = f();
        r15.getClass();
        com.ivy.ivykit.plugin.impl.web.i.d(r16, r10, r17);
        goto L17
    L19:
        LinkedHashMap r18 = com.bytedance.ies.bullet.web.pia.i.f6234a;
        com.bytedance.ies.bullet.core.e r19 = r11.d;
        if (r19 == null) goto L23;
        String r20 = r19.f;
        if (r20 == null) goto L23;
    L24:
        String r21 = r10.getSettings().getUserAgentString();
        Intrinsics.checkNotNullParameter(r20, "bid");
        Intrinsics.checkNotNullParameter(r21, "userAgent");
        com.bytedance.ies.bullet.web.pia.d r22 = (com.bytedance.ies.bullet.web.pia.d) com.bytedance.ies.bullet.web.pia.i.f6234a.get(r20);
        if (r22 == null) goto L27;
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        r22.f6223a = r21;
    L27:
        WebSettings r23 = r10.getSettings();
        ((com.bytedance.android.anniex.base.depend.b) com.bytedance.android.anniex.base.depend.a.f3113b.getValue()).getClass();
        r23.setUserAgentString(r23.getUserAgentString() + " IsPreInstallApp/0");
        com.lynx.animax.player.b r24 = r11.f5536k;
        if (r24 == null) goto L47;
        qb.a r27 = (qb.a) r24.f9657b;
        if (r27.f21500a == true) goto L33;
        r27 = null;
    L33:
        if (r27 == null) goto L39;
        Boolean r28 = r27.f21501b;
        if (r28 == null) goto L39;
        if (r28.booleanValue() == true) goto L39;
        r10.setLayerType(1, null);
    L39:
        qb.a r29 = (qb.a) r24.f9658c;
        if (r29.f21500a == true) goto L43;
        r29 = null;
    L43:
        if (r29 == null) goto L47;
        Boolean r30 = r29.f21501b;
        if (r30 == null) goto L47;
        r10.setLongClickable(r30.booleanValue());
    L23:
        r20 = "default_bid";
    L47:
        g();
        r10.setFocusable(true);
        r10.setFocusableInTouchMode(true);
        SSWebView r31 = (SSWebView) r25;
        g();
        boolean r32 = d().f5307v.f1118b;
        if (r32 == true) goto L50;
        r31.setSecureLinkScene(null);
    L50:
        Intrinsics.checkNotNullParameter(new com.lynx.tasm.behavior.d(r5), "providerFactory");
        if (d() != null) goto L54;
        Lazy r33 = com.bytedance.ies.bullet.secure.f.f5904c;
        wn.h.e().getClass();
    L54:
        if (Intrinsics.areEqual(Boolean.valueOf(r32), Boolean.TRUE) == true) goto L64;
        com.bytedance.ies.bullet.kit.web.j r34 = (com.bytedance.ies.bullet.kit.web.j) d().f5307v.f1119c;
        if (r34 != null) goto L60;
        r34 = null;
    L60:
        if (r34 == null) goto L64;
        if (r34.e == null) goto L64;
        Intrinsics.checkNotNullParameter(f(), "providerFactory");
    L64:
        r31.setArgusAdapter$anniex_release(null);
        r26.getClass();
        if (d().f5307v.f1118b == false) goto L90;
        LinkedHashMap r35 = com.bytedance.ies.bullet.web.pia.i.f6234a;
        String r36 = d().f;
        if (r36 != null) goto L69;
        r36 = "default_bid";
    L69:
        Intrinsics.checkNotNullParameter(r36, "bid");
        if (((oh.f) ai.p.g(oh.f.class)) == null) goto L76;
        String r37 = "bullet-".concat(r36);
        com.bytedance.ies.bullet.web.pia.c r110 = new com.bytedance.ies.bullet.web.pia.c(null);
        if (r37 != null) goto L74;
        nh.b r38 = null;
    L75:
        j r111 = new j(r38);
    L77:
        if (r111 == null) goto L88;
        com.bytedance.ies.bullet.core.e r39 = d();
        Intrinsics.checkNotNullParameter(r31, "webView");
        Intrinsics.checkNotNullParameter(r39, "bulletContext");
        s r40 = r111.f6236b;
        r40.getClass();
        Intrinsics.checkNotNullParameter(r39, "bulletContext");
        r40.f6249a = r39;
        nh.b r41 = r111.f6235a;
        s r42 = r111.f6236b;
        r41.g = r42;
        nh.d r43 = (nh.d) r41.f;
        if (r43 == null) goto L81;
        r43.g("event-on-bind-bridge-handle", new Object[]{r42});
    L81:
        nh.b r44 = r111.f6235a;
        r44.getClass();
        r44.e = new WeakReference(r31);
        String r45 = r31.getSettings().getUserAgentString();
        if (r45.contains("PIA/2.0.0") == true) goto L84;
        r31.getSettings().setUserAgentString(r45.concat(" PIA/2.0.0"));
    L84:
        nh.d r46 = (nh.d) r44.f;
        if (r46 == null) goto L87;
        r46.d(r31);
    L87:
        r31.setPiaLifeCycle$anniex_release(r111);
    L89:
        this.g = r111;
        goto L90
    L88:
        r111 = null;
        goto L89
    L74:
        r38 = new nh.b();
        r38.d = new nh.a();
        r38.e = null;
        r38.f20235c = false;
        r38.f = null;
        r38.g = null;
        r38.f20233a = r37;
        r38.f20234b = r110;
        goto L75
    L76:
        r111 = null;
    L90:
        d().f5293c.u();
        if (this.f5526i == false) goto L239;
        com.bytedance.ies.bullet.kit.web.j r47 = (com.bytedance.ies.bullet.kit.web.j) d().f5307v.f1119c;
        if (r47 == null) goto L96;
        td.c.c(r47, KitType.f6012c);
    L96:
        if (d().f5294h == null) goto L98;
        Context r48 = d().f5294h;
        Intrinsics.checkNotNull(r48);
        String r49 = d().getSessionId();
        if (Intrinsics.areEqual(d().f, "webcast") == false) goto L102;
        String r112 = "webcast";
    L103:
        this.f5527j = new com.bytedance.sdk.xbridge.cn.platform.web.b(r48, r49, r31, r112);
        com.bytedance.ies.bullet.service.webkit.c r50 = this.f5522a;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.base.l.class, "clazz");
        tc.c r51 = tc.c.f22119c;
        if (tc.c.f22119c.a(com.bytedance.ies.bullet.service.base.l.class, r50.f22117a) != null) goto L238;
        com.bytedance.ies.bullet.settings.b r52 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r52 == null) goto L108;
        com.bytedance.ies.bullet.service.base.d r53 = (com.bytedance.ies.bullet.service.base.d) r52.f6163b.getValue();
    L108:
        boolean r54 = tc.c.f22119c.a(pb.a.class, "default_bid") instanceof com.ivy.ivykit.plugin.impl.jsb.c;
        com.bytedance.sdk.xbridge.cn.platform.web.b r55 = this.f5527j;
        if (r55 != null) goto L111;
    L122:
        com.bytedance.ies.bullet.settings.b r56 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r56 == null) goto L130;
        com.bytedance.ies.bullet.service.base.d r57 = (com.bytedance.ies.bullet.service.base.d) r56.f6163b.getValue();
        if (r57 == null) goto L130;
        com.bytedance.sdk.xbridge.cn.platform.web.b r58 = this.f5527j;
        if (r58 == null) goto L130;
        ArrayList r59 = r57.f5966h;
        r58.f7417r = Boolean.FALSE;
        r58.f7416q = r59;
    L130:
        if (xq.b.e() == true) goto L132;
    L136:
        com.bytedance.sdk.xbridge.cn.platform.web.b r60 = this.f5527j;
        if (r60 == null) goto L139;
        LinkedHashMap r61 = new LinkedHashMap();
        Lazy r62 = com.bytedance.sdk.xbridge.cn.optimize.b.f7355a;
        r61.put("can_run_in_background_fix", Boolean.valueOf(xq.b.g()));
        r61.put("xbridge_model_proxy_enhancement", Boolean.valueOf(xq.b.s()));
        Intrinsics.checkNotNullParameter(r61, "settings");
        r60.e.putAll(r61);
    L139:
        pb.a r63 = (pb.a) tc.c.f22119c.a(pb.a.class, "default_bid");
        if (r63 == null) goto L163;
        Iterator r64 = r63.c(f()).iterator();
    L143:
        if (r64.hasNext() == false) goto L148;
        com.bytedance.sdk.xbridge.cn.protocol.h r65 = (com.bytedance.sdk.xbridge.cn.protocol.h) r64.next();
        com.bytedance.sdk.xbridge.cn.platform.web.b r66 = this.f5527j;
        if (r66 == null) goto L143;
        r66.g(r65);
        goto L143
    L148:
        if ((r63 instanceof com.ivy.ivykit.plugin.impl.jsb.c) == false) goto L163;
        com.ivy.ivykit.plugin.impl.jsb.c r67 = (com.ivy.ivykit.plugin.impl.jsb.c) r63;
        Intrinsics.checkNotNullParameter(f(), "providerFactory");
        rd.b r68 = d().e;
        if (r68 == null) goto L152;
        Uri r69 = ((com.bytedance.ies.bullet.service.sdk.b) r68).f6135c;
    L153:
        if (r69 == null) goto L155;
        String r70 = r69.getQueryParameter("enable_annie_jsb_for_common");
    L157:
        if (Intrinsics.areEqual(r70, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L163;
        WebView r71 = this.e.f6158b;
        if (r71 == null) goto L162;
        new defpackage.c().c(d(), r71, this.f5527j, f(), this.f5531n);
        goto L163
    L162:
        throw new IllegalStateException("You must call 'createWebView' or 'setWebView' first.");
    L155:
        r70 = null;
        goto L157
    L152:
        r69 = null;
    L163:
        tc.c r72 = tc.c.f22119c;
        tc.c r73 = tc.c.f22119c;
        String r74 = d().f;
        if (r74 != null) goto L166;
        r74 = "default_bid";
    L166:
        pb.a r75 = (pb.a) r73.a(pb.a.class, r74);
        if ((r75 instanceof com.ivy.ivykit.plugin.impl.jsb.c) == false) goto L169;
        com.ivy.ivykit.plugin.impl.jsb.c r76 = (com.ivy.ivykit.plugin.impl.jsb.c) r75;
    L170:
        if (r76 == null) goto L172;
        Intrinsics.checkNotNullParameter(f(), "providerFactory");
    L172:
        tc.c r77 = tc.c.f22119c;
        String r78 = d().f;
        if (r78 == null) goto L176;
        r13 = r78;
    L176:
        pb.a r79 = (pb.a) r77.a(pb.a.class, r13);
        if ((r79 instanceof com.ivy.ivykit.plugin.impl.jsb.c) == false) goto L179;
        com.ivy.ivykit.plugin.impl.jsb.c r80 = (com.ivy.ivykit.plugin.impl.jsb.c) r79;
    L180:
        if (r80 == null) goto L187;
        Iterator r81 = r80.d(f()).iterator();
    L183:
        if (r81.hasNext() == false) goto L187;
        IDLXBridgeMethod r82 = (IDLXBridgeMethod) r81.next();
        com.bytedance.sdk.xbridge.cn.platform.web.b r83 = this.f5527j;
        if (r83 == null) goto L183;
        r83.h(r82);
    L187:
        com.bytedance.sdk.xbridge.cn.platform.web.b r84 = this.f5527j;
        if (r84 == null) goto L190;
        r84.i(rb.b.class, f());
    L190:
        com.bytedance.ies.bullet.core.e r85 = d();
        com.bytedance.sdk.xbridge.cn.platform.web.b r86 = this.f5527j;
        if (r86 == null) goto L193;
        r86.i(com.bytedance.ies.bullet.core.e.class, r85);
    L193:
        com.bytedance.sdk.xbridge.cn.platform.web.b r87 = this.f5527j;
        if (r87 == null) goto L196;
        r87.i(kj.b.class, this.f5532o);
    L196:
        n r88 = pi.a.f21355b;
        if (r88 != null) goto L200;
        r88 = pi.a.f21354a;
    L200:
        if (r88.f19675a == true) goto L204;
        com.bytedance.ies.bullet.kit.web.j r89 = null;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XBridgeAuth", "add legacy jsb2 auth", null, 12);
        com.bytedance.sdk.xbridge.cn.platform.web.b r90 = this.f5527j;
        if (r90 == null) goto L205;
        r90.d(new c(this), AuthPriority.f7442a);
    L205:
        com.bytedance.sdk.xbridge.cn.platform.web.b r91 = this.f5527j;
        if (r91 == null) goto L208;
        d().f5302p = new e(this, r91);
        com.bytedance.sdk.xbridge.cn.auth.j r92 = r91.f7411l;
        g8.g r93 = new g8.g(this, 4);
        r92.getClass();
        Intrinsics.checkNotNullParameter(r93, "report");
        com.bytedance.sdk.xbridge.cn.auth.i r94 = r92.f7350a;
        r94.getClass();
        Intrinsics.checkNotNullParameter(r93, "report");
        r94.e = r93;
        com.bytedance.sdk.xbridge.cn.auth.g r95 = new com.bytedance.sdk.xbridge.cn.auth.g(6);
        Intrinsics.checkNotNullParameter(r95, "log");
        com.bytedance.sdk.xbridge.cn.auth.i r96 = r92.f7350a;
        r96.getClass();
        Intrinsics.checkNotNullParameter(r95, "log");
        r96.f7347a = r95;
    L208:
        com.bytedance.ies.bullet.kit.web.j r97 = (com.bytedance.ies.bullet.kit.web.j) d().f5307v.f1119c;
        if (r97 != null) goto L212;
        r97 = r89;
    L212:
        if (r97 == null) goto L219;
        Log.d("auth", "DefaultWebKitDelegate disablePermissionCheck");
        Iterator r98 = r97.f5541p.entrySet().iterator();
    L215:
        if (r98.hasNext() == false) goto L219;
        Map.Entry r99 = (Map.Entry) r98.next();
        com.bytedance.sdk.xbridge.cn.platform.web.b r100 = this.f5527j;
        if (r100 == null) goto L215;
        r100.d((aj.a) r99.getKey(), (AuthPriority) r99.getValue());
    L219:
        com.bytedance.ies.bullet.kit.web.j r101 = (com.bytedance.ies.bullet.kit.web.j) d().f5307v.f1119c;
        if (r101 != null) goto L223;
        r101 = r89;
    L223:
        if (r101 == null) goto L98;
        ArrayList r102 = new ArrayList();
        if (r101.e == null) goto L227;
        Intrinsics.checkNotNullParameter(f(), "providerFactory");
    L227:
        Iterator r103 = r101.f.iterator();
    L229:
        if (r103.hasNext() == false) goto L232;
        com.ivy.ivykit.plugin.impl.web.i r104 = (com.ivy.ivykit.plugin.impl.web.i) r103.next();
        rb.b r105 = f();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "providerFactory");
        goto L229
    L232:
        if (r102.isEmpty() == true) goto L98;
        com.bytedance.sdk.xbridge.cn.platform.web.b r106 = this.f5527j;
        if (r106 == null) goto L98;
        r106.s(r102);
        goto L98
    L204:
        r89 = null;
        goto L205
    L179:
        r80 = null;
        goto L180
    L169:
        r76 = null;
        goto L170
    L132:
        if (Intrinsics.areEqual(d().f, "webcast") == false) goto L136;
        com.bytedance.sdk.xbridge.cn.platform.web.b r107 = this.f5527j;
        if (r107 == null) goto L136;
        ArrayList r108 = new ArrayList();
        com.bytedance.sdk.xbridge.cn.optimize.c r109 = new com.bytedance.sdk.xbridge.cn.optimize.c(null, null, 31);
        r109.f7356a = SetsKt.hashSetOf(new String[]{"bdx_thread_opt_all_schema"});
        HashSet r113 = new HashSet();
        r113.add("sendLogV3");
        r113.add("setStorage");
        r109.f7357b = r113;
        r108.add(r109);
        Unit r114 = Unit.INSTANCE;
        r107.f7417r = Boolean.TRUE;
        r107.f7416q = r108;
        goto L136
    L111:
        if (Intrinsics.areEqual(d().f, "webcast") == false) goto L113;
        String r115 = "webcast";
    L114:
        zi.a r116 = new zi.a(r115);
        if (Intrinsics.areEqual(d().f, "webcast") == false) goto L117;
        String r117 = "webcast";
    L118:
        Intrinsics.checkNotNullParameter(r117, "namespace");
        com.bytedance.sdk.xbridge.cn.platform.web.e[] r118 = {r116, new zi.b(r117)};
        Intrinsics.checkNotNullParameter(r118, "protocols");
        com.bytedance.sdk.xbridge.cn.platform.web.d r119 = r55.f7413n;
        Intrinsics.checkNotNullParameter(r119, "bridgeContext");
        r55.f7456h = r119;
        r119.getClass();
        Intrinsics.checkNotNullParameter(kj.a.class, "clazz");
        r119.d.put(kj.a.class, new cj.c(r55));
        r55.f7414o.clear();
        CollectionsKt.c(r55.f7414o, r118);
        int r120 = 0;
    L120:
        if (r120 >= 2) goto L122;
        com.bytedance.sdk.xbridge.cn.platform.web.e r121 = r118[r120];
        SSWebView r122 = r55.f7410k;
        r121.getClass();
        Intrinsics.checkNotNullParameter(r122, "view");
        Intrinsics.checkNotNullParameter(r55, "bdxBridge");
        Intrinsics.checkNotNullParameter(r122, "<set-?>");
        r121.f7419b = r122;
        Intrinsics.checkNotNullParameter(r55, "<set-?>");
        r121.f7420c = r55;
        r121.d(r122);
        r120 = r120 + 1;
        goto L120
    L117:
        r117 = "";
        goto L118
    L113:
        r115 = "";
        goto L114
    L238:
        throw new ClassCastException();
    L102:
        r112 = "";
    L98:
        String r123 = "providerFactory";
        r12 = "<set-?>";
    L334:
        d().f5293c.v();
        Iterator r124 = this.f.iterator();
        if (r124.hasNext() == true) goto L351;
        g();
        d().f5307v.getClass();
        String r125 = d().getSessionId();
        Intrinsics.checkNotNullParameter(r125, "sessionId");
        r31.e = r125;
        r r126 = r31.g;
        r126.getClass();
        Intrinsics.checkNotNullParameter(r125, r12);
        r126.f18728b = r125;
        r31.f = xq.b.d(d());
        g();
        bd.f r127 = this.e.f6159c;
        b r128 = new b(this, 0);
        r127.getClass();
        Intrinsics.checkNotNullParameter(r128, "webViewClient");
        r127.f907b.add(0, r128);
        WebChromeClientDispatcher r129 = this.e.d;
        com.bytedance.ies.bullet.kit.web.k r130 = new com.bytedance.ies.bullet.kit.web.k(this, 1);
        r129.getClass();
        Intrinsics.checkNotNullParameter(r130, "webChromeClient");
        r129.f6021a.add(r130);
        ((com.bytedance.ies.bullet.service.webkit.a) this.e.e.getValue()).a(r10);
        com.bytedance.ies.bullet.kit.web.j r131 = (com.bytedance.ies.bullet.kit.web.j) d().f5307v.f1119c;
        if (r131 != null) goto L340;
        r131 = null;
    L340:
        if (r131 == null) goto L348;
        com.bytedance.ies.bullet.service.base.b.a(2, "DefaultWebKitDelegate disablePermissionCheck", "XWebKit");
        LinkedHashMap r132 = cd.a.f1171a;
        com.bytedance.ies.bullet.core.e r133 = r131.d;
        if (r133 == null) goto L344;
        String r134 = r133.getSessionId();
    L345:
        rb.b r135 = cd.a.a(r134);
        if (r131.e == null) goto L348;
        Intrinsics.checkNotNullParameter(r135, r123);
        goto L348
    L344:
        r134 = null;
    L348:
        this.f5530m = r31.getSettings().getUserAgentString();
        return;
    L351:
        throw mn.h.c(r124);
    L239:
        r10 = r10;
        if (this.f5525h != null) goto L294;
        final com.bytedance.ies.bullet.kit.web.j r136 = (com.bytedance.ies.bullet.kit.web.j) d().f5307v.f1119c;
        if (r136 != null) goto L245;
        r136 = null;
    L245:
        if (r136 == null) goto L248;
        final ArrayList r137 = r136.f5539n;
        if (r137 == null) goto L248;
    L249:
        if (r136 == null) goto L252;
        final ArrayList r138 = r136.f5540o;
        if (r138 == null) goto L252;
    L253:
        Intrinsics.checkNotNullParameter(r31, "webView");
        com.bytedance.ies.bullet.kit.web.jsbridge.d r139 = new com.bytedance.ies.bullet.kit.web.jsbridge.d(r31);
        r139.f5556m = new DefaultWebKitDelegate$createWebJsBridge$1$1(this);
        ((com.bytedance.android.anniex.base.depend.b) com.bytedance.android.anniex.base.depend.a.f3113b.getValue()).getClass();
        Intrinsics.checkNotNullParameter("ToutiaoJSBridge", "jsObjectName");
        r139.g = "ToutiaoJSBridge";
        Intrinsics.checkNotNullParameter("bytedance", "bridgeScheme");
        r139.f5551h = "bytedance";
        if (r136 == null) goto L257;
        ArrayList r140 = r136.f5537l;
        if (r140 == null) goto L257;
    L258:
        Intrinsics.checkNotNullParameter(r140, "safeHost");
        r139.f5550c.addAll(r140);
        if (r136 == null) goto L262;
        ArrayList r141 = r136.f5538m;
        if (r141 == null) goto L262;
    L263:
        Intrinsics.checkNotNullParameter(r141, "safeHost");
        r139.d.addAll(r141);
        Intrinsics.checkNotNullParameter(r137, "publicFunc");
        r139.e.addAll(r137);
        Intrinsics.checkNotNullParameter(r138, "protectedFunc");
        r139.f.addAll(r138);
        xk.c r142 = new xk.c(r31);
        Intrinsics.checkNotNullParameter(r142, "listener");
        r139.f5552i = r142;
        this.f5525h = r139;
        com.bytedance.ies.bullet.core.kit.bridge.d r143 = d().f5301o;
        if (r143 == null) goto L266;
        r143.d(new DefaultWebKitDelegate$setJsBridge$1$1(r136, r137, r138));
    L266:
        com.bytedance.ies.bullet.kit.web.jsbridge.d r144 = this.f5525h;
        if (r144 == null) goto L291;
        SSWebView r145 = r144.f5548a;
        com.bytedance.ies.web.jsbridge2.m r146 = com.bytedance.ies.web.jsbridge2.o.d;
        com.bytedance.ies.web.jsbridge2.d r147 = new com.bytedance.ies.web.jsbridge2.d(r145);
        r147.f = true;
        r147.f6274c = r144.g;
        r147.f6277j.addAll(r144.e);
        r147.d = new uj.a();
        r147.g.add(new com.bytedance.ies.bullet.kit.web.jsbridge.c(r144));
        ArrayList r148 = r144.d;
        if (r148 != null) goto L271;
    L274:
        ArrayList r149 = r144.f5550c;
    L275:
        r147.f6276i.addAll(r149);
        r147.e = true;
        r147.g.add(r144.f5552i);
        if (r147.f6272a == null) goto L290;
        if (TextUtils.isEmpty(r147.f6274c) == false) goto L282;
        if (r147.f6272a != null) goto L290;
    L282:
        if (r147.d == null) goto L290;
        t r150 = new t();
        r150.a("jsObjectName", r147.f6274c);
        Boolean r151 = Boolean.FALSE;
        r150.a("debug", r151);
        r150.a("shouldFlattenData", Boolean.valueOf(r147.e));
        r150.a("enablePermissionCheck", Boolean.valueOf(r147.f));
        r150.a("namespace", r147.f6275h);
        r150.a("safeHostSet", r147.f6276i);
        r150.a("publicMethodSet", r147.f6277j);
        r150.a("dummy", r151);
        r150.a("jsbPermissionValidator", r151);
        r150.a("disableAllPermissionCheck", r151);
        r150.a("isShowDebugToast", Boolean.valueOf(r147.f6279l));
        SSWebView r152 = r147.f6272a;
        if (r152 == null) goto L286;
        r150.a("webView", r152.getClass().getSimpleName());
    L286:
        r150.b("label_create_jsb_environment", r147.f6278k);
        com.bytedance.ies.web.jsbridge2.o r153 = new com.bytedance.ies.web.jsbridge2.o(r147);
        r144.f5555l = r153;
        com.bytedance.ies.web.jsbridge2.p r154 = new com.bytedance.ies.web.jsbridge2.p(r144.f5548a, r153);
        r144.f5554k = r154;
        Intrinsics.checkNotNull(r154);
        r144.f5553j = (ce.b) r154.f6304c;
        tc.c r155 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r156 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r156 == null) goto L292;
        com.bytedance.ies.bullet.service.base.d r157 = (com.bytedance.ies.bullet.service.base.d) r156.f6163b.getValue();
    L292:
        this.f5525h = r144;
        rb.b r158 = f();
        com.bytedance.ies.bullet.kit.web.jsbridge.d r159 = this.f5525h;
        Intrinsics.checkNotNull(r159);
        ce.b r160 = r159.f5553j;
        r158.getClass();
        Intrinsics.checkNotNullParameter(ce.b.class, "clazz");
        r158.b(ce.b.class, new rb.a(r160, 0));
        rb.b r161 = f();
        com.bytedance.ies.bullet.kit.web.jsbridge.d r162 = this.f5525h;
        Intrinsics.checkNotNull(r162);
        com.bytedance.ies.web.jsbridge2.p r163 = r162.f5554k;
        r161.getClass();
        Intrinsics.checkNotNullParameter(com.bytedance.ies.web.jsbridge2.p.class, "clazz");
        r161.b(com.bytedance.ies.web.jsbridge2.p.class, new rb.a(r163, 0));
    L290:
        throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
    L271:
        if (r148.isEmpty() == true) goto L274;
        r149 = r144.d;
        goto L275
    L291:
        r144 = null;
    L262:
        r141 = new ArrayList();
    L257:
        r140 = new ArrayList();
    L252:
        r138 = new ArrayList();
    L248:
        r137 = new ArrayList();
    L294:
        com.bytedance.ies.bullet.kit.web.j r164 = (com.bytedance.ies.bullet.kit.web.j) d().f5307v.f1119c;
        if (r164 == null) goto L297;
        td.c.c(r164, KitType.f6012c);
    L297:
        com.bytedance.ies.bullet.kit.web.jsbridge.d r165 = this.f5525h;
        if (r165 == null) goto L312;
        com.bytedance.ies.bullet.service.webkit.d r166 = this.e;
        WebChromeClientDispatcher r167 = r166.d;
        r165.f5549b = r166.f6159c;
        ce.b r168 = r165.f5553j;
        if (r168 == null) goto L312;
        r168.f1174a = r165.f5551h;
        r168.d = r165.f5550c;
        r168.e = r165.e;
        r168.f = r165.f;
        if (r167 == null) goto L306;
        SSWebView r169 = (SSWebView) r168.f1176c;
        if (r169 == null) goto L306;
        r169.setWebChromeClient(r167);
    L306:
        bd.f r170 = r165.f5549b;
        if (r170 == null) goto L312;
        SSWebView r171 = (SSWebView) r168.f1176c;
        if (r171 == null) goto L312;
        r171.setWebViewClient(r170);
    L312:
        com.bytedance.ies.bullet.service.webkit.c r172 = this.f5522a;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.base.l.class, "clazz");
        tc.c r173 = tc.c.f22119c;
        if (tc.c.f22119c.a(com.bytedance.ies.bullet.service.base.l.class, r172.f22117a) != null) goto L353;
        com.bytedance.ies.bullet.core.kit.bridge.d r174 = d().f5301o;
        if (r174 == null) goto L317;
        r174.a(new com.bytedance.ies.bullet.kit.web.jsbridge.b(f(), 0));
        r174.a(new com.bytedance.ies.bullet.kit.web.jsbridge.a(f()));
    L317:
        ConcurrentHashMap r175 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(jb.a.class, "cls");
        if (((jb.a) yc.a.a(jb.a.class, "default_bid")) == null) goto L329;
        rb.b r176 = f();
        String r177 = d().f;
        if (r177 == null) goto L323;
        r13 = r177;
    L323:
        d().getSessionId();
        r123 = "providerFactory";
        Intrinsics.checkNotNullParameter(r176, r123);
        Intrinsics.checkNotNullParameter(r13, "bid");
        ArrayList r178 = new ArrayList();
        r178.add(new com.bytedance.ies.bullet.service.preload.f(r176));
        r178.add(new com.bytedance.ies.bullet.service.preload.d(r176));
        r178.add(new ed.a(r176, 2));
        r178.add(new com.bytedance.ies.bullet.kit.web.jsbridge.b(r176, 2));
        r178.add(new ed.a(r176, 1));
        r178.add(new ed.a(r176, 0));
        r178.add(new com.bytedance.ies.bullet.kit.web.jsbridge.b(r176, 1));
        Iterator r179 = r178.iterator();
    L325:
        if (r179.hasNext() == false) goto L330;
        Object r180 = r179.next();
        com.bytedance.ies.bullet.core.kit.bridge.d r181 = d().f5301o;
        if (r181 == null) goto L325;
        Intrinsics.checkNotNull(r180, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod");
        r181.a((com.bytedance.ies.bullet.core.kit.bridge.b) r180);
    L330:
        com.bytedance.ies.bullet.core.kit.bridge.d r182 = d().f5301o;
        if (r182 == null) goto L333;
        r182.d(new DefaultWebKitDelegate$setJsBridge$6(this));
    L333:
        r26.f5565c = this.f5525h;
        goto L334
    L329:
        r123 = r10;
        goto L330
    L353:
        throw new ClassCastException();
    }

    public final rb.b f() {
        rb.b r5 = this.d;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("providerFactory");
        return null;
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String forestDownloadEngine(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.c(r5);
    }

    public final void g() {
        d().g.getClass();
    }

    @Override // com.bytedance.ies.bullet.forest.p
    public final Pair h(String r5, boolean r10, com.bytedance.ies.bullet.core.e r11, rd.e r12) {
        return o.b(this, r5, r10, r11, r12);
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
