package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nChannelFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlow\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,245:1\n1#2:246\n*E\n"})
public abstract class ChannelFlow<T> implements k<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final CoroutineContext f10464c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public final int f10465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public final BufferOverflow f10466h;

    public ChannelFlow(CoroutineContext r10, int r11, BufferOverflow r12) {
        this.f10464c = r10;
        this.f10465g = r11;
        this.f10466h = r12;
        if (n0.a() == true) goto L5;
        return;
    L5:
        if (r11 == (-1)) goto L7;
        boolean r13 = true;
    L8:
        if (r13 == false) goto L11;
        return;
    L11:
        throw new AssertionError();
    L7:
        r13 = false;
        goto L8
    }

    static /* synthetic */ <T> Object g(ChannelFlow<T> r10, kotlinx.coroutines.flow.d<? super T> r11, Continuation<? super Unit> r12) {
        Object r13 = m0.d(new ChannelFlow$collect$2(r11, r10, null), r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.c
    public Object a(kotlinx.coroutines.flow.d<? super T> r10, Continuation<? super Unit> r11) {
        return g(this, r10, r11);
    }

    @Override // kotlinx.coroutines.flow.internal.k
    public kotlinx.coroutines.flow.c<T> e(CoroutineContext r10, int r11, BufferOverflow r12) {
        boolean r13 = true;
        if (n0.a() == true) goto L5;
    L12:
        CoroutineContext r14 = r10.plus(this.f10464c);
        if (r12 != BufferOverflow.SUSPEND) goto L50;
        int r15 = this.f10465g;
        if (r15 == (-3)) goto L48;
        if (r11 != (-3)) goto L21;
    L19:
        r11 = r15;
        goto L48
    L21:
        if (r15 == (-2)) goto L48;
        if (r11 == (-2)) goto L19;
        if (n0.a() == false) goto L36;
        if (this.f10465g < 0) goto L30;
        boolean r16 = true;
    L31:
        if (r16 == true) goto L36;
        throw new AssertionError();
    L30:
        r16 = false;
    L36:
        if (n0.a() == false) goto L44;
        if (r11 >= 0) goto L40;
        r13 = false;
    L40:
        if (r13 == true) goto L44;
        throw new AssertionError();
    L44:
        r15 = this.f10465g + r11;
        if (r15 >= 0) goto L19;
        r11 = Integer.MAX_VALUE;
    L48:
        r12 = this.f10466h;
    L50:
        if (Intrinsics.areEqual(r14, this.f10464c) == false) goto L57;
        if (r11 != this.f10465g) goto L57;
        if (r12 != this.f10466h) goto L57;
        return this;
    L57:
        return i(r14, r11, r12);
    L5:
        if (r11 == (-1)) goto L7;
        boolean r17 = true;
    L8:
        if (r17 == true) goto L12;
        throw new AssertionError();
    L7:
        r17 = false;
        goto L8
    }

    protected String f() {
        return null;
    }

    protected abstract Object h(kotlinx.coroutines.channels.l<? super T> r10, Continuation<? super Unit> r11);

    protected abstract ChannelFlow<T> i(CoroutineContext r10, int r11, BufferOverflow r12);

    public final Function2<kotlinx.coroutines.channels.l<? super T>, Continuation<? super Unit>, Object> j() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    public final int k() {
        int r10 = this.f10465g;
        if (r10 != (-3)) goto L6;
        return -2;
    L6:
        return r10;
    }

    public ReceiveChannel<T> l(l0 r10) {
        return ProduceKt.e(r10, this.f10464c, k(), this.f10466h, CoroutineStart.ATOMIC, null, j(), 16, null);
    }

    public String toString() {
        ArrayList r10 = new ArrayList(4);
        String r11 = f();
        if (r11 == null) goto L6;
        r10.add(r11);
    L6:
        if (this.f10464c == EmptyCoroutineContext.INSTANCE) goto L9;
        r10.add("context=" + this.f10464c);
    L9:
        if (this.f10465g == (-3)) goto L12;
        r10.add("capacity=" + this.f10465g);
    L12:
        if (this.f10466h == BufferOverflow.SUSPEND) goto L15;
        r10.add("onBufferOverflow=" + this.f10466h);
    L15:
        return o0.a(this) + '[' + CollectionsKt.joinToString$default(r10, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
