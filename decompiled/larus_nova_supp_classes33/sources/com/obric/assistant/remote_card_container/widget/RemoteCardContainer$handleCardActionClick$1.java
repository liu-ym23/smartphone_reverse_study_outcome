package com.obric.assistant.remote_card_container.widget;

import android.content.Context;
import android.os.Bundle;
import com.obric.aiagent.assistant_card.provider_core.ICardProviderService;
import com.obric.aiagent.assistant_card.provider_core.bean.CardAction;
import com.obric.assistant.remote_card_container.manager.CardProviderServices;
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
@DebugMetadata(c = "com.obric.assistant.remote_card_container.widget.RemoteCardContainer$handleCardActionClick$1", f = "RemoteCardContainer.kt", i = {}, l = {418}, m = "invokeSuspend", n = {}, s = {})
public final class RemoteCardContainer$handleCardActionClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CardAction $action;
    final /* synthetic */ String $cardUri;
    final /* synthetic */ Context $context;
    int label;

    public RemoteCardContainer$handleCardActionClick$1(Context r1, String r2, CardAction r3, Continuation<? super RemoteCardContainer$handleCardActionClick$1> r4) {
        this.$context = r1;
        this.$cardUri = r2;
        this.$action = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RemoteCardContainer$handleCardActionClick$1(this.$context, this.$cardUri, this.$action, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        ICardProviderService r9 = (ICardProviderService) r8;
        if (r9 != null) goto L14;
        p9a.b.b("RemoteCardContainer", "cardProviderService is null, failed to handle action");
    L27:
        return Unit.INSTANCE;
    L14:
        String r2 = this.$cardUri;
        CardAction r3 = this.$action;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L17
        Bundle r5 = new Bundle();     // Catch: Throwable -> L17
        r5.putString("card_uri", r2);     // Catch: Throwable -> L17
        Bundle r6 = new Bundle();     // Catch: Throwable -> L17
        r6.putString("action_name", r3.getActionName());     // Catch: Throwable -> L17
        r6.putString("action_params", r3.getActionParams());     // Catch: Throwable -> L17
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L17
        r5.putBundle("action", r6);     // Catch: Throwable -> L17
        r9.handleCardAction(r5);     // Catch: Throwable -> L17
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        String r11 = this.$cardUri;
        Throwable r12 = Result.exceptionOrNull-impl(r10);
        if (r12 == null) goto L22;
        p9a.e r13 = p9a.b.a;
        p9a.b.c("RemoteCardContainer", "handleCardAction failed " + r11 + ", " + r12.getMessage(), r12);
    L22:
        String r14 = this.$cardUri;
        CardAction r15 = this.$action;
        if (Result.isSuccess-impl(r10) == false) goto L25;
        Unit r16 = (Unit) r10;
        p9a.e r17 = p9a.b.a;
        p9a.b.a("RemoteCardContainer", "handleCardAction done " + r14 + ", action = " + r15);
    L25:
        Result.box-impl(r10);
    L17:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CardProviderServices r19 = CardProviderServices.a;
        Context r20 = this.$context;
        String r21 = this.$cardUri;
        this.label = 1;
        r8 = r19.c(r20, r21, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
