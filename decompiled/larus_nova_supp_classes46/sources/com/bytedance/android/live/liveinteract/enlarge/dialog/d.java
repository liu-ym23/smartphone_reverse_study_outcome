package com.bytedance.android.live.liveinteract.enlarge.dialog;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Comparator<T> {
    public d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((ch0.e) r4).a.getFanTicket()), Long.valueOf(((ch0.e) r3).a.getFanTicket()));
    }
}
