package dxb;

import android.net.Uri;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m implements Runnable {
    public final /* synthetic */ cxb.a a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Uri d;

    public m(cxb.a r1, boolean r2, String r3, Uri r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        g r0 = new g("wb_override_url_loading", c.k, this.a);
        r0.a("is_first_page", Boolean.valueOf(this.b));
        r0.a("override_loading_type", "end");
        r0.a("override_loading_end_point", this.c);
        t.b(r0, this.d);
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
