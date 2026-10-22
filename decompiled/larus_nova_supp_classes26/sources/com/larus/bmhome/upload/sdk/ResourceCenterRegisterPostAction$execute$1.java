package com.larus.bmhome.upload.sdk;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.ResourceCenterRegisterPostAction", f = "ResourceUploadSdkIntegration.kt", i = {0, 0, 0, 0, 0, 0}, l = {385}, m = "execute", n = {"context", "identifier", "originParam", "uploadResult", "tosKey", "scene"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
public final class ResourceCenterRegisterPostAction$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResourceCenterRegisterPostAction this$0;

    public ResourceCenterRegisterPostAction$execute$1(ResourceCenterRegisterPostAction r1, Continuation<? super ResourceCenterRegisterPostAction$execute$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
