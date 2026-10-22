package com.larus.bmhome.video.download;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.download.VideoDownloadLoadingMgr", f = "VideoDownloadLoadingMgr.kt", i = {}, l = {694}, m = "collectLoadingStatus", n = {}, s = {})
final class VideoDownloadLoadingMgr$collectLoadingStatus$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VideoDownloadLoadingMgr this$0;

    public VideoDownloadLoadingMgr$collectLoadingStatus$1(VideoDownloadLoadingMgr r1, Continuation<? super VideoDownloadLoadingMgr$collectLoadingStatus$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
