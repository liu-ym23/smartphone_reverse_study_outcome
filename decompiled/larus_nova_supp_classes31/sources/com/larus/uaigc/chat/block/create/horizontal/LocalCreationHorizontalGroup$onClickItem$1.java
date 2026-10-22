package com.larus.uaigc.chat.block.create.horizontal;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.horizontal.LocalCreationHorizontalGroup", f = "LocalCreationHorizontalGroup.kt", i = {}, l = {287}, m = "onClickItem", n = {}, s = {})
final class LocalCreationHorizontalGroup$onClickItem$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalCreationHorizontalGroup this$0;

    public LocalCreationHorizontalGroup$onClickItem$1(LocalCreationHorizontalGroup r1, Continuation<? super LocalCreationHorizontalGroup$onClickItem$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return LocalCreationHorizontalGroup.o(this.this$0, null, null, null, this);
    }
}
