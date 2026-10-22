package com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter.PcLocalFileBlockHolder", f = "PcLocalFileBlockHolder.kt", i = {}, l = {154}, m = "hasCachedFile", n = {}, s = {})
final class PcLocalFileBlockHolder$hasCachedFile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PcLocalFileBlockHolder this$0;

    public PcLocalFileBlockHolder$hasCachedFile$1(PcLocalFileBlockHolder r1, Continuation<? super PcLocalFileBlockHolder$hasCachedFile$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return PcLocalFileBlockHolder.j(this.this$0, null, this);
    }
}
