package com.bytedance.android.anniex.web;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import b36.k;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.forest.model.Scene;
import com.bytedance.ies.argus.api.params.l;
import com.bytedance.ies.bullet.core.m;
import com.bytedance.ies.bullet.forest.r;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.kit.web.WebLoadError;
import com.bytedance.ies.bullet.secure.ArgusWebDelegateAdapter;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.web.pia.g;
import com.bytedance.ies.bullet.web.scc.SccDelegate;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBDXBridge;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol;
import com.google.gson.Gson;
import ib.f;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t36.j;
import v36.e;
import y36.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends c26.d {
    public boolean b;
    public final /* synthetic */ AnnieXWebKit c;
    public final /* synthetic */ f d;
    public final /* synthetic */ String e;

    public final boolean c(WebView r10, k r11) {
        if (r11 == null) goto L8;
        Uri r0 = r11.getUrl();
        if (r0 == null) goto L8;
        g r1 = this.c.d;
        if (r1 == null) goto L8;
        String r12 = r0.toString();
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL);
        r1.a.d(r12);
    L8:
        if (r11 == null) goto L17;
        Uri r13 = r11.getUrl();
        if (r13 == null) goto L17;
        String r14 = r13.toString();
        if (r14 == null) goto L17;
        SccDelegate r15 = this.c.z;
        if (r15 == null) goto L17;
        r15.b(r14);
    L17:
        if (r10 == null) goto L26;
        ArgusWebDelegateAdapter r16 = this.c.C;
        if (r16 == null) goto L21;
        Boolean r17 = Boolean.valueOf(r16.c(r10, r11));
    L23:
        if (Intrinsics.areEqual(r17, Boolean.TRUE) == false) goto L26;
        return true;
    L21:
        r17 = null;
    L26:
        super/*b36.q*/.c(r10, r11);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onLoadResource(WebView r1, String r10) {
        super/*android.webkit.WebViewClient*/.onLoadResource(r1, r10);
        if (r10 == null) goto L8;
        WebBDXBridge r11 = this.c.l;
        if (r11 == null) goto L9;
        r11.C(r10);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPageCommitVisible(WebView r1, String r10) {
        super/*android.webkit.WebViewClient*/.onPageCommitVisible(r1, r10);
        SSWebView r11 = this.c.e;
        if (r11 == null) goto L6;
        r11.setPageCommitVisibleUrl(r10);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPageFinished(WebView r10, String r11) {
        super/*android.webkit.WebViewClient*/.onPageFinished(r10, r11);
        AnnieXWebModel r0 = this.c.c;
        if (r0 == null) goto L6;
        Map<String, i36.d> r1 = MonitorManager.a;
        MonitorManager.R(r0.d);
    L6:
        if (Build.VERSION.SDK_INT > 28) goto L8;
        AnnieXWebKit.b(this.c);
    L8:
        if (r11 == null) goto L13;
        g r12 = this.c.d;
        if (r12 == null) goto L13;
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        r12.a.onLoadFinish();
    L13:
        if (this.b == false) goto L15;
    L23:
        this.b = false;
        return;
    L15:
        if (this.c.h == true) goto L23;
        f r13 = this.d;
        if (r13 == null) goto L19;
        r13.onLoadUriSuccess(r11, r10);
    L19:
        AnnieXWebKit r14 = this.c;
        if (r14.m == true) goto L22;
        AnnieXWebKit.a(r14, r14.a);
    L22:
        this.c.h = true;
        goto L23
    }

    public final boolean onRenderProcessGone(WebView r10, RenderProcessGoneDetail r11) {
        ExecutorService r0 = BulletLogger.a;
        BulletLogger.k("onRenderProcessGone: detail=" + r11, null, "XWebKit", 2);
        return super/*b36.q*/.onRenderProcessGone(r10, r11);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView r13, WebResourceRequest r14) {
        AnnieXWebKit r0 = this.c;
        AnnieXWebModel r1 = r0.c;
        WebResourceResponse r10 = null;
        if (r1 == null) goto L5;
        j r11 = r1.h;
    L6:
        Pair r12 = r.a.d(r0, r14, null, r11, 6);
        boolean r15 = ((Boolean) r12.component1()).booleanValue();
        Scene r16 = (Scene) r12.component2();
        AnnieXWebModel r17 = this.c.c;
        if (r17 == null) goto L9;
        j r18 = r17.h;
    L10:
        boolean r19 = true;
        if (com.bytedance.ies.bullet.forest.g.a.w(r18) == false) goto L14;
        if (r15 == false) goto L14;
        boolean r20 = true;
    L15:
        if (r14 == null) goto L19;
        Uri r21 = r14.getUrl();
        if (r21 == null) goto L19;
        String r22 = r21.toString();
    L20:
        if (r22 == null) goto L36;
        ArgusWebDelegateAdapter r23 = this.c.C;
        if (r23 == null) goto L36;
        l r24 = r23.h(r22, r14, r20, false);
        if (r24 == null) goto L36;
        AnnieXWebKit r25 = this.c;
        WebResourceResponse r26 = r24.b;
        if (r26 == null) goto L29;
    L37:
        if (r26 == null) goto L39;
        return r26;
    L39:
        AnnieXWebModel r27 = this.c.c;
        if (r27 == null) goto L44;
        j r28 = r27.h;
        if (r28 == null) goto L44;
        t36.f r29 = r28.d;
    L46:
        if ((r29 instanceof e) == false) goto L48;
        e r30 = (e) r29;
    L49:
        if (r30 == null) goto L58;
        i r31 = r30.u;
        if (r31 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("skipIntercept");
        r31 = null;
    L54:
        if (r31 == null) goto L58;
        Boolean r32 = (Boolean) r31.b;
        if (r32 == null) goto L58;
        boolean r33 = r32.booleanValue();
    L59:
        if (r33 == false) goto L61;
    L151:
        this.c.getClass();
        return super/*b36.q*/.shouldInterceptRequest(r13, r14);
    L61:
        if (r20 == false) goto L80;
        if (r14 == null) goto L80;
        AnnieXWebKit r34 = this.c;
        if (r16 != Scene.WEB_MAIN_DOCUMENT) goto L70;
        AnnieXWebModel r35 = r34.c;
        if (r35 == null) goto L70;
        String r36 = r35.d;
        if (r36 == null) goto L70;
        Map<String, i36.d> r110 = MonitorManager.a;
        MonitorManager.B(r36);
    L70:
        g r37 = r34.d;
        if (r37 == null) goto L80;
        WebResourceResponse r38 = r37.c(r14);
        if (r38 == null) goto L80;
        if (r14.isForMainFrame() == false) goto L79;
        AnnieXWebModel r111 = r34.c;
        if (r111 == null) goto L79;
        m r112 = r111.l.x;
        r112.getClass();
        Intrinsics.checkNotNullParameter("pia", "<set-?>");
        r112.b = "pia";
        Map<String, i36.d> r113 = MonitorManager.a;
        MonitorManager.T(r111.d, r111.l.x);
    L79:
        return r38;
    L80:
        if (r20 == false) goto L82;
        boolean r39 = true;
    L102:
        if (r39 == false) goto L126;
        if (r14 == null) goto L107;
        kb.c r40 = this.c.n;
        if (r40 == null) goto L107;
        r14.getUrl().toString();
        r40.a.getClass();
    L107:
        if (r14 == null) goto L126;
        AnnieXWebKit r41 = this.c;
        AnnieXWebModel r42 = r41.c;
        if (r42 == null) goto L126;
        com.bytedance.ies.bullet.kit.web.impl.a r43 = r41.f;
        r43.getClass();
        Intrinsics.checkNotNullParameter(r42, "annieXWebModel");
        Intrinsics.checkNotNullParameter(r14, "request");
        Uri r114 = r14.getUrl();
        if (r114 != null) goto L113;
    L115:
        boolean r115 = false;
    L116:
        if (r115 == false) goto L124;
        j r116 = r42.h;
        Pair r44 = r.a.d(r43, r14, null, r116, 6);
        boolean r45 = ((Boolean) r44.component1()).booleanValue();
        Scene r46 = (Scene) r44.component2();
        String r117 = r14.getUrl().toString();
        if (com.bytedance.ies.bullet.forest.g.a.w(r116) == false) goto L122;
        if (r45 == false) goto L122;
    L123:
        r10 = com.bytedance.ies.bullet.kit.web.impl.a.b(r43, r117, r46, r19, r42);
    L122:
        r19 = false;
    L124:
        if (r10 == null) goto L126;
        return r10;
    L113:
        if (r114.isHierarchical() != true) goto L115;
        r115 = true;
    L126:
        if (r14 == null) goto L151;
        AnnieXWebKit r47 = this.c;
        if (r20 == false) goto L130;
    L146:
        SccDelegate r48 = r47.z;
        if (r48 == null) goto L151;
        WebResourceResponse r49 = r48.c(r14.getUrl().toString());
        if (r49 == null) goto L151;
        return r49;
    L130:
        if (r16 != Scene.WEB_MAIN_DOCUMENT) goto L136;
        AnnieXWebModel r50 = r47.c;
        if (r50 == null) goto L136;
        String r51 = r50.d;
        if (r51 == null) goto L136;
        Map<String, i36.d> r52 = MonitorManager.a;
        MonitorManager.B(r51);
    L136:
        g r53 = r47.d;
        if (r53 == null) goto L146;
        WebResourceResponse r54 = r53.c(r14);
        if (r54 == null) goto L146;
        if (r14.isForMainFrame() == false) goto L145;
        AnnieXWebModel r118 = r47.c;
        if (r118 == null) goto L145;
        m r119 = r118.l.x;
        r119.getClass();
        Intrinsics.checkNotNullParameter("pia", "<set-?>");
        r119.b = "pia";
        Map<String, i36.d> r120 = MonitorManager.a;
        MonitorManager.T(r118.d, r118.l.x);
    L145:
        return r54;
    L82:
        AnnieXWebModel r55 = this.c.c;
        if (r55 == null) goto L87;
        j r56 = r55.h;
        if (r56 == null) goto L87;
        t36.f r57 = r56.d;
    L89:
        if ((r57 instanceof e) == false) goto L91;
        e r58 = (e) r57;
    L92:
        if (r58 == null) goto L101;
        i r59 = r58.i;
        if (r59 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("interceptRequest");
        r59 = null;
    L97:
        if (r59 == null) goto L101;
        Boolean r60 = (Boolean) r59.b;
        if (r60 == null) goto L101;
        r39 = r60.booleanValue();
    L101:
        r39 = false;
        goto L102
    L91:
        r58 = null;
    L87:
        r57 = null;
    L58:
        r33 = false;
        goto L59
    L48:
        r30 = null;
    L44:
        r29 = null;
        goto L46
    L29:
        if (Intrinsics.areEqual(r24.e(), Boolean.TRUE) == false) goto L36;
        SccDelegate r61 = r25.z;
        if (r61 == null) goto L35;
        r26 = r61.c(r22);
        if (r26 != null) goto L37;
    L35:
        r26 = super/*b36.q*/.shouldInterceptRequest(r13, r14);
    L36:
        r26 = null;
    L19:
        r22 = null;
    L14:
        r20 = false;
        goto L15
    L9:
        r18 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public boolean shouldOverrideUrlLoading(WebView r10, String r11) {
        if (r11 == null) goto L6;
        SccDelegate r0 = this.c.z;
        if (r0 == null) goto L6;
        r0.b(r11);
    L6:
        WebBDXBridge r1 = this.c.l;
        if (r1 == null) goto L12;
        Iterator r12 = r1.p.iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        ((WebBridgeProtocol) r12.next()).n(r11);
    L12:
        if (r10 == null) goto L22;
        ArgusWebDelegateAdapter r13 = this.c.C;
        if (r13 != null) goto L16;
    L18:
        boolean r14 = false;
    L19:
        if (r14 == false) goto L22;
        return true;
    L16:
        if (r13.d(r10, r11) != true) goto L18;
        r14 = true;
    L22:
        return super/*b36.q*/.shouldOverrideUrlLoading(r10, r11);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView r12, String r13) {
        if (r13 != null) goto L5;
    L8:
        boolean r10 = true;
    L10:
        if (r10 == true) goto L65;
        if (r13 == null) goto L28;
        ArgusWebDelegateAdapter r11 = this.c.C;
        if (r11 == null) goto L28;
        l r0 = r11.h(r13, null, false, true);
        if (r0 == null) goto L28;
        AnnieXWebKit r14 = this.c;
        WebResourceResponse r15 = r0.b;
        if (r15 == null) goto L20;
    L29:
        if (r15 == null) goto L31;
        return r15;
    L31:
        AnnieXWebModel r1 = this.c.c;
        if (r1 == null) goto L36;
        j r16 = r1.h;
        if (r16 == null) goto L36;
        t36.f r17 = r16.d;
    L38:
        if ((r17 instanceof e) == false) goto L40;
        e r18 = (e) r17;
    L41:
        if (r18 == null) goto L50;
        i r19 = r18.u;
        if (r19 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("skipIntercept");
        r19 = null;
    L46:
        if (r19 == null) goto L50;
        Boolean r20 = (Boolean) r19.b;
        if (r20 == null) goto L50;
        boolean r21 = r20.booleanValue();
    L51:
        if (r21 == true) goto L65;
        AnnieXWebKit r22 = this.c;
        AnnieXWebModel r23 = r22.c;
        if (r23 == null) goto L60;
        com.bytedance.ies.bullet.kit.web.impl.a r24 = r22.f;
        r24.getClass();
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r23, "model");
        if (UriProtector.parse(r13).isHierarchical() == true) goto L57;
        WebResourceResponse r25 = null;
    L58:
        if (r25 == null) goto L60;
        return r25;
    L57:
        j r110 = r23.h;
        Pair r26 = r.a.e(r24, r13, false, null, r110, 14);
        ((Boolean) r26.component1()).booleanValue();
        Scene r27 = (Scene) r26.component2();
        com.bytedance.ies.bullet.forest.g.a.w(r110);
        r25 = com.bytedance.ies.bullet.kit.web.impl.a.b(r24, r13, r27, false, r23);
    L60:
        SccDelegate r28 = this.c.z;
        if (r28 == null) goto L65;
        WebResourceResponse r29 = r28.c(r13);
        if (r29 == null) goto L65;
        return r29;
    L50:
        r21 = false;
        goto L51
    L40:
        r18 = null;
    L36:
        r17 = null;
        goto L38
    L20:
        if (Intrinsics.areEqual(r0.e(), Boolean.TRUE) == false) goto L28;
        SccDelegate r30 = r14.z;
        if (r30 == null) goto L26;
        r15 = r30.c(r13);
        if (r15 != null) goto L29;
    L26:
        super/*b36.q*/.shouldInterceptRequest(r12, r13);
        throw null;
    L28:
        r15 = null;
    L65:
        AnnieXWebKit r31 = this.c;
        int r32 = AnnieXWebKit.K;
        r31.getClass();
        super/*b36.q*/.shouldInterceptRequest(r12, r13);
        throw null;
    L5:
        if (r13.length() == 0) goto L8;
        r10 = false;
        goto L10
    }

    public d(AnnieXWebKit r1, f r10, String r11) {
        this.c = r1;
        this.d = r10;
        this.e = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPageStarted(WebView r10, String r11, Bitmap r12) {
        super/*android.webkit.WebViewClient*/.onPageStarted(r10, r11, r12);
        AnnieXWebModel r13 = this.c.c;
        if (r13 == null) goto L9;
        Map<String, i36.d> r1 = MonitorManager.a;
        MonitorManager.S(r13.d);
        SLMonitorCompat r14 = SLMonitorCompat.a;
        String r15 = r13.d;
        if (r11 != null) goto L7;
        String r16 = "";
    L8:
        SLMonitorCompat.s(r14, r15, null, r16, 2);
        goto L9
    L7:
        r16 = r11;
    L9:
        AnnieXWebKit r17 = this.c;
        boolean r18 = true;
        if (r10 == null) goto L16;
        r17.getClass();
        int r19 = r10.copyBackForwardList().getCurrentIndex();
        if (r19 <= r17.v) goto L14;
        r17.w++;
    L15:
        r17.v = r19;
        goto L16
    L14:
        r17.w--;
    L16:
        AnnieXWebModel r20 = r17.c;
        if (r20 == null) goto L36;
        j r21 = r20.h;
        if (r21 == null) goto L36;
        t36.d r22 = r21.a;
        if (r22 == null) goto L36;
        if (Intrinsics.areEqual(((i) new y36.a(r22, "show_closeall", Boolean.valueOf(h.h0(r22)))).b, Boolean.TRUE) == false) goto L36;
        m16.b r23 = r17.D;
        if ((r23 instanceof m16.b) == true) goto L28;
        r23 = null;
    L28:
        if (r23 == null) goto L36;
        ia.h r24 = (ia.h) r23.c(ia.h.class);
        if (r24 == null) goto L36;
        if (r17.w != 0) goto L35;
        r18 = false;
    L35:
        r24.k(r18);
    L36:
        f r25 = this.d;
        if ((r25 instanceof f.a) == false) goto L39;
        f.a r26 = (f.a) r25;
    L40:
        if (r26 == null) goto L42;
        r26.a(String.valueOf(this.c.u), this.c.e);
    L42:
        SSWebView r27 = this.c.e;
        if (r27 == null) goto L45;
        r27.setPageStartUrl(r11);
    L45:
        AnnieXWebKit.b(this.c);
        if (r11 == null) goto L50;
        g r28 = this.c.d;
        if (r28 == null) goto L50;
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        r28.a.onLoadStart();
    L50:
        if (r11 == null) goto L60;
        AnnieXWebKit r29 = this.c;
        f r30 = this.d;
        SccDelegate r31 = r29.z;
        if (r31 == null) goto L60;
        SccConfig.SccLevel r32 = r31.d(r11);
        if (r32 == null) goto L60;
        r29.A = r32;
        if (r32 == SccConfig.SccLevel.SAFE) goto L60;
        if (r30 == null) goto L60;
        r30.onLoadFail(r11, r29.e, new WebLoadError(403, "scc check failed", r11));
    L60:
        if (Intrinsics.areEqual(this.c.a, "webcast") == true) goto L62;
        return;
    L62:
        if (this.c.C == null) goto L64;
        int r33 = ArgusWebDelegateAdapter.h;
        Intrinsics.checkNotNullParameter("AnnieXWebKit", "enterFrom");
        h.R();
    L64:
        Gson r34 = new Gson();
        AnnieXWebModel r35 = this.c.c;
        if (r35 == null) goto L67;
        Map<String, Object> r36 = r35.g;
    L68:
        String r37 = "window.__globalProps=" + GsonProtectorUtils.toJson(r34, r36) + ';';
        if (r10 == null) goto L73;
        r10.evaluateJavascript(r37, null);
        return;
    L73:
        return;
    L67:
        r36 = null;
        goto L68
    L39:
        r26 = null;
        goto L40
    }

    public final void onReceivedError(WebView r10, WebResourceRequest r11, WebResourceError r12) {
        boolean r0 = true;
        int r1 = 0;
        if (r11 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == false) goto L10;
        AnnieXWebKit r14 = this.c;
        int r15 = AnnieXWebKit.K;
        r14.getClass();
        this.b = true;
    L10:
        super/*b36.q*/.onReceivedError(r10, r11, r12);
        if (r11 != null) goto L13;
    L15:
        r0 = false;
    L16:
        if (r0 == false) goto L37;
        AnnieXWebKit r16 = this.c;
        AnnieXWebModel r17 = r16.c;
        String r18 = null;
        if (r17 == null) goto L24;
        Map<String, i36.d> r19 = MonitorManager.a;
        String r20 = r17.a;
        String r21 = r17.d;
        AbsBulletMonitorCallback.ErrStage r22 = AbsBulletMonitorCallback.ErrStage.Engine;
        if (r12 == null) goto L22;
        CharSequence r23 = r12.getDescription();
    L23:
        MonitorManager.o(r20, r21, r22, String.valueOf(r23), r16.e);
        goto L24
    L22:
        r23 = null;
    L24:
        f r24 = this.d;
        if (r24 == null) goto L38;
        String r25 = this.e;
        SSWebView r26 = this.c.e;
        if (r12 == null) goto L29;
        r1 = r12.getErrorCode();
    L29:
        if (r12 == null) goto L31;
        CharSequence r27 = r12.getDescription();
    L32:
        Uri r28 = r11.getUrl();
        if (r28 == null) goto L35;
        r18 = r28.toString();
    L35:
        r24.onLoadFail(r25, r26, new WebLoadError(r1, r27, r18));
        return;
    L31:
        r27 = null;
        goto L32
    L38:
        return;
    L37:
        return;
    L13:
        if (r11.isForMainFrame() != true) goto L15;
    L5:
        if (r11.isForMainFrame() != true) goto L7;
        r13 = true;
        goto L8
    }

    public final void onReceivedHttpError(WebView r10, WebResourceRequest r11, WebResourceResponse r12) {
        super/*b36.q*/.onReceivedHttpError(r10, r11, r12);
        if (r11 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L40;
        String r13 = null;
        if (r12 == null) goto L12;
        Integer r14 = Integer.valueOf(r12.getStatusCode());
    L14:
        if (h.A0(r14) == true) goto L41;
        this.b = true;
        if (r10 == null) goto L42;
        String r15 = r10.getUrl();
        if (r15 == null) goto L43;
        Uri r16 = r11.getUrl();
        if (r16 == null) goto L22;
        String r17 = r16.toString();
    L24:
        if (Intrinsics.areEqual(r15, r17) == true) goto L27;
        r15 = null;
    L27:
        if (r15 == null) goto L44;
        AnnieXWebKit r18 = this.c;
        f r0 = this.d;
        String r19 = this.e;
        if (r12 == null) goto L31;
        int r20 = r12.getStatusCode();
    L32:
        if (r12 == null) goto L34;
        r13 = r12.getReasonPhrase();
    L34:
        WebLoadError r21 = new WebLoadError(r20, r13, r15);
        AnnieXWebModel r22 = r18.c;
        if (r22 == null) goto L37;
        Map<String, i36.d> r23 = MonitorManager.a;
        MonitorManager.o(r22.a, r22.d, AbsBulletMonitorCallback.ErrStage.Engine, r21.toString(), r18.e);
    L37:
        if (r0 == null) goto L45;
        r0.onLoadFail(r19, r18.e, r21);
        return;
    L45:
        return;
    L31:
        r20 = 404;
        goto L32
    L44:
        return;
    L22:
        r17 = null;
        goto L24
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L12:
        r14 = null;
        goto L14
    L40:
        return;
    L5:
        if (r11.isForMainFrame() != true) goto L7;
        r1 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onReceivedSslError(WebView r10, SslErrorHandler r11, SslError r12) {
        boolean r0 = true;
        this.b = true;
        super/*android.webkit.WebViewClient*/.onReceivedSslError(r10, r11, r12);
        String r13 = null;
        if (r12 == null) goto L5;
        String r1 = r12.getUrl();
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        Uri r14 = UriProtector.parse(r1);
        if (r14 == null) goto L13;
        String r15 = r14.getPath();
        if (r15 == null) goto L13;
        r0 = StringsKt.contains$default(r15, ".html", false, 2, null);
    L13:
        if (r0 == false) goto L24;
        if (r10 == null) goto L25;
        String r16 = r10.getUrl();
        if (r16 == null) goto L26;
        f r17 = this.d;
        String r18 = this.e;
        AnnieXWebKit r19 = this.c;
        if (r17 == null) goto L27;
        SSWebView r20 = r19.e;
        if (r12 == null) goto L22;
        r13 = r12.toString();
    L22:
        r17.onLoadFail(r18, r20, new WebLoadError(-100, r13, r16));
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onReceivedError(WebView r10, int r11, String r12, String r13) {
        AnnieXWebKit r0 = this.c;
        int r1 = AnnieXWebKit.K;
        r0.getClass();
        this.b = true;
        super/*android.webkit.WebViewClient*/.onReceivedError(r10, r11, r12, r13);
        if (Build.VERSION.SDK_INT < 23) goto L5;
        return;
    L5:
        AnnieXWebKit r14 = this.c;
        AnnieXWebModel r15 = r14.c;
        if (r15 == null) goto L12;
        Map<String, i36.d> r16 = MonitorManager.a;
        String r17 = r15.a;
        String r18 = r15.d;
        AbsBulletMonitorCallback.ErrStage r19 = AbsBulletMonitorCallback.ErrStage.Engine;
        if (r12 != null) goto L10;
        String r20 = "";
    L11:
        MonitorManager.o(r17, r18, r19, r20, r14.e);
        goto L12
    L10:
        r20 = r12;
    L12:
        f r21 = this.d;
        if (r21 == null) goto L16;
        r21.onLoadFail(r13, this.c.e, new WebLoadError(r11, r12, r13));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onReceivedHttpAuthRequest(WebView r1, HttpAuthHandler r10, String r11, String r12) {
        super/*android.webkit.WebViewClient*/.onReceivedHttpAuthRequest(r1, r10, r11, r12);
    }
}
