package com.larus.bot.impl.feature.edit.feature.autofill;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.autofill.BotAutoFillViewModel", f = "BotAutoFillViewModel.kt", i = {}, l = {936}, m = "requireEnrichCheck", n = {}, s = {})
public final class BotAutoFillViewModel$requireEnrichCheck$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BotAutoFillViewModel this$0;

    public BotAutoFillViewModel$requireEnrichCheck$1(BotAutoFillViewModel r1, Continuation<? super BotAutoFillViewModel$requireEnrichCheck$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        BotAutoFillViewModel r3 = this.this$0;
        int r0 = BotAutoFillViewModel.x;
        return r3.K(null, this);
    }
}
