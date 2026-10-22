package com.ss.android.lark.chameleon.container.webcontainer.view;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import com.ss.android.lark.chameleon.api.WebviewConfig;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.AppInfoUtils;
import com.ss.android.lark.chameleon.util.UserAgentUtil;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0003J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebViewConfig;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "UA_NETWORK", "UA_NETWORK_VERSION", "UA_PLATFORM", "UA_PLATFORM_ANDROID", "configWebSettings", BuildConfig.FLAVOR, "webView", "Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;", "webSettings", "Landroid/webkit/WebSettings;", "getUserAgent", "context", "Landroid/content/Context;", "init", "setUserAgent", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonWebViewConfig {
    public static final ChameleonWebViewConfig INSTANCE = null;
    private static final String TAG = "CML_TAG_ChameleonWebSettings";
    private static final String UA_NETWORK = "okhttp";
    private static final String UA_NETWORK_VERSION = "3.2";
    private static final String UA_PLATFORM = "platform";
    private static final String UA_PLATFORM_ANDROID = "android";

    static {
        INSTANCE = new ChameleonWebViewConfig();
    }

    private ChameleonWebViewConfig() {
    }

    public final String getUserAgent(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        StringBuilder r0 = new StringBuilder();
        String r1 = UserAgentUtil.INSTANCE.getUserAgent(r4);
        if (r1.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        r1 = "Mozilla/5.0 (Linux; Android 7.0; FRD-AL00 Build/HUAWEIFRD-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.91 Mobile Safari/537.36";
    L8:
        r0.append(r1);
        r0.append(" Chameleon");
        r0.append(" " + AppInfoUtils.getUaAppName(r4) + '/' + AppInfoUtils.getVersionName(r4));
        r0.append(" platform/android okhttp/3.2");
        return r0.toString();
    L5:
        r2 = false;
        goto L6
    }

    public final void init(ChameleonWebView r3) {
        Intrinsics.checkNotNullParameter(r3, "webView");
        CookieManager.getInstance().setAcceptThirdPartyCookies(r3, true);
        configWebSettings(r3, r3.getSettings());
    }

    private final void configWebSettings(ChameleonWebView r3, WebSettings r4) {
        r4.setJavaScriptEnabled(true);
        r4.setDomStorageEnabled(true);
        r4.setSupportMultipleWindows(false);
        r4.setJavaScriptCanOpenWindowsAutomatically(true);
        r4.setCacheMode(-1);
        r4.setAllowFileAccess(true);
        r4.setDatabaseEnabled(true);
        r4.setMixedContentMode(2);
        setUserAgent(r3, r4);
    }

    private final void setUserAgent(ChameleonWebView r4, WebSettings r5) {
        String r0 = getUserAgent(r4.getContext());
        WebviewConfig r1 = r4.getChameleonConfig().getWebviewConfig();
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getBizUAgent();
    L7:
        if (TextUtils.isEmpty(r3) == true) goto L12;
        StringBuilder r6 = new StringBuilder();
        r6.append(r0);
        r6.append(' ');
        WebviewConfig r7 = r4.getChameleonConfig().getWebviewConfig();
        if (r7 == null) goto L11;
        r2 = r7.getBizUAgent();
    L11:
        r6.append(r2);
        r0 = r6.toString();
    L12:
        r5.setUserAgentString(r0);
        Log.i(TAG, "initSettings: ua = " + r0);
        return;
    L5:
        r3 = null;
        goto L7
    }
}
