package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.resource.access.ResourceAccessPipeline", f = "ResourceAccessPipeline.kt", i = {}, l = {71, 71}, m = "handleResult", n = {}, s = {})
public final class ResourceAccessPipeline$handleResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResourceAccessPipeline this$0;

    public ResourceAccessPipeline$handleResult$1(ResourceAccessPipeline r1, Continuation<? super ResourceAccessPipeline$handleResult$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ResourceAccessPipeline r3 = this.this$0;
        ResourceAccessPipeline r0 = ResourceAccessPipeline.a;
        return r3.b(null, null, null, this);
    }
}
