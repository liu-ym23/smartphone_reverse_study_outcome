package com.larus.camera.impl.vlm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.vlm.VLMIntentDetectRepository", f = "VLMIntentDetectRepository.kt", i = {0, 1, 1}, l = {55, 60}, m = "requestDetectInternal", n = {"tracker", "tracker", "httpRequest"}, s = {"L$0", "L$0", "L$1"})
public final class VLMIntentDetectRepository$requestDetectInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VLMIntentDetectRepository this$0;

    public VLMIntentDetectRepository$requestDetectInternal$1(VLMIntentDetectRepository r1, Continuation<? super VLMIntentDetectRepository$requestDetectInternal$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        VLMIntentDetectRepository r3 = this.this$0;
        VLMIntentDetectRepository r0 = VLMIntentDetectRepository.a;
        return r3.c(null, null, this);
    }
}
