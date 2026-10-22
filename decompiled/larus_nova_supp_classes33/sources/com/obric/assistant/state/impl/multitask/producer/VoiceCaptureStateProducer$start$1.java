package com.obric.assistant.state.impl.multitask.producer;

import aha.g0;
import aha.h0;
import aha.u;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import com.obric.assistant.state.multitask.ext.f;
import com.obric.assistant.state.multitask.ext.g;
import com.obric.cae.libs.useraware.ApWakeEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import jha.c;
import jha.j$a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.VoiceCaptureStateProducer$start$1", f = "VoiceCaptureStateProducer.kt", i = {0, 0, 0}, l = {109, ApWakeEvent.ACCELERATING_END}, m = "invokeSuspend", n = {"effectiveSessionId", "taskMetadata", "key"}, s = {"L$0", "L$1", "L$2"})
public final class VoiceCaptureStateProducer$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ VoiceCaptureScene $scene;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ Integer $sourceType;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ VoiceCaptureStateProducer this$0;

    public VoiceCaptureStateProducer$start$1(String r1, String r2, String r3, VoiceCaptureScene r4, Integer r5, VoiceCaptureStateProducer r6, Continuation<? super VoiceCaptureStateProducer$start$1> r7) {
        this.$sessionId = r1;
        this.$conversationId = r2;
        this.$botId = r3;
        this.$scene = r4;
        this.$sourceType = r5;
        this.this$0 = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new VoiceCaptureStateProducer$start$1(this.$sessionId, this.$conversationId, this.$botId, this.$scene, this.$sourceType, this.this$0, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L11;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r25);
    L70:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r3 = (String) this.L$2;
        u r8 = (u) this.L$1;
        String r9 = (String) this.L$0;
        ResultKt.throwOnFailure(r25);
        Object r5 = r25;
    L10:
        String r12 = r9;
        u r10 = r8;
        jha.m r6 = (jha.m) r5;
        if (r6 != null) goto L53;
    L71:
        FLogger.a.w("VoiceCaptureStateProducer", "start: task already active, sessionId=" + r12);
        return Unit.INSTANCE;
    L53:
        if (r6.b == false) goto L71;
        this.this$0.b.put(r3, new VoiceCaptureStateProducer.a(r12, r6.a, r10, this.$scene, this.$sourceType));
        VoiceCaptureStateProducer r7 = this.this$0;
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        VoiceCaptureStateProducer.c r11 = r7.c.remove(r3);
        if (r11 != null) goto L58;
        Unit r4 = Unit.INSTANCE;
    L67:
        if (r4 != r1) goto L70;
        return r1;
    L58:
        Job.DefaultImpls.cancel$default(r11.e, null, 1, null);
        String r13 = r11.d;
        if (r13 != null) goto L61;
    L63:
        FLogger.a.i("VoiceCaptureStateProducer", "flushPendingEnd: flushing buffered End for key=" + r3 + ", sessionId=" + r12);
        r4 = r7.i(r3, r11.a, r11.b, r11.c);
        if (r4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L67;
        r4 = Unit.INSTANCE;
        goto L67
    L61:
        if (Intrinsics.areEqual(r13, r12) == true) goto L63;
        FLogger.a.w("VoiceCaptureStateProducer", "flushPendingEnd: sessionId mismatch for key=" + r3 + ", expected=" + r12 + ", got=" + r11.d + ", discarding pending End");
        r4 = Unit.INSTANCE;
        goto L67
    L11:
        ResultKt.throwOnFailure(r25);
        String r14 = this.$sessionId;
        if (r14 != null) goto L14;
        r14 = StringsKt.take(UUID.randomUUID().toString(), 8);
    L14:
        r9 = r14;
        int r15 = m.a;
        String r16 = this.$conversationId;
        String r17 = this.$botId;
        if (this.$scene != VoiceCaptureScene.CONTINUOUS_TALK) goto L17;
        ObricInteractionType r18 = ObricInteractionType.AutoHalfDuplex;
    L18:
        r8 = m.d(r16, r17, r18, 8);
        FLogger.a.i("VoiceCaptureStateProducer", "start, conversationId=" + this.$conversationId + ", scene=" + this.$scene + ", sourceType=" + this.$sourceType + ", sessionId=" + r9);
        r3 = VoiceCaptureStateProducer.g(this.this$0, this.$conversationId, this.$scene);
        Set<Map.Entry<String, VoiceCaptureStateProducer.a>> r19 = this.this$0.b.entrySet();
        String r110 = this.$conversationId;
        ArrayList r111 = new ArrayList();
        Iterator r112 = r19.iterator();
    L19:
        boolean r113 = false;
        String r114 = "unknown_session";
        if (r112.hasNext() == false) goto L34;
        Object r115 = r112.next();
        Map.Entry r116 = (Map.Entry) r115;
        Intrinsics.checkNotNull(r116);
        String r20 = (String) r116.getKey();
        if (Intrinsics.areEqual(r20, r3) == true) goto L30;
        Iterator r26 = r112;
        if (r110 == null) goto L28;
        r114 = r110;
    L28:
        if (StringsKt.endsWith$default(r20, "#".concat(r114), false, 2, null) == false) goto L31;
        r113 = true;
    L31:
        if (r113 == false) goto L33;
        r111.add(r115);
    L33:
        r112 = r26;
        goto L19
    L30:
        r26 = r112;
        goto L31
    L34:
        VoiceCaptureStateProducer r21 = this.this$0;
        Iterator r117 = r111.iterator();
    L36:
        if (r117.hasNext() == false) goto L38;
        Map.Entry r118 = (Map.Entry) r117.next();
        Intrinsics.checkNotNull(r118);
        String r119 = (String) r118.getKey();
        VoiceCaptureStateProducer.a r120 = (VoiceCaptureStateProducer.a) r118.getValue();
        r21.b.remove(r119, r120);
        jha.l<h0> r121 = r120.b;
        String r22 = r120.c.b;
        VoiceCaptureScene r23 = r120.d;
        Integer r122 = r120.e;
        TaskFlowDslKt.c(r121, new h0.c(r22, r23, r122, VoiceCaptureStateProducer.h(r122), r120.c));
        goto L36
    L38:
        VoiceCaptureStateProducer.a r24 = this.this$0.b.get(r3);
        if (r24 != null) goto L41;
    L43:
        String r27 = this.$conversationId;
        VoiceCaptureScene r28 = this.$scene;
        Intrinsics.checkNotNullParameter(r28, "scene");
        Intrinsics.checkNotNullParameter(r9, "sessionId");
        g0 r29 = g0.a;
        int r123 = f.a;
        g r124 = new g();
        String[] r125 = new String[3];
        if (r27 == null) goto L47;
        r114 = r27;
    L47:
        r125[0] = r114;
        r125[1] = r28.name();
        r125[2] = r9;
        jha.g r30 = TaskFlowDslKt.b(r29, g.a(r124, r125));
        String r126 = this.$conversationId;
        VoiceCaptureScene r127 = this.$scene;
        Integer r128 = this.$sourceType;
        this.this$0.getClass();
        h0.d r31 = new h0.d(r126, r127, r128, VoiceCaptureStateProducer.h(r128), r8);
        VoiceCaptureStateProducer r32 = this.this$0;
        r32.getClass();
        c r33 = j$a.a(r32);
        this.L$0 = r9;
        this.L$1 = r8;
        this.L$2 = r3;
        this.label = 1;
        r5 = TaskFlowDslKt.e(r30, r31, r33, this);
        if (r5 != r1) goto L10;
        return r1;
    L41:
        if (Intrinsics.areEqual(r24.a, r9) == true) goto L43;
        FLogger.a.w("VoiceCaptureStateProducer", "start: ending previous session " + r24.a + " for key=" + r3);
        jha.l<h0> r34 = r24.b;
        String r129 = this.$conversationId;
        VoiceCaptureScene r130 = this.$scene;
        Integer r131 = this.$sourceType;
        this.this$0.getClass();
        TaskFlowDslKt.c(r34, new h0.c(r129, r130, r131, VoiceCaptureStateProducer.h(r131), r24.c));
        goto L43
    L17:
        r18 = ObricInteractionType.DefaultMode;
        goto L18
    }
}
