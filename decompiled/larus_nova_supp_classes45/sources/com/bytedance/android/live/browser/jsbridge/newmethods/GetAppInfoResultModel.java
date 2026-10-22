package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001:\u0001ZB\u0007¢\u0006\u0004\bX\u0010YR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR$\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR$\u0010(\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000fR$\u00105\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR$\u00108\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR$\u0010;\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR$\u0010>\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\bR$\u0010A\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000fR$\u0010D\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010\u000b\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR$\u0010G\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010\u000b\u001a\u0004\bH\u0010\r\"\u0004\bI\u0010\u000fR$\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bK\u0010M\"\u0004\bN\u0010OR$\u0010P\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010\u000b\u001a\u0004\bQ\u0010\r\"\u0004\bR\u0010\u000fR$\u0010S\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010L\u001a\u0004\bS\u0010M\"\u0004\bT\u0010OR$\u0010U\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010\u000b\u001a\u0004\bV\u0010\r\"\u0004\bW\u0010\u000f¨\u0006["}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/GetAppInfoResultModel;", "Lw20/aa;", "", "code", "Ljava/lang/Number;", "getCode", "()Ljava/lang/Number;", "setCode", "(Ljava/lang/Number;)V", "", "appID", "Ljava/lang/String;", "getAppID", "()Ljava/lang/String;", "setAppID", "(Ljava/lang/String;)V", "appName", "getAppName", "setAppName", "appVersion", "getAppVersion", "setAppVersion", "updateVersionCode", "getUpdateVersionCode", "setUpdateVersionCode", "networkType", "getNetworkType", "setNetworkType", "deviceID", "getDeviceID", "setDeviceID", "screenOrientation", "getScreenOrientation", "setScreenOrientation", "screenHeight", "getScreenHeight", "setScreenHeight", "screenWidth", "getScreenWidth", "setScreenWidth", "idfa", "getIdfa", "setIdfa", "Lcom/bytedance/android/live/browser/jsbridge/newmethods/GetAppInfoResultModel$GetAppInfoSafeArea;", "safeArea", "Lcom/bytedance/android/live/browser/jsbridge/newmethods/GetAppInfoResultModel$GetAppInfoSafeArea;", "getSafeArea", "()Lcom/bytedance/android/live/browser/jsbridge/newmethods/GetAppInfoResultModel$GetAppInfoSafeArea;", "setSafeArea", "(Lcom/bytedance/android/live/browser/jsbridge/newmethods/GetAppInfoResultModel$GetAppInfoSafeArea;)V", "channel", "getChannel", "setChannel", "language", "getLanguage", "setLanguage", "appTheme", "getAppTheme", "setAppTheme", "osVersion", "getOsVersion", "setOsVersion", "statusBarHeight", "getStatusBarHeight", "setStatusBarHeight", "devicePlatform", "getDevicePlatform", "setDevicePlatform", "deviceModel", "getDeviceModel", "setDeviceModel", "carrier", "getCarrier", "setCarrier", "", "is32Bit", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "set32Bit", "(Ljava/lang/Boolean;)V", "installID", "getInstallID", "setInstallID", "isTeenMode", "setTeenMode", "msg", "getMsg", "setMsg", "<init>", "()V", "GetAppInfoSafeArea", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GetAppInfoResultModel implements w20.aa {

    @SerializedName("appID")
    private String appID;

    @SerializedName("appName")
    private String appName;

    @SerializedName("appTheme")
    private String appTheme;

    @SerializedName("appVersion")
    private String appVersion;

    @SerializedName("carrier")
    private String carrier;

    @SerializedName("channel")
    private String channel;

    @SerializedName("code")
    private Number code;

    @SerializedName("deviceID")
    private String deviceID;

    @SerializedName("deviceModel")
    private String deviceModel;

    @SerializedName("devicePlatform")
    private String devicePlatform;

    @SerializedName("idfa")
    private String idfa;

    @SerializedName("installID")
    private String installID;

    @SerializedName("is32Bit")
    private Boolean is32Bit;

    @SerializedName("isTeenMode")
    private Boolean isTeenMode;

    @SerializedName("language")
    private String language;

    @SerializedName("msg")
    private String msg;

    @SerializedName("networkType")
    private String networkType;

    @SerializedName("osVersion")
    private String osVersion;

    @SerializedName("safeArea")
    private GetAppInfoSafeArea safeArea;

    @SerializedName("screenHeight")
    private Number screenHeight;

    @SerializedName("screenOrientation")
    private String screenOrientation;

    @SerializedName("screenWidth")
    private Number screenWidth;

    @SerializedName("statusBarHeight")
    private Number statusBarHeight;

    @SerializedName("updateVersionCode")
    private String updateVersionCode;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/GetAppInfoResultModel$GetAppInfoSafeArea;", "", "()V", "marginBottom", "", "getMarginBottom", "()Ljava/lang/Number;", "setMarginBottom", "(Ljava/lang/Number;)V", "marginLeft", "getMarginLeft", "setMarginLeft", "marginRight", "getMarginRight", "setMarginRight", "marginTop", "getMarginTop", "setMarginTop", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GetAppInfoSafeArea {

        @SerializedName("marginBottom")
        private Number marginBottom;

        @SerializedName("marginLeft")
        private Number marginLeft;

        @SerializedName("marginRight")
        private Number marginRight;

        @SerializedName("marginTop")
        private Number marginTop;

        public GetAppInfoSafeArea() {
        }

        public final Number getMarginBottom() {
            return this.marginBottom;
        }

        public final Number getMarginLeft() {
            return this.marginLeft;
        }

        public final Number getMarginRight() {
            return this.marginRight;
        }

        public final Number getMarginTop() {
            return this.marginTop;
        }

        public final void setMarginBottom(Number r1) {
            this.marginBottom = r1;
        }

        public final void setMarginLeft(Number r1) {
            this.marginLeft = r1;
        }

        public final void setMarginRight(Number r1) {
            this.marginRight = r1;
        }

        public final void setMarginTop(Number r1) {
            this.marginTop = r1;
        }
    }

    public GetAppInfoResultModel() {
    }

    public String empty() {
        return "";
    }

    public final String getAppID() {
        return this.appID;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppTheme() {
        return this.appTheme;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getCarrier() {
        return this.carrier;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final Number getCode() {
        return this.code;
    }

    public final String getDeviceID() {
        return this.deviceID;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final String getDevicePlatform() {
        return this.devicePlatform;
    }

    public final String getIdfa() {
        return this.idfa;
    }

    public final String getInstallID() {
        return this.installID;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getNetworkType() {
        return this.networkType;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final GetAppInfoSafeArea getSafeArea() {
        return this.safeArea;
    }

    public final Number getScreenHeight() {
        return this.screenHeight;
    }

    public final String getScreenOrientation() {
        return this.screenOrientation;
    }

    public final Number getScreenWidth() {
        return this.screenWidth;
    }

    public final Number getStatusBarHeight() {
        return this.statusBarHeight;
    }

    public final String getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    public final Boolean is32Bit() {
        return this.is32Bit;
    }

    public final Boolean isTeenMode() {
        return this.isTeenMode;
    }

    public final void set32Bit(Boolean r1) {
        this.is32Bit = r1;
    }

    public final void setAppID(String r1) {
        this.appID = r1;
    }

    public final void setAppName(String r1) {
        this.appName = r1;
    }

    public final void setAppTheme(String r1) {
        this.appTheme = r1;
    }

    public final void setAppVersion(String r1) {
        this.appVersion = r1;
    }

    public final void setCarrier(String r1) {
        this.carrier = r1;
    }

    public final void setChannel(String r1) {
        this.channel = r1;
    }

    public final void setCode(Number r1) {
        this.code = r1;
    }

    public final void setDeviceID(String r1) {
        this.deviceID = r1;
    }

    public final void setDeviceModel(String r1) {
        this.deviceModel = r1;
    }

    public final void setDevicePlatform(String r1) {
        this.devicePlatform = r1;
    }

    public final void setIdfa(String r1) {
        this.idfa = r1;
    }

    public final void setInstallID(String r1) {
        this.installID = r1;
    }

    public final void setLanguage(String r1) {
        this.language = r1;
    }

    public final void setMsg(String r1) {
        this.msg = r1;
    }

    public final void setNetworkType(String r1) {
        this.networkType = r1;
    }

    public final void setOsVersion(String r1) {
        this.osVersion = r1;
    }

    public final void setSafeArea(GetAppInfoSafeArea r1) {
        this.safeArea = r1;
    }

    public final void setScreenHeight(Number r1) {
        this.screenHeight = r1;
    }

    public final void setScreenOrientation(String r1) {
        this.screenOrientation = r1;
    }

    public final void setScreenWidth(Number r1) {
        this.screenWidth = r1;
    }

    public final void setStatusBarHeight(Number r1) {
        this.statusBarHeight = r1;
    }

    public final void setTeenMode(Boolean r1) {
        this.isTeenMode = r1;
    }

    public final void setUpdateVersionCode(String r1) {
        this.updateVersionCode = r1;
    }
}
