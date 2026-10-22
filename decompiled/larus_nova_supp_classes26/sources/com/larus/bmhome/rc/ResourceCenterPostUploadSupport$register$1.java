package com.larus.bmhome.rc;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.rc.ResourceCenterPostUploadSupport", f = "ResourceCenterPostUploadSupport.kt", i = {0, 0, 0}, l = {68}, m = "register", n = {"sceneId", "tosKey", "registerUri"}, s = {"L$0", "L$1", "L$2"})
public final class ResourceCenterPostUploadSupport$register$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResourceCenterPostUploadSupport this$0;

    public ResourceCenterPostUploadSupport$register$1(ResourceCenterPostUploadSupport r1, Continuation<? super ResourceCenterPostUploadSupport$register$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, null, null, null, null, this);
    }
}
