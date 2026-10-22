package ft9;

import com.bytedance.news.common.settings.SettingsManager;
import com.larus.utils.logger.FLogger;
import hq9.v2;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class f implements Runnable {
    public /* synthetic */ f() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r0 = g.c;
        monitor-enter(r0);
        g.e = false;     // Catch: Throwable -> L23
        v2 r1 = g.d;     // Catch: Throwable -> L23
        g.d = null;     // Catch: Throwable -> L23
        monitor-exit(r0);
        if (r1 == null) goto L30;
        k.a.getClass();
        if (Intrinsics.areEqual(k.k, r1) == true) goto L21;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L13:
        if (Intrinsics.areEqual(g.d, r1) == false) goto L15;
        g.d = null;     // Catch: Throwable -> L18
    L15:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r0);
        return;
    L21:
        FLogger.a.i("SettingsExt", "retry social settings after previous update generation=" + r1.b);
        SettingsManager.updateSettings(true);
        return;
    L30:
        return;
    L23:
        th = move-exception;
        throw th;
    }
}
