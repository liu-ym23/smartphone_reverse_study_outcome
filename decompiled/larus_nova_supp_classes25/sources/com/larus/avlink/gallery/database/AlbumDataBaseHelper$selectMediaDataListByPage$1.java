package com.larus.avlink.gallery.database;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.database.AlbumDataBaseHelper", f = "AlbumDataBaseHelper.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {542}, m = "selectMediaDataListByPage", n = {"this_$iv", "operation$iv", "store$iv", "offset", "limit", "count$iv", "startTime$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "J$0"})
public final class AlbumDataBaseHelper$selectMediaDataListByPage$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlbumDataBaseHelper this$0;

    public AlbumDataBaseHelper$selectMediaDataListByPage$1(AlbumDataBaseHelper r1, Continuation<? super AlbumDataBaseHelper$selectMediaDataListByPage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.u(0, 0, this);
    }
}
