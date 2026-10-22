package dxb;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class r implements Runnable {
    public final /* synthetic */ cxb.a a;
    public final /* synthetic */ String b;

    public r(cxb.a r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        g r0 = new g("wb_browse_url_start", c.f, this.a);
        int r1 = t.a;
        t.a(this.a, r0, this.b);
        cxb.a r2 = this.a;
        if (r2 == null) goto L13;
        Map<String, Object> r3 = r2.getCommonParams();
        if (r3 == null) goto L13;
        int r4 = com.ss.android.lark.officesdk.utils.di.l.a;
        Intrinsics.checkNotNullParameter(r2.getBaseTraceId(), "baseTraceId");
        ntb.o r5 = com.ss.android.lark.officesdk.utils.di.l.a.a();
        if (r5 == null) goto L10;
        String r6 = r5.T();
        if (r6 == null) goto L10;
    L12:
        if (r3.put("trace_id", r6) == null) goto L13;
    L14:
        r0.b();
        return;
    L10:
        r6 = "";
    L13:
        com.ss.android.lark.officesdk.utils.di.j.b("WebMonitorManager", "expand TracingSpan error");
        Unit r7 = Unit.INSTANCE;
        goto L14
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
