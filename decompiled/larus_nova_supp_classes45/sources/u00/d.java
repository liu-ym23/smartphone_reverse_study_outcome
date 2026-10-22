package u00;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0016"}, d2 = {"Lu00/d;", "", "Lu00/e;", "continent", "Lu00/e;", "getContinent", "()Lu00/e;", "country", "getCountry", "", "subdivisions", "Ljava/util/List;", "getSubdivisions", "()Ljava/util/List;", "city", "a", "district", "getDistrict", "GPS", "getGPS", "town", "getTown", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("GPS")
    private final e GPS;

    @SerializedName("City")
    private final e city;

    @SerializedName("Continent")
    private final e continent;

    @SerializedName("Country")
    private final e country;

    @SerializedName("District")
    private final e district;

    @SerializedName("Subdivisions")
    private final List<e> subdivisions;

    @SerializedName("Town")
    private final e town;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L20;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.continent, r4.continent) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.country, r4.country) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.subdivisions, r4.subdivisions) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.city, r4.city) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.district, r4.district) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.GPS, r4.GPS) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.town, r4.town) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        e r0 = this.continent;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        e r4 = this.country;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<e> r7 = this.subdivisions;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        e r11 = this.city;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        e r14 = this.district;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        e r17 = this.GPS;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        e r21 = this.town;
        if (r21 == null) goto L30;
        r1 = r21.hashCode();
    L30:
        return r19 + r1;
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveLocation(continent=" + this.continent + ", country=" + this.country + ", subdivisions=" + this.subdivisions + ", city=" + this.city + ", district=" + this.district + ", GPS=" + this.GPS + ", town=" + this.town + ")";
    }

    public d() {
        this.continent = null;
        this.country = null;
        this.subdivisions = null;
        this.city = null;
        this.district = null;
        this.GPS = null;
        this.town = null;
    }

    public final e a() {
        return this.city;
    }
}
