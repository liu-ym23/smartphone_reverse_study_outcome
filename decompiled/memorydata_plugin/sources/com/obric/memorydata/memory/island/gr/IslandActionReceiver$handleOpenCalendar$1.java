package com.obric.memorydata.memory.island.gr;

import android.content.Context;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.gr.IslandActionReceiver$handleOpenCalendar$1", f = "IslandActionReceiver.kt", i = {}, l = {220, 241}, m = "invokeSuspend", n = {}, s = {})
final class IslandActionReceiver$handleOpenCalendar$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $eventUuid;
    int label;
    final /* synthetic */ IslandActionReceiver this$0;

    IslandActionReceiver$handleOpenCalendar$1(String r3, IslandActionReceiver r4, Context r5, Continuation<? super IslandActionReceiver$handleOpenCalendar$1> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$eventUuid = r3;
        this.this$0 = r4;
        this.$context = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandActionReceiver$handleOpenCalendar$1(this.$eventUuid, this.this$0, this.$context, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((IslandActionReceiver$handleOpenCalendar$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), IslandActionReceiver$handleOpenCalendar$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r4 = true;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L12
    L36:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "handleOpenCalendar: completed", false, 4, null);     // Catch: Exception -> L12
    L40:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L12
    L21:
        return Unit.INSTANCE;
    L14:
        ResultKt.throwOnFailure(r13);
        String r14 = this.$eventUuid;     // Catch: Exception -> L12
        if (r14 != null) goto L22;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "handleOpenCalendar: eventUuid is null, just destroying island", null, 4, null);     // Catch: Exception -> L12
        f.a r15 = f.f10213a;     // Catch: Exception -> L12
        Continuation<? super Unit> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        this.label = 1;     // Catch: Exception -> L12
        if (r15.a(r2) != r0) goto L21;
        return r0;
    L22:
        Long r16 = StringsKt.toLongOrNull(r14);     // Catch: Exception -> L12
        RunLog r3 = RunLog.INSTANCE;     // Catch: Exception -> L12
        StringBuilder r6 = new StringBuilder().append("handleOpenCalendar: parsed eventId=").append(r16).append(" (isNumeric=");     // Catch: Exception -> L12
        if (r16 != null) goto L26;
        r4 = false;
    L26:
        r3.debug("IslandActionReceiver", r6.append(r4).append(')').toString());     // Catch: Exception -> L12
        if (r16 != null) goto L29;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "handleOpenCalendar: eventUuid is not numeric, using AssistantHybridAbilityProviderUtil", false, 4, null);     // Catch: Exception -> L12
        com.obric.memorydata.memory.provider.b r17 = com.obric.memorydata.memory.provider.b.f10359a;     // Catch: Exception -> L12
        String r5 = this.$eventUuid;     // Catch: Exception -> L12
    L31:
        r17.a(r5);     // Catch: Exception -> L12
    L33:
        RunLog.INSTANCE.debug("IslandActionReceiver", "handleOpenCalendar: destroying island after open");     // Catch: Exception -> L12
        f.a r18 = f.f10213a;     // Catch: Exception -> L12
        Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        this.label = 2;     // Catch: Exception -> L12
        if (r18.a(r7) != r0) goto L36;
        return r0;
    L29:
        if (IslandActionReceiver.a(this.this$0, this.$context, r16.longValue()) == true) goto L33;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "handleOpenCalendar: no calendar activity found for ContentUri, falling back to AssistantHybridAbilityProviderUtil.openCalendar", null, 4, null);     // Catch: Exception -> L12
        r17 = com.obric.memorydata.memory.provider.b.f10359a;     // Catch: Exception -> L12
        r5 = this.$eventUuid;     // Catch: Exception -> L12
    L12:
        e = move-exception;
        RunLog.INSTANCE.error("IslandActionReceiver", "handleOpenCalendar: error: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L40
    }
}
