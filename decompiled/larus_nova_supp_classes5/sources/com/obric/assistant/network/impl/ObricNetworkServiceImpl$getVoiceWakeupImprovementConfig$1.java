package com.obric.assistant.network.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl", f = "ObricNetworkServiceImpl.kt", i = {}, l = {1955}, m = "getVoiceWakeupImprovementConfig", n = {}, s = {})
public final class ObricNetworkServiceImpl$getVoiceWakeupImprovementConfig$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricNetworkServiceImpl this$0;

    public ObricNetworkServiceImpl$getVoiceWakeupImprovementConfig$1(ObricNetworkServiceImpl r1, Continuation<? super ObricNetworkServiceImpl$getVoiceWakeupImprovementConfig$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= IntCompanionObject.MIN_VALUE;
        return this.this$0.p(this);
    }
}
