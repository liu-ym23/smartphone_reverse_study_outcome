package com.larus.uaigc.helper;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.helper.EnterpriseFileDownloadHelper", f = "EnterpriseFileDownloadHelper.kt", i = {0}, l = {34, 69}, m = "resolveFinalDownloadUrl", n = {"context"}, s = {"L$0"})
public final class EnterpriseFileDownloadHelper$resolveFinalDownloadUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EnterpriseFileDownloadHelper this$0;

    public EnterpriseFileDownloadHelper$resolveFinalDownloadUrl$1(EnterpriseFileDownloadHelper r1, Continuation<? super EnterpriseFileDownloadHelper$resolveFinalDownloadUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        EnterpriseFileDownloadHelper r3 = this.this$0;
        EnterpriseFileDownloadHelper r0 = EnterpriseFileDownloadHelper.a;
        return r3.c(null, this);
    }
}
