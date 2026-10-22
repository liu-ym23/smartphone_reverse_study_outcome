package com.obric.assistant.interaction.impl;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL;
import com.obric.aiagent.assistant.idl.bean.DMConstData;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.f;
import com.obric.assistant.network.api.IObricNetworkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.ObricChatUILifecycleMonitorImpl$stopComplexTaskOfConv$1", f = "ObricChatUILifecycleMonitorImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricChatUILifecycleMonitorImpl$stopComplexTaskOfConv$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $convId;
    private /* synthetic */ Object L$0;
    int label;

    public ObricChatUILifecycleMonitorImpl$stopComplexTaskOfConv$1(String r1, Continuation<? super ObricChatUILifecycleMonitorImpl$stopComplexTaskOfConv$1> r2) {
        this.$convId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ObricChatUILifecycleMonitorImpl$stopComplexTaskOfConv$1 r0 = new ObricChatUILifecycleMonitorImpl$stopComplexTaskOfConv$1(this.$convId, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L120;
        ResultKt.throwOnFailure(r13);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        String r15 = this.$convId;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L112
        IObricNetworkService r2 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);     // Catch: Throwable -> L112
        if (r2 == null) goto L9;
        r2.clearOmniTasks(MapsKt.mapOf(TuplesKt.to("stop_scene", "start_new_topic")), null);     // Catch: Throwable -> L112
    L9:
        IAgentDMStateManagerIDL r3 = f.a(Reflection.getOrCreateKotlinClass(IAgentDMStateManagerIDL.class));     // Catch: Throwable -> L112
        if (r3 != null) goto L13;
        FLogger.a.w("ObricChatUILifecycleMonitorImpl", "stopComplexTaskOfConv: agentDMStateManagerIDL is null");     // Catch: Throwable -> L112
        return Unit.INSTANCE;
    L13:
        DMStateInfo r4 = r3.getCurrentDMSteate();     // Catch: Throwable -> L112
        if (r4 == null) goto L39;
        List r5 = r4.getActiveTasks();     // Catch: Throwable -> L112
        if (r5 == null) goto L39;
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L112
        Iterator r7 = r5.iterator();     // Catch: Throwable -> L112
    L19:
        if (r7.hasNext() == false) goto L40;
        Object r8 = r7.next();     // Catch: Throwable -> L112
        DMTaskState r9 = (DMTaskState) r8;     // Catch: Throwable -> L112
        DMTaskInfo r10 = r9.getTaskInfo();     // Catch: Throwable -> L112
        if (r10 != null) goto L23;
    L25:
        boolean r11 = false;
    L26:
        if (r11 == true) goto L36;
        DMTaskInfo r12 = r9.getTaskInfo();     // Catch: Throwable -> L112
        if (r12 != null) goto L30;
    L32:
        boolean r16 = false;
    L33:
        if (r16 == true) goto L36;
        boolean r17 = false;
    L37:
        if (r17 == false) goto L19;
        r6.add(r8);     // Catch: Throwable -> L112
        goto L19
    L30:
        if (r12.getTaskType() != DMConstData.DMTaskType.OAUTO.ordinal()) goto L32;
        r16 = true;
    L36:
        r17 = true;
        goto L37
    L23:
        if (r10.getTaskType() != DMConstData.DMTaskType.COMPLEX.ordinal()) goto L25;
        r11 = true;
    L40:
        if (r6 != null) goto L42;
    L45:
        boolean r18 = true;
    L46:
        if (r18 == false) goto L49;
        FLogger.a.d("ObricChatUILifecycleMonitorImpl", "stopComplexTaskOfConv: no active task");     // Catch: Throwable -> L112
        return Unit.INSTANCE;
    L49:
        FLogger.a.d("ObricChatUILifecycleMonitorImpl", "stopComplexTaskOfConv: active task size " + r6.size());     // Catch: Throwable -> L112
        Iterator r19 = r6.iterator();     // Catch: Throwable -> L112
    L51:
        if (r19.hasNext() == false) goto L110;
        DMTaskState r20 = (DMTaskState) r19.next();     // Catch: Throwable -> L112
        FLogger r21 = FLogger.a;     // Catch: Throwable -> L112
        r21.d("ObricChatUILifecycleMonitorImpl", "stopComplexTaskOfConv: taskId = " + r20.getTaskId() + ", taskInfo = " + r20.getTaskInfo());     // Catch: Throwable -> L112
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L105
        DMTaskInfo r23 = r20.getTaskInfo();     // Catch: Throwable -> L105
        if (r23 == null) goto L58;
        IMMessage r24 = r23.getMessage();     // Catch: Throwable -> L105
        if (r24 == null) goto L58;
        String r25 = r24.getConversationId();     // Catch: Throwable -> L105
    L60:
        if (Intrinsics.areEqual(r25, r15) == false) goto L96;
        DMTaskInfo r26 = r20.getTaskInfo();     // Catch: Throwable -> L105
        if (r26 == null) goto L66;
        IMMessage r27 = r26.getMessage();     // Catch: Throwable -> L105
        if (r27 == null) goto L66;
        String r28 = r27.getMessageId();     // Catch: Throwable -> L105
    L67:
        if (r28 != null) goto L70;
        r28 = "";
    L70:
        if (r28.length() != 0) goto L72;
        boolean r110 = true;
    L73:
        if (r110 == false) goto L75;
        r21.w("ObricChatUILifecycleMonitorImpl", "stopComplexTaskOfConv: msg id is null");     // Catch: Throwable -> L105
    L95:
        Unit r29 = Unit.INSTANCE;     // Catch: Throwable -> L105
    L103:
        Object r30 = Result.constructor-impl(r29);     // Catch: Throwable -> L105
    L107:
        Throwable r31 = Result.exceptionOrNull-impl(r30);     // Catch: Throwable -> L112
        if (r31 == null) goto L51;
        FLogger.a.w("ObricChatUILifecycleMonitorImpl", "stopComplexTaskOfConv: inner failed " + r31.getMessage(), r31);     // Catch: Throwable -> L112
        goto L51
    L75:
        DMTaskInfo r111 = r20.getTaskInfo();     // Catch: Throwable -> L105
        if (r111 != null) goto L78;
    L80:
        boolean r112 = false;
    L81:
        if (r112 == false) goto L85;
        r21.w("ObricChatUILifecycleMonitorImpl", "stopComplexTaskOfConv: notifyStopComplexTaskByHttp " + r28);     // Catch: Throwable -> L105
        IObricNetworkService r32 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);     // Catch: Throwable -> L105
        if (r32 == null) goto L95;
        r32.q(CastLongProtector.parseLong(r28), "start_new_topic");     // Catch: Throwable -> L105
        goto L95
    L85:
        DMTaskInfo r33 = r20.getTaskInfo();     // Catch: Throwable -> L105
        if (r33 != null) goto L88;
    L90:
        boolean r34 = false;
    L91:
        if (r34 == false) goto L95;
        r21.w("ObricChatUILifecycleMonitorImpl", "stopComplexTaskOfConv: notifyStopOAutoTaskByHttp " + r28);     // Catch: Throwable -> L105
        IAgentAppIntentIDL r35 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));     // Catch: Throwable -> L105
        if (r35 == null) goto L95;
        r35.notifyStopAutoAction(r28, "clear context");     // Catch: Throwable -> L105
        goto L95
    L88:
        if (r33.getTaskType() != DMConstData.DMTaskType.OAUTO.ordinal()) goto L90;
        r34 = true;
        goto L91
    L78:
        if (r111.getTaskType() != DMConstData.DMTaskType.COMPLEX.ordinal()) goto L80;
        r112 = true;
        goto L81
    L72:
        r110 = false;
    L66:
        r28 = null;
        goto L67
    L96:
        StringBuilder r36 = new StringBuilder();     // Catch: Throwable -> L105
        r36.append("stopComplexTaskOfConv: conversationId not match ");     // Catch: Throwable -> L105
        DMTaskInfo r37 = r20.getTaskInfo();     // Catch: Throwable -> L105
        if (r37 == null) goto L101;
        IMMessage r38 = r37.getMessage();     // Catch: Throwable -> L105
        if (r38 == null) goto L101;
        String r39 = r38.getConversationId();     // Catch: Throwable -> L105
    L102:
        r36.append(r39);     // Catch: Throwable -> L105
        r21.d("ObricChatUILifecycleMonitorImpl", r36.toString());     // Catch: Throwable -> L105
        r29 = Unit.INSTANCE;     // Catch: Throwable -> L105
    L101:
        r39 = null;
    L58:
        r25 = null;
        goto L60
    L105:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L112
        r30 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L112
        goto L107
    L110:
        Object r113 = Result.constructor-impl(r6);     // Catch: Throwable -> L112
    L114:
        Throwable r114 = Result.exceptionOrNull-impl(r113);
        if (r114 == null) goto L118;
        FLogger.a.w("ObricChatUILifecycleMonitorImpl", "stopComplexTaskOfConv: failed " + r114.getMessage(), r114);
    L118:
        return Unit.INSTANCE;
    L42:
        if (r6.isEmpty() == true) goto L45;
        r18 = false;
    L39:
        r6 = null;
    L112:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r113 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L114
    L120:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
