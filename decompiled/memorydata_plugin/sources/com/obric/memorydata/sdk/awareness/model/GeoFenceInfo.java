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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0006\u0010\u000f\u001a\u00020\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\rHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/model/GeoFenceInfo;", "Landroid/os/Parcelable;", "fenceId", "", "<init>", "(Ljava/lang/String;)V", "getFenceId", "()Ljava/lang/String;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "toJson", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GeoFenceInfo implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("fence_id")
    private final String fenceId;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/model/GeoFenceInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/awareness/model/GeoFenceInfo;", "<init>", "()V", "fromJson", "json", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/awareness/model/GeoFenceInfo;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<GeoFenceInfo> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public GeoFenceInfo a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            GeoFenceInfo r1 = a(r2.readString());
            if (r1 != null) goto L6;
            String r0 = null;
            return new GeoFenceInfo(r0, 1, 0 == true ? 1 : 0);
        L6:
            return r1;
        }

        @JvmStatic
        public final GeoFenceInfo a(String r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            Object r2 = null;
            if (r1 == false) goto L29;
            return null;
        L29:
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L21
            a r5 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
            GeoFenceInfo r6 = (GeoFenceInfo) ZeusTransformUtils.preCheckCast(com.obric.memorydata.sdk.awareness.model.a.a().fromJson(r4, GeoFenceInfo.class), GeoFenceInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
            if (r6 != null) goto L15;
            GeoFenceInfo r7 = null;
        L19:
            Object r8 = Result.m1421constructorimpl(r7);     // Catch: Throwable -> L21
        L24:
            if (Result.m1427isFailureimpl(r8) == true) goto L28;
            r2 = r8;
        L28:
            return (GeoFenceInfo) ZeusTransformUtils.preCheckCast(r2, GeoFenceInfo.class, "com.obric.memorydata.plugin");
        L15:
            String r9 = r6.getFenceId();     // Catch: Throwable -> L21
            if (r9 != null) goto L18;
            r9 = "";
        L18:
            r7 = new GeoFenceInfo(r9);     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L24
        L5:
            if (StringsKt.isBlank(r0) == true) goto L8;
            r1 = false;
            goto L9
        }

        public GeoFenceInfo[] a(int r1) {
            return new GeoFenceInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ GeoFenceInfo createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ GeoFenceInfo[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GeoFenceInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public GeoFenceInfo(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fenceId");
        this.fenceId = r2;
    }

    public /* synthetic */ GeoFenceInfo(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this(r1);
    }

    public static /* synthetic */ GeoFenceInfo copy$default(GeoFenceInfo r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.fenceId;
    L6:
        return r0.copy(r1);
    }

    @JvmStatic
    public static final GeoFenceInfo fromJson(String r1) {
        return CREATOR.a(r1);
    }

    public final String component1() {
        return this.fenceId;
    }

    public final GeoFenceInfo copy(String r1) {
        Intrinsics.checkNotNullParameter(r1, "fenceId");
        return new GeoFenceInfo(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GeoFenceInfo.class) == true) goto L8;
        return false;
    L8:
        GeoFenceInfo r6 = (GeoFenceInfo) ZeusTransformUtils.preCheckCast(r5, GeoFenceInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.fenceId, r6.fenceId) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final String getFenceId() {
        return this.fenceId;
    }

    public int hashCode() {
        return this.fenceId.hashCode();
    }

    public final String toJson() {
        String r1 = com.obric.memorydata.sdk.awareness.model.a.a().toJson(this);
        Intrinsics.checkNotNullExpressionValue(r1, "toJson(...)");
        return r1;
    }

    public String toString() {
        return "GeoFenceInfo(fenceId=" + this.fenceId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(toJson());
    }
}
