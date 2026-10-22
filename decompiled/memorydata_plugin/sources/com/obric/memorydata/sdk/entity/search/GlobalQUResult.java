package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001%B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J1\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0019HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0015¨\u0006&"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/GlobalQUResult;", "Landroid/os/Parcelable;", "origin_query", "", "query_rewrite", "", "Lcom/obric/memorydata/sdk/entity/search/RewriteQuery;", "slot_result", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getOrigin_query", "()Ljava/lang/String;", "getQuery_rewrite", "()Ljava/util/List;", "setQuery_rewrite", "(Ljava/util/List;)V", "getSlot_result", "setSlot_result", "(Ljava/lang/String;)V", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalQUResult implements Parcelable {
    public static final a CREATOR = null;
    private final String origin_query;
    private List<RewriteQuery> query_rewrite;
    private String slot_result;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/GlobalQUResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/entity/search/GlobalQUResult;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/entity/search/GlobalQUResult;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<GlobalQUResult> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public GlobalQUResult a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new GlobalQUResult(r1);
        }

        public GlobalQUResult[] a(int r1) {
            return new GlobalQUResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ GlobalQUResult createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ GlobalQUResult[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public GlobalQUResult(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        String r0 = r5.readString();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this(r0, (List) ZeusTransformUtils.preCheckCast(r5.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(RewriteQuery.CREATOR, Parcelable.Creator.class, "com.obric.memorydata.plugin")), List.class, "com.obric.memorydata.plugin"), r5.readString());
    }

    public GlobalQUResult(String r3, List<RewriteQuery> r4, String r5) {
        List<RewriteQuery> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "origin_query");
        this.origin_query = r3;
        this.query_rewrite = r6;
        this.slot_result = r5;
    }

    public /* synthetic */ GlobalQUResult(String r2, List r3, String r4, int r5, DefaultConstructorMarker r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = null;
    L5:
        this(r2, r7, r4);
    }

    public static /* synthetic */ GlobalQUResult copy$default(GlobalQUResult r1, String r2, List r3, String r4, int r5, Object r6) {
        List<RewriteQuery> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.origin_query;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = r1.query_rewrite;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r1.slot_result;
    L12:
        return r1.copy(r2, r7, r4);
    }

    public final String component1() {
        return this.origin_query;
    }

    public final List<RewriteQuery> component2() {
        return this.query_rewrite;
    }

    public final String component3() {
        return this.slot_result;
    }

    public final GlobalQUResult copy(String r2, List<RewriteQuery> r3, String r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "origin_query");
        return new GlobalQUResult(r2, r1, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GlobalQUResult.class) == true) goto L8;
        return false;
    L8:
        GlobalQUResult r6 = (GlobalQUResult) ZeusTransformUtils.preCheckCast(r5, GlobalQUResult.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.origin_query, r6.origin_query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.query_rewrite, r6.query_rewrite) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.slot_result, r6.slot_result) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getOrigin_query() {
        return this.origin_query;
    }

    public final List<RewriteQuery> getQuery_rewrite() {
        return this.query_rewrite;
    }

    public final String getSlot_result() {
        return this.slot_result;
    }

    public int hashCode() {
        int r0 = this.origin_query.hashCode() * 31;
        List<RewriteQuery> r1 = this.query_rewrite;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.slot_result;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void setQuery_rewrite(List<RewriteQuery> r3) {
        this.query_rewrite = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setSlot_result(String r1) {
        this.slot_result = r1;
    }

    public String toString() {
        return "GlobalQUResult(origin_query=" + this.origin_query + ", query_rewrite=" + this.query_rewrite + ", slot_result=" + this.slot_result + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.origin_query);
        r1.writeTypedList(this.query_rewrite);
        r1.writeString(this.slot_result);
    }
}
