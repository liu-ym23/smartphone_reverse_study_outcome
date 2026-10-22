package com.bytedance.sdk.account.h;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.Header;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, com.ss.android.account.b.a> f3124b;
    protected String c;
    public int d;
    public boolean e;
    public String f;
    public String g;
    public String h;
    public String i;
    public boolean j;
    public boolean k;
    protected JSONObject l;
    protected JSONObject m;
    protected JSONObject n;

    public a() {
        this.f3124b = new HashMap();
    }

    public a(JSONObject r2, JSONObject r3) {
        this.f3124b = new HashMap();
        this.m = r2;
        this.l = r2.optJSONObject("data");
        this.n = r3;
    }

    public static void a(a r17, JSONObject r18, JSONObject r19) {
        long r3 = 0;
        r17.f3123a = r19.optLong(Header.KEY_USER_ID, 0);
        r17.c = r19.optString("sec_user_id", "");
        r17.f = r19.optString("session_key", "");
        r17.c = r19.optString("sec_user_id", "");
        boolean r8 = true;
        int r9 = 0;
        if (r19.optInt(Api.KEY_NEW_USER) == 0) goto L5;
        boolean r7 = true;
    L6:
        r17.e = r7;
        r17.g = r19.optString("mobile", "");
        if (r19.optInt("has_password") != 0) goto L10;
        r8 = false;
    L10:
        r17.j = r8;
        r17.i = r19.optString("sec_user_id", "");
        r17.k = r19.optBoolean("is_visitor_account", false);
        r17.h = r19.optString(NotificationCompat.CATEGORY_EMAIL, "");
        com.ss.android.account.b.a r6 = com.ss.android.account.b.a.a("mobile");
        com.ss.android.account.b.a r5 = com.ss.android.account.b.a.a(NotificationCompat.CATEGORY_EMAIL);
        r5.d = r17.h;
        if (TextUtils.isEmpty(r17.h) == true) goto L13;
        r17.e().put(r5.f14989b, r5);
    L13:
        r6.d = r17.g;
        if (TextUtils.isEmpty(r17.g) == true) goto L16;
        r17.e().put(r6.f14989b, r6);
    L16:
        JSONArray r10 = r19.optJSONArray("connects");
        if (r10 == null) goto L45;
        int r11 = r10.length();
        long r12 = System.currentTimeMillis();
    L19:
        if (r9 >= r11) goto L45;
        JSONObject r13 = r10.getJSONObject(r9);
        String r14 = r13.getString(WsConstants.KEY_PLATFORM);
        if (r14 != null) goto L23;
    L43:
        long r15 = r3;
    L44:
        r9 = r9 + 1;
        r3 = r15;
        goto L19
    L23:
        if (r14.length() == 0) goto L43;
        com.ss.android.account.b.a r16 = com.ss.android.account.b.a.a(r14);
        String r110 = "screen_name";
        if (r13.has("screen_name") == false) goto L28;
    L27:
        r16.d = r13.optString(r110);
    L31:
        r16.e = r13.optString("profile_image_url");
        r16.f = r13.optString("platform_uid");
        r16.g = r13.optString("sec_platform_uid");
        r16.i = r13.optLong("modify_time");
        r16.h = r13.optString("create_time");
        r16.l = r19.optLong(Header.KEY_USER_ID, r3);
        long r111 = r13.optLong("expires_in");
        if (r111 <= r3) goto L34;
        r16.j = r12 + (1000 * r111);
    L34:
        r16.k = r111;
        com.ss.android.account.b.a r4 = (com.ss.android.account.b.a) ZeusTransformUtils.preCheckCast(r17.e().get(r14), com.ss.android.account.b.a.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L41;
        r15 = 0;
        if (r4.i > 0) goto L39;
    L42:
        r17.e().put(r14, r16);
        goto L44
    L39:
        if (r4.i <= r16.i) goto L42;
    L41:
        r15 = 0;
        goto L42
    L28:
        r110 = "platform_screen_name";
        if (r13.has("platform_screen_name") == false) goto L31;
    L45:
        r17.d = r19.optInt("country_code", -1);
        return;
    L5:
        r7 = false;
        goto L6
    }

    public JSONObject a() {
        return this.l;
    }

    public JSONObject b() {
        return this.n;
    }

    public void c() {
        a(this, this.m, this.n);
    }

    public long d() {
        return this.f3123a;
    }

    public Map<String, com.ss.android.account.b.a> e() {
        return this.f3124b;
    }

    public int f() {
        return this.d;
    }

    public String g() {
        return this.f;
    }

    public String h() {
        return this.g;
    }

    public String i() {
        return this.h;
    }

    public String j() {
        return this.c;
    }
}
