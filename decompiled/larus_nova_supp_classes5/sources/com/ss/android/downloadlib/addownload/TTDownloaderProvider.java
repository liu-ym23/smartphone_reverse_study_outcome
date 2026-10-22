package com.ss.android.downloadlib.addownload;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.ss.android.downloadlib.DownloadComponentManager;
import com.ss.android.downloadlib.exception.TTDownloaderMonitor;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class TTDownloaderProvider extends ContentProvider {
    private static final String TAG = "DownloadClickIdManager";
    private TTDownloaderClickIdDBHelper dbHelper;
    private boolean isInit;

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (this.dbHelper == null) goto L5;
        return true;
    L5:
        if (this.isInit == true) goto L10;
        DownloadComponentManager.getInstance().submitScheduledTask(new AnonymousClass1(this), 10000);
        return true;
    L10:
        return true;
    }

    public TTDownloaderProvider() {
        this.isInit = false;
    }

    public static /* synthetic */ TTDownloaderClickIdDBHelper access$002(TTDownloaderProvider r0, TTDownloaderClickIdDBHelper r1) {
        r0.dbHelper = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$102(TTDownloaderProvider r0, boolean r1) {
        r0.isInit = r1;
        return r1;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r5, ContentValues r6) {
        TTDownloaderClickIdDBHelper r0 = this.dbHelper;
        if (r0 != null) goto L9;
    L8:
        return null;
    L9:
        return ContentUris.withAppendedId(r5, r0.getWritableDatabase().insert(TTDownloaderClickIdDBHelper.CLICK_ID_TABLE_NAME, null, r6));
    L6:
        e = move-exception;
        TTDownloaderMonitor.inst().monitorException(false, e, "insert database error");
        goto L8
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r2, String r3, String[] r4) {
        TTDownloaderClickIdDBHelper r5 = this.dbHelper;
        if (r5 != null) goto L5;
        return IntCompanionObject.MIN_VALUE;
    L5:
        return r5.getWritableDatabase().delete(TTDownloaderClickIdDBHelper.CLICK_ID_TABLE_NAME, r3, r4);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r2, ContentValues r3, String r4, String[] r5) {
        TTDownloaderClickIdDBHelper r6 = this.dbHelper;
        if (r6 != null) goto L5;
        return IntCompanionObject.MIN_VALUE;
    L5:
        return r6.getWritableDatabase().update(TTDownloaderClickIdDBHelper.CLICK_ID_TABLE_NAME, r3, r4, r5);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        TTDownloaderClickIdDBHelper r15 = this.dbHelper;
        if (r15 == null) goto L12;
        return r15.getWritableDatabase().query(TTDownloaderClickIdDBHelper.CLICK_ID_TABLE_NAME, r11, r12, r13, null, null, r14, null);
    L6:
        e = move-exception;
        TTDownloaderMonitor.inst().monitorException(false, e, "query database error");
        return null;
    L12:
        return null;
    }
}
