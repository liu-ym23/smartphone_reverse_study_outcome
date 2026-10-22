package com.bytedance.android.live.liveinteract.voicechat.util;

import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean c;

    public h(int r1, int r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = j.a;     // Catch: Throwable -> L8
        j.b(this.a, this.b);     // Catch: Throwable -> L8
        if (this.c == false) goto L11;
        com.bytedance.live.datacontext.m r1 = o3.d().o();     // Catch: Throwable -> L8
        if (r1 == null) goto L15;
        r1.setValue(Boolean.TRUE);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
