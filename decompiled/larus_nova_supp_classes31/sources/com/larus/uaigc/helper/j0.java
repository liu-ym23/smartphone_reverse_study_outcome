package com.larus.uaigc.helper;

import androidx.collection.LruCache;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationAsset;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.uaigc.chat.image.event.GenerateImageTrace;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.a4;
import tx9.l3;
import tx9.u2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j0 implements hy9.d {
    public static final j0 a = null;

    static {
        a = new j0();
    }

    public j0() {
    }

    @Override // hy9.d
    public final ky9.a b() {
        return GenerateImageTrace.a;
    }

    @Override // hy9.d
    public final ky9.b e() {
        return com.larus.uaigc.chat.image.event.b.a;
    }

    @Override // hy9.d
    public final void c(String r2) {
        if (r2 != null) goto L4;
        r2 = "";
    L4:
        tx9.r0.f(r2, "my_replica");
    }

    @Override // hy9.d
    public final void j(Message r31, String r32) {
        if (r31 == null) goto L185;
        List<CreationItem> r0 = bz9.a.g(r31);
        if (com.larus.bmhome.chat.bean.d.j0(r31) == false) goto L7;
    L11:
        Map r1 = r31.getExt();
        String r2 = "";
        String r3 = null;
        if (r1 == null) goto L16;
        String r4 = (String) r1.get("log_id");
        FLogger r5 = FLogger.a;
        r5.d("BotUtils", "msgId: " + r31.getMessageId() + "; logId: " + r4);
        Object r6 = r1.get("show_from");
        if (r4 == null) goto L17;
        r5.d("BotUtils", "msgId: " + r31.getMessageId() + "; NO logId");
        String r7 = "";
    L18:
        IAIChatControlTraceService.Companion r8 = IAIChatControlTraceService.a;
        String r9 = r31.getReplyId();
        if (r9 != null) goto L21;
        r9 = "";
    L21:
        String r10 = r8.Sa(r9);
        int r20 = 0;
        boolean r21 = false;
        r21 = false;
        r21 = false;
        r21 = false;
        if (r10.length() != 0) goto L24;
        boolean r11 = true;
    L25:
        if (r11 == false) goto L45;
        LruCache<String, Message> r12 = r8.mb();
        String r13 = r31.getReplyId();
        if (r13 != null) goto L29;
        r13 = "";
    L29:
        Message r14 = (Message) r12.get(r13);
        if (r14 == null) goto L34;
        Map r15 = r14.getExt();
        if (r15 == null) goto L34;
        String r16 = (String) r15.get("original_content_source");
    L35:
        if (r16 == null) goto L39;
        r2 = r16;
    L39:
        if (r2.length() != 0) goto L41;
        boolean r17 = true;
    L42:
        if (r17 == false) goto L44;
        r2 = "other";
    L44:
        String r18 = r2;
    L46:
        ArrayList r19 = (ArrayList) r0;
        String r22 = "0";
        if ((!r19.isEmpty()) == false) goto L87;
        ArrayList r23 = new ArrayList();
        Iterator r24 = r19.iterator();
    L50:
        if (r24.hasNext() == false) goto L61;
        Object r25 = r24.next();
        Integer r26 = ((CreationItem) r25).type;
        if (r26 != null) goto L55;
    L57:
        boolean r27 = false;
    L58:
        if (r27 == false) goto L50;
        r23.add(r25);
        goto L50
    L55:
        if (r26.intValue() != 1) goto L57;
        r27 = true;
        goto L58
    L61:
        if ((!r23.isEmpty()) == false) goto L182;
        String r28 = r31.getMessageId();
        String r29 = r31.getConversationId();
        String r110 = CollectionsKt.joinToString$default(r23, ",", null, null, 0, null, new com.larus.uaigc.chat.markdown.helper.e0(), 30, null);
        String r111 = CollectionsKt.joinToString$default(r23, ",", null, null, 0, null, new com.larus.uaigc.chat.markdown.helper.f0(), 30, null);
        if (com.larus.bmhome.chat.bean.d.z0(r31) == false) goto L65;
        r22 = "1";
    L65:
        String r112 = (String) r6;
        CreationItem r30 = (CreationItem) CollectionsKt.firstOrNull(r23);
        if (r30 == null) goto L75;
        CreationGenDetail r33 = r30.genDetail;
        if (r33 == null) goto L75;
        Integer r34 = r33.taskType;
        if (r34 == null) goto L75;
        if (r34.intValue() != 5) goto L75;
        boolean r35 = true;
    L76:
        CreationItem r36 = (CreationItem) CollectionsKt.firstOrNull(r23);
        if (r36 == null) goto L86;
        CreationGenDetail r37 = r36.genDetail;
        if (r37 == null) goto L86;
        Integer r38 = r37.taskType;
        if (r38 == null) goto L86;
        if (r38.intValue() != 7) goto L86;
        r21 = true;
    L86:
        boolean r39 = com.larus.im.bean.message.a.C0(r31);
        u2.c(r32, r29, r22, r7, r28, r18, r110, r111, "bot", Boolean.valueOf(r35), Boolean.valueOf(r21), Boolean.valueOf(r39), tz9.a.a(r31), null, r112, 90112);
        return;
    L75:
        r35 = false;
        goto L76
    L182:
        return;
    L87:
        Map<String, CreationTask> r40 = com.larus.uaigc.chat.markdown.helper.j0.d(dp8.e.c(r31));
        if (r40 == null) goto L90;
        Collection<CreationTask> r41 = r40.values();
    L91:
        if (r41 == null) goto L105;
        ArrayList r42 = new ArrayList();
        Iterator<T> r43 = r41.iterator();
    L94:
        if (r43.hasNext() == false) goto L106;
        CreationTask r113 = (CreationTask) r43.next();
        if (r113 == null) goto L102;
        CreationAsset r114 = r113.asset;
        if (r114 == null) goto L102;
        UserCreationImage r115 = r114.imageContent;
        if (r115 == null) goto L102;
        ImageInfo r116 = r115.a;
    L103:
        if (r116 == null) goto L94;
        r42.add(r116);
    L102:
        r116 = null;
    L106:
        if (r42 != null) goto L108;
    L111:
        boolean r44 = true;
    L112:
        if (r44 == true) goto L135;
        String r45 = r31.getMessageId();
        String r117 = r31.getConversationId();
        ArrayList r210 = r42;
        String r118 = CollectionsKt.joinToString$default(r210, ",", null, null, 0, null, new com.larus.uaigc.chat.markdown.helper.g0(), 30, null);
        String r119 = CollectionsKt.joinToString$default(r210, ",", null, null, 0, null, new com.larus.uaigc.chat.markdown.helper.h0(), 30, null);
        if (com.larus.bmhome.chat.bean.d.z0(r31) == false) goto L116;
        r22 = "1";
    L116:
        String r120 = (String) r6;
        Collection<CreationTask> r46 = r41;
        CreationTask r47 = (CreationTask) CollectionsKt.firstOrNull(r46);
        if (r47 == null) goto L124;
        Integer r48 = r47.taskType;
        if (r48 == null) goto L124;
        if (r48.intValue() != 5) goto L124;
        boolean r49 = true;
    L125:
        CreationTask r50 = (CreationTask) CollectionsKt.firstOrNull(r46);
        if (r50 == null) goto L133;
        Integer r51 = r50.taskType;
        if (r51 == null) goto L133;
        if (r51.intValue() != 7) goto L133;
        boolean r52 = true;
    L134:
        boolean r53 = com.larus.im.bean.message.a.C0(r31);
        int r54 = 7;
        u2.c(r32, r117, r22, r7, r45, r18, r118, r119, "bot", Boolean.valueOf(r49), Boolean.valueOf(r52), Boolean.valueOf(r53), tz9.a.a(r31), null, r120, 90112);
    L136:
        if (r41 == null) goto L153;
        Iterator<T> r55 = r41.iterator();
    L139:
        if (r55.hasNext() == false) goto L151;
        Object r56 = r55.next();
        CreationTask r57 = (CreationTask) r56;
        if (r57 == null) goto L148;
        Integer r58 = r57.loadingAssetType;
        if (r58 == null) goto L148;
        if (r58.intValue() != r54) goto L148;
        boolean r121 = true;
    L149:
        if (r121 == false) goto L139;
    L152:
        CreationTask r59 = (CreationTask) r56;
    L154:
        if (r59 == null) goto L184;
        CreationAsset r60 = r59.asset;
        if (r60 == null) goto L162;
        ep8.a r61 = r60.videoContent;
        if (r61 == null) goto L162;
        AiGenVideoContentData r62 = r61.videoInfo;
        if (r62 == null) goto L162;
        r3 = r62.getVid();
    L162:
        String r63 = r3;
        String r64 = r31.getMessageId();
        String r65 = tz9.a.a(r31);
        Integer r66 = r59.index;
        if (r66 == null) goto L165;
        r20 = r66.intValue();
    L165:
        a4.d(r63, r64, r32, r65, Integer.valueOf(r20 + 1), r59.id, null, null, 448);
        return;
    L184:
        return;
    L148:
        r121 = false;
        goto L149
    L151:
        r56 = null;
        goto L152
    L153:
        r59 = null;
    L133:
        r52 = false;
    L124:
        r49 = false;
        goto L125
    L135:
        r54 = 7;
        goto L136
    L108:
        if (r42.isEmpty() == true) goto L111;
        r44 = false;
        goto L112
    L105:
        r42 = null;
        goto L106
    L90:
        r41 = null;
        goto L91
    L41:
        r17 = false;
    L34:
        r16 = null;
        goto L35
    L45:
        r18 = r10;
        goto L46
    L24:
        r11 = false;
    L17:
        r7 = null;
        goto L18
    L16:
        r6 = null;
        goto L17
    L7:
        if (com.larus.bmhome.chat.bean.d.a0(r31) == true) goto L11;
        if (((ArrayList) r0).isEmpty() == false) goto L11;
        return;
    }

    @Override // hy9.d
    public final void k(String r4, String r5, String r6, String r7) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.putOpt("use_click_from", "ai_generate_board");     // Catch: JSONException -> L5
        r1.putOpt("action_bar_key", r4);     // Catch: JSONException -> L5
        r1.putOpt("action_bar_template_id", r5);     // Catch: JSONException -> L5
        r1.putOpt("action_bar_item_id", r6);     // Catch: JSONException -> L5
        r1.putOpt("image_edit_function_tab", r7);     // Catch: JSONException -> L5
    L7:
        TrackParams r8 = new TrackParams().merge(r1);
        by7.a r9 = new by7.a("use_replica_button_cancel");
        r9.a.merge(r8);
        r9.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("InstructionHitPoints", "error in mobUseReplicaButtonCancel " + e.getLocalizedMessage());
        goto L7
    }

    @Override // hy9.d
    public final void d(int r4, String r5, String r6, String r7, String r8) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.putOpt("click_from", "ai_generate_board");     // Catch: JSONException -> L5
        r1.putOpt("is_active_click", Integer.valueOf(r4));     // Catch: JSONException -> L5
        r1.putOpt("action_bar_key", r5);     // Catch: JSONException -> L5
        r1.putOpt("action_bar_template_id", r6);     // Catch: JSONException -> L5
        r1.putOpt("action_bar_item_id", r7);     // Catch: JSONException -> L5
        r1.putOpt("image_edit_function_tab", r8);     // Catch: JSONException -> L5
    L7:
        TrackParams r9 = new TrackParams().merge(r1);
        by7.a r10 = new by7.a("use_replica_button_click");
        r10.a.merge(r9);
        r10.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("InstructionHitPoints", "error in mobUseReplicaButtonClick " + e.getLocalizedMessage());
        goto L7
    }

    @Override // hy9.d
    public final void f(String r3, String r4, String r5, String r6, String r7) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.putOpt("show_from", r3);     // Catch: JSONException -> L5
        r0.putOpt("action_bar_key", r4);     // Catch: JSONException -> L5
        r0.putOpt("action_bar_template_id", r5);     // Catch: JSONException -> L5
        r0.putOpt("action_bar_item_id", r6);     // Catch: JSONException -> L5
        r0.putOpt("image_edit_function_tab", r7);     // Catch: JSONException -> L5
    L7:
        TrackParams r8 = new TrackParams().merge(r0);
        by7.a r9 = new by7.a("use_replica_button_show");
        r9.a.merge(r8);
        r9.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("InstructionHitPoints", "error in mobUseReplicaButtonShow " + e.getLocalizedMessage());
        goto L7
    }

    @Override // hy9.d
    public final void a(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r3 != null) goto L23;
    L7:
        if (r4 == null) goto L9;
        r0.put("tab_type_after", r4);     // Catch: JSONException -> L5
    L9:
        if (r5 == null) goto L11;
        r0.put("enter_method", r5);     // Catch: JSONException -> L5
    L11:
        if (r6 == null) goto L13;
        r0.put("bot_id", r6);     // Catch: JSONException -> L5
    L13:
        if (r11 == null) goto L16;
        r0.put("current_page", r11);     // Catch: JSONException -> L5
    L16:
        if (com.larus.utils.o0.d(r9) == false) goto L18;
        r0.put("from_template_id", r9);     // Catch: JSONException -> L5
    L18:
        r0.putOpt("image_edit_function_id", r10);     // Catch: JSONException -> L5
        r0.putOpt("action_bar_template_id", r7);     // Catch: JSONException -> L5
        r0.putOpt("action_bar_template_type", r8);     // Catch: JSONException -> L5
    L21:
        TrackParams r12 = new TrackParams().merge(r0);
        by7.a r13 = new by7.a("image_edit_tab_switch");
        r13.a.merge(r12);
        r13.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("InstructionHitPoints", "error in mobImageEditTabSwitch " + e.getLocalizedMessage());
        goto L21
    L23:
        r0.put("tab_type_before", r3);     // Catch: JSONException -> L5
        goto L7
    }

    @Override // hy9.d
    public final void h(String r2, Integer r3, String r4, String r5, String r6, String r7, String r8, String r9, JSONObject r10, by7.e r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "params");
        nz9.c.b(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    @Override // hy9.d
    public final void g(String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, Boolean r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, JSONObject r31, by7.e r32) {
        Intrinsics.checkNotNullParameter(r25, "tabType");
        Intrinsics.checkNotNullParameter(r31, "params");
        Intrinsics.checkNotNullParameter(r31, "params");
        if (r23 != null) goto L35;
        String r11 = null;
    L7:
        r31.putOpt("is_deep_thinking", r11);     // Catch: JSONException -> L28
        r31.putOpt("ai_create_show_mode", r24);     // Catch: JSONException -> L28
        r31.putOpt("button_name", r13);     // Catch: JSONException -> L28
        r31.putOpt("parent_button_name", r14);     // Catch: JSONException -> L28
        r31.putOpt("show_from", r16);     // Catch: JSONException -> L28
        r31.putOpt("button_type", r17);     // Catch: JSONException -> L28
        r31.putOpt("action_bar_template_id", r20);     // Catch: JSONException -> L28
        r31.putOpt("action_bar_template_type", r21);     // Catch: JSONException -> L28
        r31.putOpt("image_edit_function_id", r15);     // Catch: JSONException -> L28
        if (r18 == null) goto L10;
        r31.put("bot_id", r18);     // Catch: JSONException -> L28
    L10:
        if (r19 == null) goto L13;
        r31.put("enter_method", r19);     // Catch: JSONException -> L28
    L13:
        if (com.larus.utils.o0.d(r22) == false) goto L15;
        r31.put("previous_page", r22);     // Catch: JSONException -> L28
    L15:
        if (r25 == null) goto L17;
        r31.put("tab_type", r25);     // Catch: JSONException -> L28
    L17:
        if (r26 == null) goto L19;
        r31.put("current_page", r26);     // Catch: JSONException -> L28
    L19:
        if (r27 == null) goto L21;
        r31.put("template_page_type", r27);     // Catch: JSONException -> L28
    L21:
        if (r28 == null) goto L23;
        r31.put("prompt_type", r28);     // Catch: JSONException -> L28
    L23:
        if (r29 == null) goto L25;
        r31.put("prompt_from", r29);     // Catch: JSONException -> L28
    L25:
        if (r30 == null) goto L30;
        r31.put("visual_size", r30);     // Catch: JSONException -> L28
    L28:
        e = move-exception;
        FLogger.a.e("InstructionHitPoints", "error in mobImageEditFunctionShow " + e.getLocalizedMessage());
    L30:
        TrackParams r0 = new TrackParams().merge(r31);
        by7.a r1 = new by7.a("image_edit_function_show");
        if (r32 == null) goto L33;
        r1.b = r32;
    L33:
        r1.a.merge(r0);
        r1.b();
        return;
    L35:
        r11 = l3.f(r23);     // Catch: JSONException -> L28
        goto L7
    }

    @Override // hy9.d
    public final void i(String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, Boolean r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, JSONObject r32, by7.e r33) {
        Intrinsics.checkNotNullParameter(r28, "tabType");
        Intrinsics.checkNotNullParameter(r32, "params");
        Intrinsics.checkNotNullParameter(r32, "params");
        if (r22 != null) goto L52;
        String r10 = null;
    L7:
        r32.putOpt("is_deep_thinking", r10);     // Catch: JSONException -> L37
        r32.putOpt("ai_create_show_mode", r23);     // Catch: JSONException -> L37
        r32.putOpt("button_name", r12);     // Catch: JSONException -> L37
        r32.putOpt("parent_button_name", r13);     // Catch: JSONException -> L37
        r32.putOpt("show_from", r15);     // Catch: JSONException -> L37
        r32.putOpt("button_type", r16);     // Catch: JSONException -> L37
        r32.putOpt("action_bar_template_id", r19);     // Catch: JSONException -> L37
        r32.putOpt("action_bar_template_type", r20);     // Catch: JSONException -> L37
        r32.putOpt("image_edit_function_id", r14);     // Catch: JSONException -> L37
        if (com.larus.utils.o0.d(r21) == false) goto L10;
        r32.put("previous_page", r21);     // Catch: JSONException -> L37
    L10:
        if (r17 == null) goto L12;
        r32.put("bot_id", r17);     // Catch: JSONException -> L37
    L12:
        if (r18 == null) goto L15;
        r32.put("enter_method", r18);     // Catch: JSONException -> L37
    L15:
        if (com.larus.utils.o0.d(r24) == false) goto L18;
        r32.put("recommend_from", r24);     // Catch: JSONException -> L37
    L18:
        if (com.larus.utils.o0.d(r27) == false) goto L21;
        r32.put("template_rec_extra", r27);     // Catch: JSONException -> L37
    L21:
        if (com.larus.utils.o0.d(r26) == false) goto L24;
        r32.put("template_rec_req_id", r26);     // Catch: JSONException -> L37
    L24:
        if (com.larus.utils.o0.d(r25) == false) goto L27;
        r32.put("from_template_id", r25);     // Catch: JSONException -> L37
    L27:
        if (com.larus.utils.o0.d(r28) == false) goto L30;
        r32.put("tab_type", r28);     // Catch: JSONException -> L37
    L30:
        if (com.larus.utils.o0.d(r29) == false) goto L32;
        r32.put("creation_task_id", r29);     // Catch: JSONException -> L37
    L32:
        if (r30 == null) goto L34;
        r32.put("current_page", r30);     // Catch: JSONException -> L37
    L34:
        if (r31 == null) goto L39;
        r32.put("template_page_type", r31);     // Catch: JSONException -> L37
    L37:
        e = move-exception;
        FLogger.a.e("InstructionHitPoints", "error in mobImageEditFunctionClick " + e.getLocalizedMessage());
    L39:
        TrackParams r0 = new TrackParams().merge(r32);
        by7.a r1 = new by7.a("image_edit_function_click");
        if (r33 == null) goto L42;
        r1.b = r33;
    L42:
        r1.a.merge(r0);
        r1.b();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L45
        com.larus.platform.service.g.a.monitorEventForSlardar("image_edit_function_click", r32, null, null);     // Catch: Throwable -> L45
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L45
    L47:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L56;
        FLogger.a.e("InstructionHitPoints", "slardar report error, image_edit_function_click " + r4.getLocalizedMessage());
        return;
    L56:
        return;
    L45:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L47
    L52:
        r10 = l3.f(r22);     // Catch: JSONException -> L37
        goto L7
    }
}
