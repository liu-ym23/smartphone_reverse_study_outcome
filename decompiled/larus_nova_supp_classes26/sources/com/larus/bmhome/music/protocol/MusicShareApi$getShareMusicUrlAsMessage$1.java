package com.larus.bmhome.music.protocol;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.protocol.MusicShareApi", f = "MusicShareApi.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {379, 381}, m = "getShareMusicUrlAsMessage", n = {"shareButton", "messageId", "musicCreationContent", "loadingDialog", "context", "shareButton", "musicCreationContent", "loadingDialog", "context"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"})
public final class MusicShareApi$getShareMusicUrlAsMessage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MusicShareApi this$0;

    public MusicShareApi$getShareMusicUrlAsMessage$1(MusicShareApi r1, Continuation<? super MusicShareApi$getShareMusicUrlAsMessage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        MusicShareApi r0 = this.this$0;
        MusicShareApi r9 = MusicShareApi.a;
        return r0.c(null, null, null, null, false, this);
    }
}
