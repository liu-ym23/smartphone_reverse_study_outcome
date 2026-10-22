package com.larus.chat.gallery.impl.preview.datasource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.datasource.PreviewMessageDataSource", f = "PreviewMessageDataSource.kt", i = {0, 2, 2}, l = {118, 125, 140}, m = "loadMore", n = {"localMessages", "result", "filteredMessages"}, s = {"L$0", "L$0", "L$1"})
final class PreviewMessageDataSource$loadMore$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreviewMessageDataSource this$0;

    public PreviewMessageDataSource$loadMore$1(PreviewMessageDataSource r1, Continuation<? super PreviewMessageDataSource$loadMore$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m(this);
    }
}
