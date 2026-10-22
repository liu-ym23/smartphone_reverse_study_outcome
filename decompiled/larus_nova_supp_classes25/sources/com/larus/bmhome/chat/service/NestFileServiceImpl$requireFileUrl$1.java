package com.larus.bmhome.chat.service;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.service.NestFileServiceImpl", f = "NestFileServiceImpl.kt", i = {0}, l = {35}, m = "requireFileUrl", n = {"context"}, s = {"L$0"})
public final class NestFileServiceImpl$requireFileUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NestFileServiceImpl this$0;

    public NestFileServiceImpl$requireFileUrl$1(NestFileServiceImpl r1, Continuation<? super NestFileServiceImpl$requireFileUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
