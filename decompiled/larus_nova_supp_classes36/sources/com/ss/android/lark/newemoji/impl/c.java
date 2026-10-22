package com.ss.android.lark.newemoji.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Runnable {
    public final /* synthetic */ EmojiService2 a;
    public final /* synthetic */ Set<qsb.a> b;
    public final /* synthetic */ Integer c;

    public c(EmojiService2 r1, Set<qsb.a> r2, Integer r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        rsb.a r0 = this.a.c;     // Catch: Throwable -> L4
        Set<qsb.a> r1 = this.b;     // Catch: Throwable -> L4
        Integer r2 = this.c;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L4
        r0.V8(r1, r2.intValue());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
