package com.obric.memorydata.memory.island.obric;

import com.obric.memorydata.memory.utils.o;
import com.obric.memorydata.middleware.api.log.IRunLog;
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
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.obric.IslandSessionUtils$Companion$handleIslandContentClick$1", f = "IslandSessionUtils.kt", i = {0, 0, 1, 1}, l = {1883, 848, 1887, 1887}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "actualOwner$iv", "$this$withLock_u24default$iv", "actualOwner$iv"}, s = {"L$0", "L$3", "L$0", "L$1"})
final class IslandSessionUtils$Companion$handleIslandContentClick$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ IslandSessionUtils.Companion.b $content;
    final /* synthetic */ String $reason;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    IslandSessionUtils$Companion$handleIslandContentClick$1(String r3, IslandSessionUtils.Companion.b r4, Continuation<? super IslandSessionUtils$Companion$handleIslandContentClick$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$reason = r3;
        this.$content = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$handleIslandContentClick$1(this.$reason, this.$content, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((IslandSessionUtils$Companion$handleIslandContentClick$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), IslandSessionUtils$Companion$handleIslandContentClick$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r19) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L24;
        if (r0 == 1) goto L21;
        if (r0 == 2) goto L16;
        if (r0 == 3) goto L13;
        if (r0 != 4) goto L9;
        th = (Throwable) ZeusTransformUtils.preCheckCast(this.L$0, Throwable.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r19);     // Catch: Exception -> L43
    L42:
        throw th;     // Catch: Exception -> L43
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        Unit r1 = (Unit) ZeusTransformUtils.preCheckCast(this.L$0, Unit.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r19);     // Catch: Exception -> L43
    L46:
        return Unit.INSTANCE;
    L16:
        CoroutineContext.Element r5 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$1, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        o r6 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L19
    L33:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L19
        Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L43
        this.L$0 = r3;     // Catch: Exception -> L43
        this.L$1 = null;     // Catch: Exception -> L43
        this.label = 3;     // Catch: Exception -> L43
        if (r6.b(r5, r4) != r2) goto L46;
        return r2;
    L19:
        th = th;
    L39:
        Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L43
        this.L$0 = th;     // Catch: Exception -> L43
        this.L$1 = null;     // Catch: Exception -> L43
        this.L$2 = null;     // Catch: Exception -> L43
        this.L$3 = null;     // Catch: Exception -> L43
        this.label = 4;     // Catch: Exception -> L43
        if (r6.b(r5, r7) != r2) goto L42;
        return r2;
    L21:
        CoroutineContext.Element r8 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$3, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        IslandSessionUtils.Companion.b r9 = (IslandSessionUtils.Companion.b) ZeusTransformUtils.preCheckCast(this.L$2, IslandSessionUtils.Companion.b.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
        o r11 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r19);     // Catch: Exception -> L43
        CoroutineContext.Element r12 = r8;
    L47:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "open island content, reason=" + r10 + ", entityId=" + r9.a().getId(), false, 4, null);     // Catch: Throwable -> L37
        IslandSessionUtils.Companion.a(IslandSessionUtils.f10217a, r9);     // Catch: Throwable -> L37
        IslandSessionUtils.Companion r13 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L37
        IslandSessionUtils.a(null);     // Catch: Throwable -> L37
        IslandSessionUtils.Companion r14 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L37
        this.L$0 = r11;     // Catch: Throwable -> L37
        this.L$1 = r12;     // Catch: Throwable -> L37
        this.L$2 = null;     // Catch: Throwable -> L37
        this.L$3 = null;     // Catch: Throwable -> L37
        this.label = 2;     // Catch: Throwable -> L37
        if (r14.a(0, this) != r2) goto L32;
        return r2;
    L32:
        r6 = r11;
        r5 = r12;
    L37:
        th = th;
        r6 = r11;
        r5 = r12;
        goto L39
    L24:
        ResultKt.throwOnFailure(r19);
        o r15 = IslandSessionUtils.c();     // Catch: Exception -> L43
        r10 = this.$reason;     // Catch: Exception -> L43
        IslandSessionUtils.Companion.b r16 = this.$content;     // Catch: Exception -> L43
        r12 = getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L43
        Continuation<? super Unit> r17 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L43
        this.L$0 = r15;     // Catch: Exception -> L43
        this.L$1 = r10;     // Catch: Exception -> L43
        this.L$2 = r16;     // Catch: Exception -> L43
        this.L$3 = r12;     // Catch: Exception -> L43
        this.label = 1;     // Catch: Exception -> L43
        if (r15.a(r12, r17) != r2) goto L28;
        return r2;
    L28:
        r9 = r16;
        r11 = r15;
    L43:
        e = move-exception;
        RunLog.INSTANCE.error("IslandSessionUtils", "Error in island content click: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        IslandSessionUtils.Companion r18 = IslandSessionUtils.f10217a;
        IslandSessionUtils.a(null);
        IslandSessionUtils.Companion r20 = IslandSessionUtils.f10217a;
        IslandSessionUtils.a("");
        IslandSessionUtils.Companion r21 = IslandSessionUtils.f10217a;
        IslandSessionUtils.a(null);
        goto L46
    }
}
