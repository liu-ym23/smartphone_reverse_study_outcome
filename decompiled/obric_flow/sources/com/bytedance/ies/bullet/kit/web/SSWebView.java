package com.bytedance.ies.bullet.kit.web;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Keep;
import com.bytedance.ies.bullet.service.base.YieldError;
import com.bytedance.ies.bullet.web.pia.s;
import com.bytedance.pia.core.bridge.channel.WebViewPort$JSInterface;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthUrlSourceType;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.lynx.tasm.behavior.x0;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import ko.r;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0005l>;48B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0013H\u0016¢\u0006\u0004\b \u0010!J\u0011\u0010\"\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\"\u0010\u000eJ\u0011\u0010#\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b#\u0010\u000eJ\u000f\u0010$\u001a\u00020\bH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010%J\u0017\u0010)\u001a\u00020\u00152\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u0019\u0010-\u001a\u00020\u00152\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u0019\u00100\u001a\u00020\u00152\b\u0010(\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\u00152\u0006\u00102\u001a\u00020\bH\u0016¢\u0006\u0004\b3\u0010\u001eJ\u0015\u00106\u001a\u00020\u00152\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u0015\u00109\u001a\u00020\u00152\u0006\u00105\u001a\u000208¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020\u00152\b\u0010,\u001a\u0004\u0018\u00010;¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00152\b\u0010,\u001a\u0004\u0018\u00010>¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u0004\u0018\u00010\f¢\u0006\u0004\bA\u0010\u000eJ\r\u0010C\u001a\u00020B¢\u0006\u0004\bC\u0010DJ\r\u0010E\u001a\u00020\b¢\u0006\u0004\bE\u0010%J\u0015\u0010G\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\b¢\u0006\u0004\bG\u0010\u001eJ\u0015\u0010I\u001a\u00020\u00152\u0006\u0010H\u001a\u00020\u0013¢\u0006\u0004\bI\u0010!J\u0017\u0010N\u001a\u00020\u00152\u0006\u0010K\u001a\u00020JH\u0000¢\u0006\u0004\bL\u0010MJ\u0017\u0010S\u001a\u00020\u00152\u0006\u0010P\u001a\u00020OH\u0000¢\u0006\u0004\bQ\u0010RJ\u000f\u0010U\u001a\u0004\u0018\u00010T¢\u0006\u0004\bU\u0010VR$\u0010[\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010\u000e\"\u0004\bZ\u0010\u001aR*\u0010]\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b]\u0010^\u0012\u0004\bc\u0010d\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010f\u001a\u0004\u0018\u00010e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010k¨\u0006m"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/SSWebView;", "Lcom/bytedance/webx/core/webview/WebViewContainer;", "Lcom/bytedance/ies/web/jsbridge2/j;", "Laj/b;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "getSafeUrl", "()Ljava/lang/String;", "getXSafeUrl", "Lcom/bytedance/sdk/xbridge/cn/protocol/auth/AuthUrlSourceType;", "getAuthUrlSourceType", "()Lcom/bytedance/sdk/xbridge/cn/protocol/auth/AuthUrlSourceType;", "", "enable", "", "setEnableSafeWebJSBAuth", "(Ljava/lang/Boolean;)V", "url", "setPageCommitVisibleUrl", "(Ljava/lang/String;)V", "setPageStartUrl", "mode", "setOverScrollMode", "(I)V", "networkUp", "setNetworkAvailable", "(Z)V", "getUrl", "getOriginalUrl", "getProgress", "()I", "getContentHeight", "Landroid/webkit/WebViewClient;", "client", "setWebViewClient", "(Landroid/webkit/WebViewClient;)V", "Landroid/webkit/DownloadListener;", "listener", "setDownloadListener", "(Landroid/webkit/DownloadListener;)V", "Landroid/webkit/WebChromeClient;", "setWebChromeClient", "(Landroid/webkit/WebChromeClient;)V", "color", "setBackgroundColor", "Lcom/bytedance/ies/bullet/kit/web/h;", "delegate", "setWebViewEventDelegate", "(Lcom/bytedance/ies/bullet/kit/web/h;)V", "Lcom/bytedance/ies/bullet/kit/web/i;", "setWebViewScrollDelegate", "(Lcom/bytedance/ies/bullet/kit/web/i;)V", "Lcom/bytedance/ies/bullet/kit/web/g;", "setWebScrollListener", "(Lcom/bytedance/ies/bullet/kit/web/g;)V", "Lcom/bytedance/ies/bullet/kit/web/f;", "setWebOverScrollByListener", "(Lcom/bytedance/ies/bullet/kit/web/f;)V", "getSecLinkScene", "", "getLastClickTime", "()J", "getTimeInterval", "timeInterval", "setTimeInterval", "canTouch", "setCanTouch", "Lcom/bytedance/ies/bullet/web/pia/j;", "piaLifeCycle", "setPiaLifeCycle$anniex_release", "(Lcom/bytedance/ies/bullet/web/pia/j;)V", "setPiaLifeCycle", "Lcom/bytedance/ies/bullet/web/scc/b;", "sccDelegate", "setSccDelegate$anniex_release", "(Lcom/bytedance/ies/bullet/web/scc/b;)V", "setSccDelegate", "Lcom/bytedance/ies/bullet/core/container/b;", "getSearchMode", "()Lcom/bytedance/ies/bullet/core/container/b;", "l", "Ljava/lang/String;", "getSecureLinkScene", "setSecureLinkScene", "secureLinkScene", "Lcom/bytedance/ies/bullet/kit/web/b;", "secureDelegate", "Lcom/bytedance/ies/bullet/kit/web/b;", "getSecureDelegate", "()Lcom/bytedance/ies/bullet/kit/web/b;", "setSecureDelegate", "(Lcom/bytedance/ies/bullet/kit/web/b;)V", "getSecureDelegate$annotations", "()V", "Lcom/bytedance/ies/bullet/secure/c;", "argusAdapter", "Lcom/bytedance/ies/bullet/secure/c;", "getArgusAdapter$anniex_release", "()Lcom/bytedance/ies/bullet/secure/c;", "setArgusAdapter$anniex_release", "(Lcom/bytedance/ies/bullet/secure/c;)V", "ko/r", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nSSWebView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SSWebView.kt\ncom/bytedance/ies/bullet/kit/web/SSWebView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Yield.kt\ncom/bytedance/ies/bullet/service/base/YieldKt\n*L\n1#1,911:1\n1#2:912\n10#3,5:913\n10#3,5:918\n10#3,5:923\n10#3,5:928\n*E\n*S KotlinDebug\n*F\n+ 1 SSWebView.kt\ncom/bytedance/ies/bullet/kit/web/SSWebView\n*L\n523#1,5:913\n537#1,5:918\n576#1,5:923\n633#1,5:928\n*E\n"})
public class SSWebView extends WebViewContainer implements com.bytedance.ies.web.jsbridge2.j, aj.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5474c;
    public boolean d;
    public String e;
    public boolean f;
    public final r g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f5475h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f5476i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h f5477j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public i f5478k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f5479l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.ies.bullet.web.pia.j f5480m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.ies.bullet.web.scc.b f5481n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f5482o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f5483p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f5484q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public AuthUrlSourceType f5485r;

    @JvmOverloads
    @Keep
    public SSWebView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    @Deprecated(message = "废弃，内部收敛统一到internal argusAdapter避免外部随意修改，请不要主动调用")
    public static /* synthetic */ void getSecureDelegate$annotations() {
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final boolean canGoBack() {
        return super.canGoBack();
    L4:
        return false;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final boolean canGoBackOrForward(int r5) {
        return super.canGoBackOrForward(r5);
    L4:
        return false;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final boolean canGoForward() {
        return super.canGoForward();
    L4:
        return false;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r5) {
        h r10 = this.f5477j;
        if (r10 == null) goto L8;
        super.canScrollVertically(r5);     // Catch: YieldError -> L9
        ol.e r11 = ((com.ivy.ivykit.plugin.impl.web.e) r10).f9539a.d;     // Catch: YieldError -> L9
        throw new YieldError();     // Catch: YieldError -> L9
    L8:
        return super.canScrollVertically(r5);
    }

    @Override // android.webkit.WebView
    public final void clearCache(boolean r5) {
        super.clearCache(r5);     // Catch: Exception -> L4
        return;
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

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void destroy() {
        com.bytedance.android.monitorV2.webview.k r5 = com.bytedance.android.monitorV2.webview.k.d;     // Catch: Throwable -> L15
        r5.getClass();     // Catch: Throwable -> L15
        d5.b.f("WebViewMonitorHelper", "destroy: " + d5.b.a(this));     // Catch: Throwable -> L15
        if (r5.v() == true) goto L5;
    L7:
        r5.d(this);     // Catch: Throwable -> L15
    L8:
        r r10 = this.g;     // Catch: Throwable -> L15
        r10.f18728b = "";     // Catch: Throwable -> L15
        ((Handler) r10.f18729c).removeCallbacksAndMessages(null);     // Catch: Throwable -> L15
        com.bytedance.ies.bullet.web.pia.j r11 = this.f5480m;     // Catch: Throwable -> L15
        if (r11 == null) goto L13;
        nh.b r12 = r11.f6235a;     // Catch: Throwable -> L15
        ((nh.a) r12.d).release();     // Catch: Throwable -> L15
        r12.c();     // Catch: Throwable -> L15
        View r13 = (View) ((WeakReference) r12.e).get();     // Catch: Throwable -> L15
        if ((r13 instanceof WebView) == false) goto L13;
        WeakHashMap r14 = WebViewPort$JSInterface.f6958c;     // Catch: Throwable -> L15
        com.bytedance.pia.core.utils.m.a(new hh.c((WebView) r13, 0));     // Catch: Throwable -> L15
    L13:
        this.f5481n = null;     // Catch: Throwable -> L15
        super.destroy();     // Catch: Throwable -> L15
        return;
    L5:
        if (r5.f3799b.f(this) == false) goto L7;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void evaluateJavascript(String r5, ValueCallback r10) {
        Intrinsics.checkNotNullParameter(r5, "script");
        super.evaluateJavascript(r5, r10);
        com.bytedance.ies.bullet.web.pia.j r11 = this.f5480m;
        if (r11 == null) goto L7;
        if (r5 == null) goto L8;
        s r12 = r11.f6236b;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r5, "script");
        r12.a(r5);
        return;
    L8:
        return;
    }

    public final com.bytedance.ies.bullet.secure.c getArgusAdapter$anniex_release() {
        return null;
    }

    @Override // aj.b
    public AuthUrlSourceType getAuthUrlSourceType() {
        return this.f5485r;
    }

    @Override // android.webkit.WebView
    public int getContentHeight() {
        return super.getContentHeight();
    L4:
        return 1;
    }

    public final long getLastClickTime() {
        return this.f5474c;
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

    @Override // com.bytedance.ies.web.jsbridge2.j
    public String getSafeUrl() {
        if (this.f5482o == true) goto L5;
        this.f5485r = AuthUrlSourceType.f7445b;
        return this.f5483p;
    L5:
        return getXSafeUrl();
    }

    public final com.bytedance.ies.bullet.core.container.b getSearchMode() {
        return null;
    }

    public final String getSecLinkScene() {
        return this.f5479l;
    }

    public final b getSecureDelegate() {
        return null;
    }

    public final String getSecureLinkScene() {
        return this.f5479l;
    }

    public final int getTimeInterval() {
        int r5 = this.f5472a;
        if (r5 <= 0) goto L5;
        return r5;
    L5:
        return 500;
    }

    @Override // android.webkit.WebView
    public String getUrl() {
        return super.getUrl();
    L4:
        return null;
    }

    @Override // aj.b
    public String getXSafeUrl() {
        if (TextUtils.isEmpty(this.f5484q) == true) goto L6;
        this.f5485r = AuthUrlSourceType.f;
        String r5 = this.f5484q;
    L12:
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        StringBuilder r11 = com.lynx.tasm.utils.e.b("GetXSafeUrl: return ", r5, ", type is ");
        r11.append(this.f5485r);
        com.bytedance.ies.bullet.base.utils.logger.a.g("SSWebView", r11.toString(), null, 12);
        return r5;
    L6:
        if (TextUtils.isEmpty(this.f5483p) == true) goto L9;
        this.f5485r = AuthUrlSourceType.e;
        r5 = this.f5483p;
        goto L12
    L9:
        if (TextUtils.isEmpty(getUrl()) == true) goto L11;
        this.f5485r = AuthUrlSourceType.g;
        r5 = getUrl();
        goto L12
    L11:
        this.f5485r = AuthUrlSourceType.f7447h;
        r5 = null;
        goto L12
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void goBack() {
        com.bytedance.android.monitorV2.webview.k r5 = com.bytedance.android.monitorV2.webview.k.d;     // Catch: Exception -> L10
        r5.getClass();     // Catch: Exception -> L10
        d5.b.f("WebViewMonitorHelper", "goBack: " + d5.b.a(this));     // Catch: Exception -> L10
        if (r5.v() == true) goto L5;
    L7:
        r5.r(this);     // Catch: Exception -> L10
    L8:
        super.goBack();     // Catch: Exception -> L10
        return;
    L5:
        if (r5.f3799b.f(this) == false) goto L7;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void goBackOrForward(int r5) {
        super.goBackOrForward(r5);     // Catch: Exception -> L4
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void goForward() {
        super.goForward();     // Catch: Exception -> L4
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void loadData(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "data");
        super.loadData(r5, r10, r11);     // Catch: Exception -> L5
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void loadDataWithBaseURL(String r5, String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "data");
        super.loadDataWithBaseURL(r5, r10, r11, r12, r13);     // Catch: Exception -> L5
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void loadUrl(String r10) {
        Intrinsics.checkNotNullParameter(r10, "url");
        com.bytedance.android.monitorV2.webview.k r5 = com.bytedance.android.monitorV2.webview.k.d;     // Catch: Exception -> L17
        r5.getClass();     // Catch: Exception -> L17
        d5.b.f("WebViewMonitorHelper", "onLoadUrl: " + r10);     // Catch: Exception -> L17
        if (r5.v() == true) goto L6;
    L8:
        r5.j(this, r10);     // Catch: Exception -> L17
    L9:
        com.bytedance.ies.bullet.web.pia.j r11 = this.f5480m;     // Catch: Exception -> L17
        if (r11 == null) goto L12;
        r11.b(r10);     // Catch: Exception -> L17
    L12:
        com.bytedance.ies.bullet.web.scc.b r12 = this.f5481n;     // Catch: Exception -> L17
        if (r12 == null) goto L15;
        Intrinsics.checkNotNullParameter(r10, "url");     // Catch: Exception -> L17
        i4.a r13 = r12.f6255a;     // Catch: Exception -> L17
        ((ug.d) r13.f17502b).a(StringsKt.W(r10, '#'));     // Catch: Exception -> L17
    L15:
        super.loadUrl(r10);     // Catch: Exception -> L17
        return;
    L6:
        if (r5.f3799b.f(this) == false) goto L8;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        com.bytedance.android.monitorV2.webview.k.d.n(this);     // Catch: Throwable -> L4
        LinkedHashMap r5 = com.bytedance.android.anniex.monitor.c.f3335a;     // Catch: Throwable -> L4
        com.bytedance.android.anniex.monitor.c.k(this.e, getUrl());     // Catch: Throwable -> L4
        super.onAttachedToWindow();     // Catch: Throwable -> L4
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView, android.view.View
    public final void onOverScrolled(int r5, int r10, boolean r11, boolean r12) {
        i r13 = this.f5478k;
        if (r13 != null) goto L16;
    L13:
        super.onOverScrolled(r5, r10, r11, r12);
        return;
    L16:
        ol.g r14 = ((com.ivy.ivykit.plugin.impl.web.f) r13).f9540a.e;     // Catch: YieldError -> L15
        if (r14 == null) goto L13;
        j1.e r15 = ((j1.c) r14).f18222a;     // Catch: YieldError -> L15
        if (r11 == true) goto L11;
        if (r12 == true) goto L11;
        boolean r16 = false;
    L12:
        r15.f = r16;     // Catch: YieldError -> L15
    L11:
        r16 = true;
        goto L12
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void onPause() {
        super.onPause();     // Catch: Exception -> L4
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void onResume() {
        super.onResume();     // Catch: Exception -> L4
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView, android.view.View
    public final void onScrollChanged(int r5, int r10, int r11, int r12) {
        super.onScrollChanged(r5, r10, r11, r12);
        g r13 = this.f5475h;
        if (r13 == null) goto L6;
        r13.a(r5, r10, r11, r12);
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        h r5 = this.f5477j;
        if (r5 == null) goto L8;
        ((com.ivy.ivykit.plugin.impl.web.e) r5).a(r10);     // Catch: YieldError -> L20
        throw null;     // Catch: YieldError -> L20
    L8:
        if (this.d == false) goto L26;
        int r11 = r10.getAction();
        if (r11 != 0) goto L12;
        this.f5473b = System.currentTimeMillis();
        Log.i("SSWebView", "startClickTime" + this.f5473b);
    L22:
        return super.onTouchEvent(r10);
    L27:
        return false;
    L12:
        if (r11 != 1) goto L22;
        long r12 = System.currentTimeMillis() - this.f5473b;
        Log.i("SSWebView", "clickDuration" + r12);
        if (r12 >= 100) goto L22;
        this.f5474c = System.currentTimeMillis();
        Log.i("SSWebView", "lastClickTime:" + this.f5474c + "TapTimeout():" + ViewConfiguration.getTapTimeout());
        goto L22
    L26:
        return false;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.view.View
    public final boolean overScrollBy(int r5, int r10, int r11, int r12, int r13, int r14, int r15, int r16, boolean r17) {
        f r18 = this.f5476i;
        if (r18 == null) goto L6;
        ol.g r19 = ((com.ivy.ivykit.plugin.impl.web.g) r18).f9541a.e;
    L6:
        return super.overScrollBy(r5, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void postUrl(String r5, byte[] r10) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r10, "postData");
        super.postUrl(r5, r10);     // Catch: Exception -> L5
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void reload() {
        com.bytedance.android.monitorV2.webview.k r5 = com.bytedance.android.monitorV2.webview.k.d;     // Catch: Exception -> L12
        r5.getClass();     // Catch: Exception -> L12
        d5.b.f("WebViewMonitorHelper", "reload: " + d5.b.a(this));     // Catch: Exception -> L12
        if (r5.v() == false) goto L5;
        r5.f3799b.f(this);     // Catch: Exception -> L12
    L5:
        com.bytedance.ies.bullet.web.scc.b r10 = this.f5481n;     // Catch: Exception -> L12
        if (r10 == null) goto L10;
        String r11 = getUrl();     // Catch: Exception -> L12
        if (r11 == null) goto L10;
        Intrinsics.checkNotNullParameter(r11, "url");     // Catch: Exception -> L12
        i4.a r12 = r10.f6255a;     // Catch: Exception -> L12
        ((ug.d) r12.f17502b).a(StringsKt.W(r11, '#'));     // Catch: Exception -> L12
    L10:
        super.reload();     // Catch: Exception -> L12
        return;
    }

    public final void setArgusAdapter$anniex_release(com.bytedance.ies.bullet.secure.c r5) {
    }

    @Override // android.webkit.WebView, android.view.View
    public void setBackgroundColor(int r5) {
        super.setBackgroundColor(r5);     // Catch: Exception -> L4
        return;
    }

    public final void setCanTouch(boolean r5) {
        this.d = r5;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public void setDownloadListener(DownloadListener r5) {
        super.setDownloadListener(r5);     // Catch: Exception -> L4
        return;
    }

    public final void setEnableSafeWebJSBAuth(Boolean r5) {
        if (r5 == null) goto L4;
        boolean r10 = r5.booleanValue();
    L5:
        this.f5482o = r10;
        return;
    L4:
        r10 = false;
        goto L5
    }

    @Override // android.webkit.WebView
    public void setNetworkAvailable(boolean r5) {
        super.setNetworkAvailable(r5);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView, android.view.View
    public void setOverScrollMode(int r5) {
        super.setOverScrollMode(r5);     // Catch: Throwable -> L4
        return;
    }

    public final void setPageCommitVisibleUrl(String r5) {
        this.f5484q = r5;
    }

    public final void setPageStartUrl(String r5) {
        this.f5483p = r5;
    }

    public final void setPiaLifeCycle$anniex_release(com.bytedance.ies.bullet.web.pia.j r5) {
        Intrinsics.checkNotNullParameter(r5, "piaLifeCycle");
        this.f5480m = r5;
    }

    public final void setSccDelegate$anniex_release(com.bytedance.ies.bullet.web.scc.b r5) {
        Intrinsics.checkNotNullParameter(r5, "sccDelegate");
        this.f5481n = r5;
    }

    public final void setSecureDelegate(b r5) {
    }

    public final void setSecureLinkScene(String r5) {
        this.f5479l = r5;
    }

    public final void setTimeInterval(int r5) {
        this.f5472a = r5;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public void setWebChromeClient(WebChromeClient r5) {
        super.setWebChromeClient(r5);     // Catch: Exception -> L4
        return;
    }

    public final void setWebOverScrollByListener(f r5) {
        this.f5476i = r5;
    }

    public final void setWebScrollListener(g r5) {
        this.f5475h = r5;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public void setWebViewClient(WebViewClient r5) {
        Intrinsics.checkNotNullParameter(r5, "client");
        super.setWebViewClient(r5);     // Catch: Exception -> L5
        return;
    }

    public final void setWebViewEventDelegate(h r5) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
        this.f5477j = r5;
    }

    public final void setWebViewScrollDelegate(i r5) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
        this.f5478k = r5;
    }

    @Override // android.view.View
    public final ActionMode startActionMode(ActionMode.Callback r10) {
        boolean r5 = this.f;
        r r11 = this.g;
        r11.getClass();
        if (r5 == false) goto L8;
        com.bytedance.android.anniex.base.monitor.b r12 = com.bytedance.android.anniex.base.monitor.b.f3120b;
        String r13 = (String) r11.f18728b;
        Map r14 = MapsKt.mapOf(new Pair[]{TuplesKt.to("event_type", "event_type_press"), TuplesKt.to("event_source", "event_source_press_text_panel")});
        r12.getClass();
        Intrinsics.checkNotNullParameter(r14, "event");
        if (r13 == null) goto L8;
        h.f.b(new com.bytedance.android.anniex.base.monitor.a(r12, r13, 0), h.f.g);
    L8:
        Intrinsics.checkNotNullParameter(this, "webView");
        if (r10 != null) goto L11;
        e r15 = null;
    L13:
        return super.startActionMode(r15);
    L11:
        r15 = new e(new x0(r10));
        goto L13
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void stopLoading() {
        super.stopLoading();     // Catch: Exception -> L4
        return;
    }

    @JvmOverloads
    @Keep
    public SSWebView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ SSWebView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    @Keep
    public SSWebView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f5472a = 500;
        this.d = true;
        this.e = "";
        this.g = new r(4);
        this.f5485r = AuthUrlSourceType.d;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void loadUrl(String r10, Map r11) {
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r11, "additionalHttpHeaders");
        com.bytedance.android.monitorV2.webview.k r5 = com.bytedance.android.monitorV2.webview.k.d;     // Catch: Exception -> L17
        r5.getClass();     // Catch: Exception -> L17
        d5.b.f("WebViewMonitorHelper", "onLoadUrl: " + r10);     // Catch: Exception -> L17
        if (r5.v() == true) goto L6;
    L8:
        r5.j(this, r10);     // Catch: Exception -> L17
    L9:
        com.bytedance.ies.bullet.web.pia.j r12 = this.f5480m;     // Catch: Exception -> L17
        if (r12 == null) goto L12;
        r12.b(r10);     // Catch: Exception -> L17
    L12:
        com.bytedance.ies.bullet.web.scc.b r13 = this.f5481n;     // Catch: Exception -> L17
        if (r13 == null) goto L15;
        Intrinsics.checkNotNullParameter(r10, "url");     // Catch: Exception -> L17
        i4.a r14 = r13.f6255a;     // Catch: Exception -> L17
        ((ug.d) r14.f17502b).a(StringsKt.W(r10, '#'));     // Catch: Exception -> L17
    L15:
        Pair r15 = new Pair(r10, r11);     // Catch: Exception -> L17
        super.loadUrl((String) r15.component1(), (Map) r15.component2());     // Catch: Exception -> L17
        return;
    L6:
        if (r5.f3799b.f(this) == false) goto L8;
    }

    @Override // android.view.View
    public final ActionMode startActionMode(ActionMode.Callback r10, int r11) {
        boolean r5 = this.f;
        r r12 = this.g;
        r12.getClass();
        if (r5 == false) goto L8;
        com.bytedance.android.anniex.base.monitor.b r13 = com.bytedance.android.anniex.base.monitor.b.f3120b;
        String r14 = (String) r12.f18728b;
        Map r15 = MapsKt.mapOf(new Pair[]{TuplesKt.to("event_type", "event_type_press"), TuplesKt.to("event_source", "event_source_press_text_panel")});
        r13.getClass();
        Intrinsics.checkNotNullParameter(r15, "event");
        if (r14 == null) goto L8;
        h.f.b(new com.bytedance.android.anniex.base.monitor.a(r13, r14, 0), h.f.g);
    L8:
        Intrinsics.checkNotNullParameter(this, "webView");
        if (r10 != null) goto L11;
        e r16 = null;
    L13:
        return super.startActionMode(r16, r11);
    L11:
        r16 = new e(new x0(r10));
        goto L13
    }
}
