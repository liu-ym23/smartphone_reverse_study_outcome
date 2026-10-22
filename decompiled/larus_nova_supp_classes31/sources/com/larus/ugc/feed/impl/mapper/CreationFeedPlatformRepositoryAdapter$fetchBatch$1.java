package com.larus.ugc.feed.impl.mapper;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.mapper.CreationFeedPlatformRepositoryAdapter", f = "CreationFeedPlatformMapper.kt", i = {}, l = {340}, m = "fetchBatch", n = {}, s = {})
public final class CreationFeedPlatformRepositoryAdapter$fetchBatch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationFeedPlatformRepositoryAdapter this$0;

    public CreationFeedPlatformRepositoryAdapter$fetchBatch$1(CreationFeedPlatformRepositoryAdapter r1, Continuation<? super CreationFeedPlatformRepositoryAdapter$fetchBatch$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0, null, null, null, this);
    }
}
