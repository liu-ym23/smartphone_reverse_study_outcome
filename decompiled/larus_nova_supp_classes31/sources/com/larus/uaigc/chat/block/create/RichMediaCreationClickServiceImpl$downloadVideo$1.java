package com.larus.uaigc.chat.block.create;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.RichMediaCreationClickServiceImpl", f = "RichMediaCreationClickServiceImpl.kt", i = {0, 0, 0, 0, 0, 0}, l = {545}, m = "downloadVideo", n = {"anchorView", "message", "clickItem", "onCompleted", "extraTraceParams", "userCreation"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
public final class RichMediaCreationClickServiceImpl$downloadVideo$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RichMediaCreationClickServiceImpl this$0;

    public RichMediaCreationClickServiceImpl$downloadVideo$1(RichMediaCreationClickServiceImpl r1, Continuation<? super RichMediaCreationClickServiceImpl$downloadVideo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        RichMediaCreationClickServiceImpl r0 = this.this$0;
        int r12 = RichMediaCreationClickServiceImpl.b;
        return r0.i(null, null, null, 0, null, null, null, null, this);
    }
}
