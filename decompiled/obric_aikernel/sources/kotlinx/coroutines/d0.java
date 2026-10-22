package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d0 extends LockFreeLinkedListNode implements Function1<Throwable, Unit> {
    public d0() {
    }

    public abstract void q(Throwable r10);
}
