package com.larus.dora.impl.log.g;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.File;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i<T> implements Comparator {
    public i() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r9, T r10) {
        return ComparisonsKt.compareValues(Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(StringsKt.split$default(((File) r9).getName(), new String[]{"_"}, false, 0, 6, null), 1))), Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(StringsKt.split$default(((File) r10).getName(), new String[]{"_"}, false, 0, 6, null), 1))));
    }
}
