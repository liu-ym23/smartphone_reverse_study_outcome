package com.ss.android.lark.conditional.access.auth.v2.handler;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public final long a;
    public final Function1<Set<String>, Unit> b;
    public long c;
    public final ConcurrentSkipListSet<String> d;
    public boolean e;

    /* JADX WARN: Multi-variable type inference failed */
    public e(long r2, Function1<? super Set<String>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "refreshCallback");
        this.a = r2;
        this.b = r4;
        this.d = new ConcurrentSkipListSet();
    }
}
