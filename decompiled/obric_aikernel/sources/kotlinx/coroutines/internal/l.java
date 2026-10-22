package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.s2;
import kotlinx.coroutines.w0;

/* JADX INFO: loaded from: classes3.dex */
@PublishedApi
@SourceDebugExtension({"SMAP\nDispatchedContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,317:1\n243#1,8:381\n255#1:389\n256#1,2:400\n258#1:404\n1#2:318\n1#2:324\n1#2:365\n297#3,5:319\n302#3,12:325\n314#3:359\n297#3,5:360\n302#3,12:366\n314#3:419\n200#4,3:337\n203#4,14:345\n200#4,3:378\n203#4,14:405\n95#5,5:340\n107#5,10:390\n118#5,2:402\n107#5,13:420\n*S KotlinDebug\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n*L\n224#1:381,8\n225#1:389\n225#1:400,2\n225#1:404\n202#1:324\n223#1:365\n202#1:319,5\n202#1:325,12\n202#1:359\n223#1:360,5\n223#1:366,12\n223#1:419\n202#1:337,3\n202#1:345,14\n223#1:378,3\n223#1:405,14\n203#1:340,5\n225#1:390,10\n225#1:402,2\n255#1:420,13\n*E\n"})
public final class l<T> extends w0<T> implements CoroutineStackFrame, Continuation<T> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10558m = null;

    @Volatile
    private volatile Object _reusableCancellableContinuation;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @JvmField
    public final CoroutineDispatcher f10559i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @JvmField
    public final Continuation<T> f10560j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @JvmField
    public Object f10561k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @JvmField
    public final Object f10562l;

    static {
        f10558m = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_reusableCancellableContinuation");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(CoroutineDispatcher r10, Continuation<? super T> r11) {
        super(-1);
        this.f10559i = r10;
        this.f10560j = r11;
        this.f10561k = m.a();
        this.f10562l = ThreadContextKt.b(getContext());
    }

    private final kotlinx.coroutines.o<?> p() {
        Object r10 = f10558m.get(this);
        if ((r10 instanceof kotlinx.coroutines.o) == true) goto L7;
        return null;
    L7:
        return (kotlinx.coroutines.o) r10;
    }

    @Override // kotlinx.coroutines.w0
    public void b(Object r10, Throwable r11) {
        if ((r10 instanceof kotlinx.coroutines.c0) == false) goto L6;
        ((kotlinx.coroutines.c0) r10).f10249b.invoke(r11);
        return;
    }

    @Override // kotlinx.coroutines.w0
    public Continuation<T> d() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> r10 = this.f10560j;
        if ((r10 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r10;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f10560j.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.w0
    public Object i() {
        Object r10 = this.f10561k;
        if (kotlinx.coroutines.n0.a() == true) goto L5;
    L12:
        this.f10561k = m.a();
        return r10;
    L5:
        if (r10 == m.a()) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == true) goto L12;
        throw new AssertionError();
    L7:
        r11 = false;
        goto L8
    }

    public final void l() {
        AtomicReferenceFieldUpdater r10 = f10558m;
    L4:
        if (r10.get(this) == m.f10564b) goto L4;
    }

    public final kotlinx.coroutines.o<T> n() {
        AtomicReferenceFieldUpdater r10 = f10558m;
    L3:
        Object r11 = r10.get(this);
        if (r11 == null) goto L5;
        if ((r11 instanceof kotlinx.coroutines.o) == true) goto L10;
        if (r11 == m.f10564b) goto L3;
        if ((r11 instanceof Throwable) == true) goto L3;
        throw new IllegalStateException(("Inconsistent state " + r11).toString());
    L10:
        if (f10558m.compareAndSet(this, r11, m.f10564b) == false) goto L3;
        return (kotlinx.coroutines.o) r11;
    L5:
        f10558m.set(this, m.f10564b);
        return null;
    }

    public final void o(CoroutineContext r10, T r11) {
        this.f10561k = r11;
        this.f10728h = 1;
        this.f10559i.dispatchYield(r10, this);
    }

    public final boolean r() {
        if (f10558m.get(this) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r10) {
        CoroutineContext r11 = this.f10560j.getContext();
        Object r12 = kotlinx.coroutines.e0.d(r10, null, 1, null);
        if (this.f10559i.isDispatchNeeded(r11) == false) goto L5;
        this.f10561k = r12;
        this.f10728h = 0;
        this.f10559i.dispatch(r11, this);
        return;
    L5:
        kotlinx.coroutines.n0.a();
        f1 r13 = s2.f10631a.b();
        if (r13.j0() == false) goto L8;
        this.f10561k = r12;
        this.f10728h = 0;
        r13.f0(this);
        return;
    L8:
        r13.h0(true);
        CoroutineContext r14 = getContext();     // Catch: Throwable -> L18
        Object r15 = ThreadContextKt.c(r14, this.f10562l);     // Catch: Throwable -> L18
        this.f10560j.resumeWith(r10);     // Catch: Throwable -> L15
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L15
        ThreadContextKt.a(r14, r15);     // Catch: Throwable -> L18
    L13:
        if (r13.m0() == true) goto L13;
    L20:
        r13.c0(true);
        return;
    L15:
        th = move-exception;
        ThreadContextKt.a(r14, r15);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        g(th, null);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r13.c0(true);
        throw th;
    }

    public final boolean s(Throwable r10) {
        AtomicReferenceFieldUpdater r11 = f10558m;
    L3:
        Object r12 = r11.get(this);
        i0 r13 = m.f10564b;
        if (Intrinsics.areEqual(r12, r13) == true) goto L6;
        if ((r12 instanceof Throwable) == true) goto L10;
        if (f10558m.compareAndSet(this, r12, null) == false) goto L3;
        return false;
    L10:
        return true;
    L6:
        if (f10558m.compareAndSet(this, r13, r10) == false) goto L3;
        return true;
    }

    public final void t() {
        l();
        kotlinx.coroutines.o<?> r10 = p();
        if (r10 == null) goto L6;
        r10.s();
        return;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f10559i + ", " + kotlinx.coroutines.o0.c(this.f10560j) + ']';
    }

    public final Throwable w(kotlinx.coroutines.n<?> r10) {
        AtomicReferenceFieldUpdater r11 = f10558m;
    L3:
        Object r12 = r11.get(this);
        i0 r13 = m.f10564b;
        if (r12 != r13) goto L9;
        if (f10558m.compareAndSet(this, r13, r10) == false) goto L3;
        return null;
    L9:
        if ((r12 instanceof Throwable) == false) goto L17;
        if (f10558m.compareAndSet(this, r12, null) == false) goto L15;
        return (Throwable) r12;
    L15:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L17:
        throw new IllegalStateException(("Inconsistent state " + r12).toString());
    }
}
