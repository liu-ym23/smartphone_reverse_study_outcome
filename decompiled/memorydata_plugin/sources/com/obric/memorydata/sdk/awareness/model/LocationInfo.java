package com.obric.memorydata.sdk.awareness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0003!\"#B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0006\u0010\u0015\u001a\u00020\u0003J\b\u0010\u0016\u001a\u00020\u0000H\u0002J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J+\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0013HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006$"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/model/LocationInfo;", "Landroid/os/Parcelable;", "locationType", "", "aoiInfo", "Lcom/obric/memorydata/sdk/awareness/model/LocationInfo$AoiInfo;", "updateSource", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/sdk/awareness/model/LocationInfo$AoiInfo;Ljava/lang/String;)V", "getLocationType", "()Ljava/lang/String;", "getAoiInfo", "()Lcom/obric/memorydata/sdk/awareness/model/LocationInfo$AoiInfo;", "getUpdateSource", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "toJson", "withCompatibleDefaults", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "AoiInfo", "CREATOR", "UpdateSource", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocationInfo implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("aoi_info")
    private final AoiInfo aoiInfo;

    @SerializedName("location_type")
    private final String locationType;

    @SerializedName("update_source")
    private final String updateSource;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0006\u0010\u0013\u001a\u00020\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0011HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/model/LocationInfo$AoiInfo;", "Landroid/os/Parcelable;", "aoiId", "", "aoiName", "aoiType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAoiId", "()Ljava/lang/String;", "getAoiName", "getAoiType", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "toJson", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AoiInfo implements Parcelable {
        public static final a CREATOR = null;

        @SerializedName("aoi_id")
        private final String aoiId;

        @SerializedName("aoi_name")
        private final String aoiName;

        @SerializedName("aoi_type")
        private final String aoiType;

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/model/LocationInfo$AoiInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/awareness/model/LocationInfo$AoiInfo;", "<init>", "()V", "fromJson", "json", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/awareness/model/LocationInfo$AoiInfo;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a implements Parcelable.Creator<AoiInfo> {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            public AoiInfo a(Parcel r7) {
                Intrinsics.checkNotNullParameter(r7, "parcel");
                AoiInfo r6 = a(r7.readString());
                if (r6 == null) goto L5;
                return r6;
            L5:
                return new AoiInfo(null, null, null, 7, null);
            }

            @JvmStatic
            public final AoiInfo a(String r4) {
                CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
                if (r0 != null) goto L5;
            L8:
                boolean r1 = true;
            L9:
                Object r2 = null;
                if (r1 == false) goto L26;
                return null;
            L26:
                Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L18
                a r5 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
                AoiInfo r6 = (AoiInfo) ZeusTransformUtils.preCheckCast(b.a().fromJson(r4, AoiInfo.class), AoiInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
                if (r6 == null) goto L15;
                AoiInfo r7 = b.a(r6);     // Catch: Throwable -> L18
            L16:
                Object r8 = Result.m1421constructorimpl(r7);     // Catch: Throwable -> L18
            L21:
                if (Result.m1427isFailureimpl(r8) == true) goto L25;
                r2 = r8;
            L25:
                return (AoiInfo) ZeusTransformUtils.preCheckCast(r2, AoiInfo.class, "com.obric.memorydata.plugin");
            L15:
                r7 = null;
            L18:
                th = move-exception;
                Result.Companion r9 = Result.Companion;
                r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
                goto L21
            L5:
                if (StringsKt.isBlank(r0) == true) goto L8;
                r1 = false;
                goto L9
            }

            public AoiInfo[] a(int r1) {
                return new AoiInfo[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* synthetic */ AoiInfo createFromParcel(Parcel r1) {
                return a(r1);
            }

            @Override // android.os.Parcelable.Creator
            public /* synthetic */ AoiInfo[] newArray(int r1) {
                return a(r1);
            }
        }

        static {
            CREATOR = new a(null);
        }

        public AoiInfo() {
            this(null, null, null, 7, null);
        }

        public AoiInfo(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "aoiId");
            Intrinsics.checkNotNullParameter(r3, "aoiName");
            Intrinsics.checkNotNullParameter(r4, "aoiType");
            this.aoiId = r2;
            this.aoiName = r3;
            this.aoiType = r4;
        }

        public /* synthetic */ AoiInfo(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = "";
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = "";
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = "";
        L11:
            this(r2, r3, r4);
        }

        public static /* synthetic */ AoiInfo copy$default(AoiInfo r0, String r1, String r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.aoiId;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.aoiName;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.aoiType;
        L12:
            return r0.copy(r1, r2, r3);
        }

        @JvmStatic
        public static final AoiInfo fromJson(String r1) {
            return CREATOR.a(r1);
        }

        public final String component1() {
            return this.aoiId;
        }

        public final String component2() {
            return this.aoiName;
        }

        public final String component3() {
            return this.aoiType;
        }

        public final AoiInfo copy(String r1, String r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "aoiId");
            Intrinsics.checkNotNullParameter(r2, "aoiName");
            Intrinsics.checkNotNullParameter(r3, "aoiType");
            return new AoiInfo(r1, r2, r3);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AoiInfo.class) == true) goto L8;
            return false;
        L8:
            AoiInfo r6 = (AoiInfo) ZeusTransformUtils.preCheckCast(r5, AoiInfo.class, "com.obric.memorydata.plugin");
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

        public final String getAoiId() {
            return this.aoiId;
        }

        public final String getAoiName() {
            return this.aoiName;
        }

        public final String getAoiType() {
            return this.aoiType;
        }

        public int hashCode() {
            return (((this.aoiId.hashCode() * 31) + this.aoiName.hashCode()) * 31) + this.aoiType.hashCode();
        }

        public final String toJson() {
            String r1 = b.a().toJson(this);
            Intrinsics.checkNotNullExpressionValue(r1, "toJson(...)");
            return r1;
        }

        public String toString() {
            return "AoiInfo(aoiId=" + this.aoiId + ", aoiName=" + this.aoiName + ", aoiType=" + this.aoiType + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            r1.writeString(toJson());
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/model/LocationInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/awareness/model/LocationInfo;", "<init>", "()V", "fromJson", "json", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/awareness/model/LocationInfo;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<LocationInfo> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public LocationInfo a(Parcel r7) {
            Intrinsics.checkNotNullParameter(r7, "parcel");
            LocationInfo r6 = a(r7.readString());
            if (r6 == null) goto L5;
            return r6;
        L5:
            return new LocationInfo(null, null, null, 7, null);
        }

        @JvmStatic
        public final LocationInfo a(String r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            Object r2 = null;
            if (r1 == false) goto L26;
            return null;
        L26:
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L18
            a r5 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
            LocationInfo r6 = (LocationInfo) ZeusTransformUtils.preCheckCast(b.a().fromJson(r4, LocationInfo.class), LocationInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
            if (r6 == null) goto L15;
            LocationInfo r7 = LocationInfo.access$withCompatibleDefaults(r6);     // Catch: Throwable -> L18
        L16:
            Object r8 = Result.m1421constructorimpl(r7);     // Catch: Throwable -> L18
        L21:
            if (Result.m1427isFailureimpl(r8) == true) goto L25;
            r2 = r8;
        L25:
            return (LocationInfo) ZeusTransformUtils.preCheckCast(r2, LocationInfo.class, "com.obric.memorydata.plugin");
        L15:
            r7 = null;
        L18:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L21
        L5:
            if (StringsKt.isBlank(r0) == true) goto L8;
            r1 = false;
            goto L9
        }

        public LocationInfo[] a(int r1) {
            return new LocationInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ LocationInfo createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ LocationInfo[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public LocationInfo() {
        this(null, null, null, 7, null);
    }

    public LocationInfo(String r2, AoiInfo r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "updateSource");
        this.locationType = r2;
        this.aoiInfo = r3;
        this.updateSource = r4;
    }

    public /* synthetic */ LocationInfo(String r2, AoiInfo r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = "";
    L11:
        this(r2, r3, r4);
    }

    public static final /* synthetic */ LocationInfo access$withCompatibleDefaults(LocationInfo r0) {
        return r0.withCompatibleDefaults();
    }

    public static /* synthetic */ LocationInfo copy$default(LocationInfo r0, String r1, AoiInfo r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.locationType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.aoiInfo;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.updateSource;
    L12:
        return r0.copy(r1, r2, r3);
    }

    @JvmStatic
    public static final LocationInfo fromJson(String r1) {
        return CREATOR.a(r1);
    }

    private final LocationInfo withCompatibleDefaults() {
        String r1 = this.locationType;
        AoiInfo r2 = this.aoiInfo;
        if (r2 == null) goto L5;
        AoiInfo r3 = b.a(r2);
    L6:
        String r4 = this.updateSource;
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        return new LocationInfo(r1, r3, r4);
    L5:
        r3 = null;
        goto L6
    }

    public final String component1() {
        return this.locationType;
    }

    public final AoiInfo component2() {
        return this.aoiInfo;
    }

    public final String component3() {
        return this.updateSource;
    }

    public final LocationInfo copy(String r1, AoiInfo r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "updateSource");
        return new LocationInfo(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LocationInfo.class) == true) goto L8;
        return false;
    L8:
        LocationInfo r6 = (LocationInfo) ZeusTransformUtils.preCheckCast(r5, LocationInfo.class, "com.obric.memorydata.plugin");
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

    public final AoiInfo getAoiInfo() {
        return this.aoiInfo;
    }

    public final String getLocationType() {
        return this.locationType;
    }

    public final String getUpdateSource() {
        return this.updateSource;
    }

    public int hashCode() {
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

    public final String toJson() {
        String r1 = b.a().toJson(this);
        Intrinsics.checkNotNullExpressionValue(r1, "toJson(...)");
        return r1;
    }

    public String toString() {
        return "LocationInfo(locationType=" + this.locationType + ", aoiInfo=" + this.aoiInfo + ", updateSource=" + this.updateSource + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(toJson());
    }
}
