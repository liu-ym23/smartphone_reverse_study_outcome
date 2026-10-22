package com.larus.voicecall.impl.component.denoise;

import com.mammon.audiosdk.enums.SAMICoreSessionRequestType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.denoise.DenoiseNetUtil", f = "DenoiseNetUtil.kt", i = {}, l = {SAMICoreSessionRequestType.SAMICore_Session_RequestType_Translate}, m = "reportDenoiseStatus", n = {}, s = {})
public final class DenoiseNetUtil$reportDenoiseStatus$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DenoiseNetUtil this$0;

    public DenoiseNetUtil$reportDenoiseStatus$1(DenoiseNetUtil r1, Continuation<? super DenoiseNetUtil$reportDenoiseStatus$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
