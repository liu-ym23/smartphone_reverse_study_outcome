package com.obric.assistant.live.gr.island.island.impl;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public final StackTraceElement[] a;
    public final Function1<Continuation<? super Unit>, Object> b;

    public c() {
        throw null;
    }

    public final String toString() {
        return "IslandTask(creationStack=" + Arrays.toString(this.a) + ", block=" + this.b + ')';
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public c(Function1 r3) {
        StackTraceElement[] r0 = ThreadMethodProxy.currentThread().getStackTrace();
        Intrinsics.checkNotNullParameter(r3, "block");
        this.a = r0;
        this.b = r3;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if (r3 == null) goto L8;
        Class<?> r1 = r3.getClass();
    L10:
        if (Intrinsics.areEqual(c.class, r1) == true) goto L13;
        return false;
    L13:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.assistant.live.gr.island.island.impl.IslandTask");
        return Intrinsics.areEqual(this.b, ((c) r3).b);
    L8:
        r1 = null;
        goto L10
    }
}
