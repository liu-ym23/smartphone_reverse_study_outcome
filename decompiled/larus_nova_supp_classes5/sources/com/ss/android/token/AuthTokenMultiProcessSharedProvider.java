package com.ss.android.token;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.account.k;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import f06.c;
import f06.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class AuthTokenMultiProcessSharedProvider extends ContentProvider {
    public static String e = null;
    public static Uri f = null;
    public static UriMatcher g = null;
    public static b h = null;
    public static String i = "token_shared_preference";
    public SharedPreferences a;
    public final Map<String, Object> b;
    public volatile boolean c;
    public final Object d;

    public static class a {
        public final Context a;
        public final ContentValues b;

        public final synchronized void a() {
            monitor-enter(this);
            tb7.a.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider apply key called, size = " + this.b.size());     // Catch: Throwable -> L39
            com.bytedance.sdk.account.settings.common.a.a();     // Catch: Throwable -> L39
            if (com.bytedance.sdk.account.settings.common.a.Z == true) goto L7;
        L42:
            SharedPreferences.Editor r0 = this.a.getSharedPreferences(AuthTokenMultiProcessSharedProvider.i, 4).edit();     // Catch: Throwable -> L35
            Iterator<Map.Entry<String, Object>> r1 = this.b.valueSet().iterator();     // Catch: Throwable -> L35
        L12:
            if (r1.hasNext() == false) goto L31;
            Map.Entry<String, Object> r2 = r1.next();     // Catch: Throwable -> L35
            Object r3 = r2.getValue();     // Catch: Throwable -> L35
            String r4 = r2.getKey();     // Catch: Throwable -> L35
            tb7.a.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider apply key = " + r4 + " value = " + TokenFactory.l(r3));     // Catch: Throwable -> L35
            if (r3 == null) goto L15;
            if ((r3 instanceof String) == true) goto L18;
            if ((r3 instanceof Boolean) == true) goto L21;
            if ((r3 instanceof Long) == true) goto L24;
            if ((r3 instanceof Integer) == true) goto L27;
            if ((r3 instanceof Float) == false) goto L12;
            r0.putFloat(r4, ((Float) r3).floatValue());     // Catch: Throwable -> L35
            goto L12
        L27:
            r0.putInt(r4, ((Integer) r3).intValue());     // Catch: Throwable -> L35
            goto L12
        L24:
            r0.putLong(r4, ((Long) r3).longValue());     // Catch: Throwable -> L35
            goto L12
        L21:
            r0.putBoolean(r4, ((Boolean) r3).booleanValue());     // Catch: Throwable -> L35
            goto L12
        L18:
            r0.putString(r4, (String) r3);     // Catch: Throwable -> L35
            goto L12
        L15:
            r0.remove(r4);     // Catch: Throwable -> L35
            goto L12
        L31:
            boolean r5 = r0.commit();     // Catch: Throwable -> L35
            b(this.a.getContentResolver(), AuthTokenMultiProcessSharedProvider.b(this.a, "key", EffectConfiguration.KEY_TYPE), this.b);     // Catch: Throwable -> L35
            if (r5 == true) goto L37;
            TTTokenMonitor.h(-1, "commit fail");     // Catch: Throwable -> L35
        L37:
            monitor-exit(this);
            return;
        L35:
            th = move-exception;
            tb7.a.d("AuthTokenMultiProcessShared", "MultiProcessShareProvider apply error = " + Log.getStackTraceString(th));     // Catch: Throwable -> L39
            TTTokenMonitor.h(-2, th.getMessage());     // Catch: Throwable -> L39
            TTTokenMonitor.d(th);     // Catch: Throwable -> L39
            goto L37
        L7:
            if (this.b.size() != 0) goto L42;
            monitor-exit(this);
            return;
        L39:
            th = move-exception;
            throw th;
        }

        public a(Context r2) {
            this.b = new ContentValues();
            this.a = r2.getApplicationContext();
        }

        public final void c(String r2, String r3) {
            this.b.put(r2, r3);
        }

        public static void b(ContentResolver r18, Uri r19, ContentValues r20) {
            ArrayList r0 = new ArrayList();
            Object[] r1 = {r19, r20};
            f06.b r11 = new f06.b();
            g06.a r2 = (g06.a) ApiHookConfig.b.get(240017);
            if (r2 == null) goto L5;
            f06.a[] r3 = r2.i;
        L6:
            f06.a[] r15 = r3;
            int r9 = r15.length;
            int r8 = 0;
        L8:
            if (r8 >= r9) goto L15;
            f06.a r7 = r15[r8];
            int r16 = r8;
            int r17 = r9;
            d r4 = r7.preInvoke(240017, "android/content/ContentResolver", "insert", r18, r1, "android.net.Uri", r11);     // Catch: Exception -> L22
            if (r4.a == true) goto L17;
            r0.add(r7);     // Catch: Exception -> L22
        L17:
            if (r4.a == false) goto L20;
            Uri r5 = (Uri) r4.b;
            return;
        L20:
            r18.insert(r19, r20);
            return;
        L14:
            r8 = r16 + 1;
            r9 = r17;
            goto L8
        L15:
            r4 = new d(false, null);
            goto L17
        L5:
            r3 = ApiHookConfig.d;
            goto L6
        }
    }

    public static class b {
        public final Context a;
        public final boolean b;
        public final SharedPreferences c;

        public final a b() {
            return new a(this.a);
        }

        public final long e() {
        L30:
            th = move-exception;
            TTTokenMonitor.d(th);
            return 0;
        L5:
            if (this.b == true) goto L7;
            Cursor r2 = a(this.a.getContentResolver(), AuthTokenMultiProcessSharedProvider.b(this.a, "x-tt-token-timestamp", "long"));     // Catch: Throwable -> L30
            if (r2 == null) goto L42;
        L15:
            th = move-exception;
            TTTokenMonitor.d(th);     // Catch: Throwable -> L24
        L17:
            long r3 = 0;
        L37:
            r2.close();     // Catch: Exception -> L20 Throwable -> L30
        L23:
            return r3;
        L20:
            e = move-exception;
            TTTokenMonitor.d(e);     // Catch: Throwable -> L30
            goto L23
        L24:
            th = move-exception;
            r2.close();     // Catch: Exception -> L27 Throwable -> L30
        L29:
            throw th;     // Catch: Throwable -> L30
        L27:
            e = move-exception;
            TTTokenMonitor.d(e);     // Catch: Throwable -> L30
            goto L29
        L12:
            if (r2.moveToFirst() == false) goto L17;
            r3 = r2.getLong(0);     // Catch: Throwable -> L15
        L42:
            return 0;
        L7:
            return this.c.getLong("x-tt-token-timestamp", 0);
        }

        public final String f(String r8) {
        L38:
            th = move-exception;
            TTTokenMonitor.d(th);
            return "";
        L5:
            if (this.b == false) goto L8;
            String r1 = this.c.getString(r8, "");     // Catch: Throwable -> L38
            tb7.a.a("AuthTokenMultiProcessShared", "mSharedPreferences main getString get key = " + r8 + " value = " + TokenFactory.l(r1));     // Catch: Throwable -> L38
            return r1;
        L8:
            Cursor r2 = a(this.a.getContentResolver(), AuthTokenMultiProcessSharedProvider.b(this.a, r8, "string"));     // Catch: Throwable -> L38
            if (r2 != null) goto L45;
        L29:
            String r3 = "";
        L30:
            tb7.a.a("AuthTokenMultiProcessShared", " MultiProcessShared getString get key = " + r8 + " value = " + TokenFactory.l(r3));     // Catch: Throwable -> L38
            return r3;
        L45:
        L21:
            th = move-exception;
            TTTokenMonitor.d(th);     // Catch: Throwable -> L32
        L49:
            r2.close();     // Catch: Exception -> L25 Throwable -> L38
        L27:
            r3 = "";
        L28:
            if (r3 != null) goto L30;
        L25:
            e = move-exception;
            TTTokenMonitor.d(e);     // Catch: Throwable -> L38
        L32:
            th = move-exception;
            r2.close();     // Catch: Exception -> L35 Throwable -> L38
        L37:
            throw th;     // Catch: Throwable -> L38
        L35:
            e = move-exception;
            TTTokenMonitor.d(e);     // Catch: Throwable -> L38
            goto L37
        L12:
            if (r2.moveToFirst() == false) goto L15;
            r3 = r2.getString(0);     // Catch: Throwable -> L21
        L47:
            r2.close();     // Catch: Exception -> L18 Throwable -> L38
        L18:
            e = move-exception;
            TTTokenMonitor.d(e);     // Catch: Throwable -> L38
            goto L28
        L15:
            r3 = "";
            goto L47
        }

        public static Cursor a(ContentResolver r12, Uri r13) {
            c r8 = new c();
            Object[] r9 = {r13, null, null, null, null};
            f06.b r10 = new f06.b();
            d r11 = r8.b(240004, "android/content/ContentResolver", DownloadConstants.QUERY_KEY, r12, r9, "android.database.Cursor", r10);
            if (r11.a == false) goto L6;
            r8.a(240004, "android/content/ContentResolver", DownloadConstants.QUERY_KEY, r12, r9, null, r10, false);
            return (Cursor) r11.b;
        L6:
            Cursor r14 = r12.query(r13, null, null, null, null);
            r8.a(240004, "android/content/ContentResolver", DownloadConstants.QUERY_KEY, r12, r9, r14, r10, true);
            return r14;
        }

        public final boolean c(String r4, boolean r5) {
        L29:
            th = move-exception;
            TTTokenMonitor.d(th);
            return r5;
        L3:
            if (this.b == true) goto L5;
            Cursor r6 = a(this.a.getContentResolver(), AuthTokenMultiProcessSharedProvider.b(this.a, r4, "boolean"));     // Catch: Throwable -> L29
            if (r6 == null) goto L41;
        L14:
            th = move-exception;
            TTTokenMonitor.d(th);     // Catch: Throwable -> L23
        L16:
            boolean r0 = r5;
        L32:
            r6.close();     // Catch: Exception -> L19 Throwable -> L29
        L22:
            return r0;
        L19:
            e = move-exception;
            TTTokenMonitor.d(e);     // Catch: Throwable -> L29
            goto L22
        L23:
            th = move-exception;
            r6.close();     // Catch: Exception -> L26 Throwable -> L29
        L28:
            throw th;     // Catch: Throwable -> L29
        L26:
            e = move-exception;
            TTTokenMonitor.d(e);     // Catch: Throwable -> L29
            goto L28
        L10:
            if (r6.moveToFirst() == false) goto L16;
            r0 = false;
            if (r6.getInt(0) <= 0) goto L32;
            r0 = true;
            goto L32
        L41:
            return r5;
        L5:
            return this.c.getBoolean(r4, r5);
        }

        public final int d(String r4, int r5) {
        L28:
            th = move-exception;
            TTTokenMonitor.d(th);
            return r5;
        L3:
            if (this.b == true) goto L5;
            Cursor r6 = a(this.a.getContentResolver(), AuthTokenMultiProcessSharedProvider.b(this.a, r4, "integer"));     // Catch: Throwable -> L28
            if (r6 == null) goto L40;
        L13:
            th = move-exception;
            TTTokenMonitor.d(th);     // Catch: Throwable -> L22
        L15:
            int r0 = r5;
        L36:
            r6.close();     // Catch: Exception -> L18 Throwable -> L28
        L21:
            return r0;
        L18:
            e = move-exception;
            TTTokenMonitor.d(e);     // Catch: Throwable -> L28
            goto L21
        L22:
            th = move-exception;
            r6.close();     // Catch: Exception -> L25 Throwable -> L28
        L27:
            throw th;     // Catch: Throwable -> L28
        L25:
            e = move-exception;
            TTTokenMonitor.d(e);     // Catch: Throwable -> L28
            goto L27
        L10:
            if (r6.moveToFirst() == false) goto L15;
            r0 = r6.getInt(0);     // Catch: Throwable -> L13
        L40:
            return r5;
        L5:
            return this.c.getInt(r4, r5);
        }

        public b(Context r2, String r3, boolean r4) {
            this.b = false;
            this.b = r4;
            Context r5 = r2.getApplicationContext();
            this.a = r5;
            AuthTokenMultiProcessSharedProvider.i = r3;
            this.c = r5.getApplicationContext().getSharedPreferences(AuthTokenMultiProcessSharedProvider.i, 4);
            tb7.a.a("AuthTokenMultiProcessShared", "MultiProcessShared create");
        }
    }

    public final synchronized SharedPreferences c() {
        monitor-enter(this);
        SharedPreferences r0 = this.a;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        SharedPreferences r1 = getContext().getApplicationContext().getSharedPreferences(i, 4);     // Catch: Throwable -> L10
        this.a = r1;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r1;
    L8:
        monitor-exit(this);
        return r0;
    L10:
        th = move-exception;
        throw th;
    }

    public static boolean f() {
        if (TextUtils.isEmpty(e) == false) goto L6;
        return true;
    L6:
        if (g == null) goto L10;
        return false;
    L10:
        return true;
    }

    public final void a() {
        if (this.c == true) goto L14;
        Object r0 = this.d;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.c == true) goto L9;
        g();     // Catch: Throwable -> L11
        this.c = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        if (k.b == null) goto L6;
        k.b.isLocalTest();
    L6:
        if (getContext() == null) goto L11;
        if ((getContext().getApplicationContext() instanceof Application) == false) goto L11;
        com.bytedance.sdk.account.utils.d.c((Application) getContext().getApplicationContext());
    L11:
        if (g == null) goto L19;
        return true;
    L19:
        tb7.a.a("AuthTokenMultiProcessSharedProvider", "init form onCreate");     // Catch: Exception -> L14
        e(getContext());     // Catch: Exception -> L14
        return true;
    L14:
        e = move-exception;
        TTTokenMonitor.d(e);
        e.printStackTrace();
        return false;
    }

    public AuthTokenMultiProcessSharedProvider() {
        this.b = new ConcurrentHashMap();
        this.c = false;
        this.d = new Object();
    }

    public final void g() {
        SharedPreferences r0 = c();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, ?>> r1 = r0.getAll().entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L16;
        Map.Entry<String, ?> r2 = r1.next();
        String r3 = r2.getKey();
        Object r4 = r2.getValue();
        if (r4 == null) goto L17;
        if (r3 == null) goto L17;
        ((ConcurrentHashMap) this.b).put(r3, r4);
    L17:
        tb7.a.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider loadValues key_ = " + r3 + " value_ = " + r4);     // Catch: Exception -> L14
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L14
        r5.put("key_", r3);     // Catch: Exception -> L14
        r5.put("value_", r4);     // Catch: Exception -> L14
        TTTokenMonitor.t("token_sp_error", r5);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        TTTokenMonitor.d(e);
        goto L7
    }

    public static void e(Context r3) throws IllegalStateException {
        if (TextUtils.isEmpty(e) == false) goto L6;
        e = d(r3, AuthTokenMultiProcessSharedProvider.class.getName());
    L6:
        if (TextUtils.isEmpty(e) == true) goto L10;
        tb7.a.a("AuthTokenMultiProcessSharedProvider", e);
        UriMatcher r4 = new UriMatcher(-1);
        g = r4;
        r4.addURI(e, "*/*", 65536);
        f = UriProtector.parse("content://" + e);
        return;
    L10:
        throw new IllegalStateException("Must Set AuthTokenMultiProcessSharedProvider Authority");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r2) {
        a();
        return "vnd.android.cursor.item/vnd." + e + ".item";
    }

    public static String d(Context r5, String r6) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r6) == true) goto L23;
        ProviderInfo[] r0 = r5.getPackageManager().getPackageInfo(r5.getPackageName(), 8).providers;     // Catch: Exception -> L13
        int r1 = r0.length;     // Catch: Exception -> L13
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L16;
        ProviderInfo r3 = r0[r2];     // Catch: Exception -> L13
        if (r6.equals(r3.name) == true) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return r3.authority;
    L16:
        return r5.getPackageName() + ".auth_token.SHARE_PROVIDER_AUTHORITY";
    L13:
        e = move-exception;
        TTTokenMonitor.d(e);
        goto L16
    L23:
        return null;
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r2, ProviderInfo r3) {
        if (r3 == null) goto L4;
        e = r3.authority;
    L4:
        super.attachInfo(r2, r3);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r17, ContentValues r18) {
        a();
        if (f() == false) goto L6;
        return null;
    L6:
        if (g.match(r17) != 65536) goto L96;
        com.bytedance.sdk.account.settings.common.a.a();     // Catch: Exception -> L92
        int r5 = com.bytedance.sdk.account.settings.common.a.c0;     // Catch: Exception -> L92
        if (r5 > 0) goto L10;
        boolean r9 = true;
    L12:
        if (r5 == 2) goto L14;
        boolean r6 = true;
    L15:
        ArrayList r10 = new ArrayList();     // Catch: Exception -> L92
        Iterator<Map.Entry<String, Object>> r11 = r18.valueSet().iterator();     // Catch: Exception -> L92
        SharedPreferences.Editor r13 = null;
        boolean r12 = false;
    L17:
        if (r11.hasNext() == false) goto L81;
        Map.Entry<String, Object> r14 = r11.next();     // Catch: Exception -> L92
        Object r15 = r14.getValue();     // Catch: Exception -> L92
        String r16 = r14.getKey();     // Catch: Exception -> L92
        tb7.a.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider reallly insert key = " + r16 + " value = " + TokenFactory.l(r15));     // Catch: Exception -> L92
        if (r16 == null) goto L17;
        if (r15 != null) goto L23;
        ((ConcurrentHashMap) this.b).remove(r16);     // Catch: Exception -> L92
    L30:
        boolean r7 = true;
    L31:
        if (r7 == false) goto L17;
        tb7.a.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider reallly insert key = " + r16 + " value = " + TokenFactory.l(r15));     // Catch: Exception -> L92
        if (r9 == false) goto L55;
        if (r13 != null) goto L36;
        r13 = c().edit();     // Catch: Exception -> L92
    L36:
        if (r15 != null) goto L39;
        r13.remove(r16);     // Catch: Exception -> L92
        goto L55
    L39:
        if ((r15 instanceof String) == false) goto L42;
        r13.putString(r16, (String) r15);     // Catch: Exception -> L92
        goto L55
    L42:
        if ((r15 instanceof Boolean) == false) goto L45;
        r13.putBoolean(r16, ((Boolean) r15).booleanValue());     // Catch: Exception -> L92
        goto L55
    L45:
        if ((r15 instanceof Long) == false) goto L48;
        r13.putLong(r16, ((Long) r15).longValue());     // Catch: Exception -> L92
        goto L55
    L48:
        if ((r15 instanceof Integer) == false) goto L51;
        r13.putInt(r16, ((Integer) r15).intValue());     // Catch: Exception -> L92
        goto L55
    L51:
        if ((r15 instanceof Float) == false) goto L54;
        r13.putFloat(r16, ((Float) r15).floatValue());     // Catch: Exception -> L92
        goto L55
    L54:
        throw new IllegalArgumentException("Unsupported type " + r17);     // Catch: Exception -> L92
    L55:
        if (r6 == false) goto L80;
        String r8 = "string";
        if (r15 != null) goto L59;
        com.ss.android.token.a r19 = new com.ss.android.token.a(this, r16, "string");     // Catch: Exception -> L92
    L78:
        if (r19 == null) goto L80;
        r10.add(r19);     // Catch: Exception -> L92
        goto L80
    L59:
        if ((r15 instanceof String) == false) goto L62;
    L74:
        if (r8 == null) goto L76;
        r19 = new com.ss.android.token.a(this, r16, r8);     // Catch: Exception -> L92
        goto L78
    L76:
        r19 = null;
        goto L78
    L62:
        if ((r15 instanceof Boolean) == false) goto L65;
        r8 = "boolean";
        goto L74
    L65:
        if ((r15 instanceof Long) == false) goto L68;
        r8 = "long";
        goto L74
    L68:
        if ((r15 instanceof Integer) == false) goto L71;
        r8 = "integer";
        goto L74
    L71:
        if ((r15 instanceof Float) == false) goto L73;
        r8 = "float";
        goto L74
    L73:
        r8 = null;
    L80:
        r12 = true;
        goto L17
    L23:
        Object r20 = ((ConcurrentHashMap) this.b).get(r16);     // Catch: Exception -> L92
        if (r20 != null) goto L26;
    L29:
        ((ConcurrentHashMap) this.b).put(r16, r15);     // Catch: Exception -> L92
        goto L30
    L26:
        if (r20.equals(r15) == false) goto L29;
        r7 = false;
        goto L31
    L81:
        if (r12 == true) goto L83;
        return null;
    L83:
        if (r9 == false) goto L86;
        if (r13 == null) goto L86;
        r13.apply();     // Catch: Exception -> L92
    L86:
        if (r6 == false) goto L94;
        Iterator r0 = r10.iterator();     // Catch: Exception -> L92
    L89:
        if (r0.hasNext() == false) goto L94;
        ((Runnable) r0.next()).run();     // Catch: Exception -> L92
    L94:
        return null;
    L14:
        r6 = false;
        goto L15
    L10:
        r9 = false;
    L92:
        e = move-exception;
        TTTokenMonitor.d(e);
        goto L94
    L96:
        throw new IllegalArgumentException("Unsupported uri " + r17);
    }

    public static final synchronized Uri b(Context r3, String r4, String r5) {
        monitor-enter(AuthTokenMultiProcessSharedProvider.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (f == null) goto L20;
    L13:
        Uri r6 = f.buildUpon().appendPath(r4).appendPath(r5).build();     // Catch: Throwable -> L16
        monitor-exit(AuthTokenMultiProcessSharedProvider.class);
        return r6;
    L20:
        tb7.a.a("MultiProcessSharedProvider", "init form getContentUri");     // Catch: Exception -> L8 Throwable -> L16
        e(r3);     // Catch: Exception -> L8 Throwable -> L16
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        TTTokenMonitor.d(e);     // Catch: Throwable -> L16
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r2, String r3, String[] r4) {
        a();
        if (f() == false) goto L6;
        return 0;
    L6:
        if (g.match(r2) != 65536) goto L13;
        ((ConcurrentHashMap) this.b).clear();     // Catch: Exception -> L9
        c().edit().clear().commit();     // Catch: Exception -> L9
        getContext().getContentResolver().notifyChange(b(getContext(), "key", EffectConfiguration.KEY_TYPE), null);     // Catch: Exception -> L9
    L11:
        return 0;
    L9:
        e = move-exception;
        TTTokenMonitor.d(e);
        goto L11
    L13:
        throw new IllegalArgumentException("Unsupported uri " + r2);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.database.Cursor] */
    @Override // android.content.ContentProvider
    public Cursor query(Uri r5, String[] r6, String r7, String[] r8, String r9) {
        a();
        String r10 = null;
        if (f() == false) goto L6;
        return null;
    L6:
        if (g.match(r5) != 65536) goto L56;
        int r11 = 1;
        if (DownloadConstants.ENCODING_SCENE_ALL.equals((String) ListProtector.get(r5.getPathSegments(), 1)) == false) goto L37;
        Map<String, ?> r12 = c().getAll();     // Catch: Exception -> L52
        MatrixCursor r13 = new MatrixCursor(new String[]{"key_column", "value_column", "type_column"});     // Catch: Exception -> L52
        Iterator<Map.Entry<String, ?>> r14 = r12.entrySet().iterator();     // Catch: Exception -> L35
    L11:
        if (r14.hasNext() == false) goto L57;
        Map.Entry<String, ?> r15 = r14.next();     // Catch: Exception -> L35
        r10 = r15.getKey();     // Catch: Exception -> L35
        Object r16 = r15.getValue();     // Catch: Exception -> L35
        MatrixCursor.RowBuilder r1 = r13.newRow();     // Catch: Exception -> L35
        String r3 = "string";
        if ((r16 instanceof String) == true) goto L33;
        if ((r16 instanceof Boolean) == false) goto L25;
        r3 = "boolean";
        if (((Boolean) r16).booleanValue() == false) goto L22;
        int r17 = 1;
    L23:
        r16 = Integer.valueOf(r17);     // Catch: Exception -> L35
        goto L33
    L22:
        r17 = 0;
        goto L23
    L25:
        if ((r16 instanceof Integer) == false) goto L28;
        r3 = "integer";
        goto L33
    L28:
        if ((r16 instanceof Long) == false) goto L31;
        r3 = "long";
        goto L33
    L31:
        if ((r16 instanceof Float) == false) goto L33;
        r3 = "float";
    L33:
        r1.add(r10);     // Catch: Exception -> L35
        r1.add(r16);     // Catch: Exception -> L35
        r1.add(r3);     // Catch: Exception -> L35
    L57:
        return r13;
    L35:
        e = e;
        r10 = r13;
    L53:
        TTTokenMonitor.d(e);
        return r10;
    L37:
        String r18 = (String) ListProtector.get(r5.getPathSegments(), 0);     // Catch: Exception -> L52
        if (((ConcurrentHashMap) this.b).containsKey(r18) == true) goto L40;
        return null;
    L40:
        MatrixCursor r19 = new MatrixCursor(new String[]{r18});     // Catch: Exception -> L52
        r10 = ((ConcurrentHashMap) this.b).get(r18);     // Catch: Exception -> L50
        MatrixCursor.RowBuilder r2 = r19.newRow();     // Catch: Exception -> L50
        if ((r10 instanceof Boolean) == true) goto L44;
    L48:
        tb7.a.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider  get key = " + r18 + " value = " + TokenFactory.l(r10));     // Catch: Exception -> L50
        r2.add(r10);     // Catch: Exception -> L50
        r13 = r19;
        goto L57
    L44:
        if (((Boolean) r10).booleanValue() == true) goto L47;
        r11 = 0;
    L47:
        r10 = Integer.valueOf(r11);     // Catch: Exception -> L50
    L50:
        e = e;
        r10 = r19;
    L52:
        e = e;
        goto L53
    L56:
        throw new IllegalArgumentException("Unsupported uri " + r5);
    }
}
