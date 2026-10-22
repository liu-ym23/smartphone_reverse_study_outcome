package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BU\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J^\u0010!\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\"J\t\u0010#\u001a\u00020\nHÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\nHÖ\u0001J\t\u0010)\u001a\u00020\u0004HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\nHÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006/"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/LocationCondition;", "Lcom/obric/eventkit/eventstaskmanager/Condition;", "Landroid/os/Parcelable;", "mode", "", "type", "longitude", "", "latitude", "radius", "", "addrName", "addrType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getAddrName", "()Ljava/lang/String;", "getAddrType", "getLatitude", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLongitude", "getMode", "getRadius", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/eventkit/eventstaskmanager/LocationCondition;", "describeContents", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LocationCondition implements Condition, Parcelable {
    public static final Parcelable.Creator<LocationCondition> CREATOR = null;
    private final String addrName;
    private final String addrType;
    private final Double latitude;
    private final Double longitude;
    private final String mode;
    private final Integer radius;
    private final String type;

    public static final class a implements Parcelable.Creator<LocationCondition> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LocationCondition createFromParcel(Parcel r12) {
            int r0 = r12.readInt();
            Intrinsics.checkNotNullParameter(r12, "parcel");
            String r3 = r12.readString();
            String r4 = r12.readString();
            if (r12.readInt() != 0) goto L5;
            Double r6 = null;
        L7:
            if (r12.readInt() != 0) goto L9;
            Double r7 = null;
        L11:
            if (r12.readInt() != 0) goto L13;
            Integer r8 = null;
        L14:
            LocationCondition r1 = new LocationCondition(r3, r4, r6, r7, r8, r12.readString(), r12.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r5 = a.class.getClassLoader();
            int r9 = 1;
        L15:
            if (r9 > r2) goto L17;
            r9 = r9 + 1;
        L17:
            if (r9 > r0) goto L19;
            joa.a.d(r12, r5);
            r9 = r9 + 1;
            goto L17
        L19:
            return r1;
        L13:
            r8 = Integer.valueOf(r12.readInt());
            goto L14
        L9:
            r7 = Double.valueOf(r12.readDouble());
            goto L11
        L5:
            r6 = Double.valueOf(r12.readDouble());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final LocationCondition[] newArray(int r1) {
            return new LocationCondition[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public LocationCondition(@LocationMode String r2, @LocationType String r3, Double r4, Double r5, Integer r6, String r7, @AddrType String r8) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        Intrinsics.checkNotNullParameter(r3, "type");
        this.mode = r2;
        this.type = r3;
        this.longitude = r4;
        this.latitude = r5;
        this.radius = r6;
        this.addrName = r7;
        this.addrType = r8;
    }

    public /* synthetic */ LocationCondition(String r11, String r12, Double r13, Double r14, Integer r15, String r16, String r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 4) == 0) goto L5;
        Double r5 = null;
    L7:
        if ((r18 & 8) == 0) goto L9;
        Double r6 = null;
    L11:
        if ((r18 & 16) == 0) goto L13;
        Integer r7 = null;
    L15:
        if ((r18 & 32) == 0) goto L17;
        String r8 = null;
    L19:
        if ((r18 & 64) == 0) goto L21;
        String r9 = null;
    L22:
        this(r11, r12, r5, r6, r7, r8, r9);
        return;
    L21:
        r9 = r17;
        goto L22
    L17:
        r8 = r16;
        goto L19
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public static /* synthetic */ LocationCondition copy$default(LocationCondition r5, String r6, String r7, Double r8, Double r9, Integer r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.mode;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.type;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.longitude;
    L11:
        Double r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.latitude;
    L14:
        Double r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.radius;
    L17:
        Integer r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.addrName;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.addrType;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.mode;
    }

    public final String component2() {
        return this.type;
    }

    public final Double component3() {
        return this.longitude;
    }

    public final Double component4() {
        return this.latitude;
    }

    public final Integer component5() {
        return this.radius;
    }

    public final String component6() {
        return this.addrName;
    }

    public final String component7() {
        return this.addrType;
    }

    public final LocationCondition copy(@LocationMode String r10, @LocationType String r11, Double r12, Double r13, Integer r14, String r15, @AddrType String r16) {
        Intrinsics.checkNotNullParameter(r10, "mode");
        Intrinsics.checkNotNullParameter(r11, "type");
        return new LocationCondition(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LocationCondition) == true) goto L8;
        return false;
    L8:
        LocationCondition r6 = (LocationCondition) r5;
        if (Intrinsics.areEqual(this.mode, r6.mode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.longitude, r6.longitude) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.latitude, r6.latitude) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.radius, r6.radius) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.addrName, r6.addrName) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.addrType, r6.addrType) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final String getAddrName() {
        return this.addrName;
    }

    public final String getAddrType() {
        return this.addrType;
    }

    public final Double getLatitude() {
        return this.latitude;
    }

    public final Double getLongitude() {
        return this.longitude;
    }

    public final String getMode() {
        return this.mode;
    }

    public final Integer getRadius() {
        return this.radius;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = ((this.mode.hashCode() * 31) + this.type.hashCode()) * 31;
        Double r1 = this.longitude;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Double r5 = this.latitude;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.radius;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.addrName;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.addrType;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "LocationCondition(mode=" + this.mode + ", type=" + this.type + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ", radius=" + this.radius + ", addrName=" + this.addrName + ", addrType=" + this.addrType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        int r7 = 0;
        r5.writeInt(0);
        Intrinsics.checkNotNullParameter(r5, "out");
        r5.writeString(this.mode);
        r5.writeString(this.type);
        Double r0 = this.longitude;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L6:
        Double r1 = this.latitude;
        if (r1 != null) goto L9;
        r5.writeInt(0);
    L10:
        Integer r2 = this.radius;
        if (r2 == null) goto L14;
        r5.writeInt(1);
        r7 = r2.intValue();
    L14:
        r5.writeInt(r7);
        r5.writeString(this.addrName);
        r5.writeString(this.addrType);
        return;
    L9:
        r5.writeInt(1);
        r5.writeDouble(r1.doubleValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeDouble(r0.doubleValue());
        goto L6
    }
}
