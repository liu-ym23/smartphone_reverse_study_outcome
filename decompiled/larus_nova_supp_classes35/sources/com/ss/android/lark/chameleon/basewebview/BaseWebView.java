package com.ss.android.lark.chameleon.basewebview;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient;
import com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient;
import com.ss.android.lark.chameleon.basewebview.config.LarkWebViewConfig;
import com.ss.android.lark.chameleon.basewebview.config.PerformanceConfig;
import com.ss.android.lark.chameleon.basewebview.config.WebSettingConfig;
import com.ss.android.lark.chameleon.basewebview.interfaces.ILarkWebViewClientCompat;
import com.ss.android.lark.chameleon.basewebview.interfaces.ILarkWebViewContext;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.AppInfoUtils;
import com.ss.android.lark.chameleon.util.DarkModeContextExtension;
import com.ss.android.lark.chameleon.util.RomUtils;
import com.ss.android.lark.chameleon.util.UIExecutor;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class BaseWebView extends WebView implements ILarkWebViewContext {
    private static final String FG_KEY_DISABLE_SUBTHREAD_DRAW_IN_HUAWEI = "openplatform.web.disable.huawei.subThread.draw";
    private static final String HEADER_ACCEPT_LANGUAGE = "Accept-Language";
    private static final String PERFORMANCE_CMD = "ttwebview:/*enableTTLogEvent*/;";
    private static final String TAG = "BaseWebView";
    private LarkBaseWebChromeClient mBaseWebChromeClient;
    private LarkBaseWebViewClient mBaseWebViewClient;
    private LarkWebViewConfig mConfig;
    private boolean mIsOpenFromMultiWindow;

    public static /* synthetic */ void a(BaseWebView r0, String r1, String r2, String r3) {
        r0.lambda$loadData$3(r1, r2, r3);
    }

    public static /* synthetic */ void b(BaseWebView r0, String r1, Map r2) {
        r0.lambda$loadUrl$2(r1, r2);
    }

    public static /* synthetic */ void c(BaseWebView r0, String r1) {
        r0.lambda$loadUrl$1(r1);
    }

    public static /* synthetic */ void d(BaseWebView r0, String r1, String r2, String r3, String r4, String r5) {
        r0.lambda$loadDataWithBaseURL$4(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void e(BaseWebView r0, String r1, ValueCallback r2) {
        r0.lambda$evaluateJavascript$0(r1, r2);
    }

    private void registerService() {
    }

    @Override // android.webkit.WebView
    public WebViewClient getWebViewClient() {
        LarkBaseWebViewClient r0 = this.mBaseWebViewClient;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getWebViewClient();
    }

    private void initWebView() {
        LarkWebViewConfig r0 = LarkWebViewConfig.createDefault(getContext());
        this.mConfig = r0;
        setWebViewConfig(r0);
        this.mBaseWebViewClient = new LarkBaseWebViewClient(this);
        this.mBaseWebChromeClient = new LarkBaseWebChromeClient(this);
        super.setWebViewClient(this.mBaseWebViewClient);
        super.setWebChromeClient(this.mBaseWebChromeClient);
        registerService();
        Log.i(TAG, "initWebView done");
    }

    @Override // com.ss.android.lark.chameleon.basewebview.interfaces.ILarkWebViewContext
    public Context getWebViewContext() {
        return getContext();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resumeTimers();
    }

    public void resetServiceAndClient() {
        LarkWebViewConfig r0 = LarkWebViewConfig.createDefault(getContext());
        this.mConfig = r0;
        setWebViewConfig(r0);
        this.mBaseWebViewClient.setWebViewClient(null);
        this.mBaseWebChromeClient.setWebChromeClient(null);
        registerService();
    }

    public LarkWebViewConfig getWebViewConfig() {
        return this.mConfig;
    }

    public boolean isOpenFromMultiWindow() {
        return this.mIsOpenFromMultiWindow;
    }

    @Override // android.webkit.WebView
    public void onPause() {
        super.onPause();
    }

    @Override // android.webkit.WebView
    public void onResume() {
        super.onResume();
    }

    public BaseWebView(Context r2) {
        this(new DarkModeContextExtension(r2), null);
    }

    private /* synthetic */ void lambda$loadUrl$1(String r2) {
        loadUrlInternal(r2, new HashMap());
    }

    @Override // android.view.View
    public void draw(Canvas r3) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        super.draw(r3);
        return;
    L6:
        if (RomUtils.isHuawei() == false) goto L8;
        Log.e(TAG, "huawei is drawing webView in subThread !!");
        return;
    L8:
        super.draw(r3);
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String r3) {
        Log.i(TAG, "loadUrl");
        if (UIExecutor.checkUiThread() == false) goto L5;
        loadUrlInternal(r3, new HashMap());
        return;
    L5:
        UIExecutor.executor().post(new e(this, r3));
    }

    public void setOpenFromMultiWindow(boolean r1) {
        this.mIsOpenFromMultiWindow = r1;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient r3) {
        if (this.mBaseWebChromeClient == null) goto L6;
        Log.i(TAG, "setWebChromeClient success");
        this.mBaseWebChromeClient.setWebChromeClient(r3);
        return;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient r5) {
        if (this.mBaseWebViewClient == null) goto L16;
        Log.i(TAG, "mWebViewClient setWebViewClient");
        if (AppInfoUtils.isApkInDebug(getWebViewContext()) == false) goto L13;
        if (r5 == null) goto L13;
        if ((r5 instanceof ILarkWebViewClientCompat) == true) goto L13;
        StackTraceElement[] r0 = ThreadMethodProxy.currentThread().getStackTrace();
        int r1 = r0.length;
        int r2 = 2;
        if (r1 <= 2) goto L13;
    L11:
        if (r2 >= r1) goto L13;
        StackTraceElement r3 = r0[r2];
        r3.getClassName();
        r3.getMethodName();
        r2 = r2 + 1;
    L13:
        this.mBaseWebViewClient.setWebViewClient(r5);
        return;
    }

    public void setWebViewConfig(LarkWebViewConfig r2) {
        if (r2 == null) goto L4;
        updateWebViewConfig(r2);
        return;
    L4:
        Log.w(TAG, "setWebViewConfig failed, config is null.");
    }

    public void updateWebViewConfig(LarkWebViewConfig r4) {
        if (r4 != null) goto L6;
        Log.w(TAG, "updateWebViewConfig failed, config is null.");
        return;
    L6:
        this.mConfig = new LarkWebViewConfig.Builder(getContext()).apply(r4);
        if (r4.getDebuggableConfig() != null) goto L9;
        Log.w(TAG, "setWebViewConfig failed, debuggableConfig is null.");
    L13:
        WebSettingConfig r1 = r4.getWebSettingConfig();
        if (r1 == null) goto L16;
        r1.apply(this);
    L17:
        PerformanceConfig r5 = r4.getPerformanceConfig();
        if (r5 != null) goto L20;
        Log.w(TAG, "setPerformanceConfig failed, performanceConfig is null.");
        return;
    L20:
        if (r5.isPerformanceEnable() == false) goto L24;
        Log.i(TAG, "performanceConfig is enable");
        return;
    L24:
        return;
    L16:
        Log.w(TAG, "setWebViewConfig failed, webSettingConfig is null.");
        goto L17
    L9:
        if (r4.getDebuggableConfig().isWebViewInspectEnable() == true) goto L11;
        WebView.setWebContentsDebuggingEnabled(false);
        goto L13
    L11:
        Log.w(TAG, "open inspect");
        goto L13
    }

    public BaseWebView(DarkModeContextExtension r2, AttributeSet r3) {
        super(r2.getContext(), r3);
        r2.injectRedirectConfiguration(r2.getContext());
        initWebView();
    }

    private /* synthetic */ void lambda$evaluateJavascript$0(String r1, ValueCallback r2) {
        super.evaluateJavascript(r1, r2);
    }

    private /* synthetic */ void lambda$loadUrl$2(String r1, Map r2) {
        loadUrlInternal(r1, r2);
    }

    private void loadUrlInternal(String r1, Map<String, String> r2) {
        super.loadUrl(r1, r2);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, e.toString());
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(final String r3, final ValueCallback<String> r4) {
        Log.i(TAG, "evaluateJavascript run");
        if (UIExecutor.checkUiThread() == false) goto L5;
        super.evaluateJavascript(r3, r4);
        return;
    L5:
        UIExecutor.executor().post(new b(this, r3, r4));
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String r3, final Map<String, String> r4) {
        Log.i(TAG, "loadUrl additional");
        if (r4 == null) goto L6;
        r4.put(HEADER_ACCEPT_LANGUAGE, Env.getCacheLanguageSetting().toLanguageTag());
    L6:
        if (UIExecutor.checkUiThread() == false) goto L8;
        loadUrlInternal(r3, r4);
        return;
    L8:
        UIExecutor.executor().post(new c(this, r3, r4));
    }

    private /* synthetic */ void lambda$loadData$3(String r1, String r2, String r3) {
        super.loadData(r1, r2, r3);
    }

    @Override // android.webkit.WebView
    public void loadData(final String r3, final String r4, final String r5) {
        Log.i(TAG, "loadData");
        if (UIExecutor.checkUiThread() == false) goto L5;
        super.loadData(r3, r4, r5);
        return;
    L5:
        UIExecutor.executor().post(new a(this, r3, r4, r5));
    }

    private /* synthetic */ void lambda$loadDataWithBaseURL$4(String r1, String r2, String r3, String r4, String r5) {
        super.loadDataWithBaseURL(r1, r2, r3, r4, r5);
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String r10, final String r11, final String r12, final String r13, final String r14) {
        Log.i(TAG, "loadDataWithBaseUrl");
        if (UIExecutor.checkUiThread() == false) goto L5;
        super.loadDataWithBaseURL(r10, r11, r12, r13, r14);
        return;
    L5:
        UIExecutor.executor().post(new d(this, r10, r11, r12, r13, r14));
    }
}
