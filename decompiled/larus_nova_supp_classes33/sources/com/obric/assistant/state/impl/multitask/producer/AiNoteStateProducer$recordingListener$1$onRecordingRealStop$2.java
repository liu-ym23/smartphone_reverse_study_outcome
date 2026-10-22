package com.obric.assistant.state.impl.multitask.producer;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.AiNoteStateProducer$recordingListener$1$onRecordingRealStop$2", f = "AiNoteStateProducer.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
public final class AiNoteStateProducer$recordingListener$1$onRecordingRealStop$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $msgId;
    int label;
    final /* synthetic */ AiNoteStateProducer this$0;

    public AiNoteStateProducer$recordingListener$1$onRecordingRealStop$2(AiNoteStateProducer r1, String r2, Continuation<? super AiNoteStateProducer$recordingListener$1$onRecordingRealStop$2> r3) {
        this.this$0 = r1;
        this.$msgId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AiNoteStateProducer$recordingListener$1$onRecordingRealStop$2(this.this$0, this.$msgId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        AiNoteStateProducer r7 = this.this$0;
        Pair[] r2 = new Pair[2];
        r2[0] = TuplesKt.to(WindowEvent.Params.REASON, "real_stop");
        String r3 = this.$msgId;
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        r2[1] = TuplesKt.to("msg_id", r3);
        Map r4 = MapsKt.mapOf(r2);
        this.label = 1;
        if (AiNoteStateProducer.a(r7, r4) != r0) goto L15;
        return r0;
    }
}
