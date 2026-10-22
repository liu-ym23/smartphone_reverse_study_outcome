package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.upload.SharedAlbumUploadCoordinator", f = "SharedAlbumUploadCoordinator.kt", i = {0}, l = {DoraCallStateCode.DOUBAO_STOP_SI_BY_TIMEOUT}, m = "submit", n = {"identifier"}, s = {"L$0"})
public final class SharedAlbumUploadCoordinator$submit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SharedAlbumUploadCoordinator this$0;

    public SharedAlbumUploadCoordinator$submit$1(SharedAlbumUploadCoordinator r1, Continuation<? super SharedAlbumUploadCoordinator$submit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, null, null, null, this);
    }
}
