package l12;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ll12/b;", BuildConfig.FLAVOR, "Lorg/json/JSONObject;", "contextFeatures", "Lorg/json/JSONObject;", "getContextFeatures", "()Lorg/json/JSONObject;", BuildConfig.FLAVOR, "level", "I", "getLevel", "()I", BuildConfig.FLAVOR, "roomId", "Ljava/lang/String;", "getRoomId", "()Ljava/lang/String;", BuildConfig.FLAVOR, "available", "J", "getAvailable", "()J", "Ll12/e;", "strategyContext", "Ll12/e;", "getStrategyContext", "()Ll12/e;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("available")
    private final long available;

    @SerializedName("context_features")
    private final JSONObject contextFeatures;

    @SerializedName("level")
    private final int level;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("strategy_context")
    private final e strategyContext;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L16;
        b r7 = (b) r6;
        if (Intrinsics.areEqual(this.contextFeatures, r7.contextFeatures) == true) goto L8;
        return false;
    L8:
        if (this.level == r7.level) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.roomId, r7.roomId) == true) goto L12;
        return false;
    L12:
        if (this.available == r7.available) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.strategyContext, r7.strategyContext) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        JSONObject r0 = this.contextFeatures;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.level) * 31;
        String r4 = this.roomId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = this.available;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        e r9 = this.strategyContext;
        if (r9 == null) goto L14;
        r1 = r9.hashCode();
    L14:
        return r8 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftListResponseModel(contextFeatures=" + this.contextFeatures + ", level=" + this.level + ", roomId=" + this.roomId + ", available=" + this.available + ", strategyContext=" + this.strategyContext + ")";
    }
}
