package com.larus.share.impl.sdk.special;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.sdk.special.ShareImageSpecialHandler", f = "ShareImageSpecialHandler.kt", i = {0, 0}, l = {286}, m = "saveVideoByMdlCache", n = {"cacheKey", "targetPath"}, s = {"L$0", "L$1"})
final class ShareImageSpecialHandler$saveVideoByMdlCache$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ShareImageSpecialHandler this$0;

    public ShareImageSpecialHandler$saveVideoByMdlCache$1(ShareImageSpecialHandler r1, Continuation<? super ShareImageSpecialHandler$saveVideoByMdlCache$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ShareImageSpecialHandler.e(this.this$0, null, null, null, this);
    }
}
