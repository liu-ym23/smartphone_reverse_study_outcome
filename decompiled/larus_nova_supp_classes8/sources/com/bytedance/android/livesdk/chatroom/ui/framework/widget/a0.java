package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a0 implements Runnable {
    public final /* synthetic */ LinkDelegateWidget a;
    public final /* synthetic */ IRoom b;

    public a0(LinkDelegateWidget r1, IRoom r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        kc0.r r0 = this.a.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.p3(this.b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
