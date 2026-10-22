package dxb;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k implements Runnable {
    public final /* synthetic */ cxb.a a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;

    public k(cxb.a r1, boolean r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r0 = new g("wb_load_resource", null, this.a);     // Catch: Throwable -> L4
        r0.a("is_first_page", Boolean.valueOf(this.b));     // Catch: Throwable -> L4
        t.c(r0, this.c);     // Catch: Throwable -> L4
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
