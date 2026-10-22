package com.larus.bmhome.rc;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.rc.ResourceCenterUploadDelegate", f = "ResourceCenterUploadDelegate.kt", i = {}, l = {100}, m = "registerResource", n = {}, s = {})
final class ResourceCenterUploadDelegate$registerResource$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResourceCenterUploadDelegate this$0;

    public ResourceCenterUploadDelegate$registerResource$1(ResourceCenterUploadDelegate r1, Continuation<? super ResourceCenterUploadDelegate$registerResource$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ResourceCenterUploadDelegate.d(this.this$0, null, this);
    }
}
