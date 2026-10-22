package com.larus.slides.sdk.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.sdk.impl.SlidesSdkServiceImplV2", f = "SlidesSdkServiceImplV2.kt", i = {0, 0, 0, 0}, l = {113}, m = "openAndGetSlidesFragment", n = {"inputParam", "listener", "hostAbilityProvider", "reloadInterceptor"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class SlidesSdkServiceImplV2$openAndGetSlidesFragment$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SlidesSdkServiceImplV2 this$0;

    public SlidesSdkServiceImplV2$openAndGetSlidesFragment$1(SlidesSdkServiceImplV2 r1, Continuation<? super SlidesSdkServiceImplV2$openAndGetSlidesFragment$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.s(null, null, null, null, this);
    }
}
