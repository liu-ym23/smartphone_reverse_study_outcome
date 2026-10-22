package com.larus.uaigc.chat.markdown.image;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.image.MDImageScrollWidget", f = "MDImageScrollWidget.kt", i = {}, l = {458}, m = "onClickImageItem", n = {}, s = {})
final class MDImageScrollWidget$onClickImageItem$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MDImageScrollWidget this$0;

    public MDImageScrollWidget$onClickImageItem$1(MDImageScrollWidget r1, Continuation<? super MDImageScrollWidget$onClickImageItem$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MDImageScrollWidget.g(this.this$0, null, null, this);
    }
}
