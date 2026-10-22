package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.platform.model.HandsfreeExperimentConfig;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMessageStrategy", f = "CreationMessageStrategy.kt", i = {}, l = {131, 132, 133}, m = HandsfreeExperimentConfig.ASR_END_SEND, n = {}, s = {})
public final class CreationMessageStrategy$send$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationMessageStrategy this$0;

    public CreationMessageStrategy$send$1(CreationMessageStrategy r1, Continuation<? super CreationMessageStrategy$send$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.y(null, this);
    }
}
