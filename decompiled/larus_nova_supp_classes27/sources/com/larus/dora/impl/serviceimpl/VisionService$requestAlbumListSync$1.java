package com.larus.dora.impl.serviceimpl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.VisionService", f = "VisionService.kt", i = {0, 0}, l = {298, 304}, m = "requestAlbumListSync", n = {"uid", "retryCount"}, s = {"L$0", "I$0"})
public final class VisionService$requestAlbumListSync$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VisionService this$0;

    public VisionService$requestAlbumListSync$1(VisionService r1, Continuation<? super VisionService$requestAlbumListSync$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.u(this);
    }
}
