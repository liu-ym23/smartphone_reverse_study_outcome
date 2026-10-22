package com.ss.android.lark.feed.molten.cache.user;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.feed.molten.cache.user.FeedUserHolderLocalCache", f = "FeedUserHolderLocalCache.kt", i = {0, 0}, l = {353}, m = "persistPlan", n = {"plan", "mark$iv$iv"}, s = {"L$0", "J$0"})
public final class FeedUserHolderLocalCache$persistPlan$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedUserHolderLocalCache this$0;

    public FeedUserHolderLocalCache$persistPlan$1(FeedUserHolderLocalCache r1, Continuation<? super FeedUserHolderLocalCache$persistPlan$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        FeedUserHolderLocalCache r3 = this.this$0;
        int r0 = FeedUserHolderLocalCache.p;
        return r3.f(null, this);
    }
}
