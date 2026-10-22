package com.obric.assistant.activation.presentation.runtime.session;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.concurrent.atomic.AtomicLong;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.activation.presentation.runtime.session.InteractionSessionProxy$closeSystemDialogsFromMain$1$1", f = "InteractionSessionProxy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class InteractionSessionProxy$closeSystemDialogsFromMain$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InteractionSessionProxy this$0;

    public InteractionSessionProxy$closeSystemDialogsFromMain$1$1(InteractionSessionProxy r1, Continuation<? super InteractionSessionProxy$closeSystemDialogsFromMain$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        InteractionSessionProxy$closeSystemDialogsFromMain$1$1 r0 = new InteractionSessionProxy$closeSystemDialogsFromMain$1$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r11);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        long r0 = SystemClock.elapsedRealtime();
        InteractionSessionProxy r13 = this.this$0;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        AtomicLong r3 = InteractionSessionProxy.d;     // Catch: Throwable -> L7
        r13.closeSystemDialogs();     // Catch: Throwable -> L7
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        InteractionSessionProxy r4 = this.this$0;
        Throwable r5 = Result.exceptionOrNull-impl(r14);
        if (r5 == null) goto L12;
        FLogger.a.w("InteractionSessionProxy", "closeSystemDialogs failed, id=" + r4.a + ", cost=" + (SystemClock.elapsedRealtime() - r0), r5);
    L12:
        InteractionSessionProxy r6 = this.this$0;
        if (Result.isSuccess-impl(r14) == false) goto L16;
        Unit r15 = (Unit) r14;
        FLogger.a.i("InteractionSessionProxy", "closeSystemDialogs success, id=" + r6.a + ", cost=" + (SystemClock.elapsedRealtime() - r0));
    L16:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
