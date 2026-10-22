package com.larus.bmhome.music.protocol;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.protocol.MusicPullingApi", f = "MusicPullingApi.kt", i = {0, 0, 0}, l = {34}, m = "pullMusicStateTillCanPlay", n = {"bindMessage", "taskId", "retryCount"}, s = {"L$0", "L$1", "I$0"})
public final class MusicPullingApi$pullMusicStateTillCanPlay$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MusicPullingApi this$0;

    public MusicPullingApi$pullMusicStateTillCanPlay$1(MusicPullingApi r1, Continuation<? super MusicPullingApi$pullMusicStateTillCanPlay$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, 0, this);
    }
}
