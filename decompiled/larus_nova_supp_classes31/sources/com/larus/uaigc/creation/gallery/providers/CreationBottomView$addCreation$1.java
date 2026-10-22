package com.larus.uaigc.creation.gallery.providers;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationBottomView", f = "CreationBottomView.kt", i = {1, 1, 1, 2, 2, 3, 3}, l = {374, 391, 398, 410}, m = "addCreation", n = {"publisherCreation", "privateStatus", "buttonStatus", "privateStatus", "buttonStatus", "result", "privateStatus"}, s = {"L$0", "I$0", "I$1", "I$0", "I$1", "L$0", "I$0"})
final class CreationBottomView$addCreation$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationBottomView this$0;

    public CreationBottomView$addCreation$1(CreationBottomView r1, Continuation<? super CreationBottomView$addCreation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CreationBottomView.R5(this.this$0, this);
    }
}
