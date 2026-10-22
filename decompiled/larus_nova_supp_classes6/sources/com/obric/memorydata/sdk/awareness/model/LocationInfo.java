package com.obric.memorydata.sdk.awareness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.annotations.SerializedName;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0003!\"#B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0006\u0010\u0015\u001a\u00020\u0003J\b\u0010\u0016\u001a\u00020\u0000H\u0002J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J+\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0013HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006$"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/model/LocationInfo;", "Landroid/os/Parcelable;", "locationType", "", "aoiInfo", "Lcom/obric/memorydata/sdk/awareness/model/LocationInfo$AoiInfo;", "updateSource", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/sdk/awareness/model/LocationInfo$AoiInfo;Ljava/lang/String;)V", "getLocationType", "()Ljava/lang/String;", "getAoiInfo", "()Lcom/obric/memorydata/sdk/awareness/model/LocationInfo$AoiInfo;", "getUpdateSource", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "toJson", "withCompatibleDefaults", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "AoiInfo", "CREATOR", "UpdateSource", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class LocationInfo implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("aoi_info")
    private final AoiInfo aoiInfo;

    @SerializedName("location_type")
    private final String locationType;

    @SerializedName("update_source")
    private final String updateSource;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0006\u0010\u0013\u001a\u00020\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0011HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/model/LocationInfo$AoiInfo;", "Landroid/os/Parcelable;", "aoiId", "", "aoiName", "aoiType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAoiId", "()Ljava/lang/String;", "getAoiName", "getAoiType", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "toJson", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class AoiInfo implements Parcelable {
        public static final a CREATOR = null;

        @SerializedName("aoi_id")
        private final String aoiId;

        @SerializedName("aoi_name")
        private final String aoiName;

        @SerializedName("aoi_type")
        private final String aoiType;

        public AoiInfo() {
            this(0);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof AoiInfo) == true) goto L8;
            return false;
        L8:
            AoiInfo r6 = (AoiInfo) r5;
            if (Intrinsics.areEqual(this.aoiId, r6.aoiId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.aoiName, r6.aoiName) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.aoiType, r6.aoiType) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.aoiId.hashCode() * 31) + this.aoiName.hashCode()) * 31) + this.aoiType.hashCode();
        }

        public final String toString() {
            return "AoiInfo(aoiId=" + this.aoiId + ", aoiName=" + this.aoiName + ", aoiType=" + this.aoiType + ')';
        }

        static {
            CREATOR = new a();
        }

        public final String a() {
            return this.aoiId;
        }

        public final String b() {
            return this.aoiName;
        }

        public final String c() {
            return this.aoiType;
        }

        public /* synthetic */ AoiInfo(int r1) {
            this("", "", "");
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            r1.writeString(GsonProtectorUtils.toJson(com.obric.memorydata.sdk.awareness.model.a.a, this));
        }

        public AoiInfo(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "aoiId");
            Intrinsics.checkNotNullParameter(r3, "aoiName");
            Intrinsics.checkNotNullParameter(r4, "aoiType");
            this.aoiId = r2;
            this.aoiName = r3;
            this.aoiType = r4;
        }
    }

    public static final class a implements Parcelable.Creator<LocationInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LocationInfo createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            String r6 = r5.readString();
            int r0 = 0;
            if (r6 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            LocationInfo r2 = null;
            Object r3 = null;
            if (r1 == false) goto L28;
        L25:
            if (r2 == null) goto L27;
            return r2;
        L27:
            return new LocationInfo(r0);
        L28:
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L18
            LocationInfo r7 = (LocationInfo) com.obric.memorydata.sdk.awareness.model.a.a.fromJson(r6, LocationInfo.class);     // Catch: Throwable -> L18
            if (r7 == null) goto L15;
            LocationInfo r8 = LocationInfo.a(r7);     // Catch: Throwable -> L18
        L16:
            Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L18
        L21:
            if (Result.isFailure-impl(r9) == true) goto L24;
            r3 = r9;
        L24:
            r2 = (LocationInfo) r3;
            goto L25
        L15:
            r8 = null;
        L18:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            r9 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L21
        L5:
            if (StringsKt.isBlank(r6) == true) goto L8;
            r1 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final LocationInfo[] newArray(int r1) {
            return new LocationInfo[r1];
        }
    }

    public LocationInfo() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LocationInfo) == true) goto L8;
        return false;
    L8:
        LocationInfo r6 = (LocationInfo) r5;
        if (Intrinsics.areEqual(this.locationType, r6.locationType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.aoiInfo, r6.aoiInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.updateSource, r6.updateSource) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.locationType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        AoiInfo r4 = this.aoiInfo;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + this.updateSource.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "LocationInfo(locationType=" + this.locationType + ", aoiInfo=" + this.aoiInfo + ", updateSource=" + this.updateSource + ')';
    }

    static {
        CREATOR = new a();
    }

    public /* synthetic */ LocationInfo(int r2) {
        this(null, null, "");
    }

    public static final LocationInfo a(LocationInfo r3) {
        String r1 = r3.locationType;
        AoiInfo r2 = r3.aoiInfo;
        if (r2 == null) goto L5;
        AoiInfo r4 = com.obric.memorydata.sdk.awareness.model.a.a(r2);
    L6:
        String r5 = r3.updateSource;
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        return new LocationInfo(r1, r4, r5);
    L5:
        r4 = null;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(GsonProtectorUtils.toJson(com.obric.memorydata.sdk.awareness.model.a.a, this));
    }

    public LocationInfo(String r2, AoiInfo r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "updateSource");
        this.locationType = r2;
        this.aoiInfo = r3;
        this.updateSource = r4;
    }
}
