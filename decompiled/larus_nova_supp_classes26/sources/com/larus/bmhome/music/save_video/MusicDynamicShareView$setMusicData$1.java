package com.larus.bmhome.music.save_video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.save_video.MusicDynamicShareView", f = "MusicDynamicShareView.kt", i = {0, 0}, l = {66}, m = "setMusicData", n = {"musicContent", "$this$setMusicData_u24lambda_u242"}, s = {"L$0", "L$1"})
public final class MusicDynamicShareView$setMusicData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MusicDynamicShareView this$0;

    public MusicDynamicShareView$setMusicData$1(MusicDynamicShareView r1, Continuation<? super MusicDynamicShareView$setMusicData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.R5(null, this);
    }
}
