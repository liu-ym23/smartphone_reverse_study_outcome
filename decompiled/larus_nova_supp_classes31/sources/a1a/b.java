package a1a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final StateFlowImpl a;

    public final n0a.a a() {
        return (n0a.a) this.a.getValue();
    }

    public b() {
        this.a = j1.a(new n0a.a(0));
    }

    public final void b(Function1<? super n0a.a, n0a.a> r4) {
        Intrinsics.checkNotNullParameter(r4, "transform");
        StateFlowImpl r0 = this.a;
    L3:
        Object r1 = r0.getValue();
        if (r0.compareAndSet(r1, (n0a.a) r4.invoke((n0a.a) r1)) == false) goto L3;
    }

    public final void update(Function1<? super n0a.a, n0a.a> r4) {
        Intrinsics.checkNotNullParameter(r4, "transform");
        StateFlowImpl r0 = this.a;
    L3:
        Object r1 = r0.getValue();
        if (r0.compareAndSet(r1, (n0a.a) r4.invoke((n0a.a) r1)) == false) goto L3;
    }
}
