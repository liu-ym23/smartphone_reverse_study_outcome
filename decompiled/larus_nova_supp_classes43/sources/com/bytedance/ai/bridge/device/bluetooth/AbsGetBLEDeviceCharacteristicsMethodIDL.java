package com.bytedance.ai.bridge.device.bluetooth;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\f\r\u000e\u000fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBLEDeviceCharacteristicsMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBLEDeviceCharacteristicsMethodIDL$GetBLEDeviceCharacteristicsParamModel;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBLEDeviceCharacteristicsMethodIDL$GetBLEDeviceCharacteristicsResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "GetBLEDeviceCharacteristicsParamModel", "GetBLEDeviceCharacteristicsResultModel", "BLECharacteristic", "BLECharacteristicProperties", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetBLEDeviceCharacteristicsMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBLEDeviceCharacteristicsMethodIDL$BLECharacteristic;", "", "uuid", "", "properties", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBLEDeviceCharacteristicsMethodIDL$BLECharacteristicProperties;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBLEDeviceCharacteristicsMethodIDL$BLECharacteristicProperties;)V", "getUuid", "()Ljava/lang/String;", "getProperties", "()Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBLEDeviceCharacteristicsMethodIDL$BLECharacteristicProperties;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BLECharacteristic {

        @SerializedName("properties")
        private final BLECharacteristicProperties properties;

        @SerializedName("uuid")
        private final String uuid;

        public static /* synthetic */ BLECharacteristic copy$default(BLECharacteristic r0, String r1, BLECharacteristicProperties r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r1 = r0.uuid;
        L6:
            if ((r11 & 2) == 0) goto L9;
            r10 = r0.properties;
        L9:
            return r0.copy(r1, r10);
        }

        public final String component1() {
            return this.uuid;
        }

        public final BLECharacteristicProperties component2() {
            return this.properties;
        }

        public final BLECharacteristic copy(String r10, BLECharacteristicProperties r11) {
            Intrinsics.checkNotNullParameter(r10, "uuid");
            Intrinsics.checkNotNullParameter(r11, "properties");
            return new BLECharacteristic(r10, r11);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof BLECharacteristic) == true) goto L8;
            return false;
        L8:
            BLECharacteristic r11 = (BLECharacteristic) r10;
            if (Intrinsics.areEqual(this.uuid, r11.uuid) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.properties, r11.properties) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.uuid.hashCode() * 31) + this.properties.hashCode();
        }

        public String toString() {
            return "BLECharacteristic(uuid=" + this.uuid + ", properties=" + this.properties + ')';
        }

        public final BLECharacteristicProperties getProperties() {
            return this.properties;
        }

        public final String getUuid() {
            return this.uuid;
        }

        public BLECharacteristic(String r10, BLECharacteristicProperties r11) {
            Intrinsics.checkNotNullParameter(r10, "uuid");
            Intrinsics.checkNotNullParameter(r11, "properties");
            this.uuid = r10;
            this.properties = r11;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBLEDeviceCharacteristicsMethodIDL$BLECharacteristicProperties;", "", "read", "", "write", "notify", "indicate", "writeNoResponse", "writeDefault", "<init>", "(ZZZZZZ)V", "getRead", "()Z", "getWrite", "getNotify", "getIndicate", "getWriteNoResponse", "getWriteDefault", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BLECharacteristicProperties {

        @SerializedName("indicate")
        private final boolean indicate;

        @SerializedName("notify")
        private final boolean notify;

        @SerializedName("read")
        private final boolean read;

        @SerializedName("write")
        private final boolean write;

        @SerializedName("writeDefault")
        private final boolean writeDefault;

        @SerializedName("writeNoResponse")
        private final boolean writeNoResponse;

        public static /* synthetic */ BLECharacteristicProperties copy$default(BLECharacteristicProperties r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, int r17, Object r18) {
            if ((r17 & 1) == 0) goto L6;
            r11 = r10.read;
        L6:
            if ((r17 & 2) == 0) goto L8;
            r12 = r10.write;
        L8:
            boolean r19 = r12;
            if ((r17 & 4) == 0) goto L11;
            r13 = r10.notify;
        L11:
            boolean r0 = r13;
            if ((r17 & 8) == 0) goto L14;
            r14 = r10.indicate;
        L14:
            boolean r1 = r14;
            if ((r17 & 16) == 0) goto L17;
            r15 = r10.writeNoResponse;
        L17:
            boolean r20 = r15;
            if ((r17 & 32) == 0) goto L20;
            r16 = r10.writeDefault;
        L20:
            boolean r21 = r11;
            return r10.copy(r21, r19, r0, r1, r20, r16);
        }

        public final boolean component1() {
            return this.read;
        }

        public final boolean component2() {
            return this.write;
        }

        public final boolean component3() {
            return this.notify;
        }

        public final boolean component4() {
            return this.indicate;
        }

        public final boolean component5() {
            return this.writeNoResponse;
        }

        public final boolean component6() {
            return this.writeDefault;
        }

        public final BLECharacteristicProperties copy(boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15) {
            return new BLECharacteristicProperties(r10, r11, r12, r13, r14, r15);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof BLECharacteristicProperties) == true) goto L8;
            return false;
        L8:
            BLECharacteristicProperties r11 = (BLECharacteristicProperties) r10;
            if (this.read == r11.read) goto L12;
            return false;
        L12:
            if (this.write == r11.write) goto L15;
            return false;
        L15:
            if (this.notify == r11.notify) goto L18;
            return false;
        L18:
            if (this.indicate == r11.indicate) goto L21;
            return false;
        L21:
            if (this.writeNoResponse == r11.writeNoResponse) goto L24;
            return false;
        L24:
            if (this.writeDefault == r11.writeDefault) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r1 = 1231;
            if (this.read == false) goto L5;
            int r0 = 1231;
        L6:
            int r10 = r0 * 31;
            if (this.write == false) goto L9;
            int r11 = 1231;
        L10:
            int r12 = (r10 + r11) * 31;
            if (this.notify == false) goto L13;
            int r13 = 1231;
        L14:
            int r14 = (r12 + r13) * 31;
            if (this.indicate == false) goto L17;
            int r15 = 1231;
        L18:
            int r16 = (r14 + r15) * 31;
            if (this.writeNoResponse == false) goto L21;
            int r17 = 1231;
        L22:
            int r18 = (r16 + r17) * 31;
            if (this.writeDefault == true) goto L27;
            r1 = 1237;
        L27:
            return r18 + r1;
        L21:
            r17 = 1237;
            goto L22
        L17:
            r15 = 1237;
            goto L18
        L13:
            r13 = 1237;
            goto L14
        L9:
            r11 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public String toString() {
            return "BLECharacteristicProperties(read=" + this.read + ", write=" + this.write + ", notify=" + this.notify + ", indicate=" + this.indicate + ", writeNoResponse=" + this.writeNoResponse + ", writeDefault=" + this.writeDefault + ')';
        }

        public final boolean getIndicate() {
            return this.indicate;
        }

        public final boolean getNotify() {
            return this.notify;
        }

        public final boolean getRead() {
            return this.read;
        }

        public final boolean getWrite() {
            return this.write;
        }

        public final boolean getWriteDefault() {
            return this.writeDefault;
        }

        public final boolean getWriteNoResponse() {
            return this.writeNoResponse;
        }

        public BLECharacteristicProperties(boolean r1, boolean r10, boolean r11, boolean r12, boolean r13, boolean r14) {
            this.read = r1;
            this.write = r10;
            this.notify = r11;
            this.indicate = r12;
            this.writeNoResponse = r13;
            this.writeDefault = r14;
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "deviceId", required = true)
        String getDeviceId();

        @AIBridgeParamField(keyPath = "serviceId", required = true)
        String getServiceId();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "characteristics", required = true)
        void setCharacteristics(List<BLECharacteristic> r1);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsGetBLEDeviceCharacteristicsMethodIDL() {
        this.a = "doubao.getBLEDeviceCharacteristics";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
