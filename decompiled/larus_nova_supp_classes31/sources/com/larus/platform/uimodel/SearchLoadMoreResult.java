package com.larus.platform.uimodel;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ur9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/larus/platform/uimodel/SearchLoadMoreResult;", "", "searchResult", "Lcom/larus/platform/uimodel/SearchResult;", "hasMore", "", "queryParams", "Lcom/google/gson/JsonObject;", "<init>", "(Lcom/larus/platform/uimodel/SearchResult;Ljava/lang/Boolean;Lcom/google/gson/JsonObject;)V", "getSearchResult", "()Lcom/larus/platform/uimodel/SearchResult;", "setSearchResult", "(Lcom/larus/platform/uimodel/SearchResult;)V", "getHasMore", "()Ljava/lang/Boolean;", "setHasMore", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getQueryParams", "()Lcom/google/gson/JsonObject;", "setQueryParams", "(Lcom/google/gson/JsonObject;)V", "component1", "component2", "component3", "copy", "(Lcom/larus/platform/uimodel/SearchResult;Ljava/lang/Boolean;Lcom/google/gson/JsonObject;)Lcom/larus/platform/uimodel/SearchLoadMoreResult;", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SearchLoadMoreResult {

    @SerializedName("has_more")
    private Boolean hasMore;

    @SerializedName("query_params")
    private JsonObject queryParams;

    @SerializedName("search_result")
    private a searchResult;

    public SearchLoadMoreResult() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SearchLoadMoreResult copy$default(SearchLoadMoreResult r0, a r1, Boolean r2, JsonObject r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.searchResult;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.hasMore;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.queryParams;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final a component1() {
        return this.searchResult;
    }

    public final Boolean component2() {
        return this.hasMore;
    }

    public final JsonObject component3() {
        return this.queryParams;
    }

    public final SearchLoadMoreResult copy(a r2, Boolean r3, JsonObject r4) {
        return new SearchLoadMoreResult(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SearchLoadMoreResult) == true) goto L8;
        return false;
    L8:
        SearchLoadMoreResult r6 = (SearchLoadMoreResult) r5;
        if (Intrinsics.areEqual(this.searchResult, r6.searchResult) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hasMore, r6.hasMore) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.queryParams, r6.queryParams) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        a r0 = this.searchResult;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.hasMore;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        JsonObject r7 = this.queryParams;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SearchLoadMoreResult(searchResult=" + this.searchResult + ", hasMore=" + this.hasMore + ", queryParams=" + this.queryParams + ')';
    }

    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final JsonObject getQueryParams() {
        return this.queryParams;
    }

    public final a getSearchResult() {
        return this.searchResult;
    }

    public final void setHasMore(Boolean r1) {
        this.hasMore = r1;
    }

    public final void setQueryParams(JsonObject r1) {
        this.queryParams = r1;
    }

    public final void setSearchResult(a r1) {
        this.searchResult = r1;
    }

    public SearchLoadMoreResult(a r1, Boolean r2, JsonObject r3) {
        this.searchResult = r1;
        this.hasMore = r2;
        this.queryParams = r3;
    }

    public /* synthetic */ SearchLoadMoreResult(a r2, Boolean r3, JsonObject r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = Boolean.FALSE;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
