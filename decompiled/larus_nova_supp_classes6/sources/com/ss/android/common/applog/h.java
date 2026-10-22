package com.ss.android.common.applog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class h {
    public static volatile String e = "ss_app_log.db";
    public static final String[] f = null;
    public static final String[] g = null;
    public static final String[] h = null;
    public static final String[] i = null;
    public static final String[] j = null;
    public static final String[] k = null;
    public static final Object l = null;
    public static h m;
    public final SQLiteDatabase a;
    public final Context b;
    public final Set<Long> c;
    public final Set<Long> d;

    public static class a extends SQLiteOpenHelper {
        public a(Context r4) {
            super(r4, h.e, null, 14);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS session ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value VARCHAR NOT NULL, timestamp INTEGER, duration INTEGER, non_page INTEGER, app_version VARCHAR, version_code INTEGER, pausetime INTEGER,launch_sent INTEGER NOT NULL DEFAULT 0, event_index INTEGER NOT NULL DEFAULT 0  )");     // Catch: Exception -> L4
            r2.execSQL("CREATE TABLE IF NOT EXISTS event ( _id INTEGER PRIMARY KEY AUTOINCREMENT, category VARCHAR, tag VARCHAR, label VARCHAR, value INTEGER, ext_value INTEGER, ext_json TEXT, user_id INTEGER, timestamp INTEGER, session_id INTEGER, event_index INTEGER NOT NULL DEFAULT 0, user_type INTEGER NOT NULL DEFAULT 0, user_is_login INTEGER NOT NULL DEFAULT 0, user_is_auth INTEGER NOT NULL DEFAULT 0, uid INTEGER NOT NULL DEFAULT 0, disable_personalization VARCHAR, _event_id INTEGER NOT NULL DEFAULT 0 )");     // Catch: Exception -> L4
            r2.execSQL("CREATE TABLE IF NOT EXISTS page ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, duration INTEGER, session_id INTEGER )");     // Catch: Exception -> L4
            r2.execSQL("CREATE TABLE IF NOT EXISTS queue ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value TEXT, is_crash INTEGER NOT NULL DEFAULT 0, log_type INTEGER NOT NULL DEFAULT 0, timestamp INTEGER, retry_count INTEGER, retry_time INTEGER )");     // Catch: Exception -> L4
            r2.execSQL("CREATE TABLE IF NOT EXISTS misc_log ( _id INTEGER PRIMARY KEY AUTOINCREMENT, log_type VARCHAR, value TEXT, session_id INTEGER, _event_id INTEGER NOT NULL DEFAULT 0 )");     // Catch: Exception -> L4
            r2.execSQL("CREATE TABLE IF NOT EXISTS succ_rate ( _id INTEGER PRIMARY KEY AUTOINCREMENT, event_name VARCHAR, event_fail_reason INTEGER, event_fail_cnt INTEGER NOT NULL DEFAULT 0, event_date INTEGER )");     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            ita.j.c("AppLogcreate db exception ", e);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase r6, int r7, int r8) {
            String[] r9 = h.f;
            int r10 = r9.length;
            int r0 = 0;
        L3:
            if (r0 >= r10) goto L10;
            String r1 = r9[r0];
            r6.execSQL("DROP TABLE IF EXISTS " + r1);     // Catch: Throwable -> L7
        L9:
            r0 = r0 + 1;
        L7:
            th = move-exception;
            ita.j.c("drop table failed, " + r1, th);
            goto L9
        L10:
            onCreate(r6);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase r3, int r4, int r5) {
            if (r4 >= 2) goto L6;
            r3.execSQL("ALTER TABLE event ADD COLUMN user_id INTEGER");
        L6:
            if (r4 >= 3) goto L9;
            r3.execSQL("ALTER TABLE session ADD COLUMN launch_sent INTEGER NOT NULL DEFAULT 0");
        L9:
            if (r4 >= 4) goto L12;
            r3.execSQL("ALTER TABLE queue ADD COLUMN is_crash INTEGER NOT NULL DEFAULT 0");
        L12:
            if (r4 >= 5) goto L15;
            r3.execSQL("ALTER TABLE event ADD COLUMN ext_json TEXT");
        L15:
            if (r4 >= 6) goto L18;
            r3.execSQL("ALTER TABLE queue ADD COLUMN log_type INTEGER NOT NULL DEFAULT 0");
        L18:
            if (r4 >= 7) goto L21;
            r3.execSQL("CREATE TABLE IF NOT EXISTS misc_log ( _id INTEGER PRIMARY KEY AUTOINCREMENT, log_type VARCHAR, value TEXT, session_id INTEGER, _event_id INTEGER NOT NULL DEFAULT 0 )");
        L21:
            if (r4 >= 8) goto L24;
            r3.execSQL("ALTER TABLE event ADD COLUMN event_index INTEGER NOT NULL DEFAULT 0");
        L24:
            if (r4 >= 9) goto L27;
            r3.execSQL("ALTER TABLE session ADD COLUMN event_index INTEGER NOT NULL DEFAULT 0");
        L27:
            if (r4 >= 10) goto L30;
            r3.execSQL("CREATE TABLE IF NOT EXISTS succ_rate ( _id INTEGER PRIMARY KEY AUTOINCREMENT, event_name VARCHAR, event_fail_reason INTEGER, event_fail_cnt INTEGER NOT NULL DEFAULT 0, event_date INTEGER )");
        L30:
            if (r4 < 12) goto L57;
        L35:
            if (r4 >= 12) goto L41;
            r3.execSQL("ALTER TABLE event ADD COLUMN uid INTEGER NOT NULL DEFAULT 0");     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            ita.j.c("alter table add column failed", th);
        L41:
            if (r4 >= 13) goto L47;
            r3.execSQL("ALTER TABLE event ADD COLUMN disable_personalization VARCHAR");     // Catch: Throwable -> L44
        L44:
            th = move-exception;
            ita.j.c("alter table add column failed", th);
        L47:
            if (r4 >= 14) goto L67;
            r3.execSQL("ALTER TABLE event ADD COLUMN _event_id INTEGER NOT NULL DEFAULT 0");     // Catch: Throwable -> L50
        L59:
            r3.execSQL("ALTER TABLE misc_log ADD COLUMN _event_id INTEGER NOT NULL DEFAULT 0");     // Catch: Throwable -> L54
            return;
        L54:
            th = move-exception;
            ita.j.c("alter table add column failed", th);
            return;
        L50:
            th = move-exception;
            ita.j.c("alter table add column failed", th);
            goto L59
        L67:
            return;
        L57:
            r3.execSQL("ALTER TABLE event ADD COLUMN user_type INTEGER NOT NULL DEFAULT 0");     // Catch: Throwable -> L33
            r3.execSQL("ALTER TABLE event ADD COLUMN user_is_login INTEGER NOT NULL DEFAULT 0");     // Catch: Throwable -> L33
            r3.execSQL("ALTER TABLE event ADD COLUMN user_is_auth INTEGER NOT NULL DEFAULT 0");     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            ita.j.c("alter table add column failed", th);
            goto L35
        }
    }

    static {
        f = new String[]{EventVerify.TYPE_EVENT_V1, "page", "session", "misc_log", "succ_rate", "queue"};
        g = new String[]{"_id", "name", "duration", "session_id"};
        h = new String[]{"_id", "value", "is_crash", "timestamp", "retry_count", "retry_time", "log_type"};
        i = new String[]{"_id", "value", "timestamp", "duration", "non_page", "app_version", "version_code", "pausetime", "launch_sent", "event_index"};
        j = new String[]{"_id", "category", "tag", "label", "value", "ext_value", "ext_json", "user_id", "timestamp", "session_id", "event_index", "user_type", "user_is_login", "user_is_auth", "uid", "disable_personalization", "_event_id"};
        k = new String[]{"_id", "log_type", "value", "session_id", "_event_id"};
        new String[]{"_id", "log_type", "value"};
        l = new Object();
    }

    public h(Context r2) {
        this.c = new HashSet();
        this.d = new HashSet();
        this.a = new a(r2).getWritableDatabase();
        this.b = r2;
    }

    public static h d(Context r2) {
        Object r0 = l;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (m != null) goto L7;
        m = new h(r2.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return m;
    }

    public static void k(JSONObject r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (e.a().a.b == false) goto L27;
        JSONArray r0 = r6.optJSONArray(EventVerify.TYPE_EVENT_V3);
        JSONArray r1 = r6.optJSONArray(EventVerify.TYPE_EVENT_V1);
        JSONArray r2 = r6.optJSONArray(EventVerify.TYPE_LOG_DATA);
        JSONArray r3 = r6.optJSONArray(EventVerify.TYPE_LAUNCH);
        JSONArray r7 = r6.optJSONArray(EventVerify.TYPE_TERMINATE);
        if (r3 != null) goto L9;
    L11:
        if (r7 != null) goto L13;
    L15:
        int r8 = 0;
        if (r0 == null) goto L18;
        r8 = 0 + r0.length();
    L18:
        if (r1 == null) goto L20;
        r8 = r8 + r1.length();
    L20:
        if (r2 == null) goto L22;
        r8 = r8 + r2.length();
    L22:
        if (r8 <= 0) goto L26;
        e.a().b(StatsCountKeys.CLEAN_UP_EVENT_COUNT, r8);
        return;
    L26:
        return;
    L13:
        if (r7.length() <= 0) goto L15;
        e.a().b(StatsCountKeys.CLEAN_UP_TERMINATE_COUNT, r7.length());
        goto L15
    L9:
        if (r3.length() <= 0) goto L11;
        e.a().b(StatsCountKeys.CLEAN_UP_LAUNCH_COUNT, r3.length());
        goto L11
    }

    public static void p(Cursor r1) {
        if (r1 == null) goto L10;
        if (r1.isClosed() == true) goto L11;
        r1.close();     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public final boolean b(long r12) {
        ita.j.b("delete app_log: " + r12, null);
        String[] r6 = {String.valueOf(r12)};
        int r7 = this.a.delete("queue", "_id = ?", r6);     // Catch: Throwable -> L10
        if (r7 > 0) goto L6;
        e.a().b(StatsCountKeys.DB_ERROR_COUNT, 1);     // Catch: Throwable -> L10
    L6:
        if (r7 > 0) goto L25;
        return false;
    L25:
        return true;
    L10:
        th = move-exception;
        ita.j.c("delete app_log: " + r12 + " failed", th);
        if ((th instanceof SQLiteFullException) == true) goto L21;
    L20:
        return false;
    L21:
        this.a.execSQL("VACUUM");     // Catch: Throwable -> L18
        ita.j.b("try delete app_log: " + r12 + " again after vacuum", null);     // Catch: Throwable -> L18
        if (this.a.delete("queue", "_id = ?", r6) > 0) goto L26;
        return false;
    L26:
        return true;
    L18:
        th = move-exception;
        ita.j.c("VACUUM failed:" + th.getMessage(), th);
        goto L20
    }

    public final synchronized boolean c(long r13) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.a;     // Catch: Throwable -> L23
        boolean r9 = false;
        if (r0 != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        Cursor r11 = null;
        r11 = r0.query("queue", new String[]{"_id"}, "_id = ?", new String[]{String.valueOf(r13)}, null, null, null, "1");     // Catch: Throwable -> L15
        if (r11.getCount() <= 0) goto L12;
        r9 = true;
    L12:
        p(r11);     // Catch: Throwable -> L23
        monitor-exit(this);
        return r9;
    L15:
        th = move-exception;
        e.a().b(StatsCountKeys.DB_ERROR_COUNT, 1);     // Catch: Throwable -> L20
        ita.j.g("AppLog existsLogByQuery exception ", th);     // Catch: Throwable -> L20
        p(r11);     // Catch: Throwable -> L23
        return false;
    L20:
        th = move-exception;
        p(r11);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public final synchronized r e(long r12) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.a;     // Catch: Throwable -> L34
        Cursor r1 = null;
        r r2 = null;
        if (r0 != null) goto L6;
    L31:
        ita.j.g("AppLog db not establish and open", null);     // Catch: Throwable -> L34
        monitor-exit(this);
        return null;
    L6:
        if (r0.isOpen() == false) goto L31;
        Cursor r13 = this.a.query("queue", h, "_id > ?", new String[]{String.valueOf(r12)}, null, null, "_id ASC", "1");     // Catch: Throwable -> L19 Exception -> L21
    L17:
        Exception e2 = e;
    L23:
        e.a().b(StatsCountKeys.DB_ERROR_COUNT, 1);     // Catch: Throwable -> L27
        ita.j.g("AppLog getLog exception ", e2);     // Catch: Throwable -> L27
        p(r13);     // Catch: Throwable -> L34
        monitor-exit(this);
        return null;
    L27:
        th = move-exception;
        r1 = r13;
        th = th;
    L29:
        p(r1);     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L11:
        if (r13.moveToNext() == false) goto L14;
        r r3 = new r();     // Catch: Exception -> L17 Throwable -> L27
        r3.a = r13.getInt(0);     // Catch: Exception -> L17 Throwable -> L27
        r3.b = r13.getString(1);     // Catch: Exception -> L17 Throwable -> L27
        r13.getLong(3);     // Catch: Exception -> L17 Throwable -> L27
        r13.getInt(4);     // Catch: Exception -> L17 Throwable -> L27
        r13.getLong(5);     // Catch: Exception -> L17 Throwable -> L27
        r3.c = r13.getInt(6);     // Catch: Exception -> L17 Throwable -> L27
        r2 = r3;
    L14:
        p(r13);     // Catch: Throwable -> L34
        monitor-exit(this);
        return r2;
    L21:
        e = move-exception;
        e2 = e;
        r13 = null;
    L19:
        th = th;
    L34:
        th = move-exception;
        throw th;
    }

    public final synchronized z f(long r13) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.a;     // Catch: Throwable -> L46
        Cursor r1 = null;
        z r2 = null;
        if (r0 != null) goto L6;
    L43:
        ita.j.g("AppLog db not establish and open", null);     // Catch: Throwable -> L46
        monitor-exit(this);
        return null;
    L6:
        if (r0.isOpen() == false) goto L43;
        if (r13 > 0) goto L53;
        String r5 = null;
        String[] r6 = null;
    L13:
        Cursor r14 = this.a.query("session", i, r5, r6, null, null, "_id DESC", "1");     // Catch: Throwable -> L31 Exception -> L33
    L29:
        Exception e2 = e;
    L35:
        e.a().b(StatsCountKeys.DB_ERROR_COUNT, 1);     // Catch: Throwable -> L39
        ita.j.g("AppLog getLastSession exception ", e2);     // Catch: Throwable -> L39
        p(r14);     // Catch: Throwable -> L46
        monitor-exit(this);
        return null;
    L39:
        Throwable th = th;
        r1 = r14;
    L41:
        p(r1);     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L15:
        if (r14.moveToNext() == false) goto L26;
        z r15 = new z();     // Catch: Exception -> L29 Throwable -> L39
        r15.a = r14.getInt(0);     // Catch: Exception -> L29 Throwable -> L39
        r15.b = r14.getString(1);     // Catch: Exception -> L29 Throwable -> L39
        r15.c = r14.getLong(2);     // Catch: Exception -> L29 Throwable -> L39
        if (r14.getInt(4) <= 0) goto L19;
        boolean r3 = true;
    L20:
        r15.h = r3;     // Catch: Exception -> L29 Throwable -> L39
        r15.e = r14.getString(5);     // Catch: Exception -> L29 Throwable -> L39
        r15.f = r14.getInt(6);     // Catch: Exception -> L29 Throwable -> L39
        r15.g = r14.getInt(7);     // Catch: Exception -> L29 Throwable -> L39
        if (r14.getInt(8) <= 0) goto L23;
        boolean r4 = true;
    L24:
        r15.i = r4;     // Catch: Exception -> L29 Throwable -> L39
        r15.d = r14.getLong(9);     // Catch: Exception -> L29 Throwable -> L39
        r15.j = false;     // Catch: Exception -> L29 Throwable -> L39
        r2 = r15;
        goto L26
    L23:
        r4 = false;
        goto L24
    L19:
        r3 = false;
    L26:
        p(r14);     // Catch: Throwable -> L46
        monitor-exit(this);
        return r2;
    L33:
        e = move-exception;
        e2 = e;
        r14 = null;
    L31:
        th = move-exception;
        th = th;
        goto L41
    L53:
        r5 = "_id < ?";
        r6 = new String[]{String.valueOf(r13)};     // Catch: Throwable -> L31 Exception -> L33
    L46:
        th = move-exception;
        throw th;
    }

    public final synchronized long g(q r6) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.a;     // Catch: Throwable -> L21
        if (r0 != null) goto L6;
    L17:
        ita.j.g("AppLog db not establish and open", null);     // Catch: Throwable -> L21
        monitor-exit(this);
        return -1;
    L6:
        if (r0.isOpen() == false) goto L17;
        ContentValues r1 = new ContentValues();     // Catch: Throwable -> L21
        r1.put("category", r6.b);     // Catch: Throwable -> L21
        r1.put("tag", r6.c);     // Catch: Throwable -> L21
        if (StringUtils.isEmpty(r6.d) == true) goto L11;
        r1.put("label", r6.d);     // Catch: Throwable -> L21
    L11:
        r1.put("value", Long.valueOf(r6.e));     // Catch: Throwable -> L21
        r1.put("ext_value", Long.valueOf(r6.f));     // Catch: Throwable -> L21
        if (StringUtils.isEmpty(r6.n) == true) goto L14;
        r1.put("ext_json", r6.n);     // Catch: Throwable -> L21
    L14:
        r1.put("user_id", Long.valueOf(r6.h));     // Catch: Throwable -> L21
        r1.put("timestamp", Long.valueOf(r6.l));     // Catch: Throwable -> L21
        r1.put("session_id", Long.valueOf(r6.m));     // Catch: Throwable -> L21
        r1.put("event_index", Long.valueOf(r6.q));     // Catch: Throwable -> L21
        r1.put("user_type", Integer.valueOf(r6.g));     // Catch: Throwable -> L21
        r1.put("user_is_login", Integer.valueOf(r6.j));     // Catch: Throwable -> L21
        r1.put("user_is_auth", Integer.valueOf(r6.k));     // Catch: Throwable -> L21
        r1.put("uid", Long.valueOf(r6.i));     // Catch: Throwable -> L21
        r1.put("_event_id", Long.valueOf(r6.a));     // Catch: Throwable -> L21
        long r2 = this.a.insert(EventVerify.TYPE_EVENT_V1, null, r1);     // Catch: Throwable -> L21
        monitor-exit(this);
        return r2;
    L21:
        th = move-exception;
        throw th;
    }

    public final long h(String r3) {
        return i(r3);
    }

    public final synchronized long i(String r5) {
        monitor-enter(this);
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L6
        r0.put("value", r5);     // Catch: Throwable -> L6
        r0.put("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L6
        r0.put("retry_count", 0);     // Catch: Throwable -> L6
        r0.put("retry_time", 0L);     // Catch: Throwable -> L6
        r0.put("log_type", 0);     // Catch: Throwable -> L6
        long r1 = this.a.insert("queue", null, r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void r(long r5) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.a;     // Catch: Throwable -> L18
        if (r0 != null) goto L6;
    L15:
        ita.j.g("AppLog db not establish and open", null);     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L6:
        if (r0.isOpen() == false) goto L15;
        String[] r2 = {String.valueOf(r5)};     // Catch: Exception -> L11 Throwable -> L18
        ContentValues r6 = new ContentValues();     // Catch: Exception -> L11 Throwable -> L18
        r6.put("launch_sent", 1);     // Catch: Exception -> L11 Throwable -> L18
        this.a.update("session", r6, "_id=?", r2);     // Catch: Exception -> L11 Throwable -> L18
    L13:
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        e.a().b(StatsCountKeys.DB_ERROR_COUNT, 1);     // Catch: Throwable -> L18
        ita.j.g("AppLog setSessionLaunchSent exception: ", e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static synchronized void q(Cursor r4, SQLiteDatabase r5) {
        monitor-enter(h.class);
        p(r4);     // Catch: Throwable -> L19
        if (r5 != null) goto L24;
    L17:
        monitor-exit(h.class);
        return;
    L24:
    L10:
        th = move-exception;
        ita.j.c("safeCloseCursorAndEndTX failed: " + th.getMessage(), th);     // Catch: Throwable -> L19
        if ((th instanceof SQLiteFullException) == false) goto L17;
        r5.execSQL("VACUUM");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        ita.j.c("VACUUM failed:" + th.getMessage(), th);     // Catch: Throwable -> L19
        goto L17
    L7:
        if (r5.inTransaction() == false) goto L17;
        r5.endTransaction();     // Catch: Throwable -> L10
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean n(long r13, boolean r15) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.a;     // Catch: Throwable -> L46
        Cursor r1 = null;
        boolean r2 = false;
        if (r0 != null) goto L6;
    L43:
        ita.j.g("AppLog db not establish and open", null);     // Catch: Throwable -> L46
        monitor-exit(this);
        return false;
    L6:
        if (r0.isOpen() == false) goto L43;
        if (r13 > 0) goto L12;
        monitor-exit(this);
        return false;
    L12:
        boolean r3 = true;
        String[] r11 = {String.valueOf(r13)};     // Catch: Throwable -> L46
        if (r15 == false) goto L49;
        boolean r16 = false;
    L37:
        if (r16 == false) goto L39;
        Logger.debug();     // Catch: Throwable -> L46
    L39:
        if (r3 == false) goto L41;
        r2 = b(r13);     // Catch: Throwable -> L46
    L41:
        monitor-exit(this);
        return r2;
    L49:
        r1 = this.a.query("queue", new String[]{"timestamp", "retry_count", "retry_time"}, "_id = ?", r11, null, null, null);     // Catch: Exception -> L30 Throwable -> L33
        if (r1.moveToNext() == true) goto L20;
        p(r1);     // Catch: Throwable -> L46
        monitor-exit(this);
        return false;
    L20:
        long r4 = r1.getLong(0);     // Catch: Exception -> L30 Throwable -> L33
        int r17 = r1.getInt(1);     // Catch: Exception -> L30 Throwable -> L33
        long r5 = System.currentTimeMillis();     // Catch: Exception -> L30 Throwable -> L33
        if ((r5 - r4) < AppLog.Y) goto L23;
    L28:
        p(r1);     // Catch: Throwable -> L46
        r16 = true;
        goto L37
    L23:
        if (r17 >= AppLog.Z) goto L28;
        ContentValues r6 = new ContentValues();     // Catch: Exception -> L30 Throwable -> L33
        r6.put("retry_count", Integer.valueOf(r17 + 1));     // Catch: Exception -> L30 Throwable -> L33
        r6.put("retry_time", Long.valueOf(r5));     // Catch: Exception -> L30 Throwable -> L33
        this.a.update("queue", r6, "_id = ?", r11);     // Catch: Exception -> L30 Throwable -> L33
        p(r1);     // Catch: Throwable -> L46
        monitor-exit(this);
        return false;
    L30:
        e = move-exception;
        e.a().b(StatsCountKeys.DB_ERROR_COUNT, 1);     // Catch: Throwable -> L33
        ita.j.g("AppLog onLogSent excepiton: ", e);     // Catch: Throwable -> L33
        p(r1);     // Catch: Throwable -> L46
        r16 = false;
        r3 = false;
        goto L37
    L33:
        th = move-exception;
        p(r1);     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }

    public final synchronized void s(long r5, String r7) {
        monitor-enter(this);
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L6
        r0.put("value", r7);     // Catch: Throwable -> L6
        this.a.update("queue", r0, "_id = ?", new String[]{String.valueOf(r5)});     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final JSONArray o(long r31, JSONObject r33, JSONObject r34) {
        char r12 = 0;
        String[] r15 = {"0", String.valueOf(r31)};
        String r10 = "_id<= ? ";
        String[] r9 = {"0"};
        Cursor r20 = null;
        JSONArray r21 = null;
        long r22 = 0;
    L97:
        r15[r12] = String.valueOf(r22);     // Catch: Throwable -> L80 Exception -> L82
        JSONArray r0 = new JSONArray();     // Catch: Throwable -> L80 Exception -> L82
        String[] r26 = r9;
        String r27 = r10;
        int r14 = 0;
        Cursor r4 = this.a.query("misc_log", k, "_id > ? AND session_id=?", r15, null, null, "_id ASC", "100");     // Catch: Exception -> L77 Throwable -> L80
        r4.getCount();     // Catch: Throwable -> L73 Exception -> L75
        long r5 = 0;
    L7:
        if (r4.moveToNext() == false) goto L39;
        long r7 = r4.getLong(r14);     // Catch: Exception -> L36 Throwable -> L73
        if (r7 <= 0) goto L7;
        if (r7 <= r5) goto L15;
        r5 = r7;
    L15:
        String r11 = r4.getString(1);     // Catch: Exception -> L36 Throwable -> L73
        String r13 = r4.getString(2);     // Catch: Exception -> L36 Throwable -> L73
        if (r4.isNull(3) == false) goto L111;
        long r16 = 0;
    L109:
    L34:
        e = e;
    L38:
        r20 = r4;
    L79:
        r9 = r26;
        String r17 = r27;
    L84:
        ita.j.c("pack misc log", e);     // Catch: Throwable -> L80
        e.a().b(StatsCountKeys.DB_ERROR_COUNT, 1);     // Catch: Throwable -> L80
        e.a().b(StatsCountKeys.PACK_ERROR_COUNT, 1);     // Catch: Throwable -> L80
        if ((e instanceof SQLiteBlobTooBigException) == false) goto L87;
        boolean r1 = AppLog.L;     // Catch: Throwable -> L80
    L87:
        boolean r2 = AppLog.L;     // Catch: Throwable -> L80
        p(r20);
    L89:
        r15 = r15;
        r10 = r17;
        r12 = 0;
        goto L97
    L23:
        if (StringUtils.isEmpty(r13) == false) goto L25;
    L33:
        r15 = r15;
        r14 = 0;
        goto L7
    L25:
        if (StringUtils.isEmpty(r11) == true) goto L33;
        JSONObject r18 = new JSONObject(r13);     // Catch: Exception -> L32 Throwable -> L73
        r18.put("log_id", r7);     // Catch: Exception -> L32 Throwable -> L73
        if (StringUtils.isEmpty(r11) == true) goto L30;
        r18.put("log_type", r11);     // Catch: Exception -> L32 Throwable -> L73
    L30:
        r18.put("event_id", r16);     // Catch: Exception -> L32 Throwable -> L73
        r0.put(r18);     // Catch: Exception -> L32 Throwable -> L73
    L32:
        e.a().b(StatsCountKeys.JSON_ERROR_COUNT, 1);     // Catch: Exception -> L34 Throwable -> L73
        goto L33
    L111:
        r16 = r4.getLong(3);     // Catch: Exception -> L19 Throwable -> L73
    L19:
        e = e;
        r20 = r4;
    L78:
        r15 = r15;
    L36:
        e = e;
        r15 = r15;
        goto L38
    L39:
        r15 = r15;
        if (r22 != 0) goto L42;
        r21 = r0;
        boolean r8 = false;
    L44:
        if (r22 >= r5) goto L45;
        r9 = r26;
        r9[0] = String.valueOf(r5);     // Catch: Exception -> L68 Throwable -> L73
        r17 = r27;
        this.a.delete("misc_log", r17, r9);     // Catch: Exception -> L65 Throwable -> L73
        if (r8 == true) goto L54;
    L67:
        p(r4);
        r20 = r4;
        r22 = r5;
        goto L89
    L54:
        if (r0.length() <= 0) goto L67;
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L65 Throwable -> L73
        r19.put("magic_tag", "ss_app_log");     // Catch: Exception -> L65 Throwable -> L73
        if (r34 == null) goto L58;
        r19.put("time_sync", r34);     // Catch: Exception -> L65 Throwable -> L73
    L58:
        r19.put(EventVerify.TYPE_LOG_DATA, r0);     // Catch: Exception -> L65 Throwable -> L73
        if (r33 == null) goto L61;
        r19.put("header", r33);     // Catch: Exception -> L65 Throwable -> L73
    L61:
        r19.put("_gen_time", System.currentTimeMillis());     // Catch: Exception -> L65 Throwable -> L73
        if (i(r19.toString()) >= 0) goto L67;
        e.a().b(StatsCountKeys.DB_ERROR_COUNT, 1);     // Catch: Exception -> L65 Throwable -> L73
    L65:
        e = e;
    L72:
        r20 = r4;
        r22 = r5;
    L68:
        e = e;
    L69:
        r17 = r27;
    L70:
        e = e;
        r9 = r26;
        goto L69
    L45:
        p(r4);
        return r21;
    L42:
        r8 = true;
    L73:
        th = th;
    L91:
        p(r4);
        throw th;
    L75:
        e = e;
        r15 = r15;
        r9 = r26;
        r17 = r27;
        r20 = r4;
    L77:
        e = e;
        goto L78
    L80:
        th = th;
        r4 = r20;
    L82:
        e = e;
        r17 = r10;
        r15 = r15;
        goto L84
    }

    public static void l(List r0, long r1, String r3, JSONObject r4) {
        if (r0 != null) goto L4;
        return;
    L4:
        monitor-enter(r0);
        Iterator r2 = r0.iterator();     // Catch: Throwable -> L15
    L7:
        if (r2.hasNext() == false) goto L13;
        ((AppLog.g) r2.next()).c();     // Catch: Exception -> L11 Throwable -> L15
    L11:
        e = move-exception;
        ita.j.g("AppLog onLogSessionBatchEvent exception: ", e);     // Catch: Throwable -> L15
        goto L7
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static void m(List r0, long r1, String r3, JSONObject r4) {
        if (r0 != null) goto L4;
        return;
    L4:
        monitor-enter(r0);
        Iterator r2 = r0.iterator();     // Catch: Throwable -> L15
    L7:
        if (r2.hasNext() == false) goto L13;
        ((AppLog.g) r2.next()).b();     // Catch: Exception -> L11 Throwable -> L15
    L11:
        e = move-exception;
        ita.j.g("AppLog onLogSessionTerminate exception: ", e);     // Catch: Throwable -> L15
        goto L7
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized long j(long r3, String r5, String r6, long r7) {
        monitor-enter(this);
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L6
        r0.put("log_type", r5);     // Catch: Throwable -> L6
        r0.put("value", r6);     // Catch: Throwable -> L6
        r0.put("session_id", Long.valueOf(r3));     // Catch: Throwable -> L6
        r0.put("_event_id", Long.valueOf(r7));     // Catch: Throwable -> L6
        long r4 = this.a.insert("misc_log", null, r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:520:0x09b7
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:143)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:58)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:50)
        */
    public final synchronized long a(com.ss.android.common.applog.z r55, com.ss.android.common.applog.z r56, org.json.JSONObject r57, boolean r58, long[] r59, java.lang.String[] r60, java.util.List<com.ss.android.common.applog.AppLog.g> r61, boolean r62, org.json.JSONObject r63, boolean r64) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 2631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.common.applog.h.a(com.ss.android.common.applog.z, com.ss.android.common.applog.z, org.json.JSONObject, boolean, long[], java.lang.String[], java.util.List, boolean, org.json.JSONObject, boolean):long");
    }
}
