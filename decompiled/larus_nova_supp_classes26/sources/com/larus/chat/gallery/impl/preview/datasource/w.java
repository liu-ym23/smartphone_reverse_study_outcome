package com.larus.chat.gallery.impl.preview.datasource;

import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w<T> implements Comparator {
    public w() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        Integer r4 = ((CreationTask) r2).index;
        int r0 = 0;
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
    L6:
        Integer r6 = Integer.valueOf(r5);
        Integer r7 = ((CreationTask) r3).index;
        if (r7 == null) goto L10;
        r0 = r7.intValue();
    L10:
        return ComparisonsKt.compareValues(r6, Integer.valueOf(r0));
    L5:
        r5 = 0;
        goto L6
    }
}
