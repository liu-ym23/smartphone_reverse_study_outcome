package com.larus.uaigc.lynx;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.lynx.LotteryLynxWarmer", f = "LotteryLynxWarmer.kt", i = {0}, l = {94}, m = "createIvyPluginView", n = {"ivyPluginView"}, s = {"L$0"})
final class LotteryLynxWarmer$createIvyPluginView$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LotteryLynxWarmer this$0;

    public LotteryLynxWarmer$createIvyPluginView$1(LotteryLynxWarmer r1, Continuation<? super LotteryLynxWarmer$createIvyPluginView$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return LotteryLynxWarmer.c(this.this$0, null, this);
    }
}
