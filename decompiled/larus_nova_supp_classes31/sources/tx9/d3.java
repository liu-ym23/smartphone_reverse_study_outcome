package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d3 {
    public static /* synthetic */ void b(String r127, Integer r128, Long r129, String r130, String r131, String r132, Long r133, String r134, Long r135, Long r136, Long r137, Integer r138, Long r139, String r140, String r141, String r142, String r143, String r144, String r145, Long r146, Long r147, Long r148, Long r149, String r150, String r151, Long r152, String r153, String r154, String r155, String r156, Integer r157, JSONObject r158, by7.e r159, String r160, String r161, String r162, Integer r163, String r164, String r165, String r166, String r167, Integer r168, String r169, Integer r170, String r171, String r172, String r173, String r174, String r175, String r176, String r177, String r178, String r179, String r180, String r181, String r182, String r183, String r184, String r185, String r186, Long r187, String r188, Long r189, String r190, String r191, String r192, Integer r193, String r194, String r195, String r196, String r197, Integer r198, Integer r199, String r200, String r201, String r202, String r203, String r204, Integer r205, Integer r206, boolean r207, String r208, String r209, String r210, boolean r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, Map r220, String r221, String r222, String r223, Boolean r224, String r225, String r226, int r227, int r228, int r229, int r230) {
        if ((r227 & 2) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r227 & 4) == 0) goto L9;
        Integer r7 = null;
    L11:
        if ((r227 & 8) == 0) goto L13;
        Long r8 = null;
    L15:
        if ((r227 & 16) == 0) goto L17;
        String r9 = null;
    L19:
        if ((r227 & 32) == 0) goto L21;
        String r10 = null;
    L23:
        if ((r227 & 64) == 0) goto L25;
        String r11 = null;
    L27:
        if ((r227 & 128) == 0) goto L29;
        Long r12 = null;
    L31:
        if ((r227 & 256) == 0) goto L33;
        String r13 = null;
    L35:
        if ((r227 & 1024) == 0) goto L37;
        Long r15 = null;
    L39:
        if ((r227 & 8192) == 0) goto L41;
        Long r19 = null;
    L43:
        if ((r227 & 32768) == 0) goto L45;
        Long r21 = null;
    L47:
        if ((r227 & 65536) == 0) goto L49;
        Integer r23 = null;
    L51:
        if ((r227 & 131072) == 0) goto L53;
        Long r25 = null;
    L55:
        if ((r227 & 262144) == 0) goto L57;
        String r27 = null;
    L59:
        if ((r227 & 524288) == 0) goto L61;
        String r29 = null;
    L63:
        if ((r227 & 1048576) == 0) goto L65;
        String r31 = null;
    L67:
        if ((r227 & 2097152) == 0) goto L69;
        String r33 = null;
    L71:
        if ((r227 & 8388608) == 0) goto L73;
        String r36 = null;
    L75:
        if ((r227 & 16777216) == 0) goto L77;
        String r38 = null;
    L79:
        if ((r227 & 33554432) == 0) goto L81;
        Long r40 = null;
    L83:
        if ((r227 & 67108864) == 0) goto L85;
        Long r42 = null;
    L87:
        if ((r227 & 134217728) == 0) goto L89;
        Long r44 = null;
    L91:
        if ((r227 & 268435456) == 0) goto L93;
        Long r46 = null;
    L95:
        if ((r227 & 536870912) == 0) goto L97;
        String r48 = null;
    L99:
        if ((r227 & 1073741824) == 0) goto L101;
        String r50 = null;
    L103:
        if ((r227 & Integer.MIN_VALUE) == 0) goto L105;
        Long r52 = null;
    L107:
        if ((r228 & 1) == 0) goto L109;
        String r53 = null;
    L111:
        if ((r228 & 2) == 0) goto L113;
        String r54 = null;
    L115:
        if ((r228 & 4) == 0) goto L117;
        String r55 = null;
    L119:
        if ((r228 & 8) == 0) goto L121;
        String r56 = null;
    L123:
        if ((r228 & 16) == 0) goto L125;
        Integer r57 = null;
    L127:
        if ((r228 & 32) == 0) goto L129;
        JSONObject r58 = new JSONObject();
    L131:
        if ((r228 & 64) == 0) goto L133;
        by7.e r59 = null;
    L135:
        if ((r228 & 128) == 0) goto L137;
        String r60 = null;
    L139:
        if ((r228 & 256) == 0) goto L141;
        String r61 = null;
    L143:
        if ((r228 & 512) == 0) goto L145;
        String r62 = null;
    L147:
        if ((r228 & 1024) == 0) goto L149;
        Integer r63 = null;
    L151:
        if ((r228 & 2048) == 0) goto L153;
        String r64 = null;
    L155:
        if ((r228 & 4096) == 0) goto L157;
        String r65 = null;
    L159:
        if ((r228 & 8192) == 0) goto L161;
        String r66 = null;
    L163:
        if ((r228 & 16384) == 0) goto L165;
        String r67 = null;
    L167:
        if ((r228 & 32768) == 0) goto L169;
        Integer r68 = null;
    L171:
        if ((r228 & 65536) == 0) goto L173;
        String r69 = null;
    L175:
        if ((r228 & 131072) == 0) goto L177;
        Integer r70 = null;
    L179:
        if ((r228 & 262144) == 0) goto L181;
        String r71 = null;
    L183:
        if ((r228 & 524288) == 0) goto L185;
        String r72 = null;
    L187:
        if ((r228 & 1048576) == 0) goto L189;
        String r73 = null;
    L191:
        if ((r228 & 2097152) == 0) goto L193;
        String r74 = "receive_stream";
    L195:
        if ((4194304 & r228) == 0) goto L197;
        String r75 = null;
    L199:
        if ((r228 & 8388608) == 0) goto L201;
        String r76 = null;
    L203:
        if ((r228 & 16777216) == 0) goto L205;
        String r77 = null;
    L207:
        if ((r228 & 33554432) == 0) goto L209;
        String r78 = null;
    L211:
        if ((r228 & 67108864) == 0) goto L213;
        String r79 = null;
    L215:
        if ((r228 & 134217728) == 0) goto L217;
        String r80 = null;
    L219:
        if ((r228 & 268435456) == 0) goto L221;
        String r81 = null;
    L223:
        if ((r228 & 536870912) == 0) goto L225;
        String r82 = null;
    L227:
        if ((r228 & 1073741824) == 0) goto L229;
        String r83 = null;
    L231:
        if ((r228 & Integer.MIN_VALUE) == 0) goto L233;
        String r84 = null;
    L235:
        if ((r229 & 1) == 0) goto L237;
        String r85 = null;
    L239:
        if ((r229 & 2) == 0) goto L241;
        String r86 = null;
    L243:
        if ((r229 & 4) == 0) goto L245;
        Long r87 = null;
    L247:
        if ((r229 & 8) == 0) goto L249;
        String r88 = null;
    L251:
        if ((r229 & 16) == 0) goto L253;
        Long r89 = null;
    L255:
        if ((r229 & 32) == 0) goto L257;
        String r90 = null;
    L259:
        if ((r229 & 64) == 0) goto L261;
        String r91 = null;
    L263:
        if ((r229 & 128) == 0) goto L265;
        String r92 = null;
    L267:
        if ((r229 & 256) == 0) goto L269;
        Integer r93 = null;
    L271:
        if ((r229 & 512) == 0) goto L273;
        String r94 = null;
    L275:
        if ((r229 & 1024) == 0) goto L277;
        String r95 = null;
    L279:
        if ((r229 & 2048) == 0) goto L281;
        String r96 = null;
    L283:
        if ((r229 & 4096) == 0) goto L285;
        String r97 = null;
    L287:
        if ((r229 & 8192) == 0) goto L289;
        Integer r98 = null;
    L291:
        if ((r229 & 16384) == 0) goto L293;
        Integer r99 = null;
    L295:
        if ((r229 & 32768) == 0) goto L297;
        String r100 = null;
    L299:
        if ((r229 & 65536) == 0) goto L301;
        String r101 = null;
    L303:
        if ((r229 & 131072) == 0) goto L305;
        String r102 = null;
    L307:
        if ((r229 & 262144) == 0) goto L309;
        String r103 = null;
    L311:
        if ((r229 & 524288) == 0) goto L313;
        String r104 = null;
    L315:
        if ((r229 & 1048576) == 0) goto L317;
        Integer r105 = null;
    L319:
        if ((r229 & 2097152) == 0) goto L321;
        Integer r106 = null;
    L323:
        if ((4194304 & r229) == 0) goto L325;
        boolean r107 = false;
    L327:
        if ((r229 & 8388608) == 0) goto L329;
        String r108 = null;
    L331:
        if ((r229 & 16777216) == 0) goto L333;
        String r109 = null;
    L335:
        if ((r229 & 33554432) == 0) goto L337;
        String r110 = null;
    L339:
        if ((r229 & 67108864) == 0) goto L341;
        boolean r111 = false;
    L343:
        if ((r229 & 134217728) == 0) goto L345;
        String r112 = null;
    L347:
        if ((r229 & 268435456) == 0) goto L349;
        String r113 = null;
    L351:
        if ((r229 & 536870912) == 0) goto L353;
        String r114 = null;
    L355:
        if ((r229 & 1073741824) == 0) goto L357;
        String r115 = null;
    L359:
        if ((r229 & Integer.MIN_VALUE) == 0) goto L361;
        String r116 = null;
    L363:
        if ((r230 & 1) == 0) goto L365;
        String r117 = null;
    L367:
        if ((r230 & 2) == 0) goto L369;
        String r118 = null;
    L371:
        if ((r230 & 4) == 0) goto L373;
        String r119 = null;
    L375:
        if ((r230 & 8) == 0) goto L377;
        Map r120 = null;
    L379:
        if ((r230 & 16) == 0) goto L381;
        String r121 = null;
    L383:
        if ((r230 & 32) == 0) goto L385;
        String r122 = null;
    L387:
        if ((r230 & 64) == 0) goto L389;
        String r123 = null;
    L391:
        if ((r230 & 128) == 0) goto L393;
        Boolean r124 = null;
    L395:
        if ((r230 & 256) == 0) goto L397;
        String r125 = null;
    L399:
        if ((r230 & 512) == 0) goto L401;
        String r126 = null;
    L402:
        a(null, r5, r7, r8, r9, r10, r11, r12, r13, null, r15, null, null, r19, null, r21, r23, r25, r27, r29, r31, r33, null, r36, r38, r40, r42, r44, r46, r48, r50, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126);
        return;
    L401:
        r126 = r226;
        goto L402
    L397:
        r125 = r225;
        goto L399
    L393:
        r124 = r224;
        goto L395
    L389:
        r123 = r223;
        goto L391
    L385:
        r122 = r222;
        goto L387
    L381:
        r121 = r221;
        goto L383
    L377:
        r120 = r220;
        goto L379
    L373:
        r119 = r219;
        goto L375
    L369:
        r118 = r218;
        goto L371
    L365:
        r117 = r217;
        goto L367
    L361:
        r116 = r216;
        goto L363
    L357:
        r115 = r215;
        goto L359
    L353:
        r114 = r214;
        goto L355
    L349:
        r113 = r213;
        goto L351
    L345:
        r112 = r212;
        goto L347
    L341:
        r111 = r211;
        goto L343
    L337:
        r110 = r210;
        goto L339
    L333:
        r109 = r209;
        goto L335
    L329:
        r108 = r208;
        goto L331
    L325:
        r107 = r207;
        goto L327
    L321:
        r106 = r206;
        goto L323
    L317:
        r105 = r205;
        goto L319
    L313:
        r104 = r204;
        goto L315
    L309:
        r103 = r203;
        goto L311
    L305:
        r102 = r202;
        goto L307
    L301:
        r101 = r201;
        goto L303
    L297:
        r100 = r200;
        goto L299
    L293:
        r99 = r199;
        goto L295
    L289:
        r98 = r198;
        goto L291
    L285:
        r97 = r197;
        goto L287
    L281:
        r96 = r196;
        goto L283
    L277:
        r95 = r195;
        goto L279
    L273:
        r94 = r194;
        goto L275
    L269:
        r93 = r193;
        goto L271
    L265:
        r92 = r192;
        goto L267
    L261:
        r91 = r191;
        goto L263
    L257:
        r90 = r190;
        goto L259
    L253:
        r89 = r189;
        goto L255
    L249:
        r88 = r188;
        goto L251
    L245:
        r87 = r187;
        goto L247
    L241:
        r86 = r186;
        goto L243
    L237:
        r85 = r185;
        goto L239
    L233:
        r84 = r184;
        goto L235
    L229:
        r83 = r183;
        goto L231
    L225:
        r82 = r182;
        goto L227
    L221:
        r81 = r181;
        goto L223
    L217:
        r80 = r180;
        goto L219
    L213:
        r79 = r179;
        goto L215
    L209:
        r78 = r178;
        goto L211
    L205:
        r77 = r177;
        goto L207
    L201:
        r76 = r176;
        goto L203
    L197:
        r75 = r175;
        goto L199
    L193:
        r74 = r174;
        goto L195
    L189:
        r73 = r173;
        goto L191
    L185:
        r72 = r172;
        goto L187
    L181:
        r71 = r171;
        goto L183
    L177:
        r70 = r170;
        goto L179
    L173:
        r69 = r169;
        goto L175
    L169:
        r68 = r168;
        goto L171
    L165:
        r67 = r167;
        goto L167
    L161:
        r66 = r166;
        goto L163
    L157:
        r65 = r165;
        goto L159
    L153:
        r64 = r164;
        goto L155
    L149:
        r63 = r163;
        goto L151
    L145:
        r62 = r162;
        goto L147
    L141:
        r61 = r161;
        goto L143
    L137:
        r60 = r160;
        goto L139
    L133:
        r59 = r159;
        goto L135
    L129:
        r58 = r158;
        goto L131
    L125:
        r57 = r157;
        goto L127
    L121:
        r56 = r156;
        goto L123
    L117:
        r55 = r155;
        goto L119
    L113:
        r54 = r154;
        goto L115
    L109:
        r53 = r153;
        goto L111
    L105:
        r52 = r152;
        goto L107
    L101:
        r50 = r151;
        goto L103
    L97:
        r48 = r150;
        goto L99
    L93:
        r46 = r149;
        goto L95
    L89:
        r44 = r148;
        goto L91
    L85:
        r42 = r147;
        goto L87
    L81:
        r40 = r146;
        goto L83
    L77:
        r38 = r145;
        goto L79
    L73:
        r36 = r144;
        goto L75
    L69:
        r33 = r143;
        goto L71
    L65:
        r31 = r142;
        goto L67
    L61:
        r29 = r141;
        goto L63
    L57:
        r27 = r140;
        goto L59
    L53:
        r25 = r139;
        goto L55
    L49:
        r23 = r138;
        goto L51
    L45:
        r21 = r137;
        goto L47
    L41:
        r19 = r136;
        goto L43
    L37:
        r15 = r135;
        goto L39
    L33:
        r13 = r134;
        goto L35
    L29:
        r12 = r133;
        goto L31
    L25:
        r11 = r132;
        goto L27
    L21:
        r10 = r131;
        goto L23
    L17:
        r9 = r130;
        goto L19
    L13:
        r8 = r129;
        goto L15
    L9:
        r7 = r128;
        goto L11
    L5:
        r5 = r127;
        goto L7
    }

    public static final void a(String r18, String r19, Integer r20, Long r21, String r22, String r23, String r24, Long r25, String r26, String r27, Long r28, String r29, String r30, Long r31, String r32, Long r33, Integer r34, Long r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, Long r43, Long r44, Long r45, Long r46, String r47, String r48, Long r49, String r50, String r51, String r52, String r53, Integer r54, JSONObject r55, by7.e r56, String r57, String r58, String r59, Integer r60, String r61, String r62, String r63, String r64, Integer r65, String r66, Integer r67, String r68, String r69, String r70, String r71, String r72, String r73, String r74, String r75, String r76, String r77, String r78, String r79, String r80, String r81, String r82, String r83, Long r84, String r85, Long r86, String r87, String r88, String r89, Integer r90, String r91, String r92, String r93, String r94, Integer r95, Integer r96, String r97, String r98, String r99, String r100, String r101, Integer r102, Integer r103, boolean r104, String r105, String r106, String r107, boolean r108, String r109, String r110, String r111, String r112, String r113, String r114, String r115, String r116, Map<String, String> r117, String r118, String r119, String r120, Boolean r121, String r122, String r123) {
        Intrinsics.checkNotNullParameter(r55, "params");
        Intrinsics.checkNotNullParameter(r71, "eventName");
        if (r117 == null) goto L13;
        Iterator<Map.Entry<String, String>> r12 = r117.entrySet().iterator();     // Catch: JSONException -> L9
    L6:
        if (r12.hasNext() == false) goto L8;
        Map.Entry<String, String> r16 = r12.next();     // Catch: JSONException -> L9
        r55.put(r16.getKey(), r16.getValue());     // Catch: JSONException -> L9
        r12 = r12;
        goto L6
    L8:
        Unit r13 = Unit.INSTANCE;     // Catch: JSONException -> L9
    L9:
        JSONException e = e;
        String r1 = r71;
    L11:
        JSONObject r2 = r55;
    L286:
        FLogger.a.e("ReceiveEventHelper", "error in ReceiveEventHelper receiveStream " + e.getLocalizedMessage());
    L287:
        TrackParams r0 = new TrackParams().merge(r2);
        by7.a r3 = new by7.a(r1);
        if (r56 == null) goto L290;
        r3.b = r56;
    L290:
        r3.a.merge(r0);
        r3.b();
        com.larus.platform.service.g.a.monitorEventForSlardar(r1, r2, new JSONObject(), null);
        return;
    L13:
        if (r108 == false) goto L15;
        String r14 = "1";
    L16:
        r55.putOpt("is_contain_replica_create_button", r14);     // Catch: JSONException -> L9
        r55.putOpt("ai_creation_tool_list", r88);     // Catch: JSONException -> L9
        if (r80 != null) goto L19;
        String r15 = "";
    L20:
        r55.putOpt("ai_create_show_mode", r15);     // Catch: JSONException -> L9
        r55.putOpt("hit_pocket_lottery_raf", r109);     // Catch: JSONException -> L9
        r55.putOpt("is_lottery", r110);     // Catch: JSONException -> L9
        if (r18 == null) goto L23;
        r55.put("back_page", r18);     // Catch: JSONException -> L9
    L23:
        if (r19 == null) goto L25;
        r55.put("bot_id", r19);     // Catch: JSONException -> L9
    L25:
        if (r20 == null) goto L27;
        r55.put("bot_type", r20.intValue());     // Catch: JSONException -> L9
    L27:
        if (r21 == null) goto L29;
        r55.put("content_length", r21.longValue());     // Catch: JSONException -> L9
    L29:
        if (r22 == null) goto L31;
        r55.put("conversation_id", r22);     // Catch: JSONException -> L9
    L31:
        if (r23 == null) goto L33;
        r55.put("reply_id", r23);     // Catch: JSONException -> L9
    L33:
        if (r24 == null) goto L35;
        r55.put("current_page", r24);     // Catch: JSONException -> L9
    L35:
        if (r25 == null) goto L37;
        r55.put("duration", r25.longValue());     // Catch: JSONException -> L9
    L37:
        if (r70 == null) goto L39;
        r55.put("is_contain_ecommerce", r70);     // Catch: JSONException -> L9
    L39:
        if (r26 == null) goto L41;
        r55.put("group_type", r26);     // Catch: JSONException -> L9
    L41:
        if (r27 == null) goto L43;
        r55.put("if_with_bot", r27);     // Catch: JSONException -> L9
    L43:
        if (r28 == null) goto L45;
        r55.put("is_cache", r28.longValue());     // Catch: JSONException -> L9
    L45:
        if (r29 == null) goto L47;
        r55.put("is_cued", r29);     // Catch: JSONException -> L9
    L47:
        if (r30 == null) goto L49;
        r55.put("is_group_action_bar_cued", r30);     // Catch: JSONException -> L9
    L49:
        if (r31 == null) goto L51;
        r55.put("is_onboarding", r31.longValue());     // Catch: JSONException -> L9
    L51:
        if (r32 == null) goto L53;
        r55.put("is_search_link", r32);     // Catch: JSONException -> L9
    L53:
        if (r33 == null) goto L55;
        r55.put("is_soft_link", r33.longValue());     // Catch: JSONException -> L9
    L55:
        if (r34 == null) goto L57;
        r55.put("is_app_download_link", r34.intValue());     // Catch: JSONException -> L9
    L57:
        if (r35 == null) goto L59;
        r55.put("is_tts_open", r35.longValue());     // Catch: JSONException -> L9
    L59:
        if (r36 == null) goto L61;
        r55.put("message_id", r36);     // Catch: JSONException -> L9
    L61:
        if (r37 == null) goto L64;
        r55.put("message_type", r37);     // Catch: JSONException -> L9
    L64:
        if (r38 == null) goto L66;
        r55.put("onboarding_content_source", r38);     // Catch: JSONException -> L9
    L66:
        r1 = r71;
        if (r39 == null) goto L72;
        r55.put("previous_page", r39);     // Catch: JSONException -> L69
    L69:
        e = e;
    L72:
        if (r40 == null) goto L74;
        r55.put("query", r40);     // Catch: JSONException -> L69
    L74:
        r2 = r55;
        if (r41 == null) goto L80;
        r2.put("result", r41);     // Catch: JSONException -> L77
    L77:
        e = e;
    L80:
        if (r42 == null) goto L82;
        r2.put("section_id", r42);     // Catch: JSONException -> L77
    L82:
        if (r43 == null) goto L84;
        r2.put("stream_handle_time", r43.longValue());     // Catch: JSONException -> L77
    L84:
        if (r44 == null) goto L86;
        r2.put("stream_receive_count", r44.longValue());     // Catch: JSONException -> L77
    L86:
        if (r45 == null) goto L88;
        r2.put("stream_receive_interval", r45.longValue());     // Catch: JSONException -> L77
    L88:
        if (r46 == null) goto L91;
        r2.put("success", r46.longValue());     // Catch: JSONException -> L77
    L91:
        if (r47 == null) goto L94;
        r2.put("type", r47);     // Catch: JSONException -> L77
    L94:
        if (r48 == null) goto L96;
        r2.put("use_nickname", r48);     // Catch: JSONException -> L77
    L96:
        if (r49 == null) goto L99;
        r2.put("voice_id", r49.longValue());     // Catch: JSONException -> L77
    L99:
        if (r50 == null) goto L102;
        r2.put("voice_type", r50);     // Catch: JSONException -> L77
    L102:
        if (r51 == null) goto L105;
        r2.put("is_baike_link", r51);     // Catch: JSONException -> L77
    L105:
        if (r52 == null) goto L108;
        r2.put("speaker_id", r52);     // Catch: JSONException -> L77
    L108:
        if (r53 == null) goto L111;
        r2.put("speaker_name", r53);     // Catch: JSONException -> L77
    L111:
        if (r57 == null) goto L114;
        r2.put("agent_id", r57);     // Catch: JSONException -> L77
    L114:
        if (r58 == null) goto L117;
        r2.put("agent_intention", r58);     // Catch: JSONException -> L77
    L117:
        if (r59 == null) goto L119;
        r2.put("scene", r59);     // Catch: JSONException -> L77
    L119:
        if (r54 == null) goto L121;
        r2.put("instruction_type", r54.intValue());     // Catch: JSONException -> L77
    L121:
        if (r60 == null) goto L124;
        r2.put("action_bar_template_name", r60.intValue());     // Catch: JSONException -> L77
        r2.put("action_bar_template_id", r60.intValue());     // Catch: JSONException -> L77
    L124:
        if (r61 == null) goto L126;
        r2.put("action_bar_template_type", r61);     // Catch: JSONException -> L77
    L126:
        if (r58 == null) goto L129;
        r2.put("agent_intention", r58);     // Catch: JSONException -> L77
    L129:
        if (r62 == null) goto L132;
        r2.put("action_bar_key", r62);     // Catch: JSONException -> L77
    L132:
        if (r63 == null) goto L135;
        r2.put("is_action_bar", r63);     // Catch: JSONException -> L77
    L135:
        if (r64 == null) goto L137;
        r2.put("chat_type", r64);     // Catch: JSONException -> L77
    L137:
        if (r65 == null) goto L140;
        r2.put("tts_speaker_volume", r65.intValue());     // Catch: JSONException -> L77
    L140:
        if (r66 == null) goto L142;
        r2.put("is_multi_question", r66);     // Catch: JSONException -> L77
    L142:
        if (r67 == null) goto L145;
        r2.put("multi_question_count", r67.intValue());     // Catch: JSONException -> L77
    L145:
        if (r68 == null) goto L148;
        r2.put("is_perspective_corrected", r68);     // Catch: JSONException -> L77
    L148:
        if (r69 == null) goto L151;
        r2.put("parent_message_id", r69);     // Catch: JSONException -> L77
    L151:
        if (r89 == null) goto L153;
        r2.put("call_id", r89);     // Catch: JSONException -> L77
    L153:
        if (r90 == null) goto L156;
        r2.put("is_realtime_call_hello", r90.intValue());     // Catch: JSONException -> L77
    L156:
        if (r91 == null) goto L159;
        r2.put("realtime_call_hello_tech_type", r91);     // Catch: JSONException -> L77
    L159:
        if (r92 == null) goto L162;
        r2.put("realtime_call_hello_type", r92);     // Catch: JSONException -> L77
    L162:
        if (r105 == null) goto L165;
        r2.put("content_source", r105);     // Catch: JSONException -> L77
    L165:
        if (r107 == null) goto L168;
        r2.put("is_simultaneous_interpretation", r107);     // Catch: JSONException -> L77
    L168:
        if (r72 == null) goto L171;
        r2.put("is_deep_thinking_switch_on", r72);     // Catch: JSONException -> L77
    L171:
        if (r73 == null) goto L174;
        r2.put("is_deep_thinking", r73);     // Catch: JSONException -> L77
    L174:
        if (r111 == null) goto L177;
        r2.put("is_pro", r111);     // Catch: JSONException -> L77
    L177:
        if (r74 == null) goto L180;
        r2.put("is_crowd_testing", r74);     // Catch: JSONException -> L77
    L180:
        if (r76 == null) goto L183;
        r2.put("is_internet_switch_on", r76);     // Catch: JSONException -> L77
    L183:
        if (r77 == null) goto L186;
        r2.put("deep_research_phase", r77);     // Catch: JSONException -> L77
    L186:
        if (r78 == null) goto L189;
        r2.put("deep_research_id", r78);     // Catch: JSONException -> L77
    L189:
        if (r79 == null) goto L192;
        r2.put("thinking_content_card_type", r79);     // Catch: JSONException -> L77
    L192:
        if (r75 == null) goto L195;
        r2.put("is_video_comprehend", r75);     // Catch: JSONException -> L77
    L195:
        if (r81 == null) goto L198;
        r2.put("user_case_item_id", r81);     // Catch: JSONException -> L77
    L198:
        if (r82 == null) goto L201;
        r2.put("user_case_reco_request_id", r82);     // Catch: JSONException -> L77
    L201:
        if (r83 == null) goto L203;
        r2.put("recommend_from", r83);     // Catch: JSONException -> L77
    L203:
        if (r84 == null) goto L206;
        r2.put("action_bar_option_id", r84.longValue());     // Catch: JSONException -> L77
    L206:
        if (r85 == null) goto L208;
        r2.put("action_bar_option_text", r85);     // Catch: JSONException -> L77
    L208:
        if (r86 == null) goto L211;
        r2.put("action_bar_item_id", r86.longValue());     // Catch: JSONException -> L77
    L211:
        if (r87 == null) goto L214;
        r2.put("is_ai_podcast", r87);     // Catch: JSONException -> L77
    L214:
        if (r93 == null) goto L217;
        r2.put("page_token", r93);     // Catch: JSONException -> L77
    L217:
        if (r94 == null) goto L219;
        r2.put("artifact_meta_id", r94);     // Catch: JSONException -> L77
    L219:
        if (r95 == null) goto L221;
        r2.put("artifact_type", r95.intValue());     // Catch: JSONException -> L77
    L221:
        if (r96 == null) goto L224;
        r2.put("resource_type", r96.intValue());     // Catch: JSONException -> L77
    L224:
        if (r97 == null) goto L227;
        r2.put("presentation_id", r97);     // Catch: JSONException -> L77
    L227:
        if (r98 == null) goto L230;
        r2.put("resource_id", r98);     // Catch: JSONException -> L77
    L230:
        if (r99 == null) goto L233;
        r2.put("base_id", r99);     // Catch: JSONException -> L77
    L233:
        if (r100 == null) goto L236;
        r2.put("ai_base_cnt", r100);     // Catch: JSONException -> L77
    L236:
        if (r101 == null) goto L238;
        r2.put("aippt_task_id", r101);     // Catch: JSONException -> L77
    L238:
        if (r102 == null) goto L240;
        r2.put("is_float_chat", r102.intValue());     // Catch: JSONException -> L77
    L240:
        if (r103 == null) goto L243;
        r2.put("float_chat_shown_pct", r103.intValue());     // Catch: JSONException -> L77
    L243:
        if (r106 == null) goto L246;
        r2.put("credit_message_type", r106);     // Catch: JSONException -> L77
    L246:
        if (r104 == false) goto L248;
        int r4 = 1;
    L249:
        r2.put("is_with_ai_doc", r4);     // Catch: JSONException -> L77
        if (com.larus.utils.o0.d(r112) == false) goto L253;
        r2.put("collection_id", r112);     // Catch: JSONException -> L77
    L253:
        if (com.larus.utils.o0.d(r113) == false) goto L256;
        r2.put("collection_name", r113);     // Catch: JSONException -> L77
    L256:
        if (com.larus.utils.o0.d(r114) == false) goto L259;
        r2.put("content_type", r114);     // Catch: JSONException -> L77
    L259:
        if (com.larus.utils.o0.d(r115) == false) goto L262;
        r2.put("content_sec_type", r115);     // Catch: JSONException -> L77
    L262:
        if (com.larus.utils.o0.d(r116) == false) goto L265;
        r2.put("link_type", r116);     // Catch: JSONException -> L77
    L265:
        if (com.larus.utils.o0.d(r118) == false) goto L268;
        r2.put("spreadsheet_id", r118);     // Catch: JSONException -> L77
    L268:
        if (com.larus.utils.o0.d(r119) == false) goto L271;
        r2.put("ai_sheet_cnt", r119);     // Catch: JSONException -> L77
    L271:
        if (com.larus.utils.o0.d(r120) == false) goto L273;
        r2.put("ai_excel_cnt", r120);     // Catch: JSONException -> L77
    L273:
        if (r121 == null) goto L280;
        if (r121.booleanValue() == false) goto L277;
        String r5 = "true";
    L278:
        r2.put("button_invisible", r5);     // Catch: JSONException -> L77
        goto L280
    L277:
        r5 = "false";
    L280:
        if (com.larus.utils.o0.d(r122) == false) goto L283;
        r2.put("button_scene", r122);     // Catch: JSONException -> L77
    L283:
        if (r123 == null) goto L287;
        r2.put("clarify_id", r123);     // Catch: JSONException -> L77
        goto L287
    L248:
        r4 = 0;
        goto L249
    L19:
        r15 = r80;
        goto L20
    L15:
        r14 = "0";
        goto L16
    }
}
