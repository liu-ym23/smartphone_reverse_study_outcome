package com.larus.bmhome.video.download;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.download.VideoDownloadLoadingMgr", f = "VideoDownloadLoadingMgr.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {437, 447, 463}, m = "saveVideoByMdlCache", n = {"downloadTaskKey", "cacheKey", "downloadUrl", "resultPath", "suffix", "downloadTaskKey", "cacheKey", "resultPath", "suffix"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"})
public final class VideoDownloadLoadingMgr$saveVideoByMdlCache$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VideoDownloadLoadingMgr this$0;

    public VideoDownloadLoadingMgr$saveVideoByMdlCache$1(VideoDownloadLoadingMgr r1, Continuation<? super VideoDownloadLoadingMgr$saveVideoByMdlCache$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, null, null, null, null, this);
    }
}
