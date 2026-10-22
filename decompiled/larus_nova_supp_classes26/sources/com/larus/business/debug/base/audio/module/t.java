package com.larus.business.debug.base.audio.module;

import java.io.File;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t<T> implements Comparator {
    public final /* synthetic */ s a;

    public t(s r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        s r0 = this.a;
        Long r5 = Long.valueOf(s.a(r0, (File) r3));
        s r1 = this.a;
        return ComparisonsKt.compareValues(r5, Long.valueOf(s.a(r1, (File) r4)));
    }
}
