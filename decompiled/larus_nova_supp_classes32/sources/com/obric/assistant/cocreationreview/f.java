package com.obric.assistant.cocreationreview;

import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class f implements Function0 {
    public final /* synthetic */ g a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ f(g r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        g r0 = this.a;
        Function1 r1 = this.b;
        LinkedHashSet r2 = r0.c;
        monitor-enter(r2);
        r0.c.remove(r1);     // Catch: Throwable -> L8
        int r3 = r0.c.size();     // Catch: Throwable -> L8
        monitor-exit(r2);
        int r4 = s3.a;
        s3.b(r0.b, "remove owner=" + r0.a + ", listeners=" + r3);
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        throw th;
    }
}
