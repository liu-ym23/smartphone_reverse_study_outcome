package com.larus.dora.impl.log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n implements ff7.e {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;

    public final void onSuccess() {
        DoraLogManager.a.u(true, "upload log success");
        String r0 = p.b;
        p.f(0, this.a, System.currentTimeMillis() - this.b);
    }

    public final void onFail(String r5) {
        g49.d.b("DoraLogManager", "upload log failed, " + r5);
        DoraLogManager.a.u(false, "upload log failed");
        String r6 = p.b;
        p.f(1, this.a, System.currentTimeMillis() - this.b);
    }

    public n(int r1, long r2) {
        this.a = r1;
        this.b = r2;
    }
}
