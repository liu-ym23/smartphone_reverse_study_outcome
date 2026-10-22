package com.obric.memorydata.memory.ui.automemory;

import com.obric.memorydata.database.entity.MemoryRuleEntity;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0004"}, d2 = {"getStableItemId", "", "item", "Lcom/obric/memorydata/database/entity/MemoryRuleEntity;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class b {
    public static final /* synthetic */ long a(MemoryRuleEntity r2) {
        return b(r2);
    }

    private static final long b(MemoryRuleEntity r4) {
        if (r4.getId() <= 0) goto L7;
        return r4.getId();
    L7:
        return (r4.getTitle() + '_' + r4.getContent()).hashCode();
    }
}
