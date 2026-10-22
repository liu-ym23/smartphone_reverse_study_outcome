package com.obric.memorydata.recommend.context.data;

import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003JC\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/recommend/context/data/LocationThroughData;", "", "gps", "", "", "cellId", "", "bssId", "", MemoryKeyInfoEntity.KEY_ADDRESS, "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getGps", "()Ljava/util/List;", "getCellId", "getBssId", "getAddress", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocationThroughData {
    private final String address;
    private final List<String> bssId;
    private final List<Long> cellId;
    private final List<Double> gps;

    public LocationThroughData(List<Double> r3, List<Long> r4, List<String> r5, String r6) {
        List<Double> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<Long> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "gps");
        Intrinsics.checkNotNullParameter(r8, "cellId");
        Intrinsics.checkNotNullParameter(r9, "bssId");
        Intrinsics.checkNotNullParameter(r6, MemoryKeyInfoEntity.KEY_ADDRESS);
        this.gps = r7;
        this.cellId = r8;
        this.bssId = r9;
        this.address = r6;
    }

    public static /* synthetic */ LocationThroughData copy$default(LocationThroughData r1, List r2, List r3, List r4, String r5, int r6, Object r7) {
        List<Double> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List<Long> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = r1.gps;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r9 = r1.cellId;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r10 = r1.bssId;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.address;
    L15:
        return r1.copy(r8, r9, r10, r5);
    }

    public final List<Double> component1() {
        return this.gps;
    }

    public final List<Long> component2() {
        return this.cellId;
    }

    public final List<String> component3() {
        return this.bssId;
    }

    public final String component4() {
        return this.address;
    }

    public final LocationThroughData copy(List<Double> r2, List<Long> r3, List<String> r4, String r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "gps");
        Intrinsics.checkNotNullParameter(r6, "cellId");
        Intrinsics.checkNotNullParameter(r7, "bssId");
        Intrinsics.checkNotNullParameter(r5, MemoryKeyInfoEntity.KEY_ADDRESS);
        return new LocationThroughData(r1, r6, r7, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LocationThroughData.class) == true) goto L8;
        return false;
    L8:
        LocationThroughData r6 = (LocationThroughData) ZeusTransformUtils.preCheckCast(r5, LocationThroughData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.gps, r6.gps) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cellId, r6.cellId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bssId, r6.bssId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.address, r6.address) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getAddress() {
        return this.address;
    }

    public final List<String> getBssId() {
        return this.bssId;
    }

    public final List<Long> getCellId() {
        return this.cellId;
    }

    public final List<Double> getGps() {
        return this.gps;
    }

    public int hashCode() {
        return (((((this.gps.hashCode() * 31) + this.cellId.hashCode()) * 31) + this.bssId.hashCode()) * 31) + this.address.hashCode();
    }

    public String toString() {
        return "LocationThroughData(gps=" + this.gps + ", cellId=" + this.cellId + ", bssId=" + this.bssId + ", address=" + this.address + ')';
    }
}
