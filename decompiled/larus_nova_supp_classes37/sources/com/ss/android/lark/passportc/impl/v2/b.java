package com.ss.android.lark.passportc.impl.v2;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements Executor {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r1) {
        r1.run();
    }
}
