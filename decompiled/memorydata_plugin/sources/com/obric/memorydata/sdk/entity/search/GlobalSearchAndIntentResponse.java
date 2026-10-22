package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003JI\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0017HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006%"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/GlobalSearchAndIntentResponse;", "Landroid/os/Parcelable;", "origin_query", "", "searchAppEntity", "", "Lcom/obric/memorydata/sdk/entity/search/RewriteQuery;", "searchAppEntityContent", "searchMemoryEntity", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getOrigin_query", "()Ljava/lang/String;", "getSearchAppEntity", "()Ljava/util/List;", "getSearchAppEntityContent", "getSearchMemoryEntity", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalSearchAndIntentResponse implements Parcelable {
    public static final a CREATOR = null;
    private final String origin_query;
    private final List<RewriteQuery> searchAppEntity;
    private final List<RewriteQuery> searchAppEntityContent;
    private final List<RewriteQuery> searchMemoryEntity;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/GlobalSearchAndIntentResponse$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/entity/search/GlobalSearchAndIntentResponse;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/entity/search/GlobalSearchAndIntentResponse;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<GlobalSearchAndIntentResponse> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public GlobalSearchAndIntentResponse a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new GlobalSearchAndIntentResponse(r1);
        }

        public GlobalSearchAndIntentResponse[] a(int r1) {
            return new GlobalSearchAndIntentResponse[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ GlobalSearchAndIntentResponse createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ GlobalSearchAndIntentResponse[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public GlobalSearchAndIntentResponse(Parcel r7) {
        Intrinsics.checkNotNullParameter(r7, "parcel");
        String r0 = r7.readString();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        ArrayList r1 = r7.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(RewriteQuery.CREATOR, Parcelable.Creator.class, "com.obric.memorydata.plugin"));
        if (r1 == null) goto L8;
        List r2 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    L9:
        ArrayList r3 = r7.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(RewriteQuery.CREATOR, Parcelable.Creator.class, "com.obric.memorydata.plugin"));
        if (r3 == null) goto L12;
        List r4 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    L13:
        ArrayList r8 = r7.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(RewriteQuery.CREATOR, Parcelable.Creator.class, "com.obric.memorydata.plugin"));
        if (r8 == null) goto L16;
        List r9 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
    L17:
        this(r0, r2, r4, r9);
        return;
    L16:
        r9 = CollectionsKt.emptyList();
        goto L17
    L12:
        r4 = CollectionsKt.emptyList();
        goto L13
    L8:
        r2 = CollectionsKt.emptyList();
        goto L9
    }

    public GlobalSearchAndIntentResponse(String r3, List<RewriteQuery> r4, List<RewriteQuery> r5, List<RewriteQuery> r6) {
        List<RewriteQuery> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<RewriteQuery> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List<RewriteQuery> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "origin_query");
        this.origin_query = r3;
        this.searchAppEntity = r7;
        this.searchAppEntityContent = r8;
        this.searchMemoryEntity = r9;
    }

    public static /* synthetic */ GlobalSearchAndIntentResponse copy$default(GlobalSearchAndIntentResponse r1, String r2, List r3, List r4, List r5, int r6, Object r7) {
        List<RewriteQuery> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<RewriteQuery> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<RewriteQuery> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.origin_query;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = r1.searchAppEntity;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r9 = r1.searchAppEntityContent;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r10 = r1.searchMemoryEntity;
    L15:
        return r1.copy(r2, r8, r9, r10);
    }

    public final String component1() {
        return this.origin_query;
    }

    public final List<RewriteQuery> component2() {
        return this.searchAppEntity;
    }

    public final List<RewriteQuery> component3() {
        return this.searchAppEntityContent;
    }

    public final List<RewriteQuery> component4() {
        return this.searchMemoryEntity;
    }

    public final GlobalSearchAndIntentResponse copy(String r2, List<RewriteQuery> r3, List<RewriteQuery> r4, List<RewriteQuery> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "origin_query");
        return new GlobalSearchAndIntentResponse(r2, r1, r6, r7);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GlobalSearchAndIntentResponse.class) == true) goto L8;
        return false;
    L8:
        GlobalSearchAndIntentResponse r6 = (GlobalSearchAndIntentResponse) ZeusTransformUtils.preCheckCast(r5, GlobalSearchAndIntentResponse.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.origin_query, r6.origin_query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.searchAppEntity, r6.searchAppEntity) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.searchAppEntityContent, r6.searchAppEntityContent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.searchMemoryEntity, r6.searchMemoryEntity) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getOrigin_query() {
        return this.origin_query;
    }

    public final List<RewriteQuery> getSearchAppEntity() {
        return this.searchAppEntity;
    }

    public final List<RewriteQuery> getSearchAppEntityContent() {
        return this.searchAppEntityContent;
    }

    public final List<RewriteQuery> getSearchMemoryEntity() {
        return this.searchMemoryEntity;
    }

    public int hashCode() {
        int r0 = this.origin_query.hashCode() * 31;
        List<RewriteQuery> r1 = this.searchAppEntity;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<RewriteQuery> r5 = this.searchAppEntityContent;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        List<RewriteQuery> r8 = this.searchMemoryEntity;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "GlobalSearchAndIntentResponse(origin_query=" + this.origin_query + ", searchAppEntity=" + this.searchAppEntity + ", searchAppEntityContent=" + this.searchAppEntityContent + ", searchMemoryEntity=" + this.searchMemoryEntity + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.origin_query);
        r1.writeTypedList(this.searchAppEntity);
        r1.writeTypedList(this.searchAppEntityContent);
        r1.writeTypedList(this.searchMemoryEntity);
    }
}
