package com.larus.chat.gallery.impl.preview.datasource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.datasource.PreviewMessageDataSource", f = "PreviewMessageDataSource.kt", i = {0, 0, 0, 1, 1, 1}, l = {212, 214}, m = "refreshOriginalDataList", n = {"originalDataList", "scene", "messages", "originalDataList", "scene", "messages"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class PreviewMessageDataSource$refreshOriginalDataList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreviewMessageDataSource this$0;

    public PreviewMessageDataSource$refreshOriginalDataList$1(PreviewMessageDataSource r1, Continuation<? super PreviewMessageDataSource$refreshOriginalDataList$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        PreviewMessageDataSource r3 = this.this$0;
        int r0 = PreviewMessageDataSource.p;
        return r3.r(null, null, this);
    }
}
