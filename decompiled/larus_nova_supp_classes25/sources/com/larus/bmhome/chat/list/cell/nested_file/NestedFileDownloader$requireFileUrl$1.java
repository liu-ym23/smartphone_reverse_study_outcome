package com.larus.bmhome.chat.list.cell.nested_file;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.nested_file.NestedFileDownloader", f = "NestedFileDownloader.kt", i = {0, 1}, l = {182, DoraCallStateCode.ENV_OBSERVE_USER_TIMER_START, DoraCallStateCode.ENV_OBSERVE_USER_TIMER_END, DoraCallStateCode.ENV_OBSERVE_AUTO_TIMER_ENTER_PAUSE}, m = "requireFileUrl", n = {"uplinkFileInfo", "uplinkFileInfo"}, s = {"L$0", "L$0"})
public final class NestedFileDownloader$requireFileUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NestedFileDownloader this$0;

    public NestedFileDownloader$requireFileUrl$1(NestedFileDownloader r1, Continuation<? super NestedFileDownloader$requireFileUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, this);
    }
}
