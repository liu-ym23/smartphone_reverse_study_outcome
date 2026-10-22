package com.larus.bmhome.upload.sdk;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.UploadAuthTokenCredentialProvider", f = "ResourceUploadSdkIntegration.kt", i = {0, 0, 0}, l = {155}, m = "fetch", n = {"request", "route", "originParam"}, s = {"L$0", "L$1", "L$2"})
public final class UploadAuthTokenCredentialProvider$fetch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UploadAuthTokenCredentialProvider this$0;

    public UploadAuthTokenCredentialProvider$fetch$1(UploadAuthTokenCredentialProvider r1, Continuation<? super UploadAuthTokenCredentialProvider$fetch$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
