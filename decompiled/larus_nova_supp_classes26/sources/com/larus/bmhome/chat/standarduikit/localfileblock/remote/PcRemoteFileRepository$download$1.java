package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFileRepository", f = "PcRemoteFileRepository.kt", i = {}, l = {189}, m = "download", n = {}, s = {})
public final class PcRemoteFileRepository$download$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PcRemoteFileRepository this$0;

    public PcRemoteFileRepository$download$1(PcRemoteFileRepository r1, Continuation<? super PcRemoteFileRepository$download$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        PcRemoteFileRepository r3 = this.this$0;
        PcRemoteFileRepository r0 = PcRemoteFileRepository.a;
        return r3.h(null, null, this);
    }
}
