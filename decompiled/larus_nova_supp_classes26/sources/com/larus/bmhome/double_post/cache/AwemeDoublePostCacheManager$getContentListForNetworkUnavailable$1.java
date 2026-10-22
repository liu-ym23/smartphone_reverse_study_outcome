package com.larus.bmhome.double_post.cache;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.cache.AwemeDoublePostCacheManager", f = "AwemeDoublePostCacheManager.kt", i = {}, l = {100}, m = "getContentListForNetworkUnavailable", n = {}, s = {})
public final class AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AwemeDoublePostCacheManager this$0;

    public AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$1(AwemeDoublePostCacheManager r1, Continuation<? super AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
