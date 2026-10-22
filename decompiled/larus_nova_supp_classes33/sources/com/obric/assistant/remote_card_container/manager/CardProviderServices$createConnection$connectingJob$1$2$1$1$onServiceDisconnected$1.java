package com.obric.assistant.remote_card_container.manager;

import android.app.Application;
import com.obric.aiagent.assistant_card.provider_core.ICardProviderService;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.manager.CardProviderServices$createConnection$connectingJob$1$2$1$1$onServiceDisconnected$1", f = "CardProviderServices.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CardProviderServices$createConnection$connectingJob$1$2$1$1$onServiceDisconnected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Application $application;
    final /* synthetic */ i<ICardProviderService> $continuation;
    final /* synthetic */ String $providerPkgName;
    final /* synthetic */ CardProviderServices$createConnection$connectingJob$1$2$1$1 $tempConnection;
    int label;
    final /* synthetic */ CardProviderServices$createConnection$connectingJob$1$2$1$1 this$0;

    public CardProviderServices$createConnection$connectingJob$1$2$1$1$onServiceDisconnected$1(CardProviderServices$createConnection$connectingJob$1$2$1$1 r1, i<? super ICardProviderService> r2, Application r3, CardProviderServices$createConnection$connectingJob$1$2$1$1 r4, String r5, Continuation<? super CardProviderServices$createConnection$connectingJob$1$2$1$1$onServiceDisconnected$1> r6) {
        this.this$0 = r1;
        this.$continuation = r2;
        this.$application = r3;
        this.$tempConnection = r4;
        this.$providerPkgName = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CardProviderServices$createConnection$connectingJob$1$2$1$1$onServiceDisconnected$1(this.this$0, this.$continuation, this.$application, this.$tempConnection, this.$providerPkgName, r9);
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
        this.this$0.a.set(false);
        Application r6 = this.$application;
        CardProviderServices$createConnection$connectingJob$1$2$1$1 r0 = this.$tempConnection;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        r6.unbindService(r0);     // Catch: Throwable -> L7
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L10:
        if (Result.exceptionOrNull-impl(r7) == null) goto L12;
        p9a.b.b("CardProviderServices", "unbind service failed");
    L12:
        String r8 = this.$providerPkgName;
        CardProviderServices$createConnection$connectingJob$1$2$1$1 r2 = this.$tempConnection;
        Pair r3 = (Pair) ((LinkedHashMap) CardProviderServices.b).get(r8);     // Catch: Throwable -> L23
        if (r3 == null) goto L16;
        CardProviderServices.a r4 = (CardProviderServices.a) r3.getSecond();     // Catch: Throwable -> L23
    L18:
        if (Intrinsics.areEqual(r4, r2) == false) goto L20;
        CardProviderServices.a(r8);     // Catch: Throwable -> L23
    L21:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        String r10 = this.$providerPkgName;
        if (Result.exceptionOrNull-impl(r9) == null) goto L28;
        p9a.e r11 = p9a.b.a;
        p9a.b.b("CardProviderServices", "error cancel connection " + r10);
    L28:
        p9a.c.a(this.$continuation, null);
        return Unit.INSTANCE;
    L20:
        p9a.b.a("CardProviderServices", "service connection not match");     // Catch: Throwable -> L23
        goto L21
    L16:
        r4 = null;
    L23:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
