package com.obric.assistant.remote_card_container.manager;

import android.os.Bundle;
import android.os.IBinder;
import com.obric.aiagent.assistant_card.provider_core.ICardProviderService;
import com.obric.assistant.remote_card_container.cardhost.CardHostIPCApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.manager.CardProviderServices$createConnection$connectingJob$1$2$1$1$onServiceConnected$1", f = "CardProviderServices.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CardProviderServices$createConnection$connectingJob$1$2$1$1$onServiceConnected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ i<ICardProviderService> $continuation;
    final /* synthetic */ String $providerPkgName;
    final /* synthetic */ IBinder $service;
    final /* synthetic */ Ref.ObjectRef<CardProviderServices.a> $serviceConnection;
    int label;
    final /* synthetic */ CardProviderServices$createConnection$connectingJob$1$2$1$1 this$0;

    public CardProviderServices$createConnection$connectingJob$1$2$1$1$onServiceConnected$1(CardProviderServices$createConnection$connectingJob$1$2$1$1 r1, IBinder r2, String r3, Ref.ObjectRef<CardProviderServices.a> r4, i<? super ICardProviderService> r5, Continuation<? super CardProviderServices$createConnection$connectingJob$1$2$1$1$onServiceConnected$1> r6) {
        this.this$0 = r1;
        this.$service = r2;
        this.$providerPkgName = r3;
        this.$serviceConnection = r4;
        this.$continuation = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CardProviderServices$createConnection$connectingJob$1$2$1$1$onServiceConnected$1(this.this$0, this.$service, this.$providerPkgName, this.$serviceConnection, this.$continuation, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r6);
        this.this$0.a.set(true);
        IBinder r7 = this.$service;
        String r2 = this.$providerPkgName;
        Ref.ObjectRef<CardProviderServices.a> r3 = this.$serviceConnection;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L17
        ICardProviderService r8 = ICardProviderService.Stub.asInterface(r7);     // Catch: Throwable -> L17
        if (r8 == null) goto L15;
        Map<String, Pair<ICardProviderService, CardProviderServices.a>> r5 = CardProviderServices.b;     // Catch: Throwable -> L17
        Object r9 = r3.element;     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L17
        r5.put(r2, TuplesKt.to(r8, r9));     // Catch: Throwable -> L17
        Bundle r10 = new Bundle();     // Catch: Throwable -> L10
        r10.putBinder("host_api", CardHostIPCApi.INSTANCE);     // Catch: Throwable -> L10
        r8.setHostApi(r10);     // Catch: Throwable -> L10
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r12 = Result.exceptionOrNull-impl(r11);     // Catch: Throwable -> L17
        if (r12 == null) goto L15;
        p9a.e r13 = p9a.b.a;     // Catch: Throwable -> L17
        p9a.b.c("CardProviderServices", "set host api failed: " + r12.getMessage(), r12);     // Catch: Throwable -> L17
        goto L15
    L10:
        th = move-exception;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L17
        r11 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L17
    L15:
        Object r15 = Result.constructor-impl(r8);     // Catch: Throwable -> L17
    L19:
        i<ICardProviderService> r1 = this.$continuation;
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L22;
        p9a.e r17 = p9a.b.a;
        p9a.b.c("CardProviderServices", "create connection failed: " + r16.getMessage(), r16);
        p9a.c.a(r1, null);
    L22:
        i<ICardProviderService> r18 = this.$continuation;
        String r19 = this.$providerPkgName;
        if (Result.isSuccess-impl(r15) == false) goto L29;
        ICardProviderService r20 = (ICardProviderService) r15;
        if (r18.isActive() == true) goto L27;
        p9a.b.a("CardProviderServices", "job not active. set time out");
        CardProviderServices r0 = CardProviderServices.a;
        CardProviderServices.d(r19);
    L27:
        p9a.c.a(r18, r20);
    L29:
        return Unit.INSTANCE;
    L17:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
