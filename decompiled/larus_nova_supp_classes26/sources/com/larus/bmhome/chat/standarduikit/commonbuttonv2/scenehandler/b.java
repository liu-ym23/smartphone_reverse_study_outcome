package com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends c {
    public final String a;

    public static final class a {
    }

    static {
    }

    public b() {
        this.a = "audio";
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final String getScene() {
        return this.a;
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final void a(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r5) {
        Intrinsics.checkNotNullParameter(r5, "vmData");
        Intrinsics.checkNotNullParameter(r5, "vmData");
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        r1.put("show_from", "reply_inner_button");
        Map<String, String> r6 = r5.h;
        if (r6 == null) goto L5;
        String r7 = r6.get("action");
    L6:
        r1.put("button_name", r7);
        Unit r8 = Unit.INSTANCE;
        r0.reportEvent("click_button", r1);
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final void b(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r5) {
        Intrinsics.checkNotNullParameter(r5, "vmData");
        Intrinsics.checkNotNullParameter(r5, "vmData");
        Message r0 = r5.i;
        String r1 = null;
        if (r0 == null) goto L7;
        Map r2 = r0.getBusinessExt();
        if (r2 == null) goto L7;
        String r3 = (String) r2.get("common_button_v2_scene_audio");
    L8:
        if (r3 != null) goto L20;
        FLogger r4 = FLogger.a;
        StringBuilder r6 = new StringBuilder("[onBindData]: identify message(");
        Message r7 = r5.i;
        if (r7 == null) goto L12;
        String r8 = r7.getMessageId();
    L13:
        r6.append(r8);
        r6.append(") as Audio Button Message");
        r4.i("RealtimeCallSceneHandler", r6.toString());
        IChatRepoService r9 = zh8.a.a;
        Message r10 = r5.i;
        if (r10 == null) goto L16;
        r1 = r10.getLocalMessageId();
    L16:
        if (r1 != null) goto L18;
        r1 = "";
    L18:
        r9.r1(r1, new com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.a());
        return;
    L12:
        r8 = null;
        goto L13
    L20:
        return;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final boolean c(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r12) {
        Intrinsics.checkNotNullParameter(r12, "vmData");
        Message r0 = r12.i;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getMessageId();
    L6:
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("[needHideButton] now handle messageId = ");
        r4.append(r2);
        r4.append(", buttonName = ");
        Map<String, String> r5 = r12.h;
        if (r5 == null) goto L9;
        String r6 = r5.get("action");
    L10:
        r4.append(r6);
        r3.i("RealtimeCallSceneHandler", r4.toString());
        if (ce8.c.a() == true) goto L22;
        Message r7 = r12.i;
        if (r7 == null) goto L17;
        Map r8 = r7.getBusinessExt();
        if (r8 == null) goto L17;
        String r9 = (String) r8.get("button_audio_hidden_cnt_talk");
    L19:
        if (Intrinsics.areEqual(r9, "true") == true) goto L22;
        boolean r10 = false;
    L24:
        if (r10 == false) goto L27;
        r3.i("RealtimeCallSceneHandler", "[needHideButton]: messageId = " + r2 + ", need hide button because of isContinuousTalking is true");
        return true;
    L27:
        Map<String, String> r11 = r12.h;
        if (r11 == null) goto L30;
        String r13 = r11.get("downgrade_scene");
    L31:
        VoiceCallServiceDelegate r14 = VoiceCallServiceDelegate.a;
        if (r13 != null) goto L35;
        r13 = "";
    L35:
        if (r14.q(r13, "message_button", true) == false) goto L38;
        r3.i("RealtimeCallSceneHandler", "[needHideButton]: messageId = " + r2 + ", need hide button because of realtimeCallDowngradeHookShow is true");
        return true;
    L38:
        Map<String, String> r15 = r12.h;
        if (r15 == null) goto L41;
        String r16 = r15.get("permanent");
    L43:
        if (Intrinsics.areEqual(r16, "true") == false) goto L46;
        r3.i("RealtimeCallSceneHandler", "[needHideButton]: messageId = " + r2 + ", no need hide button because of server params permanent is true");
        return false;
    L46:
        Function0<Boolean> r17 = r12.o;
        if (r17 == null) goto L49;
        boolean r18 = Intrinsics.areEqual(r17.invoke(), Boolean.TRUE);
    L50:
        if (r18 == true) goto L61;
        Message r19 = r12.i;
        if (r19 == null) goto L56;
        Map r20 = r19.getBusinessExt();
        if (r20 == null) goto L56;
        String r21 = (String) r20.get("button_audio_hidden_clear_context");
    L58:
        if (Intrinsics.areEqual(r21, "true") == true) goto L61;
        boolean r22 = false;
    L62:
        if (r22 == false) goto L65;
        r3.i("RealtimeCallSceneHandler", "[needHideButton]: messageId = " + r2 + ", need hide button because of isLastMsgIsClearContext is true");
        return true;
    L65:
        Function0<List<Message>> r23 = r12.p;
        if (r23 == null) goto L109;
        List r24 = (List) r23.invoke();
        if (r24 == null) goto L109;
        Iterator r25 = r24.iterator();
    L71:
        if (r25.hasNext() == false) goto L105;
        Object r26 = r25.next();
        Message r27 = (Message) r26;
        if (com.larus.bmhome.chat.bean.d.i0(r27) == false) goto L78;
        if (com.larus.bmhome.chat.bean.d.w(r27) == true) goto L78;
    L97:
        boolean r28 = false;
    L98:
        if (r28 == true) goto L100;
    L102:
        boolean r29 = false;
    L103:
        if (r29 == false) goto L71;
    L106:
        Message r30 = (Message) r26;
        if (r30 == null) goto L109;
        String r31 = r30.getMessageId();
    L110:
        Message r32 = r12.i;
        if (r32 == null) goto L113;
        String r33 = r32.getMessageId();
    L115:
        if (Intrinsics.areEqual(r31, r33) == true) goto L125;
        Message r110 = r12.i;
        if (r110 == null) goto L122;
        Map r111 = r110.getBusinessExt();
        if (r111 == null) goto L122;
        r1 = (String) r111.get("button_audio_hidden_last_msg");
    L122:
        if (Intrinsics.areEqual(r1, "false") == false) goto L125;
        boolean r112 = false;
    L126:
        if (r112 == true) goto L129;
        FLogger.a.i("RealtimeCallSceneHandler", "[needHideButton]: messageId = " + r2 + ", lastMsgId = " + r31 + ", need hide button because of isLastMsg is false");
        return true;
    L129:
        return false;
    L125:
        r112 = true;
        goto L126
    L113:
        r33 = null;
        goto L115
    L100:
        if (b0.f(r27) == true) goto L102;
        r29 = true;
    L78:
        if (com.larus.bmhome.chat.bean.d.T(r27) == true) goto L97;
        if (com.larus.bmhome.chat.bean.d.p0(r27) == true) goto L97;
        if (com.larus.bmhome.chat.bean.d.C0(r27) == true) goto L85;
    L87:
        MessageStatus r34 = r27.getMessageStatus();
        if (r34 != null) goto L90;
    L92:
        boolean r35 = false;
    L93:
        if (r35 == false) goto L95;
    L96:
        r28 = true;
        goto L98
    L95:
        if (b0.f(r27) == false) goto L97;
    L90:
        if (r34.isVisible() != true) goto L92;
        r35 = true;
        goto L93
    L85:
        if (r27.getRegenVisible() == true) goto L87;
    L105:
        r26 = null;
    L109:
        r31 = null;
    L56:
        r21 = null;
    L61:
        r22 = true;
        goto L62
    L49:
        r18 = false;
        goto L50
    L41:
        r16 = null;
        goto L43
    L30:
        r13 = null;
    L17:
        r9 = null;
    L22:
        r10 = true;
        goto L24
    L9:
        r6 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final void d(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r5) {
        Intrinsics.checkNotNullParameter(r5, "vmData");
        Intrinsics.checkNotNullParameter(r5, "vmData");
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        r1.put("show_from", "reply_inner_button");
        Map<String, String> r6 = r5.h;
        if (r6 == null) goto L5;
        String r7 = r6.get("action");
    L6:
        r1.put("button_name", r7);
        Unit r8 = Unit.INSTANCE;
        r0.reportEvent("show_button", r1);
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final int e(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r2) {
        Intrinsics.checkNotNullParameter(r2, "vmData");
        Map<String, String> r3 = r2.h;
        if (r3 == null) goto L5;
        String r4 = r3.get("icon_position");
    L7:
        if (Intrinsics.areEqual(r4, "left") == false) goto L9;
        return 1;
    L9:
        return 2;
    L5:
        r4 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final boolean f(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r5) {
        Intrinsics.checkNotNullParameter(r5, "vmData");
        Map<String, String> r6 = r5.h;
        if (r6 == null) goto L5;
        String r7 = r6.get("downgrade_scene");
    L6:
        VoiceCallServiceDelegate r0 = VoiceCallServiceDelegate.a;
        if (r7 != null) goto L9;
        String r1 = "";
    L10:
        boolean r2 = r0.o(r1, "message_button", true);
        FLogger.a.i("RealtimeCallSceneHandler", "[interceptWhenClick]: realtimeCallScene = " + r7 + ", isDowngrade = " + r2);
        return r2;
    L9:
        r1 = r7;
        goto L10
    L5:
        r7 = null;
        goto L6
    }
}
