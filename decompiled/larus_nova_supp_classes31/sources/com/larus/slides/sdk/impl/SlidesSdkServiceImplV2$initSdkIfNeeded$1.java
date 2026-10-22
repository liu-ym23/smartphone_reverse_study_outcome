package com.larus.slides.sdk.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.sdk.impl.SlidesSdkServiceImplV2", f = "SlidesSdkServiceImplV2.kt", i = {}, l = {284}, m = "initSdkIfNeeded", n = {}, s = {})
public final class SlidesSdkServiceImplV2$initSdkIfNeeded$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SlidesSdkServiceImplV2 this$0;

    public SlidesSdkServiceImplV2$initSdkIfNeeded$1(SlidesSdkServiceImplV2 r1, Continuation<? super SlidesSdkServiceImplV2$initSdkIfNeeded$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
