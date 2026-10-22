package com.larus.bot.impl.repository;

import com.google.gson.Gson;
import com.larus.bmhome.chat.bean.RecommendBot;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.repository.UgcBotRepo$saveRecommendBotList$2", f = "UgcBotRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UgcBotRepo$saveRecommendBotList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<RecommendBot> $recommendBotList;
    final /* synthetic */ long $tagId;
    int label;
    final /* synthetic */ UgcBotRepo this$0;

    public UgcBotRepo$saveRecommendBotList$2(List<RecommendBot> r1, UgcBotRepo r2, long r3, Continuation<? super UgcBotRepo$saveRecommendBotList$2> r5) {
        this.$recommendBotList = r1;
        this.this$0 = r2;
        this.$tagId = r3;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new UgcBotRepo$saveRecommendBotList$2(this.$recommendBotList, this.this$0, this.$tagId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r5);
        if (this.$recommendBotList == null) goto L7;
        UgcBotRepo r6 = this.this$0;     // Catch: Exception -> L10
        Lazy<UgcBotRepo> r1 = UgcBotRepo.d;     // Catch: Exception -> L10
        r6.e().storeString("key_recommend_bot_data_" + this.$tagId, new Gson().toJson(this.$recommendBotList));     // Catch: Exception -> L10
    L13:
        return Unit.INSTANCE;
    L10:
        e = move-exception;
        com.larus.platform.service.g.a.ensureNotReachHere(e, "saveRecommendBotList");
        goto L13
    L7:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
