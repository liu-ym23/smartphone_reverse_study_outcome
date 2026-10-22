package com.obric.memorydata.memory.ui.selection;

import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bH&¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/ui/selection/DividerProvider;", "", "shouldShowDivider", "", "getDividerColor", "", "getDividerHeight", "getDividerMargins", "Lkotlin/Pair;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface a {
    boolean a();

    int getDividerColor();

    int getDividerHeight();

    Pair<Integer, Integer> getDividerMargins();
}
