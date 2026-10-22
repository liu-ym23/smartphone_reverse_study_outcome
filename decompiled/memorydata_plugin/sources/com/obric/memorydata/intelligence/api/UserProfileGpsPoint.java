package com.obric.memorydata.intelligence.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u0017\u001a\u00020\bHÆ\u0003JB\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012¨\u0006 "}, d2 = {"Lcom/obric/memorydata/intelligence/api/UserProfileGpsPoint;", "", "longitude", "", "latitude", "confidence", "radiusM", "isOfficialHome", "", "<init>", "(DDDLjava/lang/Double;Z)V", "getLongitude", "()D", "getLatitude", "getConfidence", "getRadiusM", "()Ljava/lang/Double;", "Ljava/lang/Double;", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "(DDDLjava/lang/Double;Z)Lcom/obric/memorydata/intelligence/api/UserProfileGpsPoint;", "equals", "other", "hashCode", "", "toString", "", "intelligence_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserProfileGpsPoint {
    private final double confidence;
    private final boolean isOfficialHome;
    private final double latitude;
    private final double longitude;
    private final Double radiusM;

    public UserProfileGpsPoint(double r1, double r3, double r5, Double r7, boolean r8) {
        this.longitude = r1;
        this.latitude = r3;
        this.confidence = r5;
        this.radiusM = r7;
        this.isOfficialHome = r8;
    }

    public /* synthetic */ UserProfileGpsPoint(double r12, double r14, double r16, Double r18, boolean r19, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 4) == 0) goto L5;
        double r7 = 0.0d;
    L7:
        if ((r20 & 8) == 0) goto L9;
        Double r9 = null;
    L11:
        if ((r20 & 16) == 0) goto L13;
        boolean r10 = false;
    L14:
        this(r12, r14, r7, r9, r10);
        return;
    L13:
        r10 = r19;
        goto L14
    L9:
        r9 = r18;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }

    public static /* synthetic */ UserProfileGpsPoint copy$default(UserProfileGpsPoint r9, double r10, double r12, double r14, Double r16, boolean r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        double r1 = r9.longitude;
    L7:
        if ((r18 & 2) == 0) goto L9;
        double r3 = r9.latitude;
    L11:
        if ((r18 & 4) == 0) goto L13;
        double r5 = r9.confidence;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Double r7 = r9.radiusM;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r8 = r9.isOfficialHome;
    L23:
        return r9.copy(r1, r3, r5, r7, r8);
    L21:
        r8 = r17;
        goto L23
    L17:
        r7 = r16;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final double component1() {
        return this.longitude;
    }

    public final double component2() {
        return this.latitude;
    }

    public final double component3() {
        return this.confidence;
    }

    public final Double component4() {
        return this.radiusM;
    }

    public final boolean component5() {
        return this.isOfficialHome;
    }

    public final UserProfileGpsPoint copy(double r11, double r13, double r15, Double r17, boolean r18) {
        return new UserProfileGpsPoint(r11, r13, r15, r17, r18);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, UserProfileGpsPoint.class) == true) goto L8;
        return false;
    L8:
        UserProfileGpsPoint r10 = (UserProfileGpsPoint) ZeusTransformUtils.preCheckCast(r9, UserProfileGpsPoint.class, "com.obric.memorydata.plugin");
        if (Double.compare(this.longitude, r10.longitude) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.latitude, r10.latitude) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.confidence, r10.confidence) == 0) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.radiusM, r10.radiusM) == true) goto L21;
        return false;
    L21:
        if (this.isOfficialHome == r10.isOfficialHome) goto L23;
        return false;
    L23:
        return true;
    }

    public final double getConfidence() {
        return this.confidence;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final Double getRadiusM() {
        return this.radiusM;
    }

    public int hashCode() {
        int r0 = ((((Double.hashCode(this.longitude) * 31) + Double.hashCode(this.latitude)) * 31) + Double.hashCode(this.confidence)) * 31;
        Double r1 = this.radiusM;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Boolean.hashCode(this.isOfficialHome);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final boolean isOfficialHome() {
        return this.isOfficialHome;
    }

    public String toString() {
        return "UserProfileGpsPoint(longitude=" + this.longitude + ", latitude=" + this.latitude + ", confidence=" + this.confidence + ", radiusM=" + this.radiusM + ", isOfficialHome=" + this.isOfficialHome + ')';
    }
}
