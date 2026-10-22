package com.obric.assistant.state.impl.multitask.producer;

import aha.j;
import aha.u;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import com.obric.assistant.state.impl.v2.utils.CoroutineExtKt;
import com.obric.assistant.state.multitask.TaskFlowManager;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import java.util.Map;
import jha.p;
import jha.q;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.MessageStateProducer$scheduleActiveTimeout$job$1", f = "MessageStateProducer.kt", i = {0}, l = {851}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class MessageStateProducer$scheduleActiveTimeout$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Message $msg;
    final /* synthetic */ String $taskRootMessageId;
    final /* synthetic */ h $trackingKey;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MessageStateProducer this$0;

    public MessageStateProducer$scheduleActiveTimeout$job$1(MessageStateProducer r1, h r2, String r3, String r4, Message r5, Continuation<? super MessageStateProducer$scheduleActiveTimeout$job$1> r6) {
        this.this$0 = r1;
        this.$trackingKey = r2;
        this.$taskRootMessageId = r3;
        this.$conversationId = r4;
        this.$msg = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        MessageStateProducer$scheduleActiveTimeout$job$1 r7 = new MessageStateProducer$scheduleActiveTimeout$job$1(this.this$0, this.$trackingKey, this.$taskRootMessageId, this.$conversationId, this.$msg, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);
    L12:
        jha.l r12 = (jha.l) this.this$0.c.get(this.$trackingKey);
        if (CoroutineScopeKt.isActive(r2) == false) goto L33;
        if (r12 == null) goto L33;
        FLogger.a.i("MessageStateProducer", "scheduleActiveTimeout: task " + this.$taskRootMessageId + " timed out, ending");
        if (this.this$0.c.get(this.$trackingKey) != r12) goto L18;
        this.this$0.c.remove(this.$trackingKey);
        String r4 = this.$conversationId;
        String r5 = this.$msg.getMessageId();
        int r6 = this.$msg.getMessageStatusLocal();
        Message r7 = this.$msg;
        Map r8 = MapsKt.mapOf(TuplesKt.to("timeout", Boxing.boxBoolean(true)));
        TaskFlowManager r3 = TaskFlowManager.a;
        q r9 = TaskFlowManager.d(r12.a);
        if (r9 == null) goto L28;
        p r10 = r9.a();
        if (r10 == null) goto L28;
        aha.q r13 = (aha.q) r10.b;
        if (r13 == null) goto L28;
        u r14 = r13.b();
        if (r14 == null) goto L28;
    L29:
        TaskFlowDslKt.c(r12, new aha.q.b(r4, r5, r6, r7, r8, r14));
        this.this$0.r(this.$conversationId, this.$taskRootMessageId);
        this.this$0.r.remove(this.$trackingKey);
        this.this$0.s.remove(this.$trackingKey);
        this.this$0.o.remove(this.$trackingKey);
        jha.l r15 = (jha.l) this.this$0.v.remove(this.$trackingKey);
        if (r15 == null) goto L33;
        String r16 = this.$conversationId;
        String r17 = this.$taskRootMessageId;
        int r18 = this.$msg.getMessageStatusLocal();
        Message r19 = this.$msg;
        TaskFlowDslKt.c(r15, new j.a(r16, r17, r18, r19, jha.h.c.a, m.c(r19, false)));
    L28:
        int r20 = m.a;
        r14 = m.a(this.$msg, ObricInteractionType.TextMode, false);
        goto L29
    L18:
        return Unit.INSTANCE;
    L33:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        this.L$0 = r110;
        this.label = 1;
        if (CoroutineExtKt.a(15000, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r110;
        goto L12
    }
}
