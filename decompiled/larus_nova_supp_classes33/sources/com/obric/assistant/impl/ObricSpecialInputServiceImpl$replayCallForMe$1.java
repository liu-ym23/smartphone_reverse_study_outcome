package com.obric.assistant.impl;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.aiagent.assistant.idl.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.impl.ObricSpecialInputServiceImpl$replayCallForMe$1", f = "ObricSpecialInputServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricSpecialInputServiceImpl$replayCallForMe$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $clarifyContent;
    final /* synthetic */ Map<String, String> $extra;
    final /* synthetic */ String $messageId;
    private /* synthetic */ Object L$0;
    int label;

    public ObricSpecialInputServiceImpl$replayCallForMe$1(String r1, String r2, Map<String, String> r3, Continuation<? super ObricSpecialInputServiceImpl$replayCallForMe$1> r4) {
        this.$messageId = r1;
        this.$clarifyContent = r2;
        this.$extra = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ObricSpecialInputServiceImpl$replayCallForMe$1 r0 = new ObricSpecialInputServiceImpl$replayCallForMe$1(this.$messageId, this.$clarifyContent, this.$extra, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        String r8 = this.$messageId;
        String r0 = this.$clarifyContent;
        Map<String, String> r1 = this.$extra;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        IAgentAppIntentIDL r3 = a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        r3.replyAskUser(r8, r0, AppHost.a.getApplication().getString(2131911989), r1);     // Catch: Throwable -> L11
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L11
    L13:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L17;
        FLogger.a.w("ObricSpecialInputServiceImpl", "replayCallForMe: replyAskUser failed: " + r11.getMessage(), r11);
    L17:
        return Unit.INSTANCE;
    L8:
        r9 = null;
    L11:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
