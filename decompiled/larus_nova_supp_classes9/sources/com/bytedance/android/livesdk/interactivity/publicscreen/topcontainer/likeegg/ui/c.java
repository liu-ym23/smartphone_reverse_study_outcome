package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements Runnable {
    public final /* synthetic */ LikeEggView a;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.likeegg.a b;

    public c(LikeEggView r1, com.bytedance.android.livesdk.chatroom.likeegg.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LikeEggView r0 = this.a;     // Catch: Throwable -> L6
        if (r0.h != 2) goto L9;
        LikeEggView.d(r0, this.b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
