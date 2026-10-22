package ms.bd.c;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e2 {
    public long a;
    public String b;

    public e2() {
    }

    public final void a(String r15, int r16) {
        monitor-enter(z3.class);
        z3 r0 = z3.b;     // Catch: Throwable -> L13
        monitor-exit(z3.class);
        if (r0 != null) goto L8;
        return;
    L8:
        long r2 = System.currentTimeMillis();
        long r7 = this.a;
        long r5 = r2 - r7;
        String r9 = this.b;
        SDKMonitor r4 = r0.a;
        if (r4 == null) goto L19;
        r4.monitorApiError(r5, r7, r9, null, r15, r16, null);
        return;
    L19:
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
