package com.bytedance.android.anniex.scene.handler.idle;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Runnable {
    public final /* synthetic */ IdleSignalCenter.a a;

    public a(IdleSignalCenter.a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IdleSignalCenter r0 = IdleSignalCenter.a;     // Catch: Throwable -> L13
        IdleSignalCenter.a r1 = this.a;     // Catch: Throwable -> L13
        monitor-enter(r0);     // Catch: Throwable -> L13
        if (((ArrayList) IdleSignalCenter.b).remove(r1) == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L22;
        throw th;
    }
}
