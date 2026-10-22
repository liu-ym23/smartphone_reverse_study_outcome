package com.xiphias.browser.scanner.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ&\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u0016\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/xiphias/browser/scanner/document/DocumentResultStore;", "", "<init>", "()V", "ROOT_DIRECTORY", "", "maxAgeMs", "", "saveOriginal", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "bitmap", "Landroid/graphics/Bitmap;", "jpegQuality", "", "saveProcessed", "originalUri", "writeBitmap", "", "outputFile", "Ljava/io/File;", "cleanupExpired", "nowMs", "root", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f16320a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f16321b = 0;

    static {
        f16320a = new c();
        f16321b = TimeUnit.HOURS.toMillis(24);
    }

    private c() {
    }

    private final File a(Context r2) {
        File r3 = new File(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getCacheDir(), "aiscan/document");
        r3.mkdirs();
        return r3;
    }

    private final void a(Context r7, long r8) {
        File[] r6 = a((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin")).listFiles();
        if (r6 == null) goto L12;
        int r9 = 0;
        int r0 = r6.length;
    L5:
        if (r9 >= r0) goto L16;
        File r1 = r6[r9];
        if (r1.isDirectory() == true) goto L9;
    L10:
        Intrinsics.checkNotNull(r1);
        FilesKt.deleteRecursively(r1);
    L11:
        r9 = r9 + 1;
        goto L5
    L9:
        if ((r8 - r1.lastModified()) <= f16321b) goto L11;
    L16:
        return;
    }

    static /* synthetic */ void a(c r1, Context r2, long r3, int r5, Object r6) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L5;
        r3 = System.currentTimeMillis();
    L5:
        r1.a(r4, r3);
    }

    private final void a(File r4, Bitmap r5, int r6) {
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r4), Closeable.class, "com.obric.memorydata.plugin");
        FileOutputStream r7 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r3, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r5.compress(Bitmap.CompressFormat.JPEG, r6, (OutputStream) ZeusTransformUtils.preCheckCast(r7, OutputStream.class, "com.obric.memorydata.plugin")) == false) goto L9;
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r3, null);
        return;
    L9:
        throw new IllegalStateException("Unable to encode document result".toString());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    }

    public final Uri a(Context r7, Bitmap r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r8, "bitmap");
        a(this, r10, 0, 2, null);
        File r0 = new File(a(r10), UUID.randomUUID().toString());
        if (r0.mkdirs() == false) goto L12;
        File r11 = new File(r0, "original.jpg");
        a(r11, r8, r9);     // Catch: Throwable -> L8
        Uri r6 = Uri.fromFile(r11);
        Intrinsics.checkNotNullExpressionValue(r6, "fromFile(...)");
        return r6;
    L8:
        th = move-exception;
        FilesKt.deleteRecursively(r0);
        throw th;
    L12:
        throw new IllegalStateException("Unable to create document result directory".toString());
    }
}
