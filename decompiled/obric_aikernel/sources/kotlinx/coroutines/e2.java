package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
final class e2<T> extends s0<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Continuation<Unit> f10384i;

    public e2(CoroutineContext r10, Function2<? super l0, ? super Continuation<? super T>, ? extends Object> r11) {
        super(r10, false);
        this.f10384i = IntrinsicsKt.createCoroutineUnintercepted(r11, this, this);
    }

    @Override // kotlinx.coroutines.c2
    protected void P0() {
        fc.a.b(this.f10384i, this);
    }
}
