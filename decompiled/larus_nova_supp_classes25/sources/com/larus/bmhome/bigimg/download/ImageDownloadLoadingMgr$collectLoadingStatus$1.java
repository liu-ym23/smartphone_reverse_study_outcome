package com.larus.bmhome.bigimg.download;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bigimg.download.ImageDownloadLoadingMgr", f = "ImageDownloadLoadingMgr.kt", i = {}, l = {63}, m = "collectLoadingStatus", n = {}, s = {})
public final class ImageDownloadLoadingMgr$collectLoadingStatus$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageDownloadLoadingMgr this$0;

    public ImageDownloadLoadingMgr$collectLoadingStatus$1(ImageDownloadLoadingMgr r1, Continuation<? super ImageDownloadLoadingMgr$collectLoadingStatus$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
