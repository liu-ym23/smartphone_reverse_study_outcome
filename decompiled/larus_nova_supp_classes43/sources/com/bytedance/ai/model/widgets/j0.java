package com.bytedance.ai.model.widgets;

import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.ai.applet.render.core.web.WebViewAIBridgePort;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.method.ui.AIBridgeSetTitleMethod;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j0 extends ix7.d.a {
    public final /* synthetic */ WebEngineAssem a;

    public static final class a extends d3.a0 {
        public final String a;
        public final String b;
        public final ContainerType c;
        public final String d;
        public final String e;

        @Override // d3.a0
        public final String getAppId() {
            return this.b;
        }

        @Override // d3.a0
        public final String getAppletId() {
            return this.a;
        }

        @Override // d3.a0
        public final String getContainerId() {
            return this.d;
        }

        @Override // d3.a0
        public final ContainerType getContainerType() {
            return this.c;
        }

        @Override // d3.a0
        public final String getUrl() {
            return this.e;
        }

        public a(k2.j r10, WebEngineAssem r11) {
            this.a = r10.getAppletId();
            this.b = r10.getAppletId();
            this.c = ContainerType.PAGE;
            this.d = r10.getPageID();
            int r12 = WebEngineAssem.C;
            k2.b r13 = r11.t();
            if (r13 == null) goto L5;
            String r14 = r13.b;
        L6:
            this.e = r14;
            return;
        L5:
            r14 = null;
            goto L6
        }
    }

    public final void f() {
        d3.w r0 = this.a.A;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    public j0(WebEngineAssem r1) {
        this.a = r1;
    }

    public final void d(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r10, "view");
        if ((r10 instanceof WebView) == true) goto L6;
        r10 = null;
    L6:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.webkit.WebView");
        WebView r11 = (WebView) r10;
        WebEngineAssem r0 = this.a;
        int r12 = WebEngineAssem.C;
        k2.b r13 = r0.t();
        if (r13 == null) goto L9;
        String r14 = r13.b;
    L10:
        boolean r15 = StringsKt.equals(UriProtector.parse(r14).getScheme(), "file", true);
        k2.b r16 = r0.t();
        if (r16 == null) goto L13;
        String r17 = r16.b;
    L14:
        boolean r18 = StringsKt.equals(UriProtector.parse(r17).getScheme(), "content", true);
        r0.n = r11;
        if (r0.q == false) goto L17;
        r11.setNestedScrollingEnabled(true);
    L17:
        k2.b r19 = r0.t();
        if (r19 == null) goto L24;
        k2.j r20 = r19.n;
        if (r20 == null) goto L24;
        WebView r21 = r0.n;
        if (r21 == null) goto L24;
        r21.setTag(2131363149, new WeakReference(r20));
    L24:
        com.bytedance.ai.utils.g.a.i("WebViewAssem", "bindingWebView " + r11);
        boolean r22 = false;
        if (r11 == null) goto L34;
        r11.getSettings().setJavaScriptEnabled(true);
        r11.getSettings().setDisplayZoomControls(false);
        r11.getSettings().setBuiltInZoomControls(false);
        k2.b r23 = r0.t();
        if (r23 == null) goto L31;
        k2.j r24 = r23.n;
        if (r24 == null) goto L31;
        r0.p = new com.bytedance.ai.model.o0(r24);
    L31:
        com.bytedance.ai.model.o0 r25 = r0.p;
        if (r25 == null) goto L34;
        r11.addJavascriptInterface(r25, "AppletJSBridge");
    L34:
        r11.getSettings().setAllowFileAccess(true);
        WebSettings r26 = r11.getSettings();
        if (r15 == true) goto L38;
        if (r18 == true) goto L38;
        boolean r27 = true;
    L39:
        r26.setJavaScriptEnabled(r27);
        WebSettings r28 = r11.getSettings();
        k2.b r29 = r0.t();
        if (r29 == null) goto L42;
        String r30 = r29.b;
    L44:
        if (r30 == null) goto L63;
        Uri r31 = UriProtector.parse(r30);
        if (r31 == null) goto L63;
        String r32 = r31.getHost();
        if (r32 == null) goto L63;
        k2.b r33 = r0.t();
        if (r33 == null) goto L63;
        Callable<List<String>> r34 = r33.j;
        if (r34 == null) goto L63;
        List<String> r35 = r34.call();
        if (r35 == null) goto L63;
        Iterator<T> r36 = r35.iterator();
    L59:
        if (r36.hasNext() == false) goto L63;
        if (StringsKt.contains$default(r32, (String) r36.next(), false, 2, null) == false) goto L59;
        boolean r37 = true;
    L64:
        r28.setDomStorageEnabled(r37);
        r11.getSettings().setMixedContentMode(2);
        WebSettings r38 = r11.getSettings();
        h2.a r39 = f2.b.c;
        if (r39 == null) goto L67;
        int r40 = r39.t;
    L68:
        r38.setTextZoom(r40);
        k2.b r41 = r0.t();
        if (r41 != null) goto L71;
    L73:
        if (r22 == false) goto L75;
        r11.setOverScrollMode(2);
    L75:
        int r42 = Build.VERSION.SDK_INT;
        if (r42 != 24) goto L78;
    L81:
        r11.setLayerType(1, null);
    L82:
        WebViewAIBridgePort.Companion.getClass();
        r0.B = WebViewAIBridgePort.a.a(r11);
        k2.b r110 = r0.t();
        if (r110 == null) goto L114;
        final k2.j r111 = r110.n;
        if (r111 == null) goto L114;
        d3.w r1 = new d3.w();
        r0.A = r1;
        r1.d(new q4.a());
        WebView r43 = r0.n;
        if (r43 == null) goto L91;
        d3.w r44 = r0.A;
        if (r44 == null) goto L91;
        r44.j(r43);
    L91:
        d3.w r45 = r0.A;
        if (r45 == null) goto L96;
        e3.a r46 = r45.i;
        if (r46 == null) goto L96;
        r46.e(d3.a0.class, new a(r111, r0));
    L96:
        d3.w r47 = r0.A;
        if (r47 == null) goto L101;
        e3.a r48 = r47.i;
        if (r48 == null) goto L101;
        e3.d.a.a(r48, AppletRuntime.class, r111.getAppletRuntime());
    L101:
        d3.w r49 = r0.A;
        if (r49 == null) goto L106;
        e3.a r50 = r49.i;
        if (r50 == null) goto L106;
        e3.d.a.a(r50, k2.j.class, r111);
    L106:
        d3.w r51 = r0.A;
        if (r51 == null) goto L111;
        e3.a r52 = r51.i;
        if (r52 == null) goto L111;
        r52.e(d3.z.class, new i0(r111));
    L111:
        d3.w r112 = r0.A;
        if (r112 == null) goto L114;
        Intrinsics.checkNotNullParameter(AIBridgeSetTitleMethod.class, "clazz");
        r112.b.b(AIBridgeSetTitleMethod.class);
    L114:
        WebViewAIBridgePort r113 = r0.B;
        if (r113 == null) goto L123;
        d3.w r53 = r0.A;
        if (r53 == null) goto L124;
        r53.k(r113);
        return;
    L124:
        return;
    L123:
        return;
    L78:
        if (r42 == 25) goto L81;
        r11.setLayerType(2, null);
        goto L82
    L71:
        if (r41.l != true) goto L73;
        r22 = true;
        goto L73
    L67:
        r40 = 100;
    L63:
        r37 = false;
        goto L64
    L42:
        r30 = null;
    L38:
        r27 = false;
        goto L39
    L13:
        r17 = null;
        goto L14
    L9:
        r14 = null;
        goto L10
    }
}
