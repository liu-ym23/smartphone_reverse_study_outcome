package gla;

import android.content.Context;
import android.database.MatrixCursor;
import android.net.Uri;
import com.obric.olog.salvage.LogCompressionProvider;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ LogCompressionProvider a;
    public final /* synthetic */ String[] b;
    public final /* synthetic */ Uri c;
    public final /* synthetic */ MatrixCursor d;
    public final /* synthetic */ CountDownLatch e;

    public /* synthetic */ a(LogCompressionProvider r1, String[] r2, Uri r3, MatrixCursor r4, CountDownLatch r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LogCompressionProvider r0 = this.a;
        String[] r1 = this.b;
        Uri r2 = this.c;
        MatrixCursor r3 = this.d;
        CountDownLatch r4 = this.e;
        int r5 = LogCompressionProvider.c;
        r0.getClass();
        Context r6 = r0.getContext();     // Catch: Throwable -> L17 Exception -> L19
        if (r6 != null) goto L29;
    L21:
        r4.countDown();
        return;
    L29:
        LogCompressionProvider.a("com.obric.android.agilelogger.ALog").getMethod("syncFlush", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L9 Throwable -> L17
        Thread.sleep(1000);     // Catch: Exception -> L9 Throwable -> L17
    L25:
        LogCompressionProvider.a("com.ss.android.agilelogger.ALog").getMethod("syncFlush", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L13 Throwable -> L17
        Thread.sleep(1000);     // Catch: Exception -> L13 Throwable -> L17
    L15:
        b.b(r6, r1);     // Catch: Throwable -> L17 Exception -> L19
        r3.addRow(new Object[]{Uri.withAppendedPath(r2, "zip_file").toString()});     // Catch: Throwable -> L17 Exception -> L19
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17 Exception -> L19
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17 Exception -> L19
    L17:
        th = move-exception;
        r4.countDown();
        throw th;
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
        goto L21
    }
}
