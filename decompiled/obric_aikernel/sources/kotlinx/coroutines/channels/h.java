package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.c3;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.i0;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/ChannelSegment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3055:1\n1#2:3056\n*E\n"})
public final class h<E> extends f0<h<E>> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final BufferedChannel<E> f10322j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicReferenceArray f10323k;

    public h(long r10, h<E> r11, BufferedChannel<E> r12, int r13) {
        super(r10, r11, r13);
        this.f10322j = r12;
        this.f10323k = new AtomicReferenceArray(BufferedChannelKt.f10293b * 2);
    }

    private final void z(int r10, Object r11) {
        this.f10323k.lazySet(r10 * 2, r11);
    }

    public final void A(int r10, Object r11) {
        this.f10323k.set((r10 * 2) + 1, r11);
    }

    public final void B(int r10, E r11) {
        z(r10, r11);
    }

    @Override // kotlinx.coroutines.internal.f0
    public int n() {
        return BufferedChannelKt.f10293b;
    }

    @Override // kotlinx.coroutines.internal.f0
    public void o(int r10, Throwable r11, CoroutineContext r12) {
        int r13 = BufferedChannelKt.f10293b;
        if (r10 < r13) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L8;
        r10 = r10 - r13;
    L8:
        E r15 = v(r10);
    L9:
        Object r16 = w(r10);
        if ((r16 instanceof c3) == true) goto L41;
        if ((r16 instanceof o) == true) goto L41;
        if (r16 == BufferedChannelKt.j()) goto L35;
        if (r16 == BufferedChannelKt.i()) goto L35;
        if (r16 == BufferedChannelKt.p()) goto L9;
        if (r16 == BufferedChannelKt.q()) goto L9;
        if (r16 != BufferedChannelKt.f()) goto L27;
        return;
    L27:
        if (r16 != BufferedChannelKt.f10295d) goto L30;
        return;
    L30:
        if (r16 != BufferedChannelKt.z()) goto L33;
        return;
    L33:
        throw new IllegalStateException(("unexpected state: " + r16).toString());
    L35:
        s(r10);
        if (r14 == false) goto L65;
        Function1<E, Unit> r17 = u().f10285g;
        if (r17 == null) goto L66;
        OnUndeliveredElementKt.b(r17, r15, r12);
        return;
    L66:
        return;
    L65:
        return;
    L41:
        if (r14 == false) goto L43;
        i0 r18 = BufferedChannelKt.j();
    L45:
        if (r(r10, r16, r18) == false) goto L9;
        s(r10);
        x(r10, !r14);
        if (r14 == false) goto L67;
        Function1<E, Unit> r19 = u().f10285g;
        if (r19 == null) goto L68;
        OnUndeliveredElementKt.b(r19, r15, r12);
        return;
    L68:
        return;
    L67:
        return;
    L43:
        r18 = BufferedChannelKt.i();
        goto L45
    L5:
        r14 = false;
        goto L6
    }

    public final boolean r(int r10, Object r11, Object r12) {
        return this.f10323k.compareAndSet((r10 * 2) + 1, r11, r12);
    }

    public final void s(int r10) {
        z(r10, null);
    }

    public final Object t(int r10, Object r11) {
        return this.f10323k.getAndSet((r10 * 2) + 1, r11);
    }

    public final BufferedChannel<E> u() {
        BufferedChannel<E> r10 = this.f10322j;
        Intrinsics.checkNotNull(r10);
        return r10;
    }

    public final E v(int r10) {
        return (E) this.f10323k.get(r10 * 2);
    }

    public final Object w(int r10) {
        return this.f10323k.get((r10 * 2) + 1);
    }

    public final void x(int r10, boolean r11) {
        if (r11 == false) goto L4;
        u().g1((this.f10550h * ((long) BufferedChannelKt.f10293b)) + ((long) r10));
    L4:
        p();
    }

    public final E y(int r10) {
        E r11 = v(r10);
        s(r10);
        return r11;
    }
}
