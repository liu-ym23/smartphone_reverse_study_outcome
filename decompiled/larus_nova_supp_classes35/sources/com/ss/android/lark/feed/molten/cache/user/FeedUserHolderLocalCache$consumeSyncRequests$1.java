package com.ss.android.lark.feed.molten.cache.user;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.feed.molten.cache.user.FeedUserHolderLocalCache", f = "FeedUserHolderLocalCache.kt", i = {}, l = {265, 268}, m = "consumeSyncRequests", n = {}, s = {})
final class FeedUserHolderLocalCache$consumeSyncRequests$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedUserHolderLocalCache this$0;

    public FeedUserHolderLocalCache$consumeSyncRequests$1(FeedUserHolderLocalCache r1, Continuation<? super FeedUserHolderLocalCache$consumeSyncRequests$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        return FeedUserHolderLocalCache.b(this.this$0, this);
    }
}
