package com.larus.uaigc.chat.block.create.horizontal;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.horizontal.CreationHorizontalGroup", f = "CreationHorizontalGroup.kt", i = {}, l = {400, 404}, m = "onClickItem", n = {}, s = {})
final class CreationHorizontalGroup$onClickItem$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationHorizontalGroup this$0;

    public CreationHorizontalGroup$onClickItem$1(CreationHorizontalGroup r1, Continuation<? super CreationHorizontalGroup$onClickItem$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CreationHorizontalGroup.o(this.this$0, null, null, null, this);
    }
}
