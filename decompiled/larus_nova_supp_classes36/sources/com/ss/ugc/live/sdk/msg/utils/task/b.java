package com.ss.ugc.live.sdk.msg.utils.task;

import com.ss.ugc.live.sdk.msg.utils.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class b<INPUT, OUTPUT> implements mmc.a<INPUT, OUTPUT> {
    public final TaskState<INPUT, OUTPUT, b<INPUT, OUTPUT>> a;
    public final mmc.c b;

    public b(mmc.c r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.b = r2;
        this.a = new TaskState();
    }

    public final void b(g<? extends OUTPUT, ? extends Throwable> r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        TaskState<INPUT, OUTPUT, b<INPUT, OUTPUT>> r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "result");
        r1.d.d(new TaskState.a.C0233a(r3));
    }
}
