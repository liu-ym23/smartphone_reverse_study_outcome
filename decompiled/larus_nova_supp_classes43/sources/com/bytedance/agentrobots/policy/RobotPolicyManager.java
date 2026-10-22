package com.bytedance.agentrobots.policy;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import d2.c;
import d2.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class RobotPolicyManager {
    public static volatile RobotPolicyManager c;
    public static final Uri d = null;
    public final Context a;
    public final d b;

    public static final enum DisableLevel extends Enum<DisableLevel> {
        public static final DisableLevel Activity = null;
        public static final DisableLevel App = null;
        public static final DisableLevel None = null;
        public static final /* synthetic */ DisableLevel[] a = null;
        private final int value;

        static {
            DisableLevel r0 = new DisableLevel("None", 0, 0);
            None = r0;
            DisableLevel r1 = new DisableLevel("App", 1, 1);
            App = r1;
            DisableLevel r10 = new DisableLevel("Activity", 2, 2);
            Activity = r10;
            a = new DisableLevel[]{r0, r1, r10};
        }

        public static DisableLevel[] values() {
            return (DisableLevel[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static DisableLevel valueOf(String r1) {
            return (DisableLevel) r27.a.a(DisableLevel.class, r1);
        }

        public DisableLevel(String r1, int r10, int r11) {
            super(r1, r10);
            this.value = r11;
        }
    }

    public class a extends ContentObserver {
        public final /* synthetic */ RobotPolicyManager a;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r1) {
            RobotPolicyManager.a(this.a);
        }

        public a(RobotPolicyManager r1, Handler r10) {
            this.a = r1;
            super(r10);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r10, Uri r11) {
            Cursor r12 = null;
            if (r11 == null) goto L5;
            String r0 = UriProtector.getQueryParameter(r11, "package_name");
        L6:
            Objects.toString(r11);
            if (TextUtils.isEmpty(r0) == true) goto L32;
            RobotPolicyManager r13 = this.a;
            r12 = RobotPolicyManager.b(r13.a.getContentResolver(), RobotPolicyManager.d, null, "package_name=?", new String[]{r0});     // Catch: Throwable -> L24 Exception -> L26
            if (r12 != null) goto L12;
        L18:
            d r14 = r13.b;     // Catch: Throwable -> L24 Exception -> L26
            if (r0 != null) goto L21;
            r14.getClass();     // Catch: Throwable -> L24 Exception -> L26
        L22:
            if (r12 == null) goto L35;
        L28:
            r12.close();
            return;
        L35:
            return;
        L21:
            r14.a.remove(r0);     // Catch: Throwable -> L24 Exception -> L26
            r14.b.remove(r0);     // Catch: Throwable -> L24 Exception -> L26
            r14.c.delete(r0);     // Catch: Throwable -> L24 Exception -> L26
            goto L22
        L12:
            if (r12.moveToFirst() == false) goto L18;
            int r1 = r12.getColumnIndex("policy");     // Catch: Throwable -> L24 Exception -> L26
            if (r1 == (-1)) goto L22;
            String r15 = r12.getString(r1);     // Catch: Throwable -> L24 Exception -> L26
            if (TextUtils.isEmpty(r15) == true) goto L22;
            r13.b.a(r0, new JSONObject(r15));     // Catch: Throwable -> L24 Exception -> L26
        L24:
            th = move-exception;
            if (0 == 0) goto L31;
            r12.close();
        L31:
            throw th;
        L27:
            if (0 != 0) goto L28;
            return;
        L32:
            RobotPolicyManager.a(this.a);
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    public static final class b {
        public final List<String> a;
        public final List<String> b;

        public b(List<String> r1, List<String> r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    static {
        d = UriProtector.parse("content://com.obric.agentrobots.provider/policy");
    }

    public final Map<String, List<String>> d() {
        Context r10 = this.a;     // Catch: Exception -> L58
        if (r10 != null) goto L7;
    L9:
        boolean r11 = false;
    L10:
        if (r11 == false) goto L59;
        TreeSet r12 = new TreeSet();     // Catch: Exception -> L58
        TreeSet r13 = new TreeSet();     // Catch: Exception -> L58
        c r14 = new c(Build.BRAND, Build.MANUFACTURER);     // Catch: Exception -> L58
        Cursor r15 = b(this.a.getContentResolver(), d, new String[]{"package_name", "policy"}, null, null);     // Catch: Exception -> L58
        if (r15 != null) goto L67;
        if (r15 == null) goto L59;
    L50:
        r15.close();     // Catch: Exception -> L58
        goto L59
    L67:
        int r1 = r15.getColumnIndex("package_name");     // Catch: Throwable -> L52
        int r0 = r15.getColumnIndex("policy");     // Catch: Throwable -> L52
        if (r1 < 0) goto L50;
        if (r0 < 0) goto L50;
    L21:
        if (r15.moveToNext() == false) goto L49;
        String r16 = r15.getString(r1);     // Catch: Throwable -> L52
        String r17 = r15.getString(r0);     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r16) == true) goto L50;
        if (TextUtils.isEmpty(r17) == true) goto L50;
        d2.a r18 = e(new JSONObject(r17), r14);     // Catch: Throwable -> L52
        if (r18.b == true) goto L41;
        JSONObject r19 = r18.a;     // Catch: Throwable -> L52
        if (r19 == null) goto L34;
        JSONObject r110 = r19.optJSONObject("app");     // Catch: Throwable -> L52
    L35:
        if (r110 == null) goto L41;
        if (r110.optBoolean("global_disable", false) == false) goto L39;
    L40:
        boolean r111 = true;
    L42:
        if (r111 == true) goto L43;
        if (r12.contains(r16) == true) goto L21;
        r13.add(r16);     // Catch: Throwable -> L52
        goto L21
    L43:
        r12.add(r16);     // Catch: Throwable -> L52
        r13.remove(r16);     // Catch: Throwable -> L52
        goto L21
    L39:
        if (r110.optBoolean("screenshot_disable", false) == false) goto L41;
    L34:
        r110 = null;
    L41:
        r111 = false;
        goto L42
    L47:
        goto L59
    L49:
        r15.close();     // Catch: Exception -> L58
        b r20 = new b(Collections.unmodifiableList(new ArrayList(r12)), Collections.unmodifiableList(new ArrayList(r13)));     // Catch: Exception -> L58
    L60:
        if (r20 != null) goto L62;
        return null;
    L62:
        LinkedHashMap r21 = new LinkedHashMap(2);
        r21.put("restricted_packages", r20.a);
        r21.put("saep_declared_packages", r20.b);
        return Collections.unmodifiableMap(r21);
    L52:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L55
    L57:
        throw th;     // Catch: Exception -> L58
    L55:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L58
        goto L57
    L7:
        if (Settings.Secure.getInt(r10.getContentResolver(), "robots_protocol_enabled", 1) != 1) goto L9;
        r11 = true;
    L59:
        r20 = null;
        goto L60
    }

    public RobotPolicyManager(Context r10) {
        Context r11 = r10.getApplicationContext();
        this.a = r11;
        int r0 = com.bytedance.agentrobots.audit.a.a;
        if (r11 == null) goto L5;
        r11.getApplicationContext();
    L5:
        this.b = new d(r11);
        new a(this, new Handler(Looper.getMainLooper()));
    }

    public static void a(RobotPolicyManager r10) {
        ContentResolver r0 = r10.a.getContentResolver();
        Cursor r1 = null;
        Uri r11 = d;     // Catch: Throwable -> L22 Exception -> L26
        Objects.toString(r11);     // Catch: Throwable -> L22 Exception -> L26
        r1 = b(r0, r11, null, null, null);     // Catch: Throwable -> L22 Exception -> L26
        Objects.toString(r1);     // Catch: Throwable -> L22 Exception -> L26
        if (r1 == null) goto L6;
        r1.getCount();     // Catch: Throwable -> L22 Exception -> L26
    L6:
        if (r1 != null) goto L8;
    L20:
        if (r1 == null) goto L44;
    L27:
        r1.close();
        return;
    L44:
        return;
    L8:
        if (r1.moveToNext() == false) goto L19;
        int r12 = r1.getColumnIndex("package_name");     // Catch: Throwable -> L22 Exception -> L26
        int r13 = r1.getColumnIndex("policy");     // Catch: Throwable -> L22 Exception -> L26
        if (r12 == (-1)) goto L8;
        if (r13 == (-1)) goto L8;
        String r14 = r1.getString(r12);     // Catch: Throwable -> L22 Exception -> L26
        String r15 = r1.getString(r13);     // Catch: Throwable -> L22 Exception -> L26
        if (TextUtils.isEmpty(r14) == true) goto L8;
        if (TextUtils.isEmpty(r15) == true) goto L8;
        JSONObject r16 = new JSONObject(r15);     // Catch: JSONException -> L18 Throwable -> L22 Exception -> L26
        r10.b.a(r14, r16);     // Catch: JSONException -> L18 Throwable -> L22 Exception -> L26
        goto L8
    L19:
    L26:
        if (r1 != null) goto L27;
        return;
    L22:
        th = move-exception;
        if (r1 == null) goto L25;
        r1.close();
    L25:
        throw th;
    }

    public static RobotPolicyManager c(Context r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (c != null) goto L18;
        monitor-enter(RobotPolicyManager.class);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (c != null) goto L12;
        c = new RobotPolicyManager(r10);     // Catch: Throwable -> L14
    L12:
        monitor-exit(RobotPolicyManager.class);     // Catch: Throwable -> L14
    L18:
        return c;
    }

    public static d2.a e(JSONObject r10, c r11) {
        JSONArray r0 = r10.optJSONArray("oem_groups");
        if (r0 != null) goto L5;
    L30:
        JSONObject r12 = null;
    L31:
        boolean r13 = true;
        if (r12 != null) goto L34;
    L39:
        JSONObject r1 = r10.optJSONObject("scope");
        if (r1 != null) goto L42;
    L49:
        if (r13 == false) goto L52;
        r1 = r10.optJSONObject("default_policy");
    L52:
        return new d2.a(r1, false);
    L42:
        if (r1.optJSONObject("app") == null) goto L44;
    L48:
        r13 = false;
        goto L49
    L44:
        if (r1.optJSONObject("activities") != null) goto L48;
        if (r1.optJSONObject("agent_intents") != null) goto L48;
    L34:
        if (r12.optBoolean("bypass_policy", false) == true) goto L62;
        JSONObject r14 = r12.optJSONObject("policy");
        if (r14 == null) goto L39;
        return new d2.a(r14, false);
    L62:
        return new d2.a(null, true);
    L5:
        if (r0.length() == 0) goto L30;
        int r15 = 0;
    L8:
        if (r15 >= r0.length()) goto L30;
        r12 = r0.optJSONObject(r15);
        if (r12 == null) goto L29;
        JSONArray r16 = r12.optJSONArray("brands");
        if (r16 == null) goto L29;
        if (r16.length() == 0) goto L29;
        int r17 = 0;
    L19:
        if (r17 >= r16.length()) goto L29;
        String r18 = r16.optString(r17, "").toLowerCase();
        if (TextUtils.isEmpty(r18) == true) goto L28;
        if (r18.equals(r11.a) == true) goto L31;
        if (r18.equals(r11.b) == true) goto L31;
    L28:
        r17 = r17 + 1;
    L29:
        r15 = r15 + 1;
        goto L8
    }

    public static Cursor b(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17) {
        f06.c r10 = new f06.c();
        Object[] r11 = {r14, r15, r16, r17, null};
        f06.b r12 = new f06.b();
        f06.d r18 = r10.b(240004, "android/content/ContentResolver", "query", r13, r11, "android.database.Cursor", r12);
        if (r18.a == false) goto L6;
        r10.a(240004, "android/content/ContentResolver", "query", r13, r11, null, r12, false);
        return (Cursor) r18.b;
    L6:
        Cursor r19 = r13.query(r14, r15, r16, r17, null);
        r10.a(240004, "android/content/ContentResolver", "query", r13, r11, r19, r12, true);
        return r19;
    }
}
