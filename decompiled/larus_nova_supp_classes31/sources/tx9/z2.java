package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class z2 {
    public static void a(String r18, String r19, String r20, String r21, String r22, Integer r23, String r24, Long r25, Long r26, Long r27, Long r28, Long r29, Long r30, Long r31, String r32, String r33, Long r34, Long r35, Long r36, Long r37, Long r38, Long r39, Long r40, Long r41, Long r42, Long r43, String r44, String r45, Integer r46, String r47, String r48, String r49, JSONObject r50, by7.e r51, Long r52, String r53, String r54, String r55, String r56, String r57, String r58, String r59, String r60, String r61, Integer r62, Integer r63, String r64, String r65, String r66, String r67, Integer r68, String r69, String r70, Integer r71, Integer r72, String r73, Long r74, String r75, String r76, Integer r77, String r78, String r79, String r80, String r81, Map r82, String r83) {
        Intrinsics.checkNotNullParameter(r50, "params");
        if (r82 != null) goto L153;
    L8:
        r50.putOpt("ai_create_show_mode", r58);     // Catch: JSONException -> L146
        r50.putOpt("ai_creation_tool_list", r59);     // Catch: JSONException -> L146
        if (r44 == null) goto L11;
        r50.put("source_type", r44);     // Catch: JSONException -> L146
    L11:
        if (r45 == null) goto L13;
        r50.put("task_id", r45);     // Catch: JSONException -> L146
    L13:
        if (r18 == null) goto L15;
        r50.put("message_id", r18);     // Catch: JSONException -> L146
    L15:
        if (r19 == null) goto L17;
        r50.put("reply_id", r19);     // Catch: JSONException -> L146
    L17:
        if (r20 == null) goto L19;
        r50.put("section_id", r20);     // Catch: JSONException -> L146
    L19:
        if (r21 == null) goto L21;
        r50.put("conversation_id", r21);     // Catch: JSONException -> L146
    L21:
        r50.put("bot_id", r22);     // Catch: JSONException -> L146
        if (r23 == null) goto L24;
        r50.put("bot_type", r23.intValue());     // Catch: JSONException -> L146
    L24:
        if (r24 == null) goto L26;
        r50.put("chat_type", r24);     // Catch: JSONException -> L146
    L26:
        if (r25 == null) goto L28;
        r50.put("message_height", r25.longValue());     // Catch: JSONException -> L146
    L28:
        if (r26 == null) goto L30;
        r50.put("thinking_content_height", r26.longValue());     // Catch: JSONException -> L146
    L30:
        if (r27 == null) goto L32;
        r50.put("show_duration", r27.longValue());     // Catch: JSONException -> L146
    L32:
        if (r28 == null) goto L34;
        r50.put("read_duration", r28.longValue());     // Catch: JSONException -> L146
    L34:
        if (r29 == null) goto L36;
        r50.put("thinking_content_read_duration", r29.longValue());     // Catch: JSONException -> L146
    L36:
        if (r30 == null) goto L38;
        r50.put("is_stream", r30.longValue());     // Catch: JSONException -> L146
    L38:
        if (r31 == null) goto L40;
        r50.put("is_regenerate", r31.longValue());     // Catch: JSONException -> L146
    L40:
        if (r32 == null) goto L42;
        r50.put("start_method", r32);     // Catch: JSONException -> L146
    L42:
        if (r33 == null) goto L44;
        r50.put("end_method", r33);     // Catch: JSONException -> L146
    L44:
        r50.put("is_contain_ecommerce", r47);     // Catch: JSONException -> L146
        if (r34 == null) goto L47;
        r50.put("is_show_content_full_screen", r34.longValue());     // Catch: JSONException -> L146
    L47:
        if (r35 == null) goto L49;
        r50.put("is_message_finished_generation", r35.longValue());     // Catch: JSONException -> L146
    L49:
        if (r36 == null) goto L51;
        r50.put("is_thinking_content_finished_generation", r36.longValue());     // Catch: JSONException -> L146
    L51:
        if (r37 == null) goto L53;
        r50.put("is_message_fully_shown", r37.longValue());     // Catch: JSONException -> L146
    L53:
        if (r39 == null) goto L55;
        r50.put("is_answer_action_show", r39.longValue());     // Catch: JSONException -> L146
    L55:
        if (r38 == null) goto L57;
        r50.put("is_thinking_content_fully_shown", r38.longValue());     // Catch: JSONException -> L146
    L57:
        if (r40 == null) goto L59;
        r50.put("message_type", r40.longValue());     // Catch: JSONException -> L146
    L59:
        if (r41 == null) goto L61;
        r50.put("is_have_video", r41.longValue());     // Catch: JSONException -> L146
    L61:
        if (r42 == null) goto L63;
        r50.put("is_have_pic", r42.longValue());     // Catch: JSONException -> L146
    L63:
        if (r43 == null) goto L65;
        r50.put("message_show_area_height", r43.longValue());     // Catch: JSONException -> L146
    L65:
        if (r46 == null) goto L67;
        r50.put("index", r46.intValue());     // Catch: JSONException -> L146
    L67:
        if (r52 == null) goto L69;
        r50.put("is_deep_thinking", r52.longValue());     // Catch: JSONException -> L146
    L69:
        if (r48 == null) goto L71;
        r50.put("agent_id", r48);     // Catch: JSONException -> L146
    L71:
        if (r49 == null) goto L73;
        r50.put("msg_candidate_source", r49);     // Catch: JSONException -> L146
    L73:
        if (r53 == null) goto L75;
        r50.put("msg_group_id", r53);     // Catch: JSONException -> L146
    L75:
        if (r54 == null) goto L78;
        r50.put("user_case_item_id", r54);     // Catch: JSONException -> L146
    L78:
        if (r55 == null) goto L81;
        r50.put("user_case_reco_request_id", r55);     // Catch: JSONException -> L146
    L81:
        if (r57 == null) goto L84;
        r50.put("thinking_content_card_type", r57);     // Catch: JSONException -> L146
    L84:
        if (r56 == null) goto L87;
        r50.put("previous_page", r56);     // Catch: JSONException -> L146
    L87:
        if (r60 == null) goto L90;
        r50.put("page_token", r60);     // Catch: JSONException -> L146
    L90:
        if (r61 == null) goto L92;
        r50.put("artifact_meta_id", r61);     // Catch: JSONException -> L146
    L92:
        if (r62 == null) goto L94;
        r50.put("artifact_type", r62.intValue());     // Catch: JSONException -> L146
    L94:
        if (r63 == null) goto L97;
        r50.put("resource_type", r63.intValue());     // Catch: JSONException -> L146
    L97:
        if (r64 == null) goto L100;
        r50.put("presentation_id", r64);     // Catch: JSONException -> L146
    L100:
        if (r65 == null) goto L103;
        r50.put("resource_id", r65);     // Catch: JSONException -> L146
    L103:
        if (r66 == null) goto L106;
        r50.put("base_id", r66);     // Catch: JSONException -> L146
    L106:
        if (r67 == null) goto L108;
        r50.put("aippt_task_id", r67);     // Catch: JSONException -> L146
    L108:
        if (r68 == null) goto L111;
        r50.put("is_with_ai_doc", r68.intValue());     // Catch: JSONException -> L146
    L111:
        if (r69 == null) goto L114;
        r50.put("ai_doc_show_status", r69);     // Catch: JSONException -> L146
    L114:
        if (r70 == null) goto L116;
        r50.put("ai_doc_gen_status", r70);     // Catch: JSONException -> L146
    L116:
        if (r71 == null) goto L118;
        r50.put("is_float_chat", r71.intValue());     // Catch: JSONException -> L146
    L118:
        if (r72 == null) goto L121;
        r50.put("float_chat_shown_pct", r72.intValue());     // Catch: JSONException -> L146
    L121:
        if (r73 == null) goto L123;
        r50.put("is_chat_last_message", r73);     // Catch: JSONException -> L146
    L123:
        if (r74 == null) goto L125;
        r50.put("thinking_duration", r74.longValue());     // Catch: JSONException -> L146
    L125:
        r50.put("read_stop_scene", r75);     // Catch: JSONException -> L146
        if (r76 == null) goto L128;
        r50.put("block_types", r76);     // Catch: JSONException -> L146
    L128:
        if (r77 == null) goto L131;
        r50.put("status_local", r77.intValue());     // Catch: JSONException -> L146
    L131:
        if (com.larus.utils.o0.d(r78) == false) goto L134;
        r50.put("collection_id", r78);     // Catch: JSONException -> L146
    L134:
        if (com.larus.utils.o0.d(r79) == false) goto L137;
        r50.put("collection_name", r79);     // Catch: JSONException -> L146
    L137:
        if (com.larus.utils.o0.d(r80) == false) goto L140;
        r50.put("content_type", r80);     // Catch: JSONException -> L146
    L140:
        if (com.larus.utils.o0.d(r81) == false) goto L143;
        r50.put("content_sec_type", r81);     // Catch: JSONException -> L146
    L143:
        if (com.larus.utils.o0.d(r83) == false) goto L148;
        r50.put("spreadsheet_id", r83);     // Catch: JSONException -> L146
    L146:
        e = move-exception;
        FLogger.a.e("ReadEventHelper", "error in ReadEventHelper readMessage " + e.getLocalizedMessage());
    L148:
        TrackParams r0 = new TrackParams().merge(r50);
        by7.a r1 = new by7.a("read_message");
        if (r51 == null) goto L151;
        r1.b = r51;
    L151:
        r1.a.merge(r0);
        r1.b();
        com.larus.platform.service.g.a.monitorEventForSlardar("read_message", r0.makeJSONObject(), null, null);
        return;
    L153:
        Iterator r12 = r82.entrySet().iterator();     // Catch: JSONException -> L146
    L6:
        if (r12.hasNext() == false) goto L8;
        Map.Entry r16 = (Map.Entry) r12.next();     // Catch: JSONException -> L146
        r50.put((String) r16.getKey(), r16.getValue());     // Catch: JSONException -> L146
        r12 = r12;
        goto L6
    }
}
