package csb;

import com.ss.android.lark.monitor.cpu.CpuThreadMetrics;
import com.ss.android.lark.monitor.i;
import com.ss.android.lark.monitor.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends com.ss.android.lark.monitor.a {
    public final d a;

    public c(i r2) {
        this.a = new d(r2.f);
    }

    @Override // com.ss.android.lark.monitor.a
    public final void a(y r3, int r4) {
        if (b.c == null) goto L5;
    L14:
        b.c.getClass();
        CpuThreadMetrics r0 = new CpuThreadMetrics();
        r0.switchType = r4;
        if (b.a().b(r0) == false) goto L20;
        this.a.a(r0, r3);
        return;
    L20:
        return;
    L5:
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b.c != null) goto L9;
        b.c = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
        goto L14
    }
}
