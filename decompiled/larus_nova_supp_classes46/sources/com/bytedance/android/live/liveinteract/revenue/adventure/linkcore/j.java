package com.bytedance.android.live.liveinteract.revenue.adventure.linkcore;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements Runnable {
    public final /* synthetic */ h a;

    public j(h r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ALogger.i("AdventureMediaManager", "onDestroy");     // Catch: Throwable -> L10
        ILivePlayerClient r0 = this.a.a;     // Catch: Throwable -> L10
        if (r0 == null) goto L13;
        IRoomEventHub r1 = r0.getEventHub();     // Catch: Throwable -> L10
        if (r1 == null) goto L17;
        MutableLiveData r2 = r1.getPlayerMute();     // Catch: Throwable -> L10
        if (r2 == null) goto L18;
        this.a.getClass();     // Catch: Throwable -> L10
        r2.removeObserver(h.b.a);     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
