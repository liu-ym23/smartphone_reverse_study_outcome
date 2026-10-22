package com.larus.bmhome.chat.map;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r {
    public static volatile r c;
    public static final r d = null;
    public final AtomicBoolean a;
    public final List<com.larus.bmhome.chat.map.a> b;

    public static final class a {
        public a() {
        }
    }

    static {
        a r0 = new a();
        r r1 = c;
        if (r1 != null) goto L13;
        monitor-enter(r0);
        r1 = c;     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        r1 = new r();     // Catch: Throwable -> L10
        c = r1;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);
    L10:
        th = move-exception;
        throw th;
    L13:
        d = r1;
    }

    public r() {
        this.a = new AtomicBoolean(false);
        this.b = new ArrayList();
    }
}
