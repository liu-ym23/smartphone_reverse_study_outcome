package u00;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lu00/e;", "", "", "code", "Ljava/lang/String;", "getCode", "()Ljava/lang/String;", "geoNameID", "getGeoNameID", "ASCIName", "getASCIName", "name", "a", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("ASCIName")
    private final String ASCIName;

    @SerializedName("Code")
    private final String code;

    @SerializedName("GeoNameID")
    private final String geoNameID;

    @SerializedName("Name")
    private final String name;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L14;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.code, r4.code) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.geoNameID, r4.geoNameID) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.ASCIName, r4.ASCIName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.code;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.geoNameID;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.ASCIName;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r11 = this.name;
        if (r11 == null) goto L18;
        r1 = r11.hashCode();
    L18:
        return r9 + r1;
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
        return "LiveLocationDetail(code=" + this.code + ", geoNameID=" + this.geoNameID + ", ASCIName=" + this.ASCIName + ", name=" + this.name + ")";
    }

    public e() {
        this.code = null;
        this.geoNameID = null;
        this.ASCIName = null;
        this.name = null;
    }

    public final String a() {
        return this.name;
    }
}
