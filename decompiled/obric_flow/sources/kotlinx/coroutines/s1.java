package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class s1 extends n0 {
    public final Continuation d;

    public s1(CoroutineContext r5, Function2 r10) {
        super(r5, false);
        this.d = IntrinsicsKt.createCoroutineUnintercepted(r10, this, this);
    }

    @Override // kotlinx.coroutines.r1
    public final void T() {
        xt.a.a(this.d, this);
    }
}
