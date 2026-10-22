package com.ss.android.lark.keyboard.ime;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements z0<ImeStateDetail> {
    public final /* synthetic */ StateFlowImpl a;

    public final ImeStateDetail b() {
        return (ImeStateDetail) this.a.getValue();
    }

    public final Object collect(FlowCollector<? super ImeStateDetail> r2, Continuation<?> r3) {
        return this.a.collect(r2, r3);
    }

    public final List<ImeStateDetail> getReplayCache() {
        return this.a.getReplayCache();
    }

    public final i1<Integer> getSubscriptionCount() {
        return this.a.getSubscriptionCount();
    }

    public final void resetReplayCache() {
        this.a.resetReplayCache();
        throw null;
    }

    public final /* bridge */ /* synthetic */ Object getValue() {
        return b();
    }

    public j(ImeStateDetail r2) {
        Intrinsics.checkNotNullParameter(r2, "initialState");
        this.a = j1.a(r2);
    }

    public final void setValue(Object r2) {
        ImeStateDetail r3 = (ImeStateDetail) r2;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.a.setValue(r3);
    }

    public final boolean tryEmit(Object r2) {
        ImeStateDetail r3 = (ImeStateDetail) r2;
        Intrinsics.checkNotNullParameter(r3, "value");
        this.a.setValue(r3);
        return true;
    }

    public final boolean compareAndSet(Object r2, Object r3) {
        ImeStateDetail r4 = (ImeStateDetail) r2;
        ImeStateDetail r5 = (ImeStateDetail) r3;
        Intrinsics.checkNotNullParameter(r4, "expect");
        Intrinsics.checkNotNullParameter(r5, "update");
        return this.a.compareAndSet(r4, r5);
    }

    public final Object emit(Object r1, Continuation r2) {
        StateFlowImpl r3 = this.a;
        r3.setValue((ImeStateDetail) r1);
        return Unit.INSTANCE;
    }
}
