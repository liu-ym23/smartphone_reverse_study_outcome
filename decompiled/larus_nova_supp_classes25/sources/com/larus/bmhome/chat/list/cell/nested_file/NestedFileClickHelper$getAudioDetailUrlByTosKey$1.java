package com.larus.bmhome.chat.list.cell.nested_file;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.nested_file.NestedFileClickHelper", f = "NestedFileClickHelper.kt", i = {0}, l = {800}, m = "getAudioDetailUrlByTosKey", n = {"tosKey"}, s = {"L$0"})
public final class NestedFileClickHelper$getAudioDetailUrlByTosKey$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NestedFileClickHelper this$0;

    public NestedFileClickHelper$getAudioDetailUrlByTosKey$1(NestedFileClickHelper r1, Continuation<? super NestedFileClickHelper$getAudioDetailUrlByTosKey$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, this);
    }
}
