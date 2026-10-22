package com.larus.bmhome.music.save_video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.save_video.MusicVideoSaver", f = "MusicVideoSaver.kt", i = {0, 0, 0, 0}, l = {607}, m = "enqueueFrameBitmap", n = {"bitmaps", "lyricsText", "$this$enqueueFrameBitmap_u24lambda_u2413", "bgColor"}, s = {"L$0", "L$1", "L$3", "I$0"})
public final class MusicVideoSaver$enqueueFrameBitmap$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MusicVideoSaver this$0;

    public MusicVideoSaver$enqueueFrameBitmap$1(MusicVideoSaver r1, Continuation<? super MusicVideoSaver$enqueueFrameBitmap$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        MusicVideoSaver r0 = this.this$0;
        MusicVideoSaver r8 = MusicVideoSaver.a;
        return r0.e(null, null, null, 0, this);
    }
}
