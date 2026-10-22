package com.larus.chat.gallery.impl.preview.datasource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.datasource.PreviewMessageDataSource", f = "PreviewMessageDataSource.kt", i = {}, l = {400}, m = "resolveUserSendDesc", n = {}, s = {})
public final class PreviewMessageDataSource$resolveUserSendDesc$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreviewMessageDataSource this$0;

    public PreviewMessageDataSource$resolveUserSendDesc$1(PreviewMessageDataSource r1, Continuation<? super PreviewMessageDataSource$resolveUserSendDesc$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        PreviewMessageDataSource r3 = this.this$0;
        int r0 = PreviewMessageDataSource.p;
        return r3.t(null, this);
    }
}
