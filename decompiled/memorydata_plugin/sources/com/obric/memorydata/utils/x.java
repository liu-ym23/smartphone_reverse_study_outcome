package com.obric.memorydata.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Base64;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0014\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0007J \u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fJ,\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010!\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010#\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\fH\u0002J\u0016\u0010&\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/memorydata/utils/ImageUtil;", "", "<init>", "()V", "TAG", "", "base64ToBitmap", "Landroid/graphics/Bitmap;", "base64Str", "bitmapToBase64", "bitmap", "quality", "", "getBitmapFromPath", Params.FILE_PATH, "getBitmapFromFd", "context", "Landroid/content/Context;", "fd", "Ljava/io/FileDescriptor;", "maxMemoryKB", "saveJPEG", "absolutePath", "resizeFactor", "", "getImageSize", "Landroid/graphics/Point;", "uri", "Landroid/net/Uri;", "getShareImageUri", "file", "Ljava/io/File;", "cropStatusBar", "cropSystemBars", "getStatusBarHeight", "getNavigationBarHeight", "rotateBitmap", "orientation", "scaleBitmap", "scale", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f13267a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13268a = null;

        static {
            int[] r0 = new int[Bitmap.Config.values().length];
            r0[Bitmap.Config.RGB_565.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f13268a = r0;
        }
    }

    static {
        f13267a = new x();
    }

    private x() {
    }

    private static final Bitmap a(FileDescriptor r15, int r16) {
        BitmapFactory.Options r3 = new BitmapFactory.Options();
        r3.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(r15, null, r3);
        BitmapFactory.Options r6 = new BitmapFactory.Options();
        Pair r4 = TuplesKt.to(Integer.valueOf(r3.outWidth), Integer.valueOf(r3.outHeight));
        int r7 = ((Number) ZeusTransformUtils.preCheckCast(r4.component1(), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r5 = ((Number) ZeusTransformUtils.preCheckCast(r4.component2(), Number.class, "com.obric.memorydata.plugin")).intValue();
        Bitmap.Config r8 = r6.inPreferredConfig;
        if (r8 != null) goto L5;
        int r9 = -1;
    L6:
        if (r9 != 1) goto L8;
        int r10 = 2;
    L9:
        int r11 = (r16 * 1024) / r10;
        int r12 = 1;
    L10:
        long r13 = r12;
        if ((((((long) r7) * 1) * ((long) r5)) / ((1 * r13) * r13)) <= r11) goto L13;
        r12 = r12 * 2;
        goto L10
    L13:
        r6.inSampleSize = r12;
        Unit r14 = Unit.INSTANCE;
        Bitmap r17 = BitmapFactory.decodeFileDescriptor(r15, null, r6);
        if (r17 == null) goto L23;
        return f13267a.b(r17, new ExifInterface(r15).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1));
    L17:
        e = move-exception;
        RunLog.INSTANCE.error("ImageUtil", "getBitmapFromFd Failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return r17;
    L23:
        return r17;
    L8:
        r10 = 4;
        goto L9
    L5:
        r9 = a.f13268a[r8.ordinal()];
        goto L6
    }

    private final Bitmap b(Bitmap r8, int r9) {
        Matrix r5 = new Matrix();
        if (r9 != 3) goto L5;
        float r7 = 180.0f;
    L12:
        r5.postRotate(r7);
        Bitmap r10 = Bitmap.createBitmap(r8, 0, 0, r8.getWidth(), r8.getHeight(), r5, true);
        Intrinsics.checkNotNullExpressionValue(r10, "createBitmap(...)");
        r8.recycle();
        return r10;
    L5:
        if (r9 != 6) goto L7;
        r7 = 90.0f;
        goto L12
    L7:
        if (r9 == 8) goto L9;
        return r8;
    L9:
        r7 = 270.0f;
        goto L12
    }

    public static /* synthetic */ Bitmap lambda$66EWoKHWWSv6TwM_lfHbeg5rfvM(FileDescriptor r0, int r1) {
        return a(r0, r1);
    }

    public final int a(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Resources r5 = ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin");
        int r6 = ZeusTransformUtils.getIdentifier(r5, "navigation_bar_height", "dimen", "android", "com.obric.memorydata.plugin");
        if (r6 > 0) goto L7;
        return 0;
    L7:
        return r5.getDimensionPixelSize(r6);
    }

    public final Bitmap a(Context r2, final FileDescriptor r3, final int r4) {
        Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "context");
        Intrinsics.checkNotNullParameter(r3, "fd");
        return (Bitmap) ZeusTransformUtils.preCheckCast(y.a(null, new $$Lambda$x$66EWoKHWWSv6TwM_lfHbeg5rfvM(r3, r4), 1, null), Bitmap.class, "com.obric.memorydata.plugin");
    }

    public final Bitmap a(Bitmap r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "bitmap");
        Bitmap r1 = Bitmap.createScaledBitmap(r2, (int) (r2.getWidth() * r3), (int) (r2.getHeight() * r3), true);
        r2.recycle();
        return r1;
    }

    public final Point a(Context r5, Uri r6) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "uri");
        ContentResolver r7 = r4.getContentResolver();
        Point r8 = new Point(-1, -1);
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(r7.openInputStream(r6), Closeable.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L15
        InputStream r10 = (InputStream) ZeusTransformUtils.preCheckCast(r9, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r10 == null) goto L7;
        BitmapFactory.Options r2 = new BitmapFactory.Options();     // Catch: Throwable -> L10
        r2.inJustDecodeBounds = true;     // Catch: Throwable -> L10
        BitmapFactory.decodeStream(r10, null, r2);     // Catch: Throwable -> L10
        r8.x = r2.outWidth;     // Catch: Throwable -> L10
        r8.y = r2.outHeight;     // Catch: Throwable -> L10
    L7:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r9, null);     // Catch: IOException -> L15
    L17:
        return r8;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);     // Catch: IOException -> L15
        throw th;     // Catch: IOException -> L15
    L15:
        e = move-exception;
        RunLog.INSTANCE.error("ImageUtil", "getImageSize error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L17
    }

    public final Uri a(File r3) {
        Intrinsics.checkNotNullParameter(r3, "file");
        Uri r2 = ZeusTransformUtils.getUriForFile((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.fileprovider", r3, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r2);
        return r2;
    }

    public final String a(Bitmap r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "bitmap");
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();
        r4.compress(Bitmap.CompressFormat.JPEG, r5, (OutputStream) ZeusTransformUtils.preCheckCast(r3, OutputStream.class, "com.obric.memorydata.plugin"));
        String r6 = Base64.encodeToString(r3.toByteArray(), 0);
        Intrinsics.checkNotNullExpressionValue(r6, "encodeToString(...)");
        return r6;
    }

    public final String a(Bitmap r6, String r7, float r8, int r9) {
        Intrinsics.checkNotNullParameter(r6, "bitmap");
        Intrinsics.checkNotNullParameter(r7, "absolutePath");
        RunLog.INSTANCE.debug("ImageUtil", "Save Image To " + r7);
        if (r8 != 1.0f) goto L5;
        boolean r5 = true;
    L7:
        if (r5 == false) goto L26;
    L10:
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(new File(r7)), Closeable.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L19
        FileOutputStream r11 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r10, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        r6.compress(Bitmap.CompressFormat.JPEG, r9, (OutputStream) ZeusTransformUtils.preCheckCast(r11, OutputStream.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        r11.flush();     // Catch: Throwable -> L14
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r10, null);     // Catch: IOException -> L19
        return r7;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: IOException -> L19
        throw th;     // Catch: IOException -> L19
    L19:
        e = move-exception;
        RunLog.INSTANCE.error("ImageUtil", "Save Image Failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    L26:
        r6 = Bitmap.createScaledBitmap(r6, (int) (r6.getWidth() * r8), (int) (r6.getHeight() * r8), true);     // Catch: IOException -> L19
        goto L10
    L5:
        r5 = false;
        goto L7
    }
}
