package com.ss.android.account;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class b extends com.ss.android.account.a {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public long H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f14987J;
    public int K;
    public boolean L;
    public boolean M;
    public String N;
    public String O;
    public String P;
    public int Q;
    public int R;
    public boolean S;
    public boolean T;
    public int U;
    public String r;
    public String s;
    public long t;
    public String u;
    public String v;
    public boolean w;
    public String x;
    public String y;
    public String z;

    public static class a {
        public a() {
        }

        public b a(JSONObject r1, JSONObject r2) {
            b r0 = new b(r1, r2);
            r0.c();
            return r0;
        }
    }

    public b() {
        this.f14987J = 0;
    }

    public b(JSONObject r1, JSONObject r2) {
        super(r1, r2);
        this.f14987J = 0;
    }

    public static void a(b r4, JSONObject r5) {
        r4.A = r5.optInt("can_be_found_by_phone");
        r4.B = r5.optInt("share_to_repost", -1);
        boolean r2 = true;
        r4.C = r5.optInt("user_privacy_extend") & 1;
        r4.D = r5.optInt("user_privacy_extend");
        r4.K = r5.optInt("gender");
        r4.r = r5.optString("screen_name");
        r4.s = r5.optString("verified_content");
        r4.L = r5.optBoolean("is_generated");
        r4.M = r5.optBoolean("user_verified");
        if (r5.optInt("is_recommend_allowed") == 0) goto L5;
        boolean r0 = true;
    L6:
        r4.w = r0;
        r4.x = r5.optString("recommend_hint_message");
        r4.y = r5.optString("user_decoration");
        r4.z = r5.optString("user_auth_info");
        r4.N = r5.optString("birthday");
        r4.O = r5.optString("area");
        r4.P = r5.optString("industry");
        r4.R = r5.optInt("is_blocked");
        r4.Q = r5.optInt("is_blocking");
        r4.S = r5.optBoolean("is_toutiao");
        if (r5.optInt("has_password") != 0) goto L10;
        r2 = false;
    L10:
        r4.T = r2;
        JSONObject r1 = r5.optJSONObject("media");
        if (r1 == null) goto L13;
        r4.u = r1.optString("avatar_url");
        r4.t = r1.optLong(OaidModel.KEY_ID);
        r4.v = r1.optString(ActivityLifecycle.NAME);
        r4.f14987J = r1.optInt("display_app_ocr_entrance", 0);
    L13:
        r4.E = r5.optInt("followings_count");
        r4.F = r5.optInt("followers_count");
        r4.G = r5.optInt("visit_count_recent");
        r4.H = r5.optLong("media_id");
        r4.I = r5.optString("bg_img_url");
        r4.U = r5.optInt("app_id");
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.ss.android.account.a, com.bytedance.sdk.account.h.a
    public void c() {
        super.c();
        a(this, b());
    }
}
