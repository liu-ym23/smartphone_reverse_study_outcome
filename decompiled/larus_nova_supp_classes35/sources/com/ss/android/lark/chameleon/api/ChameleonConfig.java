package com.ss.android.lark.chameleon.api;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 E2\u00020\u0001:\u0002DEBq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0012J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ju\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020BHÖ\u0001J\b\u0010C\u001a\u00020\u0003H\u0016R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006F"}, d2 = {"Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "Ljava/io/Serializable;", "bizName", BuildConfig.FLAVOR, "loadUrl", "router", "Lcom/ss/android/lark/chameleon/api/RouteConfig;", "resConfig", "Lcom/ss/android/lark/chameleon/api/ResConfig;", "resInterceptConfig", "Lcom/ss/android/lark/chameleon/api/ResInterceptConfig;", "preloadConfig", "Lcom/ss/android/lark/chameleon/api/PreloadConfig;", "openConfig", "Lcom/ss/android/lark/chameleon/api/OpenConfig;", "webviewConfig", "Lcom/ss/android/lark/chameleon/api/WebviewConfig;", "appID", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chameleon/api/RouteConfig;Lcom/ss/android/lark/chameleon/api/ResConfig;Lcom/ss/android/lark/chameleon/api/ResInterceptConfig;Lcom/ss/android/lark/chameleon/api/PreloadConfig;Lcom/ss/android/lark/chameleon/api/OpenConfig;Lcom/ss/android/lark/chameleon/api/WebviewConfig;Ljava/lang/String;)V", "getAppID", "()Ljava/lang/String;", "setAppID", "(Ljava/lang/String;)V", "getBizName", "setBizName", "getLoadUrl", "setLoadUrl", "getOpenConfig", "()Lcom/ss/android/lark/chameleon/api/OpenConfig;", "setOpenConfig", "(Lcom/ss/android/lark/chameleon/api/OpenConfig;)V", "getPreloadConfig", "()Lcom/ss/android/lark/chameleon/api/PreloadConfig;", "setPreloadConfig", "(Lcom/ss/android/lark/chameleon/api/PreloadConfig;)V", "getResConfig", "()Lcom/ss/android/lark/chameleon/api/ResConfig;", "setResConfig", "(Lcom/ss/android/lark/chameleon/api/ResConfig;)V", "getResInterceptConfig", "()Lcom/ss/android/lark/chameleon/api/ResInterceptConfig;", "setResInterceptConfig", "(Lcom/ss/android/lark/chameleon/api/ResInterceptConfig;)V", "getRouter", "()Lcom/ss/android/lark/chameleon/api/RouteConfig;", "setRouter", "(Lcom/ss/android/lark/chameleon/api/RouteConfig;)V", "getWebviewConfig", "()Lcom/ss/android/lark/chameleon/api/WebviewConfig;", "setWebviewConfig", "(Lcom/ss/android/lark/chameleon/api/WebviewConfig;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Builder", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonConfig implements Serializable {
    public static final Companion Companion = null;
    public static final String STYLE_FULLSCREEN = "fullScreen";
    private String appID;
    private String bizName;
    private String loadUrl;
    private OpenConfig openConfig;
    private PreloadConfig preloadConfig;
    private ResConfig resConfig;
    private ResInterceptConfig resInterceptConfig;
    private RouteConfig router;
    private WebviewConfig webviewConfig;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0006\u00100\u001a\u000201J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010$\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010%J\u0010\u0010*\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010+R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/ss/android/lark/chameleon/api/ChameleonConfig$Builder;", BuildConfig.FLAVOR, "()V", "bizName", BuildConfig.FLAVOR, "getBizName", "()Ljava/lang/String;", "setBizName", "(Ljava/lang/String;)V", "loadUrl", "getLoadUrl", "setLoadUrl", "openConfig", "Lcom/ss/android/lark/chameleon/api/OpenConfig;", "getOpenConfig", "()Lcom/ss/android/lark/chameleon/api/OpenConfig;", "setOpenConfig", "(Lcom/ss/android/lark/chameleon/api/OpenConfig;)V", "preloadConfig", "Lcom/ss/android/lark/chameleon/api/PreloadConfig;", "getPreloadConfig", "()Lcom/ss/android/lark/chameleon/api/PreloadConfig;", "setPreloadConfig", "(Lcom/ss/android/lark/chameleon/api/PreloadConfig;)V", "resConfig", "Lcom/ss/android/lark/chameleon/api/ResConfig;", "getResConfig", "()Lcom/ss/android/lark/chameleon/api/ResConfig;", "setResConfig", "(Lcom/ss/android/lark/chameleon/api/ResConfig;)V", "resInterceptConfig", "Lcom/ss/android/lark/chameleon/api/ResInterceptConfig;", "getResInterceptConfig", "()Lcom/ss/android/lark/chameleon/api/ResInterceptConfig;", "setResInterceptConfig", "(Lcom/ss/android/lark/chameleon/api/ResInterceptConfig;)V", "router", "Lcom/ss/android/lark/chameleon/api/RouteConfig;", "getRouter", "()Lcom/ss/android/lark/chameleon/api/RouteConfig;", "setRouter", "(Lcom/ss/android/lark/chameleon/api/RouteConfig;)V", "webviewConfig", "Lcom/ss/android/lark/chameleon/api/WebviewConfig;", "getWebviewConfig", "()Lcom/ss/android/lark/chameleon/api/WebviewConfig;", "setWebviewConfig", "(Lcom/ss/android/lark/chameleon/api/WebviewConfig;)V", "build", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder {
        private String bizName;
        private String loadUrl;
        private OpenConfig openConfig;
        private PreloadConfig preloadConfig;
        private ResConfig resConfig;
        private ResInterceptConfig resInterceptConfig;
        private RouteConfig router;
        private WebviewConfig webviewConfig;

        public Builder() {
        }

        public final ChameleonConfig build() {
            return new ChameleonConfig(this.bizName, this.loadUrl, this.router, this.resConfig, this.resInterceptConfig, this.preloadConfig, this.openConfig, this.webviewConfig, null, 256, null);
        }

        public final String getBizName() {
            return this.bizName;
        }

        public final String getLoadUrl() {
            return this.loadUrl;
        }

        public final OpenConfig getOpenConfig() {
            return this.openConfig;
        }

        public final PreloadConfig getPreloadConfig() {
            return this.preloadConfig;
        }

        public final ResConfig getResConfig() {
            return this.resConfig;
        }

        public final ResInterceptConfig getResInterceptConfig() {
            return this.resInterceptConfig;
        }

        public final RouteConfig getRouter() {
            return this.router;
        }

        public final WebviewConfig getWebviewConfig() {
            return this.webviewConfig;
        }

        public final Builder bizName(String r1) {
            this.bizName = r1;
            return this;
        }

        public final Builder loadUrl(String r1) {
            this.loadUrl = r1;
            return this;
        }

        public final Builder openConfig(OpenConfig r1) {
            this.openConfig = r1;
            return this;
        }

        public final Builder preloadConfig(PreloadConfig r1) {
            this.preloadConfig = r1;
            return this;
        }

        public final Builder resConfig(ResConfig r1) {
            this.resConfig = r1;
            return this;
        }

        public final Builder resInterceptConfig(ResInterceptConfig r1) {
            this.resInterceptConfig = r1;
            return this;
        }

        public final Builder router(RouteConfig r1) {
            this.router = r1;
            return this;
        }

        public final void setBizName(String r1) {
            this.bizName = r1;
        }

        public final void setLoadUrl(String r1) {
            this.loadUrl = r1;
        }

        public final void setOpenConfig(OpenConfig r1) {
            this.openConfig = r1;
        }

        public final void setPreloadConfig(PreloadConfig r1) {
            this.preloadConfig = r1;
        }

        public final void setResConfig(ResConfig r1) {
            this.resConfig = r1;
        }

        public final void setResInterceptConfig(ResInterceptConfig r1) {
            this.resInterceptConfig = r1;
        }

        public final void setRouter(RouteConfig r1) {
            this.router = r1;
        }

        public final void setWebviewConfig(WebviewConfig r1) {
            this.webviewConfig = r1;
        }

        public final Builder webviewConfig(WebviewConfig r1) {
            this.webviewConfig = r1;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/api/ChameleonConfig$Companion;", BuildConfig.FLAVOR, "()V", "STYLE_FULLSCREEN", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    public ChameleonConfig() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ ChameleonConfig copy$default(ChameleonConfig r10, String r11, String r12, RouteConfig r13, ResConfig r14, ResInterceptConfig r15, PreloadConfig r16, OpenConfig r17, WebviewConfig r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.bizName;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.loadUrl;
    L11:
        if ((r20 & 4) == 0) goto L13;
        RouteConfig r4 = r10.router;
    L15:
        if ((r20 & 8) == 0) goto L17;
        ResConfig r5 = r10.resConfig;
    L19:
        if ((r20 & 16) == 0) goto L21;
        ResInterceptConfig r6 = r10.resInterceptConfig;
    L23:
        if ((r20 & 32) == 0) goto L25;
        PreloadConfig r7 = r10.preloadConfig;
    L27:
        if ((r20 & 64) == 0) goto L29;
        OpenConfig r8 = r10.openConfig;
    L31:
        if ((r20 & 128) == 0) goto L33;
        WebviewConfig r9 = r10.webviewConfig;
    L35:
        if ((r20 & 256) == 0) goto L37;
        String r1 = r10.appID;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final String component1() {
        return this.bizName;
    }

    public final String component2() {
        return this.loadUrl;
    }

    public final RouteConfig component3() {
        return this.router;
    }

    public final ResConfig component4() {
        return this.resConfig;
    }

    public final ResInterceptConfig component5() {
        return this.resInterceptConfig;
    }

    public final PreloadConfig component6() {
        return this.preloadConfig;
    }

    public final OpenConfig component7() {
        return this.openConfig;
    }

    public final WebviewConfig component8() {
        return this.webviewConfig;
    }

    public final String component9() {
        return this.appID;
    }

    public final ChameleonConfig copy(String r12, String r13, RouteConfig r14, ResConfig r15, ResInterceptConfig r16, PreloadConfig r17, OpenConfig r18, WebviewConfig r19, String r20) {
        return new ChameleonConfig(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChameleonConfig) == true) goto L8;
        return false;
    L8:
        ChameleonConfig r6 = (ChameleonConfig) r5;
        if (Intrinsics.areEqual(this.bizName, r6.bizName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.loadUrl, r6.loadUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.router, r6.router) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.resConfig, r6.resConfig) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.resInterceptConfig, r6.resInterceptConfig) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.preloadConfig, r6.preloadConfig) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.openConfig, r6.openConfig) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.webviewConfig, r6.webviewConfig) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.appID, r6.appID) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r0 = this.bizName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.loadUrl;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        RouteConfig r7 = this.router;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        ResConfig r10 = this.resConfig;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        ResInterceptConfig r13 = this.resInterceptConfig;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        PreloadConfig r16 = this.preloadConfig;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        OpenConfig r19 = this.openConfig;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        WebviewConfig r22 = this.webviewConfig;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.appID;
        if (r25 == null) goto L39;
        r1 = r25.hashCode();
    L39:
        return r24 + r1;
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ChameleonConfig(bizName=" + this.bizName + ", loadUrl=" + this.loadUrl + ", router=" + this.router + ", resConfig=" + this.resConfig + ", resInterceptConfig=" + this.resInterceptConfig + ", preloadConfig=" + this.preloadConfig + ", openConfig=" + this.openConfig + ", webviewConfig=" + this.webviewConfig + ", appID=" + this.appID + ')';
    }

    public final String getAppID() {
        return this.appID;
    }

    public final String getBizName() {
        return this.bizName;
    }

    public final String getLoadUrl() {
        return this.loadUrl;
    }

    public final OpenConfig getOpenConfig() {
        return this.openConfig;
    }

    public final PreloadConfig getPreloadConfig() {
        return this.preloadConfig;
    }

    public final ResConfig getResConfig() {
        return this.resConfig;
    }

    public final ResInterceptConfig getResInterceptConfig() {
        return this.resInterceptConfig;
    }

    public final RouteConfig getRouter() {
        return this.router;
    }

    public final WebviewConfig getWebviewConfig() {
        return this.webviewConfig;
    }

    public final void setAppID(String r1) {
        this.appID = r1;
    }

    public final void setBizName(String r1) {
        this.bizName = r1;
    }

    public final void setLoadUrl(String r1) {
        this.loadUrl = r1;
    }

    public final void setOpenConfig(OpenConfig r1) {
        this.openConfig = r1;
    }

    public final void setPreloadConfig(PreloadConfig r1) {
        this.preloadConfig = r1;
    }

    public final void setResConfig(ResConfig r1) {
        this.resConfig = r1;
    }

    public final void setResInterceptConfig(ResInterceptConfig r1) {
        this.resInterceptConfig = r1;
    }

    public final void setRouter(RouteConfig r1) {
        this.router = r1;
    }

    public final void setWebviewConfig(WebviewConfig r1) {
        this.webviewConfig = r1;
    }

    public ChameleonConfig(String r1, String r2, RouteConfig r3, ResConfig r4, ResInterceptConfig r5, PreloadConfig r6, OpenConfig r7, WebviewConfig r8, String r9) {
        this.bizName = r1;
        this.loadUrl = r2;
        this.router = r3;
        this.resConfig = r4;
        this.resInterceptConfig = r5;
        this.preloadConfig = r6;
        this.openConfig = r7;
        this.webviewConfig = r8;
        this.appID = r9;
    }

    public /* synthetic */ ChameleonConfig(String r11, String r12, RouteConfig r13, ResConfig r14, ResInterceptConfig r15, PreloadConfig r16, OpenConfig r17, WebviewConfig r18, String r19, int r20, DefaultConstructorMarker r21) {
        String r2 = null;
        if ((r20 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        RouteConfig r4 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        ResConfig r5 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        ResInterceptConfig r6 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        PreloadConfig r7 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        OpenConfig r8 = null;
    L31:
        if ((r20 & 128) == 0) goto L33;
        WebviewConfig r9 = null;
    L35:
        if ((r20 & 256) != 0) goto L38;
        r2 = r19;
    L38:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r2);
        return;
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
