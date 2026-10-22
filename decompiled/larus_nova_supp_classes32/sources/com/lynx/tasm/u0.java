package com.lynx.tasm;

import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.eventreport.LynxEventReporter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(final e0 r14, long r15) {
        final n0 r1 = n0.c;
        r1.getClass();
        TraceEvent.beginSection("GlobalMemoryUsage.query");
        final long r10 = System.currentTimeMillis();
        if (r15 <= 0) goto L5;
        final long r12 = r15;
    L7:
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L9;
        LynxThreadPool.a().execute(new g0(r14, r10, r12));
        TraceEvent.endSection("GlobalMemoryUsage.query");
        return;
    L9:
        final long r5 = r12;
        LynxEventReporter.runOnReportThread(new h0(r1, r14, r10, r5));
        TraceEvent.endSection("GlobalMemoryUsage.query");
        return;
    L5:
        r12 = 2000;
        goto L7
    }
}
