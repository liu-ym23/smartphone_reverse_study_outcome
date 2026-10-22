package com.bytedance.apm.battery.d;

/* JADX INFO: loaded from: classes.dex */
public class j extends b {
    private volatile long c;
    private volatile long d;
    private com.bytedance.apm.h.b.g e;

    public j() {
        super("traffic");
        this.c = -1;
        this.d = -1;
        this.e = com.bytedance.apm.h.b.g.a();
    }

    private void d(boolean r9) {
        long r0 = this.e.f();
        long r2 = this.e.d();
        if (this.d > (-1)) goto L5;
    L8:
        this.c = r0;
        this.d = r2;
        return;
    L5:
        if (this.c <= (-1)) goto L8;
        if (r9 == false) goto L8;
        String r10 = com.bytedance.apm.battery.a.a().h();
        a(true, r0 - this.c, r10);
        a(false, r2 - this.d, r10);
        goto L8
    }

    @Override // com.bytedance.apm.battery.d.l
    public void a(com.bytedance.apm.battery.c.b r3, com.bytedance.apm.c.a r4) {
        boolean r2 = r4.a();
        long r0 = r4.d();
        if (r2 == false) goto L5;
        r3.m(r0);
        return;
    L5:
        r3.d(r0);
    }

    @Override // com.bytedance.apm.battery.d.b
    public void b(boolean r4, boolean r5) {
        if (a() == false) goto L14;
        d(r5);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if (com.bytedance.apm.b.k() == false) goto L10;
        com.bytedance.apm.e.e.c(com.bytedance.apm.e.b.f1308b, new String[]{"handleTrafficMonitor error: " + th.getCause()});
    L10:
        com.bytedance.services.apm.api.a.a(th, "BatteryTrafficStatsImpl");
        return;
    }
}
