package com.obric.memorydata.personalcontext.search.entity;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/entity/SearchRequest;", "", "searchType", "Lcom/obric/memorydata/personalcontext/search/entity/SearchType;", "searchParams", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "<init>", "(Lcom/obric/memorydata/personalcontext/search/entity/SearchType;Ljava/lang/Object;Ljava/lang/String;)V", "getSearchType", "()Lcom/obric/memorydata/personalcontext/search/entity/SearchType;", "getSearchParams", "()Ljava/lang/Object;", "getPackageName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SearchRequest {

    @SerializedName(ObricMemoryConstants.KEY_PACKAGE_NAME)
    private final String packageName;

    @SerializedName("searchParams")
    private final Object searchParams;

    @SerializedName("searchType")
    private final SearchType searchType;

    public SearchRequest(SearchType r2, Object r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "searchType");
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
        this.searchType = r2;
        this.searchParams = r3;
        this.packageName = r4;
    }

    public /* synthetic */ SearchRequest(SearchType r1, Object r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = "";
    L5:
        this(r1, r2, r3);
    }

    public static /* synthetic */ SearchRequest copy$default(SearchRequest r0, SearchType r1, Object r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.searchType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.searchParams;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.packageName;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final SearchType component1() {
        return this.searchType;
    }

    public final Object component2() {
        return this.searchParams;
    }

    public final String component3() {
        return this.packageName;
    }

    public final SearchRequest copy(SearchType r1, Object r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "searchType");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return new SearchRequest(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SearchRequest.class) == true) goto L8;
        return false;
    L8:
        SearchRequest r6 = (SearchRequest) ZeusTransformUtils.preCheckCast(r5, SearchRequest.class, "com.obric.memorydata.plugin");
        if (this.searchType == r6.searchType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.searchParams, r6.searchParams) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final Object getSearchParams() {
        return this.searchParams;
    }

    public final SearchType getSearchType() {
        return this.searchType;
    }

    public int hashCode() {
        int r0 = this.searchType.hashCode() * 31;
        Object r1 = this.searchParams;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.packageName.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "SearchRequest(searchType=" + this.searchType + ", searchParams=" + this.searchParams + ", packageName=" + this.packageName + ')';
    }
}
