package com.bytedance.ai.bridge.device.bluetooth;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBluetoothDevicesMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBluetoothDevicesMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBluetoothDevicesMethodIDL$GetBluetoothDevicesResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "EmptyMessageModel", "GetBluetoothDevicesResultModel", "BluetoothDevice", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetBluetoothDevicesMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b \b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\rHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001fJz\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0006HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001f¨\u0006/"}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBluetoothDevicesMethodIDL$BluetoothDevice;", "", "deviceId", "", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "RSSI", "", "advertisData", "", "advertisServiceUUIDs", "Ljava/util/List;", "localName", "serviceData", "", "connectable", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I[BLjava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;)V", "getDeviceId", "()Ljava/lang/String;", "getName", "getRSSI", "()I", "getAdvertisData", "()[B", "getAdvertisServiceUUIDs", "()Ljava/util/List;", "getLocalName", "getServiceData", "()Ljava/util/Map;", "getConnectable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;I[BLjava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;)Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBluetoothDevicesMethodIDL$BluetoothDevice;", "equals", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BluetoothDevice {

        @SerializedName("RSSI")
        private final int RSSI;

        @SerializedName("advertisData")
        private final byte[] advertisData;

        @SerializedName("advertisServiceUUIDs")
        private final List<String> advertisServiceUUIDs;

        @SerializedName("connectable")
        private final Boolean connectable;

        @SerializedName("deviceId")
        private final String deviceId;

        @SerializedName("localName")
        private final String localName;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME)
        private final String name;

        @SerializedName("serviceData")
        private final Map<String, byte[]> serviceData;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BluetoothDevice copy$default(BluetoothDevice r10, String r11, String r12, int r13, byte[] r14, List r15, String r16, Map r17, Boolean r18, int r19, Object r110) {
            if ((r19 & 1) == 0) goto L5;
            String r20 = r10.deviceId;
        L7:
            if ((r19 & 2) == 0) goto L9;
            String r21 = r10.name;
        L11:
            if ((r19 & 4) == 0) goto L13;
            int r22 = r10.RSSI;
        L15:
            if ((r19 & 8) == 0) goto L17;
            byte[] r23 = r10.advertisData;
        L19:
            if ((r19 & 16) == 0) goto L21;
            List r24 = r10.advertisServiceUUIDs;
        L23:
            if ((r19 & 32) == 0) goto L25;
            String r25 = r10.localName;
        L27:
            if ((r19 & 64) == 0) goto L29;
            Map r26 = r10.serviceData;
        L31:
            if ((r19 & 128) == 0) goto L33;
            Boolean r1 = r10.connectable;
        L35:
            return r10.copy(r20, r21, r22, r23, r24, r25, r26, r1);
        L33:
            r1 = r18;
            goto L35
        L29:
            r26 = r17;
            goto L31
        L25:
            r25 = r16;
            goto L27
        L21:
            r24 = r15;
            goto L23
        L17:
            r23 = r14;
            goto L19
        L13:
            r22 = r13;
            goto L15
        L9:
            r21 = r12;
            goto L11
        L5:
            r20 = r11;
            goto L7
        }

        public final String component1() {
            return this.deviceId;
        }

        public final String component2() {
            return this.name;
        }

        public final int component3() {
            return this.RSSI;
        }

        public final byte[] component4() {
            return this.advertisData;
        }

        public final List<String> component5() {
            return this.advertisServiceUUIDs;
        }

        public final String component6() {
            return this.localName;
        }

        public final Map<String, byte[]> component7() {
            return this.serviceData;
        }

        public final Boolean component8() {
            return this.connectable;
        }

        public final BluetoothDevice copy(String r11, String r12, int r13, byte[] r14, List<String> r15, String r16, Map<String, byte[]> r17, Boolean r18) {
            Intrinsics.checkNotNullParameter(r11, "deviceId");
            Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            return new BluetoothDevice(r11, r12, r13, r14, r15, r16, r17, r18);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof BluetoothDevice) == true) goto L8;
            return false;
        L8:
            BluetoothDevice r11 = (BluetoothDevice) r10;
            if (Intrinsics.areEqual(this.deviceId, r11.deviceId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.name, r11.name) == true) goto L15;
            return false;
        L15:
            if (this.RSSI == r11.RSSI) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.advertisData, r11.advertisData) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.advertisServiceUUIDs, r11.advertisServiceUUIDs) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.localName, r11.localName) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.serviceData, r11.serviceData) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.connectable, r11.connectable) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.deviceId.hashCode() * 31) + this.name.hashCode()) * 31) + this.RSSI) * 31;
            byte[] r1 = this.advertisData;
            int r10 = 0;
            if (r1 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = (r0 + r11) * 31;
            List<String> r13 = this.advertisServiceUUIDs;
            if (r13 != null) goto L9;
            int r14 = 0;
        L10:
            int r15 = (r12 + r14) * 31;
            String r16 = this.localName;
            if (r16 != null) goto L13;
            int r17 = 0;
        L14:
            int r18 = (r15 + r17) * 31;
            Map<String, byte[]> r19 = this.serviceData;
            if (r19 != null) goto L17;
            int r20 = 0;
        L18:
            int r21 = (r18 + r20) * 31;
            Boolean r22 = this.connectable;
            if (r22 == null) goto L23;
            r10 = r22.hashCode();
        L23:
            return r21 + r10;
        L17:
            r20 = r19.hashCode();
            goto L18
        L13:
            r17 = r16.hashCode();
            goto L14
        L9:
            r14 = r13.hashCode();
            goto L10
        L5:
            r11 = Arrays.hashCode(r1);
            goto L6
        }

        public String toString() {
            return "BluetoothDevice(deviceId=" + this.deviceId + ", name=" + this.name + ", RSSI=" + this.RSSI + ", advertisData=" + Arrays.toString(this.advertisData) + ", advertisServiceUUIDs=" + this.advertisServiceUUIDs + ", localName=" + this.localName + ", serviceData=" + this.serviceData + ", connectable=" + this.connectable + ')';
        }

        public final byte[] getAdvertisData() {
            return this.advertisData;
        }

        public final List<String> getAdvertisServiceUUIDs() {
            return this.advertisServiceUUIDs;
        }

        public final Boolean getConnectable() {
            return this.connectable;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final String getLocalName() {
            return this.localName;
        }

        public final String getName() {
            return this.name;
        }

        public final int getRSSI() {
            return this.RSSI;
        }

        public final Map<String, byte[]> getServiceData() {
            return this.serviceData;
        }

        public BluetoothDevice(String r10, String r11, int r12, byte[] r13, List<String> r14, String r15, Map<String, byte[]> r16, Boolean r17) {
            Intrinsics.checkNotNullParameter(r10, "deviceId");
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            this.deviceId = r10;
            this.name = r11;
            this.RSSI = r12;
            this.advertisData = r13;
            this.advertisServiceUUIDs = r14;
            this.localName = r15;
            this.serviceData = r16;
            this.connectable = r17;
        }

        public /* synthetic */ BluetoothDevice(String r13, String r14, int r15, byte[] r16, List r17, String r18, Map r19, Boolean r20, int r21, DefaultConstructorMarker r22) {
            if ((r21 & 8) == 0) goto L5;
            byte[] r10 = null;
        L7:
            if ((r21 & 16) == 0) goto L9;
            List r11 = null;
        L11:
            if ((r21 & 32) == 0) goto L13;
            String r12 = null;
        L15:
            if ((r21 & 64) == 0) goto L17;
            Map r110 = null;
        L19:
            if ((r21 & 128) == 0) goto L21;
            Boolean r111 = null;
        L22:
            this(r13, r14, r15, r10, r11, r12, r110, r111);
            return;
        L21:
            r111 = r20;
            goto L22
        L17:
            r110 = r19;
            goto L19
        L13:
            r12 = r18;
            goto L15
        L9:
            r11 = r17;
            goto L11
        L5:
            r10 = r16;
            goto L7
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "devices", required = true)
        void setDevices(List<BluetoothDevice> r1);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsGetBluetoothDevicesMethodIDL() {
        this.a = "doubao.getBluetoothDevices";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
