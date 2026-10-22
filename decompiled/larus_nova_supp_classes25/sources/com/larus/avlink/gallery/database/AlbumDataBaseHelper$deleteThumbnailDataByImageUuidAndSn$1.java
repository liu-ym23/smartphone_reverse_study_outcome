package com.larus.avlink.gallery.database;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.database.AlbumDataBaseHelper", f = "AlbumDataBaseHelper.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {343}, m = "deleteThumbnailDataByImageUuidAndSn", n = {"sn", "this_$iv", "operation$iv", "store$iv", "imageUuid", "count$iv", "startTime$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "I$0", "J$1"})
public final class AlbumDataBaseHelper$deleteThumbnailDataByImageUuidAndSn$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlbumDataBaseHelper this$0;

    public AlbumDataBaseHelper$deleteThumbnailDataByImageUuidAndSn$1(AlbumDataBaseHelper r1, Continuation<? super AlbumDataBaseHelper$deleteThumbnailDataByImageUuidAndSn$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(0, null, this);
    }
}
