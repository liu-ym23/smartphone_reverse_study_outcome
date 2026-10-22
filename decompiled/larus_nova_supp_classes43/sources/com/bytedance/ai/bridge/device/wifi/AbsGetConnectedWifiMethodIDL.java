package com.bytedance.ai.bridge.device.wifi;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/device/wifi/AbsGetConnectedWifiMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/device/wifi/AbsGetConnectedWifiMethodIDL$GetConnectedWifiParamModel;", "Lcom/bytedance/ai/bridge/device/wifi/AbsGetConnectedWifiMethodIDL$GetConnectedWifiResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "GetConnectedWifiParamModel", "GetConnectedWifiResultModel", "WifiInfo", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetConnectedWifiMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017JH\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\nHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/bytedance/ai/bridge/device/wifi/AbsGetConnectedWifiMethodIDL$WifiInfo;", "", "ssid", "", "bssid", "secure", "", "signalStrength", "", "frequency", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;)V", "getSsid", "()Ljava/lang/String;", "getBssid", "getSecure", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSignalStrength", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getFrequency", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;)Lcom/bytedance/ai/bridge/device/wifi/AbsGetConnectedWifiMethodIDL$WifiInfo;", "equals", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WifiInfo {

        @SerializedName("bssid")
        private final String bssid;

        @SerializedName("frequency")
        private final Integer frequency;

        @SerializedName("secure")
        private final Boolean secure;

        @SerializedName("signalStrength")
        private final Double signalStrength;

        @SerializedName("ssid")
        private final String ssid;

        public static /* synthetic */ WifiInfo copy$default(WifiInfo r10, String r11, String r12, Boolean r13, Double r14, Integer r15, int r16, Object r17) {
            if ((r16 & 1) == 0) goto L6;
            r11 = r10.ssid;
        L6:
            if ((r16 & 2) == 0) goto L8;
            r12 = r10.bssid;
        L8:
            String r18 = r12;
            if ((r16 & 4) == 0) goto L11;
            r13 = r10.secure;
        L11:
            Boolean r0 = r13;
            if ((r16 & 8) == 0) goto L14;
            r14 = r10.signalStrength;
        L14:
            Double r1 = r14;
            if ((r16 & 16) == 0) goto L17;
            r15 = r10.frequency;
        L17:
            String r19 = r11;
            return r10.copy(r19, r18, r0, r1, r15);
        }

        public final String component1() {
            return this.ssid;
        }

        public final String component2() {
            return this.bssid;
        }

        public final Boolean component3() {
            return this.secure;
        }

        public final Double component4() {
            return this.signalStrength;
        }

        public final Integer component5() {
            return this.frequency;
        }

        public final WifiInfo copy(String r10, String r11, Boolean r12, Double r13, Integer r14) {
            Intrinsics.checkNotNullParameter(r10, "ssid");
            return new WifiInfo(r10, r11, r12, r13, r14);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof WifiInfo) == true) goto L8;
            return false;
        L8:
            WifiInfo r11 = (WifiInfo) r10;
            if (Intrinsics.areEqual(this.ssid, r11.ssid) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.bssid, r11.bssid) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.secure, r11.secure) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.signalStrength, r11.signalStrength) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.frequency, r11.frequency) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = this.ssid.hashCode() * 31;
            String r1 = this.bssid;
            int r10 = 0;
            if (r1 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = (r0 + r11) * 31;
            Boolean r13 = this.secure;
            if (r13 != null) goto L9;
            int r14 = 0;
        L10:
            int r15 = (r12 + r14) * 31;
            Double r16 = this.signalStrength;
            if (r16 != null) goto L13;
            int r17 = 0;
        L14:
            int r18 = (r15 + r17) * 31;
            Integer r19 = this.frequency;
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
            r11 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "WifiInfo(ssid=" + this.ssid + ", bssid=" + this.bssid + ", secure=" + this.secure + ", signalStrength=" + this.signalStrength + ", frequency=" + this.frequency + ')';
        }

        public final String getBssid() {
            return this.bssid;
        }

        public final Integer getFrequency() {
            return this.frequency;
        }

        public final Boolean getSecure() {
            return this.secure;
        }

        public final Double getSignalStrength() {
            return this.signalStrength;
        }

        public final String getSsid() {
            return this.ssid;
        }

        public WifiInfo(String r10, String r11, Boolean r12, Double r13, Integer r14) {
            Intrinsics.checkNotNullParameter(r10, "ssid");
            this.ssid = r10;
            this.bssid = r11;
            this.secure = r12;
            this.signalStrength = r13;
            this.frequency = r14;
        }

        public /* synthetic */ WifiInfo(String r10, String r11, Boolean r12, Double r13, Integer r14, int r15, DefaultConstructorMarker r16) {
            if ((r15 & 2) == 0) goto L5;
            String r17 = null;
        L7:
            if ((r15 & 4) == 0) goto L9;
            Boolean r18 = null;
        L11:
            if ((r15 & 8) == 0) goto L13;
            Double r19 = null;
        L15:
            if ((r15 & 16) == 0) goto L17;
            Integer r20 = null;
        L18:
            this(r10, r17, r18, r19, r20);
            return;
        L17:
            r20 = r14;
            goto L18
        L13:
            r19 = r13;
            goto L15
        L9:
            r18 = r12;
            goto L11
        L5:
            r17 = r11;
            goto L7
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "partialInfo", required = false)
        Boolean getPartialInfo();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "wifi", required = true)
        void setWifi(WifiInfo r1);
    }

    public AbsGetConnectedWifiMethodIDL() {
        this.a = "doubao.getConnectedWifi";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
