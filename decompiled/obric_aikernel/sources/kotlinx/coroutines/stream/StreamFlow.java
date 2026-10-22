package kotlinx.coroutines.stream;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.d;

/* JADX INFO: loaded from: classes3.dex */
final class StreamFlow<T> implements c<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f10693g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Stream<T> f10694c;

    @Volatile
    private volatile int consumed;

    static {
        f10693g = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed");
    }

    @Override // kotlinx.coroutines.flow.c
    public Object a(d<? super T> r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof StreamFlow$collect$1) == false) goto L7;
        StreamFlow$collect$1 r12 = (StreamFlow$collect$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        Iterator<T> r17 = (Iterator) r12.L$2;
        d r18 = (d) r12.L$1;
        StreamFlow<T> r19 = (StreamFlow) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
        d r20 = r18;
        StreamFlow<T> r21 = r19;
    L39:
    L29:
        Throwable th = th;
    L33:
        r21.f10694c.close();
        throw th;
    L23:
        if (r17.hasNext() == false) goto L27;
        T r22 = r17.next();     // Catch: Throwable -> L29
        r12.L$0 = r21;     // Catch: Throwable -> L29
        r12.L$1 = r20;     // Catch: Throwable -> L29
        r12.L$2 = r17;     // Catch: Throwable -> L29
        r12.label = 1;     // Catch: Throwable -> L29
        if (r20.emit(r22, r12) != r15) goto L39;
        return r15;
    L27:
        r21.f10694c.close();
        return Unit.INSTANCE;
    L14:
        th = th;
        r21 = r19;
        goto L33
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        if (f10693g.compareAndSet(this, 0, 1) == false) goto L36;
        r21 = this;
        r17 = this.f10694c.iterator();     // Catch: Throwable -> L31
        r20 = r10;
    L31:
        th = move-exception;
        r21 = this;
        th = th;
        goto L33
    L36:
        throw new IllegalStateException("Stream.consumeAsFlow can be collected only once".toString());
    L7:
        r12 = new StreamFlow$collect$1(this, r11);
        goto L8
    }
}
