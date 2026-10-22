package com.bytedance.apm.battery.d;

/* JADX INFO: loaded from: classes.dex */
public class f extends b {
    private long c;

    public f() {
        super("cpu_active_time");
        this.c = 0;
    }

    private long b() {
        return com.bytedance.apm.util.b.a(100);
    }

    @Override // com.bytedance.apm.battery.d.l
    public void a(com.bytedance.apm.battery.c.b r8, com.bytedance.apm.c.a r9) {
        boolean r0 = r9.a();
        double r3 = (r9.d() / b()) * 1000.0d;
        if (r0 == false) goto L5;
        r8.k((long) r3);
        return;
    L5:
        r8.b((long) r3);
    }

    @Override // com.bytedance.apm.battery.d.b
    public void b(boolean r8, boolean r9) {
        long r0 = com.bytedance.apm.util.b.d();
        long r2 = this.c;
        if (r2 <= 0) goto L9;
        if (r9 == false) goto L9;
        long r3 = r0 - r2;
        if (r3 <= 0) goto L8;
        a(r8, r3, com.bytedance.apm.battery.a.a().h());
        goto L9
    L8:
        com.bytedance.apm.e.a.b("APM-Battery", "CPU Value:" + r3);
    L9:
        this.c = r0;
    }
}
