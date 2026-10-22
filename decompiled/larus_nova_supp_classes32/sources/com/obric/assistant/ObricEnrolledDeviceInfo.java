package com.obric.assistant;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/ObricEnrolledDeviceInfo;", NameKeys.UnloadStrategy_No_Strategy, "macId", NameKeys.UnloadStrategy_No_Strategy, "deviceName", "blueDeviceType", NameKeys.UnloadStrategy_No_Strategy, "blueProductId", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "getMacId", "()Ljava/lang/String;", "getDeviceName", "getBlueDeviceType", "()I", "getBlueProductId", "component1", "component2", "component3", "component4", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricEnrolledDeviceInfo {
    private final int blueDeviceType;
    private final int blueProductId;
    private final String deviceName;
    private final String macId;

    public static /* synthetic */ ObricEnrolledDeviceInfo copy$default(ObricEnrolledDeviceInfo r0, String r1, String r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.macId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.deviceName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.blueDeviceType;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.blueProductId;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.macId;
    }

    public final String component2() {
        return this.deviceName;
    }

    public final int component3() {
        return this.blueDeviceType;
    }

    public final int component4() {
        return this.blueProductId;
    }

    public final ObricEnrolledDeviceInfo copy(String r2, String r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "macId");
        Intrinsics.checkNotNullParameter(r3, "deviceName");
        return new ObricEnrolledDeviceInfo(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricEnrolledDeviceInfo) == true) goto L8;
        return false;
    L8:
        ObricEnrolledDeviceInfo r6 = (ObricEnrolledDeviceInfo) r5;
        if (Intrinsics.areEqual(this.macId, r6.macId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deviceName, r6.deviceName) == true) goto L15;
        return false;
    L15:
        if (this.blueDeviceType == r6.blueDeviceType) goto L18;
        return false;
    L18:
        if (this.blueProductId == r6.blueProductId) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.macId.hashCode() * 31) + this.deviceName.hashCode()) * 31) + this.blueDeviceType) * 31) + this.blueProductId;
    }

    public String toString() {
        return "ObricEnrolledDeviceInfo(macId=" + this.macId + ", deviceName=" + this.deviceName + ", blueDeviceType=" + this.blueDeviceType + ", blueProductId=" + this.blueProductId + ')';
    }

    public final int getBlueDeviceType() {
        return this.blueDeviceType;
    }

    public final int getBlueProductId() {
        return this.blueProductId;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getMacId() {
        return this.macId;
    }

    public ObricEnrolledDeviceInfo(String r2, String r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "macId");
        Intrinsics.checkNotNullParameter(r3, "deviceName");
        this.macId = r2;
        this.deviceName = r3;
        this.blueDeviceType = r4;
        this.blueProductId = r5;
    }

    public /* synthetic */ ObricEnrolledDeviceInfo(String r2, String r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = 0;
    L8:
        this(r2, r3, r4, r5);
    }
}
