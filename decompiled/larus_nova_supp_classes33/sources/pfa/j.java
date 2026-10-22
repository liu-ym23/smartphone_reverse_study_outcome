package pfa;

import com.larus.utils.logger.FLogger;
import f09.a;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j implements a.b {
    public j() {
    }

    public final void onAllActivityDestroyed() {
    }

    public final void onAppBackground() {
        FLogger.a.i("NovaProcessControler", "onAppBackground");
    }

    public final void onAppForeground() {
        FLogger.a.i("NovaProcessControler", "onAppForeground");
        Object r0 = i.m;
        monitor-enter(r0);
        i.l = false;     // Catch: Throwable -> L9
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r0);
        i.a.getClass();
        i.a().removeCallbacks(i.q);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
