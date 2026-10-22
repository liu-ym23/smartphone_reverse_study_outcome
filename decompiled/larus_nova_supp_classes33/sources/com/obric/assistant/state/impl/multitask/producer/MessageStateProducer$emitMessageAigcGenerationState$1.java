package com.obric.assistant.state.impl.multitask.producer;

import com.obric.assistant.interaction.impl.performance.WindowAnimationBoostCoordinator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.MessageStateProducer", f = "MessageStateProducer.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7}, l = {391, 393, 396, 398, WindowAnimationBoostCoordinator.DEFAULT_WINDOW_ANIMATION_DURATION_MS, 401, 402, 404}, m = "emitMessageAigcGenerationState", n = {"msg", "trackingKey", "musicRequestKey", "isAigc", "msg", "trackingKey", "musicRequestKey", "isAigc", "msg", "trackingKey", "musicRequestKey", "isAigc", "msg", "trackingKey", "musicRequestKey", "isAigc", "msg", "trackingKey", "musicRequestKey", "isAigc", "msg", "trackingKey", "musicRequestKey", "isAigc", "msg", "trackingKey", "musicRequestKey", "isAigc", "msg", "trackingKey", "musicRequestKey", "isAigc"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0"})
public final class MessageStateProducer$emitMessageAigcGenerationState$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageStateProducer this$0;

    public MessageStateProducer$emitMessageAigcGenerationState$1(MessageStateProducer r1, Continuation<? super MessageStateProducer$emitMessageAigcGenerationState$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MessageStateProducer r3 = this.this$0;
        Set r0 = MessageStateProducer.w;
        return r3.l(null, null, null, this);
    }
}
