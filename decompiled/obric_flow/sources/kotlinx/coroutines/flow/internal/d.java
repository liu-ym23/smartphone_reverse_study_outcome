package kotlinx.coroutines.flow.internal;

import ai.j0;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f18865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BufferOverflow f18867c;

    public d(CoroutineContext r5, int r10, BufferOverflow r11) {
        this.f18865a = r5;
        this.f18866b = r10;
        this.f18867c = r11;
    }

    @Override // kotlinx.coroutines.flow.internal.r
    public final kotlinx.coroutines.flow.g b(CoroutineContext r5, int r10, BufferOverflow r11) {
        CoroutineContext r12 = this.f18865a;
        CoroutineContext r13 = r5.plus(r12);
        BufferOverflow r14 = BufferOverflow.SUSPEND;
        BufferOverflow r15 = this.f18867c;
        int r16 = this.f18866b;
        if (r11 != r14) goto L21;
        if (r16 == (-3)) goto L19;
        if (r10 != (-3)) goto L11;
    L9:
        r10 = r16;
        goto L19
    L11:
        if (r16 == (-2)) goto L19;
        if (r10 == (-2)) goto L9;
        r10 = r10 + r16;
        if (r10 >= 0) goto L19;
        r10 = Integer.MAX_VALUE;
    L19:
        r11 = r15;
    L21:
        if (Intrinsics.areEqual(r13, r12) == false) goto L26;
        if (r10 != r16) goto L26;
        if (r11 != r15) goto L26;
        return this;
    L26:
        return e(r13, r10, r11);
    }

    public abstract Object c(kotlinx.coroutines.channels.u r5, Continuation r10);

    @Override // kotlinx.coroutines.flow.g
    public Object collect(kotlinx.coroutines.flow.h r5, Continuation r10) {
        Object r11 = h0.d(new ChannelFlow$collect$2(r5, this, null), r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    public abstract d e(CoroutineContext r5, int r10, BufferOverflow r11);

    public kotlinx.coroutines.channels.t f(CoroutineScope r10) {
        int r5 = this.f18866b;
        if (r5 != (-3)) goto L5;
        r5 = -2;
    L5:
        CoroutineStart r11 = CoroutineStart.ATOMIC;
        ChannelFlow$collectToFun$1 r12 = new ChannelFlow$collectToFun$1(this, null);
        kotlinx.coroutines.channels.f r13 = kotlinx.coroutines.channels.p.a(r5, 4, this.f18867c);
        kotlinx.coroutines.channels.t r14 = new kotlinx.coroutines.channels.t(kotlinx.coroutines.x.b(r10, this.f18865a), r13);
        r11.invoke(r12, r14, r14);
        return r14;
    }

    public String toString() {
        ArrayList r5 = new ArrayList(4);
        EmptyCoroutineContext r10 = EmptyCoroutineContext.INSTANCE;
        CoroutineContext r11 = this.f18865a;
        if (r11 == r10) goto L5;
        r5.add("context=" + r11);
    L5:
        int r12 = this.f18866b;
        if (r12 == (-3)) goto L8;
        r5.add("capacity=" + r12);
    L8:
        BufferOverflow r13 = BufferOverflow.SUSPEND;
        BufferOverflow r14 = this.f18867c;
        if (r14 == r13) goto L11;
        r5.add("onBufferOverflow=" + r14);
    L11:
        StringBuilder r15 = new StringBuilder();
        r15.append(getClass().getSimpleName());
        r15.append('[');
        return j0.p(r15, CollectionsKt.q(r5, ", ", null, null, 0, null, null, 62), ']');
    }
}
