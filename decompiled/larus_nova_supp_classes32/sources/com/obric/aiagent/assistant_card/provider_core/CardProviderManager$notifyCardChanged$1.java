package com.obric.aiagent.assistant_card.provider_core;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.assistant_card.provider_core.CardProviderManager$notifyCardChanged$1", f = "CardProviderManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CardProviderManager$notifyCardChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $cardParams;
    final /* synthetic */ Uri $cardUri;
    private /* synthetic */ Object L$0;
    int label;

    public CardProviderManager$notifyCardChanged$1(Uri r1, JSONObject r2, Continuation<? super CardProviderManager$notifyCardChanged$1> r3) {
        this.$cardUri = r1;
        this.$cardParams = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CardProviderManager$notifyCardChanged$1 r0 = new CardProviderManager$notifyCardChanged$1(this.$cardUri, this.$cardParams, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L35;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        Uri r10 = this.$cardUri;
        JSONObject r2 = this.$cardParams;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L24
        Unit r4 = c.c;     // Catch: Throwable -> L24
        if (r4 != null) goto L36;
        b.a("CardProviderManager", "notifyDataChanged: hostApi is null, will use cp to notify");     // Catch: Throwable -> L24
        c.a(r10, r2);     // Catch: Throwable -> L24
        r4 = Unit.INSTANCE;     // Catch: Throwable -> L24
    L22:
        Object r11 = Result.constructor-impl(r4);     // Catch: Throwable -> L24
    L26:
        Uri r5 = this.$cardUri;
        Throwable r6 = Result.exceptionOrNull-impl(r11);
        if (r6 == null) goto L29;
        e r7 = b.a;
        b.c("CardProviderManager", "notifyDataChanged: failed to notify " + r5, r6);
    L29:
        Uri r1 = this.$cardUri;
        if (Result.isSuccess-impl(r11) == false) goto L33;
        e r12 = b.a;
        b.a("CardProviderManager", "notifyDataChanged: notify " + r1 + " success");
    L33:
        return Unit.INSTANCE;
    L36:
        Bundle r13 = new Bundle();     // Catch: Throwable -> L13
        r13.putString("card_uri", r10.toString());     // Catch: Throwable -> L13
        if (r2 == null) goto L10;
        String r14 = r2.toString();     // Catch: Throwable -> L13
    L11:
        r13.putString("card_extra_params", r14);     // Catch: Throwable -> L13
        r4.notifyCardChanged(r13);     // Catch: Throwable -> L13
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L24
        if (r16 == null) goto L19;
        e r17 = b.a;     // Catch: Throwable -> L24
        b.c("CardProviderManager", "notifyDataChanged: failed to notify " + r10 + ", error: " + r16.getMessage(), r16);     // Catch: Throwable -> L24
    L19:
        if (Result.isSuccess-impl(r15) == false) goto L22;
        Unit r18 = (Unit) r15;     // Catch: Throwable -> L24
        b.a("CardProviderManager", "notifyDataChanged succeed");     // Catch: Throwable -> L24
        goto L22
    L10:
        r14 = null;
    L13:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L24
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L35:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
