package com.obric.assistant.remote_card_container.manager;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.aiagent.assistant_card.provider_core.ICardProviderService;
import com.obric.aiagent.assistant_card.provider_core.service.CardProviderService;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;
import p9a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.manager.CardProviderServices$createConnection$connectingJob$1$2$1$2", f = "CardProviderServices.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CardProviderServices$createConnection$connectingJob$1$2$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Application $application;
    final /* synthetic */ Uri $cardUri;
    final /* synthetic */ i<ICardProviderService> $continuation;
    final /* synthetic */ String $providerPkgName;
    final /* synthetic */ Ref.ObjectRef<CardProviderServices.a> $serviceConnection;
    int label;

    public CardProviderServices$createConnection$connectingJob$1$2$1$2(Uri r1, String r2, Application r3, Ref.ObjectRef<CardProviderServices.a> r4, i<? super ICardProviderService> r5, Continuation<? super CardProviderServices$createConnection$connectingJob$1$2$1$2> r6) {
        this.$cardUri = r1;
        this.$providerPkgName = r2;
        this.$application = r3;
        this.$serviceConnection = r4;
        this.$continuation = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CardProviderServices$createConnection$connectingJob$1$2$1$2(this.$cardUri, this.$providerPkgName, this.$application, this.$serviceConnection, this.$continuation, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r8);
        Uri r9 = this.$cardUri;
        String r2 = this.$providerPkgName;
        Application r3 = this.$application;
        Ref.ObjectRef<CardProviderServices.a> r4 = this.$serviceConnection;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L10
        String r6 = UriProtector.getQueryParameter(r9, "card_service_name");     // Catch: Throwable -> L10
        if (r6 != null) goto L8;
        r6 = CardProviderService.class.getName();     // Catch: Throwable -> L10
    L8:
        p9a.e r7 = p9a.b.a;     // Catch: Throwable -> L10
        p9a.b.a("CardProviderServices", "bindService " + r2 + ' ' + r6);     // Catch: Throwable -> L10
        Intent r1 = new Intent();     // Catch: Throwable -> L10
        r1.setComponent(new ComponentName(f.b(r9), r6));     // Catch: Throwable -> L10
        Object r10 = Result.constructor-impl(Boxing.boxBoolean(r3.bindService(r1, (ServiceConnection) r4.element, 1)));     // Catch: Throwable -> L10
    L12:
        String r11 = this.$providerPkgName;
        i<ICardProviderService> r12 = this.$continuation;
        Throwable r13 = Result.exceptionOrNull-impl(r10);
        if (r13 == null) goto L15;
        p9a.e r14 = p9a.b.a;
        p9a.b.c("CardProviderServices", "bindService failed: " + r11 + ", " + r13.getMessage(), r13);
        p9a.c.a(r12, null);
    L15:
        String r15 = this.$providerPkgName;
        i<ICardProviderService> r16 = this.$continuation;
        if (Result.isSuccess-impl(r10) == false) goto L21;
        boolean r17 = ((Boolean) r10).booleanValue();
        p9a.e r18 = p9a.b.a;
        p9a.b.a("CardProviderServices", "bindService done: " + r15 + ", bindResult = " + r17);
        if (r17 == true) goto L21;
        p9a.c.a(r16, null);
    L21:
        return Unit.INSTANCE;
    L10:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
