package com.ss.android.lark.chameleonv2.container.webcontainer.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.OpenConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/config/ChameleonOpenConfig;", "Ljava/io/Serializable;", "<init>", "()V", "showTabBar", BuildConfig.FLAVOR, "getShowTabBar", "()Z", "setShowTabBar", "(Z)V", "showDefaultLoading", "getShowDefaultLoading", "setShowDefaultLoading", "loadingTimeout", BuildConfig.FLAVOR, "getLoadingTimeout", "()J", "setLoadingTimeout", "(J)V", "hideLoadingByJS", "getHideLoadingByJS", "setHideLoadingByJS", "statisticsByJS", "getStatisticsByJS", "setStatisticsByJS", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChameleonOpenConfig implements Serializable {

    @SerializedName("hideLoadingByJS")
    private boolean hideLoadingByJS;

    @SerializedName("loadingTimeout")
    private long loadingTimeout;

    @SerializedName("showDefaultLoading")
    private boolean showDefaultLoading;

    @SerializedName("showTabBar")
    private boolean showTabBar;

    @SerializedName("statisticsByJS")
    private boolean statisticsByJS;

    public ChameleonOpenConfig() {
        this.showTabBar = true;
        this.showDefaultLoading = true;
        this.loadingTimeout = OpenConfig.DEFAULT_LOADING_TIMEOUT;
    }

    public final boolean getHideLoadingByJS() {
        return this.hideLoadingByJS;
    }

    public final long getLoadingTimeout() {
        return this.loadingTimeout;
    }

    public final boolean getShowDefaultLoading() {
        return this.showDefaultLoading;
    }

    public final boolean getShowTabBar() {
        return this.showTabBar;
    }

    public final boolean getStatisticsByJS() {
        return this.statisticsByJS;
    }

    public final void setHideLoadingByJS(boolean r1) {
        this.hideLoadingByJS = r1;
    }

    public final void setLoadingTimeout(long r1) {
        this.loadingTimeout = r1;
    }

    public final void setShowDefaultLoading(boolean r1) {
        this.showDefaultLoading = r1;
    }

    public final void setShowTabBar(boolean r1) {
        this.showTabBar = r1;
    }

    public final void setStatisticsByJS(boolean r1) {
        this.statisticsByJS = r1;
    }
}
