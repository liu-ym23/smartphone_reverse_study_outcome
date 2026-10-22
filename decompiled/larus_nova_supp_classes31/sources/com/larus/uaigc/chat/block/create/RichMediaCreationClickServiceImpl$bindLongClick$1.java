package com.larus.uaigc.chat.block.create;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.RichMediaCreationClickServiceImpl", f = "RichMediaCreationClickServiceImpl.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {165, 184, 190}, m = "bindLongClick", n = {"bindView", "message", "createBlockConfig", "extraTraceParams", "itemData", "bindView", "message", "createBlockConfig", "extraTraceParams", "itemData", "imageCommonParams"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
public final class RichMediaCreationClickServiceImpl$bindLongClick$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RichMediaCreationClickServiceImpl this$0;

    public RichMediaCreationClickServiceImpl$bindLongClick$1(RichMediaCreationClickServiceImpl r1, Continuation<? super RichMediaCreationClickServiceImpl$bindLongClick$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r14) {
        this.result = r14;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, null, null, 0, 0, 0, null, null, null, null, null, this);
    }
}
