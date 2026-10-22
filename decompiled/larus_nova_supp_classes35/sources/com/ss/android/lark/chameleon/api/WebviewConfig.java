package com.ss.android.lark.chameleon.api;

import com.ss.android.lark.chameleon.pluginsystem.WebService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J+\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\b\u0010\u001f\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chameleon/api/WebviewConfig;", "Ljava/io/Serializable;", "webViewPoolConfig", "Lcom/ss/android/lark/chameleon/api/WebViewPoolConfig;", "webService", "Lcom/ss/android/lark/chameleon/api/IWebService;", "bizUAgent", BuildConfig.FLAVOR, "(Lcom/ss/android/lark/chameleon/api/WebViewPoolConfig;Lcom/ss/android/lark/chameleon/api/IWebService;Ljava/lang/String;)V", "getBizUAgent", "()Ljava/lang/String;", "setBizUAgent", "(Ljava/lang/String;)V", "getWebService", "()Lcom/ss/android/lark/chameleon/api/IWebService;", "setWebService", "(Lcom/ss/android/lark/chameleon/api/IWebService;)V", "getWebViewPoolConfig", "()Lcom/ss/android/lark/chameleon/api/WebViewPoolConfig;", "setWebViewPoolConfig", "(Lcom/ss/android/lark/chameleon/api/WebViewPoolConfig;)V", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WebviewConfig implements Serializable {
    public static final Companion Companion = null;
    public static final long DEFAULT_ALIVE_DURATION = 300000;
    public static final int DEFAULT_MAX_REUSE_TIMES = 10;
    private String bizUAgent;
    private IWebService webService;
    private WebViewPoolConfig webViewPoolConfig;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleon/api/WebviewConfig$Companion;", BuildConfig.FLAVOR, "()V", "DEFAULT_ALIVE_DURATION", BuildConfig.FLAVOR, "DEFAULT_MAX_REUSE_TIMES", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    public WebviewConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ WebviewConfig copy$default(WebviewConfig r0, WebViewPoolConfig r1, IWebService r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.webViewPoolConfig;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.webService;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.bizUAgent;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final WebViewPoolConfig component1() {
        return this.webViewPoolConfig;
    }

    public final IWebService component2() {
        return this.webService;
    }

    public final String component3() {
        return this.bizUAgent;
    }

    public final WebviewConfig copy(WebViewPoolConfig r2, IWebService r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "bizUAgent");
        return new WebviewConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WebviewConfig) == true) goto L8;
        return false;
    L8:
        WebviewConfig r6 = (WebviewConfig) r5;
        if (Intrinsics.areEqual(this.webViewPoolConfig, r6.webViewPoolConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.webService, r6.webService) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bizUAgent, r6.bizUAgent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        WebViewPoolConfig r0 = this.webViewPoolConfig;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        IWebService r4 = this.webService;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + this.bizUAgent.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("WebviewConfig(webViewPoolConfig=");
        r0.append(this.webViewPoolConfig);
        r0.append(", bizUAgent=");
        r0.append(this.bizUAgent);
        r0.append(", webService=");
        IWebService r1 = this.webService;
        if (r1 == null) goto L7;
        List<WebService> r2 = r1.getWebService();
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(r2.size());
    L8:
        r0.append(r3);
        r0.append(')');
        return r0.toString();
    L7:
        r3 = null;
        goto L8
    }

    public final String getBizUAgent() {
        return this.bizUAgent;
    }

    public final IWebService getWebService() {
        return this.webService;
    }

    public final WebViewPoolConfig getWebViewPoolConfig() {
        return this.webViewPoolConfig;
    }

    public final void setBizUAgent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.bizUAgent = r2;
    }

    public final void setWebService(IWebService r1) {
        this.webService = r1;
    }

    public final void setWebViewPoolConfig(WebViewPoolConfig r1) {
        this.webViewPoolConfig = r1;
    }

    public WebviewConfig(WebViewPoolConfig r2, IWebService r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "bizUAgent");
        this.webViewPoolConfig = r2;
        this.webService = r3;
        this.bizUAgent = r4;
    }

    public /* synthetic */ WebviewConfig(WebViewPoolConfig r2, IWebService r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = BuildConfig.FLAVOR;
    L11:
        this(r2, r3, r4);
    }
}
