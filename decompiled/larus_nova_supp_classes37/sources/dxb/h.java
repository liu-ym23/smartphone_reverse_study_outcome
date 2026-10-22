package dxb;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h implements Runnable {
    public final /* synthetic */ cxb.a a;
    public final /* synthetic */ String b;

    public h(cxb.a r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r0 = new g("wb_container_pause", c.j, this.a);     // Catch: Throwable -> L4
        int r1 = t.a;     // Catch: Throwable -> L4
        t.a(this.a, r0, this.b);     // Catch: Throwable -> L4
        r0.b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
