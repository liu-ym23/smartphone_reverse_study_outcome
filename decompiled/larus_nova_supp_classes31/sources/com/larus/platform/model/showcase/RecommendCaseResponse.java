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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J7\u0010\u0010\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR&\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/larus/platform/model/showcase/RecommendCaseResponse;", "", "caseList", "", "Lcom/larus/platform/model/showcase/Case;", "extra", "", "", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "getCaseList", "()Ljava/util/List;", "getExtra", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class RecommendCaseResponse {

    @SerializedName("case_list")
    private final List<Case> caseList;

    @SerializedName("extra")
    private final Map<String, String> extra;

    /* JADX WARN: Multi-variable type inference failed */
    public RecommendCaseResponse() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecommendCaseResponse copy$default(RecommendCaseResponse r0, List r1, Map r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.caseList;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.extra;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<Case> component1() {
        return this.caseList;
    }

    public final Map<String, String> component2() {
        return this.extra;
    }

    public final RecommendCaseResponse copy(List<Case> r2, Map<String, String> r3) {
        return new RecommendCaseResponse(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RecommendCaseResponse) == true) goto L8;
        return false;
    L8:
        RecommendCaseResponse r6 = (RecommendCaseResponse) r5;
        if (Intrinsics.areEqual(this.caseList, r6.caseList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<Case> r0 = this.caseList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Map<String, String> r4 = this.extra;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "RecommendCaseResponse(caseList=" + this.caseList + ", extra=" + this.extra + ')';
    }

    public final List<Case> getCaseList() {
        return this.caseList;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public RecommendCaseResponse(List<Case> r1, Map<String, String> r2) {
        this.caseList = r1;
        this.extra = r2;
    }

    public /* synthetic */ RecommendCaseResponse(List r1, Map r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = MapsKt.emptyMap();
    L8:
        this(r1, r2);
    }
}
