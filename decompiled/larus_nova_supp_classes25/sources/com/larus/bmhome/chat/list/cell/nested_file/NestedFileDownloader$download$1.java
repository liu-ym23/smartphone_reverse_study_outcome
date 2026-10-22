package com.larus.bmhome.chat.list.cell.nested_file;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.nested_file.NestedFileDownloader", f = "NestedFileDownloader.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 5, 5, 7, 7}, l = {93, MessageCellStateTransformerType.DOWNLOAD_APP_ENTITY, 118, 125, 131, 138, 152, 159, 173}, m = "download", n = {"context", "fileInfo", "targetFileName", "tosKey", "startTime", "context", "fileInfo", "targetFileName", "tosKey", "urlResult", "startTime", "context", "fileInfo", "targetFileName", "tosKey", "startTime", "context", "fileInfo", "targetFileName", "tosKey", "startTime", "tosKey", "startTime", "tosKey", "startTime"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "J$0", "L$0", "J$0"})
public final class NestedFileDownloader$download$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NestedFileDownloader this$0;

    public NestedFileDownloader$download$1(NestedFileDownloader r1, Continuation<? super NestedFileDownloader$download$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, null, null, this);
    }
}
