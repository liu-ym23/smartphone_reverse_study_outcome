package com.obric.cae.location.report;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f7273a;

    public static a a() {
        return f7273a;
    }

    public static synchronized void a(a r3) {
        monitor-enter(b.class);
        com.obric.cae.log.a.c("StarLocation-ReportFactory", "Creating Location report instance");     // Catch: Throwable -> L10
        if (f7273a != null) goto L7;
        r3.a();     // Catch: Throwable -> L10
        com.obric.cae.log.a.c("StarLocation-ReportFactory", "Creating instance: StarLocation-ReportJson");     // Catch: Throwable -> L10
        f7273a = r3;     // Catch: Throwable -> L10
    L8:
        monitor-exit(b.class);
        return;
    L7:
        r3.a();     // Catch: Throwable -> L10
        f7273a.a();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }
}
