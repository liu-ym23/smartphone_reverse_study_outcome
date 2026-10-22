package com.obric.memorydata.sdk.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001!B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0014HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\""}, d2 = {"Lcom/obric/memorydata/sdk/entity/RecommendComplexQuery;", "Landroid/os/Parcelable;", ChatMessage.TYPE_QUERY, "", InfoRequestQPSOptTraceLogger.REASON, "sourceData", "meta", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getQuery", "()Ljava/lang/String;", "getReason", "getSourceData", "getMeta", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecommendComplexQuery implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("meta")
    private final String meta;

    @SerializedName(ChatMessage.TYPE_QUERY)
    private final String query;

    @SerializedName(InfoRequestQPSOptTraceLogger.REASON)
    private final String reason;

    @SerializedName("sourceData")
    private final String sourceData;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/entity/RecommendComplexQuery$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/entity/RecommendComplexQuery;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/entity/RecommendComplexQuery;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<RecommendComplexQuery> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public RecommendComplexQuery a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new RecommendComplexQuery(r1);
        }

        public RecommendComplexQuery[] a(int r1) {
            return new RecommendComplexQuery[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ RecommendComplexQuery createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ RecommendComplexQuery[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public RecommendComplexQuery(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        String r0 = r5.readString();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = r5.readString();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        String r3 = r5.readString();
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        String r6 = r5.readString();
        if (r6 == null) goto L15;
        r1 = r6;
    L15:
        this(r0, r2, r3, r1);
    }

    public RecommendComplexQuery(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, ChatMessage.TYPE_QUERY);
        Intrinsics.checkNotNullParameter(r3, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r4, "sourceData");
        Intrinsics.checkNotNullParameter(r5, "meta");
        this.query = r2;
        this.reason = r3;
        this.sourceData = r4;
        this.meta = r5;
    }

    public /* synthetic */ RecommendComplexQuery(String r1, String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = "";
    L5:
        this(r1, r2, r3, r4);
    }

    public static /* synthetic */ RecommendComplexQuery copy$default(RecommendComplexQuery r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.query;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.reason;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.sourceData;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.meta;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.query;
    }

    public final String component2() {
        return this.reason;
    }

    public final String component3() {
        return this.sourceData;
    }

    public final String component4() {
        return this.meta;
    }

    public final RecommendComplexQuery copy(String r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, ChatMessage.TYPE_QUERY);
        Intrinsics.checkNotNullParameter(r2, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r3, "sourceData");
        Intrinsics.checkNotNullParameter(r4, "meta");
        return new RecommendComplexQuery(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RecommendComplexQuery.class) == true) goto L8;
        return false;
    L8:
        RecommendComplexQuery r6 = (RecommendComplexQuery) ZeusTransformUtils.preCheckCast(r5, RecommendComplexQuery.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.reason, r6.reason) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceData, r6.sourceData) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.meta, r6.meta) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getMeta() {
        return this.meta;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getSourceData() {
        return this.sourceData;
    }

    public int hashCode() {
        return (((((this.query.hashCode() * 31) + this.reason.hashCode()) * 31) + this.sourceData.hashCode()) * 31) + this.meta.hashCode();
    }

    public String toString() {
        return "RecommendComplexQuery(query=" + this.query + ", reason=" + this.reason + ", sourceData=" + this.sourceData + ", meta=" + this.meta + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.query);
        r1.writeString(this.reason);
        r1.writeString(this.sourceData);
        r1.writeString(this.meta);
    }
}
