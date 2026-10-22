package com.bytedance.android.live.browser.jsbridge.base;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;
import w20.aa;
import w20.z9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0004\n\u0002\b4\u0018\u00002\u00020\u0001:\u0001XB\u0007¢\u0006\u0004\bV\u0010WR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR$\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR$\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010,\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010'\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R$\u0010/\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\r\"\u0004\b1\u0010\u000fR$\u00102\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000fR$\u00105\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR$\u00108\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR$\u0010;\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR$\u0010>\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR$\u0010A\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010'\u001a\u0004\bB\u0010)\"\u0004\bC\u0010+R\"\u0010D\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010\u000b\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR\"\u0010G\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010\u000b\u001a\u0004\bH\u0010\r\"\u0004\bI\u0010\u000fR\"\u0010J\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010\u000b\u001a\u0004\bK\u0010\r\"\u0004\bL\u0010\u000fR\"\u0010M\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010\u000b\u001a\u0004\bN\u0010\r\"\u0004\bO\u0010\u000fR\"\u0010P\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010\u000b\u001a\u0004\bQ\u0010\r\"\u0004\bR\u0010\u000fR\"\u0010S\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010\u000b\u001a\u0004\bT\u0010\r\"\u0004\bU\u0010\u000f¨\u0006Y"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/AppInfoResultModel;", "Lw20/aa;", "Lcom/bytedance/android/live/browser/jsbridge/base/AppInfoResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/AppInfoResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/AppInfoResultModel$Code;", "e", "(Lcom/bytedance/android/live/browser/jsbridge/base/AppInfoResultModel$Code;)V", "", "aid", "Ljava/lang/String;", "getAid", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "appName", "getAppName", "c", "appVersion", "getAppVersion", "d", "device_id", "getDevice_id", "i", "netType", "getNetType", "j", "user_id", "getUser_id", "t", "sec_user_id", "getSec_user_id", "q", "orientation", "a", "l", "", "screenHeight", "Ljava/lang/Number;", "getScreenHeight", "()Ljava/lang/Number;", "n", "(Ljava/lang/Number;)V", "screenWidth", "getScreenWidth", "o", "ac", "getAc", "setAc", "version_code", "getVersion_code", "v", "versionCode", "getVersionCode", "u", "idfa", "getIdfa", "setIdfa", "updateVersionCode", "getUpdateVersionCode", "s", "webcast_sdk_version", "getWebcast_sdk_version", "w", "start_time", "getStart_time", "r", "openId", "getOpenId", "k", "devicePlatform", "getDevicePlatform", "g", "osVersion", "getOsVersion", "m", "deviceType", "getDeviceType", "h", "deviceBrand", "getDeviceBrand", "f", "sdkVersion", "getSdkVersion", "p", "<init>", "()V", "Code", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AppInfoResultModel implements aa {

    @SerializedName("ac")
    private String ac;

    @SerializedName("aid")
    private String aid;

    @SerializedName("appName")
    private String appName;

    @SerializedName("appVersion")
    private String appVersion;

    @SerializedName("code")
    private Code code;

    @SerializedName("device_brand")
    private String deviceBrand;

    @SerializedName("device_platform")
    private String devicePlatform;

    @SerializedName("device_type")
    private String deviceType;

    @SerializedName("device_id")
    private String device_id;

    @SerializedName("idfa")
    private String idfa;

    @SerializedName("netType")
    private String netType;

    @SerializedName("open_id")
    private String openId;

    @SerializedName("orientation")
    private String orientation;

    @SerializedName("os_version")
    private String osVersion;

    @SerializedName("screenHeight")
    private Number screenHeight;

    @SerializedName("screenWidth")
    private Number screenWidth;

    @SerializedName("SDKVersion")
    private String sdkVersion;

    @SerializedName("sec_user_id")
    private String sec_user_id;

    @SerializedName("start_time")
    private Number start_time;

    @SerializedName("updateVersionCode")
    private String updateVersionCode;

    @SerializedName("user_id")
    private String user_id;

    @SerializedName("versionCode")
    private String versionCode;

    @SerializedName("version_code")
    private String version_code;

    @SerializedName("webcast_sdk_version")
    private String webcast_sdk_version;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/AppInfoResultModel$Code;", "", "Lw20/z9;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements z9 {
        public static final Code Failed = null;
        public static final Code Success = null;
        public static final /* synthetic */ Code[] a = null;
        private final int value;

        static {
            Code r1 = new Code("Success", 0, 1);
            Success = r1;
            Code r2 = new Code("Failed", 1, 0);
            Failed = r2;
            a = new Code[]{r1, r2};
        }

        public static Code valueOf(String r1) {
            return (Code) a.a(Code.class, r1);
        }

        public static Code[] values() {
            return (Code[]) a.clone();
        }

        @Override // w20.z9
        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Code(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public AppInfoResultModel() {
        this.openId = "";
        this.devicePlatform = "";
        this.osVersion = "";
        this.deviceType = "";
        this.deviceBrand = "";
        this.sdkVersion = "";
    }

    public final String a() {
        return this.orientation;
    }

    public final void b(String r1) {
        this.aid = r1;
    }

    public final void c(String r1) {
        this.appName = r1;
    }

    public final void d(String r1) {
        this.appVersion = r1;
    }

    public final void e(Code r1) {
        this.code = r1;
    }

    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.deviceBrand = r2;
    }

    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.devicePlatform = r2;
    }

    public final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.deviceType = r2;
    }

    public final void i(String r1) {
        this.device_id = r1;
    }

    public final void j(String r1) {
        this.netType = r1;
    }

    public final void k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.openId = r2;
    }

    public final void l(String r1) {
        this.orientation = r1;
    }

    public final void m(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.osVersion = r2;
    }

    public final void n(Number r1) {
        this.screenHeight = r1;
    }

    public final void o(Number r1) {
        this.screenWidth = r1;
    }

    public final void p(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.sdkVersion = r2;
    }

    public final void q(String r1) {
        this.sec_user_id = r1;
    }

    public final void r(Number r1) {
        this.start_time = r1;
    }

    public final void s(String r1) {
        this.updateVersionCode = r1;
    }

    public final void t(String r1) {
        this.user_id = r1;
    }

    public final void u(String r1) {
        this.versionCode = r1;
    }

    public final void v(String r1) {
        this.version_code = r1;
    }

    public final void w(String r1) {
        this.webcast_sdk_version = r1;
    }
}
