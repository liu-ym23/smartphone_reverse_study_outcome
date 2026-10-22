package com.larus.uaigc.createpage.component.stylelist;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.stylelist.ImageStyleListComponent", f = "ImageStyleListComponent.kt", i = {}, l = {213}, m = "fetchImageStyleListFromRemote", n = {}, s = {})
public final class ImageStyleListComponent$fetchImageStyleListFromRemote$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageStyleListComponent this$0;

    public ImageStyleListComponent$fetchImageStyleListFromRemote$1(ImageStyleListComponent r1, Continuation<? super ImageStyleListComponent$fetchImageStyleListFromRemote$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ImageStyleListComponent r3 = this.this$0;
        int r0 = ImageStyleListComponent.p;
        return r3.F2(null, this);
    }
}
