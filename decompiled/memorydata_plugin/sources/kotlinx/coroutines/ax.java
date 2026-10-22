package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000f\b!\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u000f\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0002\b\u0014J\u001f\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\u001bJ\u0006\u0010\u001c\u001a\u00020\fJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u000eH ¢\u0006\u0002\b\u001eR\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX \u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelCompletedResult", "", "takenState", "", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "getExceptionalResult", "state", "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "finallyException", "handleFatalException$kotlinx_coroutines_core", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class ax<T> extends kotlinx.coroutines.scheduling.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17224a;

    public ax(int r1) {
        this.f17224a = r1;
    }

    public void a(Object r1, Throwable r2) {
    }

    public final void a(Throwable r3, Throwable r4) {
        if (r3 != null) goto L5;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == null) goto L8;
        if (r4 == null) goto L8;
        ExceptionsKt.addSuppressed(r3, r4);
    L8:
        if (r3 != null) goto L10;
        r3 = r4;
    L10:
        Intrinsics.checkNotNull(r3);
        ai.a(c().getContext(), (Throwable) ZeusTransformUtils.preCheckCast(new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", r3), Throwable.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T b(Object r1) {
        return r1;
    }

    public Throwable c(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, ab.class) == false) goto L5;
        ab r2 = (ab) ZeusTransformUtils.preCheckCast(r3, ab.class, "com.obric.memorydata.plugin");
    L6:
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2.f17205a;
    L5:
        r2 = null;
        goto L6
    }

    public abstract Continuation<T> c();

    public abstract Object g();

    @Override // java.lang.Runnable
    public final void run() {
        if (an.a() == true) goto L5;
    L12:
        kotlinx.coroutines.scheduling.h r1 = this.g;
        Continuation<T> r2 = c();     // Catch: Throwable -> L55
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");     // Catch: Throwable -> L55
        kotlinx.coroutines.internal.l r3 = (kotlinx.coroutines.internal.l) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.internal.l.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L55
        Continuation<T> r4 = r3.c;     // Catch: Throwable -> L55
        Object r5 = r3.e;     // Catch: Throwable -> L55
        CoroutineContext r6 = r4.getContext();     // Catch: Throwable -> L55
        Object r7 = kotlinx.coroutines.internal.an.a(r6, r5);     // Catch: Throwable -> L55
        if (r7 == kotlinx.coroutines.internal.an.f17564a) goto L17;
        dc<?> r8 = ag.a(r4, r6, r7);     // Catch: Throwable -> L55
    L67:
        CoroutineContext r9 = r4.getContext();     // Catch: Throwable -> L49
        Object r10 = g();     // Catch: Throwable -> L49
        Throwable r11 = c(r10);     // Catch: Throwable -> L49
        if (r11 == null) goto L21;
    L23:
        bx r12 = null;
    L24:
        if (r12 != null) goto L26;
    L36:
        if (r11 == null) goto L38;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L49
        Object r14 = Result.m1421constructorimpl(ResultKt.createFailure(r11));     // Catch: Throwable -> L49
    L35:
        r4.resumeWith(r14);     // Catch: Throwable -> L49
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L49
        if (r8 != null) goto L42;
    L43:
        kotlinx.coroutines.internal.an.b(r6, r7);     // Catch: Throwable -> L55
    L64:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L46
        ax r0 = (ax) ZeusTransformUtils.preCheckCast(this, ax.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        r1.b();     // Catch: Throwable -> L46
        Object r17 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L46
    L48:
        a(null, Result.m1424exceptionOrNullimpl(r17));
        return;
    L46:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L48
    L42:
        if (r8.g() == false) goto L64;
    L38:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L49
        r14 = Result.m1421constructorimpl(b(r10));     // Catch: Throwable -> L49
        goto L35
    L26:
        if (r12.a() == true) goto L36;
        CancellationException r20 = r12.t_();     // Catch: Throwable -> L49
        a(r10, (Throwable) ZeusTransformUtils.preCheckCast(r20, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L49
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L49
        if (an.c() == true) goto L30;
    L33:
        Throwable r22 = (Throwable) ZeusTransformUtils.preCheckCast(r20, Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L49
    L34:
        r14 = Result.m1421constructorimpl(ResultKt.createFailure(r22));     // Catch: Throwable -> L49
        goto L35
    L30:
        if (ZeusTransformUtils.instanceOf(r4, CoroutineStackFrame.class) == false) goto L33;
        r22 = kotlinx.coroutines.internal.ai.a((Throwable) ZeusTransformUtils.preCheckCast(r20, Throwable.class, "com.obric.memorydata.plugin"), (CoroutineStackFrame) ZeusTransformUtils.preCheckCast(r4, CoroutineStackFrame.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L49
        goto L34
    L21:
        if (ay.a(this.f17224a) == false) goto L23;
        r12 = (bx) ZeusTransformUtils.preCheckCast(r9.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        if (r8 != null) goto L52;
    L53:
        kotlinx.coroutines.internal.an.b(r6, r7);     // Catch: Throwable -> L55
    L54:
        throw th;     // Catch: Throwable -> L55
    L52:
        if (r8.g() == false) goto L54;
    L17:
        r8 = null;
    L55:
        th = move-exception;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L58
        r1.b();     // Catch: Throwable -> L58
        Object r24 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L58
    L60:
        a(th, Result.m1424exceptionOrNullimpl(r24));
        return;
    L58:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r24 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L60
    L5:
        if (this.f17224a == (-1)) goto L7;
        boolean r26 = true;
    L8:
        if (r26 == true) goto L12;
        throw new AssertionError();
    L7:
        r26 = false;
        goto L8
    }
}
