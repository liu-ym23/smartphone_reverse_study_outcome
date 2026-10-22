package com.obric.assistant.impl;

import android.view.View;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt;
import com.obric.assistant.actionbar.statemanager.state.ObricTaskMode;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.p;
import com.obric.assistant.device.obricDeviceManagerDelegate;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.special_input.ObricSpecialInputServiceDelegate;
import com.obric.assistant.spi.audio.IObricAsrService;
import com.obric.assistant.spi.dora.IDoraWakeupService;
import com.obric.assistant.task.ObricTaskStatusManager;
import com.obric.assistant.trace.IObricTraceParam;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.obric.audio.enroll.VoiceEnrollServiceDelegate;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.b1;
import laa.j;
import laa.v;
import org.json.JSONException;
import org.json.JSONObject;
import qha.e;
import t1a.b;
import tha.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\b\u0007\u0018\u0000 V2\u00020\u0001:\u0001VB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J1\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u001e\u0010\u0016\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u001b\u0010\u0016\u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cH\u0016¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0013H\u0016J\u0018\u0010\u0016\u001a\u00020\u00072\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0018H\u0016JE\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u0006\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\u000e2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010'J \u0010(\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%H\u0016J \u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%H\u0016J\u001a\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010,\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u000eH\u0002J\n\u0010-\u001a\u0004\u0018\u00010.H\u0002J\n\u0010/\u001a\u0004\u0018\u000100H\u0002J(\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%H\u0016JG\u00103\u001a\u00020\u00072\n\b\u0002\u00104\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u00106\u001a\u0002072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u00109JS\u0010:\u001a\u00020\u00072\n\b\u0002\u00104\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u00106\u001a\u0002072\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010<J \u0010=\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%H\u0002J\u0012\u0010>\u001a\u0004\u0018\u00010\u000e2\u0006\u0010*\u001a\u00020\u000eH\u0002J\u0010\u0010?\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000eH\u0002J\u0010\u0010@\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000eH\u0002J\u0010\u0010A\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000eH\u0002J\u0012\u0010B\u001a\u0004\u0018\u00010\u000e2\u0006\u0010*\u001a\u00020\u000eH\u0002J(\u0010C\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%H\u0002J(\u0010D\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%2\u0006\u0010!\u001a\u00020\u000eH\u0002J\u0018\u0010E\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%H\u0016J \u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%H\u0016J\n\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u001a\u0010J\u001a\u00020\u00072\b\u0010K\u001a\u0004\u0018\u00010\u000e2\u0006\u0010L\u001a\u000207H\u0016J0\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020O2\b\u0010K\u001a\u0004\u0018\u00010\u000e2\u0014\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010QH\u0016J\u0012\u0010R\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010S\u001a\u00020\u000eH\u0016J\b\u0010T\u001a\u00020\u000eH\u0016J\f\u0010U\u001a\u00020%*\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/obric/assistant/impl/ObricActionBarTrackServiceImpl;", "Lcom/obric/assistant/actionbar/service/IObricActionBarTrackServiceExt;", "<init>", "()V", "isClickModeChangeButton", "", "setIsClickModeChangeButton", "", "onObricActionBarInstructionShow", "tag", "Landroid/widget/TextView;", "status", "", "displayText", "", "itemView", "Landroid/view/View;", "(Landroid/widget/TextView;Ljava/lang/Integer;Ljava/lang/String;Landroid/view/View;)V", "mapToObricActionBarTrackType", "Lcom/obric/trace/ObricActionBarTrackType;", "itemId", "mapToActionBarV2Option", "mobChatActionBarShow", "actionBarList", "", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "position", "actionBarKeyList", "", "([Ljava/lang/String;)V", "traceType", "Lcom/obric/assistant/view/actionbar/custom/ObricBaseSegment;", "mobChatActionBarClick", "clickV2Option", "customActionBarItem", "botId", "conversationId", "", "clickPosition", "(Ljava/lang/String;Lcom/obric/trace/ObricActionBarTrackType;Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Ljava/lang/String;JLjava/lang/Integer;)V", "mobObricActionBarBoardShow", "mobObricActionPanelShow", "currentActionBar", "mobObricActionBarBoardClick", "getBoardClickEnterMethod", "getConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getSpecialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "mobObricActionBarBoardLeave", "leaveMethod", "mobActionBarShow", "actionBarTemplateId", "actionBarKey", "params", "Lorg/json/JSONObject;", "actionBarTemplateType", "(Ljava/lang/Integer;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/Integer;Ljava/lang/String;)V", "mobActionBarClick", "showPosition", "(Ljava/lang/Integer;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "mobActionBarBoardShow", "getLv2BoardName", "getBoardShowKey", "getBoardLeaveKey", "getEnterMethod", "getActionPanelEnterMethod", "mobActionBarBoardLeave", "mobActionBarBoardClick", "mobObricActionBarLv3BoardShow", "mobObricActionBarLv3BoardClick", "clickV3Option", "getReferenceInfo", "Lcom/larus/im/bean/message/ReferenceInfo;", "setObricVoiceAuthenParams", "taskId", "json", "onObricVoiceAuthenAsrUpdate", "lifeState", "Lcom/larus/audio/audiov3/task/asr/AsrLifeState;", "extraMap", "", "isAssistantActionBar", "getObricMockClickActionBarKey", "getCurrentModelLevel", "atLeastLong", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricActionBarTrackServiceImpl implements IObricActionBarTrackServiceExt {
    public boolean a;

    public static final class a {
    }

    public ObricActionBarTrackServiceImpl() {
    }

    public final String c(int r2) {
        if (r2 != 2131381229) goto L6;
        return "oauto_publish_new_task";
    L6:
        if (r2 != 2131381230) goto L9;
        return "oauto_task_list";
    L9:
        if (r2 != 2131381177) goto L12;
        return "mcp_stopped";
    L12:
        if (r2 != 2131381180) goto L14;
    L20:
        return "mcp_view_task";
    L14:
        if (r2 == 2131381179) goto L20;
        if (r2 != 2131381176) goto L19;
        return "mcp_supplement";
    L19:
        return "mcp_reply";
    }

    public final void e() {
        this.a = false;
    }

    public final void k(TextView r1, Integer r2, String r3, View r4) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r4, "itemView");
    }

    public final String p() {
        return "obric_mock_click";
    }

    static {
        AppHost.a.getApplication().getString(2131911911);
    }

    public final String h() {
        ObricTaskStatusManager.a.getClass();
        return ObricTaskMode.PRO.getValue();
    }

    public final ReferenceInfo r() {
        ObricTaskStatusManager.a.getClass();
        String r1 = null;
        if (Intrinsics.areEqual(ObricTaskStatusManager.b(), "addition_complex_task") == false) goto L26;
        int r0 = p.a;
        b r2 = p.a(AppHost.a.a().getCurrentActivity());
        if (r2 == null) goto L7;
        j r3 = (j) r2.getAbility(j.class);
    L8:
        if (r3 == null) goto L14;
        b1 r4 = r3.i80();
        if (r4 == null) goto L14;
        v r5 = (v) r4.getValue();
        if (r5 == null) goto L14;
        StateInfo r6 = r5.b;
    L16:
        if (r6 == null) goto L25;
        String r7 = r6.getRefMessageId();
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Map r8 = r6.getExt();
        if (r8 == null) goto L20;
        r1 = (String) r8.get("o_reference_msg_content");
    L20:
        if (r1 != null) goto L22;
        String r9 = "";
    L23:
        FLogger.a.i("ObricActionBarTrackServiceImpl", "getReferenceInfo reMsgId is " + r7 + " and refMsgContent.len is " + r9.length());
        return new ReferenceInfo(1, r9, r7, 0, null, null, null, null, 248, null);
    L22:
        r9 = r1;
        goto L23
    L25:
        FLogger.a.i("ObricActionBarTrackServiceImpl", "getReferenceInfo refMsgContent is empty");
    L14:
        r6 = null;
        goto L16
    L7:
        r3 = null;
    L26:
        return null;
    }

    public static String v(String r1) {
        switch(r1.hashCode()) {
            case -864393189: goto L18;
            case -762642120: goto L14;
            case 631414287: goto L10;
            case 1360883263: goto L6;
            default: goto L21;
        };
    L21:
        return "click_mini_icon";
    L6:
        if (r1.equals("obric_omni") == false) goto L21;
        return "click_omni_actionbar";
    L10:
        if (r1.equals("obric_mode_change_switch_standard") == false) goto L21;
        return "click_mode_to_standard";
    L14:
        if (r1.equals("obric_oauto") == false) goto L21;
        return "click_oauto_actionbar";
    L18:
        if (r1.equals("obric_mode_change_switch_pro") == false) goto L21;
        return "click_mode_to_pro";
    }

    public final boolean a(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        ObricActionBarTrackType.Companion.getClass();
        if (ObricActionBarTrackType.a.b().contains(r3) == false) goto L8;
    L9:
        return true;
    L8:
        if (Intrinsics.areEqual(r3, "obric_phone_operation") == true) goto L9;
        return false;
    }

    public final void b(List<? extends e> r5) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("mobChatActionBarShow actionBarList = ");
        if (r5 == null) goto L5;
        String r2 = r5.toString();
    L6:
        r1.append(r2);
        r0.i("ObricActionBarTrackServiceImpl", r1.toString());
        if (r5 == null) goto L12;
        Iterator<T> r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        String r3 = ((e) r6.next()).k();
        String r4 = ObricSpecialInputServiceDelegate.b.e(r3);
        ObricActionBarTrackType.Companion.getClass();
        w(this, ObricActionBarTrackType.a.a(r4), ObricActionBarTrackType.COCO_INSTRUCTION.getStringValue(), -1, r4);
        goto L10
    L14:
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void d(String r8) {
        Intrinsics.checkNotNullParameter("obric_omni", "currentActionBar");
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r0 == null) goto L7;
        b r1 = r0.getCurrentVContext();
        if (r1 == null) goto L7;
        y r2 = (y) r1.getAbility(y.class);
    L8:
        JSONObject r3 = new JSONObject();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L52
        String r5 = "click_omni_actionbar";
        if (Intrinsics.areEqual(r8, "omni_edit_instruction") == false) goto L14;
    L22:
        r3.put("enter_method", r5);     // Catch: Throwable -> L52
        if (Intrinsics.areEqual("obric_omni", "obric_oauto") == false) goto L25;
        String r6 = "obric_omni";
    L26:
        r3.put("current_action_bar", r6);     // Catch: Throwable -> L52
        if (r2 == null) goto L30;
        String r7 = r2.getBotId();     // Catch: Throwable -> L52
        if (r7 == null) goto L30;
    L31:
        r3.put("bot_id", r7);     // Catch: Throwable -> L52
        if (r2 == null) goto L39;
        wc9.e r9 = r2.h();     // Catch: Throwable -> L52
        if (r9 == null) goto L39;
        String r10 = r9.a;     // Catch: Throwable -> L52
        if (r10 == null) goto L39;
        long r11 = CastLongProtector.parseLong(r10);     // Catch: Throwable -> L62
    L40:
        r3.put("conversation_id", r11);     // Catch: Throwable -> L52
        if (r8 == null) goto L46;
        if (r3.put("click_lv2_option", r8) == null) goto L46;
    L50:
        Object r12 = Result.constructor-impl(r3.put("obric_lv2_board_name", "omni_quick_instruction"));     // Catch: Throwable -> L52
    L54:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L58;
        FLogger.a.e("ObricActionBarTrackServiceImpl", "error in ObricActionBarTrackServiceImpl mobObricActionBarBoardClick " + r13.getLocalizedMessage());
    L58:
        if (Result.isSuccess-impl(r12) == false) goto L60;
        JSONObject r14 = (JSONObject) r12;
        FLogger.a.i("ObricActionBarTrackServiceImpl", "mobObricActionBarBoardClick params = " + r3);
    L60:
        TrackParams r15 = new TrackParams().merge(r3);
        by7.a r16 = new by7.a("obric_action_bar_lv2_board_click");
        r16.a.merge(r15);
        r16.b();
        return;
    L46:
        if (Intrinsics.areEqual("obric_omni", "obric_oauto") == false) goto L48;
        String r17 = "oauto_suggest_prompt";
    L49:
        r3.put("click_lv2_option", r17);     // Catch: Throwable -> L52
        goto L50
    L48:
        r17 = "omni_suggest_prompt";
    L39:
        r11 = 0;
    L30:
        r7 = "";
        goto L31
    L25:
        r6 = "click_omni_operate_board";
        goto L26
    L14:
        if (this.a == false) goto L20;
        if (Intrinsics.areEqual("obric_omni", "obric_omni") == false) goto L18;
        r5 = "click_mode_to_pro";
        goto L22
    L18:
        r5 = "click_mode_to_standard";
        goto L22
    L20:
        if (Intrinsics.areEqual("obric_omni", "obric_oauto") == false) goto L22;
        r5 = "click_oauto_actionbar";
    L52:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = null;
        goto L8
    }

    public final void m(String[] r8) {
        Intrinsics.checkNotNullParameter(r8, "actionBarKeyList");
        int r0 = r8.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        String r3 = r8[r1];
        int r4 = r2 + 1;
        ObricActionBarTrackType.Companion.getClass();
        w(this, ObricActionBarTrackType.a.a(r3), ObricActionBarTrackType.COCO_INSTRUCTION.getStringValue(), Integer.valueOf(r2), r3);
        r1 = r1 + 1;
        r2 = r4;
        goto L3
    }

    public final void o(ObricActionBarTrackType r4) {
        Intrinsics.checkNotNullParameter(r4, "traceType");
        int r0 = r4.getIntValue();
        String r5 = r4.getStringValue();
        String r1 = ObricActionBarTrackType.COCO_INSTRUCTION.getStringValue();
        w(this, Integer.valueOf(r0), r1, -1, r5);
    }

    public final ObricActionBarTrackType u(int r2) {
        if (r2 != 2131381150) goto L6;
        return ObricActionBarTrackType.OBRIC_AI_BEAUTIFY;
    L6:
        if (r2 != 2131381149) goto L9;
        return ObricActionBarTrackType.OBRIC_ADJUST_COPYWRITING;
    L9:
        if (r2 != 2131381279) goto L12;
        return ObricActionBarTrackType.OBRIC_WHATS_THIS;
    L12:
        if (r2 != 2131381191) goto L15;
        return ObricActionBarTrackType.OBRIC_EXTRACT_TEXT;
    L15:
        if (r2 != 2131381264) goto L18;
        return ObricActionBarTrackType.OBRIC_TEXT_TRANSLATION;
    L18:
        if (r2 != 2131381235) goto L21;
        return ObricActionBarTrackType.OBRIC_PICTURE_DYNAMIC;
    L21:
        if (r2 != 2131381236) goto L24;
        return ObricActionBarTrackType.OBRIC_PICTURE_QA;
    L24:
        if (r2 != 2131381199) goto L27;
        return ObricActionBarTrackType.OBRIC_IM_SCREEN_QA;
    L27:
        return ObricActionBarTrackType.NA;
    }

    public final void i(String r6, long r7) {
        Intrinsics.checkNotNullParameter("oauto_scheduled", "clickV3Option");
        Intrinsics.checkNotNullParameter(r6, "botId");
        JSONObject r3 = new JSONObject();
        r3.put("current_action_bar", "obric_oauto");     // Catch: JSONException -> L5
        r3.put("bot_id", r6);     // Catch: JSONException -> L5
        r3.put("conversation_id", String.valueOf(r7));     // Catch: JSONException -> L5
        r3.put("current_lv2_option", "oauto_publish_new_task");     // Catch: JSONException -> L5
        r3.put("click_lv3_option", "oauto_scheduled");     // Catch: JSONException -> L5
    L7:
        TrackParams r8 = new TrackParams().merge(r3);
        by7.a r9 = new by7.a("obric_action_bar_lv3_board_click");
        r9.a.merge(r8);
        r9.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("ObricActionBarTrackServiceImpl", "error in ObricActionBarTrackServiceImpl chatActionBarBoardShow " + e.getLocalizedMessage());
        goto L7
    }

    public final void j(List<z0> r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "actionBarList");
        Iterator<T> r8 = r6.iterator();
        int r9 = 0;
    L4:
        if (r8.hasNext() == false) goto L16;
        Object r0 = r8.next();
        int r1 = r9 + 1;
        if (r9 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        z0 r2 = (z0) r0;
        ObricActionBarTrackType.a r3 = ObricActionBarTrackType.Companion;
        String r4 = r2.b;
        String r5 = "obric_na";
        if (r4 != null) goto L11;
        r4 = "obric_na";
    L11:
        r3.getClass();
        Integer r10 = ObricActionBarTrackType.a.a(r4);
        String r11 = r2.b;
        if (r11 == null) goto L15;
        r5 = r11;
    L15:
        w(this, r10, ObricActionBarTrackType.COCO_INSTRUCTION.getStringValue(), Integer.valueOf(r9), r5);
        r9 = r1;
        goto L4
    }

    public final void l(String r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "botId");
        JSONObject r2 = new JSONObject();
        r2.put("current_action_bar", "obric_oauto");     // Catch: JSONException -> L5
        r2.put("bot_id", r5);     // Catch: JSONException -> L5
        r2.put("conversation_id", String.valueOf(r6));     // Catch: JSONException -> L5
        r2.put("current_lv2_option", "oauto_publish_new_task");     // Catch: JSONException -> L5
    L7:
        TrackParams r7 = new TrackParams().merge(r2);
        by7.a r8 = new by7.a("obric_action_bar_lv3_board_show");
        r8.a.merge(r7);
        r8.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("ObricActionBarTrackServiceImpl", "error in ObricActionBarTrackServiceImpl chatActionBarBoardShow " + e.getLocalizedMessage());
        goto L7
    }

    public final void n(String r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r12, "json");
        ISessionAuthenticationService r0 = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getSessionId();
    L6:
        ISessionAuthenticationService r3 = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
        boolean r4 = false;
        if (r3 != null) goto L9;
    L11:
        boolean r5 = false;
    L13:
        if (r11 == null) goto L39;
        if (r2 == null) goto L39;
        if (r5 == false) goto L39;
        IObricAsrService r6 = (IObricAsrService) ServiceManager.get().getService(IObricAsrService.class);
        if (r6 == null) goto L19;
        r6.l(r11, r2);
    L19:
        r12.put("enable_speaker_identify", true);
        JSONObject r13 = new JSONObject();
        String r7 = AccountService.a.getUserId();
        String r8 = obricDeviceManagerDelegate.b.getUuid();
        IDoraWakeupService r9 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r9 != null) goto L22;
    L24:
        boolean r10 = false;
    L25:
        if (r10 == false) goto L27;
        r1 = wda.b.a();
    L27:
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("btMacHashDid is null: ");
        if (r1 != null) goto L30;
        boolean r16 = true;
    L31:
        r15.append(r16);
        r14.i("ObricActionBarTrackServiceImpl", r15.toString());
        if (r1 != null) goto L34;
        String r17 = r8;
    L35:
        r13.put("engine_version", "1.0.0.100");
        r13.put("voice_print_id", r7 + '-' + r17);
        VoiceEnrollServiceDelegate r18 = VoiceEnrollServiceDelegate.c;
        if (r1 != null) goto L38;
        r1 = "";
    L38:
        r13.put("has_feature", r18.r(r1));
        r13.put("default_did", r8);
        r12.put("dora_engine_version", r13.toString());
        goto L39
    L34:
        r17 = r1;
        goto L35
    L30:
        r16 = false;
        goto L31
    L22:
        if (r9.o() != true) goto L24;
        r10 = true;
    L39:
        IBluetoothHeadSetAPI r19 = c.a();
        if (r19 != null) goto L42;
    L44:
        r12.put("enable_third_party_accessory_connection", r4);
        FLogger.a.i("ObricActionBarTrackServiceImpl", "setObricVoiceAuthenParams " + r5 + " and json is " + r12);
        return;
    L42:
        if (r19.a() != true) goto L44;
        r4 = true;
        goto L44
    L9:
        if (r3.m() != true) goto L11;
        r5 = true;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public final void g(z0 r10, String r11, long r12) {
        Intrinsics.checkNotNullParameter(r10, "customActionBarItem");
        Intrinsics.checkNotNullParameter(r11, "botId");
        String r13 = r10.b;
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        String r0 = v(r13);
        switch(r13.hashCode()) {
            case -864393189: goto L21;
            case -762642120: goto L18;
            case -761162256: goto L15;
            case 631414287: goto L12;
            case 1360883263: goto L9;
            default: goto L24;
        };
    L24:
        String r1 = "obric_action_bar_board_show";
    L26:
        if (Intrinsics.areEqual(r13, "obric_omni") == false) goto L28;
        String r6 = "omni_quick_instruction";
    L29:
        JSONObject r7 = new JSONObject();
        r7.put("enter_method", r0);     // Catch: JSONException -> L51
        switch(r13.hashCode()) {
            case -864393189: goto L44;
            case -762642120: goto L40;
            case 631414287: goto L37;
            case 1360883263: goto L34;
            default: goto L47;
        };     // Catch: JSONException -> L51
    L47:
        r7.put("current_action_bar", r13);     // Catch: JSONException -> L51
        r7.put("bot_id", r11);     // Catch: JSONException -> L51
        r7.put("conversation_id", String.valueOf(r12));     // Catch: JSONException -> L51
        if (r6 == null) goto L53;
        r7.put("obric_lv2_board_name", r6);     // Catch: JSONException -> L51
    L53:
        TrackParams r14 = new TrackParams().merge(r7);
        by7.a r15 = new by7.a(r1);
        r15.a.merge(r14);
        r15.b();
        return;
    L34:
        if (r13.equals("obric_omni") == false) goto L47;
    L46:
        r13 = "obric_omni_operate_board";
        goto L47
    L37:
        if (r13.equals("obric_mode_change_switch_standard") == false) goto L47;
    L42:
        r13 = "obric_oauto";
        goto L47
    L40:
        if (r13.equals("obric_oauto") == true) goto L42;
    L44:
        if (r13.equals("obric_mode_change_switch_pro") == true) goto L46;
    L51:
        e = move-exception;
        FLogger.a.e("ObricActionBarTrackServiceImpl", "error in ObricActionBarTrackServiceImpl chatActionBarBoardShow " + e.getLocalizedMessage());
        goto L53
    L28:
        r6 = null;
        goto L29
    L9:
        if (r13.equals("obric_omni") == false) goto L24;
    L23:
        r1 = "obric_action_bar_lv2_board_show";
        goto L26
    L12:
        if (r13.equals("obric_mode_change_switch_standard") == false) goto L24;
    L15:
        if (r13.equals("obric_phone_operation") == true) goto L23;
    L18:
        if (r13.equals("obric_oauto") == true) goto L23;
    L21:
        if (r13.equals("obric_mode_change_switch_pro") == true) goto L23;
        goto L23
    }

    public final void s(String r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "currentActionBar");
        Intrinsics.checkNotNullParameter(r5, "botId");
        if (Intrinsics.areEqual(r4, "obric_web_perception") == false) goto L6;
        String r0 = "click_web_perception_actionbar";
    L9:
        if (r0 != null) goto L11;
        return;
    L11:
        JSONObject r1 = new JSONObject();
        r1.put("enter_method", r0);     // Catch: JSONException -> L14
        r1.put("current_action_bar", r4);     // Catch: JSONException -> L14
        r1.put("bot_id", r5);     // Catch: JSONException -> L14
        r1.put("conversation_id", String.valueOf(r6));     // Catch: JSONException -> L14
    L16:
        TrackParams r7 = new TrackParams().merge(r1);
        by7.a r8 = new by7.a("obric_action_panel_show");
        r8.a.merge(r7);
        r8.b();
        return;
    L14:
        e = move-exception;
        FLogger.a.e("ObricActionBarTrackServiceImpl", "error in ObricActionBarTrackServiceImpl mobObricActionPanelShow " + e.getLocalizedMessage());
        goto L16
    L6:
        if (Intrinsics.areEqual(r4, "obric_video_perception") == false) goto L8;
        r0 = "click_video_perception_actionbar";
        goto L9
    L8:
        r0 = null;
        goto L9
    }

    public final void t(AsrLifeState r3, String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r3, "lifeState");
        if (r3 != AsrLifeState.ASR_RESULT) goto L8;
        FLogger.a.i("ObricActionBarTrackServiceImpl", "onObricVoiceAuthenAsrResult " + r4 + " and extraMap is " + r5);
        IObricChatService.a.getClass();
        IObricChatService r6 = IObricChatService.a.a();
        if (r6 == null) goto L9;
        r6.p(r4, r5);
        return;
    L9:
        return;
    }

    public final void q(String r6, z0 r7, String r8, long r9) {
        Intrinsics.checkNotNullParameter(r6, "leaveMethod");
        Intrinsics.checkNotNullParameter(r7, "customActionBarItem");
        Intrinsics.checkNotNullParameter(r8, "botId");
        String r10 = r7.b;
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        String r0 = v(r10);
        if (Intrinsics.areEqual(r10, "obric_oauto") == false) goto L8;
    L11:
        String r1 = "obric_action_bar_lv2_board_leave";
    L12:
        JSONObject r3 = new JSONObject();
        r3.put("enter_method", r0);     // Catch: JSONException -> L18
        r3.put("leave_method", r6);     // Catch: JSONException -> L18
        if (Intrinsics.areEqual(r10, "obric_omni") == false) goto L16;
        r10 = "obric_omni_operate_board";
    L16:
        r3.put("current_action_bar", r10);     // Catch: JSONException -> L18
        r3.put("bot_id", r8);     // Catch: JSONException -> L18
        r3.put("conversation_id", String.valueOf(r9));     // Catch: JSONException -> L18
    L20:
        TrackParams r11 = new TrackParams().merge(r3);
        by7.a r12 = new by7.a(r1);
        r12.a.merge(r11);
        r12.b();
        return;
    L18:
        e = move-exception;
        FLogger.a.e("ObricActionBarTrackServiceImpl", "error in ObricActionBarTrackServiceImpl chatActionBarBoardShow " + e.getLocalizedMessage());
        goto L20
    L8:
        if (Intrinsics.areEqual(r10, "obric_omni") == true) goto L11;
        r1 = "obric_action_bar_board_leave";
        goto L12
    }

    public static void w(ObricActionBarTrackServiceImpl r2, Integer r3, String r4, Integer r5, String r6) {
        JSONObject r0 = new JSONObject();
        r2.getClass();
    L27:
        e = move-exception;
        FLogger.a.e("ObricActionBarTrackServiceImpl", "error in ObricActionBarTrackServiceImpl chatActionBarShow " + e.getLocalizedMessage());
    L29:
        TrackParams r7 = new TrackParams().merge(r0);
        by7.a r8 = new by7.a("chat_action_bar_show");
        r8.a.merge(r7);
        r8.b();
        return;
    L4:
        if (Intrinsics.areEqual(r4, "coco_message_history") == false) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r4, "coco_bot_like") == true) goto L34;
        if (r3 == null) goto L11;
        r0.put("template_name", r3.intValue());     // Catch: JSONException -> L27
        r0.put("action_bar_template_id", r3.intValue());     // Catch: JSONException -> L27
    L11:
        if (r6 == null) goto L19;
        r0.put("template_type", r6);     // Catch: JSONException -> L27
        r0.put("action_bar_template_type", r6);     // Catch: JSONException -> L27
        r0.put("is_from_obric_action_bar", r6);     // Catch: JSONException -> L27
        if (Intrinsics.areEqual(r6, "obric_oauto") == false) goto L17;
        r0.put("obric_action_bar_status", ObricSpecialInputServiceDelegate.b.f());     // Catch: JSONException -> L27
    L17:
        if (Intrinsics.areEqual(r6, "obric_omni") == false) goto L19;
        r0.put("obric_action_bar_status", ObricSpecialInputServiceDelegate.b.f());     // Catch: JSONException -> L27
    L19:
        if (r4 == null) goto L21;
        r0.put("action_name", r4);     // Catch: JSONException -> L27
        r0.put("action_bar_key", r4);     // Catch: JSONException -> L27
    L21:
        if (r5 == null) goto L23;
        r0.put("show_position", r5.intValue());     // Catch: JSONException -> L27
    L23:
        IObricTraceParam r9 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);     // Catch: JSONException -> L27
        if (r9 == null) goto L29;
        r9.o(r0);     // Catch: JSONException -> L27
        goto L29
    }

    public final void f(String r3, ObricActionBarTrackType r4, z0 r5, String r6, long r7, Integer r9) {
        Intrinsics.checkNotNullParameter(r5, "customActionBarItem");
        if (r3 == null) goto L18;
        String r8 = r5.b;
        if (r8 != null) goto L7;
        r8 = "";
    L7:
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        String r10 = v(r8);
        JSONObject r11 = new JSONObject();
        r11.put("enter_method", r10);     // Catch: JSONException -> L15
        if (Intrinsics.areEqual(r8, "obric_omni") == false) goto L13;
        r8 = "obric_omni_operate_board";
    L13:
        r11.put("current_action_bar", r8);     // Catch: JSONException -> L15
        r11.put("bot_id", r6);     // Catch: JSONException -> L15
        r11.put("conversation_id", String.valueOf(r7));     // Catch: JSONException -> L15
        r11.put("click_lv2_option", r3);     // Catch: JSONException -> L15
    L17:
        TrackParams r12 = new TrackParams().merge(r11);
        by7.a r13 = new by7.a("obric_action_bar_lv2_board_click");
        r13.a.merge(r12);
        r13.b();
        return;
    L15:
        e = move-exception;
        FLogger.a.e("ObricActionBarTrackServiceImpl", "error in ObricActionBarTrackServiceImpl chatActionBarBoardShow " + e.getLocalizedMessage());
        goto L17
    L18:
        if (r4 != null) goto L20;
        return;
    L20:
        if (r4 == ObricActionBarTrackType.NA) goto L46;
        Integer r14 = Integer.valueOf(r4.getIntValue());
        String r15 = ObricActionBarTrackType.COCO_INSTRUCTION.getStringValue();
        String r16 = r4.getStringValue();
        Integer r17 = -1;
        JSONObject r18 = new JSONObject();
    L36:
        e = move-exception;
        FLogger.a.e("ObricActionBarTrackServiceImpl", "error in ObricActionBarTrackServiceImpl chatActionBarClick " + e.getLocalizedMessage());
    L38:
        TrackParams r19 = new TrackParams().merge(r18);
        by7.a r20 = new by7.a("chat_action_bar_click");
        r20.a.merge(r19);
        r20.b();
        return;
    L23:
        if (Intrinsics.areEqual(r15, "coco_message_history") == true) goto L47;
        if (r14 == null) goto L27;
        r18.put("template_name", r14.intValue());     // Catch: JSONException -> L36
        r18.put("action_bar_template_id", r14.intValue());     // Catch: JSONException -> L36
    L27:
        if (r15 == null) goto L29;
        r18.put("action_name", r15);     // Catch: JSONException -> L36
        r18.put("action_bar_key", r15);     // Catch: JSONException -> L36
    L29:
        if (r16 == null) goto L31;
        r18.put("template_type", r16);     // Catch: JSONException -> L36
        r18.put("action_bar_template_type", r16);     // Catch: JSONException -> L36
        r18.put("is_from_obric_action_bar", r16);     // Catch: JSONException -> L36
    L31:
        if (r17 == null) goto L33;
        r18.put("show_position", r17.intValue());     // Catch: JSONException -> L36
    L33:
        if (r9 == null) goto L38;
        r18.put("click_position", r9.intValue());     // Catch: JSONException -> L36
        goto L38
    L47:
        return;
    }
}
