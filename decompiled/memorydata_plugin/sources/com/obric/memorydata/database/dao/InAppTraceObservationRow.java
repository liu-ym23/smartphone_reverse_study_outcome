package com.obric.memorydata.database.dao;

import com.obric.memorydata.database.entity.cc;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/database/dao/InAppTraceObservationRow;", "", "trace", "Lcom/obric/memorydata/database/entity/InAppTraceUploadEntity;", "observationId", "", "<init>", "(Lcom/obric/memorydata/database/entity/InAppTraceUploadEntity;J)V", "getTrace", "()Lcom/obric/memorydata/database/entity/InAppTraceUploadEntity;", "getObservationId", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InAppTraceObservationRow {
    private final long observationId;
    private final cc trace;

    public InAppTraceObservationRow(cc r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "trace");
        this.trace = r2;
        this.observationId = r3;
    }

    public static /* synthetic */ InAppTraceObservationRow copy$default(InAppTraceObservationRow r0, cc r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.trace;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.observationId;
    L9:
        return r0.copy(r1, r2);
    }

    public final cc component1() {
        return this.trace;
    }

    public final long component2() {
        return this.observationId;
    }

    public final InAppTraceObservationRow copy(cc r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "trace");
        return new InAppTraceObservationRow(r1, r2);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, InAppTraceObservationRow.class) == true) goto L8;
        return false;
    L8:
        InAppTraceObservationRow r8 = (InAppTraceObservationRow) ZeusTransformUtils.preCheckCast(r7, InAppTraceObservationRow.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.trace, r8.trace) == true) goto L12;
        return false;
    L12:
        if (this.observationId == r8.observationId) goto L14;
        return false;
    L14:
        return true;
    }

    public final long getObservationId() {
        return this.observationId;
    }

    public final cc getTrace() {
        return this.trace;
    }

    public int hashCode() {
        return (this.trace.hashCode() * 31) + Long.hashCode(this.observationId);
    }

    public String toString() {
        return "InAppTraceObservationRow(trace=" + this.trace + ", observationId=" + this.observationId + ')';
    }
}
