package kotlinx.coroutines;

import cuc.a;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h1<T> extends e0<T> {
    public final Continuation<Unit> d;

    public final void c0() {
        a.a(this.d, this);
    }

    public h1(CoroutineContext r2, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r3) {
        super(r2, false);
        this.d = IntrinsicsKt.createCoroutineUnintercepted(r3, this, this);
    }
}
