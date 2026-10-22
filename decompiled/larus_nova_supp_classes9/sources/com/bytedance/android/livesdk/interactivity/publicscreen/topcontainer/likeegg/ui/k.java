package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements Runnable {
    public final /* synthetic */ LikeEggView a;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.likeegg.a b;

    public k(LikeEggView r1, com.bytedance.android.livesdk.chatroom.likeegg.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LikeEggView.d(this.a, this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
