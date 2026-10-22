package com.larus.chat.gallery.impl.preview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.OriginalImagePreloader", f = "OriginalImagePreloader.kt", i = {0, 0, 1, 1, 1}, l = {60, 80}, m = "awaitPrefetchReady", n = {"rawImagePath", "bizTag", "rawImagePath", "bizTag", "dataSource"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
final class OriginalImagePreloader$awaitPrefetchReady$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OriginalImagePreloader this$0;

    public OriginalImagePreloader$awaitPrefetchReady$1(OriginalImagePreloader r1, Continuation<? super OriginalImagePreloader$awaitPrefetchReady$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return OriginalImagePreloader.a(this.this$0, null, null, this);
    }
}
