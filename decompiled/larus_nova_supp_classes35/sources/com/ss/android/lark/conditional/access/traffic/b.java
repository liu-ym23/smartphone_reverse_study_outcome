package com.ss.android.lark.conditional.access.traffic;

import com.bytedance.lark.pb.basic.v1.Command;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.sdk.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements Runnable {
    public final /* synthetic */ g.b a;

    public b(d r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.e.a.b(Command.PUSH_REQ_REGULATE, this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
