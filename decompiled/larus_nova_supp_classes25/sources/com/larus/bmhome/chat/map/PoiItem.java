package com.larus.bmhome.chat.map;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003Jn\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006)"}, d2 = {"Lcom/larus/bmhome/chat/map/PoiItem;", "", "podId", "", "poiName", "lon", "lat", "address", "distance", "score", "", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;)V", "getPodId", "()Ljava/lang/String;", "getPoiName", "getLon", "getLat", "getAddress", "getDistance", "getScore", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getIcon", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;)Lcom/larus/bmhome/chat/map/PoiItem;", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PoiItem {

    @SerializedName("address")
    private final String address;

    @SerializedName("distance")
    private final String distance;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("latitude")
    private final String lat;

    @SerializedName("longitude")
    private final String lon;

    @SerializedName("poi_id")
    private final String podId;

    @SerializedName("poi_name")
    private final String poiName;

    @SerializedName("score")
    private final Float score;

    public PoiItem() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ PoiItem copy$default(PoiItem r9, String r10, String r11, String r12, String r13, String r14, String r15, Float r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.podId;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.poiName;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.lon;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.lat;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.address;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.distance;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Float r8 = r9.score;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.icon;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.podId;
    }

    public final String component2() {
        return this.poiName;
    }

    public final String component3() {
        return this.lon;
    }

    public final String component4() {
        return this.lat;
    }

    public final String component5() {
        return this.address;
    }

    public final String component6() {
        return this.distance;
    }

    public final Float component7() {
        return this.score;
    }

    public final String component8() {
        return this.icon;
    }

    public final PoiItem copy(String r11, String r12, String r13, String r14, String r15, String r16, Float r17, String r18) {
        return new PoiItem(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PoiItem) == true) goto L8;
        return false;
    L8:
        PoiItem r6 = (PoiItem) r5;
        if (Intrinsics.areEqual(this.podId, r6.podId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.poiName, r6.poiName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lon, r6.lon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lat, r6.lat) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.address, r6.address) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.distance, r6.distance) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.score, r6.score) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r0 = this.podId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.poiName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.lon;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.lat;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.address;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.distance;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Float r19 = this.score;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.icon;
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
        return "PoiItem(podId=" + this.podId + ", poiName=" + this.poiName + ", lon=" + this.lon + ", lat=" + this.lat + ", address=" + this.address + ", distance=" + this.distance + ", score=" + this.score + ", icon=" + this.icon + ')';
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getDistance() {
        return this.distance;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getLat() {
        return this.lat;
    }

    public final String getLon() {
        return this.lon;
    }

    public final String getPodId() {
        return this.podId;
    }

    public final String getPoiName() {
        return this.poiName;
    }

    public final Float getScore() {
        return this.score;
    }

    public PoiItem(String r1, String r2, String r3, String r4, String r5, String r6, Float r7, String r8) {
        this.podId = r1;
        this.poiName = r2;
        this.lon = r3;
        this.lat = r4;
        this.address = r5;
        this.distance = r6;
        this.score = r7;
        this.icon = r8;
    }

    public /* synthetic */ PoiItem(String r10, String r11, String r12, String r13, String r14, String r15, Float r16, String r17, int r18, DefaultConstructorMarker r19) {
        String r2 = null;
        if ((r18 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Float r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
