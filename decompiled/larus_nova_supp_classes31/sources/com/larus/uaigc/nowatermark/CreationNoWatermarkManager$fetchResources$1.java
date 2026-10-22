package com.larus.uaigc.nowatermark;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.nowatermark.CreationNoWatermarkManager", f = "CreationNoWatermarkManager.kt", i = {0, 0, 0, 0}, l = {1417}, m = "fetchResources", n = {"scene", "accountContext", "uris", "vids"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class CreationNoWatermarkManager$fetchResources$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationNoWatermarkManager this$0;

    public CreationNoWatermarkManager$fetchResources$1(CreationNoWatermarkManager r1, Continuation<? super CreationNoWatermarkManager$fetchResources$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        CreationNoWatermarkManager r0 = this.this$0;
        CreationNoWatermarkManager r8 = CreationNoWatermarkManager.a;
        return r0.v(null, null, null, null, this);
    }
}
