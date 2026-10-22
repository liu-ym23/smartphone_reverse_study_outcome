package com.larus.avlink.e.mock;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.e.mock.Mode2AutoPlaybackController", f = "Mode2AutoPlaybackController.kt", i = {0}, l = {DoraCallStateCode.RTOS_STOP_SI_BY_GESTURE, DoraCallStateCode.DOUBAO_START_REALTIME_CALL}, m = "playScenario", n = {"completed"}, s = {"L$0"})
final class Mode2AutoPlaybackController$playScenario$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ l this$0;

    public Mode2AutoPlaybackController$playScenario$1(l r1, Continuation<? super Mode2AutoPlaybackController$playScenario$1> r2) {
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        int r3 = l.a;
        throw null;
    }
}
