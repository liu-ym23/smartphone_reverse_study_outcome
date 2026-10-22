package com.obric.assistant.state.impl.multitask.producer;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.ObricAigcGenerationStateProducer", f = "ObricAigcGenerationStateProducer.kt", i = {0, 0, 0, 0, 0}, l = {90}, m = "handleTaskList", n = {DBDefinition.TASK_ID, "taskInfo", "taskMetadata", "state", "conversationId"}, s = {"L$1", "L$2", "L$3", "L$4", "L$5"})
final class ObricAigcGenerationStateProducer$handleTaskList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricAigcGenerationStateProducer this$0;

    public ObricAigcGenerationStateProducer$handleTaskList$1(ObricAigcGenerationStateProducer r1, Continuation<? super ObricAigcGenerationStateProducer$handleTaskList$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= IntCompanionObject.MIN_VALUE;
        return ObricAigcGenerationStateProducer.a(this.this$0, null, this);
    }
}
