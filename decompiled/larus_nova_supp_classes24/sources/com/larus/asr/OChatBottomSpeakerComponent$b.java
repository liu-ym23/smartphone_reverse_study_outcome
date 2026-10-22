package com.larus.asr;

import java.io.File;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class OChatBottomSpeakerComponent$b<T> implements Comparator {
    public OChatBottomSpeakerComponent$b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((File) r4).lastModified()), Long.valueOf(((File) r3).lastModified()));
    }
}
