package com.larus.avlink.gallery.executor;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaDownloadExecutor", f = "MediaDownloadExecutor.kt", i = {0}, l = {DoraCallStateCode.DOUBAO_STOP_CALL_BY_SPRING_DEGRADE}, m = "recoverDownloadedArchive", n = {"metadata"}, s = {"L$0"})
public final class MediaDownloadExecutor$recoverDownloadedArchive$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaDownloadExecutor this$0;

    public MediaDownloadExecutor$recoverDownloadedArchive$1(MediaDownloadExecutor r1, Continuation<? super MediaDownloadExecutor$recoverDownloadedArchive$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MediaDownloadExecutor r3 = this.this$0;
        int r0 = MediaDownloadExecutor.n;
        return r3.k(null, this);
    }
}
