package com.larus.bmhome.music.save_video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.save_video.MusicVideoSaver", f = "MusicVideoSaver.kt", i = {}, l = {502}, m = "requestAudioUrl", n = {}, s = {})
public final class MusicVideoSaver$requestAudioUrl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MusicVideoSaver this$0;

    public MusicVideoSaver$requestAudioUrl$1(MusicVideoSaver r1, Continuation<? super MusicVideoSaver$requestAudioUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MusicVideoSaver r3 = this.this$0;
        MusicVideoSaver r0 = MusicVideoSaver.a;
        return r3.j(null, this);
    }
}
