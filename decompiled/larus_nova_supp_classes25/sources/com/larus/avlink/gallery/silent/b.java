package com.larus.avlink.gallery.silent;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import java.util.TimerTask;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b extends TimerTask {
    public final /* synthetic */ String a;

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        FLogger.a.d("SilentSyncManager", "Timer triggered, checking sync status");     // Catch: Throwable -> L4
        BuildersKt.launch$default(SilentSyncManager.d, null, null, new SilentSyncManager$scheduleAutoSync$1$1(this.a, null), 3, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(String r1) {
        this.a = r1;
    }
}
