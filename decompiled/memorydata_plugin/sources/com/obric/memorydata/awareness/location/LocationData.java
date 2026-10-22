package com.obric.memorydata.awareness.location;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0012HÆ\u0003Jo\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u000204HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00065"}, d2 = {"Lcom/obric/memorydata/awareness/location/LocationData;", "", "Continent", "Lcom/obric/memorydata/awareness/location/Continent;", "Country", "Lcom/obric/memorydata/awareness/location/Country;", "Subdivisions", "", "Lcom/obric/memorydata/awareness/location/Subdivision;", "City", "Lcom/obric/memorydata/awareness/location/City;", "District", "Lcom/obric/memorydata/awareness/location/District;", "Place", "Lcom/obric/memorydata/awareness/location/Place;", "GPS", "Lcom/obric/memorydata/awareness/location/GPS;", "Town", "Lcom/obric/memorydata/awareness/location/Town;", "<init>", "(Lcom/obric/memorydata/awareness/location/Continent;Lcom/obric/memorydata/awareness/location/Country;Ljava/util/List;Lcom/obric/memorydata/awareness/location/City;Lcom/obric/memorydata/awareness/location/District;Lcom/obric/memorydata/awareness/location/Place;Lcom/obric/memorydata/awareness/location/GPS;Lcom/obric/memorydata/awareness/location/Town;)V", "getContinent", "()Lcom/obric/memorydata/awareness/location/Continent;", "getCountry", "()Lcom/obric/memorydata/awareness/location/Country;", "getSubdivisions", "()Ljava/util/List;", "getCity", "()Lcom/obric/memorydata/awareness/location/City;", "getDistrict", "()Lcom/obric/memorydata/awareness/location/District;", "getPlace", "()Lcom/obric/memorydata/awareness/location/Place;", "getGPS", "()Lcom/obric/memorydata/awareness/location/GPS;", "getTown", "()Lcom/obric/memorydata/awareness/location/Town;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocationData {
    private final City City;
    private final Continent Continent;
    private final Country Country;
    private final District District;
    private final GPS GPS;
    private final Place Place;
    private final List<Subdivision> Subdivisions;
    private final Town Town;

    public LocationData() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public LocationData(Continent r3, Country r4, List<Subdivision> r5, City r6, District r7, Place r8, GPS r9, Town r10) {
        List<Subdivision> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.Continent = r3;
        this.Country = r4;
        this.Subdivisions = r11;
        this.City = r6;
        this.District = r7;
        this.Place = r8;
        this.GPS = r9;
        this.Town = r10;
    }

    public /* synthetic */ LocationData(Continent r10, Country r11, List r12, City r13, District r14, Place r15, GPS r16, Town r17, int r18, DefaultConstructorMarker r19) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Town r3 = null;
        if ((r18 & 1) == 0) goto L5;
        Continent r2 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Country r4 = null;
    L11:
        if ((r18 & 4) == 0) goto L14;
        r1 = null;
    L14:
        if ((r18 & 8) == 0) goto L16;
        City r5 = null;
    L18:
        if ((r18 & 16) == 0) goto L20;
        District r6 = null;
    L22:
        if ((r18 & 32) == 0) goto L24;
        Place r7 = null;
    L26:
        if ((r18 & 64) == 0) goto L28;
        GPS r8 = null;
    L30:
        if ((r18 & 128) != 0) goto L33;
        r3 = r17;
    L33:
        this(r2, r4, r1, r5, r6, r7, r8, r3);
        return;
    L28:
        r8 = r16;
        goto L30
    L24:
        r7 = r15;
        goto L26
    L20:
        r6 = r14;
        goto L22
    L16:
        r5 = r13;
        goto L18
    L9:
        r4 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public static /* synthetic */ LocationData copy$default(LocationData r9, Continent r10, Country r11, List r12, City r13, District r14, Place r15, GPS r16, Town r17, int r18, Object r19) {
        List<Subdivision> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        if ((r18 & 1) == 0) goto L5;
        Continent r3 = r9.Continent;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Country r4 = r9.Country;
    L11:
        if ((r18 & 4) == 0) goto L14;
        r2 = r9.Subdivisions;
    L14:
        if ((r18 & 8) == 0) goto L16;
        City r5 = r9.City;
    L18:
        if ((r18 & 16) == 0) goto L20;
        District r6 = r9.District;
    L22:
        if ((r18 & 32) == 0) goto L24;
        Place r7 = r9.Place;
    L26:
        if ((r18 & 64) == 0) goto L28;
        GPS r8 = r9.GPS;
    L30:
        if ((r18 & 128) == 0) goto L32;
        Town r1 = r9.Town;
    L34:
        return r9.copy(r3, r4, r2, r5, r6, r7, r8, r1);
    L32:
        r1 = r17;
        goto L34
    L28:
        r8 = r16;
        goto L30
    L24:
        r7 = r15;
        goto L26
    L20:
        r6 = r14;
        goto L22
    L16:
        r5 = r13;
        goto L18
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    public final Continent component1() {
        return this.Continent;
    }

    public final Country component2() {
        return this.Country;
    }

    public final List<Subdivision> component3() {
        return this.Subdivisions;
    }

    public final City component4() {
        return this.City;
    }

    public final District component5() {
        return this.District;
    }

    public final Place component6() {
        return this.Place;
    }

    public final GPS component7() {
        return this.GPS;
    }

    public final Town component8() {
        return this.Town;
    }

    public final LocationData copy(Continent r11, Country r12, List<Subdivision> r13, City r14, District r15, Place r16, GPS r17, Town r18) {
        return new LocationData(r11, r12, (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin"), r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LocationData.class) == true) goto L8;
        return false;
    L8:
        LocationData r6 = (LocationData) ZeusTransformUtils.preCheckCast(r5, LocationData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.Continent, r6.Continent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.Country, r6.Country) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.Subdivisions, r6.Subdivisions) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.City, r6.City) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.District, r6.District) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.Place, r6.Place) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.GPS, r6.GPS) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.Town, r6.Town) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final City getCity() {
        return this.City;
    }

    public final Continent getContinent() {
        return this.Continent;
    }

    public final Country getCountry() {
        return this.Country;
    }

    public final District getDistrict() {
        return this.District;
    }

    public final GPS getGPS() {
        return this.GPS;
    }

    public final Place getPlace() {
        return this.Place;
    }

    public final List<Subdivision> getSubdivisions() {
        return this.Subdivisions;
    }

    public final Town getTown() {
        return this.Town;
    }

    public int hashCode() {
        Continent r0 = this.Continent;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Country r4 = this.Country;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<Subdivision> r7 = this.Subdivisions;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        City r10 = this.City;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        District r13 = this.District;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Place r16 = this.Place;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        GPS r19 = this.GPS;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Town r22 = this.Town;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "LocationData(Continent=" + this.Continent + ", Country=" + this.Country + ", Subdivisions=" + this.Subdivisions + ", City=" + this.City + ", District=" + this.District + ", Place=" + this.Place + ", GPS=" + this.GPS + ", Town=" + this.Town + ')';
    }
}
