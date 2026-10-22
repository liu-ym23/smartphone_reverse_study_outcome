package com.larus.uaigc.createpage.utils;

import com.tencent.open.log.TraceLevel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor", f = "NestedFileSendMessageProcessor.kt", i = {}, l = {90}, m = "ugcReviewImage", n = {}, s = {})
public final class UgcUploadingSendMessageProcessor$ugcReviewImage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UgcUploadingSendMessageProcessor this$0;

    public UgcUploadingSendMessageProcessor$ugcReviewImage$1(UgcUploadingSendMessageProcessor r1, Continuation<? super UgcUploadingSendMessageProcessor$ugcReviewImage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        UgcUploadingSendMessageProcessor r3 = this.this$0;
        Set<String> r0 = UgcUploadingSendMessageProcessor.a;
        return r3.f(null, this);
    }
}
