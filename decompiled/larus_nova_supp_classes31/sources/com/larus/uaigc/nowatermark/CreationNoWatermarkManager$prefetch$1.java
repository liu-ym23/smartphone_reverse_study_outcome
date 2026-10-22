package com.larus.uaigc.nowatermark;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.nowatermark.CreationNoWatermarkManager", f = "CreationNoWatermarkManager.kt", i = {0, 0, 0}, l = {1323, 1327}, m = "prefetch", n = {"keys", "scene", "accountContext"}, s = {"L$0", "L$1", "L$2"})
public final class CreationNoWatermarkManager$prefetch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationNoWatermarkManager this$0;

    public CreationNoWatermarkManager$prefetch$1(CreationNoWatermarkManager r1, Continuation<? super CreationNoWatermarkManager$prefetch$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        CreationNoWatermarkManager r3 = this.this$0;
        CreationNoWatermarkManager r0 = CreationNoWatermarkManager.a;
        return r3.M(null, null, this);
    }
}
