package com.larus.avlink.gallery.executor;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaDownloadExecutor", f = "MediaDownloadExecutor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {380, 392, 412, 878}, m = "saveMediaFile", n = {"context", "mediaInfo", "suffix", "syncMode", "downloadUrl", "downloadMediaType", "mediaType", "prefix", "hash", "currentSn", "lastModified", "id", "startTime", "mediaSize", "mediaId", "context", "mediaInfo", "suffix", "syncMode", "downloadUrl", "downloadMediaType", "mediaType", "prefix", "hash", "currentSn", "lastModified", "id", "downloadDir", "startTime", "mediaSize", "mediaId", "context", "mediaInfo", "suffix", "syncMode", "downloadUrl", "mediaType", "prefix", "hash", "currentSn", "lastModified", "id", "downloadDir", "metadata", "startTime", "mediaSize", "mediaId", "context", "mediaInfo", "suffix", "downloadUrl", "mediaType", "prefix", "hash", "currentSn", "lastModified", "id", "downloadDir", "metadata", "wifi", "customHeaders", "sessionId", "startTime", "mediaSize", "mediaId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "J$0", "J$1", "J$2"})
public final class MediaDownloadExecutor$saveMediaFile$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaDownloadExecutor this$0;

    public MediaDownloadExecutor$saveMediaFile$1(MediaDownloadExecutor r1, Continuation<? super MediaDownloadExecutor$saveMediaFile$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        MediaDownloadExecutor r0 = this.this$0;
        int r8 = MediaDownloadExecutor.n;
        return r0.m(null, null, null, null, this);
    }
}
