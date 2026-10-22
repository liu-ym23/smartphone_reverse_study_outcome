package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements Runnable {
    public final /* synthetic */ Function0 a;

    public g(Function0 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
