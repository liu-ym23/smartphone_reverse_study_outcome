package com.larus.uaigc.chat.block.create;

import com.larus.uaigc.chat.block.create.i;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.BaseCreationHolder", f = "BaseCreationHolder.kt", i = {0, 2}, l = {108, 104, 131, 127}, m = "handleItemLongClick$suspendImpl", n = {"createBlockConfig", "createBlockConfig"}, s = {"L$0", "L$0"})
public final class BaseCreationHolder$handleItemLongClick$1<T extends i> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseCreationHolder<T> this$0;

    public BaseCreationHolder$handleItemLongClick$1(BaseCreationHolder<T> r1, Continuation<? super BaseCreationHolder$handleItemLongClick$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return BaseCreationHolder.l(this.this$0, null, null, null, null, this);
    }
}
