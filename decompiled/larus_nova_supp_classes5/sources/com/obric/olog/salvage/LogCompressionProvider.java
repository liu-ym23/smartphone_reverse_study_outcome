package com.obric.olog.salvage;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import el9.a;
import java.io.FileNotFoundException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class LogCompressionProvider extends ContentProvider {
    public static final /* synthetic */ int c = 0;
    public PthreadHandlerThreadV2 a;
    public Handler b;

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return "application/zip";
    }

    static {
        PatternProtector.compile("^[a-zA-Z0-9_./-]+$");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("LogCompressionThread", 10);
        this.a = r0;
        ThreadMethodProxy.start(r0);
        this.b = new Handler(this.a.getLooper());
        return true;
    }

    public final boolean b() {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.checkCallingOrSelfPermission(r0.getPackageName() + ".ACCESS_LOG_COMPRESSION_PROVIDER") != 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.content.ContentProvider
    public final void shutdown() {
        super.shutdown();
        this.a.quitSafely();
    }

    public LogCompressionProvider() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        b();
        return null;
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri r3, String r4) throws FileNotFoundException {
        if (b() == false) goto L15;
        Context r5 = getContext();
        if (r5 == null) goto L13;
        PolarisFileWrapper r6 = new PolarisFileWrapper(r5.getFilesDir(), "ologs.zip");
        if (r6.exists() == false) goto L11;
        return ParcelFileDescriptor.open(r6, 268435456);
    L11:
        throw new FileNotFoundException("ZIP file not found: " + r6.getAbsolutePath());
    L13:
        throw new FileNotFoundException("Context is null");
    L15:
        throw new SecurityException("Caller does not have the required permission");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r2, String r3, String[] r4) {
        if (b() == true) goto L6;
        return 0;
    L6:
        if ("delete_zip".equals(r3) == false) goto L16;
        Context r5 = getContext();
        if (r5 != null) goto L10;
        return 0;
    L10:
        PolarisFileWrapper r6 = new PolarisFileWrapper(r5.getFilesDir(), "ologs.zip");
        if (r6.exists() == false) goto L16;
        if (r6.delete() == false) goto L16;
        return 1;
    L16:
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        b();
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r8, String[] r9, String r10, String[] r11, String r12) {
        if (b() == true) goto L5;
        return null;
    L5:
        if (r11 != null) goto L7;
    L15:
        return null;
    L7:
        if (r11.length == 0) goto L15;
        MatrixCursor r13 = new MatrixCursor(new String[]{"zip_file_uri"});
        CountDownLatch r14 = new CountDownLatch(1);
        this.b.post(new gla.a(this, r11, r8, r13, r14));
        r14.await();     // Catch: InterruptedException -> L12
    L14:
        return r13;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
