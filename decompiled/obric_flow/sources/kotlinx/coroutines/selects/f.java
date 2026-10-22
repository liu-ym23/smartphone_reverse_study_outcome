package kotlinx.coroutines.selects;

import com.bytedance.ies.web.jsbridge2.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.k;
import kotlinx.coroutines.l;
import kotlinx.coroutines.t0;

/* JADX INFO: loaded from: classes3.dex */
public class f implements kotlinx.coroutines.i, h {
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f19004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f19005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f19006c;
    public int d;
    public Object e;
    private volatile /* synthetic */ Object state$volatile;

    static {
        f = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "state$volatile");
    }

    public f(CoroutineContext r5) {
        this.f19004a = r5;
        this.state$volatile = b.f18996a;
        this.f19005b = new ArrayList(2);
        this.d = -1;
        this.e = b.d;
    }

    @Override // kotlinx.coroutines.i2
    public final void a(s r5, int r10) {
        this.f19006c = r5;
        this.d = r10;
    }

    @Override // kotlinx.coroutines.i
    public final void b(Throwable r5) {
    L2:
        AtomicReferenceFieldUpdater r10 = f;
        Object r11 = r10.get(this);
        if (r11 == b.f18997b) goto L4;
        g8.g r12 = b.f18998c;
    L7:
        if (r10.compareAndSet(this, r11, r12) == true) goto L8;
        if (r10.get(this) == r11) goto L7;
    L8:
        ArrayList r13 = this.f19005b;
        if (r13 != null) goto L11;
        return;
    L11:
        Iterator r14 = r13.iterator();
    L13:
        if (r14.hasNext() == false) goto L15;
        ((e) r14.next()).a();
        goto L13
    L15:
        this.e = b.d;
        this.f19005b = null;
        return;
    }

    @Override // kotlinx.coroutines.selects.g
    public final void c(Object r5) {
        this.e = r5;
    }

    @Override // kotlinx.coroutines.selects.g
    public final void d(t0 r5) {
        this.f19006c = r5;
    }

    @Override // kotlinx.coroutines.selects.g
    public final boolean e(Object r5, Object r10) {
        if (l(r5, r10) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final Object f(ContinuationImpl r10) {
        AtomicReferenceFieldUpdater r5 = f;
        Object r11 = r5.get(this);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        e r12 = (e) r11;
        Object r13 = this.e;
        ArrayList r14 = this.f19005b;
        if (r14 == null) goto L12;
        Iterator r15 = r14.iterator();
    L7:
        if (r15.hasNext() == false) goto L11;
        e r16 = (e) r15.next();
        if (r16 == r12) goto L7;
        r16.a();
        goto L7
    L11:
        r5.set(this, b.f18997b);
        this.e = b.d;
        this.f19005b = null;
    L12:
        Object r17 = r12.f18999a;
        g8.g r18 = r12.d;
        Object r19 = r12.f19001c.invoke(r17, r18, r13);
        g8.g r20 = b.e;
        Function r21 = r12.e;
        if (r12.d != r20) goto L15;
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
        return ((Function1) r21).invoke(r10);
    L15:
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
        return ((Function2) r21).mo2invoke(r19, r10);
    }

    public Object g(ContinuationImpl r5) {
        if ((f.get(this) instanceof e) == false) goto L6;
        return f(r5);
    L6:
        return h(r5);
    }

    @Override // kotlinx.coroutines.selects.g
    public final CoroutineContext getContext() {
        return this.f19004a;
    }

    public final Object h(ContinuationImpl r10) {
        if ((r10 instanceof SelectImplementation$doSelectSuspend$1) == false) goto L7;
        SelectImplementation$doSelectSuspend$1 r5 = (SelectImplementation$doSelectSuspend$1) r10;
        int r11 = r5.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r5.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r5.label;
        if (r14 == 0) goto L16;
        if (r14 == 1) goto L15;
        if (r14 != 2) goto L14;
        ResultKt.throwOnFailure(r12);
    L55:
        return r12;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        f this = (f) r5.L$0;
        ResultKt.throwOnFailure(r12);
    L52:
        r5.L$0 = null;
        r5.label = 2;
        r12 = this.f(r5);
        if (r12 != r13) goto L55;
        return r13;
    L16:
        ResultKt.throwOnFailure(r12);
        r5.L$0 = this;
        r5.label = 1;
        l r15 = new l(1, IntrinsicsKt.intercepted(r5));
        r15.w();
    L17:
        AtomicReferenceFieldUpdater r16 = f;
        Object r17 = r16.get(this);
        g8.g r18 = b.f18996a;
        if (r17 == r18) goto L20;
        if ((r17 instanceof List) == false) goto L37;
    L28:
        if (r16.compareAndSet(this, r17, r18) == true) goto L29;
        if (r16.get(this) == r17) goto L28;
    L29:
        Iterator r19 = ((Iterable) r17).iterator();
    L31:
        if (r19.hasNext() == false) goto L17;
        e r20 = i(r19.next());
        Intrinsics.checkNotNull(r20);
        r20.g = null;
        r20.f19002h = -1;
        k(r20, true);
        goto L31
    L37:
        if ((r17 instanceof e) == false) goto L57;
        Unit r21 = Unit.INSTANCE;
        e r22 = (e) r17;
        Object r23 = this.e;
        Function3 r24 = r22.f;
        if (r24 == null) goto L41;
        Function3 r25 = (Function3) r24.invoke(this, r22.d, r23);
    L42:
        r15.k(r21, r25);
    L43:
        Object r110 = r15.v();
        if (r110 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L47;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L47:
        if (r110 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L50;
        r110 = Unit.INSTANCE;
    L50:
        if (r110 != r13) goto L52;
        return r13;
    L41:
        r25 = null;
        goto L42
    L57:
        throw new IllegalStateException(("unexpected state: " + r17).toString());
    L20:
        if (r16.compareAndSet(this, r17, r15) == true) goto L21;
        if (r16.get(this) == r17) goto L20;
    L21:
        r15.z(this);
    L7:
        r5 = new SelectImplementation$doSelectSuspend$1(this, r10);
        goto L8
    }

    public final e i(Object r5) {
        ArrayList r10 = this.f19005b;
        Object r11 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        Iterator r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        Object r13 = r12.next();
        if (((e) r13).f18999a != r5) goto L7;
        r11 = r13;
    L11:
        e r14 = (e) r11;
        if (r14 == null) goto L15;
        return r14;
    L15:
        throw new IllegalStateException(("Clause with object " + r5 + " is not found").toString());
    }

    public final void j(p r10, Function2 r11) {
        kotlinx.coroutines.channels.f r5 = (kotlinx.coroutines.channels.f) r10.f6303b;
        k r12 = (k) r10.e;
        k(new e(this, r5, (Function3) r10.f6304c, (Function3) r10.d, null, r11, r12), false);
    }

    public final void k(e r5, boolean r10) {
        AtomicReferenceFieldUpdater r11 = f;
        if ((r11.get(this) instanceof e) == false) goto L5;
        return;
    L5:
        Object r12 = r5.f18999a;
        if (r10 == true) goto L20;
        ArrayList r13 = this.f19005b;
        Intrinsics.checkNotNull(r13);
        if (r13 != null) goto L10;
    L12:
        Iterator r14 = r13.iterator();
    L14:
        if (r14.hasNext() == false) goto L20;
        if (((e) r14.next()).f18999a != r12) goto L14;
        throw new IllegalStateException(("Cannot use select clauses on the same object: " + r12).toString());
    L10:
        if (r13.isEmpty() == false) goto L12;
    L20:
        r5.f19000b.invoke(r12, this, r5.d);
        if (this.e != b.d) goto L25;
        if (r10 == true) goto L24;
        ArrayList r15 = this.f19005b;
        Intrinsics.checkNotNull(r15);
        r15.add(r5);
    L24:
        r5.g = this.f19006c;
        r5.f19002h = this.d;
        this.f19006c = null;
        this.d = -1;
        return;
    L25:
        r11.set(this, r5);
    }

    public final int l(Object r10, Object r11) {
    L2:
        AtomicReferenceFieldUpdater r5 = f;
        Object r12 = r5.get(this);
        if ((r12 instanceof kotlinx.coroutines.j) == true) goto L4;
        if (Intrinsics.areEqual(r12, b.f18997b) == true) goto L50;
        if ((r12 instanceof e) == true) goto L73;
        if (Intrinsics.areEqual(r12, b.f18998c) == true) goto L29;
        if (Intrinsics.areEqual(r12, b.f18996a) == true) goto L32;
        if ((r12 instanceof List) == false) goto L49;
        List r13 = CollectionsKt.plus((Collection) r12, r10);
    L43:
        if (r5.compareAndSet(this, r12, r13) == true) goto L44;
        if (r5.get(this) == r12) goto L43;
    L44:
        return 1;
    L49:
        throw new IllegalStateException(("Unexpected state: " + r12).toString());
    L32:
        List r14 = CollectionsKt.listOf(r10);
    L34:
        if (r5.compareAndSet(this, r12, r14) == true) goto L35;
        if (r5.get(this) == r12) goto L34;
    L35:
        return 1;
    L29:
        return 2;
    L73:
        return 3;
    L50:
        return 3;
    L4:
        e r15 = i(r10);
        if (r15 == null) goto L2;
        Function3 r16 = r15.f;
        if (r16 == null) goto L10;
        Function3 r17 = (Function3) r16.invoke(this, r15.d, r11);
    L12:
        if (r5.compareAndSet(this, r12, r15) == true) goto L13;
        if (r5.get(this) == r12) goto L12;
    L13:
        kotlinx.coroutines.j r18 = (kotlinx.coroutines.j) r12;
        this.e = r11;
        g8.g r19 = r18.c(Unit.INSTANCE, r17);
        if (r19 != null) goto L17;
        this.e = b.d;
        return 2;
    L17:
        r18.s(r19);
        return 0;
    L10:
        r17 = null;
        goto L12
    }
}
