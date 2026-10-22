package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.manager;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements Runnable {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    public final void a() {
        if (((ArrayList) this.a.a).isEmpty() == false) goto L6;
        ALogger.e("LikeEggManager", "waitingMsgRunnable run, but waitingMsgList is empty");
        return;
    L6:
        com.bytedance.android.livesdk.chatroom.likeegg.a r0 = (com.bytedance.android.livesdk.chatroom.likeegg.a) ListProtector.remove(this.a.a, 0);
        this.a.getClass();
        GuideTray r1 = GuideTray.HotMsgGather;
        throw null;
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
