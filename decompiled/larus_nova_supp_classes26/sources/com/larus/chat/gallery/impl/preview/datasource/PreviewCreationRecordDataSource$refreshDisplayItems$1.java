package com.larus.chat.gallery.impl.preview.datasource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.datasource.PreviewCreationRecordDataSource", f = "PreviewCreationRecordDataSource.kt", i = {}, l = {166}, m = "refreshDisplayItems", n = {}, s = {})
public final class PreviewCreationRecordDataSource$refreshDisplayItems$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreviewCreationRecordDataSource this$0;

    public PreviewCreationRecordDataSource$refreshDisplayItems$1(PreviewCreationRecordDataSource r1, Continuation<? super PreviewCreationRecordDataSource$refreshDisplayItems$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, this);
    }
}
