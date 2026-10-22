package com.obric.assistant.complex_task;

import android.media.AudioManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL;
import com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL;
import com.obric.aiagent.assistant.idl.bean.DMConstData;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.task.ITaskCenter;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\n\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"com/obric/assistant/complex_task/ComplexTaskManager$complexTaskStateListener$1", "Lcom/obric/aiagent/assistant/idl/IAgentDMStateListenerIDL$Stub;", "onDMStateChanged", NameKeys.UnloadStrategy_No_Strategy, "dmState", "Lcom/obric/aiagent/assistant/idl/bean/DMStateInfo;", "onTaskAdded", "taskInfo", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskInfo;", "onTaskEnd", "onTaskStateChanged", "previousState", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;", "newState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComplexTaskManager$complexTaskStateListener$1 extends IAgentDMStateListenerIDL.Stub {
    public static /* synthetic */ void a(DMTaskInfo r0) {
        onTaskEnd$lambda$0(r0);
    }

    public void onDMStateChanged(DMStateInfo r1) {
    }

    public void onTaskAdded(DMTaskInfo r1) {
    }

    public ComplexTaskManager$complexTaskStateListener$1() {
    }

    private static final void onTaskEnd$lambda$0(DMTaskInfo r3) {
        String r4 = "ComplexTask-" + r3.getTaskId();
        FLogger.a.i("ComplexTaskManager", "onTaskEnd, cancel task in task center, taskId = " + r4);
        ITaskCenter r0 = (ITaskCenter) ServiceManager.get().getService(ITaskCenter.class);
        if (r0 == null) goto L6;
        r0.cancel(r4);
        return;
    }

    public void onTaskEnd(final DMTaskInfo r4) {
        if (r4 != null) goto L4;
    L6:
        boolean r0 = false;
    L7:
        if (r0 == true) goto L9;
        return;
    L9:
        SoftReference r1 = y.a;
        Runnable r2 = new l(r4);
        Intrinsics.checkNotNullParameter(r2, "action");
        y.d(r2, 5000);
        return;
    L4:
        if (r4.getTaskType() != DMConstData.DMTaskType.COMPLEX.ordinal()) goto L6;
        r0 = true;
        goto L7
    }

    public void onTaskStateChanged(DMTaskInfo r12, DMTaskState r13, DMTaskState r14) {
        boolean r0 = false;
        if (r12 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L11;
        return;
    L11:
        if (r14 != null) goto L14;
        FLogger.a.w("ComplexTaskManager", "newState is null, task is " + r12.getTaskId());
        return;
    L14:
        t r3 = ComplexTaskManager.a;
        if (r13 != null) goto L17;
    L19:
        boolean r4 = false;
    L20:
        List r5 = null;
        if (r4 == false) goto L24;
    L53:
        Map r6 = r12.getExt();
        StringBuilder r7 = new StringBuilder("progress = ");
        r7.append(r12.getProgress());
        r7.append(", latestMsgId = ");
        if (r6 == null) goto L56;
        String r8 = (String) r6.get("o_last_reply_message_id");
    L57:
        r7.append(r8);
        r7.append(", stepDescription = ");
        if (r6 == null) goto L60;
        String r9 = (String) r6.get("o_task_current_step_description");
    L61:
        r7.append(r9);
        String r10 = r7.toString();
        FLogger r11 = FLogger.a;
        StringBuilder r15 = new StringBuilder("task is ");
        r15.append(r12.getTaskId());
        r15.append(", onTaskStateChanged to ");
        r15.append(ComplexTaskManager.c(Integer.valueOf(r14.getState())));
        r15.append(", previous state is ");
        if (r13 == null) goto L64;
        Integer r16 = Integer.valueOf(r13.getState());
    L65:
        r15.append(ComplexTaskManager.c(r16));
        r15.append(", omni id = ");
        if (r6 == null) goto L68;
        String r17 = (String) r6.get("o_omni_task_id");
    L69:
        r15.append(r17);
        r15.append(", EXT_KEY_COMPLEX_TASK_SOURCE_TYPE = ");
        Map r18 = r14.getExtra();
        if ((r18 instanceof Map) == true) goto L74;
        r18 = null;
    L74:
        if (r18 == null) goto L76;
        Object r19 = r18.get("o_complex_source_type");
    L77:
        r15.append(r19);
        r11.i("ComplexTaskManager", r15.toString());
        Map r20 = r14.getExtra();
        if ((r20 instanceof Map) == true) goto L81;
        r20 = null;
    L81:
        int r21 = r14.getState();
        DMConstData.DMComplexTaskState r22 = DMConstData.DMComplexTaskState.Queueing;
        if (r21 != r22.ordinal()) goto L89;
        StringBuilder r23 = new StringBuilder();
        r23.append(r10);
        r23.append(", queueingTimestamp = ");
        if (r20 == null) goto L86;
        Object r24 = r20.get("o_task_queue_timestamp");
    L87:
        r23.append(r24);
        r11.i("ComplexTaskManager", r23.toString());
    L137:
        IAgentDMStateManagerIDL r25 = com.obric.aiagent.assistant.idl.f.a(Reflection.getOrCreateKotlinClass(IAgentDMStateManagerIDL.class));
        if (r25 == null) goto L142;
        DMStateInfo r26 = r25.getCurrentDMSteate();
        if (r26 == null) goto L142;
        r5 = r26.getActiveTasks();
    L142:
        ComplexTaskManager.d(r12, r13, r14, r5, ComplexTaskManager.UpdateSource.TASK_STATE_CHANGED);
        if (r14.getState() == r22.ordinal()) goto L149;
        if (r13 != null) goto L146;
    L148:
        if (r0 == true) goto L149;
        return;
    L146:
        if (r13.getState() != r22.ordinal()) goto L148;
        r0 = true;
    L149:
        ComplexTaskManager.f(r12.getTaskId(), r5);
        return;
    L86:
        r24 = null;
        goto L87
    L89:
        if (r21 != DMConstData.DMComplexTaskState.Thinking.ordinal()) goto L96;
        StringBuilder r27 = new StringBuilder();
        r27.append(r10);
        r27.append(", operatingPackage = ");
        if (r20 == null) goto L93;
        Object r28 = r20.get("o_gui_package_name");
    L94:
        r27.append(r28);
        r11.i("ComplexTaskManager", r27.toString());
        goto L137
    L93:
        r28 = null;
        goto L94
    L96:
        if (r21 != DMConstData.DMComplexTaskState.Clarify.ordinal()) goto L111;
        StringBuilder r29 = new StringBuilder();
        r29.append(r10);
        r29.append(", clarifyMessageContent = ");
        if (r20 == null) goto L100;
        Object r30 = r20.get("clarify_message_content");
    L101:
        r29.append(r30);
        r29.append(", clarifyCandidates = ");
        if (r20 == null) goto L104;
        Object r31 = r20.get("o_complex_clarify_candidate");
    L105:
        r29.append(r31);
        r29.append(", sourceType = ");
        if (r20 == null) goto L108;
        Object r32 = r20.get("o_complex_source_type");
    L109:
        r29.append(r32);
        r11.i("ComplexTaskManager", r29.toString());
        goto L137
    L108:
        r32 = null;
        goto L109
    L104:
        r31 = null;
        goto L105
    L100:
        r30 = null;
        goto L101
    L111:
        if (r21 != DMConstData.DMComplexTaskState.ClarifyAck.ordinal()) goto L118;
        StringBuilder r33 = new StringBuilder();
        r33.append(r10);
        r33.append(", clarifyReply = ");
        if (r20 == null) goto L115;
        Object r34 = r20.get("clarify_message_reply");
    L116:
        r33.append(r34);
        r11.i("ComplexTaskManager", r33.toString());
        goto L137
    L115:
        r34 = null;
        goto L116
    L118:
        if (r21 != DMConstData.DMComplexTaskState.Idle.ordinal()) goto L125;
        StringBuilder r35 = new StringBuilder();
        r35.append(r10);
        r35.append(", completeResult = ");
        if (r20 == null) goto L122;
        Object r36 = r20.get("o_complete_result");
    L123:
        r35.append(r36);
        r11.i("ComplexTaskManager", r35.toString());
        goto L137
    L122:
        r36 = null;
        goto L123
    L125:
        if (r21 != DMConstData.DMComplexTaskState.TakingOver.ordinal()) goto L128;
        r11.i("ComplexTaskManager", r10 + ", TakingOver");
        goto L137
    L128:
        if (r21 != DMConstData.DMComplexTaskState.Terminated.ordinal()) goto L131;
        r11.i("ComplexTaskManager", r10 + ", Terminated");
        goto L137
    L131:
        if (r21 != DMConstData.DMComplexTaskState.CallUser.ordinal()) goto L137;
        StringBuilder r37 = new StringBuilder();
        r37.append(r10);
        r37.append(", callUserContent = ");
        if (r20 == null) goto L135;
        Object r38 = r20.get("o_complex_call_user_content");
    L136:
        r37.append(r38);
        r11.i("ComplexTaskManager", r37.toString());
        goto L137
    L135:
        r38 = null;
        goto L136
    L76:
        r19 = null;
        goto L77
    L68:
        r17 = null;
        goto L69
    L64:
        r16 = null;
        goto L65
    L60:
        r9 = null;
        goto L61
    L56:
        r8 = null;
        goto L57
    L24:
        if (r14.getState() != DMConstData.DMComplexTaskState.CallUser.ordinal()) goto L26;
    L27:
        long r39 = System.currentTimeMillis();
        if ((r39 - ComplexTaskManager.c) < 2000) goto L53;
        ComplexTaskManager.c = r39;
        AppHost.Companion r40 = AppHost.a;
        Object r41 = r40.getApplication().getSystemService(LynxResourceModule.AUDIO_TYPE);
        if ((r41 instanceof AudioManager) == false) goto L33;
        AudioManager r42 = (AudioManager) r41;
    L35:
        if (r42 == null) goto L37;
        int r43 = r42.getRingerMode();
    L38:
        if (r43 != 2) goto L40;
        SoundEffectHelper.INSTANCE.playCallUserClarifyNotify();
    L40:
        if (r43 == 1) goto L43;
        if (r43 != 2) goto L53;
    L43:
        Object r44 = r40.getApplication().getSystemService("vibrator");
        if ((r44 instanceof Vibrator) == false) goto L46;
        Vibrator r45 = (Vibrator) r44;
    L48:
        if (Build.VERSION.SDK_INT < 26) goto L51;
        if (r45 == null) goto L53;
        r45.vibrate(VibrationEffect.createWaveform(new long[]{0, 60, 80, 160}, -1));
        goto L53
    L51:
        if (r45 == null) goto L53;
        r45.vibrate(new long[]{0, 60, 80, 160}, -1);
        goto L53
    L46:
        r45 = null;
        goto L48
    L37:
        r43 = 2;
        goto L38
    L33:
        r42 = null;
        goto L35
    L26:
        if (r14.getState() != DMConstData.DMComplexTaskState.Clarify.ordinal()) goto L53;
    L17:
        if (r13.getState() != r14.getState()) goto L19;
        r4 = true;
        goto L20
    L5:
        if (r12.getTaskType() != DMConstData.DMTaskType.COMPLEX.ordinal()) goto L7;
        r2 = true;
        goto L8
    }
}
