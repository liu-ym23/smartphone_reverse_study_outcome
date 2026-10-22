package com.larus.voicecall.impl;

import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.voicecall.impl.component.core.r0;
import com.larus.voicecall.impl.component.core.s0;
import com.larus.voicecall.impl.component.core.t0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e0<T> implements FlowCollector {
    public final /* synthetic */ Function0<String> a;
    public final /* synthetic */ Function0<AVKitDuplexState> b;
    public final /* synthetic */ Function2<c0, Continuation<? super Unit>, Object> c;
    public final /* synthetic */ Function1<c0, Unit> d;

    public e0(r0 r1, s0 r2, Function2 r3, t0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object emit(Object r3, Continuation r4) {
        c0 r5 = (c0) r3;
        if (f0.b(r5, (String) this.a.invoke(), (AVKitDuplexState) this.b.invoke()) == false) goto L8;
        Object r6 = this.c.invoke(r5, r4);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r6;
    L10:
        return Unit.INSTANCE;
    L8:
        this.d.invoke(r5);
        return Unit.INSTANCE;
    }
}
