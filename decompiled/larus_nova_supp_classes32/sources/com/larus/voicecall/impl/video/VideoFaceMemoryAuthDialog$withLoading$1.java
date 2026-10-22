package com.larus.voicecall.impl.video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.video.VideoFaceMemoryAuthDialog", f = "VideoFaceMemoryAuthDialog.kt", i = {}, l = {108}, m = "withLoading", n = {}, s = {})
public final class VideoFaceMemoryAuthDialog$withLoading$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VideoFaceMemoryAuthDialog this$0;

    public VideoFaceMemoryAuthDialog$withLoading$1(VideoFaceMemoryAuthDialog r1, Continuation<? super VideoFaceMemoryAuthDialog$withLoading$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        VideoFaceMemoryAuthDialog r3 = this.this$0;
        int r0 = VideoFaceMemoryAuthDialog.g;
        return r3.T90(null, null, this);
    }
}
