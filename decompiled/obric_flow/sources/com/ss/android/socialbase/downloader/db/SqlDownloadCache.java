package com.ss.android.socialbase.downloader.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.lynx.tasm.utils.g;
import com.ss.android.socialbase.downloader.cleaner.Cleaner;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import td.c;

/* JADX INFO: loaded from: classes3.dex */
public class SqlDownloadCache extends ISqlDownloadCacheAidl.Stub implements ISqlDownloadCache {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile SQLiteDatabase f15400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f15401k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile HashMap f15402l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f15403m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final boolean f15404n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final boolean f15405o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final CopyOnWriteArraySet f15406p = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TableStatements f15407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TableStatements f15408c;
    public volatile boolean d;
    public int e;
    public long f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f15409h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ISqlCacheLoadCompleteCallbackAidl f15410i;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$16, reason: invalid class name */
    class AnonymousClass16 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SqlDownloadCache f15422b;

        public AnonymousClass16(SqlDownloadCache r5, int r10) {
            this.f15422b = r5;
            this.f15421a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SqlDownloadCache r5 = this.f15422b;
            SQLiteDatabase r10 = SqlDownloadCache.f15400j;
            r5.y();
            if (SqlDownloadCache.f15400j == null) goto L19;
            SqlDownloadCache r11 = this.f15422b;
            if (r11.f15407b == null) goto L20;
        L10:
            th = move-exception;
            th.printStackTrace();
            Logger.a("SqlDownloadCache", this.f15421a, "removeDownloadInfo", "Error:" + th);
            return;
        L8:
            if (r11.f15409h == false) goto L12;
            SqlDownloadCache r12 = this.f15422b;     // Catch: Throwable -> L10
            int r13 = this.f15421a;     // Catch: Throwable -> L10
            r12.getClass();     // Catch: Throwable -> L10
            SqlDownloadCache.a(r13, "downloader");     // Catch: Throwable -> L10
        L13:
            this.f15422b.b(this.f15421a, null);     // Catch: Throwable -> L10
            return;
        L12:
            SqlDownloadCache.a(this.f15421a, this.f15422b.f15407b.a());     // Catch: Throwable -> L10
            goto L13
        L20:
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$17, reason: invalid class name */
    class AnonymousClass17 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SqlDownloadCache f15424b;

        public AnonymousClass17(SqlDownloadCache r5, int r10) {
            this.f15424b = r5;
            this.f15423a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SqlDownloadCache r5 = this.f15424b;
            int r10 = this.f15423a;
            r5.getClass();
            DownloadComponentManager.a(new AnonymousClass16(r5, r10));
            this.f15424b.q(this.f15423a);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$18, reason: invalid class name */
    class AnonymousClass18 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SqlDownloadCache f15425a;

        public AnonymousClass18(SqlDownloadCache r5) {
            this.f15425a = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SqlDownloadCache r5 = this.f15425a;
            SQLiteDatabase r10 = SqlDownloadCache.f15400j;
            r5.y();
            if (SqlDownloadCache.f15400j == null) goto L18;
            SqlDownloadCache r11 = this.f15425a;
            monitor-enter(r11);
            SqlDownloadCache.f15400j.beginTransaction();     // Catch: Throwable -> L14
            SqlDownloadCache.f15400j.delete("downloader", null, null);     // Catch: Throwable -> L14
            SqlDownloadCache.f15400j.setTransactionSuccessful();     // Catch: Throwable -> L14
            SqlDownloadCache.A();     // Catch: Throwable -> L12
            monitor-exit(r11);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        L14:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L19
            Logger.c("SqlDownloadCache", "clearDataInSubThread", "Error:" + th);     // Catch: Throwable -> L19
            SqlDownloadCache.A();     // Catch: Throwable -> L12
            return;
        L19:
            th = move-exception;
            SqlDownloadCache.A();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCache$19, reason: invalid class name */
    class AnonymousClass19 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ContentValues f15427b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SqlDownloadCache f15428c;

        public AnonymousClass19(SqlDownloadCache r5, int r10, ContentValues r11) {
            this.f15428c = r5;
            this.f15426a = r10;
            this.f15427b = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SqlDownloadCache r5 = this.f15428c;
            SQLiteDatabase r10 = SqlDownloadCache.f15400j;
            r5.y();
            if (SqlDownloadCache.f15400j == null) goto L30;
            SqlDownloadCache r11 = this.f15428c;
            int r12 = this.f15426a;
            ContentValues r13 = this.f15427b;
            r11.getClass();
            int r14 = 10;
        L21:
        L15:
            th = move-exception;
            th.printStackTrace();
            Logger.a("SqlDownloadCache", r12, "updateInner", "Error2:" + th);
            return;
        L7:
            if (SqlDownloadCache.f15400j.isDbLockedByCurrentThread() == false) goto L17;
            r14 = r14 - 1;
            if (r14 < 0) goto L17;
            Thread.sleep(5);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L15
            Logger.a("SqlDownloadCache", r12, "updateInner", "Error:" + th);     // Catch: Throwable -> L15
        L17:
            SqlDownloadCache.f15400j.update("downloader", r13, "_id = ? ", new String[]{String.valueOf(r12)});     // Catch: Throwable -> L15
            return;
        }
    }

    public interface Fallback<T> {
        Object a();
    }

    static {
        LruCache r5 = DownloadSetting.e;
        int r10 = 300;
        int r11 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optInt("lru_download_info_capacity_max", 300);
        if (r11 < 100) goto L5;
        r10 = r11;
    L5:
        f15401k = r10;
        f15402l = null;
        DownloadSetting r12 = DownloadSetting.f;
        boolean r13 = false;
        int r14 = r12.a("main_thread_db_op_max_time_ms", 0);
        if (r14 < 0) goto L9;
        Context r15 = DownloadComponentManager.f15515a;
    L9:
        f15403m = r14;
        if (r12.a("enable_remove_download_sp_info", 0) <= 0) goto L12;
        r13 = true;
    L12:
        f15404n = r13;
        f15405o = DownloadFileUtils.b();
        f15406p = new CopyOnWriteArraySet();
    }

    public SqlDownloadCache() {
        this.g = false;
        this.f15409h = false;
        this.f15410i = null;
    }

    public static void A() {
    L8:
        th = move-exception;
        th.printStackTrace();
        Logger.c("SqlDownloadCache", "safeEndTransaction", "Error:" + th);
        return;
    L3:
        if (f15400j != null) goto L5;
        return;
    L5:
        if (f15400j.inTransaction() == false) goto L14;
        f15400j.endTransaction();     // Catch: Throwable -> L8
        return;
    }

    public static void w() {
        monitor-enter(DownloadComponentManager.class);
        Context r5 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L29
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L29
        String r10 = DownloadUtils.a(r5);
        if (TextUtils.isEmpty(r10) == false) goto L11;
        Logger.c("SqlDownloadCache", "dbInitDataBase", "ProcessName is null");
        return;
    L11:
        if (r10.contains(":") == false) goto L24;
        String[] r11 = r10.split(":");
        if (r11 != null) goto L15;
    L22:
        Logger.c("SqlDownloadCache", "dbInitDataBase", "Error process name:".concat(r10));
        return;
    L15:
        if (r11.length != 2) goto L22;
        String r12 = r11[1];
        if (TextUtils.isEmpty(r12) == false) goto L21;
        Logger.c("SqlDownloadCache", "dbInitDataBase", "TargetProcess empty");
        return;
    L21:
        String r13 = g.d("downloader_", r12, ".db");
    L25:
        f15400j = DownloadDBHelper.a(r13).getWritableDatabase();
        if (Logger.b() == false) goto L34;
        Logger.b("SqlDownloadCache", "dbInitDataBase", "DB name:" + r13);
        return;
    L34:
        return;
    L24:
        r13 = "downloader.db";
    L29:
        th = move-exception;
        throw th;
    }

    public static void x() {
        if (f15400j == null) goto L12;
        f15400j.execSQL("DROP TABLE IF EXISTS downloadChunk");     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.c("SqlDownloadCache", "deleteChunkTable", "Error:" + th);
        return;
    }

    public static void z() {
        if (f15402l == null) goto L5;
        return;
    L5:
        JSONObject r5 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optJSONObject("lru_preload_hot_cache_keys");
        SparseArray r10 = DownloadHelper.f16133a;
        if (r5 == null) goto L16;
        HashMap r11 = new HashMap();
        Iterator<String> r12 = r5.keys();
    L10:
        if (r12.hasNext() == false) goto L15;
        String r13 = r12.next();
        if (r13 == null) goto L10;
        r11.put(r13, Integer.valueOf(r5.optInt(r13, 0)));
        goto L10
    L15:
        if (r11.isEmpty() == true) goto L16;
    L17:
        f15402l = r11;
        return;
    L16:
        r11 = null;
        goto L17
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final List a(String r5, String r10) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final void b(DownloadInfo r5) {
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final void c(int r5) {
    }

    public final void d(ArrayList r5) {
        Iterator r10 = r5.iterator();     // Catch: Throwable -> L11
    L3:
        if (r10.hasNext() == false) goto L25;
        DownloadInfo r11 = (DownloadInfo) r10.next();     // Catch: Throwable -> L11
        if (r11 == null) goto L3;
        r11.d();     // Catch: Throwable -> L11
        if (r11.T0.optBoolean("is_save_path_redirected", false) == false) goto L13;
        DownloadUtils.a(r11);     // Catch: Throwable -> L11
    L13:
        b(r11.l(), r11.e);     // Catch: Throwable -> L11
        goto L3
    L25:
        return;
    L11:
        th = move-exception;
        c.e("Error:", th, "SqlDownloadCache", "clearAntiHijackDirIfNeeded");
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final boolean e() {
        return false;
    }

    public final List f(final String r5) {
        return (List) a(new AnonymousClass20(this, r5), new AnonymousClass21());
    }

    public final Map g(final String r5) {
        return (Map) a(new AnonymousClass22(this, r5), new AnonymousClass23());
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final DownloadInfo h(int r5) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final DownloadInfo j(int r5) {
        ContentValues r10 = new ContentValues();
        r10.put(NotificationCompat.CATEGORY_STATUS, -7);
        DownloadComponentManager.a(new AnonymousClass19(this, r5, r10));
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final DownloadInfo k(int r5) {
        ContentValues r10 = new ContentValues();
        r10.put(NotificationCompat.CATEGORY_STATUS, 1);
        DownloadComponentManager.a(new AnonymousClass19(this, r5, r10));
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List o(int r5) {
        Map r10 = r(r5);
        if (r10 == null) goto L9;
        HashMap r11 = (HashMap) r10;
        if (r11.isEmpty() == false) goto L8;
        return null;
    L8:
        return new ArrayList(r11.values());
    L9:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final void q(int r5) {
        y();
        if (f15400j == null) goto L16;
    L9:
        th = move-exception;
        th.printStackTrace();
        Logger.a("SqlDownloadCache", r5, "removeSegments", "Error:" + th);
        return;
    L6:
        if (this.f15409h == false) goto L11;
        a(r5, "segments");     // Catch: Throwable -> L9
        return;
    L11:
        a(r5, this.f15408c.a());     // Catch: Throwable -> L9
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final Map r(int r11) {
        y();
        if (f15400j != null) goto L29;
    L28:
        return null;
    L29:
        Cursor r10 = f15400j.rawQuery("SELECT * FROM segments WHERE _id = ?", new String[]{Integer.toString(r11)});     // Catch: Throwable -> L21
    L10:
        th = th;
    L31:
        th.printStackTrace();     // Catch: Throwable -> L25
        Logger.a("SqlDownloadCache", r11, "getSegmentMap", "Error:" + th);     // Catch: Throwable -> L25
        DownloadUtils.a(new Cursor[]{r10});
    L25:
        th = move-exception;
        DownloadUtils.a(new Cursor[]{r10});
        throw th;
    L6:
        if (r10.moveToNext() == false) goto L20;
        int r5 = r10.getColumnIndex("info");     // Catch: Throwable -> L10
        if (r5 < 0) goto L12;
        String r12 = r10.getString(r5);     // Catch: Throwable -> L10
    L13:
        HashMap r13 = new HashMap();     // Catch: Throwable -> L10
        JSONArray r14 = new JSONArray(r12);     // Catch: Throwable -> L10
        int r15 = 0;
    L14:
        if (r15 >= r14.length()) goto L18;
        Segment r16 = new Segment(r14.getJSONObject(r15));     // Catch: Throwable -> L10
        r13.put(Long.valueOf(r16.f16034a), r16);     // Catch: Throwable -> L10
        r15 = r15 + 1;
        goto L14
    L18:
        DownloadUtils.a(new Cursor[]{r10});
        return r13;
    L12:
        r12 = null;
        goto L13
    L20:
        DownloadUtils.a(new Cursor[]{r10});
    L21:
        th = th;
        r10 = null;
        goto L31
    }

    public final void y() {
        if (f15400j == null) goto L5;
        return;
    L5:
        monitor-enter(SqlDownloadCache.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (f15400j == null) goto L29;
    L24:
        monitor-exit(SqlDownloadCache.class);     // Catch: Throwable -> L13
        return;
    L29:
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L13
        Logger.c("SqlDownloadCache", "ensureDataBaseInit", "Error:" + th);     // Catch: Throwable -> L13
        goto L24
    L9:
        if (DownloadComponentManager.b() != null) goto L18;
        Logger.c("SqlDownloadCache", "ensureDataBaseInit", "Context is null");     // Catch: Throwable -> L15
        monitor-exit(SqlDownloadCache.class);     // Catch: Throwable -> L13
        return;
    L18:
        if (DownloadUtils.d.get() != 2) goto L20;
        w();     // Catch: Throwable -> L15
    L21:
        this.f15407b = new TableStatements(f15400j, "downloader", DBDefinition.f15269a, DBDefinition.f15270b);     // Catch: Throwable -> L15
        this.f15408c = new TableStatements(f15400j, "segments", DBDefinition.f15271c, DBDefinition.d);     // Catch: Throwable -> L15
        goto L24
    L20:
        f15400j = DownloadDBHelper.a("downloader.db").getWritableDatabase();     // Catch: Throwable -> L15
        goto L21
    }

    public static void a(SqlDownloadCache r5, DownloadInfo r10, SQLiteStatement r11) {
        r5.getClass();
        if (r10 == null) goto L25;
        if (r11 == null) goto L28;
        monitor-enter(r11);     // Catch: Throwable -> L15
        r10.a(r11);     // Catch: Throwable -> L17
        r11.executeInsert();     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
    L10:
        if (f15405o == true) goto L12;
        return;
    L12:
        if (DownloadFileUtils.e(r10.e) == false) goto L27;
        f15406p.add(Integer.valueOf(r10.l()));     // Catch: Throwable -> L15
        return;
    L27:
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
        Logger.a("SqlDownloadCache", r10.l(), "insertDownloadInfoInner", "Error:" + th);
        return;
    L28:
        return;
    }

    public static boolean h(String r5) {
        if (f15402l != null) goto L5;
    L17:
        return false;
    L5:
        if (f15402l.isEmpty() == true) goto L17;
        if (r5 == null) goto L17;
        Iterator r10 = f15402l.entrySet().iterator();
    L10:
        if (r10.hasNext() == false) goto L17;
        String r11 = (String) ((Map.Entry) r10.next()).getKey();
        if (r11 == null) goto L10;
        if (r5.indexOf(r11) == (-1)) goto L10;
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final List b(final String r5) {
        return (List) a(new AnonymousClass6(this, r5), new AnonymousClass7());
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final List c(final String r5) {
        return (List) a(new AnonymousClass3(this, r5), new AnonymousClass4());
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final DownloadInfo e(int r5) {
        ContentValues r10 = new ContentValues();
        r10.put(NotificationCompat.CATEGORY_STATUS, 5);
        r10.put("isFirstDownload", 0);
        DownloadComponentManager.a(new AnonymousClass19(this, r5, r10));
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final boolean b(int r5) {
        DownloadComponentManager.a(new AnonymousClass16(this, r5));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final DownloadInfo c(int r5, long r10) {
        ContentValues r11 = new ContentValues();
        r11.put(NotificationCompat.CATEGORY_STATUS, -1);
        r11.put("curBytes", Long.valueOf(r10));
        if (r10 <= 0) goto L5;
        r11.put("isFirstDownload", 0);
    L5:
        DownloadComponentManager.a(new AnonymousClass19(this, r5, r11));
        return null;
    }

    public final void b(int r5, String r10) {
        if (f15404n == false) goto L13;
        monitor-enter(DownloadComponentManager.class);
        Context r11 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L9
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L9
        r11.getSharedPreferences("sp_download_info", 0).edit().remove(Integer.toString(r5)).apply();
    L9:
        th = move-exception;
        throw th;
    L13:
        if (f15405o == false) goto L34;
        CopyOnWriteArraySet r12 = f15406p;
        if (r12.contains(Integer.valueOf(r5)) == false) goto L35;
        r12.remove(Integer.valueOf(r5));
    L22:
        th = move-exception;
        th.printStackTrace();
        Logger.a("SqlDownloadCache", r5, "handleRelatedData", "Error:" + th);
        return;
    L18:
        if (TextUtils.isEmpty(r10) == false) goto L25;
        DownloadInfo r13 = a(r5);     // Catch: Throwable -> L22
        if (r13 == null) goto L25;
        r10 = r13.e;     // Catch: Throwable -> L22
    L25:
        if (TextUtils.isEmpty(r10) == true) goto L36;
        ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).e().getContentResolver().delete(Uri.parse(r10), null, null);     // Catch: Throwable -> L22
        return;
    L36:
        return;
    L35:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final boolean c() {
        return this.d;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final List d(final String r5) {
        return (List) a(new AnonymousClass10(this, r5), new AnonymousClass11());
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final List d() {
        return (List) a(new AnonymousClass12(this), new AnonymousClass13());
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final boolean d(int r5) {
        DownloadComponentManager.a(new AnonymousClass17(this, r5));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final DownloadInfo d(int r5, long r10) {
        ContentValues r11 = new ContentValues();
        r11.put(NotificationCompat.CATEGORY_STATUS, -3);
        r11.put("curBytes", Long.valueOf(r10));
        r11.put("isFirstDownload", 0);
        r11.put("isFirstSuccess", 0);
        DownloadComponentManager.a(new AnonymousClass19(this, r5, r11));
        return null;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 14951. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public static void a(com.ss.android.socialbase.downloader.db.SqlDownloadCache r42, com.ss.android.socialbase.downloader.model.DownloadDBInitInfo r43, android.util.SparseArray r44, java.util.HashMap r45, java.util.List r46, java.util.List r47, com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback r48, com.ss.android.socialbase.downloader.cleaner.Cleaner r49) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0013: CONSTRUCTOR (r15v0 ?? I:android.util.SparseArray) =  A[DECLARE_VAR, MD:():void (c)] call: android.util.SparseArray.<init>():void type: CONSTRUCTOR in method: com.ss.android.socialbase.downloader.db.SqlDownloadCache.a(com.ss.android.socialbase.downloader.db.SqlDownloadCache, com.ss.android.socialbase.downloader.model.DownloadDBInitInfo, android.util.SparseArray, java.util.HashMap, java.util.List, java.util.List, com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback, com.ss.android.socialbase.downloader.cleaner.Cleaner):void, file: classes3.dex
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
            Method dump skipped, instruction units count: 1495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.db.SqlDownloadCache.a(com.ss.android.socialbase.downloader.db.SqlDownloadCache, com.ss.android.socialbase.downloader.model.DownloadDBInitInfo, android.util.SparseArray, java.util.HashMap, java.util.List, java.util.List, com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback, com.ss.android.socialbase.downloader.cleaner.Cleaner):void");
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final DownloadInfo b(int r5, long r10) {
        ContentValues r11 = new ContentValues();
        r11.put(NotificationCompat.CATEGORY_STATUS, 4);
        r11.put("curBytes", Long.valueOf(r10));
        DownloadComponentManager.a(new AnonymousClass19(this, r5, r11));
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final void a(boolean r10) {
        if (r10 == false) goto L12;
        SparseArray r5 = new SparseArray();
        HashMap r11 = new HashMap();
        ArrayList r12 = new ArrayList();
        monitor-enter(DownloadComponentManager.class);
        Context r13 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L9
        char[] r14 = DownloadUtils.f16142a;     // Catch: Throwable -> L9
        monitor-exit(DownloadComponentManager.class);
        a(r5, r11, r12, null, null);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        a(new SparseArray(), null, null, null, null);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public final void a(final SparseArray r10, final HashMap r11, final List r12, final List r13, final SqlCacheLoadCompleteCallback r14) {
        Runnable r15 = new AnonymousClass1(this, r10, r14, r11, r12, r13);     // Catch: Throwable -> L6
        ExecutorService r16 = DownloadComponentManager.e();     // Catch: Throwable -> L6
        if (r16 == null) goto L11;
        ((ThreadPoolExecutor) r16).execute(r15);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        Logger.c("SqlDownloadCache", "init", "Error2:" + th);
    }

    public final void a(boolean r10, ArrayList r11, SparseArray r12, SparseArray r13, HashMap r14, List r15, SqlCacheLoadCompleteCallback r16) {
        if (Logger.a() == false) goto L5;
        Logger.b("SqlDownloadCache", "callbackDownloadInfo", "Run");
    L5:
        d(r11);
        a(r11, r12);
        if (Logger.b() == false) goto L8;
        Logger.b("SqlDownloadCache", "callbackDownloadInfo", "Run Callback:" + r16);
    L8:
        if (r16 == null) goto L10;
        r16.a(r10);
    L10:
        a(r13, r14, r15, r10);
        r12.clear();
        r11.clear();
        r13.clear();
        if (r10 == true) goto L24;
    L16:
        th = move-exception;
        th.printStackTrace();
        Logger.c("SqlDownloadCache", "newInit", "Sleep:" + th);
        return;
    L14:
        if (Logger.b() == false) goto L18;
        Logger.b("SqlDownloadCache", "newInit", "Sleep:" + this.f);     // Catch: Throwable -> L16
    L18:
        Thread.sleep(this.f);     // Catch: Throwable -> L16
        return;
    }

    public final boolean a(DownloadInfo r10, boolean r11, long r12, boolean r14) {
        if (this.g == false) goto L14;
        long r5 = r10.f15843w;
        if (r5 <= 0) goto L14;
        long r13 = r10.X;
        if (r13 <= 0) goto L14;
        if (((r5 * 1000) + r13) >= System.currentTimeMillis()) goto L14;
        if (r14 == false) goto L12;
        return true;
    L12:
        DownloadUtils.b(r10, true);
        return true;
    L14:
        if (r11 == false) goto L23;
        if (DownloadFileUtils.a() == false) goto L23;
        if (DownloadFileUtils.e(r10.e) == true) goto L23;
        if (DownloadFileUtils.d(r10.e) == false) goto L23;
        return true;
    L23:
        if (r12 > 0) goto L25;
    L32:
        return false;
    L25:
        if (r10.o() == (-3)) goto L32;
        r10.d();
        long r15 = r12 * 1000;
        if ((r15 + r10.T0.optLong("dbjson_last_start_download_time", 0)) >= System.currentTimeMillis()) goto L32;
        if (r14 == false) goto L30;
        return true;
    L30:
        DownloadUtils.b(r10, false);
        return true;
    }

    public static boolean a(DownloadInfo r10, boolean r11, boolean r12, Cleaner r13, boolean r14) {
        if (r10.o() != (-3)) goto L34;
        String r5 = r10.e;
        String r15 = r10.f15808b;
        char[] r16 = DownloadUtils.f16142a;
        boolean r17 = false;
        if (TextUtils.isEmpty(r5) == false) goto L8;
    L14:
        boolean r18 = false;
    L16:
        if (r10.Z > 0) goto L18;
    L24:
        if (r18 == false) goto L30;
        if (r17 == false) goto L34;
        if (r14 == false) goto L28;
        r13.f15223a.a(-1, r10, true);
        goto L34
    L28:
        DownloadUtils.b(r10, true);
        return r12;
    L30:
        if (r11 == false) goto L32;
        return true;
    L32:
        if (r17 == true) goto L34;
        r10.f();
        goto L34
    L18:
        if (DownloadDirUtils.a(r10.e) == false) goto L20;
    L23:
        r17 = true;
        goto L24
    L20:
        if (f15405o == false) goto L24;
        if (DownloadFileUtils.e(r10.e) == false) goto L24;
    L8:
        if (TextUtils.isEmpty(r15) == true) goto L14;
        if (DownloadFileUtils.e(r5) == true) goto L36;
    L13:
        r18 = new DownloadFile(r5, r15, true).f();
        goto L16
    L36:
        DownloadFileUtils.a(Uri.parse(r5), DownloadFileUtils.b(r5));     // Catch: Throwable -> L35
    L34:
        return r12;
    }

    public static void a(ArrayList r10, SparseArray r11) {
        int r5 = r11.size();
        if (r5 >= 0) goto L5;
        return;
    L5:
        if (f15400j == null) goto L42;
        SQLiteDatabase r12 = f15400j;
        monitor-enter(r12);
        f15400j.beginTransaction();     // Catch: Throwable -> L15
        int r13 = 0;
        if (r10.isEmpty() == true) goto L18;
        String[] r14 = new String[r10.size()];     // Catch: Throwable -> L15
        int r15 = 0;
    L13:
        if (r15 >= r10.size()) goto L17;
        r14[r15] = String.valueOf(((DownloadInfo) r10.get(r15)).l());     // Catch: Throwable -> L15
        r15 = r15 + 1;     // Catch: Throwable -> L15
        goto L13
    L17:
        f15400j.delete("downloader", "CAST(_id AS TEXT) IN (" + new String(new char[r10.size() - 1]).replace("\u0000", "?,") + "?)", r14);     // Catch: Throwable -> L15
    L18:
        if (r13 >= r5) goto L20;
        int r16 = r11.keyAt(r13);     // Catch: Throwable -> L15
        DownloadInfo r17 = (DownloadInfo) r11.get(r16);     // Catch: Throwable -> L15
        f15400j.delete("downloader", "_id = ?", new String[]{String.valueOf(r16)});     // Catch: Throwable -> L15
        f15400j.insert("downloader", null, DownloadHelper.a(r17));     // Catch: Throwable -> L15
        r13 = r13 + 1;     // Catch: Throwable -> L15
        goto L18
    L20:
        f15400j.setTransactionSuccessful();     // Catch: Throwable -> L15
    L23:
        A();     // Catch: Throwable -> L26
        monitor-exit(r12);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L28
        Logger.c("SqlDownloadCache", "loadCacheFromDB", "Error:" + th);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        A();     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final DownloadInfo a(final int r5) {
        return (DownloadInfo) a(new AnonymousClass2(this, r5), null);
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final List a(final String r5) {
        return (List) a(new AnonymousClass8(this, r5), new AnonymousClass9());
    }

    public static void a(int r5, SQLiteStatement r10) {
        if (r10 == null) goto L18;
        monitor-enter(r10);     // Catch: Throwable -> L12
        r10.bindLong(1, r5);     // Catch: Throwable -> L9
        r10.execute();     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
        Logger.a("SqlDownloadCache", r5, "deleteInner", "Error:" + th);
        return;
    }

    public static void a(int r5, String r10) {
        f15400j.beginTransaction();     // Catch: Throwable -> L6
        f15400j.delete(r10, "_id = ?", new String[]{String.valueOf(r5)});     // Catch: Throwable -> L6
        f15400j.setTransactionSuccessful();     // Catch: Throwable -> L6
        A();
        return;
    L6:
        th = move-exception;
        Logger.c("SqlDownloadCache", "deleteInner", "Error:" + th);     // Catch: Throwable -> L10
        A();
        return;
    L10:
        th = move-exception;
        A();
        throw th;
    }

    public static void a(DownloadInfo r5, SQLiteStatement r10) {
        if (r5 == null) goto L19;
        if (r10 == null) goto L20;
        monitor-enter(r10);     // Catch: Throwable -> L12
        r5.a(r10);     // Catch: Throwable -> L9
        r10.bindLong(r5.f15838t0 + 1, r5.l());     // Catch: Throwable -> L9
        r10.execute();     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
        Logger.a("SqlDownloadCache", r5.l(), "updateDownloadInfoInner", "Error:" + th);
        return;
    L20:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final boolean a(final DownloadInfo r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        DownloadComponentManager.a(new AnonymousClass15(this, r5));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final void a() {
        DownloadComponentManager.a(new AnonymousClass18(this));
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final DownloadInfo a(int r5, long r10, String r11, String r12) {
        ContentValues r13 = new ContentValues();
        r13.put(NotificationCompat.CATEGORY_STATUS, 3);
        r13.put("totalBytes", Long.valueOf(r10));
        r13.put("eTag", r11);
        if (TextUtils.isEmpty(r12) == true) goto L5;
        r13.put("name", r12);
    L5:
        DownloadComponentManager.a(new AnonymousClass19(this, r5, r13));
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final DownloadInfo a(int r5, long r10) {
        ContentValues r11 = new ContentValues();
        r11.put(NotificationCompat.CATEGORY_STATUS, -2);
        r11.put("curBytes", Long.valueOf(r10));
        DownloadComponentManager.a(new AnonymousClass19(this, r5, r11));
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean a(int r10, Map r11) {
        y();
        if (f15400j != null) goto L5;
        return false;
    L5:
        JSONArray r5 = new JSONArray();
        Iterator r12 = r11.entrySet().iterator();     // Catch: Throwable -> L14
    L7:
        if (r12.hasNext() == false) goto L19;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Throwable -> L14
        if (r13.getValue() == null) goto L7;
        Segment r14 = (Segment) r13.getValue();     // Catch: Throwable -> L14
        JSONObject r15 = r14.f16037h;     // Catch: Throwable -> L14
        if (r15 != null) goto L16;
        r15 = new JSONObject();     // Catch: Throwable -> L14
        r14.f16037h = r15;     // Catch: Throwable -> L14
    L16:
        r15.put("st", r14.f16034a);     // Catch: Throwable -> L14
        r15.put("cu", r14.a());     // Catch: Throwable -> L14
        r15.put("en", r14.d);     // Catch: Throwable -> L14
        r5.put(r15);     // Catch: Throwable -> L14
    L19:
        SQLiteStatement r16 = this.f15408c.b();
        if (r16 != null) goto L23;
        Logger.a("SqlDownloadCache", r10, "updateSegments", "UpdateSegments statement is null");
        return false;
    L23:
        monitor-enter(r16);
        r16.clearBindings();     // Catch: Throwable -> L27
        r16.bindLong(1, r10);     // Catch: Throwable -> L27
        r16.bindString(2, r5.toString());     // Catch: Throwable -> L27
        r16.execute();     // Catch: Throwable -> L27
        monitor-exit(r16);     // Catch: Throwable -> L27
        return false;
    L27:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        th.printStackTrace();
        Logger.a("SqlDownloadCache", r10, "updateSegments", "Error:" + th);
        goto L19
    }

    public static HashMap a(SqlDownloadCache r12, String r13) {
        r12.y();
        HashMap r14 = new HashMap();
        if (f15400j != null) goto L46;
    L41:
        return r14;
    L46:
        Cursor r15 = f15400j.rawQuery("SELECT _id, savePath, name, installedTimeStamp FROM downloader WHERE savePath LIKE ?", new String[]{r13});     // Catch: Throwable -> L34
        int r5 = r15.getColumnIndex("_id");     // Catch: Throwable -> L30
        if (r5 != (-1)) goto L11;
        DownloadUtils.a(new Cursor[]{r15});
        return null;
    L11:
        int r10 = r15.getColumnIndex("savePath");     // Catch: Throwable -> L30
        if (r10 != (-1)) goto L15;
        DownloadUtils.a(new Cursor[]{r15});
        return null;
    L15:
        int r11 = r15.getColumnIndex("name");     // Catch: Throwable -> L30
        if (r11 != (-1)) goto L19;
        DownloadUtils.a(new Cursor[]{r15});
        return null;
    L19:
        int r16 = r15.getColumnIndex("installedTimeStamp");     // Catch: Throwable -> L30
        if (r16 != (-1)) goto L24;
        DownloadUtils.a(new Cursor[]{r15});
        return null;
    L24:
        if (r15.moveToNext() == false) goto L32;
        String r17 = new DownloadFile(r15.getString(r10), r15.getString(r11), true).e();     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r17) == true) goto L24;
        r14.put(r17, new Pair(Integer.valueOf(r15.getInt(r5)), Long.valueOf(r15.getLong(r16))));     // Catch: Throwable -> L30
        goto L24
    L32:
        DownloadUtils.a(new Cursor[]{r15});
        return r14;
    L30:
        Object th2 = th;
    L42:
        Logger.c("SqlDownloadCache", "getDownloadInfosBySaveInfoImpl", "Error:" + th2);     // Catch: Throwable -> L38
        DownloadUtils.a(new Cursor[]{r15});
    L38:
        th = move-exception;
        DownloadUtils.a(new Cursor[]{r15});
        throw th;
    L34:
        th = move-exception;
        th2 = th;
        r15 = null;
        goto L42
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public final void a(ISqlCacheLoadCompleteCallbackAidl r5) {
        this.f15410i = r5;
    }

    public final void a(SparseArray r10, HashMap r11, List r12, boolean r13) {
        if (Logger.b() == false) goto L26;
        Logger.b("SqlDownloadCache", "onInitFinish", "Run onInitFinish:" + this.f15410i);
    L26:
        SparseArray r5 = DownloadHelper.f16133a;     // Catch: Throwable -> L8
        HashMap r14 = new HashMap();     // Catch: Throwable -> L8
        int r15 = r10.size();     // Catch: Throwable -> L8
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L10;
        int r17 = r10.keyAt(r16);     // Catch: Throwable -> L8
        r14.put(Integer.valueOf(r17), r10.valueAt(r16));     // Catch: Throwable -> L8
        r16 = r16 + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        if (r12 != null) goto L12;
        HashMap r18 = null;
    L18:
        ISqlCacheLoadCompleteCallbackAidl r19 = this.f15410i;     // Catch: Throwable -> L8
        if (r19 == null) goto L34;
        r19.a(r14, r11, r18, r13);     // Catch: Throwable -> L8
        return;
    L34:
        return;
    L12:
        r18 = new HashMap();     // Catch: Throwable -> L8
        Iterator r110 = r12.iterator();     // Catch: Throwable -> L8
    L14:
        if (r110.hasNext() == false) goto L18;
        DownloadInfo r20 = (DownloadInfo) r110.next();     // Catch: Throwable -> L8
        if (r20.l() == 0) goto L14;
        r18.put(Integer.valueOf(r20.l()), r20);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (Logger.b() == false) goto L35;
        Logger.b("SqlDownloadCache", "onInitFinish", "Error:" + th);
        return;
    }

    public static Object a(Callable r5, Fallback r10) {
        int r11 = f15403m;
        if (r11 > 0) goto L5;
    L21:
        return r5.call();
    L14:
        th = move-exception;
        th.printStackTrace();
        Logger.c("SqlDownloadCache", "runImpl", "Call Error: " + th);
    L16:
        if (r10 != null) goto L18;
        return null;
    L18:
        return r10.a();
    L5:
        if (DownloadUtils.a() == false) goto L21;
        return DownloadComponentManager.e().submit(r5).get(r11, TimeUnit.MILLISECONDS);
    L10:
        th = move-exception;
        th.printStackTrace();
        Logger.c("SqlDownloadCache", "runImpl", "Get Error: " + th);
        goto L16
    }
}
