package com.ss.android.lark.chameleon.basewebview.client;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.lark.chameleon.basewebview.interfaces.ILarkWebViewContext;
import com.ss.android.lark.chameleon.idependency.Log;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class LarkBaseWebChromeClient extends WebChromeClient {
    private static final String TAG = "LarkBaseWebChromeClient";
    private WebChromeClient mClient;
    private ILarkWebViewContext mContext;

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        if (this.mClient == null) goto L6;
        Log.i(TAG, "getVideoLoadingProgressView");
        return this.mClient.getVideoLoadingProgressView();
    L6:
        Log.i(TAG, "getVideoLoadingProgressView");
        return super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        Log.i(TAG, "onGeolocationPermissionsHidePrompt");
        super.onGeolocationPermissionsHidePrompt();
        if (this.mClient == null) goto L6;
        Log.i(TAG, "onGeolocationPermissionsHidePrompt mClient");
        this.mClient.onGeolocationPermissionsHidePrompt();
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        Log.i(TAG, "onHideCustomView");
        super.onHideCustomView();
        WebChromeClient r0 = this.mClient;
        if (r0 == null) goto L6;
        r0.onHideCustomView();
        return;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        WebChromeClient r0 = this.mClient;
        if (r0 == null) goto L7;
        return r0.onJsTimeout();
    L7:
        return super.onJsTimeout();
    }

    public LarkBaseWebChromeClient(ILarkWebViewContext r1) {
        this.mContext = r1;
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> r3) {
        Log.i(TAG, "getVisitedHistory");
        super.getVisitedHistory(r3);
        WebChromeClient r0 = this.mClient;
        if (r0 == null) goto L6;
        r0.getVisitedHistory(r3);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView r3) {
        Log.i(TAG, "onCloseWindow");
        super.onCloseWindow(r3);
        WebChromeClient r0 = this.mClient;
        if (r0 == null) goto L6;
        r0.onCloseWindow(r3);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage r2) {
        WebChromeClient r0 = this.mClient;
        if (r0 == null) goto L7;
        return r0.onConsoleMessage(r2);
    L7:
        return super.onConsoleMessage(r2);
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest r3) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "onPermissionRequest mClient");
        this.mClient.onPermissionRequest(r3);
        return;
    L5:
        Log.i(TAG, "onPermissionRequest default");
        super.onPermissionRequest(r3);
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(PermissionRequest r3) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "onPermissionRequestCanceled mClient");
        this.mClient.onPermissionRequestCanceled(r3);
        return;
    L5:
        Log.i(TAG, "onPermissionRequestCanceled default");
        super.onPermissionRequestCanceled(r3);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView r2) {
        super.onRequestFocus(r2);
        WebChromeClient r0 = this.mClient;
        if (r0 == null) goto L6;
        r0.onRequestFocus(r2);
        return;
    }

    public void setWebChromeClient(WebChromeClient r3) {
        Log.i(TAG, "Caller setWebChromeClient");
        this.mClient = r3;
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String r22, GeolocationPermissions.Callback r23) {
        ArrayList r11 = new ArrayList();
        Object[] r12 = {r22, r23};
        b r14 = new b();
        a r0 = (a) ApiHookConfig.b.get(100003);
        if (r0 == null) goto L5;
        f06.a[] r1 = r0.i;
    L6:
        f06.a[] r7 = r1;
        int r6 = r7.length;
        int r5 = 0;
    L8:
        if (r5 >= r6) goto L15;
        f06.a r4 = r7[r5];
        int r18 = r5;
        int r19 = r6;
        f06.a[] r20 = r7;
        d r2 = r4.preInvoke(100003, "com/ss/android/lark/chameleon/basewebview/client/LarkBaseWebChromeClient", "onGeolocationPermissionsShowPrompt", this, r12, "void", r14);     // Catch: Exception -> L23
        if (r2.a == true) goto L17;
        r11.add(r4);     // Catch: Exception -> L23
    L17:
        if (r2.a == false) goto L19;
        return;
    L19:
        Log.i(TAG, "onGeolocationPermissionsShowPrompt");
        super.onGeolocationPermissionsShowPrompt(r22, r23);
        if (this.mClient == null) goto L29;
        Log.i(TAG, "onGeolocationPermissionsShowPrompt default");
        this.mClient.onGeolocationPermissionsShowPrompt(r22, r23);
        return;
    L29:
        return;
    L14:
        r5 = r18 + 1;
        r6 = r19;
        r7 = r20;
        goto L8
    L15:
        r2 = new d(false, null);
        goto L17
    L5:
        r1 = ApiHookConfig.d;
        goto L6
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView r3, int r4) {
        Log.i(TAG, "onProgressChanged " + r4);
        super.onProgressChanged(r3, r4);
        WebChromeClient r0 = this.mClient;
        if (r0 == null) goto L6;
        r0.onProgressChanged(r3, r4);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView r3, Bitmap r4) {
        Log.i(TAG, "onReceiveIcon");
        super.onReceivedIcon(r3, r4);
        WebChromeClient r0 = this.mClient;
        if (r0 == null) goto L6;
        r0.onReceivedIcon(r3, r4);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView r3, String r4) {
        Log.i(TAG, "onReceivedTitle");
        super.onReceivedTitle(r3, r4);
        WebChromeClient r0 = this.mClient;
        if (r0 == null) goto L6;
        r0.onReceivedTitle(r3, r4);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View r3, WebChromeClient.CustomViewCallback r4) {
        Log.i(TAG, "onShowCustomView");
        super.onShowCustomView(r3, r4);
        WebChromeClient r0 = this.mClient;
        if (r0 == null) goto L6;
        r0.onShowCustomView(r3, r4);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String r2, int r3, String r4) {
        super.onConsoleMessage(r2, r3, r4);
        WebChromeClient r0 = this.mClient;
        if (r0 == null) goto L6;
        r0.onConsoleMessage(r2, r3, r4);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView r3, String r4, boolean r5) {
        Log.i(TAG, "onReceivedTouchIconUrl , precomposed = " + r5);
        WebChromeClient r0 = this.mClient;
        if (r0 == null) goto L5;
        r0.onReceivedTouchIconUrl(r3, r4, r5);
    L5:
        super.onReceivedTouchIconUrl(r3, r4, r5);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View r2, int r3, WebChromeClient.CustomViewCallback r4) {
        super.onShowCustomView(r2, r3, r4);
        WebChromeClient r0 = this.mClient;
        if (r0 == null) goto L6;
        r0.onShowCustomView(r2, r3, r4);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView r3, boolean r4, boolean r5, Message r6) {
        if (this.mClient == null) goto L6;
        Log.i(TAG, "onCreateWindow mClient");
        return this.mClient.onCreateWindow(r3, r4, r5, r6);
    L6:
        Log.i(TAG, "onCreateWindow default");
        return super.onCreateWindow(r3, r4, r5, r6);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView r3, String r4, String r5, JsResult r6) {
        if (this.mClient == null) goto L6;
        Log.i(TAG, "onJsAlert mClient");
        return this.mClient.onJsAlert(r3, r4, r5, r6);
    L6:
        Log.i(TAG, "onJsAlert default");
        return super.onJsAlert(r3, r4, r5, r6);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView r3, String r4, String r5, JsResult r6) {
        if (this.mClient == null) goto L6;
        Log.i(TAG, "onJsBeforeUnload mClient");
        return this.mClient.onJsBeforeUnload(r3, r4, r5, r6);
    L6:
        Log.i(TAG, "onJsBeforeUnload default");
        return super.onJsBeforeUnload(r3, r4, r5, r6);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView r3, String r4, String r5, JsResult r6) {
        if (this.mClient == null) goto L6;
        Log.i(TAG, "onJsConfirm mClient");
        return this.mClient.onJsConfirm(r3, r4, r5, r6);
    L6:
        Log.i(TAG, "onJsConfirm default");
        return super.onJsConfirm(r3, r4, r5, r6);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView r9, String r10, String r11, String r12, JsPromptResult r13) {
        if (this.mClient == null) goto L6;
        Log.i(TAG, "onJsPrompt mClient");
        return this.mClient.onJsPrompt(r9, r10, r11, r12, r13);
    L6:
        Log.i(TAG, "onJsPrompt default");
        return super.onJsPrompt(r9, r10, r11, r12, r13);
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String r1, String r2, long r3, long r5, long r7, WebStorage.QuotaUpdater r9) {
        super.onExceededDatabaseQuota(r1, r2, r3, r5, r7, r9);
    }
}
