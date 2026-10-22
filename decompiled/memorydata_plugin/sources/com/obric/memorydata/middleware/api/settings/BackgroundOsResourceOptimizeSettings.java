package com.obric.memorydata.middleware.api.settings;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/BackgroundOsResourceOptimizeSettings;", "", "enable", "", "networkInterceptConfig", "Lcom/obric/memorydata/middleware/api/settings/NetworkInterceptConfig;", "backgroundNetworkModeConfig", "Lcom/obric/memorydata/middleware/api/settings/BackgroundNetworkModeConfig;", "<init>", "(ZLcom/obric/memorydata/middleware/api/settings/NetworkInterceptConfig;Lcom/obric/memorydata/middleware/api/settings/BackgroundNetworkModeConfig;)V", "getEnable", "()Z", "getNetworkInterceptConfig", "()Lcom/obric/memorydata/middleware/api/settings/NetworkInterceptConfig;", "getBackgroundNetworkModeConfig", "()Lcom/obric/memorydata/middleware/api/settings/BackgroundNetworkModeConfig;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BackgroundOsResourceOptimizeSettings {

    @SerializedName("background_network_mode_config")
    private final BackgroundNetworkModeConfig backgroundNetworkModeConfig;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("network_intercept_config")
    private final NetworkInterceptConfig networkInterceptConfig;

    public BackgroundOsResourceOptimizeSettings() {
        this(false, null, null, 7, null);
    }

    public BackgroundOsResourceOptimizeSettings(boolean r2, NetworkInterceptConfig r3, BackgroundNetworkModeConfig r4) {
        Intrinsics.checkNotNullParameter(r3, "networkInterceptConfig");
        Intrinsics.checkNotNullParameter(r4, "backgroundNetworkModeConfig");
        this.enable = r2;
        this.networkInterceptConfig = r3;
        this.backgroundNetworkModeConfig = r4;
    }

    public /* synthetic */ BackgroundOsResourceOptimizeSettings(boolean r10, NetworkInterceptConfig r11, BackgroundNetworkModeConfig r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = true;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = new NetworkInterceptConfig(false, null, null, false, 15, null);
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = new BackgroundNetworkModeConfig(0, false, false, false, 0, 31, null);
    L11:
        this(r10, r11, r12);
    }

    public static /* synthetic */ BackgroundOsResourceOptimizeSettings copy$default(BackgroundOsResourceOptimizeSettings r0, boolean r1, NetworkInterceptConfig r2, BackgroundNetworkModeConfig r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.enable;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.networkInterceptConfig;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.backgroundNetworkModeConfig;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final NetworkInterceptConfig component2() {
        return this.networkInterceptConfig;
    }

    public final BackgroundNetworkModeConfig component3() {
        return this.backgroundNetworkModeConfig;
    }

    public final BackgroundOsResourceOptimizeSettings copy(boolean r1, NetworkInterceptConfig r2, BackgroundNetworkModeConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "networkInterceptConfig");
        Intrinsics.checkNotNullParameter(r3, "backgroundNetworkModeConfig");
        return new BackgroundOsResourceOptimizeSettings(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BackgroundOsResourceOptimizeSettings.class) == true) goto L8;
        return false;
    L8:
        BackgroundOsResourceOptimizeSettings r6 = (BackgroundOsResourceOptimizeSettings) ZeusTransformUtils.preCheckCast(r5, BackgroundOsResourceOptimizeSettings.class, "com.obric.memorydata.plugin");
        if (this.enable == r6.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.networkInterceptConfig, r6.networkInterceptConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.backgroundNetworkModeConfig, r6.backgroundNetworkModeConfig) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final BackgroundNetworkModeConfig getBackgroundNetworkModeConfig() {
        return this.backgroundNetworkModeConfig;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final NetworkInterceptConfig getNetworkInterceptConfig() {
        return this.networkInterceptConfig;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.enable) * 31) + this.networkInterceptConfig.hashCode()) * 31) + this.backgroundNetworkModeConfig.hashCode();
    }

    public String toString() {
        return "BackgroundOsResourceOptimizeSettings(enable=" + this.enable + ", networkInterceptConfig=" + this.networkInterceptConfig + ", backgroundNetworkModeConfig=" + this.backgroundNetworkModeConfig + ')';
    }
}
