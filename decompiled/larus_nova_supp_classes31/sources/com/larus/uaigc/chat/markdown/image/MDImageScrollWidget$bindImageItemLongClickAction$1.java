package com.larus.uaigc.chat.markdown.image;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.image.MDImageScrollWidget", f = "MDImageScrollWidget.kt", i = {0, 0, 1, 1, 1, 1}, l = {415, 433}, m = "bindImageItemLongClickAction", n = {"itemData", "itemView", "itemView", "msg", "clickTask", "clickIndex"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "I$0"})
final class MDImageScrollWidget$bindImageItemLongClickAction$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MDImageScrollWidget this$0;

    public MDImageScrollWidget$bindImageItemLongClickAction$1(MDImageScrollWidget r1, Continuation<? super MDImageScrollWidget$bindImageItemLongClickAction$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MDImageScrollWidget.e(this.this$0, null, null, this);
    }
}
