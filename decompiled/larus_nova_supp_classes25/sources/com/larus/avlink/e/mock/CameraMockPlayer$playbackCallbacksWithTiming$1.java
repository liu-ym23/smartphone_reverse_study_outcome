package com.larus.avlink.e.mock;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.e.mock.CameraMockPlayer", f = "CameraMockPlayer.kt", i = {0, 0, 1, 1, 1}, l = {384, 397}, m = "playbackCallbacksWithTiming", n = {"callbacks", "callback", "callbacks", "timing", "callback"}, s = {"L$0", "L$2", "L$0", "L$1", "L$3"})
final class CameraMockPlayer$playbackCallbacksWithTiming$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ f this$0;

    public CameraMockPlayer$playbackCallbacksWithTiming$1(f r1, Continuation<? super CameraMockPlayer$playbackCallbacksWithTiming$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return f.b(this.this$0, null, null, this);
    }
}
