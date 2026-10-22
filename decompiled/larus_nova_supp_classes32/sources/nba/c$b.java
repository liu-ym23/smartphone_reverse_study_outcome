package nba;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.applog.api.IApplog;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c$b implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ long d;

    public final void a() {
        Object r0 = c.e;
        monitor-enter(r0);
        c.h = null;     // Catch: Throwable -> L9
        c.i = true;     // Catch: Throwable -> L9
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r0);
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("trigger resetAndReInstall, trigger=");
        r3.append(this.a);
        r3.append(", reason=");
        r3.append(this.b);
        r3.append(", invalidDid=");
        r3.append(this.c);
        r3.append(", delayMs=");
        r3.append(this.d);
        r3.append(", timeoutMs=");
        c.a.getClass();
        r3.append(RangesKt.coerceAtLeast(c.e().getReinstallTimeoutMs(), 500));
        r2.i("AppLogIDLStub", r3.toString());
        IApplog.a.u(RangesKt.coerceAtLeast(c.e().getReinstallTimeoutMs(), 500), c.k);
        return;
    L9:
        th = move-exception;
        throw th;
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

    public c$b(String r1, String r2, String r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
