package q7;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.web.jsbridge2.x;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthUrlSourceType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class d extends WebView implements x, o7.b, ke7.b {
    public String a;
    public boolean b;
    public String c;
    public String d;
    public AuthUrlSourceType e;

    public String getSafeUrl() {
        if (this.b == true) goto L7;
        this.e = AuthUrlSourceType.DisableSafeAuthInXBridge2;
        return this.a;
    L7:
        return getXSafeUrl();
    }

    public String getXSafeUrl() {
        if (TextUtils.isEmpty(this.d) == true) goto L6;
        this.e = AuthUrlSourceType.PageCommitVisibleUrl;
        String r0 = this.d;
    L12:
        HybridLogger r10 = HybridLogger.a;
        HybridLogger.m("SSWebView", "GetXSafeUrl: return " + r0 + ", type is " + this.e, null, null, 12);
        return r0;
    L6:
        if (TextUtils.isEmpty(this.c) == true) goto L9;
        this.e = AuthUrlSourceType.PageStartedUrl;
        r0 = this.c;
        goto L12
    L9:
        if (TextUtils.isEmpty(getUrl()) == true) goto L11;
        this.e = AuthUrlSourceType.WebViewUrl;
        r0 = getUrl();
        goto L12
    L11:
        this.e = AuthUrlSourceType.AbnormalUrl;
        r0 = null;
        goto L12
    }

    @Override // android.webkit.WebView
    public boolean canGoBack() {
        return super.canGoBack();
    L4:
        return false;
    }

    @Override // android.webkit.WebView
    public final boolean canGoForward() {
        return super.canGoForward();
    L4:
        return false;
    }

    @Override // android.webkit.WebView
    public int getContentHeight() {
        return super.getContentHeight();
    L4:
        return 1;
    }

    @Override // android.webkit.WebView
    public String getOriginalUrl() {
        return super.getOriginalUrl();
    L4:
        return null;
    }

    @Override // android.webkit.WebView
    public int getProgress() {
        return super.getProgress();
    L4:
        return 100;
    }

    @Override // android.webkit.WebView
    public String getUrl() {
        return super.getUrl();
    L4:
        return null;
    }

    public final boolean a() {
        return this.b;
    }

    @Override // android.webkit.WebView
    public final void clearFormData() {
        super.clearFormData();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void clearHistory() {
        super.clearHistory();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView, android.view.View
    public final void computeScroll() {
        super.computeScroll();     // Catch: Exception -> L4
        return;
    }

    public AuthUrlSourceType getAuthUrlSourceType() {
        return this.e;
    }

    @Override // android.webkit.WebView
    public void goBack() {
        super.goBack();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void goForward() {
        super.goForward();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public void reload() {
        super.reload();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        super.stopLoading();     // Catch: Exception -> L4
        return;
    }

    public d(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        this.a = "";
        this.e = AuthUrlSourceType.Unset;
    }

    @Override // android.webkit.WebView
    public final boolean canGoBackOrForward(int r1) {
        return super.canGoBackOrForward(r1);
    L4:
        return false;
    }

    @Override // android.webkit.WebView
    public final void clearCache(boolean r1) {
        super.clearCache(r1);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void goBackOrForward(int r1) {
        super.goBackOrForward(r1);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        super.loadUrl(r10);     // Catch: Exception -> L5
        return;
    }

    @Override // android.webkit.WebView, android.view.View
    public void setBackgroundColor(int r1) {
        super.setBackgroundColor(r1);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public void setDownloadListener(DownloadListener r1) {
        super.setDownloadListener(r1);     // Catch: Exception -> L4
        return;
    }

    public final void setEnableSafeAuth(Boolean r1) {
        if (r1 == null) goto L4;
        boolean r10 = r1.booleanValue();
    L5:
        this.b = r10;
        return;
    L4:
        r10 = false;
        goto L5
    }

    @Override // android.webkit.WebView
    public void setNetworkAvailable(boolean r1) {
        super.setNetworkAvailable(r1);     // Catch: Exception -> L4
        return;
    }

    public final void setPageCommitVisibleUrl(String r1) {
        this.d = r1;
    }

    public final void setPageStartUrl(String r1) {
        this.c = r1;
    }

    @Override // o7.b
    public void setSafeUrl(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.a = r10;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient r1) {
        super.setWebChromeClient(r1);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient r10) {
        Intrinsics.checkNotNullParameter(r10, "client");
        super.setWebViewClient(r10);     // Catch: Exception -> L5
        return;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "additionalHttpHeaders");
        super.loadUrl(r10, r11);
    }

    @Override // android.webkit.WebView
    public final void postUrl(String r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "postData");
        super.postUrl(r10, r11);     // Catch: Exception -> L5
        return;
    }
}
