package com.larus.bmhome.music.save_video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.save_video.MusicVideoSaver", f = "MusicVideoSaver.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {638, 641, 650, 663}, m = "getVideoFrames", n = {"parent", "lyricsSeekContent", "bitmaps", "utterances", "musicVideoFrameDurationStore", "shareView", "bgColor", "lastStartTimeMs", "parent", "lyricsSeekContent", "bitmaps", "utterances", "musicVideoFrameDurationStore", "shareView", "bgColor", "lastStartTimeMs", "parent", "lyricsSeekContent", "bitmaps", "utterances", "musicVideoFrameDurationStore", "shareView", "bgColor", "lastStartTimeMs", "index", "parent", "bitmaps", "musicVideoFrameDurationStore", "bitmap", "$this$getVideoFrames_u24lambda_u2416", "bgColor"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$5", "I$0"})
public final class MusicVideoSaver$getVideoFrames$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MusicVideoSaver this$0;

    public MusicVideoSaver$getVideoFrames$1(MusicVideoSaver r1, Continuation<? super MusicVideoSaver$getVideoFrames$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        MusicVideoSaver r0 = this.this$0;
        MusicVideoSaver r8 = MusicVideoSaver.a;
        return r0.f(null, null, null, null, this);
    }
}
