package com.larus.bmhome.chat.list.cell.nested_file;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.nested_file.NestedFileDownloader", f = "NestedFileDownloader.kt", i = {0, 0}, l = {394}, m = "applyWatermarkOrFallback", n = {"src", "perf"}, s = {"L$0", "L$1"})
public final class NestedFileDownloader$applyWatermarkOrFallback$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NestedFileDownloader this$0;

    public NestedFileDownloader$applyWatermarkOrFallback$1(NestedFileDownloader r1, Continuation<? super NestedFileDownloader$applyWatermarkOrFallback$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        NestedFileDownloader r3 = this.this$0;
        NestedFileDownloader r0 = NestedFileDownloader.a;
        return r3.a(null, this);
    }
}
