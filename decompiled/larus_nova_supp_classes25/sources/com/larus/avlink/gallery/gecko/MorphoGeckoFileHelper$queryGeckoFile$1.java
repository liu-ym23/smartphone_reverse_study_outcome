package com.larus.avlink.gallery.gecko;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.gecko.MorphoGeckoFileHelper", f = "MorphoGeckoFileHelper.kt", i = {0, 0, 0, 0}, l = {272}, m = "queryGeckoFile", n = {"source", "bundleOrUrl", "$this$queryGeckoFile_u24lambda_u241", "$completion$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class MorphoGeckoFileHelper$queryGeckoFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MorphoGeckoFileHelper this$0;

    public MorphoGeckoFileHelper$queryGeckoFile$1(MorphoGeckoFileHelper r1, Continuation<? super MorphoGeckoFileHelper$queryGeckoFile$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MorphoGeckoFileHelper r3 = this.this$0;
        MorphoGeckoFileHelper r0 = MorphoGeckoFileHelper.a;
        return r3.i(null, null, this);
    }
}
