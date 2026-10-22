package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: loaded from: classes3.dex */
class b<T> extends ChannelFlow<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Function2<kotlinx.coroutines.channels.l<? super T>, Continuation<? super Unit>, Object> f10460i;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function2<? super kotlinx.coroutines.channels.l<? super T>, ? super Continuation<? super Unit>, ? extends Object> r10, CoroutineContext r11, int r12, BufferOverflow r13) {
        super(r11, r12, r13);
        this.f10460i = r10;
    }

    static /* synthetic */ <T> Object m(b<T> r10, kotlinx.coroutines.channels.l<? super T> r11, Continuation<? super Unit> r12) {
        Object r13 = ((b) r10).f10460i.invoke(r11, r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected Object h(kotlinx.coroutines.channels.l<? super T> r10, Continuation<? super Unit> r11) {
        return m(this, r10, r11);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return "block[" + this.f10460i + "] -> " + super.toString();
    }
}
