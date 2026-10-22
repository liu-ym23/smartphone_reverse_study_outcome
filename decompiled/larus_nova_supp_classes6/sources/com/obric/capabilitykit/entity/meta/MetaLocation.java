package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.data.ISmModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0001;B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0085\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0002\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0010HÆ\u0003J\t\u0010\"\u001a\u00020\u0010HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0089\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J'\u00102\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000201H\u0010¢\u0006\u0002\b7J\t\u00108\u001a\u00020\u0006HÖ\u0001J\u0018\u00109\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010:\u001a\u000201H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014¨\u0006<"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaLocation;", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "country", "", "stateOrProvince", "administrativeArea", "locality", "subLocality", "thoroughfare", "subThoroughfare", "namedLocation", "fullAddress", "longitude", "", "latitude", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DD)V", "getAdministrativeArea", "()Ljava/lang/String;", "getCountry", "getFullAddress", "getLatitude", "()D", "getLocality", "getLongitude", "getNamedLocation", "getStateOrProvince", "getSubLocality", "getSubThoroughfare", "getThoroughfare", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "onReadMetaValueExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "onReadMetaValueExtensionField$capabilitykitcommon_release", "toString", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class MetaLocation extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String administrativeArea;
    private final String country;
    private final String fullAddress;
    private final double latitude;
    private final String locality;
    private final double longitude;
    private final String namedLocation;
    private final String stateOrProvince;
    private final String subLocality;
    private final String subThoroughfare;
    private final String thoroughfare;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaLocation$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/meta/MetaLocation;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/meta/MetaLocation;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class CREATOR implements Parcelable.Creator<MetaLocation> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaLocation createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new MetaLocation(r2);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaLocation createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaLocation[] newArray(int r1) {
            return new MetaLocation[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaLocation[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaLocation() {
        this(null, null, null, null, null, null, null, null, null, 0.0d, 0.0d, 2047, null);
    }

    public MetaLocation(Parcel r17) {
        Intrinsics.checkNotNullParameter(r17, "parcel");
        this(r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readDouble(), r17.readDouble());
        readMetaValueExtensionField$capabilitykitcommon_release(r17, 0, r17.readInt());
    }

    public MetaLocation(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, double r11, double r13) {
        super(MetaType.LOCATION);
        this.country = r2;
        this.stateOrProvince = r3;
        this.administrativeArea = r4;
        this.locality = r5;
        this.subLocality = r6;
        this.thoroughfare = r7;
        this.subThoroughfare = r8;
        this.namedLocation = r9;
        this.fullAddress = r10;
        this.longitude = r11;
        this.latitude = r13;
    }

    public /* synthetic */ MetaLocation(String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, double r25, double r27, int r29, DefaultConstructorMarker r30) {
        String r2 = null;
        if ((r29 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r29 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r29 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r29 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r29 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r29 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r29 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r29 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r29 & ISmModel.VERSION_0100) != 0) goto L38;
        r2 = r24;
    L38:
        double r11 = 0.0d;
        if ((r29 & ISmModel.VERSION_0200) == 0) goto L41;
        double r13 = 0.0d;
    L43:
        if ((r29 & ISmModel.VERSION_0400) != 0) goto L46;
        r11 = r27;
    L46:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r2, r13, r11);
        return;
    L41:
        r13 = r25;
        goto L43
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }

    public static /* synthetic */ MetaLocation copy$default(MetaLocation r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, double r25, double r27, int r29, Object r30) {
        if ((r29 & 1) == 0) goto L5;
        String r2 = r15.country;
    L7:
        if ((r29 & 2) == 0) goto L9;
        String r3 = r15.stateOrProvince;
    L11:
        if ((r29 & 4) == 0) goto L13;
        String r4 = r15.administrativeArea;
    L15:
        if ((r29 & 8) == 0) goto L17;
        String r5 = r15.locality;
    L19:
        if ((r29 & 16) == 0) goto L21;
        String r6 = r15.subLocality;
    L23:
        if ((r29 & 32) == 0) goto L25;
        String r7 = r15.thoroughfare;
    L27:
        if ((r29 & 64) == 0) goto L29;
        String r8 = r15.subThoroughfare;
    L31:
        if ((r29 & 128) == 0) goto L33;
        String r9 = r15.namedLocation;
    L35:
        if ((r29 & ISmModel.VERSION_0100) == 0) goto L37;
        String r10 = r15.fullAddress;
    L39:
        if ((r29 & ISmModel.VERSION_0200) == 0) goto L41;
        double r11 = r15.longitude;
    L43:
        if ((r29 & ISmModel.VERSION_0400) == 0) goto L45;
        double r13 = r15.latitude;
    L47:
        return r15.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13);
    L45:
        r13 = r27;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final String component1() {
        return this.country;
    }

    public final double component10() {
        return this.longitude;
    }

    public final double component11() {
        return this.latitude;
    }

    public final String component2() {
        return this.stateOrProvince;
    }

    public final String component3() {
        return this.administrativeArea;
    }

    public final String component4() {
        return this.locality;
    }

    public final String component5() {
        return this.subLocality;
    }

    public final String component6() {
        return this.thoroughfare;
    }

    public final String component7() {
        return this.subThoroughfare;
    }

    public final String component8() {
        return this.namedLocation;
    }

    public final String component9() {
        return this.fullAddress;
    }

    public final MetaLocation copy(String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, double r25, double r27) {
        return new MetaLocation(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r27);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof MetaLocation) == true) goto L8;
        return false;
    L8:
        MetaLocation r9 = (MetaLocation) r8;
        if (Intrinsics.areEqual(this.country, r9.country) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.stateOrProvince, r9.stateOrProvince) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.administrativeArea, r9.administrativeArea) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.locality, r9.locality) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.subLocality, r9.subLocality) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.thoroughfare, r9.thoroughfare) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.subThoroughfare, r9.subThoroughfare) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.namedLocation, r9.namedLocation) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.fullAddress, r9.fullAddress) == true) goto L36;
        return false;
    L36:
        if (Double.compare(this.longitude, r9.longitude) == 0) goto L39;
        return false;
    L39:
        if (Double.compare(this.latitude, r9.latitude) == 0) goto L41;
        return false;
    L41:
        return true;
    }

    public final String getAdministrativeArea() {
        return this.administrativeArea;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getFullAddress() {
        return this.fullAddress;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final String getLocality() {
        return this.locality;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final String getNamedLocation() {
        return this.namedLocation;
    }

    public final String getStateOrProvince() {
        return this.stateOrProvince;
    }

    public final String getSubLocality() {
        return this.subLocality;
    }

    public final String getSubThoroughfare() {
        return this.subThoroughfare;
    }

    public final String getThoroughfare() {
        return this.thoroughfare;
    }

    public int hashCode() {
        String r0 = this.country;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.stateOrProvince;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.administrativeArea;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.locality;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.subLocality;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.thoroughfare;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.subThoroughfare;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.namedLocation;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.fullAddress;
        if (r25 == null) goto L38;
        r1 = r25.hashCode();
    L38:
        int r26 = (r24 + r1) * 31;
        long r27 = Double.doubleToLongBits(this.longitude);
        int r28 = (r26 + ((int) (r27 ^ (r27 >>> 32)))) * 31;
        long r29 = Double.doubleToLongBits(this.latitude);
        return r28 + ((int) (r29 ^ (r29 >>> 32)));
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

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "MetaLocation(country=" + this.country + ", stateOrProvince=" + this.stateOrProvince + ", administrativeArea=" + this.administrativeArea + ", locality=" + this.locality + ", subLocality=" + this.subLocality + ", thoroughfare=" + this.thoroughfare + ", subThoroughfare=" + this.subThoroughfare + ", namedLocation=" + this.namedLocation + ", fullAddress=" + this.fullAddress + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeString(this.country);
        r3.writeString(this.stateOrProvince);
        r3.writeString(this.administrativeArea);
        r3.writeString(this.locality);
        r3.writeString(this.subLocality);
        r3.writeString(this.thoroughfare);
        r3.writeString(this.subThoroughfare);
        r3.writeString(this.namedLocation);
        r3.writeString(this.fullAddress);
        r3.writeDouble(this.longitude);
        r3.writeDouble(this.latitude);
        r3.writeInt(0);
    }
}
