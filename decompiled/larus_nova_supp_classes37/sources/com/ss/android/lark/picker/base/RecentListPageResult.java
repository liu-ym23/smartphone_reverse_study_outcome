package com.ss.android.lark.picker.base;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/picker/base/RecentListPageResult;", "", "items", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "nextLastLabel", "", "hasMore", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Z)V", "getItems", "()Ljava/util/List;", "getNextLastLabel", "()Ljava/lang/String;", "getHasMore", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class RecentListPageResult {
    private final boolean hasMore;
    private final List<SearchBaseInfo> items;
    private final String nextLastLabel;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecentListPageResult copy$default(RecentListPageResult r0, List r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.items;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.nextLastLabel;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.hasMore;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final List<SearchBaseInfo> component1() {
        return this.items;
    }

    public final String component2() {
        return this.nextLastLabel;
    }

    public final boolean component3() {
        return this.hasMore;
    }

    public final RecentListPageResult copy(List<? extends SearchBaseInfo> r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "items");
        return new RecentListPageResult(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RecentListPageResult) == true) goto L8;
        return false;
    L8:
        RecentListPageResult r6 = (RecentListPageResult) r5;
        if (Intrinsics.areEqual(this.items, r6.items) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nextLastLabel, r6.nextLastLabel) == true) goto L15;
        return false;
    L15:
        if (this.hasMore == r6.hasMore) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.items.hashCode() * 31;
        String r1 = this.nextLastLabel;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        if (this.hasMore == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "RecentListPageResult(items=" + this.items + ", nextLastLabel=" + this.nextLastLabel + ", hasMore=" + this.hasMore + ')';
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<SearchBaseInfo> getItems() {
        return this.items;
    }

    public final String getNextLastLabel() {
        return this.nextLastLabel;
    }

    public RecentListPageResult(List<? extends SearchBaseInfo> r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this.items = r2;
        this.nextLastLabel = r3;
        this.hasMore = r4;
    }
}
