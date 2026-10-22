package com.bytedance.news.common.settings.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f2957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences f2958b;
    private HashMap<String, com.bytedance.news.common.settings.api.e> c;
    private final com.bytedance.news.common.settings.api.e d;
    private SharedPreferences e;
    private JSONObject f;
    private Context g;

    private f(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        this.c = new HashMap();
        this.d = new com.bytedance.news.common.settings.api.e(null, null, "", false);
        this.g = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        SettingsConfigProvider r0 = (SettingsConfigProvider) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(SettingsConfigProvider.class), SettingsConfigProvider.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        if (r0.getConfig() == null) goto L8;
        this.f2958b = r0.getConfig().a(r7, "__local_settings_data.sp", 0, false);
    L8:
        if (this.f2958b != null) goto L11;
        this.f2958b = r7.getSharedPreferences("__local_settings_data.sp", 0);
        return;
    }

    public static f a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f2957a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2957a != null) goto L9;
        f2957a = new f(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f2957a;
    }

    private static String a(String r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return r1;
    L6:
        return r1 + "_" + r2;
    }

    private void a(com.bytedance.news.common.settings.b r18, boolean r19) {
        Context r0 = this.g;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.e != null) goto L8;
        this.e = r0.getSharedPreferences("diff_settings.sp", 0);
    L8:
        SharedPreferences.Editor r3 = this.e.edit();
        if (r19 == false) goto L17;
        String r1 = this.e.getString(a("key_local_app_settings_data", r18.s()), "");     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r1) == true) goto L17;
        r3.putString(a("key_local_settings_dff_last", r18.s()), r1);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        if (this.f != null) goto L67;
        r3.apply();
        return;
    L67:
        String r2 = this.e.getString(a("key_diff_app_settings_timestamp", r18.s()), "");     // Catch: Exception -> L46
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L46
    L44:
        e = e;
        JSONObject r7 = null;
    L48:
        e.printStackTrace();
    L49:
        if (r4 != null) goto L65;
    L54:
        if (r7 != null) goto L74;
    L59:
        r3.apply();
        boolean r5 = r18.r();
        com.bytedance.news.common.settings.api.g r6 = r18.q();
        if (r5 == false) goto L63;
        if (r6 == null) goto L63;
        r6.a("diff_setting_report_tag", this.f.toString());
    L63:
        this.f = null;
        return;
    L74:
        r3.putString(a("key_diff_app_settings_timestamp", r18.s()), r7.toString());     // Catch: Exception -> L57
    L57:
        e = move-exception;
        e.printStackTrace();
        goto L59
    L65:
        r4.put("settings_sdk_timestamp", System.currentTimeMillis());     // Catch: Exception -> L52
        r3.putString(a("key_local_app_settings_data", r18.s()), r4.toString());     // Catch: Exception -> L52
    L52:
        e = move-exception;
        e.printStackTrace();
        goto L54
    L23:
        if (TextUtils.isEmpty(r2) == true) goto L25;
        r7 = new JSONObject(r2);     // Catch: Exception -> L44
    L70:
        Iterator<String> r8 = this.f.keys();     // Catch: Exception -> L42
        long r9 = System.currentTimeMillis();     // Catch: Exception -> L42
    L29:
        if (r8.hasNext() == false) goto L31;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L42
        r4.put(r10, this.f.opt(r10));     // Catch: Exception -> L42
        r7.put(r10, r9);     // Catch: Exception -> L42
        goto L29
    L31:
        Iterator<String> r11 = r7.keys();     // Catch: Exception -> L42
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L42
    L33:
        if (r11.hasNext() == false) goto L37;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L42
        if ((r9 - r7.optLong(r13, r9)) <= 259200000) goto L33;
        r12.add(r13);     // Catch: Exception -> L42
        goto L33
    L37:
        Iterator r14 = r12.iterator();     // Catch: Exception -> L42
    L38:
        if (r14.hasNext() == false) goto L49;
        r7.remove((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L42
    L42:
        e = e;
        goto L48
    L25:
        r7 = new JSONObject();     // Catch: Exception -> L44
    L46:
        e = e;
        r4 = null;
        r7 = null;
        goto L48
    }

    private void a(JSONObject r2, String r3, Object r4) {
        if (this.f != null) goto L5;
        this.f = new JSONObject();
    L5:
        this.f.put(r3, r4);
        r2.put(r3, r4);
    }

    public synchronized com.bytedance.news.common.settings.api.e a(String r8) {
        monitor-enter(this);
        com.bytedance.news.common.settings.api.e r0 = (com.bytedance.news.common.settings.api.e) ZeusTransformUtils.preCheckCast(this.c.get(r8), com.bytedance.news.common.settings.api.e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r0 != null) goto L6;
        String r1 = this.f2958b.getString(a("key_local_app_settings_data", r8), "");     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r1) == false) goto L28;
    L21:
        this.c.put(r8, this.d);     // Catch: Throwable -> L24
        monitor-exit(this);
        return null;
    L28:
        JSONObject r2 = new JSONObject(r1);     // Catch: JSONException -> L19 Throwable -> L24
        String r3 = this.f2958b.getString(a("key_local_user_settings_data", r8), "");     // Catch: JSONException -> L19 Throwable -> L24
        if (TextUtils.isEmpty(r3) == true) goto L15;
        JSONObject r4 = new JSONObject(r3);     // Catch: JSONException -> L19 Throwable -> L24
    L16:
        com.bytedance.news.common.settings.api.e r5 = new com.bytedance.news.common.settings.api.e(r2, r4, this.f2958b.getString(a("key_last_update_token", r8), ""), false);     // Catch: JSONException -> L19 Throwable -> L24
        this.c.put(r8, r5);     // Catch: JSONException -> L19 Throwable -> L24
        monitor-exit(this);
        return r5;
    L15:
        r4 = new JSONObject();     // Catch: JSONException -> L19 Throwable -> L24
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
        goto L21
    L6:
        if (r0 != this.d) goto L8;
        r0 = null;
    L8:
        monitor-exit(this);
        return r0;
    L24:
        th = move-exception;
        throw th;
    }

    public synchronized void a(com.bytedance.news.common.settings.api.e r16, com.bytedance.news.common.settings.b r17, boolean r18) {
        monitor-enter(this);
        JSONObject r2 = r16.a();     // Catch: Throwable -> L104
        JSONObject r3 = r16.b();     // Catch: Throwable -> L104
        com.bytedance.news.common.settings.api.e r4 = a(r17.s());     // Catch: Throwable -> L104
        if (r4 == null) goto L80;
        JSONObject r0 = r4.a();     // Catch: Throwable -> L104
        JSONObject r5 = r4.b();     // Catch: Throwable -> L104
        if (r0 != null) goto L9;
        r0 = new JSONObject();     // Catch: Throwable -> L104
    L9:
        JSONObject r6 = r0;
        if (r5 != null) goto L12;
        r5 = new JSONObject();     // Catch: Throwable -> L104
    L12:
        if (r2 == null) goto L35;
        Iterator<String> r7 = r2.keys();     // Catch: Throwable -> L104
    L15:
        if (r7.hasNext() == false) goto L35;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L104
        Object r8 = r2.opt(r1);     // Catch: Exception -> L33 Throwable -> L104
        Object r9 = r6.opt(r1);     // Catch: Exception -> L33 Throwable -> L104
        String r10 = String.valueOf(r8);     // Catch: Exception -> L33 Throwable -> L104
        String r11 = String.valueOf(r9);     // Catch: Exception -> L33 Throwable -> L104
    L18:
        if (ZeusTransformUtils.instanceOf(r8, JSONObject.class) == false) goto L31;
        if (ZeusTransformUtils.instanceOf(r9, JSONObject.class) == false) goto L31;
        JsonObject r12 = (JsonObject) ZeusTransformUtils.preCheckCast(new JsonParser().parse(r10), JsonObject.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27 Throwable -> L104
        JsonObject r13 = (JsonObject) ZeusTransformUtils.preCheckCast(new JsonParser().parse(r11), JsonObject.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27 Throwable -> L104
        if (r12 == null) goto L15;
        if (r12.equals(r13) == true) goto L15;
        a(r6, r1, r8);     // Catch: Exception -> L27 Throwable -> L104
    L28:
        if (TextUtils.equals(r10, r11) == true) goto L15;
    L29:
        a(r6, r1, r8);     // Catch: Exception -> L33 Throwable -> L104
    L31:
        if (TextUtils.equals(r10, r11) == true) goto L15;
    L33:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L104
    L35:
        if (r3 == null) goto L58;
        Iterator<String> r14 = r3.keys();     // Catch: Throwable -> L104
    L38:
        if (r14.hasNext() == false) goto L58;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L104
        Object r19 = r3.opt(r15);     // Catch: Exception -> L56 Throwable -> L104
        Object r20 = r5.opt(r15);     // Catch: Exception -> L56 Throwable -> L104
        String r110 = String.valueOf(r19);     // Catch: Exception -> L56 Throwable -> L104
        String r111 = String.valueOf(r20);     // Catch: Exception -> L56 Throwable -> L104
    L41:
        if (ZeusTransformUtils.instanceOf(r19, JSONObject.class) == false) goto L54;
        if (ZeusTransformUtils.instanceOf(r20, JSONObject.class) == false) goto L54;
        JsonObject r21 = (JsonObject) ZeusTransformUtils.preCheckCast(new JsonParser().parse(r110), JsonObject.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L50 Throwable -> L104
        JsonObject r112 = (JsonObject) ZeusTransformUtils.preCheckCast(new JsonParser().parse(r111), JsonObject.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L50 Throwable -> L104
        if (r21 == null) goto L38;
        if (r21.equals(r112) == true) goto L38;
        a(r5, r15, r19);     // Catch: Exception -> L50 Throwable -> L104
    L51:
        if (TextUtils.equals(r110, r111) == true) goto L38;
    L52:
        a(r5, r15, r19);     // Catch: Exception -> L56 Throwable -> L104
    L54:
        if (TextUtils.equals(r110, r111) == true) goto L38;
    L56:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L104
    L58:
        this.c.put(r17.s(), r4);     // Catch: Throwable -> L104
        SharedPreferences.Editor r22 = this.f2958b.edit();     // Catch: Throwable -> L104
        r22.putString(a("key_last_update_token", r17.s()), r16.c());     // Catch: Exception -> L61 Throwable -> L104
    L111:
        String r23 = a("key_local_app_settings_data", r17.s());     // Catch: Exception -> L69 Throwable -> L104
        if (r2 == null) goto L66;
        String r24 = r6.toString();     // Catch: Exception -> L69 Throwable -> L104
    L67:
        r22.putString(r23, r24);     // Catch: Exception -> L69 Throwable -> L104
    L124:
        String r25 = a("key_local_user_settings_data", r17.s());     // Catch: Exception -> L77 Throwable -> L104
        if (r3 == null) goto L74;
        String r26 = r5.toString();     // Catch: Exception -> L77 Throwable -> L104
    L75:
        r22.putString(r25, r26);     // Catch: Exception -> L77 Throwable -> L104
    L79:
        r22.apply();     // Catch: Throwable -> L104
        a(r17, r18);     // Catch: Throwable -> L104
    L102:
        monitor-exit(this);
        return;
    L74:
        r26 = "";
    L77:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L104
        goto L79
    L66:
        r24 = "";
    L69:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L104
    L61:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L104
        goto L111
    L80:
        this.c.put(r17.s(), r16);     // Catch: Throwable -> L104
        SharedPreferences.Editor r27 = this.f2958b.edit();     // Catch: Throwable -> L104
        r27.putString(a("key_last_update_token", r17.s()), r16.c());     // Catch: Exception -> L83 Throwable -> L104
    L126:
        String r28 = a("key_local_app_settings_data", r17.s());     // Catch: Exception -> L91 Throwable -> L104
        if (r2 == null) goto L88;
        String r29 = r2.toString();     // Catch: Exception -> L91 Throwable -> L104
    L89:
        r27.putString(r28, r29);     // Catch: Exception -> L91 Throwable -> L104
    L107:
        String r30 = a("key_local_user_settings_data", r17.s());     // Catch: Exception -> L99 Throwable -> L104
        if (r3 == null) goto L96;
        String r31 = r3.toString();     // Catch: Exception -> L99 Throwable -> L104
    L97:
        r27.putString(r30, r31);     // Catch: Exception -> L99 Throwable -> L104
    L101:
        r27.apply();     // Catch: Throwable -> L104
        goto L102
    L96:
        r31 = "";
    L99:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L104
        goto L101
    L88:
        r29 = "";
    L91:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L104
    L83:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L104
    L104:
        th = move-exception;
        throw th;
    }

    public boolean a() {
        boolean r2 = false;
        if (this.f2958b.contains("key_safe_mode_fixing_timestamp") == true) goto L5;
    L11:
        return r2;
    L5:
        if (this.f2958b.contains("key_safe_mode_expiring_time") == false) goto L11;
        long r0 = this.f2958b.getLong("key_safe_mode_fixing_timestamp", 0);
        if ((System.currentTimeMillis() - r0) > this.f2958b.getLong("key_safe_mode_expiring_time", 0)) goto L9;
        r2 = true;
    L9:
        if (r2 == true) goto L11;
        c();
        goto L11
    }

    public JSONObject b() {
        return new JSONObject(this.f2958b.getString("key_safe_mode_fixed_settings", "{}"));
    L5:
        return new JSONObject();
    }

    public void c() {
        this.f2958b.edit().remove("key_safe_mode_fixing_timestamp").remove("key_safe_mode_expiring_time").remove("key_safe_mode_fixed_settings").apply();
    }
}
