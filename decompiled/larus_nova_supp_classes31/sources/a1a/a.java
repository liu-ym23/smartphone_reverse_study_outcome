package a1a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import m0a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final StateFlowImpl a;

    public a() {
        this.a = j1.a(new f(0));
    }

    public final void update(Function1<? super f, f> r4) {
        Intrinsics.checkNotNullParameter(r4, "transform");
        StateFlowImpl r0 = this.a;
    L3:
        Object r1 = r0.getValue();
        if (r0.compareAndSet(r1, (f) r4.invoke((f) r1)) == false) goto L3;
    }
}
