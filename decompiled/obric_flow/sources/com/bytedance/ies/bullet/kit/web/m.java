package com.bytedance.ies.bullet.kit.web;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.app.NotificationCompat;
import com.bytedance.ies.bullet.core.device.PropsUtilsKt;
import com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry;
import com.bytedance.ies.bullet.core.n;
import com.bytedance.ies.bullet.core.q;
import com.bytedance.ies.bullet.forest.p;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.CacheType;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.web.WebChromeClientDispatcher;
import com.bytedance.ies.web.jsbridge2.o;
import com.bytedance.ies.web.jsbridge2.u;
import com.google.common.reflect.w;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.ui.image.f0;
import com.obric.launcher.widget.R$id;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import zm.z;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements bd.a, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ies.bullet.ui.common.loader.c f5563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ies.bullet.kit.web.jsbridge.d f5565c;
    public com.bytedance.ies.bullet.kit.web.impl.i d;
    public SSWebView e;
    public String f;
    public c2.b g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5566h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f5567i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5568j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Uri f5569k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.ies.bullet.web.scc.b f5570l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SccConfig.SccLevel f5571m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public rb.b f5572n;

    public m(com.bytedance.ies.bullet.ui.common.loader.c r5, com.bytedance.ies.bullet.service.webkit.c r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "kitService");
        this.f5563a = r5;
        Intrinsics.checkNotNullParameter(r5, "context");
        ug.e r11 = r10.f6155b;
        if (r11 == null) goto L5;
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkNotNullParameter(r5, "context");
        com.bytedance.ies.bullet.kit.web.impl.i r12 = new com.ivy.ivykit.plugin.impl.applet.d(r10, (List) r11.f22361b);
    L6:
        this.d = r12;
        this.f = "";
        this.f5566h = true;
        this.f5567i = new AtomicBoolean(false);
        this.f5571m = SccConfig.SccLevel.f5894a;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.settings.b.class, "clazz");
        tc.c r13 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r14 = (com.bytedance.ies.bullet.settings.b) tc.c.f22119c.a(com.bytedance.ies.bullet.settings.b.class, r10.f22117a);
        if (r14 == null) goto L10;
        ((com.bytedance.ies.bullet.service.base.d) r14.f6163b.getValue()).getClass();
        return;
    L10:
        return;
    L5:
        r12 = new com.bytedance.ies.bullet.kit.web.impl.i(r10);
        goto L6
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final void a(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r10, "eventName");
        if (com.bytedance.ies.bullet.core.h.g.f5315a == true) goto L22;
        boolean r5 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, this.f, "send event.", "XWebKit");
    L9:
        jg.k r12 = this.d.f5531n;
        if (r12 == null) goto L12;
        r12.a(r11, r10, this.e);
        return;
    L12:
        JSONObject r13 = new JSONObject();
        if (r11 != null) goto L15;
    L17:
        r11 = r13;
    L18:
        JSONObject r14 = (JSONObject) r11;
        com.bytedance.ies.bullet.kit.web.jsbridge.d r15 = this.f5565c;
        if (r15 == null) goto L25;
        r15.b(r10, r14);
        return;
    L25:
        return;
    L15:
        if ((r11 instanceof JSONObject) == false) goto L17;
    L22:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L6
        boolean r17 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L6
        com.bytedance.ies.bullet.service.base.b.b(8, this.f, "send event: " + r10 + " with " + new Gson().toJson(r11), "XWebKit");     // Catch: Throwable -> L6
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final void b(Map r10) {
        Intrinsics.checkNotNullParameter(r10, "globalprops");
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r11 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        boolean r12 = true;
        if (r11 == null) goto L9;
        xc.d r13 = (xc.d) r11.a(xc.d.class);
        if (r13 == null) goto L9;
        Boolean r14 = r13.b();
        if (r14 == null) goto L9;
        boolean r15 = r14.booleanValue();
    L10:
        if (r15 == false) goto L30;
        com.bytedance.ies.bullet.kit.web.impl.i r16 = this.d;
        SSWebView r17 = this.e;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r10, "globalProps");
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r18 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r18 == null) goto L18;
        xc.d r19 = (xc.d) r18.a(xc.d.class);
        if (r19 == null) goto L18;
        Boolean r20 = r19.b();
        if (r20 == null) goto L18;
        r12 = r20.booleanValue();
    L18:
        if (r12 == false) goto L32;
        if (r17 == null) goto L33;
        com.bytedance.ies.bullet.service.webkit.a r21 = (com.bytedance.ies.bullet.service.webkit.a) r16.e.e.getValue();
        LinkedHashMap r22 = r16.f5529l;
        if (r22 == null) goto L31;
        r22.putAll(r10);
        r21.getClass();
        Intrinsics.checkNotNullParameter(r22, "globalProps");
        if (r22.isEmpty() == false) goto L27;
        r21.f6152a = null;
    L28:
        r21.a(r17);
        return;
    L27:
        r21.f6152a = new JSONObject(r22).toString();
        goto L28
    L31:
        return;
    L33:
        return;
    L32:
        return;
    L30:
        return;
    L9:
        r15 = true;
        goto L10
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final void c() {
        SSWebView r5 = this.e;
        if (r5 == null) goto L5;
        r5.onPause();
    L5:
        a("viewDisappeared", null);
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, this.f, "kitView status:on hide", "XWebKit");
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final void d() {
        c2.b r5 = this.g;
        if (r5 != null) goto L5;
    L15:
        SSWebView r10 = this.e;
        if (r10 == null) goto L18;
        r10.onResume();
    L18:
        JSONObject r11 = new JSONObject();
        JSONObject r12 = new JSONObject();
        r12.put("isViewFirstAppeared", this.f5566h);
        Unit r13 = Unit.INSTANCE;
        r11.put("data", r12);
        a("viewAppeared", r11);
        this.f5566h = false;
        SSWebView r14 = this.e;
        if (r14 == null) goto L21;
        com.bytedance.ies.bullet.core.container.b r15 = r14.getSearchMode();
    L22:
        if (r15 == null) goto L24;
    L26:
        boolean r16 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, this.f, "kitView status:on show", "XWebKit");
        return;
    L24:
        if (this.e == null) goto L26;
        this.d.d().f5307v.getClass();
        goto L26
    L21:
        r15 = null;
        goto L22
    L5:
        if (r5.f1108a != true) goto L15;
        if (this.f5567i.compareAndSet(false, true) == false) goto L15;
        com.bytedance.ies.bullet.service.base.b.a(2, "send pageReused event for reused view", "XWebKit");
        JSONObject r17 = new JSONObject();
        JSONObject r18 = new JSONObject();
        Uri r19 = this.f5569k;
        if (r19 == null) goto L14;
        Iterator<T> r20 = r19.getQueryParameterNames().iterator();
    L12:
        if (r20.hasNext() == false) goto L14;
        String r21 = (String) r20.next();
        r18.put(r21, r19.getQueryParameter(r21));
    L14:
        Unit r22 = Unit.INSTANCE;
        r17.put("queryItems", r18);
        a("pageReused", r17);
        goto L15
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final void destroy() {
        com.bytedance.ies.bullet.kit.web.impl.i r5 = this.d;
        r5.getClass();
        Intrinsics.checkNotNullParameter(this, "kitViewService");
        r5.f().c(ce.b.class);
        r5.f().c(com.bytedance.ies.web.jsbridge2.p.class);
        com.bytedance.ies.bullet.kit.web.jsbridge.d r10 = r5.f5525h;
        if (r10 == null) goto L35;
        ce.b r11 = r10.f5553j;
        if (r11 == null) goto L10;
        r11.f1176c = null;
        bb.b r12 = (bb.b) r11.f1177h;
        if (r12 == null) goto L9;
        r12.removeCallbacksAndMessages(null);
    L9:
        r11.g = null;
    L10:
        o r13 = r10.f5555l;
        if (r13 == null) goto L35;
        if (r13.f6301c == true) goto L35;
        u r14 = r13.f6299a;
        com.bytedance.ies.web.jsbridge2.c r15 = r14.f;
        Iterator r16 = r15.d.iterator();
        if (r16.hasNext() == true) goto L34;
        r15.d.clear();
        r15.f6270b.clear();
        r15.f6271c.clear();
        r15.f6269a.getClass();
        Iterator r17 = r14.g.values().iterator();
    L19:
        if (r17.hasNext() == false) goto L25;
        com.bytedance.ies.web.jsbridge2.c r18 = (com.bytedance.ies.web.jsbridge2.c) r17.next();
        Iterator r19 = r18.d.iterator();
        if (r19.hasNext() == true) goto L24;
        r18.d.clear();
        r18.f6270b.clear();
        r18.f6271c.clear();
        r18.f6269a.getClass();
        goto L19
    L24:
        throw mn.h.c(r19);
    L25:
        r14.f6312b.removeCallbacksAndMessages(null);
        r14.d = true;
        r14.f6316j.removeJavascriptInterface(r14.f6315i);
        r13.f6301c = true;
        Iterator r20 = r13.f6300b.iterator();
    L27:
        if (r20.hasNext() == false) goto L35;
        if (r20.next() == null) goto L27;
        throw new ClassCastException();
    L34:
        throw mn.h.c(r16);
    L35:
        r5.f5525h = null;
        com.bytedance.sdk.xbridge.cn.platform.web.b r21 = r5.f5527j;
        if (r21 == null) goto L38;
        r21.r();
    L38:
        com.bytedance.ies.bullet.service.webkit.d r22 = r5.e;
        r22.f6159c.f907b.clear();
        r22.d.f6021a.clear();
        n r23 = r5.d().f5299m;
        if (r23 == null) goto L44;
        Uri r24 = r5.d().f5297k;
        if (r24 != null) goto L43;
        r24 = Uri.EMPTY;
    L43:
        r23.s(r24, this);
    L44:
        IBridge3Registry r25 = r5.d().f5302p;
        if (r25 == null) goto L47;
        r25.release();
    L47:
        com.bytedance.ies.bullet.core.kit.bridge.d r26 = r5.d().f5301o;
        if (r26 == null) goto L50;
        r26.release();
    L50:
        zm.c r27 = com.bytedance.ies.bullet.forest.f.f5397a;
        com.bytedance.ies.bullet.forest.f.l(u8.a.p(this, this.f5563a));
        SSWebView r28 = this.e;
        if (r28 == null) goto L57;
        r28.setWebChromeClient(null);
        r28.setWebViewClient(new WebViewClient());
        r28.destroy();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        boolean r29 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.f(this.f, "WebKitView destroy exception", "XWebKit", th, LogLevel.f5955c);
    L57:
        com.bytedance.android.monitorV2.webview.k r30 = com.bytedance.android.monitorV2.webview.k.d;
        String[] r31 = {SSWebView.class.getName()};
        com.bytedance.android.monitorV2.webview.m r32 = r30.f3799b;
        r32.getClass();
        Intrinsics.checkNotNullParameter(r31, "webViewClassesNames");
        String r33 = r31[0];
        HashMap r34 = r32.f3803a;
        if (r34 == null) goto L62;
        TypeIntrinsics.asMutableMap(r34).remove(r33);
        boolean r35 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, this.f, "kitView status:destroy", "XWebKit");
        return;
    L62:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    public final void e(String r10) {
        if (this.e != null) goto L5;
    L7:
        com.bytedance.ies.bullet.kit.web.impl.i r5 = this.d;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        if (r5.f5524c != null) goto L10;
        Lazy r11 = com.bytedance.ies.bullet.core.f.f5312b;
        com.bytedance.ies.bullet.core.e r12 = td.b.b().a(r10);
        Intrinsics.checkNotNull(r12);
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r5.f5524c = r12;
    L10:
        Context r13 = r5.d().f5294h;
        Intrinsics.checkNotNull(r13);
        com.bytedance.ies.bullet.service.webkit.d r14 = r5.e;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r13, "context");
        ConcurrentHashMap r15 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.preload.c.class, "cls");
        com.bytedance.ies.bullet.service.preload.c r16 = (com.bytedance.ies.bullet.service.preload.c) yc.a.a(com.bytedance.ies.bullet.service.preload.c.class, "default_bid");
        if (r16 == null) goto L13;
        WebView r17 = r16.d(r13);
    L14:
        r14.f6158b = r17;
        if (r17 != null) goto L17;
        r14.f6158b = com.bytedance.android.anniex.base.service.e.b(r13);
    L17:
        WebView r18 = r14.f6158b;
        if (r18 == null) goto L20;
        r18.setWebViewClient(r14.f6159c);
        r18.setWebChromeClient(r14.d);
    L20:
        WebView r19 = r14.f6158b;
        if (r19 == null) goto L40;
        if ((r19 instanceof SSWebView) == false) goto L25;
        SSWebView r20 = (SSWebView) r19;
    L26:
        r14.getClass();
        Intrinsics.checkNotNullParameter(r20, "webView");
        r14.f6158b = r20;
        r20.setWebViewClient(r14.f6159c);
        r20.setWebChromeClient(r14.d);
        com.bytedance.ies.bullet.core.c r21 = r5.d().f5308w;
        Object r22 = r20.getTag(R$id.webx_precreate_is_precreate);
        if ((r22 instanceof Boolean) == false) goto L29;
        boolean r23 = ((Boolean) r22).booleanValue();
    L30:
        r21.f5276c = r23;
        if (r5.d != null) goto L33;
        LinkedHashMap r24 = cd.a.f1171a;
        rb.b r25 = cd.a.a(r5.d().getSessionId());
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r5.d = r25;
    L33:
        rb.b r26 = r5.f();
        WebView r27 = r14.f6158b;
        if (r27 == null) goto L38;
        r26.getClass();
        Intrinsics.checkNotNullParameter(WebView.class, "clazz");
        r26.b(WebView.class, new rb.a(r27));
        this.e = r20;
        return;
    L38:
        throw new IllegalStateException("You must call 'createWebView' or 'setWebView' first.");
    L29:
        r23 = false;
        goto L30
    L25:
        Context r28 = r5.d().f5294h;
        Intrinsics.checkNotNull(r28);
        r20 = com.bytedance.android.anniex.base.service.e.b(r28);
        goto L26
    L40:
        throw new IllegalStateException("You must call 'createWebView' or 'setWebView' first.");
    L13:
        r17 = null;
        goto L14
    L5:
        if (this.f5564b == null) goto L7;
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final String f() {
        return "BulletWeb";
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String forestDownloadEngine(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.c(r5);
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final boolean g() {
        if (this.f5571m == SccConfig.SccLevel.f5894a) goto L5;
        return false;
    L5:
        SSWebView r5 = this.e;
        if (r5 != null) goto L8;
    L13:
        return false;
    L8:
        if (r5.canGoBack() != true) goto L13;
        SSWebView r10 = this.e;
        if (r10 == null) goto L12;
        r10.goBack();
    L12:
        return true;
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final KitType h() {
        return KitType.f6012c;
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

    @Override // com.bytedance.ies.bullet.forest.p
    public final Pair h(String r5, boolean r10, com.bytedance.ies.bullet.core.e r11, rd.e r12) {
        return com.bytedance.ies.bullet.forest.o.b(this, r5, r10, r11, r12);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean hasGeckoModelInfo(rd.e r5) {
        return u8.a.j(r5);
    }

    public final void c(Uri r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        com.bytedance.ies.bullet.core.e r10 = (com.bytedance.ies.bullet.core.e) f0.c(this.f5563a, com.bytedance.ies.bullet.core.e.class);
        SSWebView r11 = this.e;
        if (r11 == null) goto L9;
        WebSettings r12 = r11.getSettings();
        if (r12 == null) goto L9;
        String r13 = r12.getUserAgentString();
    L10:
        ug.a.d(r10, r5, r13, true);
        return;
    L9:
        r13 = null;
        goto L10
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final void a(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final boolean a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schemaUrl");
        String r10 = this.f5564b;
        if (r10 == null) goto L7;
        e(r10);
        return true;
    L7:
        return true;
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final View a() {
        return this.e;
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final SccConfig.SccLevel b() {
        return this.f5571m;
    }

    public final void d(String r26, n r27, String r28) {
        Intrinsics.checkNotNullParameter(r26, "url");
        Intrinsics.checkNotNullParameter(r27, "lifeCycle");
        Intrinsics.checkNotNullParameter(r28, "sessionId");
        this.f = r28;
        this.f5572n = cd.a.a(r28);
        Uri r10 = Uri.parse(r26);
        com.bytedance.ies.bullet.kit.web.impl.i r5 = this.d;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r26, "url");
        Intrinsics.checkNotNullParameter(r28, "sessionId");
        r5.f5528k = r26;
        Lazy r11 = com.bytedance.ies.bullet.core.f.f5312b;
        com.bytedance.ies.bullet.core.e r12 = td.b.b().a(r28);
        String r13 = "<set-?>";
        if (r12 == null) goto L19;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r5.f5524c = r12;
        rb.b r14 = cd.a.a(r5.d().getSessionId());
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r5.d = r14;
        if (com.bytedance.ies.bullet.kit.web.impl.i.f5521p == false) goto L8;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XWebKit", "cold start this time", null, 12);
        r5.f5523b = true;
        com.bytedance.ies.bullet.kit.web.impl.i.f5521p = false;
    L8:
        ArrayList r15 = new ArrayList();
        r15.addAll(r5.d().f5300n);
        n r16 = r5.d().f5299m;
        if (r16 == null) goto L11;
        r15.add(r16);
    L11:
        com.bytedance.ies.bullet.core.e r17 = r5.d();
        c5.a r18 = r17.f5307v;
        j r19 = new j();
        List r110 = (List) r17.f5305t.f288c;
        if (r110 != null) goto L14;
        r110 = CollectionsKt.emptyList();
    L14:
        r19.d(r17, r110);
        r18.f1119c = r19;
        r5.e.f6159c.f907b.clear();
        r5.e.d.f6021a.clear();
        r5.f.clear();
        if (r5.f().a(a.class) != null) goto L352;
        hc.c r20 = (hc.c) r5.f().a(hc.c.class);
        if (r20 == null) goto L19;
        bd.f r21 = r5.e.f6159c;
        r21.getClass();
        Intrinsics.checkNotNullParameter(r20, "webViewClient");
        r21.f907b.add(r20);
        goto L19
    L352:
        throw new ClassCastException();
    L19:
        com.bytedance.ies.bullet.kit.web.impl.i r22 = this.d;
        if (r22.f5524c == null) goto L349;
        Intrinsics.checkNotNullParameter(r26, "url");
        Intrinsics.checkNotNullParameter(r28, "sessionId");
        rd.b r23 = r22.d().g.f21723a;
        if (xq.b.o() == false) goto L35;
        new ArrayList();
        com.lynx.tasm.utils.a.e(r22.d(), r23);
        com.lynx.tasm.utils.a.m(r22.d(), r23);
        tc.c r24 = tc.c.f22119c;
        tc.c r25 = tc.c.f22119c;
        List r29 = (List) r22.d().f5305t.f288c;
        if (r29 == null) goto L27;
        String r30 = (String) CollectionsKt.firstOrNull(r29);
        if (r30 == null) goto L27;
    L28:
        com.ivy.ivykit.plugin.impl.web.i r31 = (com.ivy.ivykit.plugin.impl.web.i) r25.a(com.ivy.ivykit.plugin.impl.web.i.class, r30);
        Lazy r32 = com.bytedance.ies.bullet.service.sdk.d.e;
        av.i.e().getClass();
        com.bytedance.ies.bullet.service.sdk.d.b(r23, td.e.class);
        r22.d().g.getClass();
        List r33 = (List) r22.d().f5305t.f288c;
        if (r33 == null) goto L34;
        Iterator r34 = r33.iterator();
    L32:
        if (r34.hasNext() == false) goto L34;
        String r35 = (String) r34.next();
        tc.c r36 = tc.c.f22119c;
        com.ivy.ivykit.plugin.impl.web.i r37 = (com.ivy.ivykit.plugin.impl.web.i) tc.c.f22119c.a(com.ivy.ivykit.plugin.impl.web.i.class, r35);
    L34:
        r22.d().f5305t.getClass();
        r22.f5526i = sk.a.f(r22.d());
    L47:
        r22.g();
        q r38 = (q) r27;
        r38.v(r10, this, r22.d().g);
        com.bytedance.ies.bullet.kit.web.impl.i r39 = this.d;
        c2.b r40 = new c2.b();
        com.bytedance.ies.bullet.core.e r41 = r39.d();
        Intrinsics.checkNotNullParameter(r41, "<this>");
        Lazy r111 = com.bytedance.ies.bullet.secure.f.f5904c;
        com.bytedance.ies.bullet.secure.f r112 = wn.h.e();
        String r42 = r41.f;
        if (r42 != null) goto L50;
        r42 = "default_bid";
    L50:
        com.bytedance.ies.bullet.secure.e r43 = r112.a(r42);
        if (r43 == null) goto L53;
        r40.f1110c = r43.f5903c;
        r40.d = r43.d;
    L53:
        r40.f = r39.e;
        if (((j) r39.d().f5307v.f1119c) == null) goto L87;
        j r44 = (j) r39.d().f5307v.f1119c;
        if (r44 != null) goto L59;
        r44 = null;
    L59:
        if (r44 == null) goto L87;
        Iterator r113 = r44.g.iterator();
    L62:
        if (r113.hasNext() == false) goto L69;
        Iterator r114 = r113;
        bd.e r115 = (bd.e) r113.next();
        String r116 = r13;
        com.bytedance.ies.bullet.service.webkit.d r117 = (com.bytedance.ies.bullet.service.webkit.d) r40.f;
        if (r117 == null) goto L68;
        bd.f r118 = r117.f6159c;
        if (r118 == null) goto L68;
        Intrinsics.checkNotNullParameter(r115, "webViewClient");
        r118.f907b.add(r115);
    L68:
        r13 = r116;
        r113 = r114;
        goto L62
    L69:
        String r119 = r13;
        Iterator r120 = r44.f5533h.iterator();
    L71:
        if (r120.hasNext() == false) goto L78;
        bd.c r121 = (bd.c) r120.next();
        Iterator r122 = r120;
        com.bytedance.ies.bullet.service.webkit.d r123 = (com.bytedance.ies.bullet.service.webkit.d) r40.f;
        if (r123 == null) goto L77;
        WebChromeClientDispatcher r124 = r123.d;
        if (r124 == null) goto L77;
        Intrinsics.checkNotNullParameter(r121, "webChromeClient");
        r124.f6021a.add(r121);
    L77:
        r120 = r122;
        goto L71
    L78:
        Iterator r125 = r44.f5534i.iterator();
    L80:
        if (r125.hasNext() == false) goto L86;
        if (r125.next() != null) goto L85;
        r39.f.add(null);
        r125 = r125;
        goto L80
    L85:
        throw new ClassCastException();
    L86:
        r40.e = r44.f5535j;
    L88:
        r39.d().g.getClass();
        r39.d().g.getClass();
        CacheType r45 = r39.d().f5308w.e;
        if (r45 != null) goto L91;
    L93:
        boolean r46 = false;
    L94:
        r40.f1108a = r46;
        ConcurrentHashMap r47 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r48 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r48 == null) goto L101;
        com.bytedance.ies.bullet.base.settings.m r49 = (com.bytedance.ies.bullet.base.settings.m) r48.a(com.bytedance.ies.bullet.base.settings.m.class);
        if (r49 == null) goto L101;
        com.bytedance.ies.bullet.base.settings.f r50 = r49.b();
        if (r50 == null) goto L101;
    L102:
        r40.f1109b = r50.d();
        this.g = r40;
        boolean r51 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, this.f, "webview create ".concat(r26), "XWebKit");
        this.d.d().f5293c.w();
        e(r28);
        SSWebView r52 = this.e;
        if (r52 != null) goto L106;
        ((com.bytedance.ies.bullet.ui.common.loader.b) r27).r(r10, new Throwable("web view is null"));
        return;
    L106:
        Intrinsics.checkNotNull(r52);
        r52.setOverScrollMode(0);
        SSWebView r53 = this.e;
        if (r53 != null) goto L361;
    L112:
        SSWebView r54 = this.e;
        Intrinsics.checkNotNull(r54);
        com.bytedance.android.monitorV2.webview.k r55 = com.bytedance.android.monitorV2.webview.k.d;
        String r126 = this.d.d().f;
        if (r126 != null) goto L115;
        r126 = "default_bid";
    L115:
        tc.c r127 = tc.c.f22119c;
        com.bytedance.ies.bullet.service.base.i r128 = (com.bytedance.ies.bullet.service.base.i) tc.c.f22119c.a(com.bytedance.ies.bullet.service.base.i.class, r126);
        com.bytedance.ies.bullet.service.base.i r129 = r128;
        if (r128 != null) goto L118;
        Lazy r130 = com.bytedance.ies.bullet.service.monitor.i.d;
        r129 = ym.m.b();
    L118:
        w r131 = ((com.bytedance.ies.bullet.service.monitor.i) r129).f6054b;
        r55.getClass();
        com.bytedance.android.monitorV2.webview.b r132 = new com.bytedance.android.monitorV2.webview.b();
        r132.d = (String) r131.f9377c;
        r132.f3749c = true;
        WebView[] r133 = {r54};
        ArrayList r56 = new ArrayList();
        WebView r134 = r133[0];
        if (r134 == null) goto L121;
        r56.add(r134.hashCode() + "");
    L121:
        r132.f3748b = (String[]) r56.toArray(new String[r56.size()]);
        WeakReference r135 = new WeakReference(this.d.d());
        Intrinsics.checkNotNullParameter(r135, "contextRef");
        z r57 = new z();
        r57.f23549a = r135;
        r132.f = r57;
        r132.e = "bullet";
        r132.f3752j = this.f;
        com.bytedance.android.monitorV2.webview.m r58 = r55.f3799b;
        r58.getClass();
        com.bytedance.android.monitorV2.webview.b r136 = com.bytedance.android.monitorV2.webview.m.a(r132);     // Catch: Exception -> L147
        String[] r137 = r136.f3748b;     // Catch: Exception -> L147
        if (r137 == null) goto L137;
        String r210 = "";
    L134:
        e = e;
    L135:
        Object r211 = "bullet";
    L149:
        mn.h.g("default_handle", e);
        Object r212 = r211;
    L150:
        SSWebView r59 = this.e;
        Intrinsics.checkNotNull(r59);
        Intrinsics.checkNotNullParameter(r28, "sessionId");
        Intrinsics.checkNotNullParameter(r59, "webView");
        SSWebView r60 = this.e;
        Intrinsics.checkNotNull(r60);
        d5.b.f("WebViewMonitorHelper", "handleViewCreate: " + d5.b.a(r60));
        if (r55.v() == true) goto L153;
    L155:
        r55.w(r60);
    L156:
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        r38.f5349a.o(r10, this);
        com.bytedance.ies.bullet.kit.web.impl.i r61 = this.d;
        SSWebView r62 = this.e;
        Intrinsics.checkNotNull(r62);
        r61.e(r62, this);
        Result.Companion r63 = Result.Companion;     // Catch: Throwable -> L167
        c2.b r64 = this.g;     // Catch: Throwable -> L167
        if (r64 == null) goto L176;
        com.bytedance.ies.bullet.service.webkit.d r65 = (com.bytedance.ies.bullet.service.webkit.d) r64.f;     // Catch: Throwable -> L167
        if (r65 == null) goto L176;
        Iterator r66 = r65.f6159c.f907b.iterator();     // Catch: Throwable -> L167
    L163:
        if (r66.hasNext() == false) goto L169;
        bd.e r67 = (bd.e) r66.next();     // Catch: Throwable -> L167
        if ((r67 instanceof hc.c) == false) goto L163;
        ((hc.c) r67).getClass();     // Catch: Throwable -> L167
        goto L163
    L169:
        Iterator r68 = r65.d.f6021a.iterator();     // Catch: Throwable -> L167
    L171:
        if (r68.hasNext() == false) goto L175;
        bd.c r69 = (bd.c) r68.next();     // Catch: Throwable -> L167
        if ((r69 instanceof hc.b) == false) goto L171;
        ((hc.b) r69).getClass();     // Catch: Throwable -> L167
        goto L171
    L175:
        Unit r70 = Unit.INSTANCE;     // Catch: Throwable -> L167
    L177:
        Result.m124constructorimpl(r70);     // Catch: Throwable -> L167
    L180:
        com.bytedance.ies.bullet.kit.web.impl.i r71 = this.d;
        r71.getClass();
        Intrinsics.checkNotNullParameter(r26, "url");
        Uri.Builder r72 = Uri.parse(r26).buildUpon();
        r71.g();
        r71.g();
        r71.g();
        String r73 = r72.build().toString();
        w r74 = new w((com.bytedance.ies.bullet.ui.common.loader.b) r27, 10, r10, this);
        final SSWebView r75 = this.e;
        if (r75 == null) goto L393;
        this.f5568j = false;
        this.f5569k = Uri.parse(r73);
        l r76 = new l(this, r74, r73);
        c2.b r77 = this.g;
        if (r77 == null) goto L189;
        com.bytedance.ies.bullet.service.webkit.d r78 = (com.bytedance.ies.bullet.service.webkit.d) r77.f;
        if (r78 == null) goto L189;
        bd.f r79 = r78.f6159c;
        if (r79 == null) goto L189;
        Intrinsics.checkNotNullParameter(r76, "webViewClient");
        r79.f907b.add(0, r76);
    L189:
        c2.b r80 = this.g;
        if (r80 == null) goto L196;
        com.bytedance.ies.bullet.service.webkit.d r81 = (com.bytedance.ies.bullet.service.webkit.d) r80.f;
        if (r81 == null) goto L196;
        bd.f r82 = r81.f6159c;
        if (r82 == null) goto L196;
        d r83 = new d(0);
        Intrinsics.checkNotNullParameter(r83, "webViewClient");
        r82.f907b.add(r83);
    L196:
        ConcurrentHashMap r84 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r85 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r85 == null) goto L201;
        xc.f r86 = (xc.f) r85.a(xc.f.class);
        if (r86 == null) goto L201;
        boolean r87 = r86.g();
    L202:
        if (r87 == false) goto L210;
        c2.b r88 = this.g;
        if (r88 == null) goto L210;
        com.bytedance.ies.bullet.service.webkit.d r89 = (com.bytedance.ies.bullet.service.webkit.d) r88.f;
        if (r89 == null) goto L210;
        bd.f r90 = r89.f6159c;
        if (r90 == null) goto L210;
        d r91 = new d(1);
        Intrinsics.checkNotNullParameter(r91, "webViewClient");
        r90.f907b.add(r91);
    L210:
        Lazy r92 = com.bytedance.ies.bullet.core.f.f5312b;
        com.bytedance.ies.bullet.core.e r93 = td.b.b().a(this.f);
        if (r93 == null) goto L223;
        c5.a r94 = r93.f5307v;
        if (r94 == null) goto L223;
        v3.c r95 = (v3.c) r94.d;
        if (r95 == null) goto L223;
        c2.b r96 = this.g;
        if (r96 == null) goto L223;
        com.bytedance.ies.bullet.service.webkit.d r97 = (com.bytedance.ies.bullet.service.webkit.d) r96.f;
        if (r97 == null) goto L223;
        bd.f r98 = r97.f6159c;
        if (r98 == null) goto L223;
        hc.a r99 = new hc.a(r95);
        Intrinsics.checkNotNullParameter(r99, "webViewClient");
        r98.f907b.add(r99);
    L223:
        k r100 = new k(this, 0);
        c2.b r101 = this.g;
        if (r101 == null) goto L230;
        com.bytedance.ies.bullet.service.webkit.d r102 = (com.bytedance.ies.bullet.service.webkit.d) r101.f;
        if (r102 == null) goto L230;
        WebChromeClientDispatcher r103 = r102.d;
        if (r103 == null) goto L230;
        String r104 = "webChromeClient";
        Intrinsics.checkNotNullParameter(r100, r104);
        r103.f6021a.add(0, r100);
    L231:
        c2.b r105 = this.g;
        if (r105 == null) goto L238;
        com.bytedance.ies.bullet.service.webkit.d r106 = (com.bytedance.ies.bullet.service.webkit.d) r105.f;
        if (r106 == null) goto L238;
        WebChromeClientDispatcher r107 = r106.d;
        if (r107 == null) goto L238;
        c r108 = new c();
        Intrinsics.checkNotNullParameter(r108, r104);
        r107.f6021a.add(r108);
    L238:
        c2.b r109 = this.g;
        if (r109 == null) goto L247;
        SccConfig r138 = (SccConfig) r109.d;
        if (r138 == null) goto L247;
        JsonObject r139 = r138.e();
        if (r139 == null) goto L247;
        r9.c r140 = (r9.c) r109.f1110c;
        if (r140 == null) goto L247;
        com.bytedance.ies.bullet.web.scc.b r141 = new com.bytedance.ies.bullet.web.scc.b(r139, r140);
        this.f5570l = r141;
        r75.setSccDelegate$anniex_release(r141);
    L247:
        r75.setBackgroundColor(0);
        c2.b r142 = this.g;
        if (r142 == null) goto L250;
        Boolean r143 = Boolean.valueOf(r142.f1109b);
    L251:
        r75.setEnableSafeWebJSBAuth(r143);
        com.bytedance.ies.bullet.kit.web.impl.i r144 = this.d;
        Uri r145 = this.f5569k;
        Intrinsics.checkNotNull(r145);
        SSWebView r146 = this.e;
        Intrinsics.checkNotNull(r146);
        r144.getClass();
        Intrinsics.checkNotNullParameter(r145, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r146, "view");
        if (r146 == null) goto L338;
        com.bytedance.ies.bullet.service.webkit.a r147 = (com.bytedance.ies.bullet.service.webkit.a) r144.e.e.getValue();
        LinkedHashMap r148 = cd.a.f1171a;
        rb.b r149 = cd.a.a(r144.d().getSessionId());
        r147.getClass();
        Intrinsics.checkNotNullParameter(r149, "contextProviderFactory");
        r147.f6153b = r149;
        if (r144.f5529l == null) goto L257;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XWebKit", "already getGlobalProps", null, 12);
        LinkedHashMap r150 = r144.f5529l;
        Intrinsics.checkNotNull(r150, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        Map r151 = TypeIntrinsics.asMutableMap(r150);
    L333:
        Intrinsics.checkNotNullParameter(r151, "globalProps");
        if (r151.isEmpty() == false) goto L336;
        r147.f6152a = null;
    L337:
        r147.a(r146);
        goto L338
    L336:
        r147.f6152a = new JSONObject(r151).toString();
        goto L337
    L257:
        tc.c r152 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r153 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r153 == null) goto L260;
        com.bytedance.ies.bullet.service.base.d r154 = (com.bytedance.ies.bullet.service.base.d) r153.f6163b.getValue();
    L260:
        com.bytedance.ies.bullet.service.webkit.a r155 = (com.bytedance.ies.bullet.service.webkit.a) r144.e.e.getValue();
        LinkedHashMap r156 = new LinkedHashMap();
        r156.put("containerVersion", "9.0.0");
        r156.put("containerType", r212);
        j r157 = (j) r144.d().f5307v.f1119c;
        if (r157 == null) goto L263;
        r157.c();
    L263:
        j r158 = (j) r144.d().f5307v.f1119c;
        if (r158 == null) goto L267;
        LinkedHashMap r159 = r158.f5270a;
        Map r160 = r159;
        if (r159 == null) goto L267;
    L268:
        r156.putAll(r160);
        r156.putAll(r144.d().f5293c.b());
        r144.d().getClass();
        r156.put("isPreCreate", Integer.valueOf(r144.d().f5308w.f5276c ? 1 : 0));
        r156.put("isPreload", Integer.valueOf(Intrinsics.areEqual(r144.d().f5308w.f5275b, Boolean.TRUE) ? 1 : 0));
        LinkedHashMap r161 = new LinkedHashMap();
        Iterator<T> r162 = r145.getQueryParameterNames().iterator();
    L270:
        if (r162.hasNext() == false) goto L274;
        String r163 = (String) r162.next();
        String r164 = r145.getQueryParameter(r163);
        if (r164 == null) goto L270;
        r161.put(r163, r164);
        goto L270
    L274:
        r156.put("queryItems", r161);
        ad.a r165 = r144.d().f5303q;
        if (r165 == null) goto L278;
        String r166 = r165.a();
        if (r166 == null) goto L278;
    L279:
        r156.put("resolvedUrl", r166);
        r156.put("useXBridge3", Boolean.valueOf(r144.f5526i));
        Context r167 = r144.d().f5294h;
        ConcurrentHashMap r168 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(lj.a.class, "cls");
        lj.a r169 = (lj.a) yc.a.a(lj.a.class, "default_bid");
        if (r167 == null) goto L284;
        LinkedHashMap r170 = new LinkedHashMap();
        if (r169 == null) goto L285;
        r170.putAll(lj.a.a(r167, r145));
    L285:
        r156.put("bulletStorageValues", r170);
        Context r171 = r144.d().f5294h;
        Intrinsics.checkNotNullParameter(lj.a.class, "cls");
        lj.a r172 = (lj.a) yc.a.a(lj.a.class, "default_bid");
        if (r171 == null) goto L290;
        LinkedHashMap r173 = new LinkedHashMap();
        if (r172 == null) goto L291;
        r173.putAll(lj.a.b(r171, r145));
    L291:
        r156.put("userDomainStorageValues", r173);
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.prefetchv2.p.class, "cls");
        if (((com.bytedance.ies.bullet.prefetchv2.p) yc.a.a(com.bytedance.ies.bullet.prefetchv2.p.class, "default_bid")) == null) goto L308;
        Uri r174 = r144.d().A;
        if (r174 == null) goto L308;
        long r175 = System.currentTimeMillis();
        ad.a r176 = r144.d().f5303q;
        if (r176 == null) goto L298;
        String r177 = r176.a();
    L299:
        List r178 = com.bytedance.ies.bullet.prefetchv2.p.d(r174, r177, r144.d());
        if (r178.isEmpty() == true) goto L305;
        Iterator r179 = r178.iterator();
    L303:
        if (r179.hasNext() == false) goto L305;
        ((com.bytedance.ies.bullet.service.base.q) r179.next()).getClass();
    L305:
        String r180 = "Prefetch数据注入props耗时" + (System.currentTimeMillis() - r175) + " ms, uri: " + r174 + ", Props数量: " + r178.size();
        Intrinsics.checkNotNullParameter(r180, "message");
        if (r180 == null) goto L308;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XPrefetch", r180, null, 12);
        goto L308
    L298:
        r177 = null;
    L308:
        Map<String, Object> r181 = PropsUtilsKt.getDeviceProps(KitType.f6012c, r144.d().f5294h, r144.d());
        if (r181 == null) goto L311;
        r156.putAll(r181);
    L311:
        Context r182 = r144.d().f5294h;
        ConcurrentHashMap r183 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r184 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r184 == null) goto L318;
        xc.d r185 = (xc.d) r184.a(xc.d.class);
        if (r185 == null) goto L318;
        Boolean r186 = r185.L0();
        if (r186 == null) goto L318;
        boolean r187 = r186.booleanValue();
    L319:
        r156.putAll(PropsUtilsKt.getPageCommonProps(r182, r187));
        Map r188 = r144.d().f5308w.f5277h;
        if (r188 == null) goto L322;
        r156.putAll(r188);
    L322:
        r156.put("isColdStart", Boolean.valueOf(r144.f5523b));
        LinkedHashMap r189 = com.bytedance.ies.bullet.web.pia.i.f6234a;
        String r190 = r144.d().f;
        if (r190 != null) goto L325;
        String r191 = "default_bid";
    L326:
        Intrinsics.checkNotNullParameter(r191, "bid");
        Intrinsics.checkNotNullParameter(r156, "globalProps");
        com.bytedance.ies.bullet.web.pia.d r192 = (com.bytedance.ies.bullet.web.pia.d) com.bytedance.ies.bullet.web.pia.i.f6234a.get(r191);
        if (r192 == null) goto L330;
        Intrinsics.checkNotNullParameter(r156, r119);
        r192.f6224b = r156;
    L330:
        if (Intrinsics.areEqual(r144.d().f, "webcast") == false) goto L332;
        r156.put("os", "Android");
    L332:
        r144.f5529l = r156;
        r151 = r156;
        goto L333
    L325:
        r191 = r190;
    L318:
        r187 = false;
        goto L319
    L290:
        r173 = new LinkedHashMap();
        goto L291
    L284:
        r170 = new LinkedHashMap();
    L278:
        r166 = r210;
    L267:
        r160 = MapsKt.emptyMap();
    L338:
        c2.b r193 = this.g;
        if (r193 == null) goto L343;
        com.ivy.ivykit.plugin.impl.web.b r194 = (com.ivy.ivykit.plugin.impl.web.b) r193.e;
        if (r194 == null) goto L343;
        Function4 r195 = r194.b();
    L344:
        this.d.d().f5293c.E();
        if (r195 == null) goto L347;
        r195.invoke(r75, String.valueOf(this.f5569k), null, new WebKitView$loadInner$1$1(this, r75));
        return;
    L347:
        c(this.f5569k);
        String r196 = (String) new Pair(String.valueOf(this.f5569k), null).getFirst();
        this.d.getClass();
        rk.a r197 = rk.c.f21782a;
        ((rk.b) r197.get()).f21781a.push(new dn.a[0]);
        r75.loadUrl(r196);
        ((rk.b) r197.get()).f21781a.pop();
        return;
    L343:
        r195 = null;
        goto L344
    L250:
        r143 = null;
    L230:
        r104 = "webChromeClient";
    L201:
        r87 = false;
        goto L202
    L393:
        return;
    L176:
        r70 = null;
    L167:
        th = move-exception;
        Result.Companion r198 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L180
    L153:
        if (r55.f3799b.f(r60) == false) goto L155;
    L126:
        if (r137.length == 0) goto L136;
        int r199 = r137.length;     // Catch: Exception -> L134
        Object r213 = "bullet";
        int r1100 = 0;
    L129:
        if (r1100 >= r199) goto L138;
        int r214 = r199;
        r58.f3804b.put(r137[r1100], r136);     // Catch: Exception -> L132
        r1100 = r1100 + 1;     // Catch: Exception -> L132
        r199 = r214;
        r137 = r137;
    L132:
        e = e;
        r211 = r213;
    L138:
        String[] r1101 = r136.f3747a;     // Catch: Exception -> L132
        if (r1101 != null) goto L141;
    L145:
        r58.f3805c.clear();     // Catch: Exception -> L132
        r212 = r213;
        goto L150
    L141:
        if (r1101.length == 0) goto L145;
        int r1102 = r1101.length;     // Catch: Exception -> L132
        int r1103 = 0;
    L143:
        if (r1103 >= r1102) goto L145;
        r58.f3803a.put(r1101[r1103], r136);     // Catch: Exception -> L132
        r1103 = r1103 + 1;     // Catch: Exception -> L132
        r1102 = r1102;
        r1101 = r1101;
    L136:
        r213 = "bullet";
        goto L138
    L137:
        r210 = "";
    L147:
        e = e;
        r210 = "";
        goto L135
    L361:
        CookieManager.getInstance().setAcceptThirdPartyCookies(r53, true);     // Catch: Exception -> L110
    L110:
        e = move-exception;
        e.printStackTrace();
    L101:
        r50 = new com.bytedance.ies.bullet.base.settings.f();
        goto L102
    L91:
        if (r45 == CacheType.f5917b) goto L93;
        r46 = true;
    L87:
        r119 = "<set-?>";
    L27:
        r30 = "default_bid";
        goto L28
    L35:
        new ArrayList();
        Lazy r200 = com.bytedance.ies.bullet.service.sdk.d.e;
        av.i.e().getClass();
        com.bytedance.ies.bullet.service.sdk.d.b(r23, td.a.class);
        av.i.e().getClass();
        com.bytedance.ies.bullet.service.sdk.d.b(r23, td.c.class);
        tc.c r201 = tc.c.f22119c;
        tc.c r202 = tc.c.f22119c;
        List r203 = (List) r22.d().f5305t.f288c;
        if (r203 == null) goto L39;
        String r204 = (String) CollectionsKt.firstOrNull(r203);
        if (r204 == null) goto L39;
    L40:
        com.ivy.ivykit.plugin.impl.web.i r205 = (com.ivy.ivykit.plugin.impl.web.i) r202.a(com.ivy.ivykit.plugin.impl.web.i.class, r204);
        av.i.e().getClass();
        com.bytedance.ies.bullet.service.sdk.d.b(r23, td.e.class);
        com.bytedance.ies.bullet.core.e r206 = r22.d();
        rd.e r207 = new rd.e(r23);
        r206.getClass();
        Intrinsics.checkNotNullParameter(r207, "<set-?>");
        r206.g = r207;
        r22.d().g.getClass();
        r22.d().g.getClass();
        r22.d().g.getClass();
        List r208 = (List) r22.d().f5305t.f288c;
        if (r208 == null) goto L46;
        Iterator r209 = r208.iterator();
    L44:
        if (r209.hasNext() == false) goto L46;
        String r215 = (String) r209.next();
        tc.c r216 = tc.c.f22119c;
        com.ivy.ivykit.plugin.impl.web.i r217 = (com.ivy.ivykit.plugin.impl.web.i) tc.c.f22119c.a(com.ivy.ivykit.plugin.impl.web.i.class, r215);
    L46:
        r22.d().f5305t.getClass();
        r22.f5526i = sk.a.f(r22.d());
    L39:
        r204 = "default_bid";
        goto L40
    L349:
        ((com.bytedance.ies.bullet.ui.common.loader.b) r27).r(r10, new Throwable("BulletContext is not initialized"));
    }

    @Override // com.bytedance.ies.bullet.service.base.h
    public final void e() {
        SSWebView r5 = this.e;
        if (r5 == null) goto L23;
        String r10 = r5.getUrl();
        if (r10 == null) goto L19;
        com.bytedance.ies.bullet.web.scc.b r11 = this.f5570l;
        if (r11 == null) goto L19;
        Intrinsics.checkNotNullParameter(r10, "url");
        i4.a r12 = r11.f6255a;
        String r13 = StringsKt.W(r10, '#');
        ug.d r14 = (ug.d) r12.f17502b;
        r14.getClass();
        if (TextUtils.isEmpty(r13) == true) goto L19;
        String r15 = com.lynx.tasm.behavior.ui.utils.p.h(r13);
        monitor-enter(r14);
        ((ArrayList) r14.f).add(r15);     // Catch: Throwable -> L16
        monitor-exit(r14);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L19:
        r5.reload();
        return;
    }
}
