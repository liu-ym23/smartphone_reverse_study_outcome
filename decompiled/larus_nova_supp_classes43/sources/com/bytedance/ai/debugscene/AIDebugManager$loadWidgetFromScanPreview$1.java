package com.bytedance.ai.debugscene;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.debugscene.AIDebugManager", f = "AIDebugManager.kt", i = {0}, l = {1369}, m = "loadWidgetFromScanPreview", n = {"widgetId"}, s = {"L$0"})
public final class AIDebugManager$loadWidgetFromScanPreview$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIDebugManager this$0;

    public AIDebugManager$loadWidgetFromScanPreview$1(AIDebugManager r1, Continuation<? super AIDebugManager$loadWidgetFromScanPreview$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        AIDebugManager r11 = this.this$0;
        AIDebugManager r0 = AIDebugManager.a;
        return r11.r(null, null, null, this);
    }
}
