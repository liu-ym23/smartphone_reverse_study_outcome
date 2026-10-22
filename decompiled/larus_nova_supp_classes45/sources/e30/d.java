package e30;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import b30.d0;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcast.api.model.k;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.webview.fragment.n;
import com.bytedance.android.live.browser.webview.fragment.o;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.config.cy0;
import com.bytedance.android.livesdk.config.fo;
import com.bytedance.android.livesdk.config.gm0;
import com.bytedance.android.livesdk.message.model.p4;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.schema.interfaces.IRoomActionHandler;
import com.bytedance.android.livesdk.schema.model.RoomSchemaMode;
import com.bytedance.android.livesdk.schema.model.RoomSchemaModelHelper;
import com.bytedance.android.livesdk.vs.e;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import ita.l;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import x40.f;
import x40.h;
import x40.i;
import zg1.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class d extends a {
    public d(WeakReference<Context> r1) {
        super(r1);
    }

    public static Boolean o(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return Boolean.FALSE;
    L7:
        return Boolean.valueOf(!TextUtils.equals(UriProtector.getQueryParameter(UriProtector.parse(r1), "engine_type"), "old"));
    }

    @Override // e30.a
    public final void c(boolean r2) {
        TTLiveService.getLiveService().sendMessage(r2);
    }

    public d(WeakReference<Context> r1, WeakReference<View> r2) {
        super(r1, r2);
    }

    public static void n(JSONObject r7, Bundle r8) {
        if (r7.has("business_params") == false) goto L23;
        JSONObject r9 = r7.optJSONObject("business_params");
        if (r9 != null) goto L7;
        return;
    L7:
        if (r9.has("live_community_params") == false) goto L25;
        JSONObject r11 = r9.optJSONObject("live_community_params");
        if (r11 == null) goto L26;
        boolean r0 = r11.optBoolean("show_red_envelope", false);
        String r2 = r11.optString("red_envelope_id", GamePromoteDataContext.GAME_TYPE_MOBILE);
        boolean r1 = r11.optBoolean("show_lottery", false);
        String r12 = r11.optString("lottery_id", "0");
        r8.putBoolean("click_red_packet_from_preview", r0);
        long r3 = CastLongProtector.parseLong(r12);     // Catch: Exception -> L13
    L19:
        long r5 = CastLongProtector.parseLong(r2);     // Catch: Exception -> L16
    L17:
        r8.putLong("click_red_packet_from_preview_id", r5);
        r8.putBoolean("click_lottery_from_preview", r1);
        r8.putLong("preview_lottery_id", r3);
        return;
    L16:
        r5 = 1;
    L13:
        r3 = 0;
        goto L19
    L26:
        return;
    L25:
        return;
    }

    @Override // e30.a
    public final void a(JSONObject r4, JSONObject r5) throws Exception {
        if (r4 != null) goto L6;
        r5.put("msg", "E-4");
        r5.put("code", 0);
        return;
    L6:
        k r6 = new k();
        r4.optString("title", "");
        r4.optString("content", "");
        r4.optBoolean("isfirst", false);
        xs2.b.a().post(r6);
    }

    @Override // e30.a
    public final void d(JSONObject r4, JSONObject r5) throws Exception {
        String r0 = "";
        if (r4 == null) goto L5;
        r4.optInt("feedback_id", -1);
        r0 = r4.optString("source", "");
    L5:
        WeakReference<Context> r6 = this.a;
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.get() == null) goto L12;
        Context r7 = this.a.get();
        jc1.k.f(IHostAction.class).openFeedBack(r0, r7);
        r5.put("code", 1);
        return;
    }

    @Override // e30.a
    public final void e(JSONObject r2, JSONObject r3) throws Exception {
        if (r2 == null) goto L11;
        WeakReference<Context> r4 = this.a;
        if (r4 == null) goto L11;
        Context r5 = r4.get();
        if (r5 != null) goto L9;
        return;
    L9:
        p4 r6 = new p4();
        r6.setContent(r5.getString(2131919117));
        xs2.b.a().post(new d0(r6));
        return;
    L11:
        r3.put("msg", "E-3");
        r3.put("code", 0);
    }

    @Override // e30.a
    public final void f(JSONObject r9, JSONObject r11) throws JSONException {
        Context r0 = this.a.get();
        if (r9 != null) goto L5;
    L17:
        r11.put("code", 0);
        r11.put("msg", "E-55555");
        ALogger.e("OpenLiveMethod", "handleFullScreenLynxView arg: " + r9 + " mContextRef: " + this.a);
        return;
    L5:
        if (this.a == null) goto L17;
        String r3 = r9.optString(LiveSlardarConstants.EXTRA_KEY_URL);
        Bundle r4 = new Bundle();
        if (r9.optInt("hide_nav_bar", 0) != 1) goto L10;
        boolean r6 = true;
    L11:
        r4.putBoolean("hide_nav_bar", r6);
        if (r9.optInt("hide_status_bar", 0) != 1) goto L14;
        boolean r7 = true;
    L15:
        r4.putBoolean("hide_status_bar", r7);
        r4.putString("status_bar_color", r9.optString("status_bar_color"));
        r4.putString("status_bar_bg_color", r9.optString("status_bar_bg_color"));
        r4.putInt("bundle_web_view_background_color", s1.h(2131106889));
        r4.putBoolean("bundle_user_webview_title", true);
        r4.putBoolean("support_exchange_theme", false);
        r4.putBoolean("use_annie", o(r3).booleanValue());
        jc1.k.f(IHostAction.class).openLiveLynx(r3, r4, r0);
        r11.put("code", 1);
        return;
    L14:
        r7 = false;
        goto L15
    L10:
        r6 = false;
        goto L11
    }

    @Override // e30.a
    public final void g(JSONObject r9, JSONObject r11) throws JSONException {
        Context r0 = this.a.get();
        if (r9 != null) goto L5;
    L9:
        r11.put("code", 0);
        r11.put("msg", "E-44444");
        ALogger.e("OpenLiveMethod", "handleFullScreenWebView arg: " + r9 + " mContextRef: " + this.a);
        return;
    L5:
        if (this.a == null) goto L9;
        String r2 = r9.optString(LiveSlardarConstants.EXTRA_KEY_URL);
        String r3 = r9.optString("title");
        String r4 = r9.optString("hide_nav_bar");
        String r5 = r9.optString("hide_status_bar");
        String r6 = r9.optString("hide_system_video_poster");
        u30.a r1 = ((IBrowserService) jc1.k.f(IBrowserService.class)).buildFullScreenWebPage(r0, r2).setTitle(r3);
        r1.c = TextUtils.equals(r5, GamePromoteDataContext.GAME_TYPE_MOBILE);
        r1.d = r9.optString("status_bar_color");
        r1.e = r9.optString("status_bar_bg_color");
        r1.b = TextUtils.equals(r4, GamePromoteDataContext.GAME_TYPE_MOBILE);
        r1.f = TextUtils.equals(r6, GamePromoteDataContext.GAME_TYPE_MOBILE);
        r1.i = TextUtils.equals(r9.optString("show_back"), GamePromoteDataContext.GAME_TYPE_MOBILE);
        r1.h = TextUtils.equals(r9.optString("enable_share"), GamePromoteDataContext.GAME_TYPE_MOBILE);
        r1.j = o(r2).booleanValue();
        r1.b();
        r11.put("code", 1);
    }

    @Override // e30.a
    public final void h(JSONObject r7, JSONObject r8) throws Exception {
        if (r7 != null) goto L6;
        r8.put("msg", "E-6");
        r8.put("code", 0);
        return;
    L6:
        jc1.k.f(IRoomService.class).actionHandler().handle(this.a.get(), new l("snssdk1128://aweme/detail/" + r7.optString("item_id")).d());
        r8.put("code", 1);
        r8.put("msg", "E-7");
        r8.put("code", 0);
    }

    @Override // e30.a
    public final void j(JSONObject r5, JSONObject r6) throws Exception {
        if (r5 != null) goto L6;
        r6.put("code", 0);
        r6.put("msg", "handleSendFeedback args is null");
        return;
    L6:
        Context r1 = this.a.get();
        jc1.k.f(IHostAction.class).openFeedBack(r5.optString("source"), r1);
        if ((r1 instanceof Activity) == false) goto L9;
        ((Activity) r1).finish();
    L9:
        r6.put("code", 1);
    }

    @Override // e30.a
    public final void k(JSONObject r4, JSONObject r5) throws Exception {
        if (r4 != null) goto L5;
        r5.put("msg", "E-5");
        r5.put("code", 0);
        return;
    L5:
        String r0 = r4.optString("item_id");
        l r1 = new l("sslocal://detail/video");
        r1.c("groupid", r0);
        r1.c("item_id", r0);
        r1.c("aggr_type", GamePromoteDataContext.GAME_TYPE_MINI);
        r1.c("enter_from", r4.optString("enter_from", "click_live_room"));
        r1.c("category_name", r4.optString("category_name", "live_room"));
        jc1.k.f(IRoomService.class).actionHandler().handle(this.a.get(), r1.d());
    }

    @Override // e30.a
    public final void m(JSONObject r21, JSONObject r22) throws Exception {
        if (r21 != null) goto L5;
    L86:
        r22.put("msg", "E-11");
        r22.put("code", 0);
        x40.c.c(ActivityMonitor.ActivityStatusCode.UNKNOWN_CODE.getCode(), r21, "room_id or args is null", r22.toString());
        return;
    L5:
        if (r21.has("room_id") == false) goto L86;
        WeakReference<Context> r7 = this.a;
        if (r7 == null) goto L10;
        Context r8 = r7.get();
    L11:
        if (r8 != null) goto L14;
        r22.put("msg", "E-12");
        r22.put("code", 0);
        x40.c.c(ActivityMonitor.ActivityStatusCode.UNKNOWN_CODE.getCode(), r21, "context is null", r21.toString());
        return;
    L14:
        String r0 = JSONObjectProtectorUtils.getString(r21, "room_id");
        String r9 = r21.optString("form_label", "");
        long r11 = CastLongProtector.parseLong(r21.optString("camera_id", ""));     // Catch: Exception -> L17
    L18:
        long r13 = CastLongProtector.parseLong(r0);
        Map<String, i> r1 = f.a;
        Long r2 = Long.valueOf(r13);
        if (h.a().booleanValue() == false) goto L26;
        Iterator<T> r15 = f.b.iterator();
    L23:
        if (r15.hasNext() == false) goto L26;
        f.a((String) r15.next(), r2, "OPEN_LIVE_JSB_START");
    L26:
        if (r21.has("log_extra") == false) goto L28;
        JSONObject r3 = JSONObjectProtectorUtils.getJSONObject(r21, "log_extra");
    L29:
        Bundle r6 = new Bundle();
        if (r3 == null) goto L55;
        Iterator<String> r12 = r3.keys();
    L34:
        if (r12.hasNext() == false) goto L55;
        String r16 = r12.next();
        Iterator<String> r18 = r12;
        Object r14 = r3.get(r16);
        JSONObject r19 = r3;
        if ((r14 instanceof Boolean) == false) goto L38;
    L53:
        r6.putString(r16, String.valueOf(r14));
    L54:
        r12 = r18;
        r3 = r19;
        goto L34
    L38:
        if ((r14 instanceof Byte) == true) goto L53;
        if ((r14 instanceof Character) == true) goto L53;
        if ((r14 instanceof Double) == true) goto L53;
        if ((r14 instanceof Float) == true) goto L53;
        if ((r14 instanceof Integer) == true) goto L53;
        if ((r14 instanceof Long) == true) goto L53;
        if ((r14 instanceof Short) == true) goto L53;
        if ((r14 instanceof String) == false) goto L54;
    L55:
        r6.putString("from_lable", r9);
        Map<String, i> r4 = f.a;
        f.b(Long.valueOf(r13));
        JSONObject r5 = r21.optJSONObject("extra");
        WeakReference<View> r17 = this.c;
        if (r17 == null) goto L60;
        int r110 = r30.a.a;
        IMiddlewareHostBusiness r111 = jc1.k.f(IMiddlewareHostBusiness.class);
        if (r111 == null) goto L68;
        String r23 = r111.getSourceBtmToken2Schema(r17.get(), r5);
    L69:
        Bundle r112 = new Bundle();
        n(r21, r112);     // Catch: Exception -> L72
    L74:
        IRoomActionHandler.Params r24 = new IRoomActionHandler.Params().setRoomId(r13).setOpenGiftPanel(r21.optBoolean("gift_panel", false)).setOpenPropPanel(r21.optBoolean("prop_panel", false)).setOpenFollowGuide(r21.optBoolean("follow_guide", false)).setOpenFansClubGuide(r21.optBoolean("fans_club_msg_guide", false)).setOpenShowListPage(r21.optBoolean("is_from_mic_programme", false)).setFansClubGuideMsg(r21.optString("fans_club_msg_content")).setFansClubGuideSource(r21.optString("fans_club_msg_source")).setOpenPickProfilePanel(r21.optBoolean("is_open_profile_panel", false), r21.optBoolean("is_pick3", false)).setBackRoom(String.valueOf("non-connect-pk".equals(r9))).setCameraId(r11).setLogExtras(r6).setEnterLiveBundle(r112).setSourceBtmToken(r23);
        r24.setEnterFrom(r21.optString("enter_from", "web")).setEnterLiveSource(r21.optString("enter_from", "web")).setEnterFromModule(r21.optString("enter_from", "web")).setEnterFromMerge(r21.optString("enter_from_merge", "h5")).setEnterMethod(r21.optString("enter_method", "h5"));
        RoomSchemaMode r25 = RoomSchemaModelHelper.INSTANCE.getNewSchemaModel(r21);
        if (jc1.k.f(IRoomService.class).actionHandler().openRoom(r8, r24, r25) == false) goto L77;
        r22.put("code", 1);
        x40.c.c(ActivityMonitor.ActivityStatusCode.SUCCESS.getCode(), r21, "success", "");
        Map<String, i> r26 = f.a;
        f.b(Long.valueOf(r13));
    L78:
        Map<String, i> r27 = f.a;
        Long r28 = Long.valueOf(r13);
        if (h.a().booleanValue() == false) goto L85;
        Iterator<T> r29 = f.b.iterator();
    L83:
        if (r29.hasNext() == false) goto L97;
        f.a((String) r29.next(), r28, "OPEN_LIVE_JSB_END");
        goto L83
    L97:
        return;
    L85:
        return;
    L77:
        r22.put("code", 0);
        r22.put("msg", "open room failed");
        x40.c.c(ActivityMonitor.ActivityStatusCode.UNKNOWN_CODE.getCode(), r21, "failure", "");
    L72:
        e = move-exception;
        Log.getStackTraceString(e);
    L68:
        r23 = null;
        goto L69
    L60:
        WeakReference<com.bytedance.ies.web.jsbridge2.d0> r31 = this.b;
        int r113 = r30.a.a;
        IMiddlewareHostBusiness r114 = jc1.k.f(IMiddlewareHostBusiness.class);
        if (r114 == null) goto L68;
        if (r31 == null) goto L66;
        com.bytedance.ies.web.jsbridge2.d0 r32 = r31.get();
        if (r32 == null) goto L66;
        View r33 = r32.a.g();
    L67:
        r23 = r114.getSourceBtmToken2Schema(r33, r5);
    L66:
        r33 = null;
        goto L67
    L28:
        r3 = null;
    L17:
        r11 = 0;
        goto L18
    L10:
        r8 = null;
        goto L11
    }

    @Override // e30.a
    public final void b(n56.f r11, JSONObject r12, JSONObject r13) throws JSONException {
        Long r2 = 0L;
        int r4 = 2;
        String r5 = "H5";
        String r6 = "";
        if (r12 != null) goto L5;
        String r14 = "H5";
        String r7 = r14;
        String r15 = "";
    L12:
        x2 r8 = new x2(r4, r5, r7, r14);
        if (r2.longValue() <= 0) goto L18;
        if (((Boolean) gm0.a.getValue()).booleanValue() == false) goto L18;
        r8.g = r2.longValue();
    L18:
        if (TextUtils.isEmpty(r15) == true) goto L20;
        r6 = UriProtector.parse(r15).getPath();
    L20:
        r8.s = r6;
        r8.r = "OpenLiveMethod";
        xs2.b.a().post(r8);
        r13.put("code", 1);
        return;
    L5:
        if (TextUtils.equals("half", r12.optString("type", "")) == false) goto L7;
        r4 = 1;
    L7:
        String r3 = r12.optString("enter_from", "H5");
        r7 = r12.optString("click_type", "H5");
        Long r9 = Long.valueOf(JSONObjectProtectorUtils.getLong(r12, "money_diff"));
        JSONObject r16 = r12.optJSONObject("args");
        if (r16 == null) goto L10;
        r5 = r16.optString("charge_reason", "H5");
    L10:
        r15 = r11.g;
        r14 = r5;
        r5 = r3;
        r2 = r9;
        goto L12
    }

    @Override // e30.a
    public final void i(JSONObject r8, JSONObject r9, boolean r11) {
        Context r1 = null;
        if (r11 == false) goto L23;
        WeakReference<Context> r4 = this.a;
        if (r4 == null) goto L49;
        r1 = r4.get();
    L49:
        Bundle r5 = new Bundle();     // Catch: Exception -> L21
        if (r8 == null) goto L15;
        String r6 = r8.optString("themeId");     // Catch: Exception -> L21
        String r12 = r8.optString("loginDesc");     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r6) == true) goto L13;
        r5.putString("themeId", r6);     // Catch: Exception -> L21
    L13:
        if (TextUtils.isEmpty("loginDesc") == true) goto L15;
        r5.putString("loginDesc", r12);     // Catch: Exception -> L21
    L15:
        com.bytedance.android.livesdk.user.f r13 = jc1.k.f(IUserService.class).user();     // Catch: Exception -> L21
        if (r13.isLogin() == true) goto L51;
        com.bytedance.android.livesdk.user.l.a r14 = new com.bytedance.android.livesdk.user.l.a();     // Catch: Exception -> L21
        r14.a = s1.B(2131920130);     // Catch: Exception -> L21
        r14.c = -1;     // Catch: Exception -> L21
        r14.h = r5;     // Catch: Exception -> L21
        r13.login(r1, new com.bytedance.android.livesdk.user.l(r14)).subscribe(new com.bytedance.android.livesdk.user.h());     // Catch: Exception -> L21
        if (r9 == null) goto L52;
        r9.put("code", 1);     // Catch: Exception -> L21 JSONException -> L45
    L46:
        return;
    L52:
        return;
    L51:
        return;
    L21:
        e = move-exception;
        ALogger.e("OpenLiveMethod", e);
        return;
    L23:
        WeakReference<Context> r15 = this.a;
        if (r15 == null) goto L27;
        r1 = r15.get();
    L27:
        if ((r1 instanceof FragmentActivity) == false) goto L30;
        FragmentActivity r2 = (FragmentActivity) r1;
    L35:
        if (TTLiveSDK.hostService().user().hostUserId() == 0) goto L37;
        boolean r16 = true;
    L38:
        if (r16 == true) goto L40;
        TTLiveSDK.hostService().user().hostUserLogin(r2, new b());
    L40:
        if (r9 == null) goto L54;
        r9.put("code", 1);     // Catch: JSONException -> L45
        goto L46
    L54:
        return;
    L37:
        r16 = false;
        goto L38
    L30:
        if ((r1 instanceof ContextWrapper) == false) goto L44;
        ContextWrapper r3 = (ContextWrapper) r1;
        if ((r3.getBaseContext() instanceof FragmentActivity) == false) goto L44;
        r2 = r3.getBaseContext();
    L44:
        throw new IllegalArgumentException("Argument \"context\" cannot be transformed to FragmentActivity in UserCenter.login() method. ");
    }

    @Override // e30.a
    public final void l(JSONObject r54, JSONObject r55, boolean r56) throws Exception {
        if (r54 == null) goto L111;
        WeakReference<Context> r6 = this.a;
        if (r6 == null) goto L111;
        if (r6.get() == null) goto L111;
        if ((this.a.get() instanceof FragmentActivity) == false) goto L111;
        boolean r7 = s1.F();
        if (r7 == false) goto L14;
        int r8 = s1.y();
    L15:
        int r9 = r54.optInt("width", (int) s1.G(r8));
        if (r9 > 0) goto L21;
        if (r7 == false) goto L19;
        int r11 = s1.y();
    L20:
        r9 = (int) s1.G(r11);
        goto L21
    L19:
        r11 = s1.w();
    L21:
        int r12 = r54.optInt("height", 400);
        int r13 = r54.optInt("radius", 0);
        int r14 = r54.optInt("radius_top_left", 0);
        int r16 = r54.optInt("radius_top_right", 0);
        int r17 = r14;
        int r18 = r54.optInt("radius_bottom_right", 0);
        int r21 = r54.optInt("radius_bottom_left", 0);
        if (r54.optInt("pull_down_close", 0) != 1) goto L24;
        boolean r4 = true;
    L26:
        if (r54.optInt("enable_share", 0) != 1) goto L28;
        boolean r15 = true;
    L29:
        String r19 = r54.optString("pull_down_indicator_color", "");
        int r110 = r54.optInt("margin", 0);
        boolean r31 = r15;
        if (r54.has("gravity") == false) goto L52;
        String r111 = r54.optString("gravity");
        String r32 = "pull_down_close";
        if (TextUtils.equals(r111, "right") == false) goto L34;
    L51:
        int r2 = 8388613;
    L55:
        if (r2 == 80) goto L57;
    L61:
        int r112 = r18;
        int r113 = r16;
        int r114 = r21;
    L62:
        int r33 = r2;
        String r3 = r54.optString("from_label");
        int r22 = r112;
        String r115 = JSONObjectProtectorUtils.getString(r54, LiveSlardarConstants.EXTRA_KEY_URL);
        if (r7 == true) goto L65;
    L67:
        boolean r37 = r4;
        if (o(r115).booleanValue() == false) goto L79;
        Uri.Builder r23 = new Uri.Builder();
        r23.scheme("sslocal");
        if (r56 == false) goto L72;
        String r116 = "webview_lynxview";
    L73:
        r23.authority(r116);
        r23.appendQueryParameter(LiveSlardarConstants.EXTRA_KEY_URL, r115);
        r23.appendQueryParameter("type", "popup");
        r23.appendQueryParameter("width", String.valueOf(r9));
        r23.appendQueryParameter("height", String.valueOf(r12));
        r23.appendQueryParameter("gravity", r54.optString("gravity", ""));
        r23.appendQueryParameter("from_label", r3);
        r23.appendQueryParameter("margin", String.valueOf(r110));
        r23.appendQueryParameter(r32, String.valueOf(r37));
        r23.appendQueryParameter("enable_share", String.valueOf(r31));
        r23.appendQueryParameter("pull_down_indicator_color", String.valueOf(r19));
        r23.appendQueryParameter("landscape_custom_height", String.valueOf(true));
        if (r54.has("radius") == false) goto L76;
        r23.appendQueryParameter("radius", String.valueOf(r13));
    L77:
        ((IBrowserService) jc1.k.f(IBrowserService.class)).showHybridDialog(this.a.get(), r23.build(), null);
        r55.put("code", 1);
        return;
    L76:
        r23.appendQueryParameter("radius_top_left", String.valueOf(r17));
        r23.appendQueryParameter("radius_top_right", String.valueOf(r113));
        r23.appendQueryParameter("radius_bottom_right", String.valueOf(r22));
        r23.appendQueryParameter("radius_bottom_left", String.valueOf(r114));
        goto L77
    L72:
        r116 = "webcast_webview";
        goto L73
    L79:
        Uri r24 = UriProtector.parse(r115);
        JSONObject r117 = new JSONObject();
        r117.put("path", r24.getHost() + "/" + r24.getPath());
        r117.put("tag", "OpenLiveMethod");
        JSONObject r0 = new JSONObject();
        r0.put(LiveSlardarConstants.EXTRA_KEY_URL, r115);
        LiveTracingMonitor.c("ttlive_hybrid_openLiveMethod_use_old_container", LiveTracingMonitor.EventModule.hybrid, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 0, "", r117, null, r0);
        if (((Boolean) fo.a.getValue()).booleanValue() == true) goto L92;
        if (r56 == false) goto L83;
        n r1 = ((IBrowserService) jc1.k.f(IBrowserService.class)).buildLynxDialog(r115, r54.optString("fallback_url"), null);
    L84:
        o r5 = r1.setWidth(r9);
        r5.b = r12;
        r5.i = r33;
        r5.f(r3);
        r5.c = r110;
        r5.B = r37;
        r5.z = r19;
        r5.m = true;
        if (r54.has("radius") == false) goto L87;
        r5.d(r13);
    L89:
        if (r54.has("monitor") == false) goto L91;
        r5.s = new c(r54.optJSONObject("monitor").optString("service"));
    L91:
        LiveDialogFragment.show(this.a.get(), r5.build());
    L109:
        r55.put("code", 1);
        return;
    L87:
        r5.b(r17, r113, r22, r114);
        goto L89
    L83:
        r1 = ((IBrowserService) jc1.k.f(IBrowserService.class)).buildWebDialog(r115);
        goto L84
    L92:
        int r25 = r114;
        int r118 = r113;
        WeakReference<Context> r26 = this.a;
        if (r26 == null) goto L109;
        Context r27 = r26.get();
        if (r27 == null) goto L109;
        if (r56 == false) goto L98;
        Uri.Builder r28 = x6.a.c(((IBrowserService) jc1.k.f(IBrowserService.class)).getRenderUrlByH5Service(r115)).appendQueryParameter("fallback_url", r54.optString("fallback_url"));
    L99:
        Uri.Builder r29 = r28.appendQueryParameter("width", String.valueOf(r9)).appendQueryParameter("height", String.valueOf(r12));
        if (r33 != 80) goto L102;
        String r34 = "bottom";
    L103:
        Uri.Builder r35 = r29.appendQueryParameter("gravity", r34).appendQueryParameter("margin", String.valueOf(r110)).appendQueryParameter(r32, String.valueOf(r37)).appendQueryParameter("enable_share", String.valueOf(r31)).appendQueryParameter("pull_down_indicator_color", r19).appendQueryParameter("landscape_custom_height", GamePromoteDataContext.GAME_TYPE_MOBILE).appendQueryParameter("type", "popup");
        if (r54.has("radius") == false) goto L106;
        Uri.Builder r36 = r35.appendQueryParameter("radius", String.valueOf(r13));
    L107:
        ((IBrowserService) jc1.k.f(IBrowserService.class)).showHybridDialog(r27, r36.build(), null);
        goto L109
    L106:
        r36 = r35.appendQueryParameter("radius_top_left", String.valueOf(r17)).appendQueryParameter("radius_top_right", String.valueOf(r118)).appendQueryParameter("radius_bottom_right", String.valueOf(r22)).appendQueryParameter("radius_bottom_left", String.valueOf(r25));
        goto L107
    L102:
        r34 = "other";
        goto L103
    L98:
        r28 = x6.a.a(r115);
        goto L99
    L65:
        if (PadConfigUtils.c() == false) goto L67;
        int r38 = e.a;
        ((Boolean) cy0.a.getValue()).booleanValue();
        goto L67
    L57:
        if (r54.has("radius_top_left") == true) goto L61;
        if (r54.has("radius_top_right") == true) goto L61;
        r112 = 0;
        r114 = 0;
        r17 = 8;
        r113 = 8;
        goto L62
    L34:
        if (TextUtils.equals(r111, "end") == true) goto L51;
        if (TextUtils.equals(r111, "left") == false) goto L39;
    L50:
        r2 = 8388611;
        goto L55
    L39:
        if (TextUtils.equals(r111, NewBroadcastMonitor.STAGE.START) == true) goto L50;
        if (TextUtils.equals(r111, "top") == false) goto L45;
        r2 = 48;
        goto L55
    L45:
        if (TextUtils.equals(r111, "bottom") == false) goto L48;
        r2 = 80;
        goto L55
    L48:
        if (TextUtils.equals(r111, "center") == false) goto L53;
        r2 = 17;
    L53:
        r2 = 0;
        goto L55
    L52:
        r32 = "pull_down_close";
        goto L53
    L28:
        r15 = false;
        goto L29
    L24:
        r4 = false;
        goto L26
    L14:
        r8 = s1.w();
    L111:
        r55.put("code", 0);
        r55.put("msg", "E-33333");
        ALogger.e("OpenLiveMethod", "handleWebViewPopup arg: " + r54 + " mContextRef: " + this.a);
    }
}
