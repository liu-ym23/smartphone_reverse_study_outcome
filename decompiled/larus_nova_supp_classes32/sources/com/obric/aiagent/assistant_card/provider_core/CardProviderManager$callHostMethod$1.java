package com.obric.aiagent.assistant_card.provider_core;

import android.os.Bundle;
import com.obric.aivoice.core.data.NameKeys;
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
import p9a.b;
import p9a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.assistant_card.provider_core.CardProviderManager$callHostMethod$1", f = "CardProviderManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CardProviderManager$callHostMethod$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $methodName;
    final /* synthetic */ Bundle $methodParams;
    private /* synthetic */ Object L$0;
    int label;

    public CardProviderManager$callHostMethod$1(String r1, Bundle r2, Continuation<? super CardProviderManager$callHostMethod$1> r3) {
        this.$methodName = r1;
        this.$methodParams = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CardProviderManager$callHostMethod$1 r0 = new CardProviderManager$callHostMethod$1(this.$methodName, this.$methodParams, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        String r7 = this.$methodName;
        Bundle r2 = this.$methodParams;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        Unit r4 = c.c;     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        r4.callMethod(r7, r2);     // Catch: Throwable -> L11
    L9:
        Object r8 = Result.constructor-impl(r4);     // Catch: Throwable -> L11
    L13:
        String r9 = this.$methodName;
        Throwable r10 = Result.exceptionOrNull-impl(r8);
        if (r10 == null) goto L17;
        e r11 = b.a;
        b.c("CardProviderManager", "callHostMethod: failed to call " + r9, r10);
    L17:
        return Unit.INSTANCE;
    L8:
        e r12 = b.a;     // Catch: Throwable -> L11
        b.b("CardProviderManager", "callHostMethod: failed to call " + r7 + ", hostApi is null");     // Catch: Throwable -> L11
        r4 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
