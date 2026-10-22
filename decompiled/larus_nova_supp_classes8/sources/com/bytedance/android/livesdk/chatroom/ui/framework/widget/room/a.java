package com.bytedance.android.livesdk.chatroom.ui.framework.widget.room;

import com.bytedance.android.live.link.ILinkServiceExternal;
import com.larus.apm.impl.protector.RunnableProtector;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements Runnable {
    public final /* synthetic */ zg1.m a;

    public a(zg1.m r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ILinkServiceExternal r0 = jc1.k.f(ILinkServiceExternal.class);     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.notifyPauseStatus(this.a.a);     // Catch: Throwable -> L7
    L5:
        xs2.b.a().post(new h1(31));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
