package com.larus.business.multitask_management.impl.view;

import com.larus.multitask_management.api.customize.ITaskUIFactory;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x<T> implements Comparator {
    public x() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((ITaskUIFactory) r2).getPriority()), Integer.valueOf(((ITaskUIFactory) r1).getPriority()));
    }
}
