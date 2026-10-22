package kotlinx.coroutines.debug.internal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.PublishedApi;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes3.dex */
@PublishedApi
@SourceDebugExtension({"SMAP\nDebugCoroutineInfoImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugCoroutineInfoImpl.kt\nkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n1#2:181\n*E\n"})
public final class DebugCoroutineInfoImpl {

    @JvmField
    public volatile WeakReference<CoroutineStackFrame> _lastObservedFrame;

    @JvmField
    public volatile String _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f10358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public final long f10359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference<CoroutineContext> f10360c;

    @JvmField
    public volatile Thread lastObservedThread;

    public static final /* synthetic */ Object a(DebugCoroutineInfoImpl r10, SequenceScope r11, CoroutineStackFrame r12, Continuation r13) {
        return r10.i(r11, r12, r13);
    }

    private final List<StackTraceElement> b() {
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0049 -> B:25:0x0060). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005a -> B:24:0x005d). Please report as a decompilation issue!!! */
    private final Object i(SequenceScope<? super StackTraceElement> r10, CoroutineStackFrame r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof DebugCoroutineInfoImpl$yieldFrames$1) == false) goto L7;
        DebugCoroutineInfoImpl$yieldFrames$1 r13 = (DebugCoroutineInfoImpl$yieldFrames$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        CoroutineStackFrame r18 = (CoroutineStackFrame) r13.L$2;
        r10 = (SequenceScope) r13.L$1;
        DebugCoroutineInfoImpl r19 = (DebugCoroutineInfoImpl) r13.L$0;
        ResultKt.throwOnFailure(r15);
    L24:
        DebugCoroutineInfoImpl r20 = r19;
        r11 = r18;
        DebugCoroutineInfoImpl this = r20;
    L25:
        r11 = r11.getCallerFrame();
        if (r11 == null) goto L29;
    L15:
        if (r11 == null) goto L17;
        StackTraceElement r21 = r11.getStackTraceElement();
        if (r21 == null) goto L25;
        r13.L$0 = this;
        r13.L$1 = r10;
        r13.L$2 = r11;
        r13.label = 1;
        if (r10.yield(r21, r13) != r16) goto L23;
        return r16;
    L23:
        CoroutineStackFrame r22 = r11;
        r19 = this;
        r18 = r22;
        goto L24
    L17:
        return Unit.INSTANCE;
    L29:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
    L7:
        r13 = new DebugCoroutineInfoImpl$yieldFrames$1(this, r12);
        goto L8
    }

    public final CoroutineContext c() {
        return this.f10360c.get();
    }

    public final f d() {
        return this.f10358a;
    }

    public final List<StackTraceElement> e() {
        return b();
    }

    public final CoroutineStackFrame f() {
        WeakReference<CoroutineStackFrame> r10 = this._lastObservedFrame;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.get();
    }

    public final String g() {
        return this._state;
    }

    public final List<StackTraceElement> h() {
        CoroutineStackFrame r10 = f();
        if (r10 == null) goto L5;
        ArrayList r11 = new ArrayList();
    L7:
        if (r10 == null) goto L12;
        StackTraceElement r12 = r10.getStackTraceElement();
        if (r12 == null) goto L11;
        r11.add(r12);
    L11:
        r10 = r10.getCallerFrame();
        goto L7
    L12:
        return r11;
    L5:
        return CollectionsKt.emptyList();
    }

    public String toString() {
        return "DebugCoroutineInfo(state=" + g() + ",context=" + c() + ')';
    }
}
