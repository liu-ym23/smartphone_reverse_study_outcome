package com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel;

import com.bytedance.android.live.core.utils.f2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements Runnable {
    public final /* synthetic */ LiveLinkShareToThirdDialogFragment a;

    public j(LiveLinkShareToThirdDialogFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LiveLinkShareToThirdDialogFragment r0 = this.a;     // Catch: Throwable -> L4
        int r1 = LiveLinkShareToThirdDialogFragment.n;     // Catch: Throwable -> L4
        r0.getClass();     // Catch: Throwable -> L4
        f2.b(2131922503, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
