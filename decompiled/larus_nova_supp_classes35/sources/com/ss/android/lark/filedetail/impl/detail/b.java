package com.ss.android.lark.filedetail.impl.detail;

import com.ss.android.lark.filedetailapi.container.IFileDetailPlugin;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T> implements Comparator {
    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((IFileDetailPlugin) r1).getPriority()), Integer.valueOf(((IFileDetailPlugin) r2).getPriority()));
    }
}
