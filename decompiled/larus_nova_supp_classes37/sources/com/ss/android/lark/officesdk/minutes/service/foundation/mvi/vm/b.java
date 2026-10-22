package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b<S extends l> implements Flow<S> {
    public final Function0<S> a;
    public final Flow<S> b;

    public final Object collect(FlowCollector<? super S> r2, Continuation<? super Unit> r3) {
        return this.b.collect(r2, r3);
    }

    public b(Function0 r2, a1 r3) {
        Intrinsics.checkNotNullParameter(r2, "currentStateProvider");
        Intrinsics.checkNotNullParameter(r3, "stateFlow");
        this.a = r2;
        this.b = r3;
    }
}
