package com.larus.bmhome.chat.list.cell.prompt;

import android.content.Context;
import android.text.Spanned;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageTag;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.x0;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import zb8.e$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d1 {
    public static final /* synthetic */ int l = 0;
    public final Context a;
    public final com.larus.bmhome.chat.component.cvs.y b;
    public final com.larus.bmhome.chat.component.bottom.multimodal.g c;
    public final gd8.g d;
    public final u7 e;
    public final ICoreInputAbility f;
    public final zb8.e g;
    public final va8.o h;
    public final com.larus.bmhome.instruction.h i;
    public final fx9.a j;
    public final c1 k;

    public static final class a {
    }

    static {
    }

    public static String e(e1 r4) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L30
        if (r4 == null) goto L6;
        String r2 = r4.g;     // Catch: Throwable -> L30
    L7:
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        String r5 = null;
    L28:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L30
    L33:
        if (Result.isFailure-impl(r6) == true) goto L37;
        r0 = r6;
    L37:
        return (String) r0;
    L15:
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L30
        if (r4 == null) goto L18;
        String r8 = r4.c();     // Catch: Throwable -> L30
    L19:
        r7.put("recommend_from", r8);     // Catch: Throwable -> L30
        if (r4 == null) goto L22;
        String r9 = r4.c;     // Catch: Throwable -> L30
    L23:
        r7.put("template_rec_req_id", r9);     // Catch: Throwable -> L30
        if (r4 == null) goto L26;
        String r10 = r4.b;     // Catch: Throwable -> L30
    L27:
        r7.put("from_template_id", r10);     // Catch: Throwable -> L30
        r5 = r7.toString();     // Catch: Throwable -> L30
        goto L28
    L26:
        r10 = null;
        goto L27
    L22:
        r9 = null;
        goto L23
    L18:
        r8 = null;
        goto L19
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    L6:
        r2 = null;
    L30:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    }

    public final void b(String r22, e1 r23) {
        Intrinsics.checkNotNullParameter(r23, "logParams");
        if (r22 != null) goto L5;
    L8:
        boolean r16 = true;
    L10:
        if (r16 == false) goto L188;
        FLogger.a.e("WcbSug_ActionHandler", "schema is empty");
        String r2 = r22;
        String r17 = "WcbSug_ActionHandler";
    L186:
        SmartRouter.buildRoute(this.a, r2).d();
        FLogger.a.d(r17, "jumpSchema schema=" + r2);
        return;
    L188:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L181
        String r15 = r23.a();     // Catch: Throwable -> L181
        r17 = "WcbSug_ActionHandler";
        String r14 = r23.c();     // Catch: Throwable -> L179
        x0 r3 = new x0(UriProtector.parse(r22));     // Catch: Throwable -> L179
        String r4 = r3.a("conversation_id");     // Catch: Throwable -> L179
        if (r4 != null) goto L17;
    L20:
        boolean r5 = true;
    L22:
        if (r5 == false) goto L29;
        com.larus.bmhome.chat.component.cvs.y r6 = this.b;     // Catch: Throwable -> L179
        if (r6 == null) goto L27;
        String r7 = r6.Y1();     // Catch: Throwable -> L179
        if (r7 == null) goto L27;
    L28:
        r3.b("conversation_id", r7);     // Catch: Throwable -> L179
    L27:
        r7 = "";
    L29:
        String r8 = r3.a("enter_method");     // Catch: Throwable -> L179
        if (r8 != null) goto L32;
    L35:
        boolean r9 = true;
    L36:
        if (r9 == false) goto L38;
        r3.b("enter_method", r15);     // Catch: Throwable -> L179
    L38:
        String r10 = r3.a("previous_page");     // Catch: Throwable -> L179
        if (r10 != null) goto L41;
    L44:
        boolean r11 = true;
    L45:
        if (r11 == false) goto L47;
        r3.b("previous_page", "chat");     // Catch: Throwable -> L179
    L47:
        String r12 = r3.a("recommend_from");     // Catch: Throwable -> L179
        if (r12 != null) goto L50;
    L53:
        boolean r13 = true;
    L54:
        if (r13 == false) goto L56;
        r3.b("recommend_from", r14);     // Catch: Throwable -> L179
    L56:
        String r19 = r3.a("ai_creation_recommend_from");     // Catch: Throwable -> L179
        if (r19 != null) goto L59;
    L62:
        boolean r20 = true;
    L63:
        if (r20 == false) goto L65;
        r3.b("ai_creation_recommend_from", r14);     // Catch: Throwable -> L179
    L65:
        String r21 = r3.a("template_rec_req_id");     // Catch: Throwable -> L179
        if (r21 != null) goto L68;
    L71:
        boolean r24 = true;
    L72:
        if (r24 == false) goto L77;
        String r25 = r23.c;     // Catch: Throwable -> L179
        if (r25 != null) goto L76;
        r25 = "";
    L76:
        r3.b("template_rec_req_id", r25);     // Catch: Throwable -> L179
    L77:
        String r26 = r3.a("reco_request_id");     // Catch: Throwable -> L179
        if (r26 != null) goto L80;
    L83:
        boolean r27 = true;
    L84:
        if (r27 == false) goto L89;
        String r28 = r23.c;     // Catch: Throwable -> L179
        if (r28 != null) goto L88;
        r28 = "";
    L88:
        r3.b("reco_request_id", r28);     // Catch: Throwable -> L179
    L89:
        String r29 = r3.a("prompt_type");     // Catch: Throwable -> L179
        if (r29 != null) goto L92;
    L95:
        boolean r30 = true;
    L96:
        if (r30 == false) goto L106;
        String r31 = r23.e;     // Catch: Throwable -> L179
        if (r31 != null) goto L100;
    L103:
        boolean r32 = true;
    L104:
        if (r32 == true) goto L106;
        r3.b("prompt_type", r23.e);     // Catch: Throwable -> L179
        goto L106
    L100:
        if (r31.length() == 0) goto L103;
        r32 = false;
    L106:
        String r33 = r3.a("prompt_from");     // Catch: Throwable -> L179
        if (r33 != null) goto L109;
    L112:
        boolean r34 = true;
    L113:
        if (r34 == false) goto L123;
        String r35 = r23.f;     // Catch: Throwable -> L179
        if (r35 != null) goto L117;
    L120:
        boolean r36 = true;
    L121:
        if (r36 == true) goto L123;
        r3.b("prompt_from", r23.f);     // Catch: Throwable -> L179
        goto L123
    L117:
        if (r35.length() == 0) goto L120;
        r36 = false;
    L123:
        String r37 = r3.a("visual_size");     // Catch: Throwable -> L179
        if (r37 != null) goto L126;
    L129:
        boolean r38 = true;
    L130:
        if (r38 == false) goto L140;
        String r39 = r23.j;     // Catch: Throwable -> L179
        if (r39 != null) goto L134;
    L137:
        boolean r40 = true;
    L138:
        if (r40 == true) goto L140;
        r3.b("visual_size", r23.j);     // Catch: Throwable -> L179
        goto L140
    L134:
        if (r39.length() == 0) goto L137;
        r40 = false;
    L140:
        String r41 = r3.a("tag_code");     // Catch: Throwable -> L179
        if (r41 != null) goto L143;
    L146:
        boolean r42 = true;
    L147:
        if (r42 == false) goto L157;
        String r43 = r23.h;     // Catch: Throwable -> L179
        if (r43 != null) goto L151;
    L154:
        boolean r44 = true;
    L155:
        if (r44 == true) goto L157;
        r3.b("tag_code", r23.h);     // Catch: Throwable -> L179
        goto L157
    L151:
        if (r43.length() == 0) goto L154;
        r44 = false;
    L157:
        String r45 = r3.a("item_id");     // Catch: Throwable -> L179
        if (r45 != null) goto L160;
    L163:
        boolean r46 = true;
    L164:
        if (r46 == false) goto L174;
        String r47 = r23.b;     // Catch: Throwable -> L179
        if (r47 != null) goto L168;
    L171:
        boolean r110 = true;
    L172:
        if (r110 == true) goto L174;
        r3.b("item_id", r23.b);     // Catch: Throwable -> L179
        goto L174
    L168:
        if (r47.length() == 0) goto L171;
        r110 = false;
    L174:
        r2 = r3.toString();     // Catch: Throwable -> L179
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L177
    L185:
        Result.box-impl(r0);
    L177:
        th = th;
    L184:
        Result.Companion r48 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L185
    L160:
        if (r45.length() == 0) goto L163;
        r46 = false;
        goto L164
    L143:
        if (r41.length() == 0) goto L146;
        r42 = false;
        goto L147
    L126:
        if (r37.length() == 0) goto L129;
        r38 = false;
        goto L130
    L109:
        if (r33.length() == 0) goto L112;
        r34 = false;
        goto L113
    L92:
        if (r29.length() == 0) goto L95;
        r30 = false;
        goto L96
    L80:
        if (r26.length() == 0) goto L83;
        r27 = false;
        goto L84
    L68:
        if (r21.length() == 0) goto L71;
        r24 = false;
        goto L72
    L59:
        if (r19.length() == 0) goto L62;
        r20 = false;
        goto L63
    L50:
        if (r12.length() == 0) goto L53;
        r13 = false;
        goto L54
    L41:
        if (r10.length() == 0) goto L44;
        r11 = false;
        goto L45
    L32:
        if (r8.length() == 0) goto L35;
        r9 = false;
        goto L36
    L17:
        if (r4.length() == 0) goto L20;
        r5 = false;
    L179:
        th = th;
    L183:
        r2 = r22;
    L181:
        th = th;
        r17 = "WcbSug_ActionHandler";
        goto L183
    L5:
        if (r22.length() == 0) goto L8;
        r16 = false;
        goto L10
    }

    public final void c(String r17, long r18, e1 r20) {
        Intrinsics.checkNotNullParameter(r20, "logParams");
        PromptBizType r1 = r20.a;
        PromptBizType r2 = PromptBizType.FIRST_MET;
        boolean r3 = true;
        if (r1 != r2) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        String r5 = "first_met";
    L9:
        String r7 = r20.a();
        HashMap r13 = new HashMap();
        r13.put("chat_key", Long.valueOf(r18));
        r13.put("click_from", r5);
        LinkedHashMap r10 = new LinkedHashMap();
        String r6 = r20.f;
        if (r6 == null) goto L12;
        String r8 = (String) r10.put("prompt_from", r6);
    L12:
        String r9 = r20.e;
        if (r9 == null) goto L15;
        String r11 = (String) r10.put("prompt_type", r9);
    L15:
        String r12 = r20.h;
        if (r12 == null) goto L18;
        String r14 = (String) r10.put("tag_code", r12);
    L18:
        String r15 = r20.c;
        if (r15 == null) goto L21;
        String r16 = (String) r10.put("reco_request_id", r15);
    L21:
        String r19 = r20.b;
        if (r19 == null) goto L24;
        String r21 = (String) r10.put("item_id", r19);
    L24:
        String r22 = r20.b;
        if (r22 == null) goto L27;
        String r23 = (String) r10.put("onboarding_item_id", r22);
    L27:
        r10.put("original_content_source", r20.b());
        r10.put("content_source_entrance_to_record", r7);
        r10.put("direct_use_text_message_event_ext", "true");
        if (r20.a == r2) goto L31;
        r3 = false;
    L31:
        if (r3 == false) goto L33;
        String r24 = "onboarding_first_met";
    L34:
        zb8.e r25 = this.g;
        if (r25 == null) goto L37;
        e$a.b(r25, "prompt_direct_send", r13, new zb8.a(r17, r7, r24, MapsKt.emptyMap(), r10, null, 32), null, null, false, 120);
    L37:
        FLogger.a.i("WcbSug_ActionHandler", "openCameraAndSendPrompt prompt=" + r17 + ", logParams=" + r20);
        return;
    L33:
        r24 = r7;
        goto L34
    L8:
        r5 = "new_topic";
        goto L9
    L5:
        r4 = false;
        goto L6
    }

    public final void d(String r9, boolean r10, e1 r11) {
        Intrinsics.checkNotNullParameter(r11, "logParams");
        if (r9 != null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        FLogger.a.e("WcbSug_ActionHandler", "wcb creation id is empty");
    L12:
        String r1 = r11.a();
        String r2 = r11.c();
        com.bytedance.router.i r3 = SmartRouter.buildRoute(this.a, "//flow/creation_detail_page");
        r3.c.putExtra("direct_use_template", r10 ? 1 : 0);
        String r4 = "";
        if (r9 != null) goto L15;
        String r5 = "";
    L16:
        r3.c.putExtra("creation_id", r5);
        String r6 = r11.c;
        if (r6 != null) goto L19;
        r6 = "";
    L19:
        r3.c.putExtra("template_rec_req_id", r6);
        String r7 = r11.c;
        if (r7 == null) goto L23;
        r4 = r7;
    L23:
        r3.c.putExtra("reco_request_id", r4);
        r3.c.putExtra("enter_method", r1);
        r3.c.putExtra("prompt_type", r11.e);
        r3.c.putExtra("prompt_from", r11.f);
        r3.c.putExtra("visual_size", r11.j);
        r3.c.putExtra("tag_code", r11.h);
        r3.c.putExtra("item_id", r11.b);
        r3.c.putExtra("recommend_from", r2);
        r3.c.putExtra("ai_creation_recommend_from", r2);
        r3.c.putExtra("position", r11.d);
        r3.d();
        FLogger.a.d("WcbSug_ActionHandler", "openCreationDetail creationId=" + r9 + " autoDoSame=" + r10 + " logParams=" + r11);
        return;
    L15:
        r5 = r9;
        goto L16
    L5:
        if (r9.length() == 0) goto L8;
        r0 = false;
        goto L10
    }

    public final void f(String r32, boolean r33, e1 r34, Map<String, String> r35) {
        Intrinsics.checkNotNullParameter(r34, "logParams");
        String r5 = r34.a();
        String r6 = r34.c();
        if (r34.a != PromptBizType.FIRST_MET) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L8;
        String r8 = "onboarding_first_met";
    L9:
        com.larus.bmhome.chat.component.bottom.multimodal.g r9 = this.c;
        if (r9 == null) goto L58;
        com.larus.bmhome.chat.component.bottom.multimodal.f1.a r10 = new com.larus.bmhome.chat.component.bottom.multimodal.f1.a(r33, 0, 2);
        com.larus.bmhome.chat.component.bottom.multimodal.g1 r11 = new com.larus.bmhome.chat.component.bottom.multimodal.g1(false, MultimodalBizScene.PromptCellAlbum, false);
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("enter_method", r5);
        if (r34.a == PromptBizType.SUGGEST) goto L51;
        r12.put("scene_for_text", r8);
        String r13 = r34.b;
        String r14 = "";
        if (r13 != null) goto L16;
        r13 = "";
    L16:
        r12.put("item_id", r13);
        String r15 = r34.b;
        if (r15 != null) goto L19;
        r15 = "";
    L19:
        r12.put("onboarding_item_id", r15);
        r12.put("original_content_source", r34.b());
        String r16 = r34.c;
        if (r16 != null) goto L22;
        r16 = "";
    L22:
        r12.put("reco_request_id", r16);
        String r17 = r34.c;
        if (r17 != null) goto L25;
        r17 = "";
    L25:
        r12.put("template_rec_req_id", r17);
        r12.put("direct_use_text_message_event_ext", "true");
        String r18 = r34.e;
        if (r18 != null) goto L28;
        r18 = "";
    L28:
        r12.put("prompt_type", r18);
        String r19 = r34.f;
        if (r19 == null) goto L31;
        String r20 = (String) r12.put("prompt_from", r19);
    L31:
        String r21 = r34.j;
        if (r21 == null) goto L34;
        String r22 = (String) r12.put("visual_size", r21);
    L34:
        String r23 = r34.h;
        if (r23 == null) goto L37;
        String r24 = (String) r12.put("tag_code", r23);
    L37:
        String r25 = r34.i;
        if (r25 == null) goto L41;
        String r26 = (String) r12.put("action_bar_template_id", r25);
    L41:
        if (com.larus.utils.o0.d(r34.g) == false) goto L50;
        r12.put("ai_creation_recommend_from", r6);
        String r27 = r34.b;
        if (r27 != null) goto L45;
        r27 = "";
    L45:
        r12.put("from_template_id", r27);
        String r28 = r34.g;
        if (r28 == null) goto L49;
        r14 = r28;
    L49:
        r12.put("from_template_sub_type", r14);
    L50:
        r12.put("content_source_entrance_to_record", r5);
    L51:
        Unit r29 = Unit.INSTANCE;
        LinkedHashMap r30 = new LinkedHashMap();
        if (r35 == null) goto L54;
        r30.putAll(r35);
    L54:
        String r31 = e(r34);
        if (r31 == null) goto L57;
        r30.put("creation_template", r31);
    L57:
        com.larus.bmhome.chat.component.bottom.multimodal.h1 r36 = new com.larus.bmhome.chat.component.bottom.multimodal.h1(r32, r30, r12);
        LinkedHashMap r37 = new LinkedHashMap();
        r37.put("upload_file_click_from", r5);
        r9.n90(new com.larus.bmhome.chat.component.bottom.multimodal.e1(r10, r11, r36, r37));
    L58:
        com.larus.bmhome.chat.component.cvs.y r38 = this.b;
        String r39 = null;
        if (r38 == null) goto L61;
        String r40 = r38.getBotId();
    L62:
        String r41 = r34.a();
        String r42 = r34.a();
        com.larus.bmhome.chat.component.cvs.y r43 = this.b;
        if (r43 == null) goto L67;
        wc9.e r44 = r43.h();
        if (r44 == null) goto L67;
        r39 = ic8.n.f(r44);
    L67:
        tx9.c0.H(r40, r41, r42, null, r39, "chat", null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, 33554376);
        FLogger.a.d("WcbSug_ActionHandler", "selectPicAndSendPrompt multiTake=" + r33 + " prompt=" + r32 + " logParams=" + r34 + ' ' + r35);
        return;
    L61:
        r40 = null;
        goto L62
    L8:
        r8 = r5;
        goto L9
    L5:
        r7 = false;
        goto L6
    }

    public static final Map<String, String> h(MessageTag r3, PromptContent.SuggestV2 r4, Message r5, Map<String, String> r6, Pair<String, String>... r7) {
        ILegacyChatUiServiceDelegate r0 = ILegacyChatUiServiceDelegate.b;
        SpreadBuilder r1 = new SpreadBuilder(5);
        r1.add(TuplesKt.to("from_onboarding", r3.toString()));
        r1.add(TuplesKt.to("from_suggest", "1"));
        if (r4 == null) goto L6;
        String r8 = r4.getExtra();
        if (r8 == null) goto L6;
    L7:
        r1.add(TuplesKt.to("suggest_extra", r8));
        r1.add(TuplesKt.to("click_clear_context", String.valueOf(com.larus.bmhome.chat.bean.d.x(r5).isClickClearContext())));
        r1.addSpread(r7);
        Map<String, String> r9 = MapsKt.toMutableMap(r0.S8((Pair[]) r1.toArray(new Pair[r1.size()])));
        if (r6 == null) goto L13;
        Iterator<Map.Entry<String, String>> r10 = r6.entrySet().iterator();
    L11:
        if (r10.hasNext() == false) goto L13;
        Map.Entry<String, String> r11 = r10.next();
        r9.put(r11.getKey(), r11.getValue());
    L13:
        return r9;
    L6:
        r8 = "";
        goto L7
    }

    public final void a(CharSequence r24, Pair<Integer, Integer> r25, e1 r26, Map<String, String> r27, Map<String, String> r28, String r29, Message r30) {
        Intrinsics.checkNotNullParameter(r26, "logParams");
        FLogger r6 = FLogger.a;
        r6.i("WcbSug_ActionHandler", "fillInput text=" + r24 + ", selectionPos=" + r25 + ", logParams=" + r26);
        if (r24 != null) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r8 == false) goto L11;
        return;
    L11:
        String r9 = StringsKt.replace$default(r24.toString(), "￼", "", false, 4, null);
        LinkedHashMap r10 = new LinkedHashMap();
        String r11 = r26.f;
        if (r11 == null) goto L14;
        String r12 = (String) r10.put("prompt_from", r11);
    L14:
        String r13 = r26.e;
        if (r13 == null) goto L17;
        String r14 = (String) r10.put("prompt_type", r13);
    L17:
        String r15 = r26.h;
        if (r15 == null) goto L20;
        String r16 = (String) r10.put("tag_code", r15);
    L20:
        String r17 = r26.c;
        if (r17 == null) goto L23;
        String r18 = (String) r10.put("reco_request_id", r17);
    L23:
        String r19 = r26.c;
        if (r19 == null) goto L26;
        String r110 = (String) r10.put("template_rec_req_id", r19);
    L26:
        String r111 = r26.b;
        if (r111 == null) goto L29;
        String r112 = (String) r10.put("item_id", r111);
    L29:
        String r113 = r26.b;
        if (r113 == null) goto L32;
        String r114 = (String) r10.put("onboarding_item_id", r113);
    L32:
        r10.put("enter_method", r26.a());
        if (r27 == null) goto L35;
        r10.putAll(r27);
    L35:
        c1 r3 = this.k;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r9, "prompt");
        Intrinsics.checkNotNullParameter(r10, "params");
        r3.e = r10;
        r3.f = r28;
        r3.g = r29;
        if (r3.h == true) goto L47;
        ICoreInputAbility r4 = r3.a;
        if (r4 == null) goto L40;
        r4.QG(r3.j);
    L40:
        ICoreInputAbility r5 = r3.a;
        if (r5 == null) goto L43;
        r5.Jm(r3.k);
    L43:
        ICoreInputAbility r7 = r3.a;
        if (r7 == null) goto L46;
        r7.Fz(r3.l);
    L46:
        r3.h = true;
    L47:
        com.larus.bmhome.instruction.h r20 = r3.c;
        if (r20 == null) goto L50;
        r20.qz(r28, "PromptFillInputManager.recordSendMessageLogParams");
    L50:
        IAIChatRenderTraceService.a.m(r3.a(), r9);
        r6.i("WcbFillInputMgr", "record params=" + r3.e);
        Integer r21 = null;
        if (r30 != null) goto L53;
    L55:
        Message r22 = null;
    L56:
        this.k.i = r22;
        if ((r24 instanceof Spanned) == false) goto L66;
        va8.o r23 = this.h;
        if (r23 == null) goto L66;
        if (r25 == null) goto L62;
        Integer r31 = (Integer) r25.getFirst();
    L63:
        if (r25 == null) goto L65;
        r21 = (Integer) r25.getSecond();
    L65:
        r23.ZV(r24, r31, r21);
        return;
    L62:
        r31 = null;
    L66:
        ICoreInputAbility r115 = this.f;
        if (r115 != null) goto L69;
        return;
    L69:
        if (r25 == null) goto L71;
        Integer r116 = (Integer) r25.getFirst();
    L72:
        if (r25 == null) goto L74;
        Integer r210 = (Integer) r25.getSecond();
    L75:
        ICoreInputAbility.b.d(r115, r9, true, true, r116, r210, false, 32);
        return;
    L74:
        r210 = null;
        goto L75
    L71:
        r116 = null;
        goto L72
    L53:
        if (com.larus.bmhome.chat.bean.d.W0(r30) == false) goto L55;
        r22 = r30;
        goto L56
    L5:
        if (r24.length() == 0) goto L8;
        r8 = false;
        goto L9
    }

    public d1(Context r2, com.larus.bmhome.chat.component.cvs.y r3, com.larus.bmhome.chat.component.bottom.multimodal.g r4, gd8.g r5, u7 r6, ICoreInputAbility r7, zb8.e r8, va8.o r9, com.larus.bmhome.instruction.h r10, fx9.a r11) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = new c1(r7, r3, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    public final void g(Message r32, PromptContent.SuggestV2 r33, PromptContent.SuggestItem r34, wc9.e r35, String r36, boolean r37, String r38, String r39, Map<String, String> r40, Map<String, String> r41, Map<String, String> r42, e1 r43) {
        String r5 = r39;
        Map<String, String> r7 = r41;
        Intrinsics.checkNotNullParameter(r32, "data");
        Intrinsics.checkNotNullParameter(r36, "sendContent");
        long r10 = System.currentTimeMillis();
        FLogger.a.d("WcbSug_ActionHandler", "sendText prompt=" + r36 + " secScene=" + r5 + " extra=" + r40 + " eventExt=" + r7);
        u7 r12 = this.e;
        if (r12 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == true) goto L201;
        if (r35 != null) goto L11;
    L13:
        boolean r14 = false;
    L14:
        if (r14 == false) goto L202;
        MessageTag r15 = com.larus.bmhome.chat.bean.d.D(r32);
        if (com.larus.bmhome.chat.bean.d.z0(r32) == true) goto L135;
        String r6 = com.larus.bmhome.chat.bean.d.f1(r32, r33, null);
        if (Intrinsics.areEqual(r6, "related_video_suggested_prompt") == false) goto L23;
        gd8.g r8 = this.d;
        if (r8 == null) goto L203;
        gd8.g.a.b(r8, r35.a, r36, "related_video_suggestion", h(r15, r33, r32, r42, new Pair[0]), false, null, null, null, null, Long.valueOf(r10), 1520);
        return;
    L203:
        return;
    L23:
        if (Intrinsics.areEqual(r6, "search_related_suggested_prompt") == false) goto L27;
        gd8.g r9 = this.d;
        if (r9 == null) goto L205;
        gd8.g.a.b(r9, r35.a, r36, "related_search_suggestion", h(r15, r33, r32, r42, new Pair[0]), false, null, null, null, null, Long.valueOf(r10), 1520);
        return;
    L205:
        return;
    L27:
        if (r33 == null) goto L29;
        PromptContent.SuggestV2Extra r11 = r33.getSuggestV2Extra();
    L30:
        com.larus.bmhome.actionbar.util.g r16 = com.larus.bmhome.actionbar.util.g.a;
        Pair[] r17 = new Pair[0];
        String r18 = r32.getLocalMessageId();
        if (r18 == null) goto L35;
        PromptContent.SuggestV2Extra r310 = r11;
        long r19 = r10;
        String r110 = null;
        if (StringsKt.contains$default(r18, "-aweme", false, 2, null) != true) goto L36;
        boolean r4 = true;
    L37:
        if (r4 == false) goto L55;
        Object[] r20 = ArraysKt.plus(r17, TuplesKt.to("from_video_suggest", "1"));
        Map r21 = r32.getBusinessExt();
        if (r21 == null) goto L42;
        String r22 = (String) r21.get("feed_video_summary_id");
        if (r22 == null) goto L42;
    L43:
        Pair[] r23 = (Pair[]) ArraysKt.plus(r20, TuplesKt.to("feed_video_summary_id", r22));
        if (r33 == null) goto L48;
        PromptContent.SuggestV2ExtraForMultiAction r24 = r33.getSuggestV2ExtForMultiAction();
        if (r24 == null) goto L48;
        String r25 = r24.getSuggestActionType();
    L50:
        if (com.larus.utils.o0.d(r25) == false) goto L54;
        if (r25 != null) goto L53;
        r25 = "";
    L53:
        r23 = (Pair[]) ArraysKt.plus(r23, TuplesKt.to("trace_item_type", r25));
    L54:
        r17 = r23;
    L48:
        r25 = r110;
    L42:
        r22 = "";
    L55:
        Map r26 = MapsKt.toMutableMap(h(r15, r33, r32, r42, (Pair[]) Arrays.copyOf(r17, r17.length)));
        r16.getClass();
        Intrinsics.checkNotNullParameter(r32, "data");
        Intrinsics.checkNotNullParameter(r26, "originExt");
        Map r27 = r32.getExt();
        if (r27 == null) goto L60;
        boolean r28 = true;
        if (r27.containsKey(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION) != true) goto L61;
        boolean r111 = true;
    L62:
        if (r111 == false) goto L80;
        String r29 = (String) r27.get(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION);
        if (r29 != null) goto L66;
    L68:
        boolean r30 = false;
    L69:
        if (r30 == false) goto L80;
        com.larus.bmhome.actionbar.model.r r31 = com.larus.bmhome.actionbar.util.h.a(r32);
        if (r31 == null) goto L73;
        Object r44 = r31.a;
    L75:
        if (CollectionsKt.contains(CollectionsKt.arrayListOf(new Integer[]{14, 7, 29, 12, 13}), r44) == false) goto L80;
        String r45 = (String) r27.get(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION);
        if (r45 != null) goto L79;
        r45 = "";
    L79:
        r26.put(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION, r45);
        goto L80
    L73:
        r44 = r110;
        goto L75
    L66:
        if (com.flow.kmp.common.util.f.a(r29) != r28) goto L68;
        r30 = true;
    L80:
        Map r46 = MapsKt.toMutableMap(r26);
        if (r34 == null) goto L90;
        Map<String, String> r47 = r34.getSendMsgExtra();
        if (r47 == null) goto L90;
        boolean r48 = !r47.isEmpty();
        Object r49 = r47;
        if (r48 == true) goto L88;
        r49 = r110;
    L88:
        if (r49 == null) goto L90;
        r46.putAll(r49);
    L90:
        if (r7 == null) goto L97;
        ?? r50 = r7;
        if ((!r41.isEmpty()) == true) goto L95;
        r50 = r110;
    L95:
        if (r50 == 0) goto L97;
        IAIChatRenderTraceService.a.c(r35.a, r50);
    L97:
        gd8.g r51 = this.d;
        if (r51 == null) goto L207;
        String r3 = r35.a;
        String r2 = y0.d(r33);
        if (r2 == null) goto L102;
        String r52 = r2;
    L115:
        Pair[] r1 = new Pair[4];
        r1[0] = TuplesKt.to("suggested_click_from", "bubble");
        if (r310 == null) goto L118;
        String r53 = r310.getDeepResearchPhase();
    L119:
        if (r53 != null) goto L121;
        r53 = "";
    L121:
        r1[1] = TuplesKt.to("deep_research_phase", r53);
        if (r310 == null) goto L124;
        String r54 = r310.getDeepResearchEntrance();
    L125:
        if (r54 != null) goto L127;
        r54 = "";
    L127:
        r1[2] = TuplesKt.to("deep_research_entrance", r54);
        if (r310 == null) goto L130;
        String r112 = r310.getDeepResearchId();
    L131:
        if (r112 != null) goto L133;
        r112 = "";
    L133:
        r1[3] = TuplesKt.to("deep_research_id", r112);
        gd8.g.a.b(r51, r3, r36, r52, r46, false, null, new ReferenceInfo(null, null, null, 0, null, null, MapsKt.mapOf(r1), null, 191, null), null, null, Long.valueOf(r19), 1456);
        return;
    L130:
        r112 = r110;
        goto L131
    L124:
        r54 = r110;
        goto L125
    L118:
        r53 = r110;
        goto L119
    L102:
        Map r55 = r32.getBusinessExt();
        if (r55 == null) goto L105;
        String r56 = (String) r55.get("suggested_type");
    L106:
        if (r56 == null) goto L113;
        Map r57 = r32.getBusinessExt();
        if (r57 == null) goto L110;
        String r58 = (String) r57.get("suggested_type");
    L111:
        if (r58 != null) goto L114;
        r58 = "";
    L114:
        r52 = r58;
        goto L115
    L110:
        r58 = r110;
        goto L111
    L113:
        r58 = "suggested_prompts";
        goto L114
    L105:
        r56 = r110;
        goto L106
    L207:
        return;
    L61:
        r111 = false;
        goto L62
    L60:
        r28 = true;
    L36:
        r4 = false;
        goto L37
    L35:
        r310 = r11;
        r19 = r10;
        r110 = null;
        goto L36
    L29:
        r11 = null;
        goto L30
    L135:
        if (com.larus.bmhome.chat.bean.d.k0(r32) == false) goto L138;
        String r59 = "onboarding_first_met";
        String r60 = "onboarding_first_met_sug";
    L148:
        if (com.larus.utils.o0.d(com.larus.im.bean.message.a.x(r32)) == false) goto L163;
        Pair[] r113 = new Pair[4];
        if (r60 != null) goto L152;
        r60 = "";
    L152:
        r113[0] = TuplesKt.to("source", r60);
        if (r38 != null) goto L155;
        String r61 = "";
    L156:
        r113[1] = TuplesKt.to("onboarding_card_id", r61);
        if (r5 != null) goto L159;
        r5 = "";
    L159:
        r113[2] = TuplesKt.to("sec_scene", r5);
        String r62 = com.larus.im.bean.message.a.x(r32);
        if (r62 != null) goto L162;
        r62 = "";
    L162:
        r113[3] = TuplesKt.to("inner_log_id", r62);
        Map<String, String> r63 = h(r15, r33, r32, r42, r113);
    L174:
        Map r64 = MapsKt.toMutableMap(r63);
        if (r40 == null) goto L179;
        r64.putAll(r40);
        if (com.larus.bmhome.chat.bean.d.x(r32).getLocalSubCoCoMsg() == false) goto L179;
        r64.put("sub_conv_firstmet_type", "2");
    L179:
        if (r34 == null) goto L183;
        String r65 = r34.getItemType();
        if (r65 == null) goto L183;
        r64.put("trace_item_type", r65);
    L183:
        if (r34 == null) goto L187;
        String r66 = r34.getWcbItem();
        if (r66 == null) goto L187;
        r64.put("wcb_item_info", r66);
    L187:
        String r67 = e(r43);
        if (r67 == null) goto L190;
        r64.put("creation_template", r67);
    L190:
        if (r7 == null) goto L197;
        Map<String, String> r68 = r7;
        if ((!r41.isEmpty()) == true) goto L195;
        r68 = null;
    L195:
        if (r68 == null) goto L197;
        IAIChatRenderTraceService.a.c(r35.a, r68);
    L197:
        gd8.g r69 = this.d;
        if (r69 == null) goto L209;
        gd8.g.a.b(r69, r35.a, r36, r59, r64, false, null, null, null, null, Long.valueOf(r10), 1456);
        return;
    L209:
        return;
    L155:
        r61 = r38;
        goto L156
    L163:
        Pair[] r114 = new Pair[3];
        if (r60 != null) goto L166;
        r60 = "";
    L166:
        r114[0] = TuplesKt.to("source", r60);
        if (r38 != null) goto L169;
        String r70 = "";
    L170:
        r114[1] = TuplesKt.to("onboarding_card_id", r70);
        if (r5 != null) goto L173;
        r5 = "";
    L173:
        r114[2] = TuplesKt.to("sec_scene", r5);
        r63 = h(r15, r33, r32, r42, r114);
        goto L174
    L169:
        r70 = r38;
        goto L170
    L138:
        if (com.larus.bmhome.chat.bean.d.W0(r32) == false) goto L144;
        if (r37 == false) goto L141;
        r59 = "new_topic";
    L142:
        r60 = "onboarding_welcome_back_sug";
        goto L148
    L141:
        r59 = "onboarding_welcome_back";
        goto L142
    L144:
        if (com.larus.bmhome.chat.bean.d.s0(r32) == false) goto L146;
        r59 = "onboarding_longtimenosee";
        r60 = null;
        goto L148
    L146:
        r60 = null;
        r59 = "";
        goto L148
    L202:
        return;
    L11:
        if (r35.h() == true) goto L13;
        r14 = true;
        goto L14
    L201:
        return;
    L5:
        if (r12.W1() != true) goto L7;
        r13 = true;
        goto L8
    }
}
