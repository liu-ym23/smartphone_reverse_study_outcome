package com.larus.bmhome.upload.audio;

import com.larus.bmhome.upload.audio.k;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.audio.AudioResourceUploader", f = "AudioResourceUploader.kt", i = {0, 1}, l = {109, 121}, m = "upload", n = {"onFail", "result"}, s = {"L$0", "L$0"})
final class AudioResourceUploader$upload$1<T extends k> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ g this$0;

    public AudioResourceUploader$upload$1(g r1, Continuation<? super AudioResourceUploader$upload$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return g.a(this.this$0, null, null, null, this);
    }
}
