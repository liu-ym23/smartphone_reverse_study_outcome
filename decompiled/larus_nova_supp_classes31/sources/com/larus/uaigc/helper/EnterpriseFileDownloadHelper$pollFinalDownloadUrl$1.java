package com.larus.uaigc.helper;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.helper.EnterpriseFileDownloadHelper", f = "EnterpriseFileDownloadHelper.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {106, 132}, m = "pollFinalDownloadUrl", n = {"taskId", "context", "maxPollCount", "pollIntervalMs", "attempt", "taskId", "context", "maxPollCount", "pollIntervalMs"}, s = {"L$0", "L$1", "I$0", "J$0", "I$2", "L$0", "L$1", "I$0", "J$0"})
public final class EnterpriseFileDownloadHelper$pollFinalDownloadUrl$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EnterpriseFileDownloadHelper this$0;

    public EnterpriseFileDownloadHelper$pollFinalDownloadUrl$1(EnterpriseFileDownloadHelper r1, Continuation<? super EnterpriseFileDownloadHelper$pollFinalDownloadUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        EnterpriseFileDownloadHelper r3 = this.this$0;
        EnterpriseFileDownloadHelper r0 = EnterpriseFileDownloadHelper.a;
        return r3.b(null, null, this);
    }
}
