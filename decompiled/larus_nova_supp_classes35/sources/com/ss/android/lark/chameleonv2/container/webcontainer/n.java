package com.ss.android.lark.chameleonv2.container.webcontainer;

import android.content.Context;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import tb5.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class n implements vv4.k {
    public final WebView a;
    public final xwb.a b;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BridgeAuthType.values().length];
            a = r0;
            r0[BridgeAuthType.Public.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[BridgeAuthType.Private.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[BridgeAuthType.Secure.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public void addWebChromeClientDelegate(WebChromeClient r1) {
    }

    public void addWebChromeClientDelegate(WebChromeClient r1, int r2) {
    }

    public void addWebViewClientDelegate(WebViewClient r1) {
    }

    public void addWebViewClientDelegate(WebViewClient r1, int r2) {
    }

    public /* synthetic */ void c(vv4.k.a r1) {
    }

    public tb5.n getBridge() {
        return null;
    }

    public /* synthetic */ void n(vv4.k.b r1) {
    }

    public /* synthetic */ void o(WebPluginHost r1) {
    }

    public /* synthetic */ void removeJSONParamInterceptor() {
    }

    public void removeWebChromeClientDelegate(WebChromeClient r1) {
    }

    public void removeWebViewClientDelegate(WebViewClient r1) {
    }

    public /* synthetic */ void w(vv4.k.a r1) {
    }

    public Context getContext() {
        return this.a.getContext().getApplicationContext();
    }

    public final String getWebViewId() {
        return String.valueOf(this.a.hashCode());
    }

    public final WebView getWebView() {
        return this.a;
    }

    public static com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType I(BridgeAuthType r1) {
        if (r1 == null) goto L15;
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L14;
        if (r2 == 2) goto L18;
        if (r2 == 3) goto L17;
        return com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType.Public;
    L17:
        return com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType.Secure;
    L18:
        return com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType.Private;
    L14:
        return com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType.Public;
    L15:
        return com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType.Public;
    }

    public final void addOnTouchListener(View.OnTouchListener r3) {
        OfficeWebView r0 = this.a;
        if ((r0 instanceof OfficeWebView) == false) goto L10;
        OfficeWebView r1 = r0;
        if (r3 == null) goto L9;
        com.ss.android.lark.officewebview.util.c r2 = r1.j;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (((ArrayList) r2.a).contains(r3) == true) goto L12;
        ((ArrayList) r2.a).add(r3);
        return;
    L12:
        return;
    L9:
        r1.getClass();
        return;
    L10:
        com.ss.android.lark.officesdk.utils.di.j.c("CML_TAG_SimpleWebV3", "addOnTouchListener", new IllegalStateException("addOnTouchListener NOT on BridgeWebView"));
    }

    public final void execJS(String r2) {
        a(r2, null, null);
    }

    public final void loadUrl(String r2) {
        this.a.loadUrl(r2);
    }

    public final void removeOnTouchListener(View.OnTouchListener r3) {
        OfficeWebView r0 = this.a;
        if ((r0 instanceof OfficeWebView) == false) goto L8;
        OfficeWebView r1 = r0;
        if (r3 == null) goto L7;
        com.ss.android.lark.officewebview.util.c r2 = r1.j;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((ArrayList) r2.a).remove(r3);
        return;
    L7:
        r1.getClass();
        return;
    L8:
        com.ss.android.lark.officesdk.utils.di.j.c("CML_TAG_SimpleWebV3", "removeOnTouchListener", new IllegalStateException("removeOnTouchListener NOT on OfficeWebView"));
    }

    public void unbindJSHandler(String r2) {
        this.b.c(r2);
    }

    public n(WebView r1, xwb.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void B(String r3, o r4) {
        this.b.b(r3, new l(r4));
    }

    public void h(String r3, tb5.i r4) {
        this.b.b(r3, new m(r4));
    }

    public final void i(String r1, tb5.g r2) {
        com.ss.android.lark.officesdk.utils.di.j.b("CML_TAG_SimpleWebV3", "bindJSHandler not support");
    }

    public final void j(String r2, JSONObject r3) {
        a(r2, r3, null);
    }

    public final void u(String r3, NonProguard r4) {
        this.b.a(r3, r4, null);
    }

    public void a(String r2, JSONObject r3, ValueCallback<String> r4) {
        this.b.a(r2, r3, r4);
    }

    public final void k(String r3, NonProguard r4, ValueCallback<String> r5) {
        WebView r0 = this.a;
        if (ap5.a.b(r0) == true) goto L7;
        r0.evaluateJavascript(swb.k.a(r3, r4), r5);
        return;
    }

    public final void l(String r3, org.json.JSONObject r4, ValueCallback<String> r5) {
        WebView r0 = this.a;
        if (ap5.a.b(r0) == true) goto L7;
        r0.evaluateJavascript(swb.k.a(r3, r4), r5);
        return;
    }
}
