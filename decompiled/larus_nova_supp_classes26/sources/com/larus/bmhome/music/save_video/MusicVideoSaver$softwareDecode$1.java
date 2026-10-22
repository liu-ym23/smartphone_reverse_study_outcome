package com.larus.bmhome.music.save_video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.save_video.MusicVideoSaver", f = "MusicVideoSaver.kt", i = {0, 0, 0}, l = {477, 484}, m = "softwareDecode", n = {"audioPath", "resultPath", "tempPath"}, s = {"L$0", "L$1", "L$2"})
public final class MusicVideoSaver$softwareDecode$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MusicVideoSaver this$0;

    public MusicVideoSaver$softwareDecode$1(MusicVideoSaver r1, Continuation<? super MusicVideoSaver$softwareDecode$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        MusicVideoSaver r0 = this.this$0;
        MusicVideoSaver r9 = MusicVideoSaver.a;
        return r0.m(null, null, null, null, null, this);
    }
}
