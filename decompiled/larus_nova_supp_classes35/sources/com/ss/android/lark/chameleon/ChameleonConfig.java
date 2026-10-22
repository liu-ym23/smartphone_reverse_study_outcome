package com.ss.android.lark.chameleon;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 L2\u00020\u0001:\u0002LMB\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010:\u001a\u00020\u0000J\b\u0010;\u001a\u00020\u0003H\u0016J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0081\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IHÖ\u0003J\t\u0010J\u001a\u00020KHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0017\"\u0004\b9\u0010\u0019¨\u0006N"}, d2 = {"Lcom/ss/android/lark/chameleon/ChameleonConfig;", "Ljava/io/Serializable;", "bizName", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "loadUrl", "router", "Lcom/ss/android/lark/chameleon/RouteConfig;", "resConfig", "Lcom/ss/android/lark/chameleon/ResConfig;", "resInterceptConfig", "Lcom/ss/android/lark/chameleon/ResInterceptConfig;", "preloadConfig", "Lcom/ss/android/lark/chameleon/PreloadConfig;", "openConfig", "Lcom/ss/android/lark/chameleon/OpenConfig;", "webviewConfig", "Lcom/ss/android/lark/chameleon/WebviewConfig;", "dependency", "Lcom/ss/android/lark/chameleon/IDependency;", "subBizname", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chameleon/RouteConfig;Lcom/ss/android/lark/chameleon/ResConfig;Lcom/ss/android/lark/chameleon/ResInterceptConfig;Lcom/ss/android/lark/chameleon/PreloadConfig;Lcom/ss/android/lark/chameleon/OpenConfig;Lcom/ss/android/lark/chameleon/WebviewConfig;Lcom/ss/android/lark/chameleon/IDependency;Ljava/lang/String;)V", "getBizName", "()Ljava/lang/String;", "setBizName", "(Ljava/lang/String;)V", "getLoadUrl", "setLoadUrl", "getRouter", "()Lcom/ss/android/lark/chameleon/RouteConfig;", "setRouter", "(Lcom/ss/android/lark/chameleon/RouteConfig;)V", "getResConfig", "()Lcom/ss/android/lark/chameleon/ResConfig;", "setResConfig", "(Lcom/ss/android/lark/chameleon/ResConfig;)V", "getResInterceptConfig", "()Lcom/ss/android/lark/chameleon/ResInterceptConfig;", "setResInterceptConfig", "(Lcom/ss/android/lark/chameleon/ResInterceptConfig;)V", "getPreloadConfig", "()Lcom/ss/android/lark/chameleon/PreloadConfig;", "setPreloadConfig", "(Lcom/ss/android/lark/chameleon/PreloadConfig;)V", "getOpenConfig", "()Lcom/ss/android/lark/chameleon/OpenConfig;", "setOpenConfig", "(Lcom/ss/android/lark/chameleon/OpenConfig;)V", "getWebviewConfig", "()Lcom/ss/android/lark/chameleon/WebviewConfig;", "setWebviewConfig", "(Lcom/ss/android/lark/chameleon/WebviewConfig;)V", "getDependency", "()Lcom/ss/android/lark/chameleon/IDependency;", "setDependency", "(Lcom/ss/android/lark/chameleon/IDependency;)V", "getSubBizname", "setSubBizname", "copy", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "equals", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "other", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "hashCode", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "Companion", "Builder", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChameleonConfig implements Serializable {
    public static final Companion Companion = null;
    public static final String STYLE_FULLSCREEN = "fullScreen";
    private String bizName;
    private IDependency dependency;
    private String loadUrl;
    private OpenConfig openConfig;
    private PreloadConfig preloadConfig;
    private ResConfig resConfig;
    private ResInterceptConfig resInterceptConfig;
    private RouteConfig router;
    private String subBizname;
    private WebviewConfig webviewConfig;

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010%\u001a\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010&J\u0010\u0010+\u001a\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010,J\u0010\u00101\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u000102J\u0010\u00107\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\u0005J\u0006\u0010:\u001a\u00020;R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\t¨\u0006<"}, d2 = {"Lcom/ss/android/lark/chameleon/ChameleonConfig$Builder;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "()V", "bizName", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "getBizName", "()Ljava/lang/String;", "setBizName", "(Ljava/lang/String;)V", "loadUrl", "getLoadUrl", "setLoadUrl", "router", "Lcom/ss/android/lark/chameleon/RouteConfig;", "getRouter", "()Lcom/ss/android/lark/chameleon/RouteConfig;", "setRouter", "(Lcom/ss/android/lark/chameleon/RouteConfig;)V", "resConfig", "Lcom/ss/android/lark/chameleon/ResConfig;", "getResConfig", "()Lcom/ss/android/lark/chameleon/ResConfig;", "setResConfig", "(Lcom/ss/android/lark/chameleon/ResConfig;)V", "resInterceptConfig", "Lcom/ss/android/lark/chameleon/ResInterceptConfig;", "getResInterceptConfig", "()Lcom/ss/android/lark/chameleon/ResInterceptConfig;", "setResInterceptConfig", "(Lcom/ss/android/lark/chameleon/ResInterceptConfig;)V", "preloadConfig", "Lcom/ss/android/lark/chameleon/PreloadConfig;", "getPreloadConfig", "()Lcom/ss/android/lark/chameleon/PreloadConfig;", "setPreloadConfig", "(Lcom/ss/android/lark/chameleon/PreloadConfig;)V", "openConfig", "Lcom/ss/android/lark/chameleon/OpenConfig;", "getOpenConfig", "()Lcom/ss/android/lark/chameleon/OpenConfig;", "setOpenConfig", "(Lcom/ss/android/lark/chameleon/OpenConfig;)V", "webviewConfig", "Lcom/ss/android/lark/chameleon/WebviewConfig;", "getWebviewConfig", "()Lcom/ss/android/lark/chameleon/WebviewConfig;", "setWebviewConfig", "(Lcom/ss/android/lark/chameleon/WebviewConfig;)V", "dependency", "Lcom/ss/android/lark/chameleon/IDependency;", "getDependency", "()Lcom/ss/android/lark/chameleon/IDependency;", "setDependency", "(Lcom/ss/android/lark/chameleon/IDependency;)V", "subBizname", "getSubBizname", "setSubBizname", "build", "Lcom/ss/android/lark/chameleon/ChameleonConfig;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private String bizName;
        private IDependency dependency;
        private String loadUrl;
        private OpenConfig openConfig;
        private PreloadConfig preloadConfig;
        private ResConfig resConfig;
        private ResInterceptConfig resInterceptConfig;
        private RouteConfig router;
        private String subBizname;
        private WebviewConfig webviewConfig;

        public Builder() {
        }

        public final ChameleonConfig build() {
            return new ChameleonConfig(this.bizName, this.loadUrl, this.router, this.resConfig, this.resInterceptConfig, this.preloadConfig, this.openConfig, this.webviewConfig, this.dependency, this.subBizname);
        }

        public final String getBizName() {
            return this.bizName;
        }

        public final IDependency getDependency() {
            return this.dependency;
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

        public final String getSubBizname() {
            return this.subBizname;
        }

        public final WebviewConfig getWebviewConfig() {
            return this.webviewConfig;
        }

        public final Builder bizName(String r1) {
            this.bizName = r1;
            return this;
        }

        public final Builder dependency(IDependency r1) {
            this.dependency = r1;
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

        public final void setDependency(IDependency r1) {
            this.dependency = r1;
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

        public final void setSubBizname(String r1) {
            this.subBizname = r1;
        }

        public final void setWebviewConfig(WebviewConfig r1) {
            this.webviewConfig = r1;
        }

        public final Builder subBizname(String r1) {
            this.subBizname = r1;
            return this;
        }

        public final Builder webviewConfig(WebviewConfig r1) {
            this.webviewConfig = r1;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chameleon/ChameleonConfig$Companion;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "()V", "STYLE_FULLSCREEN", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ ChameleonConfig copy$default(ChameleonConfig r11, String r12, String r13, RouteConfig r14, ResConfig r15, ResInterceptConfig r16, PreloadConfig r17, OpenConfig r18, WebviewConfig r19, IDependency r20, String r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.bizName;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = r11.loadUrl;
    L11:
        if ((r22 & 4) == 0) goto L13;
        RouteConfig r4 = r11.router;
    L15:
        if ((r22 & 8) == 0) goto L17;
        ResConfig r5 = r11.resConfig;
    L19:
        if ((r22 & 16) == 0) goto L21;
        ResInterceptConfig r6 = r11.resInterceptConfig;
    L23:
        if ((r22 & 32) == 0) goto L25;
        PreloadConfig r7 = r11.preloadConfig;
    L27:
        if ((r22 & 64) == 0) goto L29;
        OpenConfig r8 = r11.openConfig;
    L31:
        if ((r22 & 128) == 0) goto L33;
        WebviewConfig r9 = r11.webviewConfig;
    L35:
        if ((r22 & 256) == 0) goto L37;
        IDependency r10 = r11.dependency;
    L39:
        if ((r22 & 512) == 0) goto L41;
        String r1 = r11.subBizname;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final String component1() {
        return this.bizName;
    }

    public final String component10() {
        return this.subBizname;
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

    public final IDependency component9() {
        return this.dependency;
    }

    public final ChameleonConfig copy(String r13, String r14, RouteConfig r15, ResConfig r16, ResInterceptConfig r17, PreloadConfig r18, OpenConfig r19, WebviewConfig r20, IDependency r21, String r22) {
        return new ChameleonConfig(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
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
        if (Intrinsics.areEqual(this.dependency, r6.dependency) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.subBizname, r6.subBizname) == true) goto L38;
        return false;
    L38:
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
        IDependency r25 = this.dependency;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.subBizname;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = r25.hashCode();
        goto L38
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

    public final ChameleonConfig copy() {
        String r2 = this.bizName;
        String r3 = this.loadUrl;
        RouteConfig r1 = this.router;
        if (r1 == null) goto L5;
        RouteConfig r5 = r1.copy();
    L6:
        ResConfig r4 = this.resConfig;
        if (r4 == null) goto L9;
        ResConfig r6 = r4.copy();
    L10:
        ResInterceptConfig r7 = this.resInterceptConfig;
        if (r7 == null) goto L13;
        ResInterceptConfig r8 = r7.copy();
    L14:
        PreloadConfig r13 = this.preloadConfig;
        if (r13 == null) goto L17;
        PreloadConfig r9 = PreloadConfig.copy$default(r13, null, null, 0, null, 15, null);
    L18:
        OpenConfig r10 = this.openConfig;
        if (r10 == null) goto L21;
        OpenConfig r11 = r10.copy();
    L22:
        WebviewConfig r12 = this.webviewConfig;
        if (r12 == null) goto L25;
        WebviewConfig r14 = r12.copy();
    L27:
        return new ChameleonConfig(r2, r3, r5, r6, r8, r9, r11, r14, this.dependency, this.subBizname);
    L25:
        r14 = null;
        goto L27
    L21:
        r11 = null;
        goto L22
    L17:
        r9 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public String toString() {
        return "ChameleonConfig(bizName=" + this.bizName + ", loadUrl=" + this.loadUrl + ", router=" + this.router + ", resConfig=" + this.resConfig + ", resInterceptConfig=" + this.resInterceptConfig + ", preloadConfig=" + this.preloadConfig + ", openConfig=" + this.openConfig + ", webviewConfig=" + this.webviewConfig + ", dependency=" + this.dependency + ", subBizname=" + this.subBizname + ')';
    }

    public final String getBizName() {
        return this.bizName;
    }

    public final IDependency getDependency() {
        return this.dependency;
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

    public final String getSubBizname() {
        return this.subBizname;
    }

    public final WebviewConfig getWebviewConfig() {
        return this.webviewConfig;
    }

    public final void setBizName(String r1) {
        this.bizName = r1;
    }

    public final void setDependency(IDependency r1) {
        this.dependency = r1;
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

    public final void setSubBizname(String r1) {
        this.subBizname = r1;
    }

    public final void setWebviewConfig(WebviewConfig r1) {
        this.webviewConfig = r1;
    }

    public ChameleonConfig(String r1, String r2, RouteConfig r3, ResConfig r4, ResInterceptConfig r5, PreloadConfig r6, OpenConfig r7, WebviewConfig r8, IDependency r9, String r10) {
        this.bizName = r1;
        this.loadUrl = r2;
        this.router = r3;
        this.resConfig = r4;
        this.resInterceptConfig = r5;
        this.preloadConfig = r6;
        this.openConfig = r7;
        this.webviewConfig = r8;
        this.dependency = r9;
        this.subBizname = r10;
    }

    public /* synthetic */ ChameleonConfig(String r12, String r13, RouteConfig r14, ResConfig r15, ResInterceptConfig r16, PreloadConfig r17, OpenConfig r18, WebviewConfig r19, IDependency r20, String r21, int r22, DefaultConstructorMarker r23) {
        String r2 = null;
        if ((r22 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        RouteConfig r4 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        ResConfig r5 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        ResInterceptConfig r6 = null;
    L23:
        if ((r22 & 32) == 0) goto L25;
        PreloadConfig r7 = null;
    L27:
        if ((r22 & 64) == 0) goto L29;
        OpenConfig r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        WebviewConfig r9 = null;
    L35:
        if ((r22 & 256) == 0) goto L37;
        IDependency r10 = null;
    L39:
        if ((r22 & 512) != 0) goto L42;
        r2 = r21;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r2);
        return;
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
