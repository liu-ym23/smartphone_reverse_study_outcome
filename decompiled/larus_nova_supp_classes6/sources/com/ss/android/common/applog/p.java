package com.ss.android.common.applog;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class p implements o {
    public static volatile p b;
    public final CopyOnWriteArraySet<o> a;

    public static p b() {
        if (b != null) goto L15;
        monitor-enter(p.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new p();     // Catch: Throwable -> L11
    L9:
        monitor-exit(p.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public p() {
        this.a = new CopyOnWriteArraySet();
    }

    @Override // com.ss.android.common.applog.o
    public final void a(String r3, long r4, boolean r6) {
        Iterator<o> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        r0.next().a(r3, r4, r6);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L4
    }
}
