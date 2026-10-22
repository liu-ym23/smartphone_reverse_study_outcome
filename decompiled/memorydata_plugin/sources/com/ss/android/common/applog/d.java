package com.ss.android.common.applog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile String f15073a = "ss_app_log.db";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String[] f15074b = null;
    static final String[] c = null;
    static final String[] d = null;
    static final String[] e = null;
    static final String[] f = null;
    static final String[] g = null;
    private static final String[] j = null;
    private static final Object k = null;
    private static d l;
    final Set<Long> h;
    final Set<Long> i;
    private SQLiteDatabase m;
    private final Context n;

    private static class a extends SQLiteOpenHelper {
        public a(Context r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), d.f15073a, null, 12);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS session ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value VARCHAR NOT NULL, timestamp INTEGER, duration INTEGER, non_page INTEGER, app_version VARCHAR, version_code INTEGER, pausetime INTEGER,launch_sent INTEGER NOT NULL DEFAULT 0, event_index INTEGER NOT NULL DEFAULT 0  )");     // Catch: Exception -> L4
            r2.execSQL("CREATE TABLE IF NOT EXISTS event ( _id INTEGER PRIMARY KEY AUTOINCREMENT, category VARCHAR, tag VARCHAR, label VARCHAR, value INTEGER, ext_value INTEGER, ext_json TEXT, user_id INTEGER, timestamp INTEGER, session_id INTEGER, event_index INTEGER NOT NULL DEFAULT 0, user_type INTEGER NOT NULL DEFAULT 0, user_is_login INTEGER NOT NULL DEFAULT 0, user_is_auth INTEGER NOT NULL DEFAULT 0, uid INTEGER NOT NULL DEFAULT 0 )");     // Catch: Exception -> L4
            r2.execSQL("CREATE TABLE IF NOT EXISTS page ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, duration INTEGER, session_id INTEGER )");     // Catch: Exception -> L4
            r2.execSQL("CREATE TABLE IF NOT EXISTS queue ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value TEXT, is_crash INTEGER NOT NULL DEFAULT 0, log_type INTEGER NOT NULL DEFAULT 0, timestamp INTEGER, retry_count INTEGER, retry_time INTEGER )");     // Catch: Exception -> L4
            r2.execSQL("CREATE TABLE IF NOT EXISTS misc_log ( _id INTEGER PRIMARY KEY AUTOINCREMENT, log_type VARCHAR, value TEXT, session_id INTEGER  )");     // Catch: Exception -> L4
            r2.execSQL("CREATE TABLE IF NOT EXISTS succ_rate ( _id INTEGER PRIMARY KEY AUTOINCREMENT, event_name VARCHAR, event_fail_reason INTEGER, event_fail_cnt INTEGER NOT NULL DEFAULT 0, event_date INTEGER )");     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            Logger.e("AppLog", "create db exception " + e);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r6, int r7, int r8) {
            String[] r9 = d.d();
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
            com.ss.android.common.b.b.d("drop table failed, " + r1, th);
            goto L9
        L10:
            onCreate(r6);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
            if (r2 >= 2) goto L6;
            r1.execSQL("ALTER TABLE event ADD COLUMN user_id INTEGER");
        L6:
            if (r2 >= 3) goto L9;
            r1.execSQL("ALTER TABLE session ADD COLUMN launch_sent INTEGER NOT NULL DEFAULT 0");
        L9:
            if (r2 >= 4) goto L12;
            r1.execSQL("ALTER TABLE queue ADD COLUMN is_crash INTEGER NOT NULL DEFAULT 0");
        L12:
            if (r2 >= 5) goto L15;
            r1.execSQL("ALTER TABLE event ADD COLUMN ext_json TEXT");
        L15:
            if (r2 >= 6) goto L18;
            r1.execSQL("ALTER TABLE queue ADD COLUMN log_type INTEGER NOT NULL DEFAULT 0");
        L18:
            if (r2 >= 7) goto L21;
            r1.execSQL("CREATE TABLE IF NOT EXISTS misc_log ( _id INTEGER PRIMARY KEY AUTOINCREMENT, log_type VARCHAR, value TEXT, session_id INTEGER  )");
        L21:
            if (r2 >= 8) goto L24;
            r1.execSQL("ALTER TABLE event ADD COLUMN event_index INTEGER NOT NULL DEFAULT 0");
        L24:
            if (r2 >= 9) goto L27;
            r1.execSQL("ALTER TABLE session ADD COLUMN event_index INTEGER NOT NULL DEFAULT 0");
        L27:
            if (r2 >= 10) goto L30;
            r1.execSQL("CREATE TABLE IF NOT EXISTS succ_rate ( _id INTEGER PRIMARY KEY AUTOINCREMENT, event_name VARCHAR, event_fail_reason INTEGER, event_fail_cnt INTEGER NOT NULL DEFAULT 0, event_date INTEGER )");
        L30:
            if (r2 >= 11) goto L36;
            r1.execSQL("ALTER TABLE event ADD COLUMN user_type INTEGER NOT NULL DEFAULT 0");     // Catch: Throwable -> L33
            r1.execSQL("ALTER TABLE event ADD COLUMN user_is_login INTEGER NOT NULL DEFAULT 0");     // Catch: Throwable -> L33
            r1.execSQL("ALTER TABLE event ADD COLUMN user_is_auth INTEGER NOT NULL DEFAULT 0");     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            com.ss.android.common.b.b.d("alter table add column failed", th);
        L36:
            if (r2 >= 12) goto L46;
            r1.execSQL("ALTER TABLE event ADD COLUMN uid INTEGER NOT NULL DEFAULT 0");     // Catch: Throwable -> L39
            return;
        L39:
            th = move-exception;
            com.ss.android.common.b.b.d("alter table add column failed", th);
            return;
        }
    }

    static {
        j = new String[]{"event", "page", "session", "misc_log", "succ_rate", "queue"};
        f15074b = new String[]{"_id", ActivityLifecycle.NAME, "duration", "session_id"};
        c = new String[]{"_id", EventBody.KEY_VALUE, "is_crash", "timestamp", "retry_count", "retry_time", "log_type"};
        d = new String[]{"_id", EventBody.KEY_VALUE, "timestamp", "duration", "non_page", "app_version", "version_code", "pausetime", "launch_sent", "event_index"};
        e = new String[]{"_id", EventBody.KEY_CATEGORY, LocationMonitorConst.TAG, AnnotatedPrivateKey.LABEL, EventBody.KEY_VALUE, "ext_value", "ext_json", Header.KEY_USER_ID, "timestamp", "session_id", "event_index", "user_type", "user_is_login", "user_is_auth", "uid"};
        f = new String[]{"_id", "log_type", EventBody.KEY_VALUE, "session_id"};
        g = new String[]{"_id", "log_type", EventBody.KEY_VALUE};
        k = new Object();
    }

    private d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.h = new HashSet();
        this.i = new HashSet();
        this.m = new a(r4).getWritableDatabase();
        this.n = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
    }

    private long a(String r2) {
        return a(r2, 0);
    }

    public static d a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Object r0 = k;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (l != null) goto L7;
        l = new d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return l;
    }

    private JSONArray a(boolean r29, long r30, String r32, JSONObject r33, JSONObject r34) {
        String[] r15 = new String[2];
        int r12 = 0;
        r15[0] = "0";
        boolean r11 = true;
        r15[1] = String.valueOf(r30);
        String r10 = "_id<= ? ";
        String[] r9 = {"0"};
        JSONArray r20 = null;
        Cursor r21 = null;
        long r22 = 0;
    L92:
        r15[r12] = String.valueOf(r22);     // Catch: Throwable -> L68 Exception -> L70
        JSONArray r0 = new JSONArray();     // Catch: Throwable -> L68 Exception -> L70
        String[] r26 = r9;
        String r27 = r10;
        int r14 = r12;
        Cursor r4 = this.m.query("misc_log", f, "_id > ? AND session_id=?", r15, null, null, "_id ASC", BDLocationException.ERROR_BEACON_ADVERTISING);     // Catch: Exception -> L66 Throwable -> L68
        r4.getCount();     // Catch: Throwable -> L62 Exception -> L64
        long r5 = 0;
    L7:
        if (r4.moveToNext() == false) goto L30;
        long r7 = r4.getLong(r14);     // Catch: Exception -> L27 Throwable -> L62
        if (r7 <= 0) goto L7;
        if (r7 <= r5) goto L15;
        r5 = r7;
    L15:
        String r13 = r4.getString(1);     // Catch: Exception -> L27 Throwable -> L62
        String r16 = r4.getString(2);     // Catch: Exception -> L27 Throwable -> L62
        if (com.bytedance.common.utility.h.a(r16) == true) goto L7;
        if (com.bytedance.common.utility.h.a(r13) == true) goto L7;
        JSONObject r17 = new JSONObject(r16);     // Catch: Exception -> L25 Throwable -> L62
        r17.put("log_id", r7);     // Catch: Exception -> L25 Throwable -> L62
        if (com.bytedance.common.utility.h.a(r13) == true) goto L23;
        r17.put("log_type", r13);     // Catch: Exception -> L25 Throwable -> L62
    L23:
        r0.put(r17);     // Catch: Exception -> L25 Throwable -> L62
    L25:
        b.a(MonitorKey.log_data, MonitorState.f_to_pack);     // Catch: Exception -> L27 Throwable -> L62
    L27:
        e = e;
        r21 = r4;
    L67:
        String[] r8 = r26;
        r10 = r27;
    L72:
        com.ss.android.common.b.b.d("pack misc log", e);     // Catch: Throwable -> L68
        if (ZeusTransformUtils.instanceOf(e, SQLiteBlobTooBigException.class) == false) goto L80;
        if (AppLog.J() == false) goto L80;
        if (e() == true) goto L78;
    L84:
        a(r21);
    L85:
        r9 = r8;
        r12 = r14;
        r11 = true;
    L78:
        a(r21);
    L83:
        return r20;
    L80:
        if (AppLog.I() == false) goto L84;
        b.a(MonitorKey.pack, MonitorState.break_pack_misc_other_exception);     // Catch: Throwable -> L68
        goto L78
    L30:
        if (r22 != 0) goto L32;
        r20 = r0;
        int r18 = r14;
    L34:
        if (r22 >= r5) goto L35;
        r8 = r26;
        r8[r14] = String.valueOf(r5);     // Catch: Exception -> L56 Throwable -> L62
        r10 = r27;
        this.m.delete("misc_log", r10, r8);     // Catch: Exception -> L54 Throwable -> L62
        if (r18 != 0) goto L43;
    L53:
        a(r4);
        r21 = r4;
        r22 = r5;
        goto L85
    L43:
        if (r0.length() <= 0) goto L53;
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L54 Throwable -> L62
        r19.put(Api.KEY_MAGIC, Api.MSG_MAGIC);     // Catch: Exception -> L54 Throwable -> L62
        if (r34 == null) goto L47;
        r19.put("time_sync", r34);     // Catch: Exception -> L54 Throwable -> L62
    L47:
        r19.put("log_data", r0);     // Catch: Exception -> L54 Throwable -> L62
        if (r33 == null) goto L50;
        r19.put("header", r33);     // Catch: Exception -> L54 Throwable -> L62
    L50:
        r19.put("_gen_time", System.currentTimeMillis());     // Catch: Exception -> L54 Throwable -> L62
        if (a(r19.toString()) >= 0) goto L53;
        b.a(MonitorKey.log_data, MonitorState.f_db_insert, r0.length());     // Catch: Exception -> L54 Throwable -> L62
    L54:
        e = e;
    L61:
        r21 = r4;
        r22 = r5;
    L56:
        e = e;
    L60:
        r10 = r27;
    L58:
        e = e;
        r8 = r26;
        goto L60
    L35:
        a(r4);
        goto L83
    L32:
        r18 = 1;
    L64:
        e = e;
        r8 = r26;
        r10 = r27;
        r21 = r4;
    L62:
        th = th;
        r21 = r4;
    L86:
        a(r21);
        throw th;
    L66:
        e = e;
    L70:
        e = e;
        r8 = r9;
        r14 = r12;
    L68:
        th = th;
        goto L86
    }

    public static void a(Cursor r2) {
        Cursor r3 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        if (r3.isClosed() == true) goto L12;
        r3.close();     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    public static void a(Cursor r2, SQLiteDatabase r3) {
        a((Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin"));
        if (r3 == null) goto L20;
    L8:
        th = move-exception;
        com.ss.android.common.b.b.d("safeCloseCursorAndEndTX failed: " + th.getMessage(), th);
        if (ZeusTransformUtils.instanceOf(th, SQLiteFullException.class) == false) goto L22;
        r3.execSQL("VACUUM");     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        com.ss.android.common.b.b.d("VACUUM failed:" + th.getMessage(), th);
        return;
    L22:
        return;
    L5:
        if (r3.inTransaction() == false) goto L21;
        r3.endTransaction();     // Catch: Throwable -> L8
        return;
    L21:
        return;
    }

    private void a(List<AppLog.i> r5, long r6, String r8, JSONObject r9) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        monitor-enter(r4);
        Iterator r7 = r4.iterator();     // Catch: Throwable -> L16
    L8:
        if (r7.hasNext() == false) goto L14;
        ((AppLog.i) ZeusTransformUtils.preCheckCast(r7.next(), AppLog.i.class, "com.obric.memorydata.plugin")).b(r6, r8, r9);     // Catch: Exception -> L12 Throwable -> L16
    L12:
        e = move-exception;
        Logger.w("AppLog", "onLogSessionBatchEvent exception: " + e);     // Catch: Throwable -> L16
        goto L8
    L14:
        monitor-exit(r4);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private void b(List<AppLog.i> r5, long r6, String r8, JSONObject r9) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        monitor-enter(r4);
        Iterator r7 = r4.iterator();     // Catch: Throwable -> L16
    L8:
        if (r7.hasNext() == false) goto L14;
        ((AppLog.i) ZeusTransformUtils.preCheckCast(r7.next(), AppLog.i.class, "com.obric.memorydata.plugin")).a(r6, r8, r9);     // Catch: Exception -> L12 Throwable -> L16
    L12:
        e = move-exception;
        Logger.w("AppLog", "onLogSessionTerminate exception: " + e);     // Catch: Throwable -> L16
        goto L8
    L14:
        monitor-exit(r4);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ String[] d() {
        return j;
    }

    private boolean e() {
        boolean r0 = false;
        Field r1 = CursorWindow.class.getDeclaredField("sCursorWindowSize");     // Catch: Throwable -> L13
        r1.setAccessible(true);     // Catch: Throwable -> L13
        int r3 = r1.getInt(null);     // Catch: Throwable -> L13
        if (r3 <= 0) goto L8;
        if (r3 > 8388608) goto L8;
        r1.setInt(null, r3 * 2);     // Catch: Throwable -> L13
        b.a(MonitorKey.pack, MonitorState.increase_cursor_window_size);     // Catch: Throwable -> L13
    L16:
        return r0;
    L8:
        if (r3 <= 8388608) goto L16;
        b.a(MonitorKey.pack, MonitorState.cursor_window_size_overflow);     // Catch: Throwable -> L11
        return true;
    L11:
        th = move-exception;
        r0 = true;
        th = th;
    L14:
        com.ss.android.common.b.b.d("tryIncreaseCursorWindowSize", th);
    L13:
        th = th;
        goto L14
    }

    private boolean e(long r10) {
        com.ss.android.common.b.b.b("delete app_log: " + r10);
        String[] r4 = {String.valueOf(r10)};
        int r5 = this.m.delete("queue", "_id = ?", r4);     // Catch: Throwable -> L10
        if (r5 > 0) goto L6;
        b.a(MonitorKey.pack, MonitorState.f_db_delete);     // Catch: Throwable -> L10
    L6:
        if (r5 <= 0) goto L9;
        return true;
    L9:
        return false;
    L10:
        th = move-exception;
        com.ss.android.common.b.b.d("delete app_log: " + r10 + " failed", th);
        if (ZeusTransformUtils.instanceOf(th, SQLiteFullException.class) == true) goto L23;
    L20:
        return false;
    L23:
        this.m.execSQL("VACUUM");     // Catch: Throwable -> L18
        com.ss.android.common.b.b.b("try delete app_log: " + r10 + " again after vacuum");     // Catch: Throwable -> L18
        if (this.m.delete("queue", "_id = ?", r4) <= 0) goto L17;
        return true;
    L17:
        return false;
    L18:
        th = move-exception;
        com.ss.android.common.b.b.d("VACUUM failed:" + th.getMessage(), th);
        goto L20
    }

    synchronized long a(long r3, String r5, String r6) {
        monitor-enter(this);
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L6
        r0.put("log_type", r5);     // Catch: Throwable -> L6
        r0.put(EventBody.KEY_VALUE, r6);     // Catch: Throwable -> L6
        r0.put("session_id", Long.valueOf(r3));     // Catch: Throwable -> L6
        long r4 = this.m.insert("misc_log", null, r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long a(o r5) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.m;     // Catch: Throwable -> L21
        if (r0 != null) goto L6;
    L17:
        Logger.w("AppLog", "db not establish and open");     // Catch: Throwable -> L21
        monitor-exit(this);
        return -1;
    L6:
        if (r0.isOpen() == false) goto L17;
        ContentValues r1 = new ContentValues();     // Catch: Throwable -> L21
        r1.put(EventBody.KEY_CATEGORY, r5.f15095b);     // Catch: Throwable -> L21
        r1.put(LocationMonitorConst.TAG, r5.c);     // Catch: Throwable -> L21
        if (com.bytedance.common.utility.h.a(r5.d) == true) goto L11;
        r1.put(AnnotatedPrivateKey.LABEL, r5.d);     // Catch: Throwable -> L21
    L11:
        r1.put(EventBody.KEY_VALUE, Long.valueOf(r5.e));     // Catch: Throwable -> L21
        r1.put("ext_value", Long.valueOf(r5.f));     // Catch: Throwable -> L21
        if (com.bytedance.common.utility.h.a(r5.n) == true) goto L14;
        r1.put("ext_json", r5.n);     // Catch: Throwable -> L21
    L14:
        r1.put(Header.KEY_USER_ID, Long.valueOf(r5.h));     // Catch: Throwable -> L21
        r1.put("timestamp", Long.valueOf(r5.l));     // Catch: Throwable -> L21
        r1.put("session_id", Long.valueOf(r5.m));     // Catch: Throwable -> L21
        r1.put("event_index", Long.valueOf(r5.q));     // Catch: Throwable -> L21
        r1.put("user_type", Integer.valueOf(r5.g));     // Catch: Throwable -> L21
        r1.put("user_is_login", Integer.valueOf(r5.j));     // Catch: Throwable -> L21
        r1.put("user_is_auth", Integer.valueOf(r5.k));     // Catch: Throwable -> L21
        r1.put("uid", Long.valueOf(r5.i));     // Catch: Throwable -> L21
        long r2 = this.m.insert("event", null, r1);     // Catch: Throwable -> L21
        monitor-exit(this);
        return r2;
    L21:
        th = move-exception;
        throw th;
    }

    public synchronized long a(q r4, long r5) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.m;     // Catch: Throwable -> L22
        if (r0 != null) goto L6;
    L20:
        Logger.w("AppLog", "db not establish and open");     // Catch: Throwable -> L22
        long r6 = -1;
    L18:
        monitor-exit(this);
        return r6;
    L6:
        if (r0.isOpen() == false) goto L20;
        ContentValues r1 = new ContentValues();     // Catch: Exception -> L10 Throwable -> L22
        r1.put("pausetime", Long.valueOf(r5));     // Catch: Exception -> L10 Throwable -> L22
        this.m.update("session", r1, "_id = ?", new String[]{String.valueOf(r4.c)});     // Catch: Exception -> L10 Throwable -> L22
    L25:
        ContentValues r7 = new ContentValues();     // Catch: Exception -> L15 Throwable -> L22
        r7.put(ActivityLifecycle.NAME, r4.f15098a);     // Catch: Exception -> L15 Throwable -> L22
        r7.put("duration", Integer.valueOf(r4.f15099b));     // Catch: Exception -> L15 Throwable -> L22
        r7.put("session_id", Long.valueOf(r4.c));     // Catch: Exception -> L15 Throwable -> L22
        long r8 = this.m.insert("page", null, r7);     // Catch: Exception -> L15 Throwable -> L22
        monitor-exit(this);
        return r8;
    L15:
        e = move-exception;
        Logger.w("AppLog", "insert page exception: " + e);     // Catch: Throwable -> L22
        r6 = 0;
        goto L18
    L10:
        e = move-exception;
        Logger.w("AppLog", "update session pausetime exception: " + e);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public synchronized long a(w r6) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.m;     // Catch: Throwable -> L15
        if (r0 != null) goto L6;
    L11:
        Logger.w("AppLog", "db not establish and open");     // Catch: Throwable -> L15
        monitor-exit(this);
        return -1;
    L6:
        if (r0.isOpen() == false) goto L11;
        boolean r1 = r6.i;     // Catch: Throwable -> L15
        ContentValues r2 = new ContentValues();     // Catch: Throwable -> L15
        r2.put(EventBody.KEY_VALUE, r6.f15107b);     // Catch: Throwable -> L15
        r2.put("timestamp", Long.valueOf(r6.c));     // Catch: Throwable -> L15
        r2.put("duration", Integer.valueOf(r6.e));     // Catch: Throwable -> L15
        r2.put("non_page", Integer.valueOf(r1 ? 1 : 0));     // Catch: Throwable -> L15
        r2.put("app_version", r6.f);     // Catch: Throwable -> L15
        r2.put("version_code", Integer.valueOf(r6.g));     // Catch: Throwable -> L15
        r2.put("event_index", Long.valueOf(r6.d));     // Catch: Throwable -> L15
        long r3 = this.m.insert("session", null, r2);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r3;
    L15:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 26381. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public synchronized long a(com.ss.android.common.applog.w r56, com.ss.android.common.applog.w r57, org.json.JSONObject r58, boolean r59, long[] r60, java.lang.String[] r61, java.util.List<com.ss.android.common.applog.AppLog.i> r62, boolean r63, org.json.JSONObject r64) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0000: MOVE (r8v0 ?? I:??[OBJECT, ARRAY]) = (r55v0 'this' ?? I:??[OBJECT, ARRAY] A[IMMUTABLE_TYPE, THIS]) A[DECLARE_VAR] in method: com.ss.android.common.applog.d.a(com.ss.android.common.applog.w, com.ss.android.common.applog.w, org.json.JSONObject, boolean, long[], java.lang.String[], java.util.List<com.ss.android.common.applog.AppLog$i>, boolean, org.json.JSONObject):long, file: classes6.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
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
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 2638
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.common.applog.d.a(com.ss.android.common.applog.w, com.ss.android.common.applog.w, org.json.JSONObject, boolean, long[], java.lang.String[], java.util.List, boolean, org.json.JSONObject):long");
    }

    synchronized long a(String r4, int r5) {
        monitor-enter(this);
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L6
        r0.put(EventBody.KEY_VALUE, r4);     // Catch: Throwable -> L6
        r0.put("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L6
        r0.put("retry_count", 0);     // Catch: Throwable -> L6
        r0.put("retry_time", 0L);     // Catch: Throwable -> L6
        r0.put("log_type", Integer.valueOf(r5));     // Catch: Throwable -> L6
        long r6 = this.m.insert("queue", null, r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r6;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void a() {
        monitor-enter(this);
        SQLiteDatabase r0 = this.m;     // Catch: Throwable -> L18
        if (r0 != null) goto L6;
    L15:
        Logger.w("AppLog", "db not establish and open");     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L6:
        if (r0.isOpen() == false) goto L15;
        this.m.delete("queue", "timestamp <= ? OR retry_count > " + AppLog.c, new String[]{String.valueOf(System.currentTimeMillis() - AppLog.f15028b)});     // Catch: Exception -> L11 Throwable -> L18
    L13:
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        Logger.d("AppLog", "delete expire log error:" + e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    synchronized void a(long r6, String r8) {
        monitor-enter(this);
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L6
        r0.put(EventBody.KEY_VALUE, r8);     // Catch: Throwable -> L6
        this.m.update("queue", r0, "_id = ?", new String[]{String.valueOf(r6)});     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean a(long r7) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.m;     // Catch: Throwable -> L12
        boolean r1 = true;
        if (r0 == null) goto L9;
        if (DatabaseUtils.queryNumEntries(r0, "queue", "_id = ?", new String[]{String.valueOf(r7)}) <= 0) goto L9;
    L10:
        monitor-exit(this);
        return r1;
    L9:
        r1 = false;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized boolean a(long r12, boolean r14) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.m;     // Catch: Throwable -> L50
        boolean r1 = false;
        if (r0 != null) goto L6;
    L47:
        Logger.w("AppLog", "db not establish and open");     // Catch: Throwable -> L50
        monitor-exit(this);
        return false;
    L6:
        if (r0.isOpen() == false) goto L47;
        if (r12 > 0) goto L12;
        monitor-exit(this);
        return false;
    L12:
        boolean r2 = true;
        String[] r10 = {String.valueOf(r12)};     // Catch: Throwable -> L50
        if (r14 == true) goto L38;
        Cursor r15 = null;
        r15 = this.m.query("queue", new String[]{"timestamp", "retry_count", "retry_time"}, "_id = ?", r10, null, null, null);     // Catch: Throwable -> L31 Exception -> L33
        if (r15.moveToNext() == true) goto L21;
        a(r15);     // Catch: Throwable -> L50
        monitor-exit(this);
        return false;
    L21:
        long r3 = r15.getLong(0);     // Catch: Throwable -> L31 Exception -> L33
        int r4 = r15.getInt(1);     // Catch: Throwable -> L31 Exception -> L33
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L31 Exception -> L33
        if ((r5 - r3) < AppLog.f15028b) goto L24;
    L29:
        a(r15);     // Catch: Throwable -> L50
        boolean r16 = true;
    L39:
        if (r16 == true) goto L41;
    L43:
        if (r2 == false) goto L45;
        r1 = e(r12);     // Catch: Throwable -> L50
    L45:
        monitor-exit(this);
        return r1;
    L41:
        if (Logger.debug() == false) goto L43;
        n.a(this.n, r12);     // Catch: Throwable -> L50
        goto L43
    L24:
        if (r4 >= AppLog.c) goto L29;
        ContentValues r6 = new ContentValues();     // Catch: Throwable -> L31 Exception -> L33
        r6.put("retry_count", Integer.valueOf(r4 + 1));     // Catch: Throwable -> L31 Exception -> L33
        r6.put("retry_time", Long.valueOf(r5));     // Catch: Throwable -> L31 Exception -> L33
        this.m.update("queue", r6, "_id = ?", r10);     // Catch: Throwable -> L31 Exception -> L33
        a(r15);     // Catch: Throwable -> L50
        monitor-exit(this);
        return false;
    L33:
        e = move-exception;
        Logger.w("AppLog", "onLogSent excepiton: " + e);     // Catch: Throwable -> L31
        a(r15);     // Catch: Throwable -> L50
        r16 = false;
        r2 = false;
        goto L39
    L31:
        th = move-exception;
        a(r15);     // Catch: Throwable -> L50
        throw th;     // Catch: Throwable -> L50
    L38:
        r16 = false;
    L50:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [long] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    public synchronized p b(long r12) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.m;     // Catch: Throwable -> L33
        ?? r1 = 0;
        p r2 = null;
        if (r0 != null) goto L37;
    L30:
        Logger.w("AppLog", "db not establish and open");     // Catch: Throwable -> L33
        monitor-exit(this);
        return null;
    L37:
        if (r0.isOpen() == false) goto L30;
        Cursor r13 = this.m.query("queue", c, "_id > ?", new String[]{String.valueOf(r12)}, null, null, "_id ASC", "1");     // Catch: Throwable -> L18 Exception -> L20
    L16:
        e = e;
    L22:
        Logger.w("AppLog", "getLog exception " + e);     // Catch: Throwable -> L26
        a(r13);     // Catch: Throwable -> L33
        monitor-exit(this);
        return null;
    L10:
        if (r13.moveToNext() == false) goto L13;
        p r3 = new p();     // Catch: Exception -> L16 Throwable -> L26
        r3.f15096a = r13.getInt(0);     // Catch: Exception -> L16 Throwable -> L26
        r3.f15097b = r13.getString(1);     // Catch: Exception -> L16 Throwable -> L26
        r3.c = r13.getLong(3);     // Catch: Exception -> L16 Throwable -> L26
        r3.d = r13.getInt(4);     // Catch: Exception -> L16 Throwable -> L26
        r3.e = r13.getLong(5);     // Catch: Exception -> L16 Throwable -> L26
        r3.f = r13.getInt(6);     // Catch: Exception -> L16 Throwable -> L26
        r2 = r3;
    L13:
        a(r13);     // Catch: Throwable -> L33
        monitor-exit(this);
        return r2;
    L20:
        e = e;
        r13 = null;
    L18:
        th = th;
    L28:
        a(r1);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L26:
        th = th;
        r1 = r12;
    L33:
        th = move-exception;
        throw th;
    }

    synchronized void b() {
        monitor-enter(this);
        SQLiteDatabase r0 = this.m;     // Catch: Throwable -> L21
        if (r0 != null) goto L6;
    L18:
        Logger.w("AppLog", "db not establish and open");     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L6:
        if (r0.isOpen() == false) goto L18;
        String[] r1 = j;     // Catch: Throwable -> L21
        int r2 = r1.length;     // Catch: Throwable -> L21
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L16;
        String r4 = r1[r3];     // Catch: Throwable -> L21
        this.m.delete(r4, null, null);     // Catch: Throwable -> L13
    L15:
        r3 = r3 + 1;
    L13:
        th = move-exception;
        Logger.w("AppLog", "delete table failed, " + r4, th);     // Catch: Throwable -> L21
        goto L15
    L16:
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00b7: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:40:0x00b7 */
    public synchronized w c(long r15) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.m;     // Catch: Throwable -> L46
        Cursor r2 = null;
        w r3 = null;
        if (r0 != null) goto L50;
    L43:
        Logger.w("AppLog", "db not establish and open");     // Catch: Throwable -> L46
        monitor-exit(this);
        return null;
    L50:
        if (r0.isOpen() == false) goto L43;
        boolean r12 = true;
        if (r15 > 0) goto L53;
        String r6 = null;
        String[] r7 = null;
    L13:
        Cursor r4 = this.m.query("session", d, r6, r7, null, null, "_id DESC", "1");     // Catch: Throwable -> L31 Exception -> L33
    L29:
        e = e;
    L35:
        Logger.w("AppLog", "getLastSession exception " + e);     // Catch: Throwable -> L39
        a(r4);     // Catch: Throwable -> L46
        monitor-exit(this);
        return null;
    L15:
        if (r4.moveToNext() == false) goto L26;
        w r1 = new w();     // Catch: Exception -> L29 Throwable -> L39
        r1.f15106a = r4.getInt(0);     // Catch: Exception -> L29 Throwable -> L39
        r1.f15107b = r4.getString(1);     // Catch: Exception -> L29 Throwable -> L39
        r1.c = r4.getLong(2);     // Catch: Exception -> L29 Throwable -> L39
        if (r4.getInt(4) <= 0) goto L19;
        boolean r5 = true;
    L20:
        r1.i = r5;     // Catch: Exception -> L29 Throwable -> L39
        r1.f = r4.getString(5);     // Catch: Exception -> L29 Throwable -> L39
        r1.g = r4.getInt(6);     // Catch: Exception -> L29 Throwable -> L39
        r1.h = r4.getInt(7);     // Catch: Exception -> L29 Throwable -> L39
        if (r4.getInt(8) > 0) goto L24;
        r12 = false;
    L24:
        r1.j = r12;     // Catch: Exception -> L29 Throwable -> L39
        r1.d = r4.getLong(9);     // Catch: Exception -> L29 Throwable -> L39
        r1.k = false;     // Catch: Exception -> L29 Throwable -> L39
        r3 = r1;
        goto L26
    L19:
        r5 = false;
    L26:
        a(r4);     // Catch: Throwable -> L46
        monitor-exit(this);
        return r3;
    L33:
        e = e;
        r4 = null;
    L31:
        th = th;
    L41:
        a(r2);     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L53:
        r6 = "_id < ?";
        r7 = new String[]{String.valueOf(r15)};     // Catch: Throwable -> L31 Exception -> L33
    L39:
        th = th;
        r2 = r3;
    L46:
        th = move-exception;
        throw th;
    }

    public void c() {
        File r4 = this.n.getDatabasePath(f15073a);
        if (r4 == null) goto L6;
        b.a(MonitorKey.database, MonitorState.init, r4.length());
        return;
    }

    public synchronized void d(long r5) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.m;     // Catch: Throwable -> L17
        if (r0 != null) goto L6;
    L14:
        Logger.w("AppLog", "db not establish and open");     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L6:
        if (r0.isOpen() == false) goto L14;
        String[] r2 = {String.valueOf(r5)};     // Catch: Exception -> L10 Throwable -> L17
        ContentValues r6 = new ContentValues();     // Catch: Exception -> L10 Throwable -> L17
        r6.put("launch_sent", 1);     // Catch: Exception -> L10 Throwable -> L17
        this.m.update("session", r6, "_id=?", r2);     // Catch: Exception -> L10 Throwable -> L17
    L12:
        monitor-exit(this);
        return;
    L10:
        e = move-exception;
        Logger.w("AppLog", "setSessionLaunchSent exception: " + e);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }
}
