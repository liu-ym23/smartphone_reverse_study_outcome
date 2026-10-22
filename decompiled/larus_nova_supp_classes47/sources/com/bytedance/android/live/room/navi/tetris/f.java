package com.bytedance.android.live.room.navi.tetris;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements Runnable {
    public final /* synthetic */ AudienceRoomNavigatorTetris a;

    public f(AudienceRoomNavigatorTetris r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudienceRoomNavigatorTetris r0 = this.a;     // Catch: Throwable -> L6
        com.bytedance.android.livesdk.common.j r1 = r0.F;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r1.setTextWithEllipsis(r0.W());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
