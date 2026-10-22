package com.larus.chat.gallery.impl.preview.datasource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.datasource.PreviewCreationRecordDataSource", f = "PreviewCreationRecordDataSource.kt", i = {}, l = {249}, m = "awaitLoadMore", n = {}, s = {})
public final class PreviewCreationRecordDataSource$awaitLoadMore$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreviewCreationRecordDataSource this$0;

    public PreviewCreationRecordDataSource$awaitLoadMore$1(PreviewCreationRecordDataSource r1, Continuation<? super PreviewCreationRecordDataSource$awaitLoadMore$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        PreviewCreationRecordDataSource r3 = this.this$0;
        int r0 = PreviewCreationRecordDataSource.c;
        return r3.l(0, this);
    }
}
