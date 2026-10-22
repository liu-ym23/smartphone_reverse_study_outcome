package dxb;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class p implements Runnable {
    public final /* synthetic */ cxb.a a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public p(cxb.a r1, boolean r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        g r0 = new g("webview_container_report", c.b, this.a);
        r0.a("is_first_page", Boolean.valueOf(this.b));
        r0.a("scene", "performance_timing");
        String r1 = this.c;
        String r2 = this.d;
        t.c(r0, r1);
        JSONObject r3 = new JSONObject(r2);     // Catch: Throwable -> L8
        Iterator<String> r4 = r3.keys();     // Catch: Throwable -> L8
    L5:
        if (r4.hasNext() == false) goto L10;
        String r5 = r4.next();     // Catch: Throwable -> L8
        r0.a(r5, r3.opt(r5));     // Catch: Throwable -> L8
    L10:
        r0.b();
        return;
    L8:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("WebMonitorManager", th);
        goto L10
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
