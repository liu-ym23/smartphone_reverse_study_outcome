package com.larus.avlink.gallery.executor;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaDownloadExecutor", f = "MediaDownloadExecutor.kt", i = {}, l = {340}, m = "realSaveMedia", n = {}, s = {})
final class MediaDownloadExecutor$realSaveMedia$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaDownloadExecutor this$0;

    public MediaDownloadExecutor$realSaveMedia$1(MediaDownloadExecutor r1, Continuation<? super MediaDownloadExecutor$realSaveMedia$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MediaDownloadExecutor.d(this.this$0, null, null, null, this);
    }
}
