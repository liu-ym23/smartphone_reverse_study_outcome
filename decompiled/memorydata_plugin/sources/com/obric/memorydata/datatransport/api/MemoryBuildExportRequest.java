package com.obric.memorydata.datatransport.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ0\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/datatransport/api/MemoryBuildExportRequest;", "Ljava/io/Serializable;", "timeRange", "Lcom/obric/memorydata/datatransport/api/MemoryBuildExportTimeRange;", "onlyRawObservation", "", "autoMemoryId", "", "<init>", "(Lcom/obric/memorydata/datatransport/api/MemoryBuildExportTimeRange;ZLjava/lang/Long;)V", "getTimeRange", "()Lcom/obric/memorydata/datatransport/api/MemoryBuildExportTimeRange;", "getOnlyRawObservation", "()Z", "getAutoMemoryId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Lcom/obric/memorydata/datatransport/api/MemoryBuildExportTimeRange;ZLjava/lang/Long;)Lcom/obric/memorydata/datatransport/api/MemoryBuildExportRequest;", "equals", "other", "", "hashCode", "", "toString", "", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryBuildExportRequest implements Serializable {
    private final Long autoMemoryId;
    private final boolean onlyRawObservation;
    private final MemoryBuildExportTimeRange timeRange;

    public MemoryBuildExportRequest() {
        this(null, false, null, 7, null);
    }

    public MemoryBuildExportRequest(MemoryBuildExportTimeRange r1, boolean r2, Long r3) {
        this.timeRange = r1;
        this.onlyRawObservation = r2;
        this.autoMemoryId = r3;
    }

    public /* synthetic */ MemoryBuildExportRequest(MemoryBuildExportTimeRange r2, boolean r3, Long r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public static /* synthetic */ MemoryBuildExportRequest copy$default(MemoryBuildExportRequest r0, MemoryBuildExportTimeRange r1, boolean r2, Long r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.timeRange;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.onlyRawObservation;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.autoMemoryId;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final MemoryBuildExportTimeRange component1() {
        return this.timeRange;
    }

    public final boolean component2() {
        return this.onlyRawObservation;
    }

    public final Long component3() {
        return this.autoMemoryId;
    }

    public final MemoryBuildExportRequest copy(MemoryBuildExportTimeRange r1, boolean r2, Long r3) {
        return new MemoryBuildExportRequest(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MemoryBuildExportRequest.class) == true) goto L8;
        return false;
    L8:
        MemoryBuildExportRequest r6 = (MemoryBuildExportRequest) ZeusTransformUtils.preCheckCast(r5, MemoryBuildExportRequest.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.timeRange, r6.timeRange) == true) goto L12;
        return false;
    L12:
        if (this.onlyRawObservation == r6.onlyRawObservation) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.autoMemoryId, r6.autoMemoryId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final Long getAutoMemoryId() {
        return this.autoMemoryId;
    }

    public final boolean getOnlyRawObservation() {
        return this.onlyRawObservation;
    }

    public final MemoryBuildExportTimeRange getTimeRange() {
        return this.timeRange;
    }

    public int hashCode() {
        MemoryBuildExportTimeRange r0 = this.timeRange;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + Boolean.hashCode(this.onlyRawObservation)) * 31;
        Long r4 = this.autoMemoryId;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MemoryBuildExportRequest(timeRange=" + this.timeRange + ", onlyRawObservation=" + this.onlyRawObservation + ", autoMemoryId=" + this.autoMemoryId + ')';
    }
}
