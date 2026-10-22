package kotlin.sequences;

import java.util.Collection;
import java.util.Iterator;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.RestrictsSuspension;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.3")
@RestrictsSuspension
public abstract class SequenceScope<T> {
    public SequenceScope() {
    }

    public abstract Object yield(T r10, Continuation<? super Unit> r11);

    public final Object yieldAll(Iterable<? extends T> r10, Continuation<? super Unit> r11) {
        if ((r10 instanceof Collection) == true) goto L5;
    L8:
        Object r12 = yieldAll(r10.iterator(), r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r12;
    L12:
        return Unit.INSTANCE;
    L5:
        if (((Collection) r10).isEmpty() == false) goto L8;
        return Unit.INSTANCE;
    }

    public abstract Object yieldAll(Iterator<? extends T> r10, Continuation<? super Unit> r11);

    public final Object yieldAll(Sequence<? extends T> r10, Continuation<? super Unit> r11) {
        Object r12 = yieldAll(r10.iterator(), r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }
}
