package com.bytedance.frameworks.baselib.network.dispatcher;

import com.bytedance.common.utility.StringUtils;
import kx5.a;
import kx5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class b extends a {
    public static c f;
    public final IRequest.Priority e;

    public final void c() {
        if (((a) this).a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (f != null) goto L7;
        f = c.b();
    L7:
        c r0 = f;
        monitor-enter(r0);
        c.g.a(this);     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final int a() {
        return ((a) this).d;
    }

    public final IRequest.Priority getPriority() {
        return this.e;
    }

    public b(IRequest.Priority r1) {
        this.e = r1;
        StringUtils.isEmpty("UpdateHelper-Thread");
    }

    public final int compareTo(Object r3) {
        IRequest r4 = (IRequest) r3;
        IRequest.Priority r0 = this.e;
        IRequest.Priority r1 = r4.getPriority();
        if (r0 != null) goto L5;
        r0 = IRequest.Priority.NORMAL;
    L5:
        if (r1 != null) goto L7;
        r1 = IRequest.Priority.NORMAL;
    L7:
        if (r0 != r1) goto L10;
        return ((a) this).d - r4.a();
    L10:
        return r1.ordinal() - r0.ordinal();
    }
}
