package com.larus.avlink.activeSummary;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.avlink.activeSummary.ChunkParser", f = "ChunkParser.kt", i = {0, 0, 0, 0}, l = {38, 45}, m = "parseStream", n = {"readLine", "close", "onDataParsed", "chunk"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class ChunkParser$parseStream$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChunkParser this$0;

    public ChunkParser$parseStream$1(ChunkParser r1, Continuation<? super ChunkParser$parseStream$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        return this.this$0.a(null, null, null, this);
    }
}
