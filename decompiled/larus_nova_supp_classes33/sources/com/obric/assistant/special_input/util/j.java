package com.obric.assistant.special_input.util;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.special_input.ObricComplexTaskPanelType;
import com.obric.assistant.task.ObricTaskStatusManager;
import com.obric.assistant.utils.l;
import com.obric.assistant.voice.ContentScene;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j {
    public static final boolean a(StateInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3 != null) goto L5;
        boolean r1 = false;
    L6:
        if (r1 == false) goto L15;
        Map r4 = r3.getExt();
        if (r4 == null) goto L10;
        String r5 = (String) r4.get("o_complex_call_for_me_directly");
    L12:
        if (Intrinsics.areEqual(r5, "1") == false) goto L16;
        return true;
    L16:
        return false;
    L10:
        r5 = null;
        goto L12
    L15:
        return false;
    L5:
        r1 = Intrinsics.areEqual(r3.getTaskType(), "complex_task");
        goto L6
    }

    public static final StateInfo b(int r6, boolean r7, Map<String, String> r8, String r9, DMTaskState r10) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("mockComplexTaskStateInfo: requestType = ");
        r1.append(r6);
        r1.append(", taskState = ");
        String r2 = null;
        if (r10 == null) goto L5;
        String r3 = l.g(r10);
    L6:
        r1.append(r3);
        r0.i("SpecialInputMsgEx", r1.toString());
        if (r8 == null) goto L10;
        Map r11 = MapsKt.toMutableMap(r8);
        if (r11 == null) goto L10;
    L11:
        if (r10 == null) goto L15;
        DMTaskInfo r4 = r10.getTaskInfo();
        if (r4 == null) goto L15;
        IMMessage r5 = r4.getMessage();
    L16:
        if (r5 == null) goto L23;
        Map r12 = r5.getExt();
        if (r12 == null) goto L20;
        String r13 = (String) r12.get("inner_log_id");
    L21:
        if (r13 == null) goto L23;
        r11.put("log_id", r13);
        goto L23
    L20:
        r13 = null;
    L23:
        if (r5 == null) goto L30;
        Map r14 = r5.getExt();
        if (r14 == null) goto L27;
        String r15 = (String) r14.get("o_omni_instruction_type");
    L28:
        if (r15 == null) goto L30;
        r11.put("instruction_type", r15);
        goto L30
    L27:
        r15 = null;
    L30:
        if (r5 == null) goto L37;
        Map r16 = r5.getExt();
        if (r16 == null) goto L34;
        String r17 = (String) r16.get("o_task_type");
    L35:
        if (r17 == null) goto L37;
        r11.put("task_type", r17);
        goto L37
    L34:
        r17 = null;
    L37:
        boolean r18 = true;
        if (r9 != null) goto L40;
    L43:
        boolean r19 = true;
    L44:
        if (r19 == false) goto L53;
        if (r10 == null) goto L51;
        DMTaskInfo r20 = r10.getTaskInfo();
        if (r20 == null) goto L51;
        IMMessage r21 = r20.getMessage();
        if (r21 == null) goto L51;
        r9 = r21.getMessageId();
    L51:
        r9 = null;
    L53:
        if (r6 != ObricComplexTaskPanelType.CLARIFYING.getValue()) goto L68;
        Set<String> r22 = l.a;
        if (r10 == null) goto L59;
        Map r110 = r10.getExtra();
        if (r110 == null) goto L59;
        r2 = (String) r110.get("clarify_message_content");
    L59:
        if (r2 != null) goto L62;
        r2 = "";
    L62:
        if (r2.length() == 0) goto L65;
        r18 = false;
    L65:
        if (r18 == false) goto L68;
        r0.w("SpecialInputMsgEx", "mockComplexTaskStateInfo: clarify is empty");
    L68:
        return e(r6, r2, r9, r7, r11);
    L40:
        if (r9.length() == 0) goto L43;
        r19 = false;
    L15:
        r5 = null;
    L10:
        r11 = new LinkedHashMap();
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    public static StateInfo e(int r11, String r12, String r13, boolean r14, Map r15) {
        return new StateInfo(r11, r12, r13, "complex_task", 0, false, r14, r15);
    }

    public static StateInfo c(int r2, boolean r3, String r4, String r5, Map r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r3 = true;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r7 & 8) == 0) goto L12;
        r5 = null;
    L12:
        if ((r7 & 16) == 0) goto L14;
        ContentScene r0 = ContentScene.UNKNOWN;
    L16:
        if ((r7 & 32) == 0) goto L18;
        r6 = null;
    L18:
        Intrinsics.checkNotNullParameter(r0, "contentScene");
        return e(r2, r4, r5, r3, r6);
    L14:
        r0 = null;
        goto L16
    }

    public static StateInfo d(int r3, boolean r4, Map r5, String r6, DMTaskState r7, int r8) {
        boolean r1 = true;
        if ((r8 & 2) == 0) goto L6;
        r4 = true;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r8 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r8 & 16) == 0) goto L27;
        if (r3 != 1) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == false) goto L19;
    L25:
        ObricTaskStatusManager.a.getClass();
        r7 = ObricTaskStatusManager.c();
        goto L27
    L19:
        if (r3 == 2) goto L22;
        r1 = false;
    L22:
        if (r1 == true) goto L25;
        r7 = null;
        goto L27
    L16:
        r9 = false;
    L27:
        return b(r3, r4, r5, r6, r7);
    }
}
