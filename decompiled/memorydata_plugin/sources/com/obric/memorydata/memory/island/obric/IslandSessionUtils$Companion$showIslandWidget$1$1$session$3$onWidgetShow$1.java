package com.obric.memorydata.memory.island.obric;

import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.memorydata.memory.utils.o;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.obric.IslandSessionUtils$Companion$showIslandWidget$1$1$session$3$onWidgetShow$1", f = "IslandSessionUtils.kt", i = {0, 0, 1, 1}, l = {1883, 992, 1887, 1887}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "actualOwner$iv", "$this$withLock_u24default$iv", "actualOwner$iv"}, s = {"L$0", "L$2", "L$0", "L$1"})
final class IslandSessionUtils$Companion$showIslandWidget$1$1$session$3$onWidgetShow$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ IslandWidget $widget;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    IslandSessionUtils$Companion$showIslandWidget$1$1$session$3$onWidgetShow$1(IslandWidget r3, Continuation<? super IslandSessionUtils$Companion$showIslandWidget$1$1$session$3$onWidgetShow$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$widget = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$showIslandWidget$1$1$session$3$onWidgetShow$1(this.$widget, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((IslandSessionUtils$Companion$showIslandWidget$1$1$session$3$onWidgetShow$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), IslandSessionUtils$Companion$showIslandWidget$1$1$session$3$onWidgetShow$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r17) {
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L24;
        if (r0 == 1) goto L21;
        if (r0 == 2) goto L16;
        if (r0 == 3) goto L13;
        if (r0 != 4) goto L9;
        th = (Throwable) ZeusTransformUtils.preCheckCast(this.L$0, Throwable.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L51
    L50:
        throw th;     // Catch: Exception -> L51
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        Unit r1 = (Unit) ZeusTransformUtils.preCheckCast(this.L$0, Unit.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L51
    L54:
        return Unit.INSTANCE;
    L16:
        CoroutineContext.Element r2 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$1, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        o r3 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L19
    L39:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CoroutineContext.Element r14 = r2;
        o r15 = r3;
    L42:
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L51
        this.L$0 = r4;     // Catch: Exception -> L51
        this.L$1 = null;     // Catch: Exception -> L51
        this.L$2 = null;     // Catch: Exception -> L51
        this.label = 3;     // Catch: Exception -> L51
        if (r15.b(r14, r5) != r8) goto L54;
        return r8;
    L19:
        th = th;
    L47:
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L51
        this.L$0 = th;     // Catch: Exception -> L51
        this.L$1 = null;     // Catch: Exception -> L51
        this.L$2 = null;     // Catch: Exception -> L51
        this.label = 4;     // Catch: Exception -> L51
        if (r3.b(r2, r6) != r8) goto L50;
        return r8;
    L21:
        CoroutineContext.Element r7 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$2, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        IslandWidget r9 = (IslandWidget) ZeusTransformUtils.preCheckCast(this.L$1, IslandWidget.class, "com.obric.memorydata.plugin");
        o r10 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L51
        r14 = r7;
        r15 = r10;
    L55:
        IslandSession r11 = (IslandSession) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(IslandSessionUtils.h()), IslandSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        if (r11 != null) goto L32;
        r4 = null;
        goto L42
    L32:
        if (r11.getCollapseWidget() != null) goto L34;
    L38:
        r2 = r14;
        r3 = r15;
        goto L39
    L34:
        if (Intrinsics.areEqual(r11.getExpandWidget(), r9) == false) goto L38;
        IslandSessionUtils.Companion r12 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L45
        this.L$0 = r15;     // Catch: Throwable -> L45
        this.L$1 = r14;     // Catch: Throwable -> L45
        this.L$2 = null;     // Catch: Throwable -> L45
        this.label = 2;     // Catch: Throwable -> L45
        if (IslandSessionUtils.Companion.a(r12, 0, this, 1, null) != r8) goto L38;
        return r8;
    L45:
        th = th;
        r2 = r14;
        r3 = r15;
        goto L47
    L24:
        ResultKt.throwOnFailure(r17);
        RunLog.INSTANCE.debug("IslandSessionUtils", "onWidgetShow");
        o r13 = IslandSessionUtils.c();     // Catch: Exception -> L51
        IslandWidget r16 = this.$widget;     // Catch: Exception -> L51
        CoroutineContext.Element r18 = getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L51
        Continuation<? super Unit> r19 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L51
        this.L$0 = r13;     // Catch: Exception -> L51
        this.L$1 = r16;     // Catch: Exception -> L51
        this.L$2 = r18;     // Catch: Exception -> L51
        this.label = 1;     // Catch: Exception -> L51
        if (r13.a(r18, r19) != r8) goto L28;
        return r8;
    L28:
        r15 = r13;
        r9 = r16;
        r14 = r18;
    L51:
        e = move-exception;
        RunLog.INSTANCE.error("IslandSessionUtils", "Error in onWidgetShow: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L54
    }
}
