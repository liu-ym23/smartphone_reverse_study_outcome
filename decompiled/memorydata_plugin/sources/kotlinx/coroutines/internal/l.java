package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cx;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\tJ\r\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b!J\u001f\u0010\"\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\f2\u0006\u0010$\u001a\u00020%H\u0010¢\u0006\u0002\b&J\u0015\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cH\u0000¢\u0006\u0002\b(J\u001f\u0010)\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010*\u001a\u00028\u0000H\u0000¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\n\u0018\u00010.j\u0004\u0018\u0001`/H\u0016J\r\u00100\u001a\u000201H\u0000¢\u0006\u0002\b2J\u0015\u00103\u001a\u0002012\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b4J\r\u00105\u001a\u00020 H\u0000¢\u0006\u0002\b6JE\u00107\u001a\u00020 2\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u0000092%\b\b\u0010:\u001a\u001f\u0012\u0013\u0012\u00110%¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b($\u0012\u0004\u0012\u00020 \u0018\u00010;H\u0080\b¢\u0006\u0004\b>\u0010?J\u0018\u0010@\u001a\u0002012\b\u0010A\u001a\u0004\u0018\u00010\fH\u0080\b¢\u0006\u0002\bBJ\u001e\u0010C\u001a\u00020 2\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u000009H\u0080\b¢\u0006\u0004\bD\u0010EJ\u001b\u0010F\u001a\u00020 2\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u000009H\u0016¢\u0006\u0002\u0010EJ\u000f\u0010G\u001a\u0004\u0018\u00010\fH\u0010¢\u0006\u0002\bHJ\b\u0010I\u001a\u00020JH\u0016J\u001b\u0010K\u001a\u0004\u0018\u00010%2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030LH\u0000¢\u0006\u0002\bMR\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004R\u001a\u0010\r\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006N"}, d2 = {"Lkotlinx/coroutines/internal/DispatchedContinuation;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/DispatchedTask;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/Continuation;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "continuation", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "_reusableCancellableContinuation", "Lkotlinx/atomicfu/AtomicRef;", "", "_state", "get_state$kotlinx_coroutines_core$annotations", "()V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "countOrElement", "delegate", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "reusableCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "getReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "awaitReusability", "", "awaitReusability$kotlinx_coroutines_core", "cancelCompletedResult", "takenState", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "claimReusableCancellableContinuation", "claimReusableCancellableContinuation$kotlinx_coroutines_core", "dispatchYield", EventBody.KEY_VALUE, "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "isReusable", "", "isReusable$kotlinx_coroutines_core", "postponeCancellation", "postponeCancellation$kotlinx_coroutines_core", "release", "release$kotlinx_coroutines_core", "resumeCancellableWith", "result", "Lkotlin/Result;", "onCancellation", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "resumeCancellableWith$kotlinx_coroutines_core", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeCancelled", "state", "resumeCancelled$kotlinx_coroutines_core", "resumeUndispatchedWith", "resumeUndispatchedWith$kotlinx_coroutines_core", "(Ljava/lang/Object;)V", "resumeWith", "takeState", "takeState$kotlinx_coroutines_core", "toString", "", "tryReleaseClaimedContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "tryReleaseClaimedContinuation$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class l<T> extends ax<T> implements Continuation<T>, CoroutineStackFrame {
    private static final /* synthetic */ AtomicReferenceFieldUpdater h = null;
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kotlinx.coroutines.ah f17584b;
    public final Continuation<T> c;
    public Object d;
    public final Object e;

    static {
        h = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_reusableCancellableContinuation$volatile");
    }

    public l(kotlinx.coroutines.ah r3, Continuation<? super T> r4) {
        Continuation<T> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        super(-1);
        this.f17584b = r3;
        this.c = r5;
        this.d = m.a();
        this.e = an.a(getContext());
    }

    private final kotlinx.coroutines.o<?> f() {
        Object r2 = h().get(this);
        if (ZeusTransformUtils.instanceOf(r2, kotlinx.coroutines.o.class) == true) goto L7;
        return null;
    L7:
        return (kotlinx.coroutines.o) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.o.class, "com.obric.memorydata.plugin");
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater h() {
        return h;
    }

    public final Throwable a(kotlinx.coroutines.n<?> r6) {
        kotlinx.coroutines.n r7 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        AtomicReferenceFieldUpdater r0 = h();
    L3:
        Object r2 = r0.get(this);
        if (r2 != m.f17585a) goto L9;
        if (h().compareAndSet(this, m.f17585a, r7) == false) goto L3;
        return null;
    L9:
        if (ZeusTransformUtils.instanceOf(r2, Throwable.class) == false) goto L17;
        if (h().compareAndSet(this, r2, null) == false) goto L15;
        return (Throwable) ZeusTransformUtils.preCheckCast(r2, Throwable.class, "com.obric.memorydata.plugin");
    L15:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L17:
        throw new IllegalStateException(("Inconsistent state " + r2).toString());
    }

    @Override // kotlinx.coroutines.ax
    public void a(Object r2, Throwable r3) {
        if (ZeusTransformUtils.instanceOf(r2, kotlinx.coroutines.ac.class) == false) goto L6;
        ((kotlinx.coroutines.ac) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.ac.class, "com.obric.memorydata.plugin")).f17207b.invoke(r3);
        return;
    }

    public final void a(CoroutineContext r3, T r4) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        this.d = r4;
        this.f17224a = 1;
        this.f17584b.dispatchYield(r5, (Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.memorydata.plugin"));
    }

    public final boolean a() {
        if (h().get(this) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean a(Throwable r5) {
        AtomicReferenceFieldUpdater r0 = h();
    L3:
        Object r1 = r0.get(this);
        if (Intrinsics.areEqual(r1, m.f17585a) == true) goto L6;
        if (ZeusTransformUtils.instanceOf(r1, Throwable.class) == true) goto L10;
        if (h().compareAndSet(this, r1, null) == false) goto L3;
        return false;
    L10:
        return true;
    L6:
        if (h().compareAndSet(this, m.f17585a, r5) == false) goto L3;
        return true;
    }

    public final void b() {
        AtomicReferenceFieldUpdater r0 = h();
    L4:
        if (r0.get(this) == m.f17585a) goto L4;
    }

    @Override // kotlinx.coroutines.ax
    public Continuation<T> c() {
        return (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
    }

    public final void d() {
        b();
        kotlinx.coroutines.o<?> r0 = f();
        if (r0 == null) goto L6;
        r0.j();
        return;
    }

    public final kotlinx.coroutines.o<T> e() {
        AtomicReferenceFieldUpdater r0 = h();
    L3:
        Object r1 = r0.get(this);
        if (r1 == null) goto L5;
        if (ZeusTransformUtils.instanceOf(r1, kotlinx.coroutines.o.class) == true) goto L10;
        if (r1 == m.f17585a) goto L3;
        if (ZeusTransformUtils.instanceOf(r1, Throwable.class) == true) goto L3;
        throw new IllegalStateException(("Inconsistent state " + r1).toString());
    L10:
        if (h().compareAndSet(this, r1, m.f17585a) == false) goto L3;
        return (kotlinx.coroutines.o) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.o.class, "com.obric.memorydata.plugin");
    L5:
        h().set(this, m.f17585a);
        return null;
    }

    @Override // kotlinx.coroutines.ax
    public Object g() {
        Object r0 = this.d;
        if (kotlinx.coroutines.an.a() == true) goto L5;
    L12:
        this.d = m.a();
        return r0;
    L5:
        if (r0 == m.a()) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L12;
        throw new AssertionError();
    L7:
        r1 = false;
        goto L8
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> r2 = this.c;
        if (ZeusTransformUtils.instanceOf(r2, CoroutineStackFrame.class) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) ZeusTransformUtils.preCheckCast(r2, CoroutineStackFrame.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.c.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r8) {
        CoroutineContext r0 = this.c.getContext();
        Object r3 = kotlinx.coroutines.ad.a(r8, null, 1, null);
        if (this.f17584b.isDispatchNeeded(r0) == false) goto L5;
        this.d = r3;
        this.f17224a = 0;
        this.f17584b.dispatch(r0, (Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        kotlinx.coroutines.an.a();
        bg r1 = cx.f17302a.a();
        if (r1.h() == false) goto L8;
        this.d = r3;
        this.f17224a = 0;
        r1.a((ax) ZeusTransformUtils.preCheckCast(this, ax.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        ax r4 = (ax) ZeusTransformUtils.preCheckCast(this, ax.class, "com.obric.memorydata.plugin");
        r1.a(true);
        CoroutineContext r5 = getContext();     // Catch: Throwable -> L18
        Object r6 = an.a(r5, this.e);     // Catch: Throwable -> L18
        this.c.resumeWith(r8);     // Catch: Throwable -> L15
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L15
        an.b(r5, r6);     // Catch: Throwable -> L18
    L13:
        if (r1.f() == true) goto L13;
    L20:
        r1.b(true);
        return;
    L15:
        th = move-exception;
        an.b(r5, r6);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r4.a(th, null);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r1.b(true);
        throw th;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f17584b + ", " + kotlinx.coroutines.ao.a(this.c) + ']';
    }
}
