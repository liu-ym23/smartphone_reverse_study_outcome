package com.tencent.open.c;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.open.log.SLog;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class b extends WebView {
    public void a() {
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        SLog.i("openSDK_LOG.OpenWebView", "removeJSInterface");
    }

    @Override // android.webkit.WebView
    public void destroy() {
        getSettings().setBuiltInZoomControls(true);     // Catch: Exception -> L5
        getSettings().setDisplayZoomControls(false);     // Catch: Exception -> L5
        setVisibility(8);     // Catch: Exception -> L5
        SLog.i("openSDK_LOG.OpenWebView", "-->OpenWebView.destroy setBuiltInZoomControls");     // Catch: Exception -> L5
    L7:
        super.destroy();
        return;
    L5:
        e = move-exception;
        SLog.e("openSDK_LOG.OpenWebView", "-->OpenWebView.destroy setBuiltInZoomControls", e);
        goto L7
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        WebSettings r1 = getSettings();
        if (r1 != null) goto L5;
        return;
    L5:
        r1.setSavePassword(false);
        Method r2 = r1.getClass().getMethod("removeJavascriptInterface", new Class[]{String.class});     // Catch: Exception -> L10
        if (r2 == null) goto L15;
        r2.invoke(this, new Object[]{"searchBoxJavaBridge_"});     // Catch: Exception -> L10
        r2.invoke(this, new Object[]{"accessibility"});     // Catch: Exception -> L10
        r2.invoke(this, new Object[]{"accessibilityTraversal"});     // Catch: Exception -> L10
        SLog.i("openSDK_LOG.OpenWebView", "remove js interface");     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        SLog.e("openSDK_LOG.OpenWebView", "remove js interface.e:" + e.toString());
    }

    public b(Context r1) {
        super(r1);
        a();
    }
}
