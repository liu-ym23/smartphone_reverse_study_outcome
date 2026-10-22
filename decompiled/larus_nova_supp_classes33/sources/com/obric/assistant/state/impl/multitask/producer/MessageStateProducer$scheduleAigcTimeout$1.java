package com.obric.assistant.state.impl.multitask.producer;

import aha.g;
import com.larus.im.bean.message.Message;
import com.obric.assistant.state.impl.v2.utils.CoroutineExtKt;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.MessageStateProducer$scheduleAigcTimeout$1", f = "MessageStateProducer.kt", i = {0}, l = {640}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class MessageStateProducer$scheduleAigcTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MessageStateProducer$a $active;
    final /* synthetic */ String $id;
    final /* synthetic */ Message $msg;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MessageStateProducer this$0;

    public MessageStateProducer$scheduleAigcTimeout$1(MessageStateProducer r1, String r2, MessageStateProducer$a r3, Message r4, Continuation<? super MessageStateProducer$scheduleAigcTimeout$1> r5) {
        this.this$0 = r1;
        this.$id = r2;
        this.$active = r3;
        this.$msg = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MessageStateProducer$scheduleAigcTimeout$1 r6 = new MessageStateProducer$scheduleAigcTimeout$1(this.this$0, this.$id, this.$active, this.$msg, r9);
        r6.L$0 = r8;
        return r6;
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
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r6);
    L13:
        if (CoroutineScopeKt.isActive(r2) == false) goto L20;
        if (this.this$0.d.get(this.$id) != this.$active) goto L20;
        MessageStateProducer r7 = this.this$0;
        String r3 = this.$id;
        r7.e.remove(r3);
        r7.f.remove(r3);
        r7.g.remove(r3);
        r7.h.remove(r3);
        r7.j.remove(r3);
        r7.i.remove(r3);
        r7.k.remove(r3);
        r7.l.remove(r3);
        this.this$0.d.remove(this.$id, this.$active);
        MessageStateProducer$a r8 = this.$active;
        jha.l<g> r4 = r8.a;
        String r9 = r8.getType();
        Message r5 = this.$msg;
        MessageStateProducer$a r10 = this.$active;
        TaskFlowDslKt.c(r4, new g.b(r9, r5, r10.c, r10.d));
        this.this$0.m.remove(this.$id);
        return Unit.INSTANCE;
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        this.L$0 = r11;
        this.label = 1;
        if (CoroutineExtKt.a(3600000, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r11;
        goto L13
    }
}
