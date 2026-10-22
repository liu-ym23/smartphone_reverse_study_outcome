package com.obric.memorydata.recommend.model;

import com.bytedance.obric.memory.model.MemoryData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"createdTimeInMills", "", "Lcom/bytedance/obric/memory/model/MemoryData;", "getCreatedTimeInMills", "(Lcom/bytedance/obric/memory/model/MemoryData;)J", "updatedTimeInMills", "getUpdatedTimeInMills", "recommend_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {
    public static final long a(MemoryData r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return r4.createdTime * ((long) 1000);
    }

    public static final long b(MemoryData r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return r4.updateTime * ((long) 1000);
    }
}
