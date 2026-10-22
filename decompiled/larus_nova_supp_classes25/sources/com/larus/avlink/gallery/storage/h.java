package com.larus.avlink.gallery.storage;

import java.io.File;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h<T> implements Comparator {
    public h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r5, T r6) {
        GalleryStoragePolicyManager.a.getClass();
        Long r7 = GalleryStoragePolicyManager.r((File) r5);
        long r0 = Long.MAX_VALUE;
        if (r7 == null) goto L5;
        long r2 = r7.longValue();
    L6:
        Long r8 = Long.valueOf(r2);
        Long r9 = GalleryStoragePolicyManager.r((File) r6);
        if (r9 == null) goto L10;
        r0 = r9.longValue();
    L10:
        return ComparisonsKt.compareValues(r8, Long.valueOf(r0));
    L5:
        r2 = Long.MAX_VALUE;
        goto L6
    }
}
