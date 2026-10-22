package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import com.bytedance.android.live.link.ILinkServiceExternal;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l implements Runnable {
    public final /* synthetic */ InteractionComponentManager a;

    public l(InteractionComponentManager r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L8
        if (this.a.getContext().d().getEnterRoomTime().d(Long.valueOf(r0)) == false) goto L11;
        ILinkServiceExternal r2 = jc1.k.f(ILinkServiceExternal.class);     // Catch: Throwable -> L8
        if (r2 == null) goto L15;
        r2.setEnterRoomTime(r0);     // Catch: Throwable -> L8
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
