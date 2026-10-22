package com.obric.aiagent.assistant_card.provider_core;

import android.content.Context;
import android.net.Uri;
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
import org.json.JSONObject;
import p9a.b;
import p9a.e;
import p9a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.assistant_card.provider_core.CardProviderManager$handleCardAction$1", f = "CardProviderManager.kt", i = {0, 0}, l = {230}, m = "invokeSuspend", n = {"actionName", "actionParams"}, s = {"L$0", "L$1"})
final class CardProviderManager$handleCardAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $cardAction;
    final /* synthetic */ Uri $cardUri;
    final /* synthetic */ Context $context;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public CardProviderManager$handleCardAction$1(Bundle r1, Uri r2, Context r3, Continuation<? super CardProviderManager$handleCardAction$1> r4) {
        this.$cardAction = r1;
        this.$cardUri = r2;
        this.$context = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CardProviderManager$handleCardAction$1(this.$cardAction, this.$cardUri, this.$context, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = this.label;
        if (r4 == 0) goto L12;
        if (r4 != 1) goto L11;
        Uri r0 = (Uri) this.L$2;
        JSONObject r1 = (JSONObject) this.L$1;
        String r5 = (String) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L8
    L39:
        e r14 = b.a;     // Catch: Throwable -> L8
        b.a("CardProviderManager", "handlePendingAction: finish cardUri = " + r0 + ", actionName = " + r5 + ", actionParams = " + r1);     // Catch: Throwable -> L8
    L40:
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L43:
        Uri r2 = this.$cardUri;
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L47;
        e r6 = b.a;
        b.c("CardProviderManager", "handlePendingAction: failed " + r2, r16);
    L47:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r13);
        String r17 = this.$cardAction.getString("action_name");
        if (r17 != null) goto L15;
        r17 = NameKeys.UnloadStrategy_No_Strategy;
    L15:
        Bundle r7 = this.$cardAction;
        Object r9 = null;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L22
        String r8 = r7.getString("action_params");     // Catch: Throwable -> L22
        if (r8 == null) goto L19;
        JSONObject r11 = new JSONObject(r8);     // Catch: Throwable -> L22
    L20:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L22
    L24:
        Throwable r18 = Result.exceptionOrNull-impl(r12);
        if (r18 == null) goto L28;
        b.c("CardProviderManager", "handleCardAction: failed to parse actionParams", r18);
    L28:
        if (Result.isFailure-impl(r12) == true) goto L31;
        r9 = r12;
    L31:
        JSONObject r19 = (JSONObject) r9;
        Uri r20 = this.$cardUri;
        if (((a) c.a.get(f.a(r20))) != null) goto L35;
        e r110 = b.a;     // Catch: Throwable -> L8
        b.b("CardProviderManager", "handlePendingAction: no cardProvider for cardType: ".concat(f.a(r20)));     // Catch: Throwable -> L8
        goto L40
    L35:
        e r21 = b.a;     // Catch: Throwable -> L8
        b.a("CardProviderManager", "handlePendingAction: start cardUri = " + r20 + ", actionName = " + r17 + ", actionParams = " + r19);     // Catch: Throwable -> L8
        this.L$0 = r17;     // Catch: Throwable -> L8
        this.L$1 = r19;     // Catch: Throwable -> L8
        this.L$2 = r20;     // Catch: Throwable -> L8
        this.label = 1;     // Catch: Throwable -> L8
        if (Unit.INSTANCE != r3) goto L38;
        return r3;
    L38:
        r5 = r17;
        r1 = r19;
        r0 = r20;
        goto L39
    L19:
        r11 = null;
    L22:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    }
}
