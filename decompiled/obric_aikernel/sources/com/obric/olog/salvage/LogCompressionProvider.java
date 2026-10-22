package com.obric.olog.salvage;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelFileDescriptor;
import com.obric.android.agilelogger.ALog;
import g9.a;
import g9.b;
import g9.c;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class LogCompressionProvider extends ContentProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HandlerThread f6146c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f6147g;

    static {
        Pattern.compile("^[a-zA-Z0-9_./-]+$");
    }

    public LogCompressionProvider() {
    }

    public static /* synthetic */ void a(LogCompressionProvider r10, String[] r11, Uri r12, MatrixCursor r13, CountDownLatch r14) {
        r10.c(r11, r12, r13, r14);
    }

    private boolean b() {
        Context r10 = getContext();
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.checkCallingOrSelfPermission("com.obric.olog.ACCESS_LOG_COMPRESSION_PROVIDER") != 0) goto L9;
        return true;
    L9:
        return false;
    }

    private /* synthetic */ void c(String[] r10, Uri r11, MatrixCursor r12, CountDownLatch r13) {
        Context r14 = getContext();     // Catch: Throwable -> L14 Exception -> L16
        if (r14 != null) goto L7;
        r13.countDown();
        return;
    L7:
        if (a.a("com.obric.android.agilelogger.ALog") == false) goto L10;
        ALog.syncFlush();     // Catch: Throwable -> L14 Exception -> L16
        Thread.sleep(1000);     // Catch: Throwable -> L14 Exception -> L16
    L10:
        if (a.a("com.ss.android.agilelogger.ALog") == false) goto L12;
        com.ss.android.agilelogger.ALog.syncFlush();     // Catch: Throwable -> L14 Exception -> L16
        Thread.sleep(1000);     // Catch: Throwable -> L14 Exception -> L16
    L12:
        c.b(r14, r10, "ologs.zip");     // Catch: Throwable -> L14 Exception -> L16
        r12.addRow(new Object[]{Uri.withAppendedPath(r11, "zip_file").toString()});     // Catch: Throwable -> L14 Exception -> L16
    L18:
        r13.countDown();
        return;
    L14:
        th = move-exception;
        r13.countDown();
        throw th;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L18
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        if (b() == true) goto L6;
        return 0;
    L6:
        if ("delete_zip".equals(r11) == false) goto L16;
        Context r13 = getContext();
        if (r13 != null) goto L10;
        return 0;
    L10:
        File r14 = new File(r13.getFilesDir(), "ologs.zip");
        if (r14.exists() == false) goto L16;
        if (r14.delete() == false) goto L16;
        return 1;
    L16:
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        return "application/zip";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        b();
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        HandlerThread r10 = new HandlerThread("LogCompressionThread", 10);
        this.f6146c = r10;
        r10.start();
        this.f6147g = new Handler(this.f6146c.getLooper());
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri r10, String r11) {
        if (b() == false) goto L15;
        Context r12 = getContext();
        if (r12 == null) goto L13;
        File r13 = new File(r12.getFilesDir(), "ologs.zip");
        if (r13.exists() == false) goto L11;
        return ParcelFileDescriptor.open(r13, 268435456);
    L11:
        throw new FileNotFoundException("ZIP file not found: " + r13.getAbsolutePath());
    L13:
        throw new FileNotFoundException("Context is null");
    L15:
        throw new SecurityException("Caller does not have the required permission");
    }

    @Override // android.content.ContentProvider
    public Cursor query(final Uri r10, String[] r11, String r12, final String[] r13, String r14) {
        if (b() == true) goto L5;
        return null;
    L5:
        if (r13 != null) goto L7;
    L15:
        return null;
    L7:
        if (r13.length == 0) goto L15;
        final MatrixCursor r15 = new MatrixCursor(new String[]{"zip_file_uri"});
        final CountDownLatch r16 = new CountDownLatch(1);
        this.f6147g.post(new b(this, r13, r10, r15, r16));
        r16.await();     // Catch: InterruptedException -> L12
    L14:
        return r15;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    @Override // android.content.ContentProvider
    public void shutdown() {
        super.shutdown();
        this.f6146c.quitSafely();
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        b();
        return 0;
    }
}
