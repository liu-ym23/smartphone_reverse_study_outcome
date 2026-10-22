package com.obric.assistant.special_input.util;

import com.larus.applog.api.IApplog;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SpecialTrackEventUtilsKt {
    public static final CoroutineScope a = null;

    static {
        a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static void c() {
        Intrinsics.checkNotNullParameter("omni_actionbar_secondary_panel", "bannerPosition");
        JSONObject r0 = new JSONObject();
        r0.put("banner_position", "omni_actionbar_secondary_panel");
        FLogger.a.i("SpecialTrackEventUtils", "reportAddIconBannerShow: bannerPosition=omni_actionbar_secondary_panel");
        BuildersKt.launch$default(a, null, null, new SpecialTrackEventUtilsKt$reportAddIconBannerShow$1(r0, null), 3, null);
    }

    public static void d() {
        Intrinsics.checkNotNullParameter("confirm_add", "itemName");
        Intrinsics.checkNotNullParameter("omni_actionbar_secondary_panel", "source");
        JSONObject r3 = new JSONObject();
        r3.put("item_name", "confirm_add");
        r3.put("source", "omni_actionbar_secondary_panel");
        FLogger.a.i("SpecialTrackEventUtils", "reportAddIconCardItemClick: itemName=confirm_add, source=omni_actionbar_secondary_panel");
        BuildersKt.launch$default(a, null, null, new SpecialTrackEventUtilsKt$reportAddIconCardItemClick$1(r3, null), 3, null);
    }

    public static void b(String r9) {
        Intrinsics.checkNotNullParameter(r9, "clickItem");
        Intrinsics.checkNotNullParameter("omni_actionbar_secondary_panel", "bannerPosition");
        JSONObject r0 = new JSONObject();
        r0.put("banner_position", "omni_actionbar_secondary_panel");
        r0.put("click_item", r9);
        FLogger.a.i("SpecialTrackEventUtils", "reportAddIconBannerClick: bannerPosition=omni_actionbar_secondary_panel, clickItem=" + r9);
        BuildersKt.launch$default(a, null, null, new SpecialTrackEventUtilsKt$reportAddIconBannerClick$1(r0, null), 3, null);
    }

    public static final void e(DMTaskState r9, StateInfo r10) {
        if (r10 == null) goto L6;
        String r1 = r10.getRefMessageId();
        if (r1 == null) goto L6;
    L13:
        if (r9 == null) goto L22;
        Map r2 = r9.getExtra();
        if (r2 == null) goto L22;
        DMTaskInfo r11 = r9.getTaskInfo();
        if (r11 == null) goto L20;
        Map r12 = r11.getExt();
        if (r12 == null) goto L20;
    L21:
        Map r13 = MapsKt.plus(r2, r12);
    L23:
        if (r10 == null) goto L25;
        Map r14 = r10.getExt();
    L26:
        JSONObject r15 = a(r1, r13, r14);
        String r16 = r15.optString("instruction_id");
        String r3 = r15.optString("doubao_message_id");
        FLogger.a.i("SpecialTrackEventUtils", "reportClarifyEvent: instructionId=" + r16 + ", doubaoMessageId=" + r3 + ", params=" + r15);
        BuildersKt.launch$default(a, null, null, new SpecialTrackEventUtilsKt$reportClarifyEvent$1(r15, null), 3, null);
        return;
    L25:
        r14 = null;
    L20:
        r12 = MapsKt.emptyMap();
    L22:
        r13 = null;
    L6:
        if (r9 == null) goto L12;
        DMTaskInfo r4 = r9.getTaskInfo();
        if (r4 == null) goto L12;
        IMMessage r5 = r4.getMessage();
        if (r5 == null) goto L12;
        r1 = r5.getMessageId();
    L12:
        r1 = null;
        goto L13
    }

    public static final void f(DMTaskState r6, StateInfo r7) {
        BuildersKt.launch$default(a, null, null, new SpecialTrackEventUtilsKt$reportUserAdditionEvent$1(r7, r6, null), 3, null);
    }

    public static final void g(DMTaskState r11, String r12) {
        Map r0 = r11.getExtra();
        DMTaskInfo r1 = r11.getTaskInfo();
        if (r1 == null) goto L5;
        Map r2 = r1.getExt();
    L6:
        DMTaskInfo r3 = r11.getTaskInfo();
        if (r3 == null) goto L11;
        IMMessage r4 = r3.getMessage();
        if (r4 == null) goto L11;
        String r5 = r4.getMessageId();
    L12:
        if (r2 == null) goto L14;
        String r6 = (String) r2.get("o_omni_task_id");
    L15:
        DMTaskInfo r13 = r11.getTaskInfo();
        if (r13 == null) goto L22;
        IMMessage r14 = r13.getMessage();
        if (r14 == null) goto L22;
        Map r15 = r14.getExt();
        if (r15 == null) goto L22;
        String r16 = (String) r15.get("o_omni_instruction_type");
    L23:
        JSONObject r7 = new JSONObject();
        r7.put("source_from", r12);
        r7.put("instruction_type", r16);
        if (r0 == null) goto L26;
        String r17 = (String) r0.get("log_id");
    L27:
        r7.put("log_id", r17);
        r7.put("instruction_id", r6);
        r7.put("doubao_message_id", r5);
        r7.put("device_id", IApplog.a.getDeviceId());
        String r18 = r7.optString("instruction_id");
        String r19 = r7.optString("doubao_message_id");
        FLogger.a.i("SpecialTrackEventUtils", "reportUserStopClickEvent: sourceFrom=" + r7.optString("source_from") + ", instructionId=" + r18 + ", doubaoMessageId=" + r19 + ", params=" + r7);
        BuildersKt.launch$default(a, null, null, new SpecialTrackEventUtilsKt$reportUserStopClickEvent$1(r7, null), 3, null);
        return;
    L26:
        r17 = null;
    L22:
        r16 = null;
        goto L23
    L14:
        r6 = null;
    L11:
        r5 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public static final JSONObject a(String r4, Map<String, String> r5, Map<String, String> r6) {
        JSONObject r0 = new JSONObject();
        if (r6 == null) goto L6;
        String r2 = r6.get("source_from");
        if (r2 == null) goto L6;
    L7:
        r0.put("source_from", r2);
        String r3 = null;
        if (r6 == null) goto L11;
        String r7 = r6.get("instruction_type");
        if (r7 == null) goto L11;
    L14:
        r0.put("instruction_type", r7);
        if (r6 == null) goto L17;
        String r8 = r6.get("log_id");
    L18:
        r0.put("log_id", r8);
        if (r6 == null) goto L21;
        String r1 = r6.get("tool_id");
    L22:
        r0.put("current_tool_id", r1);
        if (r6 == null) goto L25;
        String r9 = r6.get("tool_name");
    L26:
        r0.put("current_tool_name", r9);
        if (r6 == null) goto L29;
        String r10 = r6.get("action_button_type");
    L30:
        r0.put("action_button_type", r10);
        if (r6 == null) goto L33;
        String r11 = r6.get("enter_from");
    L34:
        r0.put("enter_from", r11);
        if (r6 == null) goto L37;
        String r12 = r6.get("action_type");
    L38:
        r0.put("action_type", r12);
        r0.put("device_id", IApplog.a.getDeviceId());
        r0.put("doubao_message_id", r4);
        if (r5 == null) goto L44;
        String r13 = r5.get("o_omni_task_id");
        if (r13 == null) goto L44;
        r3 = r13;
    L46:
        r0.put("instruction_id", r3);
        return r0;
    L44:
        if (r6 == null) goto L46;
        r3 = r6.get("o_omni_task_id");
        goto L46
    L37:
        r12 = null;
        goto L38
    L33:
        r11 = null;
        goto L34
    L29:
        r10 = null;
        goto L30
    L25:
        r9 = null;
        goto L26
    L21:
        r1 = null;
        goto L22
    L17:
        r8 = null;
    L11:
        if (r6 == null) goto L13;
        r7 = r6.get("o_omni_instruction_type");
        goto L14
    L13:
        r7 = null;
    L6:
        r2 = "dynamic_island";
        goto L7
    }

    public static final void h(String r4, String r5, String r6, String r7) {
        JSONObject r0 = new JSONObject();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.put("source_from", r4);
        r0.put("instruction_type", r5);
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r0.put("instruction_id", r6);
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        r0.put("doubao_message_id", r7);
        IApplog.Companion r8 = IApplog.a;
        r0.put("device_id", r8.getDeviceId());
        FLogger.a.i("SpecialTrackEventUtils", "reportUserStopClickEventWithParams: sourceFrom=" + r0.optString("source_from") + ", instructionId=" + r0.optString("instruction_id") + ", doubaoMessageId=" + r0.optString("doubao_message_id") + ", params=" + r0);
        r8.reportEvent("obric_omni_user_stop_click", r0);
    }
}
