package com.obric.assistant.state.impl.multitask.producer;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.AiNoteStateProducer$recordingListener$1$onRecordingStart$1", f = "AiNoteStateProducer.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
public final class AiNoteStateProducer$recordingListener$1$onRecordingStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $meetingId;
    int label;
    final /* synthetic */ AiNoteStateProducer this$0;

    public AiNoteStateProducer$recordingListener$1$onRecordingStart$1(AiNoteStateProducer r1, String r2, Continuation<? super AiNoteStateProducer$recordingListener$1$onRecordingStart$1> r3) {
        this.this$0 = r1;
        this.$meetingId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AiNoteStateProducer$recordingListener$1$onRecordingStart$1(this.this$0, this.$meetingId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        AiNoteStateProducer r5 = this.this$0;
        String r2 = this.$meetingId;
        this.label = 1;
        if (AiNoteStateProducer.b(r5, r2, this) != r0) goto L12;
        return r0;
    }
}
