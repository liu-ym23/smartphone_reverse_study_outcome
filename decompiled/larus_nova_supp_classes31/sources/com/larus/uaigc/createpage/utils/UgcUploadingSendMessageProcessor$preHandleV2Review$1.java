package com.larus.uaigc.createpage.utils;

import com.tencent.open.log.TraceLevel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor", f = "NestedFileSendMessageProcessor.kt", i = {}, l = {118}, m = "preHandleV2Review", n = {}, s = {})
public final class UgcUploadingSendMessageProcessor$preHandleV2Review$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UgcUploadingSendMessageProcessor this$0;

    public UgcUploadingSendMessageProcessor$preHandleV2Review$1(UgcUploadingSendMessageProcessor r1, Continuation<? super UgcUploadingSendMessageProcessor$preHandleV2Review$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        UgcUploadingSendMessageProcessor r0 = this.this$0;
        Set<String> r8 = UgcUploadingSendMessageProcessor.a;
        return r0.d(null, null, null, null, this);
    }
}
