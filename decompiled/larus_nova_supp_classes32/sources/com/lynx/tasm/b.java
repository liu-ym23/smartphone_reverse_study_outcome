package com.lynx.tasm;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements Runnable {
    public final /* synthetic */ List a;

    @Override // java.lang.Runnable
    public final void run() {
        SystemClock.uptimeMillis();     // Catch: Throwable -> L14
        Iterator r0 = this.a.iterator();     // Catch: Throwable -> L11
    L5:
        if (r0.hasNext() == false) goto L9;
        a r1 = ((com.lynx.tasm.behavior.a) r0.next()).createClassWarmer();     // Catch: Throwable -> L11
        if (r1 == null) goto L5;
        r1.a();     // Catch: Throwable -> L11
        goto L5
    L9:
        SystemClock.uptimeMillis();     // Catch: Throwable -> L11
    L28:
        return;
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L18;
        return;
    L18:
        throw th;
    }

    public b(List r1) {
        this.a = r1;
    }
}
