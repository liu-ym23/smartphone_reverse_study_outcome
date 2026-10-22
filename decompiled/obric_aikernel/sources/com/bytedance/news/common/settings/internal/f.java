package com.bytedance.news.common.settings.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile f f2405g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f2406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<String, f4.d> f2407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f4.d f2408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SharedPreferences f2409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f2410e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f2411f;

    private f(Context r10) {
        this.f2407b = new HashMap();
        this.f2408c = new f4.d(null, null, "", false);
        this.f2411f = r10;
        SettingsConfigProvider r11 = (SettingsConfigProvider) c4.d.a(SettingsConfigProvider.class);
        if (r11 == null) goto L8;
        if (r11.getConfig() == null) goto L8;
        this.f2406a = r11.getConfig().l(r10, "__local_settings_data.sp", 0, false);
    L8:
        if (this.f2406a != null) goto L11;
        this.f2406a = r10.getSharedPreferences("__local_settings_data.sp", 0);
        return;
    }

    private static String a(String r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return r10;
    L6:
        return r10 + "_" + r11;
    }

    public static f c(Context r10) {
        if (f2405g != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2405g != null) goto L9;
        f2405g = new f(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f2405g;
    }

    private void g(@NonNull e4.b r17, boolean r18) {
        Context r10 = this.f2411f;
        if (r10 != null) goto L6;
        return;
    L6:
        if (this.f2409d != null) goto L8;
        this.f2409d = r10.getSharedPreferences("diff_settings.sp", 0);
    L8:
        SharedPreferences.Editor r11 = this.f2409d.edit();
        if (r18 == false) goto L17;
        String r12 = this.f2409d.getString(a("key_local_app_settings_data", r17.e()), "");     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r12) == true) goto L17;
        r11.putString(a("key_local_settings_dff_last", r17.e()), r12);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        if (this.f2410e != null) goto L68;
        r11.apply();
        return;
    L68:
        String r13 = this.f2409d.getString(a("key_diff_app_settings_timestamp", r17.e()), "");     // Catch: Exception -> L45
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L45
    L43:
        e = e;
        JSONObject r15 = null;
    L47:
        e.printStackTrace();
    L48:
        if (r14 != null) goto L66;
    L53:
        if (r15 != null) goto L64;
    L58:
        r11.apply();
        boolean r16 = r17.q();
        f4.f r19 = r17.a();
        if (r16 == false) goto L62;
        if (r19 == null) goto L62;
        r19.i("diff_setting_report_tag", this.f2410e.toString());
    L62:
        this.f2410e = null;
        return;
    L64:
        r11.putString(a("key_diff_app_settings_timestamp", r17.e()), r15.toString());     // Catch: Exception -> L56
    L56:
        e = move-exception;
        e.printStackTrace();
        goto L58
    L66:
        r14.put("settings_sdk_timestamp", System.currentTimeMillis());     // Catch: Exception -> L51
        r11.putString(a("key_local_app_settings_data", r17.e()), r14.toString());     // Catch: Exception -> L51
    L51:
        e = move-exception;
        e.printStackTrace();
        goto L53
    L23:
        if (TextUtils.isEmpty(r13) == true) goto L25;
        r15 = new JSONObject(r13);     // Catch: Exception -> L43
    L73:
        Iterator<String> r20 = this.f2410e.keys();     // Catch: Exception -> L41
        long r21 = System.currentTimeMillis();     // Catch: Exception -> L41
    L28:
        if (r20.hasNext() == false) goto L30;
        String r110 = r20.next();     // Catch: Exception -> L41
        r14.put(r110, this.f2410e.opt(r110));     // Catch: Exception -> L41
        r15.put(r110, r21);     // Catch: Exception -> L41
        goto L28
    L30:
        Iterator<String> r22 = r15.keys();     // Catch: Exception -> L41
        ArrayList r111 = new ArrayList();     // Catch: Exception -> L41
    L32:
        if (r22.hasNext() == false) goto L36;
        String r112 = r22.next();     // Catch: Exception -> L41
        if ((r21 - r15.optLong(r112, r21)) <= 259200000) goto L32;
        r111.add(r112);     // Catch: Exception -> L41
        goto L32
    L36:
        Iterator r23 = r111.iterator();     // Catch: Exception -> L41
    L37:
        if (r23.hasNext() == false) goto L48;
        r15.remove((String) r23.next());     // Catch: Exception -> L41
    L41:
        e = e;
        goto L47
    L25:
        r15 = new JSONObject();     // Catch: Exception -> L43
    L45:
        e = e;
        r14 = null;
        r15 = null;
        goto L47
    }

    private void i(JSONObject r10, String r11, Object r12) {
        if (this.f2410e != null) goto L5;
        this.f2410e = new JSONObject();
    L5:
        this.f2410e.put(r11, r12);
        r10.put(r11, r12);
    }

    public JSONObject b() {
        return new JSONObject(this.f2406a.getString("key_safe_mode_fixed_settings", "{}"));
    L5:
        return new JSONObject();
    }

    @Nullable
    public synchronized f4.d d(String r10) {
        monitor-enter(this);
        f4.d r11 = this.f2407b.get(r10);     // Catch: Throwable -> L24
        if (r11 != null) goto L6;
        String r12 = this.f2406a.getString(a("key_local_app_settings_data", r10), "");     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r12) == false) goto L28;
    L21:
        this.f2407b.put(r10, this.f2408c);     // Catch: Throwable -> L24
        monitor-exit(this);
        return null;
    L28:
        JSONObject r13 = new JSONObject(r12);     // Catch: JSONException -> L19 Throwable -> L24
        String r14 = this.f2406a.getString(a("key_local_user_settings_data", r10), "");     // Catch: JSONException -> L19 Throwable -> L24
        if (TextUtils.isEmpty(r14) == true) goto L15;
        JSONObject r15 = new JSONObject(r14);     // Catch: JSONException -> L19 Throwable -> L24
    L16:
        f4.d r16 = new f4.d(r13, r15, this.f2406a.getString(a("key_last_update_token", r10), ""), false);     // Catch: JSONException -> L19 Throwable -> L24
        this.f2407b.put(r10, r16);     // Catch: JSONException -> L19 Throwable -> L24
        monitor-exit(this);
        return r16;
    L15:
        r15 = new JSONObject();     // Catch: JSONException -> L19 Throwable -> L24
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
        goto L21
    L6:
        if (r11 != this.f2408c) goto L8;
        r11 = null;
    L8:
        monitor-exit(this);
        return r11;
    L24:
        th = move-exception;
        throw th;
    }

    public boolean e() {
        boolean r10 = false;
        if (this.f2406a.contains("key_safe_mode_fixing_timestamp") == true) goto L5;
    L11:
        return r10;
    L5:
        if (this.f2406a.contains("key_safe_mode_expiring_time") == false) goto L11;
        long r11 = this.f2406a.getLong("key_safe_mode_fixing_timestamp", 0);
        if ((System.currentTimeMillis() - r11) > this.f2406a.getLong("key_safe_mode_expiring_time", 0)) goto L9;
        r10 = true;
    L9:
        if (r10 == true) goto L11;
        f();
        goto L11
    }

    public void f() {
        this.f2406a.edit().remove("key_safe_mode_fixing_timestamp").remove("key_safe_mode_expiring_time").remove("key_safe_mode_fixed_settings").apply();
    }

    public synchronized void h(f4.d r13, @NonNull e4.b r14, boolean r15) {
        monitor-enter(this);
        JSONObject r10 = r13.a();     // Catch: Throwable -> L102
        JSONObject r11 = r13.c();     // Catch: Throwable -> L102
        f4.d r12 = d(r14.e());     // Catch: Throwable -> L102
        if (r12 == null) goto L78;
        JSONObject r16 = r12.a();     // Catch: Throwable -> L102
        JSONObject r17 = r12.c();     // Catch: Throwable -> L102
        if (r16 != null) goto L8;
        r16 = new JSONObject();     // Catch: Throwable -> L102
    L8:
        if (r17 != null) goto L10;
        r17 = new JSONObject();     // Catch: Throwable -> L102
    L10:
        if (r10 == null) goto L33;
        Iterator<String> r18 = r10.keys();     // Catch: Throwable -> L102
    L13:
        if (r18.hasNext() == false) goto L33;
        String r19 = r18.next();     // Catch: Throwable -> L102
        Object r20 = r10.opt(r19);     // Catch: Exception -> L31 Throwable -> L102
        Object r21 = r16.opt(r19);     // Catch: Exception -> L31 Throwable -> L102
        String r22 = String.valueOf(r20);     // Catch: Exception -> L31 Throwable -> L102
        String r110 = String.valueOf(r21);     // Catch: Exception -> L31 Throwable -> L102
    L16:
        if ((r20 instanceof JSONObject) == false) goto L29;
        if ((r21 instanceof JSONObject) == false) goto L29;
        com.google.gson.k r23 = (com.google.gson.k) new com.google.gson.l().a(r22);     // Catch: Exception -> L25 Throwable -> L102
        com.google.gson.k r111 = (com.google.gson.k) new com.google.gson.l().a(r110);     // Catch: Exception -> L25 Throwable -> L102
        if (r23 == null) goto L13;
        if (r23.equals(r111) == true) goto L13;
        i(r16, r19, r20);     // Catch: Exception -> L25 Throwable -> L102
    L26:
        if (TextUtils.equals(r22, r110) == true) goto L13;
    L27:
        i(r16, r19, r20);     // Catch: Exception -> L31 Throwable -> L102
    L29:
        if (TextUtils.equals(r22, r110) == true) goto L13;
    L31:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L102
    L33:
        if (r11 == null) goto L56;
        Iterator<String> r24 = r11.keys();     // Catch: Throwable -> L102
    L36:
        if (r24.hasNext() == false) goto L56;
        String r25 = r24.next();     // Catch: Throwable -> L102
        Object r26 = r11.opt(r25);     // Catch: Exception -> L54 Throwable -> L102
        Object r27 = r17.opt(r25);     // Catch: Exception -> L54 Throwable -> L102
        String r28 = String.valueOf(r26);     // Catch: Exception -> L54 Throwable -> L102
        String r112 = String.valueOf(r27);     // Catch: Exception -> L54 Throwable -> L102
    L39:
        if ((r26 instanceof JSONObject) == false) goto L52;
        if ((r27 instanceof JSONObject) == false) goto L52;
        com.google.gson.k r29 = (com.google.gson.k) new com.google.gson.l().a(r28);     // Catch: Exception -> L48 Throwable -> L102
        com.google.gson.k r113 = (com.google.gson.k) new com.google.gson.l().a(r112);     // Catch: Exception -> L48 Throwable -> L102
        if (r29 == null) goto L36;
        if (r29.equals(r113) == true) goto L36;
        i(r17, r25, r26);     // Catch: Exception -> L48 Throwable -> L102
    L49:
        if (TextUtils.equals(r28, r112) == true) goto L36;
    L50:
        i(r17, r25, r26);     // Catch: Exception -> L54 Throwable -> L102
    L52:
        if (TextUtils.equals(r28, r112) == true) goto L36;
    L54:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L102
    L56:
        this.f2407b.put(r14.e(), r12);     // Catch: Throwable -> L102
        SharedPreferences.Editor r30 = this.f2406a.edit();     // Catch: Throwable -> L102
        r30.putString(a("key_last_update_token", r14.e()), r13.b());     // Catch: Exception -> L59 Throwable -> L102
    L111:
        String r114 = a("key_local_app_settings_data", r14.e());     // Catch: Exception -> L67 Throwable -> L102
        if (r10 == null) goto L64;
        String r31 = r16.toString();     // Catch: Exception -> L67 Throwable -> L102
    L65:
        r30.putString(r114, r31);     // Catch: Exception -> L67 Throwable -> L102
    L123:
        String r115 = a("key_local_user_settings_data", r14.e());     // Catch: Exception -> L75 Throwable -> L102
        if (r11 == null) goto L72;
        String r32 = r17.toString();     // Catch: Exception -> L75 Throwable -> L102
    L73:
        r30.putString(r115, r32);     // Catch: Exception -> L75 Throwable -> L102
    L77:
        r30.apply();     // Catch: Throwable -> L102
        g(r14, r15);     // Catch: Throwable -> L102
    L100:
        monitor-exit(this);
        return;
    L72:
        r32 = "";
    L75:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L102
        goto L77
    L64:
        r31 = "";
    L67:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L102
    L59:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L102
        goto L111
    L78:
        this.f2407b.put(r14.e(), r13);     // Catch: Throwable -> L102
        SharedPreferences.Editor r116 = this.f2406a.edit();     // Catch: Throwable -> L102
        r116.putString(a("key_last_update_token", r14.e()), r13.b());     // Catch: Exception -> L81 Throwable -> L102
    L109:
        String r117 = a("key_local_app_settings_data", r14.e());     // Catch: Exception -> L89 Throwable -> L102
        if (r10 == null) goto L86;
        String r33 = r10.toString();     // Catch: Exception -> L89 Throwable -> L102
    L87:
        r116.putString(r117, r33);     // Catch: Exception -> L89 Throwable -> L102
    L117:
        String r118 = a("key_local_user_settings_data", r14.e());     // Catch: Exception -> L97 Throwable -> L102
        if (r11 == null) goto L94;
        String r119 = r11.toString();     // Catch: Exception -> L97 Throwable -> L102
    L95:
        r116.putString(r118, r119);     // Catch: Exception -> L97 Throwable -> L102
    L99:
        r116.apply();     // Catch: Throwable -> L102
        goto L100
    L94:
        r119 = "";
    L97:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L102
        goto L99
    L86:
        r33 = "";
    L89:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L102
    L81:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L102
    L102:
        th = move-exception;
        throw th;
    }
}
