package com.ss.android.socialbase.downloader.db;

import ai.j0;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.lynx.tasm.base.h;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadDBHelper extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile DownloadDBHelper f15383c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15385b;

    public DownloadDBHelper(String r5) {
        monitor-enter(DownloadComponentManager.class);
        Context r10 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L8
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L8
        super(r10, r5, null, 20);
        this.f15384a = false;
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static DownloadDBHelper a(String r5) {
        if (f15383c != null) goto L16;
        monitor-enter(DownloadDBHelper.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f15383c != null) goto L11;
        f15383c = new DownloadDBHelper(r5);     // Catch: Throwable -> L9
    L11:
        monitor-exit(DownloadDBHelper.class);     // Catch: Throwable -> L9
    L16:
        return f15383c;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getReadableDatabase() {
        monitor-enter(DownloadComponentManager.class);
        Context r5 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L21
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L21
        if (this.f15384a == true) goto L20;
        if (r5 == null) goto L20;
        File r10 = new File("/data/data/" + r5.getPackageName() + "/database/main/");     // Catch: Exception -> L12
        if (r10.exists() == true) goto L14;
        r10.mkdir();     // Catch: Exception -> L12
    L14:
        super.getReadableDatabase().execSQL("PRAGMA temp_store_directory = tempDir");     // Catch: Exception -> L12
        this.f15384a = true;     // Catch: Exception -> L12
    L18:
        return super.getReadableDatabase();
    L12:
        e = move-exception;
        e.printStackTrace();
        Logger.c("DownloadDBHelper", "getReadableDatabase", "Error:" + e);
    L20:
        return super.getReadableDatabase();
    L21:
        th = move-exception;
        throw th;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase r5) {
        super.onConfigure(r5);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r5) {
        if (Logger.b() == false) goto L5;
        Logger.b("DownloadDBHelper", "onCreate", "Run");
    L5:
        r5.execSQL("CREATE TABLE IF NOT EXISTS downloader( _id INTEGER PRIMARY KEY, url TEXT, savePath TEXT, tempPath TEXT, name TEXT, chunkCount INTEGER, status INTEGER, curBytes INTEGER, totalBytes INTEGER, eTag TEXT, onlyWifi INTEGER, force INTEGER, retryCount INTEGER, extra TEXT, mimeType TEXT, title TEXT, notificationEnable INTEGER, notificationVisibility INTEGER, isFirstDownload INTEGER, isFirstSuccess INTEGER, needHttpsToHttpRetry INTEGER, downloadTime INTEGER, packageName TEXT, md5 TEXT, retryDelay INTEGER, curRetryTime INTEGER, retryDelayStatus INTEGER, defaultHttpServiceBackUp INTEGER, chunkRunnableReuse INTEGER, retryDelayTimeArray TEXT, chunkDowngradeRetry INTEGER, backUpUrlsStr TEXT, backUpUrlRetryCount INTEGER, realDownloadTime INTEGER, retryScheduleMinutes INTEGER, independentProcess INTEGER, auxiliaryJsonobjectString TEXT, iconUrl TEXT, appVersionCode INTEGER, taskId TEXT, downloadStartTimeStamp INTEGER, downloadFinishTimeStamp INTEGER, installedTimeStamp INTEGER, hasDoInstallation INTEGER, cacheLifeTimeMax INTEGER, pcdnUrlsStr TEXT, cdnUrlsStr TEXT, backCurBytes INTEGER, realBackDownloadTime INTEGER, monitorScene TEXT)");
        r5.execSQL("CREATE TABLE IF NOT EXISTS segments( _id INTEGER PRIMARY KEY,info TEXT )");
        if (Logger.b() == false) goto L9;
        Logger.b("DownloadDBHelper", "onCreate", "Run End");
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase r5, int r10, int r11) {
        if (Logger.b() == false) goto L6;
        Logger.b("DownloadDBHelper", "onDowngrade", h.b(r10, r11, "OldVersion: ", " newVersion: "));
    L6:
        if (DownloadSetting.f.a("support_sqlite_downgrade", 0) <= 0) goto L9;
        a(r5);
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r5, int r10, int r11) {
        if (Logger.b() == false) goto L16;
        Logger.b("DownloadDBHelper", "onUpgrade", h.b(r10, r11, "Run OldVersion: ", " newVersion: "));
    L16:
        a(r5, r10, r11);     // Catch: Throwable -> L7
    L12:
        if (Logger.b() == false) goto L18;
        Logger.b("DownloadDBHelper", "onUpgrade", "Run End");
        return;
    L18:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.c("DownloadDBHelper", "onUpgrade", "Error:" + th);
        if (DownloadSetting.f.a("sqlite_upgrade_fail_drop_table", 0) <= 0) goto L15;
        a(r5);
        goto L12
    L15:
        throw th;
    }

    public final void a(SQLiteDatabase r5, int r10, int r11) {
        boolean r12 = false;
        if (DownloadSetting.f.a("sqlite_upgrade_ignore_duplicate_column", 0) <= 0) goto L5;
        r12 = true;
    L5:
        this.f15385b = r12;
        if (Logger.b() == false) goto L8;
        StringBuilder r13 = j0.v("OldVersion: ", r10, r11, " newVersion: ", " ignoreDuplicateColumn:");
        r13.append(this.f15385b);
        Logger.b("DownloadDBHelper", "onUpgradeImpl", r13.toString());
    L8:
        switch(r10) {
            case 1: goto L10;
            case 2: goto L11;
            case 3: goto L12;
            case 4: goto L13;
            case 5: goto L14;
            case 6: goto L15;
            case 7: goto L16;
            case 8: goto L16;
            case 9: goto L17;
            case 10: goto L18;
            case 11: goto L19;
            case 12: goto L20;
            case 13: goto L21;
            case 14: goto L22;
            case 15: goto L23;
            case 16: goto L24;
            case 17: goto L25;
            case 18: goto L26;
            case 19: goto L27;
            default: goto L9;
        };
    L9:
        return;
    L10:
        a(r5, "mimeType TEXT");
        a(r5, "title TEXT");
        a(r5, "notificationEnable INTEGER");
        a(r5, "notificationVisibility INTEGER");
    L11:
        a(r5, "isFirstDownload INTEGER");
    L12:
        a(r5, "isFirstSuccess INTEGER");
    L13:
        a(r5, "needHttpsToHttpRetry INTEGER");
        a(r5, "downloadTime INTEGER");
    L14:
        a(r5, "packageName TEXT");
        a(r5, "md5 TEXT");
    L15:
        a(r5, "retryDelay INTEGER");
        a(r5, "curRetryTime INTEGER");
        a(r5, "retryDelayStatus INTEGER");
        a(r5, "defaultHttpServiceBackUp INTEGER");
    L16:
        a(r5, "chunkRunnableReuse INTEGER");
    L17:
        a(r5, "retryDelayTimeArray TEXT");
    L18:
        a(r5, "chunkDowngradeRetry INTEGER");
        a(r5, "backUpUrlsStr TEXT");
        a(r5, "backUpUrlRetryCount INTEGER");
        a(r5, "realDownloadTime INTEGER");
        a(r5, "retryScheduleMinutes INTEGER");
        a(r5, "independentProcess INTEGER");
    L19:
        a(r5, "auxiliaryJsonobjectString TEXT");
    L20:
        a(r5, "iconUrl TEXT");
        a(r5, "appVersionCode INTEGER");
    L21:
        r5.execSQL("CREATE TABLE IF NOT EXISTS segments( _id INTEGER PRIMARY KEY,info TEXT )");
    L22:
        a(r5, "taskId TEXT");
    L23:
        a(r5, "downloadStartTimeStamp INTEGER");
        a(r5, "downloadFinishTimeStamp INTEGER");
        a(r5, "installedTimeStamp INTEGER");
        a(r5, "hasDoInstallation INTEGER");
    L24:
        a(r5, "cacheLifeTimeMax INTEGER");
    L25:
        a(r5, "pcdnUrlsStr TEXT");
        a(r5, "cdnUrlsStr TEXT");
    L26:
        a(r5, "backCurBytes INTEGER");
        a(r5, "realBackDownloadTime INTEGER");
    L27:
        a(r5, "monitorScene TEXT");
    }

    public final void a(SQLiteDatabase r5, String r10) {
        r5.execSQL("ALTER TABLE downloader ADD ".concat(r10));     // Catch: SQLException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        Logger.c("DownloadDBHelper", "addItem", "Error:" + e);
        if (this.f15385b == false) goto L15;
        String r11 = e.getMessage();
        if (TextUtils.isEmpty(r11) == false) goto L11;
    L14:
        throw e;
    L11:
        if (r11.contains("duplicate column") == false) goto L14;
        Logger.c("DownloadDBHelper", "addItem", "duplicate column");
        return;
    L15:
        throw e;
    }

    public final void a(SQLiteDatabase r10) {
        if (Logger.b() == false) goto L13;
        Logger.c("DownloadDBHelper", "dropAndCreateDBTable", "Run");
    L13:
        r10.execSQL("DROP TABLE IF EXISTS downloader");     // Catch: Throwable -> L7
        r10.execSQL("DROP TABLE IF EXISTS segments");     // Catch: Throwable -> L7
    L9:
        onCreate(r10);
        if (Logger.b() == false) goto L15;
        Logger.c("DownloadDBHelper", "dropAndCreateDBTable", "Run End");
        return;
    L15:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.c("DownloadDBHelper", "dropAndCreateDBTable", "Error: " + th);
        goto L9
    }
}
