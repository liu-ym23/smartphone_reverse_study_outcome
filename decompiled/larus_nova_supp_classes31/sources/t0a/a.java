package t0a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final StateFlowImpl a;

    public final k0a.a a() {
        return (k0a.a) this.a.getValue();
    }

    public a() {
        this.a = j1.a(new k0a.a(0));
    }

    public final void update(Function1<? super k0a.a, k0a.a> r4) {
        Intrinsics.checkNotNullParameter(r4, "transform");
        StateFlowImpl r0 = this.a;
    L3:
        Object r1 = r0.getValue();
        if (r0.compareAndSet(r1, (k0a.a) r4.invoke((k0a.a) r1)) == false) goto L3;
    }
}
