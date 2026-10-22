package com.larus.chat.gallery.impl.preview.toolbar.action;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.MarkAction", f = "MarkAction.kt", i = {0}, l = {339}, m = "resolveDownloadWatermarkUrl", n = {"watermarkSourceUri"}, s = {"L$0"})
public final class MarkAction$resolveDownloadWatermarkUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MarkAction this$0;

    public MarkAction$resolveDownloadWatermarkUrl$1(MarkAction r1, Continuation<? super MarkAction$resolveDownloadWatermarkUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MarkAction r3 = this.this$0;
        int r0 = MarkAction.h;
        return r3.e(null, this);
    }
}
