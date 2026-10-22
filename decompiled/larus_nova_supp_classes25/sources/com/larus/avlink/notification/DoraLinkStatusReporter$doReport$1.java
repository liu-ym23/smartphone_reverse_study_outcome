package com.larus.avlink.notification;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.notification.DoraLinkStatusReporter", f = "DoraLinkStatusReporter.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {154, DoraCallStateCode.DOUBAO_START_LIVE_TUTOR}, m = "doReport", n = {"result", "postBody", "retryCount", "failCount", "result", "postBody", "retryCount", "failCount", "needRetry"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "I$2"})
final class DoraLinkStatusReporter$doReport$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraLinkStatusReporter this$0;

    public DoraLinkStatusReporter$doReport$1(DoraLinkStatusReporter r1, Continuation<? super DoraLinkStatusReporter$doReport$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return DoraLinkStatusReporter.a(this.this$0, false, 0, 0, 0, this);
    }
}
