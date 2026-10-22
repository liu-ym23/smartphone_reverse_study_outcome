package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003JI\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0017HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006%"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/GlobalSearchAndIntentResponse;", "Landroid/os/Parcelable;", "origin_query", "", "searchAppEntity", "", "Lcom/obric/memorydata/sdk/entity/search/RewriteQuery;", "searchAppEntityContent", "searchMemoryEntity", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getOrigin_query", "()Ljava/lang/String;", "getSearchAppEntity", "()Ljava/util/List;", "getSearchAppEntityContent", "getSearchMemoryEntity", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalSearchAndIntentResponse implements Parcelable {
    public static final a CREATOR = null;
    private final String origin_query;
    private final List<RewriteQuery> searchAppEntity;
    private final List<RewriteQuery> searchAppEntityContent;
    private final List<RewriteQuery> searchMemoryEntity;

    public static final class a implements Parcelable.Creator<GlobalSearchAndIntentResponse> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalSearchAndIntentResponse createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new GlobalSearchAndIntentResponse(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalSearchAndIntentResponse[] newArray(int r1) {
            return new GlobalSearchAndIntentResponse[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GlobalSearchAndIntentResponse copy$default(GlobalSearchAndIntentResponse r0, String r1, List r2, List r3, List r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.origin_query;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.searchAppEntity;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.searchAppEntityContent;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.searchMemoryEntity;
    L15:
        return r0.copy(r1, r2, r3, r4);
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
        Intrinsics.checkNotNullParameter(r2, "origin_query");
        return new GlobalSearchAndIntentResponse(r2, r3, r4, r5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GlobalSearchAndIntentResponse) == true) goto L8;
        return false;
    L8:
        GlobalSearchAndIntentResponse r6 = (GlobalSearchAndIntentResponse) r5;
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

    public GlobalSearchAndIntentResponse(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        String r0 = r5.readString();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        RewriteQuery.a r1 = RewriteQuery.CREATOR;
        List r2 = r5.createTypedArrayList(r1);
        if (r2 != null) goto L9;
        r2 = CollectionsKt.emptyList();
    L9:
        List r3 = r5.createTypedArrayList(r1);
        if (r3 != null) goto L13;
        r3 = CollectionsKt.emptyList();
    L13:
        List r6 = r5.createTypedArrayList(r1);
        if (r6 != null) goto L17;
        r6 = CollectionsKt.emptyList();
    L17:
        this(r0, r2, r3, r6);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.origin_query);
        r1.writeTypedList(this.searchAppEntity);
        r1.writeTypedList(this.searchAppEntityContent);
        r1.writeTypedList(this.searchMemoryEntity);
    }

    public GlobalSearchAndIntentResponse(String r2, List<RewriteQuery> r3, List<RewriteQuery> r4, List<RewriteQuery> r5) {
        Intrinsics.checkNotNullParameter(r2, "origin_query");
        this.origin_query = r2;
        this.searchAppEntity = r3;
        this.searchAppEntityContent = r4;
        this.searchMemoryEntity = r5;
    }
}
