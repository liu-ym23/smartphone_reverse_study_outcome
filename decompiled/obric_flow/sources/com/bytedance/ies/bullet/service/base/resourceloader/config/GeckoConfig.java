package com.bytedance.ies.bullet.service.base.resourceloader.config;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wc.c;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b/\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\f\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0018\u001a\u0004\b\b\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\"\u0010\u001e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001bR\"\u0010!\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\"\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001bR\"\u0010'\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0018\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\f\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R$\u0010-\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00103\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\f\u001a\u0004\b4\u0010\u000e\"\u0004\b5\u0010\u0010¨\u00066"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/resourceloader/config/GeckoConfig;", "", "", "accessKey", "offlineDir", "Lwc/c;", "loaderDepender", "", "isRelativePath", "loopCheck", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lwc/c;ZZ)V", "Ljava/lang/String;", "getAccessKey", "()Ljava/lang/String;", "setAccessKey", "(Ljava/lang/String;)V", "getOfflineDir", "setOfflineDir", "Lwc/c;", "getLoaderDepender", "()Lwc/c;", "setLoaderDepender", "(Lwc/c;)V", "Z", "()Z", "setRelativePath", "(Z)V", "getLoopCheck", "setLoopCheck", "useGeckoXV4", "getUseGeckoXV4", "setUseGeckoXV4", "serverMonitor", "getServerMonitor", "setServerMonitor", "updateWhenInit", "getUpdateWhenInit", "setUpdateWhenInit", "appLogMonitor", "getAppLogMonitor", "setAppLogMonitor", "localInfo", "getLocalInfo", "setLocalInfo", "networkImpl", "Ljava/lang/Object;", "getNetworkImpl", "()Ljava/lang/Object;", "setNetworkImpl", "(Ljava/lang/Object;)V", "businessVersion", "getBusinessVersion", "setBusinessVersion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GeckoConfig {
    private String accessKey;
    private boolean appLogMonitor;
    private String businessVersion;
    private boolean isRelativePath;
    private c loaderDepender;
    private String localInfo;
    private boolean loopCheck;
    private Object networkImpl;
    private String offlineDir;
    private boolean serverMonitor;
    private boolean updateWhenInit;
    private boolean useGeckoXV4;

    public GeckoConfig(String r5, String r10, c r11, boolean r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r5, "accessKey");
        Intrinsics.checkNotNullParameter(r10, "offlineDir");
        Intrinsics.checkNotNullParameter(r11, "loaderDepender");
        this.accessKey = r5;
        this.offlineDir = r10;
        this.loaderDepender = r11;
        this.isRelativePath = r12;
        this.loopCheck = r13;
        this.useGeckoXV4 = true;
        this.serverMonitor = true;
        this.localInfo = "";
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final boolean getAppLogMonitor() {
        return this.appLogMonitor;
    }

    public final String getBusinessVersion() {
        return this.businessVersion;
    }

    public final c getLoaderDepender() {
        return this.loaderDepender;
    }

    public final String getLocalInfo() {
        return this.localInfo;
    }

    public final boolean getLoopCheck() {
        return this.loopCheck;
    }

    public final Object getNetworkImpl() {
        return this.networkImpl;
    }

    public final String getOfflineDir() {
        return this.offlineDir;
    }

    public final boolean getServerMonitor() {
        return this.serverMonitor;
    }

    public final boolean getUpdateWhenInit() {
        return this.updateWhenInit;
    }

    public final boolean getUseGeckoXV4() {
        return this.useGeckoXV4;
    }

    public final boolean isRelativePath() {
        return this.isRelativePath;
    }

    public final void setAccessKey(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.accessKey = r5;
    }

    public final void setAppLogMonitor(boolean r5) {
        this.appLogMonitor = r5;
    }

    public final void setBusinessVersion(String r5) {
        this.businessVersion = r5;
    }

    public final void setLoaderDepender(c r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.loaderDepender = r5;
    }

    public final void setLocalInfo(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.localInfo = r5;
    }

    public final void setLoopCheck(boolean r5) {
        this.loopCheck = r5;
    }

    public final void setNetworkImpl(Object r5) {
        this.networkImpl = r5;
    }

    public final void setOfflineDir(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.offlineDir = r5;
    }

    public final void setRelativePath(boolean r5) {
        this.isRelativePath = r5;
    }

    public final void setServerMonitor(boolean r5) {
        this.serverMonitor = r5;
    }

    public final void setUpdateWhenInit(boolean r5) {
        this.updateWhenInit = r5;
    }

    public final void setUseGeckoXV4(boolean r5) {
        this.useGeckoXV4 = r5;
    }

    public /* synthetic */ GeckoConfig(String r10, String r11, c r12, boolean r13, boolean r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 8) == 0) goto L5;
        r13 = true;
    L5:
        boolean r5 = r13;
        if ((r15 & 16) == 0) goto L8;
        r14 = false;
    L8:
        this(r10, r11, r12, r5, r14);
    }
}
