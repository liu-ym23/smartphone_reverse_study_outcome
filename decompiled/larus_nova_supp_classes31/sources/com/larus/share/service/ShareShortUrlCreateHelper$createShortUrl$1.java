package com.larus.share.service;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.service.ShareShortUrlCreateHelper", f = "ShareShortUrlCreateHelper.kt", i = {0}, l = {33}, m = "createShortUrl", n = {"actualTimeoutMs"}, s = {"J$0"})
public final class ShareShortUrlCreateHelper$createShortUrl$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ShareShortUrlCreateHelper this$0;

    public ShareShortUrlCreateHelper$createShortUrl$1(ShareShortUrlCreateHelper r1, Continuation<? super ShareShortUrlCreateHelper$createShortUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, false, null, 0, this);
    }
}
