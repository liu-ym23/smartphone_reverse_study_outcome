package hb;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile a f9198h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9199c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f9200g;

    private a() {
        super(com.ss.android.socialbase.downloader.downloader.a.h(), "downloader.db", null, 19);
        this.f9199c = false;
    }

    private void a(SQLiteDatabase r10, String r11) {
        r10.execSQL("ALTER TABLE downloader ADD " + r11);     // Catch: SQLException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        lb.a.c("DownloadDBHelper", "addItem", "Error:" + e);
        if (this.f9200g == false) goto L14;
        String r12 = e.getMessage();
        if (TextUtils.isEmpty(r12) == false) goto L10;
    L13:
        throw e;
    L10:
        if (r12.contains("duplicate column") == false) goto L13;
        lb.a.c("DownloadDBHelper", "addItem", "duplicate column");
        return;
    L14:
        throw e;
    }

    private void c(SQLiteDatabase r10) {
        if (lb.a.a() == false) goto L13;
        lb.a.c("DownloadDBHelper", "dropAndCreateDBTable", "Run");
    L13:
        r10.execSQL("DROP TABLE IF EXISTS downloader");     // Catch: Throwable -> L7
        r10.execSQL("DROP TABLE IF EXISTS segments");     // Catch: Throwable -> L7
    L9:
        onCreate(r10);
        if (lb.a.a() == false) goto L15;
        lb.a.c("DownloadDBHelper", "dropAndCreateDBTable", "Run End");
        return;
    L15:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        lb.a.c("DownloadDBHelper", "dropAndCreateDBTable", "Error: " + th);
        goto L9
    }

    public static a f() {
        if (f9198h != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9198h != null) goto L9;
        f9198h = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f9198h;
    }

    private void i(SQLiteDatabase r10, int r11, int r12) {
        if (rb.a.j().n("sqlite_upgrade_ignore_duplicate_column") <= 0) goto L5;
        boolean r13 = true;
    L6:
        this.f9200g = r13;
        if (lb.a.a() == false) goto L9;
        lb.a.b("DownloadDBHelper", "onUpgradeImpl", "OldVersion: " + r11 + " newVersion: " + r12 + " ignoreDuplicateColumn:" + this.f9200g);
    L9:
        switch(r11) {
            case 1: goto L11;
            case 2: goto L12;
            case 3: goto L13;
            case 4: goto L14;
            case 5: goto L15;
            case 6: goto L16;
            case 7: goto L17;
            case 8: goto L17;
            case 9: goto L18;
            case 10: goto L19;
            case 11: goto L20;
            case 12: goto L21;
            case 13: goto L22;
            case 14: goto L23;
            case 15: goto L24;
            case 16: goto L25;
            case 17: goto L26;
            case 18: goto L27;
            default: goto L29;
        };
    L11:
        a(r10, "mimeType TEXT");
        a(r10, "title TEXT");
        a(r10, "notificationEnable INTEGER");
        a(r10, "notificationVisibility INTEGER");
    L12:
        a(r10, "isFirstDownload INTEGER");
    L13:
        a(r10, "isFirstSuccess INTEGER");
    L14:
        a(r10, "needHttpsToHttpRetry INTEGER");
        a(r10, "downloadTime INTEGER");
    L15:
        a(r10, "packageName TEXT");
        a(r10, "md5 TEXT");
    L16:
        a(r10, "retryDelay INTEGER");
        a(r10, "curRetryTime INTEGER");
        a(r10, "retryDelayStatus INTEGER");
        a(r10, "defaultHttpServiceBackUp INTEGER");
    L17:
        a(r10, "chunkRunnableReuse INTEGER");
    L18:
        a(r10, "retryDelayTimeArray TEXT");
    L19:
        a(r10, "chunkDowngradeRetry INTEGER");
        a(r10, "backUpUrlsStr TEXT");
        a(r10, "backUpUrlRetryCount INTEGER");
        a(r10, "realDownloadTime INTEGER");
        a(r10, "retryScheduleMinutes INTEGER");
        a(r10, "independentProcess INTEGER");
    L20:
        a(r10, "auxiliaryJsonobjectString TEXT");
    L21:
        a(r10, "iconUrl TEXT");
        a(r10, "appVersionCode INTEGER");
    L22:
        r10.execSQL("CREATE TABLE IF NOT EXISTS segments( _id INTEGER PRIMARY KEY,info TEXT )");
    L23:
        a(r10, "taskId TEXT");
    L24:
        a(r10, "downloadStartTimeStamp INTEGER");
        a(r10, "downloadFinishTimeStamp INTEGER");
        a(r10, "installedTimeStamp INTEGER");
        a(r10, "hasDoInstallation INTEGER");
    L25:
        a(r10, "cacheLifeTimeMax INTEGER");
    L26:
        a(r10, "pcdnUrlsStr TEXT");
        a(r10, "cdnUrlsStr TEXT");
    L27:
        a(r10, "backCurBytes INTEGER");
        a(r10, "realBackDownloadTime INTEGER");
        return;
    L29:
        return;
    L5:
        r13 = false;
        goto L6
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        Context r10 = com.ss.android.socialbase.downloader.downloader.a.h();
        if (this.f9199c == true) goto L15;
        if (r10 == null) goto L15;
        File r11 = new File("/data/data/" + r10.getPackageName() + "/database/main/");     // Catch: Exception -> L10
        if (r11.exists() == true) goto L8;
        r11.mkdir();     // Catch: Exception -> L10
    L8:
        super.getReadableDatabase().execSQL("PRAGMA temp_store_directory = tempDir");     // Catch: Exception -> L10
        this.f9199c = true;     // Catch: Exception -> L10
    L13:
        return super.getReadableDatabase();
    L10:
        e = move-exception;
        e.printStackTrace();
        lb.a.c("DownloadDBHelper", "getReadableDatabase", "Error:" + e);
    L15:
        return super.getReadableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase r10) {
        super.onConfigure(r10);
        if (Build.VERSION.SDK_INT != 28) goto L6;
        r10.disableWriteAheadLogging();
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r10) {
        if (lb.a.a() == false) goto L5;
        lb.a.b("DownloadDBHelper", "onCreate", "Run");
    L5:
        r10.execSQL("CREATE TABLE IF NOT EXISTS downloader( _id INTEGER PRIMARY KEY, url TEXT, savePath TEXT, tempPath TEXT, name TEXT, chunkCount INTEGER, status INTEGER, curBytes INTEGER, totalBytes INTEGER, eTag TEXT, onlyWifi INTEGER, force INTEGER, retryCount INTEGER, extra TEXT, mimeType TEXT, title TEXT, notificationEnable INTEGER, notificationVisibility INTEGER, isFirstDownload INTEGER, isFirstSuccess INTEGER, needHttpsToHttpRetry INTEGER, downloadTime INTEGER, packageName TEXT, md5 TEXT, retryDelay INTEGER, curRetryTime INTEGER, retryDelayStatus INTEGER, defaultHttpServiceBackUp INTEGER, chunkRunnableReuse INTEGER, retryDelayTimeArray TEXT, chunkDowngradeRetry INTEGER, backUpUrlsStr TEXT, backUpUrlRetryCount INTEGER, realDownloadTime INTEGER, retryScheduleMinutes INTEGER, independentProcess INTEGER, auxiliaryJsonobjectString TEXT, iconUrl TEXT, appVersionCode INTEGER, taskId TEXT, downloadStartTimeStamp INTEGER, downloadFinishTimeStamp INTEGER, installedTimeStamp INTEGER, hasDoInstallation INTEGER, cacheLifeTimeMax INTEGER, pcdnUrlsStr TEXT, cdnUrlsStr TEXT, backCurBytes INTEGER, realBackDownloadTime INTEGER)");
        r10.execSQL("CREATE TABLE IF NOT EXISTS segments( _id INTEGER PRIMARY KEY,info TEXT )");
        if (lb.a.a() == false) goto L9;
        lb.a.b("DownloadDBHelper", "onCreate", "Run End");
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase r10, int r11, int r12) {
        if (lb.a.a() == false) goto L6;
        lb.a.b("DownloadDBHelper", "onDowngrade", "OldVersion: " + r11 + " newVersion: " + r12);
    L6:
        if (rb.a.j().n("support_sqlite_downgrade") <= 0) goto L9;
        c(r10);
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r10, int r11, int r12) {
        if (lb.a.a() == false) goto L16;
        lb.a.b("DownloadDBHelper", "onUpgrade", "Run OldVersion: " + r11 + " newVersion: " + r12);
    L16:
        i(r10, r11, r12);     // Catch: Throwable -> L7
    L12:
        if (lb.a.a() == false) goto L18;
        lb.a.b("DownloadDBHelper", "onUpgrade", "Run End");
        return;
    L18:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        lb.a.c("DownloadDBHelper", "onUpgrade", "Error:" + th);
        if (rb.a.j().n("sqlite_upgrade_fail_drop_table") <= 0) goto L15;
        c(r10);
        goto L12
    L15:
        throw th;
    }
}
