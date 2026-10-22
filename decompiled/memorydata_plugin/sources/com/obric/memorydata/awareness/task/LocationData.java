package com.obric.memorydata.awareness.task;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/awareness/task/LocationData;", "", "place", "Lcom/obric/memorydata/awareness/task/Place;", "town", "Lcom/obric/memorydata/awareness/task/Town;", "<init>", "(Lcom/obric/memorydata/awareness/task/Place;Lcom/obric/memorydata/awareness/task/Town;)V", "getPlace", "()Lcom/obric/memorydata/awareness/task/Place;", "getTown", "()Lcom/obric/memorydata/awareness/task/Town;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocationData {

    @SerializedName("Place")
    private final Place place;

    @SerializedName("town")
    private final Town town;

    /* JADX WARN: Multi-variable type inference failed */
    public LocationData() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public LocationData(Place r1, Town r2) {
        this.place = r1;
        this.town = r2;
    }

    public /* synthetic */ LocationData(Place r2, Town r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public static /* synthetic */ LocationData copy$default(LocationData r0, Place r1, Town r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.place;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.town;
    L9:
        return r0.copy(r1, r2);
    }

    public final Place component1() {
        return this.place;
    }

    public final Town component2() {
        return this.town;
    }

    public final LocationData copy(Place r1, Town r2) {
        return new LocationData(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LocationData.class) == true) goto L8;
        return false;
    L8:
        LocationData r6 = (LocationData) ZeusTransformUtils.preCheckCast(r5, LocationData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.place, r6.place) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.town, r6.town) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final Place getPlace() {
        return this.place;
    }

    public final Town getTown() {
        return this.town;
    }

    public int hashCode() {
        Place r0 = this.place;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Town r4 = this.town;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "LocationData(place=" + this.place + ", town=" + this.town + ')';
    }
}
