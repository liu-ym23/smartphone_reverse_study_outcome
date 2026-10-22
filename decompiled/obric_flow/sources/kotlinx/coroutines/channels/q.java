package kotlinx.coroutines.channels;

import ai.j0;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.i2;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final BufferOverflow f18816m;

    public q(int r5, BufferOverflow r10, Function1 r11) {
        super(r5, r11);
        this.f18816m = r10;
        if (r10 == BufferOverflow.SUSPEND) goto L10;
        if (r5 < 1) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(j0.h(r5, "Buffered channel capacity must be at least 1, but ", " was specified").toString());
    L10:
        throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(f.class).getSimpleName() + " instead").toString());
    }

    @Override // kotlinx.coroutines.channels.f
    public final boolean C() {
        if (this.f18816m != BufferOverflow.DROP_OLDEST) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlinx.coroutines.channels.f
    public final void I(kotlinx.coroutines.selects.g r5, Object r10) {
        Object r11 = P(r10, false);
        if ((r11 instanceof m) == true) goto L7;
        Unit r12 = (Unit) r11;
        r5.c(Unit.INSTANCE);
        return;
    L7:
        if ((r11 instanceof l) == false) goto L11;
        n.a(r11);
        r5.c(g.f18804l);
        return;
    L11:
        throw new IllegalStateException("unreachable");
    }

    public final Object P(Object r19, boolean r20) {
        i2 r10 = null;
        if (this.f18816m != BufferOverflow.DROP_LATEST) goto L17;
        Object r5 = super.g(r19);
        if ((r5 instanceof m) == true) goto L7;
        return r5;
    L7:
        if ((r5 instanceof l) == true) goto L76;
        if (r20 == false) goto L72;
        Function1 r11 = this.f18795b;
        if (r11 == null) goto L72;
        UndeliveredElementException r12 = kotlinx.coroutines.internal.f.b(r11, r19, null);
        if (r12 == null) goto L72;
        throw r12;
    L72:
        return Unit.INSTANCE;
    L76:
        return r5;
    L17:
        oo.c r13 = g.d;
        o r14 = (o) f.f18789h.get(this);
    L18:
        long r15 = f.d.getAndIncrement(this);
        long r16 = r15 & 1152921504606846975L;
        boolean r17 = z(r15, false);
        long r18 = g.f18798b;
        long r21 = r16 / r18;
        int r110 = (int) (r16 % r18);
        if (r14.f18950c == r21) goto L26;
        o r22 = f.b(this, r21, r14);
        if (r22 == null) goto L22;
        o r23 = r22;
    L27:
        o r24 = r23;
        int r25 = f.k(this, r23, r110, r19, r16, r13, r17);
        if (r25 == 0) goto L58;
        if (r25 == 1) goto L75;
        if (r25 == 2) goto L48;
        if (r25 == 3) goto L47;
        if (r25 == 4) goto L43;
        if (r25 != 5) goto L41;
        r24.a();
    L41:
        r14 = r24;
        goto L18
    L43:
        if (r16 >= f.e.get(this)) goto L45;
        r24.a();
    L45:
        l r26 = new l(w());
    L73:
        return r26;
    L47:
        throw new IllegalStateException("unexpected");
    L48:
        if (r17 == false) goto L51;
        r24.i();
        r26 = new l(w());
        goto L73
    L51:
        if ((r13 instanceof i2) == false) goto L54;
        r10 = (i2) r13;
    L54:
        if (r10 == null) goto L56;
        f.d(this, r10, r24, r110);
    L56:
        q((r24.f18950c * r18) + ((long) r110));
        return Unit.INSTANCE;
    L75:
        return Unit.INSTANCE;
    L58:
        r24.a();
        goto L75
    L22:
        if (r17 == false) goto L18;
        r26 = new l(w());
        goto L73
    L26:
        r23 = r14;
        goto L27
    }

    @Override // kotlinx.coroutines.channels.f, kotlinx.coroutines.channels.x
    public final Object g(Object r5) {
        return P(r5, false);
    }

    @Override // kotlinx.coroutines.channels.f, kotlinx.coroutines.channels.x
    public final Object r(Object r5, Continuation r10) {
        Object r11 = P(r5, true);
        if ((r11 instanceof l) == false) goto L13;
        n.a(r11);
        Function1 r12 = this.f18795b;
        if (r12 == null) goto L11;
        UndeliveredElementException r13 = kotlinx.coroutines.internal.f.b(r12, r5, null);
        if (r13 == null) goto L11;
        ExceptionsKt.addSuppressed(r13, w());
        throw r13;
    L11:
        throw w();
    L13:
        return Unit.INSTANCE;
    }
}
