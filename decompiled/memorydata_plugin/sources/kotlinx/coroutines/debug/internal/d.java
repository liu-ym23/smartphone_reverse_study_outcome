package kotlinx.coroutines.debug.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B#\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0013\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0000¢\u0006\u0002\b&J\b\u0010'\u001a\u00020\u000eH\u0016J)\u0010(\u001a\u00020)2\u0006\u0010 \u001a\u00020\u000e2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030+2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b.J\"\u0010/\u001a\u00020)*\b\u0012\u0004\u0012\u00020\u0015002\b\u0010*\u001a\u0004\u0018\u00010\fH\u0082P¢\u0006\u0002\u00101R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\f8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "creationStackBottom", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "sequenceNumber", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/debug/internal/StackTraceFrame;J)V", "_context", "Ljava/lang/ref/WeakReference;", "_lastObservedFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "_state", "", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getCreationStackBottom$kotlinx_coroutines_core", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "creationStackTrace", "", "Ljava/lang/StackTraceElement;", "getCreationStackTrace", "()Ljava/util/List;", EventBody.KEY_VALUE, "lastObservedFrame", "getLastObservedFrame$kotlinx_coroutines_core", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "setLastObservedFrame$kotlinx_coroutines_core", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "lastObservedThread", "Ljava/lang/Thread;", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/String;", "unmatchedResume", "", "lastObservedStackTrace", "lastObservedStackTrace$kotlinx_coroutines_core", "toString", "updateState", "", TypedValues.AttributesType.S_FRAME, "Lkotlin/coroutines/Continuation;", "shouldBeMatched", "", "updateState$kotlinx_coroutines_core", "yieldFrames", "Lkotlin/sequences/SequenceScope;", "(Lkotlin/sequences/SequenceScope;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class d {
    public volatile WeakReference<CoroutineStackFrame> _lastObservedFrame;
    public volatile String _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f17326b;
    private final WeakReference<CoroutineContext> c;
    public volatile Thread lastObservedThread;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0077 -> B:25:0x008e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0088 -> B:24:0x008b). Please report as a decompilation issue!!! */
    private final Object a(SequenceScope<? super StackTraceElement> r7, CoroutineStackFrame r8, Continuation<? super Unit> r9) {
        CoroutineStackFrame r10 = (CoroutineStackFrame) ZeusTransformUtils.wrapperContextForParams(r8, CoroutineStackFrame.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, DebugCoroutineInfoImpl$yieldFrames$1.class) == false) goto L7;
        DebugCoroutineInfoImpl$yieldFrames$1 r0 = (DebugCoroutineInfoImpl$yieldFrames$1) ZeusTransformUtils.preCheckCast(r11, DebugCoroutineInfoImpl$yieldFrames$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        CoroutineStackFrame r6 = (CoroutineStackFrame) ZeusTransformUtils.preCheckCast(r0.L$2, CoroutineStackFrame.class, "com.obric.memorydata.plugin");
        r7 = (SequenceScope) ZeusTransformUtils.preCheckCast(r0.L$1, SequenceScope.class, "com.obric.memorydata.plugin");
        d r13 = (d) ZeusTransformUtils.preCheckCast(r0.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
    L24:
        d r5 = r13;
        r10 = r6;
        d this = r5;
    L25:
        r10 = r10.getCallerFrame();
        if (r10 == null) goto L29;
    L15:
        if (r10 == null) goto L17;
        StackTraceElement r14 = r10.getStackTraceElement();
        if (r14 == null) goto L25;
        r0.L$0 = this;
        r0.L$1 = r7;
        r0.L$2 = r10;
        r0.label = 1;
        if (r7.yield(r14, r0) != r2) goto L23;
        return r2;
    L23:
        CoroutineStackFrame r15 = r10;
        r13 = this;
        r6 = r15;
        goto L24
    L17:
        return Unit.INSTANCE;
    L29:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
    L7:
        r0 = new DebugCoroutineInfoImpl$yieldFrames$1(this, r11);
        goto L8
    }

    public static final /* synthetic */ Object a(d r2, SequenceScope r3, CoroutineStackFrame r4, Continuation r5) {
        return r2.a(r3, (CoroutineStackFrame) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineStackFrame.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final List<StackTraceElement> f() {
        h r0 = this.f17326b;
        if (r0 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return SequencesKt.toList(SequencesKt.sequence((Function2) ZeusTransformUtils.preCheckCast(new DebugCoroutineInfoImpl$creationStackTrace$1(this, r0, null), Function2.class, "com.obric.memorydata.plugin")));
    }

    public final h a() {
        return this.f17326b;
    }

    public final List<StackTraceElement> b() {
        return f();
    }

    public final String c() {
        return this._state;
    }

    public final CoroutineStackFrame d() {
        WeakReference<CoroutineStackFrame> r2 = this._lastObservedFrame;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) ZeusTransformUtils.preCheckCast(r2.get(), CoroutineStackFrame.class, "com.obric.memorydata.plugin");
    }

    public final List<StackTraceElement> e() {
        CoroutineStackFrame r2 = d();
        if (r2 == null) goto L5;
        ArrayList r0 = new ArrayList();
    L7:
        if (r2 == null) goto L13;
        StackTraceElement r1 = r2.getStackTraceElement();
        if (r1 == null) goto L11;
        r0.add(r1);
    L11:
        r2 = r2.getCallerFrame();
        goto L7
    L13:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L5:
        return CollectionsKt.emptyList();
    }

    public final CoroutineContext getContext() {
        return (CoroutineContext) ZeusTransformUtils.preCheckCast(this.c.get(), CoroutineContext.class, "com.obric.memorydata.plugin");
    }

    public String toString() {
        return "DebugCoroutineInfo(state=" + c() + ",context=" + getContext() + ')';
    }
}
