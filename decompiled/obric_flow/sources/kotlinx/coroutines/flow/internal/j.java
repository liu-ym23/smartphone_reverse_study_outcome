package kotlinx.coroutines.flow.internal;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends d {
    public final Iterable d;

    public j(Iterable r5, CoroutineContext r10, int r11, BufferOverflow r12) {
        super(r10, r11, r12);
        this.d = r5;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final Object c(kotlinx.coroutines.channels.u r10, Continuation r11) {
        w r12 = new w(r10);
        Iterator r13 = this.d.iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        BuildersKt.launch$default(r10, null, null, new ChannelLimitedFlowMerge$collectTo$2$1((kotlinx.coroutines.flow.g) r13.next(), r12, null), 3, null);
        goto L4
    L7:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final d e(CoroutineContext r5, int r10, BufferOverflow r11) {
        return new j(this.d, r5, r10, r11);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final kotlinx.coroutines.channels.t f(CoroutineScope r10) {
        ChannelFlow$collectToFun$1 r5 = new ChannelFlow$collectToFun$1(this, null);
        BufferOverflow r11 = BufferOverflow.SUSPEND;
        CoroutineStart r12 = CoroutineStart.DEFAULT;
        kotlinx.coroutines.channels.f r13 = kotlinx.coroutines.channels.p.a(this.f18866b, 4, r11);
        kotlinx.coroutines.channels.t r14 = new kotlinx.coroutines.channels.t(kotlinx.coroutines.x.b(r10, this.f18865a), r13);
        r12.invoke(r5, r14, r14);
        return r14;
    }
}
