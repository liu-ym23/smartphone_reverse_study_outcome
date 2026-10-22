package com.larus.bmhome.video.download;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.download.VideoDownloadLoadingMgr", f = "VideoDownloadLoadingMgr.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3}, l = {365, 376, 389, 406}, m = "saveVideo", n = {"context", "downloadTaskKey", "videoContent", "resultPath", "metaData", "downloadUrl", "isAIGC", "mdlCacheHit", "context", "downloadTaskKey", "videoContent", "metaData", "isAIGC", "mdlCacheHit", "context", "downloadTaskKey", "videoContent", "metaData", "isAIGC", "mdlCacheHit", "finalPath", "mdlCacheHit"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "L$0", "I$0"})
final class VideoDownloadLoadingMgr$saveVideo$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VideoDownloadLoadingMgr this$0;

    public VideoDownloadLoadingMgr$saveVideo$1(VideoDownloadLoadingMgr r1, Continuation<? super VideoDownloadLoadingMgr$saveVideo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        return VideoDownloadLoadingMgr.e(this.this$0, null, null, null, null, null, null, null, false, this);
    }
}
