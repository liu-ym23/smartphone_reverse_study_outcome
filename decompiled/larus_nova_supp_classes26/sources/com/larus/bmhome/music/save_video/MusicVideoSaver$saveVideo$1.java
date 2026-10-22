package com.larus.bmhome.music.save_video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.save_video.MusicVideoSaver", f = "MusicVideoSaver.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7}, l = {336, 348, 353, 357, 370, 375, 400, 418}, m = "saveVideo", n = {"context", "parent", "downloadTaskKey", "resultPath", "musicContent", "lyricsSeekContent", "context", "downloadTaskKey", "resultPath", "musicContent", "context", "downloadTaskKey", "resultPath", "musicContent", "framesInfo", "bitmaps", "context", "resultPath", "musicContent", "framesInfo", "bitmaps", "context", "resultPath", "musicContent", "context", "resultPath", "context", "resultPath", "resultPath"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$0"})
final class MusicVideoSaver$saveVideo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MusicVideoSaver this$0;

    public MusicVideoSaver$saveVideo$1(MusicVideoSaver r1, Continuation<? super MusicVideoSaver$saveVideo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        return MusicVideoSaver.b(this.this$0, null, null, null, null, null, null, this);
    }
}
