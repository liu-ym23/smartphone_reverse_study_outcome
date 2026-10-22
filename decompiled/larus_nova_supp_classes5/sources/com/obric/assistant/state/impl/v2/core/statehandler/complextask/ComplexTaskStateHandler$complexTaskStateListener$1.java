package com.obric.assistant.state.impl.v2.core.statehandler.complextask;

import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL;
import com.obric.aiagent.assistant.idl.bean.DMConstData;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.state.api.v2.core.AssistantAliveReason;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandPriority;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.assistant.state.api.v2.core.bean.ObricStateKey;
import com.obric.assistant.state.impl.v2.core.g;
import com.obric.assistant.state.impl.v2.power.ObricPowerManager;
import com.obric.assistant.state.impl.v2.utils.f;
import com.obric.assistant.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\n\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"com/obric/assistant/state/impl/v2/core/statehandler/complextask/ComplexTaskStateHandler$complexTaskStateListener$1", "Lcom/obric/aiagent/assistant/idl/IAgentDMStateListenerIDL$Stub;", "onDMStateChanged", "", "dmState", "Lcom/obric/aiagent/assistant/idl/bean/DMStateInfo;", "onTaskAdded", "taskInfo", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskInfo;", "onTaskEnd", "onTaskStateChanged", "previousState", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;", "newState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComplexTaskStateHandler$complexTaskStateListener$1 extends IAgentDMStateListenerIDL.Stub {
    final /* synthetic */ ComplexTaskStateHandler this$0;

    public ComplexTaskStateHandler$complexTaskStateListener$1(ComplexTaskStateHandler r1) {
        this.this$0 = r1;
    }

    public void onDMStateChanged(DMStateInfo r18) {
        FLogger r8 = FLogger.a;
        this.this$0.getClass();
        StringBuilder r9 = new StringBuilder("onDMStateChanged, ");
        DMStateInfo r2 = null;
        if (r18 == null) goto L13;
        this.this$0.getClass();
        Intrinsics.checkNotNullParameter(r18, "<this>");
        List r5 = r18.getActiveTasks();
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L6:
        if (r7.hasNext() == false) goto L12;
        DMTaskState r10 = (DMTaskState) r7.next();
        DMTaskInfo r11 = r10.getTaskInfo();
        if (r11 == null) goto L10;
        DMTaskInfo r12 = ComplexTaskStateHandler.a(r11);
    L11:
        r6.add(DMTaskState.copy$default(r10, null, r12, 0, null, 13, null));
        goto L6
    L10:
        r12 = null;
        goto L11
    L12:
        r2 = DMStateInfo.copy$default(r18, false, false, r6, null, 11, null);
    L13:
        r9.append(r2);
        r8.d("[ComplexTaskStateHandler]", r9.toString());
    }

    public void onTaskAdded(DMTaskInfo r6) {
        FLogger r0 = FLogger.a;
        this.this$0.getClass();
        StringBuilder r1 = new StringBuilder("onTaskAdded: taskId: ");
        String r2 = null;
        if (r6 == null) goto L5;
        String r3 = r6.getTaskId();
    L6:
        String r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r1.append(r3);
        r1.append(", omniTaskId: ");
        if (r6 == null) goto L12;
        r2 = l.c(r6);
    L12:
        if (r2 == null) goto L15;
        r4 = r2;
    L15:
        r1.append(r4);
        r0.i("[ComplexTaskStateHandler]", r1.toString());
        return;
    L5:
        r3 = null;
        goto L6
    }

    public void onTaskEnd(DMTaskInfo r6) {
        FLogger r0 = FLogger.a;
        this.this$0.getClass();
        StringBuilder r1 = new StringBuilder("onTaskEnd: taskId: ");
        String r2 = null;
        if (r6 == null) goto L5;
        String r3 = r6.getTaskId();
    L6:
        String r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r1.append(r3);
        r1.append(", omniTaskId: ");
        if (r6 == null) goto L12;
        r2 = l.c(r6);
    L12:
        if (r2 == null) goto L15;
        r4 = r2;
    L15:
        r1.append(r4);
        r0.i("[ComplexTaskStateHandler]", r1.toString());
        return;
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onTaskStateChanged(DMTaskInfo r24, DMTaskState r25, DMTaskState r26) {
        FLogger r0 = FLogger.a;
        this.this$0.getClass();
        StringBuilder r2 = new StringBuilder("onTaskStateChanged, previousState: ");
        Object r3 = null;
        if (r25 == null) goto L5;
        Integer r4 = Integer.valueOf(r25.getState());
    L6:
        r2.append(r4);
        r2.append(", newState: ");
        if (r26 == null) goto L9;
        Integer r5 = Integer.valueOf(r26.getState());
    L10:
        r2.append(r5);
        r2.append(", taskInfo: ");
        if (r24 == null) goto L13;
        this.this$0.getClass();
        DMTaskInfo r6 = ComplexTaskStateHandler.a(r24);
    L14:
        r2.append(r6);
        r0.d("[ComplexTaskStateHandler]", r2.toString());
        if (r24 == null) goto L17;
        Integer r7 = Integer.valueOf(r24.getTaskType());
    L18:
        int r8 = DMConstData.DMTaskType.COMPLEX.ordinal();
        if (r7 != null) goto L22;
        return;
    L22:
        if (r7.intValue() != r8) goto L461;
        this.this$0.getClass();
        StringBuilder r9 = new StringBuilder("handleComplexTaskInternal, previousState: ");
        if (r25 == null) goto L26;
        Integer r10 = Integer.valueOf(r25.getState());
    L27:
        r9.append(r10);
        r9.append(", newState: ");
        if (r26 == null) goto L30;
        Integer r11 = Integer.valueOf(r26.getState());
    L31:
        r9.append(r11);
        r9.append(", taskInfo: ");
        if (r24 == null) goto L34;
        DMTaskInfo r12 = ComplexTaskStateHandler.a(r24);
    L35:
        r9.append(r12);
        r0.i("[ComplexTaskStateHandler]", r9.toString());
        if (r26 == null) goto L38;
        Integer r1 = Integer.valueOf(r26.getState());
    L39:
        int r13 = DMConstData.DMComplexTaskState.CallUser.ordinal();
        if (r1 != null) goto L43;
    L96:
        int r14 = DMConstData.DMComplexTaskState.TakingOver.ordinal();
        boolean r15 = true;
        if (r1 != null) goto L100;
    L158:
        DMConstData.DMComplexTaskState r16 = DMConstData.DMComplexTaskState.Idle;
        int r17 = r16.ordinal();
        if (r1 != null) goto L162;
    L204:
        int r18 = DMConstData.DMComplexTaskState.Thinking.ordinal();
        if (r1 != null) goto L208;
    L289:
        int r19 = DMConstData.DMComplexTaskState.Clarify.ordinal();
        if (r1 != null) goto L293;
    L367:
        int r20 = DMConstData.DMComplexTaskState.ClarifyAck.ordinal();
        if (r1 != null) goto L371;
    L421:
        int r21 = DMConstData.DMComplexTaskState.ThinkingCompleted.ordinal();
        if (r1 != null) goto L425;
    L429:
        int r22 = DMConstData.DMComplexTaskState.Terminated.ordinal();
        if (r1 != null) goto L433;
    L454:
        DMConstData.DMComplexTaskState.TTS.ordinal();
        if (r1 == null) goto L479;
        r1.intValue();
        return;
    L479:
        return;
    L433:
        if (r1.intValue() != r22) goto L454;
        if (r24 == null) goto L452;
        IMMessage r23 = r24.getMessage();
        if (r23 == null) goto L452;
        String r110 = r23.getConversationId();
        if (r110 == null) goto L452;
        hha.a r27 = g.a;
        ObricIslandStateType r111 = ObricIslandStateType.COMPLEX_TASK_INTERRUPTED;
        ObricInteractionScene r112 = ObricInteractionScene.COMPLEX_TASK_SCENE;
        ObricIslandPriority r113 = ObricIslandPriority.LOW;
        IMMessage r28 = r24.getMessage();
        if (r28 == null) goto L442;
        r3 = r28.getMessageId();
    L442:
        String r114 = r3;
        Long r115 = Long.valueOf(r24.getCreatedTime());
        LinkedHashMap r29 = new LinkedHashMap();
        Map r30 = r24.getExt();
        if (r30 == null) goto L447;
        String r31 = (String) r30.get("o_omni_task_id");
        if (r31 == null) goto L447;
        r29.put("o_omni_task_id", r31);
    L447:
        String r32 = (String) r26.getExtra().get("o_complex_source_type");
        if (r32 == null) goto L450;
        r29.put("o_complex_source_type", r32);
        Unit r33 = Unit.INSTANCE;
    L450:
        Unit r34 = Unit.INSTANCE;
        g.a(new ObricState(r111, r110, r112, r113, r114, r115, r29));
    L452:
        if (f.a == true) goto L476;
        CoroutineScope r35 = ObricPowerManager.a;
        AssistantAliveReason r36 = AssistantAliveReason.COMPLEX_TASK_IN_PROGRESS;
        ObricPowerManager.g(r36);
        ObricPowerManager.f(r36);
        return;
    L476:
        return;
    L425:
        if (r1.intValue() != r21) goto L429;
        if (f.a == true) goto L474;
        CoroutineScope r37 = ObricPowerManager.a;
        AssistantAliveReason r38 = AssistantAliveReason.COMPLEX_TASK_IN_PROGRESS;
        ObricPowerManager.d(r38);
        ObricPowerManager.c(r38);
        return;
    L474:
        return;
    L371:
        if (r1.intValue() != r20) goto L421;
        if (r24 == null) goto L419;
        IMMessage r39 = r24.getMessage();
        if (r39 == null) goto L419;
        String r116 = r39.getConversationId();
        if (r116 == null) goto L419;
        hha.a r40 = g.a;
        ObricIslandStateType r117 = ObricIslandStateType.COMPLEX_TASK_RECEIVE_USER_CLARIFY;
        ObricInteractionScene r118 = ObricInteractionScene.COMPLEX_TASK_SCENE;
        ObricIslandPriority r119 = ObricIslandPriority.HIGH;
        IMMessage r41 = r24.getMessage();
        if (r41 == null) goto L380;
        r3 = r41.getMessageId();
    L380:
        String r120 = r3;
        Long r121 = Long.valueOf(r24.getCreatedTime());
        LinkedHashMap r42 = new LinkedHashMap();
        Map r43 = r24.getExt();
        if (r43 == null) goto L385;
        String r44 = (String) r43.get("o_omni_task_id");
        if (r44 == null) goto L385;
        r42.put("o_omni_task_id", r44);
    L385:
        String r45 = (String) r26.getExtra().get("o_complex_source_type");
        if (r45 == null) goto L388;
        r42.put("o_complex_source_type", r45);
    L388:
        IMMessage r46 = r24.getMessage();
        if (r46 == null) goto L393;
        String r47 = ComplexTaskStateHandler.b(r46);
        if (r47 == null) goto L393;
        r42.put("origin_query", r47);
    L393:
        String r48 = (String) r26.getExtra().get("clarify_message_reply");
        if (r48 == null) goto L396;
        r42.put("clarify_message_reply", r48);
    L396:
        DMTaskInfo r49 = r26.getTaskInfo();
        if (r49 == null) goto L403;
        Map r50 = r49.getExt();
        if (r50 == null) goto L403;
        String r51 = (String) r50.get("o_last_reply_message_id");
        if (r51 == null) goto L403;
        r42.put("o_last_reply_message_id", r51);
    L403:
        DMTaskInfo r52 = r26.getTaskInfo();
        if (r52 == null) goto L410;
        Map r53 = r52.getExt();
        if (r53 == null) goto L410;
        String r54 = (String) r53.get("o_task_current_step_description");
        if (r54 == null) goto L410;
        r42.put("o_task_current_step_description", r54);
    L410:
        DMTaskInfo r55 = r26.getTaskInfo();
        if (r55 == null) goto L417;
        Map r56 = r55.getExt();
        if (r56 == null) goto L417;
        String r57 = (String) r56.get("o_task_current_step_detail");
        if (r57 == null) goto L417;
        r42.put("o_task_current_step_detail", r57);
        Unit r58 = Unit.INSTANCE;
    L417:
        Unit r59 = Unit.INSTANCE;
        g.a(new ObricState(r117, r116, r118, r119, r120, r121, r42));
    L419:
        if (f.a == true) goto L472;
        CoroutineScope r60 = ObricPowerManager.a;
        AssistantAliveReason r61 = AssistantAliveReason.COMPLEX_TASK_IN_PROGRESS;
        ObricPowerManager.d(r61);
        ObricPowerManager.c(r61);
        return;
    L472:
        return;
    L293:
        if (r1.intValue() != r19) goto L367;
        if (r24 == null) goto L365;
        IMMessage r62 = r24.getMessage();
        if (r62 == null) goto L365;
        String r122 = r62.getConversationId();
        if (r122 == null) goto L365;
        hha.a r63 = g.a;
        ObricIslandStateType r123 = ObricIslandStateType.COMPLEX_TASK_ASK_USER;
        ObricInteractionScene r124 = ObricInteractionScene.COMPLEX_TASK_SCENE;
        ObricIslandPriority r125 = ObricIslandPriority.HIGH;
        IMMessage r64 = r24.getMessage();
        if (r64 == null) goto L302;
        String r126 = r64.getMessageId();
    L303:
        Long r127 = Long.valueOf(r24.getCreatedTime());
        LinkedHashMap r65 = new LinkedHashMap();
        Map r66 = r24.getExt();
        if (r66 == null) goto L308;
        String r67 = (String) r66.get("o_omni_task_id");
        if (r67 == null) goto L308;
        r65.put("o_omni_task_id", r67);
    L308:
        String r68 = (String) r26.getExtra().get("o_complex_source_type");
        if (r68 == null) goto L311;
        r65.put("o_complex_source_type", r68);
    L311:
        IMMessage r69 = r24.getMessage();
        if (r69 == null) goto L316;
        String r70 = ComplexTaskStateHandler.b(r69);
        if (r70 == null) goto L316;
        r65.put("origin_query", r70);
    L316:
        String r71 = (String) r26.getExtra().get("clarify_message_content");
        if (r71 == null) goto L319;
        r65.put("clarify_message_content", r71);
    L319:
        String r72 = (String) r26.getExtra().get("is_call_for_me_ask_user");
        if (r72 == null) goto L322;
        r65.put("is_call_for_me_ask_user", r72);
    L322:
        String r73 = (String) r26.getExtra().get("is_knowledge_ai_ask_user");
        if (r73 == null) goto L325;
        r65.put("is_knowledge_ai_ask_user", r73);
    L325:
        DMTaskInfo r74 = r26.getTaskInfo();
        if (r74 == null) goto L332;
        Map r75 = r74.getExt();
        if (r75 == null) goto L332;
        String r76 = (String) r75.get("o_last_reply_message_id");
        if (r76 == null) goto L332;
        r65.put("o_last_reply_message_id", r76);
    L332:
        String r77 = (String) r26.getExtra().get("o_complex_clarify_candidate");
        if (r77 != null) goto L459;
    L346:
        String r78 = (String) r26.getExtra().get("o_block_decision_source");
        if (r78 == null) goto L349;
        r65.put("o_block_decision_source", r78);
    L349:
        DMTaskInfo r79 = r26.getTaskInfo();
        if (r79 == null) goto L356;
        Map r80 = r79.getExt();
        if (r80 == null) goto L356;
        String r81 = (String) r80.get("o_task_current_step_description");
        if (r81 == null) goto L356;
        r65.put("o_task_current_step_description", r81);
    L356:
        DMTaskInfo r82 = r26.getTaskInfo();
        if (r82 == null) goto L363;
        Map r83 = r82.getExt();
        if (r83 == null) goto L363;
        String r84 = (String) r83.get("o_task_current_step_detail");
        if (r84 == null) goto L363;
        r65.put("o_task_current_step_detail", r84);
        Unit r85 = Unit.INSTANCE;
    L363:
        Unit r86 = Unit.INSTANCE;
        g.a(new ObricState(r123, r122, r124, r125, r126, r127, r65));
        goto L365
    L459:
        String[] r87 = (String[]) new Gson().fromJson(r77, String[].class);     // Catch: Exception -> L336
    L338:
        if (r87 != null) goto L340;
    L342:
        FLogger r88 = FLogger.a;
        StringBuilder r89 = new StringBuilder("clarify candidates parse failed, ");
        if (r87 == null) goto L345;
        r3 = Integer.valueOf(r87.length);
    L345:
        r89.append(r3);
        r88.w("[ComplexTaskStateHandler]", r89.toString());
        Unit r90 = Unit.INSTANCE;
        goto L346
    L340:
        if (r87.length != 2) goto L342;
        r65.put("o_complex_clarify_candidate", r87);
    L336:
        e = move-exception;
        FLogger.a.w("[ComplexTaskStateHandler]", "convert to gson failed!", e);
        r87 = null;
        goto L338
    L302:
        r126 = null;
    L365:
        if (f.a == true) goto L470;
        CoroutineScope r91 = ObricPowerManager.a;
        AssistantAliveReason r92 = AssistantAliveReason.COMPLEX_TASK_IN_PROGRESS;
        ObricPowerManager.d(r92);
        ObricPowerManager.c(r92);
        return;
    L470:
        return;
    L208:
        if (r1.intValue() != r18) goto L289;
        if (r24 == null) goto L287;
        IMMessage r93 = r24.getMessage();
        if (r93 == null) goto L287;
        String r94 = r93.getConversationId();
        if (r94 == null) goto L287;
        Object r95 = r26.getExtra().get("o_gui_package_name");
        CharSequence r96 = (CharSequence) r95;
        if (r96 != null) goto L217;
    L220:
        boolean r97 = true;
    L221:
        if (r97 == false) goto L233;
        hha.a r98 = g.a;
        ObricInteractionScene r99 = ObricInteractionScene.COMPLEX_TASK_SCENE;
        Intrinsics.checkNotNullParameter(r94, "cid");
        Intrinsics.checkNotNullParameter(r99, "scene");
        ObricState r100 = (ObricState) g.f.get(new ObricStateKey(r94, r99));
        if (r100 == null) goto L229;
        Map r101 = r100.getExt();
        if (r101 == null) goto L229;
        Object r102 = r101.get("o_gui_package_name");
        if (r102 == null) goto L229;
        String r103 = r102.toString();
    L230:
        boolean r104 = o0.d(r103);
        Object r105 = r103;
        if (r104 == true) goto L236;
    L235:
        r105 = null;
    L236:
        hha.a r106 = g.a;
        CharSequence r107 = (CharSequence) r105;
        if (r107 != null) goto L239;
    L242:
        if (r15 == false) goto L244;
        ObricIslandStateType r108 = ObricIslandStateType.COMPLEX_TASK_THINK_START;
    L245:
        ObricIslandStateType r128 = r108;
        ObricInteractionScene r129 = ObricInteractionScene.COMPLEX_TASK_SCENE;
        ObricIslandPriority r130 = ObricIslandPriority.LOW;
        IMMessage r109 = r24.getMessage();
        if (r109 == null) goto L248;
        r3 = r109.getMessageId();
    L248:
        String r210 = r3;
        Long r211 = Long.valueOf(r24.getCreatedTime());
        LinkedHashMap r131 = new LinkedHashMap();
        String r132 = (String) r105;
        if (r132 == null) goto L251;
        r131.put("o_gui_package_name", r132);
    L251:
        Map r133 = r24.getExt();
        if (r133 == null) goto L256;
        String r134 = (String) r133.get("o_omni_task_id");
        if (r134 == null) goto L256;
        r131.put("o_omni_task_id", r134);
    L256:
        String r135 = (String) r26.getExtra().get("o_complex_source_type");
        if (r135 == null) goto L259;
        r131.put("o_complex_source_type", r135);
    L259:
        IMMessage r136 = r24.getMessage();
        if (r136 == null) goto L264;
        String r137 = ComplexTaskStateHandler.b(r136);
        if (r137 == null) goto L264;
        r131.put("origin_query", r137);
    L264:
        DMTaskInfo r138 = r26.getTaskInfo();
        if (r138 == null) goto L271;
        Map r139 = r138.getExt();
        if (r139 == null) goto L271;
        String r140 = (String) r139.get("o_last_reply_message_id");
        if (r140 == null) goto L271;
        r131.put("o_last_reply_message_id", r140);
    L271:
        DMTaskInfo r141 = r26.getTaskInfo();
        if (r141 == null) goto L278;
        Map r142 = r141.getExt();
        if (r142 == null) goto L278;
        String r143 = (String) r142.get("o_task_current_step_description");
        if (r143 == null) goto L278;
        r131.put("o_task_current_step_description", r143);
    L278:
        DMTaskInfo r144 = r26.getTaskInfo();
        if (r144 == null) goto L285;
        Map r145 = r144.getExt();
        if (r145 == null) goto L285;
        String r146 = (String) r145.get("o_task_current_step_detail");
        if (r146 == null) goto L285;
        r131.put("o_task_current_step_detail", r146);
        Unit r147 = Unit.INSTANCE;
    L285:
        Unit r148 = Unit.INSTANCE;
        g.a(new ObricState(r128, r94, r129, r130, r210, r211, r131));
        goto L287
    L244:
        r108 = ObricIslandStateType.COMPLEX_TASK_OPERATING_VIRTUAL_SCREEN;
        goto L245
    L239:
        if (r107.length() == 0) goto L242;
        r15 = false;
    L229:
        r103 = null;
        goto L230
    L233:
        boolean r149 = Intrinsics.areEqual(r95, "complete");
        r105 = r95;
        if (r149 == false) goto L236;
    L217:
        if (r96.length() == 0) goto L220;
        r97 = false;
    L287:
        if (f.a == true) goto L468;
        CoroutineScope r150 = ObricPowerManager.a;
        AssistantAliveReason r151 = AssistantAliveReason.COMPLEX_TASK_IN_PROGRESS;
        ObricPowerManager.d(r151);
        ObricPowerManager.c(r151);
        return;
    L468:
        return;
    L162:
        if (r1.intValue() != r17) goto L204;
        if (r25 != null) goto L165;
    L167:
        r15 = false;
    L168:
        if (r15 == true) goto L202;
        if (r24 == null) goto L202;
        IMMessage r152 = r24.getMessage();
        if (r152 == null) goto L202;
        String r153 = r152.getConversationId();
        if (r153 == null) goto L202;
        hha.a r154 = g.a;
        ObricIslandStateType r155 = ObricIslandStateType.COMPLEX_TASK_COMPLETED;
        ObricInteractionScene r156 = ObricInteractionScene.COMPLEX_TASK_SCENE;
        ObricIslandPriority r157 = ObricIslandPriority.LOW;
        IMMessage r158 = r24.getMessage();
        if (r158 == null) goto L177;
        r3 = r158.getMessageId();
    L177:
        String r159 = r3;
        Long r160 = Long.valueOf(r24.getCreatedTime());
        LinkedHashMap r161 = new LinkedHashMap();
        Map r162 = r24.getExt();
        if (r162 == null) goto L182;
        String r163 = (String) r162.get("o_omni_task_id");
        if (r163 == null) goto L182;
        r161.put("o_omni_task_id", r163);
    L182:
        String r164 = (String) r26.getExtra().get("o_complex_source_type");
        if (r164 == null) goto L185;
        r161.put("o_complex_source_type", r164);
    L185:
        IMMessage r165 = r24.getMessage();
        if (r165 == null) goto L190;
        String r166 = ComplexTaskStateHandler.b(r165);
        if (r166 == null) goto L190;
        r161.put("origin_query", r166);
    L190:
        DMTaskInfo r167 = r26.getTaskInfo();
        if (r167 == null) goto L197;
        Map r168 = r167.getExt();
        if (r168 == null) goto L197;
        String r169 = (String) r168.get("o_last_reply_message_id");
        if (r169 == null) goto L197;
        r161.put("o_last_reply_message_id", r169);
    L197:
        String r170 = (String) r26.getExtra().get("o_complete_result");
        if (r170 == null) goto L200;
        r161.put("o_complete_result", r170);
        Unit r171 = Unit.INSTANCE;
    L200:
        Unit r172 = Unit.INSTANCE;
        g.a(new ObricState(r155, r153, r156, r157, r159, r160, r161));
    L202:
        if (f.a == true) goto L466;
        CoroutineScope r173 = ObricPowerManager.a;
        AssistantAliveReason r174 = AssistantAliveReason.COMPLEX_TASK_IN_PROGRESS;
        ObricPowerManager.g(r174);
        ObricPowerManager.f(r174);
        return;
    L466:
        return;
    L165:
        if (r25.getState() != r16.ordinal()) goto L167;
    L100:
        if (r1.intValue() != r14) goto L158;
        if (r24 == null) goto L156;
        IMMessage r175 = r24.getMessage();
        if (r175 == null) goto L156;
        String r176 = r175.getConversationId();
        if (r176 == null) goto L156;
        hha.a r177 = g.a;
        ObricIslandStateType r178 = ObricIslandStateType.COMPLEX_TASK_TAKING_OVER;
        ObricInteractionScene r179 = ObricInteractionScene.COMPLEX_TASK_SCENE;
        ObricIslandPriority r180 = ObricIslandPriority.HIGH;
        IMMessage r181 = r24.getMessage();
        if (r181 == null) goto L109;
        String r182 = r181.getMessageId();
    L110:
        Long r183 = Long.valueOf(r24.getCreatedTime());
        LinkedHashMap r184 = new LinkedHashMap();
        Map r185 = r24.getExt();
        if (r185 == null) goto L115;
        String r186 = (String) r185.get("o_omni_task_id");
        if (r186 == null) goto L115;
        r184.put("o_omni_task_id", r186);
    L115:
        String r187 = (String) r26.getExtra().get("o_complex_source_type");
        if (r187 == null) goto L118;
        r184.put("o_complex_source_type", r187);
    L118:
        IMMessage r188 = r24.getMessage();
        if (r188 == null) goto L123;
        String r189 = ComplexTaskStateHandler.b(r188);
        if (r189 == null) goto L123;
        r184.put("origin_query", r189);
    L123:
        String r190 = (String) r26.getExtra().get("take_over_reason");
        if (r190 != null) goto L126;
    L130:
        DMTaskInfo r191 = r26.getTaskInfo();
        if (r191 == null) goto L137;
        Map r192 = r191.getExt();
        if (r192 == null) goto L137;
        String r193 = (String) r192.get("o_last_reply_message_id");
        if (r193 == null) goto L137;
        r184.put("o_last_reply_message_id", r193);
    L137:
        String r194 = (String) r26.getExtra().get("o_block_decision_source");
        if (r194 == null) goto L140;
        r184.put("o_block_decision_source", r194);
    L140:
        DMTaskInfo r195 = r26.getTaskInfo();
        if (r195 == null) goto L147;
        Map r196 = r195.getExt();
        if (r196 == null) goto L147;
        String r197 = (String) r196.get("o_task_current_step_description");
        if (r197 == null) goto L147;
        r184.put("o_task_current_step_description", r197);
    L147:
        DMTaskInfo r198 = r26.getTaskInfo();
        if (r198 == null) goto L154;
        Map r199 = r198.getExt();
        if (r199 == null) goto L154;
        String r200 = (String) r199.get("o_task_current_step_detail");
        if (r200 == null) goto L154;
        r184.put("o_task_current_step_detail", r200);
        Unit r201 = Unit.INSTANCE;
    L154:
        Unit r202 = Unit.INSTANCE;
        g.a(new ObricState(r178, r176, r179, r180, r182, r183, r184));
        goto L156
    L126:
        if ((!StringsKt.isBlank(r190)) == false) goto L128;
        r3 = r190;
    L128:
        if (r3 == null) goto L130;
        r184.put("take_over_reason", r3);
        goto L130
    L109:
        r182 = null;
    L156:
        if (f.a == true) goto L464;
        CoroutineScope r203 = ObricPowerManager.a;
        AssistantAliveReason r204 = AssistantAliveReason.COMPLEX_TASK_IN_PROGRESS;
        ObricPowerManager.d(r204);
        ObricPowerManager.c(r204);
        return;
    L464:
        return;
    L43:
        if (r1.intValue() != r13) goto L96;
        if (r24 == null) goto L94;
        IMMessage r205 = r24.getMessage();
        if (r205 == null) goto L94;
        String r1100 = r205.getConversationId();
        if (r1100 == null) goto L94;
        hha.a r206 = g.a;
        ObricIslandStateType r1101 = ObricIslandStateType.COMPLEX_TASK_CALL_USER;
        ObricInteractionScene r1102 = ObricInteractionScene.COMPLEX_TASK_SCENE;
        ObricIslandPriority r1103 = ObricIslandPriority.HIGH;
        IMMessage r207 = r24.getMessage();
        if (r207 == null) goto L52;
        r3 = r207.getMessageId();
    L52:
        String r1104 = r3;
        Long r1105 = Long.valueOf(r24.getCreatedTime());
        LinkedHashMap r208 = new LinkedHashMap();
        Map r209 = r24.getExt();
        if (r209 == null) goto L57;
        String r212 = (String) r209.get("o_omni_task_id");
        if (r212 == null) goto L57;
        r208.put("o_omni_task_id", r212);
    L57:
        String r213 = (String) r26.getExtra().get("o_complex_source_type");
        if (r213 == null) goto L60;
        r208.put("o_complex_source_type", r213);
    L60:
        IMMessage r214 = r24.getMessage();
        if (r214 == null) goto L65;
        String r215 = ComplexTaskStateHandler.b(r214);
        if (r215 == null) goto L65;
        r208.put("origin_query", r215);
    L65:
        String r216 = (String) r26.getExtra().get("o_complex_call_user_content");
        if (r216 == null) goto L68;
        r208.put("o_complex_call_user_content", r216);
    L68:
        DMTaskInfo r217 = r26.getTaskInfo();
        if (r217 == null) goto L75;
        Map r218 = r217.getExt();
        if (r218 == null) goto L75;
        String r219 = (String) r218.get("o_last_reply_message_id");
        if (r219 == null) goto L75;
        r208.put("o_last_reply_message_id", r219);
    L75:
        String r220 = (String) r26.getExtra().get("o_block_decision_source");
        if (r220 == null) goto L78;
        r208.put("o_block_decision_source", r220);
    L78:
        DMTaskInfo r221 = r26.getTaskInfo();
        if (r221 == null) goto L85;
        Map r222 = r221.getExt();
        if (r222 == null) goto L85;
        String r223 = (String) r222.get("o_task_current_step_description");
        if (r223 == null) goto L85;
        r208.put("o_task_current_step_description", r223);
    L85:
        DMTaskInfo r224 = r26.getTaskInfo();
        if (r224 == null) goto L92;
        Map r225 = r224.getExt();
        if (r225 == null) goto L92;
        String r226 = (String) r225.get("o_task_current_step_detail");
        if (r226 == null) goto L92;
        r208.put("o_task_current_step_detail", r226);
        Unit r227 = Unit.INSTANCE;
    L92:
        Unit r228 = Unit.INSTANCE;
        g.a(new ObricState(r1101, r1100, r1102, r1103, r1104, r1105, r208));
    L94:
        if (f.a == true) goto L462;
        CoroutineScope r229 = ObricPowerManager.a;
        AssistantAliveReason r230 = AssistantAliveReason.COMPLEX_TASK_IN_PROGRESS;
        ObricPowerManager.d(r230);
        ObricPowerManager.c(r230);
        return;
    L462:
        return;
    L38:
        r1 = null;
        goto L39
    L34:
        r12 = null;
        goto L35
    L30:
        r11 = null;
        goto L31
    L26:
        r10 = null;
        goto L27
    L461:
        return;
    L17:
        r7 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
