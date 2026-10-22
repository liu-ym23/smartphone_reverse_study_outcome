package e30;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import ca0.j;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.event.g0;
import com.bytedance.android.livesdk.gift.model.GiftPage;
import com.bytedance.android.livesdk.h;
import com.bytedance.android.livesdk.o1;
import com.bytedance.android.livesdk.p1;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.z0;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.ies.web.jsbridge2.d0;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import n56.f;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a implements n56.c {
    public final WeakReference<Context> a;
    public WeakReference<d0> b;
    public final WeakReference<View> c;

    public abstract void a(JSONObject r1, JSONObject r2) throws Exception;

    public abstract void b(f r1, JSONObject r2, JSONObject r3) throws JSONException;

    public abstract void c(boolean r1);

    public abstract void d(JSONObject r1, JSONObject r2) throws Exception;

    public abstract void e(JSONObject r1, JSONObject r2) throws Exception;

    public abstract void f(JSONObject r1, JSONObject r2) throws JSONException;

    public abstract void g(JSONObject r1, JSONObject r2) throws JSONException;

    public abstract void h(JSONObject r1, JSONObject r2) throws Exception;

    public abstract void i(JSONObject r1, JSONObject r2, boolean r3);

    public abstract void j(JSONObject r1, JSONObject r2) throws Exception;

    public abstract void k(JSONObject r1, JSONObject r2) throws Exception;

    public abstract void l(JSONObject r1, JSONObject r2, boolean r3) throws Exception;

    public abstract void m(JSONObject r1, JSONObject r2) throws Exception;

    public a(WeakReference<Context> r1) {
        this.a = r1;
    }

    public a(WeakReference<Context> r1, WeakReference<View> r2) {
        this.a = r1;
        this.c = r2;
    }

    public void call(f r52, JSONObject r53) throws Exception {
        a r1 = this;
        r53.put("code", 0);
        r53.put("msg", "E-1");
        WeakReference<Context> r0 = r1.a;
        if (r0 != null) goto L5;
    L6:
        r53.put("msg", "E-1, mContextRef == null");
    L7:
        String r2 = r52.d.optString("type");
        if (TextUtils.isEmpty(r2) == false) goto L12;
        r53.put("code", 0);
        r53.put("msg", "E-2");
        return;
    L12:
        if (r52.d.has("args") == false) goto L14;
        JSONObject r8 = JSONObjectProtectorUtils.getJSONObject(r52.d, "args");
    L15:
        r2.getClass();
        switch(r2.hashCode()) {
            case -2056089362: goto L91;
            case -1949693950: goto L87;
            case -1932693274: goto L83;
            case -1772600516: goto L79;
            case -1361632588: goto L75;
            case -1001735703: goto L71;
            case -907987547: goto L67;
            case -309425751: goto L63;
            case -191501435: goto L59;
            case 3242771: goto L55;
            case 3322092: goto L51;
            case 3506395: goto L47;
            case 65209337: goto L43;
            case 112202875: goto L39;
            case 505229877: goto L35;
            case 845427215: goto L31;
            case 1152538955: goto L27;
            case 1224424441: goto L23;
            case 1654221230: goto L19;
            default: goto L94;
        };
    L94:
        byte r11 = -1;
    L95:
        String r15 = GamePromoteDataContext.GAME_TYPE_MOBILE;
        String r12 = "0";
        switch(r11) {
            case 0: goto L337;
            case 1: goto L336;
            case 2: goto L335;
            case 3: goto L334;
            case 4: goto L333;
            case 5: goto L335;
            case 6: goto L288;
            case 7: goto L195;
            case 8: goto L192;
            case 9: goto L191;
            case 10: goto L190;
            case 11: goto L189;
            case 12: goto L183;
            case 13: goto L181;
            case 14: goto L103;
            case 15: goto L101;
            case 16: goto L100;
            case 17: goto L99;
            case 18: goto L98;
            default: goto L97;
        };
    L97:
        r12 = "0";
        r15 = GamePromoteDataContext.GAME_TYPE_MOBILE;
        boolean r5 = true;
        f r4 = r52;
        r53.put("code", 1);
    L339:
        boolean r3 = r4.d.optBoolean("keep_open", r5);
        boolean r6 = r4.d.optString("close_webview", r12).equals(r15);
        Context r7 = r1.a.get();
        if (r3 == false) goto L343;
        if (r6 == true) goto L343;
        return;
    L343:
        if ((r7 instanceof Activity) == false) goto L374;
        Iterator r9 = k.f(IMiddlewareHostApp.class).getAllLiveActivity().iterator();
    L346:
        if (r9.hasNext() == false) goto L350;
        if (((Class) r9.next()).isAssignableFrom(r7.getClass()) == false) goto L346;
    L351:
        if (r5 == false) goto L353;
        xs2.b.a().post(new b30.c());
        Annie.closeAllAnnieDialog(null);
        return;
    L353:
        ((Activity) r7).finish();
        return;
    L350:
        r5 = false;
        goto L351
    L374:
        return;
    L98:
        r1.i(r8, r53, r52.d.optBoolean("through_aweme", true));
    L193:
        r4 = r52;
        r12 = "0";
        r15 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L194:
        r5 = true;
        goto L339
    L99:
        r1.g(r8, r53);
        goto L193
    L100:
        xs2.b.a().post(new g0());
        goto L193
    L101:
        r1.a(r8, r53);
        goto L193
    L181:
        r1.k(r8, r53);
        goto L193
    L189:
        r1.m(r8, r53);
        goto L193
    L190:
        xs2.b.a().post(new g0());
        goto L193
    L191:
        r1.h(r8, r53);
        goto L193
    L192:
        r1.d(r8, r53);
        goto L193
    L195:
        if (r8 != null) goto L197;
        r8 = new JSONObject();
    L197:
        String r13 = r8.optString("user_id");
        if (TextUtils.isEmpty(r13) == false) goto L200;
        r53.put("msg", "E-9");
        r53.put("code", 0);
    L286:
        r4 = r52;
        goto L194
    L200:
        String r14 = r8.optString("sec_user_id");
        if (TextUtils.isEmpty(r14) == false) goto L203;
        r14 = r8.optString("sec_uid");
    L203:
        String r16 = r8.optString("source");
        String r17 = r8.optString("click_user_position");
        String r18 = r8.optString("order");
        String r19 = r8.optString("ksong_user_type");
        String r21 = r8.optString("ksong_to_user_type");
        String r22 = r8.optString("vs_follow_position");
        String r23 = r8.optString("mystery_man");
        String r24 = r8.optString("is_anonymous");
        String r25 = r8.optString("commont_report_model");
        String r26 = r8.optString("to_comment_category");
        String r27 = r8.optString("is_from_at_user_nickname");
        String r28 = r8.optString("to_discussion_board_comment_id");
        String r29 = r8.optString("request_page");
        String r31 = r8.optString("report_type");
        String r32 = r8.optString("report_type_for_log");
        String r33 = r8.optString("dress_id");
        String r34 = r8.optString("skip_privacy_check");
        String r35 = r8.optString("skip_android_exist_panel_check");
        HashMap r36 = new HashMap();
        r36.put("report_from_pre", r8.optString("report_from_pre"));
        r36.put("report_from_label", r8.optString("report_from_label"));
        r36.put("report_from_action", r8.optString("report_from_action"));
        HashMap r37 = new HashMap();
        JSONObject r38 = r8.optJSONObject("event_params");
        if (r38 == null) goto L209;
        Map<String, String> r39 = JsonUtil.jsonObjectToMap(r38);
        if (r39 == null) goto L209;
        r37.putAll(r39);
    L209:
        if (TextUtils.isEmpty(r14) == true) goto L212;
        r37.put("sec_user_id", r14);
    L212:
        if (TextUtils.isEmpty(r16) == true) goto L215;
        r37.put("source", r16);
    L215:
        if (TextUtils.isEmpty(r17) == true) goto L218;
        r37.put("click_user_position", r17);
    L218:
        if (TextUtils.isEmpty(r18) == true) goto L221;
        r37.put("order", r18);
    L221:
        if (TextUtils.isEmpty(r19) == true) goto L224;
        r37.put("ksong_user_type", r19);
    L224:
        if (TextUtils.isEmpty(r21) == true) goto L227;
        r37.put("ksong_to_user_type", r21);
    L227:
        if (TextUtils.isEmpty(r22) == true) goto L230;
        r37.put("vs_follow_position", r22);
    L230:
        if (TextUtils.isEmpty(r23) == true) goto L233;
        r37.put("mystery_man", r23);
    L233:
        if (TextUtils.isEmpty(r24) == true) goto L236;
        r37.put("is_anonymous", r24);
    L236:
        if (TextUtils.isEmpty(r25) == true) goto L239;
        r37.put("commont_report_model", r25);
    L239:
        if (TextUtils.isEmpty(r26) == true) goto L242;
        r37.put("to_comment_category", r26);
    L242:
        if (TextUtils.isEmpty(r27) == true) goto L245;
        r37.put("is_from_at_user_nickname", r27);
    L245:
        if (TextUtils.isEmpty(r28) == true) goto L248;
        r37.put("to_discussion_board_comment_id", r28);
    L248:
        if (TextUtils.isEmpty(r29) == true) goto L251;
        r37.put("request_page", r29);
    L251:
        if (TextUtils.isEmpty(r31) == true) goto L254;
        r37.put("report_type", r31);
    L254:
        if (TextUtils.isEmpty(r32) == true) goto L259;
        if (((Boolean) h.a.getValue()).booleanValue() == false) goto L259;
        r37.put("report_type_for_log", r32);
    L259:
        if (TextUtils.isEmpty(r33) == true) goto L262;
        r37.put("dress_id", r33);
    L262:
        if (TextUtils.isEmpty(r34) == true) goto L355;
        r37.put("skip_privacy_check", r34);
    L355:
        r37.put("extra_follow_params", JsonUtil.toJSONString(r36));     // Catch: Exception -> L266
    L268:
        String r41 = r8.optString("follow_scene");
        if (TextUtils.isEmpty(r41) == true) goto L271;
        r37.put("follow_scene", r41);
    L271:
        r37.put("show_anchor_live_entrance", r8.optString("show_anchor_live_entrance"));
        if (TextUtils.isEmpty(r35) == true) goto L275;
        r37.put("skip_android_exist_panel_check", r35);
    L275:
        if (((Boolean) o1.a.getValue()).booleanValue() == false) goto L285;
        String r42 = r8.optString("report_source");
        if (TextUtils.isEmpty(r42) == true) goto L279;
        r37.put("report_source", r42);
    L279:
        String r43 = r8.optString("show_send_gift");
        if (TextUtils.isEmpty(r43) == true) goto L282;
        r37.put("show_send_gift", r43);
    L282:
        String r44 = r8.optString("from_interact_emoji_panel");
        if (TextUtils.isEmpty(r44) == true) goto L285;
        r37.put("from_interact_emoji_panel", r44);
    L285:
        r37.put("is_in_room", "true");
        r1 = this;
        boolean r45 = k.f(IMiddlewareRoomService.class).actionHandler().showUserProfileExt(r1.a.get(), r13, r8.optString("type"), r37);
        r53.put("msg", "E-10");
        r53.put("code", r45 ? 1 : 0);
    L266:
        e = move-exception;
        SafetyGuard.a(null, e, null);
        goto L268
    L333:
        r4 = r52;
        r1.b(r4, r8, r53);
    L338:
        r5 = true;
        goto L339
    L334:
        r4 = r52;
        r1.f(r8, r53);
        goto L338
    L335:
        r4 = r52;
        r1.l(r8, r53, "lynxview_popup".equals(r2));
        goto L338
    L336:
        r4 = r52;
        r1.j(r8, r53);
        goto L338
    L337:
        r4 = r52;
        r1.e(r8, r53);
        goto L338
    L103:
        if (k.f(g50.c.class) != null) goto L106;
        f2.c("当前版本暂不支持送礼功能，请联系应用服务商", 0);
        goto L193
    L106:
        if (r52.d.has("page_type") == false) goto L109;
        int r46 = r52.d.optInt("page_type");
    L112:
        if (r46 != 0) goto L114;
        r46 = 1;
    L114:
        if (r8 != null) goto L116;
    L118:
        String r210 = "0";
    L120:
        if (r52.d.has("gift_id") == false) goto L122;
        long r47 = r52.d.optInt("gift_id");
    L123:
        long r110 = r47;
        if (r52.d.has("card_name") == false) goto L126;
        String r48 = r52.d.optString("card_name");
    L127:
        String r211 = r48;
        Bundle r49 = new Bundle();
        if (r52.d.has("gift_log_extra") == false) goto L156;
        JSONObject r51 = JSONObjectProtectorUtils.getJSONObject(r52.d, "gift_log_extra");
        Bundle r54 = new Bundle();
        if (r51 == null) goto L154;
        Iterator<String> r55 = r51.keys();
    L134:
        if (r55.hasNext() == false) goto L154;
        String r111 = r55.next();
        Object r112 = r51.get(r111);
        if ((r112 instanceof Boolean) == true) goto L153;
        if ((r112 instanceof Byte) == true) goto L153;
        if ((r112 instanceof Character) == true) goto L153;
        if ((r112 instanceof Double) == true) goto L153;
        if ((r112 instanceof Float) == true) goto L153;
        if ((r112 instanceof Integer) == true) goto L153;
        if ((r112 instanceof Long) == true) goto L153;
        if ((r112 instanceof Short) == true) goto L153;
        if ((r112 instanceof String) == false) goto L134;
    L153:
        r54.putString(r111, String.valueOf(r112));
    L154:
        r49 = r54;
    L156:
        if (r52.d.has("gift_show_from") == false) goto L159;
        r49.putString("gift_show_from", r52.d.optString("gift_show_from"));
    L159:
        if (r52.d.has("gift_send_times") == false) goto L162;
        r49.putString("gift_send_times", r52.d.optString("gift_send_times"));
    L162:
        if (r49.containsKey("gift_show_from") == true) goto L164;
        r49.putString("gift_show_from", "jsb");
    L164:
        if (r8 != null) goto L166;
    L168:
        boolean r212 = false;
    L169:
        new ArrayList();
        List r56 = new ArrayList();
        if (r8 != null) goto L172;
    L174:
        if (r212 == false) goto L176;
        int r57 = n0.a;
        o0.a.getClass();
        ((g50.c) k.f(g50.c.class)).openGiftDialog(r46, r110, r49, o0.a.h(r56), r212, r211);
    L178:
        if (r46 != 5) goto L180;
        boolean r58 = com.bytedance.android.live.revenue.core.util.h.a;
        ((j) com.bytedance.android.live.revenue.core.util.h.d(j.class)).syncGiftPanel();
    L180:
        r53.put("code", 1);
        goto L193
    L176:
        ((g50.c) k.f(g50.c.class)).openGiftDialog(r46, r110, r210, r49, 0, r52.d.optJSONObject("gift_send_extra"), r211);
        goto L178
    L172:
        if (r8.has("user_ids") == false) goto L174;
        r56 = GsonHelper.fromJsonArray(JSONObjectProtectorUtils.getString(r8, "user_ids"), String.class);
        goto L174
    L166:
        if (r8.has("is_all_mic") == false) goto L168;
        r212 = JSONObjectProtectorUtils.getBoolean(r8, "is_all_mic");
        goto L169
    L126:
        r48 = "";
        goto L127
    L122:
        r47 = -1;
        goto L123
    L116:
        if (r8.has("user_id") == false) goto L118;
        int r59 = n0.a;
        r210 = o0.a.e(o0.a, r8, "user_id");
        goto L120
    L109:
        if (r52.d.has("panel_type") == false) goto L111;
        r46 = GiftPage.convertPageTypeFromString(JSONObjectProtectorUtils.getString(r52.d, "panel_type"));
        goto L112
    L111:
        r46 = 0;
        goto L112
    L183:
        if (r52.d.has("args") == true) goto L185;
    L187:
        boolean r61 = false;
    L188:
        r1.c(r61);
        r53.put("code", 1);
        goto L193
    L185:
        if (JSONObjectProtectorUtils.getJSONObject(r52.d, "args").has("enableDanmaku") == false) goto L187;
        r61 = TextUtils.equals(JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(r52.d, "args"), "enableDanmaku"), GamePromoteDataContext.GAME_TYPE_MOBILE);
        goto L188
    L288:
        if (r8 != null) goto L290;
        r53.put("code", 0);
        r53.put("msg", "handleSchema args is null");
    L332:
        r4 = r52;
        goto L338
    L290:
        String r62 = JSONObjectProtectorUtils.getString(r8, LiveSlardarConstants.EXTRA_KEY_URL);
        int r63 = r8.optInt("force_switch_to_portrait", 0);
        Context r64 = r1.a.get();
        ALogger.i("OpenLiveMethod", "handleSchema mContextRef: " + r1.a + "mContextRef.get(): " + r64);
        if (((Boolean) z0.a.getValue()).booleanValue() == true) goto L293;
        int r113 = 1;
        boolean r114 = !PadConfigUtils.c();
    L294:
        if (r64 == null) goto L302;
        if (r63 != r113) goto L302;
        if (r114 == false) goto L302;
        if ((r64 instanceof Activity) == false) goto L302;
        if (e5.g((Activity) r64) == false) goto L302;
        xs2.b.a().post(new HorizontalPlayEvent(r113, "source_for_jsb_force_switch_to_portrait", r62));
        r53.put("code", r113);
    L302:
        WeakReference<View> r65 = r1.c;
        if (r65 == null) goto L305;
        View r66 = r65.get();
    L311:
        JSONObject r67 = r8.optJSONObject("extra");
        int r68 = r30.a.a;
        Intrinsics.checkNotNullParameter(r62, "schema");
        IMiddlewareHostBusiness r69 = k.f(IMiddlewareHostBusiness.class);
        if (r69 == null) goto L323;
        String r71 = r69.getSourceBtmToken2Schema(r66, r67);
        if (r71 != null) goto L316;
    L319:
        boolean r72 = true;
    L320:
        if (r72 == true) goto L323;
        r62 = UriProtector.parse(r62).buildUpon().appendQueryParameter("source_btm_token", r71).build().toString();
        goto L323
    L316:
        if (r71.length() == 0) goto L319;
        r72 = false;
    L323:
        if (((Boolean) p1.a.getValue()).booleanValue() == false) goto L326;
        if (r64 != null) goto L326;
        r64 = s1.getContext();
    L326:
        if (r64 != null) goto L328;
    L331:
        r53.put("code", 0);
        r53.put("msg", "handle schema failed");
        ALogger.e("OpenLiveMethod", " context: " + r64 + "handleSchema failed, schema: " + r62);
        goto L332
    L328:
        if (k.f(IMiddlewareRoomService.class).actionHandler().handle(r64, r62) == false) goto L331;
        r53.put("code", 1);
        goto L332
    L305:
        WeakReference<d0> r73 = r1.b;
        if (r73 == null) goto L310;
        d0 r74 = r73.get();
        if (r74 == null) goto L310;
        r66 = r74.a.g();
    L310:
        r66 = null;
        goto L311
    L293:
        r113 = 1;
        r114 = true;
        goto L294
    L19:
        if (r2.equals("login_panel") == false) goto L94;
        r11 = 18;
        goto L95
    L23:
        if (r2.equals("webview") == false) goto L94;
        r11 = 17;
        goto L95
    L27:
        if (r2.equals("upload_poster") == false) goto L94;
        r11 = 16;
        goto L95
    L31:
        if (r2.equals("broadcast_task_finish") == false) goto L94;
        r11 = 15;
        goto L95
    L35:
        if (r2.equals("gift_panel") == false) goto L94;
        r11 = 14;
        goto L95
    L39:
        if (r2.equals(FileUtils.VIDEO) == false) goto L94;
        r11 = 13;
        goto L95
    L43:
        if (r2.equals("comments_panel") == false) goto L94;
        r11 = 12;
        goto L95
    L47:
        if (r2.equals(NewBroadcastMonitor.PAGE.ROOM) == false) goto L94;
        r11 = 11;
        goto L95
    L51:
        if (r2.equals(GamePromoteDataContext.LIVE) == false) goto L94;
        r11 = 10;
        goto L95
    L55:
        if (r2.equals("item") == false) goto L94;
        r11 = 9;
        goto L95
    L59:
        if (r2.equals("feedback") == false) goto L94;
        r11 = 8;
        goto L95
    L63:
        if (r2.equals("profile") == false) goto L94;
        r11 = 7;
        goto L95
    L67:
        if (r2.equals("scheme") == false) goto L94;
        r11 = 6;
        goto L95
    L71:
        if (r2.equals("lynxview_popup") == false) goto L94;
        r11 = 5;
        goto L95
    L75:
        if (r2.equals("charge") == false) goto L94;
        r11 = 4;
        goto L95
    L79:
        if (r2.equals("lynxview") == false) goto L94;
        r11 = 3;
        goto L95
    L83:
        if (r2.equals("webview_popup") == false) goto L94;
        r11 = 2;
        goto L95
    L87:
        if (r2.equals("feedback_send") == false) goto L94;
        r11 = 1;
        goto L95
    L91:
        if (r2.equals("follow_guide") == false) goto L94;
        r11 = 0;
        goto L95
    L14:
        r8 = null;
        goto L15
    L5:
        if (r0.get() != null) goto L7;
        goto L6
    }
}
