package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.flow.internal.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b<T> extends kotlinx.coroutines.flow.internal.d<T> {
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = null;
    private volatile /* synthetic */ int consumed$volatile;
    public final ReceiveChannel<T> d;
    public final boolean e;

    static {
        f = AtomicIntegerFieldUpdater.newUpdater(b.class, "consumed$volatile");
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final String b() {
        return "channel=" + this.d;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final Flow<T> e() {
        return new b(this.d, this.e);
    }

    public final void g() {
        if (this.e == false) goto L12;
        boolean r1 = true;
        if (f.getAndSet(this, 1) == 0) goto L8;
        r1 = false;
    L8:
        if (r1 == false) goto L11;
        return;
    L11:
        throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final ReceiveChannel<T> f(CoroutineScope r3) {
        g();
        if (this.b != (-3)) goto L6;
        return this.d;
    L6:
        return super.f(r3);
    }

    public /* synthetic */ b(ReceiveChannel r7, boolean r8) {
        this(r7, r8, EmptyCoroutineContext.INSTANCE, -3, BufferOverflow.SUSPEND);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final Object c(k<? super T> r3, Continuation<? super Unit> r4) {
        Object r5 = FlowKt__ChannelsKt.a(new p(r3), this.d, this.e, r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final Object collect(FlowCollector<? super T> r3, Continuation<? super Unit> r4) {
        if (this.b != (-3)) goto L9;
        g();
        Object r5 = FlowKt__ChannelsKt.a(r3, this.d, this.e, r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r5;
    L8:
        return Unit.INSTANCE;
    L9:
        Object r6 = super.collect(r3, r4);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r6;
    L13:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final kotlinx.coroutines.flow.internal.d<T> d(CoroutineContext r8, int r9, BufferOverflow r10) {
        return new b(this.d, this.e, r8, r9, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(ReceiveChannel<? extends T> r1, boolean r2, CoroutineContext r3, int r4, BufferOverflow r5) {
        super(r3, r4, r5);
        this.d = r1;
        this.e = r2;
        this.consumed$volatile = 0;
    }
}
