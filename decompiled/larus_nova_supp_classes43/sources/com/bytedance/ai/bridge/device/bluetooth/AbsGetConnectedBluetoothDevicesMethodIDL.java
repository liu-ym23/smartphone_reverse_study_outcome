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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetConnectedBluetoothDevicesMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetConnectedBluetoothDevicesMethodIDL$GetConnectedBluetoothDevicesParamModel;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetConnectedBluetoothDevicesMethodIDL$GetConnectedBluetoothDevicesResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "GetConnectedBluetoothDevicesParamModel", "GetConnectedBluetoothDevicesResultModel", "ConnectedBluetoothDevice", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetConnectedBluetoothDevicesMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetConnectedBluetoothDevicesMethodIDL$ConnectedBluetoothDevice;", "", "deviceId", "", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConnectedBluetoothDevice {

        @SerializedName("deviceId")
        private final String deviceId;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME)
        private final String name;

        public static /* synthetic */ ConnectedBluetoothDevice copy$default(ConnectedBluetoothDevice r0, String r1, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r1 = r0.deviceId;
        L6:
            if ((r11 & 2) == 0) goto L9;
            r10 = r0.name;
        L9:
            return r0.copy(r1, r10);
        }

        public final String component1() {
            return this.deviceId;
        }

        public final String component2() {
            return this.name;
        }

        public final ConnectedBluetoothDevice copy(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "deviceId");
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            return new ConnectedBluetoothDevice(r10, r11);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof ConnectedBluetoothDevice) == true) goto L8;
            return false;
        L8:
            ConnectedBluetoothDevice r11 = (ConnectedBluetoothDevice) r10;
            if (Intrinsics.areEqual(this.deviceId, r11.deviceId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.name, r11.name) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.deviceId.hashCode() * 31) + this.name.hashCode();
        }

        public String toString() {
            return "ConnectedBluetoothDevice(deviceId=" + this.deviceId + ", name=" + this.name + ')';
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final String getName() {
            return this.name;
        }

        public ConnectedBluetoothDevice(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "deviceId");
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            this.deviceId = r10;
            this.name = r11;
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "services", required = true)
        List<String> getServices();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "devices", required = true)
        void setDevices(List<ConnectedBluetoothDevice> r1);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsGetConnectedBluetoothDevicesMethodIDL() {
        this.a = "doubao.getConnectedBluetoothDevices";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
