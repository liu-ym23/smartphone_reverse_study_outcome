package com.larus.platform.model.showcase;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003JH\u0010\u0016\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\tHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR&\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/larus/platform/model/showcase/ListCaseResponse;", "", "caseList", "", "Lcom/larus/platform/model/showcase/Case;", "hasMore", "", "extra", "", "", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/util/Map;)V", "getCaseList", "()Ljava/util/List;", "getHasMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getExtra", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/util/Map;)Lcom/larus/platform/model/showcase/ListCaseResponse;", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ListCaseResponse {

    @SerializedName("case_list")
    private final List<Case> caseList;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("has_more")
    private final Boolean hasMore;

    public ListCaseResponse() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListCaseResponse copy$default(ListCaseResponse r0, List r1, Boolean r2, Map r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.caseList;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.hasMore;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.extra;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final List<Case> component1() {
        return this.caseList;
    }

    public final Boolean component2() {
        return this.hasMore;
    }

    public final Map<String, String> component3() {
        return this.extra;
    }

    public final ListCaseResponse copy(List<Case> r2, Boolean r3, Map<String, String> r4) {
        return new ListCaseResponse(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ListCaseResponse) == true) goto L8;
        return false;
    L8:
        ListCaseResponse r6 = (ListCaseResponse) r5;
        if (Intrinsics.areEqual(this.caseList, r6.caseList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hasMore, r6.hasMore) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<Case> r0 = this.caseList;
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
        Map<String, String> r7 = this.extra;
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
        return "ListCaseResponse(caseList=" + this.caseList + ", hasMore=" + this.hasMore + ", extra=" + this.extra + ')';
    }

    public final List<Case> getCaseList() {
        return this.caseList;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public ListCaseResponse(List<Case> r1, Boolean r2, Map<String, String> r3) {
        this.caseList = r1;
        this.hasMore = r2;
        this.extra = r3;
    }

    public /* synthetic */ ListCaseResponse(List r1, Boolean r2, Map r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = Boolean.FALSE;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = MapsKt.emptyMap();
    L11:
        this(r1, r2, r3);
    }
}
