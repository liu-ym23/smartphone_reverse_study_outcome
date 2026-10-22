package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends r1 implements r {
    public s(Job r5) {
        super(true);
        K(r5);
    }

    @Override // kotlinx.coroutines.m0
    public final Object d(Continuation r5) {
        Object r10 = v(r5);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r10;
    }
}
