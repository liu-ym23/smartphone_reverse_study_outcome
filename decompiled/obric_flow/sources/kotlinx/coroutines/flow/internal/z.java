package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements kotlinx.coroutines.flow.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f18888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f18889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2 f18890c;

    public z(kotlinx.coroutines.flow.h r5, CoroutineContext r10) {
        this.f18888a = r10;
        this.f18889b = kotlinx.coroutines.internal.v.b(r10);
        this.f18890c = new UndispatchedContextCollector$emitRef$1(r5, null);
    }

    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r5, Continuation r10) {
        Function2 r11 = this.f18890c;
        Object r12 = b.b(this.f18888a, r5, this.f18889b, r11, r10);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }
}
