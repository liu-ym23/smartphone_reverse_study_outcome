package com.obric.memorydata.awareness.location;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u009f\u0001\u0010+\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016¨\u00062"}, d2 = {"Lcom/obric/memorydata/awareness/location/Place;", "", "AddressLines", "", "", "AdminArea", "Name", "Locality", "SubLocality", "PostalCode", "TimeZone", "aoi", "Lcom/obric/memorydata/awareness/location/AreaOfInterest;", "poi", "Lcom/obric/memorydata/awareness/location/PointOfInterest;", "FormattedAddress", "Address", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getAddressLines", "()Ljava/util/List;", "getAdminArea", "()Ljava/lang/String;", "getName", "getLocality", "getSubLocality", "getPostalCode", "getTimeZone", "getAoi", "getPoi", "getFormattedAddress", "getAddress", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Place {
    private final String Address;
    private final List<String> AddressLines;
    private final String AdminArea;
    private final String FormattedAddress;
    private final String Locality;
    private final String Name;
    private final String PostalCode;
    private final String SubLocality;
    private final String TimeZone;
    private final List<AreaOfInterest> aoi;
    private final List<PointOfInterest> poi;

    public Place() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public Place(List<String> r3, String r4, String r5, String r6, String r7, String r8, String r9, List<AreaOfInterest> r10, List<PointOfInterest> r11, String r12, String r13) {
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<AreaOfInterest> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List<PointOfInterest> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        this.AddressLines = r14;
        this.AdminArea = r4;
        this.Name = r5;
        this.Locality = r6;
        this.SubLocality = r7;
        this.PostalCode = r8;
        this.TimeZone = r9;
        this.aoi = r15;
        this.poi = r16;
        this.FormattedAddress = r12;
        this.Address = r13;
    }

    public /* synthetic */ Place(List r13, String r14, String r15, String r16, String r17, String r18, String r19, List r20, List r21, String r22, String r23, int r24, DefaultConstructorMarker r25) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        String r5 = null;
        if ((r24 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r24 & 2) == 0) goto L8;
        String r4 = null;
    L10:
        if ((r24 & 4) == 0) goto L12;
        String r6 = null;
    L14:
        if ((r24 & 8) == 0) goto L16;
        String r7 = null;
    L18:
        if ((r24 & 16) == 0) goto L20;
        String r8 = null;
    L22:
        if ((r24 & 32) == 0) goto L24;
        String r9 = null;
    L26:
        if ((r24 & 64) == 0) goto L28;
        String r10 = null;
    L30:
        if ((r24 & 128) == 0) goto L33;
        r3 = null;
    L33:
        if ((r24 & 256) == 0) goto L36;
        r2 = null;
    L36:
        if ((r24 & 512) == 0) goto L38;
        String r11 = null;
    L40:
        if ((r24 & 1024) != 0) goto L43;
        r5 = r23;
    L43:
        this(r1, r4, r6, r7, r8, r9, r10, r3, r2, r11, r5);
        return;
    L38:
        r11 = r22;
        goto L40
    L28:
        r10 = r19;
        goto L30
    L24:
        r9 = r18;
        goto L26
    L20:
        r8 = r17;
        goto L22
    L16:
        r7 = r16;
        goto L18
    L12:
        r6 = r15;
        goto L14
    L8:
        r4 = r14;
        goto L10
    }

    public static /* synthetic */ Place copy$default(Place r12, List r13, String r14, String r15, String r16, String r17, String r18, String r19, List r20, List r21, String r22, String r23, int r24, Object r25) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        List<AreaOfInterest> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        List<PointOfInterest> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        if ((r24 & 1) == 0) goto L6;
        r2 = r12.AddressLines;
    L6:
        if ((r24 & 2) == 0) goto L8;
        String r5 = r12.AdminArea;
    L10:
        if ((r24 & 4) == 0) goto L12;
        String r6 = r12.Name;
    L14:
        if ((r24 & 8) == 0) goto L16;
        String r7 = r12.Locality;
    L18:
        if ((r24 & 16) == 0) goto L20;
        String r8 = r12.SubLocality;
    L22:
        if ((r24 & 32) == 0) goto L24;
        String r9 = r12.PostalCode;
    L26:
        if ((r24 & 64) == 0) goto L28;
        String r10 = r12.TimeZone;
    L30:
        if ((r24 & 128) == 0) goto L33;
        r4 = r12.aoi;
    L33:
        if ((r24 & 256) == 0) goto L36;
        r3 = r12.poi;
    L36:
        if ((r24 & 512) == 0) goto L38;
        String r11 = r12.FormattedAddress;
    L40:
        if ((r24 & 1024) == 0) goto L42;
        String r1 = r12.Address;
    L44:
        return r12.copy(r2, r5, r6, r7, r8, r9, r10, r4, r3, r11, r1);
    L42:
        r1 = r23;
        goto L44
    L38:
        r11 = r22;
        goto L40
    L28:
        r10 = r19;
        goto L30
    L24:
        r9 = r18;
        goto L26
    L20:
        r8 = r17;
        goto L22
    L16:
        r7 = r16;
        goto L18
    L12:
        r6 = r15;
        goto L14
    L8:
        r5 = r14;
        goto L10
    }

    public final List<String> component1() {
        return this.AddressLines;
    }

    public final String component10() {
        return this.FormattedAddress;
    }

    public final String component11() {
        return this.Address;
    }

    public final String component2() {
        return this.AdminArea;
    }

    public final String component3() {
        return this.Name;
    }

    public final String component4() {
        return this.Locality;
    }

    public final String component5() {
        return this.SubLocality;
    }

    public final String component6() {
        return this.PostalCode;
    }

    public final String component7() {
        return this.TimeZone;
    }

    public final List<AreaOfInterest> component8() {
        return this.aoi;
    }

    public final List<PointOfInterest> component9() {
        return this.poi;
    }

    public final Place copy(List<String> r15, String r16, String r17, String r18, String r19, String r20, String r21, List<AreaOfInterest> r22, List<PointOfInterest> r23, String r24, String r25) {
        return new Place((List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin"), r16, r17, r18, r19, r20, r21, (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin"), r24, r25);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Place.class) == true) goto L8;
        return false;
    L8:
        Place r6 = (Place) ZeusTransformUtils.preCheckCast(r5, Place.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.AddressLines, r6.AddressLines) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.AdminArea, r6.AdminArea) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.Name, r6.Name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.Locality, r6.Locality) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.SubLocality, r6.SubLocality) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.PostalCode, r6.PostalCode) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.TimeZone, r6.TimeZone) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.aoi, r6.aoi) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.poi, r6.poi) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.FormattedAddress, r6.FormattedAddress) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.Address, r6.Address) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final String getAddress() {
        return this.Address;
    }

    public final List<String> getAddressLines() {
        return this.AddressLines;
    }

    public final String getAdminArea() {
        return this.AdminArea;
    }

    public final List<AreaOfInterest> getAoi() {
        return this.aoi;
    }

    public final String getFormattedAddress() {
        return this.FormattedAddress;
    }

    public final String getLocality() {
        return this.Locality;
    }

    public final String getName() {
        return this.Name;
    }

    public final List<PointOfInterest> getPoi() {
        return this.poi;
    }

    public final String getPostalCode() {
        return this.PostalCode;
    }

    public final String getSubLocality() {
        return this.SubLocality;
    }

    public final String getTimeZone() {
        return this.TimeZone;
    }

    public int hashCode() {
        List<String> r0 = this.AddressLines;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.AdminArea;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.Name;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.Locality;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.SubLocality;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.PostalCode;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.TimeZone;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        List<AreaOfInterest> r22 = this.aoi;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        List<PointOfInterest> r25 = this.poi;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.FormattedAddress;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.Address;
        if (r31 == null) goto L47;
        r1 = r31.hashCode();
    L47:
        return r30 + r1;
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
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
        StringBuilder r0 = new StringBuilder();
        r0.append("Place(AddressLines=").append(this.AddressLines).append(", AdminArea=").append(this.AdminArea).append(", Name=").append(this.Name).append(", Locality=").append(this.Locality).append(", SubLocality=").append(this.SubLocality).append(", PostalCode=").append(this.PostalCode).append(", TimeZone=").append(this.TimeZone).append(", aoi=").append(this.aoi).append(", poi=").append(this.poi).append(", FormattedAddress=").append(this.FormattedAddress).append(", Address=").append(this.Address).append(')');
        return r0.toString();
    }
}
