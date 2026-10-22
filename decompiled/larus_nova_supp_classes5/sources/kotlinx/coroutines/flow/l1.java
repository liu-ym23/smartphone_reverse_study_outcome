package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class l1 implements FlowCollector<Object> {
    public final Throwable a;

    public l1(Throwable r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation<? super Unit> r2) {
        throw this.a;
    }
}
