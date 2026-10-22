package com.larus.avlink.plugins;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.plugins.DoraTaskPlugin", f = "DoraTaskPlugin.kt", i = {0, 0}, l = {459}, m = "stopAndReportCommandSend", n = {"cs", "startTime"}, s = {"L$0", "J$0"})
final class DoraTaskPlugin$stopAndReportCommandSend$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraTaskPlugin this$0;

    public DoraTaskPlugin$stopAndReportCommandSend$1(DoraTaskPlugin r1, Continuation<? super DoraTaskPlugin$stopAndReportCommandSend$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DoraTaskPlugin.k3(this.this$0, 0, 0, this);
    }
}
