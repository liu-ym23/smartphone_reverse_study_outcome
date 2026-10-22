package com.bytedance.android.live.broadcast;

import com.bytedance.android.livesdkapi.depend.model.broadcast.CommonBubble;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Comparator<T> {
    public e() {
    }

    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((CommonBubble) r3).getPriority()), Long.valueOf(((CommonBubble) r4).getPriority()));
    }
}
