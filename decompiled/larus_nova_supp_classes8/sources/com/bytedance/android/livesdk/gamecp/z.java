package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z<T> implements Comparator<T> {
    public z() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((IQuality) r1).getLevel()), Integer.valueOf(((IQuality) r2).getLevel()));
    }
}
