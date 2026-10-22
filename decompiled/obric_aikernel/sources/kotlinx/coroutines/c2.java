package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 7 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 8 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n+ 9 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n+ 10 CompletionHandler.common.kt\nkotlinx/coroutines/CompletionHandler_commonKt\n+ 11 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 12 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n+ 13 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,1454:1\n706#1,2:1461\n367#1,2:1471\n369#1,4:1476\n373#1,4:1482\n377#1,2:1489\n367#1,2:1491\n369#1,4:1496\n373#1,4:1502\n377#1,2:1509\n178#1,2:1518\n707#1:1520\n178#1,2:1521\n178#1,2:1540\n178#1,2:1555\n706#1,2:1557\n706#1,2:1559\n178#1,2:1561\n706#1,2:1563\n178#1,2:1565\n178#1,2:1572\n178#1,2:1574\n1#2:1455\n1#2:1480\n1#2:1500\n28#3,4:1456\n28#3,4:1523\n28#3,4:1567\n28#3,4:1576\n20#4:1460\n20#4:1527\n20#4:1571\n20#4:1580\n288#5,2:1463\n288#5,2:1465\n19#6:1467\n163#7:1468\n163#7:1469\n153#7,4:1583\n75#8:1470\n75#8:1481\n75#8:1501\n75#8:1514\n341#9,3:1473\n344#9,3:1486\n341#9,3:1493\n344#9,3:1506\n341#9,3:1511\n344#9,3:1515\n47#10:1528\n22#11:1529\n22#11:1530\n13#11:1551\n13#11:1554\n13#11:1581\n13#11:1582\n13#11:1587\n13#11:1588\n134#12:1531\n73#12,3:1532\n135#12,5:1535\n314#13,9:1542\n323#13,2:1552\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n250#1:1461,2\n332#1:1471,2\n332#1:1476,4\n332#1:1482,4\n332#1:1489,2\n364#1:1491,2\n364#1:1496,4\n364#1:1502,4\n364#1:1509,2\n381#1:1518,2\n426#1:1520\n461#1:1521,2\n553#1:1540,2\n594#1:1555,2\n621#1:1557,2\n630#1:1559,2\n694#1:1561,2\n723#1:1563,2\n736#1:1565,2\n809#1:1572,2\n831#1:1574,2\n332#1:1480\n364#1:1500\n213#1:1456,4\n478#1:1523,4\n739#1:1567,4\n884#1:1576,4\n213#1:1460\n478#1:1527\n739#1:1571\n884#1:1580\n261#1:1463,2\n265#1:1465,2\n273#1:1467\n279#1:1468\n281#1:1469\n1218#1:1583,4\n284#1:1470\n332#1:1481\n364#1:1501\n372#1:1514\n332#1:1473,3\n332#1:1486,3\n364#1:1493,3\n364#1:1506,3\n368#1:1511,3\n368#1:1515,3\n483#1:1528\n495#1:1529\n505#1:1530\n561#1:1551\n577#1:1554\n924#1:1581\n974#1:1582\n1237#1:1587\n1259#1:1588\n526#1:1531\n526#1:1532,3\n526#1:1535,5\n559#1:1542,9\n559#1:1552,2\n*E\n"})
public class c2 implements v1, v, k2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10251c = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10252g = null;

    @Volatile
    private volatile Object _parentHandle;

    @Volatile
    private volatile Object _state;

    @SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$AwaitContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1454:1\n1#2:1455\n*E\n"})
    private static final class a<T> extends o<T> {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final c2 f10253n;

        public a(Continuation<? super T> r10, c2 r11) {
            super(r10, 1);
            this.f10253n = r11;
        }

        @Override // kotlinx.coroutines.o
        protected String Q() {
            return "AwaitContinuation";
        }

        @Override // kotlinx.coroutines.o
        public Throwable x(v1 r10) {
            Object r11 = this.f10253n.w0();
            if ((r11 instanceof c) == false) goto L8;
            Throwable r12 = ((c) r11).e();
            if (r12 == null) goto L8;
            return r12;
        L8:
            if ((r11 instanceof b0) == false) goto L12;
            return ((b0) r11).f10244a;
        L12:
            return r10.p();
        }
    }

    private static final class b extends b2 {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final c2 f10254j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final c f10255k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final u f10256l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final Object f10257m;

        public b(c2 r10, c r11, u r12, Object r13) {
            this.f10254j = r10;
            this.f10255k = r11;
            this.f10256l = r12;
            this.f10257m = r13;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
            q(r10);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.d0
        public void q(Throwable r10) {
            c2.R(this.f10254j, this.f10255k, this.f10256l, this.f10257m);
        }
    }

    @SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$Finishing\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1454:1\n1#2:1455\n*E\n"})
    private static final class c implements p1 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f10258g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f10259h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f10260i = null;

        @Volatile
        private volatile Object _exceptionsHolder;

        @Volatile
        private volatile int _isCompleting;

        @Volatile
        private volatile Object _rootCause;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final h2 f10261c;

        static {
            f10258g = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting");
            f10259h = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause");
            f10260i = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder");
        }

        public c(h2 r10, boolean r11, Throwable r12) {
            this.f10261c = r10;
            this._isCompleting = r11 ? 1 : 0;
            this._rootCause = r12;
        }

        private final ArrayList<Throwable> c() {
            return new ArrayList(4);
        }

        private final Object d() {
            return f10260i.get(this);
        }

        private final void k(Object r10) {
            f10260i.set(this, r10);
        }

        @Override // kotlinx.coroutines.p1
        public h2 a() {
            return this.f10261c;
        }

        public final void b(Throwable r10) {
            Throwable r11 = e();
            if (r11 != null) goto L6;
            l(r10);
            return;
        L6:
            if (r10 != r11) goto L8;
            return;
        L8:
            Object r12 = d();
            if (r12 != null) goto L12;
            k(r10);
            return;
        L12:
            if ((r12 instanceof Throwable) == false) goto L17;
            if (r10 != r12) goto L15;
            return;
        L15:
            ArrayList<Throwable> r13 = c();
            r13.add(r12);
            r13.add(r10);
            k(r13);
            return;
        L17:
            if ((r12 instanceof ArrayList) == false) goto L21;
            ((ArrayList) r12).add(r10);
            return;
        L21:
            throw new IllegalStateException(("State is " + r12).toString());
        }

        public final Throwable e() {
            return (Throwable) f10259h.get(this);
        }

        public final boolean f() {
            if (e() == null) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean g() {
            if (f10258g.get(this) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean h() {
            if (d() != d2.e()) goto L5;
            return true;
        L5:
            return false;
        }

        public final List<Throwable> i(Throwable r10) {
            Object r11 = d();
            if (r11 != null) goto L6;
            ArrayList<Throwable> r12 = c();
        L11:
            Throwable r13 = e();
            if (r13 == null) goto L14;
            r12.add(0, r13);
        L14:
            if (r10 != null) goto L16;
        L18:
            k(d2.e());
            return r12;
        L16:
            if (Intrinsics.areEqual(r10, r13) == true) goto L18;
            r12.add(r10);
            goto L18
        L6:
            if ((r11 instanceof Throwable) == false) goto L9;
            ArrayList<Throwable> r14 = c();
            r14.add(r11);
            r12 = r14;
            goto L11
        L9:
            if ((r11 instanceof ArrayList) == false) goto L21;
            r12 = (ArrayList) r11;
            goto L11
        L21:
            throw new IllegalStateException(("State is " + r11).toString());
        }

        @Override // kotlinx.coroutines.p1
        public boolean isActive() {
            if (e() != null) goto L5;
            return true;
        L5:
            return false;
        }

        public final void j(boolean r10) {
            f10258g.set(this, r10 ? 1 : 0);
        }

        public final void l(Throwable r10) {
            f10259h.set(this, r10);
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + a() + ']';
        }
    }

    private final class d extends b2 {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final kotlinx.coroutines.selects.k<?> f10262j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ c2 f10263k;

        public d(c2 r10, kotlinx.coroutines.selects.k<?> r11) {
            this.f10263k = r10;
            this.f10262j = r11;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
            q(r10);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.d0
        public void q(Throwable r10) {
            Object r11 = this.f10263k.w0();
            if ((r11 instanceof b0) == true) goto L6;
            r11 = d2.h(r11);
        L6:
            this.f10262j.d(this.f10263k, r11);
        }
    }

    private final class e extends b2 {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final kotlinx.coroutines.selects.k<?> f10264j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ c2 f10265k;

        public e(c2 r10, kotlinx.coroutines.selects.k<?> r11) {
            this.f10265k = r10;
            this.f10264j = r11;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
            q(r10);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.d0
        public void q(Throwable r10) {
            this.f10264j.d(this.f10265k, Unit.INSTANCE);
        }
    }

    @SourceDebugExtension({"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,367:1\n526#2:368\n*E\n"})
    public static final class f extends LockFreeLinkedListNode.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c2 f10266d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f10267e;

        public f(LockFreeLinkedListNode r10, c2 r11, Object r12) {
            this.f10266d = r11;
            this.f10267e = r12;
            super(r10);
        }

        @Override // kotlinx.coroutines.internal.b
        public /* bridge */ /* synthetic */ Object d(LockFreeLinkedListNode r10) {
            return f(r10);
        }

        public Object f(LockFreeLinkedListNode r10) {
            if (this.f10266d.w0() != this.f10267e) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L9;
            return null;
        L9:
            return kotlinx.coroutines.internal.t.a();
        L5:
            r11 = false;
            goto L6
        }
    }

    static {
        f10251c = AtomicReferenceFieldUpdater.newUpdater(c2.class, Object.class, "_state");
        f10252g = AtomicReferenceFieldUpdater.newUpdater(c2.class, Object.class, "_parentHandle");
    }

    public c2(boolean r10) {
        if (r10 == false) goto L5;
        e1 r11 = d2.c();
    L6:
        this._state = r11;
        return;
    L5:
        r11 = d2.d();
        goto L6
    }

    private final boolean B0() {
    L2:
        Object r10 = w0();
        if ((r10 instanceof p1) == false) goto L4;
        if (V0(r10) < 0) goto L2;
        return true;
    L4:
        return false;
    }

    private final Object C0(Continuation<? super Unit> r10) {
        o r11 = new o(IntrinsicsKt.intercepted(r10), 1);
        r11.F();
        q.a(r11, A(new m2(r11)));
        Object r12 = r11.B();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L6:
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r12;
    L9:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object D0(Object r10) {
        Throwable r11 = null;
        Object[] r12 = 0;
        Throwable r13 = null;
    L3:
        Object r14 = w0();
        if ((r14 instanceof c) == true) goto L5;
        if ((r14 instanceof p1) == false) goto L47;
        if (r13 != null) goto L33;
        r13 = m0(r10);
    L33:
        p1 r15 = (p1) r14;
        if (r15.isActive() == true) goto L36;
        Object r16 = c1(r14, new b0(r13, false, 2, r12 == true ? 1 : 0));
        if (r16 == d2.a()) goto L45;
        if (r16 == d2.b()) goto L3;
        return r16;
    L45:
        throw new IllegalStateException(("Cannot happen in " + r14).toString());
    L36:
        if (b1(r15, r13) == false) goto L3;
        return d2.a();
    L47:
        return d2.f();
    L5:
        monitor-enter(r14);
    L26:
        th = move-exception;
        throw th;
    L7:
        if (((c) r14).h() == false) goto L11;
        kotlinx.coroutines.internal.i0 r17 = d2.f();     // Catch: Throwable -> L26
        monitor-exit(r14);
        return r17;
    L11:
        boolean r18 = ((c) r14).f();     // Catch: Throwable -> L26
        if (r10 != null) goto L14;
        if (r18 == false) goto L14;
    L17:
        Throwable r19 = ((c) r14).e();     // Catch: Throwable -> L26
        if ((!r18) == false) goto L21;
        r11 = r19;
    L21:
        monitor-exit(r14);
        if (r11 == null) goto L25;
        J0(((c) r14).a(), r11);
    L25:
        return d2.a();
    L14:
        if (r13 != null) goto L16;
        r13 = m0(r10);     // Catch: Throwable -> L26
    L16:
        ((c) r14).b(r13);     // Catch: Throwable -> L26
        goto L17
    }

    private final b2 G0(Function1<? super Throwable, Unit> r10, boolean r11) {
        b2 r12 = null;
        if (r11 == false) goto L10;
        if ((r10 instanceof w1) == false) goto L7;
        r12 = (w1) r10;
    L7:
        if (r12 != null) goto L21;
        r12 = new t1(r10);
    L21:
        r12.s(this);
        return r12;
    L10:
        if ((r10 instanceof b2) == false) goto L12;
        r12 = (b2) r10;
    L12:
        if (r12 != null) goto L14;
        r12 = new u1(r10);
        goto L21
    L14:
        if (n0.a() == false) goto L21;
        if ((!(r12 instanceof w1)) == true) goto L21;
        throw new AssertionError();
    }

    private final u I0(LockFreeLinkedListNode r10) {
    L3:
        if (r10.l() == false) goto L5;
        r10 = r10.k();
    L5:
        r10 = r10.j();
        if (r10.l() == true) goto L5;
        if ((r10 instanceof u) == true) goto L10;
        if ((r10 instanceof h2) == false) goto L5;
        return null;
    L10:
        return (u) r10;
    }

    private final void J0(h2 r10, Throwable r11) {
        N0(r11);
        Object r12 = r10.i();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r13 = (LockFreeLinkedListNode) r12;
        CompletionHandlerException r14 = null;
    L4:
        if (Intrinsics.areEqual(r13, r10) == true) goto L15;
        if ((r13 instanceof w1) == false) goto L14;
        b2 r15 = (b2) r13;
        r15.q(r11);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r14 == null) goto L13;
        ExceptionsKt.addSuppressed(r14, th);
        goto L14
    L13:
        r14 = new CompletionHandlerException("Exception in completion handler " + r15 + " for " + this, th);
        Unit r16 = Unit.INSTANCE;
    L14:
        r13 = r13.j();
        goto L4
    L15:
        if (r14 == null) goto L17;
        y0(r14);
    L17:
        h0(r11);
    }

    private final void K0(h2 r10, Throwable r11) {
        Object r12 = r10.i();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r13 = (LockFreeLinkedListNode) r12;
        CompletionHandlerException r14 = null;
    L4:
        if (Intrinsics.areEqual(r13, r10) == true) goto L15;
        if ((r13 instanceof b2) == false) goto L14;
        b2 r15 = (b2) r13;
        r15.q(r11);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r14 == null) goto L13;
        ExceptionsKt.addSuppressed(r14, th);
        goto L14
    L13:
        r14 = new CompletionHandlerException("Exception in completion handler " + r15 + " for " + this, th);
        Unit r16 = Unit.INSTANCE;
    L14:
        r13 = r13.j();
        goto L4
    L15:
        if (r14 == null) goto L25;
        y0(r14);
        return;
    }

    private final Object L0(Object r10, Object r11) {
        if ((r11 instanceof b0) == true) goto L6;
        return r11;
    L6:
        throw ((b0) r11).f10244a;
    }

    private final void M0(kotlinx.coroutines.selects.k<?> r10, Object r11) {
    L2:
        Object r12 = w0();
        if ((r12 instanceof p1) == false) goto L5;
        if (V0(r12) < 0) goto L2;
        r10.a(A(new d(this, r10)));
        return;
    L5:
        if ((r12 instanceof b0) == true) goto L8;
        r12 = d2.h(r12);
    L8:
        r10.f(r12);
    }

    public static final /* synthetic */ String O(c2 r10) {
        return r10.i0();
    }

    private final void Q0(e1 r10) {
        h2 r11 = new h2();
        Object r12 = r11;
        if (r10.isActive() == true) goto L6;
        r12 = new o1(r11);
    L6:
        f10251c.compareAndSet(this, r10, r12);
    }

    public static final /* synthetic */ void R(c2 r10, c r11, u r12, Object r13) {
        r10.l0(r11, r12, r13);
    }

    private final void R0(b2 r10) {
        r10.e(new h2());
        LockFreeLinkedListNode r11 = r10.j();
        f10251c.compareAndSet(this, r10, r11);
    }

    public static final /* synthetic */ Object S(c2 r10, Object r11, Object r12) {
        return r10.L0(r11, r12);
    }

    private final void S0(kotlinx.coroutines.selects.k<?> r10, Object r11) {
        if (B0() == true) goto L6;
        r10.f(Unit.INSTANCE);
        return;
    L6:
        r10.a(A(new e(this, r10)));
    }

    public static final /* synthetic */ void T(c2 r10, kotlinx.coroutines.selects.k r11, Object r12) {
        r10.M0(r11, r12);
    }

    public static final /* synthetic */ void U(c2 r10, kotlinx.coroutines.selects.k r11, Object r12) {
        r10.S0(r11, r12);
    }

    private final int V0(Object r10) {
        if ((r10 instanceof e1) == false) goto L13;
        if (((e1) r10).isActive() == false) goto L8;
        return 0;
    L8:
        if (f10251c.compareAndSet(this, r10, d2.c()) == true) goto L10;
        return -1;
    L10:
        P0();
        return 1;
    L13:
        if ((r10 instanceof o1) == true) goto L15;
        return 0;
    L15:
        if (f10251c.compareAndSet(this, r10, ((o1) r10).a()) == true) goto L17;
        return -1;
    L17:
        P0();
        return 1;
    }

    private final boolean W(Object r10, h2 r11, b2 r12) {
        f r13 = new f(r12, this, r10);
    L3:
        int r14 = r11.k().p(r12, r11, r13);
        if (r14 == 1) goto L13;
        if (r14 != 2) goto L3;
        return false;
    L13:
        return true;
    }

    private final String W0(Object r10) {
        if ((r10 instanceof c) == false) goto L11;
        c r11 = (c) r10;
        if (r11.f() == false) goto L8;
        return "Cancelling";
    L8:
        if (r11.g() == false) goto L22;
        return "Completing";
    L22:
        return "Active";
    L11:
        if ((r10 instanceof p1) == false) goto L17;
        if (((p1) r10).isActive() == true) goto L26;
        return "New";
    L26:
        return "Active";
    L17:
        if ((r10 instanceof b0) == false) goto L19;
        return "Cancelled";
    L19:
        return "Completed";
    }

    private final void Y(Throwable r10, List<? extends Throwable> r11) {
        if (r11.size() > 1) goto L5;
        return;
    L5:
        Set r12 = Collections.newSetFromMap(new IdentityHashMap(r11.size()));
        if (n0.d() == true) goto L8;
        Throwable r13 = r10;
    L9:
        Iterator<? extends Throwable> r14 = r11.iterator();
    L11:
        if (r14.hasNext() == false) goto L23;
        Throwable r15 = r14.next();
        if (n0.d() == false) goto L16;
        r15 = kotlinx.coroutines.internal.h0.l(r15);
    L16:
        if (r15 == r10) goto L11;
        if (r15 == r13) goto L11;
        if ((r15 instanceof CancellationException) == true) goto L11;
        if (r12.add(r15) == false) goto L11;
        ExceptionsKt.addSuppressed(r10, r15);
        goto L11
    L23:
        return;
    L8:
        r13 = kotlinx.coroutines.internal.h0.l(r10);
        goto L9
    }

    public static /* synthetic */ CancellationException Y0(c2 r10, Throwable r11, String r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 1) == 0) goto L7;
        r12 = null;
    L7:
        return r10.X0(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final boolean a1(p1 r10, Object r11) {
        if (n0.a() == false) goto L16;
        if ((r10 instanceof e1) == false) goto L7;
    L10:
        boolean r12 = true;
    L11:
        if (r12 == true) goto L16;
        throw new AssertionError();
    L7:
        if ((r10 instanceof b2) == true) goto L10;
        r12 = false;
    L16:
        if (n0.a() == false) goto L23;
        if ((!(r11 instanceof b0)) == true) goto L23;
        throw new AssertionError();
    L23:
        if (f10251c.compareAndSet(this, r10, d2.g(r11)) == true) goto L25;
        return false;
    L25:
        N0(null);
        O0(r11);
        k0(r10, r11);
        return true;
    }

    private final boolean b1(p1 r10, Throwable r11) {
        if (n0.a() == false) goto L10;
        if ((!(r10 instanceof c)) == true) goto L10;
        throw new AssertionError();
    L10:
        if (n0.a() == true) goto L12;
    L16:
        h2 r12 = u0(r10);
        if (r12 != null) goto L20;
        return false;
    L20:
        if (f10251c.compareAndSet(this, r10, new c(r12, false, r11)) == true) goto L22;
        return false;
    L22:
        J0(r12, r11);
        return true;
    L12:
        if (r10.isActive() == true) goto L16;
        throw new AssertionError();
    }

    private final Object c0(Continuation<Object> r10) {
        a r11 = new a(IntrinsicsKt.intercepted(r10), this);
        r11.F();
        q.a(r11, A(new l2(r11)));
        Object r12 = r11.B();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L5:
        return r12;
    }

    private final Object c1(Object r10, Object r11) {
        if ((r10 instanceof p1) == true) goto L7;
        return d2.a();
    L7:
        if ((r10 instanceof e1) == true) goto L11;
        if ((r10 instanceof b2) == true) goto L11;
    L20:
        return d1((p1) r10, r11);
    L11:
        if ((r10 instanceof u) == true) goto L20;
        if ((r11 instanceof b0) == true) goto L20;
        if (a1((p1) r10, r11) == false) goto L18;
        return r11;
    L18:
        return d2.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object d1(p1 r10, Object r11) {
        h2 r12 = u0(r10);
        if (r12 == null) goto L5;
        T r13 = 0;
        if ((r10 instanceof c) == false) goto L9;
        c r14 = (c) r10;
    L10:
        boolean r15 = false;
        if (r14 != null) goto L13;
        r14 = new c(r12, false, null);
    L13:
        Ref.ObjectRef r16 = new Ref.ObjectRef();
        monitor-enter(r14);
    L60:
        th = move-exception;
        throw th;
    L16:
        if (r14.g() == false) goto L21;
        kotlinx.coroutines.internal.i0 r17 = d2.a();     // Catch: Throwable -> L60
        monitor-exit(r14);
        return r17;
    L21:
        r14.j(true);     // Catch: Throwable -> L60
        if (r14 == r10) goto L29;
        if (f10251c.compareAndSet(this, r10, r14) == true) goto L29;
        kotlinx.coroutines.internal.i0 r18 = d2.b();     // Catch: Throwable -> L60
        monitor-exit(r14);
        return r18;
    L29:
        if (n0.a() == true) goto L31;
    L35:
        boolean r19 = r14.f();     // Catch: Throwable -> L60
        if ((r11 instanceof b0) == false) goto L38;
        b0 r20 = (b0) r11;     // Catch: Throwable -> L60
    L39:
        if (r20 == null) goto L41;
        r14.b(r20.f10244a);     // Catch: Throwable -> L60
    L41:
        Throwable r21 = r14.e();     // Catch: Throwable -> L60
        if (r19 == true) goto L45;
        r15 = true;
    L45:
        if (Boolean.valueOf(r15).booleanValue() == false) goto L47;
        r13 = r21;
    L47:
        r16.element = r13;     // Catch: Throwable -> L60
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L60
        monitor-exit(r14);
        Throwable r23 = (Throwable) r13;
        if (r23 == null) goto L52;
        J0(r12, r23);
    L52:
        u r24 = o0(r10);
        if (r24 == null) goto L59;
        if (e1(r14, r24, r11) == false) goto L59;
        return d2.f10331b;
    L59:
        return n0(r14, r11);
    L38:
        r20 = null;
        goto L39
    L31:
        if ((!r14.h()) == true) goto L35;
        throw new AssertionError();     // Catch: Throwable -> L60
    L9:
        r14 = null;
        goto L10
    L5:
        return d2.b();
    }

    private final boolean e1(c r10, u r11, Object r12) {
    L3:
        if (v1.a.d(r11.f10720j, false, false, new b(this, r10, r11, r12), 1, null) != i2.f10525c) goto L4;
        r11 = I0(r11);
        if (r11 != null) goto L3;
        return false;
    L4:
        return true;
    }

    private final Object g0(Object r10) {
    L2:
        Object r11 = w0();
        if ((r11 instanceof p1) == false) goto L13;
        if ((r11 instanceof c) == true) goto L7;
    L9:
        Object r12 = c1(r11, new b0(m0(r10), false, 2, null));
        if (r12 == d2.b()) goto L2;
        return r12;
    L7:
        if (((c) r11).g() == false) goto L9;
    L13:
        return d2.a();
    }

    private final boolean h0(Throwable r10) {
        if (A0() == false) goto L5;
        return true;
    L5:
        boolean r11 = r10 instanceof CancellationException;
        t r12 = v0();
        if (r12 != null) goto L8;
    L16:
        return r11;
    L8:
        if (r12 == i2.f10525c) goto L16;
        if (r12.b(r10) == true) goto L17;
        if (r11 == true) goto L18;
        return false;
    L18:
        return true;
    L17:
        return true;
    }

    private final void k0(p1 r10, Object r11) {
        t r12 = v0();
        if (r12 == null) goto L5;
        r12.dispose();
        U0(i2.f10525c);
    L5:
        Throwable r13 = null;
        if ((r11 instanceof b0) == false) goto L8;
        b0 r14 = (b0) r11;
    L9:
        if (r14 == null) goto L12;
        r13 = r14.f10244a;
    L12:
        if ((r10 instanceof b2) == true) goto L21;
        h2 r15 = r10.a();
        if (r15 == null) goto L24;
        K0(r15, r13);
        return;
    L24:
        return;
    L21:
        ((b2) r10).q(r13);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        y0(new CompletionHandlerException("Exception in completion handler " + r10 + " for " + this, th));
        return;
    L8:
        r14 = null;
        goto L9
    }

    private final void l0(c r10, u r11, Object r12) {
        if (n0.a() == true) goto L5;
    L12:
        u r13 = I0(r11);
        if (r13 != null) goto L15;
    L17:
        Z(n0(r10, r12));
        return;
    L15:
        if (e1(r10, r13, r12) == false) goto L17;
        return;
    L5:
        if (w0() != r10) goto L7;
        boolean r14 = true;
    L8:
        if (r14 == true) goto L12;
        throw new AssertionError();
    L7:
        r14 = false;
        goto L8
    }

    private final Throwable m0(Object r10) {
        if (r10 != null) goto L4;
        boolean r11 = true;
    L5:
        if (r11 == false) goto L9;
        Throwable r12 = (Throwable) r10;
        if (r12 == null) goto L12;
        return r12;
    L12:
        return new JobCancellationException(O(this), null, this);
    L9:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((k2) r10).Q();
    L4:
        r11 = r10 instanceof Throwable;
        goto L5
    }

    private final Object n0(c r10, Object r11) {
        boolean r12 = true;
        boolean r13 = false;
        if (n0.a() == false) goto L13;
        if (w0() != r10) goto L7;
        boolean r14 = true;
    L8:
        if (r14 == true) goto L13;
        throw new AssertionError();
    L7:
        r14 = false;
    L13:
        if (n0.a() == false) goto L20;
        if ((!r10.h()) == true) goto L20;
        throw new AssertionError();
    L20:
        if (n0.a() == true) goto L22;
    L26:
        DefaultConstructorMarker r15 = null;
        if ((r11 instanceof b0) == false) goto L29;
        b0 r16 = (b0) r11;
    L30:
        if (r16 == null) goto L32;
        Throwable r17 = r16.f10244a;
    L33:
        monitor-enter(r10);
        boolean r18 = r10.f();     // Catch: Throwable -> L62
        List<Throwable> r19 = r10.i(r17);     // Catch: Throwable -> L62
        Throwable r20 = r0(r10, r19);     // Catch: Throwable -> L62
        if (r20 == null) goto L37;
        Y(r20, r19);     // Catch: Throwable -> L62
    L37:
        monitor-exit(r10);
        if (r20 == null) goto L43;
        if (r20 == r17) goto L43;
        r11 = new b0(r20, r13, 2, r15);
    L43:
        if (r20 != null) goto L45;
    L52:
        if (r18 == true) goto L54;
        N0(r20);
    L54:
        O0(r11);
        boolean r21 = f10251c.compareAndSet(this, r10, d2.g(r11));
        if (n0.a() == false) goto L60;
        if (r21 == true) goto L60;
        throw new AssertionError();
    L60:
        k0(r10, r11);
        return r11;
    L45:
        if (h0(r20) == false) goto L47;
    L50:
        if (r12 == false) goto L52;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
        ((b0) r11).b();
        goto L52
    L47:
        if (x0(r20) == true) goto L50;
        r12 = false;
    L62:
        th = move-exception;
        throw th;
    L32:
        r17 = null;
        goto L33
    L29:
        r16 = null;
        goto L30
    L22:
        if (r10.g() == true) goto L26;
        throw new AssertionError();
    }

    private final u o0(p1 r10) {
        if ((r10 instanceof u) == false) goto L5;
        u r11 = (u) r10;
    L6:
        if (r11 != null) goto L11;
        h2 r12 = r10.a();
        if (r12 != null) goto L13;
        return null;
    L13:
        return I0(r12);
    L11:
        return r11;
    L5:
        r11 = null;
        goto L6
    }

    private final Throwable q0(Object r10) {
        if ((r10 instanceof b0) == false) goto L5;
        b0 r11 = (b0) r10;
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.f10244a;
    L5:
        r11 = null;
        goto L6
    }

    private final Throwable r0(c r10, List<? extends Throwable> r11) {
        Object r12 = null;
        if (r11.isEmpty() == true) goto L5;
        Iterator<T> r13 = r11.iterator();
    L11:
        if (r13.hasNext() == false) goto L15;
        Object r14 = r13.next();
        if ((!(((Throwable) r14) instanceof CancellationException)) == false) goto L11;
    L16:
        Throwable r15 = (Throwable) r14;
        if (r15 == null) goto L19;
        return r15;
    L19:
        Throwable r16 = r11.get(0);
        if ((r16 instanceof TimeoutCancellationException) == false) goto L35;
        Iterator<T> r17 = r11.iterator();
    L23:
        if (r17.hasNext() == false) goto L32;
        Object r18 = r17.next();
        Throwable r19 = (Throwable) r18;
        if (r19 != r16) goto L27;
    L29:
        boolean r20 = false;
    L30:
        if (r20 == false) goto L23;
        r12 = r18;
        goto L32
    L27:
        if ((r19 instanceof TimeoutCancellationException) == false) goto L29;
        r20 = true;
    L32:
        Throwable r21 = (Throwable) r12;
        if (r21 == null) goto L35;
        return r21;
    L35:
        return r16;
    L15:
        r14 = null;
        goto L16
    L5:
        if (r10.f() == true) goto L7;
        return null;
    L7:
        return new JobCancellationException(O(this), null, this);
    }

    private final h2 u0(p1 r10) {
        h2 r11 = r10.a();
        if (r11 == null) goto L5;
        return r11;
    L5:
        if ((r10 instanceof e1) == false) goto L8;
        return new h2();
    L8:
        if ((r10 instanceof b2) == false) goto L11;
        R0((b2) r10);
        return null;
    L11:
        throw new IllegalStateException(("State should have list: " + r10).toString());
    }

    @Override // kotlinx.coroutines.v1
    public final b1 A(Function1<? super Throwable, Unit> r10) {
        return o(false, true, r10);
    }

    protected boolean A0() {
        return false;
    }

    public final boolean E0(Object r10) {
    L2:
        Object r11 = c1(w0(), r10);
        if (r11 == d2.a()) goto L4;
        if (r11 == d2.f10331b) goto L8;
        if (r11 == d2.b()) goto L2;
        Z(r11);
        return true;
    L8:
        return true;
    L4:
        return false;
    }

    public final Object F0(Object r10) {
    L2:
        Object r11 = c1(w0(), r10);
        if (r11 == d2.a()) goto L8;
        if (r11 == d2.b()) goto L2;
        return r11;
    L8:
        throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + r10, q0(r10));
    }

    public String H0() {
        return o0.a(this);
    }

    protected void N0(Throwable r10) {
    }

    protected void O0(Object r10) {
    }

    protected void P0() {
    }

    @Override // kotlinx.coroutines.k2
    public CancellationException Q() {
        Object r10 = w0();
        CancellationException r11 = null;
        if ((r10 instanceof c) == false) goto L6;
        Throwable r12 = ((c) r10).e();
    L12:
        if ((r12 instanceof CancellationException) == false) goto L14;
        r11 = (CancellationException) r12;
    L14:
        if (r11 == null) goto L16;
        return r11;
    L16:
        return new JobCancellationException("Parent job is " + W0(r10), r12, this);
    L6:
        if ((r10 instanceof b0) == false) goto L9;
        r12 = ((b0) r10).f10244a;
        goto L12
    L9:
        if ((r10 instanceof p1) == true) goto L18;
        r12 = null;
        goto L12
    L18:
        throw new IllegalStateException(("Cannot be cancelling child in this state: " + r10).toString());
    }

    public final void T0(b2 r10) {
    L2:
        Object r11 = w0();
        if ((r11 instanceof b2) == false) goto L10;
        if (r11 != r10) goto L5;
        if (f10251c.compareAndSet(this, r11, d2.c()) == false) goto L2;
        return;
    L5:
        return;
    L10:
        if ((r11 instanceof p1) == true) goto L12;
        return;
    L12:
        if (((p1) r11).a() == null) goto L20;
        r10.m();
        return;
    }

    public final void U0(t r10) {
        f10252g.set(this, r10);
    }

    protected final CancellationException X0(Throwable r10, String r11) {
        if ((r10 instanceof CancellationException) == false) goto L5;
        CancellationException r12 = (CancellationException) r10;
    L6:
        if (r12 == null) goto L8;
    L11:
        return r12;
    L8:
        if (r11 != null) goto L10;
        r11 = O(this);
    L10:
        r12 = new JobCancellationException(r11, r10, this);
        goto L11
    L5:
        r12 = null;
        goto L6
    }

    protected void Z(Object r10) {
    }

    public final String Z0() {
        return H0() + '{' + W0(w0()) + '}';
    }

    @Override // kotlinx.coroutines.v1
    public final boolean a() {
        return !(w0() instanceof p1);
    }

    @Override // kotlinx.coroutines.v1
    public final t a0(v r10) {
        b1 r11 = v1.a.d(this, true, false, new u(r10), 2, null);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (t) r11;
    }

    protected final Object b0(Continuation<Object> r10) {
    L2:
        Object r11 = w0();
        if ((r11 instanceof p1) == false) goto L5;
        if (V0(r11) < 0) goto L2;
        return c0(r10);
    L5:
        if ((r11 instanceof b0) == false) goto L15;
        Throwable r12 = ((b0) r11).f10244a;
        if (n0.d() == true) goto L9;
        throw r12;
    L9:
        if ((r10 instanceof CoroutineStackFrame) == true) goto L12;
        throw r12;
    L12:
        throw kotlinx.coroutines.internal.h0.a(r12, (CoroutineStackFrame) r10);
    L15:
        return d2.h(r11);
    }

    @Override // kotlinx.coroutines.v1
    public void c(CancellationException r10) {
        if (r10 != null) goto L4;
        r10 = new JobCancellationException(O(this), null, this);
    L4:
        f0(r10);
    }

    public final boolean d0(Throwable r10) {
        return e0(r10);
    }

    public final boolean e0(Object r10) {
        Object r11 = d2.a();
        if (t0() == false) goto L8;
        r11 = g0(r10);
        if (r11 != d2.f10331b) goto L8;
        return true;
    L8:
        if (r11 != d2.a()) goto L11;
        r11 = D0(r10);
    L11:
        if (r11 != d2.a()) goto L14;
        return true;
    L14:
        if (r11 != d2.f10331b) goto L17;
        return true;
    L17:
        if (r11 != d2.f()) goto L19;
        return false;
    L19:
        Z(r11);
        return true;
    }

    public void f0(Throwable r10) {
        e0(r10);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r10, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r11) {
        return (R) v1.a.b(this, r10, r11);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r10) {
        return (E) v1.a.c(this, r10);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return v1.f10723e;
    }

    @Override // kotlinx.coroutines.v1
    public v1 getParent() {
        t r10 = v0();
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getParent();
    }

    protected String i0() {
        return "Job was cancelled";
    }

    @Override // kotlinx.coroutines.v1
    public boolean isActive() {
        Object r10 = w0();
        if ((r10 instanceof p1) == true) goto L5;
    L7:
        return false;
    L5:
        if (((p1) r10).isActive() == false) goto L7;
        return true;
    }

    @Override // kotlinx.coroutines.v1
    public final boolean isCancelled() {
        Object r10 = w0();
        if ((r10 instanceof b0) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r10 instanceof c) == true) goto L7;
    L9:
        return false;
    L7:
        if (((c) r10).f() == false) goto L9;
        goto L9
    }

    public boolean j0(Throwable r10) {
        if ((r10 instanceof CancellationException) == false) goto L6;
        return true;
    L6:
        if (e0(r10) == true) goto L8;
    L10:
        return false;
    L8:
        if (s0() == false) goto L10;
        return true;
    }

    @Override // kotlinx.coroutines.v1
    public final Object l(Continuation<? super Unit> r10) {
        if (B0() == true) goto L6;
        y1.g(r10.getContext());
        return Unit.INSTANCE;
    L6:
        Object r11 = C0(r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r11;
    L10:
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> r10) {
        return v1.a.e(this, r10);
    }

    @Override // kotlinx.coroutines.v1
    public final b1 o(boolean r10, boolean r11, Function1<? super Throwable, Unit> r12) {
        b2 r13 = G0(r12, r10);
    L3:
        Object r14 = w0();
        if ((r14 instanceof e1) == true) goto L5;
        Throwable r15 = null;
        if ((r14 instanceof p1) == false) goto L48;
        h2 r16 = ((p1) r14).a();
        if (r16 == null) goto L15;
        b1 r17 = i2.f10525c;
        if (r10 == false) goto L41;
        if ((r14 instanceof c) == false) goto L41;
        monitor-enter(r14);
        r15 = ((c) r14).e();     // Catch: Throwable -> L38
        if (r15 == null) goto L28;
        if ((r12 instanceof u) == false) goto L35;
        if (((c) r14).g() == false) goto L28;
    L35:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L38
        monitor-exit(r14);
    L28:
        if (W(r14, r16, r13) == false) goto L29;
        if (r15 == null) goto L32;
        r17 = r13;
        goto L35
    L32:
        monitor-exit(r14);
        return r13;
    L29:
        monitor-exit(r14);
    L38:
        th = move-exception;
        throw th;
    L41:
        if (r15 != null) goto L42;
        if (W(r14, r16, r13) == false) goto L3;
        return r13;
    L42:
        if (r11 == false) goto L44;
        r12.invoke(r15);
    L44:
        return r17;
    L15:
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
        R0((b2) r14);
        goto L3
    L48:
        if (r11 == false) goto L57;
        if ((r14 instanceof b0) == false) goto L52;
        b0 r19 = (b0) r14;
    L53:
        if (r19 == null) goto L55;
        r15 = r19.f10244a;
    L55:
        r12.invoke(r15);
        goto L57
    L52:
        r19 = null;
    L57:
        return i2.f10525c;
    L5:
        e1 r20 = (e1) r14;
        if (r20.isActive() == true) goto L8;
        Q0(r20);
        goto L3
    L8:
        if (f10251c.compareAndSet(this, r14, r13) == false) goto L3;
        return r13;
    }

    @Override // kotlinx.coroutines.v1
    public final CancellationException p() {
        Object r10 = w0();
        if ((r10 instanceof c) == false) goto L12;
        Throwable r11 = ((c) r10).e();
        if (r11 == null) goto L10;
        CancellationException r12 = X0(r11, o0.a(this) + " is cancelling");
        if (r12 == null) goto L10;
        return r12;
    L10:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    L12:
        if ((r10 instanceof p1) == true) goto L19;
        if ((r10 instanceof b0) == false) goto L17;
        return Y0(this, ((b0) r10).f10244a, null, 1, null);
    L17:
        return new JobCancellationException(o0.a(this) + " has completed normally", null, this);
    L19:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final Object p0() {
        Object r10 = w0();
        if ((!(r10 instanceof p1)) == false) goto L11;
        if ((r10 instanceof b0) == true) goto L9;
        return d2.h(r10);
    L9:
        throw ((b0) r10).f10244a;
    L11:
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext r10) {
        return v1.a.f(this, r10);
    }

    @Override // kotlinx.coroutines.v
    public final void s(k2 r10) {
        e0(r10);
    }

    public boolean s0() {
        return true;
    }

    @Override // kotlinx.coroutines.v1
    public final boolean start() {
    L2:
        int r10 = V0(w0());
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L2;
        return true;
    L8:
        return false;
    }

    public boolean t0() {
        return false;
    }

    public String toString() {
        return Z0() + '@' + o0.b(this);
    }

    public final t v0() {
        return (t) f10252g.get(this);
    }

    public final Object w0() {
        AtomicReferenceFieldUpdater r10 = f10251c;
    L3:
        Object r11 = r10.get(this);
        if ((r11 instanceof kotlinx.coroutines.internal.b0) == false) goto L5;
        ((kotlinx.coroutines.internal.b0) r11).a(this);
        goto L3
    L5:
        return r11;
    }

    protected boolean x0(Throwable r10) {
        return false;
    }

    public void y0(Throwable r10) {
        throw r10;
    }

    protected final void z0(v1 r10) {
        if (n0.a() == true) goto L5;
    L12:
        if (r10 != null) goto L15;
        U0(i2.f10525c);
        return;
    L15:
        r10.start();
        t r11 = r10.a0(this);
        U0(r11);
        if (a() == false) goto L19;
        r11.dispose();
        U0(i2.f10525c);
        return;
    L19:
        return;
    L5:
        if (v0() != null) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == true) goto L12;
        throw new AssertionError();
    L7:
        r12 = false;
        goto L8
    }
}
