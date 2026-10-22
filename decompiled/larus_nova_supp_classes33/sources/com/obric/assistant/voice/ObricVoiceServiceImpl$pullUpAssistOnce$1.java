package com.obric.assistant.voice;

import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ipc.l;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.voice.ObricVoiceServiceImpl$pullUpAssistOnce$1", f = "ObricVoiceServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricVoiceServiceImpl$pullUpAssistOnce$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricVoiceServiceImpl this$0;

    public ObricVoiceServiceImpl$pullUpAssistOnce$1(ObricVoiceServiceImpl r1, Continuation<? super ObricVoiceServiceImpl$pullUpAssistOnce$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricVoiceServiceImpl$pullUpAssistOnce$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r5);
        if (this.this$0.a() == true) goto L22;
        FLogger.a.i(this.this$0.b, "pullUpAssistOnce skip: not default assistant");
        return Unit.INSTANCE;
    L22:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L10
        Object r7 = Result.constructor-impl(l.a(AppHost.a.getApplication().getContentResolver(), "pull-up-assist-once", null));     // Catch: Throwable -> L10
    L12:
        ObricVoiceServiceImpl r0 = this.this$0;
        if (Result.isSuccess-impl(r7) == false) goto L15;
        Bundle r1 = (Bundle) r7;
        FLogger.a.i(r0.b, "pullUpAssistOnce call success");
    L15:
        ObricVoiceServiceImpl r2 = this.this$0;
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L19;
        FLogger.a.e(r2.b, "pullUpAssistOnce call failed: " + r8.getMessage());
    L19:
        return Unit.INSTANCE;
    L10:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
