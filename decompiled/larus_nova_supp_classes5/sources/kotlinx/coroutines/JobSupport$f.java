package kotlinx.coroutines;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedListNode$a;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JobSupport$f extends LockFreeLinkedListNode$a {
    public final /* synthetic */ JobSupport d;
    public final /* synthetic */ Object e;

    public final b0 c(Object r2) {
        LockFreeLinkedListNode r3 = (LockFreeLinkedListNode) r2;
        if (this.d.M() != this.e) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L9;
        return null;
    L9:
        return o.a;
    L5:
        r4 = false;
        goto L6
    }

    public JobSupport$f(final LockFreeLinkedListNode r1, JobSupport r2, Object r3) {
        this.d = r2;
        this.e = r3;
        super(r1);
    }
}
