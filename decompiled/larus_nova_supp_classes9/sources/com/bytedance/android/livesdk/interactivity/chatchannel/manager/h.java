package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements Runnable {
    public final /* synthetic */ ChatChannelAnimManager a;
    public final /* synthetic */ ChatChannelAnimManager.a b;

    public h(ChatChannelAnimManager r1, ChatChannelAnimManager.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        ChatChannelAnimManager r0 = this.a;
        ChatChannelAnimManager.a r1 = this.b;
        if (r0.d == true) goto L6;
        return;
    L6:
        if (r0.b != null) goto L8;
        ChatChannelAnimManager.e("submit. exec task " + r1.c);
        r0.b = r1;
        r1.a(new ChatChannelAnimManager$timeoutAction$1(r0));
        return;
    L8:
        ChatChannelAnimManager.e("submit. queue task " + r1.c);
        ((PriorityQueue) r0.a).add(r1);
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
