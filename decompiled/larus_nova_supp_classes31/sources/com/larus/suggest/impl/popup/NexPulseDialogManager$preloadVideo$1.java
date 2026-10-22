package com.larus.suggest.impl.popup;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.popup.NexPulseDialogManager", f = "NexPulseDialogManager.kt", i = {0}, l = {156}, m = "preloadVideo", n = {"imageUrl"}, s = {"L$0"})
final class NexPulseDialogManager$preloadVideo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ q this$0;

    public NexPulseDialogManager$preloadVideo$1(q r1, Continuation<? super NexPulseDialogManager$preloadVideo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return q.b(this.this$0, null, this);
    }
}
