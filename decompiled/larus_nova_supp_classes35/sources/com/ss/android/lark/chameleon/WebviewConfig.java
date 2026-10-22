package com.ss.android.lark.chameleon;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vv4.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\"\u001a\u00020\u0000J\b\u0010#\u001a\u00020\u0007H\u0016J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J?\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006/"}, d2 = {"Lcom/ss/android/lark/chameleon/WebviewConfig;", "Ljava/io/Serializable;", "webViewPoolConfig", "Lcom/ss/android/lark/chameleon/WebViewPoolConfig;", "webService", "Lcom/ss/android/lark/chameleon/IWebService;", "bizUAgent", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "larkApiEnable", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "jsbAuthConfig", "Lcom/ss/android/lark/chameleon/JsbAuthConfig;", "<init>", "(Lcom/ss/android/lark/chameleon/WebViewPoolConfig;Lcom/ss/android/lark/chameleon/IWebService;Ljava/lang/String;ZLcom/ss/android/lark/chameleon/JsbAuthConfig;)V", "getWebViewPoolConfig", "()Lcom/ss/android/lark/chameleon/WebViewPoolConfig;", "setWebViewPoolConfig", "(Lcom/ss/android/lark/chameleon/WebViewPoolConfig;)V", "getWebService", "()Lcom/ss/android/lark/chameleon/IWebService;", "setWebService", "(Lcom/ss/android/lark/chameleon/IWebService;)V", "getBizUAgent", "()Ljava/lang/String;", "setBizUAgent", "(Ljava/lang/String;)V", "getLarkApiEnable", "()Z", "setLarkApiEnable", "(Z)V", "getJsbAuthConfig", "()Lcom/ss/android/lark/chameleon/JsbAuthConfig;", "setJsbAuthConfig", "(Lcom/ss/android/lark/chameleon/JsbAuthConfig;)V", "copy", "toString", "component1", "component2", "component3", "component4", "component5", "equals", "other", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "hashCode", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "Companion", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebviewConfig implements Serializable {
    public static final Companion Companion = null;
    public static final long DEFAULT_ALIVE_DURATION = 300000;
    public static final int DEFAULT_MAX_REUSE_TIMES = 10;
    private String bizUAgent;
    private JsbAuthConfig jsbAuthConfig;
    private boolean larkApiEnable;
    private IWebService webService;
    private WebViewPoolConfig webViewPoolConfig;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chameleon/WebviewConfig$Companion;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "()V", "DEFAULT_ALIVE_DURATION", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "DEFAULT_MAX_REUSE_TIMES", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        this(null, null, null, false, null, 31, null);
    }

    public static /* synthetic */ WebviewConfig copy$default(WebviewConfig r3, WebViewPoolConfig r4, IWebService r5, String r6, boolean r7, JsbAuthConfig r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.webViewPoolConfig;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.webService;
    L8:
        IWebService r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.bizUAgent;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.larkApiEnable;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.jsbAuthConfig;
    L17:
        WebViewPoolConfig r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
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

    public final boolean component4() {
        return this.larkApiEnable;
    }

    public final JsbAuthConfig component5() {
        return this.jsbAuthConfig;
    }

    public final WebviewConfig copy(WebViewPoolConfig r8, IWebService r9, String r10, boolean r11, JsbAuthConfig r12) {
        Intrinsics.checkNotNullParameter(r10, "bizUAgent");
        Intrinsics.checkNotNullParameter(r12, "jsbAuthConfig");
        return new WebviewConfig(r8, r9, r10, r11, r12);
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
        if (Intrinsics.areEqual(this.bizUAgent, r6.bizUAgent) == true) goto L18;
        return false;
    L18:
        if (this.larkApiEnable == r6.larkApiEnable) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.jsbAuthConfig, r6.jsbAuthConfig) == true) goto L23;
        return false;
    L23:
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
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (((r3 + r1) * 31) + this.bizUAgent.hashCode()) * 31;
        if (this.larkApiEnable == false) goto L13;
        int r6 = 1231;
    L15:
        return ((r5 + r6) * 31) + this.jsbAuthConfig.hashCode();
    L13:
        r6 = 1237;
        goto L15
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final WebviewConfig copy() {
        WebViewPoolConfig r0 = this.webViewPoolConfig;
        if (r0 == null) goto L5;
        WebViewPoolConfig r1 = r0.copy();
    L7:
        return new WebviewConfig(r1, this.webService, this.bizUAgent, this.larkApiEnable, this.jsbAuthConfig.copy());
    L5:
        r1 = null;
        goto L7
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("WebviewConfig(webViewPoolConfig=");
        r0.append(this.webViewPoolConfig);
        r0.append(", bizUAgent=");
        r0.append(this.bizUAgent);
        r0.append(", larkApiEnable=");
        r0.append(this.larkApiEnable);
        r0.append(", webService=");
        IWebService r1 = this.webService;
        if (r1 == null) goto L7;
        List<? extends m> r2 = r1.getWebService();
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

    public final JsbAuthConfig getJsbAuthConfig() {
        return this.jsbAuthConfig;
    }

    public final boolean getLarkApiEnable() {
        return this.larkApiEnable;
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

    public final void setJsbAuthConfig(JsbAuthConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.jsbAuthConfig = r2;
    }

    public final void setLarkApiEnable(boolean r1) {
        this.larkApiEnable = r1;
    }

    public final void setWebService(IWebService r1) {
        this.webService = r1;
    }

    public final void setWebViewPoolConfig(WebViewPoolConfig r1) {
        this.webViewPoolConfig = r1;
    }

    public WebviewConfig(WebViewPoolConfig r2, IWebService r3, String r4, boolean r5, JsbAuthConfig r6) {
        Intrinsics.checkNotNullParameter(r4, "bizUAgent");
        Intrinsics.checkNotNullParameter(r6, "jsbAuthConfig");
        this.webViewPoolConfig = r2;
        this.webService = r3;
        this.bizUAgent = r4;
        this.larkApiEnable = r5;
        this.jsbAuthConfig = r6;
    }

    public /* synthetic */ WebviewConfig(WebViewPoolConfig r11, IWebService r12, String r13, boolean r14, JsbAuthConfig r15, int r16, DefaultConstructorMarker r17) {
        IWebService r1 = null;
        if ((r16 & 1) == 0) goto L5;
        WebViewPoolConfig r0 = null;
    L7:
        if ((r16 & 2) != 0) goto L11;
        r1 = r12;
    L11:
        if ((r16 & 4) == 0) goto L13;
        String r2 = com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR;
    L15:
        if ((r16 & 8) == 0) goto L17;
        boolean r3 = true;
    L19:
        if ((r16 & 16) == 0) goto L21;
        JsbAuthConfig r4 = new JsbAuthConfig(false, false, null, 7, null);
    L22:
        this(r0, r1, r2, r3, r4);
        return;
    L21:
        r4 = r15;
        goto L22
    L17:
        r3 = r14;
        goto L19
    L13:
        r2 = r13;
        goto L15
    L5:
        r0 = r11;
        goto L7
    }
}
