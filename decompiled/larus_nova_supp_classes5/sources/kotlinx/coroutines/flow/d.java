package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d implements Flow {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final Object collect(FlowCollector<?> r1, Continuation<? super Unit> r2) {
        return Unit.INSTANCE;
    }
}
