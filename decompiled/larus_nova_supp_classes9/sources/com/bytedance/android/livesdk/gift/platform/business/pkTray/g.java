package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Comparator<T> {
    public g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((d) r2).a), Integer.valueOf(((d) r1).a));
    }
}
