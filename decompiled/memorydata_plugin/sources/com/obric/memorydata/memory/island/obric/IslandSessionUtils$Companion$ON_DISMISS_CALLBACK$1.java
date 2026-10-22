package com.obric.memorydata.memory.island.obric;

import com.obric.memorydata.memory.utils.o;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.obric.IslandSessionUtils$Companion$ON_DISMISS_CALLBACK$1", f = "IslandSessionUtils.kt", i = {0, 0, 1, 1}, l = {1883, 162, 1887, 1887}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "actualOwner$iv", "$this$withLock_u24default$iv", "actualOwner$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class IslandSessionUtils$Companion$ON_DISMISS_CALLBACK$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;

    IslandSessionUtils$Companion$ON_DISMISS_CALLBACK$1(Continuation<? super IslandSessionUtils$Companion$ON_DISMISS_CALLBACK$1> r3) {
        super(1, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$ON_DISMISS_CALLBACK$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
        return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r3) {
        return ((IslandSessionUtils$Companion$ON_DISMISS_CALLBACK$1) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), IslandSessionUtils$Companion$ON_DISMISS_CALLBACK$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r20) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L24;
        if (r0 == 1) goto L21;
        if (r0 == 2) goto L16;
        if (r0 == 3) goto L13;
        if (r0 != 4) goto L9;
        th = (Throwable) ZeusTransformUtils.preCheckCast(this.L$0, Throwable.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r20);     // Catch: Exception -> L48
    L47:
        throw th;     // Catch: Exception -> L48
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        Unit r1 = (Unit) ZeusTransformUtils.preCheckCast(this.L$0, Unit.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r20);     // Catch: Exception -> L48
    L51:
        return Unit.INSTANCE;
    L16:
        CoroutineContext.Element r5 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$1, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        o r6 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L19
    L38:
        IslandSessionUtils.Companion r3 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L19
        IslandSessionUtils.a(null);     // Catch: Throwable -> L19
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L19
        Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L48
        this.L$0 = r4;     // Catch: Exception -> L48
        this.L$1 = null;     // Catch: Exception -> L48
        this.label = 3;     // Catch: Exception -> L48
        if (r6.b(r5, r7) != r2) goto L51;
        return r2;
    L19:
        th = th;
    L44:
        Continuation<? super Unit> r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L48
        this.L$0 = th;     // Catch: Exception -> L48
        this.L$1 = null;     // Catch: Exception -> L48
        this.label = 4;     // Catch: Exception -> L48
        if (r6.b(r5, r8) != r2) goto L47;
        return r2;
    L21:
        CoroutineContext.Element r9 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$1, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        r6 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r20);     // Catch: Exception -> L48
        CoroutineContext.Element r10 = r9;
    L52:
        IslandSessionUtils.Companion.b r11 = IslandSessionUtils.i();     // Catch: Throwable -> L42
        if (r11 == null) goto L32;
        IslandSessionUtils.Companion.b r12 = IslandSessionUtils.Companion.b.a(r11, null, null, null, null, null, false, 63, null);     // Catch: Throwable -> L42
    L33:
        if (r12 == null) goto L37;
        IslandSessionUtils.Companion r13 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L42
        this.L$0 = r6;     // Catch: Throwable -> L42
        this.L$1 = r10;     // Catch: Throwable -> L42
        this.label = 2;     // Catch: Throwable -> L42
        if (r13.a(r12, this) != r2) goto L37;
        return r2;
    L37:
        r5 = r10;
        goto L38
    L32:
        r12 = null;
    L42:
        th = th;
        r5 = r10;
        goto L44
    L24:
        ResultKt.throwOnFailure(r20);
        o r14 = IslandSessionUtils.c();     // Catch: Exception -> L48
        r10 = getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L48
        Continuation<? super Unit> r15 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L48
        this.L$0 = r14;     // Catch: Exception -> L48
        this.L$1 = r10;     // Catch: Exception -> L48
        this.label = 1;     // Catch: Exception -> L48
        if (r14.a(r10, r15) != r2) goto L28;
        return r2;
    L28:
        r6 = r14;
    L48:
        e = move-exception;
        RunLog.INSTANCE.error("IslandSessionUtils", "Error in dismiss callback: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L51
    }
}
