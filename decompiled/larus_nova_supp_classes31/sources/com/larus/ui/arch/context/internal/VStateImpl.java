package com.larus.ui.arch.context.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import t1a.c;
import t1a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class VStateImpl<T extends c> implements e<T> {
    public T a;
    public final MutableSharedFlow<T> b;
    public final a1 c;
    public final CoroutineScope d;

    @Override // t1a.e
    public final void destroy() {
        CoroutineScopeKt.cancel$default(this.d, null, 1, null);
    }

    @Override // t1a.e
    public final T getSource() {
        return this.a;
    }

    public VStateImpl(T r5) {
        Intrinsics.checkNotNullParameter(r5, "initialSource");
        this.a = r5;
        MutableSharedFlow<T> r1 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.b = r1;
        this.c = kotlinx.coroutines.flow.e.a(r1);
        this.d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        r1.tryEmit(r5);
    }

    @Override // t1a.e
    public final void a(Function1<? super T, ? extends T> r8) {
        Intrinsics.checkNotNullParameter(r8, "reducer");
        BuildersKt.launch$default(this.d, null, null, new VStateImpl$setState$1(r8, this, null), 3, null);
    }

    @Override // t1a.e
    public final void b(Function2<? super T, ? super T, Boolean> r11, boolean r12, Function1<? super T, Unit> r13) {
        Intrinsics.checkNotNullParameter(r11, "compare");
        Intrinsics.checkNotNullParameter(r13, "action");
        BuildersKt.launch$default(this.d, null, null, new VStateImpl$onEach$1(this, r12, r11, r13, null), 3, null);
    }
}
