package com.obric.memorydata.memory.ui.automemory;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryMyCollectionsFragment;", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionsFragment;", "<init>", "()V", "tab", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTab;", "getTab", "()Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTab;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryMyCollectionsFragment extends AutoMemoryCollectionsFragment {
    private final AutoMemoryTab tab;

    public AutoMemoryMyCollectionsFragment() {
        this.tab = AutoMemoryTab.AUTO;
    }

    @Override // com.obric.memorydata.memory.ui.automemory.AutoMemoryCollectionsFragment
    public AutoMemoryTab getTab() {
        return this.tab;
    }
}
