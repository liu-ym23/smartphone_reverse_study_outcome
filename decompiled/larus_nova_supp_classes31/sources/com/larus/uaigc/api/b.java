package com.larus.uaigc.api;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/uaigc/api/AiReplicaTrainQuotaData;", "", "total", "", "left", "timeUnit", "<init>", "(III)V", "getTotal", "()I", "getLeft", "getTimeUnit", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class b {

    @SerializedName("left")
    private final int left;

    @SerializedName("time_unit")
    private final int timeUnit;

    @SerializedName("total")
    private final int total;

    public b() {
        this(0, 0, 0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.total == r6.total) goto L12;
        return false;
    L12:
        if (this.left == r6.left) goto L15;
        return false;
    L15:
        if (this.timeUnit == r6.timeUnit) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.total * 31) + this.left) * 31) + this.timeUnit;
    }

    public final String toString() {
        return "AiReplicaTrainQuotaData(total=" + this.total + ", left=" + this.left + ", timeUnit=" + this.timeUnit + ')';
    }

    public final int a() {
        return this.left;
    }

    public final int b() {
        return this.timeUnit;
    }

    public final int c() {
        return this.total;
    }

    public b(int r1, int r2, int r3) {
        this.total = r1;
        this.left = r2;
        this.timeUnit = r3;
    }
}
