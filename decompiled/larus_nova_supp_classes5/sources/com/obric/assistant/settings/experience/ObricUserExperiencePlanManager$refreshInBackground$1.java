package com.obric.assistant.settings.experience;

import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.experience.ObricUserExperiencePlanManager$refreshInBackground$1", f = "ObricUserExperiencePlanManager.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
public final class ObricUserExperiencePlanManager$refreshInBackground$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public ObricUserExperiencePlanManager$refreshInBackground$1(Continuation<? super ObricUserExperiencePlanManager$refreshInBackground$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        ObricUserExperiencePlanManager$refreshInBackground$1 r0 = new ObricUserExperiencePlanManager$refreshInBackground$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L15
    L13:
        Object r5 = Result.constructor-impl((ObricUserExperiencePlanManager.a) r4);     // Catch: Throwable -> L15
    L17:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L21;
        FLogger.a.w("ObricExperiencePlan", "refresh in background failed", r6);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r4);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L15
        ObricUserExperiencePlanManager r9 = ObricUserExperiencePlanManager.a;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r4 = r9.f(this);     // Catch: Throwable -> L15
        if (r4 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
