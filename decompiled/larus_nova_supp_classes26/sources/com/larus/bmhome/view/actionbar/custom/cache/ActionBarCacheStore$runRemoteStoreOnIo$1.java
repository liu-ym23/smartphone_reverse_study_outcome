package com.larus.bmhome.view.actionbar.custom.cache;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.cache.ActionBarCacheStore", f = "ActionBarCacheStore.kt", i = {0, 0, 1}, l = {316, 176}, m = "runRemoteStoreOnIo", n = {"block", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
public final class ActionBarCacheStore$runRemoteStoreOnIo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ActionBarCacheStore this$0;

    public ActionBarCacheStore$runRemoteStoreOnIo$1(ActionBarCacheStore r1, Continuation<? super ActionBarCacheStore$runRemoteStoreOnIo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, this);
    }
}
