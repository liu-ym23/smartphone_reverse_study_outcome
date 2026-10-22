package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class n implements FlowCollector<Object> {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
    }

    public final Object emit(Object r1, Continuation<? super Unit> r2) {
        return Unit.INSTANCE;
    }
}
