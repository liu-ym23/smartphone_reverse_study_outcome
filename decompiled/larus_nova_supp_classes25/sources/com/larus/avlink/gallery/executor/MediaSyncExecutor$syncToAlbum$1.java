package com.larus.avlink.gallery.executor;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaSyncExecutor", f = "MediaSyncExecutor.kt", i = {0, 0, 3, 4, 4, 4, 5, 6, 6, 7}, l = {MessageCellStateTransformerType.MSG_SEND_ENTITY, 116, 131, 146, 157, DoraCallStateCode.RTC_STOP_FROM_P2P_FAILED, 206, 220, 235}, m = "syncToAlbum", n = {"metadata", "uniqId", "uniqId", "uniqId", "displayPath", "systemGalleryId", "uniqId", "uniqId", "systemGalleryId", "uniqId"}, s = {"L$0", "L$1", "L$0", "L$0", "L$1", "J$0", "L$0", "L$0", "J$0", "L$0"})
public final class MediaSyncExecutor$syncToAlbum$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaSyncExecutor this$0;

    public MediaSyncExecutor$syncToAlbum$1(MediaSyncExecutor r1, Continuation<? super MediaSyncExecutor$syncToAlbum$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, this);
    }
}
