package com.ttnet.org.chromium.base.metrics;

import android.os.Trace;

/* JADX INFO: loaded from: classes2.dex */
public class ScopedSysTraceEvent implements AutoCloseable {
    private ScopedSysTraceEvent(String r10) {
        Trace.beginSection(r10);
    }

    public static ScopedSysTraceEvent scoped(String r10) {
        return new ScopedSysTraceEvent(r10);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Trace.endSection();
    }
}
