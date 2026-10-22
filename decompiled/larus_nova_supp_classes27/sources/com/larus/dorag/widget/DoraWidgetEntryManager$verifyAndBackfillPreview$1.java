package com.larus.dorag.widget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dorag.widget.DoraWidgetEntryManager", f = "DoraWidgetEntryManager.kt", i = {0, 0, 1, 1, 1}, l = {178, 190}, m = "verifyAndBackfillPreview", n = {"appWidgetManager", "requestGeneration", "appWidgetManager", "registeredProviders", "requestGeneration"}, s = {"L$0", "J$0", "L$0", "L$1", "J$0"})
public final class DoraWidgetEntryManager$verifyAndBackfillPreview$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraWidgetEntryManager this$0;

    public DoraWidgetEntryManager$verifyAndBackfillPreview$1(DoraWidgetEntryManager r1, Continuation<? super DoraWidgetEntryManager$verifyAndBackfillPreview$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        DoraWidgetEntryManager r5 = this.this$0;
        DoraWidgetEntryManager r0 = DoraWidgetEntryManager.a;
        return r5.h(null, 0, this);
    }
}
