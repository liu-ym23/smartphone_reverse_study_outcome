package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a<T> implements Comparator {
    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((MmRecordingUploadTask) r1).b), Integer.valueOf(((MmRecordingUploadTask) r2).b));
    }
}
