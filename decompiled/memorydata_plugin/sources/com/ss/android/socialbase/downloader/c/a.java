package com.ss.android.socialbase.downloader.c;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f15285b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15286a;
    private boolean c;
    private boolean d;

    private a() {
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "downloader.db", null, 19);
        this.f15286a = "DownloadDBHelper";
        this.c = false;
    }

    public static a a() {
        if (f15285b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15285b != null) goto L9;
        f15285b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f15285b;
    }

    private void a(SQLiteDatabase r6) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L13;
        com.ss.android.socialbase.downloader.e.a.b("DownloadDBHelper", "dropAndCreateDBTable", "Run");
    L13:
        r6.execSQL("DROP TABLE IF EXISTS downloader");     // Catch: Throwable -> L7
        r6.execSQL("DROP TABLE IF EXISTS segments");     // Catch: Throwable -> L7
    L9:
        onCreate(r6);
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L15;
        com.ss.android.socialbase.downloader.e.a.b("DownloadDBHelper", "dropAndCreateDBTable", "Run End");
        return;
    L15:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("DownloadDBHelper", "dropAndCreateDBTable", "Error: " + th);
        goto L9
    }

    private void a(SQLiteDatabase r3, int r4, int r5) {
        if (com.ss.android.socialbase.downloader.g.a.c().b("sqlite_upgrade_ignore_duplicate_column") <= 0) goto L5;
        boolean r0 = true;
    L6:
        this.d = r0;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L9;
        com.ss.android.socialbase.downloader.e.a.a("DownloadDBHelper", "onUpgradeImpl", "OldVersion: " + r4 + " newVersion: " + r5 + " ignoreDuplicateColumn:" + this.d);
    L9:
        switch(r4) {
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
        a(r3, "mimeType TEXT");
        a(r3, "title TEXT");
        a(r3, "notificationEnable INTEGER");
        a(r3, "notificationVisibility INTEGER");
    L12:
        a(r3, "isFirstDownload INTEGER");
    L13:
        a(r3, "isFirstSuccess INTEGER");
    L14:
        a(r3, "needHttpsToHttpRetry INTEGER");
        a(r3, "downloadTime INTEGER");
    L15:
        a(r3, "packageName TEXT");
        a(r3, "md5 TEXT");
    L16:
        a(r3, "retryDelay INTEGER");
        a(r3, "curRetryTime INTEGER");
        a(r3, "retryDelayStatus INTEGER");
        a(r3, "defaultHttpServiceBackUp INTEGER");
    L17:
        a(r3, "chunkRunnableReuse INTEGER");
    L18:
        a(r3, "retryDelayTimeArray TEXT");
    L19:
        a(r3, "chunkDowngradeRetry INTEGER");
        a(r3, "backUpUrlsStr TEXT");
        a(r3, "backUpUrlRetryCount INTEGER");
        a(r3, "realDownloadTime INTEGER");
        a(r3, "retryScheduleMinutes INTEGER");
        a(r3, "independentProcess INTEGER");
    L20:
        a(r3, "auxiliaryJsonobjectString TEXT");
    L21:
        a(r3, "iconUrl TEXT");
        a(r3, "appVersionCode INTEGER");
    L22:
        r3.execSQL("CREATE TABLE IF NOT EXISTS segments( _id INTEGER PRIMARY KEY,info TEXT )");
    L23:
        a(r3, "taskId TEXT");
    L24:
        a(r3, "downloadStartTimeStamp INTEGER");
        a(r3, "downloadFinishTimeStamp INTEGER");
        a(r3, "installedTimeStamp INTEGER");
        a(r3, "hasDoInstallation INTEGER");
    L25:
        a(r3, "cacheLifeTimeMax INTEGER");
    L26:
        a(r3, "pcdnUrlsStr TEXT");
        a(r3, "cdnUrlsStr TEXT");
    L27:
        a(r3, "backCurBytes INTEGER");
        a(r3, "realBackDownloadTime INTEGER");
        return;
    L29:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void a(SQLiteDatabase r3, String r4) {
        r3.execSQL("ALTER TABLE downloader ADD " + r4);     // Catch: SQLException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("DownloadDBHelper", "addItem", "Error:" + e);
        if (this.d == false) goto L14;
        String r2 = e.getMessage();
        if (TextUtils.isEmpty(r2) == false) goto L10;
    L13:
        throw e;
    L10:
        if (r2.contains("duplicate column") == false) goto L13;
        com.ss.android.socialbase.downloader.e.a.b("DownloadDBHelper", "addItem", "duplicate column");
        return;
    L14:
        throw e;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (this.c == true) goto L15;
        if (r0 == null) goto L15;
        File r1 = new File("/data/data/" + r0.getPackageName() + "/database/main/");     // Catch: Exception -> L10
        if (r1.exists() == true) goto L8;
        r1.mkdir();     // Catch: Exception -> L10
    L8:
        super.getReadableDatabase().execSQL("PRAGMA temp_store_directory = tempDir");     // Catch: Exception -> L10
        this.c = true;     // Catch: Exception -> L10
    L13:
        return super.getReadableDatabase();
    L10:
        e = move-exception;
        e.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("DownloadDBHelper", "getReadableDatabase", "Error:" + e);
    L15:
        return super.getReadableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase r2) {
        super.onConfigure(r2);
        if (Build.VERSION.SDK_INT != 28) goto L6;
        r2.disableWriteAheadLogging();
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r3) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("DownloadDBHelper", "onCreate", "Run");
    L5:
        r3.execSQL("CREATE TABLE IF NOT EXISTS downloader( _id INTEGER PRIMARY KEY, url TEXT, savePath TEXT, tempPath TEXT, name TEXT, chunkCount INTEGER, status INTEGER, curBytes INTEGER, totalBytes INTEGER, eTag TEXT, onlyWifi INTEGER, force INTEGER, retryCount INTEGER, extra TEXT, mimeType TEXT, title TEXT, notificationEnable INTEGER, notificationVisibility INTEGER, isFirstDownload INTEGER, isFirstSuccess INTEGER, needHttpsToHttpRetry INTEGER, downloadTime INTEGER, packageName TEXT, md5 TEXT, retryDelay INTEGER, curRetryTime INTEGER, retryDelayStatus INTEGER, defaultHttpServiceBackUp INTEGER, chunkRunnableReuse INTEGER, retryDelayTimeArray TEXT, chunkDowngradeRetry INTEGER, backUpUrlsStr TEXT, backUpUrlRetryCount INTEGER, realDownloadTime INTEGER, retryScheduleMinutes INTEGER, independentProcess INTEGER, auxiliaryJsonobjectString TEXT, iconUrl TEXT, appVersionCode INTEGER, taskId TEXT, downloadStartTimeStamp INTEGER, downloadFinishTimeStamp INTEGER, installedTimeStamp INTEGER, hasDoInstallation INTEGER, cacheLifeTimeMax INTEGER, pcdnUrlsStr TEXT, cdnUrlsStr TEXT, backCurBytes INTEGER, realBackDownloadTime INTEGER)");
        r3.execSQL("CREATE TABLE IF NOT EXISTS segments( _id INTEGER PRIMARY KEY,info TEXT )");
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L9;
        com.ss.android.socialbase.downloader.e.a.a("DownloadDBHelper", "onCreate", "Run End");
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase r3, int r4, int r5) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("DownloadDBHelper", "onDowngrade", "OldVersion: " + r4 + " newVersion: " + r5);
    L6:
        if (com.ss.android.socialbase.downloader.g.a.c().b("support_sqlite_downgrade") <= 0) goto L9;
        a(r3);
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r5, int r6, int r7) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L16;
        com.ss.android.socialbase.downloader.e.a.a("DownloadDBHelper", "onUpgrade", "Run OldVersion: " + r6 + " newVersion: " + r7);
    L16:
        a(r5, r6, r7);     // Catch: Throwable -> L7
    L12:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L18;
        com.ss.android.socialbase.downloader.e.a.a("DownloadDBHelper", "onUpgrade", "Run End");
        return;
    L18:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("DownloadDBHelper", "onUpgrade", "Error:" + th);
        if (com.ss.android.socialbase.downloader.g.a.c().b("sqlite_upgrade_fail_drop_table") <= 0) goto L15;
        a(r5);
        goto L12
    L15:
        throw th;
    }
}
