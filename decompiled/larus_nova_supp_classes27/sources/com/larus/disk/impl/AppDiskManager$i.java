package com.larus.disk.impl;

import java.io.File;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AppDiskManager$i<T> implements Comparator {
    public AppDiskManager$i() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((File) r1).getAbsolutePath().length()), Integer.valueOf(((File) r2).getAbsolutePath().length()));
    }
}
