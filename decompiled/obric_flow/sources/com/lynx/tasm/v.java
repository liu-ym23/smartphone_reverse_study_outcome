package com.lynx.tasm;

import com.lynx.base.log.LynxLog;

/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ko.d f11182a;

    public v() {
        this.f11182a = null;
    }

    public final void a(String r5, String r10) {
        if (r10 == null) goto L28;
    L15:
        e = move-exception;
        LynxLog.b(3, "LynxInfoReportHelper", "Report Lynx Crash Context tag failed for LynxServiceCenter " + e.getMessage());
        return;
    L4:
        if (this.f11182a != null) goto L18;
        monitor-enter(this);     // Catch: Throwable -> L15
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15 Throwable -> L15
    L7:
        if (this.f11182a != null) goto L11;
        this.f11182a = (ko.d) ko.r.g().e(ko.d.class);     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);     // Catch: Throwable -> L9
    L18:
        if (this.f11182a != null) goto L21;
        LynxLog.b(4, "LynxInfoReportHelper", "LynxMonitorService is null");     // Catch: Throwable -> L15 Throwable -> L15
        return;
    L21:
        this.f11182a.reportCrashGlobalContextTag(r5, r10);     // Catch: Throwable -> L15 Throwable -> L15
        return;
    }
}
