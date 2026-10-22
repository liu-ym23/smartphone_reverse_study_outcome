package com.larus.bmhome.chat.component.list.pipeline.pre_dependent;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.internal.protocol.model.BotLoadingConfig;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements td8.c {
    public final td8.d a;

    public static final class a {
    }

    static {
    }

    public c(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
    }

    public final Message c(List<? extends xc8.b> r8) {
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L38;
        Object r0 = r9.next();
        xc8.b r2 = (xc8.b) r0;
        Message r3 = r2.getMessage();
        boolean r5 = true;
        if (com.larus.bmhome.chat.bean.d.i0(r3) == false) goto L11;
        if (com.larus.bmhome.chat.bean.d.w(r3) == true) goto L11;
    L30:
        boolean r4 = false;
    L31:
        if (r4 == true) goto L33;
    L35:
        r5 = false;
    L36:
        if (r5 == false) goto L4;
    L39:
        xc8.b r1 = (xc8.b) r0;
        if (r1 != null) goto L42;
        return null;
    L42:
        return r1.getMessage();
    L33:
        if (b0.f(r2.getMessage()) == true) goto L35;
    L11:
        if (com.larus.bmhome.chat.bean.d.T(r3) == true) goto L30;
        if (com.larus.bmhome.chat.bean.d.p0(r3) == true) goto L30;
        if (com.larus.bmhome.chat.bean.d.C0(r3) == true) goto L18;
    L20:
        MessageStatus r6 = r3.getMessageStatus();
        if (r6 != null) goto L23;
    L25:
        boolean r7 = false;
    L26:
        if (r7 == false) goto L28;
    L29:
        r4 = true;
        goto L31
    L28:
        if (b0.f(r3) == false) goto L30;
    L23:
        if (r6.isVisible() != true) goto L25;
        r7 = true;
        goto L26
    L18:
        if (r3.getRegenVisible() == true) goto L20;
    L38:
        r0 = null;
        goto L39
    }

    @Override // td8.c
    public final boolean a(int r11, xc8.b r12, xc8.b r13, List<? extends xc8.b> r14) {
        Intrinsics.checkNotNullParameter(r13, "current");
        Intrinsics.checkNotNullParameter(r14, "input");
        BotModel r15 = this.a.a();
        Object r16 = null;
        if (r15 == null) goto L7;
        BotLoadingConfig r17 = r15.getLoadingConf();
        if (r17 == null) goto L7;
        Boolean r18 = r17.getDisableFakeLoading();
    L9:
        if (Intrinsics.areEqual(r18, Boolean.TRUE) == false) goto L12;
        FLogger.a.i("Pipeline_List_Loading", "loading no show because of disableFakeLoading");
        return false;
    L12:
        Message r19 = c(r14);
        if (r19 != null) goto L17;
        FLogger.a.i("Pipeline_List_Loading", "loading no show because of latestVisibleMessage is null");
        return false;
    L17:
        if (com.larus.bmhome.chat.bean.d.m0(r19) == false) goto L20;
        FLogger.a.i("Pipeline_List_Loading", "loading no show because of latestVisibleMessage is illegal asr loading");
        return false;
    L20:
        Map r1 = r19.getExt();
        if (r1 == null) goto L23;
        String r2 = (String) r1.get("fork_from_conversation_id");
    L25:
        if (r2 != null) goto L27;
    L30:
        boolean r3 = true;
    L31:
        if (r3 == true) goto L41;
        Map r4 = r19.getExt();
        if (r4 != null) goto L35;
    L37:
        boolean r5 = false;
    L38:
        if (r5 == true) goto L41;
        FLogger.a.d("Pipeline_List_Loading", "loading no show because of latestVisibleMessage is copied fork anchor");
        return false;
    L35:
        if (r4.containsKey("modified_from") != true) goto L37;
        r5 = true;
    L41:
        FLogger r6 = FLogger.a;
        r6.i("Pipeline_List_Loading", "latestVisibleMessage is >>> messageId is " + r19.getMessageId() + ", localId is " + r19.getLocalMessageId() + ", contentType is " + r19.getContentType());
        if (com.larus.bmhome.chat.bean.d.C0(r19) == true) goto L55;
        if (this.a.q() == true) goto L55;
        long r7 = this.a.i();
        long r8 = r19.getServerIndex();
        if (1 <= r8) goto L48;
    L50:
        boolean r9 = false;
    L51:
        if (r9 == false) goto L55;
        r6.i("Pipeline_List_Loading", "loading no show because of condition one.isRegen is " + com.larus.bmhome.chat.bean.d.C0(r19) + ", isWaitRegenAnswer is " + this.a.q() + ", isCrowdTestMessage is " + com.larus.bmhome.chat.bean.d.b0(r19) + ", serverIndex is " + r19.getServerIndex() + ", readMessageIndex is " + this.a.i());
        return false;
    L48:
        if (r8 >= r7) goto L50;
        r9 = true;
    L55:
        if (com.larus.bmhome.chat.bean.d.G0(r19) == false) goto L171;
        StringBuilder r10 = new StringBuilder("latestVisibleMessage.messageStatusLocal: ");
        r10.append(r19.getMessageStatusLocal());
        r10.append(", latestVisibleMessage.needTriggerLoading(): ");
        r10.append(b0.i(r19));
        r10.append(", empty_response: ");
        Map r20 = r19.getExt();
        if (r20 == null) goto L59;
        String r21 = (String) r20.get("empty_response");
    L60:
        r10.append(r21);
        r10.append(", loading value: ");
        Map r22 = r19.getBusinessExt();
        if (r22 == null) goto L63;
        String r23 = (String) r22.get("send_loading");
    L64:
        r10.append(r23);
        r10.append(", latestVisibleMessage.showLoading: ");
        r10.append(com.larus.bmhome.chat.bean.d.M(r19));
        r6.i("Pipeline_List_Loading", r10.toString());
        if (r19.getMessageStatusLocal() == 12) goto L143;
        if (r19.getMessageStatusLocal() == 13) goto L143;
        if (r19.getMessageStatusLocal() == 14) goto L143;
        if (b0.i(r19) == false) goto L143;
        Map r24 = r19.getExt();
        if (r24 == null) goto L82;
        String r25 = (String) r24.get("empty_response");
        if (r25 == null) goto L82;
        Integer r26 = StringsKt.toIntOrNull(r25);
        if (r26 == null) goto L82;
        if (r26.intValue() != 1) goto L82;
        boolean r27 = true;
    L83:
        if (r27 == true) goto L143;
        if (ObricFeatureServiceDelegate.b.a() == false) goto L140;
        String r110 = com.larus.im.bean.message.a.g(r19);
        if (r110 == null) goto L136;
        ArrayList r28 = new ArrayList();
        Iterator<T> r111 = r14.iterator();
    L91:
        if (r111.hasNext() == false) goto L96;
        Object r29 = r111.next();
        if (Intrinsics.areEqual(com.larus.im.bean.message.a.g(((xc8.b) r29).getMessage()), r110) == false) goto L91;
        r28.add(r29);
        goto L91
    L96:
        if (r28.isEmpty() == true) goto L136;
        Iterator r112 = r28.iterator();
    L100:
        if (r112.hasNext() == false) goto L136;
        xc8.b r113 = (xc8.b) r112.next();
        Map r30 = r113.getMessage().getBusinessExt();
        if (r30 == null) goto L104;
        String r31 = (String) r30.get("send_loading");
    L106:
        if (Intrinsics.areEqual(r31, "0") == true) goto L133;
        List r114 = com.larus.bmhome.chat.bean.d.f(r113.getMessage()).getEntities();
        if (r114 == null) goto L129;
        List r115 = r114;
        if ((r115 instanceof Collection) == true) goto L112;
    L114:
        Iterator r116 = r115.iterator();
    L116:
        if (r116.hasNext() == false) goto L126;
        Integer r32 = ((UplinkFileEntity) r116.next()).getUpLinkStatus();
        int r33 = UpLinkState.FAIL.getValue();
        if (r32 != null) goto L121;
    L123:
        boolean r34 = false;
    L124:
        if (r34 == false) goto L116;
        boolean r117 = true;
    L127:
        if (r117 != true) goto L129;
        boolean r118 = true;
    L130:
        if (r118 == true) goto L133;
        boolean r119 = false;
    L134:
        if (r119 == false) goto L100;
        boolean r120 = true;
    L137:
        if (r120 == false) goto L140;
        FLogger.a.i("Pipeline_List_Loading", "loading no show because of latestVisibleMessage is self and belong to batch upload file failed");
        return false;
    L121:
        if (r32.intValue() != r33) goto L123;
        r34 = true;
    L126:
        r117 = false;
        goto L127
    L112:
        if (r115.isEmpty() == false) goto L114;
    L129:
        r118 = false;
    L133:
        r119 = true;
        goto L134
    L104:
        r31 = null;
    L136:
        r120 = false;
    L140:
        FLogger.a.i("Pipeline_List_Loading", "loading show because of latestVisibleMessage is self and ext get empty_response != 1");
        return true;
    L82:
        r27 = false;
    L143:
        if (r19.getMessageStatusLocal() == 12) goto L159;
        if (r19.getMessageStatusLocal() == 13) goto L159;
        if (r19.getMessageStatusLocal() == 14) goto L159;
        Map r121 = r19.getBusinessExt();
        if (r121 == null) goto L151;
        String r122 = (String) r121.get("send_loading");
    L153:
        if (Intrinsics.areEqual(r122, "0") == true) goto L159;
        if (com.larus.bmhome.chat.bean.d.M(r19) == false) goto L159;
        r6.i("Pipeline_List_Loading", "loading show because of latestVisibleMessage is self and latestVisibleMessage showLoading");
        return true;
    L151:
        r122 = null;
    L159:
        if (AppHost.a.isTestChannel() == false) goto L208;
        StringBuilder r123 = new StringBuilder("loading  show  condition skip because of SKIP1: latestVisibleMessage.messageStatusLocal:");
        r123.append(r19.getMessageStatusLocal());
        r123.append("latestVisibleMessage.messageStatusLocal:");
        r123.append(r19.getMessageStatusLocal());
        r123.append("latestVisibleMessage.businessExt?.get(TRIGGER_SEND_LOADING_KEY)");
        Map r35 = r19.getBusinessExt();
        if (r35 == null) goto L163;
        String r36 = (String) r35.get("send_loading");
    L164:
        r123.append(r36);
        r123.append("latestVisibleMessage.showLoading:");
        r123.append(com.larus.bmhome.chat.bean.d.M(r19));
        r123.append("latestVisibleMessage.needTriggerLoading():");
        r123.append(b0.i(r19));
        r123.append("latestVisibleMessage.ext?.get(empty_response)?.toIntOrNull():");
        Map r124 = r19.getExt();
        if (r124 == null) goto L169;
        String r125 = (String) r124.get("empty_response");
        if (r125 == null) goto L169;
        r16 = StringsKt.toIntOrNull(r125);
    L169:
        r123.append(r16);
        r6.d("Pipeline_List_Loading", r123.toString());
        goto L208
    L163:
        r36 = null;
    L208:
        r6.i("Pipeline_List_Loading", "loading no show because of default");
        return false;
    L63:
        r23 = null;
        goto L64
    L59:
        r21 = null;
        goto L60
    L171:
        if (com.larus.bmhome.chat.bean.d.o0(r19) == true) goto L175;
        if (com.larus.im.bean.message.a.E(r19) == true) goto L175;
    L178:
        Intrinsics.checkNotNullParameter(r19, "<this>");
        if (r19.getContentType() == 60) goto L181;
    L183:
        boolean r126 = false;
    L184:
        if (r126 == true) goto L186;
    L193:
        Map r127 = r19.getBusinessExt();
        if (r127 == null) goto L196;
        String r128 = (String) r127.get("send_loading");
    L198:
        if (Intrinsics.areEqual(r128, "2") == false) goto L201;
        r6.i("Pipeline_List_Loading", "loading show because of businessExt[TRIGGER_SEND_LOADING_KEY] is BOT_SAY_LOADING");
        return true;
    L201:
        Map r129 = r19.getBusinessExt();
        if (r129 == null) goto L205;
        r16 = (String) r129.get("send_loading");
    L205:
        if (Intrinsics.areEqual(r16, "5") == false) goto L208;
        r6.i("Pipeline_List_Loading", "loading show because of businessExt[TRIGGER_SEND_LOADING_KEY] is SEND_HIDDEN_MSG_LOADING");
        return true;
    L196:
        r128 = null;
        goto L198
    L186:
        if (r19.getMessageStatusLocal() == 22) goto L193;
        if (r19.getMessageStatusLocal() == 23) goto L193;
        if (IAIChatService.a.V7() == false) goto L193;
        r6.i("Pipeline_List_Loading", "loading show because of latestVisibleMessage is ExpertType");
        return true;
    L181:
        if (r19.getUserType() != 2) goto L183;
        r126 = true;
    L175:
        if (b0.i(r19) == false) goto L178;
        r6.i("Pipeline_List_Loading", "loading show because of latestVisibleMessage is Image4Type");
        return true;
    L27:
        if (StringsKt.isBlank(r2) == true) goto L30;
        r3 = false;
        goto L31
    L23:
        r2 = null;
    L7:
        r18 = null;
        goto L9
    }

    @Override // td8.c
    public final List<xc8.b> b(int r52, xc8.b r53, xc8.b r54, List<xc8.b> r55) {
        Intrinsics.checkNotNullParameter(r54, "current");
        Intrinsics.checkNotNullParameter(r55, "input");
        FLogger r1 = FLogger.a;
        r1.i("Pipeline_List_Loading", "start AddLoadingTask, current input size is " + r55.size());
        Message r4 = c(r55);
        if (r4 == null) goto L47;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (com.larus.bmhome.chat.bean.d.M(r4) == false) goto L7;
        String r6 = "1";
    L12:
        Message r10 = null;
        if (Intrinsics.areEqual(r6, "0") == false) goto L15;
        r1.i("Pipeline_List_Loading", "loading no show because of triggerLoadingType is NO_LOADING");
        int r5 = 0;
    L45:
        if (r10 == null) goto L47;
        r1.i("Pipeline_List_Loading", "loading added, loading message >>>> contentType is " + r10.getContentType() + ", content is " + g2a.d.b(r10.getContent()));
        ListProtector.add(r55, r5, xc8.f.f(r10));
        goto L47
    L15:
        Map r9 = r4.getBusinessExt();
        if (r9 == null) goto L19;
        String r11 = (String) r9.get("loading_reply_id");
        if (r11 == null) goto L19;
    L20:
        String r36 = r11;
        int r12 = r6.hashCode();
        if (r12 != 49) goto L23;
        r6.equals("1");
    L36:
        int r49 = 0;
    L37:
        MessageStatus r50 = MessageStatus.MessageStatus_AVAILABLE;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Map r7 = r4.getBusinessExt();
        if (r7 == null) goto L41;
        r10 = (String) r7.get("waiting_error");
    L41:
        if (Intrinsics.areEqual(r10, "true") == false) goto L43;
        int r13 = 22;
    L44:
        r5 = 0;
        r10 = b0.j(Message.copy$default(r4, null, null, "", 0, r13, r50, r49, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_mock_receiving", "1"), TuplesKt.to("key_error_code", "-1"), TuplesKt.to("err_msg", "first pkg timeout err"), TuplesKt.to("key_is_business_error", "0")}), null, null, 0, false, 0, r36, null, false, null, null, 0, null, null, null, -272629877, 31, null), 0);
        goto L45
    L43:
        r13 = 0;
        goto L44
    L23:
        if (r12 == 51) goto L32;
        if (r12 != 52) goto L36;
        if (r6.equals("4") == false) goto L36;
        r49 = 3;
        goto L37
    L32:
        if (r6.equals("3") == false) goto L36;
        r49 = 6;
    L19:
        r11 = r4.getLocalMessageId();
        goto L20
    L7:
        Map r8 = r4.getBusinessExt();
        if (r8 == null) goto L11;
        r6 = (String) r8.get("send_loading");
        if (r6 != null) goto L12;
    L11:
        r6 = "0";
    L47:
        r1.i("Pipeline_List_Loading", "end AddLoadingTask, current input size is " + r55.size());
        return r55;
    }
}
