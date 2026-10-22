package com.obric.memorydata.awareness.location;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/awareness/location/City;", "", "GeoNameID", "", "ASCIName", "", "Name", "LocalID", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGeoNameID", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getASCIName", "()Ljava/lang/String;", "getName", "getLocalID", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/memorydata/awareness/location/City;", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class City {
    private final String ASCIName;
    private final Long GeoNameID;
    private final String LocalID;
    private final String Name;

    public City() {
        this(null, null, null, null, 15, null);
    }

    public City(Long r1, String r2, String r3, String r4) {
        this.GeoNameID = r1;
        this.ASCIName = r2;
        this.Name = r3;
        this.LocalID = r4;
    }

    public /* synthetic */ City(Long r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public static /* synthetic */ City copy$default(City r0, Long r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.GeoNameID;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.ASCIName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.Name;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.LocalID;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Long component1() {
        return this.GeoNameID;
    }

    public final String component2() {
        return this.ASCIName;
    }

    public final String component3() {
        return this.Name;
    }

    public final String component4() {
        return this.LocalID;
    }

    public final City copy(Long r1, String r2, String r3, String r4) {
        return new City(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, City.class) == true) goto L8;
        return false;
    L8:
        City r6 = (City) ZeusTransformUtils.preCheckCast(r5, City.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.GeoNameID, r6.GeoNameID) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ASCIName, r6.ASCIName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.Name, r6.Name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.LocalID, r6.LocalID) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getASCIName() {
        return this.ASCIName;
    }

    public final Long getGeoNameID() {
        return this.GeoNameID;
    }

    public final String getLocalID() {
        return this.LocalID;
    }

    public final String getName() {
        return this.Name;
    }

    public int hashCode() {
        Long r0 = this.GeoNameID;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.ASCIName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.Name;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.LocalID;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "City(GeoNameID=" + this.GeoNameID + ", ASCIName=" + this.ASCIName + ", Name=" + this.Name + ", LocalID=" + this.LocalID + ')';
    }
}
