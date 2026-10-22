package com.obric.memorydata.memory.ui.list;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SemanticMemoryPagingPolicy;", "", "<init>", "()V", "resolveRefreshOffset", "", "requestedOffset", "totalCount", "pageSize", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class bk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bk f11245a = null;

    static {
        f11245a = new bk();
    }

    private bk() {
    }

    public final int a(int r1, int r2, int r3) {
        if (r1 <= 0) goto L7;
        if (r2 <= 0) goto L9;
        int r4 = RangesKt.coerceAtLeast(r3, 1);
        return RangesKt.coerceAtMost(r1, ((r2 - 1) / r4) * r4);
    L9:
        return 0;
    L7:
        return 0;
    }
}
