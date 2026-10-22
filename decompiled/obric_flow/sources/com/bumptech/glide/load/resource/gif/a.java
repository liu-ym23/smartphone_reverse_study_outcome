package com.bumptech.glide.load.resource.gif;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f1650a;

    public a() {
        char[] r5 = q0.i.f21459a;
        this.f1650a = new ArrayDeque(0);
    }

    public final synchronized void a(x.d r5) {
        monitor-enter(this);
        r5.f22926b = null;     // Catch: Throwable -> L7
        r5.f22927c = null;     // Catch: Throwable -> L7
        this.f1650a.offer(r5);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
