package com.larus.bmhome.chat.list.cell.nested_file;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.nested_file.NestedFileDownloader", f = "NestedFileDownloader.kt", i = {}, l = {241}, m = "requireFileUrlByTosKey", n = {}, s = {})
public final class NestedFileDownloader$requireFileUrlByTosKey$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NestedFileDownloader this$0;

    public NestedFileDownloader$requireFileUrlByTosKey$1(NestedFileDownloader r1, Continuation<? super NestedFileDownloader$requireFileUrlByTosKey$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        NestedFileDownloader r3 = this.this$0;
        NestedFileDownloader r0 = NestedFileDownloader.a;
        return r3.i(null, this);
    }
}
