package com.lynx.tasm;

import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q0 {
    public volatile i8a.d a;

    public q0() {
        this.a = null;
    }

    public final void a(String r3, String r4) {
        if (r4 == null) goto L28;
    L22:
        e = move-exception;
        LLog.w("LynxInfoReportHelper", "Report Lynx Crash Context tag failed for LynxServiceCenter " + e.getMessage());
        return;
    L4:
        if (this.a != null) goto L15;
        monitor-enter(this);     // Catch: NullPointerException -> L20 Throwable -> L22
    L11:
        th = move-exception;
        throw th;     // Catch: NullPointerException -> L20 Throwable -> L22
    L7:
        if (this.a != null) goto L9;
        this.a = (i8a.d) i8a.n.c().a(i8a.d.class);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
    L15:
        if (this.a != null) goto L18;
        LLog.e("LynxInfoReportHelper", "LynxMonitorService is null");     // Catch: NullPointerException -> L20 Throwable -> L22
        return;
    L18:
        this.a.reportCrashGlobalContextTag(r3, r4);     // Catch: NullPointerException -> L20 Throwable -> L22
        return;
    }
}
