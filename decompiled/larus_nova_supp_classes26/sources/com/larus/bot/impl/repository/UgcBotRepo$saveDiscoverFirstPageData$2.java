package com.larus.bot.impl.repository;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.chat.bean.RecommendBot;
import ic8.o0;
import java.util.List;
import kotlin.Lazy;
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
import zp9.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.repository.UgcBotRepo$saveDiscoverFirstPageData$2", f = "UgcBotRepo.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
public final class UgcBotRepo$saveDiscoverFirstPageData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ o0 $recommendData;
    int label;
    final /* synthetic */ UgcBotRepo this$0;

    public UgcBotRepo$saveDiscoverFirstPageData$2(o0 r1, UgcBotRepo r2, Continuation<? super UgcBotRepo$saveDiscoverFirstPageData$2> r3) {
        this.$recommendData = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new UgcBotRepo$saveDiscoverFirstPageData$2(this.$recommendData, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        o0 r10 = this.$recommendData;
        if (r10 == null) goto L11;
        List<RecommendBot> r11 = r10.b();
        UgcBotRepo r2 = this.this$0;
        Lazy<UgcBotRepo> r3 = UgcBotRepo.d;
        r2.e().storeString("key_recommend_bot_first_page_data", GsonProtectorUtils.toJson(new Gson(), o0.a(this.$recommendData, null, false, 62)));
        this.this$0.e().storeBoolean("key_has_recommend_bot_first_page_data", true);
        UgcBotRepo r4 = this.this$0;
        List r5 = this.$recommendData.e();
        if (r5 == null) goto L17;
        w r6 = (w) CollectionsKt.getOrNull(r5, 0);
        if (r6 == null) goto L17;
        long r7 = r6.a;
    L18:
        this.label = 1;
        if (r4.l(r7, r11, this) != r0) goto L22;
        return r0;
    L17:
        r7 = 1;
        goto L18
    L11:
        return Unit.INSTANCE;
    }
}
