package com.bytedance.ai.bridge.device.wifi;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/device/wifi/AbsSetWifiListMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/device/wifi/AbsSetWifiListMethodIDL$SetWifiListParamModel;", "Lcom/bytedance/ai/bridge/device/wifi/AbsSetWifiListMethodIDL$EmptyMessageModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "SetWifiListParamModel", "EmptyMessageModel", "WifiListItem", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsSetWifiListMethodIDL extends CoreAIBridgeMethod<a, Object> {
    public final String a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/bridge/device/wifi/AbsSetWifiListMethodIDL$WifiListItem;", "", "ssid", "", "bssid", "password", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSsid", "()Ljava/lang/String;", "getBssid", "getPassword", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WifiListItem {

        @SerializedName("bssid")
        private final String bssid;

        @SerializedName("password")
        private final String password;

        @SerializedName("ssid")
        private final String ssid;

        public WifiListItem() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ WifiListItem copy$default(WifiListItem r0, String r1, String r10, String r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r1 = r0.ssid;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r10 = r0.bssid;
        L9:
            if ((r12 & 4) == 0) goto L12;
            r11 = r0.password;
        L12:
            return r0.copy(r1, r10, r11);
        }

        public final String component1() {
            return this.ssid;
        }

        public final String component2() {
            return this.bssid;
        }

        public final String component3() {
            return this.password;
        }

        public final WifiListItem copy(String r10, String r11, String r12) {
            return new WifiListItem(r10, r11, r12);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof WifiListItem) == true) goto L8;
            return false;
        L8:
            WifiListItem r11 = (WifiListItem) r10;
            if (Intrinsics.areEqual(this.ssid, r11.ssid) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.bssid, r11.bssid) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.password, r11.password) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r0 = this.ssid;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = r10 * 31;
            String r12 = this.bssid;
            if (r12 != null) goto L9;
            int r13 = 0;
        L10:
            int r14 = (r11 + r13) * 31;
            String r15 = this.password;
            if (r15 == null) goto L15;
            r1 = r15.hashCode();
        L15:
            return r14 + r1;
        L9:
            r13 = r12.hashCode();
            goto L10
        L5:
            r10 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "WifiListItem(ssid=" + this.ssid + ", bssid=" + this.bssid + ", password=" + this.password + ')';
        }

        public final String getBssid() {
            return this.bssid;
        }

        public final String getPassword() {
            return this.password;
        }

        public final String getSsid() {
            return this.ssid;
        }

        public WifiListItem(String r1, String r10, String r11) {
            this.ssid = r1;
            this.bssid = r10;
            this.password = r11;
        }

        public /* synthetic */ WifiListItem(String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 1) == 0) goto L6;
            r10 = null;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r11 = null;
        L9:
            if ((r13 & 4) == 0) goto L11;
            r12 = null;
        L11:
            this(r10, r11, r12);
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "wifiList", required = true)
        List<WifiListItem> getWifiList();
    }

    public AbsSetWifiListMethodIDL() {
        this.a = "doubao.setWifiList";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
