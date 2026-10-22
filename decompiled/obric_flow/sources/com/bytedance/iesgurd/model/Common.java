package com.bytedance.iesgurd.model;

import android.os.Build;
import androidx.annotation.Keep;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0010\u0010\u000e\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00068\u0002X\u0083D¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00068\u0002X\u0083D¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/iesgurd/model/Common;", "", "()V", Constant.APPID, "", "appVersion", "", "getAppVersion", "()Ljava/lang/String;", "setAppVersion", "(Ljava/lang/String;)V", "deviceId", "getDeviceId", "setDeviceId", "deviceModel", "osVersion", WsConstants.KEY_PLATFORM, "sdkEnv", "sdkVersion", "getEncryptStr", "init", "", "config", "Lcom/bytedance/geckox/GeckoGlobalConfig;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class Common {

    @SerializedName("app_id")
    private long appId;

    @SerializedName("app_version")
    private String appVersion;

    @SerializedName(WsConstants.KEY_DEVICE_ID)
    private String deviceId;

    @SerializedName("device_model")
    private final String deviceModel;

    @SerializedName("os_version")
    private final String osVersion;

    @SerializedName(WsConstants.KEY_PLATFORM)
    private final String platform;

    @SerializedName("sdk_env")
    private String sdkEnv;

    @SerializedName(WsConstants.KEY_SDK_VERSION)
    private final String sdkVersion;

    public Common() {
        this.appVersion = "";
        this.deviceId = "";
        this.sdkEnv = "";
        this.platform = "ANDROID";
        String r5 = Build.MODEL;
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        this.deviceModel = r5;
        this.osVersion = String.valueOf(Build.VERSION.SDK_INT) + "";
        this.sdkVersion = "5.2.4";
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getEncryptStr() {
        return this.appId + this.appVersion + this.platform + this.deviceModel + this.sdkVersion + this.osVersion;
    }

    public final void init(GeckoGlobalConfig r5) {
        this.appId = r5.getAppId();
        this.deviceId = r5.getDeviceId();
        this.appVersion = r5.getAppVersion();
        if (r5.getEnv() != GeckoGlobalConfig.ENVType.PROD) goto L5;
        String r10 = "ONLINE";
    L6:
        this.sdkEnv = r10;
        return;
    L5:
        r10 = "INHOUSE";
        goto L6
    }

    public final void setAppVersion(String r5) {
        this.appVersion = r5;
    }

    public final void setDeviceId(String r5) {
        this.deviceId = r5;
    }
}
