package com.obric.assistant.state.impl.multitask.producer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.SelfUpdateDownloadStateProducer", f = "SelfUpdateDownloadStateProducer.kt", i = {0}, l = {90}, m = "startOrRefreshTask", n = {"state"}, s = {"L$0"})
public final class SelfUpdateDownloadStateProducer$startOrRefreshTask$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SelfUpdateDownloadStateProducer this$0;

    public SelfUpdateDownloadStateProducer$startOrRefreshTask$1(SelfUpdateDownloadStateProducer r1, Continuation<? super SelfUpdateDownloadStateProducer$startOrRefreshTask$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        SelfUpdateDownloadStateProducer r3 = this.this$0;
        int r0 = SelfUpdateDownloadStateProducer.i;
        return r3.b(this);
    }
}
