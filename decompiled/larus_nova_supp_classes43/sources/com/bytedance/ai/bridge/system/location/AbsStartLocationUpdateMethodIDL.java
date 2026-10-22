package com.bytedance.ai.bridge.system.location;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/system/location/AbsStartLocationUpdateMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/system/location/AbsStartLocationUpdateMethodIDL$StartLocationUpdateParamModel;", "Lcom/bytedance/ai/bridge/system/location/AbsStartLocationUpdateMethodIDL$EmptyMessageModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "StartLocationUpdateParamModel", "EmptyMessageModel", "LocationUpdateType", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsStartLocationUpdateMethodIDL extends CoreAIBridgeMethod<b, a> {
    public final String a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/system/location/AbsStartLocationUpdateMethodIDL$LocationUpdateType;", "", "<init>", "(Ljava/lang/String;I)V", "WGS84", "GCJ02", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LocationUpdateType extends Enum<LocationUpdateType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ LocationUpdateType[] $VALUES = null;

        @SerializedName("gcj02")
        public static final LocationUpdateType GCJ02 = null;

        @SerializedName("wgs84")
        public static final LocationUpdateType WGS84 = null;

        private static final /* synthetic */ LocationUpdateType[] $values() {
            return new LocationUpdateType[]{WGS84, GCJ02};
        }

        public static EnumEntries<LocationUpdateType> getEntries() {
            return $ENTRIES;
        }

        static {
            WGS84 = new LocationUpdateType("WGS84", 0);
            GCJ02 = new LocationUpdateType("GCJ02", 1);
            LocationUpdateType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static LocationUpdateType[] values() {
            return (LocationUpdateType[]) $VALUES.clone();
        }

        public static LocationUpdateType valueOf(String r1) {
            return (LocationUpdateType) r27.a.a(LocationUpdateType.class, r1);
        }

        private LocationUpdateType(String r1, int r10) {
            super(r1, r10);
        }
    }

    @AIBridgeResultModel
    public interface a extends ResultModel {
    }

    @AIBridgeParamModel
    public interface b extends ParamModel {
        @AIBridgeParamField(keyPath = "type", required = true)
        LocationUpdateType getType();
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsStartLocationUpdateMethodIDL() {
        this.a = "doubao.startLocationUpdate";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
