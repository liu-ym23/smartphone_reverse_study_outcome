package com.bytedance.ai.bridge.method.info;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL$GetAppInfoParamModel;", "Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL$GetAppInfoResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "GetAppInfoParamModel", "GetAppInfoResultModel", "GetAppInfoSafeArea", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetAppInfoMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "is32Bit", required = true)
        void set32Bit(Boolean r1);

        @AIBridgeParamField(keyPath = "appBackgroundColor", required = false)
        void setAppBackgroundColor(String r1);

        @AIBridgeParamField(keyPath = "appID", required = true)
        void setAppID(String r1);

        @AIBridgeParamField(keyPath = BdpAwemeConstant.KEY_APP_NAME, required = true)
        void setAppName(String r1);

        @AIBridgeParamField(keyPath = "appTheme", required = true)
        void setAppTheme(String r1);

        @AIBridgeParamField(keyPath = "appVersion", required = true)
        void setAppVersion(String r1);

        @AIBridgeParamField(keyPath = "isBaseMode", required = true)
        void setBaseMode(Boolean r1);

        @AIBridgeParamField(keyPath = "carrier", required = true)
        void setCarrier(String r1);

        @AIBridgeParamField(keyPath = "channel", required = true)
        void setChannel(String r1);

        @AIBridgeParamField(keyPath = "clientDid", required = false)
        void setClientDid(String r1);

        @AIBridgeParamField(keyPath = "deviceBrand", required = false)
        void setDeviceBrand(String r1);

        @AIBridgeParamField(keyPath = "deviceID", required = true)
        void setDeviceID(String r1);

        @AIBridgeParamField(keyPath = "deviceModel", required = true)
        void setDeviceModel(String r1);

        @AIBridgeParamField(keyPath = "devicePlatform", required = true)
        void setDevicePlatform(String r1);

        @AIBridgeParamField(keyPath = "idfa", required = false)
        void setIdfa(String r1);

        @AIBridgeParamField(keyPath = "installID", required = true)
        void setInstallID(String r1);

        @AIBridgeParamField(keyPath = "language", required = true)
        void setLanguage(String r1);

        @AIBridgeParamField(keyPath = "netType", required = true)
        void setNetType(String r1);

        @AIBridgeParamField(keyPath = "networkType", required = true)
        void setNetworkType(String r1);

        @AIBridgeParamField(keyPath = "osVersion", required = true)
        void setOsVersion(String r1);

        @AIBridgeParamField(keyPath = "packageName", required = false)
        void setPackageName(String r1);

        @AIBridgeParamField(keyPath = "safeArea", required = false)
        void setSafeArea(JsonObject r1);

        @AIBridgeParamField(keyPath = "screenHeight", required = true)
        void setScreenHeight(Number r1);

        @AIBridgeParamField(keyPath = "screenOrientation", required = true)
        void setScreenOrientation(String r1);

        @AIBridgeParamField(keyPath = "screenWidth", required = true)
        void setScreenWidth(Number r1);

        @AIBridgeParamField(keyPath = "statusBarHeight", required = true)
        void setStatusBarHeight(Number r1);

        @AIBridgeParamField(keyPath = "isTeenMode", required = true)
        void setTeenMode(Boolean r1);

        @AIBridgeParamField(keyPath = "updateVersionCode", required = true)
        void setUpdateVersionCode(String r1);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL$GetAppInfoSafeArea;", "", "marginTop", "", "marginBottom", "marginLeft", "marginRight", "<init>", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)V", "getMarginTop", "()Ljava/lang/Number;", "getMarginBottom", "getMarginLeft", "getMarginRight", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c {

        @SerializedName("marginBottom")
        private final Number marginBottom;

        @SerializedName("marginLeft")
        private final Number marginLeft;

        @SerializedName("marginRight")
        private final Number marginRight;

        @SerializedName("marginTop")
        private final Number marginTop;

        public c() {
            this(null, null, null, null);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (Intrinsics.areEqual(this.marginTop, r11.marginTop) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.marginBottom, r11.marginBottom) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.marginLeft, r11.marginLeft) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.marginRight, r11.marginRight) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Number r0 = this.marginTop;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = r10 * 31;
            Number r12 = this.marginBottom;
            if (r12 != null) goto L9;
            int r13 = 0;
        L10:
            int r14 = (r11 + r13) * 31;
            Number r15 = this.marginLeft;
            if (r15 != null) goto L13;
            int r16 = 0;
        L14:
            int r17 = (r14 + r16) * 31;
            Number r18 = this.marginRight;
            if (r18 == null) goto L19;
            r1 = r18.hashCode();
        L19:
            return r17 + r1;
        L13:
            r16 = r15.hashCode();
            goto L14
        L9:
            r13 = r12.hashCode();
            goto L10
        L5:
            r10 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "GetAppInfoSafeArea(marginTop=" + this.marginTop + ", marginBottom=" + this.marginBottom + ", marginLeft=" + this.marginLeft + ", marginRight=" + this.marginRight + ')';
        }

        public c(Number r1, Number r10, Number r11, Number r12) {
            this.marginTop = r1;
            this.marginBottom = r10;
            this.marginLeft = r11;
            this.marginRight = r12;
        }
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsGetAppInfoMethodIDL() {
        this.a = "applet.getAppInfo";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
