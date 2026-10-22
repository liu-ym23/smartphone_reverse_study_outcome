package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class d<T> implements l<T> {
    public final CoroutineContext a;
    public final int b;
    public final BufferOverflow c;

    public String b() {
        return null;
    }

    public abstract Object c(k<? super T> r1, Continuation<? super Unit> r2);

    public abstract d<T> d(CoroutineContext r1, int r2, BufferOverflow r3);

    public Flow<T> e() {
        return null;
    }

    public String toString() {
        ArrayList r0 = new ArrayList(4);
        String r1 = b();
        if (r1 == null) goto L6;
        r0.add(r1);
    L6:
        if (this.a == EmptyCoroutineContext.INSTANCE) goto L9;
        r0.add("context=" + this.a);
    L9:
        if (this.b == (-3)) goto L12;
        r0.add("capacity=" + this.b);
    L12:
        if (this.c == BufferOverflow.SUSPEND) goto L15;
        r0.add("onBufferOverflow=" + this.c);
    L15:
        return getClass().getSimpleName() + '[' + CollectionsKt.joinToString$default(r0, ", ", null, null, 0, null, null, 62, null) + ']';
    }

    public ReceiveChannel<T> f(CoroutineScope r8) {
        CoroutineContext r1 = this.a;
        int r0 = this.b;
        if (r0 != (-3)) goto L5;
        int r2 = -2;
    L7:
        return ProduceKt.b(r8, r1, r2, this.c, CoroutineStart.ATOMIC, null, new ChannelFlow$collectToFun$1(this, null));
    L5:
        r2 = r0;
        goto L7
    }

    public Object collect(FlowCollector<? super T> r3, Continuation<? super Unit> r4) {
        Object r5 = CoroutineScopeKt.coroutineScope(new ChannelFlow$collect$2(r3, this, null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public d(CoroutineContext r1, int r2, BufferOverflow r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Flow<T> a(CoroutineContext r2, int r3, BufferOverflow r4) {
        CoroutineContext r5 = r2.plus(this.a);
        if (r4 != BufferOverflow.SUSPEND) goto L21;
        int r6 = this.b;
        if (r6 == (-3)) goto L19;
        if (r3 != (-3)) goto L11;
    L17:
        r3 = r6;
        goto L19
    L11:
        if (r6 == (-2)) goto L19;
        if (r3 == (-2)) goto L17;
        r6 = r6 + r3;
        if (r6 >= 0) goto L17;
        r3 = Integer.MAX_VALUE;
    L19:
        r4 = this.c;
    L21:
        if (Intrinsics.areEqual(r5, this.a) == false) goto L28;
        if (r3 != this.b) goto L28;
        if (r4 != this.c) goto L28;
        return this;
    L28:
        return d(r5, r3, r4);
    }
}
