package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.internal.a;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e1 extends kotlinx.coroutines.flow.internal.c<SharedFlowImpl<?>> {
    public long a;
    public j b;

    public e1() {
        this.a = -1;
    }

    public final boolean a(a r6) {
        SharedFlowImpl r7 = (SharedFlowImpl) r6;
        if (this.a < 0) goto L5;
        return false;
    L5:
        long r0 = r7.i;
        if (r0 >= r7.j) goto L8;
        r7.j = r0;
    L8:
        this.a = r0;
        return true;
    }

    public final Continuation[] b(a r5) {
        long r0 = this.a;
        this.a = -1;
        this.b = null;
        return ((SharedFlowImpl) r5).r(r0);
    }
}
