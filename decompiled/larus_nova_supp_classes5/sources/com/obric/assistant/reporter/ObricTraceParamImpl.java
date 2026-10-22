package com.obric.assistant.reporter;

import bda.b;
import com.larus.dora.api.DoraConfig;
import com.larus.home.impl.sdk.s;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.impl.MessageApiImpl;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;
import com.obric.assistant.reporter.utils.g;
import com.obric.assistant.special_input.ObricSpecialInputServiceDelegate;
import com.obric.assistant.spi.task.ObricTaskSkillDelegate;
import com.obric.assistant.state.api.multitask.ObricInteractionProjectionDelegate;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import com.obric.assistant.trace.IObricTraceParam;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\rJ\u001a\u0010\u000f\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\rJ\u001a\u0010\u0010\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\rJ\u001a\u0010\u0011\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\rJ\u001a\u0010\u0012\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0006\u0010\u0013\u001a\u00020\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001c\u0010\u001d\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\bH\u0002J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\bH\u0002J\u0018\u0010#\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\bH\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\bH\u0002J\b\u0010&\u001a\u00020\bH\u0002J\u0018\u0010'\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\bH\u0002J\u0018\u0010(\u001a\u00020%2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\bH\u0002J\b\u0010)\u001a\u00020\u0005H\u0002J\u0010\u0010*\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010+\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\"\u0010,\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010-\u001a\u0004\u0018\u00010\b2\u0006\u0010!\u001a\u00020\bH\u0016J\u0018\u0010.\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\bH\u0016J\u0010\u0010/\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u00100\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u00101\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u00102\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u00103\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u00104\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J.\u00105\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u00106\u001a\u0004\u0018\u00010\b2\b\u00107\u001a\u0004\u0018\u00010\b2\b\u00108\u001a\u0004\u0018\u00010\bH\u0016J.\u00109\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u00106\u001a\u0004\u0018\u00010\b2\b\u0010:\u001a\u0004\u0018\u00010\b2\b\u00108\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/obric/assistant/reporter/ObricTraceParamImpl;", "Lcom/obric/assistant/trace/IObricTraceParam;", "<init>", "()V", "chatWindowHeight", "", "clickTalkSourceType", "imSpeakConversationMode", "", "initSendMessageExtTrace", "", "putWindowModePara", "paramsMap", "", "", "putPositionLevelPara", "putWakeUpData", "putBluetoothData", "putBizDoraSceneData", "getWindowMode", "currentInteractionType", "Lcom/obric/assistant/state/api/multitask/state/ObricInteractionType;", "setWindowHeight", "height", "setClickTalkSourceType", "sourceType", "setImSpeakConversationMode", "mode", "getWindowHeight", "putLaunchPara", "params", "Lorg/json/JSONObject;", "putActionBarSendEventPara", "eventName", "putAutoMicSendEventPara", "putClickTalkConversationMode", "shouldPutClickTalkConversationMode", "", "getConversationMode", "putImSpeakConversationMode", "shouldPutImSpeakConversationMode", "getActionBarShowPosition", "putLaunchEventForMiddlePlatformPara", "putLaunchEventForClientPara", "putSendEventPara", "actionBarKey", "putReceiveEventPara", "putInputFunctionSwitchPara", "putActionBarEventPara", "putActionBarOptionEventPara", "putWindowTracePara", "putClickEventPara", "putClickTalkEventPara", "putEnterPageEventPara", "currentPage", "previousPage", "enterFrom", "putClickPageEventPara", "actionType", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTraceParamImpl implements IObricTraceParam {
    public int b;
    public volatile int c;
    public volatile String d;

    public static final class c implements b {
        public final /* synthetic */ ObricTraceParamImpl a;

        public final String getScene() {
            return "ObricTraceApiImpl";
        }

        public c(ObricTraceParamImpl r1) {
            this.a = r1;
        }

        public final Map<String, String> getExt(Map<String, String> r13, b.a r14) {
            Intrinsics.checkNotNullParameter(r13, "originExt");
            LinkedHashMap r15 = new LinkedHashMap();
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r15, "paramsMap");
            IObricReporter.a.getClass();
            IObricReporter r0 = IObricReporter.a.a();
            if (r0 == null) goto L7;
            String r1 = r0.a();
            if (r1 == null) goto L7;
            r15.put("obric_launch_method", r1);
        L7:
            IObricReporter r2 = IObricReporter.a.a();
            if (r2 == null) goto L12;
            String r3 = r2.l();
            if (r3 == null) goto L12;
            r15.put("obric_launch_service", r3);
        L12:
            IObricReporter r4 = IObricReporter.a.a();
            if (r4 == null) goto L17;
            String r5 = r4.getWakeupSource();
            if (r5 == null) goto L17;
            r15.put("obric_launch_wakeup", r5);
        L17:
            Intrinsics.checkNotNullParameter(r15, "paramsMap");
            int r6 = g.a;
            if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L20;
            String r7 = "lock_screen";
        L21:
            r15.put("obric_message_position_level1", r7);
            String r8 = IAssistantInteractionServiceKt.getInteractionStateService().getWakeUpAppPkg();
            if (r8 == null) goto L24;
            r15.put("obric_message_position_level2", r8);
        L24:
            Intrinsics.checkNotNullParameter(r15, "paramsMap");
            r15.put("obric_window_mode", ObricTraceParamImpl.p());
            Intrinsics.checkNotNullParameter(r15, "paramsMap");
            IInteractionStateService r9 = IAssistantInteractionServiceKt.getInteractionStateService();
            IObricTraceParam.a.getClass();
            boolean r10 = false;
            String r11 = (String) r9.getWakeUpData(0);
            if (r11 == null) goto L27;
            r15.put("obric_automic_type", r11);
        L27:
            Intrinsics.checkNotNullParameter(r15, "paramsMap");
            IBluetoothHeadSetAPI r12 = tha.c.a();
            if (r12 != null) goto L30;
        L32:
            boolean r16 = false;
        L33:
            String r17 = IAssistantInteractionServiceKt.getInteractionStateService().getWakeUpSource();
            ObricInteractionProjectionDelegate r18 = ObricInteractionProjectionDelegate.b;
            ObricInteractionType r19 = r18.a(DoraConfig.g()).c;
            if (Intrinsics.areEqual(r17, IInteractionStateService.WAKE_UP_SOURCE_BLUETOOTH) == true) goto L40;
            if (Intrinsics.areEqual(r17, IInteractionStateService.WAKE_UP_SOURCE_DORA_VOICE_WAKEUP) == true) goto L40;
            if (Intrinsics.areEqual(r17, IInteractionStateService.WAKE_UP_SOURCE_DORA_KEY_UP) == true) goto L40;
        L44:
            boolean r20 = false;
        L46:
            FLogger r21 = FLogger.a;
            r21.d("ObricTraceApiImpl", "putBluetoothData isConnect? " + r16 + ", wakeupSource = " + r17 + ", assistantMode = " + r19);
            String r22 = "";
            if (r16 == false) goto L59;
            if (r20 == false) goto L59;
            IBluetoothHeadSetAPI r23 = tha.c.a();
            if (r23 == null) goto L53;
            String r24 = r23.r();
            if (r24 == null) goto L53;
        L55:
            if (r24.length() <= 0) goto L57;
            r10 = true;
        L57:
            if (r10 == false) goto L59;
            r15.put("obric_bluetooth_encrypted_id", r24);
        L53:
            r24 = "";
        L59:
            Intrinsics.checkNotNullParameter(r15, "paramsMap");
            String r110 = IAssistantInteractionServiceKt.getInteractionStateService().getWakeUpSource();
            ObricInteractionType r25 = r18.a(DoraConfig.g()).c;
            r21.i("ObricTraceApiImpl", "putBizDoraSceneData: wakeupSource = " + r110 + ", assistantMode = " + r25);
            if (r25 != ObricInteractionType.AutoHalfDuplex) goto L62;
        L64:
            String r26 = null;
            if (Intrinsics.areEqual(r110, IInteractionStateService.WAKE_UP_SOURCE_DORA_VOICE_WAKEUP) == false) goto L76;
            IFlowSdkDepend r111 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r111 == null) goto L71;
            s r112 = r111.s0();
            if (r112 == null) goto L71;
            r26 = r112.y();
        L71:
            if (r26 == null) goto L74;
            r22 = r26;
        L74:
            r15.put("dora_sn", r22);
            r15.put("dora_scene", "obric_dora_call");
            r15.put("biz_input_scene", "obric_dora_call");
            r15.put("app_key", "QwsgN3QXFsz4ttIT");
        L86:
            ArrayList r113 = new ArrayList(r15.size());
            Iterator r114 = r15.entrySet().iterator();
        L88:
            if (r114.hasNext() == false) goto L91;
            Map.Entry r27 = (Map.Entry) r114.next();
            r113.add(TuplesKt.to((String) r27.getKey(), r27.getValue().toString()));
            goto L88
        L91:
            return MapsKt.toMap(r113);
        L76:
            if (Intrinsics.areEqual(r110, IInteractionStateService.WAKE_UP_SOURCE_DORA_KEY_UP) == false) goto L86;
            IFlowSdkDepend r115 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r115 == null) goto L82;
            s r116 = r115.s0();
            if (r116 == null) goto L82;
            r26 = r116.y();
        L82:
            if (r26 == null) goto L85;
            r22 = r26;
        L85:
            r15.put("dora_sn", r22);
            r15.put("dora_scene", "obric_dora_radio");
            r15.put("biz_input_scene", "obric_dora_radio");
            r15.put("app_key", "QwsgN3QXFsz4ttIT");
            goto L86
        L62:
            if (r25 == ObricInteractionType.ManualHalfDuplex) goto L64;
        L40:
            if (r19 != ObricInteractionType.AutoHalfDuplex) goto L42;
        L45:
            r20 = true;
            goto L46
        L42:
            if (r19 != ObricInteractionType.ManualHalfDuplex) goto L44;
        L30:
            if (r12.a() != true) goto L32;
            r16 = true;
            goto L33
        L20:
            r7 = "unlocked_screen";
            goto L21
        }
    }

    static {
    }

    @Override // com.obric.assistant.trace.IObricTraceParam
    public final void j() {
        String r1 = "physical_button_longpress";
        Intrinsics.checkNotNullParameter("physical_button_longpress", "mode");
        FLogger.a.i("ObricTraceApiImpl", "setImSpeakConversationMode mode=physical_button_longpress");
        if (Intrinsics.areEqual("physical_button_longpress", "physical_button_longpress") == true) goto L6;
        r1 = "bottom_bar";
    L6:
        this.d = r1;
    }

    @Override // com.obric.assistant.trace.IObricTraceParam
    public final void m() {
        IObricChatService.a.getClass();
        IObricChatService r0 = IObricChatService.a.a();
        if (r0 == null) goto L6;
        r0.g();
        MessageApiImpl.a.g(new c(this));
        return;
    }

    public ObricTraceParamImpl() {
        this.c = -1;
        this.d = "bottom_bar";
    }

    public static String p() {
        AssistantActivityExpandState r0 = IAssistantInteractionServiceKt.getInteractionStateService().getInteractionActivityExpandState();
        int r1 = b.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        return "full_screen";
    L5:
        if (r1 != 2) goto L7;
        return "global_quad_screen";
    L7:
        if (r1 != 3) goto L9;
    L11:
        return "global_small_window";
    L9:
        if (r1 == 4) goto L11;
        return "unknown";
    }

    @Override // com.obric.assistant.trace.IObricTraceParam
    public final void e(JSONObject r8) {
        Intrinsics.checkNotNullParameter(r8, "params");
        String r1 = r8.optString("mode_id");
        String r3 = r8.optString("to_status");
        ObricTaskSkillDelegate r4 = ObricTaskSkillDelegate.b;
        if (r4.d(r1) == false) goto L6;
        r8.put("to_status", "obric_" + r1);
        r8.put("mode_id", "obric_" + r1);
        return;
    L6:
        if (r4.d(r3) == false) goto L10;
        r8.put("to_status", "obric_" + r3);
        return;
    }

    @Override // com.obric.assistant.trace.IObricTraceParam
    public final void f(int r4) {
        FLogger.a.i("ObricTraceApiImpl", "setClickTalkSourceType sourceType=" + r4);
        this.c = r4;
    }

    @Override // com.obric.assistant.trace.IObricTraceParam
    public final void g(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        r3.put("obric_window_height", this.b);
        r3.put("obric_window_mode", p());
    }

    @Override // com.obric.assistant.trace.IObricTraceParam
    public final void h(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        r3.put("obric_window_height", this.b);
        r3.put("obric_window_mode", p());
    }

    @Override // com.obric.assistant.trace.IObricTraceParam
    public final void i(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        r3.put("obric_window_height", this.b);
        r3.put("obric_window_mode", p());
    }

    @Override // com.obric.assistant.trace.IObricTraceParam
    public final void k(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        r3.put("obric_window_height", this.b);
        r3.put("obric_window_mode", p());
    }

    @Override // com.obric.assistant.trace.IObricTraceParam
    public final void l(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        int r0 = g.a;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r1 = r5.optString("action_bar_key", "");
        ObricActionBarTrackType.Companion.getClass();
        if (ObricActionBarTrackType.a.b().contains(r1) == false) goto L5;
    L6:
        ObricSpecialInputServiceDelegate r2 = ObricSpecialInputServiceDelegate.b;
        String r3 = r2.e(r1);
        r5.put("is_from_obric_action_bar", r3);
        r5.put("action_bar_key", ObricActionBarTrackType.COCO_INSTRUCTION.getStringValue());
        r5.put("show_position", -1);
        r5.put("action_bar_template_id", ObricActionBarTrackType.a.a(r3));
        r5.put("action_bar_template_type", r3);
        if (Intrinsics.areEqual(r3, "obric_oauto") == false) goto L10;
        r5.put("obric_action_bar_status", r2.f());
    L10:
        if (Intrinsics.areEqual(r3, "obric_omni") == false) goto L14;
        r5.put("obric_action_bar_status", r2.f());
        return;
    L14:
        return;
    L5:
        if (Intrinsics.areEqual(r1, "obric_phone_operation") == true) goto L6;
    }

    @Override // com.obric.assistant.trace.IObricTraceParam
    public final void n(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        r3.put("obric_window_mode", p());
    }

    @Override // com.obric.assistant.trace.IObricTraceParam
    public final void o(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        r3.put("obric_window_height", this.b);
        r3.put("obric_window_mode", p());
    }

    @Override // com.obric.assistant.trace.IObricTraceParam
    public final void setWindowHeight(int r1) {
        this.b = r1;
    }

    @Override // com.obric.assistant.trace.IObricTraceParam
    public final void c(JSONObject r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "eventName");
        r8.put("obric_window_height", this.b);
        r8.put("obric_window_mode", p());
        int r0 = g.a;
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L5;
        Object r1 = "lock_screen";
    L6:
        r8.put("obric_message_position_level1", r1);
        r8.put("obric_message_position_level2", IAssistantInteractionServiceKt.getInteractionStateService().getWakeUpAppPkg());
        IInteractionStateService r2 = IAssistantInteractionServiceKt.getInteractionStateService();
        IObricTraceParam.a.getClass();
        String r3 = (String) r2.getWakeUpData(0);
        if (o0.d(r3) == false) goto L9;
        FLogger.a.d("ObricTraceApiImpl", "putSendEventPara automic : " + r3 + " from source " + IAssistantInteractionServiceKt.getInteractionStateService().getWakeUpSource());
        r8.put("obric_automic_type", r3);
    L9:
        ObricSpecialInputServiceDelegate r4 = ObricSpecialInputServiceDelegate.b;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        String r5 = r4.e(r8.optString("action_bar_key", ""));
        ObricActionBarTrackType.Companion.getClass();
        if (ObricActionBarTrackType.a.b().contains(r5) == false) goto L12;
    L13:
        String r6 = r4.e(r5);
        r8.put("is_from_obric_action_bar", r6);
        r8.put("action_bar_key", ObricActionBarTrackType.COCO_INSTRUCTION.getStringValue());
        r8.put("action_bar_template_id", ObricActionBarTrackType.a.a(r6));
        Intrinsics.checkNotNullParameter(r8, "<this>");
        String r7 = r8.optString("scene", "");
        if (StringsKt.isBlank(r7) == false) goto L16;
    L19:
        r8.put("scene", "keyboard");
    L20:
        String r10 = ObricActionBarTrackType.access$getActionBarStatus$cp();
        if (Intrinsics.areEqual(r6, "obric_oauto") == false) goto L29;
        if (Intrinsics.areEqual(r9, "send_message_status") == false) goto L26;
        if (r10 == null) goto L26;
        String r11 = r10;
    L27:
        r8.put("obric_action_bar_status", r11);
    L26:
        r11 = r4.f();
        Intrinsics.checkNotNullParameter(r11, "status");
        ObricActionBarTrackType.access$setActionBarStatus$cp(r11);
    L29:
        if (Intrinsics.areEqual(r6, "obric_omni") == true) goto L31;
    L36:
        q(r8, r9);
        r(r8, r9);
        return;
    L31:
        if (Intrinsics.areEqual(r9, "send_message_status") == false) goto L34;
        if (r10 == null) goto L34;
    L35:
        r8.put("obric_action_bar_status", r10);
    L34:
        r10 = r4.f();
        Intrinsics.checkNotNullParameter(r10, "status");
        ObricActionBarTrackType.access$setActionBarStatus$cp(r10);
        goto L35
    L16:
        if (Intrinsics.areEqual(r7, "speak") == true) goto L20;
        if (Intrinsics.areEqual(r7, "obric_click_speak") == true) goto L20;
    L12:
        if (Intrinsics.areEqual(r5, "obric_phone_operation") == false) goto L36;
    L5:
        r1 = "unlocked_screen";
        goto L6
    }

    @Override // com.obric.assistant.trace.IObricTraceParam
    public final void d(JSONObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "eventName");
        r3.put("obric_window_height", this.b);
        r3.put("obric_window_mode", p());
        int r0 = g.a;
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L5;
        String r1 = "lock_screen";
    L6:
        r3.put("obric_message_position_level1", r1);
        r3.put("obric_message_position_level2", IAssistantInteractionServiceKt.getInteractionStateService().getWakeUpAppPkg());
        q(r3, r4);
        r(r3, r4);
        return;
    L5:
        r1 = "unlocked_screen";
        goto L6
    }

    public final void q(JSONObject r3, String r4) {
        int r0 = r4.hashCode();
        if (r0 == (-624136624)) goto L16;
        if (r0 == 1268229313) goto L13;
        if (r0 == 1479107676) goto L10;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == true) goto L22;
        return;
    L22:
        switch(this.c) {
            case 0: goto L30;
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L25;
            default: goto L23;
        };
    L23:
        String r6 = IInteractionStateService.WAKE_UP_SOURCE_OTHER;
    L31:
        r3.put("conversation_mode", r6);
        return;
    L24:
        r6 = "bottom_bar";
        goto L31
    L25:
        r6 = "physical_button_tap";
        goto L31
    L26:
        r6 = "intent_iauto_mic";
        goto L31
    L27:
        r6 = "special_input";
        goto L31
    L28:
        r6 = "auto_mic";
        goto L31
    L29:
        r6 = "bluetooth_headset_wakeup";
        goto L31
    L30:
        r6 = "voice_wakeup";
        goto L31
    L10:
        if (r4.equals("receive_stream") == false) goto L18;
    L17:
        int r7 = g.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r5 = Intrinsics.areEqual(r3.optString("scene", ""), "obric_click_speak");
        goto L19
    L13:
        if (r4.equals("send_message_status") == true) goto L17;
    L16:
        if (r4.equals("send_message") == false) goto L18;
        goto L17
    }

    public final void r(JSONObject r4, String r5) {
        int r0 = r5.hashCode();
        if (r0 == (-624136624)) goto L16;
        if (r0 == 1268229313) goto L13;
        if (r0 == 1479107676) goto L10;
    L18:
        boolean r1 = false;
    L19:
        if (r1 == true) goto L21;
        return;
    L21:
        r4.put("conversation_mode", this.d);
        if (Intrinsics.areEqual(r5, "receive_stream") == false) goto L25;
        this.d = "bottom_bar";
        return;
    L25:
        return;
    L10:
        if (r5.equals("receive_stream") == false) goto L18;
    L17:
        int r2 = g.a;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        r1 = Intrinsics.areEqual(r4.optString("scene", ""), "speak");
        goto L19
    L13:
        if (r5.equals("send_message_status") == true) goto L17;
    L16:
        if (r5.equals("send_message") == false) goto L18;
        goto L17
    }

    @Override // com.obric.assistant.trace.IObricTraceParam
    public final void a(JSONObject r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r3 == null) goto L5;
        r2.put("current_page", r3);
    L5:
        if (r4 == null) goto L7;
        r2.put("action_type", r4);
    L7:
        if (r5 == null) goto L10;
        r2.put("enter_from", r5);
        return;
    }

    @Override // com.obric.assistant.trace.IObricTraceParam
    public final void b(JSONObject r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r3 == null) goto L5;
        r2.put("current_page", r3);
    L5:
        if (r4 == null) goto L7;
        r2.put("previous_page", r4);
    L7:
        if (r5 == null) goto L10;
        r2.put("enter_from", r5);
        return;
    }
}
