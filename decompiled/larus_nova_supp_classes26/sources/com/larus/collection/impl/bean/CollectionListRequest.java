package com.larus.collection.impl.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006$"}, d2 = {"Lcom/larus/collection/impl/bean/CollectionListRequest;", "", "pageSize", "", "page", "lastUpdateTime", "", "scene", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;)V", "getPageSize", "()Ljava/lang/Integer;", "setPageSize", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPage", "setPage", "getLastUpdateTime", "()Ljava/lang/Long;", "setLastUpdateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getScene", "setScene", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/larus/collection/impl/bean/CollectionListRequest;", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CollectionListRequest {

    @SerializedName("last_update_time")
    private Long lastUpdateTime;

    @SerializedName("page")
    private Integer page;

    @SerializedName("page_size")
    private Integer pageSize;

    @SerializedName("scene")
    private Integer scene;

    public CollectionListRequest() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CollectionListRequest copy$default(CollectionListRequest r0, Integer r1, Integer r2, Long r3, Integer r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.pageSize;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.page;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.lastUpdateTime;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.scene;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Integer component1() {
        return this.pageSize;
    }

    public final Integer component2() {
        return this.page;
    }

    public final Long component3() {
        return this.lastUpdateTime;
    }

    public final Integer component4() {
        return this.scene;
    }

    public final CollectionListRequest copy(Integer r2, Integer r3, Long r4, @CollectionListScene Integer r5) {
        return new CollectionListRequest(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CollectionListRequest) == true) goto L8;
        return false;
    L8:
        CollectionListRequest r6 = (CollectionListRequest) r5;
        if (Intrinsics.areEqual(this.pageSize, r6.pageSize) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.page, r6.page) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lastUpdateTime, r6.lastUpdateTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.pageSize;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.page;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.lastUpdateTime;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.scene;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CollectionListRequest(pageSize=" + this.pageSize + ", page=" + this.page + ", lastUpdateTime=" + this.lastUpdateTime + ", scene=" + this.scene + ')';
    }

    public final Long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public final Integer getPage() {
        return this.page;
    }

    public final Integer getPageSize() {
        return this.pageSize;
    }

    public final Integer getScene() {
        return this.scene;
    }

    public final void setLastUpdateTime(Long r1) {
        this.lastUpdateTime = r1;
    }

    public final void setPage(Integer r1) {
        this.page = r1;
    }

    public final void setPageSize(Integer r1) {
        this.pageSize = r1;
    }

    public final void setScene(Integer r1) {
        this.scene = r1;
    }

    public CollectionListRequest(Integer r1, Integer r2, Long r3, @CollectionListScene Integer r4) {
        this.pageSize = r1;
        this.page = r2;
        this.lastUpdateTime = r3;
        this.scene = r4;
    }

    public /* synthetic */ CollectionListRequest(Integer r3, Integer r4, Long r5, Integer r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = 0L;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = 1;
    L14:
        this(r3, r4, r5, r6);
    }
}
