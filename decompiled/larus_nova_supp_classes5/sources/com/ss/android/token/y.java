package com.ss.android.token;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class y implements Runnable {
    public static void a() {
        List r0 = TokenFactory.D;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (((CopyOnWriteArrayList) r0).size() <= 0) goto L11;
        Iterator r1 = ((CopyOnWriteArrayList) r0).iterator();     // Catch: Throwable -> L13
    L8:
        if (r1.hasNext() == false) goto L10;
        ((c) r1.next()).onInitFinish();     // Catch: Throwable -> L13
        goto L8
    L10:
        ((CopyOnWriteArrayList) TokenFactory.D).clear();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public y() {
    }
}
