package com.larus.avlink.gallery.inject;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.inject.DatasetInjectionRunner", f = "DatasetInjectionRunner.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 2, 2}, l = {191, 209, 215}, m = "enqueuePack", n = {"file", "uniqId", "storedMediaType", "$this$enqueuePack_u24lambda_u242", "mediaId", "createTime", "isLivePhoto", "file", "file", "uniqId"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "J$1", "Z$0", "L$0", "L$0", "L$1"})
final class DatasetInjectionRunner$enqueuePack$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DatasetInjectionRunner this$0;

    public DatasetInjectionRunner$enqueuePack$1(DatasetInjectionRunner r1, Continuation<? super DatasetInjectionRunner$enqueuePack$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DatasetInjectionRunner.b(this.this$0, null, this);
    }
}
