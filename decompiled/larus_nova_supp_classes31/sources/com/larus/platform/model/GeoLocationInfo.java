package com.larus.platform.model;

import com.tencent.open.log.TraceLevel;
import hq9.b3;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b<\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bá\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\tHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u000eHÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\tHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010N\u001a\u00020\u000eHÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010R\u001a\u00020\u001cHÆ\u0003J\t\u0010S\u001a\u00020\u001cHÆ\u0003J\t\u0010T\u001a\u00020\u001cHÆ\u0003Jú\u0001\u0010U\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001cHÆ\u0001¢\u0006\u0002\u0010VJ\u0013\u0010W\u001a\u00020\u001c2\b\u0010X\u001a\u0004\u0018\u00010YHÖ\u0003J\t\u0010Z\u001a\u00020\tHÖ\u0001J\t\u0010[\u001a\u00020\u000bHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010)R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010)R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b5\u0010+R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b6\u0010+R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b7\u0010+R\u0011\u0010\u0017\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u0010/R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b9\u0010\"R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010-R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b;\u0010+R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\u001d\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b>\u0010=R\u0011\u0010\u001e\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010=¨\u0006\\"}, d2 = {"Lcom/larus/platform/model/GeoLocationInfo;", "Ljava/io/Serializable;", "gpsDir", "", "longitude", "", "latitude", "altitude", "accuracyLevel", "", "city", "", "speed", "gpsTime", "", "satelliteCount", "radius", "locationType", "extraInfo", "Lcom/larus/platform/model/LocationExtraInfo;", "cityCode", "districtCode", "provinceCode", "locationTime", "bearing", "naviAccuracy", "poi", "poiUseFallback", "", "validLatlng", "isLightLocation", "<init>", "(Ljava/lang/Float;DDDILjava/lang/String;FJIFILcom/larus/platform/model/LocationExtraInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Float;FLjava/lang/String;ZZZ)V", "getGpsDir", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getLongitude", "()D", "getLatitude", "getAltitude", "getAccuracyLevel", "()I", "getCity", "()Ljava/lang/String;", "getSpeed", "()F", "getGpsTime", "()J", "getSatelliteCount", "getRadius", "getLocationType", "getExtraInfo", "()Lcom/larus/platform/model/LocationExtraInfo;", "getCityCode", "getDistrictCode", "getProvinceCode", "getLocationTime", "getBearing", "getNaviAccuracy", "getPoi", "getPoiUseFallback", "()Z", "getValidLatlng", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "(Ljava/lang/Float;DDDILjava/lang/String;FJIFILcom/larus/platform/model/LocationExtraInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Float;FLjava/lang/String;ZZZ)Lcom/larus/platform/model/GeoLocationInfo;", "equals", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class GeoLocationInfo implements Serializable {
    private final int accuracyLevel;
    private final double altitude;
    private final Float bearing;
    private final String city;
    private final String cityCode;
    private final String districtCode;
    private final transient b3 extraInfo;
    private final Float gpsDir;
    private final long gpsTime;
    private final boolean isLightLocation;
    private final double latitude;
    private final long locationTime;
    private final int locationType;
    private final double longitude;
    private final float naviAccuracy;
    private final String poi;
    private final boolean poiUseFallback;
    private final String provinceCode;
    private final float radius;
    private final int satelliteCount;
    private final float speed;
    private final boolean validLatlng;

    public static /* synthetic */ GeoLocationInfo copy$default(GeoLocationInfo r17, Float r18, double r19, double r21, double r23, int r25, String r26, float r27, long r28, int r30, float r31, int r32, b3 r33, String r34, String r35, String r36, long r37, Float r39, float r40, String r41, boolean r42, boolean r43, boolean r44, int r45, Object r46) {
        if ((r45 & 1) == 0) goto L5;
        Float r2 = r17.gpsDir;
    L7:
        if ((r45 & 2) == 0) goto L9;
        double r3 = r17.longitude;
    L11:
        if ((r45 & 4) == 0) goto L13;
        double r5 = r17.latitude;
    L15:
        if ((r45 & 8) == 0) goto L17;
        double r7 = r17.altitude;
    L19:
        if ((r45 & 16) == 0) goto L21;
        int r9 = r17.accuracyLevel;
    L23:
        if ((r45 & 32) == 0) goto L25;
        String r10 = r17.city;
    L27:
        if ((r45 & 64) == 0) goto L29;
        float r11 = r17.speed;
    L31:
        if ((r45 & 128) == 0) goto L33;
        long r12 = r17.gpsTime;
    L35:
        if ((r45 & 256) == 0) goto L37;
        int r14 = r17.satelliteCount;
    L39:
        if ((r45 & 512) == 0) goto L41;
        float r15 = r17.radius;
    L42:
        float r38 = r15;
        if ((r45 & 1024) == 0) goto L45;
        int r16 = r17.locationType;
    L46:
        int r310 = r16;
        if ((r45 & 2048) == 0) goto L49;
        b3 r110 = r17.extraInfo;
    L50:
        b3 r311 = r110;
        if ((r45 & 4096) == 0) goto L53;
        String r111 = r17.cityCode;
    L54:
        String r312 = r111;
        if ((r45 & 8192) == 0) goto L57;
        String r112 = r17.districtCode;
    L58:
        String r313 = r112;
        if ((r45 & 16384) == 0) goto L61;
        String r113 = r17.provinceCode;
    L62:
        int r314 = r14;
        String r315 = r113;
        if ((r45 & 32768) == 0) goto L65;
        long r114 = r17.locationTime;
    L66:
        long r316 = r114;
        if ((r45 & 65536) == 0) goto L69;
        Float r115 = r17.bearing;
    L71:
        if ((131072 & r45) == 0) goto L73;
        float r116 = r17.naviAccuracy;
    L74:
        float r47 = r116;
        if ((r45 & 262144) == 0) goto L77;
        String r117 = r17.poi;
    L78:
        String r48 = r117;
        if ((r45 & 524288) == 0) goto L81;
        boolean r118 = r17.poiUseFallback;
    L82:
        boolean r49 = r118;
        if ((r45 & 1048576) == 0) goto L85;
        boolean r119 = r17.validLatlng;
    L87:
        if ((r45 & 2097152) == 0) goto L89;
        boolean r1 = r17.isLightLocation;
    L91:
        return r17.copy(r2, r3, r5, r7, r9, r10, r11, r12, r314, r38, r310, r311, r312, r313, r315, r316, r115, r47, r48, r49, r119, r1);
    L89:
        r1 = r44;
        goto L91
    L85:
        r119 = r43;
        goto L87
    L81:
        r118 = r42;
        goto L82
    L77:
        r117 = r41;
        goto L78
    L73:
        r116 = r40;
        goto L74
    L69:
        r115 = r39;
        goto L71
    L65:
        r114 = r37;
        goto L66
    L61:
        r113 = r36;
        goto L62
    L57:
        r112 = r35;
        goto L58
    L53:
        r111 = r34;
        goto L54
    L49:
        r110 = r33;
        goto L50
    L45:
        r16 = r32;
        goto L46
    L41:
        r15 = r31;
        goto L42
    L37:
        r14 = r30;
        goto L39
    L33:
        r12 = r28;
        goto L35
    L29:
        r11 = r27;
        goto L31
    L25:
        r10 = r26;
        goto L27
    L21:
        r9 = r25;
        goto L23
    L17:
        r7 = r23;
        goto L19
    L13:
        r5 = r21;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final Float component1() {
        return this.gpsDir;
    }

    public final float component10() {
        return this.radius;
    }

    public final int component11() {
        return this.locationType;
    }

    public final b3 component12() {
        return this.extraInfo;
    }

    public final String component13() {
        return this.cityCode;
    }

    public final String component14() {
        return this.districtCode;
    }

    public final String component15() {
        return this.provinceCode;
    }

    public final long component16() {
        return this.locationTime;
    }

    public final Float component17() {
        return this.bearing;
    }

    public final float component18() {
        return this.naviAccuracy;
    }

    public final String component19() {
        return this.poi;
    }

    public final double component2() {
        return this.longitude;
    }

    public final boolean component20() {
        return this.poiUseFallback;
    }

    public final boolean component21() {
        return this.validLatlng;
    }

    public final boolean component22() {
        return this.isLightLocation;
    }

    public final double component3() {
        return this.latitude;
    }

    public final double component4() {
        return this.altitude;
    }

    public final int component5() {
        return this.accuracyLevel;
    }

    public final String component6() {
        return this.city;
    }

    public final float component7() {
        return this.speed;
    }

    public final long component8() {
        return this.gpsTime;
    }

    public final int component9() {
        return this.satelliteCount;
    }

    public final GeoLocationInfo copy(Float r30, double r31, double r33, double r35, int r37, String r38, float r39, long r40, int r42, float r43, int r44, b3 r45, String r46, String r47, String r48, long r49, Float r51, float r52, String r53, boolean r54, boolean r55, boolean r56) {
        return new GeoLocationInfo(r30, r31, r33, r35, r37, r38, r39, r40, r42, r43, r44, r45, r46, r47, r48, r49, r51, r52, r53, r54, r55, r56);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof GeoLocationInfo) == true) goto L8;
        return false;
    L8:
        GeoLocationInfo r9 = (GeoLocationInfo) r8;
        if (Intrinsics.areEqual(this.gpsDir, r9.gpsDir) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.longitude, r9.longitude) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.latitude, r9.latitude) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.altitude, r9.altitude) == 0) goto L21;
        return false;
    L21:
        if (this.accuracyLevel == r9.accuracyLevel) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.city, r9.city) == true) goto L27;
        return false;
    L27:
        if (Float.compare(this.speed, r9.speed) == 0) goto L30;
        return false;
    L30:
        if (this.gpsTime == r9.gpsTime) goto L33;
        return false;
    L33:
        if (this.satelliteCount == r9.satelliteCount) goto L36;
        return false;
    L36:
        if (Float.compare(this.radius, r9.radius) == 0) goto L39;
        return false;
    L39:
        if (this.locationType == r9.locationType) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.extraInfo, r9.extraInfo) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.cityCode, r9.cityCode) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.districtCode, r9.districtCode) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.provinceCode, r9.provinceCode) == true) goto L54;
        return false;
    L54:
        if (this.locationTime == r9.locationTime) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.bearing, r9.bearing) == true) goto L60;
        return false;
    L60:
        if (Float.compare(this.naviAccuracy, r9.naviAccuracy) == 0) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.poi, r9.poi) == true) goto L66;
        return false;
    L66:
        if (this.poiUseFallback == r9.poiUseFallback) goto L69;
        return false;
    L69:
        if (this.validLatlng == r9.validLatlng) goto L72;
        return false;
    L72:
        if (this.isLightLocation == r9.isLightLocation) goto L74;
        return false;
    L74:
        return true;
    }

    public int hashCode() {
        Float r0 = this.gpsDir;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        long r3 = Double.doubleToLongBits(this.longitude);
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = Double.doubleToLongBits(this.latitude);
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r7 = Double.doubleToLongBits(this.altitude);
        int r8 = (((r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31) + this.accuracyLevel) * 31;
        String r9 = this.city;
        if (r9 != null) goto L9;
        int r10 = 0;
    L10:
        int r11 = (((r8 + r10) * 31) + Float.floatToIntBits(this.speed)) * 31;
        long r12 = this.gpsTime;
        int r13 = (((((((r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31) + this.satelliteCount) * 31) + Float.floatToIntBits(this.radius)) * 31) + this.locationType) * 31;
        b3 r14 = this.extraInfo;
        if (r14 != null) goto L13;
        int r15 = 0;
    L14:
        int r16 = (r13 + r15) * 31;
        String r17 = this.cityCode;
        if (r17 != null) goto L17;
        int r18 = 0;
    L18:
        int r19 = (r16 + r18) * 31;
        String r20 = this.districtCode;
        if (r20 != null) goto L21;
        int r21 = 0;
    L22:
        int r22 = (r19 + r21) * 31;
        String r23 = this.provinceCode;
        if (r23 != null) goto L25;
        int r24 = 0;
    L26:
        int r25 = (r22 + r24) * 31;
        long r26 = this.locationTime;
        int r27 = (r25 + ((int) (r26 ^ (r26 >>> 32)))) * 31;
        Float r28 = this.bearing;
        if (r28 != null) goto L29;
        int r29 = 0;
    L30:
        int r30 = (((r27 + r29) * 31) + Float.floatToIntBits(this.naviAccuracy)) * 31;
        String r31 = this.poi;
        if (r31 == null) goto L34;
        r1 = r31.hashCode();
    L34:
        int r32 = (r30 + r1) * 31;
        int r33 = 1231;
        if (this.poiUseFallback == false) goto L37;
        int r34 = 1231;
    L38:
        int r35 = (r32 + r34) * 31;
        if (this.validLatlng == false) goto L41;
        int r36 = 1231;
    L42:
        int r37 = (r35 + r36) * 31;
        if (this.isLightLocation == true) goto L47;
        r33 = 1237;
    L47:
        return r37 + r33;
    L41:
        r36 = 1237;
        goto L42
    L37:
        r34 = 1237;
        goto L38
    L29:
        r29 = r28.hashCode();
        goto L30
    L25:
        r24 = r23.hashCode();
        goto L26
    L21:
        r21 = r20.hashCode();
        goto L22
    L17:
        r18 = r17.hashCode();
        goto L18
    L13:
        r15 = r14.hashCode();
        goto L14
    L9:
        r10 = r9.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "GeoLocationInfo(gpsDir=" + this.gpsDir + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ", altitude=" + this.altitude + ", accuracyLevel=" + this.accuracyLevel + ", city=" + this.city + ", speed=" + this.speed + ", gpsTime=" + this.gpsTime + ", satelliteCount=" + this.satelliteCount + ", radius=" + this.radius + ", locationType=" + this.locationType + ", extraInfo=" + this.extraInfo + ", cityCode=" + this.cityCode + ", districtCode=" + this.districtCode + ", provinceCode=" + this.provinceCode + ", locationTime=" + this.locationTime + ", bearing=" + this.bearing + ", naviAccuracy=" + this.naviAccuracy + ", poi=" + this.poi + ", poiUseFallback=" + this.poiUseFallback + ", validLatlng=" + this.validLatlng + ", isLightLocation=" + this.isLightLocation + ')';
    }

    public final int getAccuracyLevel() {
        return this.accuracyLevel;
    }

    public final double getAltitude() {
        return this.altitude;
    }

    public final Float getBearing() {
        return this.bearing;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCityCode() {
        return this.cityCode;
    }

    public final String getDistrictCode() {
        return this.districtCode;
    }

    public final b3 getExtraInfo() {
        return this.extraInfo;
    }

    public final Float getGpsDir() {
        return this.gpsDir;
    }

    public final long getGpsTime() {
        return this.gpsTime;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final long getLocationTime() {
        return this.locationTime;
    }

    public final int getLocationType() {
        return this.locationType;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final float getNaviAccuracy() {
        return this.naviAccuracy;
    }

    public final String getPoi() {
        return this.poi;
    }

    public final boolean getPoiUseFallback() {
        return this.poiUseFallback;
    }

    public final String getProvinceCode() {
        return this.provinceCode;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final int getSatelliteCount() {
        return this.satelliteCount;
    }

    public final float getSpeed() {
        return this.speed;
    }

    public final boolean getValidLatlng() {
        return this.validLatlng;
    }

    public final boolean isLightLocation() {
        return this.isLightLocation;
    }

    public GeoLocationInfo(Float r4, double r5, double r7, double r9, int r11, String r12, float r13, long r14, int r16, float r17, int r18, b3 r19, String r20, String r21, String r22, long r23, Float r25, float r26, String r27, boolean r28, boolean r29, boolean r30) {
        this.gpsDir = r4;
        this.longitude = r5;
        this.latitude = r7;
        this.altitude = r9;
        this.accuracyLevel = r11;
        this.city = r12;
        this.speed = r13;
        this.gpsTime = r14;
        this.satelliteCount = r16;
        this.radius = r17;
        this.locationType = r18;
        this.extraInfo = r19;
        this.cityCode = r20;
        this.districtCode = r21;
        this.provinceCode = r22;
        this.locationTime = r23;
        this.bearing = r25;
        this.naviAccuracy = r26;
        this.poi = r27;
        this.poiUseFallback = r28;
        this.validLatlng = r29;
        this.isLightLocation = r30;
    }

    public /* synthetic */ GeoLocationInfo(Float r31, double r32, double r34, double r36, int r38, String r39, float r40, long r41, int r43, float r44, int r45, b3 r46, String r47, String r48, String r49, long r50, Float r52, float r53, String r54, boolean r55, boolean r56, boolean r57, int r58, DefaultConstructorMarker r59) {
        if ((r58 & 32) == 0) goto L5;
        String r11 = "";
    L7:
        if ((r58 & 256) == 0) goto L9;
        int r15 = 0;
    L11:
        if ((r58 & 2048) == 0) goto L13;
        b3 r18 = null;
    L15:
        if ((r58 & 4096) == 0) goto L17;
        String r19 = null;
    L19:
        if ((r58 & 8192) == 0) goto L21;
        String r20 = null;
    L23:
        if ((r58 & 16384) == 0) goto L25;
        String r21 = null;
    L27:
        if ((32768 & r58) == 0) goto L29;
        long r22 = 0;
    L31:
        if ((65536 & r58) == 0) goto L33;
        Float r24 = null;
    L35:
        if ((131072 & r58) == 0) goto L37;
        float r25 = 0.0f;
    L39:
        if ((262144 & r58) == 0) goto L41;
        String r26 = null;
    L43:
        if ((524288 & r58) == 0) goto L45;
        boolean r27 = false;
    L47:
        if ((1048576 & r58) == 0) goto L49;
        boolean r28 = false;
    L51:
        if ((r58 & 2097152) == 0) goto L53;
        boolean r29 = false;
    L54:
        this(r31, r32, r34, r36, r38, r11, r40, r41, r15, r44, r45, r18, r19, r20, r21, r22, r24, r25, r26, r27, r28, r29);
        return;
    L53:
        r29 = r57;
        goto L54
    L49:
        r28 = r56;
        goto L51
    L45:
        r27 = r55;
        goto L47
    L41:
        r26 = r54;
        goto L43
    L37:
        r25 = r53;
        goto L39
    L33:
        r24 = r52;
        goto L35
    L29:
        r22 = r50;
        goto L31
    L25:
        r21 = r49;
        goto L27
    L21:
        r20 = r48;
        goto L23
    L17:
        r19 = r47;
        goto L19
    L13:
        r18 = r46;
        goto L15
    L9:
        r15 = r43;
        goto L11
    L5:
        r11 = r39;
        goto L7
    }
}
