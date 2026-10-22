package com.larus.bmhome.upload.sdk;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.ResourceCenterTokenCredentialProvider", f = "ResourceUploadSdkIntegration.kt", i = {0, 0, 0, 0, 0}, l = {86}, m = "fetch", n = {"request", "route", "originParam", "resourceType", "scene"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class ResourceCenterTokenCredentialProvider$fetch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResourceCenterTokenCredentialProvider this$0;

    public ResourceCenterTokenCredentialProvider$fetch$1(ResourceCenterTokenCredentialProvider r1, Continuation<? super ResourceCenterTokenCredentialProvider$fetch$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
