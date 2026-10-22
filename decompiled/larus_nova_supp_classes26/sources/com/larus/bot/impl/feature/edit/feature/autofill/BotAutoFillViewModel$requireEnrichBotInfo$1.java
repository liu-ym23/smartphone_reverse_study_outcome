package com.larus.bot.impl.feature.edit.feature.autofill;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.autofill.BotAutoFillViewModel", f = "BotAutoFillViewModel.kt", i = {0}, l = {486, 495}, m = "requireEnrichBotInfo", n = {"requestParam"}, s = {"L$0"})
final class BotAutoFillViewModel$requireEnrichBotInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BotAutoFillViewModel this$0;

    public BotAutoFillViewModel$requireEnrichBotInfo$1(BotAutoFillViewModel r1, Continuation<? super BotAutoFillViewModel$requireEnrichBotInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return BotAutoFillViewModel.w(this.this$0, this);
    }
}
