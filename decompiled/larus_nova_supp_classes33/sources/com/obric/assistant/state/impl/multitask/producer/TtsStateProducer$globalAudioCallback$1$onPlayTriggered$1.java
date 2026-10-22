package com.obric.assistant.state.impl.multitask.producer;

import aha.e0;
import aha.f0;
import com.obric.assistant.state.multitask.TaskFlowManager;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jha.c;
import jha.g;
import jha.j$a;
import jha.p;
import jha.q;
import kotlin.Metadata;
import kotlin.ResultKt;
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
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.TtsStateProducer$globalAudioCallback$1$onPlayTriggered$1", f = "TtsStateProducer.kt", i = {0, 0}, l = {85}, m = "invokeSuspend", n = {"taskFlowId", "preparingState"}, s = {"L$0", "L$1"})
public final class TtsStateProducer$globalAudioCallback$1$onPlayTriggered$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $bizExtra;
    final /* synthetic */ String $scene;
    final /* synthetic */ String $uniId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TtsStateProducer this$0;

    public TtsStateProducer$globalAudioCallback$1$onPlayTriggered$1(Map<String, String> r1, String r2, String r3, TtsStateProducer r4, Continuation<? super TtsStateProducer$globalAudioCallback$1$onPlayTriggered$1> r5) {
        this.$bizExtra = r1;
        this.$uniId = r2;
        this.$scene = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new TtsStateProducer$globalAudioCallback$1$onPlayTriggered$1(this.$bizExtra, this.$uniId, this.$scene, this.this$0, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        e0 r2 = (e0.c) this.L$1;
        g<e0> r3 = (g) this.L$0;
        ResultKt.throwOnFailure(r12);
    L38:
        jha.m r13 = (jha.m) r12;
        if (r13 == null) goto L41;
        ConcurrentHashMap r4 = this.this$0.b;
        String r5 = r3.a;
        jha.l<S> r6 = r13.a;
        if (r13.b == true) goto L53;
        TaskFlowManager r14 = TaskFlowManager.a;
        q r15 = TaskFlowManager.d(r3);
        if (r15 == null) goto L53;
        p r16 = r15.a();
        if (r16 == null) goto L53;
        e0 r17 = (e0) r16.b;
        if (r17 == null) goto L53;
        r2 = r17;
    L53:
        r4.put(r5, new TtsStateProducer$a(r6, r2));
        return Unit.INSTANCE;
    L41:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        Map<String, String> r18 = this.$bizExtra;
        if (r18 != null) goto L11;
        r18 = MapsKt.emptyMap();
    L11:
        Map<String, String> r7 = r18;
        String r19 = r7.get("message_id");
        boolean r8 = false;
        if (r19 != null) goto L14;
    L21:
        r19 = this.$uniId;
    L22:
        String r9 = r19;
        String r110 = r7.get("conversation_id");
        if (r110 != null) goto L25;
    L29:
        String r10 = null;
    L30:
        g<e0> r111 = f0.a(r10, r9, this.$scene);
        if (this.this$0.b.containsKey(r111.a) == true) goto L33;
        String r11 = this.$scene;
        int r20 = m.a;
        e0.c r21 = new e0.c(r11, r10, r9, r7, m.d(r10, r7.get("bot_id"), null, 12));
        TtsStateProducer r22 = this.this$0;
        r22.getClass();
        c r23 = j$a.a(r22);
        this.L$0 = r111;
        this.L$1 = r21;
        this.label = 1;
        Object r24 = TaskFlowDslKt.e(r111, r21, r23, this);
        if (r24 != r0) goto L37;
        return r0;
    L37:
        r2 = r21;
        r3 = r111;
        r12 = r24;
        goto L38
    L33:
        return Unit.INSTANCE;
    L25:
        if (r110.length() <= 0) goto L27;
        r8 = true;
    L27:
        if (r8 == false) goto L29;
        r10 = r110;
        goto L30
    L14:
        if (r19.length() <= 0) goto L16;
        boolean r25 = true;
    L17:
        if (r25 == true) goto L20;
        r19 = null;
    L20:
        if (r19 != null) goto L22;
    L16:
        r25 = false;
        goto L17
    }
}
