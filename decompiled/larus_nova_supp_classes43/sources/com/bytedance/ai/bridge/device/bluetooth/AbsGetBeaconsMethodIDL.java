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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBeaconsMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBeaconsMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBeaconsMethodIDL$GetBeaconsResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "EmptyMessageModel", "GetBeaconsResultModel", "BeaconInfo", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetBeaconsMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006\""}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBeaconsMethodIDL$BeaconInfo;", "", "uuid", "", "major", "", "minor", "proximity", "accuracy", "", "rssi", "<init>", "(Ljava/lang/String;IIIDI)V", "getUuid", "()Ljava/lang/String;", "getMajor", "()I", "getMinor", "getProximity", "getAccuracy", "()D", "getRssi", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BeaconInfo {

        @SerializedName("accuracy")
        private final double accuracy;

        @SerializedName("major")
        private final int major;

        @SerializedName("minor")
        private final int minor;

        @SerializedName("proximity")
        private final int proximity;

        @SerializedName("rssi")
        private final int rssi;

        @SerializedName("uuid")
        private final String uuid;

        public static /* synthetic */ BeaconInfo copy$default(BeaconInfo r10, String r11, int r12, int r13, int r14, double r15, int r16, int r17, Object r18) {
            if ((r17 & 1) == 0) goto L6;
            r11 = r10.uuid;
        L6:
            if ((r17 & 2) == 0) goto L8;
            r12 = r10.major;
        L8:
            int r19 = r12;
            if ((r17 & 4) == 0) goto L11;
            r13 = r10.minor;
        L11:
            int r0 = r13;
            if ((r17 & 8) == 0) goto L14;
            r14 = r10.proximity;
        L14:
            int r1 = r14;
            if ((r17 & 16) == 0) goto L17;
            r15 = r10.accuracy;
        L17:
            double r20 = r15;
            if ((r17 & 32) == 0) goto L20;
            r16 = r10.rssi;
        L20:
            String r21 = r11;
            return r10.copy(r21, r19, r0, r1, r20, r16);
        }

        public final String component1() {
            return this.uuid;
        }

        public final int component2() {
            return this.major;
        }

        public final int component3() {
            return this.minor;
        }

        public final int component4() {
            return this.proximity;
        }

        public final double component5() {
            return this.accuracy;
        }

        public final int component6() {
            return this.rssi;
        }

        public final BeaconInfo copy(String r10, int r11, int r12, int r13, double r14, int r16) {
            Intrinsics.checkNotNullParameter(r10, "uuid");
            return new BeaconInfo(r10, r11, r12, r13, r14, r16);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof BeaconInfo) == true) goto L8;
            return false;
        L8:
            BeaconInfo r11 = (BeaconInfo) r10;
            if (Intrinsics.areEqual(this.uuid, r11.uuid) == true) goto L12;
            return false;
        L12:
            if (this.major == r11.major) goto L15;
            return false;
        L15:
            if (this.minor == r11.minor) goto L18;
            return false;
        L18:
            if (this.proximity == r11.proximity) goto L21;
            return false;
        L21:
            if (Double.compare(this.accuracy, r11.accuracy) == 0) goto L24;
            return false;
        L24:
            if (this.rssi == r11.rssi) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((this.uuid.hashCode() * 31) + this.major) * 31) + this.minor) * 31) + this.proximity) * 31;
            long r1 = Double.doubleToLongBits(this.accuracy);
            return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.rssi;
        }

        public String toString() {
            return "BeaconInfo(uuid=" + this.uuid + ", major=" + this.major + ", minor=" + this.minor + ", proximity=" + this.proximity + ", accuracy=" + this.accuracy + ", rssi=" + this.rssi + ')';
        }

        public final double getAccuracy() {
            return this.accuracy;
        }

        public final int getMajor() {
            return this.major;
        }

        public final int getMinor() {
            return this.minor;
        }

        public final int getProximity() {
            return this.proximity;
        }

        public final int getRssi() {
            return this.rssi;
        }

        public final String getUuid() {
            return this.uuid;
        }

        public BeaconInfo(String r10, int r11, int r12, int r13, double r14, int r15) {
            Intrinsics.checkNotNullParameter(r10, "uuid");
            this.uuid = r10;
            this.major = r11;
            this.minor = r12;
            this.proximity = r13;
            this.accuracy = r14;
            this.rssi = r15;
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "beacons", required = true)
        void setBeacons(List<BeaconInfo> r1);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsGetBeaconsMethodIDL() {
        this.a = "doubao.getBeacons";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
