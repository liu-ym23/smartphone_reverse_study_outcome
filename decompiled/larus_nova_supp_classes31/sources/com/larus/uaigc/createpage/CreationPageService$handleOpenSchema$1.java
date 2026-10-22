package com.larus.uaigc.createpage;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.CreationPageService", f = "CreationPageService.kt", i = {0, 0, 0, 0}, l = {336, 349}, m = "handleOpenSchema", n = {"item", "enterMethod", "mainBotId", "conversationId"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class CreationPageService$handleOpenSchema$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationPageService this$0;

    public CreationPageService$handleOpenSchema$1(CreationPageService r1, Continuation<? super CreationPageService$handleOpenSchema$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CreationPageService.h(this.this$0, null, null, this);
    }
}
