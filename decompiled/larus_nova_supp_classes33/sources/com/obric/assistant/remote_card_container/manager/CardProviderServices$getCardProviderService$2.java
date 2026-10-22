package com.obric.assistant.remote_card_container.manager;

import android.content.Context;
import android.net.Uri;
import com.obric.aiagent.assistant_card.provider_core.ICardProviderService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/aiagent/assistant_card/provider_core/ICardProviderService;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.manager.CardProviderServices$getCardProviderService$2", f = "CardProviderServices.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
public final class CardProviderServices$getCardProviderService$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ICardProviderService>, Object> {
    final /* synthetic */ Uri $cardUri;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $providerPkgName;
    int label;

    public CardProviderServices$getCardProviderService$2(String r1, Context r2, Uri r3, Continuation<? super CardProviderServices$getCardProviderService$2> r4) {
        this.$providerPkgName = r1;
        this.$context = r2;
        this.$cardUri = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CardProviderServices$getCardProviderService$2(this.$providerPkgName, this.$context, this.$cardUri, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ICardProviderService> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L22:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CardProviderServices r6 = CardProviderServices.a;
        String r2 = this.$providerPkgName;
        Map<String, Job> r3 = CardProviderServices.c;
        if (r3 == null) goto L13;
        Job r4 = r3.remove(r2);
        if (r4 == null) goto L13;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L13:
        Map<String, Pair<ICardProviderService, CardProviderServices.a>> r7 = CardProviderServices.b;
        LinkedHashMap r8 = (LinkedHashMap) r7;
        Pair r9 = (Pair) r8.get(this.$providerPkgName);
        if (r9 != null) goto L16;
    L19:
        Context r10 = this.$context;
        Uri r11 = this.$cardUri;
        this.label = 1;
        r5 = CardProviderServices.b(r6, r10, r11, this);
        if (r5 != r0) goto L22;
        return r0;
    L16:
        if (((CardProviderServices.a) r9.getSecond()).a.get() == false) goto L19;
        return r9.getFirst();
    }
}
