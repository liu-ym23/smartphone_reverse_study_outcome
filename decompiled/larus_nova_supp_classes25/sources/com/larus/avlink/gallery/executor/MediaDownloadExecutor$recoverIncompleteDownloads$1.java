package com.larus.avlink.gallery.executor;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaDownloadExecutor", f = "MediaDownloadExecutor.kt", i = {0, 1, 1, 2, 2, 3, 3}, l = {DoraCallStateCode.DOUBAO_STOP_SI_BY_VUI, DoraCallStateCode.DOUBAO_STOP_RECORD_BY_IM, DoraCallStateCode.DORA_NEW_USER_GUIDE, 208}, m = "recoverIncompleteDownloads", n = {"recoveredMediaIds", "recoveredMediaIds", "metadata", "recoveredMediaIds", "metadata", "recoveredMediaIds", "metadata"}, s = {"L$0", "L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
public final class MediaDownloadExecutor$recoverIncompleteDownloads$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaDownloadExecutor this$0;

    public MediaDownloadExecutor$recoverIncompleteDownloads$1(MediaDownloadExecutor r1, Continuation<? super MediaDownloadExecutor$recoverIncompleteDownloads$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(this);
    }
}
