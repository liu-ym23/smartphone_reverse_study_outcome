package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import java.util.Comparator;
import kotlin.collections.IndexedValue;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i<T> implements Comparator {
    public i() {
    }

    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) ((IndexedValue) r3).getValue()).d), Long.valueOf(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) ((IndexedValue) r4).getValue()).d));
    }
}
