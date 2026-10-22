package com.bytedance.android.live.liveinteract.revenue.adventure.linkcore;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements Runnable {
    public final /* synthetic */ h a;
    public final /* synthetic */ boolean b;

    public i(h r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        ALogger.i("AdventureMediaManager", "muteLiveRoom, isMute: " + this.b);
        if (this.b == false) goto L7;
        ILivePlayerClient r0 = h.a(this.a);
        if (r0 == null) goto L11;
        r0.mute("AdventureMediaManager.muteLiveRoom");
        return;
    L11:
        return;
    L7:
        ILivePlayerClient r1 = h.a(this.a);
        if (r1 == null) goto L13;
        r1.unmute("AdventureMediaManager.muteLiveRoom");
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
}
