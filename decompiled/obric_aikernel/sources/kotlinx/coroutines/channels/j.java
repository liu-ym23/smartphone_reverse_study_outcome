package kotlinx.coroutines.channels;

import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.c3;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nConflatedBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConflatedBufferedChannel.kt\nkotlinx/coroutines/channels/ConflatedBufferedChannel\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 5 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n*L\n1#1,119:1\n548#2,5:120\n514#2,6:125\n514#2,6:212\n548#2,5:218\n244#3:131\n269#3,10:132\n280#3,68:143\n3038#4:142\n269#5:211\n*S KotlinDebug\n*F\n+ 1 ConflatedBufferedChannel.kt\nkotlinx/coroutines/channels/ConflatedBufferedChannel\n*L\n41#1:120,5\n53#1:125,6\n106#1:212,6\n109#1:218,5\n80#1:131\n80#1:132,10\n80#1:143,68\n80#1:142\n80#1:211\n*E\n"})
public class j<E> extends BufferedChannel<E> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f10324r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final BufferOverflow f10325s;

    public j(int r10, BufferOverflow r11, Function1<? super E, Unit> r12) {
        super(r10, r12);
        this.f10324r = r10;
        this.f10325s = r11;
        boolean r13 = false;
        if (r11 == BufferOverflow.SUSPEND) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L14;
        if (r10 < 1) goto L9;
        r13 = true;
    L9:
        if (r13 == false) goto L12;
        return;
    L12:
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + r10 + " was specified").toString());
    L14:
        throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(BufferedChannel.class).getSimpleName() + " instead").toString());
    L5:
        r14 = false;
        goto L6
    }

    public /* synthetic */ j(int r10, BufferOverflow r11, Function1 r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        this(r10, r11, r12);
    }

    static /* synthetic */ <E> Object h1(j<E> r10, E r11, Continuation<? super Unit> r12) {
        Object r13 = r10.l1(r11, true);
        if ((r13 instanceof g.a) == false) goto L13;
        g.e(r13);
        Function1<E, Unit> r14 = r10.f10285g;
        if (r14 == null) goto L11;
        UndeliveredElementException r15 = OnUndeliveredElementKt.d(r14, r11, null, 2, null);
        if (r15 == null) goto L11;
        ExceptionsKt.addSuppressed(r15, r10.Z());
        throw r15;
    L11:
        throw r10.Z();
    L13:
        return Unit.INSTANCE;
    }

    static /* synthetic */ <E> Object i1(j<E> r10, E r11, Continuation<? super Boolean> r12) {
        Object r13 = r10.l1(r11, true);
        if ((r13 instanceof g.c) == true) goto L7;
        Unit r14 = (Unit) r13;
        return Boxing.boxBoolean(true);
    L7:
        return Boxing.boxBoolean(false);
    }

    private final Object j1(E r10, boolean r11) {
        Object r12 = super.E(r10);
        if (g.i(r12) == false) goto L5;
    L16:
        return r12;
    L5:
        if (g.h(r12) == true) goto L16;
        if (r11 == false) goto L15;
        Function1<E, Unit> r13 = this.f10285g;
        if (r13 == null) goto L15;
        UndeliveredElementException r14 = OnUndeliveredElementKt.d(r13, r10, null, 2, null);
        if (r14 == null) goto L15;
        throw r14;
    L15:
        return g.f10318b.c(Unit.INSTANCE);
    }

    private final Object k1(E r17) {
        Object r10 = BufferedChannelKt.f10295d;
        h r11 = (h) BufferedChannel.k().get(this);
    L3:
        long r12 = BufferedChannel.l().getAndIncrement(this);
        long r13 = r12 & 1152921504606846975L;
        boolean r14 = BufferedChannel.m(this, r12);
        int r15 = BufferedChannelKt.f10293b;
        long r16 = r13 / ((long) r15);
        int r18 = (int) (r13 % ((long) r15));
        if (r11.f10550h == r16) goto L11;
        h r19 = BufferedChannel.f(this, r16, r11);
        if (r19 == null) goto L7;
        h r110 = r19;
    L12:
        int r20 = BufferedChannel.F(this, r110, r18, r17, r13, r10, r14);
        if (r20 == 0) goto L47;
        if (r20 == 1) goto L46;
        if (r20 == 2) goto L34;
        if (r20 == 3) goto L33;
        if (r20 == 4) goto L28;
        if (r20 != 5) goto L26;
        r110.b();
    L26:
        r11 = r110;
        goto L3
    L28:
        if (r13 >= Y()) goto L31;
        r110.b();
    L31:
        return g.f10318b.a(Z());
    L33:
        throw new IllegalStateException("unexpected".toString());
    L34:
        if (r14 == false) goto L38;
        r110.p();
        return g.f10318b.a(Z());
    L38:
        if ((r10 instanceof c3) == false) goto L40;
        c3 r21 = (c3) r10;
    L41:
        if (r21 == null) goto L43;
        BufferedChannel.s(this, r21, r110, r18);
    L43:
        Q((r110.f10550h * ((long) r15)) + ((long) r18));
        return g.f10318b.c(Unit.INSTANCE);
    L40:
        r21 = null;
        goto L41
    L46:
        return g.f10318b.c(Unit.INSTANCE);
    L47:
        r110.b();
        return g.f10318b.c(Unit.INSTANCE);
    L7:
        if (r14 == false) goto L3;
        return g.f10318b.a(Z());
    L11:
        r110 = r11;
        goto L12
    }

    private final Object l1(E r10, boolean r11) {
        if (this.f10325s != BufferOverflow.DROP_LATEST) goto L6;
        return j1(r10, r11);
    L6:
        return k1(r10);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.n
    public Object E(E r10) {
        return l1(r10, false);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.n
    public Object H(E r10, Continuation<? super Unit> r11) {
        return h1(this, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected void L0(kotlinx.coroutines.selects.k<?> r10, Object r11) {
        Object r12 = E(r11);
        if ((r12 instanceof g.c) == true) goto L8;
        Unit r13 = (Unit) r12;
        Object r14 = Unit.INSTANCE;
    L5:
        r10.f(r14);
        return;
    L8:
        if ((r12 instanceof g.a) == false) goto L11;
        g.e(r12);
        r14 = BufferedChannelKt.z();
        goto L5
    L11:
        throw new IllegalStateException("unreachable".toString());
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public Object R0(E r10, Continuation<? super Boolean> r11) {
        return i1(this, r10, r11);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean V0() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected boolean k0() {
        if (this.f10325s != BufferOverflow.DROP_OLDEST) goto L5;
        return true;
    L5:
        return false;
    }
}
