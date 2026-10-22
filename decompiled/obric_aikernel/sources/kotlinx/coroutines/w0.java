package kotlinx.coroutines;

import kotlin.ExceptionsKt;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes3.dex */
@PublishedApi
@SourceDebugExtension({"SMAP\nDispatchedTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 6 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,222:1\n1#2:223\n107#3,10:224\n118#3,2:238\n220#4:234\n221#4:237\n61#5,2:235\n75#6:240\n*S KotlinDebug\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTask\n*L\n90#1:224,10\n90#1:238,2\n103#1:234\n103#1:237\n103#1:235,2\n142#1:240\n*E\n"})
public abstract class w0<T> extends gc.g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public int f10728h;

    public w0(int r10) {
        this.f10728h = r10;
    }

    public void b(Object r10, Throwable r11) {
    }

    public abstract Continuation<T> d();

    public Throwable e(Object r10) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T f(Object r10) {
        return r10;
    }

    public final void g(Throwable r10, Throwable r11) {
        if (r10 != null) goto L5;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10 == null) goto L8;
        if (r11 == null) goto L8;
        ExceptionsKt.addSuppressed(r10, r11);
    L8:
        if (r10 != null) goto L10;
        r10 = r11;
    L10:
        Intrinsics.checkNotNull(r10);
        i0.a(d().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", r10));
    }

    public abstract Object i();

    @Override // java.lang.Runnable
    public final void run() {
        if (n0.a() == true) goto L5;
    L12:
        gc.h r10 = this.f9107g;
        Continuation<T> r11 = d();     // Catch: Throwable -> L54
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");     // Catch: Throwable -> L54
        kotlinx.coroutines.internal.l r12 = (kotlinx.coroutines.internal.l) r11;     // Catch: Throwable -> L54
        Continuation<T> r13 = r12.f10560j;     // Catch: Throwable -> L54
        Object r14 = r12.f10562l;     // Catch: Throwable -> L54
        CoroutineContext r15 = r13.getContext();     // Catch: Throwable -> L54
        Object r16 = ThreadContextKt.c(r15, r14);     // Catch: Throwable -> L54
        if (r16 == ThreadContextKt.f10533a) goto L17;
        a3<?> r17 = CoroutineContextKt.g(r13, r15, r16);     // Catch: Throwable -> L54
    L66:
        CoroutineContext r18 = r13.getContext();     // Catch: Throwable -> L48
        Object r19 = i();     // Catch: Throwable -> L48
        Throwable r20 = e(r19);     // Catch: Throwable -> L48
        if (r20 == null) goto L21;
    L23:
        v1 r21 = null;
    L24:
        if (r21 != null) goto L26;
    L35:
        if (r20 == null) goto L37;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L48
        Object r23 = Result.m32constructorimpl(ResultKt.createFailure(r20));     // Catch: Throwable -> L48
    L34:
        r13.resumeWith(r23);     // Catch: Throwable -> L48
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L48
        if (r17 != null) goto L41;
    L42:
        ThreadContextKt.a(r15, r16);     // Catch: Throwable -> L54
    L63:
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L45
        r10.a();     // Catch: Throwable -> L45
        Object r26 = Result.m32constructorimpl(r24);     // Catch: Throwable -> L45
    L47:
        g(null, Result.m35exceptionOrNullimpl(r26));
        return;
    L45:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r26 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L47
    L41:
        if (r17.j1() == false) goto L63;
    L37:
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L48
        r23 = Result.m32constructorimpl(f(r19));     // Catch: Throwable -> L48
        goto L34
    L26:
        if (r21.isActive() == true) goto L35;
        Throwable r29 = r21.p();     // Catch: Throwable -> L48
        b(r19, r29);     // Catch: Throwable -> L48
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L48
        if (n0.d() == true) goto L30;
    L33:
        r23 = Result.m32constructorimpl(ResultKt.createFailure(r29));     // Catch: Throwable -> L48
        goto L34
    L30:
        if ((r13 instanceof CoroutineStackFrame) == false) goto L33;
        r29 = kotlinx.coroutines.internal.h0.a(r29, (CoroutineStackFrame) r13);     // Catch: Throwable -> L48
        goto L33
    L21:
        if (x0.b(this.f10728h) == false) goto L23;
        r21 = (v1) r18.get(v1.f10723e);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        if (r17 != null) goto L51;
    L52:
        ThreadContextKt.a(r15, r16);     // Catch: Throwable -> L54
    L53:
        throw th;     // Catch: Throwable -> L54
    L51:
        if (r17.j1() == false) goto L53;
    L17:
        r17 = null;
    L54:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L57
        r10.a();     // Catch: Throwable -> L57
        Object r32 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L57
    L59:
        g(th, Result.m35exceptionOrNullimpl(r32));
        return;
    L57:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r32 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L59
    L5:
        if (this.f10728h == (-1)) goto L7;
        boolean r34 = true;
    L8:
        if (r34 == true) goto L12;
        throw new AssertionError();
    L7:
        r34 = false;
        goto L8
    }
}
