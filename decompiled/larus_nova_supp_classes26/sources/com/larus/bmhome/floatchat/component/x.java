package com.larus.bmhome.floatchat.component;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x<T> implements FlowCollector {
    public final /* synthetic */ FloatChatFoldHandlerComponent a;

    public x(FloatChatFoldHandlerComponent r1) {
        this.a = r1;
    }

    public final Object emit(Object r2, Continuation r3) {
        boolean r4 = Intrinsics.areEqual(((rr8.a) r2).a, Boxing.boxBoolean(true));
        FloatChatFoldHandlerComponent r5 = this.a;
        int r0 = FloatChatFoldHandlerComponent.H1;
        r5.h3(r4);
        return Unit.INSTANCE;
    }
}
