package dxb;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j implements Runnable {
    public final /* synthetic */ cxb.a a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public j(cxb.a r1, boolean r2, int r3, String r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        g r0 = new g("wb_load_duration", c.l, this.a);
        r0.a("is_first_page", Boolean.valueOf(this.b));
        r0.a("result_code", Integer.valueOf(this.c));
        r0.a("duration", this.d);
        t.c(r0, this.e);
        r0.b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
