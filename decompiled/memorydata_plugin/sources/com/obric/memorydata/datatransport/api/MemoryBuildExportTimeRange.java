package com.obric.memorydata.datatransport.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/datatransport/api/MemoryBuildExportTimeRange;", "Ljava/io/Serializable;", "startTimeMs", "", "endTimeMs", "<init>", "(JJ)V", "getStartTimeMs", "()J", "getEndTimeMs", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryBuildExportTimeRange implements Serializable {
    private final long endTimeMs;
    private final long startTimeMs;

    public MemoryBuildExportTimeRange(long r1, long r3) {
        this.startTimeMs = r1;
        this.endTimeMs = r3;
    }

    public static /* synthetic */ MemoryBuildExportTimeRange copy$default(MemoryBuildExportTimeRange r0, long r1, long r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.startTimeMs;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.endTimeMs;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.startTimeMs;
    }

    public final long component2() {
        return this.endTimeMs;
    }

    public final MemoryBuildExportTimeRange copy(long r1, long r3) {
        return new MemoryBuildExportTimeRange(r1, r3);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, MemoryBuildExportTimeRange.class) == true) goto L8;
        return false;
    L8:
        MemoryBuildExportTimeRange r10 = (MemoryBuildExportTimeRange) ZeusTransformUtils.preCheckCast(r9, MemoryBuildExportTimeRange.class, "com.obric.memorydata.plugin");
        if (this.startTimeMs == r10.startTimeMs) goto L12;
        return false;
    L12:
        if (this.endTimeMs == r10.endTimeMs) goto L14;
        return false;
    L14:
        return true;
    }

    public final long getEndTimeMs() {
        return this.endTimeMs;
    }

    public final long getStartTimeMs() {
        return this.startTimeMs;
    }

    public int hashCode() {
        return (Long.hashCode(this.startTimeMs) * 31) + Long.hashCode(this.endTimeMs);
    }

    public String toString() {
        return "MemoryBuildExportTimeRange(startTimeMs=" + this.startTimeMs + ", endTimeMs=" + this.endTimeMs + ')';
    }
}
