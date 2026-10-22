package com.larus.bmhome.music.save_video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.save_video.MusicShareView", f = "MusicShareView.kt", i = {0, 0, 1, 1, 2, 2, 3, 3}, l = {66, 69, 117, 125}, m = "setMusicData", n = {"musicContent", "$this$setMusicData_u24lambda_u244", "musicContent", "$this$setMusicData_u24lambda_u244", "$this$setMusicData_u24lambda_u244", "textViewHeight", "$this$setMusicData_u24lambda_u244", "textViewHeight"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
public final class MusicShareView$setMusicData$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MusicShareView this$0;

    public MusicShareView$setMusicData$1(MusicShareView r1, Continuation<? super MusicShareView$setMusicData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.R5(null, this);
    }
}
