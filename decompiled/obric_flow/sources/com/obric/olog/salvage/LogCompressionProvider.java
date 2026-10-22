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
import com.bytedance.ai.model.widgets.m;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class LogCompressionProvider extends ContentProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f11911c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HandlerThread f11912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f11913b;

    static {
        Pattern.compile("^[a-zA-Z0-9_./-]+$");
    }

    public LogCompressionProvider() {
    }

    public final boolean a() {
        Context r5 = getContext();
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.checkCallingOrSelfPermission("com.obric.olog.ACCESS_LOG_COMPRESSION_PROVIDER") != 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r5, String r10, String[] r11) {
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
    public final String getType(Uri r5) {
        return "application/zip";
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r5, ContentValues r10) {
        a();
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        HandlerThread r5 = new HandlerThread("LogCompressionThread", 10);
        this.f11912a = r5;
        r5.start();
        this.f11913b = new Handler(this.f11912a.getLooper());
        return true;
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri r5, String r10) {
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
    public final Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        if (a() == true) goto L5;
        return null;
    L5:
        if (r13 != null) goto L7;
    L15:
        return null;
    L7:
        if (r13.length == 0) goto L15;
        MatrixCursor r15 = new MatrixCursor(new String[]{"zip_file_uri"});
        CountDownLatch r16 = new CountDownLatch(1);
        this.f11913b.post(new m(this, r13, r10, r15, r16, 5));
        r16.await();     // Catch: InterruptedException -> L12
    L14:
        return r15;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    @Override // android.content.ContentProvider
    public final void shutdown() {
        super.shutdown();
        this.f11912a.quitSafely();
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r5, ContentValues r10, String r11, String[] r12) {
        a();
        return 0;
    }
}
