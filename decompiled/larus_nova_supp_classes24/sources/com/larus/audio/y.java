package com.larus.audio;

import com.larus.bmhome.chat.component.title.o1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class y<T> implements FlowCollector {
    public final /* synthetic */ Function0<Unit> a;

    public y(o1 r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        ((Number) r1).intValue();
        this.a.invoke();
        return Unit.INSTANCE;
    }
}
