package com.bytedance.apm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<i> f995a;

    static {
        f995a = new ArrayList(2);
    }

    public static synchronized void a(i r10) {
        monitor-enter(j.class);
        f995a.add(r10);     // Catch: Throwable -> L7
        monitor-exit(j.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(u.e r10) {
        monitor-enter(j.class);
        Iterator<i> r11 = f995a.iterator();     // Catch: Throwable -> L13
    L6:
        if (r11.hasNext() == false) goto L11;
        i r12 = r11.next();     // Catch: Throwable -> L13
        if (r12 == null) goto L6;
        r12.a(r10);     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(j.class);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
