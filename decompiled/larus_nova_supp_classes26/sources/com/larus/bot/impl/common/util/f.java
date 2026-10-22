package com.larus.bot.impl.common.util;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f<T> {
    public final Flow<T> a;
    public final long b;
    public final MutableSharedFlow<T> c;
    public final FlowKt__EmittersKt$onStart$.inlined.unsafeFlow.1 d;
    public long e;
    public a<T> f;

    public static final class a<T> {
        public T a;
        public Job b;

        public a(T r1) {
            this.a = r1;
        }
    }

    public f(MutableSharedFlow r3) {
        Intrinsics.checkNotNullParameter(r3, "upstream");
        this.a = r3;
        this.b = 500;
        MutableSharedFlow<T> r4 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.c = r4;
        this.d = new FlowKt__EmittersKt$onStart$.inlined.unsafeFlow.1(new SharedFlowThrottleLatest$downstream$1(this, null), r4);
    }
}
