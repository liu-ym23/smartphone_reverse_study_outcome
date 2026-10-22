package kotlinx.coroutines.channels;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.d;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class BufferedChannel<E> implements Channel<E> {
    public static final /* synthetic */ AtomicLongFieldUpdater d = null;
    public static final /* synthetic */ AtomicLongFieldUpdater e = null;
    public static final /* synthetic */ AtomicLongFieldUpdater f = null;
    public static final /* synthetic */ AtomicLongFieldUpdater g = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater i = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater j = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater k = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater l = null;
    private volatile /* synthetic */ Object _closeCause$volatile;
    public final int a;
    public final Function1<E, Unit> b;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    public final Function3<kotlinx.coroutines.selects.l<?>, Object, Object, Function1<Throwable, Unit>> c;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    public final class a implements ChannelIterator<E>, d2 {
        public Object a;
        public kotlinx.coroutines.j<? super Boolean> b;
        public final /* synthetic */ BufferedChannel<E> c;

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public final E next() {
            E r0 = (E) this.a;
            b0 r1 = e.p;
            if (r0 == r1) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L13;
            this.a = r1;
            if (r0 == e.l) goto L10;
            return r0;
        L10:
            BufferedChannel<E> r3 = this.c;
            AtomicLongFieldUpdater r4 = BufferedChannel.d;
            Throwable r5 = r3.n();
            int r6 = a0.a;
            throw r5;
        L13:
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        L5:
            r2 = false;
            goto L6
        }

        public a(BufferedChannel r1) {
            this.c = r1;
            this.a = e.p;
        }

        public static final void a(a r2) {
            kotlinx.coroutines.j<? super Boolean> r0 = r2.b;
            Intrinsics.checkNotNull(r0);
            r2.b = null;
            r2.a = e.l;
            Throwable r3 = r2.c.m();
            if (r3 != null) goto L5;
            Result.Companion r4 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(Boolean.FALSE));
            return;
        L5:
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(r3)));
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public final Object hasNext(Continuation<? super Boolean> r17) {
            BufferedChannel<E> r0 = this.c;
            kotlinx.coroutines.internal.e r1 = (h) BufferedChannel.i.get(r0);
        L4:
            if (r0.isClosedForReceive() == true) goto L5;
            long r9 = BufferedChannel.e.getAndIncrement(r0);
            int r2 = e.b;
            long r3 = r9 / ((long) r2);
            int r11 = (int) (r9 % ((long) r2));
            if (((y) r1).c == r3) goto L16;
            kotlinx.coroutines.internal.e r4 = r0.k(r3, r1);
            if (r4 == null) goto L4;
            kotlinx.coroutines.internal.e r12 = r4;
        L17:
            Object r5 = r0.K(r12, r11, r9, null);
            b0 r13 = e.m;
            if (r5 == r13) goto L78;
            b0 r14 = e.o;
            if (r5 != r14) goto L26;
            if (r9 >= r0.q()) goto L24;
            r12.b();
        L24:
            r1 = r12;
            goto L4
        L26:
            if (r5 != e.n) goto L75;
            BufferedChannel<E> r6 = this.c;
            kotlinx.coroutines.j<? super Boolean> r15 = kotlinx.coroutines.l.a(IntrinsicsKt.intercepted(r17));
            this.b = r15;     // Catch: Throwable -> L72
            Object r7 = r6.K(r12, r11, r9, this);     // Catch: Throwable -> L72
            if (r7 != r13) goto L31;
            r6.B();     // Catch: Throwable -> L72
            e(r12, r11);     // Catch: Throwable -> L72
        L68:
            Object r8 = r15.B();
            if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L71;
            DebugProbesKt.probeCoroutineSuspended(r17);
        L71:
            return r8;
        L31:
            Function1 r16 = null;
            if (r7 == r14) goto L34;
            r12.b();     // Catch: Throwable -> L72
            this.a = r7;     // Catch: Throwable -> L72
            this.b = null;     // Catch: Throwable -> L72
            Boolean r10 = Boxing.boxBoolean(true);     // Catch: Throwable -> L72
            Function1<E, Unit> r18 = r6.b;     // Catch: Throwable -> L72
            if (r18 == null) goto L67;
            CoroutineContext r19 = r15.getContext();     // Catch: Throwable -> L72
        L61:
            r16 = OnUndeliveredElementKt.a(r18, r7, r19);     // Catch: Throwable -> L72
        L67:
            r15.h(r10, r16);     // Catch: Throwable -> L72
            goto L68
        L34:
            if (r9 >= r6.q()) goto L36;
            r12.b();     // Catch: Throwable -> L72
        L36:
            h<E> r20 = (h) BufferedChannel.i.get(r6);     // Catch: Throwable -> L72
        L38:
            if (r6.isClosedForReceive() == true) goto L39;
            long r21 = BufferedChannel.e.getAndIncrement(r6);     // Catch: Throwable -> L72
            long r22 = e.b;     // Catch: Throwable -> L72
            long r23 = r21 / r22;     // Catch: Throwable -> L72
            int r110 = (int) (r21 % r22);     // Catch: Throwable -> L72
            if (((y) r20).c == r23) goto L46;
            h<E> r24 = r6.k(r23, r20);     // Catch: Throwable -> L72
            if (r24 == null) goto L38;
            h<E> r111 = r24;
        L47:
            r7 = r6.K(r111, r110, r21, this);     // Catch: Throwable -> L72
            if (r7 == e.m) goto L49;
            if (r7 != e.o) goto L57;
            if (r21 >= r6.q()) goto L55;
            r111.b();     // Catch: Throwable -> L72
        L55:
            r20 = r111;
            goto L38
        L57:
            if (r7 == e.n) goto L63;
            r111.b();     // Catch: Throwable -> L72
            this.a = r7;     // Catch: Throwable -> L72
            this.b = null;     // Catch: Throwable -> L72
            r10 = Boxing.boxBoolean(true);     // Catch: Throwable -> L72
            r18 = r6.b;     // Catch: Throwable -> L72
            if (r18 == null) goto L67;
            r19 = r15.getContext();     // Catch: Throwable -> L72
            goto L61
        L63:
            throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L72
        L49:
            r6.B();     // Catch: Throwable -> L72
            e(r111, r110);     // Catch: Throwable -> L72
            goto L68
        L46:
            r111 = r20;
            goto L47
        L39:
            a(this);     // Catch: Throwable -> L72
        L72:
            th = move-exception;
            r15.H();
            throw th;
        L75:
            r12.b();
            this.a = r5;
            return Boxing.boxBoolean(true);
        L78:
            throw new IllegalStateException("unreachable".toString());
        L16:
            r12 = r1;
            goto L17
        L5:
            this.a = e.l;
            Throwable r25 = this.c.m();
            if (r25 == null) goto L97;
            int r26 = a0.a;
            throw r25;
        L97:
            return Boxing.boxBoolean(false);
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public final /* synthetic */ Object next(Continuation r1) {
            return ChannelIterator.DefaultImpls.a(this, r1);
        }

        public final void e(y<?> r2, int r3) {
            kotlinx.coroutines.j<? super Boolean> r0 = this.b;
            if (r0 == null) goto L6;
            r0.e(r2, r3);
            return;
        }
    }

    static {
        d = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus$volatile");
        e = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers$volatile");
        f = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd$volatile");
        g = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag$volatile");
        h = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment$volatile");
        i = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment$volatile");
        j = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment$volatile");
        k = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause$volatile");
        l = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler$volatile");
    }

    public void A() {
    }

    public void B() {
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel() {
        f(null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public final Object mo528receiveCatchingJP2dKIU(Continuation<? super g<? extends E>> r1) {
        return C(this, r1);
    }

    public boolean u() {
        return false;
    }

    public void x() {
    }

    public boolean H() {
        long r0 = d.get(this);
        if (t(r0, false) == false) goto L6;
        return false;
    L6:
        return !e(r0 & 1152921504606846975L);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final kotlinx.coroutines.selects.g<E> getOnReceive() {
        onReceive.1 r1 = onReceive.1.INSTANCE;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r2 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, 3);
        onReceive.2 r3 = onReceive.2.INSTANCE;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.h(this, r2, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r3, 3), this.c);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final kotlinx.coroutines.selects.g<g<E>> getOnReceiveCatching() {
        onReceiveCatching.1 r1 = onReceiveCatching.1.INSTANCE;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r2 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, 3);
        onReceiveCatching.2 r3 = onReceiveCatching.2.INSTANCE;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.h(this, r2, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r3, 3), this.c);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final kotlinx.coroutines.selects.g<E> getOnReceiveOrNull() {
        onReceiveOrNull.1 r1 = onReceiveOrNull.1.INSTANCE;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r2 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, 3);
        onReceiveOrNull.2 r3 = onReceiveOrNull.2.INSTANCE;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.h(this, r2, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r3, 3), this.c);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final kotlinx.coroutines.selects.i<E, BufferedChannel<E>> getOnSend() {
        onSend.1 r1 = onSend.1.INSTANCE;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r2 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, 3);
        onSend.2 r3 = onSend.2.INSTANCE;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.j(this, r2, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r3, 3));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean isClosedForReceive() {
        return t(d.get(this), true);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return t(d.get(this), false);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator<E> iterator() {
        return new a(this);
    }

    public final void j() {
        if (v() == false) goto L5;
        return;
    L5:
        h<E> r7 = (h) j.get(this);
    L6:
        long r8 = f.getAndIncrement(this);
        long r0 = r8 / ((long) e.b);
        if (q() <= r8) goto L9;
        if (((y) r7).c == r0) goto L58;
        AtomicReferenceFieldUpdater r2 = j;
        BufferedChannelKt.createSegmentFunction.1 r3 = BufferedChannelKt.createSegmentFunction.1.INSTANCE;
    L18:
        Object r4 = d.a(r7, r0, r3);
        if (z.b(r4) == true) goto L46;
        y r5 = z.a(r4);
    L21:
        y r14 = (y) r2.get(this);
        if (r14.c >= r5.c) goto L37;
        if (r5.j() == false) goto L26;
    L28:
        if (r2.compareAndSet(this, r14, r5) == true) goto L29;
        if (r2.get(this) == r14) goto L28;
        boolean r10 = false;
    L33:
        if (r10 == true) goto L35;
        if (r5.f() == false) goto L21;
        r5.e();
        goto L21
    L35:
        if (r14.f() == false) goto L37;
        r14.e();
        goto L37
    L29:
        r10 = true;
        goto L33
    L26:
        boolean r6 = false;
    L38:
        if (r6 == false) goto L18;
    L37:
        r6 = true;
    L46:
        if (z.b(r4) == false) goto L48;
        isClosedForSend();
        w(r0, r7);
        s(1);
    L54:
        h<E> r11 = null;
    L55:
        if (r11 == null) goto L6;
        r7 = r11;
        goto L58
    L48:
        r11 = (h) z.a(r4);
        long r9 = ((y) r11).c;
        if (r9 <= r0) goto L55;
        long r13 = e.b;
        if (f.compareAndSet(this, r8 + 1, r9 * r13) == false) goto L53;
        s((((y) r11).c * r13) - r8);
        goto L54
    L53:
        s(1);
    L58:
        int r1 = (int) (r8 % ((long) e.b));
        Object r12 = r7.l(r1);
        if ((r12 instanceof d2) == false) goto L68;
        if (r8 < e.get(this)) goto L68;
        if (r7.k(r1, r12, e.g) == false) goto L68;
        if (J(r12, r7, r1) == false) goto L67;
        r7.o(r1, e.d);
    L106:
        boolean r15 = true;
    L107:
        if (r15 == true) goto L108;
        s(1);
        goto L6
    L108:
        s(1);
        return;
    L67:
        r7.o(r1, e.j);
        r7.m(r1, false);
    L83:
        r15 = false;
    L68:
        Object r16 = r7.l(r1);
        if ((r16 instanceof d2) == true) goto L71;
        if (r16 == e.j) goto L83;
        if (r16 == null) goto L86;
        if (r16 == e.d) goto L106;
        if (r16 == e.h) goto L106;
        if (r16 == e.i) goto L106;
        if (r16 == e.k) goto L106;
        if (r16 == e.l) goto L106;
        if (r16 == e.f) goto L68;
        throw new IllegalStateException(("Unexpected cell state: " + r16).toString());
    L86:
        if (r7.k(r1, r16, e.e) == false) goto L68;
    L71:
        if (r8 < e.get(this)) goto L73;
        if (r7.k(r1, r16, e.g) == false) goto L68;
        if (J(r16, r7, r1) == false) goto L80;
        r7.o(r1, e.d);
        goto L106
    L80:
        r7.o(r1, e.j);
        r7.m(r1, false);
        goto L83
    L73:
        if (r7.k(r1, r16, new n((d2) r16)) == false) goto L68;
    L9:
        if (((y) r7).c < r0) goto L11;
    L13:
        s(1);
        return;
    L11:
        if (r7.c() == null) goto L13;
        w(r0, r7);
        goto L13
    }

    public final long l() {
        return f.get(this);
    }

    public final Throwable m() {
        return (Throwable) k.get(this);
    }

    public final long o() {
        return e.get(this);
    }

    public final long q() {
        return d.get(this) & 1152921504606846975L;
    }

    public final boolean r() {
    L2:
        AtomicReferenceFieldUpdater r0 = i;
        h<E> r1 = (h) r0.get(this);
        long r4 = o();
        boolean r6 = false;
        if (q() <= r4) goto L4;
        int r2 = e.b;
        long r7 = r4 / ((long) r2);
        if (((y) r1).c == r7) goto L12;
        r1 = k(r7, r1);
        if (r1 != null) goto L12;
        if (((y) ((h) r0.get(this))).c >= r7) goto L2;
        return false;
    L12:
        r1.b();
        int r3 = (int) (r4 % ((long) r2));
    L13:
        Object r5 = r1.l(r3);
        if (r5 == null) goto L43;
        if (r5 == e.e) goto L43;
        if (r5 != e.d) goto L22;
    L41:
        r6 = true;
    L45:
        if (r6 == true) goto L46;
        e.compareAndSet(this, r4, r4 + 1);
        goto L2
    L46:
        return true;
    L22:
        if (r5 == e.j) goto L45;
        if (r5 == e.l) goto L45;
        if (r5 == e.i) goto L45;
        if (r5 == e.h) goto L45;
        if (r5 == e.g) goto L41;
        if (r5 == e.f) goto L45;
        if (r4 != o()) goto L45;
    L43:
        if (r1.k(r3, r5, e.h) == false) goto L13;
        j();
        goto L45
    L4:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String toString() {
        StringBuilder r1 = new StringBuilder();
        int r3 = (int) (d.get(this) >> 60);
        if (r3 == 2) goto L7;
        if (r3 != 3) goto L8;
        r1.append("cancelled,");
    L8:
        r1.append("capacity=" + this.a + ',');
        r1.append("data=[");
        List r2 = CollectionsKt.listOf(new h[]{i.get(this), h.get(this), j.get(this)});
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
    L10:
        if (r5.hasNext() == false) goto L17;
        Object r6 = r5.next();
        if (((h) r6) == e.a) goto L14;
        boolean r8 = true;
    L15:
        if (r8 == false) goto L10;
        r4.add(r6);
        goto L10
    L14:
        r8 = false;
        goto L15
    L17:
        Iterator r7 = r4.iterator();
        if (r7.hasNext() == false) goto L103;
        Object r9 = r7.next();
        if (r7.hasNext() == false) goto L28;
        long r10 = ((y) ((h) r9)).c;
    L23:
        Object r11 = r7.next();
        long r12 = ((y) ((h) r11)).c;
        if (r10 <= r12) goto L27;
        r9 = r11;
        r10 = r12;
    L27:
        if (r7.hasNext() == true) goto L23;
    L28:
        h r13 = (h) r9;
        long r14 = o();
        long r15 = q();
    L29:
        int r16 = e.b;
        int r17 = 0;
    L30:
        if (r17 >= r16) goto L94;
        long r18 = (((y) r13).c * ((long) e.b)) + ((long) r17);
        if (r18 >= r15) goto L34;
    L35:
        Object r19 = r13.l(r17);
        Object r20 = r13.f.get(r17 * 2);
        if ((r19 instanceof kotlinx.coroutines.i) == false) goto L46;
        if (r18 >= r14) goto L41;
        if (r18 < r15) goto L41;
        String r21 = "receive";
    L90:
        if (r20 == null) goto L92;
        r1.append("(" + r21 + ',' + r20 + "),");
    L93:
        r17 = r17 + 1;
        goto L30
    L92:
        r1.append(r21 + ',');
    L41:
        if (r18 >= r15) goto L44;
        if (r18 < r14) goto L44;
        r21 = "send";
    L44:
        r21 = "cont";
        goto L90
    L46:
        if ((r19 instanceof kotlinx.coroutines.selects.l) == false) goto L56;
        if (r18 >= r14) goto L51;
        if (r18 < r15) goto L51;
        r21 = "onReceive";
    L51:
        if (r18 >= r15) goto L54;
        if (r18 < r14) goto L54;
        r21 = "onSend";
    L54:
        r21 = "select";
        goto L90
    L56:
        if ((r19 instanceof l) == false) goto L59;
        r21 = "receiveCatching";
        goto L90
    L59:
        if ((r19 instanceof b) == false) goto L62;
        r21 = "sendBroadcast";
        goto L90
    L62:
        if ((r19 instanceof n) == false) goto L65;
        r21 = "EB(" + r19 + ')';
        goto L90
    L65:
        if (Intrinsics.areEqual(r19, e.f) == false) goto L67;
        boolean r22 = true;
    L68:
        if (r22 == false) goto L70;
        r21 = "resuming_sender";
        goto L90
    L70:
        if (r19 != null) goto L72;
        boolean r23 = true;
    L73:
        if (r23 == false) goto L75;
        boolean r24 = true;
    L76:
        if (r24 == false) goto L78;
        boolean r25 = true;
    L79:
        if (r25 == false) goto L81;
        boolean r26 = true;
    L82:
        if (r26 == false) goto L84;
        boolean r27 = true;
    L85:
        if (r27 == false) goto L87;
        boolean r28 = true;
    L88:
        if (r28 == true) goto L93;
        r21 = r19.toString();
        goto L90
    L87:
        r28 = Intrinsics.areEqual(r19, e.l);
        goto L88
    L84:
        r27 = Intrinsics.areEqual(r19, e.j);
        goto L85
    L81:
        r26 = Intrinsics.areEqual(r19, e.k);
        goto L82
    L78:
        r25 = Intrinsics.areEqual(r19, e.h);
        goto L79
    L75:
        r24 = Intrinsics.areEqual(r19, e.i);
        goto L76
    L72:
        r23 = Intrinsics.areEqual(r19, e.e);
        goto L73
    L67:
        r22 = Intrinsics.areEqual(r19, e.g);
        goto L68
    L34:
        if (r18 < r14) goto L35;
    L97:
        if (StringsKt.last(r1) != ',') goto L99;
        r1.deleteCharAt(r1.length() - 1);
    L99:
        r1.append("]");
        return r1.toString();
    L94:
        r13 = r13.c();
        if (r13 != null) goto L29;
    L103:
        throw new NoSuchElementException();
    L7:
        r1.append("closed,");
        goto L8
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public final Object mo529tryReceivePtdJZtk() {
        long r0 = e.get(this);
        long r2 = d.get(this);
        if (t(r2, true) == false) goto L7;
        g.c r1 = g.b;
        return new g.a(m());
    L7:
        if (r0 < (r2 & 1152921504606846975L)) goto L10;
        g.c r3 = g.b;
        return g.b;
    L10:
        d2 r4 = e.k;
        h<E> r5 = (h) i.get(this);
    L12:
        if (isClosedForReceive() == true) goto L13;
        long r7 = e.getAndIncrement(this);
        int r6 = e.b;
        long r8 = r7 / ((long) r6);
        int r9 = (int) (r7 % ((long) r6));
        if (((y) r5).c == r8) goto L20;
        h<E> r10 = k(r8, r5);
        if (r10 == null) goto L12;
        h<E> r11 = r10;
    L21:
        Object r12 = K(r11, r9, r7, r4);
        if (r12 == e.m) goto L24;
        if (r12 != e.o) goto L37;
        if (r7 >= q()) goto L35;
        r11.b();
    L35:
        r5 = r11;
        goto L12
    L37:
        if (r12 == e.n) goto L41;
        r11.b();
        g.c r13 = g.b;
        return r12;
    L41:
        throw new IllegalStateException("unexpected".toString());
    L24:
        if ((r4 instanceof d2) == false) goto L26;
        d2 r14 = r4;
    L27:
        if (r14 == null) goto L29;
        B();
        r14.e(r11, r9);
    L29:
        M(r7);
        r11.i();
        g.c r15 = g.b;
        return g.b;
    L26:
        r14 = null;
        goto L27
    L20:
        r11 = r5;
        goto L21
    L13:
        g.c r16 = g.b;
        return new g.a(m());
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean isEmpty() {
        if (isClosedForReceive() == false) goto L6;
        return false;
    L6:
        if (r() == false) goto L9;
        return false;
    L9:
        return !isClosedForReceive();
    }

    public final Throwable n() {
        Throwable r0 = m();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ClosedReceiveChannelException("Channel was closed");
    }

    public final Throwable p() {
        Throwable r0 = m();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ClosedSendChannelException("Channel was closed");
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    public final E poll() {
        E r0 = (E) mo529tryReceivePtdJZtk();
        g.c r1 = g.b;
        if ((!(r0 instanceof g.c)) == false) goto L5;
        g.c(r0);
        return r0;
    L5:
        Throwable r2 = g.a(r0);
        if (r2 != null) goto L9;
        return null;
    L9:
        int r3 = a0.a;
        throw r2;
    }

    public final boolean v() {
        long r0 = l();
        if (r0 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r0 == LongCompanionObject.MAX_VALUE) goto L8;
        return false;
    }

    public final void M(long r20) {
        if (v() == false) goto L6;
        return;
    L6:
        if (l() <= r20) goto L6;
        int r0 = e.c;
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L16;
        long r2 = l();
        if (r2 != (g.get(this) & DurationKt.MAX_MILLIS)) goto L15;
        if (r2 != l()) goto L15;
        return;
    L15:
        r1 = r1 + 1;
        goto L9
    L16:
        AtomicLongFieldUpdater r10 = g;
    L17:
        long r3 = r10.get(this);
        if (r10.compareAndSet(this, r3, 4611686018427387904L + (r3 & DurationKt.MAX_MILLIS)) == false) goto L17;
    L19:
        long r4 = l();
        AtomicLongFieldUpdater r11 = g;
        long r5 = r11.get(this);
        long r6 = r5 & DurationKt.MAX_MILLIS;
        if ((r5 & 4611686018427387904L) == 0) goto L22;
        boolean r13 = true;
    L24:
        if (r4 == r6) goto L26;
    L30:
        if (r13 == true) goto L19;
        r11.compareAndSet(this, r5, r6 + 4611686018427387904L);
        goto L19
    L26:
        if (r4 != l()) goto L30;
    L27:
        long r7 = r11.get(this);
        if (r11.compareAndSet(this, r7, 0 + (r7 & DurationKt.MAX_MILLIS)) == false) goto L27;
        return;
    L22:
        r13 = false;
        goto L24
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean cancel(Throwable r1) {
        return f(r1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable r2) {
        return g(r2, false);
    }

    public final boolean e(long r5) {
        if (r5 >= l()) goto L5;
    L8:
        return true;
    L5:
        if (r5 < (o() + ((long) this.a))) goto L8;
        return false;
    }

    public boolean f(Throwable r2) {
        if (r2 != null) goto L5;
        r2 = new CancellationException("Channel was cancelled");
    L5:
        return g(r2, true);
    }

    public final h<E> h(long r14) {
        Object r0 = j.get(this);
        h r1 = (h) h.get(this);
        if (((y) r1).c <= ((y) ((h) r0)).c) goto L5;
        r0 = r1;
    L5:
        h r2 = (h) i.get(this);
        if (((y) r2).c <= ((y) ((h) r0)).c) goto L8;
        r0 = r2;
    L8:
        kotlinx.coroutines.internal.e r3 = (kotlinx.coroutines.internal.e) r0;
        b0 r4 = d.a;
    L9:
        r3.getClass();
        AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.e.a;
        Object r6 = r5.get(r3);
        b0 r7 = d.a;
        Object r8 = null;
        if (r6 == r7) goto L21;
        kotlinx.coroutines.internal.e r9 = (kotlinx.coroutines.internal.e) r6;
        if (r9 == null) goto L15;
        r3 = r9;
    L15:
        if (r5.compareAndSet(r3, null, r7) == true) goto L16;
        if (r5.get(r3) == null) goto L15;
        boolean r10 = false;
    L20:
        if (r10 == false) goto L9;
    L16:
        r10 = true;
    L21:
        h<E> r11 = (h) r3;
        if (u() == false) goto L48;
        h<E> r12 = r11;
    L24:
        int r13 = e.b - 1;
    L26:
        if ((-1) >= r13) goto L42;
        long r15 = (((y) r12).c * ((long) e.b)) + ((long) r13);
        if (r15 < o()) goto L44;
    L30:
        Object r16 = r12.l(r13);
        if (r16 == null) goto L39;
        if (r16 == e.e) goto L39;
        if (r16 != e.d) goto L41;
    L46:
        if (r15 == (-1)) goto L48;
        i(r15);
    L41:
        r13 = r13 - 1;
    L39:
        if (r12.k(r13, r16, e.l) == false) goto L30;
        r12.i();
    L44:
        r15 = -1;
        goto L46
    L42:
        r12 = (h) ((kotlinx.coroutines.internal.e) kotlinx.coroutines.internal.e.b.get(r12));
        if (r12 != null) goto L24;
    L48:
        h<E> r17 = r11;
    L49:
        if (r17 == null) goto L74;
        int r18 = e.b - 1;
    L51:
        if ((-1) >= r18) goto L73;
        if (((((y) r17).c * ((long) e.b)) + ((long) r18)) < r14) goto L74;
    L54:
        Object r19 = r17.l(r18);
        if (r19 == null) goto L70;
        if (r19 == e.e) goto L70;
        if ((r19 instanceof n) == true) goto L62;
        if ((r19 instanceof d2) == false) goto L72;
        if (r17.k(r18, r19, e.l) == false) goto L54;
        r8 = kotlinx.coroutines.internal.k.a(r8, r19);
        r17.m(r18, true);
    L72:
        r18 = r18 - 1;
        goto L51
    L62:
        if (r17.k(r18, r19, e.l) == false) goto L54;
        r8 = kotlinx.coroutines.internal.k.a(r8, ((n) r19).a);
        r17.m(r18, true);
    L70:
        if (r17.k(r18, r19, e.l) == false) goto L54;
        r17.i();
        goto L72
    L73:
        r17 = (h) ((kotlinx.coroutines.internal.e) kotlinx.coroutines.internal.e.b.get(r17));
    L74:
        if (r8 != null) goto L76;
    L81:
        return r11;
    L76:
        if ((r8 instanceof ArrayList) == true) goto L78;
        F((d2) r8, true);
        goto L81
    L78:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList r20 = (ArrayList) r8;
        int r110 = r20.size() - 1;
    L79:
        if ((-1) >= r110) goto L81;
        F((d2) ListProtector.get(r20, r110), true);
        r110 = r110 - 1;
        goto L79
    }

    public final void i(long r11) {
        kotlinx.coroutines.internal.e r0 = (h) i.get(this);
    L3:
        AtomicLongFieldUpdater r1 = e;
        long r8 = r1.get(this);
        if (r11 < Math.max(((long) this.a) + r8, l())) goto L5;
        if (r1.compareAndSet(this, r8, r8 + 1) == false) goto L3;
        long r2 = e.b;
        long r3 = r8 / r2;
        int r5 = (int) (r8 % r2);
        if (((y) r0).c == r3) goto L14;
        kotlinx.coroutines.internal.e r4 = k(r3, r0);
        if (r4 == null) goto L3;
        r0 = r4;
    L14:
        Object r6 = K(r0, r5, r8, null);
        if (r6 == e.o) goto L17;
        r0.b();
        Function1<E, Unit> r7 = this.b;
        if (r7 == null) goto L3;
        UndeliveredElementException r9 = OnUndeliveredElementKt.c(r7, r6, null);
        if (r9 == null) goto L3;
        throw r9;
    L17:
        if (r8 >= q()) goto L3;
        r0.b();
        goto L3
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void invokeOnClose(Function1<? super Throwable, Unit> r8) {
        AtomicReferenceFieldUpdater r0 = l;
    L4:
        if (r0.compareAndSet(this, null, r8) == true) goto L5;
        if (r0.get(this) == null) goto L4;
        boolean r1 = false;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        AtomicReferenceFieldUpdater r2 = l;
    L12:
        Object r3 = r2.get(this);
        b0 r4 = e.q;
        if (r3 != r4) goto L25;
        AtomicReferenceFieldUpdater r5 = l;
        b0 r6 = e.r;
    L16:
        if (r5.compareAndSet(this, r4, r6) == true) goto L17;
        if (r5.get(this) == r4) goto L16;
        boolean r7 = false;
    L21:
        if (r7 == false) goto L12;
        r8.invoke(m());
        return;
    L17:
        r7 = true;
        goto L21
    L25:
        if (r3 != e.r) goto L29;
        throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
    L29:
        throw new IllegalStateException(("Another handler is already registered: " + r3).toString());
    L5:
        r1 = true;
        goto L9
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public final boolean offer(E r1) {
        return SendChannel.a.b(this, r1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receive(Continuation<? super E> r18) {
        kotlinx.coroutines.internal.e r1 = (h) i.get(this);
    L4:
        if (isClosedForReceive() == true) goto L72;
        long r8 = e.getAndIncrement(this);
        long r2 = e.b;
        long r4 = r8 / r2;
        int r10 = (int) (r8 % r2);
        if (((y) r1).c == r4) goto L11;
        kotlinx.coroutines.internal.e r3 = k(r4, r1);
        if (r3 == null) goto L4;
        kotlinx.coroutines.internal.e r11 = r3;
    L12:
        Object r5 = K(r11, r10, r8, null);
        b0 r12 = e.m;
        if (r5 == r12) goto L71;
        b0 r14 = e.o;
        if (r5 != r14) goto L21;
        if (r8 >= q()) goto L19;
        r11.b();
    L19:
        r1 = r11;
        goto L4
    L21:
        if (r5 != e.n) goto L68;
        kotlinx.coroutines.j r15 = kotlinx.coroutines.l.a(IntrinsicsKt.intercepted(r18));
        Object r0 = K(r11, r10, r8, r15);     // Catch: Throwable -> L65
        if (r0 != r12) goto L26;
        B();     // Catch: Throwable -> L65
        r15.e(r11, r10);     // Catch: Throwable -> L65
    L62:
        r5 = r15.B();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L69;
        DebugProbesKt.probeCoroutineSuspended(r18);
    L69:
        return r5;
    L26:
        Function1 r13 = null;
        if (r0 == r14) goto L29;
        r11.b();     // Catch: Throwable -> L65
        Function1<E, Unit> r6 = this.b;     // Catch: Throwable -> L65
        if (r6 == null) goto L61;
        CoroutineContext r7 = r15.getContext();     // Catch: Throwable -> L65
        Object r9 = r0;
        Function1<E, Unit> r16 = r6;
    L59:
        r13 = OnUndeliveredElementKt.a(r16, r9, r7);     // Catch: Throwable -> L65
    L60:
        r0 = r9;
    L61:
        r15.h(r0, r13);     // Catch: Throwable -> L65
        goto L62
    L29:
        if (r8 >= q()) goto L31;
        r11.b();     // Catch: Throwable -> L65
    L31:
        h<E> r17 = (h) i.get(this);     // Catch: Throwable -> L65
    L33:
        if (isClosedForReceive() == true) goto L34;
        long r19 = e.getAndIncrement(this);     // Catch: Throwable -> L65
        long r20 = e.b;     // Catch: Throwable -> L65
        long r21 = r19 / r20;     // Catch: Throwable -> L65
        int r110 = (int) (r19 % r20);     // Catch: Throwable -> L65
        if (((y) r17).c == r21) goto L41;
        h<E> r22 = k(r21, r17);     // Catch: Throwable -> L65
        if (r22 == null) goto L33;
        r17 = r22;
    L41:
        r9 = K(r17, r110, r19, r15);     // Catch: Throwable -> L65
        if (r9 == e.m) goto L43;
        if (r9 != e.o) goto L50;
        if (r19 >= q()) goto L33;
        r17.b();     // Catch: Throwable -> L65
        goto L33
    L50:
        if (r9 == e.n) goto L55;
        r17.b();     // Catch: Throwable -> L65
        r16 = this.b;     // Catch: Throwable -> L65
        if (r16 == null) goto L60;
        r7 = r15.getContext();     // Catch: Throwable -> L65
        goto L59
    L55:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L65
    L43:
        B();     // Catch: Throwable -> L65
        r15.e(r17, r110);     // Catch: Throwable -> L65
        goto L62
    L34:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L65
        r15.resumeWith(Result.constructor-impl(ResultKt.createFailure(n())));     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        r15.H();
        throw th;
    L68:
        r11.b();
        goto L69
    L71:
        throw new IllegalStateException("unexpected".toString());
    L11:
        r11 = r1;
        goto L12
    L72:
        Throwable r24 = n();
        int r25 = a0.a;
        throw r24;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public final Object receiveOrNull(Continuation<? super E> r1) {
        return ReceiveChannel.DefaultImpls.a(this, r1);
    }

    public final void s(long r8) {
        if ((g.addAndGet(this, r8) & 4611686018427387904L) == 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == true) goto L8;
        return;
    L8:
        if ((g.get(this) & 4611686018427387904L) == 0) goto L10;
        boolean r10 = true;
    L11:
        if (r10 == true) goto L8;
        return;
    L10:
        r10 = false;
        goto L11
    L5:
        r9 = false;
        goto L6
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU, reason: not valid java name */
    public Object mo530trySendJP2dKIU(E r19) {
        long r0 = d.get(this);
        boolean r9 = false;
        if (t(r0, false) == false) goto L5;
        boolean r1 = false;
    L6:
        if (r1 == true) goto L8;
        d2 r13 = e.j;
        h r2 = (h) h.get(this);
    L10:
        long r3 = d.getAndIncrement(this);
        long r14 = r3 & 1152921504606846975L;
        boolean r16 = t(r3, r9);
        long r4 = e.b;
        long r5 = r14 / r4;
        int r7 = (int) (r14 % r4);
        if (((y) r2).c == r5) goto L17;
        h r6 = a(this, r5, r2);
        if (r6 == null) goto L14;
        h r8 = r6;
    L18:
        h r17 = r8;
        int r10 = d(this, r8, r7, r19, r14, r13, r16);
        if (r10 == 0) goto L48;
        if (r10 == 1) goto L49;
        if (r10 == 2) goto L38;
        if (r10 == 3) goto L37;
        if (r10 == 4) goto L33;
        if (r10 != 5) goto L31;
        r17.b();
    L31:
        r2 = r17;
        r9 = false;
        goto L10
    L33:
        if (r14 >= o()) goto L35;
        r17.b();
    L35:
        g.c r11 = g.b;
        return new g.a(p());
    L37:
        throw new IllegalStateException("unexpected".toString());
    L38:
        if (r16 == false) goto L41;
        r17.i();
        g.c r12 = g.b;
        return new g.a(p());
    L41:
        if ((r13 instanceof d2) == false) goto L43;
        d2 r15 = r13;
    L45:
        if (r15 == null) goto L47;
        b(this, r15, r17, r7);
    L47:
        r17.i();
        return g.b;
    L43:
        r15 = null;
    L49:
        g.c r18 = g.b;
        return Unit.INSTANCE;
    L48:
        r17.b();
        goto L49
    L14:
        if (r16 == false) goto L10;
        g.c r20 = g.b;
        return new g.a(p());
    L17:
        r8 = r2;
        goto L18
    L8:
        return g.b;
    L5:
        r1 = !e(r0 & 1152921504606846975L);
        goto L6
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException r1) {
        f(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BufferedChannel(int r9, Function1<? super E, Unit> r10) {
        this.a = r9;
        this.b = r10;
        if (r9 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L24;
        h<Object> r1 = e.a;
        if (r9 != 0) goto L10;
        long r2 = 0;
    L14:
        this.bufferEnd$volatile = r2;
        this.completedExpandBuffersAndPauseFlag$volatile = l();
        h<Object> r11 = new h(0, null, this, 3);
        this.sendSegment$volatile = r11;
        this.receiveSegment$volatile = r11;
        if (v() == false) goto L17;
        r11 = e.a;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
    L17:
        this.bufferEndSegment$volatile = r11;
        if (r10 == 0) goto L20;
        onUndeliveredElementReceiveCancellationConstructor.1.1 r12 = new onUndeliveredElementReceiveCancellationConstructor.1.1(this);
    L21:
        this.c = r12;
        this._closeCause$volatile = e.s;
        return;
    L20:
        r12 = null;
        goto L21
    L10:
        if (r9 == Integer.MAX_VALUE) goto L12;
        r2 = r9;
        goto L14
    L12:
        r2 = LongCompanionObject.MAX_VALUE;
        goto L14
    L24:
        throw new IllegalArgumentException(("Invalid channel capacity: " + r9 + ", should be >=0").toString());
    L5:
        r0 = false;
        goto L6
    }

    public static <E> Object C(BufferedChannel<E> r14, Continuation<? super g<? extends E>> r15) {
        if ((r15 instanceof BufferedChannel$receiveCatching$1) == false) goto L7;
        BufferedChannel$receiveCatching$1 r0 = (BufferedChannel$receiveCatching$1) r15;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        BufferedChannel$receiveCatching$1 r6 = r0;
        Object r16 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
        Object r17 = ((g) r16).a;
    L52:
        return r17;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        kotlinx.coroutines.internal.e r4 = (h) i.get(r14);
    L16:
        if (r14.isClosedForReceive() == true) goto L17;
        long r5 = e.getAndIncrement(r14);
        int r7 = e.b;
        long r8 = r5 / ((long) r7);
        int r9 = (int) (r5 % ((long) r7));
        if (((y) r4).c == r8) goto L24;
        kotlinx.coroutines.internal.e r10 = r14.k(r8, r4);
        if (r10 == null) goto L16;
        kotlinx.coroutines.internal.e r13 = r10;
    L25:
        Object r11 = r14.K(r13, r9, r5, null);
        if (r11 == e.m) goto L42;
        if (r11 != e.o) goto L34;
        if (r5 >= r14.q()) goto L32;
        r13.b();
    L32:
        r4 = r13;
        goto L16
    L34:
        if (r11 != e.n) goto L39;
        r6.label = 1;
        r17 = r14.D(r13, r9, r5, r6);
        if (r17 != r2) goto L52;
        return r2;
    L39:
        r13.b();
        g.c r18 = g.b;
        return r11;
    L42:
        throw new IllegalStateException("unexpected".toString());
    L24:
        r13 = r4;
        goto L25
    L17:
        g.c r19 = g.b;
        return new g.a(r14.m());
    L7:
        r0 = new BufferedChannel$receiveCatching$1(r14, r15);
        goto L8
    }

    public static final void c(BufferedChannel r11, kotlinx.coroutines.selects.l r12) {
        r11.getClass();
        h<E> r0 = (h) i.get(r11);
    L4:
        if (r11.isClosedForReceive() == true) goto L5;
        long r8 = e.getAndIncrement(r11);
        long r1 = e.b;
        long r3 = r8 / r1;
        int r10 = (int) (r8 % r1);
        if (((y) r0).c == r3) goto L12;
        h<E> r2 = r11.k(r3, r0);
        if (r2 == null) goto L4;
        r0 = r2;
    L12:
        Object r4 = r11.K(r0, r10, r8, r12);
        if (r4 == e.m) goto L15;
        if (r4 != e.o) goto L26;
        if (r8 >= r11.q()) goto L4;
        r0.b();
        goto L4
    L26:
        if (r4 == e.n) goto L30;
        r0.b();
        r12.c(r4);
        return;
    L30:
        throw new IllegalStateException("unexpected".toString());
    L15:
        if ((r12 instanceof d2) == false) goto L17;
        d2 r13 = (d2) r12;
    L18:
        if (r13 == null) goto L42;
        r11.B();
        r13.e(r0, r10);
        return;
    L42:
        return;
    L17:
        r13 = null;
        goto L18
    L5:
        r12.c(e.l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void E(kotlinx.coroutines.selects.l<?> r14, Object r15) {
        kotlinx.coroutines.internal.e r0 = (h) h.get(this);
    L3:
        long r1 = d.getAndIncrement(this);
        long r3 = 1152921504606846975L & r1;
        boolean r2 = t(r1, false);
        long r5 = e.b;
        long r7 = r3 / r5;
        int r4 = (int) (r3 % r5);
        if (((y) r0).c == r7) goto L10;
        kotlinx.coroutines.internal.e r6 = a(this, r7, r0);
        if (r6 == null) goto L7;
        r0 = r6;
        goto L10
    L7:
        if (r2 == false) goto L3;
    L31:
        y(r15, r14);
        return;
    L10:
        int r8 = d(this, r0, r4, r15, r3, r14, r2);
        if (r8 == 0) goto L38;
        if (r8 == 1) goto L39;
        if (r8 == 2) goto L29;
        if (r8 == 3) goto L28;
        if (r8 == 4) goto L25;
        if (r8 != 5) goto L3;
        r0.b();
        goto L3
    L25:
        if (r3 >= o()) goto L31;
        r0.b();
        goto L31
    L28:
        throw new IllegalStateException("unexpected".toString());
    L29:
        if (r2 == false) goto L33;
        r0.i();
        goto L31
    L33:
        if ((r14 instanceof d2) == false) goto L35;
        d2 r16 = (d2) r14;
    L36:
        if (r16 == null) goto L56;
        b(this, r16, r0, r4);
        return;
    L56:
        return;
    L35:
        r16 = null;
    L39:
        r14.c(Unit.INSTANCE);
        return;
    L38:
        r0.b();
        goto L39
    }

    public final void F(d2 r3, boolean r4) {
        if ((r3 instanceof b) == false) goto L6;
        kotlinx.coroutines.i r5 = ((b) r3).a;
        Result.Companion r6 = Result.Companion;
        r5.resumeWith(Result.constructor-impl(Boolean.FALSE));
        return;
    L6:
        if ((r3 instanceof kotlinx.coroutines.i) == false) goto L13;
        Continuation r7 = (Continuation) r3;
        Result.Companion r0 = Result.Companion;
        if (r4 == false) goto L10;
        Throwable r8 = n();
    L11:
        r7.resumeWith(Result.constructor-impl(ResultKt.createFailure(r8)));
        return;
    L10:
        r8 = p();
        goto L11
    L13:
        if ((r3 instanceof l) == false) goto L16;
        kotlinx.coroutines.j<g<? extends E>> r9 = ((l) r3).a;
        Result.Companion r10 = Result.Companion;
        g.c r11 = g.b;
        r9.resumeWith(Result.constructor-impl(new g(new g.a(m()))));
        return;
    L16:
        if ((r3 instanceof a) == false) goto L22;
        a r12 = (a) r3;
        kotlinx.coroutines.j<? super Boolean> r13 = r12.b;
        Intrinsics.checkNotNull(r13);
        r12.b = null;
        r12.a = e.l;
        Throwable r14 = r12.c.m();
        if (r14 != null) goto L20;
        Result.Companion r15 = Result.Companion;
        r13.resumeWith(Result.constructor-impl(Boolean.FALSE));
        return;
    L20:
        Result.Companion r1 = Result.Companion;
        r13.resumeWith(Result.constructor-impl(ResultKt.createFailure(r14)));
        return;
    L22:
        if ((r3 instanceof kotlinx.coroutines.selects.l) == false) goto L26;
        ((kotlinx.coroutines.selects.l) r3).f(this, e.l);
        return;
    L26:
        throw new IllegalStateException(("Unexpected waiter: " + r3).toString());
    }

    public Object G(E r19, Continuation<? super Boolean> r20) {
        kotlinx.coroutines.j r9 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r20), 1);
        r9.C();
        if (this.b != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L46;
        b r12 = new b(r9);
        h r1 = (h) h.get(this);
    L8:
        long r2 = d.getAndIncrement(this);
        long r13 = r2 & 1152921504606846975L;
        boolean r15 = t(r2, false);
        long r3 = e.b;
        long r4 = r13 / r3;
        int r7 = (int) (r13 % r3);
        if (((y) r1).c == r4) goto L15;
        h r5 = a(this, r4, r1);
        if (r5 == null) goto L12;
        h r6 = r5;
    L16:
        h r16 = r6;
        int r8 = d(this, r6, r7, r19, r13, r12, r15);
        if (r8 == 0) goto L39;
        if (r8 == 1) goto L40;
        if (r8 == 2) goto L35;
        if (r8 == 3) goto L34;
        if (r8 == 4) goto L31;
        if (r8 != 5) goto L29;
        r16.b();
    L29:
        r1 = r16;
        goto L8
    L31:
        if (r13 >= o()) goto L37;
        r16.b();
    L37:
        Result.Companion r10 = Result.Companion;
        r9.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
    L41:
        Object r11 = r9.B();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L44;
        DebugProbesKt.probeCoroutineSuspended(r20);
    L44:
        return r11;
    L34:
        throw new IllegalStateException("unexpected".toString());
    L35:
        if (r15 == false) goto L38;
        r16.i();
        goto L37
    L38:
        b(this, r12, r16, r7);
    L40:
        Result.Companion r14 = Result.Companion;
        r9.resumeWith(Result.constructor-impl(Boxing.boxBoolean(true)));
        goto L41
    L39:
        r16.b();
        goto L40
    L12:
        if (r15 == false) goto L8;
    L15:
        r6 = r1;
        goto L16
    L46:
        throw new IllegalStateException("the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`".toString());
    L5:
        r0 = false;
        goto L6
    }

    public final boolean I(Object r5, E r6) {
        if ((r5 instanceof kotlinx.coroutines.selects.l) == true) goto L26;
        Function1 r1 = null;
        if ((r5 instanceof l) == false) goto L12;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
        l r7 = (l) r5;
        kotlinx.coroutines.j<g<? extends E>> r0 = r7.a;
        g.c r2 = g.b;
        g r3 = new g(r6);
        Function1<E, Unit> r4 = this.b;
        if (r4 == null) goto L27;
        r1 = OnUndeliveredElementKt.a(r4, r6, r7.a.getContext());
    L27:
        return e.a(r0, r3, r1);
    L12:
        if ((r5 instanceof a) == false) goto L18;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
        a r8 = (a) r5;
        kotlinx.coroutines.j<? super Boolean> r9 = r8.b;
        Intrinsics.checkNotNull(r9);
        r8.b = null;
        r8.a = r6;
        Boolean r10 = Boolean.TRUE;
        Function1<E, Unit> r11 = r8.c.b;
        if (r11 == null) goto L28;
        r1 = OnUndeliveredElementKt.a(r11, r6, r9.getContext());
    L28:
        return e.a(r9, r10, r1);
    L18:
        if ((r5 instanceof kotlinx.coroutines.i) == false) goto L25;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
        kotlinx.coroutines.i r12 = (kotlinx.coroutines.i) r5;
        Function1<E, Unit> r13 = this.b;
        if (r13 == null) goto L23;
        r1 = OnUndeliveredElementKt.a(r13, r6, r12.getContext());
    L23:
        return e.a(r12, r6, r1);
    L25:
        throw new IllegalStateException(("Unexpected receiver type: " + r5).toString());
    L26:
        return ((kotlinx.coroutines.selects.l) r5).f(this, r6);
    }

    public final boolean g(Throwable r16, boolean r17) {
        if (r17 == false) goto L9;
        AtomicLongFieldUpdater r11 = d;
    L5:
        long r2 = r11.get(this);
        if (((int) (r2 >> 60)) != 0) goto L9;
        h<Object> r4 = e.a;
        long r5 = ((long) 1) << 60;
        if (r11.compareAndSet(this, r2, r5 + (r2 & 1152921504606846975L)) == false) goto L5;
    L9:
        AtomicReferenceFieldUpdater r0 = k;
        b0 r1 = e.s;
    L11:
        if (r0.compareAndSet(this, r1, r16) == true) goto L12;
        if (r0.get(this) == r1) goto L11;
        boolean r12 = false;
    L17:
        if (r17 == false) goto L22;
        AtomicLongFieldUpdater r14 = d;
    L19:
        long r3 = r14.get(this);
        h<Object> r6 = e.a;
        long r7 = ((long) 3) << 60;
        if (r14.compareAndSet(this, r3, r7 + (r3 & 1152921504606846975L)) == false) goto L19;
    L31:
        isClosedForSend();
        x();
        if (r12 == false) goto L48;
        AtomicReferenceFieldUpdater r8 = l;
    L34:
        Object r9 = r8.get(this);
        if (r9 != null) goto L37;
        b0 r10 = e.q;
    L39:
        if (r8.compareAndSet(this, r9, r10) == true) goto L40;
        if (r8.get(this) == r9) goto L39;
        boolean r13 = false;
    L44:
        if (r13 == false) goto L34;
        if (r9 == null) goto L48;
        Function1 r15 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r9, 1);
        ((Function1) r9).invoke(m());
        goto L48
    L40:
        r13 = true;
        goto L44
    L37:
        r10 = e.r;
    L48:
        return r12;
    L22:
        AtomicLongFieldUpdater r18 = d;
    L23:
        long r19 = r18.get(this);
        int r20 = (int) (r19 >> 60);
        if (r20 == 0) goto L28;
        if (r20 != 1) goto L31;
        long r21 = r19 & 1152921504606846975L;
        h<Object> r22 = e.a;
        int r23 = 3;
    L30:
        if (r18.compareAndSet(this, r19, (((long) r23) << 60) + r21) == false) goto L23;
    L28:
        r21 = r19 & 1152921504606846975L;
        h<Object> r24 = e.a;
        r23 = 2;
        goto L30
    L12:
        r12 = true;
        goto L17
    }

    public final h<E> k(long r13, h<E> r15) {
        AtomicReferenceFieldUpdater r0 = i;
        h<Object> r1 = e.a;
        BufferedChannelKt.createSegmentFunction.1 r2 = BufferedChannelKt.createSegmentFunction.1.INSTANCE;
    L3:
        Object r3 = d.a(r15, r13, r2);
        if (z.b(r3) == true) goto L29;
        y r4 = z.a(r3);
    L6:
        y r6 = (y) r0.get(this);
        if (r6.c >= r4.c) goto L22;
        if (r4.j() == false) goto L11;
    L13:
        if (r0.compareAndSet(this, r6, r4) == true) goto L14;
        if (r0.get(this) == r6) goto L13;
        boolean r7 = false;
    L18:
        if (r7 == true) goto L20;
        if (r4.f() == false) goto L6;
        r4.e();
        goto L6
    L20:
        if (r6.f() == false) goto L22;
        r6.e();
        goto L22
    L14:
        r7 = true;
        goto L18
    L11:
        boolean r5 = false;
    L23:
        if (r5 == false) goto L3;
    L22:
        r5 = true;
    L29:
        if (z.b(r3) == false) goto L33;
        isClosedForSend();
        if ((((y) r15).c * ((long) e.b)) >= q()) goto L66;
        r15.b();
    L66:
        return null;
    L33:
        h<E> r16 = (h) z.a(r3);
        if (v() == false) goto L36;
    L55:
        long r8 = ((y) r16).c;
        if (r8 <= r13) goto L96;
        long r9 = r8 * ((long) e.b);
        AtomicLongFieldUpdater r14 = e;
    L58:
        long r10 = r14.get(this);
        if (r10 >= r9) goto L64;
        if (e.compareAndSet(this, r10, r9) == false) goto L58;
    L64:
        if ((((y) r16).c * ((long) e.b)) >= q()) goto L66;
        r16.b();
        goto L66
    L96:
        return r16;
    L36:
        if (r13 > (l() / ((long) e.b))) goto L55;
        AtomicReferenceFieldUpdater r11 = j;
    L38:
        y r12 = (y) r11.get(this);
        if (r12.c >= ((y) r16).c) goto L55;
        if (r16.j() == false) goto L55;
    L43:
        if (r11.compareAndSet(this, r12, r16) == true) goto L44;
        if (r11.get(this) == r12) goto L43;
        boolean r17 = false;
    L48:
        if (r17 == true) goto L50;
        if (r16.f() == false) goto L38;
        r16.e();
        goto L38
    L50:
        if (r12.f() == false) goto L55;
        r12.e();
        goto L55
    L44:
        r17 = true;
        goto L48
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E r23, Continuation<? super Unit> r24) {
        h r1 = (h) h.get(this);
    L3:
        long r2 = d.getAndIncrement(this);
        long r12 = r2 & 1152921504606846975L;
        boolean r15 = t(r2, false);
        long r3 = e.b;
        long r4 = r12 / r3;
        int r8 = (int) (r12 % r3);
        if (((y) r1).c == r4) goto L12;
        h r5 = a(this, r4, r1);
        if (r5 == null) goto L7;
        h r7 = r5;
    L13:
        h r16 = r7;
        int r6 = d(this, r7, r8, r23, r12, null, r15);
        if (r6 == 0) goto L104;
        if (r6 == 1) goto L106;
        if (r6 == 2) goto L100;
        if (r6 == 3) goto L32;
        if (r6 == 4) goto L27;
        if (r6 != 5) goto L25;
        r16.b();
    L25:
        r1 = r16;
        goto L3
    L27:
        if (r12 >= o()) goto L29;
        r16.b();
    L29:
        Object r0 = z(r23, r24);
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L106;
        return r0;
    L32:
        BufferedChannel<E> r9 = this;
        BufferedChannel<E> r18 = kotlinx.coroutines.l.a(IntrinsicsKt.intercepted(r24));
        int r10 = d(r9, r16, r8, r23, r12, r18, false);     // Catch: Throwable -> L95
        if (r10 == 0) goto L83;
        if (r10 == 1) goto L68;
        if (r10 == 2) goto L82;
        if (r10 != 4) goto L39;
        r18 = r18;
        if (r12 >= o()) goto L76;
        r16.b();     // Catch: Throwable -> L79
    L76:
        Function1<E, Unit> r11 = this.b;     // Catch: Throwable -> L79
        if (r11 == null) goto L81;
        OnUndeliveredElementKt.b(r11, r23, r18.getContext());     // Catch: Throwable -> L79
    L81:
        Throwable r13 = p();     // Catch: Throwable -> L79
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L79
        r18.resumeWith(Result.constructor-impl(ResultKt.createFailure(r13)));     // Catch: Throwable -> L79
    L85:
        Object r17 = r18.B();
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L89;
        DebugProbesKt.probeCoroutineSuspended(r24);
    L89:
        if (r17 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L93;
        r17 = Unit.INSTANCE;
    L93:
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L106;
        return r17;
    L39:
        if (r10 != 5) goto L72;
        r16.b();     // Catch: Throwable -> L95
        kotlinx.coroutines.internal.e r19 = (h) h.get(this);     // Catch: Throwable -> L95
    L41:
        long r20 = d.getAndIncrement(this);     // Catch: Throwable -> L95
        long r21 = r20 & 1152921504606846975L;     // Catch: Throwable -> L95
        boolean r110 = t(r20, false);     // Catch: Throwable -> L95
        long r22 = e.b;     // Catch: Throwable -> L95
        long r25 = r21 / r22;     // Catch: Throwable -> L95
        int r26 = (int) (r21 % r22);     // Catch: Throwable -> L95
        if (((y) r19).c == r25) goto L48;
        kotlinx.coroutines.internal.e r27 = a(this, r25, r19);     // Catch: Throwable -> L95
        if (r27 == null) goto L45;
        r19 = r27;
        goto L48
    L45:
        if (r110 == false) goto L41;
    L65:
        r18 = r18;
    L48:
        int r28 = d(this, r19, r26, r23, r21, r18, r110);     // Catch: Throwable -> L95
        if (r28 == 0) goto L69;
        if (r28 == 1) goto L68;
        if (r28 == 2) goto L63;
        if (r28 == 3) goto L62;
        if (r28 == 4) goto L59;
        if (r28 != 5) goto L41;
        r19.b();     // Catch: Throwable -> L95
        goto L41
    L59:
        if (r21 >= o()) goto L65;
        r19.b();     // Catch: Throwable -> L95
        goto L65
    L62:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L95
    L63:
        if (r110 == false) goto L66;
        r19.i();     // Catch: Throwable -> L95
        goto L65
    L66:
        r18 = r18;
        b(this, r18, r19, r26);     // Catch: Throwable -> L79
        goto L85
    L69:
        r19.b();     // Catch: Throwable -> L79
    L70:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L79
    L84:
        r18.resumeWith(Result.constructor-impl(Unit.INSTANCE));     // Catch: Throwable -> L79
        goto L85
    L72:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L79
    L82:
        r18 = r18;
        b(this, r18, r16, r8);     // Catch: Throwable -> L79
    L68:
        r18 = r18;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L79
        goto L84
    L83:
        r16.b();     // Catch: Throwable -> L79
    L79:
        th = th;
    L97:
        r9.H();
        throw th;
    L95:
        th = th;
        r9 = r18;
        goto L97
    L100:
        if (r15 == false) goto L106;
        r16.i();
        Object r31 = z(r23, r24);
        if (r31 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L106;
        return r31;
    L106:
        return Unit.INSTANCE;
    L104:
        r16.b();
        goto L106
    L7:
        if (r15 == false) goto L3;
        Object r32 = z(r23, r24);
        if (r32 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L106;
        return r32;
    L12:
        r7 = r1;
        goto L13
    }

    public final boolean t(long r13, boolean r15) {
        int r1 = (int) (r13 >> 60);
        if (r1 != 0) goto L5;
        return false;
    L5:
        if (r1 != 1) goto L7;
        return false;
    L7:
        if (r1 != 2) goto L9;
        h(r13 & 1152921504606846975L);
        if (r15 == true) goto L73;
    L74:
        return true;
    L73:
        if (r() == false) goto L74;
        return false;
    L9:
        if (r1 != 3) goto L69;
        h<E> r14 = h(r13 & 1152921504606846975L);
        Function1<E, Unit> r16 = this.b;
        UndeliveredElementException r2 = null;
        Object r3 = null;
    L11:
        int r4 = e.b - 1;
    L12:
        if ((-1) >= r4) goto L56;
        long r6 = (((y) r14).c * ((long) e.b)) + ((long) r4);
    L14:
        Object r8 = r14.l(r4);
        if (r8 == e.i) goto L58;
        if (r8 == e.d) goto L19;
        if (r8 == e.e) goto L53;
        if (r8 == null) goto L53;
        if ((r8 instanceof d2) == true) goto L42;
        if ((r8 instanceof n) == true) goto L42;
        b0 r9 = e.g;
        if (r8 == r9) goto L58;
        if (r8 == e.f) goto L58;
        if (r8 == r9) goto L14;
    L55:
        r4 = r4 - 1;
    L42:
        if (r6 < o()) goto L58;
        if ((r8 instanceof n) == false) goto L46;
        d2 r10 = ((n) r8).a;
    L48:
        if (r14.k(r4, r8, e.l) == false) goto L14;
        if (r16 == null) goto L51;
        r2 = OnUndeliveredElementKt.c(r16, r14.f.get(r4 * 2), r2);
    L51:
        r3 = kotlinx.coroutines.internal.k.a(r3, r10);
        r14.n(r4, null);
        r14.i();
        goto L55
    L46:
        r10 = (d2) r8;
    L53:
        if (r14.k(r4, r8, e.l) == false) goto L14;
        r14.i();
        goto L55
    L19:
        if (r6 < o()) goto L58;
        if (r14.k(r4, r8, e.l) == false) goto L14;
        if (r16 == null) goto L24;
        r2 = OnUndeliveredElementKt.c(r16, r14.f.get(r4 * 2), r2);
    L24:
        r14.n(r4, null);
        r14.i();
    L58:
        if (r3 != null) goto L60;
    L65:
        if (r2 == null) goto L74;
        throw r2;
    L60:
        if ((r3 instanceof ArrayList) == true) goto L62;
        F((d2) r3, false);
        goto L65
    L62:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList r5 = (ArrayList) r3;
        int r17 = r5.size() - 1;
    L63:
        if ((-1) >= r17) goto L65;
        F((d2) ListProtector.get(r5, r17), false);
        r17 = r17 - 1;
        goto L63
    L56:
        r14 = (h) ((kotlinx.coroutines.internal.e) kotlinx.coroutines.internal.e.b.get(r14));
        if (r14 != null) goto L11;
    L69:
        throw new IllegalStateException(("unexpected close status: " + r1).toString());
    }

    public final void w(long r7, h<E> r9) {
    L3:
        if (((y) r9).c >= r7) goto L9;
        h<E> r0 = (h) r9.c();
        if (r0 == null) goto L9;
        r9 = r0;
    L9:
        if (r9.d() == false) goto L14;
        h<E> r8 = (h) r9.c();
        if (r8 == null) goto L14;
        r9 = r8;
    L14:
        AtomicReferenceFieldUpdater r10 = j;
    L15:
        y r11 = (y) r10.get(this);
        boolean r4 = true;
        if (r11.c >= ((y) r9).c) goto L30;
        boolean r1 = false;
        if (r9.j() == false) goto L20;
    L22:
        if (r10.compareAndSet(this, r11, r9) == true) goto L23;
        if (r10.get(this) == r11) goto L22;
    L26:
        if (r1 == true) goto L28;
        if (r9.f() == false) goto L15;
        r9.e();
        goto L15
    L28:
        if (r11.f() == false) goto L30;
        r11.e();
        goto L30
    L23:
        r1 = true;
        goto L26
    L20:
        r4 = false;
    L30:
        if (r4 == false) goto L9;
    }

    public final void y(E r3, kotlinx.coroutines.selects.l<?> r4) {
        Function1<E, Unit> r0 = this.b;
        if (r0 == null) goto L5;
        OnUndeliveredElementKt.b(r0, r3, r4.getContext());
    L5:
        r4.c(e.l);
    }

    public final Object z(E r4, Continuation<? super Unit> r5) {
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r5), 1);
        r0.C();
        Function1<E, Unit> r1 = this.b;
        if (r1 == null) goto L7;
        UndeliveredElementException r6 = OnUndeliveredElementKt.c(r1, r4, null);
        if (r6 == null) goto L7;
        ExceptionsKt.addSuppressed(r6, p());
        Result.Companion r2 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(r6)));
    L8:
        Object r7 = r0.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L12:
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r7;
    L15:
        return Unit.INSTANCE;
    L7:
        Throwable r8 = p();
        Result.Companion r3 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(r8)));
        goto L8
    }

    public static final h a(BufferedChannel r11, long r12, h r14) {
        r11.getClass();
        AtomicReferenceFieldUpdater r0 = h;
        h<Object> r1 = e.a;
        BufferedChannelKt.createSegmentFunction.1 r2 = BufferedChannelKt.createSegmentFunction.1.INSTANCE;
    L3:
        Object r3 = d.a(r14, r12, r2);
        if (z.b(r3) == true) goto L27;
        y r4 = z.a(r3);
    L6:
        y r5 = (y) r0.get(r11);
        boolean r9 = true;
        if (r5.c >= r4.c) goto L21;
        boolean r6 = false;
        if (r4.j() == false) goto L11;
    L13:
        if (r0.compareAndSet(r11, r5, r4) == true) goto L14;
        if (r0.get(r11) == r5) goto L13;
    L17:
        if (r6 == true) goto L19;
        if (r4.f() == false) goto L6;
        r4.e();
        goto L6
    L19:
        if (r5.f() == false) goto L21;
        r5.e();
        goto L21
    L14:
        r6 = true;
        goto L17
    L11:
        r9 = false;
    L21:
        if (r9 == false) goto L3;
    L27:
        if (z.b(r3) == false) goto L31;
        r11.isClosedForSend();
        if ((((y) r14).c * ((long) e.b)) >= r11.o()) goto L42;
        r14.b();
    L42:
        return null;
    L31:
        h r15 = (h) z.a(r3);
        long r7 = ((y) r15).c;
        if (r7 <= r12) goto L63;
        long r8 = r7 * ((long) e.b);
        AtomicLongFieldUpdater r13 = d;
    L34:
        long r10 = r13.get(r11);
        long r16 = 1152921504606846975L & r10;
        if (r16 >= r8) goto L40;
        int r17 = (int) (r10 >> 60);
        h<Object> r18 = e.a;
        long r19 = (((long) r17) << 60) + r16;
        if (d.compareAndSet(r11, r10, r19) == false) goto L34;
    L40:
        if ((((y) r15).c * ((long) e.b)) >= r11.o()) goto L42;
        r15.b();
        goto L42
    L63:
        return r15;
    }

    public final boolean J(Object r3, h<E> r4, int r5) {
        if ((r3 instanceof kotlinx.coroutines.i) == false) goto L6;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        return e.a((kotlinx.coroutines.i) r3, Unit.INSTANCE, null);
    L6:
        if ((r3 instanceof kotlinx.coroutines.selects.l) == false) goto L15;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        TrySelectDetailedResult r6 = ((SelectImplementation) r3).l(this, Unit.INSTANCE);
        if (r6 != TrySelectDetailedResult.REREGISTER) goto L11;
        r4.n(r5, null);
    L11:
        if (r6 != TrySelectDetailedResult.SUCCESSFUL) goto L13;
        return true;
    L13:
        return false;
    L15:
        if ((r3 instanceof b) == false) goto L19;
        return e.a(((b) r3).a, Boolean.TRUE, null);
    L19:
        throw new IllegalStateException(("Unexpected waiter: " + r3).toString());
    }

    public static final void b(BufferedChannel r0, d2 r1, h r2, int r3) {
        r0.getClass();
        r1.e(r2, r3 + e.b);
    }

    public final Object D(h<E> r11, int r12, long r13, Continuation<? super g<? extends E>> r15) {
        if ((r15 instanceof BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) == false) goto L7;
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r0 = (BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) r15;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        h r14 = (h) r0.L$1;
        BufferedChannel r17 = (BufferedChannel) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L59:
        return ((g) r16).a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        r0.L$0 = this;
        r0.L$1 = r11;
        r0.I$0 = r12;
        r0.J$0 = r13;
        r0.label = 1;
        kotlinx.coroutines.j r18 = kotlinx.coroutines.l.a(IntrinsicsKt.intercepted(r0));
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$38>>");     // Catch: Throwable -> L60
        l r8 = new l(r18);     // Catch: Throwable -> L60
        Object r4 = K(r11, r12, r13, r8);     // Catch: Throwable -> L60
        if (r4 != e.m) goto L18;
        B();     // Catch: Throwable -> L60
        r8.e(r11, r12);     // Catch: Throwable -> L60
    L53:
        r16 = r18.B();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L56;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L56:
        if (r16 != r2) goto L59;
        return r2;
    L18:
        Function1 r9 = null;
        if (r4 == e.o) goto L21;
        r11.b();     // Catch: Throwable -> L60
        g.c r19 = g.b;     // Catch: Throwable -> L60
        g r110 = new g(r4);     // Catch: Throwable -> L60
        Function1<E, Unit> r111 = this.b;     // Catch: Throwable -> L60
        if (r111 != null) goto L51;
    L46:
        r18.h(r110, r9);     // Catch: Throwable -> L60
        goto L53
    L51:
        r9 = OnUndeliveredElementKt.a(r111, r4, r18.getContext());     // Catch: Throwable -> L60
        goto L46
    L21:
        if (r13 >= q()) goto L23;
        r11.b();     // Catch: Throwable -> L60
    L23:
        h<E> r112 = (h) i.get(this);     // Catch: Throwable -> L60
    L25:
        if (isClosedForReceive() == true) goto L26;
        long r113 = e.getAndIncrement(this);     // Catch: Throwable -> L60
        int r114 = e.b;     // Catch: Throwable -> L60
        long r5 = r113 / ((long) r114);     // Catch: Throwable -> L60
        int r115 = (int) (r113 % ((long) r114));     // Catch: Throwable -> L60
        if (((y) r112).c == r5) goto L33;
        h<E> r6 = k(r5, r112);     // Catch: Throwable -> L60
        if (r6 == null) goto L25;
        r112 = r6;
    L33:
        Object r7 = K(r112, r115, r113, r8);     // Catch: Throwable -> L60
        if (r7 == e.m) goto L35;
        if (r7 != e.o) goto L42;
        if (r113 >= q()) goto L25;
        r112.b();     // Catch: Throwable -> L60
        goto L25
    L42:
        if (r7 == e.n) goto L48;
        r112.b();     // Catch: Throwable -> L60
        g.c r116 = g.b;     // Catch: Throwable -> L60
        r110 = new g(r7);     // Catch: Throwable -> L60
        Function1<E, Unit> r117 = this.b;     // Catch: Throwable -> L60
        if (r117 == null) goto L46;
        r9 = OnUndeliveredElementKt.a(r117, r7, r18.getContext());     // Catch: Throwable -> L60
        goto L46
    L48:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L60
    L35:
        B();     // Catch: Throwable -> L60
        r8.e(r112, r115);     // Catch: Throwable -> L60
        goto L53
    L26:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L60
        g.c r119 = g.b;     // Catch: Throwable -> L60
        r18.resumeWith(Result.constructor-impl(new g(new g.a(m()))));     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        r18.H();
        throw th;
    L7:
        r0 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, r15);
        goto L8
    }

    public final Object K(h<E> r8, int r9, long r10, Object r12) {
        Object r0 = r8.l(r9);
        if (r0 != null) goto L14;
        if (r10 < (d.get(this) & 1152921504606846975L)) goto L19;
        if (r12 != null) goto L10;
        return e.n;
    L10:
        if (r8.k(r9, r0, r12) == false) goto L19;
        j();
        return e.m;
    L19:
        Object r1 = r8.l(r9);
        if (r1 == null) goto L53;
        if (r1 == e.e) goto L53;
        if (r1 == e.d) goto L27;
        b0 r4 = e.j;
        if (r1 == r4) goto L87;
        if (r1 == e.h) goto L88;
        if (r1 == e.l) goto L37;
        if (r1 == e.g) goto L19;
        if (r8.k(r9, r1, e.f) == false) goto L19;
        boolean r11 = r1 instanceof n;
        if (r11 == false) goto L46;
        r1 = ((n) r1).a;
    L46:
        if (J(r1, r8, r9) == false) goto L48;
        r8.o(r9, e.i);
        j();
        Object r13 = r8.f.get(r9 * 2);
        r8.n(r9, null);
        return r13;
    L48:
        r8.o(r9, r4);
        r8.m(r9, false);
        if (r11 == false) goto L91;
        j();
    L91:
        return e.o;
    L37:
        j();
        return e.o;
    L88:
        return e.o;
    L87:
        return e.o;
    L27:
        if (r8.k(r9, r1, e.i) == false) goto L19;
        j();
        Object r14 = r8.f.get(r9 * 2);
        r8.n(r9, null);
        return r14;
    L53:
        if (r10 < (d.get(this) & 1152921504606846975L)) goto L55;
        if (r12 == null) goto L93;
        if (r8.k(r9, r1, r12) == false) goto L19;
        j();
        return e.m;
    L93:
        return e.n;
    L55:
        if (r8.k(r9, r1, e.h) == false) goto L19;
        j();
        return e.o;
    L14:
        if (r0 != e.d) goto L19;
        if (r8.k(r9, r0, e.i) == false) goto L19;
        j();
        Object r15 = r8.f.get(r9 * 2);
        r8.n(r9, null);
        return r15;
    }

    public final int L(h<E> r7, int r8, E r9, long r10, Object r12, boolean r13) {
    L2:
        Object r0 = r7.l(r8);
        if (r0 == null) goto L5;
        if (r0 != e.e) goto L27;
        if (r7.k(r8, r0, e.d) == false) goto L2;
        return 1;
    L27:
        b0 r11 = e.k;
        if (r0 != r11) goto L32;
        r7.n(r8, null);
        return 5;
    L32:
        if (r0 != e.h) goto L36;
        r7.n(r8, null);
        return 5;
    L36:
        if (r0 != e.l) goto L39;
        r7.n(r8, null);
        isClosedForSend();
        return 4;
    L39:
        r7.n(r8, null);
        if ((r0 instanceof n) == false) goto L43;
        r0 = ((n) r0).a;
    L43:
        if (I(r0, r9) == false) goto L46;
        r7.o(r8, e.i);
        A();
        return 0;
    L46:
        if (r7.f.getAndSet((r8 * 2) + 1, r11) == r11) goto L48;
        r7.m(r8, true);
    L48:
        return 5;
    L5:
        if (e(r10) == false) goto L10;
        if (r13 == true) goto L10;
        if (r7.k(r8, null, e.d) == false) goto L2;
        return 1;
    L10:
        if (r13 == true) goto L12;
        if (r12 == null) goto L16;
        if (r7.k(r8, null, r12) == false) goto L2;
        return 2;
    L16:
        return 3;
    L12:
        if (r7.k(r8, null, e.j) == false) goto L2;
        r7.m(r8, false);
        return 4;
    }

    public static final int d(BufferedChannel r4, h r5, int r6, Object r7, long r8, Object r10, boolean r11) {
        r4.getClass();
        r5.n(r6, r7);
        if (r11 == true) goto L28;
        Object r0 = r5.l(r6);
        if (r0 != null) goto L18;
        if (r4.e(r8) == true) goto L10;
        if (r10 != null) goto L15;
        return 3;
    L15:
        if (r5.k(r6, null, r10) == false) goto L27;
        return 2;
    L27:
        return r4.L(r5, r6, r7, r8, r10, r11);
    L10:
        if (r5.k(r6, null, e.d) == false) goto L27;
        return 1;
    L18:
        if ((r0 instanceof d2) == false) goto L27;
        r5.n(r6, null);
        if (r4.I(r0, r7) == false) goto L22;
        r5.o(r6, e.i);
        r4.A();
        return 0;
    L22:
        b0 r9 = e.k;
        if (r5.f.getAndSet((r6 * 2) + 1, r9) == r9) goto L25;
        r5.m(r6, true);
    L25:
        return 5;
    L28:
        return r4.L(r5, r6, r7, r8, r10, r11);
    }
}
