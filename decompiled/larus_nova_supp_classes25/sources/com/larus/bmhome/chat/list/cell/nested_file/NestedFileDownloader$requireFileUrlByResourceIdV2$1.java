package com.larus.bmhome.chat.list.cell.nested_file;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.nested_file.NestedFileDownloader", f = "NestedFileDownloader.kt", i = {}, l = {DoraCallStateCode.RTC_STOP_FROM_P2P_FAILED}, m = "requireFileUrlByResourceIdV2", n = {}, s = {})
public final class NestedFileDownloader$requireFileUrlByResourceIdV2$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NestedFileDownloader this$0;

    public NestedFileDownloader$requireFileUrlByResourceIdV2$1(NestedFileDownloader r1, Continuation<? super NestedFileDownloader$requireFileUrlByResourceIdV2$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        NestedFileDownloader r3 = this.this$0;
        NestedFileDownloader r0 = NestedFileDownloader.a;
        return r3.h(null, this);
    }
}
