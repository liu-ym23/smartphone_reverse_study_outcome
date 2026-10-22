package com.larus.bot.impl.feature.edit.feature.bgimage;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.BotBgImageEditViewModel", f = "BotBgImageEditViewModel.kt", i = {0}, l = {323}, m = "interceptShowGenActionSheetForBotInfoReview", n = {"delayShowLoadingJob"}, s = {"L$0"})
final class BotBgImageEditViewModel$interceptShowGenActionSheetForBotInfoReview$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BotBgImageEditViewModel this$0;

    public BotBgImageEditViewModel$interceptShowGenActionSheetForBotInfoReview$1(BotBgImageEditViewModel r1, Continuation<? super BotBgImageEditViewModel$interceptShowGenActionSheetForBotInfoReview$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return BotBgImageEditViewModel.q(this.this$0, null, null, this);
    }
}
