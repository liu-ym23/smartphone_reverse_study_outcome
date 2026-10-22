package com.larus.bot.impl.common.util;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class BitmapHelperKt {
    public static final Object c(String r7, Continuation<? super Bitmap> r8) {
        if ((r8 instanceof BitmapHelperKt$getBitmapFromUrl$1) == false) goto L7;
        BitmapHelperKt$getBitmapFromUrl$1 r0 = (BitmapHelperKt$getBitmapFromUrl$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
    L42:
        return r9;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r9);
    L28:
        r0.label = 2;
        kotlinx.coroutines.j r10 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r10.C();
        ImageRequest r11 = ImageRequest.fromUri((Uri) r9);
        DataSource r12 = Fresco.getImagePipeline().fetchDecodedImage(r11, AppHost.a.getApplication());
        r12.subscribe(new a(r10), CallerThreadExecutor.getInstance());     // Catch: Exception -> L31
    L37:
        r9 = r10.B();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L40;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L40:
        if (r9 != r2) goto L42;
        return r2;
    L31:
        e = move-exception;
        FLogger.a.e("getBitmapFromUrl", "error", e);
        if (r10.isActive() == false) goto L35;
        r10.resumeWith(Result.constructor-impl(null));
    L35:
        if (r12 == null) goto L37;
        Boxing.boxBoolean(r12.close());
        goto L37
    L16:
        ResultKt.throwOnFailure(r9);
        if (r7 != null) goto L19;
    L22:
        boolean r13 = true;
    L23:
        if (r13 == false) goto L25;
        return null;
    L25:
        r0.label = 1;
        r9 = ImageLoaderKt.r(r7, "bitmap_helper", r0);
        if (r9 != r2) goto L28;
        return r2;
    L19:
        if (StringsKt.isBlank(r7) == true) goto L22;
        r13 = false;
    L7:
        r0 = new BitmapHelperKt$getBitmapFromUrl$1(r8);
        goto L8
    }

    public static final Object e(String r3, Continuation<? super Unit> r4) {
        Object r5 = BuildersKt.withContext(Dispatchers.getIO(), new BitmapHelperKt$prefetchBitmap$2(r3, null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object f(List<String> r3, Continuation<? super List<Unit>> r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BitmapHelperKt$prefetchBitmap$4(r3, null), r4);
    }

    public static final Object b(FragmentActivity r3, Uri r4, Uri r5) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "sourceUri");
        Intrinsics.checkNotNullParameter(r5, "destinationUri");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L34
        ContentResolver r1 = r3.getContentResolver();     // Catch: Throwable -> L34
        Unit r2 = null;
        if (r1 == null) goto L46;
        InputStream r6 = ContentResolverWrapper.openInputStream(r1, r4);     // Catch: Throwable -> L34
        if (r6 == null) goto L46;
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
        goto L46
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
    L46:
        return Result.constructor-impl(r2);
    L34:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static final Object d(FragmentActivity r3, Uri r4, Continuation r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BitmapHelperKt$getImageFormat$2(r3, r4, null), r5);
    }

    public static final Object a(FragmentActivity r3, Uri r4, PolarisFileWrapper r5, Continuation r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BitmapHelperKt$convertImageToJpeg$2(r3, r4, r5, null), r6);
    }

    public static final Object g(Context r3, Bitmap r4, String r5, Continuation<? super File> r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BitmapHelperKt$saveBitMapToFile$2(r3, r5, r4, null), r6);
    }
}
