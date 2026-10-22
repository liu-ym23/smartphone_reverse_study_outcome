package com.ss.android.account;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d extends a {
    public String A;
    public String B;
    public String C;
    public int D;
    public int E;
    public int F;
    public int G;
    public long H;
    public String I;
    public int J;
    public int K;
    public boolean L;
    public String M;
    public String N;
    public String O;
    public int P;
    public int Q;
    public boolean R;
    public JSONObject S;
    public int T;
    public boolean U;
    public String u;
    public String v;
    public long w;
    public String x;
    public String y;
    public boolean z;

    public final void a() throws Exception {
        JSONObject r1 = ((sc7.a) this).q;
        com.bytedance.sdk.account.settings.common.a.a();
        long r3 = 0;
        String r5 = "user_id";
        if (com.bytedance.sdk.account.settings.common.a.v == true) goto L89;
        ((sc7.a) this).a = r1.optLong("user_id", 0);
    L8:
        ((sc7.a) this).b = r1.optInt("odin_user_type", 0);
        String r7 = "";
        ((sc7.a) this).e = r1.optString("sec_user_id", "");
        ((sc7.a) this).h = r1.optString("session_key", "");
        if (r1.optInt("new_user") == 0) goto L11;
        boolean r8 = true;
    L12:
        ((sc7.a) this).g = r8;
        ((sc7.a) this).i = r1.optString("mobile", "");
        if (r1.optInt("has_password") == 0) goto L15;
        boolean r11 = true;
    L16:
        ((sc7.a) this).l = r11;
        ((sc7.a) this).k = r1.optString("sec_user_id", "");
        ((sc7.a) this).m = r1.optBoolean("is_visitor_account", false);
        ((sc7.a) this).j = r1.optString("email", "");
        cra.a r12 = new cra.a("mobile");
        cra.a r13 = new cra.a("email");
        String r14 = ((sc7.a) this).j;
        r13.c = r14;
        if (TextUtils.isEmpty(r14) == true) goto L19;
        ((HashMap) ((sc7.a) this).c).put("email", r13);
    L19:
        String r2 = ((sc7.a) this).i;
        r12.c = r2;
        if (TextUtils.isEmpty(r2) == true) goto L22;
        ((HashMap) ((sc7.a) this).c).put("mobile", r12);
    L22:
        com.bytedance.sdk.account.settings.common.a.a();
        int r4 = com.bytedance.sdk.account.settings.common.a.T;
        JSONArray r9 = r1.optJSONArray("connects");
        if (r9 == null) goto L70;
        int r15 = r9.length();
        System.currentTimeMillis();
        int r16 = 0;
    L25:
        if (r16 >= r15) goto L70;
        JSONObject r17 = JSONArrayProtectorUtils.getJSONObject(r9, r16);
        String r18 = JSONObjectProtectorUtils.getString(r17, "platform");
        if (r18 != null) goto L29;
    L68:
        long r19 = r3;
        String r110 = r7;
        JSONArray r111 = r9;
        String r10 = r5;
    L69:
        r16 = r16 + 1;
        r5 = r10;
        r9 = r111;
        r7 = r110;
        r3 = r19;
        goto L25
    L29:
        if (r18.length() == 0) goto L68;
        cra.a r20 = new cra.a(r18);
        r110 = r7;
        r20.k = r1.optLong(r5, r3);
        if (r17.has("screen_name") == false) goto L35;
        r20.c = r17.optString("screen_name");
    L37:
        r20.d = r17.optString("profile_image_url");
        r20.e = r17.optString("platform_uid");
        r20.f = r17.optString("sec_platform_uid");
        r20.h = r17.optLong("modify_time");
        r20.g = r17.optString("create_time");
        r20.l = r17.optInt("platform_app_id", 0);
        r20.b = true;
        r20.p = r17.optString(DBDefinition.EXTRA);
        if (r4 == 0) goto L40;
        r20.n = r17.optString("open_id");
    L40:
        sc7.a r6 = com.bytedance.sdk.account.impl.h.a().l();
        if (r6 == null) goto L55;
        r111 = r9;
        if (r6.a != ((sc7.a) this).a) goto L56;
        Map r21 = (Map) ((HashMap) r6.d).get(r18);
        if (r21 == null) goto L56;
        cra.a r22 = (cra.a) r21.get(String.valueOf(r20.l));
        if (r22 == null) goto L56;
        r20.m = r22.m;
        if (r4 != 0) goto L51;
        r20.n = r22.n;
    L54:
        r20.o = r22.o;
        r20.j = r22.j;
        r20.i = r22.i;
        r20.r = r22.r;
        r20.q = r22.q;
        goto L56
    L51:
        if (TextUtils.isEmpty(r20.n) == false) goto L54;
        r20.n = r22.n;
    L56:
        Map r23 = (Map) ((HashMap) ((sc7.a) this).d).get(r18);
        if (r23 != null) goto L59;
        r23 = new HashMap();
        ((HashMap) ((sc7.a) this).d).put(r18, r23);
    L59:
        cra.a r24 = (cra.a) r23.get(String.valueOf(r20.l));
        if (r24 == null) goto L66;
        long r25 = r24.h;
        r19 = 0;
        r10 = r5;
        if (r25 > 0) goto L64;
    L67:
        ((HashMap) ((sc7.a) this).c).put(r18, r20.b());
        r23.put(String.valueOf(r20.l), r20);
        goto L69
    L64:
        if (r25 <= r20.h) goto L67;
    L66:
        r10 = r5;
        r19 = 0;
        goto L67
    L55:
        r111 = r9;
        goto L56
    L35:
        if (r17.has("platform_screen_name") == false) goto L37;
        r20.c = r17.optString("platform_screen_name");
    L70:
        String r112 = r7;
        ((sc7.a) this).f = r1.optInt("country_code", -1);
        if (r1.optInt("is_kids_mode") != 1) goto L73;
        boolean r26 = true;
    L74:
        ((sc7.a) this).n = r26;
        r1.optString("lite_user_info_string", r112);
        r1.optInt("lite_user_info_demotion", 0);
        JSONObject r27 = ((sc7.a) this).q;
        if (r27.has(DBDefinition.NAME) == false) goto L78;
        this.r = r27.optString(DBDefinition.NAME);
    L80:
        this.t = r27.optString("avatar_url");
        this.s = r27.optString("description");
        JSONObject r28 = ((sc7.a) this).q;
        this.D = r28.optInt("can_be_found_by_phone");
        this.E = r28.optInt("share_to_repost", -1);
        this.F = r28.optInt("user_privacy_extend") & 1;
        this.G = r28.optInt("user_privacy_extend");
        this.K = r28.optInt("gender");
        this.u = r28.optString("screen_name");
        this.v = r28.optString("verified_content");
        r28.optBoolean("is_generated");
        this.L = r28.optBoolean("user_verified");
        if (r28.optInt("is_recommend_allowed") == 0) goto L83;
        boolean r29 = true;
    L84:
        this.z = r29;
        this.A = r28.optString("recommend_hint_message");
        this.B = r28.optString("user_decoration");
        this.C = r28.optString("user_auth_info");
        this.M = r28.optString("birthday");
        this.N = r28.optString("area");
        this.O = r28.optString("industry");
        this.Q = r28.optInt("is_blocked");
        this.P = r28.optInt("is_blocking");
        this.R = r28.optBoolean("is_toutiao");
        r28.optInt("has_password");
        JSONObject r30 = r28.optJSONObject("media");
        if (r30 == null) goto L87;
        this.x = r30.optString("avatar_url");
        this.w = r30.optLong("id");
        this.y = r30.optString(DBDefinition.NAME);
        this.J = r30.optInt("display_app_ocr_entrance", 0);
    L87:
        r28.optInt("followings_count");
        r28.optInt("followers_count");
        r28.optInt("visit_count_recent");
        this.H = r28.optLong("media_id");
        this.I = r28.optString("bg_img_url");
        r28.optInt("app_id");
        this.S = r28.optJSONObject("expend_attrs");
        this.T = r28.optInt("hm_region");
        this.U = r28.optBoolean("use_hm_region", false);
        return;
    L83:
        r29 = false;
        goto L84
    L78:
        if (r27.has("username") == false) goto L80;
        this.r = r27.optString("username");
        goto L80
    L73:
        r26 = false;
        goto L74
    L15:
        r11 = false;
        goto L16
    L11:
        r8 = false;
        goto L12
    L89:
        ((sc7.a) this).a = CastLongProtector.parseLong(r1.optString("user_id_str", null));     // Catch: Exception -> L6
    L6:
        ((sc7.a) this).a = r1.optLong("user_id", 0);
        goto L8
    }

    public d() {
        this.J = 0;
        this.T = 0;
    }

    public d(JSONObject r1) {
        super(r1);
        this.J = 0;
        this.T = 0;
    }

    public d(JSONObject r1, JSONObject r2) {
        super(r1, r2);
        this.J = 0;
        this.T = 0;
    }
}
