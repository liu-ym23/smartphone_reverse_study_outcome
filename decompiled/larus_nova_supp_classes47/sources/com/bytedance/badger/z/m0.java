package com.bytedance.badger.z;

import java.util.Comparator;
import java.util.zip.ZipEntry;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m0 implements Comparator {
    public m0() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r1, Object r2) {
        return ComparisonsKt.compareValues(((ZipEntry) r1).getName(), ((ZipEntry) r2).getName());
    }
}
