package com.obric.memorydata.memory.ui.list;

import androidx.paging.PagingData;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.memory.memoryentity.search.MemorySearchResultCategory;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SearchResultWithVersion;", "", "version", "", EventBody.KEY_CATEGORY, "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;", "pagingData", "Landroidx/paging/PagingData;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "<init>", "(JLcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;Landroidx/paging/PagingData;)V", "getVersion", "()J", "getCategory", "()Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;", "getPagingData", "()Landroidx/paging/PagingData;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class bj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f11243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MemorySearchResultCategory f11244b;
    private final PagingData<com.obric.memorydata.memory.ui.data.a> c;

    public bj(long r2, MemorySearchResultCategory r4, PagingData<com.obric.memorydata.memory.ui.data.a> r5) {
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_CATEGORY);
        Intrinsics.checkNotNullParameter(r5, "pagingData");
        this.f11243a = r2;
        this.f11244b = r4;
        this.c = r5;
    }

    public final long a() {
        return this.f11243a;
    }

    public final MemorySearchResultCategory b() {
        return this.f11244b;
    }

    public final PagingData<com.obric.memorydata.memory.ui.data.a> c() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, bj.class) == true) goto L8;
        return false;
    L8:
        bj r10 = (bj) ZeusTransformUtils.preCheckCast(r9, bj.class, "com.obric.memorydata.plugin");
        if (this.f11243a == r10.f11243a) goto L12;
        return false;
    L12:
        if (this.f11244b == r10.f11244b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f11243a) * 31) + this.f11244b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "SearchResultWithVersion(version=" + this.f11243a + ", category=" + this.f11244b + ", pagingData=" + this.c + ')';
    }
}
