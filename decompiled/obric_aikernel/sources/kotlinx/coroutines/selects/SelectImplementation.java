package kotlinx.coroutines.selects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.h0;
import kotlinx.coroutines.n0;

/* JADX INFO: loaded from: classes3.dex */
@PublishedApi
@SourceDebugExtension({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,873:1\n1#2:874\n2624#3,3:875\n1855#3,2:888\n1855#3,2:896\n1855#3,2:898\n314#4,9:878\n323#4,2:890\n19#5:887\n153#6,4:892\n*S KotlinDebug\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n*L\n505#1:875,3\n569#1:888,2\n726#1:896,2\n751#1:898,2\n545#1:878,9\n545#1:890,2\n561#1:887\n711#1:892,4\n*E\n"})
public class SelectImplementation<R> extends kotlinx.coroutines.l implements b<R>, l<R> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10657k = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineContext f10658c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<SelectImplementation<R>.a> f10659g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Object f10660h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10661i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Object f10662j;

    @Volatile
    private volatile Object state;

    @SourceDebugExtension({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation$ClauseData\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,873:1\n1#2:874\n*E\n"})
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public final Object f10663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function3<Object, k<?>, Object, Unit> f10664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Function3<Object, Object, Object, Object> f10665c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Object f10666d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Object f10667e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @JvmField
        public final Function3<k<?>, Object, Object, Function1<Throwable, Unit>> f10668f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @JvmField
        public Object f10669g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @JvmField
        public int f10670h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ SelectImplementation<R> f10671i;

        /* JADX WARN: Multi-variable type inference failed */
        public a(SelectImplementation r10, Object r11, Function3<Object, ? super k<?>, Object, Unit> r12, Function3<Object, Object, Object, ? extends Object> r13, Object r14, Object r15, Function3<? super k<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> r16) {
            this.f10671i = r10;
            this.f10663a = r11;
            this.f10664b = r12;
            this.f10665c = r13;
            this.f10666d = r14;
            this.f10667e = r15;
            this.f10668f = r16;
            this.f10670h = -1;
        }

        public final Function1<Throwable, Unit> a(k<?> r10, Object r11) {
            Function3<k<?>, Object, Object, Function1<Throwable, Unit>> r12 = this.f10668f;
            if (r12 != null) goto L7;
            return null;
        L7:
            return r12.invoke(r10, this.f10666d, r11);
        }

        public final void b() {
            Object r10 = this.f10669g;
            SelectImplementation<R> r11 = this.f10671i;
            b1 r12 = null;
            if ((r10 instanceof f0) == false) goto L6;
            ((f0) r10).o(this.f10670h, null, r11.getContext());
            return;
        L6:
            if ((r10 instanceof b1) == false) goto L8;
            r12 = (b1) r10;
        L8:
            if (r12 == null) goto L12;
            r12.dispose();
            return;
        }

        public final Object c(Object r10, Continuation<? super R> r11) {
            Object r12 = this.f10667e;
            if (this.f10666d != SelectKt.i()) goto L6;
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function1) r12).invoke(r11);
        L6:
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function2) r12).invoke(r10, r11);
        }

        public final Object d(Object r10) {
            return this.f10665c.invoke(this.f10663a, this.f10666d, r10);
        }

        public final boolean e(SelectImplementation<R> r10) {
            if (n0.a() == false) goto L16;
            if (SelectImplementation.i(r10) == false) goto L7;
        L10:
            boolean r11 = true;
        L11:
            if (r11 == true) goto L16;
            throw new AssertionError();
        L7:
            if (SelectImplementation.l(r10) == true) goto L10;
            r11 = false;
        L16:
            if (n0.a() == true) goto L18;
        L25:
            this.f10664b.invoke(this.f10663a, r10, this.f10666d);
            if (SelectImplementation.j(r10) == SelectKt.d()) goto L28;
            return false;
        L28:
            return true;
        L18:
            if (SelectImplementation.j(r10) != SelectKt.d()) goto L20;
            boolean r12 = true;
        L21:
            if (r12 == true) goto L25;
            throw new AssertionError();
        L20:
            r12 = false;
            goto L21
        }
    }

    static {
        f10657k = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state");
    }

    public SelectImplementation(CoroutineContext r10) {
        this.f10658c = r10;
        this.state = SelectKt.g();
        this.f10659g = new ArrayList(2);
        this.f10661i = -1;
        this.f10662j = SelectKt.d();
    }

    public static /* synthetic */ void A(SelectImplementation r10, a r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 1) == 0) goto L6;
        r12 = false;
    L6:
        r10.z(r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
    }

    private final void B(Object r10) {
        SelectImplementation<R>.a r11 = u(r10);
        Intrinsics.checkNotNull(r11);
        r11.f10669g = null;
        r11.f10670h = -1;
        z(r11, true);
    }

    private final int D(Object r10, Object r11) {
    L2:
        AtomicReferenceFieldUpdater r12 = f10657k;
        Object r13 = r12.get(this);
        if ((r13 instanceof kotlinx.coroutines.n) == true) goto L4;
        if (Intrinsics.areEqual(r13, SelectKt.f()) == false) goto L18;
        boolean r14 = true;
    L19:
        if (r14 == true) goto L20;
        if (Intrinsics.areEqual(r13, SelectKt.e()) == true) goto L24;
        if (Intrinsics.areEqual(r13, SelectKt.g()) == true) goto L28;
        if ((r13 instanceof List) == false) goto L36;
        if (r12.compareAndSet(this, r13, CollectionsKt.plus((Collection) r13, r10)) == false) goto L2;
        return 1;
    L36:
        throw new IllegalStateException(("Unexpected state: " + r13).toString());
    L28:
        if (r12.compareAndSet(this, r13, CollectionsKt.listOf(r10)) == false) goto L2;
        return 1;
    L24:
        return 2;
    L20:
        return 3;
    L18:
        r14 = r13 instanceof a;
        goto L19
    L4:
        SelectImplementation<R>.a r15 = u(r10);
        if (r15 == null) goto L2;
        Function1<Throwable, Unit> r16 = r15.a(this, r11);
        if (r12.compareAndSet(this, r13, r15) == false) goto L2;
        this.f10662j = r11;
        if (SelectKt.h((kotlinx.coroutines.n) r13, r16) == false) goto L13;
        return 0;
    L13:
        this.f10662j = null;
        return 2;
    }

    private final Object E(Continuation<? super Unit> r10) {
        kotlinx.coroutines.o r11 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r10), 1);
        r11.F();
        AtomicReferenceFieldUpdater r12 = k();
    L3:
        Object r13 = r12.get(this);
        if (r13 == SelectKt.g()) goto L6;
        if ((r13 instanceof List) == false) goto L17;
        if (k().compareAndSet(this, r13, SelectKt.g()) == false) goto L3;
        List r14 = (List) r13;
        Iterator r15 = ((Iterable) r13).iterator();
    L14:
        if (r15.hasNext() == false) goto L3;
        n(this, r15.next());
        goto L14
    L17:
        if ((r13 instanceof a) == false) goto L28;
        r11.y(Unit.INSTANCE, ((a) r13).a(this, j(this)));
    L19:
        Object r16 = r11.B();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L23:
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        return r16;
    L26:
        return Unit.INSTANCE;
    L28:
        throw new IllegalStateException(("unexpected state: " + r13).toString());
    L6:
        if (k().compareAndSet(this, r13, r11) == false) goto L3;
        r11.h(this);
        goto L19
    }

    public static final /* synthetic */ Object h(SelectImplementation r10, Continuation r11) {
        return r10.t(r11);
    }

    public static final /* synthetic */ boolean i(SelectImplementation r10) {
        return r10.v();
    }

    public static final /* synthetic */ Object j(SelectImplementation r10) {
        return r10.f10662j;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater k() {
        return f10657k;
    }

    public static final /* synthetic */ boolean l(SelectImplementation r10) {
        return r10.w();
    }

    public static final /* synthetic */ Object m(SelectImplementation r10, a r11, Object r12, Continuation r13) {
        return r10.y(r11, r12, r13);
    }

    public static final /* synthetic */ void n(SelectImplementation r10, Object r11) {
        r10.B(r11);
    }

    private final void o(Object r10) {
        List<SelectImplementation<R>.a> r11 = this.f10659g;
        Intrinsics.checkNotNull(r11);
        boolean r12 = false;
        if ((r11 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r13 = r11.iterator();
    L9:
        if (r13.hasNext() == false) goto L6;
        if (((a) r13.next()).f10663a != r10) goto L13;
        boolean r14 = true;
    L14:
        if (r14 == false) goto L9;
    L15:
        if (r12 == false) goto L18;
        return;
    L18:
        throw new IllegalStateException(("Cannot use select clauses on the same object: " + r10).toString());
    L13:
        r14 = false;
    L6:
        r12 = true;
        goto L15
    L5:
        if (r11.isEmpty() == false) goto L7;
        goto L6
    }

    private final void p(SelectImplementation<R>.a r10) {
        if (n0.a() == true) goto L5;
    L9:
        List<SelectImplementation<R>.a> r11 = this.f10659g;
        if (r11 != null) goto L12;
        return;
    L12:
        Iterator<T> r12 = r11.iterator();
    L14:
        if (r12.hasNext() == false) goto L18;
        SelectImplementation<R>.a r13 = (a) r12.next();
        if (r13 == r10) goto L14;
        r13.b();
        goto L14
    L18:
        f10657k.set(this, SelectKt.f());
        this.f10662j = SelectKt.d();
        this.f10659g = null;
        return;
    L5:
        if (Intrinsics.areEqual(f10657k.get(this), r10) == true) goto L9;
        throw new AssertionError();
    }

    private final Object q(Continuation<? super R> r10) {
        if (n0.a() == true) goto L5;
    L9:
        Object r11 = f10657k.get(this);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        SelectImplementation<R>.a r12 = (a) r11;
        Object r13 = this.f10662j;
        p(r12);
        if (n0.d() == true) goto L14;
        return r12.c(r12.d(r13), r10);
    L14:
        return y(r12, r13, r10);
    L5:
        if (x() == true) goto L9;
        throw new AssertionError();
    }

    @PublishedApi
    static /* synthetic */ <R> Object s(SelectImplementation<R> r10, Continuation<? super R> r11) {
        if (r10.x() == false) goto L7;
        return r10.q(r11);
    L7:
        return r10.t(r11);
    }

    private final Object t(Continuation<? super R> r10) {
        if ((r10 instanceof SelectImplementation$doSelectSuspend$1) == false) goto L7;
        SelectImplementation$doSelectSuspend$1 r11 = (SelectImplementation$doSelectSuspend$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        ResultKt.throwOnFailure(r13);
    L22:
        return r13;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        SelectImplementation<R> this = (SelectImplementation) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L19:
        r11.L$0 = null;
        r11.label = 2;
        r13 = this.q(r11);
        if (r13 != r14) goto L22;
        return r14;
    L16:
        ResultKt.throwOnFailure(r13);
        r11.L$0 = this;
        r11.label = 1;
        if (E(r11) != r14) goto L19;
        return r14;
    L7:
        r11 = new SelectImplementation$doSelectSuspend$1(this, r10);
        goto L8
    }

    private final SelectImplementation<R>.a u(Object r10) {
        List<SelectImplementation<R>.a> r11 = this.f10659g;
        Object r12 = null;
        if (r11 != null) goto L5;
        return null;
    L5:
        Iterator<T> r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L14;
        Object r14 = r13.next();
        if (((a) r14).f10663a != r10) goto L11;
        boolean r15 = true;
    L12:
        if (r15 == false) goto L7;
        r12 = r14;
        goto L14
    L11:
        r15 = false;
    L14:
        SelectImplementation<R>.a r16 = (a) r12;
        if (r16 == null) goto L18;
        return r16;
    L18:
        throw new IllegalStateException(("Clause with object " + r10 + " is not found").toString());
    }

    private final boolean v() {
        Object r10 = f10657k.get(this);
        if (r10 != SelectKt.g()) goto L5;
    L8:
        return true;
    L5:
        if ((r10 instanceof List) == true) goto L8;
        return false;
    }

    private final boolean w() {
        if (f10657k.get(this) != SelectKt.e()) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean x() {
        return f10657k.get(this) instanceof a;
    }

    private final Object y(SelectImplementation<R>.a r10, Object r11, Continuation<? super R> r12) {
        if ((r12 instanceof SelectImplementation$processResultAndInvokeBlockRecoveringException$1) == false) goto L7;
        SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r13 = (SelectImplementation$processResultAndInvokeBlockRecoveringException$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L17;
        if (r17 != 1) goto L16;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L13
    L27:
        return r15;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r15);
        Object r18 = r10.d(r11);     // Catch: Throwable -> L13
        r13.label = 1;     // Catch: Throwable -> L13
        r15 = r10.c(r18, r13);     // Catch: Throwable -> L13
        if (r15 != r16) goto L27;
        return r16;
    L13:
        th = move-exception;
        if (n0.d() == true) goto L25;
        throw th;
    L25:
        throw h0.a(th, r13);
    L7:
        r13 = new SelectImplementation$processResultAndInvokeBlockRecoveringException$1(this, r12);
        goto L8
    }

    public final TrySelectDetailedResult C(Object r10, Object r11) {
        return SelectKt.b(D(r10, r11));
    }

    @Override // kotlinx.coroutines.selects.k
    public void a(b1 r10) {
        this.f10660h = r10;
    }

    @Override // kotlinx.coroutines.selects.b
    public void b(d r10, Function1<? super Continuation<? super R>, ? extends Object> r11) {
        A(this, new a(this, r10.b(), r10.a(), r10.d(), SelectKt.i(), r11, r10.c()), false, 1, null);
    }

    @Override // kotlinx.coroutines.c3
    public void c(f0<?> r10, int r11) {
        this.f10660h = r10;
        this.f10661i = r11;
    }

    @Override // kotlinx.coroutines.selects.k
    public boolean d(Object r10, Object r11) {
        if (D(r10, r11) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlinx.coroutines.selects.b
    public <Q> void e(f<? extends Q> r10, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> r11) {
        A(this, new a(this, r10.b(), r10.a(), r10.d(), null, r11, r10.c()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.k
    public void f(Object r10) {
        this.f10662j = r10;
    }

    @Override // kotlinx.coroutines.m
    public void g(Throwable r10) {
        AtomicReferenceFieldUpdater r11 = f10657k;
    L3:
        Object r12 = r11.get(this);
        if (r12 == SelectKt.f()) goto L5;
        if (r11.compareAndSet(this, r12, SelectKt.e()) == false) goto L3;
        List<SelectImplementation<R>.a> r13 = this.f10659g;
        if (r13 != null) goto L11;
        return;
    L11:
        Iterator<T> r14 = r13.iterator();
    L13:
        if (r14.hasNext() == false) goto L15;
        ((a) r14.next()).b();
        goto L13
    L15:
        this.f10662j = SelectKt.d();
        this.f10659g = null;
        return;
    }

    @Override // kotlinx.coroutines.selects.k
    public CoroutineContext getContext() {
        return this.f10658c;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
        g(r10);
        return Unit.INSTANCE;
    }

    @PublishedApi
    public Object r(Continuation<? super R> r10) {
        return s(this, r10);
    }

    @JvmName(name = "register")
    public final void z(SelectImplementation<R>.a r10, boolean r11) {
        if (n0.a() == true) goto L5;
    L12:
        AtomicReferenceFieldUpdater r12 = f10657k;
        if ((r12.get(this) instanceof a) == false) goto L15;
        return;
    L15:
        if (r11 == true) goto L18;
        o(r10.f10663a);
    L18:
        if (r10.e(this) == false) goto L22;
        if (r11 == true) goto L21;
        List<SelectImplementation<R>.a> r13 = this.f10659g;
        Intrinsics.checkNotNull(r13);
        r13.add(r10);
    L21:
        r10.f10669g = this.f10660h;
        r10.f10670h = this.f10661i;
        this.f10660h = null;
        this.f10661i = -1;
        return;
    L22:
        r12.set(this, r10);
        return;
    L5:
        if (f10657k.get(this) == SelectKt.e()) goto L7;
        boolean r14 = true;
    L8:
        if (r14 == true) goto L12;
        throw new AssertionError();
    L7:
        r14 = false;
        goto L8
    }
}
