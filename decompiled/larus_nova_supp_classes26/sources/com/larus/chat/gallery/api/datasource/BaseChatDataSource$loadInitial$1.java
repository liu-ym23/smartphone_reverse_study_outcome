package com.larus.chat.gallery.api.datasource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.api.datasource.BaseChatDataSource", f = "BaseChatDataSource.kt", i = {}, l = {48}, m = "loadInitial$suspendImpl", n = {}, s = {})
public final class BaseChatDataSource$loadInitial$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseChatDataSource<T> this$0;

    public BaseChatDataSource$loadInitial$1(BaseChatDataSource<T> r1, Continuation<? super BaseChatDataSource$loadInitial$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return BaseChatDataSource.n(this.this$0, this);
    }
}
