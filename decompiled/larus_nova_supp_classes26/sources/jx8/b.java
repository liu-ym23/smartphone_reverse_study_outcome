package jx8;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.platform.spi.IChatTraceService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import v19.e6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new a());
    }

    public static IChatTraceService b() {
        return (IChatTraceService) a.getValue();
    }

    public static Map a(HashMap r4) {
        String r0 = null;
        if (r4 == null) goto L5;
        Object r5 = r4.get("general_params");
    L7:
        if ((r5 instanceof String) == false) goto L9;
        r0 = (String) r5;
    L9:
        if (r0 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == true) goto L17;
        LinkedHashMap r7 = new LinkedHashMap();     // Catch: Throwable -> L24
        JSONObject r1 = new JSONObject(r0);     // Catch: Throwable -> L24
        Iterator<String> r2 = r1.keys();     // Catch: Throwable -> L24
    L20:
        if (r2.hasNext() == false) goto L23;
        String r3 = r2.next();     // Catch: Throwable -> L24
        r7.put(r3, r1.get(r3));     // Catch: Throwable -> L24
        goto L20
    L23:
        return r7;
    L24:
        th = move-exception;
        FLogger.a.e("CameraEventHelper", "generalParams# err=" + th);
        return MapsKt.emptyMap();
    L17:
        return MapsKt.emptyMap();
    L11:
        if (StringsKt.isBlank(r0) == true) goto L14;
        r6 = false;
        goto L15
    L5:
        r5 = null;
        goto L7
    }

    public static void c(String r50, HashMap r51) {
        Intrinsics.checkNotNullParameter(r50, "mode");
        if (r51 == null) goto L5;
        Object r3 = r51.get("extra_params");
    L7:
        if ((r3 instanceof JSONObject) == false) goto L9;
        JSONObject r4 = (JSONObject) r3;
    L10:
        if (r51 == null) goto L12;
        Object r5 = r51.get("chat_key");
    L14:
        if ((r5 instanceof Long) == false) goto L16;
        Long r6 = (Long) r5;
    L17:
        IChatTraceService r7 = b();
        long r8 = 0;
        if (r7 == null) goto L24;
        if (r6 == null) goto L21;
        long r9 = r6.longValue();
    L22:
        String r10 = r7.c(r9);
        if (r10 == null) goto L24;
    L32:
        if (r51 == null) goto L34;
        Object r11 = r51.get("click_from");
    L36:
        if ((r11 instanceof String) == false) goto L38;
        String r12 = (String) r11;
    L40:
        if (r51 == null) goto L42;
        Object r13 = r51.get("is_ocr");
    L44:
        if ((r13 instanceof Integer) == false) goto L46;
        Integer r14 = (Integer) r13;
    L48:
        if (r51 == null) goto L50;
        Object r15 = r51.get("chat_type");
    L52:
        if ((r15 instanceof String) == false) goto L54;
        String r16 = (String) r15;
    L55:
        if (r16 != null) goto L62;
        IChatTraceService r17 = b();
        if (r17 == null) goto L61;
        if (r6 == null) goto L60;
        r8 = r6.longValue();
    L60:
        r16 = r17.h(r8);
        goto L62
    L61:
        r16 = null;
    L62:
        if (r4 == null) goto L64;
        String r18 = r4.optString("is_ai_ppt");
    L66:
        if (Intrinsics.areEqual(r18, "1") == false) goto L68;
        String r19 = r4.optString("current_page");
    L77:
        if (r51 == null) goto L79;
        Object r20 = r51.get("action_bar_template_id");
    L81:
        if ((r20 instanceof String) == false) goto L83;
        String r21 = (String) r20;
    L85:
        if (r51 == null) goto L87;
        Object r22 = r51.get("action_bar_template_type");
    L89:
        if ((r22 instanceof String) == false) goto L91;
        String r23 = (String) r22;
    L92:
        List<String> r24 = fx8.a.a;
        String r25 = r23;
        if (CollectionsKt.contains(CollectionsKt.arrayListOf(new String[]{"CAPTURE_MODE_EDU_GENERAL_PHOTO", "CAPTURE_MODE_EDU_ARTICLE_PHOTO", "CAPTURE_MODE_EDU_CALCULATION_PHOTO"}), r50) == false) goto L97;
        String r0 = "edu";
    L95:
        String r2 = r0;
        if (r51 == null) goto L103;
        Object r1 = r51.get("action_bar_key");
    L105:
        if ((r1 instanceof String) == false) goto L107;
        String r26 = (String) r1;
    L109:
        if (r51 == null) goto L111;
        Object r27 = r51.get("if_call");
    L113:
        if ((r27 instanceof Integer) == false) goto L115;
        Integer r28 = (Integer) r27;
    L117:
        if (r51 == null) goto L119;
        Object r29 = r51.get("call_enter_method");
    L121:
        if ((r29 instanceof String) == false) goto L123;
        String r30 = (String) r29;
    L125:
        if (r51 == null) goto L127;
        Object r31 = r51.get("cited_from_user_type");
    L129:
        if ((r31 instanceof String) == false) goto L131;
        String r32 = (String) r31;
    L133:
        if (r51 == null) goto L135;
        Object r33 = r51.get("cited_message_id");
    L137:
        if ((r33 instanceof String) == false) goto L139;
        String r34 = (String) r33;
    L140:
        e6 r35 = e6.a;
        String r36 = r34;
        String r37 = r35.b();
        if (r28 == null) goto L143;
        int r38 = r28.intValue();
    L144:
        String r39 = r35.c();
        if (r4 == null) goto L147;
        String r310 = r4.optString("aippt_task_id");
    L149:
        if (r4 == null) goto L151;
        String r311 = r4.optString("canvas_type");
    L153:
        if (r4 == null) goto L155;
        String r312 = r4.optString("presentation_id");
    L157:
        if (r4 == null) goto L159;
        String r41 = r4.optString("resource_id");
    L161:
        if (r4 == null) goto L163;
        Integer r42 = Integer.valueOf(r4.optInt("resource_type"));
    L165:
        if (r4 == null) goto L167;
        String r45 = r4.optString("artifact_meta_id");
    L168:
        String r40 = "artifact_type";
        if (r4 == null) goto L171;
        Integer r110 = Integer.valueOf(r4.optInt("artifact_type"));
    L172:
        Map r43 = a(r51);
        JSONObject r44 = new JSONObject();     // Catch: Throwable -> L183
        Iterator r46 = r43.entrySet().iterator();     // Catch: Throwable -> L183
    L175:
        if (r46.hasNext() == false) goto L182;
        Map.Entry r47 = (Map.Entry) r46.next();     // Catch: Throwable -> L183
        Iterator r48 = r46;
        String r49 = r40;
        r44.put((String) r47.getKey(), r47.getValue());     // Catch: Throwable -> L180
        r40 = r49;
        r46 = r48;
    L180:
        th = th;
    L185:
        FLogger.a.e("CameraEventHelper", "toJson err=" + th);
        r44 = new JSONObject();
    L187:
        if (o0.d(r30) == false) goto L189;
        r44.put("call_enter_method", r30);
    L189:
        if (r51 == null) goto L193;
        Object r52 = r51.get("is_live_tutor");
        if (r52 == null) goto L193;
        r44.put("is_live_tutor", r52);
    L193:
        Intrinsics.checkNotNullParameter(r44, "params");
        if (r10 != null) goto L259;
    L198:
        if (r12 == null) goto L200;
        r44.put("click_from", r12);     // Catch: JSONException -> L196
    L200:
        if (r14 == null) goto L202;
        r44.put("is_ocr", r14.intValue());     // Catch: JSONException -> L196
    L202:
        if (r16 == null) goto L204;
        r44.put("chat_type", r16);     // Catch: JSONException -> L196
    L204:
        if (r19 == 0) goto L208;
        r44.put("current_page", r19);     // Catch: JSONException -> L196
    L196:
        JSONException e = e;
        String r53 = r21;
    L213:
        String r54 = r25;
    L252:
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickCamera " + e.getLocalizedMessage());
    L253:
        TrackParams r55 = new TrackParams().merge(r44);
        by7.a r56 = new by7.a("click_camera");
        r56.a.merge(r55);
        r56.b();
        ChatInputService.b.d(r12, r53, r54);
        return;
    L208:
        if (r21 == 0) goto L214;
        r53 = r21;
        r44.put("action_bar_template_id", r53);     // Catch: JSONException -> L212
    L215:
        if (r25 == null) goto L218;
        r54 = r25;
        r44.put("action_bar_template_type", r54);     // Catch: JSONException -> L251
    L219:
        r44.put("camera_type", r2);     // Catch: JSONException -> L251
        r44.put("if_call", r38);     // Catch: JSONException -> L251
        if (r37 == 0) goto L222;
        r44.put("camera_status", r37);     // Catch: JSONException -> L251
    L222:
        if (r39 == null) goto L224;
        r44.put("mic_status", r39);     // Catch: JSONException -> L251
    L224:
        if (r26 == 0) goto L226;
        r44.put("action_bar_key", r26);     // Catch: JSONException -> L251
    L226:
        if (r32 != 0) goto L228;
    L231:
        boolean r111 = true;
    L232:
        if (r111 == false) goto L234;
        r44.put("cited_from_user_type", "no_cite");     // Catch: JSONException -> L251
    L235:
        if (r310 == null) goto L237;
        r44.put("aippt_task_id", r310);     // Catch: JSONException -> L251
    L237:
        if (r311 == null) goto L239;
        r44.put("canvas_type", r311);     // Catch: JSONException -> L251
    L239:
        if (r312 == null) goto L241;
        r44.put("presentation_id", r312);     // Catch: JSONException -> L251
    L241:
        if (r41 == null) goto L243;
        r44.put("resource_id", r41);     // Catch: JSONException -> L251
    L243:
        if (r42 == null) goto L245;
        r44.put("resource_type", r42.intValue());     // Catch: JSONException -> L251
    L245:
        if (r45 == null) goto L247;
        r44.put("artifact_meta_id", r45);     // Catch: JSONException -> L251
    L247:
        if (r110 == null) goto L249;
        r44.put(r49, r110.intValue());     // Catch: JSONException -> L251
    L249:
        r44.put("cited_message_id", r36);     // Catch: JSONException -> L251
        goto L253
    L234:
        r44.put("cited_from_user_type", r32);     // Catch: JSONException -> L251
        goto L235
    L228:
        if (r32.length() == 0) goto L231;
        r111 = false;
    L251:
        e = e;
        goto L252
    L218:
        r54 = r25;
    L212:
        e = e;
        goto L213
    L214:
        r53 = r21;
        goto L215
    L259:
        r44.put("bot_id", r10);     // Catch: JSONException -> L196
        goto L198
    L182:
        r49 = r40;
    L183:
        th = th;
        r49 = r40;
        goto L185
    L171:
        r110 = null;
        goto L172
    L167:
        r45 = null;
        goto L168
    L163:
        r42 = null;
        goto L165
    L159:
        r41 = null;
        goto L161
    L155:
        r312 = null;
        goto L157
    L151:
        r311 = null;
        goto L153
    L147:
        r310 = null;
        goto L149
    L143:
        r38 = 0;
        goto L144
    L139:
        r34 = null;
        goto L140
    L135:
        r33 = null;
        goto L137
    L131:
        r32 = null;
        goto L133
    L127:
        r31 = null;
        goto L129
    L123:
        r30 = null;
        goto L125
    L119:
        r29 = null;
        goto L121
    L115:
        r28 = null;
        goto L117
    L111:
        r27 = null;
        goto L113
    L107:
        r26 = null;
        goto L109
    L103:
        r1 = null;
        goto L105
    L97:
        if (CollectionsKt.contains(CollectionsKt.arrayListOf(new String[]{"CAPTURE_MODE_HEALTH_PHOTO", "CAPTURE_MODE_HEALTH_SECOND_PHOTO"}), r50) == false) goto L99;
        r0 = "health";
        goto L95
    L99:
        r0 = "general";
        goto L95
    L91:
        r23 = null;
        goto L92
    L87:
        r22 = null;
        goto L89
    L83:
        r21 = null;
        goto L85
    L79:
        r20 = null;
        goto L81
    L68:
        if (r6 == null) goto L70;
        r19 = "chat";
        goto L77
    L70:
        if (r51 == null) goto L72;
        boolean r57 = Intrinsics.areEqual(r51.get("is_live_tutor"), 1);
    L73:
        if (r57 == false) goto L75;
        r19 = "live_tutor_chat_page";
        goto L77
    L75:
        r19 = null;
        goto L77
    L72:
        r57 = false;
        goto L73
    L64:
        r18 = null;
        goto L66
    L54:
        r16 = null;
        goto L55
    L50:
        r15 = null;
        goto L52
    L46:
        r14 = null;
        goto L48
    L42:
        r13 = null;
        goto L44
    L38:
        r12 = null;
        goto L40
    L34:
        r11 = null;
        goto L36
    L21:
        r9 = 0;
    L24:
        if (r51 == null) goto L26;
        Object r58 = r51.get("bot_id");
    L28:
        if ((r58 instanceof String) == false) goto L30;
        r10 = (String) r58;
        goto L32
    L30:
        r10 = null;
        goto L32
    L26:
        r58 = null;
        goto L28
    L16:
        r6 = null;
        goto L17
    L12:
        r5 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L7
    }
}
