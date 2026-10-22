package com.ss.android.lark.chameleonv2.debug;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.utils.di.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    public q(Context r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = s.a;     // Catch: Throwable -> L4
        s.a.a(this.a, this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
