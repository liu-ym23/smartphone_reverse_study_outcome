package com.larus.bmhome.chat.thinkmode;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.thinkmode.IThinkModeMemoryReportService$Companion", f = "IThinkModeMemoryReportService.kt", i = {0, 0}, l = {66}, m = "report", n = {"behaviorSource", "conversationSource"}, s = {"L$0", "L$1"})
public final class IThinkModeMemoryReportService$Companion$report$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IThinkModeMemoryReportService.Companion this$0;

    public IThinkModeMemoryReportService$Companion$report$1(IThinkModeMemoryReportService.Companion r1, Continuation<? super IThinkModeMemoryReportService$Companion$report$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, this);
    }
}
