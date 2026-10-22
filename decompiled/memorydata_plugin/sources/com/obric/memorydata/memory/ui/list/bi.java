package com.obric.memorydata.memory.ui.list;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SearchResultPresentationPolicy;", "", "<init>", "()V", "resolveTabVisibility", "Lcom/obric/memorydata/memory/ui/list/SearchTabVisibility;", "isLoading", "", "hasResultList", "hasTabs", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class bi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bi f11242a = null;

    static {
        f11242a = new bi();
    }

    private bi() {
    }

    public final SearchTabVisibility a(boolean r1, boolean r2, boolean r3) {
        if (r1 == true) goto L9;
        if (r2 == false) goto L8;
        if (r3 == false) goto L8;
        return SearchTabVisibility.VISIBLE;
    L8:
        return SearchTabVisibility.GONE;
    L9:
        return SearchTabVisibility.INVISIBLE;
    }
}
