package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0 implements Runnable {
    public final /* synthetic */ HamletAvatarWidget a;

    public c0(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void a() {
        HamletAvatarWidget r0 = this.a;
        int r1 = HamletAvatarWidget.T;
        r0.getClass();
        StringBuilder r2 = new StringBuilder("realRetryStartXplay, (lastXplayEnv!=null)=");
        if (r0.o == null) goto L5;
        boolean r3 = true;
    L6:
        r2.append(r3);
        r2.append(" currentRetryCount=");
        HamletAvatarContext r4 = r0.f;
        if (r4 == null) goto L9;
        Integer r5 = Integer.valueOf(r4.getXplayRetryCount());
    L10:
        r2.append(r5);
        r2.append(", maxCount=");
        boolean r6 = ff0.c.a;
        r2.append(vm2.d.I().getXplayMaxRetryCount());
        ALogger.i("HamletAvatar", r2.toString());
        com.bytedance.android.live.broadcastgame.api.xplay.basic.c r7 = r0.o;
        if (r7 == null) goto L14;
        r0.N = System.currentTimeMillis();
        com.bytedance.android.live.broadcastgame.api.xplay.basic.b.b.d(r7, false, true);
        return;
    L14:
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = false;
        goto L6
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
