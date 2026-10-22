package com.lynx.tasm.ui.image;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.utils.UIThreadUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class x implements Runnable {
    public final /* synthetic */ y a;

    @Override // java.lang.Runnable
    public final void run() {
        y r0 = this.a;     // Catch: Throwable -> L16
        q r1 = r0.d;     // Catch: Throwable -> L16
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L19;
        r1.c = false;     // Catch: Throwable -> L16
        a r3 = r1.a;     // Catch: Throwable -> L16
        if (r3.a.add(r1) == true) goto L13;
        return;
    L13:
        if (r3.a.size() != 1) goto L24;
        UIThreadUtils.runOnUiThread(r3.b);     // Catch: Throwable -> L16
        return;
    L24:
        return;
    L19:
        return;
    L5:
        if (r1.l != r0.c) goto L7;
        r2 = true;
    L16:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L25;
        throw th;
    }

    public x(y r1) {
        this.a = r1;
    }
}
