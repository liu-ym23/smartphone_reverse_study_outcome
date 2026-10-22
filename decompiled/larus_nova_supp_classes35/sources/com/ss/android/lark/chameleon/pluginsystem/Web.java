package com.ss.android.lark.chameleon.pluginsystem;

import android.content.Context;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.bridge.BridgeHandler;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.IBridge;
import com.ss.android.lark.chameleon.bridge.JSHandler;
import com.ss.android.lark.chameleon.bridge.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface Web {
    public static final int DEFAULT_PRIORITY = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.pluginsystem.Web$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$addJSONParamInterceptor(Web r0, JSONParamInterceptor r1) {
        }

        public static String $default$getWebViewId(Web r0) {
            return BuildConfig.FLAVOR;
        }

        public static void $default$removeJSONParamInterceptor(Web r0) {
        }
    }

    public interface JSONParamInterceptor {
        boolean enableAddJsonExtraParam();

        String getInterceptFuncName();

        JsonObject getInterceptJSONObject();
    }

    void addJSONParamInterceptor(JSONParamInterceptor r1);

    void addOnTouchListener(View.OnTouchListener r1);

    void addWebChromeClientDelegate(WebChromeClient r1);

    void addWebChromeClientDelegate(WebChromeClient r1, int r2);

    void addWebViewClientDelegate(WebViewClient r1);

    void addWebViewClientDelegate(WebViewClient r1, int r2);

    void bindJSHandler(String r1, BridgeHandler r2);

    void bindJSHandler(String r1, BridgeHandlerV2 r2);

    void bindJSHandler(String r1, JSHandler r2);

    void execJS(String r1);

    void execJS(String r1, JsonObject r2);

    void execJS(String r1, JsonObject r2, ValueCallback<String> r3);

    void execJS(String r1, NonProguard r2);

    void execJS(String r1, NonProguard r2, ValueCallback<String> r3);

    IBridge getBridge();

    Context getContext();

    WebView getWebView();

    String getWebViewId();

    void loadUrl(String r1);

    void removeJSONParamInterceptor();

    void removeOnTouchListener(View.OnTouchListener r1);

    void removeWebChromeClientDelegate(WebChromeClient r1);

    void removeWebViewClientDelegate(WebViewClient r1);

    void unbindJSHandler(String r1);
}
