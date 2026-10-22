package com.obric.memorydata.awareness.location;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/awareness/location/GPS;", "", "Latitude", "", "Longitude", "Timestamp", "", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Long;)V", "getLatitude", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLongitude", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Long;)Lcom/obric/memorydata/awareness/location/GPS;", "equals", "", "other", "hashCode", "", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GPS {
    private final Double Latitude;
    private final Double Longitude;
    private final Long Timestamp;

    public GPS() {
        this(null, null, null, 7, null);
    }

    public GPS(Double r1, Double r2, Long r3) {
        this.Latitude = r1;
        this.Longitude = r2;
        this.Timestamp = r3;
    }

    public /* synthetic */ GPS(Double r2, Double r3, Long r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public static /* synthetic */ GPS copy$default(GPS r0, Double r1, Double r2, Long r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.Latitude;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.Longitude;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.Timestamp;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Double component1() {
        return this.Latitude;
    }

    public final Double component2() {
        return this.Longitude;
    }

    public final Long component3() {
        return this.Timestamp;
    }

    public final GPS copy(Double r1, Double r2, Long r3) {
        return new GPS(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GPS.class) == true) goto L8;
        return false;
    L8:
        GPS r6 = (GPS) ZeusTransformUtils.preCheckCast(r5, GPS.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.Latitude, r6.Latitude) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.Longitude, r6.Longitude) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.Timestamp, r6.Timestamp) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final Double getLatitude() {
        return this.Latitude;
    }

    public final Double getLongitude() {
        return this.Longitude;
    }

    public final Long getTimestamp() {
        return this.Timestamp;
    }

    public int hashCode() {
        Double r0 = this.Latitude;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Double r4 = this.Longitude;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.Timestamp;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "GPS(Latitude=" + this.Latitude + ", Longitude=" + this.Longitude + ", Timestamp=" + this.Timestamp + ')';
    }
}
