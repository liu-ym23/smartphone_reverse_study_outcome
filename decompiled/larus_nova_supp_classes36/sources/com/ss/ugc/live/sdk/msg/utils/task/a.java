package com.ss.ugc.live.sdk.msg.utils.task;

import com.ss.ugc.live.sdk.msg.utils.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class a<INPUT, OUTPUT> extends b<INPUT, OUTPUT> {
    public abstract void c(INPUT r1);

    public a(mmc.c r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        super(r2);
    }

    @Override // mmc.a
    public final void a(INPUT r2) {
        c(r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        int r0 = g.a;
        b(g.a.a(th));
    }
}
