package com.bytedance.android.ec.core.arch.state;

import com.bytedance.android.ec.core.arch.state.b;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class StateRepository<S extends b> {
    public final a<S> a;

    public final Object a(Continuation<? super S> r10) {
        CompletableDeferred r0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        StateRepository$awaitState$2 r1 = new StateRepository$awaitState$2(r0);
        a<S> r11 = this.a;
        e r12 = new e(r1);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "block");
        r11.b.offer(r12);
        return r0.await(r10);
    }

    public StateRepository(S r10, CoroutineScope r11) {
        Intrinsics.checkNotNullParameter(r10, "initialState");
        Intrinsics.checkNotNullParameter(r11, "coroutinesScope");
        this.a = new a(r10, r11);
    }
}
