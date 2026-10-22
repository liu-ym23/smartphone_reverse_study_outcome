package com.obric.memorydata.memory.bridge;

import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"simplify", "Lcom/obric/memorydata/memory/bridge/InfoCommonEntitySimplify;", "Lcom/obric/capabilitykit/entity/memory/InfoCommonMemoryEntity;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {
    public static final InfoCommonEntitySimplify a(InfoCommonMemoryEntity r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return new InfoCommonEntitySimplify(r4.getId(), r4.getInfoKey(), r4.getInfoValue(), r4.getDetail());
    }
}
