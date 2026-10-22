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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBLEDeviceServicesMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBLEDeviceServicesMethodIDL$GetBLEDeviceServicesParamModel;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBLEDeviceServicesMethodIDL$GetBLEDeviceServicesResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "GetBLEDeviceServicesParamModel", "GetBLEDeviceServicesResultModel", "BluetoothService", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetBLEDeviceServicesMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBLEDeviceServicesMethodIDL$BluetoothService;", "", "uuid", "", "isPrimary", "", "<init>", "(Ljava/lang/String;Z)V", "getUuid", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BluetoothService {

        @SerializedName("isPrimary")
        private final boolean isPrimary;

        @SerializedName("uuid")
        private final String uuid;

        public static /* synthetic */ BluetoothService copy$default(BluetoothService r0, String r1, boolean r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r1 = r0.uuid;
        L6:
            if ((r11 & 2) == 0) goto L9;
            r10 = r0.isPrimary;
        L9:
            return r0.copy(r1, r10);
        }

        public final String component1() {
            return this.uuid;
        }

        public final boolean component2() {
            return this.isPrimary;
        }

        public final BluetoothService copy(String r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "uuid");
            return new BluetoothService(r10, r11);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof BluetoothService) == true) goto L8;
            return false;
        L8:
            BluetoothService r11 = (BluetoothService) r10;
            if (Intrinsics.areEqual(this.uuid, r11.uuid) == true) goto L12;
            return false;
        L12:
            if (this.isPrimary == r11.isPrimary) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.uuid.hashCode() * 31;
            if (this.isPrimary == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public String toString() {
            return "BluetoothService(uuid=" + this.uuid + ", isPrimary=" + this.isPrimary + ')';
        }

        public final String getUuid() {
            return this.uuid;
        }

        public final boolean isPrimary() {
            return this.isPrimary;
        }

        public BluetoothService(String r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "uuid");
            this.uuid = r10;
            this.isPrimary = r11;
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "deviceId", required = true)
        String getDeviceId();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "services", required = true)
        void setServices(List<BluetoothService> r1);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsGetBLEDeviceServicesMethodIDL() {
        this.a = "doubao.getBLEDeviceServices";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
