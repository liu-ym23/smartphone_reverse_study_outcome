package kotlinx.coroutines;

import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u00052\u00020\u0006B\u001b\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103J\u001a\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002042\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0017\u00105\u001a\u00020/2\f\u00106\u001a\b\u0012\u0004\u0012\u00020/07H\u0082\bJ1\u00108\u001a\u00020/2!\u00109\u001a\u001d\u0012\u0013\u0012\u001103¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/0:2\u0006\u00102\u001a\u000203J\u001e\u0010=\u001a\u00020/2\n\u0010>\u001a\u0006\u0012\u0002\b\u00030?2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0012\u0010@\u001a\u00020\u001d2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001f\u0010A\u001a\u00020/2\b\u0010B\u001a\u0004\u0018\u00010\u00122\u0006\u00102\u001a\u000203H\u0010¢\u0006\u0002\bCJ\u0010\u0010D\u001a\u00020\u001d2\u0006\u00102\u001a\u000203H\u0002J\u0010\u0010E\u001a\u00020/2\u0006\u0010F\u001a\u00020\u0012H\u0016J\r\u0010G\u001a\u00020/H\u0000¢\u0006\u0002\bHJ\b\u0010I\u001a\u00020/H\u0002J\u0010\u0010J\u001a\u00020/2\u0006\u0010K\u001a\u00020\nH\u0002J\u0010\u0010L\u001a\u0002032\u0006\u0010M\u001a\u00020NH\u0016J\u0019\u0010O\u001a\u0004\u0018\u0001032\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0010¢\u0006\u0002\bPJ\n\u0010Q\u001a\u0004\u0018\u00010\u0012H\u0001J\u0010\u0010R\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`TH\u0016J\u001f\u0010U\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0010¢\u0006\u0004\bV\u0010WJ\b\u0010X\u001a\u00020/H\u0016J\n\u0010Y\u001a\u0004\u0018\u00010\u0010H\u0002J1\u0010Z\u001a\u00020/2'\u00100\u001a#\u0012\u0015\u0012\u0013\u0018\u000103¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/0:j\u0002`[H\u0016J\u001c\u0010Z\u001a\u00020/2\n\u0010>\u001a\u0006\u0012\u0002\b\u00030?2\u0006\u0010\\\u001a\u00020\nH\u0016J\u0010\u0010]\u001a\u00020/2\u0006\u00100\u001a\u00020\u0012H\u0002J\u0015\u0010^\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0000¢\u0006\u0002\b_J\b\u0010`\u001a\u00020\u001dH\u0002J\u001a\u0010a\u001a\u00020/2\u0006\u00100\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010b\u001a\u00020(H\u0014J\u0015\u0010c\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\bdJ\r\u0010e\u001a\u00020/H\u0000¢\u0006\u0002\bfJ\b\u0010g\u001a\u00020\u001dH\u0001J:\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00028\u00002#\u00109\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u00010:H\u0016¢\u0006\u0002\u0010jJA\u0010k\u001a\u00020/2\b\u0010-\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2%\b\u0002\u00109\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u00010:H\u0002J\u001b\u0010l\u001a\u00020/2\f\u0010m\u001a\b\u0012\u0004\u0012\u00028\u00000nH\u0016¢\u0006\u0002\u0010oJS\u0010p\u001a\u0004\u0018\u00010\u00122\u0006\u0010$\u001a\u00020q2\b\u0010-\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2#\u00109\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u00010:2\b\u0010r\u001a\u0004\u0018\u00010\u0012H\u0002J\u000f\u0010s\u001a\u0004\u0018\u00010\u0012H\u0010¢\u0006\u0002\btJ\b\u0010u\u001a\u00020(H\u0016J\b\u0010v\u001a\u00020\u001dH\u0002J!\u0010v\u001a\u0004\u0018\u00010\u00122\u0006\u0010i\u001a\u00028\u00002\b\u0010r\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010wJF\u0010v\u001a\u0004\u0018\u00010\u00122\u0006\u0010i\u001a\u00028\u00002\b\u0010r\u001a\u0004\u0018\u00010\u00122#\u00109\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u00010:H\u0016¢\u0006\u0002\u0010xJC\u0010y\u001a\u0004\u0018\u00010z2\b\u0010-\u001a\u0004\u0018\u00010\u00122\b\u0010r\u001a\u0004\u0018\u00010\u00122#\u00109\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u00010:H\u0002J\u0012\u0010{\u001a\u0004\u0018\u00010\u00122\u0006\u0010|\u001a\u000203H\u0016J\b\u0010}\u001a\u00020\u001dH\u0002J\u001a\u0010~\u001a\u00020/*\u00020\u007f2\u0006\u0010i\u001a\u00028\u0000H\u0016¢\u0006\u0003\u0010\u0080\u0001J\u0015\u0010\u0081\u0001\u001a\u00020/*\u00020\u007f2\u0006\u0010|\u001a\u000203H\u0016R\t\u0010\f\u001a\u00020\rX\u0082\u0004R\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004R\u0011\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000fX\u0082\u0004R\u001c\u0010\u0013\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001eR\u0014\u0010 \u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0016\u0010!\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00010\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006\u0082\u0001"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/Waiter;", "delegate", "Lkotlin/coroutines/Continuation;", "resumeMode", "", "(Lkotlin/coroutines/Continuation;I)V", "_decisionAndIndex", "Lkotlinx/atomicfu/AtomicInt;", "_parentHandle", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/DisposableHandle;", "_state", "", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "", "()Z", "isCancelled", "isCompleted", "parentHandle", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "stateDebugRepresentation", "", "getStateDebugRepresentation", "()Ljava/lang/String;", "alreadyResumedError", "", "proposedUpdate", "callCancelHandler", "", "handler", "Lkotlinx/coroutines/CancelHandler;", "cause", "", "Lkotlinx/coroutines/InternalCompletionHandler;", "callCancelHandlerSafely", "block", "Lkotlin/Function0;", "callOnCancellation", "onCancellation", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "callSegmentOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "cancelCompletedResult", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "cancelLater", "completeResume", "token", "detachChild", "detachChild$kotlinx_coroutines_core", "detachChildIfNonResuable", "dispatchResume", "mode", "getContinuationCancellationCause", "parent", "Lkotlinx/coroutines/Job;", "getExceptionalResult", "getExceptionalResult$kotlinx_coroutines_core", "getResult", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "initCancellability", "installParentHandle", "invokeOnCancellation", "Lkotlinx/coroutines/CompletionHandler;", "index", "invokeOnCancellationImpl", "invokeOnCancellationInternal", "invokeOnCancellationInternal$kotlinx_coroutines_core", "isReusable", "multipleHandlersError", "nameString", "parentCancelled", "parentCancelled$kotlinx_coroutines_core", "releaseClaimedReusableContinuation", "releaseClaimedReusableContinuation$kotlinx_coroutines_core", "resetStateReusable", "resume", EventBody.KEY_VALUE, "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeImpl", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "resumedState", "Lkotlinx/coroutines/NotCompleted;", "idempotent", "takeState", "takeState$kotlinx_coroutines_core", "toString", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "tryResumeImpl", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeWithException", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "trySuspend", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class o<T> extends ax<T> implements CoroutineStackFrame, de, n<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater d = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater e = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater h = null;
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Continuation<T> f17608b;
    private final CoroutineContext c;

    static {
        d = AtomicIntegerFieldUpdater.newUpdater(o.class, "_decisionAndIndex$volatile");
        e = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_state$volatile");
        h = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_parentHandle$volatile");
    }

    public o(Continuation<? super T> r3, int r4) {
        Continuation<T> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        super(r4);
        this.f17608b = r5;
        if (an.a() == true) goto L5;
    L12:
        this.c = r5.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = d.f17307a;
        return;
    L5:
        if (r4 == (-1)) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L12;
        throw new AssertionError();
    L7:
        r6 = false;
        goto L8
    }

    private final Object a(cm r10, Object r11, int r12, Function1<? super Throwable, Unit> r13, Object r14) {
        cm r9 = (cm) ZeusTransformUtils.wrapperContextForParams(r10, cm.class, "com.obric.memorydata.plugin");
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, ab.class) == false) goto L23;
        boolean r15 = true;
        if (an.a() == false) goto L14;
        if (r14 != null) goto L8;
        boolean r16 = true;
    L9:
        if (r16 == true) goto L14;
        throw new AssertionError();
    L8:
        r16 = false;
    L14:
        if (an.a() == false) goto L36;
        if (r4 == null) goto L18;
        r15 = false;
    L18:
        if (r15 == false) goto L21;
        return r11;
    L21:
        throw new AssertionError();
    L36:
        return r11;
    L23:
        if (ay.a(r12) == true) goto L26;
        if (r14 != null) goto L26;
        return r11;
    L26:
        if (r4 != null) goto L31;
        if (ZeusTransformUtils.instanceOf(r9, m.class) == true) goto L31;
        if (r14 != null) goto L31;
        return r11;
    L31:
        if (ZeusTransformUtils.instanceOf(r9, m.class) == false) goto L33;
        m r17 = (m) ZeusTransformUtils.preCheckCast(r9, m.class, "com.obric.memorydata.plugin");
    L35:
        return new aa(r11, r17, r4, r14, null, 16, null);
    L33:
        r17 = null;
        goto L35
    }

    private final void a(int r3) {
        if (p() == false) goto L5;
        return;
    L5:
        ay.a((ax) ZeusTransformUtils.preCheckCast(this, ax.class, "com.obric.memorydata.plugin"), r3);
    }

    private final void a(Object r10, int r11, Function1<? super Throwable, Unit> r12) {
        Function1<? super Throwable, Unit> r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        AtomicReferenceFieldUpdater r0 = t();
    L3:
        Object r8 = r0.get(this);
        if (ZeusTransformUtils.instanceOf(r8, cm.class) == false) goto L10;
        Object r2 = a((cm) ZeusTransformUtils.preCheckCast(r8, cm.class, "com.obric.memorydata.plugin"), r10, r11, r13, null);
        if (t().compareAndSet(this, r8, r2) == false) goto L3;
        r();
        a(r11);
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r8, r.class) == true) goto L12;
    L16:
        e(r10);
        throw new KotlinNothingValueException();
    L12:
        if (((r) ZeusTransformUtils.preCheckCast(r8, r.class, "com.obric.memorydata.plugin")).a() == false) goto L16;
        if (r13 == null) goto L21;
        a(r13, ((r) ZeusTransformUtils.preCheckCast(r8, r.class, "com.obric.memorydata.plugin")).f17205a);
        return;
    }

    private final void a(Object r3, Object r4) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + r3 + ", already has " + r4).toString());
    }

    private final void a(kotlinx.coroutines.internal.ag<?> r4, Throwable r5) {
        int r0 = s().get(this) & 536870911;
        if (r0 == 536870911) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L13;
        r4.a(r0, r5, getContext());     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        ai.a(getContext(), (Throwable) ZeusTransformUtils.preCheckCast(new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th), Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L13:
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
    L5:
        r1 = false;
        goto L6
    }

    static /* synthetic */ void a(o r2, Object r3, int r4, Function1 r5, int r6, Object r7) {
        Function1<? super Throwable, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 4) == 0) goto L7;
        r8 = null;
    L7:
        r2.a(r3, r4, r8);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final kotlinx.coroutines.internal.aj b(Object r10, Object r11, Function1<? super Throwable, Unit> r12) {
        Function1<? super Throwable, Unit> r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        AtomicReferenceFieldUpdater r0 = t();
    L3:
        Object r8 = r0.get(this);
        if (ZeusTransformUtils.instanceOf(r8, cm.class) == false) goto L10;
        Object r2 = a((cm) ZeusTransformUtils.preCheckCast(r8, cm.class, "com.obric.memorydata.plugin"), r10, this.f17224a, r13, r11);
        if (t().compareAndSet(this, r8, r2) == false) goto L3;
        r();
        return p.f17609a;
    L10:
        if (ZeusTransformUtils.instanceOf(r8, aa.class) == false) goto L26;
        if (r11 != null) goto L13;
        return null;
    L13:
        if (((aa) ZeusTransformUtils.preCheckCast(r8, aa.class, "com.obric.memorydata.plugin")).d == r11) goto L15;
        return null;
    L15:
        if (an.a() == false) goto L22;
        if (Intrinsics.areEqual(((aa) ZeusTransformUtils.preCheckCast(r8, aa.class, "com.obric.memorydata.plugin")).f17202a, r10) == true) goto L22;
        throw new AssertionError();
    L22:
        return p.f17609a;
    L26:
        return null;
    }

    private final void d(Object r22) {
        if (an.a() == true) goto L5;
    L15:
        AtomicReferenceFieldUpdater r2 = t();
    L16:
        Object r12 = r2.get(this);
        if (ZeusTransformUtils.instanceOf(r12, d.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r12, m.class) == false) goto L24;
        boolean r4 = true;
    L25:
        if (r4 == true) goto L26;
        if (ZeusTransformUtils.instanceOf(r12, ab.class) == true) goto L30;
        if (ZeusTransformUtils.instanceOf(r12, aa.class) == true) goto L48;
        if (ZeusTransformUtils.instanceOf(r22, kotlinx.coroutines.internal.ag.class) == true) goto L62;
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
        m r5 = (m) ZeusTransformUtils.preCheckCast(r22, m.class, "com.obric.memorydata.plugin");
        if (t().compareAndSet(this, r12, new aa(r12, (m) ZeusTransformUtils.preCheckCast(r22, m.class, "com.obric.memorydata.plugin"), null, null, null, 28, null)) == false) goto L16;
        return;
    L62:
        return;
    L48:
        if (((aa) ZeusTransformUtils.preCheckCast(r12, aa.class, "com.obric.memorydata.plugin")).f17203b == null) goto L51;
        a(r22, r12);
    L51:
        if (ZeusTransformUtils.instanceOf(r22, kotlinx.coroutines.internal.ag.class) == true) goto L52;
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
        m r6 = (m) ZeusTransformUtils.preCheckCast(r22, m.class, "com.obric.memorydata.plugin");
        if (((aa) ZeusTransformUtils.preCheckCast(r12, aa.class, "com.obric.memorydata.plugin")).a() == true) goto L55;
        if (t().compareAndSet(this, r12, aa.a((aa) ZeusTransformUtils.preCheckCast(r12, aa.class, "com.obric.memorydata.plugin"), null, (m) ZeusTransformUtils.preCheckCast(r22, m.class, "com.obric.memorydata.plugin"), null, null, null, 29, null)) == false) goto L16;
        return;
    L55:
        a((m) ZeusTransformUtils.preCheckCast(r22, m.class, "com.obric.memorydata.plugin"), ((aa) ZeusTransformUtils.preCheckCast(r12, aa.class, "com.obric.memorydata.plugin")).e);
        return;
    L52:
        return;
    L30:
        if (((ab) ZeusTransformUtils.preCheckCast(r12, ab.class, "com.obric.memorydata.plugin")).c() == true) goto L33;
        a(r22, r12);
    L33:
        if (ZeusTransformUtils.instanceOf(r12, r.class) == false) goto L84;
        Throwable r3 = null;
        if (ZeusTransformUtils.instanceOf(r12, ab.class) == false) goto L37;
        ab r7 = (ab) ZeusTransformUtils.preCheckCast(r12, ab.class, "com.obric.memorydata.plugin");
    L38:
        if (r7 == null) goto L41;
        r3 = r7.f17205a;
    L41:
        if (ZeusTransformUtils.instanceOf(r22, m.class) == false) goto L43;
        a((m) ZeusTransformUtils.preCheckCast(r22, m.class, "com.obric.memorydata.plugin"), r3);
        return;
    L43:
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
        a((kotlinx.coroutines.internal.ag) ZeusTransformUtils.preCheckCast(r22, kotlinx.coroutines.internal.ag.class, "com.obric.memorydata.plugin"), r3);
        return;
    L37:
        r7 = null;
        goto L38
    L84:
        return;
    L26:
        a(r22, r12);
        goto L16
    L24:
        r4 = ZeusTransformUtils.instanceOf(r12, kotlinx.coroutines.internal.ag.class);
        goto L25
    L19:
        if (t().compareAndSet(this, r12, r22) == false) goto L16;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r22, m.class) == false) goto L7;
    L10:
        boolean r8 = true;
    L11:
        if (r8 == true) goto L15;
        throw new AssertionError();
    L7:
        if (ZeusTransformUtils.instanceOf(r22, kotlinx.coroutines.internal.ag.class) == true) goto L10;
        r8 = false;
        goto L11
    }

    private final boolean d(Throwable r3) {
        if (n() == true) goto L6;
        return false;
    L6:
        Continuation<T> r2 = this.f17608b;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((kotlinx.coroutines.internal.l) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.internal.l.class, "com.obric.memorydata.plugin")).a(r3);
    }

    private final Void e(Object r3) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + r3).toString());
    }

    private final bc l() {
        return (bc) ZeusTransformUtils.preCheckCast(u().get(this), bc.class, "com.obric.memorydata.plugin");
    }

    private final String m() {
        Object r1 = d();
        if (ZeusTransformUtils.instanceOf(r1, cm.class) == false) goto L6;
        return "Active";
    L6:
        if (ZeusTransformUtils.instanceOf(r1, r.class) == false) goto L8;
        return "Cancelled";
    L8:
        return "Completed";
    }

    private final boolean n() {
        if (ay.b(this.f17224a) == false) goto L7;
        Continuation<T> r2 = this.f17608b;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        if (((kotlinx.coroutines.internal.l) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.internal.l.class, "com.obric.memorydata.plugin")).a() == false) goto L7;
        return true;
    L7:
        return false;
    }

    private final boolean o() {
        AtomicIntegerFieldUpdater r0 = s();
    L3:
        int r1 = r0.get(this);
        int r2 = r1 >> 29;
        if (r2 != 0) goto L6;
        if (s().compareAndSet(this, r1, SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING + (536870911 & r1)) == false) goto L3;
        return true;
    L6:
        if (r2 != 2) goto L10;
        return false;
    L10:
        throw new IllegalStateException("Already suspended".toString());
    }

    private final boolean p() {
        AtomicIntegerFieldUpdater r0 = s();
    L3:
        int r1 = r0.get(this);
        int r2 = r1 >> 29;
        if (r2 != 0) goto L5;
        if (s().compareAndSet(this, r1, 1073741824 + (536870911 & r1)) == false) goto L3;
        return true;
    L5:
        if (r2 != 1) goto L9;
        return false;
    L9:
        throw new IllegalStateException("Already resumed".toString());
    }

    private final bc q() {
        bx r4 = (bx) ZeusTransformUtils.preCheckCast(getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        bc r1 = ca.a(r4, true, false, (bt) ZeusTransformUtils.preCheckCast(new s(this), bt.class, "com.obric.memorydata.plugin"), 2, null);
        u().compareAndSet(this, null, r1);
        return r1;
    }

    private final void r() {
        if (n() == true) goto L6;
        j();
        return;
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater s() {
        return d;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater t() {
        return e;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater u() {
        return h;
    }

    @Override // kotlinx.coroutines.n
    public Object a(T r3, Object r4, Function1<? super Throwable, Unit> r5) {
        return b(r3, r4, (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.coroutines.n
    public Object a(Throwable r5) {
        return b(new ab(r5, false, 2, null), null, null);
    }

    public Throwable a(bx r2) {
        return (Throwable) ZeusTransformUtils.preCheckCast(((bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin")).t_(), Throwable.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.n
    public void a(Object r2) {
        if (an.a() == true) goto L5;
    L12:
        a(this.f17224a);
        return;
    L5:
        if (r2 != p.f17609a) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L12;
        throw new AssertionError();
    L7:
        r3 = false;
        goto L8
    }

    @Override // kotlinx.coroutines.ax
    public void a(Object r20, Throwable r21) {
        AtomicReferenceFieldUpdater r1 = t();
    L3:
        Object r10 = r1.get(this);
        if (ZeusTransformUtils.instanceOf(r10, cm.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r10, ab.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r10, aa.class) == true) goto L11;
        if (t().compareAndSet(this, r10, new aa(r10, null, null, null, r21, 14, null)) == false) goto L3;
        return;
    L11:
        if ((!((aa) ZeusTransformUtils.preCheckCast(r10, aa.class, "com.obric.memorydata.plugin")).a()) == false) goto L18;
        if (t().compareAndSet(this, r10, aa.a((aa) ZeusTransformUtils.preCheckCast(r10, aa.class, "com.obric.memorydata.plugin"), null, null, null, null, r21, 15, null)) == false) goto L3;
        ((aa) ZeusTransformUtils.preCheckCast(r10, aa.class, "com.obric.memorydata.plugin")).a(this, r21);
        return;
    L18:
        throw new IllegalStateException("Must be called at most once".toString());
    L7:
        return;
    L23:
        throw new IllegalStateException("Not completed".toString());
    }

    @Override // kotlinx.coroutines.n
    public void a(T r3, Function1<? super Throwable, Unit> r4) {
        Function1<? super Throwable, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        a(r3, this.f17224a, r5);
    }

    @Override // kotlinx.coroutines.n
    public void a(Function1<? super Throwable, Unit> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        q.a((n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin"), (m) ZeusTransformUtils.preCheckCast(new m.a(r4), m.class, "com.obric.memorydata.plugin"));
    }

    public final void a(Function1<? super Throwable, Unit> r5, Throwable r6) {
        ((Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin")).invoke(r6);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ai.a(getContext(), (Throwable) ZeusTransformUtils.preCheckCast(new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.coroutines.n
    public void a(ah r7, T r8) {
        Continuation<T> r0 = this.f17608b;
        ah r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, kotlinx.coroutines.internal.l.class) == false) goto L5;
        kotlinx.coroutines.internal.l r1 = (kotlinx.coroutines.internal.l) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.internal.l.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L8;
        r2 = r1.f17584b;
    L8:
        if (r2 != r7) goto L10;
        int r9 = 4;
    L11:
        a(this, r8, r9, null, 4, null);
        return;
    L10:
        r9 = this.f17224a;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.n
    public void a(ah r10, Throwable r11) {
        Continuation<T> r0 = this.f17608b;
        ah r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, kotlinx.coroutines.internal.l.class) == false) goto L5;
        kotlinx.coroutines.internal.l r1 = (kotlinx.coroutines.internal.l) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.internal.l.class, "com.obric.memorydata.plugin");
    L6:
        ab r4 = new ab(r11, false, 2, null);
        if (r1 == null) goto L9;
        r2 = r1.f17584b;
    L9:
        if (r2 != r10) goto L11;
        int r12 = 4;
    L12:
        a(this, r4, r12, null, 4, null);
        return;
    L11:
        r12 = this.f17224a;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.de
    public void a(kotlinx.coroutines.internal.ag<?> r5, int r6) {
        AtomicIntegerFieldUpdater r0 = s();
    L3:
        int r1 = r0.get(this);
        if ((r1 & 536870911) != 536870911) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L13;
        if (r0.compareAndSet(this, r1, ((r1 >> 29) << 29) + r6) == false) goto L3;
        d(r5);
        return;
    L13:
        throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
    L6:
        r2 = false;
        goto L7
    }

    public final void a(m r3) {
        d((m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin"));
    }

    public final void a(m r5, Throwable r6) {
        ((m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.memorydata.plugin")).a(r6);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ai.a(getContext(), (Throwable) ZeusTransformUtils.preCheckCast(new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.coroutines.n
    public boolean a() {
        return ZeusTransformUtils.instanceOf(d(), cm.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.ax
    public <T> T b(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, aa.class) == true) goto L5;
        return r2;
    L5:
        return (T) ((aa) ZeusTransformUtils.preCheckCast(r2, aa.class, "com.obric.memorydata.plugin")).f17202a;
    }

    @Override // kotlinx.coroutines.n
    public boolean b() {
        return !ZeusTransformUtils.instanceOf(d(), cm.class);
    }

    @Override // kotlinx.coroutines.n
    public boolean b(Throwable r9) {
        AtomicReferenceFieldUpdater r0 = t();
    L3:
        Object r1 = r0.get(this);
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r1, cm.class) == false) goto L5;
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, m.class) == false) goto L9;
    L10:
        r3 = true;
    L12:
        if (t().compareAndSet(this, r1, new r(r4, r9, r3)) == false) goto L3;
        cm r2 = (cm) ZeusTransformUtils.preCheckCast(r1, cm.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, m.class) == false) goto L17;
        a((m) ZeusTransformUtils.preCheckCast(r1, m.class, "com.obric.memorydata.plugin"), r9);
    L19:
        r();
        a(this.f17224a);
        return true;
    L17:
        if (ZeusTransformUtils.instanceOf(r2, kotlinx.coroutines.internal.ag.class) == false) goto L19;
        a((kotlinx.coroutines.internal.ag) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.internal.ag.class, "com.obric.memorydata.plugin"), r9);
        goto L19
    L9:
        if (ZeusTransformUtils.instanceOf(r1, kotlinx.coroutines.internal.ag.class) == false) goto L12;
    L5:
        return false;
    }

    @Override // kotlinx.coroutines.ax
    public Throwable c(Object r3) {
        Throwable r4 = super.c(r3);
        if (r4 == null) goto L10;
        Continuation<T> r2 = this.f17608b;
        if (an.c() == true) goto L7;
        return r4;
    L7:
        if (ZeusTransformUtils.instanceOf(r2, CoroutineStackFrame.class) == true) goto L13;
        return r4;
    L13:
        return kotlinx.coroutines.internal.ai.a(r4, (CoroutineStackFrame) ZeusTransformUtils.preCheckCast(r2, CoroutineStackFrame.class, "com.obric.memorydata.plugin"));
    L10:
        return null;
    }

    @Override // kotlinx.coroutines.ax
    public final Continuation<T> c() {
        return this.f17608b;
    }

    public final void c(Throwable r2) {
        if (d(r2) == false) goto L5;
        return;
    L5:
        b(r2);
        r();
    }

    public final Object d() {
        return t().get(this);
    }

    public void e() {
        bc r0 = q();
        if (r0 != null) goto L6;
        return;
    L6:
        if (b() == false) goto L9;
        r0.dispose();
        u().set(this, cl.f17297a);
        return;
    }

    public final boolean f() {
        if (an.a() == false) goto L13;
        if (this.f17224a != 2) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (an.a() == true) goto L15;
    L22:
        Object r1 = t().get(this);
        if (an.a() == false) goto L30;
        if ((!ZeusTransformUtils.instanceOf(r1, cm.class)) == true) goto L30;
        throw new AssertionError();
    L30:
        if (ZeusTransformUtils.instanceOf(r1, aa.class) == true) goto L32;
    L35:
        s().set(this, 536870911);
        t().set(this, d.f17307a);
        return true;
    L32:
        if (((aa) ZeusTransformUtils.preCheckCast(r1, aa.class, "com.obric.memorydata.plugin")).d == null) goto L35;
        j();
        return false;
    L15:
        if (l() == cl.f17297a) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == true) goto L22;
        throw new AssertionError();
    L17:
        r2 = false;
        goto L18
    }

    @Override // kotlinx.coroutines.ax
    public Object g() {
        return d();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> r2 = this.f17608b;
        if (ZeusTransformUtils.instanceOf(r2, CoroutineStackFrame.class) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) ZeusTransformUtils.preCheckCast(r2, CoroutineStackFrame.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.c;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final Object h() {
        boolean r0 = n();
        if (o() == true) goto L5;
        if (r0 == false) goto L13;
        i();
    L13:
        Object r1 = d();
        if (ZeusTransformUtils.instanceOf(r1, ab.class) == false) goto L23;
        Throwable r2 = ((ab) ZeusTransformUtils.preCheckCast(r1, ab.class, "com.obric.memorydata.plugin")).f17205a;
        if (an.c() == true) goto L18;
        throw r2;
    L18:
        if (ZeusTransformUtils.instanceOf((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"), CoroutineStackFrame.class) == true) goto L21;
        throw r2;
    L21:
        throw kotlinx.coroutines.internal.ai.a(r2, (CoroutineStackFrame) ZeusTransformUtils.preCheckCast((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"), CoroutineStackFrame.class, "com.obric.memorydata.plugin"));
    L23:
        if (ay.a(this.f17224a) == false) goto L37;
        bx r3 = (bx) ZeusTransformUtils.preCheckCast(getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L37;
        if (r3.a() == true) goto L37;
        CancellationException r4 = r3.t_();
        a(r1, (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
        if (an.c() == false) goto L35;
        if (ZeusTransformUtils.instanceOf((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"), CoroutineStackFrame.class) == false) goto L35;
        throw kotlinx.coroutines.internal.ai.a((Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"), (CoroutineStackFrame) ZeusTransformUtils.preCheckCast((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"), CoroutineStackFrame.class, "com.obric.memorydata.plugin"));
    L35:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
    L37:
        return b(r1);
    L5:
        if (l() != null) goto L7;
        q();
    L7:
        if (r0 == false) goto L10;
        i();
    L10:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public final void i() {
        Continuation<T> r0 = this.f17608b;
        if (ZeusTransformUtils.instanceOf(r0, kotlinx.coroutines.internal.l.class) == false) goto L5;
        kotlinx.coroutines.internal.l r1 = (kotlinx.coroutines.internal.l) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.internal.l.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L12;
        Throwable r2 = r1.a((n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L13;
        j();
        b(r2);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void j() {
        bc r0 = l();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.dispose();
        u().set(this, cl.f17297a);
    }

    public String k() {
        return "CancellableContinuation";
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r8) {
        a(this, ad.a(r8, (n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin")), this.f17224a, null, 4, null);
    }

    public String toString() {
        return k() + '(' + ao.a(this.f17608b) + "){" + m() + "}@" + ao.a(this);
    }
}
