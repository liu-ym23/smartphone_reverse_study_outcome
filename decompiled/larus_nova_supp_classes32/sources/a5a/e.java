package a5a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.basedevtool.logbox.LogBoxLogLevel;
import com.lynx.basedevtool.logbox.LogBoxProxy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e implements Runnable {
    public final /* synthetic */ b.a a;

    public final void a() {
        l r0 = this.a.b.e.get();
        if (r0 != null) goto L5;
        return;
    L5:
        LogBoxLogLevel r1 = this.a.b.d;
        l.a r2 = (l.a) ((HashMap) r0.b).get(r1);
        if (r2 == null) goto L16;
        LogBoxProxy r3 = r2.a();
        if (r3 == null) goto L15;
        m r4 = r0.c;
        if (r4 == null) goto L13;
        Map<LogBoxLogLevel, Boolean> r5 = r4.d;
        HashMap r6 = (HashMap) r5;
        r6.put(r1, Boolean.TRUE);
    L13:
        r2.b(r3);
        r3.clearLogsWithLevel(r1);
        return;
    L15:
        return;
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

    public e(b.a r1) {
        this.a = r1;
    }
}
