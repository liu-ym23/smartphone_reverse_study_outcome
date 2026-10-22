package com.obric.memorydata.memory.api.impl;

import com.obric.memorydata.memory.api.MemoryBuildApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"shouldNotifyImageMemorySuccess", "", "action", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$Action;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {
    public static final boolean a(MemoryBuildApi.Action r1) {
        Intrinsics.checkNotNullParameter(r1, "action");
        if (r1 != MemoryBuildApi.Action.UPDATE) goto L5;
    L7:
        return false;
    L5:
        if (r1 == MemoryBuildApi.Action.UPDATE_SNAPSHOT) goto L7;
        return true;
    }
}
