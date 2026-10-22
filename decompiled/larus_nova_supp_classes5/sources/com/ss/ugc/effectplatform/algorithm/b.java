package com.ss.ugc.effectplatform.algorithm;

import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static f a;
    public static volatile boolean b;
    public static final b c = null;

    public b() {
    }

    static {
        c = new b();
        a = f.a.a;
    }

    public final void a() {
        if (b == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (b == true) goto L9;
        a.loadLibrary("newep");     // Catch: Throwable -> L12
        b = true;     // Catch: Throwable -> L12
    L9:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
    }
}
