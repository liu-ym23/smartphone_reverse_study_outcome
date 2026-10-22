package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import com.bytedance.android.live.link.ILinkServiceExternal;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements Runnable {
    public final /* synthetic */ long a;

    public k(long r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ILinkServiceExternal r0 = jc1.k.f(ILinkServiceExternal.class);     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.updateLoad0Ts(this.a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
