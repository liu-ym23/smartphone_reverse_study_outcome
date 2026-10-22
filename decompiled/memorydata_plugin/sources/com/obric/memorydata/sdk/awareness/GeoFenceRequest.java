package com.obric.memorydata.sdk.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0006\u0010\u0017\u001a\u00020\bJ\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/GeoFenceRequest;", "Landroid/os/Parcelable;", "fenceId", "", "longitude", "", "latitude", "radius", "", "<init>", "(Ljava/lang/String;DDI)V", "getFenceId", "()Ljava/lang/String;", "getLongitude", "()D", "getLatitude", "getRadius", "()I", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GeoFenceRequest implements Parcelable {
    public static final Parcelable.Creator<GeoFenceRequest> CREATOR = null;
    private final String fenceId;
    private final double latitude;
    private final double longitude;
    private final int radius;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<GeoFenceRequest> {
        public a() {
        }

        public final GeoFenceRequest a(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            return new GeoFenceRequest(r8.readString(), r8.readDouble(), r8.readDouble(), r8.readInt());
        }

        public final GeoFenceRequest[] a(int r1) {
            return new GeoFenceRequest[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ GeoFenceRequest createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ GeoFenceRequest[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public GeoFenceRequest(String r2, double r3, double r5, int r7) {
        Intrinsics.checkNotNullParameter(r2, "fenceId");
        this.fenceId = r2;
        this.longitude = r3;
        this.latitude = r5;
        this.radius = r7;
    }

    public static /* synthetic */ GeoFenceRequest copy$default(GeoFenceRequest r4, String r5, double r6, double r8, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.fenceId;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.longitude;
    L8:
        double r0 = r6;
        if ((r11 & 4) == 0) goto L11;
        r8 = r4.latitude;
    L11:
        double r2 = r8;
        if ((r11 & 8) == 0) goto L14;
        r10 = r4.radius;
    L14:
        String r7 = r5;
        return r4.copy(r7, r0, r2, r10);
    }

    public final String component1() {
        return this.fenceId;
    }

    public final double component2() {
        return this.longitude;
    }

    public final double component3() {
        return this.latitude;
    }

    public final int component4() {
        return this.radius;
    }

    public final GeoFenceRequest copy(String r8, double r9, double r11, int r13) {
        Intrinsics.checkNotNullParameter(r8, "fenceId");
        return new GeoFenceRequest(r8, r9, r11, r13);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, GeoFenceRequest.class) == true) goto L8;
        return false;
    L8:
        GeoFenceRequest r10 = (GeoFenceRequest) ZeusTransformUtils.preCheckCast(r9, GeoFenceRequest.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.fenceId, r10.fenceId) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.longitude, r10.longitude) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.latitude, r10.latitude) == 0) goto L18;
        return false;
    L18:
        if (this.radius == r10.radius) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getFenceId() {
        return this.fenceId;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final int getRadius() {
        return this.radius;
    }

    public int hashCode() {
        return (((((this.fenceId.hashCode() * 31) + Double.hashCode(this.longitude)) * 31) + Double.hashCode(this.latitude)) * 31) + Integer.hashCode(this.radius);
    }

    public String toString() {
        return "GeoFenceRequest(fenceId=" + this.fenceId + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ", radius=" + this.radius + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.fenceId);
        r3.writeDouble(this.longitude);
        r3.writeDouble(this.latitude);
        r3.writeInt(this.radius);
    }
}
