package com.larus.bot.impl.feature.botmaker;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.botmaker.BotMakerModel", f = "BotMakerModel.kt", i = {1, 1, 2, 2, 3, 3}, l = {228, 245, 248, 255}, m = "requestBotBgImage", n = {"it", "imageInfo", "it", "imageInfo", "it", "imageInfo"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
final class BotMakerModel$requestBotBgImage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ k this$0;

    public BotMakerModel$requestBotBgImage$1(k r1, Continuation<? super BotMakerModel$requestBotBgImage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return k.a(this.this$0, null, null, this);
    }
}
