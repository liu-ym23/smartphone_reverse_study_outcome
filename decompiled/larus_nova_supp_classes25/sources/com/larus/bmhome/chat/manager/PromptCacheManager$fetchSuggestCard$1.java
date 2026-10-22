package com.larus.bmhome.chat.manager;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.auth.OnboardingActionCardData;
import com.larus.bmhome.auth.OnboardingActionCardItemData;
import com.larus.bmhome.chat.api.BotApi;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.manager.PromptCacheManager$fetchSuggestCard$1", f = "PromptCacheManager.kt", i = {}, l = {DoraCallStateCode.DOUBAO_RAPID_FLASHING_END}, m = "invokeSuspend", n = {}, s = {})
public final class PromptCacheManager$fetchSuggestCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    int label;

    public PromptCacheManager$fetchSuggestCard$1(String r1, Continuation<? super PromptCacheManager$fetchSuggestCard$1> r2) {
        this.$botId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new PromptCacheManager$fetchSuggestCard$1(this.$botId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        com.larus.network.http.a r7 = (com.larus.network.http.a) r6;
        if ((r7 instanceof com.larus.network.http.f) == true) goto L14;
        OnboardingActionCardData r8 = (OnboardingActionCardData) r7.b;
        if (r8 == null) goto L43;
        List<OnboardingActionCardItemData> r9 = r8.a();
        if (r9 == null) goto L43;
        ArrayList r2 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L21:
        String r3 = null;
        if (r10.hasNext() == false) goto L29;
        Object r4 = r10.next();
        OnboardingActionCardItemData r5 = (OnboardingActionCardItemData) r4;
        if (r5 == null) goto L27;
        r3 = r5.q();
    L27:
        if (com.larus.utils.o0.d(r3) == false) goto L21;
        r2.add(r4);
        goto L21
    L29:
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r12 = r2.iterator();
    L31:
        if (r12.hasNext() == false) goto L37;
        OnboardingActionCardItemData r13 = (OnboardingActionCardItemData) r12.next();
        if (r13 == null) goto L35;
        String r14 = r13.q();
    L36:
        r11.add(r14);
        goto L31
    L35:
        r14 = null;
        goto L36
    L37:
        Set r15 = CollectionsKt.toSet(r11);
        if ((!r15.isEmpty()) == false) goto L41;
        PromptCacheManager.b.storeStringArray("key_cached_tcc_prompt", (String[]) r15.toArray(new String[0]));
    L41:
        return Unit.INSTANCE;
    L43:
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        BotApi r16 = (BotApi) BotApi.a.getValue();
        String r17 = this.$botId;
        OnboardingActionCardData.CardScene r18 = OnboardingActionCardData.CardScene.NewTopics;
        this.label = 1;
        r16.getClass();
        r6 = BotApi.c(r17, r18, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
