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
import com.obric.cae.userAware.datacollection.NetworkClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;
import sb.a;

/* JADX INFO: loaded from: classes2.dex */
public class LogCompressionProvider extends ContentProvider {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f6155m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HandlerThread f6156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f6157b;

    static {
        Pattern.compile("^[a-zA-Z0-9_./-]+$");
    }

    public LogCompressionProvider() {
    }

    public final boolean a() {
        Context r8 = getContext();
        if (r8 != null) goto L5;
        return false;
    L5:
        if (r8.checkCallingOrSelfPermission("com.obric.olog.ACCESS_LOG_COMPRESSION_PROVIDER") != 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r8, String r10, String[] r11) {
        if (a() == true) goto L6;
        return 0;
    L6:
        if ("delete_zip".equals(r10) == false) goto L16;
        Context r12 = getContext();
        if (r12 != null) goto L10;
        return 0;
    L10:
        File r13 = new File(r12.getFilesDir(), "ologs.zip");
        if (r13.exists() == false) goto L16;
        if (r13.delete() == false) goto L16;
        return 1;
    L16:
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri r8) {
        return NetworkClient.UPLOAD_FILE_TYPE_ZIP;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r8, ContentValues r10) {
        a();
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        HandlerThread r8 = new HandlerThread("LogCompressionThread", 10);
        this.f6156a = r8;
        r8.start();
        this.f6157b = new Handler(this.f6156a.getLooper());
        return true;
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri r8, String r10) {
        if (a() == false) goto L15;
        Context r11 = getContext();
        if (r11 == null) goto L13;
        File r12 = new File(r11.getFilesDir(), "ologs.zip");
        if (r12.exists() == false) goto L11;
        return ParcelFileDescriptor.open(r12, 268435456);
    L11:
        throw new FileNotFoundException("ZIP file not found: " + r12.getAbsolutePath());
    L13:
        throw new FileNotFoundException("Context is null");
    L15:
        throw new SecurityException("Caller does not have the required permission");
    }

    @Override // android.content.ContentProvider
    public final Cursor query(final Uri r8, String[] r10, String r11, final String[] r12, String r13) {
        if (a() == true) goto L5;
        return null;
    L5:
        if (r12 != null) goto L7;
    L15:
        return null;
    L7:
        if (r12.length == 0) goto L15;
        final MatrixCursor r14 = new MatrixCursor(new String[]{"zip_file_uri"});
        final CountDownLatch r15 = new CountDownLatch(1);
        this.f6157b.post(new a(this, r12, r8, r14, r15));
        r15.await();     // Catch: InterruptedException -> L12
    L14:
        return r14;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    @Override // android.content.ContentProvider
    public final void shutdown() {
        super.shutdown();
        this.f6156a.quitSafely();
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r8, ContentValues r10, String r11, String[] r12) {
        a();
        return 0;
    }
}
