package com.larus.avlink.gallery.executor;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaDownloadExecutor", f = "MediaDownloadExecutor.kt", i = {0, 0}, l = {624}, m = "completeArchiveDownload", n = {"id", "isRecovery"}, s = {"L$0", "Z$0"})
public final class MediaDownloadExecutor$completeArchiveDownload$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaDownloadExecutor this$0;

    public MediaDownloadExecutor$completeArchiveDownload$1(MediaDownloadExecutor r1, Continuation<? super MediaDownloadExecutor$completeArchiveDownload$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        MediaDownloadExecutor r0 = this.this$0;
        int r9 = MediaDownloadExecutor.n;
        return r0.f(null, null, null, null, false, this);
    }
}
