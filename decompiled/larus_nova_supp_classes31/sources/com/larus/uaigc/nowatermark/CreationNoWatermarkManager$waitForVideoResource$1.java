package com.larus.uaigc.nowatermark;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.nowatermark.CreationNoWatermarkManager", f = "CreationNoWatermarkManager.kt", i = {}, l = {1924}, m = "waitForVideoResource", n = {}, s = {})
public final class CreationNoWatermarkManager$waitForVideoResource$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationNoWatermarkManager this$0;

    public CreationNoWatermarkManager$waitForVideoResource$1(CreationNoWatermarkManager r1, Continuation<? super CreationNoWatermarkManager$waitForVideoResource$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        CreationNoWatermarkManager r5 = this.this$0;
        CreationNoWatermarkManager r0 = CreationNoWatermarkManager.a;
        return r5.w0(null, 0, this);
    }
}
