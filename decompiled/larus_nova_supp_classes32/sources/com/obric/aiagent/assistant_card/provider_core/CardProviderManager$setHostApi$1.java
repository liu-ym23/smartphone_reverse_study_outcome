package com.obric.aiagent.assistant_card.provider_core;

import android.os.IBinder;
import com.obric.aivoice.core.data.NameKeys;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.assistant_card.provider_core.CardProviderManager$setHostApi$1", f = "CardProviderManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CardProviderManager$setHostApi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IHostApi $hostApi;
    private /* synthetic */ Object L$0;
    int label;

    public CardProviderManager$setHostApi$1(IHostApi r1, Continuation<? super CardProviderManager$setHostApi$1> r2) {
        this.$hostApi = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CardProviderManager$setHostApi$1 r0 = new CardProviderManager$setHostApi$1(this.$hostApi, r4);
        r0.L$0 = r3;
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
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        IHostApi r7 = c.c;
        if (r7 != null) goto L34;
    L14:
        ConcurrentHashMap r8 = c.a;
        c.c = this.$hostApi;
        IHostApi r9 = this.$hostApi;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L23
        if (r9 == null) goto L20;
        IBinder r10 = r9.asBinder();     // Catch: Throwable -> L23
        if (r10 == null) goto L20;
        r10.linkToDeath(c.e, 0);     // Catch: Throwable -> L23
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L21:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L23
    L25:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L29;
        b.c("CardProviderManager", "setHostApi: failed to linkToDeath", r13);
    L29:
        return Unit.INSTANCE;
    L20:
        r11 = null;
    L23:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L34:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        Object r14 = Result.constructor-impl(Boxing.boxBoolean(r7.asBinder().unlinkToDeath(c.e, 0)));     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.exceptionOrNull-impl(r14);
        if (r4 == null) goto L13;
        b.c("CardProviderManager", "setHostApi: failed to unlinkToDeath", r4);
    L13:
        Result.box-impl(r14);
    L8:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
