package j09;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/larus/common/baidunavi/api/bean/instruction/BaiduNaviVisualInstruction;", "", "position", "", "distanceToOrigin", "", "distanceToCurrent", "turnInfo", "Lcom/larus/common/baidunavi/api/bean/instruction/BaiduNaviTurnInfo;", "<init>", "(Ljava/lang/String;IILcom/larus/common/baidunavi/api/bean/instruction/BaiduNaviTurnInfo;)V", "getPosition", "()Ljava/lang/String;", "getDistanceToOrigin", "()I", "getDistanceToCurrent", "getTurnInfo", "()Lcom/larus/common/baidunavi/api/bean/instruction/BaiduNaviTurnInfo;", "getGeoPosition", "Lcom/larus/common/baidunavi/api/bean/BaiduNaviGeoPoint;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("distance_to_current")
    private final int distanceToCurrent;

    @SerializedName("distance_to_origin")
    private final int distanceToOrigin;

    @SerializedName("position")
    private final String position;

    @SerializedName("turn_description")
    private final a turnInfo;

    public d() {
        this("", 0, 0, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.position, r6.position) == true) goto L12;
        return false;
    L12:
        if (this.distanceToOrigin == r6.distanceToOrigin) goto L15;
        return false;
    L15:
        if (this.distanceToCurrent == r6.distanceToCurrent) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.turnInfo, r6.turnInfo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r0 = this.position;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + this.distanceToOrigin) * 31) + this.distanceToCurrent) * 31;
        a r4 = this.turnInfo;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "BaiduNaviVisualInstruction(position=" + this.position + ", distanceToOrigin=" + this.distanceToOrigin + ", distanceToCurrent=" + this.distanceToCurrent + ", turnInfo=" + this.turnInfo + ')';
    }

    public d(String r1, int r2, int r3, a r4) {
        this.position = r1;
        this.distanceToOrigin = r2;
        this.distanceToCurrent = r3;
        this.turnInfo = r4;
    }
}
