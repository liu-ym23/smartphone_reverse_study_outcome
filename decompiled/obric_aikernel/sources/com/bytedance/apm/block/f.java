package com.bytedance.apm.block;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<e> f773a;

    static {
        f773a = new ArrayList(2);
    }

    public static synchronized void a(e r10) {
        monitor-enter(f.class);
        f773a.add(r10);     // Catch: Throwable -> L7
        monitor-exit(f.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(boolean r10, long r11) {
        monitor-enter(f.class);
        Iterator<e> r12 = f773a.iterator();     // Catch: Throwable -> L13
    L6:
        if (r12.hasNext() == false) goto L11;
        e r13 = r12.next();     // Catch: Throwable -> L13
        if (r13 == null) goto L6;
        r13.b(r10, r11);     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(f.class);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
