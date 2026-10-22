package com.ss.android.common.applog;

import java.util.LinkedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class d {
    public static volatile d b;
    public final LinkedList<a> a;

    public static d a() {
        if (b != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public d() {
        this.a = new LinkedList();
    }
}
