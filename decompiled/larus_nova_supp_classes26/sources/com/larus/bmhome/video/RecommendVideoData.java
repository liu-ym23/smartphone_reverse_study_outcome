package com.larus.bmhome.video;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/video/RecommendVideoData;", "", "itemLists", "", "Lcom/larus/bmhome/video/Content;", "requestId", "", "hasMore", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Z)V", "getItemLists", "()Ljava/util/List;", "getRequestId", "()Ljava/lang/String;", "getHasMore", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecommendVideoData {

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("item_lists")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<Content> itemLists;

    @SerializedName("request_id")
    private final String requestId;

    public RecommendVideoData() {
        this(null, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecommendVideoData copy$default(RecommendVideoData r0, List r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.itemLists;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.requestId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.hasMore;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final List<Content> component1() {
        return this.itemLists;
    }

    public final String component2() {
        return this.requestId;
    }

    public final boolean component3() {
        return this.hasMore;
    }

    public final RecommendVideoData copy(List<Content> r2, String r3, boolean r4) {
        return new RecommendVideoData(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RecommendVideoData) == true) goto L8;
        return false;
    L8:
        RecommendVideoData r6 = (RecommendVideoData) r5;
        if (Intrinsics.areEqual(this.itemLists, r6.itemLists) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.requestId, r6.requestId) == true) goto L15;
        return false;
    L15:
        if (this.hasMore == r6.hasMore) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<Content> r0 = this.itemLists;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.requestId;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (r3 + r1) * 31;
        if (this.hasMore == false) goto L13;
        int r6 = 1231;
    L15:
        return r5 + r6;
    L13:
        r6 = 1237;
        goto L15
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "RecommendVideoData(itemLists=" + this.itemLists + ", requestId=" + this.requestId + ", hasMore=" + this.hasMore + ')';
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<Content> getItemLists() {
        return this.itemLists;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public RecommendVideoData(List<Content> r1, String r2, boolean r3) {
        this.itemLists = r1;
        this.requestId = r2;
        this.hasMore = r3;
    }

    public /* synthetic */ RecommendVideoData(List r2, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        this(r2, r3, r4);
    }
}
