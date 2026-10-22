package com.bytedance.ai.bridge.method.info;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000e\u000f\u0010B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL$GetAppInfoParamModel;", "Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL$GetAppInfoResultModel;", "<init>", "()V", "", "mustRunInMain", "()Z", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "GetAppInfoParamModel", "GetAppInfoResultModel", "a", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsGetAppInfoMethodIDL extends CoreAIBridgeMethod<GetAppInfoParamModel, GetAppInfoResultModel> {
    private final String name;

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL$GetAppInfoParamModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface GetAppInfoParamModel extends ParamModel {
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0004\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u000f\bg\u0018\u00002\u00020\u0001R&\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR&\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR&\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR&\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR&\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR&\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR&\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b@gX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010 \u001a\u0004\u0018\u00010\u001b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b@gX¦\u000e¢\u0006\f\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR&\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR&\u0010%\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR&\u0010(\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR&\u0010,\u001a\u0004\u0018\u00010+2\b\u0010\u0002\u001a\u0004\u0018\u00010+@gX¦\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R&\u00101\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR&\u00104\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR&\u00107\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR&\u0010:\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR&\u0010=\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR&\u0010@\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR&\u0010C\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u001b@gX¦\u000e¢\u0006\f\u001a\u0004\bC\u0010\u001d\"\u0004\bD\u0010\u001fR&\u0010E\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR&\u0010H\u001a\u0004\u0018\u00010+2\b\u0010\u0002\u001a\u0004\u0018\u00010+@gX¦\u000e¢\u0006\f\u001a\u0004\bI\u0010.\"\u0004\bJ\u00100R&\u0010K\u001a\u0004\u0018\u00010+2\b\u0010\u0002\u001a\u0004\u0018\u00010+@gX¦\u000e¢\u0006\f\u001a\u0004\bL\u0010.\"\u0004\bM\u00100R&\u0010N\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR&\u0010R\u001a\u0004\u0018\u00010Q2\b\u0010\u0002\u001a\u0004\u0018\u00010Q@gX¦\u000e¢\u0006\f\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR&\u0010W\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\bX\u0010\u0006\"\u0004\bY\u0010\bR&\u0010Z\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b[\u0010\u0006\"\u0004\b\\\u0010\bR&\u0010]\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b^\u0010\u0006\"\u0004\b_\u0010\b¨\u0006`"}, d2 = {"Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL$GetAppInfoResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "value", "", "appID", "getAppID", "()Ljava/lang/String;", "setAppID", "(Ljava/lang/String;)V", "installID", "getInstallID", "setInstallID", "appName", "getAppName", "setAppName", "appVersion", "getAppVersion", "setAppVersion", "updateVersionCode", "getUpdateVersionCode", "setUpdateVersionCode", LynxMonitorService.KEY_CHANNEL, "getChannel", "setChannel", "language", "getLanguage", "setLanguage", "", "isTeenMode", "()Ljava/lang/Boolean;", "setTeenMode", "(Ljava/lang/Boolean;)V", "isBaseMode", "setBaseMode", "appTheme", "getAppTheme", "setAppTheme", "deviceID", "getDeviceID", "setDeviceID", "osVersion", "getOsVersion", "setOsVersion", "", "statusBarHeight", "getStatusBarHeight", "()Ljava/lang/Number;", "setStatusBarHeight", "(Ljava/lang/Number;)V", "devicePlatform", "getDevicePlatform", "setDevicePlatform", "deviceModel", "getDeviceModel", "setDeviceModel", "deviceBrand", "getDeviceBrand", "setDeviceBrand", "netType", "getNetType", "setNetType", "networkType", "getNetworkType", "setNetworkType", "carrier", "getCarrier", "setCarrier", "is32Bit", "set32Bit", "idfa", "getIdfa", "setIdfa", "screenWidth", "getScreenWidth", "setScreenWidth", "screenHeight", "getScreenHeight", "setScreenHeight", "screenOrientation", "getScreenOrientation", "setScreenOrientation", "Lcom/google/gson/JsonObject;", "safeArea", "getSafeArea", "()Lcom/google/gson/JsonObject;", "setSafeArea", "(Lcom/google/gson/JsonObject;)V", "packageName", "getPackageName", "setPackageName", "clientDid", "getClientDid", "setClientDid", "appBackgroundColor", "getAppBackgroundColor", "setAppBackgroundColor", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface GetAppInfoResultModel extends ResultModel {
        String getAppBackgroundColor();

        String getAppID();

        String getAppName();

        String getAppTheme();

        String getAppVersion();

        String getCarrier();

        String getChannel();

        String getClientDid();

        String getDeviceBrand();

        String getDeviceID();

        String getDeviceModel();

        String getDevicePlatform();

        String getIdfa();

        String getInstallID();

        String getLanguage();

        String getNetType();

        String getNetworkType();

        String getOsVersion();

        String getPackageName();

        JsonObject getSafeArea();

        Number getScreenHeight();

        String getScreenOrientation();

        Number getScreenWidth();

        Number getStatusBarHeight();

        String getUpdateVersionCode();

        Boolean is32Bit();

        Boolean isBaseMode();

        Boolean isTeenMode();

        @AIBridgeParamField(keyPath = "is32Bit", required = true)
        void set32Bit(Boolean r5);

        @AIBridgeParamField(keyPath = "appBackgroundColor", required = false)
        void setAppBackgroundColor(String r5);

        @AIBridgeParamField(keyPath = "appID", required = true)
        void setAppID(String r5);

        @AIBridgeParamField(keyPath = "appName", required = true)
        void setAppName(String r5);

        @AIBridgeParamField(keyPath = "appTheme", required = true)
        void setAppTheme(String r5);

        @AIBridgeParamField(keyPath = "appVersion", required = true)
        void setAppVersion(String r5);

        @AIBridgeParamField(keyPath = "isBaseMode", required = true)
        void setBaseMode(Boolean r5);

        @AIBridgeParamField(keyPath = "carrier", required = true)
        void setCarrier(String r5);

        @AIBridgeParamField(keyPath = LynxMonitorService.KEY_CHANNEL, required = true)
        void setChannel(String r5);

        @AIBridgeParamField(keyPath = "clientDid", required = false)
        void setClientDid(String r5);

        @AIBridgeParamField(keyPath = "deviceBrand", required = false)
        void setDeviceBrand(String r5);

        @AIBridgeParamField(keyPath = "deviceID", required = true)
        void setDeviceID(String r5);

        @AIBridgeParamField(keyPath = "deviceModel", required = true)
        void setDeviceModel(String r5);

        @AIBridgeParamField(keyPath = "devicePlatform", required = true)
        void setDevicePlatform(String r5);

        @AIBridgeParamField(keyPath = "idfa", required = false)
        void setIdfa(String r5);

        @AIBridgeParamField(keyPath = "installID", required = true)
        void setInstallID(String r5);

        @AIBridgeParamField(keyPath = "language", required = true)
        void setLanguage(String r5);

        @AIBridgeParamField(keyPath = "netType", required = true)
        void setNetType(String r5);

        @AIBridgeParamField(keyPath = "networkType", required = true)
        void setNetworkType(String r5);

        @AIBridgeParamField(keyPath = "osVersion", required = true)
        void setOsVersion(String r5);

        @AIBridgeParamField(keyPath = "packageName", required = false)
        void setPackageName(String r5);

        @AIBridgeParamField(keyPath = "safeArea", required = false)
        void setSafeArea(JsonObject r5);

        @AIBridgeParamField(keyPath = "screenHeight", required = true)
        void setScreenHeight(Number r5);

        @AIBridgeParamField(keyPath = "screenOrientation", required = true)
        void setScreenOrientation(String r5);

        @AIBridgeParamField(keyPath = "screenWidth", required = true)
        void setScreenWidth(Number r5);

        @AIBridgeParamField(keyPath = "statusBarHeight", required = true)
        void setStatusBarHeight(Number r5);

        @AIBridgeParamField(keyPath = "isTeenMode", required = true)
        void setTeenMode(Boolean r5);

        @AIBridgeParamField(keyPath = "updateVersionCode", required = true)
        void setUpdateVersionCode(String r5);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL$a;", "", "", "a", "Ljava/lang/Number;", "getMarginTop", "()Ljava/lang/Number;", "marginTop", "b", "getMarginBottom", "marginBottom", "c", "getMarginLeft", "marginLeft", "d", "getMarginRight", "marginRight", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("marginTop")
        private final Number f1829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("marginBottom")
        private final Number f1830b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("marginLeft")
        private final Number f1831c;

        @SerializedName("marginRight")
        private final Number d;

        public a() {
            this(null, null, null, null);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r10 = (a) r5;
            if (Intrinsics.areEqual(this.f1829a, r10.f1829a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f1830b, r10.f1830b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f1831c, r10.f1831c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Number r5 = this.f1829a;
            int r10 = 0;
            if (r5 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = r11 * 31;
            Number r13 = this.f1830b;
            if (r13 != null) goto L9;
            int r14 = 0;
        L10:
            int r15 = (r12 + r14) * 31;
            Number r16 = this.f1831c;
            if (r16 != null) goto L13;
            int r17 = 0;
        L14:
            int r18 = (r15 + r17) * 31;
            Number r19 = this.d;
            if (r19 == null) goto L19;
            r10 = r19.hashCode();
        L19:
            return r18 + r10;
        L13:
            r17 = r16.hashCode();
            goto L14
        L9:
            r14 = r13.hashCode();
            goto L10
        L5:
            r11 = r5.hashCode();
            goto L6
        }

        public final String toString() {
            return "GetAppInfoSafeArea(marginTop=" + this.f1829a + ", marginBottom=" + this.f1830b + ", marginLeft=" + this.f1831c + ", marginRight=" + this.d + ')';
        }

        public a(Integer r5, Integer r10, Integer r11, Integer r12) {
            this.f1829a = r5;
            this.f1830b = r10;
            this.f1831c = r11;
            this.d = r12;
        }
    }

    public AbsGetAppInfoMethodIDL() {
        this.name = "applet.getAppInfo";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public boolean mustRunInMain() {
        return true;
    }
}
