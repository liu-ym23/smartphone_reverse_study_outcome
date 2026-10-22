package com.ss.android.lark.chameleon.basewebview;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.DarkModeContextExtension;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\b\b\u0016\u0018\u0000 (2\u00020\u0001:\u0001(B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\r\u0010\u001a\u001a\u00020\fH\u0000¢\u0006\u0002\b\u001bJ\u0006\u0010\u001c\u001a\u00020\u0010J\b\u0010\u001d\u001a\u00020\u0000H\u0016J\u0012\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0016J(\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\f2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0019H\u0016J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\fJ\u000e\u0010%\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0005J\u001c\u0010&\u001a\u00020\u00192\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chameleon/basewebview/LarkWebView;", "Lcom/ss/android/lark/chameleon/basewebview/BaseWebView;", "context", "Landroid/content/Context;", IPortraitService.TYPE, "Lcom/ss/android/lark/chameleon/basewebview/BizType;", "(Landroid/content/Context;Lcom/ss/android/lark/chameleon/basewebview/BizType;)V", "set", "Landroid/util/AttributeSet;", "bizType", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/ss/android/lark/chameleon/basewebview/BizType;)V", "bizScene", BuildConfig.FLAVOR, "injectedLogParams", BuildConfig.FLAVOR, "mBridge", "Lcom/ss/android/lark/chameleon/bridge/Bridge;", "mStartTime", BuildConfig.FLAVOR, "<set-?>", BuildConfig.FLAVOR, "webViewIsDestroy", "getWebViewIsDestroy", "()Z", "destroy", BuildConfig.FLAVOR, "getBizScene", "getBizScene$chameleon_base_release", "getBridge", "getWebView", "loadUrl", "url", "additionalHttpHeaders", BuildConfig.FLAVOR, "onResume", "setBizScene", "scene", "setBizType", "setInjectedLogParams", "logParams", "Companion", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class LarkWebView extends BaseWebView {
    public static final Companion Companion = null;
    private static final String FG_WEB_VIEW_DESTROY = "openplatform.web.lark.webview.destroy";
    public static final String TAG = "LarkWebView";
    private String bizScene;
    private BizType bizType;
    private Map<String, String> injectedLogParams;
    private Bridge mBridge;
    private long mStartTime;
    private boolean webViewIsDestroy;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chameleon/basewebview/LarkWebView$Companion;", BuildConfig.FLAVOR, "()V", "FG_WEB_VIEW_DESTROY", BuildConfig.FLAVOR, "TAG", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LarkWebView(Context r7) {
        this(r7, null, null, 6, null);
    }

    public LarkWebView(Context r7, AttributeSet r8) {
        this(r7, r8, null, 4, null);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.webViewIsDestroy = true;
        super.destroy();
        this.mBridge.destroy();
        Log.i(TAG, "larkwebview destroy");
    }

    @Override // com.ss.android.lark.chameleon.basewebview.interfaces.ILarkWebViewContext
    public LarkWebView getWebView() {
        return this;
    }

    @Override // com.ss.android.lark.chameleon.basewebview.BaseWebView, android.webkit.WebView
    public void onResume() {
        super.onResume();
        Log.i(TAG, "lark webview onResume");
        resumeTimers();
    }

    public final String getBizScene$chameleon_base_release() {
        return this.bizScene;
    }

    public final Bridge getBridge() {
        return this.mBridge;
    }

    public final boolean getWebViewIsDestroy() {
        return this.webViewIsDestroy;
    }

    @Override // com.ss.android.lark.chameleon.basewebview.BaseWebView, android.webkit.WebView
    public void loadUrl(String r1) {
        super.loadUrl(r1);
    }

    public final void setBizScene(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.bizScene = r2;
    }

    public final void setBizType(BizType r2) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        this.bizType = r2;
    }

    public final void setInjectedLogParams(Map<String, String> r1) {
        this.injectedLogParams = r1;
    }

    public LarkWebView(Context r2, BizType r3) {
        this(r2, null, r3);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.BaseWebView, android.webkit.WebView
    public void loadUrl(String r1, Map<String, String> r2) {
        super.loadUrl(r1, r2);
    }

    public LarkWebView(Context r2, AttributeSet r3, BizType r4) {
        super(new DarkModeContextExtension(r2), r3);
        this.bizType = r4;
        this.mBridge = new Bridge(this);
        this.bizScene = BuildConfig.FLAVOR;
    }

    public /* synthetic */ LarkWebView(Context r1, AttributeSet r2, BizType r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = BizType.Companion.getUNKNOWN();
    L8:
        this(r1, r2, r3);
    }
}
