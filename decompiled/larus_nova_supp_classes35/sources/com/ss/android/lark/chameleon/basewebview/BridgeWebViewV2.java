package com.ss.android.lark.chameleon.basewebview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.chameleon.bridge.BridgeHandler;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.bridge.JSHandler;
import com.ss.android.lark.chameleon.bridge.JsCallBack;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.JsonUtils;
import com.ss.android.lark.chameleon.util.SafeJSExecutor;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class BridgeWebViewV2 extends LarkWebView {
    private static final String TAG = "BridgeWebViewV2";
    public static boolean shandlerRunOnUIThread;
    private Bridge mBridge;

    public String callSync(String r1) throws Exception {
        return "null";
    }

    public void clearAllHandlers() {
        this.mBridge.clearAllHandler();
    }

    private void init() {
        this.mBridge = getBridge();
    }

    @Override // com.ss.android.lark.chameleon.basewebview.BaseWebView, android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resumeTimers();
    }

    public BridgeWebViewV2(Context r1) {
        super(r1);
        init();
    }

    public static CallBackFunction newToOldCallback(final JsCallBack r1) {
        return new AnonymousClass3(r1);
    }

    public static <T> BridgeHandler<String, LarkWebView> oldToNewHandler(final BridgeHandlerV2 r1) {
        return new AnonymousClass2(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r1) {
        return super.dispatchTouchEvent(r1);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.LarkWebView, com.ss.android.lark.chameleon.basewebview.BaseWebView, android.webkit.WebView
    public void loadUrl(String r2) {
        loadUrl(r2, false);
    }

    public void unregisterHandler(String r2) {
        this.mBridge.unRegisterHandler(r2);
    }

    public static <T> BridgeHandler<String, LarkWebView> oldToNewHandler(final JSHandler r1) {
        return new AnonymousClass1(r1);
    }

    public BridgeWebViewV2(Context r1, AttributeSet r2) {
        super(r1, r2);
        init();
    }

    public void callJsFunction(String r2, JsonObject r3) {
        callJsFunction(r2, r3, false);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.LarkWebView, com.ss.android.lark.chameleon.basewebview.BaseWebView, android.webkit.WebView
    public void loadUrl(String r2, Map<String, String> r3) {
        if (r3 != null) goto L13;
    L7:
        loadUrl(r2);     // Catch: Throwable -> L9
    L12:
        return;
    L9:
        th = move-exception;
        Log.e(TAG, "loadUrl additionalHttpHeaders e = " + th);
        return;
    L13:
        if (r3.isEmpty() == true) goto L7;
        super.loadUrl(r2, r3);     // Catch: Throwable -> L9
        goto L12
    }

    public <T> void registerHandler(String r2, BridgeHandlerV2<T> r3) {
        this.mBridge.registerHandler(r2, oldToNewHandler(r3));
    }

    public void loadUrl(String r2, boolean r3) {
        if (r3 == true) goto L4;
        super.loadUrl(r2);     // Catch: Throwable -> L7
    L10:
        return;
    L4:
        evaluateJavascript(r2, null);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        Log.e(TAG, "loadUrl e = " + th);
    }

    public <T> void registerHandler(String r2, JSHandler<T> r3) {
        this.mBridge.registerHandler(r2, oldToNewHandler(r3));
    }

    public void callJsFunction(String r1, JsonObject r2, boolean r3) {
        if (r3 == true) goto L4;
        super.loadUrl(JsonUtils.INSTANCE.combineRequestContent(r1, r2));     // Catch: Throwable -> L7
    L10:
        return;
    L4:
        SafeJSExecutor.execJS(this, r1, r2, null);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        Log.e(TAG, "loadUrl e = " + th);
    }
}
