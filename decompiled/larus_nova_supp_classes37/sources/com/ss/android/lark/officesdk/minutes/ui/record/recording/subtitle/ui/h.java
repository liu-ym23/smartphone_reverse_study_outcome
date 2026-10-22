package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import java.util.Comparator;
import kotlin.collections.IndexedValue;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h<T> implements Comparator {
    public final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l a;

    public h(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(T r5, T r6) {
        return ComparisonsKt.compareValues(Long.valueOf(Math.abs(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) ((IndexedValue) r5).getValue()).d - ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l.a) this.a).a)), Long.valueOf(Math.abs(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) ((IndexedValue) r6).getValue()).d - ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l.a) this.a).a)));
    }
}
