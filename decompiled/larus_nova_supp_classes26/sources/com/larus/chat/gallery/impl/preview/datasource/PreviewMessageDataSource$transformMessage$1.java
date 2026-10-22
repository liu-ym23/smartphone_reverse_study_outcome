package com.larus.chat.gallery.impl.preview.datasource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.datasource.PreviewMessageDataSource", f = "PreviewMessageDataSource.kt", i = {0, 0, 1, 1}, l = {329, 330}, m = "transformMessage", n = {"dataList", "firstItem", "dataList", "firstItem"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class PreviewMessageDataSource$transformMessage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreviewMessageDataSource this$0;

    public PreviewMessageDataSource$transformMessage$1(PreviewMessageDataSource r1, Continuation<? super PreviewMessageDataSource$transformMessage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        PreviewMessageDataSource r3 = this.this$0;
        int r0 = PreviewMessageDataSource.p;
        return r3.x(null, this);
    }
}
