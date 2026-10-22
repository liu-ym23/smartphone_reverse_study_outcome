package com.larus.uaigc.createpage.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class BitmapHelperKt {
    public static String b() {
        Intrinsics.checkNotNullParameter("jpeg", "formatSuffix");
        String r0 = "image_" + UUID.randomUUID() + ".jpeg";
        return AppHost.a.getApplication().getExternalFilesDir(null) + "_gen_image" + r0;
    }

    public static final PolarisFileWrapper a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "formatSuffix");
        return aa9.a.a.d("ai_beautify", "image_" + UUID.randomUUID() + '.' + r3);
    }

    public static final Bitmap g(Bitmap r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        int r0 = RangesKt.coerceAtMost(r7.getWidth(), r7.getHeight()) / 2;
        int r1 = r0 * 2;
        Bitmap r2 = Bitmap.createBitmap(r1, r1, Bitmap.Config.ARGB_8888);
        Canvas r3 = new Canvas(r2);
        Paint r4 = new Paint();
        r4.setAntiAlias(true);
        Path r5 = new Path();
        float r6 = r0;
        r5.addCircle(r6, r6, r6, Path.Direction.CW);
        r3.drawPath(r5, r4);
        r4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r3.drawBitmap(r7, r0 - (r7.getWidth() / 2), r0 - (r7.getHeight() / 2), r4);
        return r2;
    }

    public static final void c(Activity r3, Uri r4, Uri r5) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "sourceUri");
        Intrinsics.checkNotNullParameter(r5, "destinationUri");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L34
        ContentResolver r1 = r3.getContentResolver();     // Catch: Throwable -> L34
        Unit r2 = null;
        if (r1 == null) goto L32;
        InputStream r6 = ContentResolverWrapper.openInputStream(r1, r4);     // Catch: Throwable -> L34
        if (r6 == null) goto L32;
        ContentResolver r7 = r3.getContentResolver();     // Catch: Throwable -> L27
        if (r7 == null) goto L24;
        OutputStream r8 = ContentResolverWrapper.openOutputStream(r7, r5);     // Catch: Throwable -> L27
        if (r8 == null) goto L24;
        byte[] r9 = new byte[4096];     // Catch: Throwable -> L19
    L13:
        int r10 = r6.read(r9);     // Catch: Throwable -> L19
        if (r10 == (-1)) goto L16;
        r8.write(r9, 0, r10);     // Catch: Throwable -> L19
        goto L13
    L16:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L27
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L27
    L25:
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L34
        r2 = r12;
        goto L32
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L24:
        r12 = null;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L32:
        Result.constructor-impl(r2);     // Catch: Throwable -> L34
        return;
    L34:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static final Object f(Bitmap r3, String r4, Continuation r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BitmapHelperKt$saveBitmapToCleanableDir$2(r4, r3, null), r5);
    }

    public static final Object d(Context r3, Bitmap r4, String r5, Continuation<? super File> r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BitmapHelperKt$saveBitMapToFile$2(r3, r5, r4, null), r6);
    }

    public static final Object e(Bitmap r3, String r4, int r5, Continuation<? super Boolean> r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BitmapHelperKt$saveBitMapToFile$4(r4, r3, r5, null), r6);
    }
}
