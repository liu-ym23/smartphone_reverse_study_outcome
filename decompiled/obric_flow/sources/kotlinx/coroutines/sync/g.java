package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i2;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k;

/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f19015b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f19016c = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = null;
    public static final /* synthetic */ AtomicLongFieldUpdater e = null;
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = null;
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f19017a;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    static {
        f19015b = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "head$volatile");
        f19016c = AtomicLongFieldUpdater.newUpdater(g.class, "deqIdx$volatile");
        d = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "tail$volatile");
        e = AtomicLongFieldUpdater.newUpdater(g.class, "enqIdx$volatile");
        f = AtomicIntegerFieldUpdater.newUpdater(g.class, "_availablePermits$volatile");
    }

    public g(int r10) {
        if (r10 < 0) goto L9;
        if (r10 > 1) goto L9;
        i r5 = new i(0, null, 2);
        this.head$volatile = r5;
        this.tail$volatile = r5;
        this._availablePermits$volatile = 1 - r10;
        this.f19017a = new k(this, 2);
        return;
    L9:
        throw new IllegalArgumentException("The number of acquired permits should be in 0..1".toString());
    }

    public final boolean a(i2 r15) {
        AtomicReferenceFieldUpdater r5 = d;
        i r10 = (i) r5.get(this);
        long r11 = e.getAndIncrement(this);
        SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 r12 = SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        long r13 = r11 / ((long) h.f);
    L3:
        Object r14 = kotlinx.coroutines.internal.a.a(r10, r13, r12);
        if (kotlinx.coroutines.internal.f.f(r14) == true) goto L22;
        s r16 = kotlinx.coroutines.internal.f.d(r14);
    L6:
        s r17 = (s) r5.get(this);
        if (r17.f18950c >= r16.f18950c) goto L22;
        if (r16.j() == false) goto L3;
    L13:
        if (r5.compareAndSet(this, r17, r16) == true) goto L15;
        if (r5.get(this) == r17) goto L13;
        if (r16.f() == false) goto L6;
        r16.e();
        goto L6
    L15:
        if (r17.f() == false) goto L22;
        r17.e();
    L22:
        i r18 = (i) kotlinx.coroutines.internal.f.d(r14);
        int r19 = (int) (r11 % ((long) h.f));
        AtomicReferenceArray r20 = r18.e;
    L24:
        if (r20.compareAndSet(r19, null, r15) == true) goto L25;
        if (r20.get(r19) == null) goto L24;
        g8.g r21 = h.f19019b;
        g8.g r22 = h.f19020c;
    L31:
        if (r20.compareAndSet(r19, r21, r22) == true) goto L33;
        if (r20.get(r19) == r21) goto L31;
        return false;
    L33:
        if ((r15 instanceof j) == false) goto L36;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        ((j) r15).k(Unit.INSTANCE, this.f19017a);
    L38:
        return true;
    L36:
        if ((r15 instanceof kotlinx.coroutines.selects.g) == false) goto L40;
        ((kotlinx.coroutines.selects.g) r15).c(Unit.INSTANCE);
        goto L38
    L40:
        throw new IllegalStateException(("unexpected: " + r15).toString());
    L25:
        r15.a(r18, r19);
        return true;
    }

    public final void b() {
    L2:
        AtomicIntegerFieldUpdater r5 = f;
        int r10 = r5.getAndIncrement(this);
        boolean r11 = true;
        if (r10 >= 1) goto L59;
        if (r10 >= 0) goto L5;
        AtomicReferenceFieldUpdater r12 = f19015b;
        i r13 = (i) r12.get(this);
        long r14 = f19016c.getAndIncrement(this);
        long r15 = r14 / ((long) h.f);
        SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 r16 = SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
    L7:
        Object r17 = kotlinx.coroutines.internal.a.a(r13, r15, r16);
        if (kotlinx.coroutines.internal.f.f(r17) == true) goto L26;
        s r18 = kotlinx.coroutines.internal.f.d(r17);
    L10:
        s r19 = (s) r12.get(this);
        if (r19.f18950c >= r18.f18950c) goto L26;
        if (r18.j() == false) goto L7;
    L17:
        if (r12.compareAndSet(this, r19, r18) == true) goto L19;
        if (r12.get(this) == r19) goto L17;
        if (r18.f() == false) goto L10;
        r18.e();
        goto L10
    L19:
        if (r19.f() == false) goto L26;
        r19.e();
    L26:
        i r20 = (i) kotlinx.coroutines.internal.f.d(r17);
        r20.a();
        boolean r21 = false;
        if (r20.f18950c <= r15) goto L29;
    L28:
        r11 = false;
    L55:
        if (r11 == false) goto L2;
        return;
    L29:
        int r22 = (int) (r14 % ((long) h.f));
        g8.g r23 = h.f19019b;
        AtomicReferenceArray r24 = r20.e;
        Object r25 = r24.getAndSet(r22, r23);
        if (r25 != null) goto L45;
        int r26 = h.f19018a;
        int r27 = 0;
    L32:
        if (r27 >= r26) goto L37;
        if (r24.get(r22) == h.f19020c) goto L55;
        r27 = r27 + 1;
        goto L32
    L37:
        g8.g r28 = h.f19019b;
        g8.g r29 = h.d;
    L39:
        if (r24.compareAndSet(r22, r28, r29) == true) goto L40;
        if (r24.get(r22) == r28) goto L39;
    L43:
        r11 = true ^ r21;
        goto L55
    L40:
        r21 = true;
        goto L43
    L45:
        if (r25 == h.e) goto L28;
        if ((r25 instanceof j) == false) goto L53;
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        j r30 = (j) r25;
        g8.g r31 = r30.c(Unit.INSTANCE, this.f19017a);
        if (r31 == null) goto L28;
        r30.s(r31);
        goto L55
    L53:
        if ((r25 instanceof kotlinx.coroutines.selects.g) == false) goto L58;
        r11 = ((kotlinx.coroutines.selects.g) r25).e(this, Unit.INSTANCE);
        goto L55
    L58:
        throw new IllegalStateException(("unexpected: " + r25).toString());
    L5:
        return;
    L59:
        int r32 = r5.get(this);
        if (r32 <= 1) goto L65;
        if (r5.compareAndSet(this, r32, 1) == false) goto L59;
    L65:
        throw new IllegalStateException("The number of released permits cannot be greater than 1".toString());
    }
}
