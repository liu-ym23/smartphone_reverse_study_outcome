package com.obric.memorydata.awareness.task;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J?\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/awareness/task/Place;", "", "adminArea", "", "locality", "subLocality", "aoi", "", "Lcom/obric/memorydata/awareness/task/AreaOfInterest;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAdminArea", "()Ljava/lang/String;", "getLocality", "getSubLocality", "getAoi", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Place {

    @SerializedName("AdminArea")
    private final String adminArea;
    private final List<AreaOfInterest> aoi;

    @SerializedName("Locality")
    private final String locality;

    @SerializedName("SubLocality")
    private final String subLocality;

    public Place() {
        this(null, null, null, null, 15, null);
    }

    public Place(String r3, String r4, String r5, List<AreaOfInterest> r6) {
        List<AreaOfInterest> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.adminArea = r3;
        this.locality = r4;
        this.subLocality = r5;
        this.aoi = r7;
    }

    public /* synthetic */ Place(String r2, String r3, String r4, List r5, int r6, DefaultConstructorMarker r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
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
        r8 = null;
    L14:
        this(r2, r3, r4, r8);
    }

    public static /* synthetic */ Place copy$default(Place r1, String r2, String r3, String r4, List r5, int r6, Object r7) {
        List<AreaOfInterest> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.adminArea;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.locality;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.subLocality;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r8 = r1.aoi;
    L15:
        return r1.copy(r2, r3, r4, r8);
    }

    public final String component1() {
        return this.adminArea;
    }

    public final String component2() {
        return this.locality;
    }

    public final String component3() {
        return this.subLocality;
    }

    public final List<AreaOfInterest> component4() {
        return this.aoi;
    }

    public final Place copy(String r2, String r3, String r4, List<AreaOfInterest> r5) {
        return new Place(r2, r3, r4, (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Place.class) == true) goto L8;
        return false;
    L8:
        Place r6 = (Place) ZeusTransformUtils.preCheckCast(r5, Place.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.adminArea, r6.adminArea) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.locality, r6.locality) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subLocality, r6.subLocality) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.aoi, r6.aoi) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getAdminArea() {
        return this.adminArea;
    }

    public final List<AreaOfInterest> getAoi() {
        return this.aoi;
    }

    public final String getLocality() {
        return this.locality;
    }

    public final String getSubLocality() {
        return this.subLocality;
    }

    public int hashCode() {
        String r0 = this.adminArea;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.locality;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.subLocality;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<AreaOfInterest> r10 = this.aoi;
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
        return "Place(adminArea=" + this.adminArea + ", locality=" + this.locality + ", subLocality=" + this.subLocality + ", aoi=" + this.aoi + ')';
    }
}
