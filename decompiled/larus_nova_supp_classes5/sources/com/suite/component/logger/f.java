package com.suite.component.logger;

import com.suite.component.logger.api.a;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f implements a {
    public static final f a = null;
    public static LinkedList<c> b;

    public f() {
    }

    static {
        a = new f();
        b = new LinkedList();
    }

    @Override // com.suite.component.logger.api.a
    public final Queue<c> a() {
        LinkedList<c> r0 = b;
        monitor-enter(r0);
        LinkedList<c> r1 = b;     // Catch: Throwable -> L7
        b = new LinkedList();     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
