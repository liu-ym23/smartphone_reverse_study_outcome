package com.larus.camera.impl.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.utils.CaptureResultDetectLogic", f = "CaptureResultDetectLogic.kt", i = {}, l = {76}, m = "requestServerDetect", n = {}, s = {})
public final class CaptureResultDetectLogic$requestServerDetect$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CaptureResultDetectLogic this$0;

    public CaptureResultDetectLogic$requestServerDetect$1(CaptureResultDetectLogic r1, Continuation<? super CaptureResultDetectLogic$requestServerDetect$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, this);
    }
}
