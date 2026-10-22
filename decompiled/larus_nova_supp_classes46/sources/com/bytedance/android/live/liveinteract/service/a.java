package com.bytedance.android.live.liveinteract.service;

import android.content.Context;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    public a(Context r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ILiveActionHandler r0 = jc1.k.f(ILiveActionHandler.class);     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.handle(this.a, this.b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
