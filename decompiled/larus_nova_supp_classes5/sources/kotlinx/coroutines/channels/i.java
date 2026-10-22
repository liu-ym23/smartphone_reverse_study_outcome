package kotlinx.coroutines.channels;

import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class i<E> extends BufferedChannel<E> {
    public final BufferOverflow m;

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final boolean H() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final boolean u() {
        if (this.m != BufferOverflow.DROP_OLDEST) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public final Object mo530trySendJP2dKIU(E r2) {
        return N(r2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final void E(kotlinx.coroutines.selects.l<?> r2, Object r3) {
        Object r4 = N(r3, false);
        if ((r4 instanceof g.c) == true) goto L7;
        Unit r5 = (Unit) r4;
        r2.c(Unit.INSTANCE);
        return;
    L7:
        if ((r4 instanceof g.a) == false) goto L11;
        g.a(r4);
        r2.c(e.l);
        return;
    L11:
        throw new IllegalStateException("unreachable".toString());
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final Object G(E r2, Continuation<? super Boolean> r3) {
        Object r4 = N(r2, true);
        if ((r4 instanceof g.c) == true) goto L6;
        Unit r5 = (Unit) r4;
        return Boxing.boxBoolean(true);
    L6:
        return Boxing.boxBoolean(false);
    }

    public final Object N(E r19, boolean r20) {
        if (this.m != BufferOverflow.DROP_LATEST) goto L17;
        Object r0 = super.mo530trySendJP2dKIU(r19);
        g.c r1 = g.b;
        if ((!(r0 instanceof g.c)) == false) goto L7;
        return r0;
    L7:
        if ((r0 instanceof g.a) == true) goto L74;
        if (r20 == false) goto L71;
        Function1<E, Unit> r2 = this.b;
        if (r2 == null) goto L71;
        UndeliveredElementException r3 = OnUndeliveredElementKt.c(r2, r19, null);
        if (r3 == null) goto L71;
        throw r3;
    L71:
        return Unit.INSTANCE;
    L74:
        return r0;
    L17:
        d2 r12 = e.d;
        kotlinx.coroutines.internal.e r4 = (h) BufferedChannel.h.get(this);
    L18:
        long r5 = BufferedChannel.d.getAndIncrement(this);
        long r13 = r5 & 1152921504606846975L;
        boolean r15 = t(r5, false);
        long r6 = e.b;
        long r7 = r13 / r6;
        int r8 = (int) (r13 % r6);
        if (((y) r4).c == r7) goto L27;
        kotlinx.coroutines.internal.e r9 = BufferedChannel.a(this, r7, r4);
        if (r9 != null) goto L26;
        if (r15 == false) goto L18;
        g.c r10 = g.b;
        g.a r11 = new g.a(p());
    L72:
        return r11;
    L26:
        kotlinx.coroutines.internal.e r14 = r9;
    L28:
        int r16 = BufferedChannel.d(this, r14, r8, r19, r13, r12, r15);
        if (r16 == 0) goto L59;
        if (r16 == 1) goto L60;
        if (r16 == 2) goto L50;
        if (r16 == 3) goto L49;
        if (r16 == 4) goto L45;
        if (r16 != 5) goto L42;
        r14.b();
    L42:
        r4 = r14;
        goto L18
    L45:
        if (r13 >= o()) goto L47;
        r14.b();
    L47:
        g.c r17 = g.b;
        r11 = new g.a(p());
        goto L72
    L49:
        throw new IllegalStateException("unexpected".toString());
    L50:
        if (r15 == false) goto L53;
        r14.i();
        g.c r18 = g.b;
        r11 = new g.a(p());
        goto L72
    L53:
        if ((r12 instanceof d2) == false) goto L55;
        d2 r21 = r12;
    L56:
        if (r21 == null) goto L58;
        BufferedChannel.b(this, r21, r14, r8);
    L58:
        i((((y) r14).c * r6) + ((long) r8));
        g.c r22 = g.b;
        return Unit.INSTANCE;
    L55:
        r21 = null;
    L60:
        g.c r23 = g.b;
        return Unit.INSTANCE;
    L59:
        r14.b();
        goto L60
    L27:
        r14 = r4;
        goto L28
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public final Object send(E r2, Continuation<? super Unit> r3) {
        Object r4 = N(r2, true);
        if ((r4 instanceof g.a) == false) goto L13;
        g.a(r4);
        Function1<E, Unit> r5 = this.b;
        if (r5 == null) goto L11;
        UndeliveredElementException r6 = OnUndeliveredElementKt.c(r5, r2, null);
        if (r6 == null) goto L11;
        ExceptionsKt.addSuppressed(r6, p());
        throw r6;
    L11:
        throw p();
    L13:
        return Unit.INSTANCE;
    }

    public i(int r3, BufferOverflow r4, Function1<? super E, Unit> r5) {
        super(r3, r5);
        this.m = r4;
        boolean r0 = false;
        if (r4 == BufferOverflow.SUSPEND) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L14;
        if (r3 < 1) goto L9;
        r0 = true;
    L9:
        if (r0 == false) goto L12;
        return;
    L12:
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + r3 + " was specified").toString());
    L14:
        throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(BufferedChannel.class).getSimpleName() + " instead").toString());
    L5:
        r6 = false;
        goto L6
    }
}
