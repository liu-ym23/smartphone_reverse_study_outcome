package com.larus.dorag.widget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dorag.widget.DoraWidgetEntryManager", f = "DoraWidgetEntryManager.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {155, 159, 165}, m = "updateWidgetPreview", n = {"appWidgetManager", "pending", "registeredProviders", "iterator", "requestGeneration", "attempt", "appWidgetManager", "pending", "requestGeneration", "attempt"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "I$0", "L$0", "L$1", "J$0", "I$0"})
final class DoraWidgetEntryManager$updateWidgetPreview$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraWidgetEntryManager this$0;

    public DoraWidgetEntryManager$updateWidgetPreview$1(DoraWidgetEntryManager r1, Continuation<? super DoraWidgetEntryManager$updateWidgetPreview$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return DoraWidgetEntryManager.a(this.this$0, 0, this);
    }
}
