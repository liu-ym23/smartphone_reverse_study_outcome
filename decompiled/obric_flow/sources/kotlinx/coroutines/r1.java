package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
public class r1 implements Job, q, x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18988a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18989b = null;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    static {
        f18988a = AtomicReferenceFieldUpdater.newUpdater(r1.class, Object.class, "_state$volatile");
        f18989b = AtomicReferenceFieldUpdater.newUpdater(r1.class, Object.class, "_parentHandle$volatile");
    }

    public r1(boolean r5) {
        if (r5 == false) goto L5;
        v0 r10 = j0.f18970j;
    L6:
        this._state$volatile = r10;
        return;
    L5:
        r10 = j0.f18969i;
        goto L6
    }

    public static p Q(kotlinx.coroutines.internal.j r5) {
    L3:
        if (r5.g() == false) goto L12;
        kotlinx.coroutines.internal.j r10 = r5.d();
        if (r10 == null) goto L6;
        r5 = r10;
        goto L3
    L6:
        AtomicReferenceFieldUpdater r11 = kotlinx.coroutines.internal.j.f18938b;
        Object r12 = r11.get(r5);
    L7:
        r5 = (kotlinx.coroutines.internal.j) r12;
        if (r5.g() == false) goto L3;
        r12 = r11.get(r5);
    L12:
        r5 = r5.f();
        if (r5.g() == true) goto L12;
        if ((r5 instanceof p) == true) goto L17;
        if ((r5 instanceof u1) == false) goto L12;
        return null;
    L17:
        return (p) r5;
    }

    public static String X(Object r5) {
        if ((r5 instanceof p1) == false) goto L11;
        p1 r10 = (p1) r5;
        if (r10.d() == false) goto L8;
        return "Cancelling";
    L8:
        if (p1.f18984b.get(r10) == 0) goto L22;
        return "Completing";
    L22:
        return "Active";
    L11:
        if ((r5 instanceof g1) == false) goto L17;
        if (((g1) r5).isActive() == true) goto L26;
        return "New";
    L26:
        return "Active";
    L17:
        if ((r5 instanceof v) == false) goto L19;
        return "Cancelled";
    L19:
        return "Completed";
    }

    public static CancellationException Y(r1 r5, Throwable r10) {
        r5.getClass();
        if ((r10 instanceof CancellationException) == false) goto L5;
        CancellationException r11 = (CancellationException) r10;
    L6:
        if (r11 == null) goto L8;
        return r11;
    L8:
        return new JobCancellationException(r5.z(), r10, r5);
    L5:
        r11 = null;
        goto L6
    }

    public boolean A(Throwable r5) {
        if ((r5 instanceof CancellationException) == false) goto L6;
        return true;
    L6:
        if (w(r5) == true) goto L8;
    L10:
        return false;
    L8:
        if (F() == false) goto L10;
        return true;
    }

    public final void B(g1 r10, Object r11) {
        AtomicReferenceFieldUpdater r5 = f18989b;
        o r12 = (o) r5.get(this);
        if (r12 == null) goto L5;
        r12.dispose();
        r5.set(this, v1.f19027a);
    L5:
        CompletionHandlerException r13 = null;
        if ((r11 instanceof v) == false) goto L8;
        v r14 = (v) r11;
    L9:
        if (r14 == null) goto L11;
        Throwable r15 = r14.f19025a;
    L13:
        if ((r10 instanceof m1) == true) goto L35;
        u1 r16 = r10.b();
        if (r16 == null) goto L45;
        r16.c(new kotlinx.coroutines.internal.h(1), 1);
        Object r17 = kotlinx.coroutines.internal.j.f18937a.get(r16);
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        kotlinx.coroutines.internal.j r18 = (kotlinx.coroutines.internal.j) r17;
    L22:
        if (Intrinsics.areEqual(r18, r16) == true) goto L32;
        if ((r18 instanceof m1) == false) goto L31;
        ((m1) r18).j(r15);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        if (r13 == null) goto L30;
        ExceptionsKt.addSuppressed(r13, th);
        goto L31
    L30:
        r13 = new CompletionHandlerException("Exception in completion handler " + r18 + " for " + this, th);
        Unit r19 = Unit.INSTANCE;
    L31:
        r18 = r18.f();
        goto L22
    L32:
        if (r13 == null) goto L46;
        J(r13);
        return;
    L46:
        return;
    L45:
        return;
    L35:
        ((m1) r10).j(r15);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        J(new CompletionHandlerException("Exception in completion handler " + r10 + " for " + this, th));
        return;
    L11:
        r15 = null;
        goto L13
    L8:
        r14 = null;
        goto L9
    }

    public final Throwable C(Object r5) {
        if (r5 != null) goto L4;
        boolean r10 = true;
    L5:
        CancellationException r11 = null;
        if (r10 == false) goto L10;
        Throwable r12 = (Throwable) r5;
        if (r12 == null) goto L29;
        return r12;
    L29:
        return new JobCancellationException(z(), null, this);
    L10:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        r1 r13 = (r1) ((x1) r5);
        r13.getClass();
        Object r14 = f18988a.get(r13);
        if ((r14 instanceof p1) == false) goto L14;
        Throwable r15 = ((p1) r14).c();
    L20:
        if ((r15 instanceof CancellationException) == false) goto L22;
        r11 = (CancellationException) r15;
    L22:
        if (r11 != null) goto L25;
        r11 = new JobCancellationException("Parent job is ".concat(X(r14)), r15, r13);
    L25:
        return r11;
    L14:
        if ((r14 instanceof v) == false) goto L17;
        r15 = ((v) r14).f19025a;
        goto L20
    L17:
        if ((r14 instanceof g1) == true) goto L27;
        r15 = null;
        goto L20
    L27:
        throw new IllegalStateException(("Cannot be cancelling child in this state: " + r14).toString());
    L4:
        r10 = r5 instanceof Throwable;
        goto L5
    }

    public final Object D(p1 r10, Object r11) {
        Throwable r5 = null;
        if ((r11 instanceof v) == false) goto L5;
        v r12 = (v) r11;
    L6:
        if (r12 == null) goto L8;
        r5 = r12.f19025a;
    L8:
        monitor-enter(r10);
        r10.d();     // Catch: Throwable -> L50
        ArrayList r13 = r10.e(r5);     // Catch: Throwable -> L50
        Throwable r14 = E(r10, r13);     // Catch: Throwable -> L50
        if (r14 != null) goto L12;
    L26:
        monitor-exit(r10);
        if (r14 == null) goto L33;
        if (r14 == r5) goto L33;
        r11 = new v(false, r14);
    L33:
        if (r14 != null) goto L35;
    L39:
        S(r11);
        AtomicReferenceFieldUpdater r15 = f18988a;
        if ((r11 instanceof g1) == false) goto L42;
        Object r16 = new h1((g1) r11);
    L44:
        if (r15.compareAndSet(this, r10, r16) == true) goto L48;
        if (r15.get(this) == r10) goto L44;
    L48:
        B(r10, r11);
        return r11;
    L42:
        r16 = r11;
        goto L44
    L35:
        if (y(r14) == false) goto L37;
    L38:
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
        v r17 = (v) r11;
        r17.getClass();
        v.f19024b.compareAndSet(r17, 0, 1);
        goto L39
    L37:
        if (I(r14) == false) goto L39;
    L12:
        if (r13.size() <= 1) goto L26;
        Set r18 = Collections.newSetFromMap(new IdentityHashMap(r13.size()));     // Catch: Throwable -> L50
        Iterator r19 = r13.iterator();     // Catch: Throwable -> L50
    L16:
        if (r19.hasNext() == false) goto L26;
        Throwable r20 = (Throwable) r19.next();     // Catch: Throwable -> L50
        if (r20 == r14) goto L16;
        if (r20 == r14) goto L16;
        if ((r20 instanceof CancellationException) == true) goto L16;
        if (r18.add(r20) == false) goto L16;
        ExceptionsKt.addSuppressed(r14, r20);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;
    L5:
        r12 = null;
        goto L6
    }

    public final Throwable E(p1 r5, ArrayList r10) {
        Object r11 = null;
        if (r10.isEmpty() == true) goto L5;
        Iterator r12 = r10.iterator();
    L11:
        if (r12.hasNext() == false) goto L15;
        Object r13 = r12.next();
        if ((((Throwable) r13) instanceof CancellationException) == true) goto L11;
    L16:
        Throwable r14 = (Throwable) r13;
        if (r14 == null) goto L19;
        return r14;
    L19:
        Throwable r15 = (Throwable) r10.get(0);
        if ((r15 instanceof TimeoutCancellationException) == false) goto L32;
        Iterator r16 = r10.iterator();
    L23:
        if (r16.hasNext() == false) goto L29;
        Object r17 = r16.next();
        Throwable r18 = (Throwable) r17;
        if (r18 == r15) goto L23;
        if ((r18 instanceof TimeoutCancellationException) == false) goto L23;
        r11 = r17;
    L29:
        Throwable r19 = (Throwable) r11;
        if (r19 == null) goto L32;
        return r19;
    L32:
        return r15;
    L15:
        r13 = null;
        goto L16
    L5:
        if (r5.d() == true) goto L7;
        return null;
    L7:
        return new JobCancellationException(z(), null, this);
    }

    public boolean F() {
        return true;
    }

    public boolean G() {
        return this instanceof s;
    }

    public final u1 H(g1 r5) {
        u1 r10 = r5.b();
        if (r10 == null) goto L5;
        return r10;
    L5:
        if ((r5 instanceof v0) == false) goto L8;
        return new u1();
    L8:
        if ((r5 instanceof m1) == false) goto L11;
        V((m1) r5);
        return null;
    L11:
        throw new IllegalStateException(("State should have list: " + r5).toString());
    }

    public boolean I(Throwable r5) {
        return false;
    }

    public void J(CompletionHandlerException r5) {
        throw r5;
    }

    public final void K(Job r5) {
        v1 r10 = v1.f19027a;
        AtomicReferenceFieldUpdater r11 = f18989b;
        if (r5 != null) goto L6;
        r11.set(this, r10);
        return;
    L6:
        r5.start();
        o r12 = r5.attachChild(this);
        r11.set(this, r12);
        if (isCompleted() == false) goto L10;
        r12.dispose();
        r11.set(this, r10);
        return;
    }

    public final t0 L(boolean r10, m1 r11) {
        r11.d = this;
    L3:
        AtomicReferenceFieldUpdater r5 = f18988a;
        Object r12 = r5.get(this);
        boolean r13 = r12 instanceof v0;
        v1 r14 = v1.f19027a;
        boolean r15 = true;
        Throwable r16 = null;
        if (r13 == true) goto L5;
        if ((r12 instanceof g1) == false) goto L36;
        g1 r17 = (g1) r12;
        u1 r18 = r17.b();
        if (r18 == null) goto L18;
        if (r11.i() == true) goto L22;
        boolean r19 = r18.c(r11, 1);
    L34:
        if (r19 == false) goto L3;
    L37:
        if (r15 == false) goto L39;
        return r11;
    L39:
        if (r10 == false) goto L47;
        Object r20 = r5.get(this);
        if ((r20 instanceof v) == false) goto L43;
        v r21 = (v) r20;
    L44:
        if (r21 == null) goto L46;
        r16 = r21.f19025a;
    L46:
        r11.j(r16);
        goto L47
    L43:
        r21 = null;
    L47:
        return r14;
    L22:
        if ((r17 instanceof p1) == false) goto L24;
        p1 r22 = (p1) r17;
    L25:
        if (r22 == null) goto L27;
        Throwable r23 = r22.c();
    L28:
        if (r23 != null) goto L30;
        r19 = r18.c(r11, 5);
        goto L34
    L30:
        if (r10 == false) goto L32;
        r11.j(r23);
    L32:
        return r14;
    L27:
        r23 = null;
        goto L28
    L24:
        r22 = null;
        goto L25
    L18:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
        V((m1) r12);
        goto L3
    L36:
        r15 = false;
        goto L37
    L5:
        v0 r24 = (v0) r12;
        if (r24.f19026a == true) goto L8;
        U(r24);
    L8:
        if (r5.compareAndSet(this, r12, r11) == true) goto L37;
        if (r5.get(this) == r12) goto L8;
        goto L3
    }

    public boolean M() {
        return this instanceof f;
    }

    public final boolean N(Object r5) {
    L2:
        Object r10 = Z(f18988a.get(this), r5);
        if (r10 == j0.d) goto L4;
        if (r10 == j0.e) goto L8;
        if (r10 == j0.f) goto L2;
        t(r10);
        return true;
    L8:
        return true;
    L4:
        return false;
    }

    public final Object O(Object r5) {
    L2:
        Object r10 = Z(f18988a.get(this), r5);
        if (r10 == j0.d) goto L4;
        if (r10 == j0.f) goto L2;
        return r10;
    L4:
        String r11 = "Job " + this + " is already complete or completing, but is being completed with " + r5;
        Throwable r12 = null;
        if ((r5 instanceof v) == false) goto L7;
        v r13 = (v) r5;
    L8:
        if (r13 == null) goto L11;
        r12 = r13.f19025a;
    L11:
        throw new IllegalStateException(r11, r12);
    L7:
        r13 = null;
        goto L8
    }

    public String P() {
        return getClass().getSimpleName();
    }

    public final void R(u1 r10, Throwable r11) {
        r10.c(new kotlinx.coroutines.internal.h(4), 4);
        Object r5 = kotlinx.coroutines.internal.j.f18937a.get(r10);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        kotlinx.coroutines.internal.j r12 = (kotlinx.coroutines.internal.j) r5;
        CompletionHandlerException r13 = null;
    L4:
        if (Intrinsics.areEqual(r12, r10) == true) goto L16;
        if ((r12 instanceof m1) == false) goto L15;
        if (((m1) r12).i() == false) goto L15;
        ((m1) r12).j(r11);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (r13 == null) goto L14;
        ExceptionsKt.addSuppressed(r13, th);
        goto L15
    L14:
        r13 = new CompletionHandlerException("Exception in completion handler " + r12 + " for " + this, th);
        Unit r14 = Unit.INSTANCE;
    L15:
        r12 = r12.f();
        goto L4
    L16:
        if (r13 == null) goto L18;
        J(r13);
    L18:
        y(r11);
    }

    public void S(Object r5) {
    }

    public void T() {
    }

    public final void U(v0 r5) {
        u1 r10 = new u1();
        Object r11 = r10;
        if (r5.f19026a == true) goto L6;
        r11 = new f1(r10);
    L6:
        AtomicReferenceFieldUpdater r12 = f18988a;
        if (r12.compareAndSet(this, r5, r11) == true) goto L11;
        if (r12.get(this) == r5) goto L6;
        return;
    }

    public final void V(m1 r5) {
        u1 r10 = new u1();
        r5.getClass();
        kotlinx.coroutines.internal.j.f18938b.set(r10, r5);
        AtomicReferenceFieldUpdater r11 = kotlinx.coroutines.internal.j.f18937a;
        r11.set(r10, r5);
    L4:
        if (r11.get(r5) != r5) goto L9;
    L7:
        if (r11.compareAndSet(r5, r5, r10) == true) goto L8;
        if (r11.get(r5) == r5) goto L7;
    L8:
        r10.e(r5);
    L9:
        kotlinx.coroutines.internal.j r12 = r5.f();
    L10:
        AtomicReferenceFieldUpdater r13 = f18988a;
        if (r13.compareAndSet(this, r5, r12) == true) goto L15;
        if (r13.get(this) == r5) goto L10;
        return;
    }

    public final int W(Object r10) {
        boolean r5 = r10 instanceof v0;
        AtomicReferenceFieldUpdater r11 = f18988a;
        if (r5 == false) goto L16;
        if (((v0) r10).f19026a == false) goto L7;
        return 0;
    L7:
        v0 r12 = j0.f18970j;
    L9:
        if (r11.compareAndSet(this, r10, r12) == true) goto L10;
        if (r11.get(this) == r10) goto L9;
        return -1;
    L10:
        T();
        return 1;
    L16:
        if ((r10 instanceof f1) == false) goto L25;
        u1 r13 = ((f1) r10).f18825a;
    L19:
        if (r11.compareAndSet(this, r10, r13) == true) goto L20;
        if (r11.get(this) == r10) goto L19;
        return -1;
    L20:
        T();
        return 1;
    L25:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final Object Z(Object r10, Object r11) {
        if ((r10 instanceof g1) == true) goto L7;
        return j0.d;
    L7:
        if ((r10 instanceof v0) == true) goto L11;
        if ((r10 instanceof m1) == true) goto L11;
    L26:
        g1 r12 = (g1) r10;
        u1 r5 = H(r12);
        if (r5 == null) goto L93;
        ?? r13 = 0;
        if ((r12 instanceof p1) == false) goto L32;
        p1 r14 = (p1) r12;
    L33:
        if (r14 != null) goto L35;
        r14 = new p1(r5, null);
    L35:
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        monitor-enter(r14);
        AtomicIntegerFieldUpdater r16 = p1.f18984b;     // Catch: Throwable -> L59
        if (r16.get(r14) == 0) goto L40;
        boolean r17 = true;
    L41:
        if (r17 == false) goto L45;
        g8.g r18 = j0.d;     // Catch: Throwable -> L59
        monitor-exit(r14);
        return r18;
    L45:
        r16.set(r14, 1);     // Catch: Throwable -> L59
        if (r14 == r12) goto L56;
        AtomicReferenceFieldUpdater r19 = f18988a;     // Catch: Throwable -> L59
    L49:
        if (r19.compareAndSet(this, r12, r14) == true) goto L56;
        if (r19.get(this) == r12) goto L49;
        g8.g r20 = j0.f;     // Catch: Throwable -> L59
        monitor-exit(r14);
        return r20;
    L56:
        boolean r21 = r14.d();     // Catch: Throwable -> L59
        if ((r11 instanceof v) == false) goto L61;
        v r22 = (v) r11;     // Catch: Throwable -> L59
    L62:
        if (r22 == null) goto L64;
        r14.a(r22.f19025a);     // Catch: Throwable -> L59
    L64:
        Throwable r23 = r14.c();     // Catch: Throwable -> L59
        if (r21 == true) goto L67;
        r13 = r23;
    L67:
        r15.element = r13;     // Catch: Throwable -> L59
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L59
        monitor-exit(r14);
        if (r13 == 0) goto L71;
        R(r5, r13);
    L71:
        p r25 = Q(r5);
        if (r25 != null) goto L74;
    L76:
        r5.c(new kotlinx.coroutines.internal.h(2), 2);
        p r26 = Q(r5);
        if (r26 == null) goto L82;
        if (a0(r14, r26, r11) == false) goto L82;
        return j0.e;
    L82:
        return D(r14, r11);
    L74:
        if (a0(r14, r25, r11) == false) goto L76;
        return j0.e;
    L61:
        r22 = null;
        goto L62
    L40:
        r17 = false;
    L59:
        th = move-exception;
        throw th;
    L32:
        r14 = null;
        goto L33
    L93:
        return j0.f;
    L11:
        if ((r10 instanceof p) == true) goto L26;
        if ((r11 instanceof v) == true) goto L26;
        g1 r27 = (g1) r10;
        if ((r11 instanceof g1) == false) goto L17;
        Object r28 = new h1((g1) r11);
    L18:
        AtomicReferenceFieldUpdater r29 = f18988a;
        if (r29.compareAndSet(this, r27, r28) == true) goto L20;
        if (r29.get(this) == r27) goto L18;
        return j0.f;
    L20:
        S(r11);
        B(r27, r11);
        return r11;
    L17:
        r28 = r11;
        goto L18
    }

    public final boolean a0(p1 r5, p r10, Object r11) {
    L2:
        o1 r12 = new o1(this, r5, r10, r11);
        q r13 = r10.e;
        if ((r13 instanceof r1) == false) goto L5;
        t0 r14 = ((r1) r13).L(false, r12);
    L7:
        if (r14 != v1.f19027a) goto L8;
        r10 = Q(r10);
        if (r10 != null) goto L2;
        return false;
    L8:
        return true;
    L5:
        r1 r15 = (r1) r13;
        r14 = r15.invokeOnCompletion(false, false, new JobKt__JobKt$invokeOnCompletion$1(r12));
        goto L7
    }

    @Override // kotlinx.coroutines.Job
    public final o attachChild(q r10) {
        p r5 = new p(r10);
        r5.d = this;
    L3:
        AtomicReferenceFieldUpdater r11 = f18988a;
        Object r12 = r11.get(this);
        if ((r12 instanceof v0) == true) goto L5;
        boolean r13 = r12 instanceof g1;
        v1 r14 = v1.f19027a;
        Throwable r15 = null;
        if (r13 == false) goto L35;
        u1 r16 = ((g1) r12).b();
        if (r16 != null) goto L20;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
        V((m1) r12);
        goto L3
    L20:
        if (r16.c(r5, 7) == true) goto L33;
        boolean r17 = r16.c(r5, 3);
        Object r18 = r11.get(this);
        if ((r18 instanceof p1) == false) goto L26;
        r15 = ((p1) r18).c();
    L31:
        r5.j(r15);
        if (r17 == true) goto L33;
        return r14;
    L26:
        if ((r18 instanceof v) == false) goto L28;
        v r19 = (v) r18;
    L29:
        if (r19 == null) goto L31;
        r15 = r19.f19025a;
        goto L31
    L28:
        r19 = null;
    L33:
        return r5;
    L35:
        Object r20 = r11.get(this);
        if ((r20 instanceof v) == false) goto L38;
        v r21 = (v) r20;
    L39:
        if (r21 == null) goto L41;
        r15 = r21.f19025a;
    L41:
        r5.j(r15);
        return r14;
    L38:
        r21 = null;
        goto L39
    L5:
        v0 r22 = (v0) r12;
        if (r22.f19026a == true) goto L8;
        U(r22);
    L8:
        if (r11.compareAndSet(this, r12, r5) == true) goto L33;
        if (r11.get(this) == r12) goto L8;
        goto L3
    }

    public Object b() {
        Object r5 = f18988a.get(this);
        if ((r5 instanceof g1) == true) goto L11;
        if ((r5 instanceof v) == true) goto L9;
        return j0.k(r5);
    L9:
        throw ((v) r5).f19025a;
    L11:
        throw new IllegalStateException("This job has not completed yet");
    }

    @Override // kotlinx.coroutines.Job
    public /* synthetic */ void cancel() {
        cancel(null);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final Object fold(Object r5, Function2 r10) {
        return CoroutineContext.Element.DefaultImpls.fold(this, r5, r10);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key r5) {
        return CoroutineContext.Element.DefaultImpls.get(this, r5);
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        Object r5 = f18988a.get(this);
        CancellationException r10 = null;
        if ((r5 instanceof p1) == false) goto L17;
        Throwable r11 = ((p1) r5).c();
        if (r11 == null) goto L15;
        String r12 = getClass().getSimpleName().concat(" is cancelling");
        if ((r11 instanceof CancellationException) == false) goto L9;
        r10 = (CancellationException) r11;
    L9:
        if (r10 == null) goto L11;
        return r10;
    L11:
        if (r12 != null) goto L26;
        r12 = z();
    L26:
        return new JobCancellationException(r12, r11, this);
    L15:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    L17:
        if ((r5 instanceof g1) == true) goto L24;
        if ((r5 instanceof v) == false) goto L22;
        return Y(this, ((v) r5).f19025a);
    L22:
        return new JobCancellationException(getClass().getSimpleName().concat(" has completed normally"), null, this);
    L24:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // kotlinx.coroutines.Job
    public final Sequence getChildren() {
        return SequencesKt.sequence(new JobSupport$children$1(this, null));
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return Job.Key;
    }

    @Override // kotlinx.coroutines.Job
    public final kotlinx.coroutines.selects.d getOnJoin() {
        JobSupport$onJoin$1 r5 = JobSupport$onJoin$1.INSTANCE;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        return new q7.a(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r5, 3));
    }

    @Override // kotlinx.coroutines.Job
    public final Job getParent() {
        o r5 = (o) f18989b.get(this);
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getParent();
    }

    @Override // kotlinx.coroutines.Job
    public final t0 invokeOnCompletion(Function1 r5) {
        return L(true, new u0(r5, 1));
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object r5 = f18988a.get(this);
        if ((r5 instanceof g1) == true) goto L5;
    L7:
        return false;
    L5:
        if (((g1) r5).isActive() == false) goto L7;
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object r5 = f18988a.get(this);
        if ((r5 instanceof v) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r5 instanceof p1) == true) goto L7;
    L9:
        return false;
    L7:
        if (((p1) r5).d() == false) goto L9;
        goto L9
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(f18988a.get(this) instanceof g1);
    }

    @Override // kotlinx.coroutines.Job
    public final Object join(Continuation r5) {
    L2:
        Object r10 = f18988a.get(this);
        if ((r10 instanceof g1) == false) goto L4;
        if (W(r10) < 0) goto L2;
        l r11 = new l(1, IntrinsicsKt.intercepted(r5));
        r11.w();
        r11.z(new h(j0.i(this, new n(r11, 1)), 2));
        Object r12 = r11.v();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L12:
        if (r12 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        r12 = Unit.INSTANCE;
    L16:
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        return r12;
    L19:
        return Unit.INSTANCE;
    L4:
        j0.e(r5.getContext());
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key r5) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, r5);
    }

    @Override // kotlinx.coroutines.Job
    public final Job plus(Job r5) {
        return r5;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
    L2:
        int r5 = W(f18988a.get(this));
        if (r5 == 0) goto L8;
        if (r5 != 1) goto L2;
        return true;
    L8:
        return false;
    }

    public void t(Object r5) {
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(P() + '{' + X(f18988a.get(this)) + '}');
        r5.append('@');
        r5.append(j0.f(this));
        return r5.toString();
    }

    public void u(Object r5) {
        t(r5);
    }

    public final Object v(Continuation r5) {
    L2:
        Object r10 = f18988a.get(this);
        if ((r10 instanceof g1) == false) goto L5;
        if (W(r10) < 0) goto L2;
        n1 r11 = new n1(this, IntrinsicsKt.intercepted(r5));
        r11.w();
        r11.z(new h(j0.i(this, new u0(r11, 2)), 2));
        Object r12 = r11.v();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L15:
        return r12;
    L5:
        if ((r10 instanceof v) == true) goto L9;
        return j0.k(r10);
    L9:
        throw ((v) r10).f19025a;
    }

    public final boolean w(Object r10) {
        Object r5 = j0.d;
        if (G() == false) goto L19;
    L4:
        Object r11 = f18988a.get(this);
        if ((r11 instanceof g1) == false) goto L14;
        if ((r11 instanceof p1) == false) goto L11;
        p1 r12 = (p1) r11;
        r12.getClass();
        if (p1.f18984b.get(r12) != 0) goto L14;
    L11:
        r5 = Z(r11, new v(false, C(r10)));
        if (r5 == j0.f) goto L4;
    L16:
        if (r5 != j0.e) goto L19;
        return true;
    L14:
        r5 = j0.d;
    L19:
        if (r5 != j0.d) goto L74;
        Throwable r13 = null;
        Throwable r14 = null;
    L21:
        Object r15 = f18988a.get(this);
        if ((r15 instanceof p1) == true) goto L23;
        if ((r15 instanceof g1) == false) goto L72;
        if (r14 != null) goto L53;
        r14 = C(r10);
    L53:
        g1 r16 = (g1) r15;
        if (r16.isActive() == true) goto L55;
        Object r17 = Z(r15, new v(false, r14));
        if (r17 == j0.d) goto L71;
        if (r17 == j0.f) goto L21;
        r5 = r17;
        goto L74
    L71:
        throw new IllegalStateException(("Cannot happen in " + r15).toString());
    L55:
        u1 r18 = H(r16);
        if (r18 == null) goto L21;
        p1 r19 = new p1(r18, r14);
    L59:
        AtomicReferenceFieldUpdater r20 = f18988a;
        if (r20.compareAndSet(this, r16, r19) == true) goto L61;
        if (r20.get(this) == r16) goto L59;
    L61:
        R(r18, r14);
        g8.g r110 = j0.d;
    L31:
        r5 = r110;
        goto L74
    L72:
        r110 = j0.g;
        goto L31
    L23:
        monitor-enter(r15);
        p1 r21 = (p1) r15;     // Catch: Throwable -> L37
        r21.getClass();     // Catch: Throwable -> L37
        if (p1.d.get(r21) != j0.f18968h) goto L27;
        boolean r22 = true;
    L28:
        if (r22 == false) goto L32;
        r110 = j0.g;     // Catch: Throwable -> L37
        monitor-exit(r15);
        goto L31
    L32:
        boolean r23 = ((p1) r15).d();     // Catch: Throwable -> L37
        if (r10 != null) goto L35;
        if (r23 == false) goto L35;
    L40:
        Throwable r111 = ((p1) r15).c();     // Catch: Throwable -> L37
        if (r23 == true) goto L43;
        r13 = r111;
    L43:
        monitor-exit(r15);
        if (r13 == null) goto L46;
        R(((p1) r15).f18986a, r13);
    L46:
        r110 = j0.d;
    L35:
        if (r14 != null) goto L39;
        r14 = C(r10);     // Catch: Throwable -> L37
    L39:
        ((p1) r15).a(r14);     // Catch: Throwable -> L37
        goto L40
    L27:
        r22 = false;
    L37:
        th = move-exception;
        throw th;
    L74:
        if (r5 != j0.d) goto L77;
    L83:
        return true;
    L77:
        if (r5 == j0.e) goto L83;
        if (r5 == j0.g) goto L102;
        t(r5);
        goto L83
    L102:
        return false;
    }

    public void x(CancellationException r5) {
        w(r5);
    }

    public final boolean y(Throwable r5) {
        if (M() == false) goto L5;
        return true;
    L5:
        boolean r10 = r5 instanceof CancellationException;
        o r11 = (o) f18989b.get(this);
        if (r11 != null) goto L8;
    L16:
        return r10;
    L8:
        if (r11 == v1.f19027a) goto L16;
        if (r11.a(r5) == true) goto L17;
        if (r10 == true) goto L18;
        return false;
    L18:
        return true;
    L17:
        return true;
    }

    public String z() {
        return "Job was cancelled";
    }

    @Override // kotlinx.coroutines.Job
    public /* synthetic */ boolean cancel(Throwable r5) {
        if (r5 == null) goto L4;
        CancellationException r10 = Y(this, r5);
    L5:
        x(r10);
        return true;
    L4:
        r10 = new JobCancellationException(z(), null, this);
        goto L5
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext r5) {
        return CoroutineContext.Element.DefaultImpls.plus(this, r5);
    }

    @Override // kotlinx.coroutines.Job
    public final t0 invokeOnCompletion(boolean r5, boolean r10, Function1 r11) {
        if (r5 == false) goto L4;
        m1 r12 = new j1(r11);
    L6:
        return L(r10, r12);
    L4:
        r12 = new u0(r11, 1);
        goto L6
    }

    @Override // kotlinx.coroutines.Job, kotlinx.coroutines.channels.w
    public void cancel(CancellationException r5) {
        if (r5 != null) goto L4;
        r5 = new JobCancellationException(z(), null, this);
    L4:
        x(r5);
    }
}
