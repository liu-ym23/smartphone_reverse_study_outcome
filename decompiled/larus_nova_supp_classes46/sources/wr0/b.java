package wr0;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.performance.api.IPerfToolsService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final IPerfToolsService a = null;
    public static final HashMap<String, a> b = null;
    public static final HashMap<Integer, List<String>> c = null;
    public static final List<Integer> d = null;
    public static boolean e;
    public static boolean f;
    public static final List<String> g = null;
    public static final HashMap<Integer, wr0.a> h = null;

    public static class a {
        public String a;
        public HashMap<String, String> b;
        public List<Double> c;
        public int d;

        public a() {
        }
    }

    static {
        b = new HashMap();
        HashMap<Integer, List<String>> r0 = new HashMap();
        c = r0;
        d = new ArrayList();
        e = true;
        f = true;
        g = new ArrayList();
        h = new HashMap();
        a = (IPerfToolsService) k.f(IPerfToolsService.class);
        r0.put(0, Arrays.asList(new String[]{"data_host_version_code", "data_host_update_version_code", "data_push_client_sdk_version", "data_player_sdk_version", "data_live_sdk_version", "data_current_device_id", "data_current_user_id", "data_channel_id", "data_effect_sdk_version", "data_live_core_version", "data_android_release", "data_device_model", "data_device_brand", "data_device_score"}));
        r0.put(9, IPerfToolsService.baseAudienceInfo);
        r0.put(10, IPerfToolsService.baseBroadcastInfo);
        r0.put(11, Arrays.asList(new String[]{"data_channel_id", "data_inviter_established_time", "data_invitee_established_time", "data_end_to_end_delay", "data_mix_type"}));
        r0.put(12, Arrays.asList(new String[]{"data_channel_id", "data_inviter_established_time", "data_invitee_established_time", "data_end_to_end_delay", "data_mix_type"}));
        r0.put(13, Arrays.asList(new String[]{e("gift_effect", "data_cpu_rate"), e("gift_effect", "data_cpu_speed"), e("gift_effect", "data_temperature"), e("gift_effect", "data_cpu_rate")}));
        r0.put(14, Arrays.asList(new String[]{"data_push_client_bitrate", "data_push_client_fps", e("ktv", "data_http_rtt")}));
        r0.put(4, Arrays.asList(new String[]{"surface_render_enabled", "data_pull_cdn_ip", "data_play_url", "data_stream_id"}));
    }

    public static void b() {
        Set<Map.Entry<String, a>> r0 = b.entrySet();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, a>> r1 = r0.iterator();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.hasNext() == false) goto L19;
        Map.Entry<String, a> r2 = r1.next();
        if (r2 == null) goto L9;
        a r3 = r2.getValue();
        if (r3 == null) goto L9;
        if (r3.d != 2) goto L9;
        r1.remove();
        goto L9
    }

    public static boolean i() {
        String r0 = g("data_current_user_id");
        String r1 = g("data_current_room_user_id");
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.equals(r1) == false) goto L8;
        return false;
    }

    public static boolean a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return false;
    L5:
        Iterator r0 = ((ArrayList) d).iterator();
    L7:
        if (r0.hasNext() == false) goto L17;
        Integer r2 = (Integer) r0.next();
        List<String> r3 = c.get(r2);
        if (r3 == null) goto L7;
        if (r3.isEmpty() == true) goto L7;
        if (r3.contains(r4) == false) goto L7;
        return true;
    L17:
        return false;
    }

    public static String c(String r4) {
        byte r2 = 1;
        if (r4.contains("@") == true) goto L5;
    L7:
        r4.getClass();
        switch(r4.hashCode()) {
            case -2098952852: goto L314;
            case -2069970221: goto L311;
            case -2055283396: goto L307;
            case -2027658481: goto L303;
            case -1865703285: goto L299;
            case -1854495991: goto L295;
            case -1839659303: goto L291;
            case -1751273442: goto L287;
            case -1683983720: goto L283;
            case -1673262874: goto L279;
            case -1651528858: goto L275;
            case -1512049965: goto L271;
            case -1501977995: goto L267;
            case -1496783394: goto L263;
            case -1485802067: goto L259;
            case -1304311193: goto L255;
            case -1228425742: goto L251;
            case -1208425186: goto L247;
            case -1197089414: goto L243;
            case -1186101051: goto L239;
            case -1075497622: goto L235;
            case -962495820: goto L231;
            case -947329893: goto L227;
            case -904685260: goto L223;
            case -816061345: goto L219;
            case -810571734: goto L215;
            case -782072151: goto L211;
            case -759990539: goto L207;
            case -755484584: goto L203;
            case -743322109: goto L199;
            case -540811163: goto L195;
            case -505578446: goto L191;
            case -340863070: goto L187;
            case -318342954: goto L183;
            case -266741086: goto L179;
            case -224380421: goto L175;
            case -177258790: goto L171;
            case 101871466: goto L167;
            case 129833242: goto L163;
            case 134121448: goto L159;
            case 179824264: goto L155;
            case 214569036: goto L151;
            case 307992101: goto L147;
            case 321142133: goto L143;
            case 321332499: goto L139;
            case 443461424: goto L135;
            case 452790756: goto L131;
            case 459278241: goto L127;
            case 484930240: goto L123;
            case 489736068: goto L119;
            case 564530084: goto L115;
            case 580941647: goto L111;
            case 654258054: goto L107;
            case 676916096: goto L103;
            case 701936399: goto L99;
            case 806289238: goto L95;
            case 913326647: goto L91;
            case 987659062: goto L87;
            case 1007300814: goto L83;
            case 1077775884: goto L79;
            case 1170375963: goto L75;
            case 1185147752: goto L71;
            case 1186730026: goto L67;
            case 1250111221: goto L63;
            case 1277840416: goto L59;
            case 1353095156: goto L55;
            case 1545043401: goto L51;
            case 1681370334: goto L47;
            case 1687634951: goto L43;
            case 1771867293: goto L39;
            case 1835769126: goto L35;
            case 1850916179: goto L31;
            case 1866308317: goto L27;
            case 1906108724: goto L23;
            case 2050361740: goto L19;
            case 2102414013: goto L15;
            case 2118975743: goto L11;
            default: goto L9;
        };
    L9:
        r2 = -1;
    L318:
        switch(r2) {
            case 0: goto L473;
            case 1: goto L471;
            case 2: goto L469;
            case 3: goto L467;
            case 4: goto L465;
            case 5: goto L463;
            case 6: goto L461;
            case 7: goto L459;
            case 8: goto L457;
            case 9: goto L455;
            case 10: goto L453;
            case 11: goto L451;
            case 12: goto L449;
            case 13: goto L447;
            case 14: goto L445;
            case 15: goto L443;
            case 16: goto L441;
            case 17: goto L439;
            case 18: goto L437;
            case 19: goto L435;
            case 20: goto L433;
            case 21: goto L431;
            case 22: goto L429;
            case 23: goto L427;
            case 24: goto L425;
            case 25: goto L423;
            case 26: goto L421;
            case 27: goto L419;
            case 28: goto L417;
            case 29: goto L415;
            case 30: goto L413;
            case 31: goto L411;
            case 32: goto L409;
            case 33: goto L407;
            case 34: goto L405;
            case 35: goto L403;
            case 36: goto L401;
            case 37: goto L399;
            case 38: goto L397;
            case 39: goto L395;
            case 40: goto L393;
            case 41: goto L391;
            case 42: goto L389;
            case 43: goto L387;
            case 44: goto L385;
            case 45: goto L383;
            case 46: goto L381;
            case 47: goto L379;
            case 48: goto L377;
            case 49: goto L375;
            case 50: goto L373;
            case 51: goto L371;
            case 52: goto L369;
            case 53: goto L367;
            case 54: goto L365;
            case 55: goto L363;
            case 56: goto L361;
            case 57: goto L359;
            case 58: goto L357;
            case 59: goto L355;
            case 60: goto L353;
            case 61: goto L351;
            case 62: goto L349;
            case 63: goto L347;
            case 64: goto L345;
            case 65: goto L343;
            case 66: goto L341;
            case 67: goto L339;
            case 68: goto L337;
            case 69: goto L335;
            case 70: goto L333;
            case 71: goto L331;
            case 72: goto L329;
            case 73: goto L327;
            case 74: goto L325;
            case 75: goto L323;
            case 76: goto L321;
            default: goto L319;
        };
    L319:
        return r4;
    L321:
        return s1.B(2131921276);
    L323:
        return s1.B(2131921277);
    L325:
        return s1.B(2131921249);
    L327:
        return s1.B(2131921307);
    L329:
        return s1.B(2131921296);
    L331:
        return s1.B(2131921280);
    L333:
        return s1.B(2131921313);
    L335:
        return s1.B(2131921300);
    L337:
        return s1.B(2131921324);
    L339:
        return s1.B(2131921315);
    L341:
        return s1.B(2131921250);
    L343:
        return s1.B(2131921320);
    L345:
        return s1.B(2131921284);
    L347:
        return s1.B(2131921282);
    L349:
        return s1.B(2131921246);
    L351:
        return s1.B(2131921286);
    L353:
        return s1.B(2131921310);
    L355:
        return s1.B(2131921251);
    L357:
        return s1.B(2131921309);
    L359:
        return s1.B(2131921291);
    L361:
        return s1.B(2131921287);
    L363:
        return s1.B(2131921283);
    L365:
        return s1.B(2131921305);
    L367:
        return s1.B(2131921271);
    L369:
        return s1.B(2131921303);
    L371:
        return s1.B(2131921302);
    L373:
        return s1.B(2131921312);
    L375:
        return s1.B(2131921321);
    L377:
        return s1.B(2131921298);
    L379:
        return s1.B(2131921319);
    L381:
        return s1.B(2131921243);
    L383:
        return s1.B(2131921274);
    L385:
        return s1.B(2131921317);
    L387:
        return s1.B(2131921264);
    L389:
        return s1.B(2131921308);
    L391:
        return s1.B(2131921255);
    L393:
        return s1.B(2131921272);
    L395:
        return s1.B(2131921281);
    L397:
        return s1.B(2131921318);
    L399:
        return s1.B(2131921323);
    L401:
        return s1.B(2131921262);
    L403:
        return s1.B(2131921279);
    L405:
        return s1.B(2131921316);
    L407:
        return s1.B(2131921273);
    L409:
        return s1.B(2131921241);
    L411:
        return s1.B(2131921289);
    L413:
        return s1.B(2131921270);
    L415:
        return s1.B(2131921243);
    L417:
        return s1.B(2131921292);
    L419:
        return s1.B(2131921301);
    L421:
        return s1.B(2131921306);
    L423:
        return s1.B(2131921295);
    L425:
        return s1.B(2131921244);
    L427:
        return s1.B(2131921263);
    L429:
        return s1.B(2131921253);
    L431:
        return s1.B(2131921326);
    L433:
        return s1.B(2131921257);
    L435:
        return s1.B(2131921314);
    L437:
        return s1.B(2131921265);
    L439:
        return s1.B(2131921256);
    L441:
        return s1.B(2131921322);
    L443:
        return s1.B(2131921311);
    L445:
        return s1.B(2131921285);
    L447:
        return s1.B(2131921261);
    L449:
        return s1.B(2131921260);
    L451:
        return s1.B(2131921258);
    L453:
        return s1.B(2131921290);
    L455:
        return s1.B(2131921297);
    L457:
        return s1.B(2131921269);
    L459:
        return s1.B(2131921288);
    L461:
        return s1.B(2131921304);
    L463:
        return s1.B(2131921259);
    L465:
        return s1.B(2131921247);
    L467:
        return s1.B(2131921267);
    L469:
        return s1.B(2131921325);
    L471:
        return s1.B(2131921299);
    L473:
        return s1.B(2131921275);
    L11:
        if (r4.equals("data_inviter_established_time") == false) goto L9;
        r2 = 76;
        goto L318
    L15:
        if (r4.equals("isvPass") == false) goto L9;
        r2 = 75;
        goto L318
    L19:
        if (r4.equals("data_channel_id") == false) goto L9;
        r2 = 74;
        goto L318
    L23:
        if (r4.equals("data_push_stream_encode_type") == false) goto L9;
        r2 = 73;
        goto L318
    L27:
        if (r4.equals("data_preview_fps") == false) goto L9;
        r2 = 72;
        goto L318
    L31:
        if (r4.equals("data_chatroom_livecore_extra") == false) goto L9;
        r2 = 71;
        goto L318
    L35:
        if (r4.equals("data_current_room_user_id") == false) goto L9;
        r2 = 70;
        goto L318
    L39:
        if (r4.equals("data_pull_stream_codec_type") == false) goto L9;
        r2 = 69;
        goto L318
    L43:
        if (r4.equals("data_private_system_summary") == false) goto L9;
        r2 = 68;
        goto L318
    L47:
        if (r4.equals("data_sharpen_used") == false) goto L9;
        r2 = 67;
        goto L318
    L51:
        if (r4.equals("data_code_summary") == false) goto L9;
        r2 = 66;
        goto L318
    L55:
        if (r4.equals("data_sticker_used") == false) goto L9;
        r2 = 65;
        goto L318
    L59:
        if (r4.equals("local_resolution_memory") == false) goto L9;
        r2 = 64;
        goto L318
    L63:
        if (r4.equals("data_live_sdk_version") == false) goto L9;
        r2 = 63;
        goto L318
    L67:
        if (r4.equals("data_beauty_ids") == false) goto L9;
        r2 = 62;
        goto L318
    L71:
        if (r4.equals("data_gesture_used") == false) goto L9;
        r2 = 61;
        goto L318
    L75:
        if (r4.equals("data_push_stream_resolution") == false) goto L9;
        r2 = 60;
        goto L318
    L79:
        if (r4.equals("data_cpu_rate") == false) goto L9;
        r2 = 59;
        goto L318
    L83:
        if (r4.equals("data_push_client_max_bitrate") == false) goto L9;
        r2 = 58;
        goto L318
    L87:
        if (r4.equals("data_network_frequency") == false) goto L9;
        r2 = 57;
        goto L318
    L91:
        if (r4.equals("data_makeup_ids") == false) goto L9;
        r2 = 56;
        goto L318
    L95:
        if (r4.equals("data_live_core_version") == false) goto L9;
        r2 = 55;
        goto L318
    L99:
        if (r4.equals("data_push_client_sdk_version") == false) goto L9;
        r2 = 54;
        goto L318
    L103:
        if (r4.equals("data_graphics") == false) goto L9;
        r2 = 53;
        goto L318
    L107:
        if (r4.equals("data_pull_stream_resolution") == false) goto L9;
        r2 = 52;
        goto L318
    L111:
        if (r4.equals("data_pull_stream_fps") == false) goto L9;
        r2 = 51;
        goto L318
    L115:
        if (r4.equals("data_current_room_id") == false) goto L9;
        r2 = 50;
        goto L318
    L119:
        if (r4.equals("data_stream_type") == false) goto L9;
        r2 = 49;
        goto L318
    L123:
        if (r4.equals("data_pss_total") == false) goto L9;
        r2 = 48;
        goto L318
    L127:
        if (r4.equals("data_sticker_ids") == false) goto L9;
        r2 = 47;
        goto L318
    L131:
        if (r4.equals("data_current") == false) goto L9;
        r2 = 46;
        goto L318
    L135:
        if (r4.equals("data_http_rtt") == false) goto L9;
        r2 = 45;
        goto L318
    L139:
        if (r4.equals("data_small_beauty_used") == false) goto L9;
        r2 = 44;
        goto L318
    L143:
        if (r4.equals("data_enter_room_cost") == false) goto L9;
        r2 = 43;
        goto L318
    L147:
        if (r4.equals("data_push_client_fps") == false) goto L9;
        r2 = 42;
        goto L318
    L151:
        if (r4.equals("resolution_key") == false) goto L9;
        r2 = 41;
        goto L318
    L155:
        if (r4.equals("data_host_update_version_code") == false) goto L9;
        r2 = 40;
        goto L318
    L159:
        if (r4.equals("data_live_room_enter_source") == false) goto L9;
        r2 = 39;
        goto L318
    L163:
        if (r4.equals("data_stack_summary") == false) goto L9;
        r2 = 38;
        goto L318
    L167:
        if (r4.equals("surface_render_enabled") == false) goto L9;
        r2 = 37;
        goto L318
    L171:
        if (r4.equals("data_effect_sdk_version") == false) goto L9;
        r2 = 36;
        goto L318
    L175:
        if (r4.equals("data_java_heap_summary") == false) goto L9;
        r2 = 35;
        goto L318
    L179:
        if (r4.equals("data_small_beauty_ids") == false) goto L9;
        r2 = 34;
        goto L318
    L183:
        if (r4.equals("data_host_version_code") == false) goto L9;
        r2 = 33;
        goto L318
    L187:
        if (r4.equals("data_android_release") == false) goto L9;
        r2 = 32;
        goto L318
    L191:
        if (r4.equals("data_mix_type") == false) goto L9;
        r2 = 31;
        goto L318
    L195:
        if (r4.equals("data_gpu_used") == false) goto L9;
        r2 = 30;
        goto L318
    L199:
        if (r4.equals("data_battery_health") == false) goto L9;
        r2 = 29;
        goto L318
    L203:
        if (r4.equals("data_network_status") == false) goto L9;
        r2 = 28;
        goto L318
    L207:
        if (r4.equals("data_pull_download_speed") == false) goto L9;
        r2 = 27;
        goto L318
    L211:
        if (r4.equals("data_push_client_bitrate") == false) goto L9;
        r2 = 26;
        goto L318
    L215:
        if (r4.equals("data_player_sdk_version") == false) goto L9;
        r2 = 25;
        goto L318
    L219:
        if (r4.equals("data_temperature") == false) goto L9;
        r2 = 24;
        goto L318
    L223:
        if (r4.equals("data_end_to_end_delay") == false) goto L9;
        r2 = 23;
        goto L318
    L227:
        if (r4.equals("data_cpu_speed") == false) goto L9;
        r2 = 22;
        goto L318
    L231:
        if (r4.equals("data_current_user_id") == false) goto L9;
        r2 = 21;
        goto L318
    L235:
        if (r4.equals("default_resolution") == false) goto L9;
        r2 = 20;
        goto L318
    L239:
        if (r4.equals("data_current_room_watched") == false) goto L9;
        r2 = 19;
        goto L318
    L243:
        if (r4.equals("data_enter_room_split_cost") == false) goto L9;
        r2 = 18;
        goto L318
    L247:
        if (r4.equals("decode_way") == false) goto L9;
        r2 = 17;
        goto L318
    L251:
        if (r4.equals("super_resolution_enabled") == false) goto L9;
        r2 = 16;
        goto L318
    L255:
        if (r4.equals("data_avg_fps") == false) goto L9;
        r2 = 15;
        goto L318
    L259:
        if (r4.equals("data_gesture_ids") == false) goto L9;
        r2 = 14;
        goto L318
    L263:
        if (r4.equals("data_device_score") == false) goto L9;
        r2 = 13;
        goto L318
    L267:
        if (r4.equals("data_device_model") == false) goto L9;
        r2 = 12;
        goto L318
    L271:
        if (r4.equals("data_device_brand") == false) goto L9;
        r2 = 11;
        goto L318
    L275:
        if (r4.equals("data_native_heap_summary") == false) goto L9;
        r2 = 10;
        goto L318
    L279:
        if (r4.equals("data_private_other_summary") == false) goto L9;
        r2 = 9;
        goto L318
    L283:
        if (r4.equals("data_game_render_fps") == false) goto L9;
        r2 = 8;
        goto L318
    L287:
        if (r4.equals("data_makeup_used") == false) goto L9;
        r2 = 7;
        goto L318
    L291:
        if (r4.equals("data_play_url") == false) goto L9;
        r2 = 6;
        goto L318
    L295:
        if (r4.equals("data_current_device_id") == false) goto L9;
        r2 = 5;
        goto L318
    L299:
        if (r4.equals("data_beauty_used") == false) goto L9;
        r2 = 4;
        goto L318
    L303:
        if (r4.equals("data_filter_used") == false) goto L9;
        r2 = 3;
        goto L318
    L307:
        if (r4.equals("texture_render_enabled") == false) goto L9;
        r2 = 2;
        goto L318
    L311:
        if (r4.equals("data_pull_stream_bitrate") == true) goto L318;
    L314:
        if (r4.equals("data_invitee_established_time") == false) goto L9;
        r2 = 0;
        goto L318
    L5:
        if (r4.indexOf("@") >= (r4.length() - 1)) goto L7;
        r4 = r4.substring(r4.indexOf("@") + 1);
        goto L7
    }

    public static int d(String r2) {
        r2.getClass();
        switch(r2.hashCode()) {
            case -1828284544: goto L14;
            case 106541: goto L10;
            case 1194522754: goto L6;
            default: goto L4;
        };
    L4:
        byte r3 = -1;
    L17:
        switch(r3) {
            case 0: goto L23;
            case 1: goto L21;
            case 2: goto L19;
            default: goto L28;
        };
    L19:
        return 11;
    L23:
        return 13;
    L28:
        return -1;
    L21:
        if (i() == true) goto L26;
        return 14;
    L26:
        return -1;
    L6:
        if (r2.equals("link_mic") == false) goto L4;
        r3 = 2;
        goto L17
    L10:
        if (r2.equals("ktv") == false) goto L4;
        r3 = 1;
        goto L17
    L14:
        if (r2.equals("gift_effect") == false) goto L4;
        r3 = 0;
        goto L17
    }

    public static List<vr0.a> f(int r5) {
        if (r5 != 2) goto L28;
        ArrayList r6 = new ArrayList();
        Iterator r0 = ((ArrayList) d).iterator();
    L6:
        if (r0.hasNext() == false) goto L27;
        Integer r1 = (Integer) r0.next();
        HashMap<Integer, List<String>> r2 = c;
        if (r2.containsKey(r1) == false) goto L6;
        List<String> r3 = r2.get(r1);
        if (r3 == null) goto L6;
        if (r3.isEmpty() == true) goto L6;
        Iterator<String> r4 = r3.iterator();
    L17:
        if (r4.hasNext() == false) goto L6;
        String r7 = r4.next();
        HashMap<String, a> r8 = b;
        if (r8.containsKey(r7) == false) goto L17;
        a r9 = r8.get(r7);
        if (r9 == null) goto L17;
        if (r9.d != 0) goto L17;
        vr0.a r10 = new vr0.a();
        r10.a = r7;
        r10.b = c(r7);
        r10.c = r9.a;
        r6.add(r10);
        goto L17
    L27:
        return r6;
    L28:
        LinkedList r11 = new LinkedList();
        if (r5 == 1) goto L31;
    L34:
        HashMap<Integer, List<String>> r12 = c;
        if (r12.containsKey(Integer.valueOf(r5)) == true) goto L37;
        return r11;
    L37:
        List<String> r13 = r12.get(Integer.valueOf(r5));
        if (r13 != null) goto L40;
    L46:
        return r11;
    L40:
        if (r13.isEmpty() == true) goto L46;
        Iterator<String> r14 = r13.iterator();
    L44:
        if (r14.hasNext() == false) goto L46;
        String r15 = r14.next();
        vr0.a r16 = new vr0.a();
        r16.a = r15;
        r16.b = c(r15);
        r16.c = g(r15);
        r11.add(r16);
        goto L44
    L31:
        if (i() == false) goto L33;
        r5 = 9;
        goto L34
    L33:
        r5 = 10;
        goto L34
    }

    public static String g(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L14;
        HashMap<String, a> r0 = b;
        if (r0.containsKey(r3) == false) goto L14;
        a r4 = r0.get(r3);
        if (r4 == null) goto L14;
        if (r4.d != 0) goto L14;
        return r4.a;
    L14:
        return "";
    }

    public static HashMap<String, String> h(int r3) {
        HashMap<String, String> r0 = new HashMap();
        switch(r3) {
            case 1000: goto L25;
            case 1001: goto L24;
            case 1002: goto L23;
            case 1003: goto L22;
            case 1004: goto L21;
            case 1005: goto L20;
            case 1006: goto L19;
            case 1007: goto L18;
            case 1008: goto L17;
            case 1009: goto L16;
            case 1010: goto L15;
            case 1011: goto L14;
            case 1012: goto L13;
            case 1013: goto L12;
            case 1014: goto L11;
            case 1015: goto L10;
            case 1016: goto L9;
            case 1017: goto L8;
            case 1018: goto L7;
            case 1019: goto L6;
            case 1020: goto L5;
            default: goto L4;
        };
    L4:
        String r4 = "";
        String r1 = "";
    L26:
        r0.put("data_performance_title", r4);
        r0.put("data_performance_type", r1);
        return r0;
    L5:
        r4 = s1.B(2131921292);
        r1 = "data_network_status";
        goto L26
    L6:
        r4 = s1.B(2131921291);
        r1 = "data_network_frequency";
        goto L26
    L7:
        r4 = s1.B(2131921274);
        r1 = "data_http_rtt";
        goto L26
    L8:
        r4 = s1.B(2131921301);
        r1 = "data_pull_download_speed";
        goto L26
    L9:
        r4 = s1.B(2131921311);
        r1 = "data_avg_fps";
        goto L26
    L10:
        r4 = s1.B(2131921296);
        r1 = "data_preview_fps";
        goto L26
    L11:
        r4 = s1.B(2131921269);
        r1 = "data_game_render_fps";
        goto L26
    L12:
        r4 = s1.B(2131921244);
        r1 = "data_temperature";
        goto L26
    L13:
        r4 = s1.B(2131921242);
        r1 = "data_current";
        goto L26
    L14:
        r4 = s1.B(2131921243);
        r1 = "data_battery_health";
        goto L26
    L15:
        r4 = s1.B(2131921324);
        r1 = "data_private_system_summary";
        goto L26
    L16:
        r4 = s1.B(2131921297);
        r1 = "data_private_other_summary";
        goto L26
    L17:
        r4 = s1.B(2131921318);
        r1 = "data_stack_summary";
        goto L26
    L18:
        r4 = s1.B(2131921250);
        r1 = "data_code_summary";
        goto L26
    L19:
        r4 = s1.B(2131921290);
        r1 = "data_native_heap_summary";
        goto L26
    L20:
        r4 = s1.B(2131921279);
        r1 = "data_java_heap_summary";
        goto L26
    L21:
        r4 = s1.B(2131921271);
        r1 = "data_graphics";
        goto L26
    L22:
        r4 = s1.B(2131921298);
        r1 = "data_pss_total";
        goto L26
    L23:
        r4 = s1.B(2131921270);
        r1 = "data_gpu_used";
        goto L26
    L24:
        r4 = s1.B(2131921253);
        r1 = "data_cpu_speed";
        goto L26
    L25:
        r4 = s1.B(2131921251);
        r1 = "data_cpu_rate";
        goto L26
    }

    public static String e(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return "";
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return "";
    L7:
        return r1 + "@" + r2;
    }

    public static void j(String r2, boolean r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        int r4 = d(r2);
        if (r4 >= 0) goto L8;
        return;
    L8:
        if (r3 == false) goto L12;
        List<Integer> r5 = d;
        ArrayList r1 = (ArrayList) r5;
        if (r1.contains(Integer.valueOf(r4)) == true) goto L16;
        ArrayList r6 = (ArrayList) r5;
        r6.add(Integer.valueOf(r4));
        return;
    L16:
        return;
    L12:
        List<Integer> r7 = d;
        ArrayList r8 = (ArrayList) r7;
        if (r8.contains(Integer.valueOf(r4)) == false) goto L18;
        ArrayList r9 = (ArrayList) r7;
        r9.remove(Integer.valueOf(r4));
        return;
    }
}
