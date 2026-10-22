package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.content.Context;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.basewebview.BridgeWebViewV2;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.chameleon.bridge.BridgeHandler;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.bridge.IBridge;
import com.ss.android.lark.chameleon.bridge.JSHandler;
import com.ss.android.lark.chameleon.bridge.JsCallBack;
import com.ss.android.lark.chameleon.bridge.NonProguard;
import com.ss.android.lark.chameleon.pluginsystem.Web;
import com.ss.android.lark.chameleon.util.SafeJSExecutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class SimpleWebV2 implements Web {
    private static final String BIZ_EXCE_JS = "biz.execJS";
    private static final String TAG = "SimpleWebV2";
    private final Bridge bridge;
    private final WebView webView;

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public final /* synthetic */ void addJSONParamInterceptor(Web.JSONParamInterceptor r1) {
        Web.CC.$default$addJSONParamInterceptor(this, r1);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void addOnTouchListener(View.OnTouchListener r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void addWebChromeClientDelegate(WebChromeClient r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void addWebChromeClientDelegate(WebChromeClient r1, int r2) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void addWebViewClientDelegate(WebViewClient r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void addWebViewClientDelegate(WebViewClient r1, int r2) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void bindJSHandler(String r1, BridgeHandler r2) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public IBridge getBridge() {
        return null;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public final /* synthetic */ String getWebViewId() {
        return Web.CC.$default$getWebViewId(this);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public final /* synthetic */ void removeJSONParamInterceptor() {
        Web.CC.$default$removeJSONParamInterceptor(this);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void removeOnTouchListener(View.OnTouchListener r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void removeWebChromeClientDelegate(WebChromeClient r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void removeWebViewClientDelegate(WebViewClient r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public Context getContext() {
        return this.webView.getContext().getApplicationContext();
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public WebView getWebView() {
        return this.webView;
    }

    public static CallBackFunction newToOldCallback(final JsCallBack r1) {
        return new AnonymousClass1(r1);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void execJS(String r2) {
        execJS(r2, null);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void loadUrl(String r2) {
        this.webView.loadUrl(r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void unbindJSHandler(String r2) {
        this.bridge.unRegisterHandler(r2);
    }

    public SimpleWebV2(WebView r1, Bridge r2) {
        this.webView = r1;
        this.bridge = r2;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void bindJSHandler(String r2, BridgeHandlerV2 r3) {
        this.bridge.registerHandler(r2, BridgeWebViewV2.oldToNewHandler(r3));
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void execJS(String r3, NonProguard r4) {
        this.bridge.callJSFun(r3, r4, null);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void bindJSHandler(String r2, JSHandler r3) {
        this.bridge.registerHandler(r2, BridgeWebViewV2.oldToNewHandler(r3));
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void execJS(String r2, JsonObject r3) {
        execJS(r2, r3, null);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void execJS(String r2, JsonObject r3, ValueCallback<String> r4) {
        this.bridge.callJSFun(r2, r3.toString(), r4);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.Web
    public void execJS(String r2, NonProguard r3, ValueCallback<String> r4) {
        SafeJSExecutor.execJS(this.webView, r2, r3, r4);
    }
}
