package com.larus.audioplayer.impl.stream;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audioplayer.impl.stream.StreamChunkParser", f = "StreamChunkParser.kt", i = {0, 0, 0, 0, 0}, l = {57, 67}, m = "parseStream", n = {"buffer", "onDataParsed", "needStop", "chunk", "startTime"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0"})
public final class StreamChunkParser$parseStream$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StreamChunkParser this$0;

    public StreamChunkParser$parseStream$1(StreamChunkParser r1, Continuation<? super StreamChunkParser$parseStream$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        return this.this$0.a(null, null, null, this);
    }
}
